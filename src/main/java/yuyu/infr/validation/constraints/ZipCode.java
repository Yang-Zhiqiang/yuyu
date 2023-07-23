package yuyu.infr.validation.constraints;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import yuyu.infr.validation.constraintvalidators.ZipCodeValidator;

/**
 * 指定された値が郵便番号として適切かどうかを判定する。<br/>
 * 以下の形式を郵便番号として適切と見做す。<br/>
 *
 *  ●数値７桁<br/>
 *  ●数値３桁＋半角ハイフン＋数値４桁<br/>
 *  ●yuyu-base-config にテーブルIDが指定されていた場合、そのテーブルの指定カラムに存在すること<br/>
 *     （テーブル、カラムの設定がない場合はこの判定は行わない）<br/>
 */
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = { ZipCodeValidator.class })
public @interface ZipCode {
    String message() default "{yuyu.infr.validation.constraints.ZipCode.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default {};

    @Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
    @Retention(RUNTIME)
    @Documented
    @interface List {
        ZipCode[] value();
    }

}
