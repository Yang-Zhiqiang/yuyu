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
import yuyu.common.biz.workflow.IwfImageClientMock;
import yuyu.common.biz.workflow.IwfKouteiClientMock;
import yuyu.def.db.entity.HT_MosMikakuteiSyorui;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.def.workflow.configuration.YuyuWorkflowConfig;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.TestOrder;

/**
 * ワークフロー呼出ユーティリティ(到着予定取得)単体テストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class WorkFlowUtilityTest35 extends AbstractTest {

    private final static String fileName = "UT_SP_単体テスト仕様書_【35_到着予定取得】";
    private final static String sheetName = "テストデータ";


    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(WorkFlowUtilityTest35.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);

        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @Before
    public  void caseInit() {
        IwfImageClientMock.caller = "Test";
        IwfKouteiClientMock.caller = "Test";
        YuyuWorkflowConfig config = YuyuWorkflowConfig.getInstance();
        config.setWorkflowStubMode(false);
    }

    @AfterClass
    public static void testClear() {
        IwfImageClientMock.caller = null;
        IwfKouteiClientMock.caller = null;
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        HT_MosMikakuteiSyorui mosMikakuteiSyorui = sinkeiyakuDomManager.getMosMikakuteiSyorui("MOS12345678901234568");

        sinkeiyakuDomManager.delete(mosMikakuteiSyorui);

        mosMikakuteiSyorui = sinkeiyakuDomManager.getMosMikakuteiSyorui("MOS12345678901234569");

        sinkeiyakuDomManager.delete(mosMikakuteiSyorui);
    }

    @After
    public  void caseTerminat() {
    }

    @Test
    @TestOrder(10)
    public void testGetExpectedArrivalNotice_Case01(){

        IwfImageClientMock.mode = "35-01";

        GetExpectedArrivalNoticeResultBean ret = WorkFlowUtility.getExpectedArrivalNotice(
            new String[] {"MOS12345678901234567"});

        exStringEquals(ret.getSyorikekkaStatus(), "-1", "処理結果ステータス");
        exNumericEquals(ret.getExpectedArrivalNoticeBeanList().size(), 0, "到着予定Ｂｅａｎリストの件数");
    }

    @Test
    @TestOrder(20)
    public void testGetExpectedArrivalNotice_Case02(){

        IwfImageClientMock.mode = "35-02";

        GetExpectedArrivalNoticeResultBean ret = WorkFlowUtility.getExpectedArrivalNotice(
            new String[] {"MOS12345678901234568"});

        exStringEquals(ret.getSyorikekkaStatus(), "9", "処理結果ステータス");
        exStringEquals(ret.getSyousaiMessageCd(), "IWF0003", "詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), "稼働時間外エラーか、認証エラーが発生しました。", "詳細メッセージコード");
        exNumericEquals(ret.getExpectedArrivalNoticeBeanList().size(), 0, "到着予定Ｂｅａｎリストの件数");
    }

    @Test
    @TestOrder(30)
    public void testGetExpectedArrivalNotice_Case03(){

        IwfImageClientMock.mode = "35-03";

        GetExpectedArrivalNoticeResultBean ret = WorkFlowUtility.getExpectedArrivalNotice(
            new String[] {"MOS12345678901234569", "yuyu12345678901234567"});

        exStringEquals(ret.getSyorikekkaStatus(), "-1", "処理結果ステータス");
        exStringEquals(ret.getExpectedArrivalNoticeBeanList().get(0).getQrCd(), "MOS12345678901234569", "ＱＲコード値");
        exStringEquals(ret.getExpectedArrivalNoticeBeanList().get(0).getSyoruiCd(), "kk002", "書類コード");
        exStringEquals(ret.getExpectedArrivalNoticeBeanList().get(0).getSyoruiNmRyaku(), "取込表紙", "書類名（略称）");
    }

    @Test
    @TestOrder(40)
    public void testGetExpectedArrivalNotice_Case04(){

        IwfImageClientMock.mode = "35-04";

        GetExpectedArrivalNoticeResultBean ret = WorkFlowUtility.getExpectedArrivalNotice(
            new String[] {"MOS12345678901234569"});

        exStringEquals(ret.getSyorikekkaStatus(), "9", "処理結果ステータス");
        exStringEquals(ret.getSyousaiMessageCd(), "IWF0003", "詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), "稼働時間外エラーか、認証エラーが発生しました。", "詳細メッセージコード");
        exNumericEquals(ret.getExpectedArrivalNoticeBeanList().size(), 0, "到着予定Ｂｅａｎリストの件数");
    }

    @Test
    @TestOrder(50)
    public void testGetExpectedArrivalNotice_Case05(){

        IwfImageClientMock.mode = "35-05";
        IwfKouteiClientMock.mode = "35-05";

        GetExpectedArrivalNoticeResultBean ret = WorkFlowUtility.getExpectedArrivalNotice(
            new String[] {"YUYU12345678901234567", "MOS12345678901234567"});

        exStringEquals(ret.getSyorikekkaStatus(), "9", "処理結果ステータス");
        exStringEquals(ret.getSyousaiMessageCd(), "IWF0000", "詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), "異常終了しました。", "詳細メッセージコード");
        exNumericEquals(ret.getExpectedArrivalNoticeBeanList().size(), 0, "到着予定Ｂｅａｎリストの件数");
    }

    @Test
    @TestOrder(60)
    public void testGetExpectedArrivalNotice_Case06(){

        IwfImageClientMock.mode = "35-06";
        IwfKouteiClientMock.mode = "35-06";

        GetExpectedArrivalNoticeResultBean ret = WorkFlowUtility.getExpectedArrivalNotice(
            new String[] {"YUYU12345678901234567", "MOS12345678901234567"});

        exStringEquals(ret.getSyorikekkaStatus(), "-9", "処理結果ステータス");
        exStringEquals(ret.getSyousaiMessageCd(), "IWF0000", "詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), "正常終了しました。", "詳細メッセージコード");
        exStringEquals(ret.getLockingQrCd(), "YUYU12345678901234567", "ＱＲコード値");
    }

    @Test
    @TestOrder(70)
    public void testGetExpectedArrivalNotice_Case07(){

        IwfImageClientMock.mode = "35-07";
        IwfKouteiClientMock.mode = "35-07";

        GetExpectedArrivalNoticeResultBean ret = WorkFlowUtility.getExpectedArrivalNotice(
            new String[] {"YUYU12345678901234567", "MOS12345678901234567"});

        exStringEquals(ret.getSyorikekkaStatus(), "9", "処理結果ステータス");
        exStringEquals(ret.getSyousaiMessageCd(), "IWF0003", "詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), "稼働時間外エラーか、認証エラーが発生しました。", "詳細メッセージコード");
        exNumericEquals(ret.getExpectedArrivalNoticeBeanList().size(), 0, "到着予定Ｂｅａｎリストの件数");
    }

    @Test
    @TestOrder(80)
    public void testGetExpectedArrivalNotice_Case08(){

        GetExpectedArrivalNoticeResultBean ret = WorkFlowUtility.getExpectedArrivalNotice(
            null);

        exStringEquals(ret.getSyorikekkaStatus(), "-1", "処理結果ステータス");
    }

    @Test
    @TestOrder(90)
    public void testGetExpectedArrivalNotice_Case09(){

        IwfImageClientMock.mode = "35-09";
        IwfKouteiClientMock.mode = "35-09";

        GetExpectedArrivalNoticeResultBean ret = WorkFlowUtility.getExpectedArrivalNotice(
            new String[] {"MOS12345678901234569", "YUYU12345678901234567"});

        exStringEquals(ret.getSyorikekkaStatus(), "0", "処理結果ステータス");
        exStringEquals(ret.getSyousaiMessageCd(), "IWF0000", "詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), "正常終了しました。", "詳細メッセージコード");
        exStringEquals(ret.getExpectedArrivalNoticeBeanList().get(0).getKouteiKnrId(), "Gyoumukey", "工程管理ＩＤ");
        exStringEquals(ret.getExpectedArrivalNoticeBeanList().get(0).getQrCd(), "YUYU12345678901234567", "ＱＲコード値");
        exStringEquals(ret.getExpectedArrivalNoticeBeanList().get(0).getSyoruiCd(), "kk001", "書類コード");
        exStringEquals(ret.getExpectedArrivalNoticeBeanList().get(0).getSyoruiNmRyaku(), "取込表紙", "書類コード");
        exStringEquals(ret.getExpectedArrivalNoticeBeanList().get(0).getJimutetuzukiCd(), "0001", "事務手続コード");
        exStringEquals(ret.getExpectedArrivalNoticeBeanList().get(0).getSubSystemId(), "common", "サブシステムＩＤ");
    }
}