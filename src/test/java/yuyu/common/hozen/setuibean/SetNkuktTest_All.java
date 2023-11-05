package yuyu.common.hozen.setuibean;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * 年金受取人情報設定のメソッド {@link SetNkukt} テスト用クラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({
    SetNkuktTest_exec.class,
    SetNkuktTest_init.class,
})
public class SetNkuktTest_All {
}