package yuyu.common.sinkeiyaku.moschk;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link CheckMeigininNmKanaCall}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({
    CheckMeigininNmKanaCallTest_execKyk.class
    ,CheckMeigininNmKanaCallTest_execHhkn.class
    ,CheckMeigininNmKanaCallTest_execKok.class
})
public class CheckMeigininNmKanaCallTest_all {
}

