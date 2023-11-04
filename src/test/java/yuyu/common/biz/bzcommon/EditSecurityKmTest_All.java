package yuyu.common.biz.bzcommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link EditSecurityKm}クラスに含まれる、全メソッドのテストをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({EditSecurityKmTest_encode.class
    ,EditSecurityKmTest_getEncodeData.class
    ,EditSecurityKmTest_decode.class
    ,EditSecurityKmTest_getDecodeData.class
})
public class EditSecurityKmTest_All {
}