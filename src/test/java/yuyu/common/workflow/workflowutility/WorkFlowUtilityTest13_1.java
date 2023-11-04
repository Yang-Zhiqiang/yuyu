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
import yuyu.def.workflowcore.manager.IwfCoreDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.TestOrder;

/**
 * ワークフロー呼出ユーティリティ(工程ワークリスト一覧表示用リスト取得（新契約）)単体テストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class WorkFlowUtilityTest13_1 extends AbstractTest {

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_【13_工程ワークリスト一覧表示用リスト取得（新契約）】_000_01";
    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(WorkFlowUtilityTest13_1.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);

        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @Before
    public void caseInit() {
    }

    @AfterClass
    public static void testClear() {
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        IwfCoreDomManager iwfCoreDomManager = SWAKInjector.getInstance(IwfCoreDomManager.class);

        iwfCoreDomManager.delete(iwfCoreDomManager.getAllKouteiSummary());

    }

    @After
    public void caseTerminat() {
    }

    @Test
    @TestOrder(10)
    public void testGetTasksForWorkListSk_A01() {
        GetTasksForWorkListSkResultBean ret = WorkFlowUtility.getTasksForWorkListSk(
                "sinkeiyaku",
                null,
                null,
                null,
                "skinputmos",
                null,
                null,
                null,
                null,
                null,
                "1",
                "56550502",
                "1",
                "mousikomisyo_1ji",
                null,
                null,
                null,
                null,
                null,
                null);

        List<TaskSummaryForWorkListBean> resultBeanLst = ret.getTaskSummaryForWorkListBeanList();
        exNumericEquals(resultBeanLst.size(), 1000, "タスクサマリBeanリスト件数");

        exStringEquals(ret.getSyorikekkaStatus(), WorkFlowResultConstants.RESULT_OK, "処理結果ステータス");
    }

    @Test
    @TestOrder(20)
    public void testGetTasksForWorkListSk_A02() {
        GetTasksForWorkListSkResultBean ret = WorkFlowUtility.getTasksForWorkListSk(
                "sinkeiyaku",
                null,
                null,
                null,
                "sktenken",
                null,
                null,
                null,
                null,
                null,
                "1",
                "56550502",
                "1",
                "mostenken_1ji",
                null,
                null,
                null,
                null,
                null,
                null);

        List<TaskSummaryForWorkListBean> resultBeanLst = ret.getTaskSummaryForWorkListBeanList();
        exNumericEquals(resultBeanLst.size(), 1000, "タスクサマリBeanリスト件数");

        exStringEquals(ret.getSyorikekkaStatus(), WorkFlowResultConstants.RESULT_OK, "処理結果ステータス");
    }

    @Test
    @TestOrder(30)
    public void testGetTasksForWorkListSk_A03() {
        GetTasksForWorkListSkResultBean ret = WorkFlowUtility.getTasksForWorkListSk(
                "sinkeiyaku",
                null,
                null,
                null,
                "skhubitouroku",
                null,
                null,
                null,
                null,
                null,
                "1",
                "56550502",
                "1",
                "hubitouroku",
                null,
                null,
                null,
                null,
                null,
                null);

        List<TaskSummaryForWorkListBean> resultBeanLst = ret.getTaskSummaryForWorkListBeanList();
        exNumericEquals(resultBeanLst.size(), 0, "タスクサマリBeanリスト件数");

        exStringEquals(ret.getSyorikekkaStatus(), WorkFlowResultConstants.RESULT_NG, "処理結果ステータス");
    }

    @Test
    @TestOrder(40)
    public void testGetTasksForWorkListSk_A04() {
        GetTasksForWorkListSkResultBean ret = WorkFlowUtility.getTasksForWorkListSk(
                "sinkeiyaku",
                null,
                null,
                null,
                "skkankyou",
                null,
                null,
                null,
                null,
                null,
                "1",
                "56550502",
                "1",
                "kankyousatei_1ji",
                null,
                null,
                null,
                null,
                null,
                null);

        List<TaskSummaryForWorkListBean> resultBeanLst = ret.getTaskSummaryForWorkListBeanList();
        exNumericEquals(resultBeanLst.size(), 999, "タスクサマリBeanリスト件数");

        exStringEquals(ret.getSyorikekkaStatus(), WorkFlowResultConstants.RESULT_OK, "処理結果ステータス");
    }

    @Test
    @TestOrder(50)
    public void testGetTasksForWorkListSk_A05() {
        GetTasksForWorkListSkResultBean ret = WorkFlowUtility.getTasksForWorkListSk(
                "sinkeiyaku",
                null,
                null,
                null,
                "skimu",
                null,
                null,
                null,
                null,
                null,
                "1",
                "56550502",
                "1",
                "imusatei_kani_uw",
                null,
                null,
                null,
                null,
                null,
                null);

        List<TaskSummaryForWorkListBean> resultBeanLst = ret.getTaskSummaryForWorkListBeanList();
        exNumericEquals(resultBeanLst.size(), 1000, "タスクサマリBeanリスト件数");

        exStringEquals(ret.getSyorikekkaStatus(), WorkFlowResultConstants.RESULT_OK, "処理結果ステータス");
    }

    @Test
    @TestOrder(60)
    public void testGetTasksForWorkListSk_A06() {
        GetTasksForWorkListSkResultBean ret = WorkFlowUtility.getTasksForWorkListSk(
                "sinkeiyaku",
                null,
                null,
                null,
                "skmaindairiten",
                null,
                null,
                null,
                null,
                null,
                "1",
                "56550502",
                "1",
                "state-syoruinyuuryoku",
                null,
                null,
                null,
                null,
                null,
                null);

        List<TaskSummaryForWorkListBean> resultBeanLst = ret.getTaskSummaryForWorkListBeanList();
        exNumericEquals(resultBeanLst.size(), 3, "タスクサマリBeanリスト件数");

        exStringEquals(resultBeanLst.get(0).getJimutetuzukiCd(), "skmaindairiten", "事務手続コード");
        exStringEquals(resultBeanLst.get(0).getKouteiKnrId(), "0142md9phcdk19111", "工程管理ID");
        exStringEquals(resultBeanLst.get(0).getMosNo(), "860011000", "申込番号");
        exStringEquals(resultBeanLst.get(0).getJimuStartYmd(), "20210129153540200", "事務開始年月日");
        exStringEquals(resultBeanLst.get(1).getJimutetuzukiCd(), "skmaindairiten", "事務手続コード");
        exStringEquals(resultBeanLst.get(1).getKouteiKnrId(), "0142md9phcdk19110", "工程管理ID");
        exStringEquals(resultBeanLst.get(1).getMosNo(), "860010999", "申込番号");
        exStringEquals(resultBeanLst.get(1).getJimuStartYmd(), "20210129153540300", "事務開始年月日");
        exStringEquals(resultBeanLst.get(2).getJimutetuzukiCd(), "skmaindairiten", "事務手続コード");
        exStringEquals(resultBeanLst.get(2).getKouteiKnrId(), "0142md9phcdk19109", "工程管理ID");
        exStringEquals(resultBeanLst.get(2).getMosNo(), "860010998", "申込番号");
        exStringEquals(resultBeanLst.get(2).getJimuStartYmd(), "20210129153540400", "事務開始年月日");

        exStringEquals(ret.getSyorikekkaStatus(), WorkFlowResultConstants.RESULT_OK, "処理結果ステータス");
    }
}
