package yuyu.infr.validation.constraintvalidators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraintvalidators.callback.InvalidCharacterCallback;

/**
 * 禁止文字バリデータ
 */
public class InvalidCharacterValidator implements ConstraintValidator<InvalidCharacter, String> {

    @Override
    public void initialize(InvalidCharacter constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        InvalidCharacterCallback c = SWAKInjector.getInstance(InvalidCharacterCallback.class);

        return c.check(value);
    }

}