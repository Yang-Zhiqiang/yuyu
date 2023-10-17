package yuyu.common.workflow.workflowutility;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.workflow.IwfKouteiClientMock;
import yuyu.def.workflow.configuration.YuyuWorkflowConfig;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.TestOrder;

import com.google.common.base.Strings;

/**
 * ワークフロー呼出Utility.処理残件数保管のロジックテストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class WorkFlowUtilityTest31 extends AbstractTest {

    @BeforeClass
    public static void insertTestData() {
    }

    @Before
    public  void caseInit() {
        IwfKouteiClientMock.caller = "Test";
        YuyuWorkflowConfig config = YuyuWorkflowConfig.getInstance();
        config.setWorkflowStubMode(false);
    }

    @AfterClass
    public static void testClear() {
        IwfKouteiClientMock.caller = null;
    }

    @AfterClass
    public static void deleteTestData() {
    }

    @After
    public  void caseTerminat() {
    }

    @Test
    @TestOrder(10)
    public void makeCountOfTaskSummaryTest_Case1() {
        IwfKouteiClientMock.mode = "31-01";

        MakeCountOfTaskSummaryResultBean ret = WorkFlowUtility.makeCountOfTaskSummary();

        exBooleanEquals(Strings.isNullOrEmpty(ret.getSyorikekkaStatus()), false, "タスク件数サマリ作成処理結果:1");
    }

    @Test
    @TestOrder(20)
    public void makeCountOfTaskSummaryTest_Case2() {
        IwfKouteiClientMock.mode = "31-02";

        MakeCountOfTaskSummaryResultBean ret = WorkFlowUtility.makeCountOfTaskSummary();

        exBooleanEquals(Strings.isNullOrEmpty(ret.getSyorikekkaStatus()), false, "タスク件数サマリ作成処理結果:2");
    }


    @Test
    @TestOrder(30)
    public void makeCountOfTaskSummaryTest_Case3() {
        IwfKouteiClientMock.mode = "31-03";

        MakeCountOfTaskSummaryResultBean ret = WorkFlowUtility.makeCountOfTaskSummary();

        exBooleanEquals(Strings.isNullOrEmpty(ret.getSyousaiMessageCd()), false, "タスク件数サマリ作成処理結果:3");
    }


    @Test
    @TestOrder(40)
    public void makeCountOfTaskSummaryTest_Case4() {
        IwfKouteiClientMock.mode = "31-03";

        MakeCountOfTaskSummaryResultBean ret = WorkFlowUtility.makeCountOfTaskSummary();

        exBooleanEquals(Strings.isNullOrEmpty(ret.getSyousaiMessage()), false, "タスク件数サマリ作成処理結果:4");
    }


}
