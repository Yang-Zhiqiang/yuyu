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
import yuyu.common.biz.workflow.IwfKouteiClientMock;
import yuyu.def.workflow.configuration.YuyuWorkflowConfig;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.TestOrder;

/**
 * ワークフロー呼出ユーティリティ(書類到着処理)単体テストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class WorkFlowUtilityTest36 extends AbstractTest {



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
    public void testPutArrivalImage_Case01(){

        IwfKouteiClientMock.mode = "36-01";

        byte[] dummyPdf = new byte[102400];
        try {
            DataInputStream dataInStream =
                new DataInputStream(
                    new BufferedInputStream(
                        new FileInputStream("D:/develop/temp/dummy.pdf")));
            dataInStream.read(dummyPdf);
            dataInStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        PutArrivalImageResultBean ret = WorkFlowUtility.putArrivalImage("yuyu12345678901234567", dummyPdf, "GyoumuKey");

        exStringEquals(ret.getSyorikekkaStatus(), "-9", "処理結果ステータス");
    }

    @Test
    @TestOrder(20)
    public void testPutArrivalImage_Case02(){

        IwfKouteiClientMock.mode = "36-02";

        byte[] dummyPdf = new byte[102400];
        try {
            DataInputStream dataInStream =
                new DataInputStream(
                    new BufferedInputStream(
                        new FileInputStream("D:/develop/temp/dummy.pdf")));
            dataInStream.read(dummyPdf);
            dataInStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        PutArrivalImageResultBean ret = WorkFlowUtility.putArrivalImage("yuyu12345678901234567", dummyPdf, "GyoumuKey");

        exStringEquals(ret.getSyorikekkaStatus(), "9", "処理結果ステータス");
        exStringEquals(ret.getSyousaiMessageCd(), "IWF0003", "詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), "稼働時間外エラーか、認証エラーが発生しました。", "詳細メッセージ");
    }


    @Test
    @TestOrder(30)
    public void testPutArrivalImage_Case03(){

        IwfKouteiClientMock.mode = "36-03";
        IwfImageClientMock.mode = "36-03";

        byte[] dummyPdf = new byte[102400];
        try {
            DataInputStream dataInStream =
                new DataInputStream(
                    new BufferedInputStream(
                        new FileInputStream("D:/develop/temp/dummy.pdf")));
            dataInStream.read(dummyPdf);
            dataInStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        PutArrivalImageResultBean ret = WorkFlowUtility.putArrivalImage("yuyu12345678901234567", dummyPdf, "GyoumuKey");

        exStringEquals(ret.getSyorikekkaStatus(), "9", "処理結果ステータス");
        exStringEquals(ret.getSyousaiMessageCd(), "IWF0001", "詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), "異常終了しました。", "詳細メッセージ");
    }

    @Test
    @TestOrder(40)
    public void testPutArrivalImage_Case04(){

        IwfImageClientMock.mode = "36-04";

        byte[] dummyPdf = new byte[102400];
        try {
            DataInputStream dataInStream =
                new DataInputStream(
                    new BufferedInputStream(
                        new FileInputStream("D:/develop/temp/dummy.pdf")));
            dataInStream.read(dummyPdf);
            dataInStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        PutArrivalImageResultBean ret = WorkFlowUtility.putArrivalImage("yuyu12345678901234567", dummyPdf, null);

        exStringEquals(ret.getSyorikekkaStatus(), "0", "処理結果ステータス");
    }
}