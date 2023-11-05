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
 * ワークフロー呼出ユーティリティ(書類権限削除)単体テストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class WorkFlowUtilityTest27 extends AbstractTest {

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
    public void testDropSyoruiKengen_Case01(){
        IwfAccountClientMock.mode = "27-01";
        DropSyoruiKengenResultBean ret = WorkFlowUtility.dropSyoruiKengen(
            null);
        exStringEquals(ret.getSyorikekkaStatus(), "9", "書類権限削除処理結果:1");
    }

    @Test
    @TestOrder(20)
    public void testDropSyoruiKengen_Case02(){
        IwfAccountClientMock.mode = "27-02";
        DropSyoruiKengenResultBean ret = WorkFlowUtility.dropSyoruiKengen(
            "0001");
        exStringEquals(ret.getSyorikekkaStatus(), "0", "書類権限削除処理結果:2");
    }

    @Test
    @TestOrder(30)
    public void testDropSyoruiKengen_Case03(){
        IwfAccountClientMock.mode = "27-03";
        DropSyoruiKengenResultBean ret = WorkFlowUtility.dropSyoruiKengen(
            "0001");
        exStringEquals(ret.getSyousaiMessageCd(), "IWF0000", "書類権限削除処理結果:3");
    }

    @Test
    @TestOrder(40)
    public void testDropSyoruiKengen_Case04(){
        IwfAccountClientMock.mode = "27-04";
        DropSyoruiKengenResultBean ret = WorkFlowUtility.dropSyoruiKengen(
            "0001");
        exStringEquals(ret.getSyousaiMessage(), "正常終了しました。", "書類権限削除処理結果:4");
    }

    @Test
    @TestOrder(50)
    public void testDropSyoruiKengen_Case05(){
        IwfAccountClientMock.mode = "27-05";
        DropSyoruiKengenResultBean ret = WorkFlowUtility.dropSyoruiKengen(
            "0001");
        exStringEquals(ret.getSyorikekkaStatus(), "0", "書類権限削除処理結果:5");
    }
}