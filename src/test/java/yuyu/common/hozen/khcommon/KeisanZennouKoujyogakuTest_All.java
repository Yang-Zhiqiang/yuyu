package yuyu.common.hozen.khcommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link KeisanZennouKoujyogaku}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({
    KeisanZennouKoujyogakuTest_getZennouKoujyogaku.class,
    KeisanZennouKoujyogakuTest_doHaibunZennouKoujyogaku.class,
    KeisanZennouKoujyogakuTest_getKhShgtZennouKoujyogakuBean.class,
    KeisanZennouKoujyogakuTest_keisanTukiZennouGngk.class,
    KeisanZennouKoujyogakuTest_keisanTukiZennouSymt.class,
})
public class KeisanZennouKoujyogakuTest_All {
}
