package yuyu.infr.validation.constraintvalidators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.infr.validation.constraints.SyoukenNo;
import yuyu.infr.validation.constraintvalidators.callback.SyoukenNoCallback;

/**
 * 証券番号バリデータ
 */
public class SyoukenNoValidator implements ConstraintValidator<SyoukenNo, String> {

    @Override
    public void initialize(SyoukenNo constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        SyoukenNoCallback callback = SWAKInjector.getInstance(SyoukenNoCallback.class);

        return callback.check(value);
    }

}