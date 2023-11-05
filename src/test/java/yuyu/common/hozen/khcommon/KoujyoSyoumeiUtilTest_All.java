package yuyu.common.hozen.khcommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * 控除証明ユーティリティクラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({
    KoujyoSyoumeiUtilTest_chkTkZennouStkkntySeisan.class,
    KoujyoSyoumeiUtilTest_createKsnHkJmrnTyhyBean.class,
    KoujyoSyoumeiUtilTest_sumSyouhnp.class,
    KoujyoSyoumeiUtilTest_chkYenkanzanrateUmu.class
})
public class KoujyoSyoumeiUtilTest_All {
}
