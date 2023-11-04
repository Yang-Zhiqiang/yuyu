package yuyu.common.workflow.workflowutility;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.workflow.IwfImageClientMock;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.BM_TorikomiSyoruiHukaInfo;
import yuyu.def.db.entity.DM_Jimutetuzuki;
import yuyu.def.workflow.configuration.YuyuWorkflowConfig;
import yuyu.def.workflow.manager.WorkflowDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.TestOrder;


/**
 * ワークフロー呼出ユーティリティ(スキャン対象取込書類マスタ取得)単体テストクラスです。
 */
public class WorkFlowUtilityTest38 extends AbstractTest {
    private final static String fileName = "UT_SP_単体テスト仕様書_【38_スキャン対象取込書類マスタ取得】";
    private final static String sheetName = "テストデータ";
    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(WorkFlowUtilityTest38.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);

        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }

    }

    @Before
    public  void caseInit() {

        IwfImageClientMock.caller = "Test";
        YuyuWorkflowConfig config = YuyuWorkflowConfig.getInstance();
        config.setWorkflowStubMode(false);
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        IwfImageClientMock.caller = null;
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        WorkflowDomManager workflowDomManager = SWAKInjector.getInstance(WorkflowDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        DM_Jimutetuzuki data = workflowDomManager.getJimutetuzuki("0001", "Subsystem01");

        workflowDomManager.delete(data);

        BM_TorikomiSyoruiHukaInfo fukaInfo = bizDomManager.getTorikomiSyoruiHukaInfo(C_SyoruiCdKbn.WF_HYOUSI);
        bizDomManager.delete(fukaInfo);

        fukaInfo = bizDomManager.getTorikomiSyoruiHukaInfo(C_SyoruiCdKbn.WF_QRSEAL);
        bizDomManager.delete(fukaInfo);

    }

    @After
    public  void caseTerminat() {

    }

    @Test
    @TestOrder(10)
    public void testGetScanTorikomiSyoruiMst_Case01() {
        IwfImageClientMock.mode = "38-01";
        GetScanTorikomiSyoruiMstResultBean result =
            WorkFlowUtility.getScanTorikomiSyoruiMst("0001");


        exStringEquals(result.getSyorikekkaStatus(), "9", "スキャン対象取込書類マスタ取得処理結果:1");
    }

    @Test
    @TestOrder(20)
    public void testGetScanTorikomiSyoruiMst_Case02() {
        IwfImageClientMock.mode = "38-02";
        GetScanTorikomiSyoruiMstResultBean result =
            WorkFlowUtility.getScanTorikomiSyoruiMst("0001");


        exStringEquals(result.getSyousaiMessageCd(), "IWF0003", "スキャン対象取込書類マスタ取得処理結果:2");
    }

    @Test
    @TestOrder(30)
    public void testGetScanTorikomiSyoruiMst_Case03() {
        IwfImageClientMock.mode = "38-03";
        GetScanTorikomiSyoruiMstResultBean result =
            WorkFlowUtility.getScanTorikomiSyoruiMst("0001");


        exStringEquals(result.getSyousaiMessage(), "稼働時間外エラーか、認証エラーが発生しました。", "スキャン対象取込書類マスタ取得処理結果:3");
    }

    @Test
    @TestOrder(40)
    public void testGetScanTorikomiSyoruiMst_Case04() {
        IwfImageClientMock.mode = "38-04";
        GetScanTorikomiSyoruiMstResultBean result =
            WorkFlowUtility.getScanTorikomiSyoruiMst("0001");


        exStringEquals(result.getSyorikekkaStatus(), "9", "スキャン対象取込書類マスタ取得処理結果:3");
    }

    @Test
    @TestOrder(50)
    public void testGetScanTorikomiSyoruiMst_Case05() {
        IwfImageClientMock.mode = "38-05";
        GetScanTorikomiSyoruiMstResultBean result =
            WorkFlowUtility.getScanTorikomiSyoruiMst("0001");


        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(0).getSyoruiCd(), "wf002", "スキャン対象取込書類マスタ取得処理結果:5-1");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(0).getSyoruiNm(), "QRシール", "スキャン対象取込書類マスタ取得処理結果:5-2");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(0).getSyoruiRyakuNm(), "シール", "スキャン対象取込書類マスタ取得処理結果:5-3");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(0).getSyzkSyouBunruiId(), "syobun02", "スキャン対象取込書類マスタ取得処理結果:5-4");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(0).getSyzkDaiBunruiId(), "daibun02", "スキャン対象取込書類マスタ取得処理結果:5-5");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(0).getJimutetuzukiCd(), "0001", "スキャン対象取込書類マスタ取得処理結果:5-6");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(0).getZipHozonKbn(), "z02", "スキャン対象取込書類マスタ取得処理結果:5-7");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(0).getKouteiSeigyoUmuKbn(), "k02", "スキャン対象取込書類マスタ取得処理結果:5-8");

        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(1).getSyoruiCd(), "wf001", "スキャン対象取込書類マスタ取得処理結果:5-9");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(1).getSyoruiNm(), "取込用表紙", "スキャン対象取込書類マスタ取得処理結果:5-10");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(1).getSyoruiRyakuNm(), "取込表紙", "スキャン対象取込書類マスタ取得処理結果:5-11");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(1).getSyzkSyouBunruiId(), "syobun01", "スキャン対象取込書類マスタ取得処理結果:5-12");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(1).getSyzkDaiBunruiId(), "daibun01", "スキャン対象取込書類マスタ取得処理結果:5-13");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(1).getJimutetuzukiCd(), "0001", "スキャン対象取込書類マスタ取得処理結果:5-14");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(1).getZipHozonKbn(), "z01", "スキャン対象取込書類マスタ取得処理結果:5-15");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(1).getKouteiSeigyoUmuKbn(), "k01", "スキャン対象取込書類マスタ取得処理結果:5-16");
    }

    @Test
    @TestOrder(60)
    public void testGetScanTorikomiSyoruiMst_Case06() {
        IwfImageClientMock.mode = "38-06";
        GetScanTorikomiSyoruiMstResultBean result =
            WorkFlowUtility.getScanTorikomiSyoruiMst("0001");


        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(0).getTaskNm(), "住所変更請求書到着", "スキャン対象取込書類マスタ取得処理結果:6-1");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(1).getTaskNm(), "住所変更請求書作成", "スキャン対象取込書類マスタ取得処理結果:6-2");
    }

    @Test
    @TestOrder(70)
    public void testGetScanTorikomiSyoruiMst_Case07() {
        IwfImageClientMock.mode = "38-07";
        GetScanTorikomiSyoruiMstResultBean result =
            WorkFlowUtility.getScanTorikomiSyoruiMst("0001");


        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(0).getTaskNm(), null, "スキャン対象取込書類マスタ取得処理結果:7-1");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(1).getTaskNm(), "住所変更請求書作成", "スキャン対象取込書類マスタ取得処理結果:7-2");
    }

    @Test
    @TestOrder(80)
    public void testGetScanTorikomiSyoruiMst_Case08() {
        IwfImageClientMock.mode = "38-08";
        GetScanTorikomiSyoruiMstResultBean result =
            WorkFlowUtility.getScanTorikomiSyoruiMst("0001");


        exNumericEquals(result.getTorikomiSyoruiMstBeanList().size(), 1, "スキャン対象取込書類マスタ取得処理結果:8-1");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(0).getSyoruiCd(), "wf002", "スキャン対象取込書類マスタ取得処理結果:8-2");
    }

    @Test
    @TestOrder(90)
    public void testGetScanTorikomiSyoruiMst_Case09() {
        IwfImageClientMock.mode = "38-09";
        GetScanTorikomiSyoruiMstResultBean result =
            WorkFlowUtility.getScanTorikomiSyoruiMst("0001");


        exNumericEquals(result.getTorikomiSyoruiMstBeanList().size(), 1, "スキャン対象取込書類マスタ取得処理結果:9-1");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(0).getSyoruiCd(), "wf002", "スキャン対象取込書類マスタ取得処理結果:9-2");
    }

    @Test
    @TestOrder(100)
    public void testGetScanTorikomiSyoruiMst_Case10() {
        IwfImageClientMock.mode = "38-10";
        GetScanTorikomiSyoruiMstResultBean result =
            WorkFlowUtility.getScanTorikomiSyoruiMst("0001");


        exNumericEquals(result.getTorikomiSyoruiMstBeanList().size(), 2, "スキャン対象取込書類マスタ取得処理結果:10-1");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(0).getSyoruiCd(), "wf002", "スキャン対象取込書類マスタ取得処理結果:10-2");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(1).getSyoruiCd(), "wf001", "スキャン対象取込書類マスタ取得処理結果:10-3");
    }

    @Test
    @TestOrder(110)
    public void testGetScanTorikomiSyoruiMst_Case11() {
        IwfImageClientMock.mode = "38-11";
        GetScanTorikomiSyoruiMstResultBean result =
            WorkFlowUtility.getScanTorikomiSyoruiMst("0001");


        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(0).getSyoruiCd(), "wf002", "スキャン対象取込書類マスタ取得処理結果:11-2");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(1).getSyoruiCd(), "wf001", "スキャン対象取込書類マスタ取得処理結果:11-3");
    }

    @Test
    @TestOrder(120)
    public void testGetScanTorikomiSyoruiMst_Case12() {
        IwfImageClientMock.mode = "38-12";
        GetScanTorikomiSyoruiMstResultBean result =
            WorkFlowUtility.getScanTorikomiSyoruiMst("0001");


        exStringEquals(result.getSyorikekkaStatus(), "-1", "スキャン対象取込書類マスタ取得処理結果:12");
    }

    @Test
    @TestOrder(130)
    public void testGetScanTorikomiSyoruiMst_Case13() {
        IwfImageClientMock.mode = "38-13";
        GetScanTorikomiSyoruiMstResultBean result =
            WorkFlowUtility.getScanTorikomiSyoruiMst("0001");


        exStringEquals(result.getSyorikekkaStatus(), "0", "スキャン対象取込書類マスタ取得処理結果:13");
    }


    @Test
    @TestOrder(140)
    public void testGetScanTorikomiSyoruiMst_Case14() {
        IwfImageClientMock.mode = "38-14";
        GetScanTorikomiSyoruiMstResultBean result =
            WorkFlowUtility.getScanTorikomiSyoruiMst("0001");


        exStringEquals(result.getSyorikekkaStatus(), "-1", "スキャン対象取込書類マスタ取得処理結果:14");

    }

    @Test
    @TestOrder(150)
    @Transactional
    public void testGetScanTorikomiSyoruiMst_Case15() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        BM_TorikomiSyoruiHukaInfo fukaInfo = bizDomManager.getTorikomiSyoruiHukaInfo(C_SyoruiCdKbn.WF_HYOUSI);
        BM_TorikomiSyoruiHukaInfo fukaInfo1 = bizDomManager.getTorikomiSyoruiHukaInfo(C_SyoruiCdKbn.WF_QRSEAL);
        bizDomManager.delete(fukaInfo);
        bizDomManager.delete(fukaInfo1);
        IwfImageClientMock.mode = "38-14";
        GetScanTorikomiSyoruiMstResultBean result =
            WorkFlowUtility.getScanTorikomiSyoruiMst("0001");


        exStringEquals(result.getSyorikekkaStatus(), "-1", "スキャン対象取込書類マスタ取得処理結果:15");

        insertTestData();

    }

}
