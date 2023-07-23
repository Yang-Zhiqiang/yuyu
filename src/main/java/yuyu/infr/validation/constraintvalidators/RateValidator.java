package yuyu.infr.validation.constraintvalidators;

import java.math.BigDecimal;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import yuyu.infr.validation.constraints.Rate;

/**
 * 利率バリデータ
 */
public class RateValidator implements ConstraintValidator<Rate, BigDecimal> {

    private int integer;
    private int decimal;

    @Override
    public void initialize(Rate constraintAnnotation) {
        decimal = constraintAnnotation.scale();
        integer = constraintAnnotation.precision() - decimal;
        if (integer < 0) {
            throw new RuntimeException("無効な設定です。");
        }
    }

    @Override
    public boolean isValid(BigDecimal value, ConstraintValidatorContext constraintValidatorContext) {
        if ( value == null ) {
            return true;
        }

        BigDecimal bd = value.abs();
        String val = bd.toPlainString();
        int intPart = val.length();
        int decPart = 0;
        int location = val.indexOf('.');
        if (location > -1) {
            intPart = val.substring(0, location).length();
            decPart = getDecimalPartLength(val.substring(location + 1));
        }

        return intPart <= integer && decPart <= decimal;
    }

    private static int getDecimalPartLength(String decPart) {
        int len = decPart.length();
        for (int i = len - 1; i >= 0; i--) {
            if (decPart.charAt(i) == '0') {
                len--;
                continue;
            }
            break;
        }
        return len;
    }
}
