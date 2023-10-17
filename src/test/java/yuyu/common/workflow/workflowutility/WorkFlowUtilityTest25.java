package yuyu.common.workflow.workflowutility;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.workflow.IwfAccountClientMock;
import yuyu.common.biz.workflow.IwfImageClientMock;
import yuyu.def.workflow.configuration.YuyuWorkflowConfig;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.TestOrder;

/**
 * ワークフロー呼出ユーティリティ(書類権限取得)単体テストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class WorkFlowUtilityTest25 extends AbstractTest {

    @BeforeClass
    public static void insertTestData() {
    }

    @Before
    public  void caseInit() {
        IwfImageClientMock.caller = "Test";
        IwfAccountClientMock.caller = "Test";
        YuyuWorkflowConfig config = YuyuWorkflowConfig.getInstance();
        config.setWorkflowStubMode(false);
    }

    @AfterClass
    public static void testClear() {
        IwfImageClientMock.caller = null;
        IwfAccountClientMock.caller = null;
    }

    @AfterClass
    public static void deleteTestData() {
    }

    @After
    public  void caseTerminat() {
    }

    @Test
    @TestOrder(10)
    public void testGetSyoruiKengen_Case01(){
        IwfImageClientMock.mode = "25-01";
        IwfAccountClientMock.mode = "25-01";
        GetSyoruiKengenResultBean ret = WorkFlowUtility.getSyoruiKengen(
            "0001",
            new String[] {"0001","0003","0002"},
            null);
        exStringEquals(ret.getSyoruiKengenBeanList().get(0).getSyoruiCd(), "wf001", "書類権限取得処理結果:1-1");
        exStringEquals(ret.getSyoruiKengenBeanList().get(1).getSyoruiCd(), "wf003", "書類権限取得処理結果:1-2");
        exStringEquals(ret.getSyoruiKengenBeanList().get(2).getSyoruiCd(), "wf002", "書類権限取得処理結果:1-3");
    }

    @Test
    @TestOrder(20)
    public void testGetSyoruiKengen_Case02(){
        IwfImageClientMock.mode = "25-02";
        IwfAccountClientMock.mode = "25-02";
        GetSyoruiKengenResultBean ret = WorkFlowUtility.getSyoruiKengen(
            "0001",
            new String[] {"0001","0003","0002"},
            null);
        exStringEquals(ret.getSyousaiMessageCd(), "IWF0003", "書類権限取得処理結果:2");
    }

    @Test
    @TestOrder(30)
    public void testGetSyoruiKengen_Case03(){
        IwfImageClientMock.mode = "25-03";
        IwfAccountClientMock.mode = "25-03";
        GetSyoruiKengenResultBean ret = WorkFlowUtility.getSyoruiKengen(
            "0001",
            new String[] {"0001","0003","0002"},
            null);
        exStringEquals(ret.getSyousaiMessage(), "稼働時間外エラーか、認証エラーが発生しました。", "書類権限取得処理結果:3");
    }

    @Test
    @TestOrder(40)
    public void testGetSyoruiKengen_Case04(){
        IwfImageClientMock.mode = "25-04";
        IwfAccountClientMock.mode = "25-04";
        GetSyoruiKengenResultBean ret = WorkFlowUtility.getSyoruiKengen(
            "0001",
            new String[] {"0001","0003","0002"},
            null);
        exStringEquals(ret.getSyorikekkaStatus(), "9", "書類権限取得処理結果:4");
    }

    @Test
    @TestOrder(50)
    public void testGetSyoruiKengen_Case05(){
        IwfImageClientMock.mode = "25-05";
        IwfAccountClientMock.mode = "25-05";
        GetSyoruiKengenResultBean ret = WorkFlowUtility.getSyoruiKengen(
            "0001",
            new String[] {"0001","0003","0002"},
            null);
        exStringEquals(ret.getSyoruiKengenBeanList().get(0).getSyoruiCd(), "wf001", "書類権限取得処理結果:5-1");
        exStringEquals(ret.getSyoruiKengenBeanList().get(0).getSyoruiNm(), "取込用表紙", "書類権限取得処理結果:5-2");
        exStringEquals(ret.getSyoruiKengenBeanList().get(0).getJimutetuzukiCd(), "0001", "書類権限取得処理結果:5-3");

        exStringEquals(ret.getSyoruiKengenBeanList().get(1).getSyoruiCd(), "wf002", "書類権限取得処理結果:5-4");
        exStringEquals(ret.getSyoruiKengenBeanList().get(1).getSyoruiNm(), "QRシール", "書類権限取得処理結果:5-5");
        exStringEquals(ret.getSyoruiKengenBeanList().get(1).getJimutetuzukiCd(), "0001", "書類権限取得処理結果:5-6");

        exStringEquals(ret.getSyoruiKengenBeanList().get(2).getSyoruiCd(), "nk001", "書類権限取得処理結果:5-7");
        exStringEquals(ret.getSyoruiKengenBeanList().get(2).getSyoruiNm(), "年金帳票１", "書類権限取得処理結果:5-8");
        exStringEquals(ret.getSyoruiKengenBeanList().get(2).getJimutetuzukiCd(), "0003", "書類権限取得処理結果:5-9");

        exStringEquals(ret.getSyoruiKengenBeanList().get(3).getSyoruiCd(), "nk003", "書類権限取得処理結果:5-10");
        exStringEquals(ret.getSyoruiKengenBeanList().get(3).getSyoruiNm(), "年金帳票３", "書類権限取得処理結果:5-11");
        exStringEquals(ret.getSyoruiKengenBeanList().get(3).getJimutetuzukiCd(), "0003", "書類権限取得処理結果:5-12");

        exStringEquals(ret.getSyoruiKengenBeanList().get(4).getSyoruiCd(), "hz001", "書類権限取得処理結果:5-13");
        exStringEquals(ret.getSyoruiKengenBeanList().get(4).getSyoruiNm(), "保全帳票１", "書類権限取得処理結果:5-14");
        exStringEquals(ret.getSyoruiKengenBeanList().get(4).getJimutetuzukiCd(), "0002", "書類権限取得処理結果:5-15");

        exStringEquals(ret.getSyoruiKengenBeanList().get(5).getSyoruiCd(), "hz002", "書類権限取得処理結果:5-16");
        exStringEquals(ret.getSyoruiKengenBeanList().get(5).getSyoruiNm(), "保全帳票２", "書類権限取得処理結果:5-17");
        exStringEquals(ret.getSyoruiKengenBeanList().get(5).getJimutetuzukiCd(), "0002", "書類権限取得処理結果:5-18");
    }

    @Test
    @TestOrder(60)
    public void testGetSyoruiKengen_Case06(){
        IwfImageClientMock.mode = "25-06";
        IwfAccountClientMock.mode = "25-06";
        GetSyoruiKengenResultBean ret = WorkFlowUtility.getSyoruiKengen(
            "0001",
            new String[] {"0001","0003","0002"},
            null);

        exStringEquals(ret.getSyoruiKengenBeanList().get(0).getKengenFlg(), "1", "書類権限取得処理結果:6-1");
        exStringEquals(ret.getSyoruiKengenBeanList().get(1).getKengenFlg(), "0", "書類権限取得処理結果:6-2");
        exStringEquals(ret.getSyoruiKengenBeanList().get(2).getKengenFlg(), "1", "書類権限取得処理結果:6-3");
        exStringEquals(ret.getSyoruiKengenBeanList().get(3).getKengenFlg(), "0", "書類権限取得処理結果:6-4");
        exStringEquals(ret.getSyoruiKengenBeanList().get(4).getKengenFlg(), "1", "書類権限取得処理結果:6-5");
        exStringEquals(ret.getSyoruiKengenBeanList().get(5).getKengenFlg(), "0", "書類権限取得処理結果:6-6");
    }

    @Test
    @TestOrder(70)
    public void testGetSyoruiKengen_Case07(){
        IwfImageClientMock.mode = "25-07";
        IwfAccountClientMock.mode = "25-07";
        GetSyoruiKengenResultBean ret = WorkFlowUtility.getSyoruiKengen(
            "0001",
            new String[] {"0001","0003","0002"},
            null);

        exStringEquals(ret.getSyorikekkaStatus(), "-1", "書類権限取得処理結果:7");
    }

    @Test
    @TestOrder(80)
    public void testGetSyoruiKengen_Case08(){
        IwfImageClientMock.mode = "25-08";
        IwfAccountClientMock.mode = "25-08";
        GetSyoruiKengenResultBean ret = WorkFlowUtility.getSyoruiKengen(
            null,
            new String[] {"0001","0003","0002"},
            null);

        exStringEquals(ret.getSyorikekkaStatus(), "9", "書類権限取得処理結果:8");
    }

    @Test
    @TestOrder(90)
    public void testGetSyoruiKengen_Case09(){
        IwfImageClientMock.mode = "25-09";
        IwfAccountClientMock.mode = "25-09";
        GetSyoruiKengenResultBean ret = WorkFlowUtility.getSyoruiKengen(
            null,
            new String[] {"0001","0003","0002"},
            null);

        exStringEquals(ret.getSyousaiMessageCd(), "IWF9004", "書類権限取得処理結果:9");
    }

    @Test
    @TestOrder(100)
    public void testGetSyoruiKengen_Case10(){
        IwfImageClientMock.mode = "25-10";
        IwfAccountClientMock.mode = "25-10";
        GetSyoruiKengenResultBean ret = WorkFlowUtility.getSyoruiKengen(
            null,
            new String[] {"0001","0003","0002"},
            null);

        exStringEquals(ret.getSyousaiMessage(), "データ整合性エラー。", "書類権限取得処理結果:10");
    }

    @Test
    @TestOrder(110)
    public void testGetSyoruiKengen_Case11(){
        IwfImageClientMock.mode = "25-11";
        IwfAccountClientMock.mode = "25-11";
        GetSyoruiKengenResultBean ret = WorkFlowUtility.getSyoruiKengen(
            null,
            new String[] {"0001","0003","0002"},
            null);

        exStringEquals(ret.getSyorikekkaStatus(), "9", "書類権限取得処理結果:11");
    }

    @Test
    @TestOrder(120)
    public void testGetSyoruiKengen_Case12(){
        IwfImageClientMock.mode = "25-12";
        IwfAccountClientMock.mode = "25-12";
        GetSyoruiKengenResultBean ret = WorkFlowUtility.getSyoruiKengen(
            "0001",
            new String[] {"0001","0003","0002"},
            null);

        exStringEquals(ret.getSyoruiKengenBeanList().get(0).getSyoruiCd(), "wf001", "書類権限取得処理結果:12-1");
        exStringEquals(ret.getSyoruiKengenBeanList().get(1).getSyoruiCd(), "wf002", "書類権限取得処理結果:12-2");
        exStringEquals(ret.getSyoruiKengenBeanList().get(2).getSyoruiCd(), "nk001", "書類権限取得処理結果:12-3");
        exStringEquals(ret.getSyoruiKengenBeanList().get(3).getSyoruiCd(), "nk003", "書類権限取得処理結果:12-4");
        exStringEquals(ret.getSyoruiKengenBeanList().get(4).getSyoruiCd(), "hz001", "書類権限取得処理結果:12-5");
        exStringEquals(ret.getSyoruiKengenBeanList().get(5).getSyoruiCd(), "hz002", "書類権限取得処理結果:12-6");
    }

    @Test
    @TestOrder(130)
    public void testGetSyoruiKengen_Case13(){
        IwfImageClientMock.mode = "25-13";
        IwfAccountClientMock.mode = "25-13";
        GetSyoruiKengenResultBean ret = WorkFlowUtility.getSyoruiKengen(
            "0001",
            new String[] {"0001","0003","0002"},
            null);

        exStringEquals(ret.getSyoruiKengenBeanList().get(0).getKengenFlg(), "1", "書類権限取得処理結果:13-1");
        exStringEquals(ret.getSyoruiKengenBeanList().get(2).getKengenFlg(), "1", "書類権限取得処理結果:13-2");
        exStringEquals(ret.getSyoruiKengenBeanList().get(4).getKengenFlg(), "1", "書類権限取得処理結果:13-3");
    }

    @Test
    @TestOrder(140)
    public void testGetSyoruiKengen_Case14(){
        IwfImageClientMock.mode = "25-14";
        IwfAccountClientMock.mode = "25-14";
        GetSyoruiKengenResultBean ret = WorkFlowUtility.getSyoruiKengen(
            "0001",
            new String[] {"0001","0003","0002"},
            null);

        exStringEquals(ret.getSyoruiKengenBeanList().get(1).getKengenFlg(), "0", "書類権限取得処理結果:14-1");
        exStringEquals(ret.getSyoruiKengenBeanList().get(3).getKengenFlg(), "0", "書類権限取得処理結果:14-2");
        exStringEquals(ret.getSyoruiKengenBeanList().get(5).getKengenFlg(), "0", "書類権限取得処理結果:14-3");
    }

    @Test
    @TestOrder(150)
    public void testGetSyoruiKengen_Case15(){
        IwfImageClientMock.mode = "25-15";
        IwfAccountClientMock.mode = "25-15";
        GetSyoruiKengenResultBean ret = WorkFlowUtility.getSyoruiKengen(
            "0001",
            new String[] {"0001","0003","0002"},
            null);

        exStringEquals(ret.getSyorikekkaStatus(), "0", "書類権限取得処理結果:15");
    }
}