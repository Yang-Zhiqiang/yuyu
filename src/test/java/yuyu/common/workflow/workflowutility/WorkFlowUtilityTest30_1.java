package yuyu.common.workflow.workflowutility;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.workflow.IwfKouteiClientMock;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.db.entity.AM_User;
import yuyu.def.workflow.configuration.YuyuWorkflowConfig;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.TestOrder;

/**
 * ワークフロー呼出ユーティリティ(処理残件数取得(事務手続・タスク指定))単体テストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class WorkFlowUtilityTest30_1 extends AbstractTest {

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_【30_処理残件数取得(事務手続・タスク指定)】_1";
    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(WorkFlowUtilityTest30.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);

        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @Before
    public void testInit() {
        IwfKouteiClientMock.caller = "Test";
        YuyuWorkflowConfig config = YuyuWorkflowConfig.getInstance();
        config.setWorkflowStubMode(false);
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        IwfKouteiClientMock.caller = null;
        IwfKouteiClientMock.mode = null;
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        AM_User user1 = baseDomManager.getUser("29910101");

        baseDomManager.delete(user1);
    }

    @Test
    @TestOrder(10)
    public void testGetCountOfTaskSummaryByTask_A1() {

        IwfKouteiClientMock.mode = "30-07-01";

        GetCountOfTaskSummaryByTaskResultBean ret = WorkFlowUtility.getCountOfTaskSummaryByTask("101223301", "task101",
            "userId101");

        exStringEquals(ret.getSyorikekkaStatus(), "0", "処理結果ステータス");
        exStringEquals(ret.getSyousaiMessageCd(), "IWF0000", "詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), "正常終了しました。", "詳細メッセージ");

        List<CountOfTaskSummaryByTaskBean> countOfTaskSummaryByTaskBeanList = ret.getCountOfTaskSummaryBean();

        exNumericEquals(countOfTaskSummaryByTaskBeanList.size(), 3, "件数");

        exStringEquals(countOfTaskSummaryByTaskBeanList.get(0).getUserId(), "userIdIwf103", "ユーザーID");
        exStringEquals(countOfTaskSummaryByTaskBeanList.get(0).getDispUserNm(), "userIdIwf103", "(表示用)ユーザ名");
        exBizCalcbleEquals(countOfTaskSummaryByTaskBeanList.get(0).getCountOfprocessStartToday(), BizNumber.valueOf(0), "本日開始件数");
        exBizCalcbleEquals(countOfTaskSummaryByTaskBeanList.get(0).getCountOfprocessLeftToday(), BizNumber.valueOf(103), "本日残件数");
        exBizCalcbleEquals(countOfTaskSummaryByTaskBeanList.get(0).getCountOfprocessFinToday(), BizNumber.valueOf(0), "本日完了件数");

        exStringEquals(countOfTaskSummaryByTaskBeanList.get(1).getUserId(), "userIdIwf102", "ユーザーID");
        exStringEquals(countOfTaskSummaryByTaskBeanList.get(1).getDispUserNm(), "userIdIwf102", "(表示用)ユーザ名");
        exBizCalcbleEquals(countOfTaskSummaryByTaskBeanList.get(1).getCountOfprocessStartToday(), BizNumber.valueOf(0), "本日開始件数");
        exBizCalcbleEquals(countOfTaskSummaryByTaskBeanList.get(1).getCountOfprocessLeftToday(), BizNumber.valueOf(0), "本日残件数");
        exBizCalcbleEquals(countOfTaskSummaryByTaskBeanList.get(1).getCountOfprocessFinToday(), BizNumber.valueOf(102), "本日完了件数");

        exStringEquals(countOfTaskSummaryByTaskBeanList.get(2).getUserId(), "userIdIwf101", "ユーザーID");
        exStringEquals(countOfTaskSummaryByTaskBeanList.get(2).getDispUserNm(), "userIdIwf101", "(表示用)ユーザ名");
        exBizCalcbleEquals(countOfTaskSummaryByTaskBeanList.get(2).getCountOfprocessStartToday(), BizNumber.valueOf(101), "本日開始件数");
        exBizCalcbleEquals(countOfTaskSummaryByTaskBeanList.get(2).getCountOfprocessLeftToday(), BizNumber.valueOf(0), "本日残件数");
        exBizCalcbleEquals(countOfTaskSummaryByTaskBeanList.get(2).getCountOfprocessFinToday(), BizNumber.valueOf(0), "本日完了件数");
    }
}
