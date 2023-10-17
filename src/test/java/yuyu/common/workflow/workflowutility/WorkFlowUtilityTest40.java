package yuyu.common.workflow.workflowutility;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.common.collect.Lists;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.workflow.IwfKouteiClientMock;
import yuyu.common.workflow.workflowutility.dba4workflowutility.WorkFlowUtilityDao;
import yuyu.def.classification.C_ImagerenkeiKbn;
import yuyu.def.db.entity.DM_JimutetuzukiRireki;
import yuyu.def.db.entity.DM_JimutetuzukiTaskRireki;
import yuyu.def.db.entity.DT_SyoriKensuuHokanJimu;
import yuyu.def.db.entity.DT_SyoriKensuuHokanTask;
import yuyu.def.workflow.manager.WorkflowDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ワークフロー呼出ユーティリティクラスのメソッド {@link WorkFlowUtility#makeCountOfKakoJissekiTaskSummary(BizDate)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class WorkFlowUtilityTest40 {

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_【40_処理件数保管処理_過去実績サマリ分】";

    private final static String sheetName = "INデータ";

    private static HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {

            TestDataMaker testDataMaker = new TestDataMaker();

            testDataAndTblMap = testDataMaker.getInData(WorkFlowUtilityTest40.class, fileName, sheetName);

        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        WorkflowDomManager workflowDomManager = SWAKInjector.getInstance(WorkflowDomManager.class);

        workflowDomManager.delete(workflowDomManager.getAllJimutetuzuki());
        workflowDomManager.delete(workflowDomManager.getAllJimutetuzukiRireki());
        workflowDomManager.delete(workflowDomManager.getAllSyoriKensuuHokanJimu());
        workflowDomManager.delete(workflowDomManager.getAllSyoriKensuuHokanTask());
    }

    @BeforeClass
    public static void testInit(){
        IwfKouteiClientMock.caller = "Test";
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        IwfKouteiClientMock.caller = null;
        IwfKouteiClientMock.mode = null;
    }
    @Test
    @TestOrder(10)
    @Transactional
    public void testMakeCountOfKakoJissekiTaskSummary_A1() {
        MockObjectManager.initialize();
        IwfKouteiClientMock.mode = "30-06-01";
        MakeCountOfKakoJissekiTaskSummaryResultBean ret = WorkFlowUtility.makeCountOfKakoJissekiTaskSummary(
            BizDate.valueOf(20180108));

        exStringEquals(ret.getSyorikekkaStatus(), "9", "処理結果ステータス");
        exStringEquals(ret.getSyousaiMessageCd(), "IWF4021", "詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), "前日残件数取得（1回目）が失敗です。", "詳細メッセージ");
        exStringEquals(ret.getErrHasseiSyoriNm(), "TaskSummaryByActor", "エラー発生処理名");
    }


    @Test
    @TestOrder(20)
    @Transactional
    public void testMakeCountOfKakoJissekiTaskSummary_A2() {
        MockObjectManager.initialize();
        IwfKouteiClientMock.mode = "30-06-02";
        MakeCountOfKakoJissekiTaskSummaryResultBean ret = WorkFlowUtility.makeCountOfKakoJissekiTaskSummary(
            BizDate.valueOf(20180108));

        exStringEquals(ret.getSyorikekkaStatus(), "9", "処理結果ステータス");
        exStringEquals(ret.getSyousaiMessageCd(), "IWF4022", "詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), "前日残件数取得（2回目）が失敗です。", "詳細メッセージ");
        exStringEquals(ret.getErrHasseiSyoriNm(), "TaskSummaryByActor", "エラー発生処理名");
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testMakeCountOfKakoJissekiTaskSummary_A3() {
        MockObjectManager.initialize();
        IwfKouteiClientMock.mode = "30-06-03";
        MakeCountOfKakoJissekiTaskSummaryResultBean ret = WorkFlowUtility.makeCountOfKakoJissekiTaskSummary(
            BizDate.valueOf(20180108));

        exStringEquals(ret.getSyorikekkaStatus(), "9", "処理結果ステータス");
        exStringEquals(ret.getSyousaiMessageCd(), "IWF4023", "詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), "当日残件数取得（1回目）が失敗です。", "詳細メッセージ");
        exStringEquals(ret.getErrHasseiSyoriNm(), "TaskSummaryByActor", "エラー発生処理名");
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testMakeCountOfKakoJissekiTaskSummary_A4() {
        MockObjectManager.initialize();
        IwfKouteiClientMock.mode = "30-06-04";

        MakeCountOfKakoJissekiTaskSummaryResultBean ret = WorkFlowUtility.makeCountOfKakoJissekiTaskSummary(
            BizDate.valueOf(20180108));

        exStringEquals(ret.getSyorikekkaStatus(), "9", "処理結果ステータス");
        exStringEquals(ret.getSyousaiMessageCd(), "IWF4024", "詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), "当日残件数取得（2回目）が失敗です。", "詳細メッセージ");
        exStringEquals(ret.getErrHasseiSyoriNm(), "TaskSummaryByActor", "エラー発生処理名");
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testMakeCountOfKakoJissekiTaskSummary_A5() {
        MockObjectManager.initialize();
        IwfKouteiClientMock.mode = "30-06-05";

        MakeCountOfKakoJissekiTaskSummaryResultBean ret = WorkFlowUtility.makeCountOfKakoJissekiTaskSummary(
            BizDate.valueOf(20180108));

        exStringEquals(ret.getSyorikekkaStatus(), "9", "処理結果ステータス");
        exStringEquals(ret.getSyousaiMessageCd(), "IWF4025", "詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), "タスク別の当日完了件数取得が失敗です。", "詳細メッセージ");
        exStringEquals(ret.getErrHasseiSyoriNm(), "TaskSummaryByActor", "エラー発生処理名");

    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testMakeCountOfKakoJissekiTaskSummary_A6() {

        MockObjectManager.initialize();
        IwfKouteiClientMock.mode = "30-06-06";

        MakeCountOfKakoJissekiTaskSummaryResultBean ret = WorkFlowUtility.makeCountOfKakoJissekiTaskSummary(
            BizDate.valueOf(20180108));

        exStringEquals(ret.getSyorikekkaStatus(), "9", "処理結果ステータス");
        exStringEquals(ret.getSyousaiMessageCd(), "IWF4026", "詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), "事務手続別の当日完了件数取得が失敗です。", "詳細メッセージ");
        exStringEquals(ret.getErrHasseiSyoriNm(), "ProcessSummary", "エラー発生処理名");
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testMakeCountOfKakoJissekiTaskSummary_A7() {
        MockObjectManager.initialize();
        IwfKouteiClientMock.mode = "30-06-07";

        MakeCountOfKakoJissekiTaskSummaryResultBean ret = WorkFlowUtility.makeCountOfKakoJissekiTaskSummary(
            BizDate.valueOf(20180108));

        exStringEquals(ret.getSyorikekkaStatus(), "0", "処理結果ステータス");
        exStringEquals(ret.getSyousaiMessageCd(), "IWF0000", "詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), "前日残件数、当日残件数、当日完了件数を全て０件取得する。", "詳細メッセージ");
        assertNull(ret.getErrHasseiSyoriNm());
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testMakeCountOfKakoJissekiTaskSummary_A8() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }

        MockObjectManager.initialize();
        IwfKouteiClientMock.mode = "30-06-08";

        MakeCountOfKakoJissekiTaskSummaryResultBean ret = WorkFlowUtility.makeCountOfKakoJissekiTaskSummary(
            BizDate.valueOf(20180109));

        exStringEquals(ret.getSyorikekkaStatus(), "0", "処理結果ステータス");
        exStringEquals(ret.getSyousaiMessageCd(), "IWF0001", "詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), "正常終了しました。", "詳細メッセージ");
        assertNull(ret.getErrHasseiSyoriNm());

        WorkFlowUtilityDao workFlowUtilityDao = SWAKInjector.getInstance(WorkFlowUtilityDao.class);
        List<DT_SyoriKensuuHokanJimu> syoriKensuuHokanJimuList =
            workFlowUtilityDao.getSyoriKensuuHokanJimuByKensuHokanbiJimutetuzukiAccountIds(
                BizDate.valueOf(20180109), new String[]{"f801223301"}, null);

        exNumericEquals(syoriKensuuHokanJimuList.size(), 1, "件数");
        exDateEquals(syoriKensuuHokanJimuList.get(0).getKensuuHokanYmd(), BizDate.valueOf(20180109), "件数保管日");
        exStringEquals(syoriKensuuHokanJimuList.get(0).getJimutetuzukicd(), "f801223301", "事務手続コード");
        exStringEquals(syoriKensuuHokanJimuList.get(0).getAccountId(), "kyouyuu", "アカウントＩＤ");
        exBizCalcbleEquals(syoriKensuuHokanJimuList.get(0).getZenjituzanKensuu(), BizNumber.valueOf(201), "前日残件数");
        exBizCalcbleEquals(syoriKensuuHokanJimuList.get(0).getZanKensuu(), BizNumber.valueOf(205), "残件数");
        exBizCalcbleEquals(syoriKensuuHokanJimuList.get(0).getKanryoKensuu(), BizNumber.valueOf(1), "完了件数");
        exStringEquals(syoriKensuuHokanJimuList.get(0).getTaskKanryouKensuuarihyouji(), "1", "タスク完了件数有表示");

        List<DT_SyoriKensuuHokanTask> syoriKensuuHokanTaskList =
            workFlowUtilityDao.getSyoriKensuuHokanTaskByKensuHokanbiJimutetuzukiTaskIdAccountIds(
                BizDate.valueOf(20180109), "f801223301", new String[]{"w80177889901"}, null);

        exNumericEquals(syoriKensuuHokanTaskList.size(), 1, "件数");
        exDateEquals(syoriKensuuHokanTaskList.get(0).getKensuuHokanYmd(), BizDate.valueOf(20180109), "件数保管日");
        exStringEquals(syoriKensuuHokanTaskList.get(0).getJimutetuzukicd(), "f801223301", "事務手続コード");
        exStringEquals(syoriKensuuHokanTaskList.get(0).getTskid(), "w80177889901", "タスクＩＤ");
        exStringEquals(syoriKensuuHokanTaskList.get(0).getAccountId(), "kyouyuu", "アカウントＩＤ");
        exBizCalcbleEquals(syoriKensuuHokanTaskList.get(0).getZenjituzanKensuu(), BizNumber.valueOf(201), "前日残件数");
        exBizCalcbleEquals(syoriKensuuHokanTaskList.get(0).getZanKensuu(), BizNumber.valueOf(205), "残件数");
        exBizCalcbleEquals(syoriKensuuHokanTaskList.get(0).getKanryoKensuu(), BizNumber.valueOf(104), "完了件数");

        List<DM_JimutetuzukiRireki> jimutetuzukiRirekiList = workFlowUtilityDao.getJimutetuzukiRirekisBySyoriYmd(
            BizDate.valueOf(20180109));

        exNumericEquals(jimutetuzukiRirekiList.size(), 1, "件数");
        exDateEquals(jimutetuzukiRirekiList.get(0).getKensuuHokanYmd(), BizDate.valueOf(20180109), "件数保管日");
        exStringEquals(jimutetuzukiRirekiList.get(0).getJimutetuzukicd(), "skinputkokuti", "事務手続コード");
        exStringEquals(jimutetuzukiRirekiList.get(0).getSubSystemId(), "sinkeiyaku", "サブシステムＩＤ");
        exStringEquals(jimutetuzukiRirekiList.get(0).getJimutetuzukinm(), "告知書入力", "事務手続名");
        exClassificationEquals(jimutetuzukiRirekiList.get(0).getImagerenkeikbn(), C_ImagerenkeiKbn.YUYUSEIHO, "イメージ連携区分");
        exNumericEquals(jimutetuzukiRirekiList.get(0).getHyoujijyun(), 2, "表示順");
        exStringEquals(jimutetuzukiRirekiList.get(0).getSyukouteijimutetuzukicd(), "skmaindairiten", "主工程事務手続コード");

        List<DM_JimutetuzukiTaskRireki> jimutetuzukiTaskRirekiList = jimutetuzukiRirekiList.get(0).getJimutetuzukiTaskRirekis();
        exNumericEquals(jimutetuzukiTaskRirekiList.size(), 0, "件数");
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testMakeCountOfKakoJissekiTaskSummary_A9() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataMaker.insDataByDataId("データ002", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }

        MockObjectManager.initialize();
        IwfKouteiClientMock.mode = "30-06-09";

        WorkFlowUtilityDao workFlowUtilityDao = SWAKInjector.getInstance(WorkFlowUtilityDao.class);
        List<DT_SyoriKensuuHokanJimu> syoriKensuuHokanJimuList =
            workFlowUtilityDao.getSyoriKensuuHokanJimuByKensuHokanbiJimutetuzukiAccountIds(
                BizDate.valueOf(20180110), new String[]{"901223301"}, null);
        exNumericEquals(syoriKensuuHokanJimuList.size(), 1, "件数");

        List<DT_SyoriKensuuHokanTask> syoriKensuuHokanTaskList =
            workFlowUtilityDao.getSyoriKensuuHokanTaskByKensuHokanbiJimutetuzukiTaskIdAccountIds(
                BizDate.valueOf(20180110), "901223301", new String[]{"w90177889901"}, null);
        exNumericEquals(syoriKensuuHokanTaskList.size(), 1, "件数");

        List<DM_JimutetuzukiRireki> jimutetuzukiRirekiList = workFlowUtilityDao.getJimutetuzukiRirekisBySyoriYmd(
            BizDate.valueOf(20180110));
        exNumericEquals(jimutetuzukiRirekiList.size(), 1, "件数");

        List<DM_JimutetuzukiTaskRireki> jimutetuzukiTaskRirekiList = jimutetuzukiRirekiList.get(0).getJimutetuzukiTaskRirekis();
        exNumericEquals(jimutetuzukiTaskRirekiList.size(), 1, "件数");

        MakeCountOfKakoJissekiTaskSummaryResultBean ret = WorkFlowUtility.makeCountOfKakoJissekiTaskSummary(
            BizDate.valueOf(20180110));

        exStringEquals(ret.getSyorikekkaStatus(), "0", "処理結果ステータス");
        exStringEquals(ret.getSyousaiMessageCd(), "IWF0001", "詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), "正常終了しました。", "詳細メッセージ");
        assertNull(ret.getErrHasseiSyoriNm());

        syoriKensuuHokanJimuList =
            workFlowUtilityDao.getSyoriKensuuHokanJimuByKensuHokanbiJimutetuzukiAccountIds(
                BizDate.valueOf(20180110), new String[]{"f901223301"}, null);

        exNumericEquals(syoriKensuuHokanJimuList.size(), 6, "件数");
        exDateEquals(syoriKensuuHokanJimuList.get(0).getKensuuHokanYmd(), BizDate.valueOf(20180110), "件数保管日");
        exStringEquals(syoriKensuuHokanJimuList.get(0).getJimutetuzukicd(), "f901223301", "事務手続コード");
        exStringEquals(syoriKensuuHokanJimuList.get(0).getAccountId(), "accountId901", "アカウントＩＤ");
        exBizCalcbleEquals(syoriKensuuHokanJimuList.get(0).getZenjituzanKensuu(), BizNumber.valueOf(100), "前日残件数");
        exBizCalcbleEquals(syoriKensuuHokanJimuList.get(0).getZanKensuu(), BizNumber.valueOf(0), "残件数");
        exBizCalcbleEquals(syoriKensuuHokanJimuList.get(0).getKanryoKensuu(), BizNumber.valueOf(0), "完了件数");
        exStringEquals(syoriKensuuHokanJimuList.get(0).getTaskKanryouKensuuarihyouji(), "0", "タスク完了件数有表示");

        exDateEquals(syoriKensuuHokanJimuList.get(1).getKensuuHokanYmd(), BizDate.valueOf(20180110), "件数保管日");
        exStringEquals(syoriKensuuHokanJimuList.get(1).getJimutetuzukicd(), "f901223301", "事務手続コード");
        exStringEquals(syoriKensuuHokanJimuList.get(1).getAccountId(), "accountId902", "アカウントＩＤ");
        exBizCalcbleEquals(syoriKensuuHokanJimuList.get(1).getZenjituzanKensuu(), BizNumber.valueOf(101), "前日残件数");
        exBizCalcbleEquals(syoriKensuuHokanJimuList.get(1).getZanKensuu(), BizNumber.valueOf(0), "残件数");
        exBizCalcbleEquals(syoriKensuuHokanJimuList.get(1).getKanryoKensuu(), BizNumber.valueOf(0), "完了件数");
        exStringEquals(syoriKensuuHokanJimuList.get(1).getTaskKanryouKensuuarihyouji(), "0", "タスク完了件数有表示");

        exDateEquals(syoriKensuuHokanJimuList.get(2).getKensuuHokanYmd(), BizDate.valueOf(20180110), "件数保管日");
        exStringEquals(syoriKensuuHokanJimuList.get(2).getJimutetuzukicd(), "f901223301", "事務手続コード");
        exStringEquals(syoriKensuuHokanJimuList.get(2).getAccountId(), "accountId903", "アカウントＩＤ");
        exBizCalcbleEquals(syoriKensuuHokanJimuList.get(2).getZenjituzanKensuu(), BizNumber.valueOf(0), "前日残件数");
        exBizCalcbleEquals(syoriKensuuHokanJimuList.get(2).getZanKensuu(), BizNumber.valueOf(102), "残件数");
        exBizCalcbleEquals(syoriKensuuHokanJimuList.get(2).getKanryoKensuu(), BizNumber.valueOf(0), "完了件数");
        exStringEquals(syoriKensuuHokanJimuList.get(2).getTaskKanryouKensuuarihyouji(), "0", "タスク完了件数有表示");

        exDateEquals(syoriKensuuHokanJimuList.get(3).getKensuuHokanYmd(), BizDate.valueOf(20180110), "件数保管日");
        exStringEquals(syoriKensuuHokanJimuList.get(3).getJimutetuzukicd(), "f901223301", "事務手続コード");
        exStringEquals(syoriKensuuHokanJimuList.get(3).getAccountId(), "accountId904", "アカウントＩＤ");
        exBizCalcbleEquals(syoriKensuuHokanJimuList.get(3).getZenjituzanKensuu(), BizNumber.valueOf(0), "前日残件数");
        exBizCalcbleEquals(syoriKensuuHokanJimuList.get(3).getZanKensuu(), BizNumber.valueOf(103), "残件数");
        exBizCalcbleEquals(syoriKensuuHokanJimuList.get(3).getKanryoKensuu(), BizNumber.valueOf(0), "完了件数");
        exStringEquals(syoriKensuuHokanJimuList.get(3).getTaskKanryouKensuuarihyouji(), "0", "タスク完了件数有表示");

        exDateEquals(syoriKensuuHokanJimuList.get(4).getKensuuHokanYmd(), BizDate.valueOf(20180110), "件数保管日");
        exStringEquals(syoriKensuuHokanJimuList.get(4).getJimutetuzukicd(), "f901223301", "事務手続コード");
        exStringEquals(syoriKensuuHokanJimuList.get(4).getAccountId(), "accountId905", "アカウントＩＤ");
        exBizCalcbleEquals(syoriKensuuHokanJimuList.get(4).getZenjituzanKensuu(), BizNumber.valueOf(0), "前日残件数");
        exBizCalcbleEquals(syoriKensuuHokanJimuList.get(4).getZanKensuu(), BizNumber.valueOf(0), "残件数");
        exBizCalcbleEquals(syoriKensuuHokanJimuList.get(4).getKanryoKensuu(), BizNumber.valueOf(0), "完了件数");
        exStringEquals(syoriKensuuHokanJimuList.get(4).getTaskKanryouKensuuarihyouji(), "1", "タスク完了件数有表示");

        exDateEquals(syoriKensuuHokanJimuList.get(5).getKensuuHokanYmd(), BizDate.valueOf(20180110), "件数保管日");
        exStringEquals(syoriKensuuHokanJimuList.get(5).getJimutetuzukicd(), "f901223301", "事務手続コード");
        exStringEquals(syoriKensuuHokanJimuList.get(5).getAccountId(), "accountId906", "アカウントＩＤ");
        exBizCalcbleEquals(syoriKensuuHokanJimuList.get(5).getZenjituzanKensuu(), BizNumber.valueOf(0), "前日残件数");
        exBizCalcbleEquals(syoriKensuuHokanJimuList.get(5).getZanKensuu(), BizNumber.valueOf(0), "残件数");
        exBizCalcbleEquals(syoriKensuuHokanJimuList.get(5).getKanryoKensuu(), BizNumber.valueOf(1), "完了件数");
        exStringEquals(syoriKensuuHokanJimuList.get(5).getTaskKanryouKensuuarihyouji(), "1", "タスク完了件数有表示");

        syoriKensuuHokanTaskList =
            workFlowUtilityDao.getSyoriKensuuHokanTaskByKensuHokanbiJimutetuzukiTaskIdAccountIds(
                BizDate.valueOf(20180110), "f901223301", new String[]{"w90177889901"}, null);

        exNumericEquals(syoriKensuuHokanTaskList.size(), 5, "件数");
        exDateEquals(syoriKensuuHokanTaskList.get(0).getKensuuHokanYmd(), BizDate.valueOf(20180110), "件数保管日");
        exStringEquals(syoriKensuuHokanTaskList.get(0).getJimutetuzukicd(), "f901223301", "事務手続コード");
        exStringEquals(syoriKensuuHokanTaskList.get(0).getTskid(), "w90177889901", "タスクＩＤ");
        exStringEquals(syoriKensuuHokanTaskList.get(0).getAccountId(), "accountId901", "アカウントＩＤ");
        exBizCalcbleEquals(syoriKensuuHokanTaskList.get(0).getZenjituzanKensuu(), BizNumber.valueOf(100), "前日残件数");
        exBizCalcbleEquals(syoriKensuuHokanTaskList.get(0).getZanKensuu(), BizNumber.valueOf(0), "残件数");
        exBizCalcbleEquals(syoriKensuuHokanTaskList.get(0).getKanryoKensuu(), BizNumber.valueOf(0), "完了件数");

        exDateEquals(syoriKensuuHokanTaskList.get(1).getKensuuHokanYmd(), BizDate.valueOf(20180110), "件数保管日");
        exStringEquals(syoriKensuuHokanTaskList.get(1).getJimutetuzukicd(), "f901223301", "事務手続コード");
        exStringEquals(syoriKensuuHokanTaskList.get(1).getTskid(), "w90177889901", "タスクＩＤ");
        exStringEquals(syoriKensuuHokanTaskList.get(1).getAccountId(), "accountId902", "アカウントＩＤ");
        exBizCalcbleEquals(syoriKensuuHokanTaskList.get(1).getZenjituzanKensuu(), BizNumber.valueOf(101), "前日残件数");
        exBizCalcbleEquals(syoriKensuuHokanTaskList.get(1).getZanKensuu(), BizNumber.valueOf(0), "残件数");
        exBizCalcbleEquals(syoriKensuuHokanTaskList.get(1).getKanryoKensuu(), BizNumber.valueOf(0), "完了件数");

        exDateEquals(syoriKensuuHokanTaskList.get(2).getKensuuHokanYmd(), BizDate.valueOf(20180110), "件数保管日");
        exStringEquals(syoriKensuuHokanTaskList.get(2).getJimutetuzukicd(), "f901223301", "事務手続コード");
        exStringEquals(syoriKensuuHokanTaskList.get(2).getTskid(), "w90177889901", "タスクＩＤ");
        exStringEquals(syoriKensuuHokanTaskList.get(2).getAccountId(), "accountId903", "アカウントＩＤ");
        exBizCalcbleEquals(syoriKensuuHokanTaskList.get(2).getZenjituzanKensuu(), BizNumber.valueOf(0), "前日残件数");
        exBizCalcbleEquals(syoriKensuuHokanTaskList.get(2).getZanKensuu(), BizNumber.valueOf(102), "残件数");
        exBizCalcbleEquals(syoriKensuuHokanTaskList.get(2).getKanryoKensuu(), BizNumber.valueOf(0), "完了件数");

        exDateEquals(syoriKensuuHokanTaskList.get(3).getKensuuHokanYmd(), BizDate.valueOf(20180110), "件数保管日");
        exStringEquals(syoriKensuuHokanTaskList.get(3).getJimutetuzukicd(), "f901223301", "事務手続コード");
        exStringEquals(syoriKensuuHokanTaskList.get(3).getTskid(), "w90177889901", "タスクＩＤ");
        exStringEquals(syoriKensuuHokanTaskList.get(3).getAccountId(), "accountId904", "アカウントＩＤ");
        exBizCalcbleEquals(syoriKensuuHokanTaskList.get(3).getZenjituzanKensuu(), BizNumber.valueOf(0), "前日残件数");
        exBizCalcbleEquals(syoriKensuuHokanTaskList.get(3).getZanKensuu(), BizNumber.valueOf(103), "残件数");
        exBizCalcbleEquals(syoriKensuuHokanTaskList.get(3).getKanryoKensuu(), BizNumber.valueOf(0), "完了件数");

        exDateEquals(syoriKensuuHokanTaskList.get(4).getKensuuHokanYmd(), BizDate.valueOf(20180110), "件数保管日");
        exStringEquals(syoriKensuuHokanTaskList.get(4).getJimutetuzukicd(), "f901223301", "事務手続コード");
        exStringEquals(syoriKensuuHokanTaskList.get(4).getTskid(), "w90177889901", "タスクＩＤ");
        exStringEquals(syoriKensuuHokanTaskList.get(4).getAccountId(), "accountId905", "アカウントＩＤ");
        exBizCalcbleEquals(syoriKensuuHokanTaskList.get(4).getZenjituzanKensuu(), BizNumber.valueOf(0), "前日残件数");
        exBizCalcbleEquals(syoriKensuuHokanTaskList.get(4).getZanKensuu(), BizNumber.valueOf(0), "残件数");
        exBizCalcbleEquals(syoriKensuuHokanTaskList.get(4).getKanryoKensuu(), BizNumber.valueOf(104), "完了件数");

        jimutetuzukiRirekiList = workFlowUtilityDao.getJimutetuzukiRirekisBySyoriYmd(BizDate.valueOf(20180110));

        exNumericEquals(jimutetuzukiRirekiList.size(), 1, "件数");
        exDateEquals(jimutetuzukiRirekiList.get(0).getKensuuHokanYmd(), BizDate.valueOf(20180110), "件数保管日");
        exStringEquals(jimutetuzukiRirekiList.get(0).getJimutetuzukicd(), "sktenken", "事務手続コード");
        exStringEquals(jimutetuzukiRirekiList.get(0).getSubSystemId(), "sinkeiyaku", "サブシステムＩＤ");
        exStringEquals(jimutetuzukiRirekiList.get(0).getJimutetuzukinm(), "申込点検", "事務手続名");
        exClassificationEquals(jimutetuzukiRirekiList.get(0).getImagerenkeikbn(), C_ImagerenkeiKbn.YUYUSEIHO, "イメージ連携区分");
        exNumericEquals(jimutetuzukiRirekiList.get(0).getHyoujijyun(), 3, "表示順");
        exStringEquals(jimutetuzukiRirekiList.get(0).getSyukouteijimutetuzukicd(), "skmaindairiten", "主工程事務手続コード");

        jimutetuzukiTaskRirekiList = jimutetuzukiRirekiList.get(0).getJimutetuzukiTaskRirekis();

        exNumericEquals(jimutetuzukiTaskRirekiList.size(), 1, "件数");
        exDateEquals(jimutetuzukiTaskRirekiList.get(0).getKensuuHokanYmd(), BizDate.valueOf(20180110), "件数保管日");
        exStringEquals(jimutetuzukiTaskRirekiList.get(0).getSubSystemId(), "sinkeiyaku", "サブシステムＩＤ");
        exStringEquals(jimutetuzukiTaskRirekiList.get(0).getJimutetuzukicd(), "sktenken", "事務手続コード");
        exStringEquals(jimutetuzukiTaskRirekiList.get(0).getWorkflowTskId(), "mostenken_1ji", "ワークフロータスクID");
        exStringEquals(jimutetuzukiTaskRirekiList.get(0).getWorkflowTskNm(), "申込点検（１次）", "ワークフロータスク名");
        exNumericEquals(jimutetuzukiTaskRirekiList.get(0).getHyoujijyun(), 2, "表示順");
        exNumericEquals(jimutetuzukiTaskRirekiList.get(0).getWorklistHyoujiFlag(), 1, "工程ワークリスト表示フラグ");

    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testMakeCountOfKakoJissekiTaskSummary_A10() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataMaker.insDataByDataId("データ003", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }

        MockObjectManager.initialize();
        IwfKouteiClientMock.mode = "30-06-10";

        WorkFlowUtilityDao workFlowUtilityDao = SWAKInjector.getInstance(WorkFlowUtilityDao.class);
        List<DM_JimutetuzukiRireki> jimutetuzukiRirekiList = workFlowUtilityDao.getJimutetuzukiRirekisBySyoriYmd(
            BizDate.valueOf(20180111));
        exNumericEquals(jimutetuzukiRirekiList.size(), 1, "件数");

        List<DM_JimutetuzukiTaskRireki> jimutetuzukiTaskRirekiList = jimutetuzukiRirekiList.get(0).getJimutetuzukiTaskRirekis();
        exNumericEquals(jimutetuzukiTaskRirekiList.size(), 3, "件数");

        MakeCountOfKakoJissekiTaskSummaryResultBean ret = WorkFlowUtility.makeCountOfKakoJissekiTaskSummary(
            BizDate.valueOf(20180111));

        exStringEquals(ret.getSyorikekkaStatus(), "0", "処理結果ステータス");
        exStringEquals(ret.getSyousaiMessageCd(), "IWF0001", "詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), "正常終了しました。", "詳細メッセージ");
        assertNull(ret.getErrHasseiSyoriNm());

        WorkflowDomManager workflowDomManager = SWAKInjector.getInstance(WorkflowDomManager.class);
        List<DT_SyoriKensuuHokanJimu> syoriKensuuHokanJimuList = workflowDomManager.getAllSyoriKensuuHokanJimu();

        exNumericEquals(syoriKensuuHokanJimuList.size(), 8, "件数");
        exDateEquals(syoriKensuuHokanJimuList.get(0).getKensuuHokanYmd(), BizDate.valueOf(20180111), "件数保管日");
        exStringEquals(syoriKensuuHokanJimuList.get(0).getJimutetuzukicd(), "f101223301", "事務手続コード");
        exStringEquals(syoriKensuuHokanJimuList.get(0).getAccountId(), "kyouyuu", "アカウントＩＤ");
        exBizCalcbleEquals(syoriKensuuHokanJimuList.get(0).getZenjituzanKensuu(), BizNumber.valueOf(405), "前日残件数");
        exBizCalcbleEquals(syoriKensuuHokanJimuList.get(0).getZanKensuu(), BizNumber.valueOf(0), "残件数");
        exBizCalcbleEquals(syoriKensuuHokanJimuList.get(0).getKanryoKensuu(), BizNumber.valueOf(0), "完了件数");
        exStringEquals(syoriKensuuHokanJimuList.get(0).getTaskKanryouKensuuarihyouji(), "0", "タスク完了件数有表示");

        exDateEquals(syoriKensuuHokanJimuList.get(1).getKensuuHokanYmd(), BizDate.valueOf(20180111), "件数保管日");
        exStringEquals(syoriKensuuHokanJimuList.get(1).getJimutetuzukicd(), "f101223301000000001", "事務手続コード");
        exStringEquals(syoriKensuuHokanJimuList.get(1).getAccountId(), "accountId101000000000000000001", "アカウントＩＤ");
        exBizCalcbleEquals(syoriKensuuHokanJimuList.get(1).getZenjituzanKensuu(), BizNumber.valueOf(100002), "前日残件数");
        exBizCalcbleEquals(syoriKensuuHokanJimuList.get(1).getZanKensuu(), BizNumber.valueOf(300001), "残件数");
        exBizCalcbleEquals(syoriKensuuHokanJimuList.get(1).getKanryoKensuu(), BizNumber.valueOf(100000), "完了件数");
        exStringEquals(syoriKensuuHokanJimuList.get(1).getTaskKanryouKensuuarihyouji(), "1", "タスク完了件数有表示");

        exDateEquals(syoriKensuuHokanJimuList.get(2).getKensuuHokanYmd(), BizDate.valueOf(20180111), "件数保管日");
        exStringEquals(syoriKensuuHokanJimuList.get(2).getJimutetuzukicd(), "f201223302", "事務手続コード");
        exStringEquals(syoriKensuuHokanJimuList.get(2).getAccountId(), "accountId202", "アカウントＩＤ");
        exBizCalcbleEquals(syoriKensuuHokanJimuList.get(2).getZenjituzanKensuu(), BizNumber.valueOf(202), "前日残件数");
        exBizCalcbleEquals(syoriKensuuHokanJimuList.get(2).getZanKensuu(), BizNumber.valueOf(0), "残件数");
        exBizCalcbleEquals(syoriKensuuHokanJimuList.get(2).getKanryoKensuu(), BizNumber.valueOf(0), "完了件数");
        exStringEquals(syoriKensuuHokanJimuList.get(2).getTaskKanryouKensuuarihyouji(), "0", "タスク完了件数有表示");

        exDateEquals(syoriKensuuHokanJimuList.get(3).getKensuuHokanYmd(), BizDate.valueOf(20180111), "件数保管日");
        exStringEquals(syoriKensuuHokanJimuList.get(3).getJimutetuzukicd(), "f201223303", "事務手続コード");
        exStringEquals(syoriKensuuHokanJimuList.get(3).getAccountId(), "kyouyuu", "アカウントＩＤ");
        exBizCalcbleEquals(syoriKensuuHokanJimuList.get(3).getZenjituzanKensuu(), BizNumber.valueOf(203), "前日残件数");
        exBizCalcbleEquals(syoriKensuuHokanJimuList.get(3).getZanKensuu(), BizNumber.valueOf(302), "残件数");
        exBizCalcbleEquals(syoriKensuuHokanJimuList.get(3).getKanryoKensuu(), BizNumber.valueOf(0), "完了件数");
        exStringEquals(syoriKensuuHokanJimuList.get(3).getTaskKanryouKensuuarihyouji(), "0", "タスク完了件数有表示");

        exDateEquals(syoriKensuuHokanJimuList.get(4).getKensuuHokanYmd(), BizDate.valueOf(20180111), "件数保管日");
        exStringEquals(syoriKensuuHokanJimuList.get(4).getJimutetuzukicd(), "f301223303", "事務手続コード");
        exStringEquals(syoriKensuuHokanJimuList.get(4).getAccountId(), "accountId303", "アカウントＩＤ");
        exBizCalcbleEquals(syoriKensuuHokanJimuList.get(4).getZenjituzanKensuu(), BizNumber.valueOf(0), "前日残件数");
        exBizCalcbleEquals(syoriKensuuHokanJimuList.get(4).getZanKensuu(), BizNumber.valueOf(303), "残件数");
        exBizCalcbleEquals(syoriKensuuHokanJimuList.get(4).getKanryoKensuu(), BizNumber.valueOf(0), "完了件数");
        exStringEquals(syoriKensuuHokanJimuList.get(4).getTaskKanryouKensuuarihyouji(), "0", "タスク完了件数有表示");

        exDateEquals(syoriKensuuHokanJimuList.get(5).getKensuuHokanYmd(), BizDate.valueOf(20180111), "件数保管日");
        exStringEquals(syoriKensuuHokanJimuList.get(5).getJimutetuzukicd(), "f401223301", "事務手続コード");
        exStringEquals(syoriKensuuHokanJimuList.get(5).getAccountId(), "kyouyuu", "アカウントＩＤ");
        exBizCalcbleEquals(syoriKensuuHokanJimuList.get(5).getZenjituzanKensuu(), BizNumber.valueOf(0), "前日残件数");
        exBizCalcbleEquals(syoriKensuuHokanJimuList.get(5).getZanKensuu(), BizNumber.valueOf(401), "残件数");
        exBizCalcbleEquals(syoriKensuuHokanJimuList.get(5).getKanryoKensuu(), BizNumber.valueOf(0), "完了件数");
        exStringEquals(syoriKensuuHokanJimuList.get(5).getTaskKanryouKensuuarihyouji(), "1", "タスク完了件数有表示");

        exDateEquals(syoriKensuuHokanJimuList.get(6).getKensuuHokanYmd(), BizDate.valueOf(20180111), "件数保管日");
        exStringEquals(syoriKensuuHokanJimuList.get(6).getJimutetuzukicd(), "f401223302", "事務手続コード");
        exStringEquals(syoriKensuuHokanJimuList.get(6).getAccountId(), "accountId402", "アカウントＩＤ");
        exBizCalcbleEquals(syoriKensuuHokanJimuList.get(6).getZenjituzanKensuu(), BizNumber.valueOf(0), "前日残件数");
        exBizCalcbleEquals(syoriKensuuHokanJimuList.get(6).getZanKensuu(), BizNumber.valueOf(402), "残件数");
        exBizCalcbleEquals(syoriKensuuHokanJimuList.get(6).getKanryoKensuu(), BizNumber.valueOf(0), "完了件数");
        exStringEquals(syoriKensuuHokanJimuList.get(6).getTaskKanryouKensuuarihyouji(), "0", "タスク完了件数有表示");

        exDateEquals(syoriKensuuHokanJimuList.get(7).getKensuuHokanYmd(), BizDate.valueOf(20180111), "件数保管日");
        exStringEquals(syoriKensuuHokanJimuList.get(7).getJimutetuzukicd(), "f401223303", "事務手続コード");
        exStringEquals(syoriKensuuHokanJimuList.get(7).getAccountId(), "kyouyuu", "アカウントＩＤ");
        exBizCalcbleEquals(syoriKensuuHokanJimuList.get(7).getZenjituzanKensuu(), BizNumber.valueOf(0), "前日残件数");
        exBizCalcbleEquals(syoriKensuuHokanJimuList.get(7).getZanKensuu(), BizNumber.valueOf(403), "残件数");
        exBizCalcbleEquals(syoriKensuuHokanJimuList.get(7).getKanryoKensuu(), BizNumber.valueOf(0), "完了件数");
        exStringEquals(syoriKensuuHokanJimuList.get(7).getTaskKanryouKensuuarihyouji(), "1", "タスク完了件数有表示");

        List<DT_SyoriKensuuHokanTask> syoriKensuuHokanTaskList = workflowDomManager.getAllSyoriKensuuHokanTask();

        exNumericEquals(syoriKensuuHokanTaskList.size(), 9, "件数");
        exDateEquals(syoriKensuuHokanTaskList.get(0).getKensuuHokanYmd(), BizDate.valueOf(20180111), "件数保管日");
        exStringEquals(syoriKensuuHokanTaskList.get(0).getJimutetuzukicd(), "f101223301", "事務手続コード");
        exStringEquals(syoriKensuuHokanTaskList.get(0).getTskid(), "w10177889901", "タスクＩＤ");
        exStringEquals(syoriKensuuHokanTaskList.get(0).getAccountId(), "kyouyuu", "アカウントＩＤ");
        exBizCalcbleEquals(syoriKensuuHokanTaskList.get(0).getZenjituzanKensuu(), BizNumber.valueOf(103), "前日残件数");
        exBizCalcbleEquals(syoriKensuuHokanTaskList.get(0).getZanKensuu(), BizNumber.valueOf(0), "残件数");
        exBizCalcbleEquals(syoriKensuuHokanTaskList.get(0).getKanryoKensuu(), BizNumber.valueOf(0), "完了件数");

        exDateEquals(syoriKensuuHokanTaskList.get(1).getKensuuHokanYmd(), BizDate.valueOf(20180111), "件数保管日");
        exStringEquals(syoriKensuuHokanTaskList.get(1).getJimutetuzukicd(), "f101223301", "事務手続コード");
        exStringEquals(syoriKensuuHokanTaskList.get(1).getTskid(), "w20177889901", "タスクＩＤ");
        exStringEquals(syoriKensuuHokanTaskList.get(1).getAccountId(), "kyouyuu", "アカウントＩＤ");
        exBizCalcbleEquals(syoriKensuuHokanTaskList.get(1).getZenjituzanKensuu(), BizNumber.valueOf(201), "前日残件数");
        exBizCalcbleEquals(syoriKensuuHokanTaskList.get(1).getZanKensuu(), BizNumber.valueOf(0), "残件数");
        exBizCalcbleEquals(syoriKensuuHokanTaskList.get(1).getKanryoKensuu(), BizNumber.valueOf(0), "完了件数");

        exDateEquals(syoriKensuuHokanTaskList.get(2).getKensuuHokanYmd(), BizDate.valueOf(20180111), "件数保管日");
        exStringEquals(syoriKensuuHokanTaskList.get(2).getJimutetuzukicd(), "f101223301000000001", "事務手続コード");
        exStringEquals(syoriKensuuHokanTaskList.get(2).getTskid(), "w1017788990134567890111111111122222222223333333333", "タスクＩＤ");
        exStringEquals(syoriKensuuHokanTaskList.get(2).getAccountId(), "accountId101000000000000000001", "アカウントＩＤ");
        exBizCalcbleEquals(syoriKensuuHokanTaskList.get(2).getZenjituzanKensuu(), BizNumber.valueOf(100002), "前日残件数");
        exBizCalcbleEquals(syoriKensuuHokanTaskList.get(2).getZanKensuu(), BizNumber.valueOf(300001), "残件数");
        exBizCalcbleEquals(syoriKensuuHokanTaskList.get(2).getKanryoKensuu(), BizNumber.valueOf(500003), "完了件数");

        exDateEquals(syoriKensuuHokanTaskList.get(3).getKensuuHokanYmd(), BizDate.valueOf(20180111), "件数保管日");
        exStringEquals(syoriKensuuHokanTaskList.get(3).getJimutetuzukicd(), "f201223302", "事務手続コード");
        exStringEquals(syoriKensuuHokanTaskList.get(3).getTskid(), "w20177889902", "タスクＩＤ");
        exStringEquals(syoriKensuuHokanTaskList.get(3).getAccountId(), "accountId202", "アカウントＩＤ");
        exBizCalcbleEquals(syoriKensuuHokanTaskList.get(3).getZenjituzanKensuu(), BizNumber.valueOf(202), "前日残件数");
        exBizCalcbleEquals(syoriKensuuHokanTaskList.get(3).getZanKensuu(), BizNumber.valueOf(0), "残件数");
        exBizCalcbleEquals(syoriKensuuHokanTaskList.get(3).getKanryoKensuu(), BizNumber.valueOf(0), "完了件数");

        exDateEquals(syoriKensuuHokanTaskList.get(4).getKensuuHokanYmd(), BizDate.valueOf(20180111), "件数保管日");
        exStringEquals(syoriKensuuHokanTaskList.get(4).getJimutetuzukicd(), "f201223303", "事務手続コード");
        exStringEquals(syoriKensuuHokanTaskList.get(4).getTskid(), "w20177889903", "タスクＩＤ");
        exStringEquals(syoriKensuuHokanTaskList.get(4).getAccountId(), "kyouyuu", "アカウントＩＤ");
        exBizCalcbleEquals(syoriKensuuHokanTaskList.get(4).getZenjituzanKensuu(), BizNumber.valueOf(203), "前日残件数");
        exBizCalcbleEquals(syoriKensuuHokanTaskList.get(4).getZanKensuu(), BizNumber.valueOf(302), "残件数");
        exBizCalcbleEquals(syoriKensuuHokanTaskList.get(4).getKanryoKensuu(), BizNumber.valueOf(0), "完了件数");

        exDateEquals(syoriKensuuHokanTaskList.get(5).getKensuuHokanYmd(), BizDate.valueOf(20180111), "件数保管日");
        exStringEquals(syoriKensuuHokanTaskList.get(5).getJimutetuzukicd(), "f301223303", "事務手続コード");
        exStringEquals(syoriKensuuHokanTaskList.get(5).getTskid(), "w30177889903", "タスクＩＤ");
        exStringEquals(syoriKensuuHokanTaskList.get(5).getAccountId(), "accountId303", "アカウントＩＤ");
        exBizCalcbleEquals(syoriKensuuHokanTaskList.get(5).getZenjituzanKensuu(), BizNumber.valueOf(0), "前日残件数");
        exBizCalcbleEquals(syoriKensuuHokanTaskList.get(5).getZanKensuu(), BizNumber.valueOf(303), "残件数");
        exBizCalcbleEquals(syoriKensuuHokanTaskList.get(5).getKanryoKensuu(), BizNumber.valueOf(0), "完了件数");

        exDateEquals(syoriKensuuHokanTaskList.get(6).getKensuuHokanYmd(), BizDate.valueOf(20180111), "件数保管日");
        exStringEquals(syoriKensuuHokanTaskList.get(6).getJimutetuzukicd(), "f401223301", "事務手続コード");
        exStringEquals(syoriKensuuHokanTaskList.get(6).getTskid(), "w40177889901", "タスクＩＤ");
        exStringEquals(syoriKensuuHokanTaskList.get(6).getAccountId(), "kyouyuu", "アカウントＩＤ");
        exBizCalcbleEquals(syoriKensuuHokanTaskList.get(6).getZenjituzanKensuu(), BizNumber.valueOf(0), "前日残件数");
        exBizCalcbleEquals(syoriKensuuHokanTaskList.get(6).getZanKensuu(), BizNumber.valueOf(401), "残件数");
        exBizCalcbleEquals(syoriKensuuHokanTaskList.get(6).getKanryoKensuu(), BizNumber.valueOf(501), "完了件数");

        exDateEquals(syoriKensuuHokanTaskList.get(7).getKensuuHokanYmd(), BizDate.valueOf(20180111), "件数保管日");
        exStringEquals(syoriKensuuHokanTaskList.get(7).getJimutetuzukicd(), "f401223302", "事務手続コード");
        exStringEquals(syoriKensuuHokanTaskList.get(7).getTskid(), "w40177889902", "タスクＩＤ");
        exStringEquals(syoriKensuuHokanTaskList.get(7).getAccountId(), "accountId402", "アカウントＩＤ");
        exBizCalcbleEquals(syoriKensuuHokanTaskList.get(7).getZenjituzanKensuu(), BizNumber.valueOf(0), "前日残件数");
        exBizCalcbleEquals(syoriKensuuHokanTaskList.get(7).getZanKensuu(), BizNumber.valueOf(402), "残件数");
        exBizCalcbleEquals(syoriKensuuHokanTaskList.get(7).getKanryoKensuu(), BizNumber.valueOf(0), "完了件数");

        exDateEquals(syoriKensuuHokanTaskList.get(8).getKensuuHokanYmd(), BizDate.valueOf(20180111), "件数保管日");
        exStringEquals(syoriKensuuHokanTaskList.get(8).getJimutetuzukicd(), "f401223303", "事務手続コード");
        exStringEquals(syoriKensuuHokanTaskList.get(8).getTskid(), "w40177889903", "タスクＩＤ");
        exStringEquals(syoriKensuuHokanTaskList.get(8).getAccountId(), "kyouyuu", "アカウントＩＤ");
        exBizCalcbleEquals(syoriKensuuHokanTaskList.get(8).getZenjituzanKensuu(), BizNumber.valueOf(0), "前日残件数");
        exBizCalcbleEquals(syoriKensuuHokanTaskList.get(8).getZanKensuu(), BizNumber.valueOf(403), "残件数");
        exBizCalcbleEquals(syoriKensuuHokanTaskList.get(8).getKanryoKensuu(), BizNumber.valueOf(502), "完了件数");

        jimutetuzukiRirekiList = workFlowUtilityDao.getJimutetuzukiRirekisBySyoriYmd(BizDate.valueOf(20180111));

        exNumericEquals(jimutetuzukiRirekiList.size(), 3, "件数");
        exDateEquals(jimutetuzukiRirekiList.get(0).getKensuuHokanYmd(), BizDate.valueOf(20180111), "件数保管日");
        exStringEquals(jimutetuzukiRirekiList.get(0).getJimutetuzukicd(), "khsiboumukoushrnasi", "事務手続コード");
        exStringEquals(jimutetuzukiRirekiList.get(0).getSubSystemId(), "sinkeiyakusinkeiyakusinkeiyakusinkeiyakusinkeiyaku", "サブシステムＩＤ");
        exStringEquals(jimutetuzukiRirekiList.get(0).getJimutetuzukinm(), "申込書入力申込書入力申込書入力申込書入力", "事務手続名");
        exClassificationEquals(jimutetuzukiRirekiList.get(0).getImagerenkeikbn(), C_ImagerenkeiKbn.YUYUSEIHO, "イメージ連携区分");
        exNumericEquals(jimutetuzukiRirekiList.get(0).getHyoujijyun(), 10, "表示順");
        exStringEquals(jimutetuzukiRirekiList.get(0).getSyukouteijimutetuzukicd(), "skmaindairitensfesg", "主工程事務手続コード");

        exDateEquals(jimutetuzukiRirekiList.get(1).getKensuuHokanYmd(), BizDate.valueOf(20180111), "件数保管日");
        exStringEquals(jimutetuzukiRirekiList.get(1).getJimutetuzukicd(), "skhubikaisyou", "事務手続コード");
        exStringEquals(jimutetuzukiRirekiList.get(1).getSubSystemId(), "sinkeiyaku", "サブシステムＩＤ");
        exStringEquals(jimutetuzukiRirekiList.get(1).getJimutetuzukinm(), "新契約不備解消", "事務手続名");
        exClassificationEquals(jimutetuzukiRirekiList.get(1).getImagerenkeikbn(), C_ImagerenkeiKbn.YUYUSEIHO, "イメージ連携区分");
        exNumericEquals(jimutetuzukiRirekiList.get(1).getHyoujijyun(), 5, "表示順");
        exStringEquals(jimutetuzukiRirekiList.get(1).getSyukouteijimutetuzukicd(), "skmaindairiten", "主工程事務手続コード");

        exDateEquals(jimutetuzukiRirekiList.get(2).getKensuuHokanYmd(), BizDate.valueOf(20180111), "件数保管日");
        exStringEquals(jimutetuzukiRirekiList.get(2).getJimutetuzukicd(), "skhubitouroku", "事務手続コード");
        exStringEquals(jimutetuzukiRirekiList.get(2).getSubSystemId(), "sinkeiyaku", "サブシステムＩＤ");
        exStringEquals(jimutetuzukiRirekiList.get(2).getJimutetuzukinm(), "新契約不備登録", "事務手続名");
        exClassificationEquals(jimutetuzukiRirekiList.get(2).getImagerenkeikbn(), C_ImagerenkeiKbn.BLNK, "イメージ連携区分");
        exNumericEquals(jimutetuzukiRirekiList.get(2).getHyoujijyun(), 4, "表示順");
        exStringEquals(jimutetuzukiRirekiList.get(2).getSyukouteijimutetuzukicd(), "skmaindairiten", "主工程事務手続コード");

        jimutetuzukiTaskRirekiList = Lists.newArrayList();
        for (DM_JimutetuzukiRireki jimutetuzukiRireki : jimutetuzukiRirekiList) {
            jimutetuzukiTaskRirekiList.addAll(jimutetuzukiRireki.getJimutetuzukiTaskRirekis());
        }

        exNumericEquals(jimutetuzukiTaskRirekiList.size(), 5, "件数");
        exDateEquals(jimutetuzukiTaskRirekiList.get(0).getKensuuHokanYmd(), BizDate.valueOf(20180111), "件数保管日");
        exStringEquals(jimutetuzukiTaskRirekiList.get(0).getSubSystemId(), "sinkeiyakusinkeiyakusinkeiyakusinkeiyakusinkeiyaku", "サブシステムＩＤ");
        exStringEquals(jimutetuzukiTaskRirekiList.get(0).getJimutetuzukicd(), "khsiboumukoushrnasi", "事務手続コード");
        exStringEquals(jimutetuzukiTaskRirekiList.get(0).getWorkflowTskId(), "inputinputinputinputinputinputinputinputinputinput", "ワークフロータスクID");
        exStringEquals(jimutetuzukiTaskRirekiList.get(0).getWorkflowTskNm(), "入力入力入力入力入力入力入力入力入力入力入力入力１", "ワークフロータスク名");
        exNumericEquals(jimutetuzukiTaskRirekiList.get(0).getHyoujijyun(), 20, "表示順");
        exNumericEquals(jimutetuzukiTaskRirekiList.get(0).getWorklistHyoujiFlag(), 1, "工程ワークリスト表示フラグ");

        exDateEquals(jimutetuzukiTaskRirekiList.get(1).getKensuuHokanYmd(), BizDate.valueOf(20180111), "件数保管日");
        exStringEquals(jimutetuzukiTaskRirekiList.get(1).getSubSystemId(), "sinkeiyaku", "サブシステムＩＤ");
        exStringEquals(jimutetuzukiTaskRirekiList.get(1).getJimutetuzukicd(), "skhubikaisyou", "事務手続コード");
        exStringEquals(jimutetuzukiTaskRirekiList.get(1).getWorkflowTskId(), "hubikaisyou", "ワークフロータスクID");
        exStringEquals(jimutetuzukiTaskRirekiList.get(1).getWorkflowTskNm(), "不備解消", "ワークフロータスク名");
        exNumericEquals(jimutetuzukiTaskRirekiList.get(1).getHyoujijyun(), 3, "表示順");
        exNumericEquals(jimutetuzukiTaskRirekiList.get(1).getWorklistHyoujiFlag(), 1, "工程ワークリスト表示フラグ");

        exDateEquals(jimutetuzukiTaskRirekiList.get(2).getKensuuHokanYmd(), BizDate.valueOf(20180111), "件数保管日");
        exStringEquals(jimutetuzukiTaskRirekiList.get(2).getSubSystemId(), "sinkeiyaku", "サブシステムＩＤ");
        exStringEquals(jimutetuzukiTaskRirekiList.get(2).getJimutetuzukicd(), "skhubitouroku", "事務手続コード");
        exStringEquals(jimutetuzukiTaskRirekiList.get(2).getWorkflowTskId(), "hubihassin", "ワークフロータスクID");
        exStringEquals(jimutetuzukiTaskRirekiList.get(2).getWorkflowTskNm(), "不備内容確認・発信", "ワークフロータスク名");
        exNumericEquals(jimutetuzukiTaskRirekiList.get(2).getHyoujijyun(), 3, "表示順");
        exNumericEquals(jimutetuzukiTaskRirekiList.get(2).getWorklistHyoujiFlag(), 1, "工程ワークリスト表示フラグ");

        exDateEquals(jimutetuzukiTaskRirekiList.get(3).getKensuuHokanYmd(), BizDate.valueOf(20180111), "件数保管日");
        exStringEquals(jimutetuzukiTaskRirekiList.get(3).getSubSystemId(), "sinkeiyaku", "サブシステムＩＤ");
        exStringEquals(jimutetuzukiTaskRirekiList.get(3).getJimutetuzukicd(), "skhubitouroku", "事務手続コード");
        exStringEquals(jimutetuzukiTaskRirekiList.get(3).getWorkflowTskId(), "hubitouroku", "ワークフロータスクID");
        exStringEquals(jimutetuzukiTaskRirekiList.get(3).getWorkflowTskNm(), "不備登録", "ワークフロータスク名");
        exNumericEquals(jimutetuzukiTaskRirekiList.get(3).getHyoujijyun(), 2, "表示順");
        exNumericEquals(jimutetuzukiTaskRirekiList.get(3).getWorklistHyoujiFlag(), 0, "工程ワークリスト表示フラグ");

        exDateEquals(jimutetuzukiTaskRirekiList.get(4).getKensuuHokanYmd(), BizDate.valueOf(20180111), "件数保管日");
        exStringEquals(jimutetuzukiTaskRirekiList.get(4).getSubSystemId(), "sinkeiyaku", "サブシステムＩＤ");
        exStringEquals(jimutetuzukiTaskRirekiList.get(4).getJimutetuzukicd(), "skhubitouroku", "事務手続コード");
        exStringEquals(jimutetuzukiTaskRirekiList.get(4).getWorkflowTskId(), "state-kouteikaisi", "ワークフロータスクID");
        exStringEquals(jimutetuzukiTaskRirekiList.get(4).getWorkflowTskNm(), "工程開始待ち", "ワークフロータスク名");
        exNumericEquals(jimutetuzukiTaskRirekiList.get(4).getHyoujijyun(), 1, "表示順");
        exNumericEquals(jimutetuzukiTaskRirekiList.get(4).getWorklistHyoujiFlag(), 0, "工程ワークリスト表示フラグ");

    }

    @Test
    @TestOrder(110)
    @Transactional
    public void testMakeCountOfKakoJissekiTaskSummary_A11() {
        WorkflowDomManager workflowDomManager = SWAKInjector.getInstance(WorkflowDomManager.class);

        workflowDomManager.delete(workflowDomManager.getAllJimutetuzuki());

        MockObjectManager.initialize();
        IwfKouteiClientMock.mode = "30-06-11";

        MakeCountOfKakoJissekiTaskSummaryResultBean ret = WorkFlowUtility.makeCountOfKakoJissekiTaskSummary(
            BizDate.valueOf(20180108));

        exStringEquals(ret.getSyorikekkaStatus(), "0", "処理結果ステータス");
        exStringEquals(ret.getSyousaiMessageCd(), "IWF0000", "詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), "前日残件数、当日残件数、当日完了件数を全て０件取得する。", "詳細メッセージ");
        assertNull(ret.getErrHasseiSyoriNm());
    }
}
