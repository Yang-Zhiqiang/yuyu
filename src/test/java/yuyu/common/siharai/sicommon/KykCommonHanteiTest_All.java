package yuyu.common.siharai.sicommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link KykCommonHantei}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br /><br />
 */
@RunWith(Suite.class)
@SuiteClasses({
    KykCommonHanteiTest_chkKykdrtkykumu.class,
    KykCommonHanteiTest_chkKeiukedou.class
})
public class KykCommonHanteiTest_All {
}
