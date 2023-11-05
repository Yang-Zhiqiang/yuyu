package yuyu.common.biz.bzcommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link BzRenkeiHenkanUtil}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({BzRenkeiHenkanUtilTest_initialize.class
    ,BzRenkeiHenkanUtilTest_convBean.class
    ,BzRenkeiHenkanUtilTest_convDouituBean.class
    ,BzRenkeiHenkanUtilTest_convert.class
    ,BzRenkeiHenkanUtilTest_convYmdZeroToNull.class
    ,BzRenkeiHenkanUtilTest_convYmdNullToZero.class
    ,BzRenkeiHenkanUtilTest_convYmZeroToNull.class
    ,BzRenkeiHenkanUtilTest_convYmNullToZero.class
    ,BzRenkeiHenkanUtilTest_getErrorKbn.class
    ,BzRenkeiHenkanUtilTest_getConvYmString.class
    ,BzRenkeiHenkanUtilTest_getConvYmBizDate.class
    ,BzRenkeiHenkanUtilTest_getConvYmdString.class
    ,BzRenkeiHenkanUtilTest_getConvYmdBizDate.class
})
public class BzRenkeiHenkanUtilTest_All {
}
