package yuyu.common.workflow.workflowutility;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.workflow.IwfKouteiClientMock;
import yuyu.def.db.entity.DM_Jimutetuzuki;
import yuyu.def.workflow.configuration.YuyuWorkflowConfig;
import yuyu.def.workflow.manager.WorkflowDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.TestOrder;

/**
 * ワークフロー呼出ユーティリティ(工程ワークリストタスク選択用実行可能タスク情報取得（新契約以外）)単体テストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class WorkFlowUtilityTest12 extends AbstractTest {

    private final static String fileName = "UT_SP_単体テスト仕様書_【12_工程ワークリストタスク選択用実行可能タスク情報取得（新契約以外）】";
    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(WorkFlowUtilityTest12.class, fileName, sheetName);
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

        DM_Jimutetuzuki data = workflowDomManager.getJimutetuzuki("0001", "nenkin");

        workflowDomManager.delete(data);

        data = workflowDomManager.getJimutetuzuki("0002", "nenkin");

        workflowDomManager.delete(data);

        data = workflowDomManager.getJimutetuzuki("0003", "nenkin");

        workflowDomManager.delete(data);

    }

    @After
    public void caseTerminat() {
    }

    @Test
    @TestOrder(10)
    public void testGetExecutableTasksForWorkList_Case1() {
        IwfKouteiClientMock.mode = "12-01";
        GetExecutableTasksForWorkListResultBean ret = WorkFlowUtility.getExecutableTasksForWorkList("nenkin",
            null,null, "0001", "0001",
            "20150101020304005", "20151231020304005", null, null,
            null);

        exStringEquals(ret.getSyorikekkaStatus(), WorkFlowResultConstants.RESULT_NG, "「実行可能タスク取得(工程指定)」サービス処理結果:1");
    }

    @Test
    @TestOrder(20)
    public void testGetExecutableTasksForWorkList_Case2() {
        IwfKouteiClientMock.mode = "12-02";
        GetExecutableTasksForWorkListResultBean ret = WorkFlowUtility.getExecutableTasksForWorkList("nenkin",
            null,null, "0001", "0001", "",
            "20151231020304005", null, null,
            "test");

        exStringEquals(ret.getSyorikekkaStatus(), WorkFlowResultConstants.RESULT_NODATA, "「実行可能タスク取得(工程指定)」サービス処理結果:2");
    }

    @Test
    @TestOrder(30)
    public void testGetExecutableTasksForWorkList_Case3() {
        IwfKouteiClientMock.mode = "12-03";
        GetExecutableTasksForWorkListResultBean ret = WorkFlowUtility.getExecutableTasksForWorkList("nenkin",
            null,null, "0001", "0001",
            "20150101020304005", "", null, null,
            null);

        exStringEquals(ret.getSyorikekkaStatus(), WorkFlowResultConstants.RESULT_NODATA, "「実行可能タスク取得(工程指定)」サービス処理結果:3");
    }

    @Test
    @TestOrder(40)
    public void testGetExecutableTasksForWorkList_Case4() {
        IwfKouteiClientMock.mode = "12-04";
        GetExecutableTasksForWorkListResultBean ret = WorkFlowUtility.getExecutableTasksForWorkList("nenkin",
            null,null, "0001", "0001",
            "20150101020304005", "20151231020304005", null, null,
            null);

        exStringEquals(ret.getSyousaiMessageCd(), "IWF0000", "「実行可能タスク取得(工程指定)」サービス処理結果:4");
    }

    @Test
    @TestOrder(50)
    public void testGetExecutableTasksForWorkList_Case5() {
        IwfKouteiClientMock.mode = "12-05";
        GetExecutableTasksForWorkListResultBean ret = WorkFlowUtility.getExecutableTasksForWorkList("nenkin",
            null,null, "0001", "0001",
            "20150101020304005", "20151231020304005", null, null,
            null);

        exStringEquals(ret.getSyousaiMessage(), "正常終了しました。", "「実行可能タスク取得(工程指定)」サービス処理結果:5");
    }

    @Test
    @TestOrder(60)
    public void testGetExecutableTasksForWorkList_Case6() {
        IwfKouteiClientMock.mode = "12-06";
        GetExecutableTasksForWorkListResultBean ret = WorkFlowUtility.getExecutableTasksForWorkList("nenkin",
            null,null, "0001", "0001",
            "20150101020304005", "20151231020304005", null, null,
            null);

        exStringEquals(ret.getSyorikekkaStatus(), WorkFlowResultConstants.RESULT_NG, "「実行可能タスク取得(工程指定)」サービス処理結果:6");
    }

    @Test
    @TestOrder(70)
    public void testGetExecutableTasksForWorkList_Case7() {
        IwfKouteiClientMock.mode = "12-07";
        GetExecutableTasksForWorkListResultBean ret = WorkFlowUtility.getExecutableTasksForWorkList("nenkin",
            null,null, "0001", "0001",
            "20150101020304005", "20151231020304005", null, null,
            null);

        exStringEquals(ret.getExecutableTaskInfoBeanList().get(0).getJimutetuzukiCd(), "0001", "「実行可能タスク取得(工程指定)」サービス処理結果:7-1");
        exStringEquals(ret.getExecutableTaskInfoBeanList().get(0).getJimutetuzukiNm(), "年金事務１", "「実行可能タスク取得(工程指定)」サービス処理結果:7-2");
        exStringEquals(ret.getExecutableTaskInfoBeanList().get(0).getTaskNm(), "Task01", "「実行可能タスク取得(工程指定)」サービス処理結果:7-3");
        exStringEquals(ret.getExecutableTaskInfoBeanList().get(0).getDispTaskNm(), "年金事務１タスク１", "「実行可能タスク取得(工程指定)」サービス処理結果:7-4");
        exStringEquals(ret.getExecutableTaskInfoBeanList().get(0).getPersonalizedTaskNum().toString(), "1", "「実行可能タスク取得(工程指定)」サービス処理結果:7-5");
        exStringEquals(ret.getExecutableTaskInfoBeanList().get(0).getSharedTaskNum().toString(), "1", "「実行可能タスク取得(工程指定)」サービス処理結果:7-6");
        exStringEquals(ret.getExecutableTaskInfoBeanList().get(0).getJimutetuzukiDispOrder().toString(), "1", "「実行可能タスク取得(工程指定)」サービス処理結果:7-7");
        exStringEquals(ret.getExecutableTaskInfoBeanList().get(0).getTskDispOrder().toString(), "1", "「実行可能タスク取得(工程指定)」サービス処理結果:7-8");

        exStringEquals(ret.getExecutableTaskInfoBeanList().get(1).getJimutetuzukiCd(), "0002", "「実行可能タスク取得(工程指定)」サービス処理結果:7-9");
        exStringEquals(ret.getExecutableTaskInfoBeanList().get(1).getJimutetuzukiNm(), "年金事務２", "「実行可能タスク取得(工程指定)」サービス処理結果:7-10");
        exStringEquals(ret.getExecutableTaskInfoBeanList().get(1).getTaskNm(), "Task02", "「実行可能タスク取得(工程指定)」サービス処理結果:7-11");
        exStringEquals(ret.getExecutableTaskInfoBeanList().get(1).getDispTaskNm(), "年金事務２タスク１", "「実行可能タスク取得(工程指定)」サービス処理結果:7-12");
        exStringEquals(ret.getExecutableTaskInfoBeanList().get(1).getPersonalizedTaskNum().toString(), "1", "「実行可能タスク取得(工程指定)」サービス処理結果:7-13");
        exStringEquals(ret.getExecutableTaskInfoBeanList().get(1).getSharedTaskNum().toString(), "1", "「実行可能タスク取得(工程指定)」サービス処理結果:7-14");
        exStringEquals(ret.getExecutableTaskInfoBeanList().get(1).getJimutetuzukiDispOrder().toString(), "2", "「実行可能タスク取得(工程指定)」サービス処理結果:7-15");
        exStringEquals(ret.getExecutableTaskInfoBeanList().get(1).getTskDispOrder().toString(), "2", "「実行可能タスク取得(工程指定)」サービス処理結果:7-16");

        exStringEquals(ret.getExecutableTaskInfoBeanList().get(2).getJimutetuzukiCd(), "0003", "「実行可能タスク取得(工程指定)」サービス処理結果:9-17");
        exStringEquals(ret.getExecutableTaskInfoBeanList().get(2).getJimutetuzukiNm(), "年金事務３", "「実行可能タスク取得(工程指定)」サービス処理結果:9-18");
        exStringEquals(ret.getExecutableTaskInfoBeanList().get(2).getTaskNm(), "Task03", "「実行可能タスク取得(工程指定)」サービス処理結果:9-19");
        exStringEquals(ret.getExecutableTaskInfoBeanList().get(2).getDispTaskNm(), "年金事務３タスク１", "「実行可能タスク取得(工程指定)」サービス処理結果:9-20");
        exStringEquals(ret.getExecutableTaskInfoBeanList().get(2).getPersonalizedTaskNum().toString(), "1", "「実行可能タスク取得(工程指定)」サービス処理結果:9-21");
        exStringEquals(ret.getExecutableTaskInfoBeanList().get(2).getSharedTaskNum().toString(), "1", "「実行可能タスク取得(工程指定)」サービス処理結果:9-22");
        exStringEquals(ret.getExecutableTaskInfoBeanList().get(2).getJimutetuzukiDispOrder().toString(), "3", "「実行可能タスク取得(工程指定)」サービス処理結果:9-23");
        exStringEquals(ret.getExecutableTaskInfoBeanList().get(2).getTskDispOrder().toString(), "3", "「実行可能タスク取得(工程指定)」サービス処理結果:9-24");
    }

    @Test
    @TestOrder(80)
    public void testGetExecutableTasksForWorkList_Case8() {
        IwfKouteiClientMock.mode = "12-08";
        GetExecutableTasksForWorkListResultBean ret = WorkFlowUtility.getExecutableTasksForWorkList("nenkin",
            null,null, "0001", "0001",
            "20150101020304005", "20151231020304005", null, null,
            null);

        exStringEquals(ret.getSyorikekkaStatus(), WorkFlowResultConstants.RESULT_OK, "「実行可能タスク取得(工程指定)」サービス処理結果:8");
    }

    @Test
    @TestOrder(90)
    public void testGetExecutableTasksForWorkList_Case9() {
        IwfKouteiClientMock.mode = "12-09";
        GetExecutableTasksForWorkListResultBean ret = WorkFlowUtility.getExecutableTasksForWorkList("nenkin",
            null,null, "0001", "0001",
            "20150101020304005", "20151231020304005", null, null,
            null);

        exStringEquals(ret.getSyorikekkaStatus(), WorkFlowResultConstants.RESULT_NODATA, "「実行可能タスク取得(工程指定)」サービス処理結果:9");
    }

    @Test
    @TestOrder(100)
    public void testGetExecutableTasksForWorkList_Case10() {
        IwfKouteiClientMock.mode = "12-10";
        GetExecutableTasksForWorkListResultBean ret = WorkFlowUtility.getExecutableTasksForWorkList("nenkin",
            null,null, "0001", "0001",
            "20150101020304005", "20151231020304005", null, null,
            null);

        exStringEquals(ret.getSyorikekkaStatus(), WorkFlowResultConstants.RESULT_OK, "「実行可能タスク取得(工程指定)」サービス処理結果:10");
    }

    @Test
    @TestOrder(110)
    public void testGetExecutableTasksForWorkList_Case11() {
        IwfKouteiClientMock.mode = "12-11";
        GetExecutableTasksForWorkListResultBean ret = WorkFlowUtility.getExecutableTasksForWorkList(
            "nenkin",
            "0001",
            "",
            "",
            "0001",
            "20150101020304005",
            "20151231020304005",
            "",
            "0",
            "");

        exStringEquals(ret.getExecutableTaskInfoBeanList().get(0).getJimutetuzukiCd(), "0001", "事務手続コード");
        exStringEquals(ret.getExecutableTaskInfoBeanList().get(0).getJimutetuzukiNm(), "年金事務１", "事務手続名");
        exStringEquals(ret.getExecutableTaskInfoBeanList().get(0).getTaskNm(), "Task01", "タスク名");
        exStringEquals(ret.getExecutableTaskInfoBeanList().get(0).getDispTaskNm(), "年金事務１タスク１", "(表示用）タスク名");
        exBizCalcbleEquals(ret.getExecutableTaskInfoBeanList().get(0).getSharedTaskNum(), BizNumber.valueOf(10), "共有タスク数");
        exBizCalcbleEquals(ret.getExecutableTaskInfoBeanList().get(0).getPersonalizedTaskNum(), BizNumber.valueOf(5), "個人タスク数");
        exNumericEquals(ret.getExecutableTaskInfoBeanList().get(0).getJimutetuzukiDispOrder(), 1, "事務手続表示順");
        exNumericEquals(ret.getExecutableTaskInfoBeanList().get(0).getTskDispOrder(), 1, "タスク表示順");
    }

    @Test
    @TestOrder(120)
    public void testGetExecutableTasksForWorkList_Case12() {
        IwfKouteiClientMock.mode = "12-12";
        GetExecutableTasksForWorkListResultBean ret = WorkFlowUtility.getExecutableTasksForWorkList(
            "nenkin",
            "",
            "",
            "0001",
            "0001",
            "20150101020304005",
            "20151231020304005",
            "",
            "",
            "");

        exStringEquals(ret.getExecutableTaskInfoBeanList().get(0).getJimutetuzukiCd(), "0001", "事務手続コード");
        exStringEquals(ret.getExecutableTaskInfoBeanList().get(0).getJimutetuzukiNm(), "年金事務１", "事務手続名");
        exStringEquals(ret.getExecutableTaskInfoBeanList().get(0).getTaskNm(), "Task01", "タスク名");
        exStringEquals(ret.getExecutableTaskInfoBeanList().get(0).getDispTaskNm(), "年金事務１タスク１", "(表示用）タスク名");
        exBizCalcbleEquals(ret.getExecutableTaskInfoBeanList().get(0).getSharedTaskNum(), BizNumber.valueOf(10), "共有タスク数");
        exBizCalcbleEquals(ret.getExecutableTaskInfoBeanList().get(0).getPersonalizedTaskNum(), BizNumber.valueOf(5), "個人タスク数");
        exNumericEquals(ret.getExecutableTaskInfoBeanList().get(0).getJimutetuzukiDispOrder(), 1, "事務手続表示順");
        exNumericEquals(ret.getExecutableTaskInfoBeanList().get(0).getTskDispOrder(), 1, "タスク表示順");
    }
}
