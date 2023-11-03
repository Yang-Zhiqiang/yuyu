package yuyu.common.biz.kaikei;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import yuyu.testinfr.AbstractTest;

/**
 * {@link BzDenpyouDataSks}クラスに含まれる、全メソッドのテストをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({ BzDenpyouDataSksTest_execSk.class
    , BzDenpyouDataSksTest_execKh.class
    , BzDenpyouDataSksTest_execSi.class
})
public class BzDenpyouDataSksTest_All extends AbstractTest {
}