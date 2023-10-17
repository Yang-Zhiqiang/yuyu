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
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.entity.DM_Jimutetuzuki;
import yuyu.def.workflow.configuration.YuyuWorkflowConfig;
import yuyu.def.workflow.manager.WorkflowDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.TestOrder;

/**
 * ワークフロー呼出ユーティリティ(タスク担当者一覧取得)単体テストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class WorkFlowUtilityTest04_1 extends AbstractTest {

    private final static String fileName = "UT_SP_単体テスト仕様書_【04_タスク担当者一覧取得】";
    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(WorkFlowUtilityTest04_1.class, fileName, sheetName);
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

        DM_Jimutetuzuki data = workflowDomManager.getJimutetuzuki("0001", "common");

        workflowDomManager.delete(data);

        data = workflowDomManager.getJimutetuzuki("0002", "common");

        workflowDomManager.delete(data);

        data = workflowDomManager.getJimutetuzuki("0003", "common");

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
    public void testGetTaskTantoInfoList_Case01(){

        IwfKouteiClientMock.mode = "04-01";

        GetTaskTantoInfoListResultBean ret = WorkFlowUtility.getTaskTantoInfoList(
            "common",
            null,
            "test",
            "TastId01");

        exStringEquals(ret.getSyorikekkaStatus(), "9", "処理結果ステータス");
        exStringEquals(ret.getSyousaiMessageCd(), "IWF0003", "詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), "稼働時間外エラーか、認証エラーが発生しました。", "詳細メッセージ");
    }

    @Test
    @TestOrder(20)
    public void testGetTaskTantoInfoList_Case02(){

        IwfKouteiClientMock.mode = "04-02";

        GetTaskTantoInfoListResultBean ret = WorkFlowUtility.getTaskTantoInfoList(
            "common",
            new String[] {"0001","0002"},
            "test",
            null);

        exStringEquals(ret.getSyorikekkaStatus(), "-1", "処理結果ステータス");
    }

    @Test
    @TestOrder(30)
    public void testGetTaskTantoInfoList_Case03(){

        IwfKouteiClientMock.mode = "04-03";

        GetTaskTantoInfoListResultBean ret = WorkFlowUtility.getTaskTantoInfoList(
            "common",
            new String[] {"0001","0002"},
            "test",
            "TastId01");

        exStringEquals(ret.getSyorikekkaStatus(), "0", "処理結果ステータス");
        exStringEquals(ret.getSyousaiMessageCd(), "IWF0000", "詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), "正常終了しました。", "詳細メッセージ");
    }

    @Test
    @TestOrder(40)
    public void testGetTaskTantoInfoList_Case04(){

        IwfKouteiClientMock.mode = "04-04";

        GetTaskTantoInfoListResultBean ret = WorkFlowUtility.getTaskTantoInfoList(
            "common",
            new String[] {"0001","0002","0003"},
            "test",
            "TastId01");

        exStringEquals(ret.getSyorikekkaStatus(), "0", "処理結果ステータス");
        exStringEquals(ret.getSyousaiMessageCd(), "IWF0000", "詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), "正常終了しました。", "詳細メッセージ");

        exStringEquals(ret.getTaskTantoInfoBeanList().get(0).getMosNo(), "12345678902", "申込番号[0]");
        exStringEquals(ret.getTaskTantoInfoBeanList().get(0).getSyoNo(), "SyoNo01", "証券番号[0]");
        exStringEquals(ret.getTaskTantoInfoBeanList().get(0).getNkSysyNo(), "NkSysyNo01", "年金証書番号[0]");
        exStringEquals(ret.getTaskTantoInfoBeanList().get(0).getKouteiKnrId(), "GyoumuKey01", "工程管理ID[0]");
        exStringEquals(ret.getTaskTantoInfoBeanList().get(0).getJimuStartYmd(), "20150714030405006", "事務開始年月日[0]");
        exStringEquals(ret.getTaskTantoInfoBeanList().get(0).getNowSyoriTantouId(), "UserId01", "現在担当者ID[0]");
        exStringEquals(ret.getTaskTantoInfoBeanList().get(0).getNowTaskNm(), "タスク名０１", "現在タスク名[0]");
        exStringEquals(ret.getTaskTantoInfoBeanList().get(0).getDispNowSyoriTantouNm(), "ユーザー名０１", "(表示用)現在担当者名[0]");

        exStringEquals(ret.getTaskTantoInfoBeanList().get(1).getMosNo(), "12345678901", "申込番号[1]");
        exStringEquals(ret.getTaskTantoInfoBeanList().get(1).getSyoNo(), "SyoNo02", "証券番号[1]");
        exStringEquals(ret.getTaskTantoInfoBeanList().get(1).getNkSysyNo(), "NkSysyNo02", "年金証書番号[1]");
        exStringEquals(ret.getTaskTantoInfoBeanList().get(1).getKouteiKnrId(), "GyoumuKey02", "工程管理ID[1]");
        exStringEquals(ret.getTaskTantoInfoBeanList().get(1).getJimuStartYmd(), "20150715030405006", "事務開始年月日[1]");
        exStringEquals(ret.getTaskTantoInfoBeanList().get(1).getNowSyoriTantouId(), "UserId02", "現在担当者ID[1]");
        exStringEquals(ret.getTaskTantoInfoBeanList().get(1).getNowTaskNm(), "タスク名０２", "現在タスク名[1]");
        exStringEquals(ret.getTaskTantoInfoBeanList().get(1).getDispNowSyoriTantouNm(), "ユーザー名０２", "(表示用)現在担当者名[1]");

        exStringEquals(ret.getTaskTantoInfoBeanList().get(2).getMosNo(), "12345678903", "申込番号[2]");
        exStringEquals(ret.getTaskTantoInfoBeanList().get(2).getSyoNo(), "SyoNo03", "証券番号[2]");
        exStringEquals(ret.getTaskTantoInfoBeanList().get(2).getNkSysyNo(), "NkSysyNo03", "年金証書番号[2]");
        exStringEquals(ret.getTaskTantoInfoBeanList().get(2).getKouteiKnrId(), "GyoumuKey03", "工程管理ID[2]");
        exStringEquals(ret.getTaskTantoInfoBeanList().get(2).getJimuStartYmd(), "20150716030405006", "事務開始年月日[2]");
        exStringEquals(ret.getTaskTantoInfoBeanList().get(2).getNowSyoriTantouId(), "UserId03", "現在担当者ID[2]");
        exStringEquals(ret.getTaskTantoInfoBeanList().get(2).getNowTaskNm(), null, "現在タスク名[2]");
        exStringEquals(ret.getTaskTantoInfoBeanList().get(2).getDispNowSyoriTantouNm(), null, "(表示用)現在担当者名[2]");
    }
}