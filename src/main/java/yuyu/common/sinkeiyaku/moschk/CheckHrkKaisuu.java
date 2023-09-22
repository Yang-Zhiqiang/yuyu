package yuyu.common.sinkeiyaku.moschk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.number.BizCurrency;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.ICommonKoumoku;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.MessageId;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_IkkatubaraiKaisuuKbn;
import yuyu.def.classification.C_KetsrhkosKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_SyoriCTL;

/**
 * 新契約 申込内容チェック 払込回数チェック
 */
public class CheckHrkKaisuu {

    @Inject
    private static Logger logger;

    @Inject
    private SetHubiMsg setHubiMsg;

    public CheckHrkKaisuu() {
        super();
    }

    public void exec(MosnaiCheckParam pMP, BM_SyouhnZokusei pSyouhinZokusei) {

        HT_MosKihon mosKihon;
        C_Hrkkaisuu hrkkaisuu;
        C_UmuKbn itijiBrUmu;
        C_UmuKbn heiJyunBaraiUmu;
        String syouhnNm;
        C_IkkatubaraiKaisuuKbn ikkatubaraiKaisuuKbn;
        BizCurrency mosikkatuP;
        C_UmuKbn teikiIkkatubaraiUmu;
        if (logger.isDebugEnabled()) {
            logger.debug("▽ 払込回数チェック 開始");
        }

        HT_SyoriCTL syoriCTL = pMP.getDataSyoriControl();
        mosKihon = syoriCTL.getMosKihon();
        hrkkaisuu = mosKihon.getHrkkaisuu();
        ikkatubaraiKaisuuKbn = mosKihon.getIkkatubaraikaisuu();
        mosikkatuP = mosKihon.getMosikkatup();
        itijiBrUmu = pSyouhinZokusei.getItijibrumu();
        heiJyunBaraiUmu = pSyouhinZokusei.getHeijyunbaraiumu();
        syouhnNm = pSyouhinZokusei.getSyouhnnm();
        teikiIkkatubaraiUmu = pSyouhinZokusei.getTeikiikkatubaraiumu();

        if (C_Hrkkaisuu.BLNK.eq(hrkkaisuu)) {
            setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                MakeHubiMsg.exec(MessageId.EBA0027, MessageId.EBA0027,
                    ICommonKoumoku.DISP_N_HRKKAISUU), pMP);
        }
        if (C_Hrkkaisuu.ITIJI.eq(hrkkaisuu)) {
            if (C_UmuKbn.NONE.eq(itijiBrUmu)) {
                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                    MakeHubiMsg.exec(MessageId.EHC0019, MessageId.EHC0019,
                        syouhnNm, hrkkaisuu.getContent()), pMP);
            }
        }
        if (C_UmuKbn.NONE.eq(heiJyunBaraiUmu)) {
            if (C_Hrkkaisuu.TUKI.eq(hrkkaisuu) || C_Hrkkaisuu.HALFY.eq(hrkkaisuu) || C_Hrkkaisuu.NEN.eq(hrkkaisuu)) {
                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                    MakeHubiMsg.exec(MessageId.EHC0019, MessageId.EHC0019,
                        syouhnNm, hrkkaisuu.getContent()), pMP);
            }
        }
        else {
            if (C_UmuKbn.ARI.eq(teikiIkkatubaraiUmu) &&
                (C_Hrkkaisuu.HALFY.eq(hrkkaisuu) || C_Hrkkaisuu.NEN.eq(hrkkaisuu))) {
                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                    MakeHubiMsg.exec(MessageId.EHC0019, MessageId.EHC0019,
                        syouhnNm, hrkkaisuu.getContent()), pMP);
            }
        }

        if (!C_IkkatubaraiKaisuuKbn.BLNK.eq(ikkatubaraiKaisuuKbn)) {
            if (C_UmuKbn.NONE.eq(teikiIkkatubaraiUmu)) {
                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                    MakeHubiMsg.exec(MessageId.EHC0019, MessageId.EHC0019,
                        syouhnNm, ikkatubaraiKaisuuKbn.getContent()), pMP);
            }
            else {
                if (!C_Hrkkaisuu.TUKI.eq(hrkkaisuu)) {
                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                        MakeHubiMsg.exec(MessageId.EHC1108, MessageId.EHC1108,
                            ikkatubaraiKaisuuKbn.getContent()), pMP);
                }
                if (C_SysKbn.SKEI.eq(pMP.getSysKbn()) &&
                     mosikkatuP.compareTo(BizCurrency.valueOf(0, mosikkatuP.getType())) == 0) {
                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                        MakeHubiMsg.exec(MessageId.EBA0027, MessageId.EBA0027,
                            ICommonKoumoku.DISP_S_TEIKIIKKTUBARAIP), pMP);
                }
            }
        }
        else {
            if (C_SysKbn.SKEI.eq(pMP.getSysKbn()) &&
                 mosikkatuP.compareTo(BizCurrency.valueOf(0, mosikkatuP.getType())) != 0) {
                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                    MakeHubiMsg.exec(MessageId.EBC0007, MessageId.EBC0007,
                        ICommonKoumoku.DISP_S_TEIKIIKKTUBARAIP), pMP);
            }
        }

        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        if (mosSyouhnLst.size() != 1) {
            throw new CommonBizAppException("主契約申込商品件数異常 申込番号：" + syoriCTL.getMosno());
        }
        HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
        int syohinHanteiKbn = SyouhinUtil.hantei(mosSyouhn.getSyouhncd());
        if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN  == syohinHanteiKbn) {
            if (!C_IkkatubaraiKaisuuKbn.BLNK.eq(ikkatubaraiKaisuuKbn) &&
                !C_IkkatubaraiKaisuuKbn.IKKATU6.eq(ikkatubaraiKaisuuKbn) &&
                !C_IkkatubaraiKaisuuKbn.IKKATU12.eq(ikkatubaraiKaisuuKbn)) {
                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                    MakeHubiMsg.exec(MessageId.EHC0019, MessageId.EHC0019,
                        syouhnNm, ikkatubaraiKaisuuKbn.getContent()), pMP);
            }
        }

        if (logger.isDebugEnabled()) {
            logger.debug("△ 払込回数チェック 終了");
        }
    }
}
