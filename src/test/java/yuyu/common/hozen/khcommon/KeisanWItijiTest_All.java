package yuyu.common.hozen.khcommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link KeisanWItijiTest_All}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({
    KeisanWItijiTest_exec.class,
    KeisanWItijiTest_exec2.class,
})
public class KeisanWItijiTest_All {
}
