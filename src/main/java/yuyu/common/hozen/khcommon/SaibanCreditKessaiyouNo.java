package yuyu.common.hozen.khcommon;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.MessageId;
import yuyu.def.classification.C_CreditCardKeySyuruiKbn;

/**
 * 契約保全 契約保全共通 クレジットカード決済用番号採番
 */
public class SaibanCreditKessaiyouNo {

    private static final String KESSAI_SYURUI_KBN = "3";

    private static final int[] WEIGHTS = { 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2 };

    @Inject
    private static Logger logger;

    public SaibanCreditKessaiyouNo() {
        super();
    }

    public String exec(C_CreditCardKeySyuruiKbn pCreditCardKeySyuruiKbn, String pCreditCardDbKey) {

        logger.debug("▽ クレジットカード決済用番号採番 開始");

        String creditKessaiyouNo = "";
        String creditCardDbkey = "";
        String checkDigit = "";
        String currentYmd = BizDate.getSysDateTime().substring(2, 8);
        String currentTime = BizDate.getSysDateTime().substring(8, 14);

        if (pCreditCardKeySyuruiKbn.eq(C_CreditCardKeySyuruiKbn.MOSNO)) {
            if (pCreditCardDbKey.length() != 9) {
                throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EIA3053, "クレジットカードＤＢキー",
                    pCreditCardDbKey));
            }
            creditCardDbkey = "00" + pCreditCardDbKey;
        }

        if (pCreditCardKeySyuruiKbn.eq(C_CreditCardKeySyuruiKbn.SYONO)) {
            if (pCreditCardDbKey.length() != 11) {
                throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EIA3053, "クレジットカードＤＢキー",
                    pCreditCardDbKey));
            }
            creditCardDbkey = pCreditCardDbKey;
        }

        creditKessaiyouNo = KESSAI_SYURUI_KBN +
            pCreditCardKeySyuruiKbn.getValue() +
            creditCardDbkey +
            currentYmd +
            currentTime;

        int sum = 0;
        int result = 0;

        for (int n = 0; n < creditKessaiyouNo.length(); n++) {

            result = Integer.parseInt(Character.toString(creditKessaiyouNo.charAt(n))) * WEIGHTS[n];

            if (result > 9) {
                sum += (result / 10) + (result % 10);
            }
            else {
                sum += result;
            }
        }

        if (sum % 10 == 0) {
            checkDigit = String.valueOf(sum % 10);
        }
        else {
            checkDigit = String.valueOf(10 - sum % 10);
        }

        creditKessaiyouNo = creditKessaiyouNo + checkDigit;

        logger.debug("△ クレジットカード決済用番号採番 終了");

        return creditKessaiyouNo;
    }
}