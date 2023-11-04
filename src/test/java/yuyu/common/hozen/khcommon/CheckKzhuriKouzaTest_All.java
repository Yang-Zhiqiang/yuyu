package yuyu.common.hozen.khcommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link CheckKzhuriKouza}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({

    CheckKzhuriKouzaTest_execA1.class,
    CheckKzhuriKouzaTest_execA2.class
})
public class CheckKzhuriKouzaTest_All {
}
