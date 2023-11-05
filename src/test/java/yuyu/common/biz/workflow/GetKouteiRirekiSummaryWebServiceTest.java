package yuyu.common.biz.workflow;

import static org.junit.Assert.*;

import javax.inject.Inject;

import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.workflow.io.koutei.GetProcessSummaryInBean;
import yuyu.common.biz.workflow.io.koutei.GetProcessSummaryOutBean;
import yuyu.common.biz.workflow.io.koutei.sub.ProcessSummaryBean;
import yuyu.common.workflowcore.core.webservice.common.WSExtParam;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getkouteirirekisummary.WSGetKouteiRirekiSummary;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getkouteirirekisummary.WSGetKouteiRirekiSummaryRequest;
import yuyu.def.classification.C_ResultCdKbn;

/**
 * 工程サマリ取得Webサービスのゲットメソッド
 * {@link WSGetKouteiRirekiSummary#executeBizMain(WSGetKouteiRirekiSummaryRequest)}
 * テスト用クラスです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class GetKouteiRirekiSummaryWebServiceTest {

    @Inject
    IwfKouteiClient iwfKouteiClient;

    @Test(expected = RuntimeException.class)
    public void testValidationNG01() {

        iwfKouteiClient.execGetProcessSummary(null);
    }

    @Test
    public void test_GetKouteiSummary_No1() {

        String psGyoumukey = "業務キー2_3";

        GetProcessSummaryInBean inBean = new GetProcessSummaryInBean();
        inBean.setGyoumukey(psGyoumukey);

        GetProcessSummaryOutBean outBean = iwfKouteiClient
            .execGetProcessSummary(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(),
            outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程履歴サマリ取得正常終了しました。", outBean.getSyousaimsg());

        assertEquals("業務キー", psGyoumukey, outBean
            .getProcessSummaryBeanList().get(0).getGyoumukey());

    }

    @Test
    public void test_GetKouteiSummary_No2() {

        String psGyoumukey = "業務キー2_3";
        String[] psGyoumukeys = { "業務キー1_11" };

        GetProcessSummaryInBean inBean = new GetProcessSummaryInBean();
        inBean.setGyoumukey(psGyoumukey);
        inBean.setGyoumukeys(psGyoumukeys);

        GetProcessSummaryOutBean outBean = iwfKouteiClient
            .execGetProcessSummary(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(),
            outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程履歴サマリ取得正常終了しました。", outBean.getSyousaimsg());

        assertEquals("業務キー", psGyoumukeys[0], outBean
            .getProcessSummaryBeanList().get(0).getGyoumukey());

    }

    @Test
    public void test_GetKouteiSummary_No3() {
        String psFlowId = "09";

        GetProcessSummaryInBean inBean = new GetProcessSummaryInBean();
        inBean.setFlowid(psFlowId);

        GetProcessSummaryOutBean outBean = iwfKouteiClient
            .execGetProcessSummary(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(),
            outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程履歴サマリ取得正常終了しました。", outBean.getSyousaimsg());

        assertEquals("フローＩＤ", psFlowId,
            outBean.getProcessSummaryBeanList().get(0).getFlowId());

    }

    @Test
    public void test_GetKouteiSummary_No4() {

        String psFlowId = "09";
        String flowId = "tt4";
        String[] psFlowIds = { flowId };

        GetProcessSummaryInBean inBean = new GetProcessSummaryInBean();
        inBean.setFlowid(psFlowId);
        inBean.setFlowids(psFlowIds);

        GetProcessSummaryOutBean outBean = iwfKouteiClient
            .execGetProcessSummary(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(),
            outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程履歴サマリ取得正常終了しました。", outBean.getSyousaimsg());

        assertEquals("フローID", flowId, outBean.getProcessSummaryBeanList()
            .get(0).getFlowId());

    }

    @Test
    public void test_GetKouteiSummary_No5() {

        String updateTime_ = "20150427101307068";

        GetProcessSummaryInBean inBean = new GetProcessSummaryInBean();
        inBean.setLastsyoritimefrom(updateTime_);

        GetProcessSummaryOutBean outBean = iwfKouteiClient
            .execGetProcessSummary(inBean);
        System.out.println(outBean.getKekkastatus());
        System.out.println(outBean.getSyousaimsgcd());
        System.out.println(outBean.getSyousaimsg());

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(),
            outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF2169", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "最終処理時間(自)と最終処理時間(至)の両方を入力してください。",
            outBean.getSyousaimsg());

    }

    @Test
    public void test_GetKouteiSummary_No6() {

        String updateTime_ = "20150427101307068";

        try {

            GetProcessSummaryInBean inBean = new GetProcessSummaryInBean();
            inBean.setLastsyoritimeto(updateTime_);

            GetProcessSummaryOutBean outBean = iwfKouteiClient
                .execGetProcessSummary(inBean);

            System.out.println(outBean.getKekkastatus());
            System.out.println(outBean.getSyousaimsgcd());
            System.out.println(outBean.getSyousaimsg());

            assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(),
                outBean.getKekkastatus());
            assertEquals("詳細メッセージコード:", "IWF2169", outBean.getSyousaimsgcd());
            assertEquals("詳細メッセージ:", "最終処理時間(自)と最終処理時間(至)の両方を入力してください。",
                outBean.getSyousaimsg());

        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

    @Test
    public void test_GetKouteiSummary_No7() {

        String updateTime_ = "20150427";

        GetProcessSummaryInBean inBean = new GetProcessSummaryInBean();
        inBean.setKouteikaisibifrom(updateTime_);

        GetProcessSummaryOutBean outBean = iwfKouteiClient
            .execGetProcessSummary(inBean);
        System.out.println(outBean.getKekkastatus());
        System.out.println(outBean.getSyousaimsgcd());
        System.out.println(outBean.getSyousaimsg());

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(),
            outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF2167", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程開始日付(自)と工程開始日付(至)の両方を入力してください。",
            outBean.getSyousaimsg());

    }

    @Test
    public void test_GetKouteiSummary_No8() {

        String updateTime_ = "20150427";

        GetProcessSummaryInBean inBean = new GetProcessSummaryInBean();
        inBean.setKouteikaisibito(updateTime_);

        GetProcessSummaryOutBean outBean = iwfKouteiClient
            .execGetProcessSummary(inBean);

        System.out.println(outBean.getKekkastatus());
        System.out.println(outBean.getSyousaimsgcd());
        System.out.println(outBean.getSyousaimsg());

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(),
            outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF2167", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程開始日付(自)と工程開始日付(至)の両方を入力してください。",
            outBean.getSyousaimsg());

    }

    @Test
    public void test_GetKouteiSummary_No9() {

        String updateTime_ = "20150427";

        GetProcessSummaryInBean inBean = new GetProcessSummaryInBean();
        inBean.setKouteikanryoubifrom(updateTime_);

        GetProcessSummaryOutBean outBean = iwfKouteiClient
            .execGetProcessSummary(inBean);
        System.out.println(outBean.getKekkastatus());
        System.out.println(outBean.getSyousaimsgcd());
        System.out.println(outBean.getSyousaimsg());

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(),
            outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF2168", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程完了日付(自)と工程完了日付(至)の両方を入力してください。",
            outBean.getSyousaimsg());

    }

    @Test
    public void test_GetKouteiSummary_No10() {

        String updateTime_ = "20150427";

        GetProcessSummaryInBean inBean = new GetProcessSummaryInBean();
        inBean.setKouteikanryoubito(updateTime_);

        GetProcessSummaryOutBean outBean = iwfKouteiClient
            .execGetProcessSummary(inBean);

        System.out.println(outBean.getKekkastatus());
        System.out.println(outBean.getSyousaimsgcd());
        System.out.println(outBean.getSyousaimsg());

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(),
            outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF2168", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程完了日付(自)と工程完了日付(至)の両方を入力してください。",
            outBean.getSyousaimsg());

    }

    @Test
    public void test_GetKouteiSummary_No11() {

        String updateTime_ = "20152427101307068";

        GetProcessSummaryInBean inBean = new GetProcessSummaryInBean();
        inBean.setKouteikaisibifrom(updateTime_);

        GetProcessSummaryOutBean outBean = iwfKouteiClient
            .execGetProcessSummary(inBean);

        System.out.println(outBean.getKekkastatus());
        System.out.println(outBean.getSyousaimsgcd());
        System.out.println(outBean.getSyousaimsg());

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(),
            outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF2161", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "日付チェックエラー：工程開始日付(自)", outBean.getSyousaimsg());

    }

    @Test
    public void test_GetKouteiSummary_No12() {

        String updateTime_ = "20152427";

        GetProcessSummaryInBean inBean = new GetProcessSummaryInBean();
        inBean.setKouteikaisibito(updateTime_);

        GetProcessSummaryOutBean outBean = iwfKouteiClient
            .execGetProcessSummary(inBean);

        System.out.println(outBean.getKekkastatus());
        System.out.println(outBean.getSyousaimsgcd());
        System.out.println(outBean.getSyousaimsg());

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(),
            outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF2162", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "日付チェックエラー：工程開始日付(至)", outBean.getSyousaimsg());

    }

    @Test
    public void test_GetKouteiSummary_No13() {

        String updateTime_ = "20152427";

        GetProcessSummaryInBean inBean = new GetProcessSummaryInBean();
        inBean.setKouteikanryoubifrom(updateTime_);

        GetProcessSummaryOutBean outBean = iwfKouteiClient
            .execGetProcessSummary(inBean);

        System.out.println(outBean.getKekkastatus());
        System.out.println(outBean.getSyousaimsgcd());
        System.out.println(outBean.getSyousaimsg());

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(),
            outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF2163", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "日付チェックエラー：工程完了日付(自)", outBean.getSyousaimsg());

    }

    @Test
    public void test_GetKouteiSummary_No14() {

        String updateTime_ = "20152427101307068";

        GetProcessSummaryInBean inBean = new GetProcessSummaryInBean();
        inBean.setKouteikanryoubito(updateTime_);

        GetProcessSummaryOutBean outBean = iwfKouteiClient
            .execGetProcessSummary(inBean);

        System.out.println(outBean.getKekkastatus());
        System.out.println(outBean.getSyousaimsgcd());
        System.out.println(outBean.getSyousaimsg());

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(),
            outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF2164", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "日付チェックエラー：工程完了日付(至)", outBean.getSyousaimsg());

    }

    @Test
    public void test_GetKouteiSummary_No15() {

        GetProcessSummaryInBean inBean = new GetProcessSummaryInBean();

        GetProcessSummaryOutBean outBean = iwfKouteiClient
            .execGetProcessSummary(inBean);

        System.out.println(outBean.getKekkastatus());
        System.out.println(outBean.getSyousaimsgcd());
        System.out.println(outBean.getSyousaimsg());

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(),
            outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程履歴サマリ取得正常終了しました。", outBean.getSyousaimsg());

    }

    @SuppressWarnings("deprecation")
    @Test
    public void test_GetKouteiSummary_No2_1() {

        GetProcessSummaryInBean inBean = new GetProcessSummaryInBean();
        inBean.setGyoumukey("業務キー2_4");
        inBean.setGyoumukeys(new String[] { "業務キー1_11", "業務キー2_4" });
        inBean.setFlowid("tt4");
        inBean.setFlowids(new String[] { "tt4", "09" });
        inBean.setKouteikaisibifrom("20160310");
        inBean.setKouteikaisibito("20160412");
        inBean.setKouteikanryoubifrom("20160315");
        inBean.setKouteikanryoubito("20160417");
        inBean.setLastsyoritimefrom("20160415185446891");
        inBean.setLastsyoritimeto("20160415185446893");
        inBean.setSyoristatus(new String[] { "10", "99" });
        inBean.setAccountid(null);
        inBean.setNodename("torikesi-check1");
        inBean.setAccountwariateumu("1");
        inBean.setKekkajyougenkensu("100");
        WSExtParam wSExtParam = new WSExtParam();
        wSExtParam.setValues("追加パラメータ１");
        inBean.setExtParam1(wSExtParam);
        wSExtParam = new WSExtParam();
        wSExtParam.setValues("追加パラメータ２");
        inBean.setExtParam2(wSExtParam);
        wSExtParam = new WSExtParam();
        wSExtParam.setValues("追加パラメータ３");
        inBean.setExtParam3(wSExtParam);
        wSExtParam = new WSExtParam();
        wSExtParam.setValues("追加パラメータ４");
        inBean.setExtParam4(wSExtParam);
        wSExtParam = new WSExtParam();
        wSExtParam.setValues("追加パラメータ５");
        inBean.setExtParam5(wSExtParam);
        wSExtParam = new WSExtParam();
        wSExtParam.setValues("追加パラメータ６");
        inBean.setExtParam6(wSExtParam);
        wSExtParam = new WSExtParam();
        wSExtParam.setValues("追加パラメータ７");
        inBean.setExtParam7(wSExtParam);
        wSExtParam = new WSExtParam();
        wSExtParam.setValues("追加パラメータ８");
        inBean.setExtParam8(wSExtParam);
        wSExtParam = new WSExtParam();
        wSExtParam.setValues("追加パラメータ９");
        inBean.setExtParam9(wSExtParam);
        wSExtParam = new WSExtParam();
        wSExtParam.setValues("追加パラメータ１０");
        inBean.setExtParam10(wSExtParam);
        wSExtParam = new WSExtParam();
        wSExtParam.setValues("追加パラメータ１１");
        inBean.setExtParam11(wSExtParam);
        wSExtParam = new WSExtParam();
        wSExtParam.setValues("追加パラメータ１２");
        inBean.setExtParam12(wSExtParam);
        wSExtParam = new WSExtParam();
        wSExtParam.setValues("追加パラメータ１３");
        inBean.setExtParam13(wSExtParam);
        wSExtParam = new WSExtParam();
        wSExtParam.setValues("追加パラメータ１４");
        inBean.setExtParam14(wSExtParam);
        wSExtParam = new WSExtParam();
        wSExtParam.setValues("追加パラメータ１５");
        inBean.setExtParam15(wSExtParam);

        GetProcessSummaryOutBean outBean = iwfKouteiClient
            .execGetProcessSummary(inBean);
        ProcessSummaryBean processSummaryBean = new ProcessSummaryBean();

        if (C_ResultCdKbn.OK.toString().equals(outBean.getKekkastatus())) {
            processSummaryBean = outBean.getProcessSummaryBeanList().get(0);
        }

        System.out.println(outBean.getKekkastatus());
        System.out.println(outBean.getSyousaimsgcd());
        System.out.println(outBean.getSyousaimsg());

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(),
            outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程履歴サマリ取得正常終了しました。", outBean.getSyousaimsg());
        assertEquals("検索件数>=1:", true, outBean.getProcessSummaryBeanList()
            .size() >= 1);
        assertEquals("フローＩＤ:", "09", processSummaryBean.getFlowId());
        assertEquals("業務キー:", "業務キー1_11",
            processSummaryBean.getGyoumukey());
        assertEquals("工程開始年月日:", "20160331",
            processSummaryBean.getKouteiKaisiYmd());
        assertEquals("工程完了年月日:", "20160404",
            processSummaryBean.getKouteikanryouYmd());
        assertEquals("工程状態:", "10", processSummaryBean.getProcessstatus());

        assertEquals("最終更新時間:", "20160415185446892",
            processSummaryBean.getUpdateTime());
        assertEquals("初回担当者ID:", "administrator",
            processSummaryBean.getFirstAccountId());
        assertEquals("前回担当者ID:", "administrator",
            processSummaryBean.getPreviousAccountId());
        assertEquals("前回ノード名:", "torikesi-check1",
            processSummaryBean.getPreviousNodeName());
        assertEquals("前回ノード名（ローカル名）:", "施設申込取消（書類審査１次）",
            processSummaryBean.getPreviousNodeLocalname());
        assertEquals("現在担当者ID", null, processSummaryBean.getCurrentAccountId());
        assertEquals("現在ノード名:", "torikesi-check1",
            processSummaryBean.getCurrentNodeName());

        assertEquals("追加パラメータ: 追加パラメータ１", "追加パラメータ１", processSummaryBean
            .getExtparamBean().getExtparam1());
        assertEquals("追加パラメータ: 追加パラメータ２", "追加パラメータ２", processSummaryBean
            .getExtparamBean().getExtparam2());
        assertEquals("追加パラメータ: 追加パラメータ３", "追加パラメータ３", processSummaryBean
            .getExtparamBean().getExtparam3());
        assertEquals("追加パラメータ: 追加パラメータ４", "追加パラメータ４", processSummaryBean
            .getExtparamBean().getExtparam4());
        assertEquals("追加パラメータ: 追加パラメータ５", "追加パラメータ５", processSummaryBean
            .getExtparamBean().getExtparam5());
        assertEquals("追加パラメータ: 追加パラメータ６", "追加パラメータ６", processSummaryBean
            .getExtparamBean().getExtparam6());
        assertEquals("追加パラメータ: 追加パラメータ７", "追加パラメータ７", processSummaryBean
            .getExtparamBean().getExtparam7());
        assertEquals("追加パラメータ: 追加パラメータ８", "追加パラメータ８", processSummaryBean
            .getExtparamBean().getExtparam8());
        assertEquals("追加パラメータ: 追加パラメータ９", "追加パラメータ９", processSummaryBean
            .getExtparamBean().getExtparam9());
        assertEquals("追加パラメータ: 追加パラメータ１０", "追加パラメータ１０", processSummaryBean
            .getExtparamBean().getExtparam10());
        assertEquals("追加パラメータ: 追加パラメータ１１", "追加パラメータ１１", processSummaryBean
            .getExtparamBean().getExtparam11());
        assertEquals("追加パラメータ: 追加パラメータ１２", "追加パラメータ１２", processSummaryBean
            .getExtparamBean().getExtparam12());
        assertEquals("追加パラメータ: 追加パラメータ１３", "追加パラメータ１３", processSummaryBean
            .getExtparamBean().getExtparam13());
        assertEquals("追加パラメータ: 追加パラメータ１４", "追加パラメータ１４", processSummaryBean
            .getExtparamBean().getExtparam14());
        assertEquals("追加パラメータ: 追加パラメータ１５", "追加パラメータ１５", processSummaryBean
            .getExtparamBean().getExtparam15());

    }

    @Test
    public void test_GetKouteiSummary_No2_2() {

        GetProcessSummaryInBean inBean = new GetProcessSummaryInBean();

        inBean.setGyoumukeys(new String[] { "業務キー1_11", "業務キー2_4" });
        inBean.setFlowid("09");

        GetProcessSummaryOutBean outBean = iwfKouteiClient
            .execGetProcessSummary(inBean);
        ProcessSummaryBean processSummaryBean = new ProcessSummaryBean();

        if (C_ResultCdKbn.OK.toString().equals(outBean.getKekkastatus())
            && outBean.getProcessSummaryBeanList().size() > 0) {
            processSummaryBean = outBean.getProcessSummaryBeanList().get(0);
        }

        System.out.println(outBean.getKekkastatus());
        System.out.println(outBean.getSyousaimsgcd());
        System.out.println(outBean.getSyousaimsg());

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(),
            outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程履歴サマリ取得正常終了しました。", outBean.getSyousaimsg());
        assertEquals("検索件数>=1:", true, outBean.getProcessSummaryBeanList()
            .size() >= 1);
        assertEquals("フローＩＤ:", "09", processSummaryBean.getFlowId());
        assertEquals("業務キー:", "業務キー1_11",
            processSummaryBean.getGyoumukey());
        assertEquals("工程開始年月日:", "20160331",
            processSummaryBean.getKouteiKaisiYmd());
        assertEquals("工程完了年月日:", "20160404",
            processSummaryBean.getKouteikanryouYmd());
        assertEquals("工程状態:", "10", processSummaryBean.getProcessstatus());

        assertEquals("最終更新時間:", "20160415185446892",
            processSummaryBean.getUpdateTime());
        assertEquals("初回担当者ID:", "administrator",
            processSummaryBean.getFirstAccountId());
        assertEquals("前回担当者ID:", "administrator",
            processSummaryBean.getPreviousAccountId());
        assertEquals("前回ノード名:", "torikesi-check1",
            processSummaryBean.getPreviousNodeName());
        assertEquals("前回ノード名（ローカル名）:", "施設申込取消（書類審査１次）",
            processSummaryBean.getPreviousNodeLocalname());
        assertEquals("現在担当者ID", null, processSummaryBean.getCurrentAccountId());
        assertEquals("現在ノード名:", "torikesi-check1",
            processSummaryBean.getCurrentNodeName());

        assertEquals("追加パラメータ: 追加パラメータ１", "追加パラメータ１", processSummaryBean
            .getExtparamBean().getExtparam1());
        assertEquals("追加パラメータ: 追加パラメータ２", "追加パラメータ２", processSummaryBean
            .getExtparamBean().getExtparam2());
        assertEquals("追加パラメータ: 追加パラメータ３", "追加パラメータ３", processSummaryBean
            .getExtparamBean().getExtparam3());
        assertEquals("追加パラメータ: 追加パラメータ４", "追加パラメータ４", processSummaryBean
            .getExtparamBean().getExtparam4());
        assertEquals("追加パラメータ: 追加パラメータ５", "追加パラメータ５", processSummaryBean
            .getExtparamBean().getExtparam5());
        assertEquals("追加パラメータ: 追加パラメータ６", "追加パラメータ６", processSummaryBean
            .getExtparamBean().getExtparam6());
        assertEquals("追加パラメータ: 追加パラメータ７", "追加パラメータ７", processSummaryBean
            .getExtparamBean().getExtparam7());
        assertEquals("追加パラメータ: 追加パラメータ８", "追加パラメータ８", processSummaryBean
            .getExtparamBean().getExtparam8());
        assertEquals("追加パラメータ: 追加パラメータ９", "追加パラメータ９", processSummaryBean
            .getExtparamBean().getExtparam9());
        assertEquals("追加パラメータ: 追加パラメータ１０", "追加パラメータ１０", processSummaryBean
            .getExtparamBean().getExtparam10());
        assertEquals("追加パラメータ: 追加パラメータ１１", "追加パラメータ１１", processSummaryBean
            .getExtparamBean().getExtparam11());
        assertEquals("追加パラメータ: 追加パラメータ１２", "追加パラメータ１２", processSummaryBean
            .getExtparamBean().getExtparam12());
        assertEquals("追加パラメータ: 追加パラメータ１３", "追加パラメータ１３", processSummaryBean
            .getExtparamBean().getExtparam13());
        assertEquals("追加パラメータ: 追加パラメータ１４", "追加パラメータ１４", processSummaryBean
            .getExtparamBean().getExtparam14());
        assertEquals("追加パラメータ: 追加パラメータ１５", "追加パラメータ１５", processSummaryBean
            .getExtparamBean().getExtparam15());

    }

    @Test
    public void test_GetKouteiSummary_No3_1() {

        GetProcessSummaryInBean inBean = new GetProcessSummaryInBean();

        inBean.setGyoumukeys(new String[] { "GKID900000000000007" });
        inBean.setFlowid("98");

        GetProcessSummaryOutBean outBean = iwfKouteiClient
            .execGetProcessSummary(inBean);

        System.out.println(outBean.getKekkastatus());
        System.out.println(outBean.getSyousaimsgcd());
        System.out.println(outBean.getSyousaimsg());

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(),
            outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程履歴サマリ取得正常終了しました。", outBean.getSyousaimsg());
        assertEquals("検索件数:", 0, outBean.getProcessSummaryBeanList().size());

    }

    @Test
    public void test_GetKouteiSummary_No3_2() {

        GetProcessSummaryInBean inBean = new GetProcessSummaryInBean();

        inBean.setGyoumukeys(new String[] { "業務キー1_11", "業務キー2_4" });
        inBean.setFlowid("09");

        GetProcessSummaryOutBean outBean = iwfKouteiClient
            .execGetProcessSummary(inBean);

        System.out.println(outBean.getKekkastatus());
        System.out.println(outBean.getSyousaimsgcd());
        System.out.println(outBean.getSyousaimsg());

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(),
            outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程履歴サマリ取得正常終了しました。", outBean.getSyousaimsg());
        assertEquals("検索件数:", true,
            outBean.getProcessSummaryBeanList().size() >= 2);

    }

    @Test
    public void test_GetKouteiSummary_No3_3() {

        GetProcessSummaryInBean inBean = new GetProcessSummaryInBean();

        inBean.setGyoumukeys(new String[] { "業務キー1_11", "業務キー2_4" });
        inBean.setFlowid("09");
        inBean.setKekkajyougenkensu("1");

        GetProcessSummaryOutBean outBean = iwfKouteiClient
            .execGetProcessSummary(inBean);

        System.out.println(outBean.getKekkastatus());
        System.out.println(outBean.getSyousaimsgcd());
        System.out.println(outBean.getSyousaimsg());

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(),
            outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF2160", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "取得数が、上限件数を超えています。", outBean.getSyousaimsg());

    }

    @Test
    public void test_GetKouteiSummary_No3_4() {

        GetProcessSummaryInBean inBean = new GetProcessSummaryInBean();

        inBean.setGyoumukeys(new String[] { "業務キー1_11" });
        inBean.setFlowid("09");

        GetProcessSummaryOutBean outBean = iwfKouteiClient
            .execGetProcessSummary(inBean);

        ProcessSummaryBean processSummaryBean = new ProcessSummaryBean();
        if (C_ResultCdKbn.OK.toString().equals(outBean.getKekkastatus())
            && outBean.getProcessSummaryBeanList().size() > 0) {
            processSummaryBean = outBean.getProcessSummaryBeanList().get(0);
        }

        System.out.println(outBean.getKekkastatus());
        System.out.println(outBean.getSyousaimsgcd());
        System.out.println(outBean.getSyousaimsg());

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(),
            outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程履歴サマリ取得正常終了しました。", outBean.getSyousaimsg());

    }

    @Test
    public void test_GetKouteiSummary_No3_5() {

        GetProcessSummaryInBean inBean = new GetProcessSummaryInBean();

        inBean.setGyoumukeys(new String[] { "業務キー1_11", "業務キー2_4" });
        inBean.setFlowid("09");

        GetProcessSummaryOutBean outBean = iwfKouteiClient
            .execGetProcessSummary(inBean);

        System.out.println(outBean.getKekkastatus());
        System.out.println(outBean.getSyousaimsgcd());
        System.out.println(outBean.getSyousaimsg());

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(),
            outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程履歴サマリ取得正常終了しました。", outBean.getSyousaimsg());

    }

    @Test
    public void test_GetKouteiSummary_No3_7() {

        GetProcessSummaryInBean inBean = new GetProcessSummaryInBean();

        inBean.setGyoumukeys(new String[] { "業務キー1_11" });
        inBean.setFlowid("09");

        WSExtParam extParam1 = new WSExtParam();
        extParam1.setValues("追加パラメータ１");
        inBean.setExtParam1(extParam1);
        WSExtParam extParam2 = new WSExtParam();
        extParam2.setValues("追加パラメータ２");
        inBean.setExtParam2(extParam2);
        WSExtParam extParam3 = new WSExtParam();
        extParam3.setValues("追加パラメータ３");
        inBean.setExtParam3(extParam3);
        WSExtParam extParam4 = new WSExtParam();
        extParam4.setValues("追加パラメータ４");
        inBean.setExtParam4(extParam4);
        WSExtParam extParam5 = new WSExtParam();
        extParam5.setValues("追加パラメータ５");
        inBean.setExtParam5(extParam5);
        WSExtParam extParam6 = new WSExtParam();
        extParam6.setValues("追加パラメータ６");
        inBean.setExtParam6(extParam6);
        WSExtParam extParam7 = new WSExtParam();
        extParam7.setValues("追加パラメータ７");
        inBean.setExtParam7(extParam7);
        WSExtParam extParam8 = new WSExtParam();
        extParam8.setValues("追加パラメータ８");
        inBean.setExtParam8(extParam8);
        WSExtParam extParam9 = new WSExtParam();
        extParam9.setValues("追加パラメータ９");
        inBean.setExtParam9(extParam9);
        WSExtParam extParam10 = new WSExtParam();
        extParam10.setValues("追加パラメータ１０");
        inBean.setExtParam10(extParam10);
        WSExtParam extParam11 = new WSExtParam();
        extParam11.setValues("追加パラメータ１１");
        inBean.setExtParam11(extParam11);
        WSExtParam extParam12 = new WSExtParam();
        extParam12.setValues("追加パラメータ１２");
        inBean.setExtParam12(extParam12);
        WSExtParam extParam13 = new WSExtParam();
        extParam13.setValues("追加パラメータ１３");
        inBean.setExtParam13(extParam13);
        WSExtParam extParam14 = new WSExtParam();
        extParam14.setValues("追加パラメータ１４");
        inBean.setExtParam14(extParam14);
        WSExtParam extParam15 = new WSExtParam();
        extParam15.setValues("追加パラメータ１５");
        inBean.setExtParam15(extParam15);
        WSExtParam extParam16 = new WSExtParam();
        extParam16.setValues("追加パラメータ１６");
        inBean.setExtParam16(extParam16);
        WSExtParam extParam17 = new WSExtParam();
        extParam17.setValues("追加パラメータ１７");
        inBean.setExtParam17(extParam17);
        WSExtParam extParam18 = new WSExtParam();
        extParam18.setValues("追加パラメータ１８");
        inBean.setExtParam18(extParam18);
        WSExtParam extParam19 = new WSExtParam();
        extParam19.setValues("追加パラメータ１９");
        inBean.setExtParam19(extParam19);
        WSExtParam extParam20 = new WSExtParam();
        extParam20.setValues("追加パラメータ２０");
        inBean.setExtParam20(extParam20);
        WSExtParam extParam21 = new WSExtParam();
        extParam21.setValues("追加パラメータ２１");
        inBean.setExtParam21(extParam21);
        WSExtParam extParam22 = new WSExtParam();
        extParam22.setValues("追加パラメータ２２");
        inBean.setExtParam22(extParam22);
        WSExtParam extParam23 = new WSExtParam();
        extParam23.setValues("追加パラメータ２３");
        inBean.setExtParam23(extParam23);
        WSExtParam extParam24 = new WSExtParam();
        extParam24.setValues("追加パラメータ２４");
        inBean.setExtParam24(extParam24);
        WSExtParam extParam25 = new WSExtParam();
        extParam25.setValues("追加パラメータ２５");
        inBean.setExtParam25(extParam25);
        WSExtParam extParam26 = new WSExtParam();
        extParam26.setValues("追加パラメータ２６");
        inBean.setExtParam26(extParam26);
        WSExtParam extParam27 = new WSExtParam();
        extParam27.setValues("追加パラメータ２７");
        inBean.setExtParam27(extParam27);
        WSExtParam extParam28 = new WSExtParam();
        extParam28.setValues("追加パラメータ２８");
        inBean.setExtParam28(extParam28);
        WSExtParam extParam29 = new WSExtParam();
        extParam29.setValues("追加パラメータ２９");
        inBean.setExtParam29(extParam29);
        WSExtParam extParam30 = new WSExtParam();
        extParam30.setValues("追加パラメータ３０");
        inBean.setExtParam30(extParam30);

        GetProcessSummaryOutBean outBean = iwfKouteiClient
            .execGetProcessSummary(inBean);

        ProcessSummaryBean processSummaryBean = new ProcessSummaryBean();
        if (C_ResultCdKbn.OK.toString().equals(outBean.getKekkastatus())
            && outBean.getProcessSummaryBeanList().size() > 0) {
            processSummaryBean = outBean.getProcessSummaryBeanList().get(0);
        }

        System.out.println(outBean.getKekkastatus());
        System.out.println(outBean.getSyousaimsgcd());
        System.out.println(outBean.getSyousaimsg());

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(),
            outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程履歴サマリ取得正常終了しました。", outBean.getSyousaimsg());

        assertEquals(processSummaryBean.getExtparamBean().getExtparam1(), inBean.getExtParam1().getValue());
        assertEquals(processSummaryBean.getExtparamBean().getExtparam2(), inBean.getExtParam2().getValue());
        assertEquals(processSummaryBean.getExtparamBean().getExtparam3(), inBean.getExtParam3().getValue());
        assertEquals(processSummaryBean.getExtparamBean().getExtparam4(), inBean.getExtParam4().getValue());
        assertEquals(processSummaryBean.getExtparamBean().getExtparam5(), inBean.getExtParam5().getValue());
        assertEquals(processSummaryBean.getExtparamBean().getExtparam6(), inBean.getExtParam6().getValue());
        assertEquals(processSummaryBean.getExtparamBean().getExtparam7(), inBean.getExtParam7().getValue());
        assertEquals(processSummaryBean.getExtparamBean().getExtparam8(), inBean.getExtParam8().getValue());
        assertEquals(processSummaryBean.getExtparamBean().getExtparam9(), inBean.getExtParam9().getValue());
        assertEquals(processSummaryBean.getExtparamBean().getExtparam10(), inBean.getExtParam10().getValue());
        assertEquals(processSummaryBean.getExtparamBean().getExtparam11(), inBean.getExtParam11().getValue());
        assertEquals(processSummaryBean.getExtparamBean().getExtparam12(), inBean.getExtParam12().getValue());
        assertEquals(processSummaryBean.getExtparamBean().getExtparam13(), inBean.getExtParam13().getValue());
        assertEquals(processSummaryBean.getExtparamBean().getExtparam14(), inBean.getExtParam14().getValue());
        assertEquals(processSummaryBean.getExtparamBean().getExtparam15(), inBean.getExtParam15().getValue());
        assertEquals(processSummaryBean.getExtparamBean().getExtparam16(), inBean.getExtParam16().getValue());
        assertEquals(processSummaryBean.getExtparamBean().getExtparam17(), inBean.getExtParam17().getValue());
        assertEquals(processSummaryBean.getExtparamBean().getExtparam18(), inBean.getExtParam18().getValue());
        assertEquals(processSummaryBean.getExtparamBean().getExtparam19(), inBean.getExtParam19().getValue());
        assertEquals(processSummaryBean.getExtparamBean().getExtparam20(), inBean.getExtParam20().getValue());
        assertEquals(processSummaryBean.getExtparamBean().getExtparam21(), inBean.getExtParam21().getValue());
        assertEquals(processSummaryBean.getExtparamBean().getExtparam22(), inBean.getExtParam22().getValue());
        assertEquals(processSummaryBean.getExtparamBean().getExtparam23(), inBean.getExtParam23().getValue());
        assertEquals(processSummaryBean.getExtparamBean().getExtparam24(), inBean.getExtParam24().getValue());
        assertEquals(processSummaryBean.getExtparamBean().getExtparam25(), inBean.getExtParam25().getValue());
        assertEquals(processSummaryBean.getExtparamBean().getExtparam26(), inBean.getExtParam26().getValue());
        assertEquals(processSummaryBean.getExtparamBean().getExtparam27(), inBean.getExtParam27().getValue());
        assertEquals(processSummaryBean.getExtparamBean().getExtparam28(), inBean.getExtParam28().getValue());
        assertEquals(processSummaryBean.getExtparamBean().getExtparam29(), inBean.getExtParam29().getValue());
        assertEquals(processSummaryBean.getExtparamBean().getExtparam30(), inBean.getExtParam30().getValue());

    }

    @Test
    public void test_GetKouteiSummary_No3_8() {

        GetProcessSummaryInBean allInBean = new GetProcessSummaryInBean();
        allInBean.setGyoumukeys(new String[] { "業務キー1_11", "業務キー2_4" });
        allInBean.setFlowid("09");
        GetProcessSummaryOutBean allOutBean = iwfKouteiClient
            .execGetProcessSummary(allInBean);

        int allKouteiCount = allOutBean.getProcessSummaryBeanList().size();
        int NogenzaiAcdKouteiCount = 0;
        for(int i=0; i<allKouteiCount; i++){
            if(allOutBean.getProcessSummaryBeanList().get(i).getCurrentAccountId() == null){
                NogenzaiAcdKouteiCount++;
            }
        }

        GetProcessSummaryInBean inBean = new GetProcessSummaryInBean();
        inBean.setGyoumukeys(new String[] { "業務キー1_11", "業務キー2_4" });
        inBean.setFlowid("09");
        inBean.setAccountwariateumu("1");
        GetProcessSummaryOutBean outBean = iwfKouteiClient
            .execGetProcessSummary(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程履歴サマリ取得正常終了しました。", outBean.getSyousaimsg());
        assertEquals("検索件数:", false, (allKouteiCount > outBean.getProcessSummaryBeanList().size())
            && (NogenzaiAcdKouteiCount == outBean.getProcessSummaryBeanList().size()));
        for(int i = 0; i < outBean.getProcessSummaryBeanList().size(); i++){
            assertEquals("現在アカウントID無し",null,outBean.getProcessSummaryBeanList().get(i).getCurrentAccountId());
        }
    }

    @Test
    public void test_GetKouteiSummary_No3_10() {

        GetProcessSummaryInBean inBean = new GetProcessSummaryInBean();
        inBean.setGyoumukeys(new String[] { "業務キー1_11"});
        inBean.setFlowids(new String[] {"09" });
        inBean.setKouteikaisibifrom("20160331");
        inBean.setKouteikaisibito("20160412");
        inBean.setKouteikanryoubifrom("20160401");
        inBean.setKouteikanryoubito("20160417");
        inBean.setLastsyoritimefrom("20160415185446891");
        inBean.setLastsyoritimeto("20160415185446893");
        inBean.setSyoristatus(new String[] { "10", "99" });
        inBean.setAccountid(null);
        inBean.setNodename("torikesi-check1");
        inBean.setAccountwariateumu("1");

        GetProcessSummaryOutBean outBean = iwfKouteiClient.execGetProcessSummary(inBean);
        ProcessSummaryBean processSummaryBean = new ProcessSummaryBean();

        if (C_ResultCdKbn.OK.toString().equals(outBean.getKekkastatus())) {
            processSummaryBean = outBean.getProcessSummaryBeanList().get(0);
        }

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程履歴サマリ取得正常終了しました。", outBean.getSyousaimsg());
        assertEquals("検索件数=1:", true, outBean.getProcessSummaryBeanList()
            .size() == 1);
        assertEquals("工程開始年月日:", "20160331", processSummaryBean.getKouteiKaisiYmd());
        assertEquals("工程完了年月日:", "20160404", processSummaryBean.getKouteikanryouYmd());
        assertEquals("工程状態:", "10", processSummaryBean.getProcessstatus());
    }
}