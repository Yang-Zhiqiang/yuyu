package yuyu.common.hozen.khcommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link CommonSiwakeUtil}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({
    CommonSiwakeUtilTest_execPKanjokamokuHantei.class,
    CommonSiwakeUtilTest_execTaisyakuTyousei.class,
    CommonSiwakeUtilTest_execKihrkmPKanjokamokuHantei.class
})
public class CommonSiwakeUtilTest_All {
}

