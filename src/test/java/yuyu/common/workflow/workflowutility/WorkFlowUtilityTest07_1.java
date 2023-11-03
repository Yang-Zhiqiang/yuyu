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
import yuyu.def.db.entity.DM_Jimutetuzuki;
import yuyu.def.workflow.configuration.YuyuWorkflowConfig;
import yuyu.def.workflow.manager.WorkflowDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.TestOrder;

/**
 * ワークフロー呼出ユーティリティ(イメージ取込対象リスト取得)単体テストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class WorkFlowUtilityTest07_1 extends AbstractTest {

    private final static String fileName = "UT_SP_単体テスト仕様書_【07_イメージ取込対象リスト取得】";
    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(WorkFlowUtilityTest07_1.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);

        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
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
    @Transactional
    public static void deleteTestData() {
        WorkflowDomManager workflowDomManager = SWAKInjector.getInstance(WorkflowDomManager.class);
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        DM_Jimutetuzuki data = workflowDomManager.getJimutetuzuki("Id01", "Subsystem01");

        workflowDomManager.delete(data);

        data = workflowDomManager.getJimutetuzuki("Id02", "Subsystem01");

        workflowDomManager.delete(data);

        data = workflowDomManager.getJimutetuzuki("Id03", "Subsystem01");

        workflowDomManager.delete(data);

        baseDomManager.delete(baseDomManager.getAllUsers());
    }

    @After
    public  void caseTerminat() {
    }

    @Test
    @TestOrder(10)
    public void testGetTasksForPutImage_Case01(){
        IwfKouteiClientMock.mode = "07-01";
        GetTasksForPutImageResultBean ret = WorkFlowUtility.getTasksForPutImage(
            "0001",
            null,
            "12345678901",
            null ,
            "20150101",
            null,
            "10",
            "001",
            null,
            null,
            null);
        exStringEquals(ret.getSyorikekkaStatus(), "9", "イメージ取込対象リスト取得処理結果:1");
    }

    @Test
    @TestOrder(20)
    public void testGetTasksForPutImage_Case02(){
        IwfKouteiClientMock.mode = "07-02";
        GetTasksForPutImageResultBean ret = WorkFlowUtility.getTasksForPutImage(
            "0001",
            null,
            "12345678901",
            null ,
            null,
            "20150203",
            "10",
            "001",
            null,
            null,
            null);
        exStringEquals(ret.getSyousaiMessageCd(), "IWF0003", "イメージ取込対象リスト取得処理結果:2");
    }

    @Test
    @TestOrder(30)
    public void testGetTasksForPutImage_Case03(){
        IwfKouteiClientMock.mode = "07-03";
        GetTasksForPutImageResultBean ret = WorkFlowUtility.getTasksForPutImage(
            "0001",
            null,
            "12345678901",
            null ,
            "20150101",
            "20150203",
            "10",
            "001",
            null,
            null,
            null);
        exStringEquals(ret.getSyousaiMessage(), "稼働時間外エラーか、認証エラーが発生しました。", "イメージ取込対象リスト取得処理結果:3");
    }

    @Test
    @TestOrder(40)
    public void testGetTasksForPutImage_Case04(){
        IwfKouteiClientMock.mode = "07-04";
        GetTasksForPutImageResultBean ret = WorkFlowUtility.getTasksForPutImage(
            "0001",
            null,
            "12345678901",
            null ,
            null,
            null,
            null,
            null,
            null,
            null,
            null);
        exStringEquals(ret.getSyorikekkaStatus(), "9", "イメージ取込対象リスト取得処理結果:4");
    }

    @Test
    @TestOrder(50)
    public void testGetTasksForPutImage_Case05(){
        IwfKouteiClientMock.mode = "07-05";
        GetTasksForPutImageResultBean ret = WorkFlowUtility.getTasksForPutImage(
            "0001",
            null,
            "12345678901",
            null ,
            null,
            null,
            null,
            null,
            null,
            null,
            null);
        exStringEquals(ret.getSyorikekkaStatus(), "-1", "イメージ取込対象リスト取得処理結果:5");
    }

    @Test
    @TestOrder(60)
    public void testGetTasksForPutImage_Case06(){
        IwfKouteiClientMock.mode = "07-06";
        IwfAccountClientMock.mode = "07-06";
        GetTasksForPutImageResultBean ret = WorkFlowUtility.getTasksForPutImage(
            "0001",
            null,
            "12345678901",
            null ,
            null,
            null,
            null,
            null,
            null,
            null,
            null);
        exStringEquals(ret.getTaskSummaryBeanList().get(0).getSyoNo(), "SyoNo01", "イメージ取込対象リスト取得処理結果:6-1");
        exStringEquals(ret.getTaskSummaryBeanList().get(0).getNkSysyNo(), "NkSysyNo01", "イメージ取込対象リスト取得処理結果:6-2");
        exStringEquals(ret.getTaskSummaryBeanList().get(0).getKouteiKnrId(), "GyoumuKey01", "イメージ取込対象リスト取得処理結果:6-3");
        exDateEquals(ret.getTaskSummaryBeanList().get(0).getJimuStartYmd(), BizDate.valueOf("2015/07/15"), "イメージ取込対象リスト取得処理結果:6-4");
        exDateEquals(ret.getTaskSummaryBeanList().get(0).getKouteiKaisiYmd(), BizDate.valueOf("2015/07/01"), "イメージ取込対象リスト取得処理結果:6-5");
        exDateEquals(ret.getTaskSummaryBeanList().get(0).getKouteiKanryouYmd(), BizDate.valueOf("2015/07/11"), "イメージ取込対象リスト取得処理結果:6-6");
        exStringEquals(ret.getTaskSummaryBeanList().get(0).getKouteiStatus(), "10", "イメージ取込対象リスト取得処理結果:6-7");
        exStringEquals(ret.getTaskSummaryBeanList().get(0).getDispKouteiStatus(), "処理中", "イメージ取込対象リスト取得処理結果:6-8");
        exStringEquals(ret.getTaskSummaryBeanList().get(0).getLastUpdateTime(), "20150701010203004", "イメージ取込対象リスト取得処理結果:6-9");
        exStringEquals(ret.getTaskSummaryBeanList().get(0).getNowSyoriTantouId(), "UserId01", "イメージ取込対象リスト取得処理結果:6-10");
        exStringEquals(ret.getTaskSummaryBeanList().get(0).getNowTaskNm(), "Node01", "イメージ取込対象リスト取得処理結果:6-11");
        exStringEquals(ret.getTaskSummaryBeanList().get(0).getNowTaskLocalNm(), "タスク名01", "イメージ取込対象リスト取得処理結果:6-12");
        exStringEquals(ret.getTaskSummaryBeanList().get(0).getJimuyouCd(), "001", "イメージ取込対象リスト取得処理結果:6-13");

        exStringEquals(ret.getTaskSummaryBeanList().get(1).getSyoNo(), "SyoNo02", "イメージ取込対象リスト取得処理結果:6-14");
        exStringEquals(ret.getTaskSummaryBeanList().get(1).getNkSysyNo(), "NkSysyNo02", "イメージ取込対象リスト取得処理結果:6-15");
        exStringEquals(ret.getTaskSummaryBeanList().get(1).getKouteiKnrId(), "GyoumuKey02", "イメージ取込対象リスト取得処理結果:6-16");
        exDateEquals(ret.getTaskSummaryBeanList().get(1).getJimuStartYmd(), BizDate.valueOf("2015/07/16"), "イメージ取込対象リスト取得処理結果:6-17");
        exDateEquals(ret.getTaskSummaryBeanList().get(1).getKouteiKaisiYmd(), BizDate.valueOf("2015/07/02"), "イメージ取込対象リスト取得処理結果:6-18");
        exDateEquals(ret.getTaskSummaryBeanList().get(1).getKouteiKanryouYmd(), BizDate.valueOf("2015/07/12"), "イメージ取込対象リスト取得処理結果:6-19");
        exStringEquals(ret.getTaskSummaryBeanList().get(1).getKouteiStatus(), "10", "イメージ取込対象リスト取得処理結果:6-20");
        exStringEquals(ret.getTaskSummaryBeanList().get(1).getDispKouteiStatus(), "処理中", "イメージ取込対象リスト取得処理結果:6-21");
        exStringEquals(ret.getTaskSummaryBeanList().get(1).getLastUpdateTime(), "20150702010203004", "イメージ取込対象リスト取得処理結果:6-22");
        exStringEquals(ret.getTaskSummaryBeanList().get(1).getNowSyoriTantouId(), "UserId02", "イメージ取込対象リスト取得処理結果:6-23");
        exStringEquals(ret.getTaskSummaryBeanList().get(1).getNowTaskNm(), "Node02", "イメージ取込対象リスト取得処理結果:6-24");
        exStringEquals(ret.getTaskSummaryBeanList().get(1).getNowTaskLocalNm(), "タスク名02", "イメージ取込対象リスト取得処理結果:6-25");
        exStringEquals(ret.getTaskSummaryBeanList().get(1).getJimuyouCd(), "002", "イメージ取込対象リスト取得処理結果:6-26");
    }

    @Test
    @TestOrder(70)
    public void testGetTasksForPutImage_Case07(){

        IwfKouteiClientMock.mode = "07-07";

        GetTasksForPutImageResultBean ret = WorkFlowUtility.getTasksForPutImage(
            "0001",
            null,
            "12345678901",
            null ,
            null,
            null,
            null,
            null,
            null,
            null,
            null);

        exStringEquals(ret.getTaskSummaryBeanList().get(0).getNowSyoriTantouId(), null, "現在担当者ID");
        exStringEquals(ret.getTaskSummaryBeanList().get(0).getDispNowSyoriTantouNm(), null, "(表示用)現在担当者名");
        exStringEquals(ret.getTaskSummaryBeanList().get(1).getNowSyoriTantouId(), null, "現在担当者ID");
        exStringEquals(ret.getTaskSummaryBeanList().get(1).getDispNowSyoriTantouNm(), null, "(表示用)現在担当者名");
    }

    @Test
    @TestOrder(80)
    public void testGetTasksForPutImage_Case08(){

        IwfKouteiClientMock.mode = "07-08";

        GetTasksForPutImageResultBean ret = WorkFlowUtility.getTasksForPutImage(
            "0001",
            null,
            "12345678901",
            null ,
            null,
            null,
            null,
            null,
            null,
            null,
            null);

        exStringEquals(ret.getTaskSummaryBeanList().get(0).getNowSyoriTantouId(), "UserId03", "現在担当者ID");
        exStringEquals(ret.getTaskSummaryBeanList().get(0).getDispNowSyoriTantouNm(), null, "(表示用)現在担当者名");
        exStringEquals(ret.getTaskSummaryBeanList().get(1).getNowSyoriTantouId(), "UserId04", "現在担当者ID");
        exStringEquals(ret.getTaskSummaryBeanList().get(1).getDispNowSyoriTantouNm(), null, "(表示用)現在担当者名");
    }

    @Test
    @TestOrder(90)
    public void testGetTasksForPutImage_Case09(){

        IwfKouteiClientMock.mode = "07-09";

        GetTasksForPutImageResultBean ret = WorkFlowUtility.getTasksForPutImage(
            "0001",
            null,
            "12345678901",
            null ,
            null,
            null,
            null,
            null,
            null,
            null,
            null);

        exStringEquals(ret.getTaskSummaryBeanList().get(0).getNowSyoriTantouId(), "UserId01", "現在担当者ID");
        exStringEquals(ret.getTaskSummaryBeanList().get(0).getDispNowSyoriTantouNm(), "ユーザー名０１", "(表示用)現在担当者名");
        exStringEquals(ret.getTaskSummaryBeanList().get(1).getNowSyoriTantouId(), "UserId02", "現在担当者ID");
        exStringEquals(ret.getTaskSummaryBeanList().get(1).getDispNowSyoriTantouNm(), "ユーザー名０２", "(表示用)現在担当者名");
    }

    @Test
    @TestOrder(110)
    public void testGetTasksForPutImage_Case11(){
        IwfKouteiClientMock.mode = "07-11";
        IwfAccountClientMock.mode = "07-11";
        GetTasksForPutImageResultBean ret = WorkFlowUtility.getTasksForPutImage(
            "0001",
            null,
            "12345678901",
            null ,
            null,
            null,
            null,
            null,
            null,
            null,
            null);
        exStringEquals(ret.getTaskSummaryBeanList().get(0).getSyoNo(), "SyoNo01", "イメージ取込対象リスト取得処理結果:11-1");
        exStringEquals(ret.getTaskSummaryBeanList().get(0).getNkSysyNo(), "NkSysyNo01", "イメージ取込対象リスト取得処理結果:11-2");
        exStringEquals(ret.getTaskSummaryBeanList().get(1).getSyoNo(), "SyoNo02", "イメージ取込対象リスト取得処理結果:11-3");
        exStringEquals(ret.getTaskSummaryBeanList().get(1).getNkSysyNo(), "NkSysyNo01", "イメージ取込対象リスト取得処理結果:11-4");
        exStringEquals(ret.getTaskSummaryBeanList().get(2).getSyoNo(), "SyoNo02", "イメージ取込対象リスト取得処理結果:11-5");
        exStringEquals(ret.getTaskSummaryBeanList().get(2).getNkSysyNo(), "NkSysyNo02", "イメージ取込対象リスト取得処理結果:11-6");
    }

    @Test
    @TestOrder(120)
    public void testGetTasksForPutImage_Case12(){
        IwfKouteiClientMock.mode = "07-12";
        IwfAccountClientMock.mode = "07-12";
        GetTasksForPutImageResultBean ret = WorkFlowUtility.getTasksForPutImage(
            "0001",
            null,
            "12345678901",
            null ,
            null,
            null,
            null,
            null,
            null,
            null,
            null);
        exStringEquals(ret.getSyorikekkaStatus(), "0", "イメージ取込対象リスト取得処理結果:12");
    }

    @Test
    @TestOrder(130)
    public void testGetTasksForPutImage_Case13(){
        IwfKouteiClientMock.mode = "07-13";
        IwfAccountClientMock.mode = "07-13";
        GetTasksForPutImageResultBean ret = WorkFlowUtility.getTasksForPutImage(
            "0001",
            "12345678901",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "");

        exStringEquals(ret.getTaskSummaryBeanList().get(0).getMosNo(), "12345678901", "申込番号");
        exStringEquals(ret.getTaskSummaryBeanList().get(0).getSyoNo(), "12345678901", "証券番号");
        exStringEquals(ret.getTaskSummaryBeanList().get(0).getNkSysyNo(), "", "年金証書番号");
        exStringEquals(ret.getTaskSummaryBeanList().get(0).getKouteiKnrId(), "", "工程管理ID");
        exDateEquals(ret.getTaskSummaryBeanList().get(0).getJimuStartYmd(), null, "事務開始年月日");
        exDateEquals(ret.getTaskSummaryBeanList().get(0).getKouteiKaisiYmd(), null, "工程開始年月日");
        exDateEquals(ret.getTaskSummaryBeanList().get(0).getKouteiKanryouYmd(), null, "工程完了年月日");
        exStringEquals(ret.getTaskSummaryBeanList().get(0).getKouteiStatus(), "", "工程状態");
        exStringEquals(ret.getTaskSummaryBeanList().get(0).getDispKouteiStatus(), "", "（表示用）工程状態");
        exStringEquals(ret.getTaskSummaryBeanList().get(0).getLastUpdateTime(), "", "最終更新時間");
        exStringEquals(ret.getTaskSummaryBeanList().get(0).getNowSyoriTantouId(), "", "現在担当者ID");
        exStringEquals(ret.getTaskSummaryBeanList().get(0).getDispNowSyoriTantouNm(), null, "（表示用）現在担当者名");
        exStringEquals(ret.getTaskSummaryBeanList().get(0).getNowTaskNm(), "", "タスク名");
        exStringEquals(ret.getTaskSummaryBeanList().get(0).getNowTaskLocalNm(), null, "（表示用）タスク名");
        exStringEquals(ret.getTaskSummaryBeanList().get(0).getJimuyouCd(), "", "事務用コード");
        exStringEquals(ret.getTaskSummaryBeanList().get(1).getMosNo(), "12345678901", "申込番号");
        exStringEquals(ret.getTaskSummaryBeanList().get(1).getSyoNo(), "12345678902", "証券番号");
        exStringEquals(ret.getTaskSummaryBeanList().get(1).getNkSysyNo(), "", "年金証書番号");
        exStringEquals(ret.getTaskSummaryBeanList().get(1).getKouteiKnrId(), "", "工程管理ID");
        exDateEquals(ret.getTaskSummaryBeanList().get(1).getJimuStartYmd(), null, "事務開始年月日");
        exDateEquals(ret.getTaskSummaryBeanList().get(1).getKouteiKaisiYmd(), null, "工程開始年月日");
        exDateEquals(ret.getTaskSummaryBeanList().get(1).getKouteiKanryouYmd(), null, "工程完了年月日");
        exStringEquals(ret.getTaskSummaryBeanList().get(1).getKouteiStatus(), "", "工程状態");
        exStringEquals(ret.getTaskSummaryBeanList().get(1).getDispKouteiStatus(), "", "（表示用）工程状態");
        exStringEquals(ret.getTaskSummaryBeanList().get(1).getLastUpdateTime(), "", "最終更新時間");
        exStringEquals(ret.getTaskSummaryBeanList().get(1).getNowSyoriTantouId(), "", "現在担当者ID");
        exStringEquals(ret.getTaskSummaryBeanList().get(1).getDispNowSyoriTantouNm(), null, "（表示用）現在担当者名");
        exStringEquals(ret.getTaskSummaryBeanList().get(1).getNowTaskNm(), "", "タスク名");
        exStringEquals(ret.getTaskSummaryBeanList().get(1).getNowTaskLocalNm(), null, "（表示用）タスク名");
        exStringEquals(ret.getTaskSummaryBeanList().get(1).getJimuyouCd(), "", "事務用コード");
        exStringEquals(ret.getTaskSummaryBeanList().get(2).getMosNo(), "12345678901", "申込番号");
        exStringEquals(ret.getTaskSummaryBeanList().get(2).getSyoNo(), "12345678903", "証券番号");
        exStringEquals(ret.getTaskSummaryBeanList().get(2).getNkSysyNo(), "", "年金証書番号");
        exStringEquals(ret.getTaskSummaryBeanList().get(2).getKouteiKnrId(), "", "工程管理ID");
        exDateEquals(ret.getTaskSummaryBeanList().get(2).getJimuStartYmd(), null, "事務開始年月日");
        exDateEquals(ret.getTaskSummaryBeanList().get(2).getKouteiKaisiYmd(), null, "工程開始年月日");
        exDateEquals(ret.getTaskSummaryBeanList().get(2).getKouteiKanryouYmd(), null, "工程完了年月日");
        exStringEquals(ret.getTaskSummaryBeanList().get(2).getKouteiStatus(), "", "工程状態");
        exStringEquals(ret.getTaskSummaryBeanList().get(2).getDispKouteiStatus(), "", "（表示用）工程状態");
        exStringEquals(ret.getTaskSummaryBeanList().get(2).getLastUpdateTime(), "", "最終更新時間");
        exStringEquals(ret.getTaskSummaryBeanList().get(2).getNowSyoriTantouId(), "", "現在担当者ID");
        exStringEquals(ret.getTaskSummaryBeanList().get(2).getDispNowSyoriTantouNm(), null, "（表示用）現在担当者名");
        exStringEquals(ret.getTaskSummaryBeanList().get(2).getNowTaskNm(), "", "タスク名");
        exStringEquals(ret.getTaskSummaryBeanList().get(2).getNowTaskLocalNm(), null, "（表示用）タスク名");
        exStringEquals(ret.getTaskSummaryBeanList().get(2).getJimuyouCd(), "", "事務用コード");
    }

    @Test
    @TestOrder(140)
    public void testGetTasksForPutImage_Case14(){
        IwfKouteiClientMock.mode = "07-14";
        IwfAccountClientMock.mode = "07-14";
        GetTasksForPutImageResultBean ret = WorkFlowUtility.getTasksForPutImage(
            "0001",
            "",
            "12345678901",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "");

        exStringEquals(ret.getTaskSummaryBeanList().get(0).getMosNo(), "12345678901", "申込番号");
        exStringEquals(ret.getTaskSummaryBeanList().get(0).getSyoNo(), "12345678901", "証券番号");
        exStringEquals(ret.getTaskSummaryBeanList().get(0).getNkSysyNo(), "", "年金証書番号");
        exStringEquals(ret.getTaskSummaryBeanList().get(0).getKouteiKnrId(), "", "工程管理ID");
        exDateEquals(ret.getTaskSummaryBeanList().get(0).getJimuStartYmd(), null, "事務開始年月日");
        exDateEquals(ret.getTaskSummaryBeanList().get(0).getKouteiKaisiYmd(), null, "工程開始年月日");
        exDateEquals(ret.getTaskSummaryBeanList().get(0).getKouteiKanryouYmd(), null, "工程完了年月日");
        exStringEquals(ret.getTaskSummaryBeanList().get(0).getKouteiStatus(), "", "工程状態");
        exStringEquals(ret.getTaskSummaryBeanList().get(0).getDispKouteiStatus(), "", "（表示用）工程状態");
        exStringEquals(ret.getTaskSummaryBeanList().get(0).getLastUpdateTime(), "", "最終更新時間");
        exStringEquals(ret.getTaskSummaryBeanList().get(0).getNowSyoriTantouId(), "", "現在担当者ID");
        exStringEquals(ret.getTaskSummaryBeanList().get(0).getDispNowSyoriTantouNm(), null, "（表示用）現在担当者名");
        exStringEquals(ret.getTaskSummaryBeanList().get(0).getNowTaskNm(), "", "タスク名");
        exStringEquals(ret.getTaskSummaryBeanList().get(0).getNowTaskLocalNm(), null, "（表示用）タスク名");
        exStringEquals(ret.getTaskSummaryBeanList().get(0).getJimuyouCd(), "", "事務用コード");
        exStringEquals(ret.getTaskSummaryBeanList().get(1).getMosNo(), "12345678902", "申込番号");
        exStringEquals(ret.getTaskSummaryBeanList().get(1).getSyoNo(), "12345678901", "証券番号");
        exStringEquals(ret.getTaskSummaryBeanList().get(1).getNkSysyNo(), "", "年金証書番号");
        exStringEquals(ret.getTaskSummaryBeanList().get(1).getKouteiKnrId(), "", "工程管理ID");
        exDateEquals(ret.getTaskSummaryBeanList().get(1).getJimuStartYmd(), null, "事務開始年月日");
        exDateEquals(ret.getTaskSummaryBeanList().get(1).getKouteiKaisiYmd(), null, "工程開始年月日");
        exDateEquals(ret.getTaskSummaryBeanList().get(1).getKouteiKanryouYmd(), null, "工程完了年月日");
        exStringEquals(ret.getTaskSummaryBeanList().get(1).getKouteiStatus(), "", "工程状態");
        exStringEquals(ret.getTaskSummaryBeanList().get(1).getDispKouteiStatus(), "", "（表示用）工程状態");
        exStringEquals(ret.getTaskSummaryBeanList().get(1).getLastUpdateTime(), "", "最終更新時間");
        exStringEquals(ret.getTaskSummaryBeanList().get(1).getNowSyoriTantouId(), "", "現在担当者ID");
        exStringEquals(ret.getTaskSummaryBeanList().get(1).getDispNowSyoriTantouNm(), null, "（表示用）現在担当者名");
        exStringEquals(ret.getTaskSummaryBeanList().get(1).getNowTaskNm(), "", "タスク名");
        exStringEquals(ret.getTaskSummaryBeanList().get(1).getNowTaskLocalNm(), null, "（表示用）タスク名");
        exStringEquals(ret.getTaskSummaryBeanList().get(1).getJimuyouCd(), "", "事務用コード");
        exStringEquals(ret.getTaskSummaryBeanList().get(2).getMosNo(), "12345678903", "申込番号");
        exStringEquals(ret.getTaskSummaryBeanList().get(2).getSyoNo(), "12345678901", "証券番号");
        exStringEquals(ret.getTaskSummaryBeanList().get(2).getNkSysyNo(), "", "年金証書番号");
        exStringEquals(ret.getTaskSummaryBeanList().get(2).getKouteiKnrId(), "", "工程管理ID");
        exDateEquals(ret.getTaskSummaryBeanList().get(2).getJimuStartYmd(), null, "事務開始年月日");
        exDateEquals(ret.getTaskSummaryBeanList().get(2).getKouteiKaisiYmd(), null, "工程開始年月日");
        exDateEquals(ret.getTaskSummaryBeanList().get(2).getKouteiKanryouYmd(), null, "工程完了年月日");
        exStringEquals(ret.getTaskSummaryBeanList().get(2).getKouteiStatus(), "", "工程状態");
        exStringEquals(ret.getTaskSummaryBeanList().get(2).getDispKouteiStatus(), "", "（表示用）工程状態");
        exStringEquals(ret.getTaskSummaryBeanList().get(2).getLastUpdateTime(), "", "最終更新時間");
        exStringEquals(ret.getTaskSummaryBeanList().get(2).getNowSyoriTantouId(), "", "現在担当者ID");
        exStringEquals(ret.getTaskSummaryBeanList().get(2).getDispNowSyoriTantouNm(), null, "（表示用）現在担当者名");
        exStringEquals(ret.getTaskSummaryBeanList().get(2).getNowTaskNm(), "", "タスク名");
        exStringEquals(ret.getTaskSummaryBeanList().get(2).getNowTaskLocalNm(), null, "（表示用）タスク名");
        exStringEquals(ret.getTaskSummaryBeanList().get(2).getJimuyouCd(), "", "事務用コード");
    }
}