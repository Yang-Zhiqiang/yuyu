package yuyu.common.direct.dscommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link DsTumitatekinItenCheck}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({ DsTumitatekinItenCheckTest_checkTumitatekinIten.class,
    DsTumitatekinItenCheckTest_checkDsTumitatekinItenUketukeUmu.class
})
public class DsTumitatekinItenCheckTest_All {
}