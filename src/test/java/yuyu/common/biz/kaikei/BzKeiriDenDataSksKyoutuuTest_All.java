package yuyu.common.biz.kaikei;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import yuyu.testinfr.AbstractTest;

/**
 * {@link BzKeiriDenDataSksKyoutuu}クラスに含まれる、全メソッドのテストをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({
    BzKeiriDenDataSksKyoutuuTest_setSkKeiriDenpyoData.class
    , BzKeiriDenDataSksKyoutuuTest_setKeiriDenpyoData.class
    , BzKeiriDenDataSksKyoutuuTest_changeGaikaData.class
    , BzKeiriDenDataSksKyoutuuTest_getDenpyoKawaseRate.class
    , BzKeiriDenDataSksKyoutuuTest_changeGaika.class
    , BzKeiriDenDataSksKyoutuuTest_getGaikaTaisyakuFuittiInfo.class
})
public class BzKeiriDenDataSksKyoutuuTest_All extends AbstractTest {
}