package yuyu.common.sinkeiyaku.skcommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link ConvNenSaiManki}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({ ConvNenSaiMankiTest_convHrkkknNen.class
    ,ConvNenSaiMankiTest_convHrkkknSai.class
    ,ConvNenSaiMankiTest_convHknkknNen.class
    ,ConvNenSaiMankiTest_convHknkknSai.class

})
public class ConvNenSaiMankiTest_all {
}
