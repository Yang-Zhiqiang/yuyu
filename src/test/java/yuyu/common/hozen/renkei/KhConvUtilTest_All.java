package yuyu.common.hozen.renkei;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link KhConvUtil}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({
    KhConvUtilTest_convNksyukbn.class,
    KhConvUtilTest_convNenkinkkn.class,
    KhConvUtilTest_convKyktdk.class,
})
public class KhConvUtilTest_All {
}
