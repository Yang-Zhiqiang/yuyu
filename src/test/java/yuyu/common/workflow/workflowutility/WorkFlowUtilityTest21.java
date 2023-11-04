package yuyu.common.workflow.workflowutility;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.workflow.IwfImageClientMock;
import yuyu.common.biz.workflow.IwfKouteiClientMock;
import yuyu.def.workflow.configuration.YuyuWorkflowConfig;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.TestOrder;

import com.google.common.base.Strings;

/**
 * ワークフロー呼出ユーティリティ(イメージ取得)単体テストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class WorkFlowUtilityTest21 extends AbstractTest {

    @BeforeClass
    public static void insertTestData() {
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
    public static void deleteTestData() {
    }

    @After
    public  void caseTerminat() {
    }

    @Test
    @TestOrder(10)
    public void testGetImage_Case1(){
        IwfImageClientMock.mode = "21-01";
        GetImageInfoListResultBean ret = WorkFlowUtility.getImage(null, "hijklmn");
        exStringEquals(ret.getSyorikekkaStatus(), WorkFlowResultConstants.RESULT_NG, "イメージ取得処理結果:1");
    }

    @Test
    @TestOrder(20)
    public void testGetImage_Case2(){
        IwfImageClientMock.mode = "21-02";
        GetImageInfoListResultBean ret = WorkFlowUtility.getImage("abcdefg", null);
        exStringEquals(ret.getSyorikekkaStatus(), WorkFlowResultConstants.RESULT_NG, "イメージ取得処理結果:2");
    }

    @Test
    @TestOrder(30)
    public void testGetImage_Case3(){
        IwfImageClientMock.mode = "21-03";
        IwfKouteiClientMock.mode =  "21-03";
        GetImageInfoListResultBean ret = WorkFlowUtility.getImage("abcdefg", "hijklmn");

        exBooleanEquals(Strings.isNullOrEmpty(ret.getSyousaiMessageCd()), false, "イメージ取得処理結果:3");
    }

    @Test
    @TestOrder(40)
    public void testGetImage_Case4(){
        IwfImageClientMock.mode = "21-04";
        IwfKouteiClientMock.mode =  "21-04";
        GetImageInfoListResultBean ret = WorkFlowUtility.getImage("abcdefg", "hijklmn");

        exStringEquals(ret.getSyousaiMessageCd(), "IWF0000", "イメージ取得処理結果:4");
    }

    @Test
    @TestOrder(50)
    public void testGetImage_Case5(){
        IwfImageClientMock.mode = "21-05";
        IwfKouteiClientMock.mode =  "21-05";
        GetImageInfoListResultBean ret = WorkFlowUtility.getImage("abcdefg", "hijklmn");

        exStringEquals(ret.getSyousaiMessage(), "正常終了しました。", "イメージ取得処理結果:5");
    }

    @Test
    @TestOrder(60)
    public void testGetImage_Case6(){
        IwfImageClientMock.mode = "21-06";
        IwfKouteiClientMock.mode =  "21-06";
        GetImageInfoListResultBean ret = WorkFlowUtility.getImage(null, null);

        exStringEquals(ret.getSyorikekkaStatus(), "9", "イメージ取得処理結果:6");
    }

    @Test
    @TestOrder(70)
    public void testGetImage_Case7(){
        IwfImageClientMock.mode = "21-07";
        IwfKouteiClientMock.mode =  "21-07";
        GetImageInfoListResultBean ret = WorkFlowUtility.getImage("abcdefg", "hijklmn");

        exStringEquals(ret.getSyorikekkaStatus(), "-1", "イメージ取得処理結果:7");
    }

    @Test
    @TestOrder(80)
    public void testGetImage_Case8(){
        IwfImageClientMock.mode = "21-08";
        IwfKouteiClientMock.mode =  "21-08";
        GetImageInfoListResultBean ret = WorkFlowUtility.getImage("abcdefg", "hijklmn");

        exStringEquals(ret.getImageInfoBeanList().get(0).getImageid(), "ImageId01", "イメージ取得処理結果:8-1");
        exStringEquals(ret.getImageInfoBeanList().get(0).getSyoNo(), "SyoNo01", "イメージ取得処理結果:8-2");
        exStringEquals(ret.getImageInfoBeanList().get(0).getNkSysyNo(), "NkSysyNo01", "イメージ取得処理結果:8-3");
        exStringEquals(ret.getImageInfoBeanList().get(0).getTorikomisyoruicd(), "SyoruiCd01", "イメージ取得処理結果:8-4");
        exBooleanEquals(Strings.isNullOrEmpty(ret.getImageInfoBeanList().get(0).getSyoruittykymdtime()), false, "イメージ取得処理結果:8-5");
        exStringEquals(ret.getImageInfoBeanList().get(0).getKouteistatus(), "10", "イメージ取得処理結果:8-6");
        exStringEquals(ret.getImageInfoBeanList().get(0).getKengenumu(), "1", "イメージ取得処理結果:8-7");
        exBooleanEquals(ret.getImageInfoBeanList().get(0).getPdfImage() == null, false, "イメージ取得処理結果:8-8");
    }

    @Test
    @TestOrder(90)
    public void testGetImage_Case9(){
        IwfImageClientMock.mode = "21-09";
        IwfKouteiClientMock.mode =  "21-09";
        GetImageInfoListResultBean ret = WorkFlowUtility.getImage("abcdefg", "hijklmn");

        exStringEquals(ret.getSyorikekkaStatus(), "0", "イメージ取得処理結果:9");
    }

    @Test
    @TestOrder(100)
    public void testGetImage_Case10(){
        IwfImageClientMock.mode = "21-10";
        IwfKouteiClientMock.mode =  "21-10";
        GetImageInfoListResultBean ret = WorkFlowUtility.getImage("abcdefg", "hijklmn");

        exStringEquals(ret.getImageInfoBeanList().get(0).getImageid(), "abcdefg", "イメージID");
        exStringEquals(ret.getImageInfoBeanList().get(0).getMosNo(), "12345678901", "申込番号");
        exStringEquals(ret.getImageInfoBeanList().get(0).getSyoNo(), "", "証券番号");
        exStringEquals(ret.getImageInfoBeanList().get(0).getNkSysyNo(), "", "年金証書番号");
        exStringEquals(ret.getImageInfoBeanList().get(0).getTorikomisyoruicd(), "", "取込書類コード");
        exStringEquals(ret.getImageInfoBeanList().get(0).getSyoruittykymdtime(), "", "書類到着日時");
        exStringEquals(ret.getImageInfoBeanList().get(0).getKouteistatus(), "", "工程状態");
        exStringEquals(ret.getImageInfoBeanList().get(0).getKengenumu(), "", "権限有無");
        exBooleanEquals(ret.getImageInfoBeanList().get(0).getPdfImage() == null, true, "PDFイメージ");
    }
}