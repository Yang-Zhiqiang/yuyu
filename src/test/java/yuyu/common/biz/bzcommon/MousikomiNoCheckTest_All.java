package yuyu.common.biz.bzcommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link MousikomiNoCheck}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({ MousikomiNoCheckTest_isValid.class
    , MousikomiNoCheckTest_calcDegit.class
    , MousikomiNoCheckTest_ifExistMousikomiNo.class
})
public class MousikomiNoCheckTest_All {
}
