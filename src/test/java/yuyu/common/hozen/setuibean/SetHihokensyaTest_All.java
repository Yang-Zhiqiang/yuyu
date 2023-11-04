package yuyu.common.hozen.setuibean;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * 被保険者情報設定のメソッド {@link SetHihokensya} テスト用クラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({
    SetHihokensyaTest_exec.class,
    SetHihokensyaTest_init.class,
})
public class SetHihokensyaTest_All {
}