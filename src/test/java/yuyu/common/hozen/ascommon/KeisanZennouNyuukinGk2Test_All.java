package yuyu.common.hozen.ascommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link KeisanZennouNyuukinGk2}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。 <br />
 */
@RunWith(Suite.class)
@SuiteClasses({

    KeisanZennouNyuukinGk2Test_execKeisanZennouNyuukinGk.class,
    KeisanZennouNyuukinGk2Test_execKeisanSinkeiyakuDoujiZennouNyuukinGk.class,
})
public class KeisanZennouNyuukinGk2Test_All {
}
