package yuyu.common.sinkeiyaku.skcommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link GetSkTtdkTyuui}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです<br />
 */
@RunWith(Suite.class)
@SuiteClasses(
    { GetSkTtdkTyuuiTest_getTtdkTyuuiKanri.class
        , GetSkTtdkTyuuiTest_getTtdkTyuui.class
    })
public class GetSkTtdkTyuuiTest_All {
}
