package yuyu.common.hozen.ascommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link KeisanRsgaku}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({
    KeisanRsgakuTest_exec1.class,
    KeisanRsgakuTest_exec2.class,
})
public class KeisanRsgakuTest_All {
}
