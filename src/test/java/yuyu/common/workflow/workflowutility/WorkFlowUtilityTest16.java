package yuyu.common.workflow.workflowutility;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import yuyu.common.biz.workflow.IwfKouteiClientMock;
import yuyu.def.workflow.configuration.YuyuWorkflowConfig;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.TestOrder;

/**
 * ワークフロー呼出ユーティリティ(工程取消)単体テストクラスです。
 */
public class WorkFlowUtilityTest16 extends AbstractTest {

    @BeforeClass
    public static void insertTestData() {
    }

    @Before
    public  void caseInit() {
        IwfKouteiClientMock.caller = "Test";
        YuyuWorkflowConfig config = YuyuWorkflowConfig.getInstance();
        config.setWorkflowStubMode(false);
    }

    @AfterClass
    public static void testClear() {
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
    public void testCancelProcess_Case1(){

        IwfKouteiClientMock.mode =  "16-01";

        CancelProcessResultBean ret = WorkFlowUtility.cancelProcess("hijklmn", "hzn", "userId", "comment");

        exStringEquals(ret.getSyorikekkaStatus(), "-9", "出力パラメータの処理結果ステータス");
        exStringEquals(ret.getSyousaiMessageCd(), "IWF2091", "出力パラメータの詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), "対象のトークンは既にロックされています。", "出力パラメータの詳細メッセージ");
        exStringEquals(ret.getErrorApiName(), "LockProcess", "出力パラメータのエラー発生API名");
    }

    @Test
    @TestOrder(20)
    public void testCancelProcess_Case2(){

        IwfKouteiClientMock.mode =  "16-02";

        CancelProcessResultBean ret = WorkFlowUtility.cancelProcess("hijklmn", "hzn", "userId", "comment");

        exStringEquals(ret.getSyorikekkaStatus(), "9", "出力パラメータの処理結果ステータス");
        exStringEquals(ret.getSyousaiMessageCd(), "IWF0000", "出力パラメータの詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), "異常終了しました", "出力パラメータの詳細メッセージ");
        exStringEquals(ret.getErrorApiName(), "LockProcess", "出力パラメータのエラー発生API名");
    }

    @Test
    @TestOrder(30)
    public void testCancelProcess_Case3(){

        IwfKouteiClientMock.mode =  "16-03";

        CancelProcessResultBean ret = WorkFlowUtility.cancelProcess("hijklmn", "hzn", "userId", "comment");

        exStringEquals(ret.getSyorikekkaStatus(), "9", "出力パラメータの処理結果ステータス");
        exStringEquals(ret.getSyousaiMessageCd(), "IWF0000", "出力パラメータの詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), "異常終了しました", "出力パラメータの詳細メッセージ");
        exStringEquals(ret.getErrorApiName(), "ProcessCancel", "出力パラメータのエラー発生API名");
    }

    @Test
    @TestOrder(40)
    public void testCancelProcess_Case4(){

        IwfKouteiClientMock.mode =  "16-04";

        CancelProcessResultBean ret = WorkFlowUtility.cancelProcess("hijklmn", "hzn", "userId", "comment");

        exStringEquals(ret.getSyorikekkaStatus(), "9", "出力パラメータの処理結果ステータス");
        exStringEquals(ret.getSyousaiMessageCd(), "IWF0000", "出力パラメータの詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), "異常終了しました", "出力パラメータの詳細メッセージ");
        exStringEquals(ret.getErrorApiName(), "CreateProcessRecord", "出力パラメータのエラー発生API名");
    }

    @Test
    @TestOrder(50)
    public void testCancelProcess_Case5(){

        IwfKouteiClientMock.mode =  "16-05";

        CancelProcessResultBean ret = WorkFlowUtility.cancelProcess("hijklmn", "hzn", "userId", "comment");

        exStringEquals(ret.getSyorikekkaStatus(), "0", "出力パラメータの処理結果ステータス");
        exStringEquals(ret.getSyousaiMessageCd(), null, "出力パラメータの詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), null, "出力パラメータの詳細メッセージ");
        exStringEquals(ret.getErrorApiName(), null, "出力パラメータのエラー発生API名");
    }

}
