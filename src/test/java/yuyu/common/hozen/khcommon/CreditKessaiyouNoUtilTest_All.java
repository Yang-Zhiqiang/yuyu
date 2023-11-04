package yuyu.common.hozen.khcommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link CreditKessaiyouNoUtil}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({
    CreditKessaiyouNoUtilTest_getKessaiSyuruiKbn.class,
    CreditKessaiyouNoUtilTest_getKeySyuruiKbn.class,
    CreditKessaiyouNoUtilTest_getMosNo.class,
    CreditKessaiyouNoUtilTest_getSyoNo.class,
})
public class CreditKessaiyouNoUtilTest_All {
}
