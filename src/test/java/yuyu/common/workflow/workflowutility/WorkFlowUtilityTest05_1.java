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
 * ワークフロー呼出ユーティリティ(割当解除)単体テストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class WorkFlowUtilityTest05_1 extends AbstractTest {

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
    public void testUnassignTask_Case1(){
        IwfKouteiClientMock.mode =  "05-01";

        WorkListUnassignTaskResultBean ret = WorkFlowUtility.unassignTask("hijklmn", "hzn","タスク名０１", "abcdefg", "rirekiUser");

        exBooleanEquals(Strings.isNullOrEmpty(ret.getSyousaiMessageCd()), true, "割当解除処理結果:1");
    }

    @Test
    @TestOrder(20)
    public void testUnassignTask_Case2(){
        IwfKouteiClientMock.mode =  "05-02";

        WorkListUnassignTaskResultBean ret = WorkFlowUtility.unassignTask(null, null,null, null, null);

        exStringEquals(ret.getSyorikekkaStatus(), WorkFlowResultConstants.RESULT_NG, "割当解除処理結果:2");
    }

    @Test
    @TestOrder(30)
    public void testUnassignTask_Case3(){
        IwfKouteiClientMock.mode =  "05-03";

        WorkListUnassignTaskResultBean ret = WorkFlowUtility.unassignTask(null, null,null, null, null);

        exStringEquals(ret.getSyorikekkaStatus(), WorkFlowResultConstants.RESULT_NG, "割当解除処理結果:3-1");
        exStringEquals(ret.getSyousaiMessageCd(), "IWF0000", "割当解除処理結果:3-2");
    }


    @Test
    @TestOrder(40)
    public void testUnassignTask_Case4(){
        IwfKouteiClientMock.mode =  "05-04";

        WorkListUnassignTaskResultBean ret = WorkFlowUtility.unassignTask(null, null, null,null, null);

        exStringEquals(ret.getSyorikekkaStatus(), WorkFlowResultConstants.RESULT_NG, "割当解除処理結果:4-1");
        exStringEquals(ret.getSyousaiMessage(), "異常終了しました", "割当解除処理結果:4-2");
    }

    @Test
    @TestOrder(40)
    public void testUnassignTask_Case5(){
        IwfKouteiClientMock.mode =  "05-05";

        WorkListUnassignTaskResultBean ret = WorkFlowUtility.unassignTask(null, null,null, null, null);

        exStringEquals(ret.getSyorikekkaStatus(), WorkFlowResultConstants.RESULT_NG, "割当解除処理結果:5-1");
        exStringEquals(ret.getErrorApiName(), "LockProcess", "割当解除処理結果:5-2");
    }

    @Test
    @TestOrder(170)
    public void testUnassignTask_Case17(){
        IwfKouteiClientMock.mode =  "05-17";

        WorkListUnassignTaskResultBean ret = WorkFlowUtility.unassignTask(null, null, null,null, null);

        exStringEquals(ret.getSyorikekkaStatus(), WorkFlowResultConstants.RESULT_LOCK,
            "出力パラメータの処理結果ステータス");
        exStringEquals(ret.getSyousaiMessageCd(), "IWF2091", "出力パラメータの詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), "異常終了しました", "出力パラメータの詳細メッセージ");
        exStringEquals(ret.getErrorApiName(), "LockProcess", "出力パラメータのエラー発生API名");
    }

    @Test
    @TestOrder(50)
    public void testUnassignTask_Case6(){
        IwfKouteiClientMock.mode =  "05-06";

        WorkListUnassignTaskResultBean ret = WorkFlowUtility.unassignTask("hijklmn", "hzn","タスク名０６", "abcdefg", "rirekiUser");

        exBooleanEquals(Strings.isNullOrEmpty(ret.getSyousaiMessageCd()), true, "割当解除処理結果:6");
    }


    @Test
    @TestOrder(70)
    public void testUnassignTask_Case7(){
        IwfKouteiClientMock.mode =  "05-07";

        WorkListUnassignTaskResultBean ret = WorkFlowUtility.unassignTask(null, null, "タスク名０７", null, null);

        exStringEquals(ret.getSyorikekkaStatus(), WorkFlowResultConstants.RESULT_NG, "割当解除処理結果:7");
    }


    @Test
    @TestOrder(80)
    public void testUnassignTask_Case8(){
        IwfKouteiClientMock.mode =  "05-08";

        WorkListUnassignTaskResultBean ret = WorkFlowUtility.unassignTask(null, null, "タスク名０８", null, null);

        exStringEquals(ret.getSyorikekkaStatus(), WorkFlowResultConstants.RESULT_NG, "割当解除処理結果:8-1");
        exStringEquals(ret.getSyousaiMessageCd(), "IWF0000", "割当解除処理結果:8-2");
    }

    @Test
    @TestOrder(90)
    public void testUnassignTask_Case9(){
        IwfKouteiClientMock.mode =  "05-09";

        WorkListUnassignTaskResultBean ret = WorkFlowUtility.unassignTask(null, null, "タスク名０９",null, null);

        exStringEquals(ret.getSyorikekkaStatus(), WorkFlowResultConstants.RESULT_NG, "割当解除処理結果:9-1");
        exStringEquals(ret.getSyousaiMessage(), "異常終了しました", "割当解除処理結果:9-2");
    }


    @Test
    @TestOrder(100)
    public void testUnassignTask_Case10(){
        IwfKouteiClientMock.mode =  "05-10";

        WorkListUnassignTaskResultBean ret = WorkFlowUtility.unassignTask(null, null, "タスク名１０",null, null);

        exStringEquals(ret.getSyorikekkaStatus(), WorkFlowResultConstants.RESULT_NG, "割当解除処理結果:10-1");
        exStringEquals(ret.getErrorApiName(), "UnassignTask", "割当解除処理結果:10-2");
    }

}
