package yuyu.common.biz.workflow;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDate;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.workflow.io.koutei.LockProcessInBean;
import yuyu.common.biz.workflow.io.koutei.LockProcessOutBean;
import yuyu.common.biz.workflow.io.koutei.ProcessCancelInBean;
import yuyu.common.biz.workflow.io.koutei.ProcessCancelOutBean;
import yuyu.common.biz.workflow.io.koutei.ProcessCreateInBean;
import yuyu.common.biz.workflow.io.koutei.ProcessCreateOutBean;
import yuyu.common.biz.workflow.io.koutei.ProcessUpdateInBean;
import yuyu.common.biz.workflow.io.koutei.ProcessUpdateOutBean;
import yuyu.common.workflowcore.core.webservice.common.WSExtParam;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocessupdate.WSExecProcessUpdate;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocessupdate.WSExecProcessUpdateRequest;
import yuyu.def.classification.C_IwfSyoriKbn;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.def.classification.C_RirekiKbn;
import yuyu.def.db.entity.WT_KouteiRireki;
import yuyu.def.db.entity.WT_KouteiSummary;
import yuyu.def.workflowcore.configration.IwfCoreConfig;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;

/**
 * 工程情報更新Webサービス {@link WSExecProcessUpdate#executeBizMain(WSExecProcessUpdateRequest)} テスト用クラスです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class ProcessUpdateWebServiceTest {

    @Inject
    IwfKouteiClient iwfKouteiClient;

    @Inject
    private IwfCoreDomManager iwfCoreDomManager;

    @Test(expected = RuntimeException.class)
    public void testValidationNG01() {

        ProcessUpdateInBean inBean = null;

        iwfKouteiClient.execProcessUpdate(inBean);

    }

    @Test
    public void testValidationNG02() {
        String psGyoumukey = null;
        String psFlowid = "tt4";
        String psAccountid = "JUnit";
        String psLockkey = "ロックキー1_2";
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        String psExtinfo = "付加情報";
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", psExtinfo);
        poExtinfoMapList.add(poExtinfoMap);
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

        ProcessUpdateInBean inBean = new ProcessUpdateInBean();
        inBean.setGyoumukey(psGyoumukey);
        inBean.setFlowid(psFlowid);
        inBean.setAccountid(psAccountid);
        inBean.setLockkey(psLockkey);
        inBean.setExtInfo(poExtinfoMapList);
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

        ProcessUpdateOutBean outBean = iwfKouteiClient.execProcessUpdate(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "必須入力チェックエラー：業務キー", outBean.getSyousaimsg());

    }

    @Test
    public void testValidationNG03() {
        String psGyoumukey = "";
        String psFlowid = "tt4";
        String psAccountid = "JUnit";
        String psLockkey = "ロックキー1_2";
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        String psExtinfo = "付加情報";
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", psExtinfo);
        poExtinfoMapList.add(poExtinfoMap);
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

        ProcessUpdateInBean inBean = new ProcessUpdateInBean();
        inBean.setGyoumukey(psGyoumukey);
        inBean.setFlowid(psFlowid);
        inBean.setAccountid(psAccountid);
        inBean.setLockkey(psLockkey);
        inBean.setExtInfo(poExtinfoMapList);
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

        ProcessUpdateOutBean outBean = iwfKouteiClient.execProcessUpdate(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "必須入力チェックエラー：業務キー", outBean.getSyousaimsg());

    }

    @Test
    public void testValidationNG04() {
        String psGyoumukey = "業務キー1_4";
        String psFlowid = null;
        String psAccountid = "JUnit";
        String psLockkey = "ロックキー1_2";
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        String psExtinfo = "付加情報";
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", psExtinfo);
        poExtinfoMapList.add(poExtinfoMap);
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

        ProcessUpdateInBean inBean = new ProcessUpdateInBean();
        inBean.setGyoumukey(psGyoumukey);
        inBean.setFlowid(psFlowid);
        inBean.setAccountid(psAccountid);
        inBean.setLockkey(psLockkey);
        inBean.setExtInfo(poExtinfoMapList);
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

        ProcessUpdateOutBean outBean = iwfKouteiClient.execProcessUpdate(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "必須入力チェックエラー：フローＩＤ", outBean.getSyousaimsg());

    }

    @Test
    public void testValidationNG05() {
        String psGyoumukey = "業務キー1_5";
        String psFlowid = "";
        String psAccountid = "JUnit";
        String psLockkey = "ロックキー1_2";
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        String psExtinfo = "付加情報";
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", psExtinfo);
        poExtinfoMapList.add(poExtinfoMap);
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

        ProcessUpdateInBean inBean = new ProcessUpdateInBean();
        inBean.setGyoumukey(psGyoumukey);
        inBean.setFlowid(psFlowid);
        inBean.setAccountid(psAccountid);
        inBean.setLockkey(psLockkey);
        inBean.setExtInfo(poExtinfoMapList);
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

        ProcessUpdateOutBean outBean = iwfKouteiClient.execProcessUpdate(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "必須入力チェックエラー：フローＩＤ", outBean.getSyousaimsg());

    }

    @Test
    public void testValidationOK01() throws Exception {

        boolean lockYouhi = IwfCoreConfig.getInstance().isLockYouhi();
        IwfCoreConfig.getInstance().setLockYouhi(false);

        String pGyoumukey = BizDate.getSysDateTimeMilli();

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setGyoumukey(pGyoumukey);
        befProcessCreateInBean.setFlowid("tt4");
        befProcessCreateInBean.setAccountid("JUnit");
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        String psFlowid = "tt4";
        String psAccountid = "JUnit";
        String psLockkey = null;
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        String psExtinfo = null;
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", psExtinfo);
        poExtinfoMapList.add(poExtinfoMap);
        WSExtParam poExtparam1 = new WSExtParam();
        poExtparam1.setValues(null);
        WSExtParam poExtparam2 = new WSExtParam();
        poExtparam2.setValues(null);
        WSExtParam poExtparam3 = new WSExtParam();
        poExtparam3.setValues(null);
        WSExtParam poExtparam4 = new WSExtParam();
        poExtparam4.setValues(null);
        WSExtParam poExtparam5 = new WSExtParam();
        poExtparam5.setValues(null);
        WSExtParam poExtparam6 = new WSExtParam();
        poExtparam6.setValues(null);
        WSExtParam poExtparam7 = new WSExtParam();
        poExtparam7.setValues(null);
        WSExtParam poExtparam8 = new WSExtParam();
        poExtparam8.setValues(null);
        WSExtParam poExtparam9 = new WSExtParam();
        poExtparam9.setValues(null);
        WSExtParam poExtparam10 = new WSExtParam();
        poExtparam10.setValues(null);
        WSExtParam poExtparam11 = new WSExtParam();
        poExtparam11.setValues(null);
        WSExtParam poExtparam12 = new WSExtParam();
        poExtparam12.setValues(null);
        WSExtParam poExtparam13 = new WSExtParam();
        poExtparam13.setValues(null);
        WSExtParam poExtparam14 = new WSExtParam();
        poExtparam14.setValues(null);
        WSExtParam poExtparam15 = new WSExtParam();
        poExtparam15.setValues(null);

        ProcessUpdateInBean inBean = new ProcessUpdateInBean();
        inBean.setGyoumukey(pGyoumukey);
        inBean.setFlowid(psFlowid);
        inBean.setAccountid(psAccountid);
        inBean.setLockkey(psLockkey);
        inBean.setExtInfo(poExtinfoMapList);
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

        ProcessUpdateOutBean outBean = iwfKouteiClient.execProcessUpdate(inBean);

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey(pGyoumukey);
        aftProcessCancelInBean.setFlowid("tt4");
        aftProcessCancelInBean.setAccountid("JUnit");
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

        IwfCoreConfig.getInstance().setLockYouhi(lockYouhi);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程情報更新正常終了しました。", outBean.getSyousaimsg());


    }

    @Test
    public void testValidationOK02() throws Exception {
        boolean lockYouhi = IwfCoreConfig.getInstance().isLockYouhi();
        IwfCoreConfig.getInstance().setLockYouhi(false);

        String pGyoumukey = BizDate.getSysDateTimeMilli();

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setGyoumukey(pGyoumukey);
        befProcessCreateInBean.setFlowid("tt4");
        befProcessCreateInBean.setAccountid("JUnit");
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        String psFlowid = "tt4";
        String psAccountid = "JUnit";
        String psLockkey = "";
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        String psExtinfo = "";
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", psExtinfo);
        poExtinfoMapList.add(poExtinfoMap);
        WSExtParam poExtparam1 = new WSExtParam();
        poExtparam1.setValues("");
        WSExtParam poExtparam2 = new WSExtParam();
        poExtparam2.setValues("");
        WSExtParam poExtparam3 = new WSExtParam();
        poExtparam3.setValues("");
        WSExtParam poExtparam4 = new WSExtParam();
        poExtparam4.setValues("");
        WSExtParam poExtparam5 = new WSExtParam();
        poExtparam5.setValues("");
        WSExtParam poExtparam6 = new WSExtParam();
        poExtparam6.setValues("");
        WSExtParam poExtparam7 = new WSExtParam();
        poExtparam7.setValues("");
        WSExtParam poExtparam8 = new WSExtParam();
        poExtparam8.setValues("");
        WSExtParam poExtparam9 = new WSExtParam();
        poExtparam9.setValues("");
        WSExtParam poExtparam10 = new WSExtParam();
        poExtparam10.setValues("");
        WSExtParam poExtparam11 = new WSExtParam();
        poExtparam11.setValues("");
        WSExtParam poExtparam12 = new WSExtParam();
        poExtparam12.setValues("");
        WSExtParam poExtparam13 = new WSExtParam();
        poExtparam13.setValues("");
        WSExtParam poExtparam14 = new WSExtParam();
        poExtparam14.setValues("");
        WSExtParam poExtparam15 = new WSExtParam();
        poExtparam15.setValues("");

        ProcessUpdateInBean inBean = new ProcessUpdateInBean();
        inBean.setGyoumukey(pGyoumukey);
        inBean.setFlowid(psFlowid);
        inBean.setAccountid(psAccountid);
        inBean.setLockkey(psLockkey);
        inBean.setExtInfo(poExtinfoMapList);
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

        ProcessUpdateOutBean outBean = iwfKouteiClient.execProcessUpdate(inBean);

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey(pGyoumukey);
        aftProcessCancelInBean.setFlowid("tt4");
        aftProcessCancelInBean.setAccountid("JUnit");
        aftProcessCancelInBean.setLockkey("ロックキー1_9");
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

        IwfCoreConfig.getInstance().setLockYouhi(lockYouhi);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程情報更新正常終了しました。", outBean.getSyousaimsg());

    }

    @Test
    public void testValidationNG06() {

        boolean lockYouhi = IwfCoreConfig.getInstance().isLockYouhi();
        IwfCoreConfig.getInstance().setLockYouhi(true);
        ProcessUpdateInBean processUpdateInBean = new ProcessUpdateInBean();
        processUpdateInBean.setGyoumukey("業務キー1_10");
        processUpdateInBean.setFlowid("tt4");
        processUpdateInBean.setAccountid("JUnit");
        processUpdateInBean.setLockkey(null);
        List<Map<String, String>> extinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> extinfoMap = new HashMap<String, String>();
        extinfoMap.put("extinfo", "付加情報");
        extinfoMapList.add(extinfoMap);
        processUpdateInBean.setExtInfo(extinfoMapList);
        WSExtParam extParam1 = new WSExtParam();
        extParam1.setValues("追加パラメータ１");
        processUpdateInBean.setExtParam1(extParam1);
        WSExtParam extParam2 = new WSExtParam();
        extParam2.setValues("追加パラメータ２");
        processUpdateInBean.setExtParam2(extParam2);
        WSExtParam extParam3 = new WSExtParam();
        extParam3.setValues("追加パラメータ３");
        processUpdateInBean.setExtParam3(extParam3);
        WSExtParam extParam4 = new WSExtParam();
        extParam4.setValues("追加パラメータ４");
        processUpdateInBean.setExtParam4(extParam4);
        WSExtParam extParam5 = new WSExtParam();
        extParam5.setValues("追加パラメータ５");
        processUpdateInBean.setExtParam5(extParam5);
        WSExtParam extParam6 = new WSExtParam();
        extParam6.setValues("追加パラメータ６");
        processUpdateInBean.setExtParam6(extParam6);
        WSExtParam extParam7 = new WSExtParam();
        extParam7.setValues("追加パラメータ７");
        processUpdateInBean.setExtParam7(extParam7);
        WSExtParam extParam8 = new WSExtParam();
        extParam8.setValues("追加パラメータ８");
        processUpdateInBean.setExtParam8(extParam8);
        WSExtParam extParam9 = new WSExtParam();
        extParam9.setValues("追加パラメータ９");
        processUpdateInBean.setExtParam9(extParam9);
        WSExtParam extParam10 = new WSExtParam();
        extParam10.setValues("追加パラメータ１０");
        processUpdateInBean.setExtParam10(extParam10);
        WSExtParam extParam11 = new WSExtParam();
        extParam11.setValues("追加パラメータ１１");
        processUpdateInBean.setExtParam11(extParam11);
        WSExtParam extParam12 = new WSExtParam();
        extParam12.setValues("追加パラメータ１２");
        processUpdateInBean.setExtParam12(extParam12);
        WSExtParam extParam13 = new WSExtParam();
        extParam13.setValues("追加パラメータ１３");
        processUpdateInBean.setExtParam13(extParam13);
        WSExtParam extParam14 = new WSExtParam();
        extParam14.setValues("追加パラメータ１４");
        processUpdateInBean.setExtParam14(extParam14);
        WSExtParam extParam15 = new WSExtParam();
        extParam15.setValues("追加パラメータ１５");
        processUpdateInBean.setExtParam15(extParam15);
        ProcessUpdateOutBean processUpdateOutBean = iwfKouteiClient.execProcessUpdate(processUpdateInBean);

        IwfCoreConfig.getInstance().setLockYouhi(lockYouhi);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), processUpdateOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", processUpdateOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "必須入力チェックエラー：ロックキー", processUpdateOutBean.getSyousaimsg());

    }

    @Test
    public void testValidationNG07() {

        boolean lockYouhi = IwfCoreConfig.getInstance().isLockYouhi();
        IwfCoreConfig.getInstance().setLockYouhi(true);
        ProcessUpdateInBean processUpdateInBean = new ProcessUpdateInBean();
        processUpdateInBean.setGyoumukey("業務キー1_11");
        processUpdateInBean.setFlowid("tt4");
        processUpdateInBean.setAccountid("JUnit");
        processUpdateInBean.setLockkey("");
        List<Map<String, String>> extinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> extinfoMap = new HashMap<String, String>();
        extinfoMap.put("extinfo", "付加情報");
        extinfoMapList.add(extinfoMap);
        processUpdateInBean.setExtInfo(extinfoMapList);
        WSExtParam extParam1 = new WSExtParam();
        extParam1.setValues("追加パラメータ１");
        processUpdateInBean.setExtParam1(extParam1);
        WSExtParam extParam2 = new WSExtParam();
        extParam2.setValues("追加パラメータ２");
        processUpdateInBean.setExtParam2(extParam2);
        WSExtParam extParam3 = new WSExtParam();
        extParam3.setValues("追加パラメータ３");
        processUpdateInBean.setExtParam3(extParam3);
        WSExtParam extParam4 = new WSExtParam();
        extParam4.setValues("追加パラメータ４");
        processUpdateInBean.setExtParam4(extParam4);
        WSExtParam extParam5 = new WSExtParam();
        extParam5.setValues("追加パラメータ５");
        processUpdateInBean.setExtParam5(extParam5);
        WSExtParam extParam6 = new WSExtParam();
        extParam6.setValues("追加パラメータ６");
        processUpdateInBean.setExtParam6(extParam6);
        WSExtParam extParam7 = new WSExtParam();
        extParam7.setValues("追加パラメータ７");
        processUpdateInBean.setExtParam7(extParam7);
        WSExtParam extParam8 = new WSExtParam();
        extParam8.setValues("追加パラメータ８");
        processUpdateInBean.setExtParam8(extParam8);
        WSExtParam extParam9 = new WSExtParam();
        extParam9.setValues("追加パラメータ９");
        processUpdateInBean.setExtParam9(extParam9);
        WSExtParam extParam10 = new WSExtParam();
        extParam10.setValues("追加パラメータ１０");
        processUpdateInBean.setExtParam10(extParam10);
        WSExtParam extParam11 = new WSExtParam();
        extParam11.setValues("追加パラメータ１１");
        processUpdateInBean.setExtParam11(extParam11);
        WSExtParam extParam12 = new WSExtParam();
        extParam12.setValues("追加パラメータ１２");
        processUpdateInBean.setExtParam12(extParam12);
        WSExtParam extParam13 = new WSExtParam();
        extParam13.setValues("追加パラメータ１３");
        processUpdateInBean.setExtParam13(extParam13);
        WSExtParam extParam14 = new WSExtParam();
        extParam14.setValues("追加パラメータ１４");
        processUpdateInBean.setExtParam14(extParam14);
        WSExtParam extParam15 = new WSExtParam();
        extParam15.setValues("追加パラメータ１５");
        processUpdateInBean.setExtParam15(extParam15);
        ProcessUpdateOutBean processUpdateOutBean = iwfKouteiClient.execProcessUpdate(processUpdateInBean);

        IwfCoreConfig.getInstance().setLockYouhi(lockYouhi);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), processUpdateOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", processUpdateOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "必須入力チェックエラー：ロックキー", processUpdateOutBean.getSyousaimsg());

    }

    @Test
    public void testKyoukaiOK01() throws Exception {

        boolean lockYouhi = IwfCoreConfig.getInstance().isLockYouhi();
        IwfCoreConfig.getInstance().setLockYouhi(true);

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setGyoumukey("業務キー業務キー業務キー業務キー業務キ");
        befProcessCreateInBean.setFlowid("tt4");
        befProcessCreateInBean.setAccountid("JUnit");
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        LockProcessInBean befLockProcessInBean = new LockProcessInBean();
        befLockProcessInBean.setGyoumukey("業務キー業務キー業務キー業務キー業務キ");
        befLockProcessInBean.setFlowid("tt4");
        befLockProcessInBean.setLockkey("ロックキー2_1");
        LockProcessOutBean befLockProcessOutBean = iwfKouteiClient.execLockProcess(befLockProcessInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befLockProcessOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程ロック開始実行失敗！");
        }

        String psGyoumukey = "業務キー業務キー業務キー業務キー業務キ";
        String psFlowid = "tt4";
        String psAccountid = "JUnit";
        String psLockkey = "ロックキー2_1";
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        String psExtinfo = "付加情報";
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", psExtinfo);
        poExtinfoMapList.add(poExtinfoMap);
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

        ProcessUpdateInBean inBean = new ProcessUpdateInBean();
        inBean.setGyoumukey(psGyoumukey);
        inBean.setFlowid(psFlowid);
        inBean.setAccountid(psAccountid);
        inBean.setLockkey(psLockkey);
        inBean.setExtInfo(poExtinfoMapList);
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

        ProcessUpdateOutBean outBean = iwfKouteiClient.execProcessUpdate(inBean);

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey("業務キー業務キー業務キー業務キー業務キ");
        aftProcessCancelInBean.setFlowid("tt4");
        aftProcessCancelInBean.setAccountid("JUnit");
        aftProcessCancelInBean.setLockkey("ロックキー2_1");
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

        IwfCoreConfig.getInstance().setLockYouhi(lockYouhi);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程情報更新正常終了しました。", outBean.getSyousaimsg());

    }

    @Test
    public void testKyoukaiOK02() throws Exception {

        boolean lockYouhi = IwfCoreConfig.getInstance().isLockYouhi();
        IwfCoreConfig.getInstance().setLockYouhi(true);
        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setGyoumukey("業務キー業務キー業務キー業務キー業務キー");
        befProcessCreateInBean.setFlowid("tt4");
        befProcessCreateInBean.setAccountid("JUnit");
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        LockProcessInBean befLockProcessInBean = new LockProcessInBean();
        befLockProcessInBean.setGyoumukey("業務キー業務キー業務キー業務キー業務キー");
        befLockProcessInBean.setFlowid("tt4");
        befLockProcessInBean.setLockkey("ロックキー2_2");
        LockProcessOutBean befLockProcessOutBean = iwfKouteiClient.execLockProcess(befLockProcessInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befLockProcessOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程ロック開始実行失敗！");
        }

        String psGyoumukey = "業務キー業務キー業務キー業務キー業務キー";
        String psFlowid = "tt4";
        String psAccountid = "JUnit";
        String psLockkey = "ロックキー2_2";
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        String psExtinfo = "付加情報";
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", psExtinfo);
        poExtinfoMapList.add(poExtinfoMap);
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

        ProcessUpdateInBean inBean = new ProcessUpdateInBean();
        inBean.setGyoumukey(psGyoumukey);
        inBean.setFlowid(psFlowid);
        inBean.setAccountid(psAccountid);
        inBean.setLockkey(psLockkey);
        inBean.setExtInfo(poExtinfoMapList);
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

        ProcessUpdateOutBean outBean = iwfKouteiClient.execProcessUpdate(inBean);

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey("業務キー業務キー業務キー業務キー業務キー");
        aftProcessCancelInBean.setFlowid("tt4");
        aftProcessCancelInBean.setAccountid("JUnit");
        aftProcessCancelInBean.setLockkey("ロックキー2_2");
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

        IwfCoreConfig.getInstance().setLockYouhi(lockYouhi);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程情報更新正常終了しました。", outBean.getSyousaimsg());

    }

    @Test
    public void testKyoukaiNG01() {
        String psGyoumukey = "業務キー業務キー業務キー業務キー業務キー業";
        String psFlowid = "tt4";
        String psAccountid = "JUnit";
        String psLockkey = "ロックキー2_3";
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        String psExtinfo = "付加情報";
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", psExtinfo);
        poExtinfoMapList.add(poExtinfoMap);
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

        ProcessUpdateInBean inBean = new ProcessUpdateInBean();
        inBean.setGyoumukey(psGyoumukey);
        inBean.setFlowid(psFlowid);
        inBean.setAccountid(psAccountid);
        inBean.setLockkey(psLockkey);
        inBean.setExtInfo(poExtinfoMapList);
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

        ProcessUpdateOutBean outBean = iwfKouteiClient.execProcessUpdate(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0008", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "業務キーは20文字以内で入力してください。", outBean.getSyousaimsg());

    }

    @Test
    public void testKyoukaiOK03() throws Exception {

        boolean lockYouhi = IwfCoreConfig.getInstance().isLockYouhi();
        IwfCoreConfig.getInstance().setLockYouhi(true);

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setGyoumukey("業務キー0001");
        befProcessCreateInBean.setFlowid("tt4");
        befProcessCreateInBean.setAccountid("JUnit");
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        LockProcessInBean befLockProcessInBean = new LockProcessInBean();
        befLockProcessInBean.setGyoumukey("業務キー0001");
        befLockProcessInBean.setFlowid("tt4");
        befLockProcessInBean.setLockkey("ロックキー2_4");
        LockProcessOutBean befLockProcessOutBean = iwfKouteiClient.execLockProcess(befLockProcessInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befLockProcessOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程ロック開始実行失敗！");
        }

        String psGyoumukey = "業務キー0001";
        String psFlowid = "tt4";
        String psAccountid = "JUnit";
        String psLockkey = "ロックキー2_4";
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        String psExtinfo = "付加情報";
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", psExtinfo);
        poExtinfoMapList.add(poExtinfoMap);
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

        ProcessUpdateInBean inBean = new ProcessUpdateInBean();
        inBean.setGyoumukey(psGyoumukey);
        inBean.setFlowid(psFlowid);
        inBean.setAccountid(psAccountid);
        inBean.setLockkey(psLockkey);
        inBean.setExtInfo(poExtinfoMapList);
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

        ProcessUpdateOutBean outBean = iwfKouteiClient.execProcessUpdate(inBean);

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey("業務キー0001");
        aftProcessCancelInBean.setFlowid("tt4");
        aftProcessCancelInBean.setAccountid("JUnit");
        aftProcessCancelInBean.setLockkey("ロックキー2_4");
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

        IwfCoreConfig.getInstance().setLockYouhi(lockYouhi);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程情報更新正常終了しました。", outBean.getSyousaimsg());

    }

    @Test
    public void testKyoukaiOK04() throws Exception {

        boolean lockYouhi = IwfCoreConfig.getInstance().isLockYouhi();
        IwfCoreConfig.getInstance().setLockYouhi(true);
        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setGyoumukey("業務キー2_5");
        befProcessCreateInBean.setFlowid("フローＩＤフローＩＤフローＩＤフロー");
        befProcessCreateInBean.setAccountid("JUnit");
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        LockProcessInBean befLockProcessInBean = new LockProcessInBean();
        befLockProcessInBean.setGyoumukey("業務キー2_5");
        befLockProcessInBean.setFlowid("フローＩＤフローＩＤフローＩＤフロー");
        befLockProcessInBean.setLockkey("ロックキー2_5");
        LockProcessOutBean befLockProcessOutBean = iwfKouteiClient.execLockProcess(befLockProcessInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befLockProcessOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程ロック開始実行失敗！");
        }

        String psGyoumukey = "業務キー2_5";
        String psFlowid = "フローＩＤフローＩＤフローＩＤフロー";
        String psAccountid = "JUnit";
        String psLockkey = "ロックキー2_5";
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        String psExtinfo = "付加情報";
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", psExtinfo);
        poExtinfoMapList.add(poExtinfoMap);
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

        ProcessUpdateInBean inBean = new ProcessUpdateInBean();
        inBean.setGyoumukey(psGyoumukey);
        inBean.setFlowid(psFlowid);
        inBean.setAccountid(psAccountid);
        inBean.setLockkey(psLockkey);
        inBean.setExtInfo(poExtinfoMapList);
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

        ProcessUpdateOutBean outBean = iwfKouteiClient.execProcessUpdate(inBean);

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey("業務キー2_5");
        aftProcessCancelInBean.setFlowid("フローＩＤフローＩＤフローＩＤフロー");
        aftProcessCancelInBean.setAccountid("JUnit");
        aftProcessCancelInBean.setLockkey("ロックキー2_5");
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

        IwfCoreConfig.getInstance().setLockYouhi(lockYouhi);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程情報更新正常終了しました。", outBean.getSyousaimsg());

    }

    @Test
    public void testKyoukaiOK05() throws Exception {

        boolean lockYouhi = IwfCoreConfig.getInstance().isLockYouhi();
        IwfCoreConfig.getInstance().setLockYouhi(true);
        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setGyoumukey("業務キー2_6");
        befProcessCreateInBean.setFlowid("フローＩＤフローＩＤフローＩＤフローＩ");
        befProcessCreateInBean.setAccountid("JUnit");
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        LockProcessInBean befLockProcessInBean = new LockProcessInBean();
        befLockProcessInBean.setGyoumukey("業務キー2_6");
        befLockProcessInBean.setFlowid("フローＩＤフローＩＤフローＩＤフローＩ");
        befLockProcessInBean.setLockkey("ロックキー2_6");
        LockProcessOutBean befLockProcessOutBean = iwfKouteiClient.execLockProcess(befLockProcessInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befLockProcessOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程ロック開始実行失敗！");
        }

        String psGyoumukey = "業務キー2_6";
        String psFlowid = "フローＩＤフローＩＤフローＩＤフローＩ";
        String psAccountid = "JUnit";
        String psLockkey = "ロックキー2_6";
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        String psExtinfo = "付加情報";
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", psExtinfo);
        poExtinfoMapList.add(poExtinfoMap);
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

        ProcessUpdateInBean inBean = new ProcessUpdateInBean();
        inBean.setGyoumukey(psGyoumukey);
        inBean.setFlowid(psFlowid);
        inBean.setAccountid(psAccountid);
        inBean.setLockkey(psLockkey);
        inBean.setExtInfo(poExtinfoMapList);
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

        ProcessUpdateOutBean outBean = iwfKouteiClient.execProcessUpdate(inBean);

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey("業務キー2_6");
        aftProcessCancelInBean.setFlowid("フローＩＤフローＩＤフローＩＤフローＩ");
        aftProcessCancelInBean.setAccountid("JUnit");
        aftProcessCancelInBean.setLockkey("ロックキー2_6");
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

        IwfCoreConfig.getInstance().setLockYouhi(lockYouhi);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程情報更新正常終了しました。", outBean.getSyousaimsg());

    }

    @Test
    public void testKyoukaiNG02() {
        String psGyoumukey = "業務キー2_7";
        String psFlowid = "フローＩＤフローＩＤフローＩＤフローＩＤ";
        String psAccountid = "JUnit";
        String psLockkey = "ロックキー2_7";
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        String psExtinfo = "付加情報";
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", psExtinfo);
        poExtinfoMapList.add(poExtinfoMap);
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

        ProcessUpdateInBean inBean = new ProcessUpdateInBean();
        inBean.setGyoumukey(psGyoumukey);
        inBean.setFlowid(psFlowid);
        inBean.setAccountid(psAccountid);
        inBean.setLockkey(psLockkey);
        inBean.setExtInfo(poExtinfoMapList);
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

        ProcessUpdateOutBean outBean = iwfKouteiClient.execProcessUpdate(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0008", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "フローＩＤは19文字以内で入力してください。", outBean.getSyousaimsg());

    }

    @Test
    public void testKyoukaiOK06() throws Exception {

        boolean lockYouhi = IwfCoreConfig.getInstance().isLockYouhi();
        IwfCoreConfig.getInstance().setLockYouhi(true);
        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setGyoumukey("業務キー2_8");
        befProcessCreateInBean.setFlowid("フローＩＤ0001");
        befProcessCreateInBean.setAccountid("JUnit");
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        LockProcessInBean befLockProcessInBean = new LockProcessInBean();
        befLockProcessInBean.setGyoumukey("業務キー2_8");
        befLockProcessInBean.setFlowid("フローＩＤ0001");
        befLockProcessInBean.setLockkey("ロックキー2_8");
        LockProcessOutBean befLockProcessOutBean = iwfKouteiClient.execLockProcess(befLockProcessInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befLockProcessOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程ロック開始実行失敗！");
        }

        String psGyoumukey = "業務キー2_8";
        String psFlowid = "フローＩＤ0001";
        String psAccountid = "JUnit";
        String psLockkey = "ロックキー2_8";
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        String psExtinfo = "付加情報";
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", psExtinfo);
        poExtinfoMapList.add(poExtinfoMap);
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

        ProcessUpdateInBean inBean = new ProcessUpdateInBean();
        inBean.setGyoumukey(psGyoumukey);
        inBean.setFlowid(psFlowid);
        inBean.setAccountid(psAccountid);
        inBean.setLockkey(psLockkey);
        inBean.setExtInfo(poExtinfoMapList);
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

        ProcessUpdateOutBean outBean = iwfKouteiClient.execProcessUpdate(inBean);

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey("業務キー2_8");
        aftProcessCancelInBean.setFlowid("フローＩＤ0001");
        aftProcessCancelInBean.setAccountid("JUnit");
        aftProcessCancelInBean.setLockkey("ロックキー2_8");
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

        IwfCoreConfig.getInstance().setLockYouhi(lockYouhi);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程情報更新正常終了しました。", outBean.getSyousaimsg());
    }

    @Test
    public void testKyoukaiOK07() throws Exception {
        String pGyoumukey = BizDate.getSysDateTimeMilli();
        boolean lockYouhi = IwfCoreConfig.getInstance().isLockYouhi();
        IwfCoreConfig.getInstance().setLockYouhi(true);

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setGyoumukey(pGyoumukey);
        befProcessCreateInBean.setFlowid("tt4");
        befProcessCreateInBean.setAccountid("123456789012345678901234567890");
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        LockProcessInBean befLockProcessInBean = new LockProcessInBean();
        befLockProcessInBean.setGyoumukey(pGyoumukey);
        befLockProcessInBean.setFlowid("tt4");
        befLockProcessInBean.setLockkey("ロックキー2_10");
        LockProcessOutBean befLockProcessOutBean = iwfKouteiClient.execLockProcess(befLockProcessInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befLockProcessOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程ロック開始実行失敗！");
        }

        String psFlowid = "tt4";
        String psAccountid = "123456789012345678901234567890";
        String psLockkey = "ロックキー2_10";
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        String psExtinfo = "付加情報";
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", psExtinfo);
        poExtinfoMapList.add(poExtinfoMap);
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

        ProcessUpdateInBean inBean = new ProcessUpdateInBean();
        inBean.setGyoumukey(pGyoumukey);
        inBean.setFlowid(psFlowid);
        inBean.setAccountid(psAccountid);
        inBean.setLockkey(psLockkey);
        inBean.setExtInfo(poExtinfoMapList);
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

        ProcessUpdateOutBean outBean = iwfKouteiClient.execProcessUpdate(inBean);

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey(pGyoumukey);
        aftProcessCancelInBean.setFlowid("tt4");
        aftProcessCancelInBean.setAccountid("123456789012345678901234567890");
        aftProcessCancelInBean.setLockkey("ロックキー2_10");
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

        IwfCoreConfig.getInstance().setLockYouhi(lockYouhi);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程情報更新正常終了しました。", outBean.getSyousaimsg());

    }

    @Test
    public void testKyoukaiNG03() {
        String psGyoumukey = "業務キー2_11";
        String psFlowid = "tt4";
        String psAccountid = "ACID000000000000000000000000012";
        String psLockkey = "ロックキー2_11";
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        String psExtinfo = "付加情報";
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", psExtinfo);
        poExtinfoMapList.add(poExtinfoMap);
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

        ProcessUpdateInBean inBean = new ProcessUpdateInBean();
        inBean.setGyoumukey(psGyoumukey);
        inBean.setFlowid(psFlowid);
        inBean.setAccountid(psAccountid);
        inBean.setLockkey(psLockkey);
        inBean.setExtInfo(poExtinfoMapList);
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

        ProcessUpdateOutBean outBean = iwfKouteiClient.execProcessUpdate(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0008", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "アカウントＩＤは30文字以内で入力してください。", outBean.getSyousaimsg());

    }

    @Test
    public void testInfoExistNG01() {
        String psGyoumukey = "業務キー3_2";
        String psFlowid = "tt4";
        String psAccountid = "JUnit";
        String psLockkey = "ロックキー3_2";
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        String psExtinfo = "付加情報";
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", psExtinfo);
        poExtinfoMapList.add(poExtinfoMap);
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

        ProcessUpdateInBean inBean = new ProcessUpdateInBean();
        inBean.setGyoumukey(psGyoumukey);
        inBean.setFlowid(psFlowid);
        inBean.setAccountid(psAccountid);
        inBean.setLockkey(psLockkey);
        inBean.setExtInfo(poExtinfoMapList);
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

        ProcessUpdateOutBean outBean = iwfKouteiClient.execProcessUpdate(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF2025", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "指定されたフローID、業務キーに紐づくトークンは存在しない、または終了しています。", outBean.getSyousaimsg());

    }

    // ■IWF2031メッセージコードを使用する箇所がないため、テストケースを削除する。
    //    @Test
    //    public void testInfoExistNG02() throws Exception {
    //
    //        IwfCoreConfig.getInstance().setLockYouhi(true);
    //
    //        String pGyoumukey = BizDate.getSysDateTimeMilli();
    //
    //        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
    //        befProcessCreateInBean.setGyoumukey(pGyoumukey);
    //        befProcessCreateInBean.setFlowid("tt4");
    //        befProcessCreateInBean.setAccountid("JUnit");
    //        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
    //        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
    //            throw new Exception("前処理：工程作成実行失敗！");
    //        }
    //
    //        LockProcessInBean befLockProcessInBean = new LockProcessInBean();
    //        befLockProcessInBean.setGyoumukey(pGyoumukey);
    //        befLockProcessInBean.setFlowid("tt4");
    //        befLockProcessInBean.setLockkey("ロックキー3_3");
    //        LockProcessOutBean befLockProcessOutBean = iwfKouteiClient.execLockProcess(befLockProcessInBean);
    //        if (!C_ResultCdKbn.OK.toString().equals(befLockProcessOutBean.getKekkastatus())) {
    //            throw new Exception("前処理：工程ロック開始実行失敗！");
    //        }
    //
    //        String psFlowid = "tt4";
    //        String psAccountid = "JUnitx";
    //        String psLockkey = "ロックキー3_3";
    //        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
    //        String psExtinfo = "付加情報";
    //        Map<String, String> poExtinfoMap = new HashMap<String, String>();
    //        poExtinfoMap.put("extinfo", psExtinfo);
    //        poExtinfoMapList.add(poExtinfoMap);
    //        WSExtParam poExtparam1 = new WSExtParam();
    //        poExtparam1.setValues("追加パラメータ１");
    //        WSExtParam poExtparam2 = new WSExtParam();
    //        poExtparam2.setValues("追加パラメータ２");
    //        WSExtParam poExtparam3 = new WSExtParam();
    //        poExtparam3.setValues("追加パラメータ３");
    //        WSExtParam poExtparam4 = new WSExtParam();
    //        poExtparam4.setValues("追加パラメータ４");
    //        WSExtParam poExtparam5 = new WSExtParam();
    //        poExtparam5.setValues("追加パラメータ５");
    //        WSExtParam poExtparam6 = new WSExtParam();
    //        poExtparam6.setValues("追加パラメータ６");
    //        WSExtParam poExtparam7 = new WSExtParam();
    //        poExtparam7.setValues("追加パラメータ７");
    //        WSExtParam poExtparam8 = new WSExtParam();
    //        poExtparam8.setValues("追加パラメータ８");
    //        WSExtParam poExtparam9 = new WSExtParam();
    //        poExtparam9.setValues("追加パラメータ９");
    //        WSExtParam poExtparam10 = new WSExtParam();
    //        poExtparam10.setValues("追加パラメータ１０");
    //        WSExtParam poExtparam11 = new WSExtParam();
    //        poExtparam11.setValues("追加パラメータ１１");
    //        WSExtParam poExtparam12 = new WSExtParam();
    //        poExtparam12.setValues("追加パラメータ１２");
    //        WSExtParam poExtparam13 = new WSExtParam();
    //        poExtparam13.setValues("追加パラメータ１３");
    //        WSExtParam poExtparam14 = new WSExtParam();
    //        poExtparam14.setValues("追加パラメータ１４");
    //        WSExtParam poExtparam15 = new WSExtParam();
    //        poExtparam15.setValues("追加パラメータ１５");
    //
    //        ProcessUpdateInBean inBean = new ProcessUpdateInBean();
    //        inBean.setGyoumukey(pGyoumukey);
    //        inBean.setFlowid(psFlowid);
    //        inBean.setAccountid(psAccountid);
    //        inBean.setLockkey(psLockkey);
    //        inBean.setExtInfo(poExtinfoMapList);
    //        inBean.setExtParam1(poExtparam1);
    //        inBean.setExtParam2(poExtparam2);
    //        inBean.setExtParam3(poExtparam3);
    //        inBean.setExtParam4(poExtparam4);
    //        inBean.setExtParam5(poExtparam5);
    //        inBean.setExtParam6(poExtparam6);
    //        inBean.setExtParam7(poExtparam7);
    //        inBean.setExtParam8(poExtparam8);
    //        inBean.setExtParam9(poExtparam9);
    //        inBean.setExtParam10(poExtparam10);
    //        inBean.setExtParam11(poExtparam11);
    //        inBean.setExtParam12(poExtparam12);
    //        inBean.setExtParam13(poExtparam13);
    //        inBean.setExtParam14(poExtparam14);
    //        inBean.setExtParam15(poExtparam15);
    //
    //        ProcessUpdateOutBean outBean = iwfKouteiClient.execProcessUpdate(inBean);
    //
    //        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
    //        aftProcessCancelInBean.setGyoumukey(pGyoumukey);
    //        aftProcessCancelInBean.setFlowid("tt4");
    //        aftProcessCancelInBean.setAccountid("JUnit");
    //        aftProcessCancelInBean.setLockkey("ロックキー3_3");
    //        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
    //        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
    //            throw new Exception("後処理：工程取消実行失敗！");
    //        }
    //
    //        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
    //        assertEquals("詳細メッセージコード:", "IWF2031", outBean.getSyousaimsgcd());
    //        assertEquals("詳細メッセージ:", "タスクの実行権限がありません。", outBean.getSyousaimsg());
    //
    //        IwfCoreConfig.getInstance().setLockYouhi(false);
    //
    //    }

    @Test
    public void testInfoExistNG03() throws Exception {
        String pGyoumukey = BizDate.getSysDateTimeMilli();
        boolean lockYouhi = IwfCoreConfig.getInstance().isLockYouhi();
        IwfCoreConfig.getInstance().setLockYouhi(true);

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setGyoumukey(pGyoumukey);
        befProcessCreateInBean.setFlowid("tt4");
        befProcessCreateInBean.setAccountid("JUnit");
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        LockProcessInBean befLockProcessInBean = new LockProcessInBean();
        befLockProcessInBean.setGyoumukey(pGyoumukey);
        befLockProcessInBean.setFlowid("tt4");
        befLockProcessInBean.setLockkey("ロックキー3_4");
        LockProcessOutBean befLockProcessOutBean = iwfKouteiClient.execLockProcess(befLockProcessInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befLockProcessOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程ロック開始実行失敗！");
        }

        String psFlowid = "tt4";
        String psAccountid = "JUnit";
        String psLockkey = "無効ロックキー";
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        String psExtinfo = "付加情報";
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", psExtinfo);
        poExtinfoMapList.add(poExtinfoMap);
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

        ProcessUpdateInBean inBean = new ProcessUpdateInBean();
        inBean.setGyoumukey(pGyoumukey);
        inBean.setFlowid(psFlowid);
        inBean.setAccountid(psAccountid);
        inBean.setLockkey(psLockkey);
        inBean.setExtInfo(poExtinfoMapList);
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

        ProcessUpdateOutBean outBean = iwfKouteiClient.execProcessUpdate(inBean);

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey(pGyoumukey);
        aftProcessCancelInBean.setFlowid("tt4");
        aftProcessCancelInBean.setAccountid("JUnit");
        aftProcessCancelInBean.setLockkey("ロックキー3_4");
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

        IwfCoreConfig.getInstance().setLockYouhi(lockYouhi);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF2021", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "ロックキーが無効です。他の作業者がロック中、またはロックが既に解除されています。", outBean.getSyousaimsg());

    }

    @Test
    public void testSyoriLogicOK01() throws Exception {
        String pGyoumukey = BizDate.getSysDateTimeMilli();
        boolean lockYouhi = IwfCoreConfig.getInstance().isLockYouhi();
        IwfCoreConfig.getInstance().setLockYouhi(true);

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setGyoumukey(pGyoumukey);
        befProcessCreateInBean.setFlowid("tt4");
        befProcessCreateInBean.setAccountid("JUnit");
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        LockProcessInBean befLockProcessInBean = new LockProcessInBean();
        befLockProcessInBean.setGyoumukey(pGyoumukey);
        befLockProcessInBean.setFlowid("tt4");
        befLockProcessInBean.setLockkey("ロックキー4_1");
        LockProcessOutBean befLockProcessOutBean = iwfKouteiClient.execLockProcess(befLockProcessInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befLockProcessOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程ロック開始実行失敗！");
        }

        String psFlowid = "tt4";
        String psAccountid = "JUnit";
        String psLockkey = "ロックキー4_1";
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        String psExtinfo = "付加情報";
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", psExtinfo);
        poExtinfoMapList.add(poExtinfoMap);
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

        ProcessUpdateInBean inBean = new ProcessUpdateInBean();
        inBean.setGyoumukey(pGyoumukey);
        inBean.setFlowid(psFlowid);
        inBean.setAccountid(psAccountid);
        inBean.setLockkey(psLockkey);
        inBean.setExtInfo(poExtinfoMapList);
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

        ProcessUpdateOutBean outBean = iwfKouteiClient.execProcessUpdate(inBean);

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey(pGyoumukey);
        aftProcessCancelInBean.setFlowid("tt4");
        aftProcessCancelInBean.setAccountid("JUnit");
        aftProcessCancelInBean.setLockkey("ロックキー4_1");
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

        IwfCoreConfig.getInstance().setLockYouhi(lockYouhi);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程情報更新正常終了しました。", outBean.getSyousaimsg());

    }

    @Test
    public void testSyoriLogicOK02() throws Exception {
        String pGyoumukey = BizDate.getSysDateTimeMilli();
        boolean lockYouhi = IwfCoreConfig.getInstance().isLockYouhi();
        IwfCoreConfig.getInstance().setLockYouhi(true);

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setGyoumukey(pGyoumukey);
        befProcessCreateInBean.setFlowid("tt4");
        befProcessCreateInBean.setAccountid("JUnit");
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        LockProcessInBean befLockProcessInBean = new LockProcessInBean();
        befLockProcessInBean.setGyoumukey(pGyoumukey);
        befLockProcessInBean.setFlowid("tt4");
        befLockProcessInBean.setLockkey("ロックキー4_1");
        LockProcessOutBean befLockProcessOutBean = iwfKouteiClient.execLockProcess(befLockProcessInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befLockProcessOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程ロック開始実行失敗！");
        }

        String psFlowid = "tt4";
        String psAccountid = "JUnit";
        String psLockkey = "ロックキー4_1";
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        String psExtinfo = "付加情報";
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", psExtinfo);
        poExtinfoMapList.add(poExtinfoMap);
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

        ProcessUpdateInBean inBean = new ProcessUpdateInBean();
        inBean.setGyoumukey(pGyoumukey);
        inBean.setFlowid(psFlowid);
        inBean.setAccountid(psAccountid);
        inBean.setLockkey(psLockkey);
        inBean.setExtInfo(poExtinfoMapList);
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

        ProcessUpdateOutBean outBean = iwfKouteiClient.execProcessUpdate(inBean);

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey(pGyoumukey);
        aftProcessCancelInBean.setFlowid("tt4");
        aftProcessCancelInBean.setAccountid("JUnit");
        aftProcessCancelInBean.setLockkey("ロックキー4_1");
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

        IwfCoreConfig.getInstance().setLockYouhi(lockYouhi);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程情報更新正常終了しました。", outBean.getSyousaimsg());
        WT_KouteiSummary kouteiSummary = iwfCoreDomManager.getKouteiSummary(pGyoumukey);
        if (null != kouteiSummary) {

            assertEquals(kouteiSummary.getExtParam1(), inBean.getExtParam1().getValue());
            assertEquals(kouteiSummary.getExtParam2(), inBean.getExtParam2().getValue());
            assertEquals(kouteiSummary.getExtParam3(), inBean.getExtParam3().getValue());
            assertEquals(kouteiSummary.getExtParam4(), inBean.getExtParam4().getValue());
            assertEquals(kouteiSummary.getExtParam5(), inBean.getExtParam5().getValue());
            assertEquals(kouteiSummary.getExtParam6(), inBean.getExtParam6().getValue());
            assertEquals(kouteiSummary.getExtParam7(), inBean.getExtParam7().getValue());
            assertEquals(kouteiSummary.getExtParam8(), inBean.getExtParam8().getValue());
            assertEquals(kouteiSummary.getExtParam9(), inBean.getExtParam9().getValue());
            assertEquals(kouteiSummary.getExtParam10(), inBean.getExtParam10().getValue());
            assertEquals(kouteiSummary.getExtParam11(), inBean.getExtParam11().getValue());
            assertEquals(kouteiSummary.getExtParam12(), inBean.getExtParam12().getValue());
            assertEquals(kouteiSummary.getExtParam13(), inBean.getExtParam13().getValue());
            assertEquals(kouteiSummary.getExtParam14(), inBean.getExtParam14().getValue());
            assertEquals(kouteiSummary.getExtParam15(), inBean.getExtParam15().getValue());
            assertEquals(kouteiSummary.getExtParam16(), inBean.getExtParam16().getValue());
            assertEquals(kouteiSummary.getExtParam17(), inBean.getExtParam17().getValue());
            assertEquals(kouteiSummary.getExtParam18(), inBean.getExtParam18().getValue());
            assertEquals(kouteiSummary.getExtParam19(), inBean.getExtParam19().getValue());
            assertEquals(kouteiSummary.getExtParam20(), inBean.getExtParam20().getValue());
            assertEquals(kouteiSummary.getExtParam21(), inBean.getExtParam21().getValue());
            assertEquals(kouteiSummary.getExtParam22(), inBean.getExtParam22().getValue());
            assertEquals(kouteiSummary.getExtParam23(), inBean.getExtParam23().getValue());
            assertEquals(kouteiSummary.getExtParam24(), inBean.getExtParam24().getValue());
            assertEquals(kouteiSummary.getExtParam25(), inBean.getExtParam25().getValue());
            assertEquals(kouteiSummary.getExtParam26(), inBean.getExtParam26().getValue());
            assertEquals(kouteiSummary.getExtParam27(), inBean.getExtParam27().getValue());
            assertEquals(kouteiSummary.getExtParam28(), inBean.getExtParam28().getValue());
            assertEquals(kouteiSummary.getExtParam29(), inBean.getExtParam29().getValue());
            assertEquals(kouteiSummary.getExtParam30(), inBean.getExtParam30().getValue());
        } else {
            assertTrue(false);
        }

    }


    @Test
    public void testSyoriLogicOK03() throws Exception {
        String pGyoumukey = BizDate.getSysDateTimeMilli();
        boolean lockYouhi = IwfCoreConfig.getInstance().isLockYouhi();
        IwfCoreConfig.getInstance().setLockYouhi(true);

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setGyoumukey(pGyoumukey);
        befProcessCreateInBean.setFlowid("tt4");
        befProcessCreateInBean.setAccountid("JUnit");
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        LockProcessInBean befLockProcessInBean = new LockProcessInBean();
        befLockProcessInBean.setGyoumukey(pGyoumukey);
        befLockProcessInBean.setFlowid("tt4");
        befLockProcessInBean.setLockkey("ロックキー4_1");
        LockProcessOutBean befLockProcessOutBean = iwfKouteiClient.execLockProcess(befLockProcessInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befLockProcessOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程ロック開始実行失敗！");
        }

        String psFlowid = "tt4";
        String psAccountid = "JUnit";
        String psLockkey = "ロックキー4_1";
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        String psExtinfo = "付加情報";
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", psExtinfo);
        poExtinfoMapList.add(poExtinfoMap);

        ProcessUpdateInBean inBean = new ProcessUpdateInBean();
        inBean.setGyoumukey(pGyoumukey);
        inBean.setFlowid(psFlowid);
        inBean.setAccountid(psAccountid);
        inBean.setLockkey(psLockkey);
        inBean.setExtInfo(poExtinfoMapList);

        ProcessUpdateOutBean outBean = iwfKouteiClient.execProcessUpdate(inBean);

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey(pGyoumukey);
        aftProcessCancelInBean.setFlowid("tt4");
        aftProcessCancelInBean.setAccountid("JUnit");
        aftProcessCancelInBean.setLockkey("ロックキー4_1");
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

        IwfCoreConfig.getInstance().setLockYouhi(lockYouhi);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程情報更新正常終了しました。", outBean.getSyousaimsg());

        List<WT_KouteiRireki> kouteiRirekis = iwfCoreDomManager.getKouteiRirekis(pGyoumukey, psFlowid,C_RirekiKbn.SYSTEM);
        if (null != kouteiRirekis) {
            byte[] extInfo = null;
            for(WT_KouteiRireki kouteiRirekiBean : kouteiRirekis){
                if(kouteiRirekiBean.getIwfSyoriKbn().equals(C_IwfSyoriKbn.UPDATE)) {
                    extInfo     = kouteiRirekiBean.getExtInfo();
                }
            }
            assertEquals("付加情報:", true, extInfo != null);

        } else {
            assertTrue(false);
        }

    }
}
