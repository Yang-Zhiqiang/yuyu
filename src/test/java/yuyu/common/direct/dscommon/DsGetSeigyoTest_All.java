package yuyu.common.direct.dscommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link DsGetSeigyo}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({
    DsGetSeigyoTest_getGamenSeigyo.class,
    DsGetSeigyoTest_getHosyou.class,
    DsGetSeigyoTest_getTokuyaku.class,
    DsGetSeigyoTest_getSyoriKahi.class,
})
public class DsGetSeigyoTest_All {

}
