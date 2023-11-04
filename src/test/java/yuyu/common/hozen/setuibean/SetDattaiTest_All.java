package yuyu.common.hozen.setuibean;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * 脱退情報設定クラスのメソッド {@link SetDattai} テスト用クラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({
    SetDattaiTest_exec.class,
    SetDattaiTest_init.class,
})
public class SetDattaiTest_All {
}