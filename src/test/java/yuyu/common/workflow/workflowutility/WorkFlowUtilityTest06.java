package yuyu.common.workflow.workflowutility;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.workflow.IwfKouteiClientMock;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.workflow.configuration.YuyuWorkflowConfig;
import yuyu.def.workflow.manager.WorkflowDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.TestOrder;

/**
 * ワークフロー呼出ユーティリティ(取消対象工程リスト取得)単体テストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class WorkFlowUtilityTest06 extends AbstractTest {

    private final static String fileName = "UT_SP_単体テスト仕様書_【06_取消対象工程リスト取得】";
    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(WorkFlowUtilityTest06.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);

        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @Before
    public void caseInit() {
        IwfKouteiClientMock.caller = "Test";
        YuyuWorkflowConfig config = YuyuWorkflowConfig.getInstance();
        config.setWorkflowStubMode(false);
    }

    @AfterClass
    public static void testClear() {
        IwfKouteiClientMock.caller = null;
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        WorkflowDomManager workflowDomManager = SWAKInjector.getInstance(WorkflowDomManager.class);
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        workflowDomManager.delete(workflowDomManager.getAllJimutetuzuki());
        baseDomManager.delete(baseDomManager.getAllUsers());
    }

    @After
    public void caseTerminat() {
    }

    @Test
    @TestOrder(10)
    public void testGetTasksForCancel_Case01() {

        IwfKouteiClientMock.mode = "06-01";

        GetTasksForCancelResultBean ret = WorkFlowUtility.getTasksForCancel(
            "common",
            "12806345672",
            "12806345672",
            "12806345672",
            "0001");

        exStringEquals(ret.getSyousaiMessageCd(), "IWF0003", "出力パラメータの詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), "稼働時間外エラーか、認証エラーが発生しました。", "出力パラメータの詳細メッセージ");
        exStringEquals(ret.getSyorikekkaStatus(), WorkFlowResultConstants.RESULT_NG, "出力パラメータの処理結果ステータス");
    }

    @Test
    @TestOrder(20)
    public void testGetTasksForCancel_Case02() {

        IwfKouteiClientMock.mode = "06-02";

        GetTasksForCancelResultBean ret = WorkFlowUtility.getTasksForCancel("","", "", "", "");

        exStringEquals(ret.getSyousaiMessageCd(), "IWF0000", "出力パラメータの詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), "正常終了しました。", "出力パラメータの詳細メッセージ");
        exStringEquals(ret.getSyorikekkaStatus(), WorkFlowResultConstants.RESULT_NODATA, "出力パラメータの処理結果ステータス");
    }

    @Test
    @TestOrder(30)
    public void testGetTasksForCancel_Case03() {

        IwfKouteiClientMock.mode = "06-03";

        GetTasksForCancelResultBean ret = WorkFlowUtility.getTasksForCancel(
            "common",
            "12806345672",
            "12806345672",
            "12806345672",
            "0001");

        exStringEquals(ret.getSyousaiMessageCd(), "IWF0000", "出力パラメータの詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), "正常終了しました。", "出力パラメータの詳細メッセージ");
        exStringEquals(ret.getSyorikekkaStatus(), WorkFlowResultConstants.RESULT_NODATA, "出力パラメータの処理結果ステータス");
    }

    @Test
    @TestOrder(40)
    public void testGetTasksForCancel_Case04() {

        IwfKouteiClientMock.mode = "06-04";

        GetTasksForCancelResultBean ret = WorkFlowUtility.getTasksForCancel(
            "common",
            "12806345672",
            "12806345672",
            "12806345672",
            "0004");

        exStringEquals(ret.getTaskForCancelBeanList().get(0).getJimutetuzukiCd(), "0004", "事務手続コード");
        exStringEquals(ret.getTaskForCancelBeanList().get(0).getJimutetuzukiNm(), null, "事務手続名");
        exStringEquals(ret.getTaskForCancelBeanList().get(0).getMosNo(), "12806345672", "申込番号");
        exStringEquals(ret.getTaskForCancelBeanList().get(0).getSyoNo(), "12806345672", "証券番号");
        exStringEquals(ret.getTaskForCancelBeanList().get(0).getNkSysyNo(), "12806345672", "年金証書番号");
        exStringEquals(ret.getTaskForCancelBeanList().get(0).getKouteiKnrId(), "101", "工程管理ID");
        exStringEquals(ret.getTaskForCancelBeanList().get(0).getJimuStartYmd(), null, "事務開始年月日");
        exStringEquals(ret.getTaskForCancelBeanList().get(0).getKouteiKaisiYmd(), "20150701", "工程開始年月日");
        exStringEquals(ret.getTaskForCancelBeanList().get(0).getKouteiStatus(), "10", "工程状態");
        exStringEquals(ret.getTaskForCancelBeanList().get(0).getDispKouteiStatus(), "処理中", "(表示用)工程状態");
        exStringEquals(ret.getTaskForCancelBeanList().get(0).getTantouId(), "UserId04", "担当者ID");
        exStringEquals(ret.getTaskForCancelBeanList().get(0).getDispTantouNm(), null, "(表示用)担当者名");
    }

    @Test
    @TestOrder(50)
    public void testGetTasksForCancel_Case05() {

        IwfKouteiClientMock.mode = "06-05";

        GetTasksForCancelResultBean ret = WorkFlowUtility.getTasksForCancel(
            "common",
            "12806345672",
            "12806345672",
            "12806345672",
            "0001");

        exStringEquals(ret.getTaskForCancelBeanList().get(0).getJimutetuzukiCd(), "0001", "事務手続コード");
        exStringEquals(ret.getTaskForCancelBeanList().get(0).getJimutetuzukiNm(), "事務手続名１", "事務手続名");
        exStringEquals(ret.getTaskForCancelBeanList().get(0).getMosNo(), "12806345672", "申込番号");
        exStringEquals(ret.getTaskForCancelBeanList().get(0).getSyoNo(), "12806345672", "証券番号");
        exStringEquals(ret.getTaskForCancelBeanList().get(0).getNkSysyNo(), "12806345672", "年金証書番号");
        exStringEquals(ret.getTaskForCancelBeanList().get(0).getKouteiKnrId(), "101", "工程管理ID");
        exStringEquals(ret.getTaskForCancelBeanList().get(0).getJimuStartYmd(), null, "事務開始年月日");
        exStringEquals(ret.getTaskForCancelBeanList().get(0).getKouteiKaisiYmd(), "20150701", "工程開始年月日");
        exStringEquals(ret.getTaskForCancelBeanList().get(0).getKouteiStatus(), "10", "工程状態");
        exStringEquals(ret.getTaskForCancelBeanList().get(0).getDispKouteiStatus(), "処理中", "(表示用)工程状態");
        exStringEquals(ret.getTaskForCancelBeanList().get(0).getTantouId(), "UserId01", "担当者ID");
        exStringEquals(ret.getTaskForCancelBeanList().get(0).getDispTantouNm(), "担当者名１", "(表示用)担当者名");
        exStringEquals(ret.getTaskForCancelBeanList().get(1).getJimutetuzukiCd(), "0002", "事務手続コード");
        exStringEquals(ret.getTaskForCancelBeanList().get(1).getJimutetuzukiNm(), null, "事務手続名");
        exStringEquals(ret.getTaskForCancelBeanList().get(1).getMosNo(), "12806345683", "申込番号");
        exStringEquals(ret.getTaskForCancelBeanList().get(1).getSyoNo(), "12806345683", "証券番号");
        exStringEquals(ret.getTaskForCancelBeanList().get(1).getNkSysyNo(), "12806345683", "年金証書番号");
        exStringEquals(ret.getTaskForCancelBeanList().get(1).getKouteiKnrId(), "102", "工程管理ID");
        exStringEquals(ret.getTaskForCancelBeanList().get(1).getJimuStartYmd(), null, "事務開始年月日");
        exStringEquals(ret.getTaskForCancelBeanList().get(1).getKouteiKaisiYmd(), "20150702", "工程開始年月日");
        exStringEquals(ret.getTaskForCancelBeanList().get(1).getKouteiStatus(), "10", "工程状態");
        exStringEquals(ret.getTaskForCancelBeanList().get(1).getDispKouteiStatus(), "処理中", "(表示用)工程状態");
        exStringEquals(ret.getTaskForCancelBeanList().get(1).getTantouId(), "UserId02", "担当者ID");
        exStringEquals(ret.getTaskForCancelBeanList().get(1).getDispTantouNm(), "担当者名２", "(表示用)担当者名");
        exStringEquals(ret.getTaskForCancelBeanList().get(2).getJimutetuzukiCd(), "0003", "事務手続コード");
        exStringEquals(ret.getTaskForCancelBeanList().get(2).getJimutetuzukiNm(), null, "事務手続名");
        exStringEquals(ret.getTaskForCancelBeanList().get(2).getMosNo(), "12806345694", "申込番号");
        exStringEquals(ret.getTaskForCancelBeanList().get(2).getSyoNo(), "12806345694", "証券番号");
        exStringEquals(ret.getTaskForCancelBeanList().get(2).getNkSysyNo(), "12806345694", "年金証書番号");
        exStringEquals(ret.getTaskForCancelBeanList().get(2).getKouteiKnrId(), "103", "工程管理ID");
        exStringEquals(ret.getTaskForCancelBeanList().get(2).getJimuStartYmd(), null, "事務開始年月日");
        exStringEquals(ret.getTaskForCancelBeanList().get(2).getKouteiKaisiYmd(), "20150703", "工程開始年月日");
        exStringEquals(ret.getTaskForCancelBeanList().get(2).getKouteiStatus(), "10", "工程状態");
        exStringEquals(ret.getTaskForCancelBeanList().get(2).getDispKouteiStatus(), "処理中", "(表示用)工程状態");
        exStringEquals(ret.getTaskForCancelBeanList().get(2).getTantouId(), "UserId03", "担当者ID");
        exStringEquals(ret.getTaskForCancelBeanList().get(2).getDispTantouNm(), "担当者名３", "(表示用)担当者名");
    }

}
