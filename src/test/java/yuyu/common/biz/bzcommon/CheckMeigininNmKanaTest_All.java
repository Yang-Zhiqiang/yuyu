package yuyu.common.biz.bzcommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link CheckMeigininNmKana}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({CheckMeigininNmKanaTest_isCheckOK_1.class
    ,CheckMeigininNmKanaTest_isCheckOK_2.class
    ,CheckMeigininNmKanaTest_isCheckOK_3.class
    ,CheckMeigininNmKanaTest_isCheckOK_Koza_1.class
    ,CheckMeigininNmKanaTest_isCheckOK_Koza_2.class
    ,CheckMeigininNmKanaTest_isCheckOK_Kzhuri_1.class
    ,CheckMeigininNmKanaTest_isCheckOK_Kzhuri_2.class
    ,CheckMeigininNmKanaTest_isCheckOK_FBSoukin_1.class
    ,CheckMeigininNmKanaTest_isCheckOK_FBSoukin_2.class
    ,CheckMeigininNmKanaTest_isCheckOK_Tuuka.class
    ,CheckMeigininNmKanaTest_isPALCheckOK.class

})
public class CheckMeigininNmKanaTest_All {
}