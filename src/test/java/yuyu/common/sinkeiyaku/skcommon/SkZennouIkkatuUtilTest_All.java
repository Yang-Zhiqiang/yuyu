package yuyu.common.sinkeiyaku.skcommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * 新契約前納一括払関連ユーティリティクラスのメソッド {@link SkZennouIkkatuUtil} クラスに含まれる全メソッドの、
 * テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({
    SkZennouIkkatuUtilTest_getInRangeIkkatuTukiPSpecifiedZennouPYen.class,
    SkZennouIkkatuUtilTest_getInRangeIkkatuTukiPSpecifiedIkkatuPYen.class,
    SkZennouIkkatuUtilTest_getZennouPFrom12IkkatuTukiPYenforMsg.class,
    SkZennouIkkatuUtilTest_getIkkatuPFromIkkatuTukiPYenforMsg.class,
    SkZennouIkkatuUtilTest_getHaraikomiPTanni.class,
    SkZennouIkkatuUtilTest_getInRangeNenbaraiPSpecifiedZennouP.class,
    SkZennouIkkatuUtilTest_getZennouPFromNenbaraiPforMsg.class
})
public class SkZennouIkkatuUtilTest_All {
}
