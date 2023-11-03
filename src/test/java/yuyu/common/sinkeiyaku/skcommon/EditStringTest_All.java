package yuyu.common.sinkeiyaku.skcommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link EditString}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({EditStringTest_editStringJoint.class
    ,EditStringTest_editYmdhms.class
    ,EditStringTest_editYmdhm.class
})
public class EditStringTest_All {
}