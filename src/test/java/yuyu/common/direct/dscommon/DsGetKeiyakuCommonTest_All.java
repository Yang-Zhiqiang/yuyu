package yuyu.common.direct.dscommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link DsGetKeiyakuCommon}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({
    DsGetKeiyakuCommonTest_getKykKihon.class,
    DsGetKeiyakuCommonTest_getKykSya.class,
    DsGetKeiyakuCommonTest_getHhknSya.class,
    DsGetKeiyakuCommonTest_getKykUkt.class,
    DsGetKeiyakuCommonTest_getTrkKazoku.class,
    DsGetKeiyakuCommonTest_getUketoriKouza.class,
    DsGetKeiyakuCommonTest_getHokenKikan.class
})
public class DsGetKeiyakuCommonTest_All {
}