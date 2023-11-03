package yuyu.common.biz.bznayose;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import yuyu.common.biz.bznayose.BzKykNaiyouHaneiMq;
import yuyu.testinfr.AbstractTest;

/**
 * {@link BzKykNaiyouHaneiMq}クラスに含まれる、全メソッドのテストをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({BzKykNaiyouHaneiMqTest_exec1.class
    , BzKykNaiyouHaneiMqTest_exec2.class
    , BzKykNaiyouHaneiMqTest_exec3.class
})
public class BzKykNaiyouHaneiMqTest_All extends AbstractTest {
}
