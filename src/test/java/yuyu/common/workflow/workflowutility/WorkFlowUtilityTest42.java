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
import yuyu.def.workflow.manager.WorkflowDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ワークフロー呼出ユーティリティクラスのメソッド {@link WorkFlowUtility#getCountOfKakoJissekiTaskSummaryByJimutetuzuki(String[], BizDate, String, String)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class WorkFlowUtilityTest42 {

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_【42_処理残件数取得_過去実績サマリ分(事務手続指定)】";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {

            TestDataMaker testDataMaker = new TestDataMaker();

            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

            testDataAndTblMap = testDataMaker.getInData(WorkFlowUtilityTest42.class, fileName, sheetName);

            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);

        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        WorkflowDomManager workflowDomManager = SWAKInjector.getInstance(WorkflowDomManager.class);

        workflowDomManager.delete(workflowDomManager.getAllJimutetuzukiRireki());
        workflowDomManager.delete(workflowDomManager.getAllSyoriKensuuHokanTask());
    }

    @Test
    @TestOrder(10)
    public void testGetCountOfKakoJissekiTaskSummaryByJimutetuzuki_A1() {

        GetCountOfTaskSummaryByJimutetuzukiResultBean ret = WorkFlowUtility.getCountOfKakoJissekiTaskSummaryByJimutetuzuki(
            new String[]{"sub101"}, BizDate.valueOf(20180108), "101223301", "userId101");

        exStringEquals(ret.getSyorikekkaStatus(), "-1", "処理結果ステータス");
        exStringEquals(ret.getSyousaiMessageCd(), null, "詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), null, "詳細メッセージ");
        List<CountOfTaskSummaryByJimutetuzukiBean> countOfTaskSummaryByJimutetuzukiBeanLst =
            ret.getCountOfTaskSummaryBean();
        exNumericEquals(countOfTaskSummaryByJimutetuzukiBeanLst.size(), 0, "件数");
    }

    @Test
    @TestOrder(20)
    public void testGetCountOfKakoJissekiTaskSummaryByJimutetuzuki_A2() {

        GetCountOfTaskSummaryByJimutetuzukiResultBean ret = WorkFlowUtility.getCountOfKakoJissekiTaskSummaryByJimutetuzuki(
            new String[]{"sub201"}, BizDate.valueOf(20180109), "201223301", "userId201");

        exStringEquals(ret.getSyorikekkaStatus(), "0", "処理結果ステータス");
        exStringEquals(ret.getSyousaiMessageCd(), null, "詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), null, "詳細メッセージ");
        List<CountOfTaskSummaryByJimutetuzukiBean> countOfTaskSummaryByJimutetuzukiBeanLst =
            ret.getCountOfTaskSummaryBean();
        exNumericEquals(countOfTaskSummaryByJimutetuzukiBeanLst.size(), 0, "件数");

    }

    @Test
    @TestOrder(30)
    public void testGetCountOfKakoJissekiTaskSummaryByJimutetuzuki_A3() {

        GetCountOfTaskSummaryByJimutetuzukiResultBean ret = WorkFlowUtility.getCountOfKakoJissekiTaskSummaryByJimutetuzuki(
            new String[]{"sub301"}, BizDate.valueOf(20180110), "301223301", "userId301");

        exStringEquals(ret.getSyorikekkaStatus(), "0", "処理結果ステータス");
        exStringEquals(ret.getSyousaiMessageCd(), null, "詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), null, "詳細メッセージ");
        List<CountOfTaskSummaryByJimutetuzukiBean> countOfTaskSummaryByJimutetuzukiBeanLst =
            ret.getCountOfTaskSummaryBean();
        exNumericEquals(countOfTaskSummaryByJimutetuzukiBeanLst.size(), 1, "件数");

        exStringEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(0).getJimutetuzukiCd(), "301223301", "事務手続コード");
        exStringEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(0).getTaskNm(), "w30177889901", "タスク名");
        exStringEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(0).getDispTaskNm(), "ワークフロータスク名３０１", "（表示用）タスク名");
        exBizCalcbleEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(0).getCountOfprocessStartToday(),
            BizNumber.valueOf(0), "本日開始件数");
        exBizCalcbleEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(0).getCountOfprocessLeftToday(),
            BizNumber.valueOf(0), "本日残件数");
        exBizCalcbleEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(0).getCountOfprocessFinToday(),
            BizNumber.valueOf(0), "本日完了件数");
    }

    @Test
    @TestOrder(40)
    public void testGetCountOfKakoJissekiTaskSummaryByJimutetuzuki_A4() {

        GetCountOfTaskSummaryByJimutetuzukiResultBean ret = WorkFlowUtility.getCountOfKakoJissekiTaskSummaryByJimutetuzuki(
            new String[]{"sub401","sub402","sub403"}, BizDate.valueOf(20180111), "401223301", null);

        exStringEquals(ret.getSyorikekkaStatus(), "0", "処理結果ステータス");
        exStringEquals(ret.getSyousaiMessageCd(), null, "詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), null, "詳細メッセージ");
        List<CountOfTaskSummaryByJimutetuzukiBean> countOfTaskSummaryByJimutetuzukiBeanLst =
            ret.getCountOfTaskSummaryBean();

        exNumericEquals(countOfTaskSummaryByJimutetuzukiBeanLst.size(), 3, "件数");

        exStringEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(0).getJimutetuzukiCd(), "401223301", "事務手続コード");
        exStringEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(0).getTaskNm(), "w40177889901", "タスク名");
        exStringEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(0).getDispTaskNm(), "ワークフロータスク名４０１", "（表示用）タスク名");
        exBizCalcbleEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(0).getCountOfprocessStartToday(),
            BizNumber.valueOf(48), "本日開始件数");
        exBizCalcbleEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(0).getCountOfprocessLeftToday(),
            BizNumber.valueOf(318), "本日残件数");
        exBizCalcbleEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(0).getCountOfprocessFinToday(),
            BizNumber.valueOf(3018), "本日完了件数");

        exStringEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(1).getJimutetuzukiCd(), "401223301", "事務手続コード");
        exStringEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(1).getTaskNm(), "w40177889905", "タスク名");
        exStringEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(1).getDispTaskNm(), "ワークフロータスク名４０５", "（表示用）タスク名");
        exBizCalcbleEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(1).getCountOfprocessStartToday(),
            BizNumber.valueOf(20), "本日開始件数");
        exBizCalcbleEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(1).getCountOfprocessLeftToday(),
            BizNumber.valueOf(110), "本日残件数");
        exBizCalcbleEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(1).getCountOfprocessFinToday(),
            BizNumber.valueOf(1010), "本日完了件数");

        exStringEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(2).getJimutetuzukiCd(), "401223301", "事務手続コード");
        exStringEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(2).getTaskNm(), "w40177889902", "タスク名");
        exStringEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(2).getDispTaskNm(), "ワークフロータスク名４０２", "（表示用）タスク名");
        exBizCalcbleEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(2).getCountOfprocessStartToday(),
            BizNumber.valueOf(37), "本日開始件数");
        exBizCalcbleEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(2).getCountOfprocessLeftToday(),
            BizNumber.valueOf(217), "本日残件数");
        exBizCalcbleEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(2).getCountOfprocessFinToday(),
            BizNumber.valueOf(2017), "本日完了件数");

    }
}
