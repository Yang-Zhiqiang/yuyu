package yuyu.common.hozen.syoruitoutyaku;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * 契約保全書類到着時工程操作処理クラスのメソッド {@link HozenSyoruitoutyakuOperateProcess} テスト用クラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({
    HozenSyoruitoutyakuOperateProcessTest_hanteiToutyakuProcessForwardSyoruiCd.class,
    HozenSyoruitoutyakuOperateProcessTest_getSyoruitoutyakuNodeId.class
})
public class HozenSyoruitoutyakuOperateProcessTest_All {
}