package yuyu.common.workflow.workflowutility;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.workflow.IwfImageClientMock;
import yuyu.def.workflow.configuration.YuyuWorkflowConfig;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.TestOrder;


/**
 * ワークフロー呼出ユーティリティ(イメージ登録)単体テストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class WorkFlowUtilityTest22_2 extends AbstractTest {

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
    @TestOrder(160)
    public void testPutImage_Case16(){
        IwfImageClientMock.mode = "22-16";

        byte[] b = new byte[102400];
        try {
            DataInputStream dataInStream =
                new DataInputStream(
                    new BufferedInputStream(
                        new FileInputStream("D:/develop/temp/dummy.pdf")));
            dataInStream.read(b);
            dataInStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        PutImageResultBean ret = WorkFlowUtility.putImage("iw001", "abcdefg", "hzn", b, null, "2015010111223300000", "2015010111223300000", null);
        exStringEquals(ret.getSyousaiMessageCd(), "IWF0002", "イメージ登録処理結果:16");
    }

    @Test
    @TestOrder(170)
    public void testPutImage_Case17(){
        IwfImageClientMock.mode = "22-17";

        PutImageResultBean ret = WorkFlowUtility.putImage("iw001", "abcdefg", "hzn", null, "hijklmn", "2015010111223300000", "2015010111223300000", null);
        exStringEquals(ret.getSyousaiMessageCd(), "IWF0002", "イメージ登録処理結果:17");
    }

    @Test
    @TestOrder(180)
    public void testPutImage_Case18(){
        IwfImageClientMock.mode = "22-18";

        PutImageResultBean ret = WorkFlowUtility.putImage("iw001", "abcdefg", "hzn", null, "hijklmn", "2015010111223300000", "2015010111223300000", null);
        exStringEquals(ret.getSyousaiMessage(), "必須入力チェックエラー。", "イメージ登録処理結果:18");
    }

    @Test
    @TestOrder(190)
    public void testPutImage_Case19(){
        IwfImageClientMock.mode = "22-19";

        PutImageResultBean ret = WorkFlowUtility.putImage("iw001", "abcdefg", "hzn", null, "hijklmn", "2015010111223300000", "2015010111223300000", null);
        exStringEquals(ret.getSyorikekkaStatus(), "9", "イメージ登録処理結果:19");
    }

    @Test
    @TestOrder(200)
    public void testPutImage_Case20(){
        IwfImageClientMock.mode = "22-20";

        PutImageResultBean ret = WorkFlowUtility.putImage("iw001", "abcdefg", "hzn", null, "hijklmn", "2015010111223300000", "2015010111223300000", "1");
        exStringEquals(ret.getSyorikekkaStatus(), "9", "イメージ登録処理結果:20");
    }

    @Test
    @TestOrder(210)
    public void testPutImage_Case21(){
        IwfImageClientMock.mode = "22-21";

        PutImageResultBean ret = WorkFlowUtility.putImage("iw001", "abcdefg", "hzn", null, "hijklmn", "2015010111223300000", "2015010111223300000", "0");
        exStringEquals(ret.getSyorikekkaStatus(), "9", "イメージ登録処理結果:21");
    }

    @Test
    @TestOrder(220)
    public void testPutImage_Case22(){
        IwfImageClientMock.mode = "22-22";

        PutImageResultBean ret = WorkFlowUtility.putImage("iw001", "abcdefg", "hzn", null, "hijklmn", "2015010111223300000", "2015010111223300000", "1");
        exStringEquals(ret.getSyorikekkaStatus(), "0", "イメージ登録処理結果:22");
    }

    @Test
    @TestOrder(230)
    public void testPutImage_Case23(){
        IwfImageClientMock.mode = "22-23";

        byte[] b = new byte[102400];
        try {
            DataInputStream dataInStream =
                new DataInputStream(
                    new BufferedInputStream(
                        new FileInputStream("D:/develop/temp/dummy.pdf")));
            dataInStream.read(b);
            dataInStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        PutImageResultBean ret = WorkFlowUtility.putImage("iw001", "abcdefg", "hzn", b, "hijklmn", "2015010111223300000", "2015010111223300000", "1");
        exStringEquals(ret.getSyorikekkaStatus(), "0", "イメージ登録処理結果:23");
    }
}