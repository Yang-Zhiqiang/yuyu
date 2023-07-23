package yuyu.infr.validation.constraintvalidators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.infr.validation.constraints.ZipCode;
import yuyu.infr.validation.constraintvalidators.callback.ZipCodeValidatorCallback;

/**
 * 指定された値が郵便番号として適切かどうかを判定する。<br/>
 * 以下の形式を郵便番号として適切と見做す。<br/>
 *
 *  ●数値７桁<br/>
 *  ●数値３桁＋半角ハイフン＋数値４桁<br/>
 *  ●郵便番号に存在すること<br/>
 *
 */
public class ZipCodeValidator implements ConstraintValidator<ZipCode, String> {
    @Override
    public void initialize(ZipCode constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (value == null || value.length() == 0) {
            return true;
        }

        if (value.replace("-", "").length() != 7) {
            return false;
        }

        int hyphen = value.indexOf("-");
        if (hyphen >= 0 && value.substring(0, hyphen).length() != 3){
            return false;

        }

        ZipCodeValidatorCallback c = SWAKInjector.getInstance(ZipCodeValidatorCallback.class);

        return c.check(value);
    }
}