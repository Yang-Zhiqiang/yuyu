package yuyu.common.workflow.workflowutility;


import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.workflow.IwfKouteiClientMock;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.entity.DM_Jimutetuzuki;
import yuyu.def.workflow.configuration.YuyuWorkflowConfig;
import yuyu.def.workflow.manager.WorkflowDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.TestOrder;

/**
 * ワークフロー呼出ユーティリティ(工程履歴取得)単体テストクラスです。
 */
public class WorkFlowUtilityTest17 extends AbstractTest {

    private final static String fileName = "UT_SP_単体テスト仕様書_【17_工程履歴取得】_000_01";
    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(WorkFlowUtilityTest17.class, fileName, sheetName);
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
    public void testGetProcessHistory_Case1() {
        IwfKouteiClientMock.mode = "17-01";
        GetProcessHistoryResultBean result = WorkFlowUtility.getProcessHistory(null, null);

        exStringEquals(result.getSyorikekkaStatus(),WorkFlowResultConstants.RESULT_NG, "工程履歴取得処理結果:1");
    }

    @Test
    @TestOrder(20)
    public void testGetProcessHistory_Case2() {
        IwfKouteiClientMock.mode = "17-02";
        GetProcessHistoryResultBean result = WorkFlowUtility.getProcessHistory(null, "0001");

        exStringEquals(result.getSyorikekkaStatus(),WorkFlowResultConstants.RESULT_OK, "工程履歴取得処理結果:2");
    }

    @Test
    @TestOrder(30)
    public void testGetProcessHistory_Case3() {
        IwfKouteiClientMock.mode = "17-03";
        GetProcessHistoryResultBean result = WorkFlowUtility.getProcessHistory("testId", "");

        exStringEquals(result.getSyorikekkaStatus(),WorkFlowResultConstants.RESULT_OK, "工程履歴取得処理結果:3");
    }

    @Test
    @TestOrder(40)
    public void testGetProcessHistory_Case4() {

        IwfKouteiClientMock.mode = "17-04";

        GetProcessHistoryResultBean result = WorkFlowUtility.getProcessHistory("testId", "0001");

        exStringEquals(result.getSyorikekkaStatus(),WorkFlowResultConstants.RESULT_OK, "工程履歴取得処理結果:4");
    }

    @Test
    @TestOrder(50)
    public void testGetProcessHistory_Case5() {

        IwfKouteiClientMock.mode = "17-05";

        GetProcessHistoryResultBean result = WorkFlowUtility.getProcessHistory("testId", "0001");

        exStringEquals(result.getSyousaiMessageCd(),"IWF0000", "工程履歴取得処理結果:5");
    }

    @Test
    @TestOrder(60)
    public void testGetProcessHistory_Case6() {

        IwfKouteiClientMock.mode = "17-06";

        GetProcessHistoryResultBean result = WorkFlowUtility.getProcessHistory("testId", "0001");

        exStringEquals(result.getSyousaiMessage(),"正常終了しました。", "工程履歴取得処理結果:6");
    }

    @Test
    @TestOrder(70)
    public void testGetProcessHistory_Case7() {

        IwfKouteiClientMock.mode = "17-07";

        GetProcessHistoryResultBean result = WorkFlowUtility.getProcessHistory("testId", "0001");

        exStringEquals(result.getSyorikekkaStatus(),"9", "工程履歴取得処理結果:7");
    }

    @Test
    @TestOrder(80)
    public void testGetProcessHistory_Case8() {

        IwfKouteiClientMock.mode = "17-08";

        GetProcessHistoryResultBean result = WorkFlowUtility.getProcessHistory("testId", "0001");

        exStringEquals(result.getSyorikekkaStatus(),"-1", "工程履歴取得処理結果:8");
    }

    @Test
    @TestOrder(90)
    public void testGetProcessHistory_Case9() {

        IwfKouteiClientMock.mode = "17-09";

        GetProcessHistoryResultBean result = WorkFlowUtility.getProcessHistory("testId", "0001");

        exStringEquals(result.getSyorikekkaStatus(), "0", "処理結果ステータス");
        exStringEquals(result.getSyousaiMessageCd(), "IWF0000", "詳細メッセージコード");
        exStringEquals(result.getSyousaiMessage(), "正常終了しました。", "詳細メッセージ");

        exStringEquals(result.getProcessHistoryBeanList().get(0).getProcessYmdTime(), "20150102", "処理日時");
        exStringEquals(result.getProcessHistoryBeanList().get(0).getTaskNm(), "testNodeId1", "タスク名");
        exStringEquals(result.getProcessHistoryBeanList().get(0).getDispTaskNm(), "テストノード名０１", "（表示用）タスク名");
        exStringEquals(result.getProcessHistoryBeanList().get(0).getProcessResult(), "00", "結果");
        exStringEquals(result.getProcessHistoryBeanList().get(0).getTantouId(), "UserId01", "ユーザーID");
        exStringEquals(result.getProcessHistoryBeanList().get(0).getTantouNm(), "ユーザー名０１", "担当者名");
        exStringEquals(result.getProcessHistoryBeanList().get(0).getHistoryMessage(), "タスク生成０１", "履歴メッセージ");

        exStringEquals(result.getProcessHistoryBeanList().get(1).getProcessYmdTime(), "20150101", "処理日時");
        exStringEquals(result.getProcessHistoryBeanList().get(1).getTaskNm(), "testNodeId3", "タスク名");
        exStringEquals(result.getProcessHistoryBeanList().get(1).getDispTaskNm(), "テストノード名０３", "（表示用）タスク名");
        exStringEquals(result.getProcessHistoryBeanList().get(1).getProcessResult(), "0", "結果");
        exStringEquals(result.getProcessHistoryBeanList().get(1).getTantouId(), "UserId03", "ユーザーID");
        exStringEquals(result.getProcessHistoryBeanList().get(1).getTantouNm(), null, "担当者名");
        exStringEquals(result.getProcessHistoryBeanList().get(1).getHistoryMessage(), "タスク生成０３", "履歴メッセージ");

        exStringEquals(result.getProcessHistoryBeanList().get(2).getProcessYmdTime(), "20140101", "処理日時");
        exStringEquals(result.getProcessHistoryBeanList().get(2).getTaskNm(), "testNodeId4", "タスク名");
        exStringEquals(result.getProcessHistoryBeanList().get(2).getDispTaskNm(), "テストノード名０４", "（表示用）タスク名");
        exStringEquals(result.getProcessHistoryBeanList().get(2).getProcessResult(), "0", "結果");
        exStringEquals(result.getProcessHistoryBeanList().get(2).getTantouId(), "UserId04", "ユーザーID");
        exStringEquals(result.getProcessHistoryBeanList().get(2).getTantouNm(), null, "担当者名");
        exStringEquals(result.getProcessHistoryBeanList().get(2).getHistoryMessage(), "タスク生成０４", "履歴メッセージ");
    }
}
