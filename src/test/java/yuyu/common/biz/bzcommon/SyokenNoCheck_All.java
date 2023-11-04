package yuyu.common.biz.bzcommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link SyokenNoCheck}クラスに含まれる、全メソッドのテストをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({ SyokenNoCheckTest_isValid.class,
    SyokenNoCheckTest_calcDegit.class,
    SyokenNoCheckTest_ifExistSyokenNo.class

})
public class SyokenNoCheck_All {
}
