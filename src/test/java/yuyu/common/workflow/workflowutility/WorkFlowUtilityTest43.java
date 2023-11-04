package yuyu.common.workflow.workflowutility;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.workflow.manager.WorkflowDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ワークフロー呼出ユーティリティクラスのメソッド {@link WorkFlowUtility#getCountOfKakoJissekiTaskSummaryByTask(BizDate, String, String[], String)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class WorkFlowUtilityTest43 {

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_【43_処理残件数取得_過去実績サマリ分(事務手続・タスク指定)】";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {

            TestDataMaker testDataMaker = new TestDataMaker();

            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

            testDataAndTblMap = testDataMaker.getInData(WorkFlowUtilityTest43.class, fileName, sheetName);

            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);

        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        WorkflowDomManager workflowDomManager = SWAKInjector.getInstance(WorkflowDomManager.class);
        workflowDomManager.delete(workflowDomManager.getAllSyoriKensuuHokanTask());
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        baseDomManager.delete(baseDomManager.getUser("29910101"));
    }

    @Test
    @TestOrder(10)
    public void testGetCountOfKakoJissekiTaskSummaryByTask_A1() {

        GetCountOfTaskSummaryByTaskResultBean ret = WorkFlowUtility.getCountOfKakoJissekiTaskSummaryByTask(
                BizDate.valueOf(20180108), "101223301", new String[]{"task101"}, "userId101");
        exStringEquals(ret.getSyorikekkaStatus(), "0", "処理結果ステータス");
        exStringEquals(ret.getSyousaiMessageCd(), null, "詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), null, "詳細メッセージ");
        List<CountOfTaskSummaryByTaskBean> countOfKakoJissekiTaskSummaryBeanLst =
                ret.getCountOfTaskSummaryBean();
        exNumericEquals(countOfKakoJissekiTaskSummaryBeanLst.size(), 0, "件数");
    }

    @Test
    @TestOrder(20)
    public void testGetCountOfKakoJissekiTaskSummaryByTask_A2() {

        GetCountOfTaskSummaryByTaskResultBean ret = WorkFlowUtility.getCountOfKakoJissekiTaskSummaryByTask(
                BizDate.valueOf(20180109), "201223301", new String[]{"task201"}, "kyouyuu");
        exStringEquals(ret.getSyorikekkaStatus(), "0", "処理結果ステータス");
        exStringEquals(ret.getSyousaiMessageCd(), null, "詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), null, "詳細メッセージ");
        List<CountOfTaskSummaryByTaskBean> countOfKakoJissekiTaskSummaryBeanLst =
                ret.getCountOfTaskSummaryBean();
        exNumericEquals(countOfKakoJissekiTaskSummaryBeanLst.size(), 1, "件数");

        exStringEquals(countOfKakoJissekiTaskSummaryBeanLst.get(0).getUserId(), null, "ユーザーID");
        exStringEquals(countOfKakoJissekiTaskSummaryBeanLst.get(0).getDispUserNm(), "共用", "（表示用）ユーザー名");
        exBizCalcbleEquals(countOfKakoJissekiTaskSummaryBeanLst.get(0).getCountOfprocessStartToday(),
                BizNumber.valueOf(11), "本日開始件数");
        exBizCalcbleEquals(countOfKakoJissekiTaskSummaryBeanLst.get(0).getCountOfprocessLeftToday(),
                BizNumber.valueOf(6), "本日残件数");
        exBizCalcbleEquals(countOfKakoJissekiTaskSummaryBeanLst.get(0).getCountOfprocessFinToday(),
                BizNumber.valueOf(16), "本日完了件数");
        exStringEquals(countOfKakoJissekiTaskSummaryBeanLst.get(0).getJimutetuzukiCd(), "201223301", "事務手続コード");
        exStringEquals(countOfKakoJissekiTaskSummaryBeanLst.get(0).getTaskNm(), "task201", "タスク名");

    }

    @Test
    @TestOrder(30)
    public void testGetCountOfKakoJissekiTaskSummaryByTask_A3() {

        GetCountOfTaskSummaryByTaskResultBean ret = WorkFlowUtility.getCountOfKakoJissekiTaskSummaryByTask(
                BizDate.valueOf(20180110), "301223301", new String[]{"task301","task302","task303"}, null);
        exStringEquals(ret.getSyorikekkaStatus(), "0", "処理結果ステータス");
        exStringEquals(ret.getSyousaiMessageCd(), null, "詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), null, "詳細メッセージ");
        List<CountOfTaskSummaryByTaskBean> countOfKakoJissekiTaskSummaryBeanLst =
                ret.getCountOfTaskSummaryBean();
        exNumericEquals(countOfKakoJissekiTaskSummaryBeanLst.size(), 4, "件数");

        exStringEquals(countOfKakoJissekiTaskSummaryBeanLst.get(0).getUserId(), null, "ユーザーID");
        exStringEquals(countOfKakoJissekiTaskSummaryBeanLst.get(0).getDispUserNm(), "共用", "（表示用）ユーザー名");
        exBizCalcbleEquals(countOfKakoJissekiTaskSummaryBeanLst.get(0).getCountOfprocessStartToday(),
                BizNumber.valueOf(12), "本日開始件数");
        exBizCalcbleEquals(countOfKakoJissekiTaskSummaryBeanLst.get(0).getCountOfprocessLeftToday(),
                BizNumber.valueOf(7), "本日残件数");
        exBizCalcbleEquals(countOfKakoJissekiTaskSummaryBeanLst.get(0).getCountOfprocessFinToday(),
                BizNumber.valueOf(17), "本日完了件数");
        exStringEquals(countOfKakoJissekiTaskSummaryBeanLst.get(0).getJimutetuzukiCd(), "301223301", "事務手続コード");
        exStringEquals(countOfKakoJissekiTaskSummaryBeanLst.get(0).getTaskNm(), "task303", "タスク名");

        exStringEquals(countOfKakoJissekiTaskSummaryBeanLst.get(1).getUserId(), "29910101", "ユーザーID");
        exStringEquals(countOfKakoJissekiTaskSummaryBeanLst.get(1).getDispUserNm(), "支社ユ新１", "（表示用）ユーザー名");
        exBizCalcbleEquals(countOfKakoJissekiTaskSummaryBeanLst.get(1).getCountOfprocessStartToday(),
                BizNumber.valueOf(13), "本日開始件数");
        exBizCalcbleEquals(countOfKakoJissekiTaskSummaryBeanLst.get(1).getCountOfprocessLeftToday(),
                BizNumber.valueOf(8), "本日残件数");
        exBizCalcbleEquals(countOfKakoJissekiTaskSummaryBeanLst.get(1).getCountOfprocessFinToday(),
                BizNumber.valueOf(18), "本日完了件数");
        exStringEquals(countOfKakoJissekiTaskSummaryBeanLst.get(1).getJimutetuzukiCd(), "301223301", "事務手続コード");
        exStringEquals(countOfKakoJissekiTaskSummaryBeanLst.get(1).getTaskNm(), "task303", "タスク名");

        exStringEquals(countOfKakoJissekiTaskSummaryBeanLst.get(2).getUserId(), "userId30100001", "ユーザーID");
        exStringEquals(countOfKakoJissekiTaskSummaryBeanLst.get(2).getDispUserNm(), "ｕｓｅｒＩｄ３０１００００１", "（表示用）ユーザー名");
        exBizCalcbleEquals(countOfKakoJissekiTaskSummaryBeanLst.get(2).getCountOfprocessStartToday(),
                BizNumber.valueOf(15), "本日開始件数");
        exBizCalcbleEquals(countOfKakoJissekiTaskSummaryBeanLst.get(2).getCountOfprocessLeftToday(),
                BizNumber.valueOf(10), "本日残件数");
        exBizCalcbleEquals(countOfKakoJissekiTaskSummaryBeanLst.get(2).getCountOfprocessFinToday(),
                BizNumber.valueOf(20), "本日完了件数");
        exStringEquals(countOfKakoJissekiTaskSummaryBeanLst.get(2).getJimutetuzukiCd(), "301223301", "事務手続コード");
        exStringEquals(countOfKakoJissekiTaskSummaryBeanLst.get(2).getTaskNm(), "task302", "タスク名");

        exStringEquals(countOfKakoJissekiTaskSummaryBeanLst.get(3).getUserId(), "userId30100001", "ユーザーID");
        exStringEquals(countOfKakoJissekiTaskSummaryBeanLst.get(3).getDispUserNm(), "ｕｓｅｒＩｄ３０１００００１", "（表示用）ユーザー名");
        exBizCalcbleEquals(countOfKakoJissekiTaskSummaryBeanLst.get(3).getCountOfprocessStartToday(),
                BizNumber.valueOf(14), "本日開始件数");
        exBizCalcbleEquals(countOfKakoJissekiTaskSummaryBeanLst.get(3).getCountOfprocessLeftToday(),
                BizNumber.valueOf(9), "本日残件数");
        exBizCalcbleEquals(countOfKakoJissekiTaskSummaryBeanLst.get(3).getCountOfprocessFinToday(),
                BizNumber.valueOf(19), "本日完了件数");
        exStringEquals(countOfKakoJissekiTaskSummaryBeanLst.get(3).getJimutetuzukiCd(), "301223301", "事務手続コード");
        exStringEquals(countOfKakoJissekiTaskSummaryBeanLst.get(3).getTaskNm(), "task301", "タスク名");
    }

    @Test
    @TestOrder(40)
    public void testGetCountOfKakoJissekiTaskSummaryByTask_A4() {

        GetCountOfTaskSummaryByTaskResultBean ret = WorkFlowUtility.getCountOfKakoJissekiTaskSummaryByTask(
                BizDate.valueOf(20180111), "401223301", new String[]{"task401","task402"}, "");
        exStringEquals(ret.getSyorikekkaStatus(), "0", "処理結果ステータス");
        exStringEquals(ret.getSyousaiMessageCd(), null, "詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), null, "詳細メッセージ");
        List<CountOfTaskSummaryByTaskBean> countOfKakoJissekiTaskSummaryBeanLst =
                ret.getCountOfTaskSummaryBean();
        exNumericEquals(countOfKakoJissekiTaskSummaryBeanLst.size(), 2, "件数");

        exStringEquals(countOfKakoJissekiTaskSummaryBeanLst.get(0).getUserId(), "userId401000001", "ユーザーID");
        exStringEquals(countOfKakoJissekiTaskSummaryBeanLst.get(0).getDispUserNm(), "ｕｓｅｒＩｄ４０１０００００１", "（表示用）ユーザー名");
        exBizCalcbleEquals(countOfKakoJissekiTaskSummaryBeanLst.get(0).getCountOfprocessStartToday(),
                BizNumber.valueOf(16), "本日開始件数");
        exBizCalcbleEquals(countOfKakoJissekiTaskSummaryBeanLst.get(0).getCountOfprocessLeftToday(),
                BizNumber.valueOf(11), "本日残件数");
        exBizCalcbleEquals(countOfKakoJissekiTaskSummaryBeanLst.get(0).getCountOfprocessFinToday(),
                BizNumber.valueOf(21), "本日完了件数");
        exStringEquals(countOfKakoJissekiTaskSummaryBeanLst.get(0).getJimutetuzukiCd(), "401223301", "事務手続コード");
        exStringEquals(countOfKakoJissekiTaskSummaryBeanLst.get(0).getTaskNm(), "task401", "タスク名");

        exStringEquals(countOfKakoJissekiTaskSummaryBeanLst.get(1).getUserId(), "userId4020000021", "ユーザーID");
        exStringEquals(countOfKakoJissekiTaskSummaryBeanLst.get(1).getDispUserNm(), "ｕｓｅｒＩｄ４０２０００００２", "（表示用）ユーザー名");
        exBizCalcbleEquals(countOfKakoJissekiTaskSummaryBeanLst.get(1).getCountOfprocessStartToday(),
                BizNumber.valueOf(17), "本日開始件数");
        exBizCalcbleEquals(countOfKakoJissekiTaskSummaryBeanLst.get(1).getCountOfprocessLeftToday(),
                BizNumber.valueOf(12), "本日残件数");
        exBizCalcbleEquals(countOfKakoJissekiTaskSummaryBeanLst.get(1).getCountOfprocessFinToday(),
                BizNumber.valueOf(22), "本日完了件数");
        exStringEquals(countOfKakoJissekiTaskSummaryBeanLst.get(1).getJimutetuzukiCd(), "401223301", "事務手続コード");
        exStringEquals(countOfKakoJissekiTaskSummaryBeanLst.get(1).getTaskNm(), "task402", "タスク名");

    }
}
