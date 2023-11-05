package yuyu.common.hozen.khcommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link EditKykNaiyouOsirase}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({

    EditKykNaiyouOsiraseTest_editInfo.class,
    EditKykNaiyouOsiraseTest_getKawaseRateBean.class,

})
public class EditKykNaiyouOsiraseTest_All {
}
