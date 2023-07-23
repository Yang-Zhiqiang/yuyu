package yuyu.infr.validation.constraintvalidators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.infr.validation.constraints.NenkinSyousyoNo;
import yuyu.infr.validation.constraintvalidators.callback.NenkinSyousyoNoCallback;

/**
 * 年金証書番号バリデータ
 */
public class NenkinSyousyoNoValidator implements ConstraintValidator<NenkinSyousyoNo, String> {

    @Override
    public void initialize(NenkinSyousyoNo constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

    	NenkinSyousyoNoCallback callback = SWAKInjector.getInstance(NenkinSyousyoNoCallback.class);

        return callback.check(value);
    }

}