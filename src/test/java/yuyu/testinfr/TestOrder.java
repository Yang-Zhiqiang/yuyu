package yuyu.testinfr;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * TestOrder アノテーション</BR>
 * JUnitにおける@Test実行順序を指定
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface TestOrder {
    public int value();
}
