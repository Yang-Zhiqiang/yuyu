package yuyu.common.hozen.khcommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link KhozenCommonParam}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({
    KhozenCommonParamTest_getSiteiDairiSeikyuunin.class,
    KhozenCommonParamTest_getKyksyaDairinin.class,
    KhozenCommonParamTest_getTrkKzk.class,
    KhozenCommonParamTest_getTeikiSiharaikinUketorinin.class,
    KhozenCommonParamTest_getTeikiShrUketoriKouza.class,
})
public class KhozenCommonParamTest_All {
}
