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
import yuyu.def.db.entity.DM_Jimutetuzuki;
import yuyu.def.workflow.configuration.YuyuWorkflowConfig;
import yuyu.def.workflow.manager.WorkflowDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.TestOrder;

/**
 * ワークフロー呼出ユーティリティ(処理残件数取得(サブシステム・ユーザーID指定))単体テストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class WorkFlowUtilityTest28 extends AbstractTest {

    private final static String fileName = "UT_SP_単体テスト仕様書_【28_処理残件数取得(サブシステム・ユーザーID指定)】";
    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(WorkFlowUtilityTest28.class, fileName, sheetName);
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

        DM_Jimutetuzuki data = workflowDomManager.getJimutetuzuki("0024", "sinkeiyaku1");

        workflowDomManager.delete(data);

        data = workflowDomManager.getJimutetuzuki("0026", "sinkeiyaku1");

        workflowDomManager.delete(data);

        data = workflowDomManager.getJimutetuzuki("0021", "nenkin1");

        workflowDomManager.delete(data);
    }

    @After
    public void caseTerminat() {
    }

    @Test
    @TestOrder(10)
    public void testGetCountOfTaskSummaryBySubsystem_Case01() {

        IwfKouteiClientMock.mode = "28-01";

        GetCountOfTaskSummaryBySubsystemResultBean ret = WorkFlowUtility.getCountOfTaskSummaryBySubsystem(null, "UserId");

        exStringEquals(ret.getSyorikekkaStatus(), "0", "処理結果ステータス");
        exNumericEquals(ret.getCountOfTaskSummaryBean().size(), 0, "処理残件数Beanリストの件数");
    }

    @Test
    @TestOrder(20)
    public void testGetCountOfTaskSummaryBySubsystem_Case02() {

        IwfKouteiClientMock.mode = "28-02-00";

        GetCountOfTaskSummaryBySubsystemResultBean ret = WorkFlowUtility.getCountOfTaskSummaryBySubsystem(new String[] {
            "sinkeiyaku1","nenkin1"}, "UserId");

        exStringEquals(ret.getSyorikekkaStatus(), "9", "処理結果ステータス");
        exStringEquals(ret.getSyousaiMessageCd(), "IWF0003", "詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), "稼働時間外エラーか、認証エラーが発生しました。", "詳細メッセージ");
    }

    @Test
    @TestOrder(30)
    public void testGetCountOfTaskSummaryBySubsystem_Case03() {

        IwfKouteiClientMock.mode = "28-03-01";

        GetCountOfTaskSummaryBySubsystemResultBean ret = WorkFlowUtility.getCountOfTaskSummaryBySubsystem(new String[] {
            "sinkeiyaku1","nenkin1"}, "UserId");

        exStringEquals(ret.getSyorikekkaStatus(), "9", "処理結果ステータス");
        exStringEquals(ret.getSyousaiMessageCd(), "IWF0003", "詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), "稼働時間外エラーか、認証エラーが発生しました。", "詳細メッセージ");
    }

    @Test
    @TestOrder(40)
    public void testGetCountOfTaskSummaryBySubsystem_Case04() {

        IwfKouteiClientMock.mode = "28-05-02";

        GetCountOfTaskSummaryBySubsystemResultBean ret = WorkFlowUtility.getCountOfTaskSummaryBySubsystem(new String[] {
            "sinkeiyaku1","nenkin1" }, "UserId");

        exStringEquals(ret.getSyorikekkaStatus(), "9", "処理結果ステータス");
        exStringEquals(ret.getSyousaiMessageCd(), "IWF0003", "詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), "稼働時間外エラーか、認証エラーが発生しました。", "詳細メッセージ");
    }

    @Test
    @TestOrder(50)
    public void testGetCountOfTaskSummaryBySubsystem_Case05() {

        IwfKouteiClientMock.mode = "28-05-05";

        GetCountOfTaskSummaryBySubsystemResultBean ret = WorkFlowUtility.getCountOfTaskSummaryBySubsystem(new String[] {
            "sinkeiyaku1","nenkin1" } , "UserId");

        exStringEquals(ret.getSyorikekkaStatus(), "0", "処理結果ステータス");
        exStringEquals(ret.getSyousaiMessageCd(), "IWF0000", "詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), "正常終了しました。", "詳細メッセージ");

        exStringEquals(ret.getCountOfTaskSummaryBean().get(0).getJimutetuzukiCd(), "0024", "事務手続コード");
        exStringEquals(ret.getCountOfTaskSummaryBean().get(0).getJimutetuzukiNm(), "新契約事務１", "事務手続名");
        exStringEquals(ret.getCountOfTaskSummaryBean().get(0).getCountOfprocessStartToday().toString(), "1", "本日開始件数");
        exStringEquals(ret.getCountOfTaskSummaryBean().get(0).getCountOfprocessLeftToday().toString(), "10", "本日残件数");
        exStringEquals(ret.getCountOfTaskSummaryBean().get(0).getCountOfprocessFinToday().toString(), "100", "本日完了件数");

        exStringEquals(ret.getCountOfTaskSummaryBean().get(1).getJimutetuzukiCd(), "0026", "事務手続コード");
        exStringEquals(ret.getCountOfTaskSummaryBean().get(1).getJimutetuzukiNm(), "新契約事務２", "事務手続名");
        exStringEquals(ret.getCountOfTaskSummaryBean().get(1).getCountOfprocessStartToday().toString(), "5", "本日開始件数");
        exStringEquals(ret.getCountOfTaskSummaryBean().get(1).getCountOfprocessLeftToday().toString(), "50", "本日残件数");
        exStringEquals(ret.getCountOfTaskSummaryBean().get(1).getCountOfprocessFinToday().toString(), "500", "本日完了件数");

        exStringEquals(ret.getCountOfTaskSummaryBean().get(2).getJimutetuzukiCd(), "0021", "事務手続コード");
        exStringEquals(ret.getCountOfTaskSummaryBean().get(2).getJimutetuzukiNm(), "年金事務１", "事務手続名");
        exStringEquals(ret.getCountOfTaskSummaryBean().get(2).getCountOfprocessStartToday().toString(), "3", "本日開始件数");
        exStringEquals(ret.getCountOfTaskSummaryBean().get(2).getCountOfprocessLeftToday().toString(), "30", "本日残件数");
        exStringEquals(ret.getCountOfTaskSummaryBean().get(2).getCountOfprocessFinToday().toString(), "300", "本日完了件数");
    }

    @Test
    @TestOrder(60)
    public void testGetCountOfTaskSummaryBySubsystem_Case06() {

        IwfKouteiClientMock.mode = "28-05-05";

        GetCountOfTaskSummaryBySubsystemResultBean ret = WorkFlowUtility.getCountOfTaskSummaryBySubsystem(new String[] {
            "sinkeiyaku1", "nenkin1" }, "");

        exStringEquals(ret.getSyorikekkaStatus(), "0", "処理結果ステータス");
        exStringEquals(ret.getSyousaiMessageCd(), "IWF0000", "詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), "正常終了しました。", "詳細メッセージ");
        exStringEquals(ret.getCountOfTaskSummaryBean().get(0).getJimutetuzukiCd(), "0024", "事務手続コード");
        exStringEquals(ret.getCountOfTaskSummaryBean().get(0).getJimutetuzukiNm(), "新契約事務１", "事務手続名");
        exStringEquals(ret.getCountOfTaskSummaryBean().get(0).getCountOfprocessStartToday().toString(), "11", "本日開始件数");
        exStringEquals(ret.getCountOfTaskSummaryBean().get(0).getCountOfprocessLeftToday().toString(), "111", "本日残件数");
        exStringEquals(ret.getCountOfTaskSummaryBean().get(0).getCountOfprocessFinToday().toString(), "1111", "本日完了件数");

        exStringEquals(ret.getCountOfTaskSummaryBean().get(1).getJimutetuzukiCd(), "0026", "事務手続コード");
        exStringEquals(ret.getCountOfTaskSummaryBean().get(1).getJimutetuzukiNm(), "新契約事務２", "事務手続名");
        exStringEquals(ret.getCountOfTaskSummaryBean().get(1).getCountOfprocessStartToday().toString(), "55", "本日開始件数");
        exStringEquals(ret.getCountOfTaskSummaryBean().get(1).getCountOfprocessLeftToday().toString(), "555", "本日残件数");
        exStringEquals(ret.getCountOfTaskSummaryBean().get(1).getCountOfprocessFinToday().toString(), "5555", "本日完了件数");

        exStringEquals(ret.getCountOfTaskSummaryBean().get(2).getJimutetuzukiCd(), "0021", "事務手続コード");
        exStringEquals(ret.getCountOfTaskSummaryBean().get(2).getJimutetuzukiNm(), "年金事務１", "事務手続名");
        exStringEquals(ret.getCountOfTaskSummaryBean().get(2).getCountOfprocessStartToday().toString(), "33", "本日開始件数");
        exStringEquals(ret.getCountOfTaskSummaryBean().get(2).getCountOfprocessLeftToday().toString(), "333", "本日残件数");
        exStringEquals(ret.getCountOfTaskSummaryBean().get(2).getCountOfprocessFinToday().toString(), "3333", "本日完了件数");
    }
}
