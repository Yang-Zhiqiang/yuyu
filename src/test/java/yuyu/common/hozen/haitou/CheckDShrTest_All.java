package yuyu.common.hozen.haitou;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link CheckDShr}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */

@RunWith(Suite.class)
@SuiteClasses({

    CheckDShrTest_checkExistsDHaneiYmd.class,
    CheckDShrTest_checkExistsDShrYmd.class,
    CheckDShrGengakuTest_checkDShr.class,
    CheckDShrKaiyakuTest_checkDShr.class,
    CheckDShrSibouTest_checkDShr.class,
    CheckDShrDShrTest_checkDShr.class,
    CheckDShrYendtHnkuketukeTest_checkDShr.class,
    CheckDShrYendtHnkTorikesiTest_checkDShr.class,
    CheckDShrNyukinTorikesiTest_checkDShr.class,
    CheckDShrDShrTest_checkExistsDShrTaisyou.class,
    CheckDShrDShrTest_checkSakihidukeTumitateDKanriUmu.class,
    CheckDShrDShrTest_checkTounendoDUmu.class

})
public class CheckDShrTest_All {
}
