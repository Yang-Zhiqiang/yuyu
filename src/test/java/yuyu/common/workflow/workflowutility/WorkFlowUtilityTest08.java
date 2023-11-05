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
import yuyu.common.biz.workflow.IwfImageClientMock;
import yuyu.common.biz.workflow.IwfKouteiClientMock;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.workflow.configuration.YuyuWorkflowConfig;
import yuyu.def.workflow.manager.WorkflowDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.TestOrder;

/**
 * ワークフロー呼出ユーティリティ(取込用表紙作成対象リスト取得)単体テストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class WorkFlowUtilityTest08 extends AbstractTest {

    private final static String fileName = "UT_SP_単体テスト仕様書_【08_取込用表紙作成対象リスト取得】";
    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(WorkFlowUtilityTest08.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);

        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @Before
    public void caseInit() {
        IwfKouteiClientMock.caller = "Test";
        IwfImageClientMock.caller = "Test";
        YuyuWorkflowConfig config = YuyuWorkflowConfig.getInstance();
        config.setWorkflowStubMode(false);
    }

    @AfterClass
    public static void testClear() {
        IwfKouteiClientMock.caller = null;
        IwfImageClientMock.caller = null;
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        WorkflowDomManager workflowDomManager = SWAKInjector.getInstance(WorkflowDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        workflowDomManager.delete(workflowDomManager.getAllJimutetuzuki());
        bizDomManager.delete(bizDomManager.getAllTorikomiSyoruiHukaInfo());
    }

    @After
    public void caseTerminat() {
    }

    @Test
    @TestOrder(10)
    public void testGetTasksForHyousi_Case01() {

        IwfKouteiClientMock.mode = "08-01";
        IwfImageClientMock.mode = "08-01";

        GetTasksForHyousiResultBean ret = WorkFlowUtility.getTasksForHyousi(
            "common",
            "0001",
            null,
            null,
            null,
            null);

        exStringEquals(ret.getSyorikekkaStatus(), "9", "出力パラメータの処理結果ステータス");
    }

    @Test
    @TestOrder(20)
    public void testGetTasksForHyousi_Case02() {

        IwfKouteiClientMock.mode = "08-02";
        IwfImageClientMock.mode = "08-02";

        GetTasksForHyousiResultBean ret = WorkFlowUtility.getTasksForHyousi(
            "common",
            "0001",
            "12806345672",
            "12806345672",
            "12806345672",
            null);

        exStringEquals(ret.getSyorikekkaStatus(), "-1", "出力パラメータの処理結果ステータス");
    }

    @Test
    @TestOrder(30)
    public void testGetTasksForHyousi_Case03() {

        IwfKouteiClientMock.mode = "08-03";
        IwfImageClientMock.mode = "08-03";

        GetTasksForHyousiResultBean ret = WorkFlowUtility.getTasksForHyousi(
            "common",
            "0001",
            null,
            null,
            null,
            null);

        exStringEquals(ret.getSyousaiMessageCd(), "IWF0003", "出力パラメータの詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), "稼働時間外エラーか、認証エラーが発生しました。", "出力パラメータの詳細メッセージ");
        exStringEquals(ret.getSyorikekkaStatus(), "9", "出力パラメータの処理結果ステータス");
    }

    @Test
    @TestOrder(40)
    public void testGetTasksForHyousi_Case04() {

        IwfKouteiClientMock.mode = "08-04";
        IwfImageClientMock.mode = "08-04";

        GetTasksForHyousiResultBean ret = WorkFlowUtility.getTasksForHyousi(
            "common",
            "0001",
            null,
            null,
            null,
            null);

        exStringEquals(ret.getSyousaiMessageCd(), "IWF0000", "出力パラメータの詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), "正常終了しました。", "出力パラメータの詳細メッセージ");
        exStringEquals(ret.getSyorikekkaStatus(), "-1", "出力パラメータの処理結果ステータス");
    }

    @Test
    @TestOrder(50)
    public void testGetTasksForHyousi_Case05() {

        IwfKouteiClientMock.mode = "08-05";
        IwfImageClientMock.mode = "08-05";

        GetTasksForHyousiResultBean ret = WorkFlowUtility.getTasksForHyousi(
            "common",
            "0001",
            null,
            null,
            null,
            null);

        exStringEquals(ret.getTaskSummaryForHyousiBeanList().get(0).getMosNo(), "12806345672", "申込番号");
        exStringEquals(ret.getTaskSummaryForHyousiBeanList().get(0).getSyoNo(), "12806345672", "証券番号");
        exStringEquals(ret.getTaskSummaryForHyousiBeanList().get(0).getNkSysyNo(), "12806345672", "年金証書番号");
        exStringEquals(ret.getTaskSummaryForHyousiBeanList().get(0).getKouteiKnrId(), "101", "工程管理ID");
        exStringEquals(ret.getTaskSummaryForHyousiBeanList().get(0).getJimuStartYmd().substring(0, 8), "20150716", "事務開始年月日");
        exStringEquals(ret.getTaskSummaryForHyousiBeanList().get(0).getKouteiKaisiYmd().substring(0, 8), "20150703", "工程開始年月日");
        exStringEquals(ret.getTaskSummaryForHyousiBeanList().get(0).getKouteiKanryouYmd(), "20150703", "工程完了年月日");
        exStringEquals(ret.getTaskSummaryForHyousiBeanList().get(0).getKouteiStatus(), "10", "工程状態");
        exStringEquals(ret.getTaskSummaryForHyousiBeanList().get(0).getDispKouteiStatus(), "処理中", "（表示用）工程状態");
        exStringEquals(ret.getTaskSummaryForHyousiBeanList().get(0).getJimutetuzukiCd(), "0001", "事務手続コード");
        exStringEquals(ret.getTaskSummaryForHyousiBeanList().get(0).getJimutetuzukiNm(), "事務手続名１", "事務手続名");

        exStringEquals(ret.getTaskSummaryForHyousiBeanList().get(1).getMosNo(), "12806345683", "申込番号");
        exStringEquals(ret.getTaskSummaryForHyousiBeanList().get(1).getSyoNo(), "12806345683", "証券番号");
        exStringEquals(ret.getTaskSummaryForHyousiBeanList().get(1).getNkSysyNo(), "12806345683", "年金証書番号");
        exStringEquals(ret.getTaskSummaryForHyousiBeanList().get(1).getKouteiKnrId(), "102", "工程管理ID");
        exStringEquals(ret.getTaskSummaryForHyousiBeanList().get(1).getJimuStartYmd().substring(0, 8), "20150716", "事務開始年月日");
        exStringEquals(ret.getTaskSummaryForHyousiBeanList().get(1).getKouteiKaisiYmd().substring(0, 8), "20150702", "工程開始年月日");
        exStringEquals(ret.getTaskSummaryForHyousiBeanList().get(1).getKouteiKanryouYmd(), "20150702", "工程完了年月日");
        exStringEquals(ret.getTaskSummaryForHyousiBeanList().get(1).getKouteiStatus(), "10", "工程状態");
        exStringEquals(ret.getTaskSummaryForHyousiBeanList().get(1).getDispKouteiStatus(), "処理中", "（表示用）工程状態");
        exStringEquals(ret.getTaskSummaryForHyousiBeanList().get(1).getJimutetuzukiCd(), "0002", "事務手続コード");
        exStringEquals(ret.getTaskSummaryForHyousiBeanList().get(1).getJimutetuzukiNm(), "事務手続名２", "事務手続名");

        exStringEquals(ret.getTaskSummaryForHyousiBeanList().get(2).getMosNo(), "12806345694", "申込番号");
        exStringEquals(ret.getTaskSummaryForHyousiBeanList().get(2).getSyoNo(), "12806345694", "証券番号");
        exStringEquals(ret.getTaskSummaryForHyousiBeanList().get(2).getNkSysyNo(), "12806345694", "年金証書番号");
        exStringEquals(ret.getTaskSummaryForHyousiBeanList().get(2).getKouteiKnrId(), "103", "工程管理ID");
        exStringEquals(ret.getTaskSummaryForHyousiBeanList().get(2).getJimuStartYmd().substring(0, 8), "20150716", "事務開始年月日");
        exStringEquals(ret.getTaskSummaryForHyousiBeanList().get(2).getKouteiKaisiYmd().substring(0, 8), "20150701", "工程開始年月日");
        exStringEquals(ret.getTaskSummaryForHyousiBeanList().get(2).getKouteiKanryouYmd(), "20150701", "工程完了年月日");
        exStringEquals(ret.getTaskSummaryForHyousiBeanList().get(2).getKouteiStatus(), "10", "工程状態");
        exStringEquals(ret.getTaskSummaryForHyousiBeanList().get(2).getDispKouteiStatus(), "処理中", "（表示用）工程状態");
        exStringEquals(ret.getTaskSummaryForHyousiBeanList().get(2).getJimutetuzukiCd(), "0003", "事務手続コード");
        exStringEquals(ret.getTaskSummaryForHyousiBeanList().get(2).getJimutetuzukiNm(), "事務手続名３", "事務手続名");
    }

}