package yuyu.common.suuri.srcommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link SrDateUtil}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです<br />
 */
@RunWith(Suite.class)
@SuiteClasses({
    SrDateUtilTest_isKessanTuki.class,
    SrDateUtilTest_isKessanTukiYokugetu.class

})
public class SrDateUtilTest_All {
}
