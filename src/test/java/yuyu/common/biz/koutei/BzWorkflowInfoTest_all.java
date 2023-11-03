package yuyu.common.biz.koutei;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link BzWorkflowInfo}クラスに含まれる、全メソッドのテストをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({BzWorkflowInfoTest_setExceptionToRenkeiInfo.class,BzWorkflowInfoTest_BzWorkflowInfo.class})
public class BzWorkflowInfoTest_all {
}
