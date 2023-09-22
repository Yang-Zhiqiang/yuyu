package yuyu.common.sinkeiyaku.moschk;

import javax.inject.Inject;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.def.MessageId;
import yuyu.def.classification.C_CardBrandKbn;
import yuyu.def.classification.C_CreditTrkjkKbn;
import yuyu.def.classification.C_CreditYuukoukakKbn;
import yuyu.def.classification.C_FstphrkkeiroKbn;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_IkkatuyouptknKbn;
import yuyu.def.classification.C_JimusrhKbn;
import yuyu.def.classification.C_KetsrhkosKbn;
import yuyu.def.classification.C_LincjkKbn;
import yuyu.def.classification.C_LinckknnjkKbn;
import yuyu.def.classification.C_MsgKbn;
import yuyu.def.classification.C_TknKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.HT_CreditCardJyouhou;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.configuration.YuyuSinkeiyakuConfig;

/**
 * 新契約 申込内容チェック 成立保留チェック
 */
public class CheckSeirituHoryuu {

    @Inject
    private static Logger logger;

    @Inject
    private SetHubiMsg setHubiMsg;

    public CheckSeirituHoryuu() {
        super();
    }

    public void exec(MosnaiCheckParam pMP) {

        HT_SyoriCTL syoriCTL = pMP.getDataSyoriControl();
        C_UmuKbn syoriCTL_KktNrkHbUmu = syoriCTL.getKktnrkhbumu();
        C_UmuKbn syoriCTL_HjNrkHbUmu = syoriCTL.getHjynrkhbumu();
        // 実装なしとする
        //        C_UmuKbn syoriCTL_CrNrkHbUmu = syoriCTL.getCreditnrkhbumu();
        C_LincjkKbn syoriCTL_LincJkKbn = syoriCTL.getLincjkkbn();
        //        C_UmuKbn syoriCTL_CreditNykUmu = syoriCTL.getCreditnrkumu();
        //        C_AuthorijkKbn syoriCTL_AuthoriJkKbn = syoriCTL.getAuthorijkkbn();
        C_LinckknnjkKbn syoriCTL_LincKknnJkkbn = syoriCTL.getLinckknnjkkbn();
        C_JimusrhKbn syoriCTL_Jimusrhkbn = syoriCTL.getJimusrhkbn();

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        C_Hrkkeiro mosKihon_HrkKeiro = mosKihon.getHrkkeiro();

        // 実装なしとする
        //      C_SknnkaisikitkhukaKbn msKhn_SknnKaisikiTkHukaKbn = mosKihon.getSknnkaisikitkhukakbn();

        if (logger.isDebugEnabled()) {
            logger.debug("▽ 成立保留チェック 開始");
        }

        if (C_UmuKbn.ARI.eq(syoriCTL_KktNrkHbUmu)) {

            setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI, MessageId.EHC0180 + " " +
                MessageUtil.getMessage(MessageId.EHC0180), pMP, C_TknKbn.NONE, C_MsgKbn.ERROR);
        }

