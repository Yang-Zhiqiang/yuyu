package yuyu.common.workflow.workflowutility;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import yuyu.common.biz.workflow.IwfImageClientMock;
import yuyu.def.workflow.configuration.YuyuWorkflowConfig;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.TestOrder;


/**
 * ワークフロー呼出ユーティリティ(取込書類マスタ取得(書類コード指定))単体テストクラスです。
 */
public class WorkFlowUtilityTest37 extends AbstractTest {

    @BeforeClass
    public static void insertTestData() {
    }

    @Before
    public  void caseInit() {
        IwfImageClientMock.caller = "Test";
        YuyuWorkflowConfig config = YuyuWorkflowConfig.getInstance();
        config.setWorkflowStubMode(false);
    }

    @AfterClass
    public static void testClear() {
        IwfImageClientMock.caller = null;
    }

    @AfterClass
    public static void deleteTestData() {
    }

    @After
    public  void caseTerminat() {
    }

    @Test
    @TestOrder(10)
    public void testGetTorikomiSyoruiMstBySyoruiCd_Case1() {
        IwfImageClientMock.mode = "37-01";
        String syouiCd = "iwf001";
        GetTorikomiSyoruiMstBySyoruiCdResultBean result = WorkFlowUtility.getTorikomiSyoruiMstBySyoruiCd(syouiCd);

        exStringEquals(result.getSyorikekkaStatus(),WorkFlowResultConstants.RESULT_OK, "取込書類マスタ取得(書類コード指定)処理結果:1");
    }

    @Test
    @TestOrder(20)
    public void testGetTorikomiSyoruiMstBySyoruiCd_Case2() {
        IwfImageClientMock.mode = "37-02";
        String syouiCd = "iwf001";
        GetTorikomiSyoruiMstBySyoruiCdResultBean result = WorkFlowUtility.getTorikomiSyoruiMstBySyoruiCd(syouiCd);

        exStringEquals(result.getSyorikekkaStatus(),WorkFlowResultConstants.RESULT_OK, "取込書類マスタ取得(書類コード指定)処理結果:2");
    }

    @Test
    @TestOrder(30)
    public void testGetTorikomiSyoruiMstBySyoruiCd_Case3() {
        IwfImageClientMock.mode = "37-03";
        String syouiCd = "iwf001";
        GetTorikomiSyoruiMstBySyoruiCdResultBean result = WorkFlowUtility.getTorikomiSyoruiMstBySyoruiCd(syouiCd);

        exStringEquals(result.getSyousaiMessageCd(),"IWF0000", "取込書類マスタ取得(書類コード指定)処理結果:3");
    }

    @Test
    @TestOrder(40)
    public void testGetTorikomiSyoruiMstBySyoruiCd_Case4() {
        IwfImageClientMock.mode = "37-04";
        String syouiCd = "iwf001";
        GetTorikomiSyoruiMstBySyoruiCdResultBean result = WorkFlowUtility.getTorikomiSyoruiMstBySyoruiCd(syouiCd);

        exStringEquals(result.getSyousaiMessage(),"正常終了しました。", "取込書類マスタ取得(書類コード指定)処理結果:4");
    }

    @Test
    @TestOrder(50)
    public void testGetTorikomiSyoruiMstBySyoruiCd_Case5() {
        IwfImageClientMock.mode = "37-05";
        String syouiCd = "iwf001";
        GetTorikomiSyoruiMstBySyoruiCdResultBean result = WorkFlowUtility.getTorikomiSyoruiMstBySyoruiCd(syouiCd);

        exStringEquals(result.getSyorikekkaStatus(),"9", "取込書類マスタ取得(書類コード指定)処理結果:5");
    }

    @Test
    @TestOrder(60)
    public void testGetTorikomiSyoruiMstBySyoruiCd_Case6() {
        IwfImageClientMock.mode = "37-06";
        String syouiCd = "iwf001";
        GetTorikomiSyoruiMstBySyoruiCdResultBean result = WorkFlowUtility.getTorikomiSyoruiMstBySyoruiCd(syouiCd);

        exStringEquals(result.getSyorikekkaStatus(),"0", "取込書類マスタ取得(書類コード指定)処理結果:6");
    }

    @Test
    @TestOrder(70)
    public void testGetTorikomiSyoruiMstBySyoruiCd_Case7() {
        IwfImageClientMock.mode = "37-07";
        String syouiCd = "iwf001";
        GetTorikomiSyoruiMstBySyoruiCdResultBean result = WorkFlowUtility.getTorikomiSyoruiMstBySyoruiCd(syouiCd);

        exStringEquals(result.getTorikomiSyoruiBeanList().get(0).getTorikomisyoruicd(),"wf001",
            "取込書類マスタ取得(書類コード指定)処理結果:7-1");
        exStringEquals(result.getTorikomiSyoruiBeanList().get(0).getTorikomisyoruinm(),"取込書類マスタ（書類コード指定）"
            , "取込書類マスタ取得(書類コード指定)処理結果:7-2");
        exStringEquals(result.getTorikomiSyoruiBeanList().get(0).getTorikomisyoruiryaku(),"取込書類（コード指定）",
            "取込書類マスタ取得(書類コード指定)処理結果:7-3");
        exStringEquals(result.getTorikomiSyoruiBeanList().get(0).getSyzksyoubunruiid(),"syoubunrui",
            "取込書類マスタ取得(書類コード指定)処理結果:7-4");
        exStringEquals(result.getTorikomiSyoruiBeanList().get(0).getSyzkdaibunruiid(),"daibunrui",
            "取込書類マスタ取得(書類コード指定)処理結果:7-5");
        exStringEquals(result.getTorikomiSyoruiBeanList().get(0).getFlowid(),"Jimutetuzuki01",
            "取込書類マスタ取得(書類コード指定)処理結果:7-6");
        exStringEquals(result.getTorikomiSyoruiBeanList().get(0).getZiphozonkbn(),"1",
            "取込書類マスタ取得(書類コード指定)処理結果:7-7");
        exStringEquals(result.getTorikomiSyoruiBeanList().get(0).getKouteiseigyoumukbn(),"0",
            "取込書類マスタ取得(書類コード指定)処理結果:7-8");
        exStringEquals(result.getTorikomiSyoruiBeanList().get(0).getNodeid(),"タスク名",
            "取込書類マスタ取得(書類コード指定)処理結果:7-9");

    }

