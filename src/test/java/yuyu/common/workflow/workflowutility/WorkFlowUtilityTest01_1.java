package yuyu.common.workflow.workflowutility;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDate;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.workflow.IwfAccountClientMock;
import yuyu.common.biz.workflow.IwfKouteiClientMock;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.entity.DM_Jimutetuzuki;
import yuyu.def.workflow.configuration.YuyuWorkflowConfig;
import yuyu.def.workflow.manager.WorkflowDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.TestOrder;

/**
 * ワークフロー呼出ユーティリティ(ロック中工程リスト取得)単体テストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class WorkFlowUtilityTest01_1 extends AbstractTest {


    private final static String fileName = "UT_SP_単体テスト仕様書_【01_ロック中工程リスト取得】";
    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(WorkFlowUtilityTest01_1.class,fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);

        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @Before
    public  void caseInit() {
        IwfKouteiClientMock.caller = "Test";
        IwfAccountClientMock.caller = "Test";
        YuyuWorkflowConfig config = YuyuWorkflowConfig.getInstance();
        config.setWorkflowStubMode(false);
    }

    @AfterClass
    public static void testClear() {
        IwfKouteiClientMock.caller = null;
        IwfAccountClientMock.caller = null;
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        WorkflowDomManager workflowDomManager = SWAKInjector.getInstance(WorkflowDomManager.class);
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        DM_Jimutetuzuki data = workflowDomManager.getJimutetuzuki("Id01", "Subsystem01");

        workflowDomManager.delete(data);

        data = workflowDomManager.getJimutetuzuki("Id02", "Subsystem01");

        workflowDomManager.delete(data);

        AM_User user1 = baseDomManager.getUser("UserId01");

        baseDomManager.delete(user1);

        AM_User user2 = baseDomManager.getUser("UserId02");

        baseDomManager.delete(user2);
    }

    @After
    public  void caseTerminat() {
    }

    @Test
    @TestOrder(10)
    public void testGetLockedTasksInfoList_Case01(){
        IwfKouteiClientMock.mode = "01-01";
        GetLockedTaskListResultBean ret = WorkFlowUtility.getLockedTasksInfoList(
            null,
            new String[] {"1234567890"},
            null ,
            new String[] {"0001"},
            "test",
            null);
        exStringEquals(ret.getSyorikekkaStatus(), WorkFlowResultConstants.RESULT_NG, "ロック中工程リスト取得処理結果:1");
    }

    @Test
    @TestOrder(20)
    public void testGetLockedTasksInfoList_Case02(){
        IwfKouteiClientMock.mode = "01-02";
        GetLockedTaskListResultBean ret = WorkFlowUtility.getLockedTasksInfoList(
            null,
            new String[] {"1234567890"},
            null ,
            new String[] {"0001"},
            "test",
            null);
        exStringEquals(ret.getSyousaiMessageCd(), "IWF2160", "ロック中工程リスト取得処理結果:2");
    }

    @Test
    @TestOrder(30)
    public void testGetLockedTasksInfoList_Case03(){
        IwfKouteiClientMock.mode = "01-03";
        GetLockedTaskListResultBean ret = WorkFlowUtility.getLockedTasksInfoList(
            null,
            new String[] {"1234567890"},
            null ,
            new String[] {"0001"},
            "test",
            null);
        exStringEquals(ret.getSyousaiMessage(), "取得数が、上限件数を超えています。", "ロック中工程リスト取得処理結果:3");
    }

    @Test
    @TestOrder(40)
    public void testGetLockedTasksInfoList_Case04(){
        IwfKouteiClientMock.mode = "01-04";
        GetLockedTaskListResultBean ret = WorkFlowUtility.getLockedTasksInfoList(
            null,
            new String[] {"1234567890"},
            null ,
            new String[] {"0001"},
            "test",
            null);
        exStringEquals(ret.getSyorikekkaStatus(), "9", "ロック中工程リスト取得処理結果:4");
    }

    @Test
    @TestOrder(50)
    public void testGetLockedTasksInfoList_Case05(){
        IwfKouteiClientMock.mode = "01-05";
        GetLockedTaskListResultBean ret = WorkFlowUtility.getLockedTasksInfoList(
            null,
            new String[] {"1234567890"},
            null ,
            new String[] {"0001"},
            "test",
            null);
        exStringEquals(ret.getSyorikekkaStatus(), "-1", "ロック中工程リスト取得処理結果:5");
    }

    @Test
    @TestOrder(60)
    public void testGetLockedTasksInfoList_Case06(){
        IwfKouteiClientMock.mode = "01-06";
        GetLockedTaskListResultBean ret = WorkFlowUtility.getLockedTasksInfoList(
            null,
            new String[] {"1234567890"},
            null ,
            new String[] {"0001"},
            "test",
            null);
        exStringEquals(ret.getSyorikekkaStatus(), "9", "ロック中工程リスト取得処理結果:6");
    }

    @Test
    @TestOrder(70)
    public void testGetLockedTasksInfoList_Case07(){
        IwfKouteiClientMock.mode = "01-07";
        GetLockedTaskListResultBean ret = WorkFlowUtility.getLockedTasksInfoList(
            null,
            new String[] {"1234567890"},
            null ,
            new String[] {"0001"},
            "test",
            null);
        exStringEquals(ret.getSyorikekkaStatus(), "9", "ロック中工程リスト取得処理結果:7");
    }

    @Test
    @TestOrder(80)
    public void testGetLockedTasksInfoList_Case08(){
        IwfKouteiClientMock.mode = "01-08";
        GetLockedTaskListResultBean ret = WorkFlowUtility.getLockedTasksInfoList(
            null,
            new String[] {"1234567890"},
            null ,
            new String[] {"0001"},
            "test",
            null);
        exStringEquals(ret.getSyorikekkaStatus(), "-1", "ロック中工程リスト取得処理結果:8");
    }

    @Test
    @TestOrder(90)
    public void testGetLockedTasksInfoList_Case09(){
        IwfKouteiClientMock.mode = "01-09";
        IwfAccountClientMock.mode = "01-09";
        GetLockedTaskListResultBean ret = WorkFlowUtility.getLockedTasksInfoList(
            null,
            new String[] {"1234567890"},
            null ,
            new String[] {"0001"},
            "test",
            null);
        exStringEquals(ret.getSyorikekkaStatus(), "0", "ロック中工程リスト取得処理結果:9");
    }

    @Test
    @TestOrder(100)
    public void testGetLockedTasksInfoList_Case10(){
        IwfKouteiClientMock.mode = "01-10";
        IwfAccountClientMock.mode = "01-10";
        GetLockedTaskListResultBean ret = WorkFlowUtility.getLockedTasksInfoList(
            null,
            new String[] {"1234567890"},
            null ,
            new String[] {"0001"},
            "test",
            null);
        exStringEquals(ret.getLockedTaskSummaryBeanList().get(0).getJimutetuzukiCd(), "Id01", "ロック中工程リスト取得処理結果:10-1");
        exStringEquals(ret.getLockedTaskSummaryBeanList().get(0).getSyoNo(), "SyoNo01", "ロック中工程リスト取得処理結果:10-2");
        exStringEquals(ret.getLockedTaskSummaryBeanList().get(0).getNkSysyNo(), "NkSysyNo01", "ロック中工程リスト取得処理結果:10-3");
        exStringEquals(ret.getLockedTaskSummaryBeanList().get(0).getKouteiKnrId(), "GyoumuKey01", "ロック中工程リスト取得処理結果:10-4");
        exDateEquals(ret.getLockedTaskSummaryBeanList().get(0).getJimuStartYmd(), BizDate.valueOf("2015/07/16"), "ロック中工程リスト取得処理結果:10-5");
        exStringEquals(ret.getLockedTaskSummaryBeanList().get(0).getNowSyoriTantouId(), "UserId01", "ロック中工程リスト取得処理結果:10-6");
        exStringEquals(ret.getLockedTaskSummaryBeanList().get(0).getNowTaskNm(), "TaskNm01", "ロック中工程リスト取得処理結果:10-7");
        exStringEquals(ret.getLockedTaskSummaryBeanList().get(0).getNowTaskLocalNm(), "タスク名01", "ロック中工程リスト取得処理結果:10-8");

        exStringEquals(ret.getLockedTaskSummaryBeanList().get(1).getJimutetuzukiCd(), "Id02", "ロック中工程リスト取得処理結果:10-9");
        exStringEquals(ret.getLockedTaskSummaryBeanList().get(1).getSyoNo(), "SyoNo02", "ロック中工程リスト取得処理結果:10-10");
        exStringEquals(ret.getLockedTaskSummaryBeanList().get(1).getNkSysyNo(), "NkSysyNo02", "ロック中工程リスト取得処理結果:10-11");
        exStringEquals(ret.getLockedTaskSummaryBeanList().get(1).getKouteiKnrId(), "GyoumuKey02", "ロック中工程リスト取得処理結果:10-12");
        exDateEquals(ret.getLockedTaskSummaryBeanList().get(1).getJimuStartYmd(), BizDate.valueOf("2015/07/16"), "ロック中工程リスト取得処理結果:10-13");
        exStringEquals(ret.getLockedTaskSummaryBeanList().get(1).getNowSyoriTantouId(), "UserId02", "ロック中工程リスト取得処理結果:10-14");
        exStringEquals(ret.getLockedTaskSummaryBeanList().get(1).getNowTaskNm(), "TaskNm02", "ロック中工程リスト取得処理結果:10-15");
        exStringEquals(ret.getLockedTaskSummaryBeanList().get(1).getNowTaskLocalNm(), "タスク名02", "ロック中工程リスト取得処理結果:10-16");
    }

    @Test
    @TestOrder(110)
    public void testGetLockedTasksInfoList_Case11(){
        IwfKouteiClientMock.mode = "01-11";
        IwfAccountClientMock.mode = "01-11";
        GetLockedTaskListResultBean ret = WorkFlowUtility.getLockedTasksInfoList(
            null,
            new String[] {"1234567890"},
            null ,
            new String[] {"0001"},
            "test",
            null);
        exStringEquals(ret.getLockedTaskSummaryBeanList().get(0).getDispNowSyoriTantouNm(), "ユーザー名０１", "ロック中工程リスト取得処理結果:11-1");
        exStringEquals(ret.getLockedTaskSummaryBeanList().get(1).getDispNowSyoriTantouNm(), "ユーザー名０２", "ロック中工程リスト取得処理結果:11-2");
    }

    @Test
    @TestOrder(120)
    public void testGetLockedTasksInfoList_Case12(){
        IwfKouteiClientMock.mode = "01-12";
        IwfAccountClientMock.mode = "01-12";
        GetLockedTaskListResultBean ret = WorkFlowUtility.getLockedTasksInfoList(
            null,
            new String[] {"1234567890"},
            null ,
            new String[] {"0001"},
            "test",
            null);
        exStringEquals(ret.getLockedTaskSummaryBeanList().get(0).getDispNowSyoriTantouNm(), null, "ロック中工程リスト取得処理結果:12-1");
        exStringEquals(ret.getLockedTaskSummaryBeanList().get(1).getDispNowSyoriTantouNm(), null, "ロック中工程リスト取得処理結果:12-2");
    }

    @Test
    @TestOrder(130)
    public void testGetLockedTasksInfoList_Case13(){
        IwfKouteiClientMock.mode = "01-13";
        IwfAccountClientMock.mode = "01-13";
        GetLockedTaskListResultBean ret = WorkFlowUtility.getLockedTasksInfoList(
            null,
            new String[] {"1234567890"},
            null ,
            new String[] {"0001"},
            "test",
            null);
        exStringEquals(ret.getLockedTaskSummaryBeanList().get(0).getSyoNo(), "SyoNo01", "ロック中工程リスト取得処理結果:13-1");
        exStringEquals(ret.getLockedTaskSummaryBeanList().get(1).getSyoNo(), "SyoNo02", "ロック中工程リスト取得処理結果:13-2");
        exStringEquals(ret.getLockedTaskSummaryBeanList().get(2).getSyoNo(), "SyoNo03", "ロック中工程リスト取得処理結果:13-3");
    }

    @Test
    @TestOrder(140)
    public void testGetLockedTasksInfoList_Case14(){
        IwfKouteiClientMock.mode = "01-14";
        IwfAccountClientMock.mode = "01-14";
        GetLockedTaskListResultBean ret = WorkFlowUtility.getLockedTasksInfoList(
            new String[] {"12345678902","12345678903","12345678901"},
            null,
            null,
            new String[] {"0001","0002","0003"},
            "test",
            null);

        exStringEquals(ret.getLockedTaskSummaryBeanList().get(0).getJimutetuzukiCd(), "0003", "事務手続コード");
        exStringEquals(ret.getLockedTaskSummaryBeanList().get(0).getMosNo(), "12345678901", "申込番号");
        exStringEquals(ret.getLockedTaskSummaryBeanList().get(0).getSyoNo(), "", "証券番号");
        exStringEquals(ret.getLockedTaskSummaryBeanList().get(0).getNkSysyNo(), "", "年金証書番号");
        exStringEquals(ret.getLockedTaskSummaryBeanList().get(0).getKouteiKnrId(), "101", "工程管理ID");
        exDateEquals(ret.getLockedTaskSummaryBeanList().get(0).getJimuStartYmd(), BizDate.valueOf("20151212"), "事務開始年月日");
        exStringEquals(ret.getLockedTaskSummaryBeanList().get(0).getNowSyoriTantouId(), "10", "現在担当者ID");
        exStringEquals(ret.getLockedTaskSummaryBeanList().get(0).getDispNowSyoriTantouNm(), null, "現在担当者名");
        exStringEquals(ret.getLockedTaskSummaryBeanList().get(0).getNowTaskNm(), "", "現在タスク名");
        exStringEquals(ret.getLockedTaskSummaryBeanList().get(0).getNowTaskLocalNm(), null, "（表示用）現在タスク名");
        exStringEquals(ret.getLockedTaskSummaryBeanList().get(1).getJimutetuzukiCd(), "0001", "事務手続コード");
        exStringEquals(ret.getLockedTaskSummaryBeanList().get(1).getMosNo(), "12345678902", "申込番号");
        exStringEquals(ret.getLockedTaskSummaryBeanList().get(1).getSyoNo(), "", "証券番号");
        exStringEquals(ret.getLockedTaskSummaryBeanList().get(1).getNkSysyNo(), "", "年金証書番号");
        exStringEquals(ret.getLockedTaskSummaryBeanList().get(1).getKouteiKnrId(), "101", "工程管理ID");
        exDateEquals(ret.getLockedTaskSummaryBeanList().get(1).getJimuStartYmd(), BizDate.valueOf("20151212"), "事務開始年月日");
        exStringEquals(ret.getLockedTaskSummaryBeanList().get(1).getNowSyoriTantouId(), "10", "現在担当者ID");
        exStringEquals(ret.getLockedTaskSummaryBeanList().get(1).getDispNowSyoriTantouNm(), null, "現在担当者名");
        exStringEquals(ret.getLockedTaskSummaryBeanList().get(1).getNowTaskNm(), "", "現在タスク名");
        exStringEquals(ret.getLockedTaskSummaryBeanList().get(1).getNowTaskLocalNm(), null, "（表示用）現在タスク名");
        exStringEquals(ret.getLockedTaskSummaryBeanList().get(2).getJimutetuzukiCd(), "0002", "事務手続コード");
        exStringEquals(ret.getLockedTaskSummaryBeanList().get(2).getMosNo(), "12345678903", "申込番号");
        exStringEquals(ret.getLockedTaskSummaryBeanList().get(2).getSyoNo(), "", "証券番号");
        exStringEquals(ret.getLockedTaskSummaryBeanList().get(2).getNkSysyNo(), "", "年金証書番号");
        exStringEquals(ret.getLockedTaskSummaryBeanList().get(2).getKouteiKnrId(), "101", "工程管理ID");
        exDateEquals(ret.getLockedTaskSummaryBeanList().get(2).getJimuStartYmd(), BizDate.valueOf("20151212"), "事務開始年月日");
        exStringEquals(ret.getLockedTaskSummaryBeanList().get(2).getNowSyoriTantouId(), "10", "現在担当者ID");
        exStringEquals(ret.getLockedTaskSummaryBeanList().get(2).getDispNowSyoriTantouNm(), null, "現在担当者名");
        exStringEquals(ret.getLockedTaskSummaryBeanList().get(2).getNowTaskNm(), "", "現在タスク名");
        exStringEquals(ret.getLockedTaskSummaryBeanList().get(2).getNowTaskLocalNm(), null, "（表示用）現在タスク名");
    }

    @Test
    @TestOrder(150)
    public void testGetLockedTasksInfoList_Case15(){
        IwfKouteiClientMock.mode = "01-15";
        IwfAccountClientMock.mode = "01-15";
        GetLockedTaskListResultBean ret = WorkFlowUtility.getLockedTasksInfoList(
            null,
            new String[] {"12345678903","12345678901","12345678902"},
            null ,
            new String[] {"0001","0002","0003"},
            "test",
            null);

        exStringEquals(ret.getLockedTaskSummaryBeanList().get(0).getJimutetuzukiCd(), "0001", "事務手続コード");
        exStringEquals(ret.getLockedTaskSummaryBeanList().get(0).getMosNo(), "12345678901", "申込番号");
        exStringEquals(ret.getLockedTaskSummaryBeanList().get(0).getSyoNo(), "12345678902", "証券番号");
        exStringEquals(ret.getLockedTaskSummaryBeanList().get(0).getNkSysyNo(), "", "年金証書番号");
        exStringEquals(ret.getLockedTaskSummaryBeanList().get(0).getKouteiKnrId(), "101", "工程管理ID");
        exDateEquals(ret.getLockedTaskSummaryBeanList().get(0).getJimuStartYmd(), BizDate.valueOf("20151212"), "事務開始年月日");
        exStringEquals(ret.getLockedTaskSummaryBeanList().get(0).getNowSyoriTantouId(), "10", "現在担当者ID");
        exStringEquals(ret.getLockedTaskSummaryBeanList().get(0).getDispNowSyoriTantouNm(), null, "現在担当者名");
        exStringEquals(ret.getLockedTaskSummaryBeanList().get(0).getNowTaskNm(), "", "現在タスク名");
        exStringEquals(ret.getLockedTaskSummaryBeanList().get(0).getNowTaskLocalNm(), null, "（表示用）現在タスク名");
        exStringEquals(ret.getLockedTaskSummaryBeanList().get(1).getJimutetuzukiCd(), "0002", "事務手続コード");
        exStringEquals(ret.getLockedTaskSummaryBeanList().get(1).getMosNo(), "12345678901", "申込番号");
        exStringEquals(ret.getLockedTaskSummaryBeanList().get(1).getSyoNo(), "12345678903", "証券番号");
        exStringEquals(ret.getLockedTaskSummaryBeanList().get(1).getNkSysyNo(), "", "年金証書番号");
        exStringEquals(ret.getLockedTaskSummaryBeanList().get(1).getKouteiKnrId(), "101", "工程管理ID");
        exDateEquals(ret.getLockedTaskSummaryBeanList().get(1).getJimuStartYmd(), BizDate.valueOf("20151212"), "事務開始年月日");
        exStringEquals(ret.getLockedTaskSummaryBeanList().get(1).getNowSyoriTantouId(), "10", "現在担当者ID");
        exStringEquals(ret.getLockedTaskSummaryBeanList().get(1).getDispNowSyoriTantouNm(), null, "現在担当者名");
        exStringEquals(ret.getLockedTaskSummaryBeanList().get(1).getNowTaskNm(), "", "現在タスク名");
        exStringEquals(ret.getLockedTaskSummaryBeanList().get(1).getNowTaskLocalNm(), null, "（表示用）現在タスク名");
        exStringEquals(ret.getLockedTaskSummaryBeanList().get(2).getJimutetuzukiCd(), "0003", "事務手続コード");
        exStringEquals(ret.getLockedTaskSummaryBeanList().get(2).getMosNo(), "12345678902", "申込番号");
        exStringEquals(ret.getLockedTaskSummaryBeanList().get(2).getSyoNo(), "12345678901", "証券番号");
        exStringEquals(ret.getLockedTaskSummaryBeanList().get(2).getNkSysyNo(), "", "年金証書番号");
        exStringEquals(ret.getLockedTaskSummaryBeanList().get(2).getKouteiKnrId(), "101", "工程管理ID");
        exDateEquals(ret.getLockedTaskSummaryBeanList().get(2).getJimuStartYmd(), BizDate.valueOf("20151212"), "事務開始年月日");
        exStringEquals(ret.getLockedTaskSummaryBeanList().get(2).getNowSyoriTantouId(), "10", "現在担当者ID");
        exStringEquals(ret.getLockedTaskSummaryBeanList().get(2).getDispNowSyoriTantouNm(), null, "現在担当者名");
        exStringEquals(ret.getLockedTaskSummaryBeanList().get(2).getNowTaskNm(), "", "現在タスク名");
        exStringEquals(ret.getLockedTaskSummaryBeanList().get(2).getNowTaskLocalNm(), null, "（表示用）現在タスク名");
    }
}