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
 * ワークフロー呼出ユーティリティクラスのメソッド {@link WorkFlowUtility#getCountOfTaskSummaryByJimutetuzuki(String[] pSubsystemId, BizDate pSyoriYmdFrom, BizDate pSyoriYmdTo, String pJimutetuzukiCd, String pUserId)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class WorkFlowUtilityTest45 {

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_【45_処理残件数取得_過去実績サマリ分(事務手続・処理日指定)】";

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
        workflowDomManager.delete(workflowDomManager.getAllJimutetuzuki());

    }

    @Test
    @TestOrder(10)
    public void testGetCountOfTaskSummaryByJimutetuzuki_A1() {

        GetCountOfTaskSummaryByJimutetuzukiResultBean ret = WorkFlowUtility.getCountOfTaskSummaryByJimutetuzuki(
            new String[]{"workflow"}, BizDate.valueOf(20200206), BizDate.valueOf(20200206), "101223301", "userId101");
        exStringEquals(ret.getSyorikekkaStatus(), "-1", "処理結果ステータス");
        exStringEquals(ret.getSyousaiMessageCd(), null, "詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), null, "詳細メッセージ");
        List<CountOfTaskSummaryByJimutetuzukiBean> countOfTaskSummaryByJimutetuzukiBeanLst =
            ret.getCountOfTaskSummaryBean();
        exNumericEquals(countOfTaskSummaryByJimutetuzukiBeanLst.size(), 0, "件数");
    }


    @Test
    @TestOrder(20)
    public void testGetCountOfTaskSummaryByJimutetuzuki_A2() {

        GetCountOfTaskSummaryByJimutetuzukiResultBean ret = WorkFlowUtility.getCountOfTaskSummaryByJimutetuzuki(
            new String[]{"workflow"}, BizDate.valueOf(20200207), BizDate.valueOf(20200207), "201223301", "userId102");
        exStringEquals(ret.getSyorikekkaStatus(), "0", "処理結果ステータス");
        exStringEquals(ret.getSyousaiMessageCd(), null, "詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), null, "詳細メッセージ");
        List<CountOfTaskSummaryByJimutetuzukiBean> countOfTaskSummaryByJimutetuzukiBeanLst =
            ret.getCountOfTaskSummaryBean();
        exNumericEquals(countOfTaskSummaryByJimutetuzukiBeanLst.size(), 0, "件数");
    }

    @Test
    @TestOrder(30)
    public void testGetCountOfTaskSummaryByJimutetuzuki_A3() {

        GetCountOfTaskSummaryByJimutetuzukiResultBean ret = WorkFlowUtility.getCountOfTaskSummaryByJimutetuzuki(
            new String[]{"hozen"}, BizDate.valueOf(20200207), BizDate.valueOf(20200207), "301223301" ,"userId101");

        exStringEquals(ret.getSyorikekkaStatus(), "0", "処理結果ステータス");
        exStringEquals(ret.getSyousaiMessageCd(), null, "詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), null, "詳細メッセージ");
        List<CountOfTaskSummaryByJimutetuzukiBean> countOfTaskSummaryByJimutetuzukiBeanLst =
            ret.getCountOfTaskSummaryBean();
        exNumericEquals(countOfTaskSummaryByJimutetuzukiBeanLst.size(), 1, "件数");

        exStringEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(0).getJimutetuzukiCd(), "301223301", "事務手続コード");
        exStringEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(0).getTaskNm(), "workflowTskId311", "タスク名");
        exStringEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(0).getDispTaskNm(), "タスク名３１１", "（表示用）タスク名");
        exBizCalcbleEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(0).getCountOfprocessStartToday(),
            BizNumber.valueOf(0), "本日開始件数");
        exBizCalcbleEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(0).getCountOfprocessLeftToday(),
            BizNumber.valueOf(0), "本日残件数");
        exBizCalcbleEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(0).getCountOfprocessFinToday(),
            BizNumber.valueOf(0), "本日完了件数");
    }

    @Test
    @TestOrder(40)
    public void testGetCountOfTaskSummaryByJimutetuzuki_A4() {

        GetCountOfTaskSummaryByJimutetuzukiResultBean ret = WorkFlowUtility.getCountOfTaskSummaryByJimutetuzuki(
            new String[]{"hozen"}, BizDate.valueOf(20200209), BizDate.valueOf(20200211), "401223301", "userId104");

        exStringEquals(ret.getSyorikekkaStatus(), "0", "処理結果ステータス");
        exStringEquals(ret.getSyousaiMessageCd(), null, "詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), null, "詳細メッセージ");
        List<CountOfTaskSummaryByJimutetuzukiBean> countOfTaskSummaryByJimutetuzukiBeanLst =
            ret.getCountOfTaskSummaryBean();
        exNumericEquals(countOfTaskSummaryByJimutetuzukiBeanLst.size(), 1, "件数");

        exStringEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(0).getJimutetuzukiCd(), "401223301", "事務手続コード");
        exStringEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(0).getTaskNm(), "workflowTskId412", "タスク名");
        exStringEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(0).getDispTaskNm(), "タスク名４１２", "（表示用）タスク名");
        exBizCalcbleEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(0).getCountOfprocessStartToday(),
            BizNumber.valueOf(4), "本日開始件数");
        exBizCalcbleEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(0).getCountOfprocessLeftToday(),
            BizNumber.valueOf(24), "本日残件数");
        exBizCalcbleEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(0).getCountOfprocessFinToday(),
            BizNumber.valueOf(44), "本日完了件数");
    }

    @Test
    @TestOrder(50)
    public void testGetCountOfTaskSummaryByJimutetuzuki_A5() {

        GetCountOfTaskSummaryByJimutetuzukiResultBean ret = WorkFlowUtility.getCountOfTaskSummaryByJimutetuzuki(
            new String[]{"hozen", "workflow"}, BizDate.valueOf(20200214), BizDate.valueOf(20200215), "501223301",
            "userId105");

        exStringEquals(ret.getSyorikekkaStatus(), "0", "処理結果ステータス");
        exStringEquals(ret.getSyousaiMessageCd(), null, "詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), null, "詳細メッセージ");
        List<CountOfTaskSummaryByJimutetuzukiBean> countOfTaskSummaryByJimutetuzukiBeanLst =
            ret.getCountOfTaskSummaryBean();
        exNumericEquals(countOfTaskSummaryByJimutetuzukiBeanLst.size(), 3, "件数");

        exStringEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(0).getJimutetuzukiCd(), "501223301", "事務手続コード");
        exStringEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(0).getTaskNm(), "workflowTskId511", "タスク名");
        exStringEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(0).getDispTaskNm(), "タスク名５１１", "（表示用）タスク名");
        exBizCalcbleEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(0).getCountOfprocessStartToday(),
            BizNumber.valueOf(0), "本日開始件数");
        exBizCalcbleEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(0).getCountOfprocessLeftToday(),
            BizNumber.valueOf(0), "本日残件数");
        exBizCalcbleEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(0).getCountOfprocessFinToday(),
            BizNumber.valueOf(0), "本日完了件数");

        exStringEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(1).getJimutetuzukiCd(), "501223301", "事務手続コード");
        exStringEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(1).getTaskNm(), "workflowTskId512", "タスク名");
        exStringEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(1).getDispTaskNm(), "タスク名５２４", "（表示用）タスク名");
        exBizCalcbleEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(1).getCountOfprocessStartToday(),
            BizNumber.valueOf(11), "本日開始件数");
        exBizCalcbleEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(1).getCountOfprocessLeftToday(),
            BizNumber.valueOf(51), "本日残件数");
        exBizCalcbleEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(1).getCountOfprocessFinToday(),
            BizNumber.valueOf(91), "本日完了件数");

        exStringEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(2).getJimutetuzukiCd(), "501223301", "事務手続コード");
        exStringEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(2).getTaskNm(), "workflowTskId513", "タスク名");
        exStringEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(2).getDispTaskNm(), "タスク名５２５", "（表示用）タスク名");
        exBizCalcbleEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(2).getCountOfprocessStartToday(),
            BizNumber.valueOf(0), "本日開始件数");
        exBizCalcbleEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(2).getCountOfprocessLeftToday(),
            BizNumber.valueOf(0), "本日残件数");
        exBizCalcbleEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(2).getCountOfprocessFinToday(),
            BizNumber.valueOf(0), "本日完了件数");
    }

    @Test
    @TestOrder(60)
    public void testGetCountOfTaskSummaryByJimutetuzuki_A6() {

        GetCountOfTaskSummaryByJimutetuzukiResultBean ret = WorkFlowUtility.getCountOfTaskSummaryByJimutetuzuki(
            new String[]{"hozen", "workflow", "sinkeiyaku", "siharai", "suuri"}, BizDate.valueOf(20200218),
            BizDate.valueOf(20200225), "601223301" ,"userId106");

        exStringEquals(ret.getSyorikekkaStatus(), "0", "処理結果ステータス");
        exStringEquals(ret.getSyousaiMessageCd(), null, "詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), null, "詳細メッセージ");
        List<CountOfTaskSummaryByJimutetuzukiBean> countOfTaskSummaryByJimutetuzukiBeanLst =
            ret.getCountOfTaskSummaryBean();
        exNumericEquals(countOfTaskSummaryByJimutetuzukiBeanLst.size(), 4, "件数");

        exStringEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(0).getJimutetuzukiCd(), "601223301", "事務手続コード");
        exStringEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(0).getTaskNm(), "workflowTskId641", "タスク名");
        exStringEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(0).getDispTaskNm(), "タスク名６４１", "（表示用）タスク名");
        exBizCalcbleEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(0).getCountOfprocessStartToday(),
            BizNumber.valueOf(33), "本日開始件数");
        exBizCalcbleEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(0).getCountOfprocessLeftToday(),
            BizNumber.valueOf(93), "本日残件数");
        exBizCalcbleEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(0).getCountOfprocessFinToday(),
            BizNumber.valueOf(153), "本日完了件数");

        exStringEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(1).getJimutetuzukiCd(), "601223301", "事務手続コード");
        exStringEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(1).getTaskNm(), "workflowTskId631", "タスク名");
        exStringEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(1).getDispTaskNm(), "タスク名６３１", "（表示用）タスク名");
        exBizCalcbleEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(1).getCountOfprocessStartToday(),
            BizNumber.valueOf(9), "本日開始件数");
        exBizCalcbleEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(1).getCountOfprocessLeftToday(),
            BizNumber.valueOf(29), "本日残件数");
        exBizCalcbleEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(1).getCountOfprocessFinToday(),
            BizNumber.valueOf(49), "本日完了件数");

        exStringEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(2).getJimutetuzukiCd(), "601223301", "事務手続コード");
        exStringEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(2).getTaskNm(), "workflowTskId651", "タスク名");
        exStringEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(2).getDispTaskNm(), "タスク名６５１", "（表示用）タスク名");
        exBizCalcbleEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(2).getCountOfprocessStartToday(),
            BizNumber.valueOf(0), "本日開始件数");
        exBizCalcbleEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(2).getCountOfprocessLeftToday(),
            BizNumber.valueOf(0), "本日残件数");
        exBizCalcbleEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(2).getCountOfprocessFinToday(),
            BizNumber.valueOf(0), "本日完了件数");

        exStringEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(3).getJimutetuzukiCd(), "601223301", "事務手続コード");
        exStringEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(3).getTaskNm(), "workflowTskId611", "タスク名");
        exStringEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(3).getDispTaskNm(), "タスク名６１１", "（表示用）タスク名");
        exBizCalcbleEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(3).getCountOfprocessStartToday(),
            BizNumber.valueOf(15), "本日開始件数");
        exBizCalcbleEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(3).getCountOfprocessLeftToday(),
            BizNumber.valueOf(55), "本日残件数");
        exBizCalcbleEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(3).getCountOfprocessFinToday(),
            BizNumber.valueOf(95), "本日完了件数");

    }

    @Test
    @TestOrder(70)
    public void testGetCountOfTaskSummaryByJimutetuzuki_A7() {

        GetCountOfTaskSummaryByJimutetuzukiResultBean ret = WorkFlowUtility.getCountOfTaskSummaryByJimutetuzuki(
            new String[]{"hozen"}, BizDate.valueOf(20200210), BizDate.valueOf(20200211), "401223301", "userId104");

        exStringEquals(ret.getSyorikekkaStatus(), "0", "処理結果ステータス");
        exStringEquals(ret.getSyousaiMessageCd(), null, "詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), null, "詳細メッセージ");
        List<CountOfTaskSummaryByJimutetuzukiBean> countOfTaskSummaryByJimutetuzukiBeanLst =
            ret.getCountOfTaskSummaryBean();
        exNumericEquals(countOfTaskSummaryByJimutetuzukiBeanLst.size(), 1, "件数");

        exStringEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(0).getJimutetuzukiCd(), "401223301", "事務手続コード");
        exStringEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(0).getTaskNm(), "workflowTskId412", "タスク名");
        exStringEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(0).getDispTaskNm(), "タスク名４１２", "（表示用）タスク名");
        exBizCalcbleEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(0).getCountOfprocessStartToday(),
            BizNumber.valueOf(4), "本日開始件数");
        exBizCalcbleEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(0).getCountOfprocessLeftToday(),
            BizNumber.valueOf(24), "本日残件数");
        exBizCalcbleEquals(countOfTaskSummaryByJimutetuzukiBeanLst.get(0).getCountOfprocessFinToday(),
            BizNumber.valueOf(44), "本日完了件数");
    }

}
