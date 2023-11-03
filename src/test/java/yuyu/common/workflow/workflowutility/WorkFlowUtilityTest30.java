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
import yuyu.common.biz.workflow.IwfKouteiClientMock;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.db.entity.AM_User;
import yuyu.def.workflow.configuration.YuyuWorkflowConfig;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.TestOrder;

/**
 * ワークフロー呼出ユーティリティ(処理残件数取得(事務手続・タスク指定))単体テストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class WorkFlowUtilityTest30 extends AbstractTest {

    private final static String fileName = "UT_SP_単体テスト仕様書_【30_処理残件数取得(事務手続・タスク指定)】";
    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(WorkFlowUtilityTest30.class, fileName, sheetName);
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
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        AM_User user1 = baseDomManager.getUser("UserId01");

        baseDomManager.delete(user1);

        AM_User user2 = baseDomManager.getUser("UserId02");

        baseDomManager.delete(user2);

        AM_User user3 = baseDomManager.getUser("UserId04");

        baseDomManager.delete(user3);

        AM_User user4 = baseDomManager.getUser("UserId05");

        baseDomManager.delete(user4);
    }

    @After
    public void caseTerminat() {
    }

    @Test
    @TestOrder(10)
    public void testGetCountOfTaskSummaryByTask_Case01() {

        IwfKouteiClientMock.mode = "30-01-00";

        GetCountOfTaskSummaryByTaskResultBean ret = WorkFlowUtility.getCountOfTaskSummaryByTask("0001", "Task01",
            "UserId");

        exStringEquals(ret.getSyorikekkaStatus(), "9", "処理結果ステータス");
        exStringEquals(ret.getSyousaiMessageCd(), "IWF0003", "詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), "稼働時間外エラーか、認証エラーが発生しました。", "詳細メッセージ");
    }

    @Test
    @TestOrder(20)
    public void testGetCountOfTaskSummaryByTask_Case02() {

        IwfKouteiClientMock.mode = "30-05-01";

        GetCountOfTaskSummaryByTaskResultBean ret = WorkFlowUtility.getCountOfTaskSummaryByTask("0001", "Task01",
            "UserId");
        exStringEquals(ret.getSyorikekkaStatus(), "9", "処理結果ステータス");
        exStringEquals(ret.getSyousaiMessageCd(), "IWF0003", "詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), "稼働時間外エラーか、認証エラーが発生しました。", "詳細メッセージ");
    }

    @Test
    @TestOrder(30)
    public void testGetCountOfTaskSummaryByTask_Case03() {

        IwfKouteiClientMock.mode = "30-05-02";

        GetCountOfTaskSummaryByTaskResultBean ret = WorkFlowUtility.getCountOfTaskSummaryByTask("0001", "Task01",
            "UserId");

        exStringEquals(ret.getSyorikekkaStatus(), "9", "処理結果ステータス");
        exStringEquals(ret.getSyousaiMessageCd(), "IWF0003", "詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), "稼働時間外エラーか、認証エラーが発生しました。", "詳細メッセージ");
    }

    @Test
    @TestOrder(40)
    public void testGetCountOfTaskSummaryByTask_Case04() {

        IwfKouteiClientMock.mode = "30-05-05";

        GetCountOfTaskSummaryByTaskResultBean ret = WorkFlowUtility.getCountOfTaskSummaryByTask("0024", "Task01",
            "UserId");

        exStringEquals(ret.getSyorikekkaStatus(), "0", "処理結果ステータス");
        exStringEquals(ret.getSyousaiMessageCd(), "IWF0000", "詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), "正常終了しました。", "詳細メッセージ");

        exStringEquals(ret.getCountOfTaskSummaryBean().get(0).getUserId(), "", "ユーザーID");
        exStringEquals(ret.getCountOfTaskSummaryBean().get(0).getDispUserNm(), "共用", "(表示用)ユーザ名");
        exStringEquals(ret.getCountOfTaskSummaryBean().get(0).getCountOfprocessStartToday().toString(), "1", "本日開始件数");
        exStringEquals(ret.getCountOfTaskSummaryBean().get(0).getCountOfprocessLeftToday().toString(), "10", "本日残件数");
        exStringEquals(ret.getCountOfTaskSummaryBean().get(0).getCountOfprocessFinToday().toString(), "100", "本日完了件数");

        exStringEquals(ret.getCountOfTaskSummaryBean().get(1).getUserId(), "UserId02", "ユーザーID");
        exStringEquals(ret.getCountOfTaskSummaryBean().get(1).getDispUserNm(), "ユーザー名０２", "(表示用)ユーザ名");
        exStringEquals(ret.getCountOfTaskSummaryBean().get(1).getCountOfprocessStartToday().toString(), "2", "本日開始件数");
        exStringEquals(ret.getCountOfTaskSummaryBean().get(1).getCountOfprocessLeftToday().toString(), "20", "本日残件数");
        exStringEquals(ret.getCountOfTaskSummaryBean().get(1).getCountOfprocessFinToday().toString(), "200", "本日完了件数");

        exStringEquals(ret.getCountOfTaskSummaryBean().get(2).getUserId(), "UserId01", "ユーザーID");
        exStringEquals(ret.getCountOfTaskSummaryBean().get(2).getDispUserNm(), "ユーザー名０１", "(表示用)ユーザ名");
        exStringEquals(ret.getCountOfTaskSummaryBean().get(2).getCountOfprocessStartToday().toString(), "3", "本日開始件数");
        exStringEquals(ret.getCountOfTaskSummaryBean().get(2).getCountOfprocessLeftToday().toString(), "30", "本日残件数");
        exStringEquals(ret.getCountOfTaskSummaryBean().get(2).getCountOfprocessFinToday().toString(), "300", "本日完了件数");

    }

    @Test
    @TestOrder(50)
    public void testGetCountOfTaskSummaryByTask_Case05() {

        IwfKouteiClientMock.mode = "30-05-05";

        GetCountOfTaskSummaryByTaskResultBean ret = WorkFlowUtility.getCountOfTaskSummaryByTask("0024", "Task01",
            "");

        exStringEquals(ret.getSyorikekkaStatus(), "0", "処理結果ステータス");
        exStringEquals(ret.getSyousaiMessageCd(), "IWF0000", "詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), "正常終了しました。", "詳細メッセージ");

        exStringEquals(ret.getCountOfTaskSummaryBean().get(0).getUserId(), "", "ユーザーID");
        exStringEquals(ret.getCountOfTaskSummaryBean().get(0).getDispUserNm(), "共用", "(表示用)ユーザ名");
        exStringEquals(ret.getCountOfTaskSummaryBean().get(0).getCountOfprocessStartToday().toString(), "10", "本日開始件数");
        exStringEquals(ret.getCountOfTaskSummaryBean().get(0).getCountOfprocessLeftToday().toString(), "100", "本日残件数");
        exStringEquals(ret.getCountOfTaskSummaryBean().get(0).getCountOfprocessFinToday().toString(), "1000", "本日完了件数");

        exStringEquals(ret.getCountOfTaskSummaryBean().get(1).getUserId(), "UserId01", "ユーザーID");
        exStringEquals(ret.getCountOfTaskSummaryBean().get(1).getDispUserNm(), "ユーザー名０１", "(表示用)ユーザ名");
        exStringEquals(ret.getCountOfTaskSummaryBean().get(1).getCountOfprocessStartToday().toString(), "30", "本日開始件数");
        exStringEquals(ret.getCountOfTaskSummaryBean().get(1).getCountOfprocessLeftToday().toString(), "300", "本日残件数");
        exStringEquals(ret.getCountOfTaskSummaryBean().get(1).getCountOfprocessFinToday().toString(), "3000", "本日完了件数");

        exStringEquals(ret.getCountOfTaskSummaryBean().get(2).getUserId(), "UserId02", "ユーザーID");
        exStringEquals(ret.getCountOfTaskSummaryBean().get(2).getDispUserNm(), "ユーザー名０２", "(表示用)ユーザ名");
        exStringEquals(ret.getCountOfTaskSummaryBean().get(2).getCountOfprocessStartToday().toString(), "20", "本日開始件数");
        exStringEquals(ret.getCountOfTaskSummaryBean().get(2).getCountOfprocessLeftToday().toString(), "200", "本日残件数");
        exStringEquals(ret.getCountOfTaskSummaryBean().get(2).getCountOfprocessFinToday().toString(), "2000", "本日完了件数");
    }
}
