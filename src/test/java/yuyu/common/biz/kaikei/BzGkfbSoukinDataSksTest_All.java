package yuyu.common.biz.kaikei;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import yuyu.testinfr.AbstractTest;

/**
 * {@link BzGkfbSoukinDataSks}クラスに含まれる、全メソッドのテストをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({BzGkfbSoukinDataSksTest_execSk.class
    ,BzGkfbSoukinDataSksTest_execKh.class
    ,BzGkfbSoukinDataSksTest_execSi.class
})
public class BzGkfbSoukinDataSksTest_All extends AbstractTest {
}