package yuyu.common.biz.workflow;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.workflow.io.koutei.GetExecutableTasksByProcessInBean;
import yuyu.common.biz.workflow.io.koutei.GetExecutableTasksByProcessOutBean;
import yuyu.common.biz.workflow.io.koutei.sub.ExecutableTaskInfoBean;
import yuyu.common.workflowcore.core.webservice.common.WSCommonIOKey;
import yuyu.common.workflowcore.core.webservice.common.WSExtParam;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getexecutabletasksbyprocess.WSGetExecutableTasksByProcess;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getexecutabletasksbyprocess.WSGetExecutableTasksByProcessRequest;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;
import yuyu.testinfr.TestOrder;

/**
 * 実行可能タスク件数取得(工程指定)Webサービスのゲットメソッド {@link WSGetExecutableTasksByProcess#executeBizMain(WSGetExecutableTasksByProcessRequest)} テスト用クラスです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class GetExecutableTasksByProcessWebServiceTest {

    @Inject
    IwfKouteiClient iwfKouteiClient;

    @Inject
    private IwfCoreDomManager iwfCoreDomManager;

    //    @BeforeClass
    //    public static void changeUser() {
    //
    //        BaseUserInfo baseUserInfo = SWAKInjector.getInstance(BaseUserInfo.class);
    //
    //        BaseDomManager manager = SWAKInjector.getInstance(BaseDomManager.class);
    //
    //        AM_User am_user = manager.getUser("Junit");
    //
    //        YuyuFunctionTestUtil.changeCurrentUser(baseUserInfo, am_user);
    //        baseUserInfo.refresh();
    //    }
    //

    @Test(expected=RuntimeException.class)
    @TestOrder(1)
    public void test_GetExecutableTasksByProcess_01() {
        GetExecutableTasksByProcessInBean inBean = null;
        iwfKouteiClient.execGetExecutableTasksByProcess(inBean);
    }

    @Test
    @TestOrder(2)
    public void test_GetExecutableTasksByProcess_02() {
        GetExecutableTasksByProcessInBean inBean = new GetExecutableTasksByProcessInBean();
        GetExecutableTasksByProcessOutBean outBean = iwfKouteiClient.execGetExecutableTasksByProcess(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "必須入力チェックエラー：アカウントID", outBean.getSyousaimsg());
    }

    @Test
    @TestOrder(3)
    public void test_GetExecutableTasksByProcess_03() {
        String psAccountid = "Tt";

        String sKouteikaisiYmdFrom = "20140102";
        String sKouteikaisiYmdTo = null;

        GetExecutableTasksByProcessInBean inBean = new GetExecutableTasksByProcessInBean();
        inBean.setAccountid(psAccountid);
        inBean.setKouteikaisiYmdFrom(sKouteikaisiYmdFrom);
        inBean.setKouteikaisiYmdTo(sKouteikaisiYmdTo);

        GetExecutableTasksByProcessOutBean outBean = iwfKouteiClient.execGetExecutableTasksByProcess(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF4024", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程開始年月日(自)と工程開始年月日(至)の両方を入力してください。", outBean.getSyousaimsg());
    }

    @Test
    @TestOrder(4)
    public void test_GetExecutableTasksByProcess_04() {
        try {

            String psAccountid = "Tt";

            String sKouteikaisiYmdFrom = null;
            String sKouteikaisiYmdTo = "20140102";

            GetExecutableTasksByProcessInBean inBean = new GetExecutableTasksByProcessInBean();
            inBean.setAccountid(psAccountid);
            inBean.setKouteikaisiYmdFrom(sKouteikaisiYmdFrom);
            inBean.setKouteikaisiYmdTo(sKouteikaisiYmdTo);

            GetExecutableTasksByProcessOutBean outBean = iwfKouteiClient.execGetExecutableTasksByProcess(inBean);

            assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
            assertEquals("詳細メッセージコード:", "IWF4024", outBean.getSyousaimsgcd());
            assertEquals("詳細メッセージ:", "工程開始年月日(自)と工程開始年月日(至)の両方を入力してください。", outBean.getSyousaimsg());

        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

    @Test
    @TestOrder(5)
    public void test_GetExecutableTasksByProcess_05() {
        String psAccountid = "Tt";

        String sKouteikanryouYmdFrom_ = "20140102";
        String sKouteikanryouYmdTo_ = null;

        GetExecutableTasksByProcessInBean inBean = new GetExecutableTasksByProcessInBean();
        inBean.setAccountid(psAccountid);
        inBean.setKouteikanryouYmdFrom(sKouteikanryouYmdFrom_);
        inBean.setKouteikanryouYmdTo(sKouteikanryouYmdTo_);

        GetExecutableTasksByProcessOutBean outBean = iwfKouteiClient.execGetExecutableTasksByProcess(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF4025", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程完了年月日(自)と工程完了年月日(至)の両方を入力してください。", outBean.getSyousaimsg());
    }

    @Test
    @TestOrder(6)
    public void test_GetExecutableTasksByProcess_06() {
        String psAccountid = "Tt";

        String sKouteikanryouYmdFrom_ = null;
        String sKouteikanryouYmdTo_ = "20140102";

        GetExecutableTasksByProcessInBean inBean = new GetExecutableTasksByProcessInBean();
        inBean.setAccountid(psAccountid);
        inBean.setKouteikanryouYmdFrom(sKouteikanryouYmdFrom_);
        inBean.setKouteikanryouYmdTo(sKouteikanryouYmdTo_);

        GetExecutableTasksByProcessOutBean outBean = iwfKouteiClient.execGetExecutableTasksByProcess(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF4025", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程完了年月日(自)と工程完了年月日(至)の両方を入力してください。", outBean.getSyousaimsg());
    }

    @Test
    @TestOrder(7)
    public void test_GetExecutableTasksByProcess_07() {
        try {

            String psAccountid = "etss1016";

            String sKouteikaisiYmdFrom = "20120102";
            String sKouteikaisiYmdTo = "20160102";

            String sKouteikanryouYmdFrom_ = "20120102";
            String sKouteikanryouYmdTo_ = "20160102";
            String[] psSyoriStatus = { "10", "90", "99" };

            WSExtParam extParam = new WSExtParam();
            extParam.setValues("20010427101307068222");
            Map<String, WSExtParam> extParamMap = new HashMap<String, WSExtParam>();
            extParamMap.put(WSCommonIOKey.IN.sS_EXTPARAM1, extParam);

            GetExecutableTasksByProcessInBean inBean = new GetExecutableTasksByProcessInBean();
            inBean.setAccountid(psAccountid);
            inBean.setKouteikaisiYmdFrom(sKouteikaisiYmdFrom);
            inBean.setKouteikaisiYmdTo(sKouteikaisiYmdTo);
            inBean.setKouteikanryouYmdFrom(sKouteikanryouYmdFrom_);
            inBean.setKouteikanryouYmdTo(sKouteikanryouYmdTo_);
            inBean.setSyoriStatus(psSyoriStatus);
            inBean.setExtParam1(extParam);

            GetExecutableTasksByProcessOutBean outBean = iwfKouteiClient.execGetExecutableTasksByProcess(inBean);

            assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
            assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
            assertEquals("詳細メッセージ:", "実行可能タスク情報取得サービス正常終了しました。", outBean.getSyousaimsg());
            assertEquals("検索件数:", true, outBean.getExecutableTaskInfos().size() == 0);

        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

    @Test
    @TestOrder(8)
    public void test_GetExecutableTasksByProcess_08() {
        String psAccountid = "administrator";

        String sKouteikaisiYmdFrom = "20120102";
        String sKouteikaisiYmdTo = "20170102";

        GetExecutableTasksByProcessInBean inBean = new GetExecutableTasksByProcessInBean();
        inBean.setAccountid(psAccountid);
        inBean.setKouteikaisiYmdFrom(sKouteikaisiYmdFrom);
        inBean.setKouteikaisiYmdTo(sKouteikaisiYmdTo);
        GetExecutableTasksByProcessOutBean outBean = iwfKouteiClient.execGetExecutableTasksByProcess(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "実行可能タスク情報取得サービス正常終了しました。", outBean.getSyousaimsg());

        assertEquals("検索件数:", true, outBean.getExecutableTaskInfos().size() >= 1);
        ExecutableTaskInfoBean bean = outBean.getExecutableTaskInfos().get(0);
        assertEquals("フローID:", "simpleTask4", bean.getFlowId());
        assertEquals("ノード名:", "tennis2", bean.getNodeName());
        assertEquals("共有タスク数:", "0", bean.getTaskCountKyouyuu());
        assertEquals("個人タスク数:", "0", bean.getTaskCountKojin());
    }

    @Test
    @TestOrder(9)
    public void test_GetExecutableTasksByProcess_09() {
        String psAccountid = "administrator";

        String sKouteikanryouYmdFrom_ = "20010102";
        String sKouteikanryouYmdTo_ = "20180102";
        String[] psSyoriStatus = { "10", "90", "99" };

        GetExecutableTasksByProcessInBean inBean = new GetExecutableTasksByProcessInBean();
        inBean.setAccountid(psAccountid);
        inBean.setKouteikanryouYmdFrom(sKouteikanryouYmdFrom_);
        inBean.setKouteikanryouYmdTo(sKouteikanryouYmdTo_);
        inBean.setSyoriStatus(psSyoriStatus);
        GetExecutableTasksByProcessOutBean outBean = iwfKouteiClient.execGetExecutableTasksByProcess(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "実行可能タスク情報取得サービス正常終了しました。", outBean.getSyousaimsg());
        assertEquals("検索件数:", true, outBean.getExecutableTaskInfos().size() >= 1);
    }

    @Test
    @TestOrder(10)
    public void test_GetExecutableTasksByProcess_10() {
        String psAccountid = "administrator";
        String[] psSyoriStatus = { "10", "90", "99" };
        String[] flowIds = { "09" };

        WSExtParam extParam = new WSExtParam();
        extParam.setValues("20010427101307068");
        Map<String, WSExtParam> extParamMap = new HashMap<String, WSExtParam>();
        extParamMap.put(WSCommonIOKey.IN.sS_EXTPARAM1, extParam);

        GetExecutableTasksByProcessInBean inBean = new GetExecutableTasksByProcessInBean();
        inBean.setAccountid(psAccountid);
        inBean.setSyoriStatus(psSyoriStatus);
        //inBean.setExtParam1(extParam);
        inBean.setFlowIds(flowIds);

        GetExecutableTasksByProcessOutBean outBean = iwfKouteiClient.execGetExecutableTasksByProcess(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "実行可能タスク情報取得サービス正常終了しました。", outBean.getSyousaimsg());
        assertEquals("検索件数:", true, outBean.getExecutableTaskInfos().size() > 0);
    }

    @Test
    @TestOrder(11)
    public void test_GetExecutableTasksByProcess_11() {
        String psAccountid = "sinx";

        String sKouteikaisiYmdFrom = "20100102";
        String sKouteikaisiYmdTo = "20150102";

        GetExecutableTasksByProcessInBean inBean = new GetExecutableTasksByProcessInBean();
        inBean.setAccountid(psAccountid);
        inBean.setKouteikaisiYmdFrom(sKouteikaisiYmdFrom);
        inBean.setKouteikaisiYmdTo(sKouteikaisiYmdTo);

        GetExecutableTasksByProcessOutBean outBean = iwfKouteiClient.execGetExecutableTasksByProcess(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF2070", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "権限IDが取得できませんでした。", outBean.getSyousaimsg());
    }

    @Test
    public void test_GetExecutableTasksByProcess_12() {
        String psAccountid = "administrator";
        String[] psSyoriStatus = { "10", "90", "99" };
        String[] flowIds = { "09" };

        WSExtParam poExtparam1 = new WSExtParam();
        poExtparam1.setValues("追加パラメータ１");
        WSExtParam poExtparam2 = new WSExtParam();
        poExtparam2.setValues("追加パラメータ２");
        WSExtParam poExtparam3 = new WSExtParam();
        poExtparam3.setValues("追加パラメータ３");
        WSExtParam poExtparam4 = new WSExtParam();
        poExtparam4.setValues("追加パラメータ４");
        WSExtParam poExtparam5 = new WSExtParam();
        poExtparam5.setValues("追加パラメータ５");
        WSExtParam poExtparam6 = new WSExtParam();
        poExtparam6.setValues("追加パラメータ６");
        WSExtParam poExtparam7 = new WSExtParam();
        poExtparam7.setValues("追加パラメータ７");
        WSExtParam poExtparam8 = new WSExtParam();
        poExtparam8.setValues("追加パラメータ８");
        WSExtParam poExtparam9 = new WSExtParam();
        poExtparam9.setValues("追加パラメータ９");
        WSExtParam poExtparam10 = new WSExtParam();
        poExtparam10.setValues("追加パラメータ１０");
        WSExtParam poExtparam11 = new WSExtParam();
        poExtparam11.setValues("追加パラメータ１１");
        WSExtParam poExtparam12 = new WSExtParam();
        poExtparam12.setValues("追加パラメータ１２");
        WSExtParam poExtparam13 = new WSExtParam();
        poExtparam13.setValues("追加パラメータ１３");
        WSExtParam poExtparam14 = new WSExtParam();
        poExtparam14.setValues("追加パラメータ１４");
        WSExtParam poExtparam15 = new WSExtParam();
        poExtparam15.setValues("追加パラメータ１５");
        WSExtParam poExtparam16 = new WSExtParam();
        poExtparam16.setValues("追加パラメータ１６");
        WSExtParam poExtparam17 = new WSExtParam();
        poExtparam17.setValues("追加パラメータ１７");
        WSExtParam poExtparam18 = new WSExtParam();
        poExtparam18.setValues("追加パラメータ１８");
        WSExtParam poExtparam19 = new WSExtParam();
        poExtparam19.setValues("追加パラメータ１９");
        WSExtParam poExtparam20 = new WSExtParam();
        poExtparam20.setValues("追加パラメータ２０");
        WSExtParam poExtparam21 = new WSExtParam();
        poExtparam21.setValues("追加パラメータ２１");
        WSExtParam poExtparam22 = new WSExtParam();
        poExtparam22.setValues("追加パラメータ２２");
        WSExtParam poExtparam23 = new WSExtParam();
        poExtparam23.setValues("追加パラメータ２３");
        WSExtParam poExtparam24 = new WSExtParam();
        poExtparam24.setValues("追加パラメータ２４");
        WSExtParam poExtparam25 = new WSExtParam();
        poExtparam25.setValues("追加パラメータ２５");
        WSExtParam poExtparam26 = new WSExtParam();
        poExtparam26.setValues("追加パラメータ２６");
        WSExtParam poExtparam27 = new WSExtParam();
        poExtparam27.setValues("追加パラメータ２７");
        WSExtParam poExtparam28 = new WSExtParam();
        poExtparam28.setValues("追加パラメータ２８");
        WSExtParam poExtparam29 = new WSExtParam();
        poExtparam29.setValues("追加パラメータ２９");
        WSExtParam poExtparam30 = new WSExtParam();
        poExtparam30.setValues("追加パラメータ３０");

        GetExecutableTasksByProcessInBean inBean = new GetExecutableTasksByProcessInBean();
        inBean.setAccountid(psAccountid);
        inBean.setSyoriStatus(psSyoriStatus);
        inBean.setFlowIds(flowIds);

        inBean.setExtParam1(poExtparam1);
        inBean.setExtParam2(poExtparam2);
        inBean.setExtParam3(poExtparam3);
        inBean.setExtParam4(poExtparam4);
        inBean.setExtParam5(poExtparam5);
        inBean.setExtParam6(poExtparam6);
        inBean.setExtParam7(poExtparam7);
        inBean.setExtParam8(poExtparam8);
        inBean.setExtParam9(poExtparam9);
        inBean.setExtParam10(poExtparam10);
        inBean.setExtParam11(poExtparam11);
        inBean.setExtParam12(poExtparam12);
        inBean.setExtParam13(poExtparam13);
        inBean.setExtParam14(poExtparam14);
        inBean.setExtParam15(poExtparam15);
        inBean.setExtParam16(poExtparam16);
        inBean.setExtParam17(poExtparam17);
        inBean.setExtParam18(poExtparam18);
        inBean.setExtParam19(poExtparam19);
        inBean.setExtParam20(poExtparam20);
        inBean.setExtParam21(poExtparam21);
        inBean.setExtParam22(poExtparam22);
        inBean.setExtParam23(poExtparam23);
        inBean.setExtParam24(poExtparam24);
        inBean.setExtParam25(poExtparam25);
        inBean.setExtParam26(poExtparam26);
        inBean.setExtParam27(poExtparam27);
        inBean.setExtParam28(poExtparam28);
        inBean.setExtParam29(poExtparam29);
        inBean.setExtParam30(poExtparam30);

        GetExecutableTasksByProcessOutBean outBean = iwfKouteiClient.execGetExecutableTasksByProcess(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "実行可能タスク情報取得サービス正常終了しました。", outBean.getSyousaimsg());
        assertEquals("検索件数:", true, outBean.getExecutableTaskInfos().size() > 0);
    }

    @Test
    public void test_GetExecutableTasksByProcess_13() {
        String psAccountid = "administrator";
        String[] psSyoriStatus = { "10","90","99" };
        String[] flowIds = { "09" };
        WSExtParam poExtparam16 = new WSExtParam();
        poExtparam16.setValues("追加パラメータ１７");

        GetExecutableTasksByProcessInBean inBean = new GetExecutableTasksByProcessInBean();
        inBean.setAccountid(psAccountid);
        inBean.setSyoriStatus(psSyoriStatus);
        inBean.setFlowIds(flowIds);
        //inBean.setExtParam16(poExtparam16);

        GetExecutableTasksByProcessOutBean outBean = iwfKouteiClient.execGetExecutableTasksByProcess(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "実行可能タスク情報取得サービス正常終了しました。", outBean.getSyousaimsg());
        assertEquals("検索件数:", true, outBean.getExecutableTaskInfos().size() > 0);
        for(int i=0;i<outBean.getExecutableTaskInfos().size();i++){
            ExecutableTaskInfoBean taskBean =outBean.getExecutableTaskInfos().get(i);
            assertEquals("フローID:"+i, true, taskBean.getFlowId() != null && taskBean.getFlowId() != "");
            assertEquals("タスク名:"+i, true, taskBean.getNodeName() != null && taskBean.getNodeName() != "");
            assertEquals("個人タスク数:"+i, true, taskBean.getTaskCountKojin() == "0");
            assertEquals("共有タスク数:"+i, true, taskBean.getTaskCountKyouyuu() == "0");
        }
    }

    @Test
    public void test_GetExecutableTasksByProcess_14() {
        String psAccountid = "sin";

        String sKouteikaisiYmdFrom = "20160331";
        String sKouteikaisiYmdTo = "20150402";
        String sKouteikanryouYmdFrom_ = "20150401";
        String sKouteikanryouYmdTo_ = "20150405";

        GetExecutableTasksByProcessInBean inBean = new GetExecutableTasksByProcessInBean();
        inBean.setAccountid(psAccountid);
        inBean.setKouteikaisiYmdFrom(sKouteikaisiYmdFrom);
        inBean.setKouteikaisiYmdTo(sKouteikaisiYmdTo);
        inBean.setKouteikanryouYmdFrom(sKouteikanryouYmdFrom_);
        inBean.setKouteikanryouYmdTo(sKouteikanryouYmdTo_);

        GetExecutableTasksByProcessOutBean outBean = iwfKouteiClient.execGetExecutableTasksByProcess(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "実行可能タスク情報取得サービス正常終了しました。", outBean.getSyousaimsg());
    }
}
