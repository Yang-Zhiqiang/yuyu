package yuyu.common.hozen.setuibean;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * 保障内容設定のメソッド {@link SetHosyou} テスト用クラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({
    SetHosyouTest_exec.class,
    SetHosyouTest_init.class,
})
public class SetHosyouTest_All {
}
