package yuyu.common.sinkeiyaku.skcommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link EditNenkinKoumokuUtil}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({EditNenkinKoumokuUtilTest_editNenkinSueokikikan.class
    ,EditNenkinKoumokuUtilTest_editNenkinSiharaiKaisiNenrei.class
    ,EditNenkinKoumokuUtilTest_getSkNkgnsKijyunGk.class
})
public class EditNenkinKoumokuUtilTest_All {
}