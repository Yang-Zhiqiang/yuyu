package yuyu.common.sinkeiyaku.skcommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link EditGamenString}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({EditGamenStringTest_editStringSbstr.class
    ,EditGamenStringTest_editMessegeStringRule.class
    ,EditGamenStringTest_addKaigyouCode.class
})
public class EditGamenStringTest_All {
}