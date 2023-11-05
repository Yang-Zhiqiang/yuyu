package yuyu.common.base.format;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link BizDateFormatUtil}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです<br />
 */
@RunWith(Suite.class)
@SuiteClasses({
    BizDateFormatUtilTest_toFormatedYmd_01.class,
    BizDateFormatUtilTest_toFormatedYmd_02.class
})
public class BizDateFormatUtilTest_All {
}
