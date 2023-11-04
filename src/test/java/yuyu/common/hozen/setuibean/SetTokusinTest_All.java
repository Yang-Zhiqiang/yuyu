package yuyu.common.hozen.setuibean;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * 特伸情報設定クラスのメソッド {@link SetTokusin} テスト用クラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({
    SetTokusinTest_exec.class,
    SetTokusinTest_init.class,
})
public class SetTokusinTest_All {
}