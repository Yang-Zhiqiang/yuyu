package yuyu.common.hozen.setuibean;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * 基本情報設定のメソッド {@link SetKihon} テスト用クラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({
    SetKihonTest_exec.class,
    SetKihonTest_init.class,
})
public class SetKihonTest_All {
}