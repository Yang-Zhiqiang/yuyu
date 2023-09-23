package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.base.format.DefaultDateFormatter;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.bzcommon.EditSecurityKm;
import yuyu.common.biz.bzcommon.IGkCommonKoumoku;
import yuyu.def.MessageId;
import yuyu.def.classification.C_ShrhousiteiKbn;

/**
 * 契約保全 契約保全共通 契約保全文字列編集
 */
public class KhozenEdit {

    private static final String BLANK = "";

    private static final String HOSIJIRUSI = "****";

    public KhozenEdit() {
        super();
    }

    public static String editKouzaNo(String pBankcd, String pKouzano) {

        String kouzaNo = BLANK;
        if (IGkCommonKoumoku.BANKCD_YTGINKOU.equals(pBankcd)) {
            kouzaNo = pKouzano + "1";
        }
        else {
            kouzaNo = pKouzano;
        }
        String updKouzaNo = editMaskKouzaNo(kouzaNo);

        return updKouzaNo;
    }

    public static String editKouzaNo(String pKouzano) {

        String updKouzaNo = editMaskKouzaNo(pKouzano);

        return updKouzaNo;
    }

    public static String editCreditCardNo(String pSyono, String pCreditcardno, int pIndex) {

        String updCreditcardNo = "";
        if (pIndex == 4) {
            updCreditcardNo = EditSecurityKm.getDecodeData(pSyono, pCreditcardno);
        }
        else {
            updCreditcardNo = HOSIJIRUSI;
        }

        return updCreditcardNo;
    }

    public static String editSeirekiYMD(BizDate pDate) {
        if (pDate == null) {
            return "";
        }
        return editSeirekiYMD(pDate.toString());
    }

    public static String editSeirekiYMD(String pDate) {
        if (pDate == null || pDate.equals("")) {
            return "";
        }
        return DateFormatUtil.dateDOTSeireki(pDate);
    }

    public static String editTienRkksanhi(C_ShrhousiteiKbn pShrhousiteiKbn, BizCurrency pShrTienRisoku,
        BizDate pTienRisokuKishi, Integer pTienRisokuhisu) {

        if (pShrhousiteiKbn == null || C_ShrhousiteiKbn.BLNK.eq(pShrhousiteiKbn) || pShrTienRisoku == null) {
            return null;
        }

        String tienrskkisanymdnissuu = "";

        if (C_ShrhousiteiKbn.KARIUKE_RISOKU_NASI.eq(pShrhousiteiKbn)) {
            tienrskkisanymdnissuu = MessageUtil.getMessage(MessageId.IBC1006);
            return tienrskkisanymdnissuu;
        }

        if (pTienRisokuKishi == null || pTienRisokuhisu == null) {
            return null;
        }

        if (!C_ShrhousiteiKbn.KARIUKE_RISOKU_NASI.eq(pShrhousiteiKbn)) {
            if (!BizUtil.isZero(pShrTienRisoku)) {
                tienrskkisanymdnissuu = MessageUtil.getMessage(MessageId.IBC1007,
                    DefaultDateFormatter.formatYMDZeroFill(pTienRisokuKishi), String.valueOf(pTienRisokuhisu));
            }
        }

        return tienrskkisanymdnissuu;
    }

    private static String editMaskKouzaNo(String pKouzano) {
        String maskKouzaNo = BizUtil.editMask(pKouzano, 3, '*');
        return maskKouzaNo;
    }
}
