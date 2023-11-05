package yuyu.common.biz.koutei;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link BzCommonLockProcess}クラスに含まれる、全メソッドのテストをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({BzCommonLockProcessTest_unlockProcess.class
    ,BzCommonLockProcessTest_getKouteiLockKey.class
    ,BzCommonLockProcessTest_continueLockProcess.class
    , BzCommonLockProcessTest_lockProcess.class
})
public class BzCommonLockProcessTest_all {

}
