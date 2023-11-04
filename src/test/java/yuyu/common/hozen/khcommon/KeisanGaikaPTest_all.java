package yuyu.common.hozen.khcommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link KeisanGaikaP}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({
    KeisanGaikaPTest_exec.class,
    KeisanGaikaPTest_execKawaseSitei.class
})
public class KeisanGaikaPTest_all {
}

