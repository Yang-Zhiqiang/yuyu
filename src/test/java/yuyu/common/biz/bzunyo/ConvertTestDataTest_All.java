package yuyu.common.biz.bzunyo;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link ConvertTestData}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({
    ConvertTestDataTest_exec_getTestSyoukenNo.class,
    ConvertTestDataTest_exec_setTestKanjiNm.class,
    ConvertTestDataTest_exec_setNull.class
})
public class ConvertTestDataTest_All {
}
