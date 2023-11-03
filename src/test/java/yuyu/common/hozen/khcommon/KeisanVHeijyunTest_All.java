package yuyu.common.hozen.khcommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link KeisanVHeijyun}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({ KeisanVHeijyunTest_exec.class
    , KeisanVHeijyunTest_exec2.class
})
public class KeisanVHeijyunTest_All {
}