    @Test
    @TestOrder(80)
    public void testGetTorikomiSyoruiMstBySyoruiCd_Case8() {
        IwfImageClientMock.mode = "37-08";
        String syouiCd = "iwf001";
        GetTorikomiSyoruiMstBySyoruiCdResultBean result = WorkFlowUtility.getTorikomiSyoruiMstBySyoruiCd(syouiCd);

        exStringEquals(result.getSyorikekkaStatus(),"0", "取込書類マスタ取得(書類コード指定)処理結果:8-1");
        exStringEquals(result.getTorikomiSyoruiBeanList().get(0).getTorikomisyoruicd(),"wf001",
            "取込書類マスタ取得(書類コード指定)処理結果:8-2");
        exStringEquals(result.getTorikomiSyoruiBeanList().get(0).getTorikomisyoruinm(),"取込書類マスタ（書類コード指定）"
            , "取込書類マスタ取得(書類コード指定)処理結果:8-3");
        exStringEquals(result.getTorikomiSyoruiBeanList().get(0).getTorikomisyoruiryaku(),"取込書類（コード指定）",
            "取込書類マスタ取得(書類コード指定)処理結果:8-4");
        exStringEquals(result.getTorikomiSyoruiBeanList().get(0).getSyzksyoubunruiid(),"syoubunrui",
            "取込書類マスタ取得(書類コード指定)処理結果:8-5");
        exStringEquals(result.getTorikomiSyoruiBeanList().get(0).getSyzkdaibunruiid(),"daibunrui",
            "取込書類マスタ取得(書類コード指定)処理結果:8-6");
        exStringEquals(result.getTorikomiSyoruiBeanList().get(0).getFlowid(),"Jimutetuzuki01",
            "取込書類マスタ取得(書類コード指定)処理結果:8-7");
        exStringEquals(result.getTorikomiSyoruiBeanList().get(0).getZiphozonkbn(),"1",
            "取込書類マスタ取得(書類コード指定)処理結果:8-8");
        exStringEquals(result.getTorikomiSyoruiBeanList().get(0).getKouteiseigyoumukbn(),"0",
            "取込書類マスタ取得(書類コード指定)処理結果:8-9");
        exStringEquals(result.getTorikomiSyoruiBeanList().get(0).getNodeid(),"タスク名",
            "取込書類マスタ取得(書類コード指定)処理結果:8-10");
        exStringEquals(result.getTorikomiSyoruiBeanList().get(1).getTorikomisyoruicd(),"wf002",
            "取込書類マスタ取得(書類コード指定)処理結果:8-11");
        exStringEquals(result.getTorikomiSyoruiBeanList().get(1).getTorikomisyoruinm(),"取込書類マスタ（書類コード指定）"
            , "取込書類マスタ取得(書類コード指定)処理結果:8-12");
        exStringEquals(result.getTorikomiSyoruiBeanList().get(1).getTorikomisyoruiryaku(),"取込書類（コード指定）",
            "取込書類マスタ取得(書類コード指定)処理結果:8-13");
        exStringEquals(result.getTorikomiSyoruiBeanList().get(1).getSyzksyoubunruiid(),"syoubunrui",
            "取込書類マスタ取得(書類コード指定)処理結果:8-14");
        exStringEquals(result.getTorikomiSyoruiBeanList().get(1).getSyzkdaibunruiid(),"daibunrui",
            "取込書類マスタ取得(書類コード指定)処理結果:8-15");
        exStringEquals(result.getTorikomiSyoruiBeanList().get(1).getFlowid(),"Jimutetuzuki02",
            "取込書類マスタ取得(書類コード指定)処理結果:8-16");
        exStringEquals(result.getTorikomiSyoruiBeanList().get(1).getZiphozonkbn(),"1",
            "取込書類マスタ取得(書類コード指定)処理結果:8-17");
        exStringEquals(result.getTorikomiSyoruiBeanList().get(1).getKouteiseigyoumukbn(),"0",
            "取込書類マスタ取得(書類コード指定)処理結果:8-18");
        exStringEquals(result.getTorikomiSyoruiBeanList().get(1).getNodeid(),"タスク名",
            "取込書類マスタ取得(書類コード指定)処理結果:8-19");
    }

    @Test
    @TestOrder(90)
    public void testGetTorikomiSyoruiMstBySyoruiCd_Case9() {
        IwfImageClientMock.mode = "37-09";
        String syouiCd = "iwf001";
        GetTorikomiSyoruiMstBySyoruiCdResultBean result = WorkFlowUtility.getTorikomiSyoruiMstBySyoruiCd(syouiCd);

        exStringEquals(result.getSyorikekkaStatus(),"-1", "取込書類マスタ取得(書類コード指定)処理結果:9");
    }

}
