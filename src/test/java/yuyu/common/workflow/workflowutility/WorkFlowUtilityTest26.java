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
import yuyu.def.workflow.configuration.YuyuWorkflowConfig;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.TestOrder;

/**
 * ワークフロー呼出ユーティリティ(書類権限登録)単体テストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class WorkFlowUtilityTest26 extends AbstractTest {

    @BeforeClass
    public static void insertTestData() {
    }

    @Before
    public  void caseInit() {
        IwfAccountClientMock.caller = "Test";
        YuyuWorkflowConfig config = YuyuWorkflowConfig.getInstance();
        config.setWorkflowStubMode(false);
    }

    @AfterClass
    public static void testClear() {
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
    public void testPutSyoruiKengen_Case01(){
        IwfAccountClientMock.mode = "26-01";
        PutSyoruiKengenResultBean ret = WorkFlowUtility.putSyoruiKengen(
            null,
            new String[] {"wf001","wf002"});
        exStringEquals(ret.getSyorikekkaStatus(), "9", "書類権限登録処理結果:1");
    }

    @Test
    @TestOrder(20)
    public void testPutSyoruiKengen_Case02(){
        IwfAccountClientMock.mode = "26-02";
        PutSyoruiKengenResultBean ret = WorkFlowUtility.putSyoruiKengen(
            "0001",
            null);
        exStringEquals(ret.getSyorikekkaStatus(), "9", "書類権限登録処理結果:2");
    }

    @Test
    @TestOrder(30)
    public void testPutSyoruiKengen_Case03(){
        IwfAccountClientMock.mode = "26-03";
        PutSyoruiKengenResultBean ret = WorkFlowUtility.putSyoruiKengen(
            "0001",
            new String[] {"wf001","wf002"});
        exStringEquals(ret.getSyorikekkaStatus(), "0", "書類権限登録処理結果:3");
    }

    @Test
    @TestOrder(40)
    public void testPutSyoruiKengen_Case04(){
        IwfAccountClientMock.mode = "26-04";
        PutSyoruiKengenResultBean ret = WorkFlowUtility.putSyoruiKengen(
            "0001",
            new String[] {"wf001","wf002"});
        exStringEquals(ret.getSyousaiMessageCd(), "IWF0000", "書類権限登録処理結果:4");
    }

    @Test
    @TestOrder(50)
    public void testPutSyoruiKengen_Case05(){
        IwfAccountClientMock.mode = "26-05";
        PutSyoruiKengenResultBean ret = WorkFlowUtility.putSyoruiKengen(
            "0001",
            new String[] {"wf001","wf002"});
        exStringEquals(ret.getSyousaiMessage(), "正常終了しました。", "書類権限登録処理結果:5");
    }

    @Test
    @TestOrder(60)
    public void testPutSyoruiKengen_Case06(){
        IwfAccountClientMock.mode = "26-06";
        PutSyoruiKengenResultBean ret = WorkFlowUtility.putSyoruiKengen(
            "0001",
            new String[] {"wf001","wf002"});
        exStringEquals(ret.getSyorikekkaStatus(), "0", "書類権限登録処理結果:6");
    }
}