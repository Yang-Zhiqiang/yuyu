package yuyu.common.hozen.khcommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link CreditUriageSeikyuuDataSks}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({
    CreditUriageSeikyuuDataSksTest_editTuujyouUriageData.class,
    CreditUriageSeikyuuDataSksTest_editRinjiUriageData.class,
    CreditUriageSeikyuuDataSksTest_editHenkinUriageData.class
})
public class CreditUriageSeikyuuDataSksTest_All {
}
