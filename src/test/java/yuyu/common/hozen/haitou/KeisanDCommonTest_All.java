package yuyu.common.hozen.haitou;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link KeisanDCommon}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({

    KeisanDCommonTest_calcD.class,
    KeisanDCommonTest_calcKariwariateDGanrikin.class,
    KeisanDCommonTest_calcTumitateDGanrikin.class,
    KeisanDCommonKaiyakuTest_calcDShrgk.class,
    KeisanDCommonSibouTest_calcDShrgk.class,
    KeisanDCommonGengakuTest_calcDShrgk.class,
    KeisanDCommonYendtHnk_calcDkngk.class,
    KeisanDCommonDShrTest_calcDShrgkAllhikidasi.class,
    KeisanDCommonDShrTest_calcDShrgkItibuhikidasi.class,
    KeisanDCommonTest_getCoordinatedCalcYmd.class,
    KeisanDCommonTest_calcWrmdsKngk.class,
    KeisanDCommonTest_getEditDshrTukiDKoumokuBean.class

})
public class KeisanDCommonTest_All {
}
