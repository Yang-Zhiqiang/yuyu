package yuyu.common.direct.dscommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * ＤＳ解約共通チェッククラスに含まれる、全メソッドのテストをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({
    CheckDsKaiyakuTest_kaiyakukytChk.class
    ,CheckDsKaiyakuTest_kaiyakuUkeUmuChk.class
})
public class CheckDsKaiyakuTest_All {
}