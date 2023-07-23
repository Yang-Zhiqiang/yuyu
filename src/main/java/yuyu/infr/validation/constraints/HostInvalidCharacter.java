package yuyu.infr.validation.constraints;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import yuyu.infr.validation.constraintvalidators.HostInvalidCharacterValidator;

/**
 * ホスト不可文字
 */
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = { HostInvalidCharacterValidator.class })
public @interface HostInvalidCharacter {

    String message() default "{yuyu.infr.validation.constraints.HostInvalidCharacter.message}";
    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default {};

    @Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
    @Retention(RUNTIME)
    @Documented
    @interface List {
        HostInvalidCharacter[] value();
    }

}
