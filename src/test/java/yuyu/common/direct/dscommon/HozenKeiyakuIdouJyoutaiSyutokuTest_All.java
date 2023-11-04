package yuyu.common.direct.dscommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link HozenKeiyakuIdouJyoutaiSyutoku}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({HozenKeiyakuIdouJyoutaiSyutokuTest_hozenKeiyakuIdouJyoutaiSyutoku.class
    ,HozenKeiyakuIdouJyoutaiSyutokuTest_hozenKeiyakuIdouJyoutaiSyutokuDSMikanyuu.class
    ,HozenKeiyakuIdouJyoutaiSyutokuTest_keiyakuJyoutaiYuukouseiHantei.class
})
public class HozenKeiyakuIdouJyoutaiSyutokuTest_All {
}