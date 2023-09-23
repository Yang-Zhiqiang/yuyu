package yuyu.common.hozen.khcommon;

import javax.inject.Inject;

import jp.co.slcs.swak.util.string.ConvertUtil;

import org.slf4j.Logger;

import yuyu.def.classification.C_CardBrandKbn;

/**
 * 契約保全 契約保全共通 クレジットカード番号表示編集
 */
public class CreditCardNoHensyuu {

    private static final String CARDNO_MASKING1 = "＊＊＊＊　＊＊＊＊　＊＊＊＊　";

    private static final String CARDNO_MASKING2 = "＊＊＊＊　＊＊＊＊＊＊　＊";

    private static final String CARDNO_MASKING3 = "＊＊＊＊　＊＊＊＊＊＊　";

    @Inject
    private static Logger logger;

    public CreditCardNoHensyuu() {
        super();
    }

    public String exec(C_CardBrandKbn pCardBrandKbn, String pCreditKaiinnoSimo4) {

        logger.debug("▽ クレジットカード番号表示編集 開始");

        String maskingStr = "";

        if (C_CardBrandKbn.VISA.eq(pCardBrandKbn) ||
            C_CardBrandKbn.MASTER.eq(pCardBrandKbn) ||
            C_CardBrandKbn.JCB.eq(pCardBrandKbn)) {

            maskingStr = CARDNO_MASKING1;
        }
        else if (C_CardBrandKbn.AMEX.eq(pCardBrandKbn)) {

            maskingStr = CARDNO_MASKING2;
        }
        else if (C_CardBrandKbn.DINERS.eq(pCardBrandKbn)) {

            maskingStr = CARDNO_MASKING3;
        }

        String editCreditKaiinnoSimo4 = ConvertUtil.toZenAll(pCreditKaiinnoSimo4, 0, 1);

        String editCreditCardNo = maskingStr + editCreditKaiinnoSimo4;

        logger.debug("△ クレジットカード番号表示編集 終了");

        return editCreditCardNo;
    }
}
