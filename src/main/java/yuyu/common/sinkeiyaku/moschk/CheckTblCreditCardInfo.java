package yuyu.common.sinkeiyaku.moschk;

import javax.inject.Inject;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_KetsrhkosKbn;
import yuyu.def.classification.C_MosUketukeKbn;
import yuyu.def.db.entity.HT_CreditCardJyouhou;

/**
 * 新契約 申込内容チェック クレジットカード情報TBLチェック
 */
public class CheckTblCreditCardInfo {

    private final static String HUBIMSG_CREDITCARDJYOUHOU = "クレジットカード情報";

    @Inject
    private static Logger logger;

    @Inject
    private SetHubiMsg setHubiMsg;

    public CheckTblCreditCardInfo() {
        super();
    }

    public void exec(MosnaiCheckParam pMP) {

        if (logger.isDebugEnabled()) {
            logger.debug("▽ クレジットカード情報テーブルチェック 開始");
        }

        C_MosUketukeKbn mosUketukeKbn = pMP.getDataSyoriControl().getMosuketukekbn();
        C_Hrkkeiro hrkkeiro = pMP.getDataSyoriControl().getMosKihon().getHrkkeiro();
        HT_CreditCardJyouhou creditCardJyouhou =  pMP.getDataSyoriControl().getCreditCardJyouhou();

        if (C_Hrkkeiro.CREDIT.eq(hrkkeiro) && creditCardJyouhou == null) {

            setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                MakeHubiMsg.exec("EBA0024", "EBA0024", HUBIMSG_CREDITCARDJYOUHOU), pMP);
        }
        else if (!(C_Hrkkeiro.CREDIT.eq(hrkkeiro)) && creditCardJyouhou != null) {

            setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                MakeHubiMsg.exec("EBC0007", "EBC0007", HUBIMSG_CREDITCARDJYOUHOU), pMP);
        }
        if (!(C_MosUketukeKbn.PAPERLESS.eq(mosUketukeKbn)) &&
            C_Hrkkeiro.CREDIT.eq(hrkkeiro) &&
            creditCardJyouhou != null &&
            BizUtil.isBlank(creditCardJyouhou.getCreditkessaiyouno())) {

            setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI, MakeHubiMsg.exec("EHC1128", "EHC1128"), pMP);
        }

        if (logger.isDebugEnabled()) {
            logger.debug("△ クレジットカード情報テーブルチェック 終了");
        }
    }
}