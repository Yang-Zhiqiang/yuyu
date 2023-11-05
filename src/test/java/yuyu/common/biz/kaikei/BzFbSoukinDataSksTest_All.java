package yuyu.common.biz.kaikei;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link BzFbSoukinDataSks}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({BzFbSoukinDataSksTest_execKh.class
    ,BzFbSoukinDataSksTest_execSi.class
    ,BzFbSoukinDataSksTest_execSk.class
})
public class BzFbSoukinDataSksTest_All {
}