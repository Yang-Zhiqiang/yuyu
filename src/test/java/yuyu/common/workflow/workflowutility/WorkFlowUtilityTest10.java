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
 * ワークフロー呼出ユーティリティ(ＱＲシール用紙作成用案件存在チェック)単体テストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class WorkFlowUtilityTest10 extends AbstractTest {

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
    public void testGetTasksForQrSeal_Case01(){
        IwfKouteiClientMock.mode = "10-01";
        GetTasksForQrSealResultBean ret = WorkFlowUtility.getTasksForQrSeal(
            null,
            new String[] {"12345678901","12345678902"},
            null);
        exStringEquals(ret.getSyorikekkaStatus(), "9", "ＱＲシール用紙作成用案件存在チェック:1");
    }

    @Test
    @TestOrder(20)
    public void testGetTasksForQrSeal_Case02(){
        IwfKouteiClientMock.mode = "10-02";
        GetTasksForQrSealResultBean ret = WorkFlowUtility.getTasksForQrSeal(
            null,
            null,
            new String[] {"12345678901","12345678902"});
        exStringEquals(ret.getSyousaiMessageCd(), "IWF0003", "ＱＲシール用紙作成用案件存在チェック:2");
    }

    @Test
    @TestOrder(30)
    public void testGetTasksForQrSeal_Case03(){
        IwfKouteiClientMock.mode = "10-03";
        GetTasksForQrSealResultBean ret = WorkFlowUtility.getTasksForQrSeal(
            null,
            new String[] {"12345678901","12345678902"},
            null);
        exStringEquals(ret.getSyousaiMessage(), "稼働時間外エラーか、認証エラーが発生しました。", "ＱＲシール用紙作成用案件存在チェック:3");
    }

    @Test
    @TestOrder(40)
    public void testGetTasksForQrSeal_Case04(){
        IwfKouteiClientMock.mode = "10-04";
        GetTasksForQrSealResultBean ret = WorkFlowUtility.getTasksForQrSeal(
            null,
            new String[] {"12345678901","12345678902"},
            null);
        exStringEquals(ret.getSyorikekkaStatus(), "9", "ＱＲシール用紙作成用案件存在チェック:4");
    }

    @Test
    @TestOrder(50)
    public void testGetTasksForQrSeal_Case05(){
        IwfKouteiClientMock.mode = "10-05";
        GetTasksForQrSealResultBean ret = WorkFlowUtility.getTasksForQrSeal(
            null,
            new String[] {"12345678901","12345678902"},
            null);
        exStringEquals(ret.getSyorikekkaStatus(), "-1", "ＱＲシール用紙作成用案件存在チェック:5");
    }

    @Test
    @TestOrder(60)
    public void testGetTasksForQrSeal_Case06(){
        IwfKouteiClientMock.mode = "10-06";
        GetTasksForQrSealResultBean ret = WorkFlowUtility.getTasksForQrSeal(
            null,
            new String[] {"12345678901","12345678902"},
            null);
        exStringEquals(ret.getTaskSummaryForQrSealBeanList().get(0).getSyoNo(), "SyoNo03", "ＱＲシール用紙作成用案件存在チェック:6-1");
        exStringEquals(ret.getTaskSummaryForQrSealBeanList().get(0).getNkSysyNo(), "NkSysyNo03", "ＱＲシール用紙作成用案件存在チェック:6-2");
        exStringEquals(ret.getTaskSummaryForQrSealBeanList().get(0).getKouteiKnrId(), "GyoumuKey03", "ＱＲシール用紙作成用案件存在チェック:6-3");
        exStringEquals(ret.getTaskSummaryForQrSealBeanList().get(1).getSyoNo(), "SyoNo02", "ＱＲシール用紙作成用案件存在チェック:6-4");
        exStringEquals(ret.getTaskSummaryForQrSealBeanList().get(1).getNkSysyNo(), "NkSysyNo02", "ＱＲシール用紙作成用案件存在チェック:6-5");
        exStringEquals(ret.getTaskSummaryForQrSealBeanList().get(1).getKouteiKnrId(), "GyoumuKey02", "ＱＲシール用紙作成用案件存在チェック:6-6");
    }

    @Test
    @TestOrder(70)
    public void testGetTasksForQrSeal_Case07(){
        IwfKouteiClientMock.mode = "10-07";
        GetTasksForQrSealResultBean ret = WorkFlowUtility.getTasksForQrSeal(
            null,
            new String[] {"12345678901","12345678902"},
            null);
        exStringEquals(ret.getSyorikekkaStatus(), "0", "ＱＲシール用紙作成用案件存在チェック:7");
    }

    @Test
    @TestOrder(80)
    public void testGetTasksForQrSeal_Case08(){
        IwfKouteiClientMock.mode = "10-08";
        GetTasksForQrSealResultBean ret = WorkFlowUtility.getTasksForQrSeal(
            new String[] {"12345678901","12345678902"},
            null,
            null);

        exStringEquals(ret.getTaskSummaryForQrSealBeanList().get(0).getMosNo(), "12345678901", "申込番号");
        exStringEquals(ret.getTaskSummaryForQrSealBeanList().get(0).getSyoNo(), "12345678901", "証券番号");
        exStringEquals(ret.getTaskSummaryForQrSealBeanList().get(0).getNkSysyNo(), "", "年金証書番号");
        exStringEquals(ret.getTaskSummaryForQrSealBeanList().get(0).getKouteiKnrId(), "", "工程管理ID");
        exStringEquals(ret.getTaskSummaryForQrSealBeanList().get(1).getMosNo(), "12345678902", "申込番号");
        exStringEquals(ret.getTaskSummaryForQrSealBeanList().get(1).getSyoNo(), "12345678902", "証券番号");
        exStringEquals(ret.getTaskSummaryForQrSealBeanList().get(1).getNkSysyNo(), "", "年金証書番号");
        exStringEquals(ret.getTaskSummaryForQrSealBeanList().get(1).getKouteiKnrId(), "", "工程管理ID");
    }

    @Test
    @TestOrder(90)
    public void testGetTasksForQrSeal_Case09(){
        IwfKouteiClientMock.mode = "10-09";
        GetTasksForQrSealResultBean ret = WorkFlowUtility.getTasksForQrSeal(
            null,
            new String[] {"12345678901","12345678902"},
            null);

        exStringEquals(ret.getTaskSummaryForQrSealBeanList().get(0).getMosNo(), "12345678903", "申込番号");
        exStringEquals(ret.getTaskSummaryForQrSealBeanList().get(0).getSyoNo(), "12345678901", "証券番号");
        exStringEquals(ret.getTaskSummaryForQrSealBeanList().get(0).getNkSysyNo(), "", "年金証書番号");
        exStringEquals(ret.getTaskSummaryForQrSealBeanList().get(0).getKouteiKnrId(), "", "工程管理ID");
        exStringEquals(ret.getTaskSummaryForQrSealBeanList().get(1).getMosNo(), "12345678903", "申込番号");
        exStringEquals(ret.getTaskSummaryForQrSealBeanList().get(1).getSyoNo(), "12345678902", "証券番号");
        exStringEquals(ret.getTaskSummaryForQrSealBeanList().get(1).getNkSysyNo(), "", "年金証書番号");
        exStringEquals(ret.getTaskSummaryForQrSealBeanList().get(1).getKouteiKnrId(), "", "工程管理ID");
    }
}