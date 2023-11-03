package yuyu.common.hozen.ascommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link KeisanTukiRsgaku}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({
    KeisanTukiRsgakuTest_exec1.class,
    KeisanTukiRsgakuTest_exec2.class,
})
public class KeisanTukiRsgakuTest_All {
}
