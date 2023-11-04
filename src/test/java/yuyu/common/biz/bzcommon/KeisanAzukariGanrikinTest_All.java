package yuyu.common.biz.bzcommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link KeisanAzukariGanrikin}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({ KeisanAzukariGanrikinTest_exec.class
    , KeisanAzukariGanrikinTest_exec2.class
})
public class KeisanAzukariGanrikinTest_All {
}
