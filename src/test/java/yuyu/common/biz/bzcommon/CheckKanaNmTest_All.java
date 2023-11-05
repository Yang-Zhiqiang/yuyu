package yuyu.common.biz.bzcommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link CheckKanaNm}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({CheckKanaNmTest_isCheckOK_1.class
    ,CheckKanaNmTest_isCheckOK_2.class
    ,CheckKanaNmTest_isCheckOK_3.class
})
public class CheckKanaNmTest_All {
}