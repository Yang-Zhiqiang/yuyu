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
import yuyu.common.biz.workflow.IwfAccountClientMock;
import yuyu.common.biz.workflow.IwfImageClientMock;
import yuyu.common.biz.workflow.IwfKouteiClientMock;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.BT_WariateHukaInfo;
import yuyu.def.db.entity.DM_Jimutetuzuki;
import yuyu.def.workflow.configuration.YuyuWorkflowConfig;
import yuyu.def.workflow.manager.WorkflowDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.TestOrder;

/**
 * ワークフロー呼出ユーティリティ(工程ワークリスト一覧表示用リスト取得（新契約以外）)単体テストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class WorkFlowUtilityTest14 extends AbstractTest {

    private final static String fileName = "UT_SP_単体テスト仕様書_【14_工程ワークリスト一覧表示用リスト取得（新契約以外）】_000_01";
    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(WorkFlowUtilityTest14.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);

        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @Before
    public void caseInit() {
        IwfImageClientMock.caller = "Test";
        IwfKouteiClientMock.caller = "Test";
        IwfAccountClientMock.caller = "Test";
        YuyuWorkflowConfig config = YuyuWorkflowConfig.getInstance();
        config.setWorkflowStubMode(false);
    }

    @AfterClass
    public static void testClear() {
        IwfImageClientMock.caller = null;
        IwfKouteiClientMock.caller = null;
        IwfAccountClientMock.caller = null;
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        WorkflowDomManager workflowDomManager = SWAKInjector.getInstance(WorkflowDomManager.class);
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        DM_Jimutetuzuki data = workflowDomManager.getJimutetuzuki("0001", "hozen");

        workflowDomManager.delete(data);

        data = workflowDomManager.getJimutetuzuki("0002", "hozen");

        workflowDomManager.delete(data);

        data = workflowDomManager.getJimutetuzuki("0003", "hozen");

        workflowDomManager.delete(data);

        data = workflowDomManager.getJimutetuzuki("0100", "hozen");

        workflowDomManager.delete(data);

        baseDomManager.delete(baseDomManager.getAllUsers());

        BT_WariateHukaInfo wariateHukaInfo = bizDomManager.getWariateHukaInfo("GyoumuKey02", "hozen", "0002",
            "Task02", "test");

        bizDomManager.delete(wariateHukaInfo);
    }

    @After
    public void caseTerminat() {
    }

    @Test
    @TestOrder(10)
    public void testGetTasksForWorkList_Case01() {
        IwfKouteiClientMock.mode = "14-01";
        GetTasksForWorkListResultBean ret = WorkFlowUtility.getTasksForWorkList("hozen", null, "12345678901", null, "0001", "20150101", "20160101", "001", null, null, "0", null);

        exStringEquals(ret.getSyorikekkaStatus(), WorkFlowResultConstants.RESULT_NG, "「工程サマリ取得」サービス処理結果:1");
    }

    @Test
    @TestOrder(20)
    public void testGetTasksForWorkList_Case02() {
        IwfKouteiClientMock.mode = "14-02";
        IwfAccountClientMock.mode = "14-02";
        GetTasksForWorkListResultBean ret = WorkFlowUtility.getTasksForWorkList("hozen", null, "12345678901", null, "0001", "20150101", "20160101", "001", null, "test", "0", null);

        exStringEquals(ret.getSyousaiMessageCd(), "IWF0000", "「工程サマリ取得」サービス処理結果:2");

    }

    @Test
    @TestOrder(30)
    public void testGetTasksForWorkList_Case03() {
        IwfKouteiClientMock.mode = "14-03";
        IwfAccountClientMock.mode = "14-03";
        GetTasksForWorkListResultBean ret = WorkFlowUtility.getTasksForWorkList("hozen", null, "12345678901", null, "0001", "20150101", "20160101", "001", null, "test", "0", null);

        exStringEquals(ret.getSyousaiMessage(), "正常終了しました。", "「工程サマリ取得」サービス処理結果:3");

    }

    @Test
    @TestOrder(40)
    public void testGetTasksForWorkList_Case04() {
        IwfKouteiClientMock.mode = "14-04";
        GetTasksForWorkListResultBean ret = WorkFlowUtility.getTasksForWorkList("hozen", null, "12345678901", null, "0001", "20150101", "20160101", "001", null, null, "0", null);

        exStringEquals(ret.getSyorikekkaStatus(), WorkFlowResultConstants.RESULT_NG, "「工程サマリ取得」サービス処理結果:4");

    }

    @Test
    @TestOrder(50)
    public void testGetTasksForWorkList_Case05() {
        IwfKouteiClientMock.mode = "14-05";
        GetTasksForWorkListResultBean ret = WorkFlowUtility.getTasksForWorkList("hozen", null, "12345678901", null, "0001", "20150101", "20160101", "001", null, null, "0", null);

        exStringEquals(ret.getSyorikekkaStatus(), WorkFlowResultConstants.RESULT_NODATA, "「工程サマリ取得」サービス処理結果:5");
    }

    @Test
    @TestOrder(60)
    public void testGetTasksForWorkList_Case06() {
        IwfKouteiClientMock.mode = "14-06";
        IwfAccountClientMock.mode = "14-06";
        GetTasksForWorkListResultBean ret = WorkFlowUtility.getTasksForWorkList("hozen", null, "12345678901", null, "0001", "20150101", "20160101", "001", "0", "test", "1", "TaskName");

        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(0).getJimutetuzukiCd(), "0001", "「工程サマリ取得」サービス処理結果:6-1");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(0).getJimutetuzukiNm(), "住所変更", "「工程サマリ取得」サービス処理結果:6-2");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(0).getKouteiKnrId(), "GyoumuKey01", "「工程サマリ取得」サービス処理結果:6-3");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(0).getSyoNo(), "SysyNo01", "「工程サマリ取得」サービス処理結果:6-4");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(0).getNkSysyNo(), "NkSysyNo01", "「工程サマリ取得」サービス処理結果:6-5");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(0).getJimuStartYmd(), "20150101123456777", "「工程サマリ取得」サービス処理結果:6-6");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(0).getPreSyoriTantouId(), "UserId01", "「工程サマリ取得」サービス処理結果:6-7");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(0).getDispPreSyoriTantouNm(), "ユーザー名０１", "「工程サマリ取得」サービス処理結果:6-8");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(0).getPreTaskNm(), "Task01", "「工程サマリ取得」サービス処理結果:6-9");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(0).getDispPreTaskNm(), "内容確認（住所変更）", "「工程サマリ取得」サービス処理結果:6-10");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(0).getNowSyoriTantouId(), "UserId01", "「工程サマリ取得」サービス処理結果:6-11");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(0).getDispNowSyoriTantouNm(), "ユーザー名０１", "「工程サマリ取得」サービス処理結果:6-12");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(0).getNowTaskNm(), "Task01", "「工程サマリ取得」サービス処理結果:6-13");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(0).getDispNowTaskNm(), "内容確認（住所変更）", "「工程サマリ取得」サービス処理結果:6-14");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(0).getSyouhinCd(), "SyouhinCode001", "「工程サマリ取得」サービス処理結果:6-15");
        exBooleanEquals(ret.getTaskSummaryForWorkListBeanList().get(0).getNyuuryokuKahi(), true, "「工程サマリ取得」サービス処理結果:6-16");

        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(1).getJimutetuzukiCd(), "0002", "「工程サマリ取得」サービス処理結果:6-17");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(1).getJimutetuzukiNm(), "名義変更", "「工程サマリ取得」サービス処理結果:6-18");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(1).getKouteiKnrId(), "GyoumuKey02", "「工程サマリ取得」サービス処理結果:6-19");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(1).getSyoNo(), "SysyNo02", "「工程サマリ取得」サービス処理結果:6-20");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(1).getNkSysyNo(), "NkSysyNo02", "「工程サマリ取得」サービス処理結果:6-21");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(1).getJimuStartYmd(), "20150101123456777", "「工程サマリ取得」サービス処理結果:6-22");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(1).getPreSyoriTantouId(), "UserId02", "「工程サマリ取得」サービス処理結果:6-23");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(1).getDispPreSyoriTantouNm(), "ユーザー名０２", "「工程サマリ取得」サービス処理結果:6-24");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(1).getPreTaskNm(), "Task02", "「工程サマリ取得」サービス処理結果:6-25");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(1).getDispPreTaskNm(), "内容確認（名義変更）", "「工程サマリ取得」サービス処理結果:6-26");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(1).getNowSyoriTantouId(), "UserId02", "「工程サマリ取得」サービス処理結果:6-27");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(1).getDispNowSyoriTantouNm(), "ユーザー名０２", "「工程サマリ取得」サービス処理結果:6-28");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(1).getNowTaskNm(), "Task02", "「工程サマリ取得」サービス処理結果:6-29");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(1).getDispNowTaskNm(), "内容確認（名義変更）", "「工程サマリ取得」サービス処理結果:6-30");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(1).getSyouhinCd(), "SyouhinCode002", "「工程サマリ取得」サービス処理結果:6-31");
        exBooleanEquals(ret.getTaskSummaryForWorkListBeanList().get(1).getNyuuryokuKahi(), false, "「工程サマリ取得」サービス処理結果:6-32");

        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(2).getJimutetuzukiCd(), "0003", "「工程サマリ取得」サービス処理結果:6-33");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(2).getJimutetuzukiNm(), "払込方法変更", "「工程サマリ取得」サービス処理結果:6-34");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(2).getKouteiKnrId(), "GyoumuKey03", "「工程サマリ取得」サービス処理結果:6-35");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(2).getSyoNo(), "SysyNo03", "「工程サマリ取得」サービス処理結果:6-36");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(2).getNkSysyNo(), "NkSysyNo03", "「工程サマリ取得」サービス処理結果:6-37");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(2).getJimuStartYmd(), "20150101123456777", "「工程サマリ取得」サービス処理結果:6-38");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(2).getPreSyoriTantouId(), "UserId03", "「工程サマリ取得」サービス処理結果:6-39");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(2).getDispPreSyoriTantouNm(), "ユーザー名０３", "「工程サマリ取得」サービス処理結果:6-40");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(2).getPreTaskNm(), "Task03", "「工程サマリ取得」サービス処理結果:6-41");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(2).getDispPreTaskNm(), "名義変更", "「工程サマリ取得」サービス処理結果:6-42");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(2).getNowSyoriTantouId(), "UserId03", "「工程サマリ取得」サービス処理結果:6-43");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(2).getDispNowSyoriTantouNm(), "ユーザー名０３", "「工程サマリ取得」サービス処理結果:6-44");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(2).getNowTaskNm(), "Task03", "「工程サマリ取得」サービス処理結果:6-45");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(2).getDispNowTaskNm(), "名義変更", "「工程サマリ取得」サービス処理結果:6-46");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(2).getSyouhinCd(), "SyouhinCode003", "「工程サマリ取得」サービス処理結果:6-47");
        exBooleanEquals(ret.getTaskSummaryForWorkListBeanList().get(2).getNyuuryokuKahi(), true, "「工程サマリ取得」サービス処理結果:6-48");
    }

    @Test
    @TestOrder(70)
    public void testGetTasksForWorkList_Case07() {
        IwfKouteiClientMock.mode = "14-07";
        IwfAccountClientMock.mode = "14-07";
        GetTasksForWorkListResultBean ret = WorkFlowUtility.getTasksForWorkList("hozen", null, "12345678901", null, "0001", "20150101", "20160101", "001", "0", "test", "1", "TaskName");

        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(0).getJimutetuzukiNm(), "住所変更", "「工程サマリ取得」サービス処理結果:7");
    }

    @Test
    @TestOrder(80)
    public void testGetTasksForWorkList_Case08() {
        IwfKouteiClientMock.mode = "14-08";
        IwfAccountClientMock.mode = "14-08";
        GetTasksForWorkListResultBean ret = WorkFlowUtility.getTasksForWorkList("hozen", null, "12345678901", null, "0001", "20150101", "20160101", "001", "0", "test", "1", "TaskName");

        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(0).getJimutetuzukiNm(), null, "「工程サマリ取得」サービス処理結果:8");
    }

    @Test
    @TestOrder(90)
    public void testGetTasksForWorkList_Case09() {

        IwfKouteiClientMock.mode = "14-09";

        GetTasksForWorkListResultBean ret = WorkFlowUtility.getTasksForWorkList("hozen", "12345678901", "12345678901",
            "12345678901", "0001", "20150101", "20160101", "001", "0", "test", "1", "TaskName");

        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(0).getJimutetuzukiCd(), "0001", "事務手続コード");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(0).getJimutetuzukiNm(), "住所変更", "事務手続名");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(0).getKouteiKnrId(), "GyoumuKey01", "工程管理ID");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(0).getMosNo(), "MosNo01", "申込番号");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(0).getSyoNo(), "SysyNo01", "証券番号");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(0).getNkSysyNo(), "NkSysyNo01", "年金証書番号");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(0).getJimuStartYmd(), "20150101123456777", "事務開始年月日");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(0).getKeiyakusyaNm(), null, "契約者名");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(0).getPreSyoriTantouId(), "UserId01", "前回担当者ID");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(0).getDispPreSyoriTantouNm(), "ユーザー名０１", "(表示用)前回担当者名");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(0).getPreTaskNm(), "Task01", "前回タスク名");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(0).getDispPreTaskNm(), "内容確認（住所変更）", "（表示用）前回タスク名");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(0).getNowSyoriTantouId(), "UserId04", "現在担当者ID");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(0).getDispNowSyoriTantouNm(), null, "(表示用)現在担当者名");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(0).getNowTaskNm(), "Task01", "現在タスク名");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(0).getDispNowTaskNm(), "内容確認（住所変更）", "（表示用）現在タスク名");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(0).getSyouhinCd(), "SyouhinCode001", "商品コード");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(0).getSyouhinNm(), null, "商品名");
        exBooleanEquals(ret.getTaskSummaryForWorkListBeanList().get(0).getNyuuryokuKahi(), true, "入力可否");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(1).getJimutetuzukiCd(), "0002", "事務手続コード");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(1).getJimutetuzukiNm(), "名義変更", "事務手続名");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(1).getKouteiKnrId(), "GyoumuKey02", "工程管理ID");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(1).getMosNo(), "MosNo02", "申込番号");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(1).getSyoNo(), "SysyNo02", "証券番号");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(1).getNkSysyNo(), "NkSysyNo02", "年金証書番号");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(1).getJimuStartYmd(), "20150101123456777", "事務開始年月日");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(1).getKeiyakusyaNm(), null, "契約者名");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(1).getPreSyoriTantouId(), "UserId05", "前回担当者ID");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(1).getDispPreSyoriTantouNm(), null, "(表示用)前回担当者名");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(1).getPreTaskNm(), "Task02", "前回タスク名");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(1).getDispPreTaskNm(), "内容確認（名義変更）", "（表示用）前回タスク名");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(1).getNowSyoriTantouId(), "UserId02", "現在担当者ID");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(1).getDispNowSyoriTantouNm(), "ユーザー名０２", "(表示用)現在担当者名");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(1).getNowTaskNm(), "Task02", "現在タスク名");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(1).getDispNowTaskNm(), "内容確認（名義変更）", "（表示用）現在タスク名");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(1).getSyouhinCd(), "SyouhinCode002", "商品コード");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(1).getSyouhinNm(), null, "商品名");
        exBooleanEquals(ret.getTaskSummaryForWorkListBeanList().get(1).getNyuuryokuKahi(), false, "入力可否");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(2).getJimutetuzukiCd(), "0003", "事務手続コード");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(2).getJimutetuzukiNm(), "払込方法変更", "事務手続名");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(2).getKouteiKnrId(), "GyoumuKey03", "工程管理ID");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(2).getMosNo(), "MosNo03", "申込番号");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(2).getSyoNo(), "SysyNo03", "証券番号");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(2).getNkSysyNo(), "NkSysyNo03", "年金証書番号");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(2).getJimuStartYmd(), "20150101123456777", "事務開始年月日");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(2).getKeiyakusyaNm(), null, "契約者名");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(2).getPreSyoriTantouId(), "UserId03", "前回担当者ID");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(2).getDispPreSyoriTantouNm(), "ユーザー名０３", "(表示用)前回担当者名");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(2).getPreTaskNm(), "Task03", "前回タスク名");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(2).getDispPreTaskNm(), "名義変更", "（表示用）前回タスク名");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(2).getNowSyoriTantouId(), "UserId03", "現在担当者ID");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(2).getDispNowSyoriTantouNm(), "ユーザー名０３", "(表示用)現在担当者名");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(2).getNowTaskNm(), "Task03", "現在タスク名");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(2).getDispNowTaskNm(), "名義変更", "（表示用）現在タスク名");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(2).getSyouhinCd(), "SyouhinCode003", "商品コード");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(2).getSyouhinNm(), null, "商品名");
        exBooleanEquals(ret.getTaskSummaryForWorkListBeanList().get(2).getNyuuryokuKahi(), true, "入力可否");
    }

    @Test
    @TestOrder(130)
    public void testGetTasksForWorkList_Case13() {
        IwfKouteiClientMock.mode = "14-13";
        IwfAccountClientMock.mode = "14-13";
        GetTasksForWorkListResultBean ret = WorkFlowUtility.getTasksForWorkList("hozen", null, "12345678901", null, "0001", "20150101", "20160101", "001", "0", "test", "1", "TaskName");

        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(0).getJimutetuzukiCd(), "0001", "「工程サマリ取得」サービス処理結果:13-1");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(0).getJimutetuzukiNm(), "住所変更", "「工程サマリ取得」サービス処理結果:13-2");

        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(1).getJimutetuzukiCd(), "0002", "「工程サマリ取得」サービス処理結果:13-3");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(1).getJimutetuzukiNm(), "名義変更", "「工程サマリ取得」サービス処理結果:13-4");

        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(2).getJimutetuzukiCd(), "0003", "「工程サマリ取得」サービス処理結果:13-5");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(2).getJimutetuzukiNm(), "払込方法変更", "「工程サマリ取得」サービス処理結果:13-6");
    }

    @Test
    @TestOrder(140)
    public void testGetTasksForWorkList_Case14() {
        IwfKouteiClientMock.mode = "14-14";
        IwfAccountClientMock.mode = "14-14";
        GetTasksForWorkListResultBean ret = WorkFlowUtility.getTasksForWorkList(
            "hozen",
            "12345678901",
            "",
            "",
            "0001",
            "",
            "",
            "",
            "",
            "",
            "",
            "");

        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(0).getJimutetuzukiCd(), "0001", "事務手続コード");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(0).getJimutetuzukiNm(), "住所変更", "事務手続名");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(0).getKouteiKnrId(), "", "工程管理ID");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(0).getMosNo(), "12345678901", "申込番号");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(0).getSyoNo(), "", "証券番号");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(0).getNkSysyNo(), "", "年金証書番号");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(0).getJimuStartYmd(), null, "事務開始年月日");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(0).getPreSyoriTantouId(), "UserId01", "前回担当者ID");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(0).getDispPreSyoriTantouNm(), "ユーザー名０１", "(表示用)前回担当者名");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(0).getPreTaskNm(), "Task01", "前回タスク名");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(0).getDispPreTaskNm(), "内容確認（住所変更）", "（表示用）前回タスク名");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(0).getNowSyoriTantouId(), "UserId01", "現在担当者ID");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(0).getDispNowSyoriTantouNm(), "ユーザー名０１", "(表示用)現在担当者名");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(0).getNowTaskNm(), "Task01", "現在タスク名");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(0).getDispNowTaskNm(), "内容確認（住所変更）", "（表示用）現在タスク名");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(0).getSyouhinCd(), "", "商品コード");
    }

    @Test
    @TestOrder(150)
    public void testGetTasksForWorkList_Case15() {
        IwfKouteiClientMock.mode = "14-15";
        IwfAccountClientMock.mode = "14-15";
        GetTasksForWorkListResultBean ret = WorkFlowUtility.getTasksForWorkList(
            "hozen",
            "",
            "12345678901",
            "",
            "0001",
            "",
            "",
            "",
            "",
            "",
            "",
            "");

        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(0).getJimutetuzukiCd(), "0001", "事務手続コード");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(0).getJimutetuzukiNm(), "住所変更", "事務手続名");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(0).getKouteiKnrId(), "", "工程管理ID");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(0).getMosNo(), "", "申込番号");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(0).getSyoNo(), "12345678901", "証券番号");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(0).getNkSysyNo(), "", "年金証書番号");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(0).getJimuStartYmd(), null, "事務開始年月日");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(0).getPreSyoriTantouId(), "UserId01", "前回担当者ID");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(0).getDispPreSyoriTantouNm(), "ユーザー名０１", "(表示用)前回担当者名");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(0).getPreTaskNm(), "Task01", "前回タスク名");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(0).getDispPreTaskNm(), "内容確認（住所変更）", "（表示用）前回タスク名");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(0).getNowSyoriTantouId(), "UserId01", "現在担当者ID");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(0).getDispNowSyoriTantouNm(), "ユーザー名０１", "(表示用)現在担当者名");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(0).getNowTaskNm(), "Task01", "現在タスク名");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(0).getDispNowTaskNm(), "内容確認（住所変更）", "（表示用）現在タスク名");
        exStringEquals(ret.getTaskSummaryForWorkListBeanList().get(0).getSyouhinCd(), "", "商品コード");
    }

}