        if (C_UmuKbn.ARI.eq(syoriCTL_HjNrkHbUmu)) {

            setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI, MessageId.EHC0181 + " " +
                MessageUtil.getMessage(MessageId.EHC0181), pMP, C_TknKbn.NONE, C_MsgKbn.ERROR);

        }

        // 実装なしとする
        //        if (C_UmuKbn.ARI.eq(syoriCTL_CrNrkHbUmu)) {
        //
        //            setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI, MessageId.EHC0183 + " " +
        //                MessageUtil.getMessage(MessageId.EHC0183), pMP, C_TknKbn.NONE, C_MsgKbn.ERROR);
        //
        //        }

        if (C_LincjkKbn.SYOUKAIMATI.eq(syoriCTL_LincJkKbn)) {

            setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI, MessageId.EHC0143 + " " +
                MessageUtil.getMessage(MessageId.EHC0143), pMP, C_TknKbn.NONE, C_MsgKbn.ERROR);

        }

        if (C_LincjkKbn.SYOUKAI.eq(syoriCTL_LincJkKbn) || C_LincjkKbn.HANEIMATI.eq(syoriCTL_LincJkKbn)) {

            setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                MessageId.EHC0144 + " " + MessageUtil.getMessage(MessageId.EHC0144), pMP);

        }

        if ((C_LincjkKbn.KAITOARI_TASYAARI.eq(syoriCTL_LincJkKbn)) &&
            (C_LinckknnjkKbn.KAKUNINMATI.eq(syoriCTL_LincKknnJkkbn))) {

            setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI, MessageId.EBC0045 + " " +
                MessageUtil.getMessage(MessageId.EBC0045, "ＬＩＮＣ確認結果"), pMP);
        }

        // 実装なしとする
        //        if (C_Hrkkeiro.CREDIT.eq(mosKihon_HrkKeiro)) {
        //
        //            if (C_UmuKbn.NONE.eq(syoriCTL_CreditNykUmu)) {
        //
        //                setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
        //                    MessageId.EHC0146 + " " + MessageUtil.getMessage(MessageId.EHC0146), pMP);
        //
        //            }
        //
        //        }
        //        else {
        //
        //            if (C_UmuKbn.ARI.eq(syoriCTL_CreditNykUmu)) {
        //
        //                setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
        //                    MessageId.EHC0100 + " " + MessageUtil.getMessage(MessageId.EHC0100), pMP);
        //
        //            }
        //
        //        }

        // 実装なしとする
        //        if ((!C_SknnkaisikitkhukaKbn.HUKA.eq(msKhn_SknnKaisikiTkHukaKbn) &&
        //            (C_AuthorijkKbn.IRAIMATI.eq(syoriCTL_AuthoriJkKbn)
        //                || C_AuthorijkKbn.IRAITYUU.eq(syoriCTL_AuthoriJkKbn)
        //                || C_AuthorijkKbn.NG.eq(syoriCTL_AuthoriJkKbn))) ||
        //                (C_SknnkaisikitkhukaKbn.HUKA.eq(msKhn_SknnKaisikiTkHukaKbn) &&
        //                    C_AuthorijkKbn.IRAIMATI.eq(syoriCTL_AuthoriJkKbn))) {
        //
        //            setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI, MessageId.EHC0147 + " " + MessageUtil.getMessage(
        //                MessageId.EHC0147, syoriCTL_AuthoriJkKbn.getContent()), pMP, C_TknKbn.NONE, C_MsgKbn.ERROR);
        //
        //        }

        C_Tuukasyu hrktuukasyu = mosKihon.getHrktuukasyu();
        BizCurrency fstPHrkgk = mosKihon.getFstphrkgk();
        C_FstphrkkeiroKbn fstPHrkkeiroKbn = mosKihon.getFstphrkkeirokbn();
        HT_CreditCardJyouhou creditCardJyouhou = syoriCTL.getCreditCardJyouhou();
        C_CreditTrkjkKbn creditTrkjkKbn = syoriCTL.getCredittrkjkkbn();
        C_CreditYuukoukakKbn creditYuukoukakKbn = syoriCTL.getCredityuukoukakkbn();

        BizCurrency nttdCreditMax = YuyuSinkeiyakuConfig.getInstance().getNttdcreditMax();

        if (C_Hrkkeiro.CREDIT.eq(mosKihon_HrkKeiro) && C_Tuukasyu.JPY.eq(hrktuukasyu) &&
            nttdCreditMax.compareTo(fstPHrkgk) < 0) {

            setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI, "EHC1121" + " " +
                MessageUtil.getMessage(MessageId.EHC1121), pMP, C_TknKbn.NONE, C_MsgKbn.ERROR);
        }

        if (C_FstphrkkeiroKbn.CREDIT.eq(fstPHrkkeiroKbn) && C_Tuukasyu.JPY.eq(hrktuukasyu)) {

            C_IkkatuyouptknKbn ikkatuYouPTokunin =  C_IkkatuyouptknKbn.NONE;

            if (syoriCTL.getTokunin() != null) {
                ikkatuYouPTokunin = syoriCTL.getTokunin().getIkkatuyouptknkbn();
            }

            Integer ikkatuYouPHanteiKaisuu = 0;

            if (C_IkkatuyouptknKbn.NONE.eq(ikkatuYouPTokunin)) {
                ikkatuYouPHanteiKaisuu = mosKihon.getIkkatuyoupkaisuu();
            }
            else if(C_IkkatuyouptknKbn.HEITYOU.eq(ikkatuYouPTokunin)) {
                ikkatuYouPHanteiKaisuu = mosKihon.getSkjpjyuutoukaisuu();
            }

            if (1 < ikkatuYouPHanteiKaisuu && nttdCreditMax.compareTo(fstPHrkgk.multiply(ikkatuYouPHanteiKaisuu)) < 0) {
                setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI, "EHC1122" + " " +
                    MessageUtil.getMessage(MessageId.EHC1122), pMP, C_TknKbn.NONE, C_MsgKbn.ERROR);
            }
        }

        String creditTrkjkCheckMSGID = "";

        if (C_Hrkkeiro.CREDIT.eq(mosKihon_HrkKeiro)) {
            if (creditCardJyouhou != null) {
                if (!BizUtil.isBlank(creditCardJyouhou.getCreditkessaiyouno())) {
                    if (C_CreditTrkjkKbn.SUMI.eq(creditTrkjkKbn)) {
                        if (!C_CreditYuukoukakKbn.OK.eq(creditYuukoukakKbn)) {
                            creditTrkjkCheckMSGID = "EHC1123";
                        }
                    }
                    else {
                        creditTrkjkCheckMSGID = "EHC1124";
                    }
                }
                else {
                    creditTrkjkCheckMSGID = "EHC1124";
                }
            }
            else {
                creditTrkjkCheckMSGID = "EHC1124";
            }
        }

        if (!BizUtil.isBlank(creditTrkjkCheckMSGID)) {

            setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI, creditTrkjkCheckMSGID + " " +
                MessageUtil.getMessage(creditTrkjkCheckMSGID), pMP, C_TknKbn.NONE, C_MsgKbn.ERROR);
        }

        if (C_FstphrkkeiroKbn.CREDIT.eq(fstPHrkkeiroKbn) && C_CreditTrkjkKbn.SUMI.eq(creditTrkjkKbn) &&
            C_CreditYuukoukakKbn.OK.eq(creditYuukoukakKbn) && syoriCTL.getAuthorikakymd() == null) {

            setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI, "EHC1125" + " " +
                MessageUtil.getMessage(MessageId.EHC1125), pMP, C_TknKbn.NONE, C_MsgKbn.ERROR);
        }

        if (C_FstphrkkeiroKbn.CREDIT.eq(fstPHrkkeiroKbn) && C_CreditTrkjkKbn.SUMI.eq(creditTrkjkKbn) &&
            C_CreditYuukoukakKbn.OK.eq(creditYuukoukakKbn) && creditCardJyouhou != null &&
            (creditCardJyouhou.getCardbrandkbn() == null ||
            C_CardBrandKbn.BLNK.eq(creditCardJyouhou.getCardbrandkbn()))) {

            setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI, "EHC1126" + " " +
                MessageUtil.getMessage(MessageId.EHC1126), pMP, C_TknKbn.NONE, C_MsgKbn.ERROR);
        }

        if (C_JimusrhKbn.HORYU.eq(syoriCTL_Jimusrhkbn)) {

            setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI, MessageId.WHA1003 + " " + MessageUtil.getMessage(
                MessageId.WHA1003), pMP, C_TknKbn.NONE, C_MsgKbn.WARNING);
        }

        if (logger.isDebugEnabled()) {
            logger.debug("△ 成立保留チェック 終了");
        }
    }
}