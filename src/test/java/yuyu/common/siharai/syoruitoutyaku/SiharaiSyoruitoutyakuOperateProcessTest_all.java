package yuyu.common.siharai.syoruitoutyaku;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link SiharaiSyoruitoutyakuOperateProcess}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({
    SiharaiSyoruitoutyakuOperateProcessTest_doujiSeikyuu.class,
    SiharaiSyoruitoutyakuOperateProcessTest_hanteiToutyakuProcessForwardSyoruiCd.class,
    SiharaiSyoruitoutyakuOperateProcessTest_getSyoruitoutyakuNodeId.class
})
public class SiharaiSyoruitoutyakuOperateProcessTest_all {
}