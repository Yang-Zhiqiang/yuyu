package yuyu.common.workflow.workflowutility;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.List;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.workflow.configuration.YuyuWorkflowConfig;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.TestOrder;

import com.google.common.base.Strings;

/**
 * ワークフロー呼出ユーティリティ(ワークフロースタブモード：true)単体テストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class WorkFlowUtilityTest00_2 extends AbstractTest {


    @Before
    public  void caseInit() {
        YuyuWorkflowConfig config = YuyuWorkflowConfig.getInstance();
        config.setWorkflowStubMode(true);
    }


    @Test
    @TestOrder(10)
    public void testExec_A01() {

        GetLockedTaskListResultBean ret = WorkFlowUtility.getLockedTasksInfoList(
                null,
                new String[] {"1234567890"},
                null ,
                new String[] {"0001"},
                "test",
                null);
        exStringEquals(ret.getSyorikekkaStatus(), WorkFlowResultConstants.RESULT_NG, "ロック中工程リスト取得処理結果:1");
    }

    @Test
    @TestOrder(20)
    public void testExec_A02() {

        UnlockProcessForceResultBean ret = WorkFlowUtility.unlockProcessForce("hijklmn","hzn");

        exStringEquals(ret.getSyorikekkaStatus(), "9", "処理結果ステータス");
    }

    @Test
    @TestOrder(30)
    public void testExec_A03() {

        GetTaskTantoNmResultBean ret = WorkFlowUtility.getTaskTantoNm(
                new String[] {"0001","0002","0003"});
        exStringEquals(ret.getSyorikekkaStatus(), WorkFlowResultConstants.RESULT_NG, "タスク担当者名取得処理結果:1");
    }

    @Test
    @TestOrder(40)
    public void testExec_A04() {

        GetTaskTantoInfoListResultBean ret = WorkFlowUtility.getTaskTantoInfoList(
                "common",
                new String[] {"0001","0002","0003"},
                "test",
                "TastId01");

        exStringEquals(ret.getSyorikekkaStatus(), "0", "処理結果ステータス");
    }

    @Test
    @TestOrder(50)
    public void testExec_A05() {

        WorkListUnassignTaskResultBean ret = WorkFlowUtility.unassignTask("hijklmn", "hzn","タスク名０１", "abcdefg", "rirekiUser");

        exBooleanEquals(Strings.isNullOrEmpty(ret.getSyousaiMessageCd()), true, "割当解除処理結果:1");
    }

    @Test
    @TestOrder(60)
    public void testExec_A06() {

        GetTasksForCancelResultBean ret = WorkFlowUtility.getTasksForCancel("","", "", "", "");

        exStringEquals(ret.getSyousaiMessageCd(), "IWF0000", "出力パラメータの詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), "正常終了しました。", "出力パラメータの詳細メッセージ");
        exStringEquals(ret.getSyorikekkaStatus(), WorkFlowResultConstants.RESULT_NODATA, "出力パラメータの処理結果ステータス");
    }

    @Test
    @TestOrder(70)
    public void testExec_A07() {

        GetTasksForPutImageResultBean ret = WorkFlowUtility.getTasksForPutImage(
                "0001",
                null,
                "12345678901",
                null ,
                "20150101",
                null,
                "10",
                "001",
                null,
                null,
                null);
        exStringEquals(ret.getSyorikekkaStatus(), "9", "イメージ取込対象リスト取得処理結果:1");
    }

    @Test
    @TestOrder(80)
    public void testExec_A08() {

        GetTasksForHyousiResultBean ret = WorkFlowUtility.getTasksForHyousi(
                "common",
                "0001",
                null,
                null,
                null,
                null);

        exStringEquals(ret.getSyousaiMessageCd(), "IWF0000", "出力パラメータの詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), "正常終了しました。", "出力パラメータの詳細メッセージ");
        exStringEquals(ret.getSyorikekkaStatus(), "-1", "出力パラメータの処理結果ステータス");
    }

    @Test
    @TestOrder(90)
    public void testExec_A09() {

        GetTasksForKouteiStatusResultBean ret = WorkFlowUtility.getTasksForKouteiStatus("common",
                null,
                new String[] {"12345678901","12345678902"},
                null,
                new String[] {"0001","0002"},
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                "001",
                null,
                null,
                null,
                null,
                null,
                false);
        exStringEquals(ret.getSyorikekkaStatus(), "9", "工程状況照会用リスト取得処理結果:1");
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        GetTasksForQrSealResultBean ret = WorkFlowUtility.getTasksForQrSeal(
                null,
                new String[] {"12345678901","12345678902"},
                null);
        exStringEquals(ret.getSyorikekkaStatus(), "9", "ＱＲシール用紙作成用案件存在チェック:1");
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {

        GetExecutableTasksForWorkListSkResultBean ret = WorkFlowUtility.getExecutableTasksForWorkListSk("sinkeiyaku"
                , null
                , "0001",
                null
                , "0001"
                , "20150101020304005", "20151231020304005", "20150101020304005", "",
                null, null, null, null, null, null, null, null,
                null, null);

        exStringEquals(ret.getSyorikekkaStatus(), WorkFlowResultConstants.RESULT_NODATA, "「実行可能タスク取得(工程指定)」サービス処理結果:5");
    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {

        GetExecutableTasksForWorkListResultBean ret = WorkFlowUtility.getExecutableTasksForWorkList("nenkin",
                null,null, "0001", "0001", "",
                "20151231020304005", null, null,
                "test");

        exStringEquals(ret.getSyorikekkaStatus(), WorkFlowResultConstants.RESULT_NODATA, "「実行可能タスク取得(工程指定)」サービス処理結果:2");
    }

    @Test
    @TestOrder(130)
    public void testExec_A13() {

        GetTasksForWorkListSkResultBean ret = WorkFlowUtility.getTasksForWorkListSk("sinkeiyaku", null,"12345678901", null,
                "0001", "20150101", "20160101", "20150101", "20160101", "001",
                null, null, "0", null, null, null, null,
                null, null, null);

        exStringEquals(ret.getSyorikekkaStatus(), WorkFlowResultConstants.RESULT_NODATA, "「工程サマリ取得」サービス処理結果:5");
    }

    @Test
    @TestOrder(140)
    public void testExec_A14() {

        GetTasksForWorkListResultBean ret = WorkFlowUtility.getTasksForWorkList("hozen", null, "12345678901", null, "0001", "20150101", "20160101", "001", null, null, "0", null);

        exStringEquals(ret.getSyorikekkaStatus(), WorkFlowResultConstants.RESULT_NODATA, "「工程サマリ取得」サービス処理結果:5");
    }

    @Test
    @TestOrder(150)
    public void testExec_A15() {

        GetTasksForJimuyouCdResultBean ret = WorkFlowUtility.getTasksForJimuyouCd(
                null,
                null,
                null,
                new String[] {"0001","0002","0003"});
        exStringEquals(ret.getSyorikekkaStatus(), "-1", "事務用コード入力工程リスト取得処理結果:3");
    }

    @Test
    @TestOrder(160)
    public void testExec_A16() {

        CancelProcessResultBean ret = WorkFlowUtility.cancelProcess("hijklmn", "hzn", "userId", "comment");

        exStringEquals(ret.getSyorikekkaStatus(), "0", "出力パラメータの処理結果ステータス");
        exStringEquals(ret.getSyousaiMessageCd(), null, "出力パラメータの詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), null, "出力パラメータの詳細メッセージ");
        exStringEquals(ret.getErrorApiName(), null, "出力パラメータのエラー発生API名");
    }

    @Test
    @TestOrder(170)
    public void testExec_A17() {

        GetProcessHistoryResultBean result = WorkFlowUtility.getProcessHistory("testId", "0001");

        exStringEquals(result.getSyorikekkaStatus(),"-1", "工程履歴取得処理結果:8");
    }

    @Test
    @TestOrder(180)
    public void testExec_A18() {

        String[] jimutetuzuki = {"0001","0002","0003"};
        GetTorikomiSyoruiMstResultBean result = WorkFlowUtility.getTorikomiSyoruiMst(jimutetuzuki);

        exStringEquals(result.getSyorikekkaStatus(),"-1", "取込書類マスタ取得処理結果:9");
    }

    @Test
    @TestOrder(190)
    public void testExec_A19() {

        GetImagePropsListResultBean ret = WorkFlowUtility.getImagePropsList(
                "common",
                null,
                new String[] {"0005", "0006", "0007"} ,
                null,
                null,
                null,
                null,
                null,
                null,
                null);

        exStringEquals(ret.getSyorikekkaStatus(), "-1", "処理結果ステータス");
    }

    @Test
    @TestOrder(200)
    public void testExec_A20() {

        GetImageInfoListResultBean ret = WorkFlowUtility.getImage("abcdefg", "hijklmn");

        exStringEquals(ret.getSyorikekkaStatus(), "-1", "イメージ取得処理結果:7");
    }

    @Test
    @TestOrder(210)
    public void testExec_A21() {

        byte[] b = new byte[102400];

        PutImageResultBean ret = WorkFlowUtility.putImage("iw001", "abcdefg", "hzn", b, "hijklmn", "2015010111223300000", "2015010111223300000", null);
        exStringEquals(ret.getSyorikekkaStatus(), WorkFlowResultConstants.RESULT_OK, "イメージ登録処理結果:1");
    }

    @Test
    @TestOrder(220)
    public void testExec_A22() {

        DropImageResultBean ret = WorkFlowUtility.dropImage(null, "abcdefg");
        exStringEquals(ret.getSyorikekkaStatus(), WorkFlowResultConstants.RESULT_NG, "イメージ削除処理結果:1");
    }

    @Test
    @TestOrder(230)
    public void testExec_A23() {

        CreateProcessIkkatuResultBean ret = WorkFlowUtility.createProcessIkkatu(null);
        exStringEquals(ret.getSyorikekkaStatus(), WorkFlowResultConstants.RESULT_NG, "一括工程作成処理結果:1");
    }

    @Test
    @TestOrder(240)
    public void testExec_A24() {

        GetSyoruiKengenResultBean ret = WorkFlowUtility.getSyoruiKengen(
                "0001",
                new String[] {"0001","0003","0002"},
                null);
        exStringEquals(ret.getSyorikekkaStatus(), "9", "書類権限取得処理結果:4");
    }

    @Test
    @TestOrder(250)
    public void testExec_A25() {

        PutSyoruiKengenResultBean ret = WorkFlowUtility.putSyoruiKengen(
                null,
                new String[] {"wf001","wf002"});
        exStringEquals(ret.getSyorikekkaStatus(), "9", "書類権限登録処理結果:1");
    }

    @Test
    @TestOrder(260)
    public void testExec_A26() {

        DropSyoruiKengenResultBean ret = WorkFlowUtility.dropSyoruiKengen(
                null);
        exStringEquals(ret.getSyorikekkaStatus(), "9", "書類権限削除処理結果:1");
    }

    @Test
    @TestOrder(270)
    public void testExec_A27() {

        GetCountOfTaskSummaryBySubsystemResultBean ret = WorkFlowUtility.getCountOfTaskSummaryBySubsystem(null, "UserId");

        exStringEquals(ret.getSyorikekkaStatus(), "0", "処理結果ステータス");
        exNumericEquals(ret.getCountOfTaskSummaryBean().size(), 0, "処理残件数Beanリストの件数");
    }

    @Test
    @TestOrder(280)
    public void testExec_A28() {

        GetCountOfTaskSummaryByJimutetuzukiResultBean ret = WorkFlowUtility.getCountOfTaskSummaryByJimutetuzuki("Subsystem01","0024", null);

        exStringEquals(ret.getSyorikekkaStatus(), "0", "処理結果ステータス");
    }

    @Test
    @TestOrder(290)
    public void testExec_A29() {

        GetCountOfTaskSummaryByTaskResultBean ret = WorkFlowUtility.getCountOfTaskSummaryByTask("0001", "Task01",
                "UserId");

        exStringEquals(ret.getSyorikekkaStatus(), "9", "処理結果ステータス");
        exStringEquals(ret.getSyousaiMessageCd(), "IWF0003", "詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), "稼働時間外エラーか、認証エラーが発生しました。", "詳細メッセージ");
    }

    @Test
    @TestOrder(300)
    public void testExec_A30() {

        MakeCountOfTaskSummaryResultBean ret = WorkFlowUtility.makeCountOfTaskSummary();

        exBooleanEquals(Strings.isNullOrEmpty(ret.getSyorikekkaStatus()), false, "タスク件数サマリ作成処理結果:2");
    }

    @Test
    @TestOrder(310)
    public void testExec_A31() {

        List<PutJimuyouCdBean> putJimuyouCdBeanLst = new ArrayList<>();

        PutJimuyouCdBean putJimuyouCdBean1 = SWAKInjector.getInstance(PutJimuyouCdBean.class);
        putJimuyouCdBean1.setKouteiKnrId("hijklmn1");
        putJimuyouCdBean1.setJimuyouCd("123");

        PutJimuyouCdBean putJimuyouCdBean2 = SWAKInjector.getInstance(PutJimuyouCdBean.class);
        putJimuyouCdBean2.setKouteiKnrId("hijklmn2");
        putJimuyouCdBean2.setJimuyouCd("456");

        putJimuyouCdBeanLst.add(putJimuyouCdBean1);
        putJimuyouCdBeanLst.add(putJimuyouCdBean2);

        PutJimuyouCdResultBean ret = WorkFlowUtility.putJimuyouCd(
                "0001",
                "UserId01" ,
                putJimuyouCdBeanLst);

        exStringEquals(ret.getSyorikekkaStatus(), "9", "処理結果ステータス");
    }

    @Test
    @TestOrder(320)
    public void testExec_A32() {

        GetTorikomiSyoruiMstAndKengenResultBean result =
                WorkFlowUtility.getTorikomiSyoruiMstAndKengen(new String[] {"0001","0002","0003"}, "UserId01");

        exStringEquals(result.getSyorikekkaStatus(), "9", "処理結果ステータス");
    }

    @Test
    @TestOrder(330)
    public void testExec_A33() {

        PutExpectedArrivalNoticeResultBean ret = WorkFlowUtility.putExpectedArrivalNotice(
                null,
                "yuyu12345678901234567",
                "wf001",
                "0001",
                "sinkeiyaku");
        exStringEquals(ret.getSyorikekkaStatus(), "9", "到着予定登録処理結果:1");
    }

    @Test
    @TestOrder(340)
    public void testExec_A34() {

        GetExpectedArrivalNoticeResultBean ret = WorkFlowUtility.getExpectedArrivalNotice(
                null);

        exStringEquals(ret.getSyorikekkaStatus(), "-1", "処理結果ステータス");
    }

    @Test
    @TestOrder(350)
    public void testExec_A35() {

        byte[] dummyPdf = new byte[102400];

        PutArrivalImageResultBean ret = WorkFlowUtility.putArrivalImage("yuyu12345678901234567", dummyPdf, "GyoumuKey");

        exStringEquals(ret.getSyorikekkaStatus(), "-9", "処理結果ステータス");
    }

    @Test
    @TestOrder(360)
    public void testExec_A36() {

        String syouiCd = "iwf001";
        GetTorikomiSyoruiMstBySyoruiCdResultBean result = WorkFlowUtility.getTorikomiSyoruiMstBySyoruiCd(syouiCd);

        exStringEquals(result.getSyorikekkaStatus(),"-1", "取込書類マスタ取得(書類コード指定)処理結果:9");
    }

    @Test
    @TestOrder(370)
    public void testExec_A37() {

        GetScanTorikomiSyoruiMstResultBean result =
                WorkFlowUtility.getScanTorikomiSyoruiMst("0001");

        exStringEquals(result.getSyorikekkaStatus(), "9", "スキャン対象取込書類マスタ取得処理結果:3");
    }

    @Test
    @TestOrder(380)
    public void testExec_A38() {

        GetLockInfoResultBean ret = WorkFlowUtility.getLockInfo("hijklmn");

        exStringEquals(ret.getSyorikekkaStatus(), "-9", "処理結果ステータス");
    }

    @Test
    @TestOrder(390)
    public void testExec_A39() {

        MakeCountOfKakoJissekiTaskSummaryResultBean ret = WorkFlowUtility.makeCountOfKakoJissekiTaskSummary(
                BizDate.valueOf(20180108));

        exStringEquals(ret.getSyorikekkaStatus(), "9", "処理結果ステータス");
    }

    @Test
    @TestOrder(400)
    public void testExec_A40() {

        GetCountOfTaskSummaryBySubsystemResultBean ret = WorkFlowUtility.getCountOfKakoJissekiTaskSummaryBySubsystem(
                null, BizDate.valueOf(20180108), "userId101");

        exStringEquals(ret.getSyorikekkaStatus(), "-1", "処理結果ステータス");
    }

    @Test
    @TestOrder(410)
    public void testExec_A41() {

        GetCountOfTaskSummaryByJimutetuzukiResultBean ret = WorkFlowUtility.getCountOfKakoJissekiTaskSummaryByJimutetuzuki(
                new String[]{"sub101"}, BizDate.valueOf(20180108), "101223301", "userId101");

        exStringEquals(ret.getSyorikekkaStatus(), "-1", "処理結果ステータス");
    }

    @Test
    @TestOrder(420)
    public void testExec_A42() {

        GetCountOfTaskSummaryByTaskResultBean ret = WorkFlowUtility.getCountOfKakoJissekiTaskSummaryByTask(
                BizDate.valueOf(20180108), "101223301", new String[]{"task101"}, "userId101");
        exStringEquals(ret.getSyorikekkaStatus(), "0", "処理結果ステータス");
    }
}
