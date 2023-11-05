package yuyu.common.hozen.setuibean;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * 通信先情報設定のメソッド {@link SetTuusinsaki} テスト用クラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({
    SetTuusinsakiTest_exec.class,
    SetTuusinsakiTest_init.class,
})
public class SetTuusinsakiTest_All {
}