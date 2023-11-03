package yuyu.common.sinkeiyaku.skcommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link CheckTkhjn}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({ CheckTkhjnTest_checkJissi.class
    ,CheckTkhjnTest_crtCheckTaisyouLst.class
    ,CheckTkhjnTest_hanteiCheckYouhi.class

})
public class CheckTkhjnTest_all {
}

