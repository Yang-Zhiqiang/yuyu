package yuyu.common.biz.bzcommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link BizDateUtil}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです<br />
 */
@RunWith(Suite.class)
@SuiteClasses({
    BizDateUtilTest_calcDifferenceDays.class,
    BizDateUtilTest_calcDifferenceMonths.class,
    BizDateUtilTest_calcDifference.class,
    BizDateUtilTest_getDateAfterPeriod.class,
    BizDateUtilTest_ifNotBlankValueOf.class

})
public class BizDateUtilTest_All {
}
