package yuyu.common.sinkeiyaku.moschk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.ICommonKoumoku;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_KetsrhkosKbn;
import yuyu.def.classification.C_Nstknsyu;
import yuyu.def.classification.C_Nstkumu;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.def.db.entity.BM_ChkNenkinSaiteiS;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_SyoriCTL;

/**
 * 新契約 申込内容チェック 年金支払特約チェック
 */
public class CheckNnknTokuyaku {

    private static final int ININENKINKKN = 0;

    @Inject
    private static Logger logger;

    @Inject
    private SetHubiMsg setHubiMsg;

    @Inject
    private SetHutuuSibouS setHutuuSibouS;

    @Inject
    private BizDomManager bizDomManager;

    public CheckNnknTokuyaku() {
        super();
    }

    public void exec(MosnaiCheckParam pMP) {
        if(logger.isDebugEnabled()) {
            logger.debug("▽ 年金支払特約チェック 開始");
        }

        HT_SyoriCTL syoriCTL    = pMP.getDataSyoriControl();
        String      mosNo       = syoriCTL.getMosno();
        HT_MosKihon mosKihon    = syoriCTL.getMosKihon();
        C_Nstknsyu nstksbnSyu    = mosKihon.getNstksbnsyu();
        int nstksbnKkn = mosKihon.getNstksbnkkn();
        C_Tkhukaumu nstkhkKbn = mosKihon.getNstkhkkbn();

        if (C_Tkhukaumu.HUKA.eq(nstkhkKbn)) {
            if (nstksbnKkn == ININENKINKKN || C_Nstknsyu.BLNK.eq(nstksbnSyu)) {
                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, MessageId.EHC0001 + " " + MessageUtil
                    .getMessage(MessageId.EHC0001, ICommonKoumoku.DISP_N_NSTKSBNSYU), pMP);

                if (logger.isDebugEnabled()) {
                    logger.debug("△ 年金支払特約チェック(年金種類と年金期間の関連チェック) 終了");
                }
                return;
            }
        }
        else {
            if (nstksbnKkn != ININENKINKKN || !C_Nstknsyu.BLNK.eq(nstksbnSyu)) {
                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, MessageId.EHC0001 + " " + MessageUtil
                    .getMessage(MessageId.EHC0001, ICommonKoumoku.DISP_N_NSTKSBNSYU), pMP);
                if (logger.isDebugEnabled()) {
                    logger.debug("△ 年金支払特約チェック(年金種類と年金期間の関連チェック) 終了");
                }
                return;
            }
        }

        if (C_Tkhukaumu.NONE.eq(nstkhkKbn)) {
            if (logger.isDebugEnabled()) {
                logger.debug("△ 年金支払特約チェック(対象判定) 終了");
            }
            return;
        }

        List<HT_MosSyouhn>  syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        if (syuMosSyouhnLst == null || syuMosSyouhnLst.size() != 1) {
            throw new CommonBizAppException("主契約申込商品件数異常 申込番号：" + mosNo);
        }

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei(
            syuMosSyouhnLst.get(0).getSyouhncd(), syuMosSyouhnLst.get(0).getSyouhnsdno());

        if (C_Nstkumu.BLNK.eq(syouhnZokusei.getNstkumu()) && !C_Tkhukaumu.BLNK.eq(nstkhkKbn)) {
            setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                MessageId.EHC0019 + " " + MessageUtil.getMessage(MessageId.EHC0019,
                    syouhnZokusei.getSyouhnnm(), nstksbnSyu.getContent()), pMP);
        }

        if ((!C_Nstknsyu.BLNK.eq(nstksbnSyu)) && (nstksbnKkn != ININENKINKKN)) {

            BM_ChkNenkinSaiteiS chkNenkinSaiteiS  = bizDomManager.getChkNenkinSaiteiS(nstksbnKkn,
                nstksbnSyu.toString()) ;
            if (chkNenkinSaiteiS != null) {

                BizCurrency nenkinSaiteiS = chkNenkinSaiteiS.getSaiteis();

                BizCurrency hutuuSibous  =  setHutuuSibouS.exec(pMP);

                if (!(nenkinSaiteiS.compareTo(hutuuSibous) <= 0)) {
                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, MessageId.EHC0015 + " " +
                        MessageUtil.getMessage(MessageId.EHC0015, nstksbnSyu.getContent(),
                            nenkinSaiteiS.toString()), pMP);
                }
            }
            else {
                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, MessageId.EHC0038  + " " +
                    MessageUtil.getMessage(MessageId.EHC0038, nstksbnSyu.getContent(),
                        ICommonKoumoku.DISP_N_NSTKSBNKKN), pMP);
            }
        }

        if (logger.isDebugEnabled()) {

            logger.debug("△ 年金支払特約チェック 終了");
        }
    }
}
