package yuyu.common.sinkeiyaku.skcommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link SkToujituIdounaiyouEdit}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({
    SkToujituIdounaiyouEditTest_setSkIdounaiyouInit.class,
    SkToujituIdounaiyouEditTest_setSkIdounaiyouBefore.class,
    SkToujituIdounaiyouEditTest_skIdounaiyouHenkouCheck.class,
    SkToujituIdounaiyouEditTest_skIdounaiyouMQEdit.class,
    SkToujituIdounaiyouEditTest_skIdounaiyouFileEdit.class,
    SkToujituIdounaiyouEditTest_skIdounaiyouCancel.class,
    SkToujituIdounaiyouEditTest_skIdounaiyouSakujyoFileEdit.class
})
public class SkToujituIdounaiyouEditTest_all {
}

