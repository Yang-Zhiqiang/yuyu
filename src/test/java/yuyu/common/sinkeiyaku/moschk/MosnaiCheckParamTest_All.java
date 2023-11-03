package yuyu.common.sinkeiyaku.moschk;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link MosnaiCheckParam}クラスに含まれる、全メソッドのテストをまとめて実施するクラスです。<br />
 */

@RunWith(Suite.class)
@SuiteClasses({ MosnaiCheckParamTest_getSyouhnZokusei.class
    , MosnaiCheckParamTest_Properties.class
})
public class MosnaiCheckParamTest_All {
}
