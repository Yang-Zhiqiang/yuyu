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
import yuyu.common.biz.workflow.io.koutei.StartTaskInBean;
import yuyu.common.biz.workflow.io.koutei.StartTaskOutBean;
import yuyu.common.biz.workflow.io.koutei.UnassignTaskInBean;
import yuyu.common.biz.workflow.io.koutei.UnassignTaskOutBean;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.def.db.entity.JBPM_TASKINSTANCE;
import yuyu.def.db.entity.WT_GyoumuKey;
import yuyu.def.db.entity.WT_KouteiSummary;
import yuyu.def.workflowcore.configration.IwfCoreConfig;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.exectaskcancel.WSExecTaskCancel;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.exectaskcancel.WSExecTaskCancelRequest;

/**
 * 割当解除Webサービス {@link WSExecTaskCancel#executeBizMain(WSExecTaskCancelRequest)} テスト用クラスです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class UnassignTaskWebServiceTest {

    @Inject
    IwfKouteiClient iwfKouteiClient;

    @Inject
    private IwfCoreDomManager iwfCoreDomManager;

    @Test(expected = RuntimeException.class)
    public void testValidationNG01() {

        iwfKouteiClient.execUnsignTask(null);
    }

    @Test
    public void testValidationNG02() {

        UnassignTaskInBean unassignTaskInBean = new UnassignTaskInBean();
        unassignTaskInBean.setGyoumukey(null);
        unassignTaskInBean.setFlowid("tt4");
        unassignTaskInBean.setAccountid("JUnit");
        unassignTaskInBean.setRirekiaccountid("履歴用アカウントＩＤ");
        List<Map<String, String>> extinfoMapList = new ArrayList<>();
        Map<String, String> extinfoMap = new HashMap<>();
        extinfoMap.put("extinfo", "付加情報");
        extinfoMapList.add(extinfoMap);
        unassignTaskInBean.setExtInfo(extinfoMapList);
        unassignTaskInBean.setLockkey("ロックキー1_2");
        UnassignTaskOutBean unassignTaskOutBean = iwfKouteiClient.execUnsignTask(unassignTaskInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), unassignTaskOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", unassignTaskOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "必須入力チェックエラー：業務キー", unassignTaskOutBean.getSyousaimsg());

    }

    @Test
    public void testValidationNG03() {

        UnassignTaskInBean unassignTaskInBean = new UnassignTaskInBean();
        unassignTaskInBean.setGyoumukey("");
        unassignTaskInBean.setFlowid("tt4");
        unassignTaskInBean.setAccountid("JUnit");
        unassignTaskInBean.setRirekiaccountid("履歴用アカウントＩＤ");
        List<Map<String, String>> extinfoMapList = new ArrayList<>();
        Map<String, String> extinfoMap = new HashMap<>();
        extinfoMap.put("extinfo", "付加情報");
        extinfoMapList.add(extinfoMap);
        unassignTaskInBean.setExtInfo(extinfoMapList);
        unassignTaskInBean.setLockkey("ロックキー1_3");
        UnassignTaskOutBean unassignTaskOutBean = iwfKouteiClient.execUnsignTask(unassignTaskInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), unassignTaskOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", unassignTaskOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "必須入力チェックエラー：業務キー", unassignTaskOutBean.getSyousaimsg());

    }

    @Test
    public void testValidationNG04() {

        UnassignTaskInBean unassignTaskInBean = new UnassignTaskInBean();
        unassignTaskInBean.setGyoumukey("業務キー1_4");
        unassignTaskInBean.setFlowid(null);
        unassignTaskInBean.setAccountid("JUnit");
        unassignTaskInBean.setRirekiaccountid("履歴用アカウントＩＤ");
        List<Map<String, String>> extinfoMapList = new ArrayList<>();
        Map<String, String> extinfoMap = new HashMap<>();
        extinfoMap.put("extinfo", "付加情報");
        extinfoMapList.add(extinfoMap);
        unassignTaskInBean.setExtInfo(extinfoMapList);
        unassignTaskInBean.setLockkey("ロックキー1_4");
        UnassignTaskOutBean unassignTaskOutBean = iwfKouteiClient.execUnsignTask(unassignTaskInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), unassignTaskOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", unassignTaskOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "必須入力チェックエラー：フローＩＤ", unassignTaskOutBean.getSyousaimsg());

    }

    @Test
    public void testValidationNG05() {

        UnassignTaskInBean unassignTaskInBean = new UnassignTaskInBean();
        unassignTaskInBean.setGyoumukey("業務キー1_5");
        unassignTaskInBean.setFlowid("");
        unassignTaskInBean.setAccountid("JUnit");
        unassignTaskInBean.setRirekiaccountid("履歴用アカウントＩＤ");
        List<Map<String, String>> extinfoMapList = new ArrayList<>();
        Map<String, String> extinfoMap = new HashMap<>();
        extinfoMap.put("extinfo", "付加情報");
        extinfoMapList.add(extinfoMap);
        unassignTaskInBean.setExtInfo(extinfoMapList);
        unassignTaskInBean.setLockkey("ロックキー1_5");
        UnassignTaskOutBean unassignTaskOutBean = iwfKouteiClient.execUnsignTask(unassignTaskInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), unassignTaskOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", unassignTaskOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "必須入力チェックエラー：フローＩＤ", unassignTaskOutBean.getSyousaimsg());

    }

    @Test
    public void testValidationNG06() {

        UnassignTaskInBean unassignTaskInBean = new UnassignTaskInBean();
        unassignTaskInBean.setGyoumukey("業務キー1_6");
        unassignTaskInBean.setFlowid("tt4");
        unassignTaskInBean.setAccountid(null);
        unassignTaskInBean.setRirekiaccountid("履歴用アカウントＩＤ");
        List<Map<String, String>> extinfoMapList = new ArrayList<>();
        Map<String, String> extinfoMap = new HashMap<>();
        extinfoMap.put("extinfo", "付加情報");
        extinfoMapList.add(extinfoMap);
        unassignTaskInBean.setExtInfo(extinfoMapList);
        unassignTaskInBean.setLockkey("ロックキー1_6");
        UnassignTaskOutBean unassignTaskOutBean = iwfKouteiClient.execUnsignTask(unassignTaskInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), unassignTaskOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", unassignTaskOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "必須入力チェックエラー：アカウントＩＤ", unassignTaskOutBean.getSyousaimsg());

    }

    @Test
    public void testValidationNG07() {

        UnassignTaskInBean unassignTaskInBean = new UnassignTaskInBean();
        unassignTaskInBean.setGyoumukey("業務キー1_7");
        unassignTaskInBean.setFlowid("tt4");
        unassignTaskInBean.setAccountid("");
        unassignTaskInBean.setRirekiaccountid("履歴用アカウントＩＤ");
        List<Map<String, String>> extinfoMapList = new ArrayList<>();
        Map<String, String> extinfoMap = new HashMap<>();
        extinfoMap.put("extinfo", "付加情報");
        extinfoMapList.add(extinfoMap);
        unassignTaskInBean.setExtInfo(extinfoMapList);
        unassignTaskInBean.setLockkey("ロックキー1_7");
        UnassignTaskOutBean unassignTaskOutBean = iwfKouteiClient.execUnsignTask(unassignTaskInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), unassignTaskOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", unassignTaskOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "必須入力チェックエラー：アカウントＩＤ", unassignTaskOutBean.getSyousaimsg());

    }

    @Test
    public void testValidationNG08() {

        UnassignTaskInBean unassignTaskInBean = new UnassignTaskInBean();
        unassignTaskInBean.setGyoumukey("業務キー1_8");
        unassignTaskInBean.setFlowid("tt4");
        unassignTaskInBean.setAccountid("JUnit");
        unassignTaskInBean.setRirekiaccountid("履歴用アカウントＩＤ");
        List<Map<String, String>> extinfoMapList = new ArrayList<>();
        Map<String, String> extinfoMap = new HashMap<>();
        extinfoMap.put("extinfo", "付加情報");
        extinfoMapList.add(extinfoMap);
        unassignTaskInBean.setExtInfo(extinfoMapList);
        unassignTaskInBean.setLockkey(null);
        UnassignTaskOutBean unassignTaskOutBean = iwfKouteiClient.execUnsignTask(unassignTaskInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), unassignTaskOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", unassignTaskOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "必須入力チェックエラー：ロックキー", unassignTaskOutBean.getSyousaimsg());

    }

    @Test
    public void testValidationNG09() {

        UnassignTaskInBean unassignTaskInBean = new UnassignTaskInBean();
        unassignTaskInBean.setGyoumukey("業務キー1_9");
        unassignTaskInBean.setFlowid("tt4");
        unassignTaskInBean.setAccountid("JUnit");
        unassignTaskInBean.setRirekiaccountid("履歴用アカウントＩＤ");
        List<Map<String, String>> extinfoMapList = new ArrayList<>();
        Map<String, String> extinfoMap = new HashMap<>();
        extinfoMap.put("extinfo", "付加情報");
        extinfoMapList.add(extinfoMap);
        unassignTaskInBean.setExtInfo(extinfoMapList);
        unassignTaskInBean.setLockkey("");
        UnassignTaskOutBean unassignTaskOutBean = iwfKouteiClient.execUnsignTask(unassignTaskInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), unassignTaskOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", unassignTaskOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "必須入力チェックエラー：ロックキー", unassignTaskOutBean.getSyousaimsg());

    }

    @Test
    public void testValidationOK01() throws Exception {

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

        StartTaskInBean befStartTaskInBean = new StartTaskInBean();
        befStartTaskInBean.setGyoumukey(pGyoumukey);
        befStartTaskInBean.setFlowid("tt4");
        befStartTaskInBean.setAccountid("JUnit");
        befStartTaskInBean.setTaskname("data-check1");
        StartTaskOutBean befStartTaskOutBean = iwfKouteiClient.execStartTask(befStartTaskInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befStartTaskOutBean.getKekkastatus())) {
            throw new Exception("前処理：タスク開始実行失敗！");
        }

        UnassignTaskInBean unassignTaskInBean = new UnassignTaskInBean();
        unassignTaskInBean.setGyoumukey(pGyoumukey);
        unassignTaskInBean.setFlowid("tt4");
        unassignTaskInBean.setAccountid("JUnit");
        unassignTaskInBean.setRirekiaccountid(null);
        List<Map<String, String>> extinfoMapList = new ArrayList<>();
        Map<String, String> extinfoMap = new HashMap<>();
        extinfoMap.put("extinfo", null);
        extinfoMapList.add(extinfoMap);
        unassignTaskInBean.setExtInfo(extinfoMapList);
        unassignTaskInBean.setLockkey(null);
        UnassignTaskOutBean unassignTaskOutBean = iwfKouteiClient.execUnsignTask(unassignTaskInBean);

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey(pGyoumukey);
        aftProcessCancelInBean.setFlowid("tt4");
        aftProcessCancelInBean.setAccountid("JUnit");
        aftProcessCancelInBean.setLockkey("ロックキー1_10");
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), unassignTaskOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", unassignTaskOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "タスク取消正常終了しました。", unassignTaskOutBean.getSyousaimsg());

        IwfCoreConfig.getInstance().setLockYouhi(true);

    }

    @Test
    public void testValidationOK02() throws Exception {

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

        StartTaskInBean befStartTaskInBean = new StartTaskInBean();
        befStartTaskInBean.setGyoumukey(pGyoumukey);
        befStartTaskInBean.setFlowid("tt4");
        befStartTaskInBean.setAccountid("JUnit");
        befStartTaskInBean.setTaskname("data-check1");
        StartTaskOutBean befStartTaskOutBean = iwfKouteiClient.execStartTask(befStartTaskInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befStartTaskOutBean.getKekkastatus())) {
            throw new Exception("前処理：タスク開始実行失敗！");
        }

        UnassignTaskInBean unassignTaskInBean = new UnassignTaskInBean();
        unassignTaskInBean.setGyoumukey(pGyoumukey);
        unassignTaskInBean.setFlowid("tt4");
        unassignTaskInBean.setAccountid("JUnit");
        unassignTaskInBean.setRirekiaccountid("");
        List<Map<String, String>> extinfoMapList = new ArrayList<>();
        Map<String, String> extinfoMap = new HashMap<>();
        extinfoMap.put("extinfo", "");
        extinfoMapList.add(extinfoMap);
        unassignTaskInBean.setExtInfo(extinfoMapList);
        unassignTaskInBean.setLockkey("");
        UnassignTaskOutBean unassignTaskOutBean = iwfKouteiClient.execUnsignTask(unassignTaskInBean);

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey(pGyoumukey);
        aftProcessCancelInBean.setFlowid("tt4");
        aftProcessCancelInBean.setAccountid("JUnit");
        aftProcessCancelInBean.setLockkey("ロックキー1_11");
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), unassignTaskOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", unassignTaskOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "タスク取消正常終了しました。", unassignTaskOutBean.getSyousaimsg());

        IwfCoreConfig.getInstance().setLockYouhi(true);

    }

    @Test
    public void testKyoukaiOK01() throws Exception {

        String gyoumukey = TestUtil.nString_zenkaku(19);
        String lockKey = BizDate.getSysDateTimeMilli();
        IwfCoreConfig.getInstance().setLockYouhi(true);

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setGyoumukey(gyoumukey);
        befProcessCreateInBean.setFlowid("tt4");
        befProcessCreateInBean.setAccountid("JUnit");
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        LockProcessInBean befLockProcessInBean = new LockProcessInBean();
        befLockProcessInBean.setGyoumukey(gyoumukey);
        befLockProcessInBean.setFlowid("tt4");
        befLockProcessInBean.setLockkey(lockKey);
        LockProcessOutBean befLockProcessOutBean = iwfKouteiClient.execLockProcess(befLockProcessInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befLockProcessOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程ロック開始実行失敗！");
        }

        StartTaskInBean befStartTaskInBean = new StartTaskInBean();
        befStartTaskInBean.setGyoumukey(gyoumukey);
        befStartTaskInBean.setFlowid("tt4");
        befStartTaskInBean.setAccountid("JUnit");
        befStartTaskInBean.setTaskname("data-check1");
        befStartTaskInBean.setLockkey(lockKey);
        StartTaskOutBean befStartTaskOutBean = iwfKouteiClient.execStartTask(befStartTaskInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befStartTaskOutBean.getKekkastatus())) {
            throw new Exception("前処理：タスク開始実行失敗！");
        }

        UnassignTaskInBean unassignTaskInBean = new UnassignTaskInBean();
        unassignTaskInBean.setGyoumukey(gyoumukey);
        unassignTaskInBean.setFlowid("tt4");
        unassignTaskInBean.setAccountid("JUnit");
        unassignTaskInBean.setRirekiaccountid("HACID001");
        List<Map<String, String>> extinfoMapList = new ArrayList<>();
        Map<String, String> extinfoMap = new HashMap<>();
        extinfoMap.put("extinfo", "付加情報");
        extinfoMapList.add(extinfoMap);
        unassignTaskInBean.setExtInfo(extinfoMapList);
        unassignTaskInBean.setLockkey(lockKey);
        UnassignTaskOutBean unassignTaskOutBean = iwfKouteiClient.execUnsignTask(unassignTaskInBean);

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey(gyoumukey);
        aftProcessCancelInBean.setFlowid("tt4");
        aftProcessCancelInBean.setAccountid("JUnit");
        aftProcessCancelInBean.setLockkey(lockKey);
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), unassignTaskOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", unassignTaskOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "タスク取消正常終了しました。", unassignTaskOutBean.getSyousaimsg());

    }

    @Test
    public void testKyoukaiOK02() throws Exception {

        String gyoumukey = TestUtil.nString_zenkaku(20);
        String lockKey = BizDate.getSysDateTimeMilli();
        IwfCoreConfig.getInstance().setLockYouhi(true);

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setGyoumukey(gyoumukey);
        befProcessCreateInBean.setFlowid("tt4");
        befProcessCreateInBean.setAccountid("JUnit");
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        LockProcessInBean befLockProcessInBean = new LockProcessInBean();
        befLockProcessInBean.setGyoumukey(gyoumukey);
        befLockProcessInBean.setFlowid("tt4");
        befLockProcessInBean.setLockkey(lockKey);
        LockProcessOutBean befLockProcessOutBean = iwfKouteiClient.execLockProcess(befLockProcessInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befLockProcessOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程ロック開始実行失敗！");
        }

        StartTaskInBean befStartTaskInBean = new StartTaskInBean();
        befStartTaskInBean.setGyoumukey(gyoumukey);
        befStartTaskInBean.setFlowid("tt4");
        befStartTaskInBean.setAccountid("JUnit");
        befStartTaskInBean.setTaskname("data-check1");
        befStartTaskInBean.setLockkey(lockKey);
        StartTaskOutBean befStartTaskOutBean = iwfKouteiClient.execStartTask(befStartTaskInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befStartTaskOutBean.getKekkastatus())) {
            throw new Exception("前処理：タスク開始実行失敗！");
        }

        UnassignTaskInBean unassignTaskInBean = new UnassignTaskInBean();
        unassignTaskInBean.setGyoumukey(gyoumukey);
        unassignTaskInBean.setFlowid("tt4");
        unassignTaskInBean.setAccountid("JUnit");
        unassignTaskInBean.setRirekiaccountid("HACID001");
        List<Map<String, String>> extinfoMapList = new ArrayList<>();
        Map<String, String> extinfoMap = new HashMap<>();
        extinfoMap.put("extinfo", "付加情報");
        extinfoMapList.add(extinfoMap);
        unassignTaskInBean.setExtInfo(extinfoMapList);
        unassignTaskInBean.setLockkey(lockKey);
        UnassignTaskOutBean unassignTaskOutBean = iwfKouteiClient.execUnsignTask(unassignTaskInBean);

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey(gyoumukey);
        aftProcessCancelInBean.setFlowid("tt4");
        aftProcessCancelInBean.setAccountid("JUnit");
        aftProcessCancelInBean.setLockkey(lockKey);
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), unassignTaskOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", unassignTaskOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "タスク取消正常終了しました。", unassignTaskOutBean.getSyousaimsg());

    }

    @Test
    public void testKyoukaiNG01() {

        String gyoumukey = TestUtil.nString_zenkaku(21);
        String lockKey = BizDate.getSysDateTimeMilli();

        UnassignTaskInBean unassignTaskInBean = new UnassignTaskInBean();
        unassignTaskInBean.setGyoumukey(gyoumukey);
        unassignTaskInBean.setFlowid("tt4");
        unassignTaskInBean.setAccountid("JUnit");
        unassignTaskInBean.setRirekiaccountid("HACID001");
        List<Map<String, String>> extinfoMapList = new ArrayList<>();
        Map<String, String> extinfoMap = new HashMap<>();
        extinfoMap.put("extinfo", "付加情報");
        extinfoMapList.add(extinfoMap);
        unassignTaskInBean.setExtInfo(extinfoMapList);
        unassignTaskInBean.setLockkey(lockKey);
        UnassignTaskOutBean unassignTaskOutBean = iwfKouteiClient.execUnsignTask(unassignTaskInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), unassignTaskOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0008", unassignTaskOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "業務キーは20文字以内で入力してください。", unassignTaskOutBean.getSyousaimsg());

    }

    @Test
    public void testKyoukaiOK03() throws Exception {

        String gyoumukey = "業務" + BizDate.getSysDateTimeMilli();
        String lockKey = BizDate.getSysDateTimeMilli();
        IwfCoreConfig.getInstance().setLockYouhi(true);

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setGyoumukey(gyoumukey);
        befProcessCreateInBean.setFlowid("tt4");
        befProcessCreateInBean.setAccountid("JUnit");
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        LockProcessInBean befLockProcessInBean = new LockProcessInBean();
        befLockProcessInBean.setGyoumukey(gyoumukey);
        befLockProcessInBean.setFlowid("tt4");
        befLockProcessInBean.setLockkey(lockKey);
        LockProcessOutBean befLockProcessOutBean = iwfKouteiClient.execLockProcess(befLockProcessInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befLockProcessOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程ロック開始実行失敗！");
        }

        StartTaskInBean befStartTaskInBean = new StartTaskInBean();
        befStartTaskInBean.setGyoumukey(gyoumukey);
        befStartTaskInBean.setFlowid("tt4");
        befStartTaskInBean.setAccountid("JUnit");
        befStartTaskInBean.setTaskname("data-check1");
        befStartTaskInBean.setLockkey(lockKey);
        StartTaskOutBean befStartTaskOutBean = iwfKouteiClient.execStartTask(befStartTaskInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befStartTaskOutBean.getKekkastatus())) {
            throw new Exception("前処理：タスク開始実行失敗！");
        }

        UnassignTaskInBean unassignTaskInBean = new UnassignTaskInBean();
        unassignTaskInBean.setGyoumukey(gyoumukey);
        unassignTaskInBean.setFlowid("tt4");
        unassignTaskInBean.setAccountid("JUnit");
        unassignTaskInBean.setRirekiaccountid("HACID001");
        List<Map<String, String>> extinfoMapList = new ArrayList<>();
        Map<String, String> extinfoMap = new HashMap<>();
        extinfoMap.put("extinfo", "付加情報");
        extinfoMapList.add(extinfoMap);
        unassignTaskInBean.setExtInfo(extinfoMapList);
        unassignTaskInBean.setLockkey(lockKey);
        UnassignTaskOutBean unassignTaskOutBean = iwfKouteiClient.execUnsignTask(unassignTaskInBean);

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey(gyoumukey);
        aftProcessCancelInBean.setFlowid("tt4");
        aftProcessCancelInBean.setAccountid("JUnit");
        aftProcessCancelInBean.setLockkey(lockKey);
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), unassignTaskOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", unassignTaskOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "タスク取消正常終了しました。", unassignTaskOutBean.getSyousaimsg());

    }

    @Test
    public void testKyoukaiOK04() throws Exception {

        String pGyoumukey = BizDate.getSysDateTimeMilli();

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setGyoumukey(pGyoumukey);
        befProcessCreateInBean.setFlowid("フローフローフローフローフロ十八文字");
        befProcessCreateInBean.setAccountid("JUnit");
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        LockProcessInBean befLockProcessInBean = new LockProcessInBean();
        befLockProcessInBean.setGyoumukey(pGyoumukey);
        befLockProcessInBean.setFlowid("フローフローフローフローフロ十八文字");
        befLockProcessInBean.setLockkey("ロックキー2_5");
        LockProcessOutBean befLockProcessOutBean = iwfKouteiClient.execLockProcess(befLockProcessInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befLockProcessOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程ロック開始実行失敗！");
        }

        StartTaskInBean befStartTaskInBean = new StartTaskInBean();
        befStartTaskInBean.setGyoumukey(pGyoumukey);
        befStartTaskInBean.setFlowid("フローフローフローフローフロ十八文字");
        befStartTaskInBean.setAccountid("JUnit");
        befStartTaskInBean.setTaskname("data-check1");
        befStartTaskInBean.setLockkey("ロックキー2_5");
        StartTaskOutBean befStartTaskOutBean = iwfKouteiClient.execStartTask(befStartTaskInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befStartTaskOutBean.getKekkastatus())) {
            throw new Exception("前処理：タスク開始実行失敗！");
        }

        UnassignTaskInBean unassignTaskInBean = new UnassignTaskInBean();
        unassignTaskInBean.setGyoumukey(pGyoumukey);
        unassignTaskInBean.setFlowid("フローフローフローフローフロ十八文字");
        unassignTaskInBean.setAccountid("JUnit");
        unassignTaskInBean.setRirekiaccountid("HACID001");
        List<Map<String, String>> extinfoMapList = new ArrayList<>();
        Map<String, String> extinfoMap = new HashMap<>();
        extinfoMap.put("extinfo", "付加情報");
        extinfoMapList.add(extinfoMap);
        unassignTaskInBean.setExtInfo(extinfoMapList);
        unassignTaskInBean.setLockkey("ロックキー2_5");
        UnassignTaskOutBean unassignTaskOutBean = iwfKouteiClient.execUnsignTask(unassignTaskInBean);

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey(pGyoumukey);
        aftProcessCancelInBean.setFlowid("フローフローフローフローフロ十八文字");
        aftProcessCancelInBean.setAccountid("JUnit");
        aftProcessCancelInBean.setLockkey("ロックキー2_5");
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), unassignTaskOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", unassignTaskOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "タスク取消正常終了しました。", unassignTaskOutBean.getSyousaimsg());

    }

    @Test
    public void testKyoukaiOK05() throws Exception {

        String pGyoumukey = BizDate.getSysDateTimeMilli();

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setGyoumukey(pGyoumukey);
        befProcessCreateInBean.setFlowid("フローフローフローフローフロー十九文字");
        befProcessCreateInBean.setAccountid("JUnit");
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        LockProcessInBean befLockProcessInBean = new LockProcessInBean();
        befLockProcessInBean.setGyoumukey(pGyoumukey);
        befLockProcessInBean.setFlowid("フローフローフローフローフロー十九文字");
        befLockProcessInBean.setLockkey("ロックキー2_6");
        LockProcessOutBean befLockProcessOutBean = iwfKouteiClient.execLockProcess(befLockProcessInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befLockProcessOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程ロック開始実行失敗！");
        }

        StartTaskInBean befStartTaskInBean = new StartTaskInBean();
        befStartTaskInBean.setGyoumukey(pGyoumukey);
        befStartTaskInBean.setFlowid("フローフローフローフローフロー十九文字");
        befStartTaskInBean.setAccountid("JUnit");
        befStartTaskInBean.setTaskname("data-check1");
        befStartTaskInBean.setLockkey("ロックキー2_6");
        StartTaskOutBean befStartTaskOutBean = iwfKouteiClient.execStartTask(befStartTaskInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befStartTaskOutBean.getKekkastatus())) {
            throw new Exception("前処理：タスク開始実行失敗！");
        }

        UnassignTaskInBean unassignTaskInBean = new UnassignTaskInBean();
        unassignTaskInBean.setGyoumukey(pGyoumukey);
        unassignTaskInBean.setFlowid("フローフローフローフローフロー十九文字");
        unassignTaskInBean.setAccountid("JUnit");
        unassignTaskInBean.setRirekiaccountid("HACID001");
        List<Map<String, String>> extinfoMapList = new ArrayList<>();
        Map<String, String> extinfoMap = new HashMap<>();
        extinfoMap.put("extinfo", "付加情報");
        extinfoMapList.add(extinfoMap);
        unassignTaskInBean.setExtInfo(extinfoMapList);
        unassignTaskInBean.setLockkey("ロックキー2_6");
        UnassignTaskOutBean unassignTaskOutBean = iwfKouteiClient.execUnsignTask(unassignTaskInBean);

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey(pGyoumukey);
        aftProcessCancelInBean.setFlowid("フローフローフローフローフロー十九文字");
        aftProcessCancelInBean.setAccountid("JUnit");
        aftProcessCancelInBean.setLockkey("ロックキー2_6");
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), unassignTaskOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", unassignTaskOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "タスク取消正常終了しました。", unassignTaskOutBean.getSyousaimsg());

    }

    @Test
    public void testKyoukaiNG02() {

        String pGyoumukey = BizDate.getSysDateTimeMilli();

        UnassignTaskInBean unassignTaskInBean = new UnassignTaskInBean();
        unassignTaskInBean.setGyoumukey(pGyoumukey);
        unassignTaskInBean.setFlowid("フローＩＤフローＩＤフローＩＤフローＩＤ");
        unassignTaskInBean.setAccountid("JUnit");
        unassignTaskInBean.setRirekiaccountid("履歴用アカウントＩＤ");
        List<Map<String, String>> extinfoMapList = new ArrayList<>();
        Map<String, String> extinfoMap = new HashMap<>();
        extinfoMap.put("extinfo", "付加情報");
        extinfoMapList.add(extinfoMap);
        unassignTaskInBean.setExtInfo(extinfoMapList);
        unassignTaskInBean.setLockkey("ロックキー2_7");
        UnassignTaskOutBean unassignTaskOutBean = iwfKouteiClient.execUnsignTask(unassignTaskInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), unassignTaskOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0008", unassignTaskOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "フローＩＤは19文字以内で入力してください。", unassignTaskOutBean.getSyousaimsg());

    }

    @Test
    public void testKyoukaiOK06() throws Exception {

        String pGyoumukey = BizDate.getSysDateTimeMilli();

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setGyoumukey(pGyoumukey);
        befProcessCreateInBean.setFlowid("フローＩＤflow0001");
        befProcessCreateInBean.setAccountid("JUnit");
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        LockProcessInBean befLockProcessInBean = new LockProcessInBean();
        befLockProcessInBean.setGyoumukey(pGyoumukey);
        befLockProcessInBean.setFlowid("フローＩＤflow0001");
        befLockProcessInBean.setLockkey("ロックキー2_8");
        LockProcessOutBean befLockProcessOutBean = iwfKouteiClient.execLockProcess(befLockProcessInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befLockProcessOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程ロック開始実行失敗！");
        }

        StartTaskInBean befStartTaskInBean = new StartTaskInBean();
        befStartTaskInBean.setGyoumukey(pGyoumukey);
        befStartTaskInBean.setFlowid("フローＩＤflow0001");
        befStartTaskInBean.setAccountid("JUnit");
        befStartTaskInBean.setTaskname("data-check1");
        befStartTaskInBean.setLockkey("ロックキー2_8");
        StartTaskOutBean befStartTaskOutBean = iwfKouteiClient.execStartTask(befStartTaskInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befStartTaskOutBean.getKekkastatus())) {
            throw new Exception("前処理：タスク開始実行失敗！");
        }

        UnassignTaskInBean unassignTaskInBean = new UnassignTaskInBean();
        unassignTaskInBean.setGyoumukey(pGyoumukey);
        unassignTaskInBean.setFlowid("フローＩＤflow0001");
        unassignTaskInBean.setAccountid("JUnit");
        unassignTaskInBean.setRirekiaccountid("HACID001");
        List<Map<String, String>> extinfoMapList = new ArrayList<>();
        Map<String, String> extinfoMap = new HashMap<>();
        extinfoMap.put("extinfo", "付加情報");
        extinfoMapList.add(extinfoMap);
        unassignTaskInBean.setExtInfo(extinfoMapList);
        unassignTaskInBean.setLockkey("ロックキー2_8");
        UnassignTaskOutBean unassignTaskOutBean = iwfKouteiClient.execUnsignTask(unassignTaskInBean);

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey(pGyoumukey);
        aftProcessCancelInBean.setFlowid("フローＩＤflow0001");
        aftProcessCancelInBean.setAccountid("JUnit");
        aftProcessCancelInBean.setLockkey("ロックキー2_8");
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), unassignTaskOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", unassignTaskOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "タスク取消正常終了しました。", unassignTaskOutBean.getSyousaimsg());

    }

    @Test
    public void testKyoukaiOK07() throws Exception {

        String pGyoumukey = BizDate.getSysDateTimeMilli();

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
        befLockProcessInBean.setLockkey("ロックキー2_9");
        LockProcessOutBean befLockProcessOutBean = iwfKouteiClient.execLockProcess(befLockProcessInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befLockProcessOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程ロック開始実行失敗！");
        }

        StartTaskInBean befStartTaskInBean = new StartTaskInBean();
        befStartTaskInBean.setGyoumukey(pGyoumukey);
        befStartTaskInBean.setFlowid("tt4");
        befStartTaskInBean.setAccountid("JUnit");
        befStartTaskInBean.setTaskname("data-check1");
        befStartTaskInBean.setLockkey("ロックキー2_9");
        StartTaskOutBean befStartTaskOutBean = iwfKouteiClient.execStartTask(befStartTaskInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befStartTaskOutBean.getKekkastatus())) {
            throw new Exception("前処理：タスク開始実行失敗！");
        }

        UnassignTaskInBean unassignTaskInBean = new UnassignTaskInBean();
        unassignTaskInBean.setGyoumukey(pGyoumukey);
        unassignTaskInBean.setFlowid("tt4");
        unassignTaskInBean.setAccountid("JUnit");
        unassignTaskInBean.setRirekiaccountid("HACID001");
        List<Map<String, String>> extinfoMapList = new ArrayList<>();
        Map<String, String> extinfoMap = new HashMap<>();
        extinfoMap.put("extinfo", "付加情報");
        extinfoMapList.add(extinfoMap);
        unassignTaskInBean.setExtInfo(extinfoMapList);
        unassignTaskInBean.setLockkey("ロックキー2_9");
        UnassignTaskOutBean unassignTaskOutBean = iwfKouteiClient.execUnsignTask(unassignTaskInBean);

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey(pGyoumukey);
        aftProcessCancelInBean.setFlowid("tt4");
        aftProcessCancelInBean.setAccountid("JUnit");
        aftProcessCancelInBean.setLockkey("ロックキー2_9");
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), unassignTaskOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", unassignTaskOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "タスク取消正常終了しました。", unassignTaskOutBean.getSyousaimsg());

    }

    @Test
    public void testKyoukaiOK08() throws Exception {

        String pGyoumukey = BizDate.getSysDateTimeMilli();

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
        befLockProcessInBean.setLockkey("ロックキー2_10");
        LockProcessOutBean befLockProcessOutBean = iwfKouteiClient.execLockProcess(befLockProcessInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befLockProcessOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程ロック開始実行失敗！");
        }

        StartTaskInBean befStartTaskInBean = new StartTaskInBean();
        befStartTaskInBean.setGyoumukey(pGyoumukey);
        befStartTaskInBean.setFlowid("tt4");
        befStartTaskInBean.setAccountid("JUnit");
        befStartTaskInBean.setTaskname("data-check1");
        befStartTaskInBean.setLockkey("ロックキー2_10");
        StartTaskOutBean befStartTaskOutBean = iwfKouteiClient.execStartTask(befStartTaskInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befStartTaskOutBean.getKekkastatus())) {
            throw new Exception("前処理：タスク開始実行失敗！");
        }

        UnassignTaskInBean unassignTaskInBean = new UnassignTaskInBean();
        unassignTaskInBean.setGyoumukey(pGyoumukey);
        unassignTaskInBean.setFlowid("tt4");
        unassignTaskInBean.setAccountid("JUnit");
        unassignTaskInBean.setRirekiaccountid("HACID001");
        List<Map<String, String>> extinfoMapList = new ArrayList<>();
        Map<String, String> extinfoMap = new HashMap<>();
        extinfoMap.put("extinfo", "付加情報");
        extinfoMapList.add(extinfoMap);
        unassignTaskInBean.setExtInfo(extinfoMapList);
        unassignTaskInBean.setLockkey("ロックキー2_10");
        UnassignTaskOutBean unassignTaskOutBean = iwfKouteiClient.execUnsignTask(unassignTaskInBean);

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey(pGyoumukey);
        aftProcessCancelInBean.setFlowid("tt4");
        aftProcessCancelInBean.setAccountid("JUnit");
        aftProcessCancelInBean.setLockkey("ロックキー2_10");
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), unassignTaskOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", unassignTaskOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "タスク取消正常終了しました。", unassignTaskOutBean.getSyousaimsg());

    }

    @Test
    public void testKyoukaiNG03() {

        UnassignTaskInBean unassignTaskInBean = new UnassignTaskInBean();
        unassignTaskInBean.setGyoumukey("業務キー2_11");
        unassignTaskInBean.setFlowid("tt4");
        unassignTaskInBean.setAccountid("ACID000000000000000000000000012");
        unassignTaskInBean.setRirekiaccountid("履歴用アカウントＩＤ");
        List<Map<String, String>> extinfoMapList = new ArrayList<>();
        Map<String, String> extinfoMap = new HashMap<>();
        extinfoMap.put("extinfo", "付加情報");
        extinfoMapList.add(extinfoMap);
        unassignTaskInBean.setExtInfo(extinfoMapList);
        unassignTaskInBean.setLockkey("ロックキー2_11");
        UnassignTaskOutBean unassignTaskOutBean = iwfKouteiClient.execUnsignTask(unassignTaskInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), unassignTaskOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0008", unassignTaskOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "アカウントＩＤは30文字以内で入力してください。", unassignTaskOutBean.getSyousaimsg());

    }

    @Test
    public void testKyoukaiOK09() throws Exception {

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setGyoumukey("業務キー2_13");
        befProcessCreateInBean.setFlowid("tt4");
        befProcessCreateInBean.setAccountid("JUnit");
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        LockProcessInBean befLockProcessInBean = new LockProcessInBean();
        befLockProcessInBean.setGyoumukey("業務キー2_13");
        befLockProcessInBean.setFlowid("tt4");
        befLockProcessInBean.setLockkey("ロックキー2_13");
        LockProcessOutBean befLockProcessOutBean = iwfKouteiClient.execLockProcess(befLockProcessInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befLockProcessOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程ロック開始実行失敗！");
        }

        StartTaskInBean befStartTaskInBean = new StartTaskInBean();
        befStartTaskInBean.setGyoumukey("業務キー2_13");
        befStartTaskInBean.setFlowid("tt4");
        befStartTaskInBean.setAccountid("JUnit");
        befStartTaskInBean.setTaskname("data-check1");
        befStartTaskInBean.setLockkey("ロックキー2_13");
        StartTaskOutBean befStartTaskOutBean = iwfKouteiClient.execStartTask(befStartTaskInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befStartTaskOutBean.getKekkastatus())) {
            throw new Exception("前処理：タスク開始実行失敗！");
        }

        UnassignTaskInBean unassignTaskInBean = new UnassignTaskInBean();
        unassignTaskInBean.setGyoumukey("業務キー2_13");
        unassignTaskInBean.setFlowid("tt4");
        unassignTaskInBean.setAccountid("JUnit");
        unassignTaskInBean.setRirekiaccountid("HITROACID00000000000000000000");
        List<Map<String, String>> extinfoMapList = new ArrayList<>();
        Map<String, String> extinfoMap = new HashMap<>();
        extinfoMap.put("extinfo", "付加情報");
        extinfoMapList.add(extinfoMap);
        unassignTaskInBean.setExtInfo(extinfoMapList);
        unassignTaskInBean.setLockkey("ロックキー2_13");
        UnassignTaskOutBean unassignTaskOutBean = iwfKouteiClient.execUnsignTask(unassignTaskInBean);

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey("業務キー2_13");
        aftProcessCancelInBean.setFlowid("tt4");
        aftProcessCancelInBean.setAccountid("JUnit");
        aftProcessCancelInBean.setLockkey("ロックキー2_13");
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), unassignTaskOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", unassignTaskOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "タスク取消正常終了しました。", unassignTaskOutBean.getSyousaimsg());

    }

    @Test
    public void testKyoukaiOK10() throws Exception {

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setGyoumukey("業務キー2_14");
        befProcessCreateInBean.setFlowid("tt4");
        befProcessCreateInBean.setAccountid("JUnit");
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        LockProcessInBean befLockProcessInBean = new LockProcessInBean();
        befLockProcessInBean.setGyoumukey("業務キー2_14");
        befLockProcessInBean.setFlowid("tt4");
        befLockProcessInBean.setLockkey("ロックキー2_14");
        LockProcessOutBean befLockProcessOutBean = iwfKouteiClient.execLockProcess(befLockProcessInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befLockProcessOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程ロック開始実行失敗！");
        }

        StartTaskInBean befStartTaskInBean = new StartTaskInBean();
        befStartTaskInBean.setGyoumukey("業務キー2_14");
        befStartTaskInBean.setFlowid("tt4");
        befStartTaskInBean.setAccountid("JUnit");
        befStartTaskInBean.setTaskname("data-check1");
        befStartTaskInBean.setLockkey("ロックキー2_14");
        StartTaskOutBean befStartTaskOutBean = iwfKouteiClient.execStartTask(befStartTaskInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befStartTaskOutBean.getKekkastatus())) {
            throw new Exception("前処理：タスク開始実行失敗！");
        }

        UnassignTaskInBean unassignTaskInBean = new UnassignTaskInBean();
        unassignTaskInBean.setGyoumukey("業務キー2_14");
        unassignTaskInBean.setFlowid("tt4");
        unassignTaskInBean.setAccountid("JUnit");
        unassignTaskInBean.setRirekiaccountid("HITROACID000000000000000000001");
        List<Map<String, String>> extinfoMapList = new ArrayList<>();
        Map<String, String> extinfoMap = new HashMap<>();
        extinfoMap.put("extinfo", "付加情報");
        extinfoMapList.add(extinfoMap);
        unassignTaskInBean.setExtInfo(extinfoMapList);
        unassignTaskInBean.setLockkey("ロックキー2_14");
        UnassignTaskOutBean unassignTaskOutBean = iwfKouteiClient.execUnsignTask(unassignTaskInBean);

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey("業務キー2_14");
        aftProcessCancelInBean.setFlowid("tt4");
        aftProcessCancelInBean.setAccountid("JUnit");
        aftProcessCancelInBean.setLockkey("ロックキー2_14");
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), unassignTaskOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", unassignTaskOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "タスク取消正常終了しました。", unassignTaskOutBean.getSyousaimsg());

    }

    @Test
    public void testKyoukaiNG04() {

        UnassignTaskInBean unassignTaskInBean = new UnassignTaskInBean();
        unassignTaskInBean.setGyoumukey("業務キー2_15");
        unassignTaskInBean.setFlowid("tt4");
        unassignTaskInBean.setAccountid("JUnit");
        unassignTaskInBean.setRirekiaccountid("HITROACID0000000000000000000012");
        List<Map<String, String>> extinfoMapList = new ArrayList<>();
        Map<String, String> extinfoMap = new HashMap<>();
        extinfoMap.put("extinfo", "付加情報");
        extinfoMapList.add(extinfoMap);
        unassignTaskInBean.setExtInfo(extinfoMapList);
        unassignTaskInBean.setLockkey("ロックキー2_15");
        UnassignTaskOutBean unassignTaskOutBean = iwfKouteiClient.execUnsignTask(unassignTaskInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), unassignTaskOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0008", unassignTaskOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "履歴用アカウントIDは30文字以内で入力してください。", unassignTaskOutBean.getSyousaimsg());

    }

    @Test
    public void testInfoExistNG01() {

        UnassignTaskInBean unassignTaskInBean = new UnassignTaskInBean();
        unassignTaskInBean.setGyoumukey("unassignTask_01");
        unassignTaskInBean.setFlowid("tt4");
        unassignTaskInBean.setAccountid("JUnit");
        unassignTaskInBean.setRirekiaccountid("HACID001");
        List<Map<String, String>> extinfoMapList = new ArrayList<>();
        Map<String, String> extinfoMap = new HashMap<>();
        extinfoMap.put("extinfo", "付加情報");
        extinfoMapList.add(extinfoMap);
        unassignTaskInBean.setExtInfo(extinfoMapList);
        unassignTaskInBean.setLockkey("ロックキー3_1");
        UnassignTaskOutBean unassignTaskOutBean = iwfKouteiClient.execUnsignTask(unassignTaskInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), unassignTaskOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF2040", unassignTaskOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "トークンIDが取得できませんでした。", unassignTaskOutBean.getSyousaimsg());

    }

    @Test
    public void testInfoExistNG02() throws Exception {

        String gyoumukey = BizDate.getSysDateTimeMilli();
        String lockKey = BizDate.getSysDateTimeMilli();
        IwfCoreConfig.getInstance().setLockYouhi(true);

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setGyoumukey(gyoumukey);
        befProcessCreateInBean.setFlowid("tt4");
        befProcessCreateInBean.setAccountid("JUnit");
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        LockProcessInBean befLockProcessInBean = new LockProcessInBean();
        befLockProcessInBean.setGyoumukey(gyoumukey);
        befLockProcessInBean.setFlowid("tt4");
        befLockProcessInBean.setLockkey(lockKey);
        LockProcessOutBean befLockProcessOutBean = iwfKouteiClient.execLockProcess(befLockProcessInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befLockProcessOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程ロック開始実行失敗！");
        }

        ProcessCancelInBean befProcessCancelInBean = new ProcessCancelInBean();
        befProcessCancelInBean.setGyoumukey(gyoumukey);
        befProcessCancelInBean.setFlowid("tt4");
        befProcessCancelInBean.setAccountid("JUnit");
        befProcessCancelInBean.setLockkey(lockKey);
        ProcessCancelOutBean befProcessCancelOutBean = iwfKouteiClient.execProcessCancel(befProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程取消実行失敗！");
        }

        UnassignTaskInBean unassignTaskInBean = new UnassignTaskInBean();
        unassignTaskInBean.setGyoumukey(gyoumukey);
        unassignTaskInBean.setFlowid("tt4");
        unassignTaskInBean.setAccountid("JUnit");
        unassignTaskInBean.setRirekiaccountid("HACID001");
        List<Map<String, String>> extinfoMapList = new ArrayList<>();
        Map<String, String> extinfoMap = new HashMap<>();
        extinfoMap.put("extinfo", "付加情報");
        extinfoMapList.add(extinfoMap);
        unassignTaskInBean.setExtInfo(extinfoMapList);
        unassignTaskInBean.setLockkey(lockKey);
        UnassignTaskOutBean unassignTaskOutBean = iwfKouteiClient.execUnsignTask(unassignTaskInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), unassignTaskOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF2043", unassignTaskOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "指定されたフローID、業務キーに紐づくトークンは存在しない、または終了しています。", unassignTaskOutBean.getSyousaimsg());

    }

    @Test
    public void testInfoExistNG03() throws Exception {

        String gyoumukey = BizDate.getSysDateTimeMilli();
        String lockKey = BizDate.getSysDateTimeMilli();
        IwfCoreConfig.getInstance().setLockYouhi(true);

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setGyoumukey(gyoumukey);
        befProcessCreateInBean.setFlowid("tt4");
        befProcessCreateInBean.setAccountid("JUnit");
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        UnassignTaskInBean unassignTaskInBean = new UnassignTaskInBean();
        unassignTaskInBean.setGyoumukey(gyoumukey);
        unassignTaskInBean.setFlowid("tt4");
        unassignTaskInBean.setAccountid("JUnit");
        unassignTaskInBean.setRirekiaccountid("HACID001");
        List<Map<String, String>> extinfoMapList = new ArrayList<>();
        Map<String, String> extinfoMap = new HashMap<>();
        extinfoMap.put("extinfo", "付加情報");
        extinfoMapList.add(extinfoMap);
        unassignTaskInBean.setExtInfo(extinfoMapList);
        unassignTaskInBean.setLockkey(lockKey);
        UnassignTaskOutBean unassignTaskOutBean = iwfKouteiClient.execUnsignTask(unassignTaskInBean);

        LockProcessInBean aftLockProcessInBean = new LockProcessInBean();
        aftLockProcessInBean.setGyoumukey(gyoumukey);
        aftLockProcessInBean.setFlowid("tt4");
        aftLockProcessInBean.setLockkey(lockKey);
        LockProcessOutBean aftLockProcessOutBean = iwfKouteiClient.execLockProcess(aftLockProcessInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey(gyoumukey);
        aftProcessCancelInBean.setFlowid("tt4");
        aftProcessCancelInBean.setAccountid("JUnit");
        aftProcessCancelInBean.setLockkey(lockKey);
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), unassignTaskOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF2041", unassignTaskOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "ロックキーが無効です。他の作業者がロック中、またはロックが既に解除されています。", unassignTaskOutBean.getSyousaimsg());

    }

    @Test
    public void testInfoExistNG04() throws Exception {

        String gyoumukey = BizDate.getSysDateTimeMilli();
        String lockKey = BizDate.getSysDateTimeMilli();
        IwfCoreConfig.getInstance().setLockYouhi(true);

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setGyoumukey(gyoumukey);
        befProcessCreateInBean.setFlowid("tt4");
        befProcessCreateInBean.setAccountid("JUnit");
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        LockProcessInBean befLockProcessInBean = new LockProcessInBean();
        befLockProcessInBean.setGyoumukey(gyoumukey);
        befLockProcessInBean.setFlowid("tt4");
        befLockProcessInBean.setLockkey(lockKey);
        LockProcessOutBean befLockProcessOutBean = iwfKouteiClient.execLockProcess(befLockProcessInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befLockProcessOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程ロック開始実行失敗！");
        }

        UnassignTaskInBean unassignTaskInBean = new UnassignTaskInBean();
        unassignTaskInBean.setGyoumukey(gyoumukey);
        unassignTaskInBean.setFlowid("tt4");
        unassignTaskInBean.setAccountid("JUnit");
        unassignTaskInBean.setRirekiaccountid("HACID001");
        List<Map<String, String>> extinfoMapList = new ArrayList<>();
        Map<String, String> extinfoMap = new HashMap<>();
        extinfoMap.put("extinfo", "付加情報");
        extinfoMapList.add(extinfoMap);
        unassignTaskInBean.setExtInfo(extinfoMapList);
        unassignTaskInBean.setLockkey("無効なロックキー");
        UnassignTaskOutBean unassignTaskOutBean = iwfKouteiClient.execUnsignTask(unassignTaskInBean);

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey(gyoumukey);
        aftProcessCancelInBean.setFlowid("tt4");
        aftProcessCancelInBean.setAccountid("JUnit");
        aftProcessCancelInBean.setLockkey(lockKey);
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), unassignTaskOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF2041", unassignTaskOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "ロックキーが無効です。他の作業者がロック中、またはロックが既に解除されています。", unassignTaskOutBean.getSyousaimsg());

    }

    @Test
    public void testInfoExistNG05() throws Exception {

        String gyoumukey = BizDate.getSysDateTimeMilli();
        String lockKey = BizDate.getSysDateTimeMilli();
        IwfCoreConfig.getInstance().setLockYouhi(true);

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setGyoumukey(gyoumukey);
        befProcessCreateInBean.setFlowid("tt4");
        befProcessCreateInBean.setAccountid("JUnit");
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        LockProcessInBean befLockProcessInBean = new LockProcessInBean();
        befLockProcessInBean.setGyoumukey(gyoumukey);
        befLockProcessInBean.setFlowid("tt4");
        befLockProcessInBean.setLockkey(lockKey);
        LockProcessOutBean befLockProcessOutBean = iwfKouteiClient.execLockProcess(befLockProcessInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befLockProcessOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程ロック開始実行失敗！");
        }

        UnassignTaskInBean unassignTaskInBean = new UnassignTaskInBean();
        unassignTaskInBean.setGyoumukey(gyoumukey);
        unassignTaskInBean.setFlowid("tt4");
        unassignTaskInBean.setAccountid("JUnitX");
        unassignTaskInBean.setRirekiaccountid("HACID001");
        List<Map<String, String>> extinfoMapList = new ArrayList<>();
        Map<String, String> extinfoMap = new HashMap<>();
        extinfoMap.put("extinfo", "付加情報");
        extinfoMapList.add(extinfoMap);
        unassignTaskInBean.setExtInfo(extinfoMapList);
        unassignTaskInBean.setLockkey(lockKey);
        UnassignTaskOutBean unassignTaskOutBean = iwfKouteiClient.execUnsignTask(unassignTaskInBean);

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey(gyoumukey);
        aftProcessCancelInBean.setFlowid("tt4");
        aftProcessCancelInBean.setAccountid("JUnit");
        aftProcessCancelInBean.setLockkey(lockKey);
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }


        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), unassignTaskOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF2042", unassignTaskOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "タスクが取得できませんでした。", unassignTaskOutBean.getSyousaimsg());

    }

    @Test
    public void testInfoExistNG06() throws Exception {

        String gyoumukey1 = BizDate.getSysDateTimeMilli();
        String gyoumukey2 = gyoumukey1 + 1;

        String lockKey1 = BizDate.getSysDateTimeMilli();
        String lockKey2 = lockKey1 + 1;
        IwfCoreConfig.getInstance().setLockYouhi(true);
        IwfCoreConfig.getInstance().setLockValidTime(10);

        ProcessCreateInBean befProcessCreateInBean1 = new ProcessCreateInBean();
        befProcessCreateInBean1.setGyoumukey(gyoumukey1);
        befProcessCreateInBean1.setFlowid("tt4");
        befProcessCreateInBean1.setAccountid("JUnit");
        ProcessCreateOutBean befProcessCreateOutBean1 = iwfKouteiClient.execProcessCreate(befProcessCreateInBean1);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean1.getKekkastatus())) {
            throw new Exception("前処理：工程作成１実行失敗！");
        }

        ProcessCreateInBean befProcessCreateInBean2 = new ProcessCreateInBean();
        befProcessCreateInBean2.setGyoumukey(gyoumukey2);
        befProcessCreateInBean2.setFlowid("tt4");
        befProcessCreateInBean2.setAccountid("JUnit01");
        ProcessCreateOutBean befProcessCreateOutBean2 = iwfKouteiClient.execProcessCreate(befProcessCreateInBean2);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean2.getKekkastatus())) {
            throw new Exception("前処理：工程作成２実行失敗！");
        }

        LockProcessInBean befLockProcessInBean1 = new LockProcessInBean();
        befLockProcessInBean1.setGyoumukey(gyoumukey1);
        befLockProcessInBean1.setFlowid("tt4");
        befLockProcessInBean1.setLockkey(lockKey1);
        LockProcessOutBean befLockProcessOutBean1 = iwfKouteiClient.execLockProcess(befLockProcessInBean1);
        if (!C_ResultCdKbn.OK.toString().equals(befLockProcessOutBean1.getKekkastatus())) {
            throw new Exception("前処理：工程ロック１開始実行失敗！");
        }

        LockProcessInBean befLockProcessInBean2 = new LockProcessInBean();
        befLockProcessInBean2.setGyoumukey(gyoumukey2);
        befLockProcessInBean2.setFlowid("tt4");
        befLockProcessInBean2.setLockkey(lockKey2);
        LockProcessOutBean befLockProcessOutBean2 = iwfKouteiClient.execLockProcess(befLockProcessInBean2);
        if (!C_ResultCdKbn.OK.toString().equals(befLockProcessOutBean2.getKekkastatus())) {
            throw new Exception("前処理：工程ロック２開始実行失敗！");
        }

        StartTaskInBean befStartTaskInBean1 = new StartTaskInBean();
        befStartTaskInBean1.setGyoumukey(gyoumukey1);
        befStartTaskInBean1.setFlowid("tt4");
        befStartTaskInBean1.setAccountid("JUnit");
        befStartTaskInBean1.setTaskname("data-check1");
        befStartTaskInBean1.setLockkey(lockKey1);
        StartTaskOutBean befStartTaskOutBean1 = iwfKouteiClient.execStartTask(befStartTaskInBean1);
        if (!C_ResultCdKbn.OK.toString().equals(befStartTaskOutBean1.getKekkastatus())) {
            throw new Exception("前処理：タスク開始１実行失敗！");
        }

        StartTaskInBean befStartTaskInBean2 = new StartTaskInBean();
        befStartTaskInBean2.setGyoumukey(gyoumukey2);
        befStartTaskInBean2.setFlowid("tt4");
        befStartTaskInBean2.setAccountid("JUnit01");
        befStartTaskInBean2.setTaskname("data-check1");
        befStartTaskInBean2.setLockkey(lockKey2);
        StartTaskOutBean befStartTaskOutBean2 = iwfKouteiClient.execStartTask(befStartTaskInBean2);
        if (!C_ResultCdKbn.OK.toString().equals(befStartTaskOutBean2.getKekkastatus())) {
            throw new Exception("前処理：タスク開始２実行失敗！");
        }

        UnassignTaskInBean unassignTaskInBean = new UnassignTaskInBean();
        unassignTaskInBean.setGyoumukey(gyoumukey1);
        unassignTaskInBean.setFlowid("tt4");
        unassignTaskInBean.setAccountid("JUnit01");
        List<Map<String, String>> extinfoMapList = new ArrayList<>();
        Map<String, String> extinfoMap = new HashMap<>();
        extinfoMap.put("extinfo", "付加情報");
        extinfoMapList.add(extinfoMap);
        unassignTaskInBean.setExtInfo(extinfoMapList);
        unassignTaskInBean.setLockkey(lockKey1);
        UnassignTaskOutBean unassignTaskOutBean = iwfKouteiClient.execUnsignTask(unassignTaskInBean);

        ProcessCancelInBean aftProcessCancelInBean1 = new ProcessCancelInBean();
        aftProcessCancelInBean1.setGyoumukey(gyoumukey1);
        aftProcessCancelInBean1.setFlowid("tt4");
        aftProcessCancelInBean1.setAccountid("JUnit");
        aftProcessCancelInBean1.setLockkey(lockKey1);
        ProcessCancelOutBean aftProcessCancelOutBean1 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean1);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean1.getKekkastatus())) {
            throw new Exception("後処理：工程取消１実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean2 = new ProcessCancelInBean();
        aftProcessCancelInBean2.setGyoumukey(gyoumukey2);
        aftProcessCancelInBean2.setFlowid("tt4");
        aftProcessCancelInBean2.setAccountid("JUnit01");
        aftProcessCancelInBean2.setLockkey(lockKey2);
        ProcessCancelOutBean aftProcessCancelOutBean2 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean2);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean2.getKekkastatus())) {
            throw new Exception("後処理：工程取消２実行失敗！");
        }

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), unassignTaskOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF2042", unassignTaskOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "タスクが取得できませんでした。", unassignTaskOutBean.getSyousaimsg());

        IwfCoreConfig.getInstance().setLockValidTime(1);

    }

    @Test
    public void testSyoriLogicOK01() throws Exception {

        String pGyoumukey = BizDate.getSysDateTimeMilli();

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

        StartTaskInBean befStartTaskInBean = new StartTaskInBean();
        befStartTaskInBean.setGyoumukey(pGyoumukey);
        befStartTaskInBean.setFlowid("tt4");
        befStartTaskInBean.setAccountid("JUnit");
        befStartTaskInBean.setTaskname("data-check1");
        befStartTaskInBean.setLockkey("ロックキー4_1");
        StartTaskOutBean befStartTaskOutBean = iwfKouteiClient.execStartTask(befStartTaskInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befStartTaskOutBean.getKekkastatus())) {
            throw new Exception("前処理：タスク開始実行失敗！");
        }

        UnassignTaskInBean unassignTaskInBean = new UnassignTaskInBean();
        unassignTaskInBean.setGyoumukey(pGyoumukey);
        unassignTaskInBean.setFlowid("tt4");
        unassignTaskInBean.setAccountid("JUnit");
        unassignTaskInBean.setRirekiaccountid("HACID001");
        List<Map<String, String>> extinfoMapList = new ArrayList<>();
        Map<String, String> extinfoMap = new HashMap<>();
        extinfoMap.put("extinfo", "付加情報");
        extinfoMapList.add(extinfoMap);
        unassignTaskInBean.setExtInfo(extinfoMapList);
        unassignTaskInBean.setLockkey("ロックキー4_1");
        UnassignTaskOutBean unassignTaskOutBean = iwfKouteiClient.execUnsignTask(unassignTaskInBean);

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey(pGyoumukey);
        aftProcessCancelInBean.setFlowid("tt4");
        aftProcessCancelInBean.setAccountid("JUnit");
        aftProcessCancelInBean.setLockkey("ロックキー4_1");
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), unassignTaskOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", unassignTaskOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "タスク取消正常終了しました。", unassignTaskOutBean.getSyousaimsg());

    }

    @Test
    public void testSyoriLogicOK02() throws Exception {

        String pGyoumukey = BizDate.getSysDateTimeMilli();

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setGyoumukey(pGyoumukey);
        befProcessCreateInBean.setFlowid("kouteitest");
        befProcessCreateInBean.setAccountid("Tt");
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        LockProcessInBean befLockProcessInBean = new LockProcessInBean();
        befLockProcessInBean.setGyoumukey(pGyoumukey);
        befLockProcessInBean.setFlowid("kouteitest");
        befLockProcessInBean.setLockkey("ロックキー4_1");
        LockProcessOutBean befLockProcessOutBean = iwfKouteiClient.execLockProcess(befLockProcessInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befLockProcessOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程ロック開始実行失敗！");
        }

        StartTaskInBean befStartTaskInBean = new StartTaskInBean();
        befStartTaskInBean.setGyoumukey(pGyoumukey);
        befStartTaskInBean.setFlowid("kouteitest");
        befStartTaskInBean.setAccountid("administrator");
        befStartTaskInBean.setTaskname("torikesi-check1");
        befStartTaskInBean.setLockkey("ロックキー4_1");
        StartTaskOutBean befStartTaskOutBean = iwfKouteiClient.execStartTask(befStartTaskInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befStartTaskOutBean.getKekkastatus())) {
            throw new Exception("前処理：タスク開始実行失敗！");
        }

        UnassignTaskInBean unassignTaskInBean = new UnassignTaskInBean();
        unassignTaskInBean.setGyoumukey(pGyoumukey);
        unassignTaskInBean.setFlowid("kouteitest");
        unassignTaskInBean.setAccountid("administrator");
        unassignTaskInBean.setRirekiaccountid("HACID001");
        List<Map<String, String>> extinfoMapList = new ArrayList<>();
        Map<String, String> extinfoMap = new HashMap<>();
        extinfoMap.put("extinfo", "付加情報");
        extinfoMapList.add(extinfoMap);
        unassignTaskInBean.setExtInfo(extinfoMapList);
        unassignTaskInBean.setLockkey("ロックキー4_1");
        UnassignTaskOutBean unassignTaskOutBean = iwfKouteiClient.execUnsignTask(unassignTaskInBean);

        WT_KouteiSummary kouteiSummary = iwfCoreDomManager.getKouteiSummary(pGyoumukey);
        String genZaiAcd = "";
        if (null != kouteiSummary) {
            genZaiAcd = kouteiSummary.getGenzaiAccountId();
        }

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey(pGyoumukey);
        aftProcessCancelInBean.setFlowid("kouteitest");
        aftProcessCancelInBean.setAccountid("administrator");
        aftProcessCancelInBean.setLockkey("ロックキー4_1");
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), unassignTaskOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", unassignTaskOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "タスク取消正常終了しました。", unassignTaskOutBean.getSyousaimsg());
        assertEquals(null, genZaiAcd);

    }

    @Test
    public void testSyoriLogicOK03() throws Exception {

        String pGyoumukey = BizDate.getSysDateTimeMilli();

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setGyoumukey(pGyoumukey);
        befProcessCreateInBean.setFlowid("kouteitest");
        befProcessCreateInBean.setAccountid("Tt");
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        LockProcessInBean befLockProcessInBean = new LockProcessInBean();
        befLockProcessInBean.setGyoumukey(pGyoumukey);
        befLockProcessInBean.setFlowid("kouteitest");
        befLockProcessInBean.setLockkey("ロックキー4_1");
        LockProcessOutBean befLockProcessOutBean = iwfKouteiClient.execLockProcess(befLockProcessInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befLockProcessOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程ロック開始実行失敗！");
        }

        StartTaskInBean befStartTaskInBean = new StartTaskInBean();
        befStartTaskInBean.setGyoumukey(pGyoumukey);
        befStartTaskInBean.setFlowid("kouteitest");
        befStartTaskInBean.setAccountid("administrator");
        befStartTaskInBean.setTaskname("torikesi-check1");
        befStartTaskInBean.setLockkey("ロックキー4_1");
        StartTaskOutBean befStartTaskOutBean = iwfKouteiClient.execStartTask(befStartTaskInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befStartTaskOutBean.getKekkastatus())) {
            throw new Exception("前処理：タスク開始実行失敗！");
        }

        UnassignTaskInBean unassignTaskInBean = new UnassignTaskInBean();
        unassignTaskInBean.setGyoumukey(pGyoumukey);
        unassignTaskInBean.setFlowid("kouteitest");
        unassignTaskInBean.setAccountid("administrator");
        unassignTaskInBean.setRirekiaccountid("HACID001");
        List<Map<String, String>> extinfoMapList = new ArrayList<>();
        Map<String, String> extinfoMap = new HashMap<>();
        extinfoMap.put("extinfo", "付加情報");
        extinfoMapList.add(extinfoMap);
        unassignTaskInBean.setExtInfo(extinfoMapList);
        unassignTaskInBean.setLockkey("ロックキー4_1");
        UnassignTaskOutBean unassignTaskOutBean = iwfKouteiClient.execUnsignTask(unassignTaskInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), unassignTaskOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", unassignTaskOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "タスク取消正常終了しました。", unassignTaskOutBean.getSyousaimsg());
        assertTrue("開始日クリアチェック",checkStartTime("kouteitest",pGyoumukey));

    }

    private boolean checkStartTime(String psFlowId, String psGyoumukey){

        boolean startTimeFlg = false;

        WT_GyoumuKey gyoumuKey = iwfCoreDomManager.getGyoumuKey(psFlowId, psGyoumukey);

        if (null != gyoumuKey) {
            List<JBPM_TASKINSTANCE> taskIns = iwfCoreDomManager.getTaskInstances();
            if (taskIns.size() > 0) {
                for (JBPM_TASKINSTANCE taskinstance : taskIns){
                    if(gyoumuKey.getTokenId().equals(taskinstance.getToken_().toString()) && taskinstance.getStart_() == null){
                        startTimeFlg = true;
                        break;
                    }
                }
            }
        }
        return startTimeFlg;
    }
}
