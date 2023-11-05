package yuyu.common.hozen.khcommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * 前納精算額計算クラスの {@link KeisanZennouSeisanGk}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({

    KeisanZennouSeisanGkTest_exec.class,
    KeisanZennouSeisanGkTest_getZennouPSeisanKbn.class,
    KeisanZennouSeisanGkTest_exec1.class,

})
public class KeisanZennouSeisanGkTest_All {
}
