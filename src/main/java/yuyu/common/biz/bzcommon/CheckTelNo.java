package yuyu.common.biz.bzcommon;

import org.apache.commons.validator.GenericValidator;

/**
 * 業務共通 共通 電話番号チェック
 */
public class CheckTelNo {

    private static final String[] REGEX_ARRAY = new String[] {


        "0[0-9]{1,1}-[0-9]{4,4}-[0-9]{4,4}",
        "0[0-9]{2,2}-[0-9]{3,3}-[0-9]{4,4}",
        "0[0-9]{3,3}-[0-9]{2,2}-[0-9]{4,4}",
        "0[0-9]{4,4}-[0-9]{1,1}-[0-9]{4,4}",

        "0[0-9]{2,2}-[0-9]{3,3}-[0-9]{5,5}",
        "0[0-9]{2,2}-[0-9]{4,4}-[0-9]{4,4}",
        "0[0-9]{3,3}-[0-9]{3,3}-[0-9]{3,3}",
        "0[0-9]{3,3}-[0-9]{3,3}-[0-9]{4,4}"
    };

    public CheckTelNo() {
        super();
    }

    private static String getRegex() {
        StringBuilder sb = new StringBuilder();
        for (String regex : REGEX_ARRAY) {
            sb.append("(");
            sb.append(regex);
            sb.append(")|");
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    public static boolean isCheckOK(String pTelNo) {

        if (pTelNo == null || pTelNo.length() == 0) {
            return false;
        }

        if (!GenericValidator.matchRegexp(pTelNo, getRegex())) {
            return false;
        }
        return true;
    }
}
