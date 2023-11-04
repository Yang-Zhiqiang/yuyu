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

import yuyu.common.biz.workflow.io.image.CreateImageSpaceInBean;
import yuyu.common.biz.workflow.io.image.DeleteImageSpaceInBean;
import yuyu.common.biz.workflow.io.koutei.ProcessCancelInBean;
import yuyu.common.biz.workflow.io.koutei.ProcessCancelOutBean;
import yuyu.common.biz.workflow.io.koutei.ProcessCreateInBean;
import yuyu.common.biz.workflow.io.koutei.ProcessCreateOutBean;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.def.workflowcore.configration.IwfCoreConfig;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocesscancel.WSExecProcessCancelResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocesscreate.WSExecProcessCreate;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocesscreate.WSExecProcessCreateRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocesscreate.WSExecProcessCreateResponse;

/**
 * イメージ登録領域作成Webサービス {@link WSExecProcessCreate#executeBizMain(WSExecProcessCreateRequest)} テスト用クラスです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class CreateImageSpaceWebServiceTest {

    @Inject
    IwfImageClient iwfImageClient;
    @Inject
    IwfKouteiClient iwfKouteiClient;

    @Test(expected = RuntimeException.class)
    public void testValidationNG01() {

        iwfImageClient.execCreateImageSpace(null);
    }

    @Test
    public void testValidationNG02() {
        CreateImageSpaceInBean createImageSpaceInBean = new CreateImageSpaceInBean();
        createImageSpaceInBean.setGyoumukey(null);
        createImageSpaceInBean.setAccountid("Tt");
        createImageSpaceInBean.setProcessgroup("プロセスグループ");
        createImageSpaceInBean.setRirekiTaskName("履歴タスク名");
        List<Map<String, String>> extinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> extinfoMap = new HashMap<String, String>();
        extinfoMap.put("extinfo", "付加情報");
        extinfoMapList.add(extinfoMap);
        createImageSpaceInBean.setExtInfo(extinfoMapList);
        WSExecProcessCreateResponse wSExecProcessCreateResponse = iwfImageClient.execCreateImageSpace(createImageSpaceInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), wSExecProcessCreateResponse.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", wSExecProcessCreateResponse.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "必須入力チェックエラー：業務キー", wSExecProcessCreateResponse.getSyousaimsg());

    }

    @Test
    public void testValidationNG03() {
        CreateImageSpaceInBean createImageSpaceInBean = new CreateImageSpaceInBean();
        createImageSpaceInBean.setGyoumukey("");
        createImageSpaceInBean.setAccountid("Tt");
        createImageSpaceInBean.setProcessgroup("プロセスグループ");
        createImageSpaceInBean.setRirekiTaskName("履歴タスク名");
        List<Map<String, String>> extinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> extinfoMap = new HashMap<String, String>();
        extinfoMap.put("extinfo", "付加情報");
        extinfoMapList.add(extinfoMap);
        createImageSpaceInBean.setExtInfo(extinfoMapList);
        WSExecProcessCreateResponse wSExecProcessCreateResponse = iwfImageClient.execCreateImageSpace(createImageSpaceInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), wSExecProcessCreateResponse.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", wSExecProcessCreateResponse.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "必須入力チェックエラー：業務キー", wSExecProcessCreateResponse.getSyousaimsg());

    }

    @Test
    public void testValidationNG04() {
        CreateImageSpaceInBean createImageSpaceInBean = new CreateImageSpaceInBean();
        createImageSpaceInBean.setGyoumukey("業務キー1_4");
        createImageSpaceInBean.setAccountid(null);
        createImageSpaceInBean.setProcessgroup("プロセスグループ");
        createImageSpaceInBean.setRirekiTaskName("履歴タスク名");
        List<Map<String, String>> extinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> extinfoMap = new HashMap<String, String>();
        extinfoMap.put("extinfo", "付加情報");
        extinfoMapList.add(extinfoMap);
        createImageSpaceInBean.setExtInfo(extinfoMapList);
        WSExecProcessCreateResponse wSExecProcessCreateResponse = iwfImageClient.execCreateImageSpace(createImageSpaceInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), wSExecProcessCreateResponse.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", wSExecProcessCreateResponse.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "必須入力チェックエラー：アカウントＩＤ", wSExecProcessCreateResponse.getSyousaimsg());

    }

    @Test
    public void testValidationNG05() {
        CreateImageSpaceInBean createImageSpaceInBean = new CreateImageSpaceInBean();
        createImageSpaceInBean.setGyoumukey("業務キー1_5");
        createImageSpaceInBean.setAccountid("");
        createImageSpaceInBean.setProcessgroup("プロセスグループ");
        createImageSpaceInBean.setRirekiTaskName("履歴タスク名");
        List<Map<String, String>> extinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> extinfoMap = new HashMap<String, String>();
        extinfoMap.put("extinfo", "付加情報");
        extinfoMapList.add(extinfoMap);
        createImageSpaceInBean.setExtInfo(extinfoMapList);
        WSExecProcessCreateResponse wSExecProcessCreateResponse = iwfImageClient.execCreateImageSpace(createImageSpaceInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), wSExecProcessCreateResponse.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", wSExecProcessCreateResponse.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "必須入力チェックエラー：アカウントＩＤ", wSExecProcessCreateResponse.getSyousaimsg());

    }

    @Test
    public void testValidationOK01() throws Exception {
        String gyoumukey = BizDate.getSysDateTimeMilli();
        IwfCoreConfig.getInstance().setLockYouhi(false);

        CreateImageSpaceInBean createImageSpaceInBean = new CreateImageSpaceInBean();
        createImageSpaceInBean.setGyoumukey(gyoumukey);
        createImageSpaceInBean.setAccountid("Tt");
        createImageSpaceInBean.setProcessgroup(null);
        createImageSpaceInBean.setRirekiTaskName(null);
        List<Map<String, String>> extinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> extinfoMap = new HashMap<String, String>();
        extinfoMap.put("extinfo", null);
        extinfoMapList.add(extinfoMap);
        createImageSpaceInBean.setExtInfo(extinfoMapList);
        WSExecProcessCreateResponse wSExecProcessCreateResponse = iwfImageClient.execCreateImageSpace(createImageSpaceInBean);

        DeleteImageSpaceInBean aftDeleteImageSpaceInBean = new DeleteImageSpaceInBean();
        aftDeleteImageSpaceInBean.setGyoumukey(gyoumukey);
        aftDeleteImageSpaceInBean.setAccountid("Tt");
        WSExecProcessCancelResponse aftWSExecProcessCancelResponse = iwfImageClient.execDeleteImageSpace(aftDeleteImageSpaceInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftWSExecProcessCancelResponse.getKekkastatus())) {
            throw new Exception("後処理：イメージ登録領域削除実行失敗！");
        }

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), wSExecProcessCreateResponse.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", wSExecProcessCreateResponse.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程開始正常終了しました。", wSExecProcessCreateResponse.getSyousaimsg());

    }

    @Test
    public void testValidationNG06() throws Exception {
        CreateImageSpaceInBean createImageSpaceInBean = new CreateImageSpaceInBean();
        createImageSpaceInBean.setGyoumukey("業務キー1_6");
        createImageSpaceInBean.setAccountid("Tt");
        createImageSpaceInBean.setProcessgroup(null);
        createImageSpaceInBean.setRirekiTaskName(null);
        createImageSpaceInBean.setExtInfo(null);
        WSExecProcessCreateResponse wSExecProcessCreateResponse = iwfImageClient.execCreateImageSpace(createImageSpaceInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), wSExecProcessCreateResponse.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", wSExecProcessCreateResponse.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程開始正常終了しました。", wSExecProcessCreateResponse.getSyousaimsg());
    }

    @Test
    public void testValidationOK02() throws Exception {
        String gyoumukey = BizDate.getSysDateTimeMilli();
        IwfCoreConfig.getInstance().setLockYouhi(false);

        CreateImageSpaceInBean createImageSpaceInBean = new CreateImageSpaceInBean();
        createImageSpaceInBean.setGyoumukey(gyoumukey);
        createImageSpaceInBean.setAccountid("Tt");
        createImageSpaceInBean.setProcessgroup("");
        createImageSpaceInBean.setRirekiTaskName("");
        List<Map<String, String>> extinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> extinfoMap = new HashMap<String, String>();
        extinfoMap.put("extinfo", "");
        extinfoMapList.add(extinfoMap);
        createImageSpaceInBean.setExtInfo(extinfoMapList);
        WSExecProcessCreateResponse wSExecProcessCreateResponse = iwfImageClient.execCreateImageSpace(createImageSpaceInBean);

        DeleteImageSpaceInBean aftDeleteImageSpaceInBean = new DeleteImageSpaceInBean();
        aftDeleteImageSpaceInBean.setGyoumukey(gyoumukey);
        aftDeleteImageSpaceInBean.setAccountid("Tt");
        WSExecProcessCancelResponse aftWSExecProcessCancelResponse = iwfImageClient.execDeleteImageSpace(aftDeleteImageSpaceInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftWSExecProcessCancelResponse.getKekkastatus())) {
            throw new Exception("後処理：イメージ登録領域削除実行失敗！");
        }

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), wSExecProcessCreateResponse.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", wSExecProcessCreateResponse.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程開始正常終了しました。", wSExecProcessCreateResponse.getSyousaimsg());

    }

    @Test
    public void testKyoukaiOK01() throws Exception {

        String gyoumukey = TestUtil.nString_zenkaku(19);
        CreateImageSpaceInBean createImageSpaceInBean = new CreateImageSpaceInBean();
        createImageSpaceInBean.setGyoumukey(gyoumukey);
        createImageSpaceInBean.setAccountid("Tt");
        createImageSpaceInBean.setProcessgroup("プロセスグループ");
        createImageSpaceInBean.setRirekiTaskName("履歴タスク名");
        List<Map<String, String>> extinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> extinfoMap = new HashMap<String, String>();
        extinfoMap.put("extinfo", "付加情報");
        extinfoMapList.add(extinfoMap);
        createImageSpaceInBean.setExtInfo(extinfoMapList);
        WSExecProcessCreateResponse wSExecProcessCreateResponse = iwfImageClient.execCreateImageSpace(createImageSpaceInBean);

        DeleteImageSpaceInBean aftDeleteImageSpaceInBean = new DeleteImageSpaceInBean();
        aftDeleteImageSpaceInBean.setGyoumukey(gyoumukey);
        aftDeleteImageSpaceInBean.setAccountid("Tt");
        WSExecProcessCancelResponse aftWSExecProcessCancelResponse = iwfImageClient.execDeleteImageSpace(aftDeleteImageSpaceInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftWSExecProcessCancelResponse.getKekkastatus())) {
            throw new Exception("後処理：イメージ登録領域削除実行失敗！");
        }

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), wSExecProcessCreateResponse.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", wSExecProcessCreateResponse.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程開始正常終了しました。", wSExecProcessCreateResponse.getSyousaimsg());

    }

    @Test
    public void testKyoukaiOK02() throws Exception {
        String gyoumukey = TestUtil.nString_zenkaku(20);

        CreateImageSpaceInBean createImageSpaceInBean = new CreateImageSpaceInBean();
        createImageSpaceInBean.setGyoumukey(gyoumukey);
        createImageSpaceInBean.setAccountid("Tt");
        createImageSpaceInBean.setProcessgroup("プロセスグループ");
        createImageSpaceInBean.setRirekiTaskName("履歴タスク名");
        List<Map<String, String>> extinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> extinfoMap = new HashMap<String, String>();
        extinfoMap.put("extinfo", "付加情報");
        extinfoMapList.add(extinfoMap);
        createImageSpaceInBean.setExtInfo(extinfoMapList);
        WSExecProcessCreateResponse wSExecProcessCreateResponse = iwfImageClient.execCreateImageSpace(createImageSpaceInBean);

        DeleteImageSpaceInBean aftDeleteImageSpaceInBean = new DeleteImageSpaceInBean();
        aftDeleteImageSpaceInBean.setGyoumukey(gyoumukey);
        aftDeleteImageSpaceInBean.setAccountid("Tt");
        WSExecProcessCancelResponse aftWSExecProcessCancelResponse = iwfImageClient.execDeleteImageSpace(aftDeleteImageSpaceInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftWSExecProcessCancelResponse.getKekkastatus())) {
            throw new Exception("後処理：イメージ登録領域削除実行失敗！");
        }

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), wSExecProcessCreateResponse.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", wSExecProcessCreateResponse.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程開始正常終了しました。", wSExecProcessCreateResponse.getSyousaimsg());

    }

    @Test
    public void testKyoukaiNG01() {
        String gyoumukey = TestUtil.nString_zenkaku(21);
        CreateImageSpaceInBean createImageSpaceInBean = new CreateImageSpaceInBean();
        createImageSpaceInBean.setGyoumukey(gyoumukey);
        createImageSpaceInBean.setAccountid("Tt");
        createImageSpaceInBean.setProcessgroup("プロセスグループ");
        createImageSpaceInBean.setRirekiTaskName("履歴タスク名");
        List<Map<String, String>> extinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> extinfoMap = new HashMap<String, String>();
        extinfoMap.put("extinfo", "付加情報");
        extinfoMapList.add(extinfoMap);
        createImageSpaceInBean.setExtInfo(extinfoMapList);
        WSExecProcessCreateResponse wSExecProcessCreateResponse = iwfImageClient.execCreateImageSpace(createImageSpaceInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), wSExecProcessCreateResponse.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0008", wSExecProcessCreateResponse.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "業務キーは20文字以内で入力してください。", wSExecProcessCreateResponse.getSyousaimsg());

    }

    @Test
    public void testKyoukaiOK03() throws Exception {
        String gyoumukey = "業務" + BizDate.getSysDateTimeMilli();
        IwfCoreConfig.getInstance().setLockYouhi(false);

        CreateImageSpaceInBean createImageSpaceInBean = new CreateImageSpaceInBean();
        createImageSpaceInBean.setGyoumukey(gyoumukey);
        createImageSpaceInBean.setAccountid("Tt");
        createImageSpaceInBean.setProcessgroup("プロセスグループ");
        createImageSpaceInBean.setRirekiTaskName("履歴タスク名");
        List<Map<String, String>> extinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> extinfoMap = new HashMap<String, String>();
        extinfoMap.put("extinfo", "付加情報");
        extinfoMapList.add(extinfoMap);
        createImageSpaceInBean.setExtInfo(extinfoMapList);
        WSExecProcessCreateResponse wSExecProcessCreateResponse = iwfImageClient.execCreateImageSpace(createImageSpaceInBean);

        DeleteImageSpaceInBean aftDeleteImageSpaceInBean = new DeleteImageSpaceInBean();
        aftDeleteImageSpaceInBean.setGyoumukey(gyoumukey);
        aftDeleteImageSpaceInBean.setAccountid("Tt");
        WSExecProcessCancelResponse aftWSExecProcessCancelResponse = iwfImageClient.execDeleteImageSpace(aftDeleteImageSpaceInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftWSExecProcessCancelResponse.getKekkastatus())) {
            throw new Exception("後処理：イメージ登録領域削除実行失敗！");
        }

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), wSExecProcessCreateResponse.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", wSExecProcessCreateResponse.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程開始正常終了しました。", wSExecProcessCreateResponse.getSyousaimsg());

    }

    @Test
    public void testKyoukaiOK04() throws Exception {
        String gyoumukey = BizDate.getSysDateTimeMilli();
        IwfCoreConfig.getInstance().setLockYouhi(false);

        CreateImageSpaceInBean createImageSpaceInBean = new CreateImageSpaceInBean();
        createImageSpaceInBean.setGyoumukey(gyoumukey);
        createImageSpaceInBean.setAccountid("ACID0000000000000000000000000");
        createImageSpaceInBean.setProcessgroup("プロセスグループ");
        createImageSpaceInBean.setRirekiTaskName("履歴タスク名");
        List<Map<String, String>> extinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> extinfoMap = new HashMap<String, String>();
        extinfoMap.put("extinfo", "付加情報");
        extinfoMapList.add(extinfoMap);
        createImageSpaceInBean.setExtInfo(extinfoMapList);
        WSExecProcessCreateResponse wSExecProcessCreateResponse = iwfImageClient.execCreateImageSpace(createImageSpaceInBean);

        DeleteImageSpaceInBean aftDeleteImageSpaceInBean = new DeleteImageSpaceInBean();
        aftDeleteImageSpaceInBean.setGyoumukey(gyoumukey);
        aftDeleteImageSpaceInBean.setAccountid("ACID0000000000000000000000000");
        WSExecProcessCancelResponse aftWSExecProcessCancelResponse = iwfImageClient.execDeleteImageSpace(aftDeleteImageSpaceInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftWSExecProcessCancelResponse.getKekkastatus())) {
            throw new Exception("後処理：イメージ登録領域削除実行失敗！");
        }

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), wSExecProcessCreateResponse.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", wSExecProcessCreateResponse.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程開始正常終了しました。", wSExecProcessCreateResponse.getSyousaimsg());

    }

    @Test
    public void testKyoukaiOK05() throws Exception {
        String gyoumukey = BizDate.getSysDateTimeMilli();
        IwfCoreConfig.getInstance().setLockYouhi(false);

        CreateImageSpaceInBean createImageSpaceInBean = new CreateImageSpaceInBean();
        createImageSpaceInBean.setGyoumukey(gyoumukey);
        createImageSpaceInBean.setAccountid("ACID00000000000000000000000001");
        createImageSpaceInBean.setProcessgroup("プロセスグループ");
        createImageSpaceInBean.setRirekiTaskName("履歴タスク名");
        List<Map<String, String>> extinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> extinfoMap = new HashMap<String, String>();
        extinfoMap.put("extinfo", "付加情報");
        extinfoMapList.add(extinfoMap);
        createImageSpaceInBean.setExtInfo(extinfoMapList);
        WSExecProcessCreateResponse wSExecProcessCreateResponse = iwfImageClient.execCreateImageSpace(createImageSpaceInBean);

        DeleteImageSpaceInBean aftDeleteImageSpaceInBean = new DeleteImageSpaceInBean();
        aftDeleteImageSpaceInBean.setGyoumukey(gyoumukey);
        aftDeleteImageSpaceInBean.setAccountid("ACID00000000000000000000000001");
        WSExecProcessCancelResponse aftWSExecProcessCancelResponse = iwfImageClient.execDeleteImageSpace(aftDeleteImageSpaceInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftWSExecProcessCancelResponse.getKekkastatus())) {
            throw new Exception("後処理：イメージ登録領域削除実行失敗！");
        }

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), wSExecProcessCreateResponse.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", wSExecProcessCreateResponse.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程開始正常終了しました。", wSExecProcessCreateResponse.getSyousaimsg());

    }

    @Test
    public void testKyoukaiNG02() {
        CreateImageSpaceInBean createImageSpaceInBean = new CreateImageSpaceInBean();
        createImageSpaceInBean.setGyoumukey("業務キー2_7");
        createImageSpaceInBean.setAccountid("ACID000000000000000000000000012");
        createImageSpaceInBean.setProcessgroup("プロセスグループ");
        createImageSpaceInBean.setRirekiTaskName("履歴タスク名");
        List<Map<String, String>> extinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> extinfoMap = new HashMap<String, String>();
        extinfoMap.put("extinfo", "付加情報");
        extinfoMapList.add(extinfoMap);
        createImageSpaceInBean.setExtInfo(extinfoMapList);
        WSExecProcessCreateResponse wSExecProcessCreateResponse = iwfImageClient.execCreateImageSpace(createImageSpaceInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), wSExecProcessCreateResponse.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0008", wSExecProcessCreateResponse.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "アカウントＩＤは30文字以内で入力してください。", wSExecProcessCreateResponse.getSyousaimsg());

    }

    @Test
    public void testKyoukaiOK06() throws Exception {
        String gyoumukey = BizDate.getSysDateTimeMilli();
        IwfCoreConfig.getInstance().setLockYouhi(false);

        CreateImageSpaceInBean createImageSpaceInBean = new CreateImageSpaceInBean();
        createImageSpaceInBean.setGyoumukey(gyoumukey);
        createImageSpaceInBean.setAccountid("Tt");
        createImageSpaceInBean.setProcessgroup("プロセスグループ");
        createImageSpaceInBean.setRirekiTaskName("履歴タスク名履歴タスク名履歴タスク名履歴タスク名");
        List<Map<String, String>> extinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> extinfoMap = new HashMap<String, String>();
        extinfoMap.put("extinfo", "付加情報");
        extinfoMapList.add(extinfoMap);
        createImageSpaceInBean.setExtInfo(extinfoMapList);
        WSExecProcessCreateResponse wSExecProcessCreateResponse = iwfImageClient.execCreateImageSpace(createImageSpaceInBean);

        DeleteImageSpaceInBean aftDeleteImageSpaceInBean = new DeleteImageSpaceInBean();
        aftDeleteImageSpaceInBean.setGyoumukey(gyoumukey);
        aftDeleteImageSpaceInBean.setAccountid("Tt");
        WSExecProcessCancelResponse aftWSExecProcessCancelResponse = iwfImageClient.execDeleteImageSpace(aftDeleteImageSpaceInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftWSExecProcessCancelResponse.getKekkastatus())) {
            throw new Exception("後処理：イメージ登録領域削除実行失敗！");
        }

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), wSExecProcessCreateResponse.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", wSExecProcessCreateResponse.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程開始正常終了しました。", wSExecProcessCreateResponse.getSyousaimsg());

    }

    @Test
    public void testKyoukaiOK07() throws Exception {
        String gyoumukey = BizDate.getSysDateTimeMilli();
        IwfCoreConfig.getInstance().setLockYouhi(false);

        CreateImageSpaceInBean createImageSpaceInBean = new CreateImageSpaceInBean();
        createImageSpaceInBean.setGyoumukey(gyoumukey);
        createImageSpaceInBean.setAccountid("Tt");
        createImageSpaceInBean.setProcessgroup("プロセスグループ");
        createImageSpaceInBean.setRirekiTaskName("履歴タスク名履歴タスク名履歴タスク名履歴タスク名履");
        List<Map<String, String>> extinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> extinfoMap = new HashMap<String, String>();
        extinfoMap.put("extinfo", "付加情報");
        extinfoMapList.add(extinfoMap);
        createImageSpaceInBean.setExtInfo(extinfoMapList);
        WSExecProcessCreateResponse wSExecProcessCreateResponse = iwfImageClient.execCreateImageSpace(createImageSpaceInBean);

        DeleteImageSpaceInBean aftDeleteImageSpaceInBean = new DeleteImageSpaceInBean();
        aftDeleteImageSpaceInBean.setGyoumukey(gyoumukey);
        aftDeleteImageSpaceInBean.setAccountid("Tt");
        WSExecProcessCancelResponse aftWSExecProcessCancelResponse = iwfImageClient.execDeleteImageSpace(aftDeleteImageSpaceInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftWSExecProcessCancelResponse.getKekkastatus())) {
            throw new Exception("後処理：イメージ登録領域削除実行失敗！");
        }

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), wSExecProcessCreateResponse.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", wSExecProcessCreateResponse.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程開始正常終了しました。", wSExecProcessCreateResponse.getSyousaimsg());

    }

    @Test
    public void testKyoukaiNG03() {
        CreateImageSpaceInBean createImageSpaceInBean = new CreateImageSpaceInBean();
        createImageSpaceInBean.setGyoumukey("業務キー2_11");
        createImageSpaceInBean.setAccountid("Tt");
        createImageSpaceInBean.setProcessgroup("プロセスグループ");
        createImageSpaceInBean.setRirekiTaskName("履歴タスク名履歴タスク名履歴タスク名履歴タスク名履歴");
        List<Map<String, String>> extinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> extinfoMap = new HashMap<String, String>();
        extinfoMap.put("extinfo", "付加情報");
        extinfoMapList.add(extinfoMap);
        createImageSpaceInBean.setExtInfo(extinfoMapList);
        WSExecProcessCreateResponse wSExecProcessCreateResponse = iwfImageClient.execCreateImageSpace(createImageSpaceInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), wSExecProcessCreateResponse.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0008", wSExecProcessCreateResponse.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "履歴タスク名は25文字以内で入力してください。", wSExecProcessCreateResponse.getSyousaimsg());

    }

    @Test
    public void testKyoukaiOK08() throws Exception {
        String gyoumukey = BizDate.getSysDateTimeMilli();
        IwfCoreConfig.getInstance().setLockYouhi(false);

        CreateImageSpaceInBean createImageSpaceInBean = new CreateImageSpaceInBean();
        createImageSpaceInBean.setGyoumukey(gyoumukey);
        createImageSpaceInBean.setAccountid("Tt");
        createImageSpaceInBean.setProcessgroup("プロセスグループ");
        createImageSpaceInBean.setRirekiTaskName("履歴タスク名0001");
        List<Map<String, String>> extinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> extinfoMap = new HashMap<String, String>();
        extinfoMap.put("extinfo", "付加情報");
        extinfoMapList.add(extinfoMap);
        createImageSpaceInBean.setExtInfo(extinfoMapList);
        WSExecProcessCreateResponse wSExecProcessCreateResponse = iwfImageClient.execCreateImageSpace(createImageSpaceInBean);

        DeleteImageSpaceInBean aftDeleteImageSpaceInBean = new DeleteImageSpaceInBean();
        aftDeleteImageSpaceInBean.setGyoumukey(gyoumukey);
        aftDeleteImageSpaceInBean.setAccountid("Tt");
        WSExecProcessCancelResponse aftWSExecProcessCancelResponse = iwfImageClient.execDeleteImageSpace(aftDeleteImageSpaceInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftWSExecProcessCancelResponse.getKekkastatus())) {
            throw new Exception("後処理：イメージ登録領域削除実行失敗！");
        }

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), wSExecProcessCreateResponse.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", wSExecProcessCreateResponse.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程開始正常終了しました。", wSExecProcessCreateResponse.getSyousaimsg());

    }

    @Test
    public void testInfoExistNG01() throws Exception {
        String gyoumukey = BizDate.getSysDateTimeMilli();
        String lockKey = BizDate.getSysDateTimeMilli();
        IwfCoreConfig.getInstance().setLockYouhi(false);

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setGyoumukey(gyoumukey);
        befProcessCreateInBean.setFlowid("system-image-space");
        befProcessCreateInBean.setAccountid("Tt");
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        CreateImageSpaceInBean createImageSpaceInBean = new CreateImageSpaceInBean();
        createImageSpaceInBean.setGyoumukey(gyoumukey);
        createImageSpaceInBean.setAccountid("Tt");
        createImageSpaceInBean.setProcessgroup("プロセスグループ");
        createImageSpaceInBean.setRirekiTaskName("履歴タスク名");
        List<Map<String, String>> extinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> extinfoMap = new HashMap<String, String>();
        extinfoMap.put("extinfo", "付加情報");
        extinfoMapList.add(extinfoMap);
        createImageSpaceInBean.setExtInfo(extinfoMapList);
        WSExecProcessCreateResponse wSExecProcessCreateResponse = iwfImageClient.execCreateImageSpace(createImageSpaceInBean);

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey(gyoumukey);
        aftProcessCancelInBean.setFlowid("system-image-space");
        aftProcessCancelInBean.setAccountid("Tt");
        aftProcessCancelInBean.setLockkey(lockKey);
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), wSExecProcessCreateResponse.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF2051", wSExecProcessCreateResponse.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "指定された業務キー、フローIDに紐付くトークンは、既に存在しています。", wSExecProcessCreateResponse.getSyousaimsg());

    }

    public void testInfoExistNG02() {
        String gyoumukey = BizDate.getSysDateTimeMilli();

        CreateImageSpaceInBean createImageSpaceInBean = new CreateImageSpaceInBean();
        createImageSpaceInBean.setGyoumukey(gyoumukey);
        createImageSpaceInBean.setAccountid("Tt");
        createImageSpaceInBean.setProcessgroup("プロセスグループ");
        createImageSpaceInBean.setRirekiTaskName("履歴タスク名");
        List<Map<String, String>> extinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> extinfoMap = new HashMap<String, String>();
        extinfoMap.put("extinfo", "付加情報");
        extinfoMapList.add(extinfoMap);
        createImageSpaceInBean.setExtInfo(extinfoMapList);
        IwfCoreConfig.getInstance().setLockYouhi(false);
        WSExecProcessCreateResponse wSExecProcessCreateResponse = iwfImageClient.execCreateImageSpace(createImageSpaceInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), wSExecProcessCreateResponse.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF2053", wSExecProcessCreateResponse.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "プロセス定義が取得できませんでした。", wSExecProcessCreateResponse.getSyousaimsg());

    }

    @Test
    public void testSyoriLogicOK01() throws Exception {
        String gyoumukey = BizDate.getSysDateTimeMilli();
        IwfCoreConfig.getInstance().setLockYouhi(false);

        CreateImageSpaceInBean createImageSpaceInBean = new CreateImageSpaceInBean();
        createImageSpaceInBean.setGyoumukey(gyoumukey);
        createImageSpaceInBean.setAccountid("Tt");
        createImageSpaceInBean.setProcessgroup("プロセスグループ");
        createImageSpaceInBean.setRirekiTaskName("履歴タスク名");
        List<Map<String, String>> extinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> extinfoMap = new HashMap<String, String>();
        extinfoMap.put("extinfo", "付加情報");
        extinfoMapList.add(extinfoMap);
        createImageSpaceInBean.setExtInfo(extinfoMapList);
        WSExecProcessCreateResponse wSExecProcessCreateResponse = iwfImageClient.execCreateImageSpace(createImageSpaceInBean);

        DeleteImageSpaceInBean aftDeleteImageSpaceInBean = new DeleteImageSpaceInBean();
        aftDeleteImageSpaceInBean.setGyoumukey(gyoumukey);
        aftDeleteImageSpaceInBean.setAccountid("Tt");
        WSExecProcessCancelResponse aftWSExecProcessCancelResponse = iwfImageClient.execDeleteImageSpace(aftDeleteImageSpaceInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftWSExecProcessCancelResponse.getKekkastatus())) {
            throw new Exception("後処理：イメージ登録領域削除実行失敗！");
        }

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), wSExecProcessCreateResponse.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", wSExecProcessCreateResponse.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程開始正常終了しました。", wSExecProcessCreateResponse.getSyousaimsg());

    }
}
