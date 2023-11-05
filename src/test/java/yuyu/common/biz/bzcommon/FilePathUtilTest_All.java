package yuyu.common.biz.bzcommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link FilePathUtil}クラスに含まれる、全メソッドのテストをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({FilePathUtilTest_getBatchInDataPath.class
    ,FilePathUtilTest_getBatchOutDataPath.class
})
public class FilePathUtilTest_All {
}
