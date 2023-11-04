package yuyu.common.siharai.sicommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link SaigaiGaitouHantei}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br /><br />
 */
@RunWith(Suite.class)
@SuiteClasses({
    SaigaiGaitouHanteiTest_chkGeninkbn.class,
    SaigaiGaitouHanteiTest_chkByoumei.class,
    SaigaiGaitouHanteiTest_chkSateikaisou.class,
    SaigaiGaitouHanteiTest_chkKyuusyorui.class
})
public class SaigaiGaitouHanteiTest_All {
}
