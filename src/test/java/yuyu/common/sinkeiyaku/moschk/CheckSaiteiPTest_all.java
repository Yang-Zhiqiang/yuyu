package yuyu.common.sinkeiyaku.moschk;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link CheckSaiteiP}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({
    CheckSaiteiPTest_exec.class
    ,CheckSaiteiPTest_getSaiteiP.class
})
public class CheckSaiteiPTest_all {
}