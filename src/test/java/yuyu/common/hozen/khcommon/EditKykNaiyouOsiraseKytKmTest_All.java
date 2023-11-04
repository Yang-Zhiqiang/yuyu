package yuyu.common.hozen.khcommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link EditKykNaiyouOsiraseKytKm}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({

    EditKykNaiyouOsiraseKytKmTest_editDsTourokuJyou.class,
    EditKykNaiyouOsiraseKytKmTest_editInfo.class,
    EditKykNaiyouOsiraseKytKmTest_editInfo_uktInfoSyusin.class,
    EditKykNaiyouOsiraseKytKmTest_editInfo_uktInfoNenkin.class
})
public class EditKykNaiyouOsiraseKytKmTest_All {
}


