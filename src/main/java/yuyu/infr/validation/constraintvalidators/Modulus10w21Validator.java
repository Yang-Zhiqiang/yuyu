package yuyu.infr.validation.constraintvalidators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import yuyu.infr.util.Modulus10w21Util;
import yuyu.infr.validation.constraints.Modulus10w21;


/**
 * モジュラス10ウェイト2.1
 */
public class Modulus10w21Validator implements ConstraintValidator<Modulus10w21, String> {
    @Override
    public void initialize(Modulus10w21 constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return Modulus10w21Util.chkModulus10w21(value);
    }

}
