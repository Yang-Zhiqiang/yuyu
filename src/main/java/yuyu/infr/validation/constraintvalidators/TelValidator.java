package yuyu.infr.validation.constraintvalidators;

import jp.co.slcs.swak.validation.constraintvalidators.BasePatternValidator;
import yuyu.infr.validation.constraints.Tel;

/**
 * 電話番号バリデータ
 */
public class TelValidator extends BasePatternValidator<Tel> {

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

    @Override
    protected String getRegex(Tel constraintAnnotation) {
        StringBuilder sb = new StringBuilder();
        for (String regex : REGEX_ARRAY) {
            sb.append("(");
            sb.append(regex);
            sb.append(")|");
        }

        return sb.deleteCharAt(sb.length() - 1).toString();
    }

}