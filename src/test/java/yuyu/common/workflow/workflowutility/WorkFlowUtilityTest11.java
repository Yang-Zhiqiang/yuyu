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
 * ワークフロー呼出ユーティリティ(工程ワークリストタスク選択用実行可能タスク情報取得（新契約）)単体テストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class WorkFlowUtilityTest11 extends AbstractTest {

    private final static String fileName = "UT_SP_単体テスト仕様書_【11_工程ワークリストタスク選択用実行可能タスク情報取得（新契約）】_000_01";
    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(WorkFlowUtilityTest11.class, fileName, sheetName);
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

        DM_Jimutetuzuki data = workflowDomManager.getJimutetuzuki("Id01", "sinkeiyaku");

        workflowDomManager.delete(data);

        data = workflowDomManager.getJimutetuzuki("Id02", "sinkeiyaku");

        workflowDomManager.delete(data);

        data = workflowDomManager.getJimutetuzuki("Id03", "sinkeiyaku");

        workflowDomManager.delete(data);

    }

    @After
    public void caseTerminat() {
    }

    @Test
    @TestOrder(10)
    public void testGetExecutableTasksForWorkListSk_Case1() {
        IwfKouteiClientMock.mode = "11-01";
        GetExecutableTasksForWorkListSkResultBean ret = WorkFlowUtility.getExecutableTasksForWorkListSk("sinkeiyaku"
            , null
            , "0001",
            null
            , "0001"
            , "20150101020304005", "20151231020304005", "20150101020304005", "20151231020304005",
            null, null, null, null, null, null, null, null,
            null, null);

        exStringEquals(ret.getSyorikekkaStatus(), WorkFlowResultConstants.RESULT_NG, "「実行可能タスク取得(工程指定)」サービス処理結果:1");
    }

    @Test
    @TestOrder(20)
    public void testGetExecutableTasksForWorkListSk_Case2() {
        IwfKouteiClientMock.mode = "11-02";
        GetExecutableTasksForWorkListSkResultBean ret = WorkFlowUtility.getExecutableTasksForWorkListSk("sinkeiyaku"
            , null
            , "0001",
            null
            , "0001"
            , "", "20151231020304005", "20150101020304005", "20151231020304005",
            null, null, null, null, null, null, null, null,
            null, null);

        exStringEquals(ret.getSyorikekkaStatus(), WorkFlowResultConstants.RESULT_NODATA, "「実行可能タスク取得(工程指定)」サービス処理結果:2");
    }

    @Test
    @TestOrder(30)
    public void testGetExecutableTasksForWorkListSk_Case3() {
        IwfKouteiClientMock.mode = "11-03";
        GetExecutableTasksForWorkListSkResultBean ret = WorkFlowUtility.getExecutableTasksForWorkListSk("sinkeiyaku"
            , null
            , "0001",
            null
            , "0001"
            , "20150101020304005", "", "20150101020304005", "20151231020304005",
            null, null, null, null, null, null, null, null,
            null, null);

        exStringEquals(ret.getSyorikekkaStatus(), WorkFlowResultConstants.RESULT_NODATA, "「実行可能タスク取得(工程指定)」サービス処理結果:3");
    }

    @Test
    @TestOrder(40)
    public void testGetExecutableTasksForWorkListSk_Case4() {
        IwfKouteiClientMock.mode = "11-04";
        GetExecutableTasksForWorkListSkResultBean ret = WorkFlowUtility.getExecutableTasksForWorkListSk("sinkeiyaku"
            , null
            , "0001",
            null
            , "0001"
            , "20150101020304005", "20151231020304005", "", "20151231020304005",
            null, null, null, null, null, null, null, null,
            null, null);

        exStringEquals(ret.getSyorikekkaStatus(), WorkFlowResultConstants.RESULT_NODATA, "「実行可能タスク取得(工程指定)」サービス処理結果:4");
    }

    @Test
    @TestOrder(50)
    public void testGetExecutableTasksForWorkListSk_Case5() {
        IwfKouteiClientMock.mode = "11-05";
        GetExecutableTasksForWorkListSkResultBean ret = WorkFlowUtility.getExecutableTasksForWorkListSk("sinkeiyaku"
            , null
            , "0001",
            null
            , "0001"
            , "20150101020304005", "20151231020304005", "20150101020304005", "",
            null, null, null, null, null, null, null, null,
            null, null);

        exStringEquals(ret.getSyorikekkaStatus(), WorkFlowResultConstants.RESULT_NODATA, "「実行可能タスク取得(工程指定)」サービス処理結果:5");
    }

    @Test
    @TestOrder(60)
    public void testGetExecutableTasksForWorkListSk_Case6() {
        IwfKouteiClientMock.mode = "11-06";
        GetExecutableTasksForWorkListSkResultBean ret = WorkFlowUtility.getExecutableTasksForWorkListSk("sinkeiyaku"
            , null
            , "0001",
            null
            , "0001"
            , "20150101020304005", "20151231020304005", "20150101020304005", "20151231020304005",
            null, null, null, null, null, null, null, null,
            null, null);

        exStringEquals(ret.getSyousaiMessageCd(), "IWF0000", "「実行可能タスク取得(工程指定)」サービス処理結果:6");
    }

    @Test
    @TestOrder(70)
    public void testGetExecutableTasksForWorkListSk_Case7() {
        IwfKouteiClientMock.mode = "11-07";
        GetExecutableTasksForWorkListSkResultBean ret = WorkFlowUtility.getExecutableTasksForWorkListSk("sinkeiyaku"
            , null
            , "0001",
            null
            , "0001"
            , "20150101020304005", "20151231020304005", "20150101020304005", "20151231020304005",
            null, null, null, null, null, null, null, null,
            null, null);

        exStringEquals(ret.getSyousaiMessage(), "正常終了しました。", "「実行可能タスク取得(工程指定)」サービス処理結果:7");
    }

    @Test
    @TestOrder(80)
    public void testGetExecutableTasksForWorkListSk_Case8() {
        IwfKouteiClientMock.mode = "11-08";
        GetExecutableTasksForWorkListSkResultBean ret = WorkFlowUtility.getExecutableTasksForWorkListSk("sinkeiyaku"
            , null
            , "0001",
            null
            , "0001"
            , "20150101020304005", "20151231020304005", "20150101020304005", "20151231020304005",
            null, null, null, null, null, null, null, null,
            null, null);

        exStringEquals(ret.getSyorikekkaStatus(), WorkFlowResultConstants.RESULT_NG, "「実行可能タスク取得(工程指定)」サービス処理結果:8");
    }

    @Test
    @TestOrder(90)
    public void testGetExecutableTasksForWorkListSk_Case9() {
        IwfKouteiClientMock.mode = "11-09";
        GetExecutableTasksForWorkListSkResultBean ret = WorkFlowUtility.getExecutableTasksForWorkListSk("sinkeiyaku"
            , null
            , "0001",
            null
            , "Id01"
            , "20150101020304005", "20151231020304005", "20150101020304005", "20151231020304005",
            null, null, null, null, null, null, null, null,
            null, null);


        exStringEquals(ret.getExecutableTaskInfoBeanList().get(0).getJimutetuzukiCd(), "Id01", "「実行可能タスク取得(工程指定)」サービス処理結果:9-1");
        exStringEquals(ret.getExecutableTaskInfoBeanList().get(0).getJimutetuzukiNm(), "新契約事務１", "「実行可能タスク取得(工程指定)」サービス処理結果:9-2");
        exStringEquals(ret.getExecutableTaskInfoBeanList().get(0).getTaskNm(), "Task01", "「実行可能タスク取得(工程指定)」サービス処理結果:9-3");
        exStringEquals(ret.getExecutableTaskInfoBeanList().get(0).getDispTaskNm(), "タスク名01", "「実行可能タスク取得(工程指定)」サービス処理結果:9-4");
        exStringEquals(ret.getExecutableTaskInfoBeanList().get(0).getPersonalizedTaskNum().toString(), "1", "「実行可能タスク取得(工程指定)」サービス処理結果:9-5");
        exStringEquals(ret.getExecutableTaskInfoBeanList().get(0).getSharedTaskNum().toString(), "1", "「実行可能タスク取得(工程指定)」サービス処理結果:9-6");
        exStringEquals(ret.getExecutableTaskInfoBeanList().get(0).getJimutetuzukiDispOrder().toString(), "1", "「実行可能タスク取得(工程指定)」サービス処理結果:9-7");
        exStringEquals(ret.getExecutableTaskInfoBeanList().get(0).getTskDispOrder().toString(), "1", "「実行可能タスク取得(工程指定)」サービス処理結果:9-8");

        exStringEquals(ret.getExecutableTaskInfoBeanList().get(1).getJimutetuzukiCd(), "Id02", "「実行可能タスク取得(工程指定)」サービス処理結果:9-9");
        exStringEquals(ret.getExecutableTaskInfoBeanList().get(1).getJimutetuzukiNm(), "新契約事務２", "「実行可能タスク取得(工程指定)」サービス処理結果:9-10");
        exStringEquals(ret.getExecutableTaskInfoBeanList().get(1).getTaskNm(), "Task02", "「実行可能タスク取得(工程指定)」サービス処理結果:9-11");
        exStringEquals(ret.getExecutableTaskInfoBeanList().get(1).getDispTaskNm(), "タスク名02", "「実行可能タスク取得(工程指定)」サービス処理結果:9-12");
        exStringEquals(ret.getExecutableTaskInfoBeanList().get(1).getPersonalizedTaskNum().toString(), "1", "「実行可能タスク取得(工程指定)」サービス処理結果:9-13");
        exStringEquals(ret.getExecutableTaskInfoBeanList().get(1).getSharedTaskNum().toString(), "1", "「実行可能タスク取得(工程指定)」サービス処理結果:9-14");
        exStringEquals(ret.getExecutableTaskInfoBeanList().get(1).getJimutetuzukiDispOrder().toString(), "2", "「実行可能タスク取得(工程指定)」サービス処理結果:9-15");
        exStringEquals(ret.getExecutableTaskInfoBeanList().get(1).getTskDispOrder().toString(), "2", "「実行可能タスク取得(工程指定)」サービス処理結果:9-16");

        exStringEquals(ret.getExecutableTaskInfoBeanList().get(2).getJimutetuzukiCd(), "Id03", "「実行可能タスク取得(工程指定)」サービス処理結果:9-17");
        exStringEquals(ret.getExecutableTaskInfoBeanList().get(2).getJimutetuzukiNm(), "新契約事務３", "「実行可能タスク取得(工程指定)」サービス処理結果:9-18");
        exStringEquals(ret.getExecutableTaskInfoBeanList().get(2).getTaskNm(), "Task03", "「実行可能タスク取得(工程指定)」サービス処理結果:9-19");
        exStringEquals(ret.getExecutableTaskInfoBeanList().get(2).getDispTaskNm(), "タスク名03", "「実行可能タスク取得(工程指定)」サービス処理結果:9-20");
        exStringEquals(ret.getExecutableTaskInfoBeanList().get(2).getPersonalizedTaskNum().toString(), "1", "「実行可能タスク取得(工程指定)」サービス処理結果:9-21");
        exStringEquals(ret.getExecutableTaskInfoBeanList().get(2).getSharedTaskNum().toString(), "1", "「実行可能タスク取得(工程指定)」サービス処理結果:9-22");
        exStringEquals(ret.getExecutableTaskInfoBeanList().get(2).getJimutetuzukiDispOrder().toString(), "3", "「実行可能タスク取得(工程指定)」サービス処理結果:9-23");
        exStringEquals(ret.getExecutableTaskInfoBeanList().get(2).getTskDispOrder().toString(), "3", "「実行可能タスク取得(工程指定)」サービス処理結果:9-24");


    }

    @Test
    @TestOrder(100)
    public void testGetExecutableTasksForWorkListSk_Case10() {
        IwfKouteiClientMock.mode = "11-10";
        GetExecutableTasksForWorkListSkResultBean ret = WorkFlowUtility.getExecutableTasksForWorkListSk("sinkeiyaku"
            , null
            , "0001",
            null
            , "0001"
            , "20150101020304005", "20151231020304005", "20150101020304005", "20151231020304005",
            null, null, null, null, null, null, null, null,
            null, null);

        exStringEquals(ret.getSyorikekkaStatus(), WorkFlowResultConstants.RESULT_OK, "「実行可能タスク取得(工程指定)」サービス処理結果:10");
    }


    @Test
    @TestOrder(110)
    public void testGetExecutableTasksForWorkListSk_Case11() {
        IwfKouteiClientMock.mode = "11-11";
        GetExecutableTasksForWorkListSkResultBean ret = WorkFlowUtility.getExecutableTasksForWorkListSk("sinkeiyaku"
            , null
            , "0001",
            null
            , "0001"
            , "20150101020304005", "20151231020304005", "20150101020304005", "20151231020304005",
            null, null, null, null, null, null, null, null,
            null, null);

        exStringEquals(ret.getSyorikekkaStatus(), WorkFlowResultConstants.RESULT_NODATA, "「実行可能タスク取得(工程指定)」サービス処理結果:11");
    }


    @Test
    @TestOrder(120)
    public void testGetExecutableTasksForWorkListSk_Case12() {
        IwfKouteiClientMock.mode = "11-12";
        GetExecutableTasksForWorkListSkResultBean ret = WorkFlowUtility.getExecutableTasksForWorkListSk("sinkeiyaku"
            , null
            , "0001",
            null
            , "0001"
            , "20150101020304005", "20151231020304005", "20150101020304005", "20151231020304005",
            null, null, null, null, null, null, null, null,
            null, null);

        exStringEquals(ret.getSyorikekkaStatus(), WorkFlowResultConstants.RESULT_OK, "「実行可能タスク取得(工程指定)」サービス処理結果:12");
    }

    @Test
    @TestOrder(130)
    public void testGetExecutableTasksForWorkListSk_Case13() {
        IwfKouteiClientMock.mode = "11-13";
        GetExecutableTasksForWorkListSkResultBean ret = WorkFlowUtility.getExecutableTasksForWorkListSk(
            "sinkeiyaku",
            "0001",
            "",
            "",
            "0001",
            "20150101020304005",
            "20151231020304005",
            "20150101020304005",
            "20151231020304005",
            "",
            "0",
            "",
            "",
            null,
            null,
            new String[] {"101","102"},
            null,
            "",
            "");

        exStringEquals(ret.getExecutableTaskInfoBeanList().get(0).getJimutetuzukiCd(), "Id01", "事務手続コード");
        exStringEquals(ret.getExecutableTaskInfoBeanList().get(0).getJimutetuzukiNm(), "新契約事務１", "事務手続名");
        exStringEquals(ret.getExecutableTaskInfoBeanList().get(0).getTaskNm(), "Task01", "タスク名");
        exStringEquals(ret.getExecutableTaskInfoBeanList().get(0).getDispTaskNm(), "タスク名01", "(表示用）タスク名");
        exBizCalcbleEquals(ret.getExecutableTaskInfoBeanList().get(0).getSharedTaskNum(), BizNumber.valueOf(10), "共有タスク数");
        exBizCalcbleEquals(ret.getExecutableTaskInfoBeanList().get(0).getPersonalizedTaskNum(), BizNumber.valueOf(5), "個人タスク数");
        exNumericEquals(ret.getExecutableTaskInfoBeanList().get(0).getJimutetuzukiDispOrder(), 1, "事務手続表示順");
        exNumericEquals(ret.getExecutableTaskInfoBeanList().get(0).getTskDispOrder(), 1, "タスク表示順");
    }

    @Test
    @TestOrder(140)
    public void testGetExecutableTasksForWorkListSk_Case14() {
        IwfKouteiClientMock.mode = "11-14";
        GetExecutableTasksForWorkListSkResultBean ret = WorkFlowUtility.getExecutableTasksForWorkListSk(
            "sinkeiyaku",
            "",
            "0001",
            "",
            "0001",
            "20150101020304005",
            "20151231020304005",
            "20150101020304005",
            "20151231020304005",
            "",
            "",
            "",
            "",
            null,
            null,
            null,
            null,
            "",
            "");

        exStringEquals(ret.getExecutableTaskInfoBeanList().get(0).getJimutetuzukiCd(), "Id01", "事務手続コード");
        exStringEquals(ret.getExecutableTaskInfoBeanList().get(0).getJimutetuzukiNm(), "新契約事務１", "事務手続名");
        exStringEquals(ret.getExecutableTaskInfoBeanList().get(0).getTaskNm(), "Task01", "タスク名");
        exStringEquals(ret.getExecutableTaskInfoBeanList().get(0).getDispTaskNm(), "タスク名01", "(表示用）タスク名");
        exBizCalcbleEquals(ret.getExecutableTaskInfoBeanList().get(0).getSharedTaskNum(), BizNumber.valueOf(10), "共有タスク数");
        exBizCalcbleEquals(ret.getExecutableTaskInfoBeanList().get(0).getPersonalizedTaskNum(), BizNumber.valueOf(5), "個人タスク数");
        exNumericEquals(ret.getExecutableTaskInfoBeanList().get(0).getJimutetuzukiDispOrder(), 1, "事務手続表示順");
        exNumericEquals(ret.getExecutableTaskInfoBeanList().get(0).getTskDispOrder(), 1, "タスク表示順");
    }
}
