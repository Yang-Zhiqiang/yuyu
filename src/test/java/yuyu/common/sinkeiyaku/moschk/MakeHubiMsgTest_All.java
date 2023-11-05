package yuyu.common.sinkeiyaku.moschk;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link MakeHubiMsg}クラスに含まれる、全メソッドのテストをまとめて実施するクラスです。<br />
 */

@RunWith(Suite.class)
@SuiteClasses({ MakeHubiMsgTest_exec.class
    , MakeHubiMsgTest_execParam2CommaTuuka.class
    , MakeHubiMsgTest_execParam1CommaTuuka.class
})
public class MakeHubiMsgTest_All {
}
