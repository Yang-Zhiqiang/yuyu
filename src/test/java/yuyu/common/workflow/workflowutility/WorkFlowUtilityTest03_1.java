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
import yuyu.def.workflow.configuration.YuyuWorkflowConfig;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.TestOrder;

/**
 * ワークフロー呼出ユーティリティ(タスク担当者名取得)単体テストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class WorkFlowUtilityTest03_1 extends AbstractTest {

    private final static String fileName = "UT_SP_単体テスト仕様書_【03_タスク担当者名取得】";
    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(WorkFlowUtilityTest03_1.class,fileName, sheetName);
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
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

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
    public void testGetTaskTantoNm_Case01(){
        IwfKouteiClientMock.mode = "03-01";
        GetTaskTantoNmResultBean ret = WorkFlowUtility.getTaskTantoNm(
            new String[] {"0001","0002","0003"});
        exStringEquals(ret.getSyorikekkaStatus(), WorkFlowResultConstants.RESULT_NG, "タスク担当者名取得処理結果:1");
    }

    @Test
    @TestOrder(20)
    public void testGetTaskTantoNm_Case02(){
        IwfKouteiClientMock.mode = "03-02";
        GetTaskTantoNmResultBean ret = WorkFlowUtility.getTaskTantoNm(
            new String[] {"0001","0002","0003"});
        exStringEquals(ret.getSyousaiMessageCd(), "IWF0003", "タスク担当者名取得処理結果:2");
    }

    @Test
    @TestOrder(30)
    public void testGetTaskTantoNm_Case03(){
        IwfKouteiClientMock.mode = "03-03";
        GetTaskTantoNmResultBean ret = WorkFlowUtility.getTaskTantoNm(
            new String[] {"0001","0002","0003"});
        exStringEquals(ret.getSyousaiMessage(), "稼働時間外エラーか、認証エラーが発生しました。", "タスク担当者名取得処理結果:3");
    }

    @Test
    @TestOrder(40)
    public void testGetTaskTantoNm_Case04(){
        IwfKouteiClientMock.mode = "03-04";
        GetTaskTantoNmResultBean ret = WorkFlowUtility.getTaskTantoNm(
            new String[] {"0001","0002","0003"});
        exStringEquals(ret.getSyorikekkaStatus(), "9", "タスク担当者名取得処理結果:4");
    }

    @Test
    @TestOrder(50)
    public void testGetTaskTantoNm_Case05(){
        IwfKouteiClientMock.mode = "03-05";
        GetTaskTantoNmResultBean ret = WorkFlowUtility.getTaskTantoNm(
            new String[] {"0001","0002","0003"});
        exStringEquals(ret.getSyorikekkaStatus(), "-1", "タスク担当者名取得処理結果:5");
    }

    @Test
    @TestOrder(60)
    public void testGetTaskTantoNm_Case06(){

        IwfKouteiClientMock.mode = "03-06";

        GetTaskTantoNmResultBean ret = WorkFlowUtility.getTaskTantoNm(
            new String[] {"0001","0002","0003"});

        exStringEquals(ret.getSyorikekkaStatus(), "-1", "処理結果ステータス");
    }

    @Test
    @TestOrder(70)
    public void testGetTaskTantoNm_Case07(){

        IwfKouteiClientMock.mode = "03-07";

        GetTaskTantoNmResultBean ret = WorkFlowUtility.getTaskTantoNm(
            new String[] {"0001","0002","0003"});

        exStringEquals(ret.getSyorikekkaStatus(), "0", "処理結果ステータス");
        exStringEquals(ret.getTaskTantoNmBeanList().get(0).getTantId(), "UserId01", "現在担当者ID[0]");
        exStringEquals(ret.getTaskTantoNmBeanList().get(0).getDispTntNm(), "ユーザー名０１", "(表示用)現在担当者名[0]");
        exStringEquals(ret.getTaskTantoNmBeanList().get(1).getTantId(), "UserId02", "現在担当者ID[1]");
        exStringEquals(ret.getTaskTantoNmBeanList().get(1).getDispTntNm(), "ユーザー名０２", "(表示用)現在担当者名[1]");
    }

    @Test
    @TestOrder(80)
    public void testGetTaskTantoNm_Case08(){

        IwfKouteiClientMock.mode = "03-08";

        GetTaskTantoNmResultBean ret = WorkFlowUtility.getTaskTantoNm(
            new String[] {"0001","0002","0003"});

        exStringEquals(ret.getSyorikekkaStatus(), "0", "処理結果ステータス");
        exStringEquals(ret.getTaskTantoNmBeanList().get(0).getTantId(), "UserId03", "現在担当者ID[0]");
        exStringEquals(ret.getTaskTantoNmBeanList().get(0).getDispTntNm(), null, "(表示用)現在担当者名[0]");
        exStringEquals(ret.getTaskTantoNmBeanList().get(1).getTantId(), "UserId04", "現在担当者ID[1]");
        exStringEquals(ret.getTaskTantoNmBeanList().get(1).getDispTntNm(), null, "(表示用)現在担当者名[1]");
    }

    @Test
    @TestOrder(90)
    public void testGetTaskTantoNm_Case09(){

        IwfKouteiClientMock.mode = "03-12";

        GetTaskTantoNmResultBean ret = WorkFlowUtility.getTaskTantoNm(
            new String[] {"0001","0002","0003"});

        exStringEquals(ret.getTaskTantoNmBeanList().get(0).getTantId(), "UserId01", "タスク担当者名取得処理結果:12-1");
        exStringEquals(ret.getTaskTantoNmBeanList().get(1).getTantId(), "UserId02", "タスク担当者名取得処理結果:12-2");
        exStringEquals(ret.getTaskTantoNmBeanList().get(2).getTantId(), "UserId03", "タスク担当者名取得処理結果:12-3");
    }
}