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
 * ワークフロー呼出ユーティリティ(取込書類マスタ取得)単体テストクラスです。
 */
public class WorkFlowUtilityTest18 extends AbstractTest {

    private final static String fileName = "UT_SP_単体テスト仕様書_【18_取込書類マスタ取得】";
    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(WorkFlowUtilityTest18.class, fileName, sheetName);
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

        DM_Jimutetuzuki data = workflowDomManager.getJimutetuzuki("0001", "Subsystem01");

        workflowDomManager.delete(data);

        data = workflowDomManager.getJimutetuzuki("0002", "Subsystem01");

        workflowDomManager.delete(data);

        data = workflowDomManager.getJimutetuzuki("0003", "Subsystem01");

        workflowDomManager.delete(data);
    }

    @After
    public  void caseTerminat() {

    }

    @Test
    @TestOrder(10)
    public void testGetTorikomiSyoruiMst_Case1() {
        IwfImageClientMock.mode = "18-01";
        GetTorikomiSyoruiMstResultBean result = WorkFlowUtility.getTorikomiSyoruiMst(null);


        exStringEquals(result.getSyorikekkaStatus(),WorkFlowResultConstants.RESULT_OK, "取込書類マスタ取得処理結果:1");
    }

    @Test
    @TestOrder(20)
    public void testGetTorikomiSyoruiMst_Case2() {
        IwfImageClientMock.mode = "18-02";
        String[] jimutetuzuki = {"0001","0002","0003"};
        GetTorikomiSyoruiMstResultBean result = WorkFlowUtility.getTorikomiSyoruiMst(jimutetuzuki);



        exStringEquals(result.getSyorikekkaStatus(),WorkFlowResultConstants.RESULT_OK, "取込書類マスタ取得処理結果:2");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(0).getJimutetuzukiCd(),"0001", "取込書類マスタ取得処理結果:2-2");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(0).getSyoruiCd(),"wf001", "取込書類マスタ取得処理結果:2-3");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(0).getSyoruiNm(),"取込書類マスタ", "取込書類マスタ取得処理結果:2-4");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(0).getSyoruiRyakuNm(),"取込書類", "取込書類マスタ取得処理結果:2-5");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(0).getSyzkSyouBunruiId(),"syoubunrui", "取込書類マスタ取得処理結果:2-6");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(0).getSyzkDaiBunruiId(),"daibunrui", "取込書類マスタ取得処理結果:2-7");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(0).getZipHozonKbn(),"1", "取込書類マスタ取得処理結果:2-8");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(0).getKouteiSeigyoUmuKbn(),"0", "取込書類マスタ取得処理結果:2-9");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(0).getTaskNm(),"タスク名01", "取込書類マスタ取得処理結果:2-10");


        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(1).getJimutetuzukiCd(),"0002", "取込書類マスタ取得処理結果:2-11");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(1).getSyoruiCd(),"wf002", "取込書類マスタ取得処理結果:2-12");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(1).getSyoruiNm(),"取込書類マスタ", "取込書類マスタ取得処理結果:2-13");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(1).getSyoruiRyakuNm(),"取込書類", "取込書類マスタ取得処理結果:2-14");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(1).getSyzkSyouBunruiId(),"syoubunrui", "取込書類マスタ取得処理結果:2-15");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(1).getSyzkDaiBunruiId(),"daibunrui", "取込書類マスタ取得処理結果:2-16");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(1).getZipHozonKbn(),"1", "取込書類マスタ取得処理結果:2-17");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(1).getKouteiSeigyoUmuKbn(),"0", "取込書類マスタ取得処理結果:2-18");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(1).getTaskNm(),"タスク名02", "取込書類マスタ取得処理結果:2-19");

        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(2).getJimutetuzukiCd(),"0003", "取込書類マスタ取得処理結果:2-20");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(2).getSyoruiCd(),"wf003", "取込書類マスタ取得処理結果:2-21");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(2).getSyoruiNm(),"取込書類マスタ", "取込書類マスタ取得処理結果:2-22");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(2).getSyoruiRyakuNm(),"取込書類", "取込書類マスタ取得処理結果:2-23");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(2).getSyzkSyouBunruiId(),"syoubunrui", "取込書類マスタ取得処理結果:2-24");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(2).getSyzkDaiBunruiId(),"daibunrui", "取込書類マスタ取得処理結果:2-25");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(2).getZipHozonKbn(),"1", "取込書類マスタ取得処理結果:2-26");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(2).getKouteiSeigyoUmuKbn(),"0", "取込書類マスタ取得処理結果:2-27");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(2).getTaskNm(),"タスク名03", "取込書類マスタ取得処理結果:2-28");
    }

    @Test
    @TestOrder(30)
    public void testGetTorikomiSyoruiMst_Case3() {
        IwfImageClientMock.mode = "18-03";
        String[] jimutetuzuki = {"0001","0002","0003"};
        GetTorikomiSyoruiMstResultBean result = WorkFlowUtility.getTorikomiSyoruiMst(jimutetuzuki);


        exStringEquals(result.getSyousaiMessageCd(),"IWF0000", "取込書類マスタ取得処理結果:3");
    }

    @Test
    @TestOrder(40)
    public void testGetTorikomiSyoruiMst_Case4() {
        IwfImageClientMock.mode = "18-04";
        String[] jimutetuzuki = {"0001","0002","0003"};
        GetTorikomiSyoruiMstResultBean result = WorkFlowUtility.getTorikomiSyoruiMst(jimutetuzuki);


        exStringEquals(result.getSyousaiMessage(),"正常終了しました。", "取込書類マスタ取得処理結果:4");
    }

    @Test
    @TestOrder(50)
    public void testGetTorikomiSyoruiMst_Case5() {
        IwfImageClientMock.mode = "18-05";
        String[] jimutetuzuki = {"0001","0002","0003"};
        GetTorikomiSyoruiMstResultBean result = WorkFlowUtility.getTorikomiSyoruiMst(jimutetuzuki);


        exStringEquals(result.getSyorikekkaStatus(),"9", "取込書類マスタ取得処理結果:5");
    }

    @Test
    @TestOrder(60)
    public void testGetTorikomiSyoruiMst_Case6() {
        IwfImageClientMock.mode = "18-06";
        String[] jimutetuzuki = {"0001","0002","0003"};
        GetTorikomiSyoruiMstResultBean result = WorkFlowUtility.getTorikomiSyoruiMst(jimutetuzuki);


        exStringEquals(result.getSyorikekkaStatus(),"0", "取込書類マスタ取得処理結果:6");
    }

    @Test
    @TestOrder(70)
    public void testGetTorikomiSyoruiMst_Case7() {
        IwfImageClientMock.mode = "18-07";
        String[] jimutetuzuki = {"0001","0002","0003"};
        GetTorikomiSyoruiMstResultBean result = WorkFlowUtility.getTorikomiSyoruiMst(jimutetuzuki);


        exStringEquals(result.getSyorikekkaStatus(),"0", "取込書類マスタ取得処理結果:7-1");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(0).getJimutetuzukiCd(),"0001", "取込書類マスタ取得処理結果:7-2");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(0).getSyoruiCd(),"wf001", "取込書類マスタ取得処理結果:7-3");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(0).getSyoruiNm(),"取込書類マスタ", "取込書類マスタ取得処理結果:7-4");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(0).getSyoruiRyakuNm(),"取込書類", "取込書類マスタ取得処理結果:7-5");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(0).getSyzkSyouBunruiId(),"syoubunrui", "取込書類マスタ取得処理結果:7-6");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(0).getSyzkDaiBunruiId(),"daibunrui", "取込書類マスタ取得処理結果:7-7");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(0).getZipHozonKbn(),"1", "取込書類マスタ取得処理結果:7-8");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(0).getKouteiSeigyoUmuKbn(),"0", "取込書類マスタ取得処理結果:7-9");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(0).getTaskNm(),"タスク名01", "取込書類マスタ取得処理結果:7-10");
    }

    @Test
    @TestOrder(80)
    public void testGetTorikomiSyoruiMst_Case8() {
        IwfImageClientMock.mode = "18-10";
        String[] jimutetuzuki = {"0003","0002","0001"};
        GetTorikomiSyoruiMstResultBean result = WorkFlowUtility.getTorikomiSyoruiMst(jimutetuzuki);



        exStringEquals(result.getSyorikekkaStatus(),"0", "取込書類マスタ取得処理結果:8-1");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(0).getJimutetuzukiCd(),"0003", "取込書類マスタ取得処理結果:8-2");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(0).getSyoruiCd(),"hk031", "取込書類マスタ取得処理結果:8-3");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(0).getSyoruiNm(),"取込書類マスタ", "取込書類マスタ取得処理結果:8-4");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(0).getSyoruiRyakuNm(),"取込書類", "取込書類マスタ取得処理結果:8-5");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(0).getSyzkSyouBunruiId(),"syoubunrui", "取込書類マスタ取得処理結果:8-6");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(0).getSyzkDaiBunruiId(),"daibunrui", "取込書類マスタ取得処理結果:8-7");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(0).getZipHozonKbn(),"1", "取込書類マスタ取得処理結果:8-8");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(0).getKouteiSeigyoUmuKbn(),"0", "取込書類マスタ取得処理結果:8-9");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(0).getTaskNm(),"タスク名03", "取込書類マスタ取得処理結果:8-10");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(1).getJimutetuzukiCd(),"0001", "取込書類マスタ取得処理結果:8-11");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(1).getSyoruiCd(),"hk011", "取込書類マスタ取得処理結果:8-12");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(1).getSyoruiNm(),"取込書類マスタ", "取込書類マスタ取得処理結果:8-13");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(1).getSyoruiRyakuNm(),"取込書類", "取込書類マスタ取得処理結果:8-14");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(1).getSyzkSyouBunruiId(),"syoubunrui", "取込書類マスタ取得処理結果:8-15");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(1).getSyzkDaiBunruiId(),"daibunrui", "取込書類マスタ取得処理結果:8-16");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(1).getZipHozonKbn(),"1", "取込書類マスタ取得処理結果:8-17");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(1).getKouteiSeigyoUmuKbn(),"0", "取込書類マスタ取得処理結果:8-18");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(1).getTaskNm(),"タスク名01", "取込書類マスタ取得処理結果:8-19");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(2).getJimutetuzukiCd(),"0002", "取込書類マスタ取得処理結果:8-20");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(2).getSyoruiCd(),"hk015", "取込書類マスタ取得処理結果:8-21");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(2).getSyoruiNm(),"取込書類マスタ", "取込書類マスタ取得処理結果:8-22");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(2).getSyoruiRyakuNm(),"取込書類", "取込書類マスタ取得処理結果:8-23");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(2).getSyzkSyouBunruiId(),"syoubunrui", "取込書類マスタ取得処理結果:8-24");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(2).getSyzkDaiBunruiId(),"daibunrui", "取込書類マスタ取得処理結果:8-25");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(2).getZipHozonKbn(),"1", "取込書類マスタ取得処理結果:8-26");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(2).getKouteiSeigyoUmuKbn(),"0", "取込書類マスタ取得処理結果:8-27");
        exStringEquals(result.getTorikomiSyoruiMstBeanList().get(2).getTaskNm(),"タスク名02", "取込書類マスタ取得処理結果:8-28");

    }

    @Test
    @TestOrder(90)
    public void testGetTorikomiSyoruiMst_Case9() {
        IwfImageClientMock.mode = "18-09";
        String[] jimutetuzuki = {"0001","0002","0003"};
        GetTorikomiSyoruiMstResultBean result = WorkFlowUtility.getTorikomiSyoruiMst(jimutetuzuki);


        exStringEquals(result.getSyorikekkaStatus(),"-1", "取込書類マスタ取得処理結果:9");

    }

    @Test
    @TestOrder(100)
    public void testGetTorikomiSyoruiMst_Case10() {
        IwfImageClientMock.mode = "18-01";
        String[] jimutetuzuki = new String[0];
        GetTorikomiSyoruiMstResultBean result = WorkFlowUtility.getTorikomiSyoruiMst(jimutetuzuki);


        exStringEquals(result.getSyorikekkaStatus(),WorkFlowResultConstants.RESULT_OK, "取込書類マスタ取得処理結果:10");
    }

    @Test
    @TestOrder(110)
    public void testGetTorikomiSyoruiMst_Case11() {
        IwfImageClientMock.mode = "18-11";
        String[] jimutetuzuki = {"0001","0002","0003"};
        GetTorikomiSyoruiMstResultBean result = WorkFlowUtility.getTorikomiSyoruiMst(jimutetuzuki);


        exStringEquals(result.getSyorikekkaStatus(),WorkFlowResultConstants.RESULT_NODATA, "取込書類マスタ取得処理結果:11");
    }

    @Test
    @TestOrder(120)
    @Transactional
    public void testGetTorikomiSyoruiMst_Case12() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        BM_TorikomiSyoruiHukaInfo HukaInfo = bizDomManager.getTorikomiSyoruiHukaInfo(C_SyoruiCdKbn.HK_SB_HOKEN_SKS);
        BM_TorikomiSyoruiHukaInfo HukaInfo1 = bizDomManager.getTorikomiSyoruiHukaInfo(C_SyoruiCdKbn.HK_SEISANKINHRKM_IRAIS);
        BM_TorikomiSyoruiHukaInfo HukaInfo2 = bizDomManager.getTorikomiSyoruiHukaInfo(C_SyoruiCdKbn.HK_SB_DAIHYOU);
        bizDomManager.delete(HukaInfo);
        bizDomManager.delete(HukaInfo1);
        bizDomManager.delete(HukaInfo2);

        IwfImageClientMock.mode = "18-01";
        GetTorikomiSyoruiMstResultBean result = WorkFlowUtility.getTorikomiSyoruiMst(null);

        exStringEquals(result.getSyorikekkaStatus(),WorkFlowResultConstants.RESULT_NODATA, "取込書類マスタ取得処理結果:12");
        insertTestData();
    }

}
