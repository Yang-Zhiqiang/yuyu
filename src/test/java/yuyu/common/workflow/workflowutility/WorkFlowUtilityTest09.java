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
import yuyu.common.biz.workflow.IwfKouteiClientMock;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.DM_Jimutetuzuki;
import yuyu.def.workflow.configuration.YuyuWorkflowConfig;
import yuyu.def.workflow.manager.WorkflowDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.TestOrder;

/**
 * ワークフロー呼出ユーティリティ(工程状況照会用リスト取得)単体テストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class WorkFlowUtilityTest09 extends AbstractTest {

    private final static String fileName = "UT_SP_単体テスト仕様書_【09_工程状況照会用リスト取得】";
    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(WorkFlowUtilityTest09.class, fileName, sheetName);
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
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        DM_Jimutetuzuki data = workflowDomManager.getJimutetuzuki("0001", "common");

        workflowDomManager.delete(data);

        data = workflowDomManager.getJimutetuzuki("0002", "common");

        workflowDomManager.delete(data);

        data = workflowDomManager.getJimutetuzuki("0003", "common");

        workflowDomManager.delete(data);

        baseDomManager.delete(baseDomManager.getAllUsers());

        bizDomManager.delete(bizDomManager.getAllGyoumuKouteiInfo());
    }

    @After
    public  void caseTerminat() {
    }

    @Test
    @TestOrder(10)
    public void testGetTasksForKouteiStatus_Case01(){
        IwfKouteiClientMock.mode = "09-01";
        IwfAccountClientMock.mode = "09-01";
        GetTasksForKouteiStatusResultBean ret = WorkFlowUtility.getTasksForKouteiStatus("common",
            null,
            new String[] {"12345678901","12345678902"},
            null,
            new String[] {"0001","0002"},
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            "001",
            null,
            null,
            null,
            null,
            null,
            false);
        exStringEquals(ret.getSyorikekkaStatus(), "9", "工程状況照会用リスト取得処理結果:1");
    }

    @Test
    @TestOrder(20)
    public void testGetTasksForKouteiStatus_Case02(){
        IwfKouteiClientMock.mode = "09-02";
        IwfAccountClientMock.mode = "09-02";
        GetTasksForKouteiStatusResultBean ret = WorkFlowUtility.getTasksForKouteiStatus("common",
            null,
            new String[] {"12345678901","12345678902"},
            null,
            new String[] {"0001","0002"},
            "20150101",
            null,
            "20150202",
            null,
            "20150303",
            null,
            null,
            null,
            "1",
            null,
            null,
            null,
            "Task01",
            false);
        exStringEquals(ret.getSyousaiMessageCd(), "IWF0003", "工程状況照会用リスト取得処理結果:2");
    }

    @Test
    @TestOrder(30)
    public void testGetTasksForKouteiStatus_Case03(){
        IwfKouteiClientMock.mode = "09-03";
        IwfAccountClientMock.mode = "09-03";
        GetTasksForKouteiStatusResultBean ret = WorkFlowUtility.getTasksForKouteiStatus("common",
            null,
            new String[] {"12345678901","12345678902"},
            null,
            new String[] {"0001","0002"},
            "20150101",
            "20150131",
            "20150202",
            "20150228",
            "20150303",
            "20150331",
            null,
            null,
            "1",
            null,
            null,
            null,
            "Task01",
            false);
        exStringEquals(ret.getSyousaiMessage(), "稼働時間外エラーか、認証エラーが発生しました。", "工程状況照会用リスト取得処理結果:3");
    }

    @Test
    @TestOrder(40)
    public void testGetTasksForKouteiStatus_Case04(){
        IwfKouteiClientMock.mode = "09-04";
        IwfAccountClientMock.mode = "09-04";
        GetTasksForKouteiStatusResultBean ret = WorkFlowUtility.getTasksForKouteiStatus("common",
            null,
            new String[] {"12345678901","12345678902"},
            null,
            new String[] {"0001","0002"},
            null,
            "20150131",
            null,
            "20150228",
            null,
            "20150331",
            null,
            null,
            "1",
            null,
            null,
            null,
            "Task01",
            false);
        exStringEquals(ret.getSyorikekkaStatus(), "9", "工程状況照会用リスト取得処理結果:4");
    }

    @Test
    @TestOrder(50)
    public void testGetTasksForKouteiStatus_Case05(){
        IwfKouteiClientMock.mode = "09-05";
        IwfAccountClientMock.mode = "09-05";
        GetTasksForKouteiStatusResultBean ret = WorkFlowUtility.getTasksForKouteiStatus("common",
            null,
            new String[] {"12345678901","12345678902"},
            null,
            new String[] {"0001","0002"},
            null,
            "20150131",
            null,
            "20150228",
            null,
            "20150331",
            null,
            null,
            "1",
            null,
            null,
            null,
            "Task01",
            false);
        exStringEquals(ret.getSyorikekkaStatus(), "-1", "工程状況照会用リスト取得処理結果:5");
    }

    @Test
    @TestOrder(60)
    public void testGetTasksForKouteiStatus_Case06(){

        IwfKouteiClientMock.mode = "09-06";

        GetTasksForKouteiStatusResultBean ret = WorkFlowUtility.getTasksForKouteiStatus("common",
            new String[] {"12345678901","12345678902"},
            new String[] {"12345678901","12345678902"},
            new String[] {"12345678901","12345678902"},
            new String[] {"0001","0002","0003"},
            "20150131",
            "20150131",
            "20150228",
            "20150228",
            "20150331",
            "20150331",
            new String[] {"10","10"},
            "10",
            "0",
            "101",
            null,
            null,
            "タスク名",
            false);

        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(0).getJimutetuzukiCd(), "0002", "事務手続コード");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(0).getJimutetuzukiNm(), "事務手続名２", "事務手続名");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(0).getMosNo(), null, "申込番号");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(0).getSyoNo(), "12345678901", "証券番号");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(0).getNkSysyNo(), "12345678901", "年金証書番号");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(0).getKouteiKnrId(), "KouteiKnrId15", "工程管理ID");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(0).getSyuKouteiKnrId(), "KouteiKnrId15", "主工程管理ID");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(0).getJimuStartYmd(), "20150703010203004", "事務開始年月日");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(0).getKouteiKaisiYmd(), "20150702", "工程開始年月日");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(0).getKouteiKanryouYmd(), "20150712", "工程完了年月日");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(0).getKouteiStatus(), "10", "工程状態");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(0).getDispKouteiStatus(), "処理中", "（表示用）工程状態");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(0).getLastUpdateTime(), "20150728010203004", "最終更新時間");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(0).getNowSyoriTantouId(), "UserId02", "現在担当者ID");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(0).getDispNowSyoriTantouNm(), "担当者名２", "（表示用）現在担当者名");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(0).getNowTaskNm(), "Task02", "現在タスク名");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(0).getNowTaskLocalNm(), "タスク名０２", "現在タスク名（ローカル名）");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(1).getJimutetuzukiCd(), "0004", "事務手続コード");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(1).getJimutetuzukiNm(), null, "事務手続名");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(1).getMosNo(), null, "申込番号");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(1).getSyoNo(), "12345678901", "証券番号");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(1).getNkSysyNo(), "12345678901", "年金証書番号");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(1).getKouteiKnrId(), "KouteiKnrId14", "工程管理ID");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(1).getSyuKouteiKnrId(), "KouteiKnrId16", "主工程管理ID");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(1).getJimuStartYmd(), "20150703010203004", "事務開始年月日");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(1).getKouteiKaisiYmd(), "20150702", "工程開始年月日");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(1).getKouteiKanryouYmd(), "20150712", "工程完了年月日");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(1).getKouteiStatus(), "10", "工程状態");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(1).getDispKouteiStatus(), "処理中", "（表示用）工程状態");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(1).getLastUpdateTime(), "20150728010203004", "最終更新時間");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(1).getNowSyoriTantouId(), "UserId04", "現在担当者ID");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(1).getDispNowSyoriTantouNm(), null, "（表示用）現在担当者名");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(1).getNowTaskNm(), "Task03", "現在タスク名");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(1).getNowTaskLocalNm(), null, "現在タスク名（ローカル名）");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(2).getJimutetuzukiCd(), "0001", "事務手続コード");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(2).getJimutetuzukiNm(), "事務手続名１", "事務手続名");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(2).getMosNo(), null, "申込番号");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(2).getSyoNo(), "12345678901", "証券番号");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(2).getNkSysyNo(), "12345678901", "年金証書番号");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(2).getKouteiKnrId(), "KouteiKnrId13", "工程管理ID");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(2).getSyuKouteiKnrId(), "KouteiKnrId17", "主工程管理ID");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(2).getJimuStartYmd(), "20150703010203004", "事務開始年月日");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(2).getKouteiKaisiYmd(), "20150702", "工程開始年月日");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(2).getKouteiKanryouYmd(), "20150712", "工程完了年月日");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(2).getKouteiStatus(), "10", "工程状態");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(2).getDispKouteiStatus(), "処理中", "（表示用）工程状態");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(2).getLastUpdateTime(), "20150727010203004", "最終更新時間");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(2).getNowSyoriTantouId(), "UserId01", "現在担当者ID");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(2).getDispNowSyoriTantouNm(), "担当者名１", "（表示用）現在担当者名");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(2).getNowTaskNm(), "Task01", "現在タスク名");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(2).getNowTaskLocalNm(), "タスク名０１", "現在タスク名（ローカル名）");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(3).getJimutetuzukiCd(), "0001", "事務手続コード");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(3).getJimutetuzukiNm(), "事務手続名１", "事務手続名");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(3).getMosNo(), null, "申込番号");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(3).getSyoNo(), "12345678901", "証券番号");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(3).getNkSysyNo(), "12345678901", "年金証書番号");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(3).getKouteiKnrId(), "KouteiKnrId13", "工程管理ID");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(3).getSyuKouteiKnrId(), "KouteiKnrId17", "主工程管理ID");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(3).getJimuStartYmd(), "20150703010203004", "事務開始年月日");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(3).getKouteiKaisiYmd(), "20150701", "工程開始年月日");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(3).getKouteiKanryouYmd(), "20150712", "工程完了年月日");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(3).getKouteiStatus(), "10", "工程状態");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(3).getDispKouteiStatus(), "処理中", "（表示用）工程状態");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(3).getLastUpdateTime(), "20150727010203004", "最終更新時間");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(3).getNowSyoriTantouId(), "UserId01", "現在担当者ID");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(3).getDispNowSyoriTantouNm(), "担当者名１", "（表示用）現在担当者名");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(3).getNowTaskNm(), "Task01", "現在タスク名");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(3).getNowTaskLocalNm(), "タスク名０１", "現在タスク名（ローカル名）");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(4).getJimutetuzukiCd(), "0004", "事務手続コード");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(4).getJimutetuzukiNm(), null, "事務手続名");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(4).getMosNo(), null, "申込番号");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(4).getSyoNo(), "12345678901", "証券番号");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(4).getNkSysyNo(), "12345678901", "年金証書番号");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(4).getKouteiKnrId(), "KouteiKnrId14", "工程管理ID");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(4).getSyuKouteiKnrId(), "KouteiKnrId16", "主工程管理ID");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(4).getJimuStartYmd(), "20150702010203004", "事務開始年月日");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(4).getKouteiKaisiYmd(), "20150702", "工程開始年月日");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(4).getKouteiKanryouYmd(), "20150712", "工程完了年月日");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(4).getKouteiStatus(), "10", "工程状態");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(4).getDispKouteiStatus(), "処理中", "（表示用）工程状態");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(4).getLastUpdateTime(), "20150728010203004", "最終更新時間");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(4).getNowSyoriTantouId(), "UserId04", "現在担当者ID");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(4).getDispNowSyoriTantouNm(), null, "（表示用）現在担当者名");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(4).getNowTaskNm(), "Task03", "現在タスク名");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(4).getNowTaskLocalNm(), null, "現在タスク名（ローカル名）");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(5).getJimutetuzukiCd(), "0002", "事務手続コード");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(5).getJimutetuzukiNm(), "事務手続名２", "事務手続名");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(5).getMosNo(), null, "申込番号");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(5).getSyoNo(), "12345678901", "証券番号");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(5).getNkSysyNo(), "12345678901", "年金証書番号");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(5).getKouteiKnrId(), "KouteiKnrId15", "工程管理ID");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(5).getSyuKouteiKnrId(), "KouteiKnrId15", "主工程管理ID");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(5).getJimuStartYmd(), "20150703010203004", "事務開始年月日");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(5).getKouteiKaisiYmd(), "20150702", "工程開始年月日");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(5).getKouteiKanryouYmd(), "20150711", "工程完了年月日");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(5).getKouteiStatus(), "10", "工程状態");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(5).getDispKouteiStatus(), "処理中", "（表示用）工程状態");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(5).getLastUpdateTime(), "20150728010203004", "最終更新時間");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(5).getNowSyoriTantouId(), "UserId02", "現在担当者ID");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(5).getDispNowSyoriTantouNm(), "担当者名２", "（表示用）現在担当者名");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(5).getNowTaskNm(), "Task02", "現在タスク名");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(5).getNowTaskLocalNm(), "タスク名０２", "現在タスク名（ローカル名）");
    }

    @Test
    @TestOrder(70)
    public void testGetTasksForKouteiStatus_Case07(){

        IwfKouteiClientMock.mode = "09-07";

        GetTasksForKouteiStatusResultBean ret = WorkFlowUtility.getTasksForKouteiStatus("common",
            null,
            new String[] {"12345678901","12345678902"},
            null,
            new String[] {"0004","0005"},
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            "1",
            null,
            null,
            null,
            null,
            false);
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(0).getJimutetuzukiCd(), "0002", "事務手続コード");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(0).getJimutetuzukiNm(), null, "事務手続名");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(0).getMosNo(), null, "申込番号");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(0).getSyoNo(), "12345678901", "証券番号");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(0).getNkSysyNo(), "12345678901", "年金証書番号");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(0).getKouteiKnrId(), "KouteiKnrId15", "工程管理ID");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(0).getSyuKouteiKnrId(), "KouteiKnrId15", "主工程管理ID");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(0).getJimuStartYmd(), "20150703010203004", "事務開始年月日");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(0).getKouteiKaisiYmd(), "20150702", "工程開始年月日");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(0).getKouteiKanryouYmd(), "20150712", "工程完了年月日");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(0).getKouteiStatus(), "10", "工程状態");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(0).getDispKouteiStatus(), "処理中", "（表示用）工程状態");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(0).getLastUpdateTime(), "20150728010203004", "最終更新時間");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(0).getNowSyoriTantouId(), "UserId02", "現在担当者ID");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(0).getDispNowSyoriTantouNm(), "担当者名２", "（表示用）現在担当者名");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(0).getNowTaskNm(), "Task02", "現在タスク名");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(0).getNowTaskLocalNm(), null, "現在タスク名（ローカル名）");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(1).getJimutetuzukiCd(), "0001", "事務手続コード");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(1).getJimutetuzukiNm(), null, "事務手続名");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(1).getMosNo(), null, "申込番号");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(1).getSyoNo(), "12345678901", "証券番号");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(1).getNkSysyNo(), "12345678901", "年金証書番号");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(1).getKouteiKnrId(), "KouteiKnrId13", "工程管理ID");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(1).getSyuKouteiKnrId(), "KouteiKnrId17", "主工程管理ID");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(1).getJimuStartYmd(), "20150703010203004", "事務開始年月日");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(1).getKouteiKaisiYmd(), "20150702", "工程開始年月日");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(1).getKouteiKanryouYmd(), "20150712", "工程完了年月日");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(1).getKouteiStatus(), "10", "工程状態");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(1).getDispKouteiStatus(), "処理中", "（表示用）工程状態");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(1).getLastUpdateTime(), "20150727010203004", "最終更新時間");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(1).getNowSyoriTantouId(), "UserId01", "現在担当者ID");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(1).getDispNowSyoriTantouNm(), "担当者名１", "（表示用）現在担当者名");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(1).getNowTaskNm(), "Task01", "現在タスク名");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(1).getNowTaskLocalNm(), null, "現在タスク名（ローカル名）");
    }

    @Test
    @TestOrder(80)
    public void testGetTasksForKouteiStatus_Case08(){

        IwfKouteiClientMock.mode = "09-08";

        GetTasksForKouteiStatusResultBean ret = WorkFlowUtility.getTasksForKouteiStatus("common",
            null,
            new String[] {"12345678901","12345678902"},
            null,
            new String[] {"0001","0002"},
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            "タスク名",
            false);
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(0).getJimutetuzukiCd(), "0002", "事務手続コード");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(0).getJimutetuzukiNm(), "事務手続名２", "事務手続名");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(0).getMosNo(), null, "申込番号");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(0).getSyoNo(), "12345678901", "証券番号");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(0).getNkSysyNo(), "12345678901", "年金証書番号");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(0).getKouteiKnrId(), "KouteiKnrId15", "工程管理ID");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(0).getSyuKouteiKnrId(), "KouteiKnrId15", "主工程管理ID");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(0).getJimuStartYmd(), "20150703010203004", "事務開始年月日");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(0).getKouteiKaisiYmd(), "20150702", "工程開始年月日");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(0).getKouteiKanryouYmd(), "20150712", "工程完了年月日");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(0).getKouteiStatus(), "10", "工程状態");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(0).getDispKouteiStatus(), "処理中", "（表示用）工程状態");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(0).getLastUpdateTime(), "20150728010203004", "最終更新時間");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(0).getNowSyoriTantouId(), "UserId02", "現在担当者ID");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(0).getDispNowSyoriTantouNm(), "担当者名２", "（表示用）現在担当者名");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(0).getNowTaskNm(), "Task02", "現在タスク名");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(0).getNowTaskLocalNm(), "タスク名０２", "現在タスク名（ローカル名）");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(1).getJimutetuzukiCd(), "0001", "事務手続コード");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(1).getJimutetuzukiNm(), "事務手続名１", "事務手続名");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(1).getMosNo(), null, "申込番号");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(1).getSyoNo(), "12345678901", "証券番号");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(1).getNkSysyNo(), "12345678901", "年金証書番号");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(1).getKouteiKnrId(), "KouteiKnrId13", "工程管理ID");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(1).getSyuKouteiKnrId(), "KouteiKnrId17", "主工程管理ID");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(1).getJimuStartYmd(), "20150703010203004", "事務開始年月日");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(1).getKouteiKaisiYmd(), "20150702", "工程開始年月日");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(1).getKouteiKanryouYmd(), "20150712", "工程完了年月日");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(1).getKouteiStatus(), "10", "工程状態");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(1).getDispKouteiStatus(), "処理中", "（表示用）工程状態");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(1).getLastUpdateTime(), "20150727010203004", "最終更新時間");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(1).getNowSyoriTantouId(), "UserId01", "現在担当者ID");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(1).getDispNowSyoriTantouNm(), "担当者名１", "（表示用）現在担当者名");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(1).getNowTaskNm(), "Task01", "現在タスク名");
        exStringEquals(ret.getTaskSummaryForKouteiStatusBeanList().get(1).getNowTaskLocalNm(), "タスク名０１", "現在タスク名（ローカル名）");
    }

}