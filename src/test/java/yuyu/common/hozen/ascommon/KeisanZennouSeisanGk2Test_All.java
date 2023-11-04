package yuyu.common.hozen.ascommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * 前納精算額計算２クラスの {@link KeisanZennouSeisanGk2}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({

    KeisanZennouSeisanGk2Test_exec.class,
    KeisanZennouSeisanGk2Test_exec1.class,
    KeisanZennouSeisanGk2Test_kansanZennouSeisanGk.class,
    KeisanZennouSeisanGk2Test_kansanKykOutoubiZennouZndkList.class,
    KeisanZennouSeisanGk2Test_getZennouPSeisanKbn.class
})
public class KeisanZennouSeisanGk2Test_All {
}
