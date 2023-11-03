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
 * ワークフロー呼出ユーティリティクラスのメソッド {@link WorkFlowUtility#getCountOfKakoJissekiTaskSummaryBySubsystem(String[], BizDate, String)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class WorkFlowUtilityTest41 {

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_【41_処理残件数取得_過去実績サマリ分(サブシステム・ユーザーID指定)】";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {

            TestDataMaker testDataMaker = new TestDataMaker();

            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

            testDataAndTblMap = testDataMaker.getInData(WorkFlowUtilityTest41.class, fileName, sheetName);

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
        workflowDomManager.delete(workflowDomManager.getAllSyoriKensuuHokanJimu());
    }

    @Test
    @TestOrder(10)
    public void testGetCountOfKakoJissekiTaskSummaryBySubsystem_A1() {

        GetCountOfTaskSummaryBySubsystemResultBean ret = WorkFlowUtility.getCountOfKakoJissekiTaskSummaryBySubsystem(
            null, BizDate.valueOf(20180108), "userId101");

        exStringEquals(ret.getSyorikekkaStatus(), "-1", "処理結果ステータス");
        exStringEquals(ret.getSyousaiMessageCd(), null, "詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), null, "詳細メッセージ");
        List<CountOfTaskSummaryBySubsystemBean> countOfTaskSummaryBySubsystemBeanLst =
            ret.getCountOfTaskSummaryBean();
        exNumericEquals(countOfTaskSummaryBySubsystemBeanLst.size(), 0, "件数");
    }


    @Test
    @TestOrder(20)
    public void testGetCountOfKakoJissekiTaskSummaryBySubsystem_A2() {

        GetCountOfTaskSummaryBySubsystemResultBean ret = WorkFlowUtility.getCountOfKakoJissekiTaskSummaryBySubsystem(
            new String[]{}, BizDate.valueOf(20180108), "userId101");

        exStringEquals(ret.getSyorikekkaStatus(), "-1", "処理結果ステータス");
        exStringEquals(ret.getSyousaiMessageCd(), null, "詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), null, "詳細メッセージ");
        List<CountOfTaskSummaryBySubsystemBean> countOfTaskSummaryBySubsystemBeanLst =
            ret.getCountOfTaskSummaryBean();
        exNumericEquals(countOfTaskSummaryBySubsystemBeanLst.size(), 0, "件数");
    }


    @Test
    @TestOrder(30)
    public void testGetCountOfKakoJissekiTaskSummaryBySubsystem_A3() {

        GetCountOfTaskSummaryBySubsystemResultBean ret = WorkFlowUtility.getCountOfKakoJissekiTaskSummaryBySubsystem(
            new String[]{"sub101"}, null, "userId101");

        exStringEquals(ret.getSyorikekkaStatus(), "-1", "処理結果ステータス");
        exStringEquals(ret.getSyousaiMessageCd(), null, "詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), null, "詳細メッセージ");
        List<CountOfTaskSummaryBySubsystemBean> countOfTaskSummaryBySubsystemBeanLst =
            ret.getCountOfTaskSummaryBean();
        exNumericEquals(countOfTaskSummaryBySubsystemBeanLst.size(), 0, "件数");
    }


    @Test
    @TestOrder(40)
    public void testGetCountOfKakoJissekiTaskSummaryBySubsystem_A4() {

        GetCountOfTaskSummaryBySubsystemResultBean ret = WorkFlowUtility.getCountOfKakoJissekiTaskSummaryBySubsystem(
            new String[]{"sub101"}, BizDate.valueOf(20180108), "userId101");

        exStringEquals(ret.getSyorikekkaStatus(), "-1", "処理結果ステータス");
        exStringEquals(ret.getSyousaiMessageCd(), null, "詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), null, "詳細メッセージ");
        List<CountOfTaskSummaryBySubsystemBean> countOfTaskSummaryBySubsystemBeanLst =
            ret.getCountOfTaskSummaryBean();
        exNumericEquals(countOfTaskSummaryBySubsystemBeanLst.size(), 0, "件数");
    }

    @Test
    @TestOrder(50)
    public void testGetCountOfKakoJissekiTaskSummaryBySubsystem_A5() {

        GetCountOfTaskSummaryBySubsystemResultBean ret = WorkFlowUtility.getCountOfKakoJissekiTaskSummaryBySubsystem(
            new String[]{"sub201"}, BizDate.valueOf(20180109), "userId201");

        exStringEquals(ret.getSyorikekkaStatus(), "0", "処理結果ステータス");
        exStringEquals(ret.getSyousaiMessageCd(), null, "詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), null, "詳細メッセージ");
        List<CountOfTaskSummaryBySubsystemBean> countOfTaskSummaryBySubsystemBeanLst =
            ret.getCountOfTaskSummaryBean();
        exNumericEquals(countOfTaskSummaryBySubsystemBeanLst.size(), 0, "件数");

    }

    @Test
    @TestOrder(60)
    public void testGetCountOfKakoJissekiTaskSummaryBySubsystem_A6() {

        GetCountOfTaskSummaryBySubsystemResultBean ret = WorkFlowUtility.getCountOfKakoJissekiTaskSummaryBySubsystem(
            new String[]{"sub301"}, BizDate.valueOf(20180110), "userId301");

        exStringEquals(ret.getSyorikekkaStatus(), "0", "処理結果ステータス");
        exStringEquals(ret.getSyousaiMessageCd(), null, "詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), null, "詳細メッセージ");
        List<CountOfTaskSummaryBySubsystemBean> countOfTaskSummaryBySubsystemBeanLst =
            ret.getCountOfTaskSummaryBean();
        exNumericEquals(countOfTaskSummaryBySubsystemBeanLst.size(), 1, "件数");

        exStringEquals(countOfTaskSummaryBySubsystemBeanLst.get(0).getJimutetuzukiCd(), "301223301", "事務手続コード");
        exStringEquals(countOfTaskSummaryBySubsystemBeanLst.get(0).getJimutetuzukiNm(), "事務手続名３０１", "事務手続名");
        exBizCalcbleEquals(countOfTaskSummaryBySubsystemBeanLst.get(0).getCountOfprocessStartToday(),
            BizNumber.valueOf(0), "本日開始件数");
        exBizCalcbleEquals(countOfTaskSummaryBySubsystemBeanLst.get(0).getCountOfprocessLeftToday(),
            BizNumber.valueOf(0), "本日残件数");
        exBizCalcbleEquals(countOfTaskSummaryBySubsystemBeanLst.get(0).getCountOfprocessFinToday(),
            BizNumber.valueOf(0), "本日完了件数");
        exBooleanEquals(countOfTaskSummaryBySubsystemBeanLst.get(0).isTaskFinByActorFlg(), false, "タスク別件数完了担当者フラグ");
    }

    @Test
    @TestOrder(70)
    public void testGetCountOfKakoJissekiTaskSummaryBySubsystem_A7() {

        GetCountOfTaskSummaryBySubsystemResultBean ret = WorkFlowUtility.getCountOfKakoJissekiTaskSummaryBySubsystem(
            new String[]{"sub401"}, BizDate.valueOf(20180111), "userId401");

        exStringEquals(ret.getSyorikekkaStatus(), "0", "処理結果ステータス");
        exStringEquals(ret.getSyousaiMessageCd(), null, "詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), null, "詳細メッセージ");
        List<CountOfTaskSummaryBySubsystemBean> countOfTaskSummaryBySubsystemBeanLst =
            ret.getCountOfTaskSummaryBean();
        exNumericEquals(countOfTaskSummaryBySubsystemBeanLst.size(), 1, "件数");

        exStringEquals(countOfTaskSummaryBySubsystemBeanLst.get(0).getJimutetuzukiCd(), "401223301", "事務手続コード");
        exStringEquals(countOfTaskSummaryBySubsystemBeanLst.get(0).getJimutetuzukiNm(), "事務手続名４０１", "事務手続名");
        exBizCalcbleEquals(countOfTaskSummaryBySubsystemBeanLst.get(0).getCountOfprocessStartToday(),
            BizNumber.valueOf(14), "本日開始件数");
        exBizCalcbleEquals(countOfTaskSummaryBySubsystemBeanLst.get(0).getCountOfprocessLeftToday(),
            BizNumber.valueOf(104), "本日残件数");
        exBizCalcbleEquals(countOfTaskSummaryBySubsystemBeanLst.get(0).getCountOfprocessFinToday(),
            BizNumber.valueOf(1004), "本日完了件数");
        exBooleanEquals(countOfTaskSummaryBySubsystemBeanLst.get(0).isTaskFinByActorFlg(), true, "タスク別件数完了担当者フラグ");
    }

    @Test
    @TestOrder(80)
    public void testGetCountOfKakoJissekiTaskSummaryBySubsystem_A8() {

        GetCountOfTaskSummaryBySubsystemResultBean ret = WorkFlowUtility.getCountOfKakoJissekiTaskSummaryBySubsystem(
            new String[]{"sub501"}, BizDate.valueOf(20180112), null);

        exStringEquals(ret.getSyorikekkaStatus(), "0", "処理結果ステータス");
        exStringEquals(ret.getSyousaiMessageCd(), null, "詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), null, "詳細メッセージ");
        List<CountOfTaskSummaryBySubsystemBean> countOfTaskSummaryBySubsystemBeanLst =
            ret.getCountOfTaskSummaryBean();
        exNumericEquals(countOfTaskSummaryBySubsystemBeanLst.size(), 1, "件数");

        exStringEquals(countOfTaskSummaryBySubsystemBeanLst.get(0).getJimutetuzukiCd(), "501223301", "事務手続コード");
        exStringEquals(countOfTaskSummaryBySubsystemBeanLst.get(0).getJimutetuzukiNm(), "事務手続名５０１", "事務手続名");
        exBizCalcbleEquals(countOfTaskSummaryBySubsystemBeanLst.get(0).getCountOfprocessStartToday(),
            BizNumber.valueOf(48), "本日開始件数");
        exBizCalcbleEquals(countOfTaskSummaryBySubsystemBeanLst.get(0).getCountOfprocessLeftToday(),
            BizNumber.valueOf(318), "本日残件数");
        exBizCalcbleEquals(countOfTaskSummaryBySubsystemBeanLst.get(0).getCountOfprocessFinToday(),
            BizNumber.valueOf(3018), "本日完了件数");
        exBooleanEquals(countOfTaskSummaryBySubsystemBeanLst.get(0).isTaskFinByActorFlg(), true, "タスク別件数完了担当者フラグ");
    }

    @Test
    @TestOrder(90)
    public void testGetCountOfKakoJissekiTaskSummaryBySubsystem_A9() {

        GetCountOfTaskSummaryBySubsystemResultBean ret = WorkFlowUtility.getCountOfKakoJissekiTaskSummaryBySubsystem(
            new String[]{"sub601","sub602","sub603"}, BizDate.valueOf(20180113), "");

        exStringEquals(ret.getSyorikekkaStatus(), "0", "処理結果ステータス");
        exStringEquals(ret.getSyousaiMessageCd(), null, "詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), null, "詳細メッセージ");
        List<CountOfTaskSummaryBySubsystemBean> countOfTaskSummaryBySubsystemBeanLst =
            ret.getCountOfTaskSummaryBean();
        exNumericEquals(countOfTaskSummaryBySubsystemBeanLst.size(), 3, "件数");

        exStringEquals(countOfTaskSummaryBySubsystemBeanLst.get(0).getJimutetuzukiCd(), "601223302", "事務手続コード");
        exStringEquals(countOfTaskSummaryBySubsystemBeanLst.get(0).getJimutetuzukiNm(), "事務手続名６０２", "事務手続名");
        exBizCalcbleEquals(countOfTaskSummaryBySubsystemBeanLst.get(0).getCountOfprocessStartToday(),
            BizNumber.valueOf(61), "本日開始件数");
        exBizCalcbleEquals(countOfTaskSummaryBySubsystemBeanLst.get(0).getCountOfprocessLeftToday(),
            BizNumber.valueOf(331), "本日残件数");
        exBizCalcbleEquals(countOfTaskSummaryBySubsystemBeanLst.get(0).getCountOfprocessFinToday(),
            BizNumber.valueOf(3031), "本日完了件数");
        exBooleanEquals(countOfTaskSummaryBySubsystemBeanLst.get(0).isTaskFinByActorFlg(), true, "タスク別件数完了担当者フラグ");


        exStringEquals(countOfTaskSummaryBySubsystemBeanLst.get(1).getJimutetuzukiCd(), "601223303", "事務手続コード");
        exStringEquals(countOfTaskSummaryBySubsystemBeanLst.get(1).getJimutetuzukiNm(), "事務手続名６０３", "事務手続名");
        exBizCalcbleEquals(countOfTaskSummaryBySubsystemBeanLst.get(1).getCountOfprocessStartToday(),
            BizNumber.valueOf(41), "本日開始件数");
        exBizCalcbleEquals(countOfTaskSummaryBySubsystemBeanLst.get(1).getCountOfprocessLeftToday(),
            BizNumber.valueOf(221), "本日残件数");
        exBizCalcbleEquals(countOfTaskSummaryBySubsystemBeanLst.get(1).getCountOfprocessFinToday(),
            BizNumber.valueOf(2021), "本日完了件数");
        exBooleanEquals(countOfTaskSummaryBySubsystemBeanLst.get(1).isTaskFinByActorFlg(), true, "タスク別件数完了担当者フラグ");


        exStringEquals(countOfTaskSummaryBySubsystemBeanLst.get(2).getJimutetuzukiCd(), "601223301", "事務手続コード");
        exStringEquals(countOfTaskSummaryBySubsystemBeanLst.get(2).getJimutetuzukiNm(), "事務手続名６０１", "事務手続名");
        exBizCalcbleEquals(countOfTaskSummaryBySubsystemBeanLst.get(2).getCountOfprocessStartToday(),
            BizNumber.valueOf(21), "本日開始件数");
        exBizCalcbleEquals(countOfTaskSummaryBySubsystemBeanLst.get(2).getCountOfprocessLeftToday(),
            BizNumber.valueOf(111), "本日残件数");
        exBizCalcbleEquals(countOfTaskSummaryBySubsystemBeanLst.get(2).getCountOfprocessFinToday(),
            BizNumber.valueOf(1011), "本日完了件数");
        exBooleanEquals(countOfTaskSummaryBySubsystemBeanLst.get(2).isTaskFinByActorFlg(), false, "タスク別件数完了担当者フラグ");

    }
}
