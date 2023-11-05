package yuyu.common.direct.dscommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link DsSaibanSyori}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({
    DsSaibanSyoriTest_saibanDsKoknoYichi.class,
    DsSaibanSyoriTest_saibanDsKoknoNi.class,
    DsSaibanSyoriTest_saibanDsKoknoSan.class,
    DsSaibanSyoriTest_saibanDsKoknoYoh.class,
    DsSaibanSyoriTest_saibanDsKoknoGo.class,
    DsSaibanSyoriTest_saibanDsKoknoRoku.class,
    DsSaibanSyoriTest_saibanDsKoknoNana.class,
    DsSaibanSyoriTest_saibanDsKoknoHati.class,
    DsSaibanSyoriTest_saibanDsHenkouSikibetukey.class,
    DsSaibanSyoriTest_saibanDsSousinNoRenban.class,
    DsSaibanSyoriTest_saibanRealTimeMailDsSousinNoRenban.class,
    DsSaibanSyoriTest_saibanDsTetuzukiSikibetuId.class
})
public class DsSaibanSyoriTest_All {
}