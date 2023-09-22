package yuyu.common.sinkeiyaku.moschk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_AeoiKekkaKbn;
import yuyu.def.classification.C_AeoisnsiKbn;
import yuyu.def.classification.C_BikkjnssinfoKbn;
import yuyu.def.classification.C_FatcakakkekkaKbn;
import yuyu.def.classification.C_FatcasnsiKbn;
import yuyu.def.classification.C_HubisyubetusyousaiKbn;
import yuyu.def.classification.C_KetsrhkosKbn;
import yuyu.def.classification.C_MsgKbn;
import yuyu.def.classification.C_SpKeisanKahiKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TknKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_SyoriCTL;

/**
 * 新契約 申込内容チェック ＦＡＴＣＡチェック
 */
public class CheckFatca {

    @Inject
    private static Logger logger;

    @Inject
    private  BizDomManager bizDomManager;

    @Inject
    private SetHubiMsg setHubiMsg;

    public CheckFatca() {
        super();
    }

    public void exec(MosnaiCheckParam pMp) {

        if (logger.isDebugEnabled()) {
            logger.debug("▽ ＦＡＴＣＡチェック 開始");
        }

        HT_SyoriCTL syoriCTL = pMp.getDataSyoriControl();

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();

        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        if (mosSyouhnLst.size() != 1) {

            throw new CommonBizAppException("主契約申込商品件数異常 申込番号：" + syoriCTL.getMosno());
        }

        HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);

        BM_SyouhnZokusei syouhnZokusei =
            bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());

        C_FatcasnsiKbn fatcaSnsiKbn = mosKihon.getFatcasnsikbn();
        C_BikkjnssinfoKbn bikkjnSsinfoKbn = mosKihon.getBikkjnssinfokbn();
        String bikkNzsyNo = mosKihon.getBikknzsyno();
        C_FatcakakkekkaKbn fatcaKakkekkaKbn = syoriCTL.getFatcakakkekkakbn();

        if (C_FatcasnsiKbn.BLNK.eq(fatcaSnsiKbn) &&
            C_BikkjnssinfoKbn.BLNK.eq(bikkjnSsinfoKbn) &&
            !BizUtil.isBlank(bikkNzsyNo)) {

            setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                C_SpKeisanKahiKbn.SPKEISANKA,
                C_HubisyubetusyousaiKbn.NONE,
                MessageId.EHC1006 + " " + MessageUtil.getMessage(MessageId.EHC1006),
                pMp,
                C_TknKbn.NONE,
                C_MsgKbn.ERROR);
        }

        if ((C_FatcasnsiKbn.GAITOU.eq(fatcaSnsiKbn) ||
            C_BikkjnssinfoKbn.ARI.eq(bikkjnSsinfoKbn)) &&
            C_FatcakakkekkaKbn.BLNK.eq(fatcaKakkekkaKbn)) {

            setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                MessageId.EHC1004 + " " + MessageUtil.getMessage(MessageId.EHC1004),
                pMp,
                C_TknKbn.NONE,
                C_MsgKbn.ERROR);
        }

        if (C_FatcasnsiKbn.BLNK.eq(fatcaSnsiKbn) &&
            C_BikkjnssinfoKbn.BLNK.eq(bikkjnSsinfoKbn) &&
            C_FatcakakkekkaKbn.FATCA_HOUKOKUTAISYOU.eq(fatcaKakkekkaKbn)) {

            setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                MessageId.EHC1005 + " " + MessageUtil.getMessage(MessageId.EHC1005),
                pMp,
                C_TknKbn.NONE,
                C_MsgKbn.ERROR);
        }

        if (C_UmuKbn.NONE.eq(syouhnZokusei.getAeoitaisyouumu()) &&
            C_AeoisnsiKbn.GAITOU.eq(mosKihon.getAeoisnsikbn())) {

            setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                MessageId.EHC1050 + " " + MessageUtil.getMessage(MessageId.EHC1050),
                pMp,
                C_TknKbn.NONE,
                C_MsgKbn.ERROR);
        }

        if (C_UmuKbn.ARI.eq(syouhnZokusei.getAeoitaisyouumu()) &&
            C_AeoisnsiKbn.GAITOU.eq(mosKihon.getAeoisnsikbn()) &&
            C_AeoiKekkaKbn.BLNK.eq(syoriCTL.getAeoikekkakbn())) {

            setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                MessageId.EHC1051 + " " + MessageUtil.getMessage(MessageId.EHC1051),
                pMp,
                C_TknKbn.NONE,
                C_MsgKbn.ERROR);
        }

        if (C_AeoisnsiKbn.BLNK.eq(mosKihon.getAeoisnsikbn()) &&
            C_AeoiKekkaKbn.HOUKOKUTAISYOU.eq(syoriCTL.getAeoikekkakbn())) {

            setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                MessageId.EHC1052 + " " + MessageUtil.getMessage(MessageId.EHC1052),
                pMp,
                C_TknKbn.NONE,
                C_MsgKbn.ERROR);
        }

        if (logger.isDebugEnabled()) {
            logger.debug("△ ＦＡＴＣＡチェック 終了");
        }
    }
}