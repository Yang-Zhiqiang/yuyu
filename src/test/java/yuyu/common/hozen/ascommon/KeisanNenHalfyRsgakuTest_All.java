package yuyu.common.hozen.ascommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
/**
 * {@link KeisanNenHalfyRsgaku}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({
    KeisanNenHalfyRsgakuTest_exec1.class,
    KeisanNenHalfyRsgakuTest_exec2.class,
})
public class KeisanNenHalfyRsgakuTest_All {
}
