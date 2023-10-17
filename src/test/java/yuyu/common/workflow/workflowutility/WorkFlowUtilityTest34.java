package yuyu.common.workflow.workflowutility;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.workflow.IwfImageClientMock;
import yuyu.def.workflow.configuration.YuyuWorkflowConfig;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.TestOrder;

/**
 * ワークフロー呼出ユーティリティ(到着予定登録)単体テストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class WorkFlowUtilityTest34 extends AbstractTest {

    @BeforeClass
    public static void insertTestData() {
    }

    @Before
    public  void caseInit() {
        IwfImageClientMock.caller = "Test";
        YuyuWorkflowConfig config = YuyuWorkflowConfig.getInstance();
        config.setWorkflowStubMode(false);
    }

    @AfterClass
    public static void testClear() {
        IwfImageClientMock.caller = null;
    }

    @AfterClass
    public static void deleteTestData() {
    }

    @After
    public  void caseTerminat() {
    }

    @Test
    @TestOrder(10)
    public void testPutExpectedArrivalNotice_Case01(){
        IwfImageClientMock.mode = "34-01";
        PutExpectedArrivalNoticeResultBean ret = WorkFlowUtility.putExpectedArrivalNotice(
            null,
            "yuyu12345678901234567",
            "wf001",
            "0001",
            "sinkeiyaku");
        exStringEquals(ret.getSyorikekkaStatus(), "9", "到着予定登録処理結果:1");
    }

    @Test
    @TestOrder(20)
    public void testPutExpectedArrivalNotice_Case02(){
        IwfImageClientMock.mode = "34-02";
        PutExpectedArrivalNoticeResultBean ret = WorkFlowUtility.putExpectedArrivalNotice(
            "12345678901",
            null,
            "wf001",
            "0001",
            "sinkeiyaku");
        exStringEquals(ret.getSyorikekkaStatus(), "9", "到着予定登録処理結果:2");
    }

    @Test
    @TestOrder(30)
    public void testPutExpectedArrivalNotice_Case03(){
        IwfImageClientMock.mode = "34-03";
        PutExpectedArrivalNoticeResultBean ret = WorkFlowUtility.putExpectedArrivalNotice(
            "12345678901",
            "yuyu12345678901234567",
            null,
            "0001",
            "sinkeiyaku");
        exStringEquals(ret.getSyorikekkaStatus(), "9", "到着予定登録処理結果:3");
    }

    @Test
    @TestOrder(40)
    public void testPutExpectedArrivalNotice_Case04(){
        IwfImageClientMock.mode = "34-04";
        PutExpectedArrivalNoticeResultBean ret = WorkFlowUtility.putExpectedArrivalNotice(
            "12345678901",
            "yuyu12345678901234567",
            "wf001",
            null,
            "sinkeiyaku");
        exStringEquals(ret.getSyorikekkaStatus(), "9", "到着予定登録処理結果:4");
    }

    @Test
    @TestOrder(50)
    public void testPutExpectedArrivalNotice_Case05(){
        IwfImageClientMock.mode = "34-05";
        PutExpectedArrivalNoticeResultBean ret = WorkFlowUtility.putExpectedArrivalNotice(
            "12345678901",
            "yuyu12345678901234567",
            "wf001",
            "0001",
            null);
        exStringEquals(ret.getSyorikekkaStatus(), "9", "到着予定登録処理結果:5");
    }

    @Test
    @TestOrder(60)
    public void testPutExpectedArrivalNotice_Case06(){
        IwfImageClientMock.mode = "34-06";
        PutExpectedArrivalNoticeResultBean ret = WorkFlowUtility.putExpectedArrivalNotice(
            "12345678901",
            "yuyu12345678901234567",
            "wf001",
            "0001",
            "sinkeiyaku");
        exStringEquals(ret.getSyorikekkaStatus(), "0", "到着予定登録処理結果:6");
    }

    @Test
    @TestOrder(70)
    public void testPutExpectedArrivalNotice_Case07(){
        IwfImageClientMock.mode = "34-07";
        PutExpectedArrivalNoticeResultBean ret = WorkFlowUtility.putExpectedArrivalNotice(
            "12345678901",
            "yuyu12345678901234567",
            "wf001",
            "0001",
            "sinkeiyaku");
        exStringEquals(ret.getSyousaiMessageCd(), "IWF0000", "到着予定登録処理結果:7");
    }

    @Test
    @TestOrder(80)
    public void testPutExpectedArrivalNotice_Case08(){
        IwfImageClientMock.mode = "34-08";
        PutExpectedArrivalNoticeResultBean ret = WorkFlowUtility.putExpectedArrivalNotice(
            "12345678901",
            "yuyu12345678901234567",
            "wf001",
            "0001",
            "sinkeiyaku");
        exStringEquals(ret.getSyousaiMessage(), "正常終了しました。", "到着予定登録処理結果:8");
    }

    @Test
    @TestOrder(90)
    public void testPutExpectedArrivalNotice_Case09(){
        IwfImageClientMock.mode = "34-09";
        PutExpectedArrivalNoticeResultBean ret = WorkFlowUtility.putExpectedArrivalNotice(
            "12345678901",
            "yuyu12345678901234567",
            "wf001",
            "0001",
            "sinkeiyaku");
        exStringEquals(ret.getSyorikekkaStatus(), "0", "到着予定登録処理結果:9");
    }
}