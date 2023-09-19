package yuyu.common.workflowcore.core.iwfinfr.util;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * JSONからオブジェクトへの変換時に、マルチバイト文字のデコードが必要なフィールドに対して付与するアノテーションです。<br/>
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface IwfNeedsDecode {
    IwfDecodeType value();
}
