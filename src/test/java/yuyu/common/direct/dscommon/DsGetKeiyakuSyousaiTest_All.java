package yuyu.common.direct.dscommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * ＤＳ契約詳細取得クラスに含まれる、全メソッドのテストをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({
    DsGetKeiyakuSyousaiTest_exec.class
    ,DsGetKeiyakuSyousaiTest2_exec.class
})
public class DsGetKeiyakuSyousaiTest_All {
}