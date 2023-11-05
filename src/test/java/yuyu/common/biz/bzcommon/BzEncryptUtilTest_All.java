package yuyu.common.biz.bzcommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link BzEncryptUtil}クラスに含まれる、全メソッドのテストをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({BzEncryptUtilTest_raydbEncrypt.class
    ,BzEncryptUtilTest_raydbDecrypt.class
})
public class BzEncryptUtilTest_All {
}