package yuyu.common.sinkeiyaku.moschk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_KetsrhkosKbn;
import yuyu.def.classification.C_MsgKbn;
import yuyu.def.classification.C_TknKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_SyoriCTL;

/**
 * 新契約 申込内容チェック 発売期間チェック
 */
public class CheckHatubaikkn {

    private final BizDate hatubaiKaisiYmd = BizDate.valueOf("20170417");

    @Inject
    private static Logger logger;

    @Inject
    private SetHubiMsg setHubiMsg;

    @Inject
    private BizDomManager bizDomManager;

    public CheckHatubaikkn() {
        super();
    }

    public void exec(MosnaiCheckParam pMp) {

        if (logger.isDebugEnabled()) {
            logger.debug("▽ 発売期間チェック 開始");
        }

        HT_SyoriCTL syoriCTL = pMp.getDataSyoriControl();

        BizDate kktYmd = syoriCTL.getKktymd();

        BizDate htbKknKjnYmd1 = null;

        String syouhnNm = null;

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        BizDate mosYmd = mosKihon.getMosymd();

        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhns();

        if (mosSyouhnLst.size() > 0) {
            if (kktYmd == null) {
                htbKknKjnYmd1 = mosYmd;
            }
            else {
                if (BizDateUtil.compareYmd(mosYmd, kktYmd) == BizDateUtil.COMPARE_GREATER ||
                    BizDateUtil.compareYmd(mosYmd, kktYmd) == BizDateUtil.COMPARE_EQUAL) {
                    htbKknKjnYmd1 = kktYmd;
                }
                else {
                    htbKknKjnYmd1 = mosYmd;
                }
            }

            BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei(
                mosSyouhnLst.get(0).getSyouhncd(), mosSyouhnLst.get(0).getSyouhnsdno());
            syouhnNm = syouhnZokusei.getSyouhnnm();

            if (BizDateUtil.compareYmd(hatubaiKaisiYmd, htbKknKjnYmd1) == BizDateUtil.COMPARE_GREATER) {

                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                    MessageId.EHC0188 + " " + MessageUtil.getMessage(MessageId.EHC0188, syouhnNm),
                    pMp,
                    C_TknKbn.NONE,
                    C_MsgKbn.ERROR);
            }
        }

        if (logger.isDebugEnabled()) {
            logger.debug("△ 発売期間チェック 終了");
        }
    }
}