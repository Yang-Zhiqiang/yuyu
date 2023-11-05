package yuyu.common.hozen.khcommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link CommonNyuukin}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({
    CommonNyuukinTest_exec.class,
    CommonNyuukinTest_exec1.class,
    CommonNyuukinTest_exec3.class,
    CommonNyuukinTest_exec4.class,
    CommonNyuukinTest_exec5.class,
    CommonNyuukinTest_exec6.class,
    CommonNyuukinTest_exec7.class,
    CommonNyuukinTest_exec8.class
})
public class CommonNyuukinTest_All {
}

