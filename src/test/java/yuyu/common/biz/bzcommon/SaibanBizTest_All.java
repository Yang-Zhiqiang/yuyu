package yuyu.common.biz.bzcommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link SaibanBiz}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br /><br />
 */
@RunWith(Suite.class)
@SuiteClasses({
    SaibanBizTest_All_A1.class,
    SaibanBizTest_All_A2.class,
    SaibanBizTest_All_A3.class
})
public class SaibanBizTest_All {
}
