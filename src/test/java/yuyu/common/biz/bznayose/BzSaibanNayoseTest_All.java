package yuyu.common.biz.bznayose;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


/**
 * {@link BzSaibanNayose}クラスに含まれる、全メソッドのテストをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({BzSaibanNayoseTest_exec.class
    , BzSaibanNayoseTest_exec_2.class
})
public class BzSaibanNayoseTest_All {
}
