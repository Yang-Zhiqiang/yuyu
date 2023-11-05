package yuyu.common.workflow.workflowutility;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.koutei.GetSyoriKokouteiInfoMock;
import yuyu.common.biz.workflow.IwfKouteiClientMock;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.workflow.configuration.YuyuWorkflowConfig;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.TestOrder;

/**
 * ワークフロー呼出ユーティリティ(強制工程ロック解除)単体テストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class WorkFlowUtilityTest02 extends AbstractTest {

    private final static String fileName = "UT_SP_単体テスト仕様書_【02_強制工程ロック解除】";
    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(WorkFlowUtilityTest02.class,fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);

        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @Before
    public  void caseInit() {
        IwfKouteiClientMock.caller = "Test";
        GetSyoriKokouteiInfoMock.caller = "Test";
        YuyuWorkflowConfig config = YuyuWorkflowConfig.getInstance();
        config.setWorkflowStubMode(false);
    }

    @AfterClass
    public static void testClear() {
        IwfKouteiClientMock.caller = null;
        GetSyoriKokouteiInfoMock.caller = null;
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        bizDomManager.delete(bizDomManager.getGyoumuKouteiInfo("hijklmn"));
        bizDomManager.delete(bizDomManager.getGyoumuKouteiInfo("hijklmn1"));
        bizDomManager.delete(bizDomManager.getGyoumuKouteiInfo("hijklmn2"));
    }

    @After
    public  void caseTerminat() {
    }

    @Test
    @TestOrder(10)
    public void unlockProcessForceTest_Case1() {

        IwfKouteiClientMock.mode = "02-01";

        UnlockProcessForceResultBean ret = WorkFlowUtility.unlockProcessForce("hijklmn","hzn");

        exStringEquals(ret.getSyorikekkaStatus(), "9", "処理結果ステータス");
        exStringEquals(ret.getSyousaiMessageCd(), "IWF0001", "詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), "異常終了しました。", "詳細メッセージ");
    }

    @Test
    @TestOrder(20)
    public void unlockProcessForceTest_Case2() {

        IwfKouteiClientMock.mode = "02-02";

        UnlockProcessForceResultBean ret = WorkFlowUtility.unlockProcessForce("hijklmn","hzn");

        exStringEquals(ret.getSyorikekkaStatus(), "0", "処理結果ステータス");
        exStringEquals(ret.getSyousaiMessageCd(), "IWF0000", "詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), "正常終了しました。", "詳細メッセージ");
    }
}
