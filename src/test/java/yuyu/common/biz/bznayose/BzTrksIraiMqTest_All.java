package yuyu.common.biz.bznayose;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import yuyu.testinfr.AbstractTest;

/**
 * {@link BzTrksIraiMq}クラスに含まれる、全メソッドのテストをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({BzTrksIraiMqTest_exec1.class
    , BzTrksIraiMqTest_exec2.class
})
public class BzTrksIraiMqTest_All extends AbstractTest {
}
