package yuyu.infr.validation.constraintvalidators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraintvalidators.callback.HostInvalidCharacterCallback;

/**
 * ホスト不可文字バリデータ
 */
public class HostInvalidCharacterValidator implements ConstraintValidator<HostInvalidCharacter, String> {

    @Override
    public void initialize(HostInvalidCharacter constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        HostInvalidCharacterCallback c = SWAKInjector.getInstance(HostInvalidCharacterCallback.class);

        return c.check(value);
    }

}