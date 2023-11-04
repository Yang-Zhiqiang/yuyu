package yuyu.common.biz.bzcommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link CheckKouzaNo}クラスに含まれる、全メソッドのテストをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({ CheckKouzaNoTest_isCheckOK.class,
                CheckKouzaNoTest_isKyoyouKeta.class

})
public class CheckKouzaNoTest_All {
}
