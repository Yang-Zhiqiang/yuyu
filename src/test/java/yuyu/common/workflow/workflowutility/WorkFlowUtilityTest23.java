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
import yuyu.def.workflow.configuration.YuyuWorkflowConfig;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.TestOrder;

import com.google.common.base.Strings;

/**
 * ワークフロー呼出ユーティリティ(イメージ削除)単体テストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class WorkFlowUtilityTest23 extends AbstractTest {

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
    public void testDropImage_Case1(){
        IwfImageClientMock.mode = "23-01";
        DropImageResultBean ret = WorkFlowUtility.dropImage(null, "abcdefg");
        exStringEquals(ret.getSyorikekkaStatus(), WorkFlowResultConstants.RESULT_NG, "イメージ削除処理結果:1");
    }

    @Test
    @TestOrder(20)
    public void testDropImage_Case2(){
        IwfImageClientMock.mode = "23-02";
        DropImageResultBean ret = WorkFlowUtility.dropImage("abcdefg", null);
        exStringEquals(ret.getSyorikekkaStatus(), WorkFlowResultConstants.RESULT_NG, "イメージ削除処理結果:2");
    }

    @Test
    @TestOrder(30)
    public void testDropImage_Case3(){
        IwfImageClientMock.mode = "23-02";
        DropImageResultBean ret = WorkFlowUtility.dropImage("abcdefg", "hijklmn");
        exBooleanEquals(Strings.isNullOrEmpty(ret.getSyousaiMessageCd()), false, "イメージ削除処理結果:3");
    }

    @Test
    @TestOrder(40)
    public void testDropImage_Case4(){
        IwfImageClientMock.mode = "23-04";
        DropImageResultBean ret = WorkFlowUtility.dropImage("abcdefg", "hijklmn");
        exStringEquals(ret.getSyousaiMessageCd(), "IWF0000", "イメージ削除処理結果:4");
    }

    @Test
    @TestOrder(50)
    public void testDropImage_Case5(){
        IwfImageClientMock.mode = "23-05";
        DropImageResultBean ret = WorkFlowUtility.dropImage("abcdefg", "hijklmn");
        exStringEquals(ret.getSyousaiMessage(), "正常終了しました。", "イメージ削除処理結果:5");
    }

    @Test
    @TestOrder(60)
    public void testDropImage_Case6(){
        IwfImageClientMock.mode = "23-06";
        DropImageResultBean ret = WorkFlowUtility.dropImage("abcdefg", "hijklmn");
        exStringEquals(ret.getSyorikekkaStatus(), "0", "イメージ削除処理結果:6");
    }
}