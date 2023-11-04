package yuyu.common.hozen.khcommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link KeisanZennouNyuukinGk}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。 <br />
 */
@RunWith(Suite.class)
@SuiteClasses({

    KeisanZennouNyuukinGkTest_execKeisanZennouNyuukinGk.class,
    KeisanZennouNyuukinGkTest_execKeisanSinkeiyakuDoujiZennouNyuukinGk.class,
})
public class KeisanZennouNyuukinGkTest_All {
}
