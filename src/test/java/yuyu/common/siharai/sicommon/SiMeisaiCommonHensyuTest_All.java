package yuyu.common.siharai.sicommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link SiMeisaiCommonHensyu}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br /><br />
 */
@RunWith(Suite.class)
@SuiteClasses({
    SiMeisaiCommonHensyuTest_siMeisaiHensyu.class,
    SiMeisaiCommonHensyuTest_sisansyoHensyu.class
})
public class SiMeisaiCommonHensyuTest_All {
}
