package yuyu.infr.validation.constraintvalidators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.infr.validation.constraints.MousikomiNo;
import yuyu.infr.validation.constraintvalidators.callback.MousikomiNoCallback;

/**
 * 申込番号バリデータ
 */
public class MousikomiNoValidator implements ConstraintValidator<MousikomiNo, String> {

    @Override
    public void initialize(MousikomiNo constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

    	MousikomiNoCallback callback = SWAKInjector.getInstance(MousikomiNoCallback.class);

        return callback.check(value);
    }

}