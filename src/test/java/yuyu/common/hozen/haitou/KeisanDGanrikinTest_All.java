package yuyu.common.hozen.haitou;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


/**
 * {@link KeisanDGanrikin}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({

    KeisanDGanrikinTest_exec1.class,
    KeisanDGanrikinTest_exec2.class,
    KeisanDGanrikinTest_exec3.class,
    KeisanDGanrikinTest_exec4.class,

})
public class KeisanDGanrikinTest_All {
}

