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

/**
 * ワークフロー呼出ユーティリティ(工程ロック情報取得)単体テストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class WorkFlowUtilityTest39 extends AbstractTest {

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
    public void getLockInfoTest_Case1() {

        IwfKouteiClientMock.mode = "39-01";

        GetLockInfoResultBean ret = WorkFlowUtility.getLockInfo("hijklmn");

        exStringEquals(ret.getSyorikekkaStatus(), "-9", "処理結果ステータス");
    }


    @Test
    @TestOrder(20)
    public void getLockInfoTest_Case2() {

        IwfKouteiClientMock.mode = "39-02";

        GetLockInfoResultBean ret = WorkFlowUtility.getLockInfo("hijklmn");

        exStringEquals(ret.getSyorikekkaStatus(), "0", "処理結果ステータス");
    }

    @Test
    @TestOrder(30)
    public void getLockInfoTest_Case3() {

        IwfKouteiClientMock.mode = "39-03";

        GetLockInfoResultBean ret = WorkFlowUtility.getLockInfo("hijklmn");

        exStringEquals(ret.getSyorikekkaStatus(), "9", "処理結果ステータス");
    }
}
