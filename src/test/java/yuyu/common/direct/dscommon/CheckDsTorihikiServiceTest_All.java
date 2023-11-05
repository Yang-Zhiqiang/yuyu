package yuyu.common.direct.dscommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link CheckDsTorihikiService}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({
    CheckDsTorihikiServiceTest_checkZokuseiNo.class,
    CheckDsTorihikiServiceTest_checkSoukinyoukz.class,
    CheckDsTorihikiServiceTest_checkSoukinyoukzInput.class,
    CheckDsTorihikiServiceTest_getTrhkServiceTourokuJyoukyou.class
})
public class CheckDsTorihikiServiceTest_All {
}