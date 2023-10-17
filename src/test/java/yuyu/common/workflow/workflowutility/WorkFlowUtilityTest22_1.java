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
public class WorkFlowUtilityTest22_1 extends AbstractTest {

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
    public void testPutImage_Case1(){
        IwfImageClientMock.mode = "22-01";

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

        PutImageResultBean ret = WorkFlowUtility.putImage("iw001", "abcdefg", "hzn", b, "hijklmn", "2015010111223300000", "2015010111223300000", null);
        exStringEquals(ret.getSyorikekkaStatus(), WorkFlowResultConstants.RESULT_OK, "イメージ登録処理結果:1");
    }

    @Test
    @TestOrder(20)
    public void testPutImage_Case2(){
        IwfImageClientMock.mode = "22-02";

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

        PutImageResultBean ret = WorkFlowUtility.putImage("iw001", "abcdefg", "hzn", b, "hijklmn", "2015010111223300000", "2015010111223300000", "0");
        exStringEquals(ret.getSyorikekkaStatus(), WorkFlowResultConstants.RESULT_OK, "イメージ登録処理結果:2");
    }

    @Test
    @TestOrder(30)
    public void testPutImage_Case3(){
        IwfImageClientMock.mode = "22-03";

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

        PutImageResultBean ret = WorkFlowUtility.putImage("iw001", "abcdefg", "hzn", b, "hijklmn", "2015010111223300000", "2015010111223300000", "2");
        exStringEquals(ret.getSyorikekkaStatus(), WorkFlowResultConstants.RESULT_OK, "イメージ登録処理結果:3");
    }

    @Test
    @TestOrder(40)
    public void testPutImage_Case4(){
        IwfImageClientMock.mode = "22-04";

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
        exStringEquals(ret.getSyorikekkaStatus(), "96", "イメージ登録処理結果:4");
    }

    @Test
    @TestOrder(50)
    public void testPutImage_Case5(){
        IwfImageClientMock.mode = "22-05";

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

        PutImageResultBean ret = WorkFlowUtility.putImage("iw001", null, "hzn", b, "hijklmn", "2015010111223300000", "2015010111223300000", "1");
        exStringEquals(ret.getSyorikekkaStatus(), "9", "イメージ登録処理結果:5");
    }

    @Test
    @TestOrder(60)
    public void testPutImage_Case6(){
        IwfImageClientMock.mode = "22-06";

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

        PutImageResultBean ret = WorkFlowUtility.putImage("iw001", "abcdefg", "hzn", b, null, "2015010111223300000", "2015010111223300000", "1");
        exStringEquals(ret.getSyorikekkaStatus(), "9", "イメージ登録処理結果:6");
    }

    @Test
    @TestOrder(70)
    public void testPutImage_Case7(){
        IwfImageClientMock.mode = "22-07";

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

        PutImageResultBean ret = WorkFlowUtility.putImage("iw001", "abcdefg", "hzn", b, null, "2015010111223300000", "2015010111223300000", "1");
        exStringEquals(ret.getSyorikekkaStatus(), "9", "イメージ登録処理結果:7-1");
        exStringEquals(ret.getSyousaiMessageCd(), "IWF0002", "イメージ登録処理結果:7-2");
    }

    @Test
    @TestOrder(80)
    public void testPutImage_Case8(){
        IwfImageClientMock.mode = "22-08";

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

        PutImageResultBean ret = WorkFlowUtility.putImage("iw001", "abcdefg", "hzn", b, null, "2015010111223300000", "2015010111223300000", "1");
        exStringEquals(ret.getSyorikekkaStatus(), "9", "イメージ登録処理結果:8-1");
        exStringEquals(ret.getSyousaiMessage(), "必須入力チェックエラー", "イメージ登録処理結果:8-2");
    }

    @Test
    @TestOrder(90)
    public void testPutImage_Case9(){
        IwfImageClientMock.mode = "22-09";

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

        PutImageResultBean ret = WorkFlowUtility.putImage("iw001", "abcdefg", "hzn", b, null, "2015010111223300000", "2015010111223300000", "1");
        exStringEquals(ret.getSyorikekkaStatus(), "95", "イメージ登録処理結果:9");
    }

    @Test
    @TestOrder(100)
    public void testPutImage_Case10(){
        IwfImageClientMock.mode = "22-10";

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

        PutImageResultBean ret = WorkFlowUtility.putImage("iw001", "abcdefg", "hzn", b, null, "2015010111223300000", "2015010111223300000", "1");
        exStringEquals(ret.getSyorikekkaStatus(), "9", "イメージ登録処理結果:10");
    }

    @Test
    @TestOrder(110)
    public void testPutImage_Case11(){
        IwfImageClientMock.mode = "22-11";

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
        exStringEquals(ret.getSyousaiMessageCd(), "IWF3092", "イメージ登録処理結果:11");
    }

    @Test
    @TestOrder(120)
    public void testPutImage_Case12(){
        IwfImageClientMock.mode = "22-12";

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

        PutImageResultBean ret = WorkFlowUtility.putImage("iw001", "abcdefg", "hzn", b, "hijklmn", "2015010111223300000", "2015010111223300000", null);
        exStringEquals(ret.getSyousaiMessageCd(), "IWF3091", "イメージ登録処理結果:12");
    }

    @Test
    @TestOrder(130)
    public void testPutImage_Case13(){
        IwfImageClientMock.mode = "22-13";

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

        PutImageResultBean ret = WorkFlowUtility.putImage(null, "abcdefg", "hzn", b, "hijklmn", "2015010111223300000", "2015010111223300000", null);
        exStringEquals(ret.getSyousaiMessageCd(), "IWF0002", "イメージ登録処理結果:13");
    }

    @Test
    @TestOrder(140)
    public void testPutImage_Case14(){
        IwfImageClientMock.mode = "22-14";

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

        PutImageResultBean ret = WorkFlowUtility.putImage("iw001", null, "hzn", b, "hijklmn", "2015010111223300000", "2015010111223300000", null);
        exStringEquals(ret.getSyousaiMessageCd(), "IWF0002", "イメージ登録処理結果:14");
    }

    @Test
    @TestOrder(150)
    public void testPutImage_Case15(){
        IwfImageClientMock.mode = "22-15";

        PutImageResultBean ret = WorkFlowUtility.putImage("iw001", "abcdefg", "hzn", null, "hijklmn", "2015010111223300000", "2015010111223300000", null);
        exStringEquals(ret.getSyousaiMessageCd(), "IWF0002", "イメージ登録処理結果:15");
    }
}