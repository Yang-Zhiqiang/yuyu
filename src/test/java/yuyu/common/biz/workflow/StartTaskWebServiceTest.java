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
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.exectaskstart.WSExecTaskStart;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.exectaskstart.WSExecTaskStartRequest;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.def.db.entity.JBPM_TASKINSTANCE;
import yuyu.def.db.entity.WT_GyoumuKey;
import yuyu.def.workflowcore.configration.IwfCoreConfig;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;
import yuyu.testinfr.TestOrder;

/**
 * タスク開始Webサービス {@link WSExecTaskStart#executeBizMain(WSExecTaskStartRequest)} テスト用クラスです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class StartTaskWebServiceTest {

    @Inject
    IwfKouteiClient iwfKouteiClient;

    @Inject
    private IwfCoreDomManager iwfCoreDomManager;

    @Test(expected=RuntimeException.class)
    @TestOrder(1)
    public void testValidationNG01() {
        StartTaskInBean inBean = null;
        iwfKouteiClient.execStartTask(inBean);
    }

    @Test
    @TestOrder(2)
    public void testValidationNG02() {
        String psGyoumukey = null;
        String psFlowid = "09";
        String psAccountid = "Tt";
        String psLockkey = "ロックキー";
        String psTaskname = "タスク名";
        String psExtinfo = "付加情報";

        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", psExtinfo);
        poExtinfoMapList.add(poExtinfoMap);

        StartTaskInBean inBean = new StartTaskInBean();
        inBean.setGyoumukey(psGyoumukey);
        inBean.setFlowid(psFlowid);
        inBean.setAccountid(psAccountid);
        inBean.setTaskname(psTaskname);
        inBean.setLockkey(psLockkey);
        inBean.setExtInfo(poExtinfoMapList);

        StartTaskOutBean outBean = iwfKouteiClient.execStartTask(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("IWF0002", outBean.getSyousaimsgcd());
        assertEquals("必須入力チェックエラー：業務キー", outBean.getSyousaimsg());
    }

    @Test
    @TestOrder(3)
    public void testValidationNG03() {
        String psGyoumukey = "";
        String psFlowid = "09";
        String psAccountid = "Tt";
        String psLockkey = "ロックキー";
        String psTaskname = "タスク名";
        String psExtinfo = "付加情報";

        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", psExtinfo);
        poExtinfoMapList.add(poExtinfoMap);

        StartTaskInBean inBean = new StartTaskInBean();
        inBean.setGyoumukey(psGyoumukey);
        inBean.setFlowid(psFlowid);
        inBean.setAccountid(psAccountid);
        inBean.setTaskname(psTaskname);
        inBean.setLockkey(psLockkey);
        inBean.setExtInfo(poExtinfoMapList);

        StartTaskOutBean outBean = iwfKouteiClient.execStartTask(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("IWF0002", outBean.getSyousaimsgcd());
        assertEquals("必須入力チェックエラー：業務キー", outBean.getSyousaimsg());

    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(4)
    public void testValidationNG04() {
        String psGyoumukey = BizDate.getSysDateTimeMilli();
        String psFlowId = null;
        String psAccountid = "JUnit";
        String psLockkey = BizDate.getSysDateTimeMilli();
        String psTaskname = "data-input1";
        String psExtinfo = "付加情報";

        boolean lockYouhi = IwfCoreConfig.getInstance().isLockYouhi();
        int lockValidTime = IwfCoreConfig.getInstance().getLockValidTime();

        IwfCoreConfig.getInstance().setLockYouhi(true);
        IwfCoreConfig.getInstance().setLockValidTime(1000);

        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();

        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", psExtinfo);
        poExtinfoMapList.add(poExtinfoMap);

        StartTaskInBean inBean = new StartTaskInBean();
        inBean.setGyoumukey(psGyoumukey);
        inBean.setFlowid(psFlowId);
        inBean.setAccountid(psAccountid);
        inBean.setTaskname(psTaskname);
        inBean.setLockkey(psLockkey);
        inBean.setExtInfo(poExtinfoMapList);

        StartTaskOutBean outBean = iwfKouteiClient.execStartTask(inBean);

        IwfCoreConfig.getInstance().setLockYouhi(lockYouhi);

        IwfCoreConfig.getInstance().setLockValidTime(lockValidTime);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("IWF0002", outBean.getSyousaimsgcd());
        assertEquals("必須入力チェックエラー：フローＩＤ", outBean.getSyousaimsg());
    }

    @Test
    @TestOrder(5)
    public void testValidationNG05() {
        String psGyoumukey = "業務キー";
        String psFlowid = "";
        String psAccountid = "Tt";
        String psTaskname = "タスク名";
        String psLockkey = "ロックキー";
        String psExtinfo = "付加情報";

        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", psExtinfo);
        poExtinfoMapList.add(poExtinfoMap);

        StartTaskInBean inBean = new StartTaskInBean();
        inBean.setGyoumukey(psGyoumukey);
        inBean.setFlowid(psFlowid);
        inBean.setAccountid(psAccountid);
        inBean.setTaskname(psTaskname);
        inBean.setLockkey(psLockkey);
        inBean.setExtInfo(poExtinfoMapList);

        StartTaskOutBean outBean = iwfKouteiClient.execStartTask(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("IWF0002", outBean.getSyousaimsgcd());
        assertEquals("必須入力チェックエラー：フローＩＤ", outBean.getSyousaimsg());
    }

    @Test
    @TestOrder(6)
    public void testValidationNG06() {
        String psGyoumukey = "業務キー";
        String psFlowid = "09";
        String psAccountid = null;
        String psTaskname = "タスク名";
        String psLockkey = "ロックキー";
        String psExtinfo = "付加情報";

        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", psExtinfo);
        poExtinfoMapList.add(poExtinfoMap);

        StartTaskInBean inBean = new StartTaskInBean();
        inBean.setGyoumukey(psGyoumukey);
        inBean.setFlowid(psFlowid);
        inBean.setAccountid(psAccountid);
        inBean.setTaskname(psTaskname);
        inBean.setLockkey(psLockkey);
        inBean.setExtInfo(poExtinfoMapList);

        StartTaskOutBean outBean = iwfKouteiClient.execStartTask(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("IWF0002", outBean.getSyousaimsgcd());
        assertEquals("必須入力チェックエラー：アカウントＩＤ", outBean.getSyousaimsg());

    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(7)
    public void testValidationNG07() {
        String psGyoumukey = BizDate.getSysDateTimeMilli();
        String psFlowId = "tt";
        String psAccountid = "";
        String psTaskname = "data-input1";
        String psLockkey = BizDate.getSysDateTimeMilli();
        String psExtinfo = "付加情報";
        IwfCoreConfig.getInstance().setLockYouhi(true);
        IwfCoreConfig.getInstance().setLockValidTime(1000);

        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", psExtinfo);
        poExtinfoMapList.add(poExtinfoMap);

        StartTaskInBean inBean = new StartTaskInBean();
        inBean.setGyoumukey(psGyoumukey);
        inBean.setFlowid(psFlowId);
        inBean.setAccountid(psAccountid);
        inBean.setTaskname(psTaskname);
        inBean.setLockkey(psLockkey);
        inBean.setExtInfo(poExtinfoMapList);

        StartTaskOutBean outBean = iwfKouteiClient.execStartTask(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("IWF0002", outBean.getSyousaimsgcd());
        assertEquals("必須入力チェックエラー：アカウントＩＤ", outBean.getSyousaimsg());

    }

    @Test
    @TestOrder(8)
    public void testValidationNG08() {
        String psGyoumukey = "業務キー";
        String psFlowid = "09";
        String psAccountid = "Tt";
        String psTaskname = null;
        String psLockkey = "ロックキー";
        String psExtinfo = "付加情報";

        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", psExtinfo);
        poExtinfoMapList.add(poExtinfoMap);

        StartTaskInBean inBean = new StartTaskInBean();
        inBean.setGyoumukey(psGyoumukey);
        inBean.setFlowid(psFlowid);
        inBean.setAccountid(psAccountid);
        inBean.setTaskname(psTaskname);
        inBean.setLockkey(psLockkey);
        inBean.setExtInfo(poExtinfoMapList);

        StartTaskOutBean outBean = iwfKouteiClient.execStartTask(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("IWF0002", outBean.getSyousaimsgcd());
        assertEquals("必須入力チェックエラー：タスク名", outBean.getSyousaimsg());

    }

    @Test
    @TestOrder(9)
    public void testValidationNG09() {
        String psGyoumukey = "業務キー";
        String psFlowid = "09";
        String psAccountid = "Tt";
        String psTaskname = "";
        String psLockkey = "ロックキー";
        String psExtinfo = "付加情報";

        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();

        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", psExtinfo);
        poExtinfoMapList.add(poExtinfoMap);

        StartTaskInBean inBean = new StartTaskInBean();
        inBean.setGyoumukey(psGyoumukey);
        inBean.setFlowid(psFlowid);
        inBean.setAccountid(psAccountid);
        inBean.setTaskname(psTaskname);
        inBean.setLockkey(psLockkey);
        inBean.setExtInfo(poExtinfoMapList);

        StartTaskOutBean outBean = iwfKouteiClient.execStartTask(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("IWF0002", outBean.getSyousaimsgcd());
        assertEquals("必須入力チェックエラー：タスク名", outBean.getSyousaimsg());
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(10)
    public void testValidationOK01() throws Exception {
        String psGyoumukey = BizDate.getSysDateTimeMilli();
        String psFlowId = "tt4";
        String psAccountid = "JUnit";
        String psTaskname = "data-check1";
        String psLockkey = null;
        String psExtinfo = "付加情報";

        boolean lockYouhi = IwfCoreConfig.getInstance().isLockYouhi();
        int lockValidTime = IwfCoreConfig.getInstance().getLockValidTime();

        IwfCoreConfig.getInstance().setLockYouhi(false);
        IwfCoreConfig.getInstance().setLockValidTime(1000);

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setGyoumukey(psGyoumukey);
        befProcessCreateInBean.setFlowid(psFlowId);
        befProcessCreateInBean.setAccountid(psAccountid);
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", psExtinfo);
        poExtinfoMapList.add(poExtinfoMap);
        StartTaskInBean inBean = new StartTaskInBean();
        inBean.setGyoumukey(psGyoumukey);
        inBean.setFlowid(psFlowId);
        inBean.setAccountid(psAccountid);
        inBean.setTaskname(psTaskname);
        inBean.setLockkey(psLockkey);
        inBean.setExtInfo(poExtinfoMapList);
        StartTaskOutBean outBean = iwfKouteiClient.execStartTask(inBean);

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey(psGyoumukey);
        aftProcessCancelInBean.setFlowid(psFlowId);
        aftProcessCancelInBean.setAccountid(psAccountid);
        aftProcessCancelInBean.setLockkey(psLockkey);
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

        IwfCoreConfig.getInstance().setLockYouhi(lockYouhi);

        IwfCoreConfig.getInstance().setLockValidTime(lockValidTime);

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("IWF0000", outBean.getSyousaimsgcd());
        assertEquals("タスク開始正常終了しました。", outBean.getSyousaimsg());
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(11)
    public void testValidationOK02() throws Exception {
        String psGyoumukey = BizDate.getSysDateTimeMilli();
        String psFlowId = "tt4";
        String psAccountid = "JUnit";
        String psTaskname = "data-check1";
        String psLockkey = "";
        String psExtinfo = "付加情報";

        boolean lockYouhi = IwfCoreConfig.getInstance().isLockYouhi();
        int lockValidTime = IwfCoreConfig.getInstance().getLockValidTime();

        IwfCoreConfig.getInstance().setLockYouhi(false);
        IwfCoreConfig.getInstance().setLockValidTime(1000);

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setGyoumukey(psGyoumukey);
        befProcessCreateInBean.setFlowid(psFlowId);
        befProcessCreateInBean.setAccountid("Tt");
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", psExtinfo);
        poExtinfoMapList.add(poExtinfoMap);
        StartTaskInBean inBean = new StartTaskInBean();
        inBean.setGyoumukey(psGyoumukey);
        inBean.setFlowid(psFlowId);
        inBean.setAccountid(psAccountid);
        inBean.setTaskname(psTaskname);
        inBean.setLockkey(psLockkey);
        inBean.setExtInfo(poExtinfoMapList);

        StartTaskOutBean outBean = iwfKouteiClient.execStartTask(inBean);

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey(psGyoumukey);
        aftProcessCancelInBean.setFlowid(psFlowId);
        aftProcessCancelInBean.setAccountid(psAccountid);
        aftProcessCancelInBean.setLockkey(psLockkey);
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);

        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

        IwfCoreConfig.getInstance().setLockYouhi(lockYouhi);

        IwfCoreConfig.getInstance().setLockValidTime(lockValidTime);

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("IWF0000", outBean.getSyousaimsgcd());
        assertEquals("タスク開始正常終了しました。", outBean.getSyousaimsg());
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(12)
    public void testValidationOK03() throws Exception {
        String psGyoumukey = BizDate.getSysDateTimeMilli();
        String psFlowId = "tt4";
        String psAccountid = "JUnit";
        String psTaskname = "data-check1";
        String psLockkey = BizDate.getSysDateTimeMilli();
        String psExtinfo = null;

        boolean lockYouhi = IwfCoreConfig.getInstance().isLockYouhi();
        int lockValidTime = IwfCoreConfig.getInstance().getLockValidTime();

        IwfCoreConfig.getInstance().setLockYouhi(true);
        IwfCoreConfig.getInstance().setLockValidTime(1000);

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setGyoumukey(psGyoumukey);
        befProcessCreateInBean.setFlowid(psFlowId);
        befProcessCreateInBean.setAccountid(psAccountid);
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }
        LockProcessInBean befLockProcessInBean = new LockProcessInBean();
        befLockProcessInBean.setGyoumukey(psGyoumukey);
        befLockProcessInBean.setFlowid(psFlowId);
        befLockProcessInBean.setLockkey(psLockkey);
        LockProcessOutBean befLockProcessOutBean = iwfKouteiClient.execLockProcess(befLockProcessInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befLockProcessOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程ロック開始実行失敗！");
        }
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", psExtinfo);
        poExtinfoMapList.add(poExtinfoMap);
        StartTaskInBean inBean = new StartTaskInBean();
        inBean.setFlowid(psFlowId);
        inBean.setGyoumukey(psGyoumukey);
        inBean.setAccountid(psAccountid);
        inBean.setTaskname(psTaskname);
        inBean.setLockkey(psLockkey);
        inBean.setExtInfo(poExtinfoMapList);
        StartTaskOutBean outBean = iwfKouteiClient.execStartTask(inBean);

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey(psGyoumukey);
        aftProcessCancelInBean.setFlowid(psFlowId);
        aftProcessCancelInBean.setAccountid(psAccountid);
        aftProcessCancelInBean.setLockkey(psLockkey);
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

        IwfCoreConfig.getInstance().setLockYouhi(lockYouhi);

        IwfCoreConfig.getInstance().setLockValidTime(lockValidTime);

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("IWF0000", outBean.getSyousaimsgcd());
        assertEquals("タスク開始正常終了しました。", outBean.getSyousaimsg());
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(13)
    public void testValidationOK04() throws Exception {
        String psGyoumukey = BizDate.getSysDateTimeMilli();
        String psFlowId = "tt4";
        String psAccountid = "JUnit";
        String psTaskname = "data-check1";
        String psLockkey = BizDate.getSysDateTimeMilli();
        String psExtinfo = "";

        boolean lockYouhi = IwfCoreConfig.getInstance().isLockYouhi();
        int lockValidTime = IwfCoreConfig.getInstance().getLockValidTime();

        IwfCoreConfig.getInstance().setLockYouhi(true);
        IwfCoreConfig.getInstance().setLockValidTime(1000);

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setGyoumukey(psGyoumukey);
        befProcessCreateInBean.setFlowid(psFlowId);
        befProcessCreateInBean.setAccountid(psAccountid);
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }
        LockProcessInBean befLockProcessInBean = new LockProcessInBean();
        befLockProcessInBean.setGyoumukey(psGyoumukey);
        befLockProcessInBean.setFlowid(psFlowId);
        befLockProcessInBean.setLockkey(psLockkey);
        LockProcessOutBean befLockProcessOutBean = iwfKouteiClient.execLockProcess(befLockProcessInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befLockProcessOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程ロック開始実行失敗！");
        }
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", psExtinfo);
        poExtinfoMapList.add(poExtinfoMap);
        StartTaskInBean inBean = new StartTaskInBean();
        inBean.setGyoumukey(psGyoumukey);
        inBean.setFlowid(psFlowId);
        inBean.setAccountid(psAccountid);
        inBean.setTaskname(psTaskname);
        inBean.setLockkey(psLockkey);
        inBean.setExtInfo(poExtinfoMapList);
        StartTaskOutBean outBean = iwfKouteiClient.execStartTask(inBean);

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey(psGyoumukey);
        aftProcessCancelInBean.setFlowid(psFlowId);
        aftProcessCancelInBean.setAccountid(psAccountid);
        aftProcessCancelInBean.setLockkey(psLockkey);
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

        IwfCoreConfig.getInstance().setLockYouhi(lockYouhi);

        IwfCoreConfig.getInstance().setLockValidTime(lockValidTime);

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("IWF0000", outBean.getSyousaimsgcd());
        assertEquals("タスク開始正常終了しました。", outBean.getSyousaimsg());
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(14)
    public void testKyoukaiOK01() throws Exception {
        String psGyoumukey = TestUtil.nString_zenkaku(19);
        String psFlowid = "tt4";
        String psAccountid = "JUnit";
        String psTaskname = "data-check1";
        String psLockkey = BizDate.getSysDateTimeMilli();
        String psExtinfo = "付加情報";

        boolean lockYouhi = IwfCoreConfig.getInstance().isLockYouhi();
        int lockValidTime = IwfCoreConfig.getInstance().getLockValidTime();

        IwfCoreConfig.getInstance().setLockYouhi(true);
        IwfCoreConfig.getInstance().setLockValidTime(1000);

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setGyoumukey(psGyoumukey);
        befProcessCreateInBean.setFlowid(psFlowid);
        befProcessCreateInBean.setAccountid(psAccountid);
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        LockProcessInBean befLockProcessInBean = new LockProcessInBean();
        befLockProcessInBean.setGyoumukey(psGyoumukey);
        befLockProcessInBean.setFlowid(psFlowid);
        befLockProcessInBean.setLockkey(psLockkey);
        LockProcessOutBean befLockProcessOutBean = iwfKouteiClient.execLockProcess(befLockProcessInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befLockProcessOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程ロック開始実行失敗！");
        }

        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", psExtinfo);
        poExtinfoMapList.add(poExtinfoMap);

        StartTaskInBean inBean = new StartTaskInBean();
        inBean.setGyoumukey(psGyoumukey);
        inBean.setFlowid(psFlowid);
        inBean.setAccountid(psAccountid);
        inBean.setTaskname(psTaskname);
        inBean.setLockkey(psLockkey);
        inBean.setExtInfo(poExtinfoMapList);

        StartTaskOutBean outBean = iwfKouteiClient.execStartTask(inBean);

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey(psGyoumukey);
        aftProcessCancelInBean.setFlowid(psFlowid);
        aftProcessCancelInBean.setAccountid(psAccountid);
        aftProcessCancelInBean.setLockkey(psLockkey);
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

        IwfCoreConfig.getInstance().setLockYouhi(lockYouhi);

        IwfCoreConfig.getInstance().setLockValidTime(lockValidTime);

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("IWF0000", outBean.getSyousaimsgcd());
        assertEquals("タスク開始正常終了しました。", outBean.getSyousaimsg());

    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(15)
    public void testKyoukaiOK02() throws Exception {
        String psGyoumukey = TestUtil.nString_zenkaku(20);
        String psFlowid = "tt4";
        String psAccountid = "JUnit";
        String psLockkey = BizDate.getSysDateTimeMilli();
        String psTaskname = "data-check1";
        String psExtinfo = "付加情報";

        boolean lockYouhi = IwfCoreConfig.getInstance().isLockYouhi();
        int lockValidTime = IwfCoreConfig.getInstance().getLockValidTime();

        IwfCoreConfig.getInstance().setLockYouhi(true);
        IwfCoreConfig.getInstance().setLockValidTime(1000);
        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setGyoumukey(psGyoumukey);
        befProcessCreateInBean.setFlowid(psFlowid);
        befProcessCreateInBean.setAccountid(psAccountid);
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        LockProcessInBean befLockProcessInBean = new LockProcessInBean();
        befLockProcessInBean.setGyoumukey(psGyoumukey);
        befLockProcessInBean.setFlowid(psFlowid);
        befLockProcessInBean.setLockkey(psLockkey);
        LockProcessOutBean befLockProcessOutBean = iwfKouteiClient.execLockProcess(befLockProcessInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befLockProcessOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程ロック開始実行失敗！");
        }

        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", psExtinfo);
        poExtinfoMapList.add(poExtinfoMap);

        StartTaskInBean inBean = new StartTaskInBean();
        inBean.setGyoumukey(psGyoumukey);
        inBean.setFlowid(psFlowid);
        inBean.setAccountid(psAccountid);
        inBean.setTaskname(psTaskname);
        inBean.setLockkey(psLockkey);
        inBean.setExtInfo(poExtinfoMapList);

        StartTaskOutBean outBean = iwfKouteiClient.execStartTask(inBean);

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey(psGyoumukey);
        aftProcessCancelInBean.setFlowid(psFlowid);
        aftProcessCancelInBean.setAccountid(psAccountid);
        aftProcessCancelInBean.setLockkey(psLockkey);
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

        IwfCoreConfig.getInstance().setLockYouhi(lockYouhi);

        IwfCoreConfig.getInstance().setLockValidTime(lockValidTime);

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("IWF0000", outBean.getSyousaimsgcd());
        assertEquals("タスク開始正常終了しました。", outBean.getSyousaimsg());
    }

    @Test
    @TestOrder(16)
    public void testKyoukaiNG01() {
        String psGyoumukey = TestUtil.nString_zenkaku(21);
        String psFlowid = "09";
        String psAccountid = "Tt";
        String psLockkey = "ロックキー2_3";
        String psTaskname = "torikesi-check1";
        String psExtinfo = "付加情報";

        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", psExtinfo);
        poExtinfoMapList.add(poExtinfoMap);

        StartTaskInBean inBean = new StartTaskInBean();
        inBean.setGyoumukey(psGyoumukey);
        inBean.setFlowid(psFlowid);
        inBean.setAccountid(psAccountid);
        inBean.setTaskname(psTaskname);
        inBean.setLockkey(psLockkey);
        inBean.setExtInfo(poExtinfoMapList);

        StartTaskOutBean outBean = iwfKouteiClient.execStartTask(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("IWF0008", outBean.getSyousaimsgcd());
        assertEquals("業務キーは20文字以内で入力してください。", outBean.getSyousaimsg());
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(17)
    public void testKyoukaiOK03() throws Exception {
        String psGyoumukey = BizDate.getSysDateTimeMilli()+"業務キ";
        String psFlowid = "tt4";
        String psAccountid = "JUnit";
        String psTaskname = "data-check1";
        String psLockkey = BizDate.getSysDateTimeMilli();
        String psExtinfo = "付加情報";

        boolean lockYouhi = IwfCoreConfig.getInstance().isLockYouhi();
        int lockValidTime = IwfCoreConfig.getInstance().getLockValidTime();

        IwfCoreConfig.getInstance().setLockYouhi(true);
        IwfCoreConfig.getInstance().setLockValidTime(1000);
        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setGyoumukey(psGyoumukey);
        befProcessCreateInBean.setFlowid(psFlowid);
        befProcessCreateInBean.setAccountid(psAccountid);
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        LockProcessInBean befLockProcessInBean = new LockProcessInBean();
        befLockProcessInBean.setGyoumukey(psGyoumukey);
        befLockProcessInBean.setFlowid(psFlowid);
        befLockProcessInBean.setLockkey(psLockkey);
        LockProcessOutBean befLockProcessOutBean = iwfKouteiClient.execLockProcess(befLockProcessInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befLockProcessOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程ロック開始実行失敗！");
        }

        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", psExtinfo);
        poExtinfoMapList.add(poExtinfoMap);

        StartTaskInBean inBean = new StartTaskInBean();
        inBean.setGyoumukey(psGyoumukey);
        inBean.setFlowid(psFlowid);
        inBean.setAccountid(psAccountid);
        inBean.setLockkey(psLockkey);
        inBean.setTaskname(psTaskname);
        inBean.setExtInfo(poExtinfoMapList);

        StartTaskOutBean outBean = iwfKouteiClient.execStartTask(inBean);

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey(psGyoumukey);
        aftProcessCancelInBean.setFlowid(psFlowid);
        aftProcessCancelInBean.setAccountid(psAccountid);
        aftProcessCancelInBean.setLockkey(psLockkey);
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

        IwfCoreConfig.getInstance().setLockYouhi(lockYouhi);

        IwfCoreConfig.getInstance().setLockValidTime(lockValidTime);

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("IWF0000", outBean.getSyousaimsgcd());
        assertEquals("タスク開始正常終了しました。", outBean.getSyousaimsg());
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(18)
    public void testKyoukaiOK04() throws Exception {
        String psGyoumukey = BizDate.getSysDateTimeMilli();
        String psFlowid = "フローＩＤフローＩＤフローＩＤフロー";
        String psAccountid = "JUnit";
        String psTaskname = "data-check1";
        String psLockkey = BizDate.getSysDateTimeMilli();
        String psExtinfo = "付加情報";

        boolean lockYouhi = IwfCoreConfig.getInstance().isLockYouhi();
        int lockValidTime = IwfCoreConfig.getInstance().getLockValidTime();

        IwfCoreConfig.getInstance().setLockYouhi(true);
        IwfCoreConfig.getInstance().setLockValidTime(1000);
        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setGyoumukey(psGyoumukey);
        befProcessCreateInBean.setFlowid(psFlowid);
        befProcessCreateInBean.setAccountid(psAccountid);
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        LockProcessInBean befLockProcessInBean = new LockProcessInBean();
        befLockProcessInBean.setGyoumukey(psGyoumukey);
        befLockProcessInBean.setFlowid(psFlowid);
        befLockProcessInBean.setLockkey(psLockkey);
        LockProcessOutBean befLockProcessOutBean = iwfKouteiClient.execLockProcess(befLockProcessInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befLockProcessOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程ロック開始実行失敗！");
        }

        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", psExtinfo);
        poExtinfoMapList.add(poExtinfoMap);

        StartTaskInBean inBean = new StartTaskInBean();
        inBean.setGyoumukey(psGyoumukey);
        inBean.setFlowid(psFlowid);
        inBean.setAccountid(psAccountid);
        inBean.setTaskname(psTaskname);
        inBean.setLockkey(psLockkey);
        inBean.setExtInfo(poExtinfoMapList);

        StartTaskOutBean outBean = iwfKouteiClient.execStartTask(inBean);

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey(psGyoumukey);
        aftProcessCancelInBean.setFlowid(psFlowid);
        aftProcessCancelInBean.setAccountid(psAccountid);
        aftProcessCancelInBean.setLockkey(psLockkey);
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

        IwfCoreConfig.getInstance().setLockYouhi(lockYouhi);

        IwfCoreConfig.getInstance().setLockValidTime(lockValidTime);

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("IWF0000", outBean.getSyousaimsgcd());
        assertEquals("タスク開始正常終了しました。", outBean.getSyousaimsg());

    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(19)
    public void testKyoukaiOK05() throws Exception {
        String psGyoumukey = BizDate.getSysDateTimeMilli();
        String psFlowid = "フローＩＤフローＩＤフローＩＤフローＩ";
        String psAccountid = "JUnit";
        String psLockkey = BizDate.getSysDateTimeMilli();
        String psTaskname = "data-check1";
        String psExtinfo = "付加情報";

        boolean lockYouhi = IwfCoreConfig.getInstance().isLockYouhi();
        int lockValidTime = IwfCoreConfig.getInstance().getLockValidTime();

        IwfCoreConfig.getInstance().setLockYouhi(true);
        IwfCoreConfig.getInstance().setLockValidTime(1000);
        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setGyoumukey(psGyoumukey);
        befProcessCreateInBean.setFlowid(psFlowid);
        befProcessCreateInBean.setAccountid(psAccountid);
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }
        LockProcessInBean befLockProcessInBean = new LockProcessInBean();
        befLockProcessInBean.setGyoumukey(psGyoumukey);
        befLockProcessInBean.setFlowid(psFlowid);
        befLockProcessInBean.setLockkey(psLockkey);
        LockProcessOutBean befLockProcessOutBean = iwfKouteiClient.execLockProcess(befLockProcessInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befLockProcessOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程ロック開始実行失敗！");
        }
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", psExtinfo);
        poExtinfoMapList.add(poExtinfoMap);

        StartTaskInBean inBean = new StartTaskInBean();
        inBean.setGyoumukey(psGyoumukey);
        inBean.setFlowid(psFlowid);
        inBean.setAccountid(psAccountid);
        inBean.setTaskname(psTaskname);
        inBean.setLockkey(psLockkey);
        inBean.setExtInfo(poExtinfoMapList);
        StartTaskOutBean outBean = iwfKouteiClient.execStartTask(inBean);

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey(psGyoumukey);
        aftProcessCancelInBean.setFlowid(psFlowid);
        aftProcessCancelInBean.setAccountid(psAccountid);
        aftProcessCancelInBean.setLockkey(psLockkey);
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

        IwfCoreConfig.getInstance().setLockYouhi(lockYouhi);

        IwfCoreConfig.getInstance().setLockValidTime(lockValidTime);

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("IWF0000", outBean.getSyousaimsgcd());
        assertEquals("タスク開始正常終了しました。", outBean.getSyousaimsg());
    }

    @Test
    @TestOrder(20)
    public void testKyoukaiNG02() {
        String psGyoumukey = "業務キー2_7";
        String psFlowid = "フローＩＤフローＩＤフローＩＤフローＩＤ";
        String psAccountid = "Tt";
        String psLockkey = "ロックキー2_7";
        String psTaskname = "torikesi-check1";
        String psExtinfo = "付加情報";

        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", psExtinfo);
        poExtinfoMapList.add(poExtinfoMap);

        StartTaskInBean inBean = new StartTaskInBean();
        inBean.setGyoumukey(psGyoumukey);
        inBean.setFlowid(psFlowid);
        inBean.setAccountid(psAccountid);
        inBean.setTaskname(psTaskname);
        inBean.setLockkey(psLockkey);
        inBean.setExtInfo(poExtinfoMapList);

        StartTaskOutBean outBean = iwfKouteiClient.execStartTask(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("IWF0008", outBean.getSyousaimsgcd());
        assertEquals("フローＩＤは19文字以内で入力してください。", outBean.getSyousaimsg());

    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(21)
    public void testKyoukaiOK06() throws Exception {
        String psGyoumukey = BizDate.getSysDateTimeMilli();
        String psFlowid = "フローＩＤ0001";
        String psAccountid = "JUnit";
        String psTaskname = "torikesi-check1";
        String psLockkey = BizDate.getSysDateTimeMilli();
        String psExtinfo = "付加情報";

        boolean lockYouhi = IwfCoreConfig.getInstance().isLockYouhi();
        int lockValidTime = IwfCoreConfig.getInstance().getLockValidTime();

        IwfCoreConfig.getInstance().setLockYouhi(true);
        IwfCoreConfig.getInstance().setLockValidTime(1000);

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setGyoumukey(psGyoumukey);
        befProcessCreateInBean.setFlowid(psFlowid);
        befProcessCreateInBean.setAccountid(psAccountid);
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        LockProcessInBean befLockProcessInBean = new LockProcessInBean();
        befLockProcessInBean.setGyoumukey(psGyoumukey);
        befLockProcessInBean.setFlowid(psFlowid);
        befLockProcessInBean.setLockkey(psLockkey);
        LockProcessOutBean befLockProcessOutBean = iwfKouteiClient.execLockProcess(befLockProcessInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befLockProcessOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程ロック開始実行失敗！");
        }
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", psExtinfo);
        poExtinfoMapList.add(poExtinfoMap);

        StartTaskInBean inBean = new StartTaskInBean();
        inBean.setFlowid(psFlowid);
        inBean.setGyoumukey(psGyoumukey);
        inBean.setAccountid(psAccountid);
        inBean.setTaskname(psTaskname);
        inBean.setLockkey(psLockkey);
        inBean.setExtInfo(poExtinfoMapList);

        StartTaskOutBean outBean = iwfKouteiClient.execStartTask(inBean);

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey(psGyoumukey);
        aftProcessCancelInBean.setFlowid(psFlowid);
        aftProcessCancelInBean.setAccountid(psAccountid);
        aftProcessCancelInBean.setLockkey(psLockkey);
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

        IwfCoreConfig.getInstance().setLockYouhi(lockYouhi);

        IwfCoreConfig.getInstance().setLockValidTime(lockValidTime);

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("IWF0000", outBean.getSyousaimsgcd());
        assertEquals("タスク開始正常終了しました。", outBean.getSyousaimsg());
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(22)
    public void testKyoukaiOK07() throws Exception {
        String psGyoumukey = BizDate.getSysDateTimeMilli();
        String psFlowid = "tt4";
        String psAccountid = "abcde123456789012345678901234";
        String psLockkey = BizDate.getSysDateTimeMilli();
        String psTaskname = "data-check1";
        String psExtinfo = "付加情報";

        boolean lockYouhi = IwfCoreConfig.getInstance().isLockYouhi();
        int lockValidTime = IwfCoreConfig.getInstance().getLockValidTime();

        IwfCoreConfig.getInstance().setLockYouhi(true);
        IwfCoreConfig.getInstance().setLockValidTime(1000);

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setGyoumukey(psGyoumukey);
        befProcessCreateInBean.setFlowid(psFlowid);
        befProcessCreateInBean.setAccountid(psAccountid);
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }
        LockProcessInBean befLockProcessInBean = new LockProcessInBean();
        befLockProcessInBean.setGyoumukey(psGyoumukey);
        befLockProcessInBean.setFlowid(psFlowid);
        befLockProcessInBean.setLockkey(psLockkey);
        LockProcessOutBean befLockProcessOutBean = iwfKouteiClient.execLockProcess(befLockProcessInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befLockProcessOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程ロック開始実行失敗！");
        }
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", psExtinfo);
        poExtinfoMapList.add(poExtinfoMap);

        StartTaskInBean inBean = new StartTaskInBean();
        inBean.setGyoumukey(psGyoumukey);
        inBean.setFlowid(psFlowid);
        inBean.setAccountid(psAccountid);
        inBean.setLockkey(psLockkey);
        inBean.setTaskname(psTaskname);
        inBean.setExtInfo(poExtinfoMapList);
        StartTaskOutBean outBean = iwfKouteiClient.execStartTask(inBean);

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey(psGyoumukey);
        aftProcessCancelInBean.setFlowid(psFlowid);
        aftProcessCancelInBean.setAccountid(psAccountid);
        aftProcessCancelInBean.setLockkey(psLockkey);
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

        IwfCoreConfig.getInstance().setLockYouhi(lockYouhi);

        IwfCoreConfig.getInstance().setLockValidTime(lockValidTime);

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("IWF0000", outBean.getSyousaimsgcd());
        assertEquals("タスク開始正常終了しました。", outBean.getSyousaimsg());
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(23)
    public void testKyoukaiOK08() throws Exception {
        String psGyoumukey = BizDate.getSysDateTimeMilli();
        String psFlowid = "tt4";
        String psAccountid = "abcde1234567890123456789012345";
        String psLockkey = BizDate.getSysDateTimeMilli();
        String psTaskname = "data-check1";
        String psExtinfo = "付加情報";

        boolean lockYouhi = IwfCoreConfig.getInstance().isLockYouhi();
        int lockValidTime = IwfCoreConfig.getInstance().getLockValidTime();

        IwfCoreConfig.getInstance().setLockYouhi(true);
        IwfCoreConfig.getInstance().setLockValidTime(1000);

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setGyoumukey(psGyoumukey);
        befProcessCreateInBean.setFlowid(psFlowid);
        befProcessCreateInBean.setAccountid(psAccountid);
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        LockProcessInBean befLockProcessInBean = new LockProcessInBean();
        befLockProcessInBean.setGyoumukey(psGyoumukey);
        befLockProcessInBean.setFlowid(psFlowid);
        befLockProcessInBean.setLockkey(psLockkey);
        LockProcessOutBean befLockProcessOutBean = iwfKouteiClient.execLockProcess(befLockProcessInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befLockProcessOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程ロック開始実行失敗！");
        }

        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", psExtinfo);
        poExtinfoMapList.add(poExtinfoMap);
        StartTaskInBean inBean = new StartTaskInBean();
        inBean.setGyoumukey(psGyoumukey);
        inBean.setFlowid(psFlowid);
        inBean.setAccountid(psAccountid);
        inBean.setTaskname(psTaskname);
        inBean.setLockkey(psLockkey);
        inBean.setExtInfo(poExtinfoMapList);
        StartTaskOutBean outBean = iwfKouteiClient.execStartTask(inBean);

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey(psGyoumukey);
        aftProcessCancelInBean.setFlowid(psFlowid);
        aftProcessCancelInBean.setAccountid(psAccountid);
        aftProcessCancelInBean.setLockkey(psLockkey);
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

        IwfCoreConfig.getInstance().setLockYouhi(lockYouhi);

        IwfCoreConfig.getInstance().setLockValidTime(lockValidTime);

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("IWF0000", outBean.getSyousaimsgcd());
        assertEquals("タスク開始正常終了しました。", outBean.getSyousaimsg());

    }

    @Test
    @TestOrder(24)
    public void testKyoukaiNG03() {
        String psGyoumukey = "業務キー2_11";
        String psFlowid = "09";
        String psAccountid = "abcde12345678901234567890123456";
        String psLockkey = "ロックキー2_11";
        String psTaskname = "torikesi-check1";
        String psExtinfo = "付加情報";

        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", psExtinfo);
        poExtinfoMapList.add(poExtinfoMap);

        StartTaskInBean inBean = new StartTaskInBean();
        inBean.setGyoumukey(psGyoumukey);
        inBean.setFlowid(psFlowid);
        inBean.setAccountid(psAccountid);
        inBean.setTaskname(psTaskname);
        inBean.setLockkey(psLockkey);
        inBean.setExtInfo(poExtinfoMapList);

        StartTaskOutBean outBean = iwfKouteiClient.execStartTask(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("IWF0008", outBean.getSyousaimsgcd());
        assertEquals("アカウントＩＤは30文字以内で入力してください。", outBean.getSyousaimsg());


    }

    // ■カウントＩＤはユーザーＩＤなので「全角」の指定ができないため、テストケースを削除する。
    //    @SuppressWarnings("deprecation")
    //    public void testKyoukaiOK09() throws Exception {
    //        String psGyoumukey = BizDate.getSysDateTimeMilli();
    //        String psFlowid = "tt4";
    //        String psAccountid = "アカウントＩＤ0001";
    //        String psTaskname = "data-input1";
    //        String psLockkey = BizDate.getSysDateTimeMilli();
    //        String psExtinfo = "付加情報";
    //        IwfCoreConfig.getInstance().setLockYouhi(true);
    //        IwfCoreConfig.getInstance().setLockValidTime(1000);
    //
    //        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
    //        befProcessCreateInBean.setGyoumukey(psGyoumukey);
    //        befProcessCreateInBean.setFlowid(psFlowid);
    //        befProcessCreateInBean.setAccountid(psAccountid);
    //        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
    //        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
    //            throw new Exception("前処理：工程作成実行失敗！");
    //        }
    //
    //        LockProcessInBean befLockProcessInBean = new LockProcessInBean();
    //        befLockProcessInBean.setGyoumukey(psGyoumukey);
    //        befLockProcessInBean.setFlowid(psFlowid);
    //        befLockProcessInBean.setLockkey(psLockkey);
    //        LockProcessOutBean befLockProcessOutBean = iwfKouteiClient.execLockProcess(befLockProcessInBean);
    //        if (!C_ResultCdKbn.OK.toString().equals(befLockProcessOutBean.getKekkastatus())) {
    //            throw new Exception("前処理：工程ロック開始実行失敗！");
    //        }
    //
    //        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
    //        Map<String, String> poExtinfoMap = new HashMap<String, String>();
    //        poExtinfoMap.put("extinfo", psExtinfo);
    //        poExtinfoMapList.add(poExtinfoMap);
    //        StartTaskInBean inBean = new StartTaskInBean();
    //        inBean.setGyoumukey(psGyoumukey);
    //        inBean.setFlowid(psFlowid);
    //        inBean.setAccountid(psAccountid);
    //        inBean.setTaskname(psTaskname);
    //        inBean.setLockkey(psLockkey);
    //        inBean.setExtInfo(poExtinfoMapList);
    //        StartTaskOutBean outBean = iwfKouteiClient.execStartTask(inBean);
    //
    //        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
    //        assertEquals("IWF0000", outBean.getSyousaimsgcd());
    //        assertEquals("タスク開始正常終了しました。", outBean.getSyousaimsg());
    //
    //        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
    //        aftProcessCancelInBean.setFlowid(psFlowid);
    //        aftProcessCancelInBean.setGyoumukey(psGyoumukey);
    //        aftProcessCancelInBean.setAccountid(psAccountid);
    //        aftProcessCancelInBean.setLockkey(psLockkey);
    //        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
    //        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
    //            throw new Exception("後処理：工程取消実行失敗！");
    //        }
    //    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(26)
    public void testKyoukaiOK10() throws Exception {
        String psFlowid = "業務キー0003";
        String psGyoumukey = BizDate.getSysDateTimeMilli();
        String psAccountid = "JUnit";
        String psTaskname = "タスク名タスク名タスク名タスク名タスク名タスク名";
        String psLockkey = BizDate.getSysDateTimeMilli();
        String psExtinfo = "付加情報";

        boolean lockYouhi = IwfCoreConfig.getInstance().isLockYouhi();
        int lockValidTime = IwfCoreConfig.getInstance().getLockValidTime();

        IwfCoreConfig.getInstance().setLockYouhi(true);
        IwfCoreConfig.getInstance().setLockValidTime(1000);

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setGyoumukey(psGyoumukey);
        befProcessCreateInBean.setFlowid(psFlowid);
        befProcessCreateInBean.setAccountid(psAccountid);
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        LockProcessInBean befLockProcessInBean = new LockProcessInBean();
        befLockProcessInBean.setGyoumukey(psGyoumukey);
        befLockProcessInBean.setFlowid(psFlowid);
        befLockProcessInBean.setLockkey(psLockkey);
        LockProcessOutBean befLockProcessOutBean = iwfKouteiClient.execLockProcess(befLockProcessInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befLockProcessOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程ロック開始実行失敗！");
        }

        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", psExtinfo);
        poExtinfoMapList.add(poExtinfoMap);

        StartTaskInBean inBean = new StartTaskInBean();
        inBean.setGyoumukey(psGyoumukey);
        inBean.setFlowid(psFlowid);
        inBean.setAccountid(psAccountid);
        inBean.setTaskname(psTaskname);
        inBean.setLockkey(psLockkey);
        inBean.setExtInfo(poExtinfoMapList);
        StartTaskOutBean outBean = iwfKouteiClient.execStartTask(inBean);

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setFlowid(psFlowid);
        aftProcessCancelInBean.setGyoumukey(psGyoumukey);
        aftProcessCancelInBean.setAccountid(psAccountid);
        aftProcessCancelInBean.setLockkey(psLockkey);
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

        IwfCoreConfig.getInstance().setLockYouhi(lockYouhi);

        IwfCoreConfig.getInstance().setLockValidTime(lockValidTime);

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("IWF0000", outBean.getSyousaimsgcd());
        assertEquals("タスク開始正常終了しました。", outBean.getSyousaimsg());

    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(27)
    public void testKyoukaiOK11() throws Exception {
        String psGyoumukey = BizDate.getSysDateTimeMilli();
        String psFlowid = "KyoukaiOK11";
        String psAccountid = "JUnit";
        String psTaskname = "タスク名タスク名タスク名タスク名タスク名タスク名タ";
        String psLockkey = BizDate.getSysDateTimeMilli();
        String psExtinfo = "付加情報";

        boolean lockYouhi = IwfCoreConfig.getInstance().isLockYouhi();
        int lockValidTime = IwfCoreConfig.getInstance().getLockValidTime();

        IwfCoreConfig.getInstance().setLockYouhi(true);
        IwfCoreConfig.getInstance().setLockValidTime(1000);

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setGyoumukey(psGyoumukey);
        befProcessCreateInBean.setFlowid(psFlowid);
        befProcessCreateInBean.setAccountid(psAccountid);
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        LockProcessInBean befLockProcessInBean = new LockProcessInBean();
        befLockProcessInBean.setGyoumukey(psGyoumukey);
        befLockProcessInBean.setFlowid(psFlowid);
        befLockProcessInBean.setLockkey(psLockkey);
        LockProcessOutBean befLockProcessOutBean = iwfKouteiClient.execLockProcess(befLockProcessInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befLockProcessOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程ロック開始実行失敗！");
        }
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", psExtinfo);
        poExtinfoMapList.add(poExtinfoMap);
        StartTaskInBean inBean = new StartTaskInBean();
        inBean.setGyoumukey(psGyoumukey);
        inBean.setFlowid(psFlowid);
        inBean.setAccountid(psAccountid);
        inBean.setTaskname(psTaskname);
        inBean.setLockkey(psLockkey);
        inBean.setExtInfo(poExtinfoMapList);
        StartTaskOutBean outBean = iwfKouteiClient.execStartTask(inBean);

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey(psGyoumukey);
        aftProcessCancelInBean.setFlowid(psFlowid);
        aftProcessCancelInBean.setAccountid(psAccountid);
        aftProcessCancelInBean.setLockkey(psLockkey);
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

        IwfCoreConfig.getInstance().setLockYouhi(lockYouhi);

        IwfCoreConfig.getInstance().setLockValidTime(lockValidTime);

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("IWF0000", outBean.getSyousaimsgcd());
        assertEquals("タスク開始正常終了しました。", outBean.getSyousaimsg());

    }

    @Test
    @TestOrder(28)
    public void testKyoukaiNG04() {
        String psGyoumukey = "業務キー2_15";
        String psFlowid = "フローＩＤ2_15";
        String psAccountid = "Tt";
        String psTaskname = "タスク名タスク名タスク名タスク名タスク名タスク名タス";
        String psLockkey = "ロックキー2_15";
        String psExtinfo = "付加情報";

        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", psExtinfo);
        poExtinfoMapList.add(poExtinfoMap);

        StartTaskInBean inBean = new StartTaskInBean();
        inBean.setGyoumukey(psGyoumukey);
        inBean.setFlowid(psFlowid);
        inBean.setAccountid(psAccountid);
        inBean.setTaskname(psTaskname);
        inBean.setLockkey(psLockkey);
        inBean.setExtInfo(poExtinfoMapList);

        StartTaskOutBean outBean = iwfKouteiClient.execStartTask(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("IWF0008", outBean.getSyousaimsgcd());
        assertEquals("タスク名は25文字以内で入力してください。", outBean.getSyousaimsg());

    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(29)
    public void testKyoukaiOK12() throws Exception {
        String psGyoumukey = BizDate.getSysDateTimeMilli();
        String psFlowid = "フローＩＤ(タスク名全半)";
        String psAccountid = "JUnit";
        String psTaskname = "task名";
        String psLockkey = BizDate.getSysDateTimeMilli();
        String psExtinfo = "付加情報";

        boolean lockYouhi = IwfCoreConfig.getInstance().isLockYouhi();
        int lockValidTime = IwfCoreConfig.getInstance().getLockValidTime();

        IwfCoreConfig.getInstance().setLockYouhi(true);
        IwfCoreConfig.getInstance().setLockValidTime(1000);

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setGyoumukey(psGyoumukey);
        befProcessCreateInBean.setFlowid(psFlowid);
        befProcessCreateInBean.setAccountid(psAccountid);
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        LockProcessInBean befLockProcessInBean = new LockProcessInBean();
        befLockProcessInBean.setGyoumukey(psGyoumukey);
        befLockProcessInBean.setFlowid(psFlowid);
        befLockProcessInBean.setLockkey(psLockkey);
        LockProcessOutBean befLockProcessOutBean = iwfKouteiClient.execLockProcess(befLockProcessInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befLockProcessOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程ロック開始実行失敗！");
        }
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", psExtinfo);
        poExtinfoMapList.add(poExtinfoMap);

        StartTaskInBean inBean = new StartTaskInBean();
        inBean.setGyoumukey(psGyoumukey);
        inBean.setFlowid(psFlowid);
        inBean.setAccountid(psAccountid);
        inBean.setTaskname(psTaskname);
        inBean.setLockkey(psLockkey);
        inBean.setExtInfo(poExtinfoMapList);
        StartTaskOutBean outBean = iwfKouteiClient.execStartTask(inBean);

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey(psGyoumukey);
        aftProcessCancelInBean.setFlowid(psFlowid);
        aftProcessCancelInBean.setAccountid(psAccountid);
        aftProcessCancelInBean.setLockkey(psLockkey);
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

        IwfCoreConfig.getInstance().setLockYouhi(lockYouhi);

        IwfCoreConfig.getInstance().setLockValidTime(lockValidTime);

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("IWF0000", outBean.getSyousaimsgcd());
        assertEquals("タスク開始正常終了しました。", outBean.getSyousaimsg());
    }

    @Test
    @TestOrder(30)
    public void testInfoExistNG01() {
        String psFlowid = "09";
        String psGyoumukey = BizDate.getSysDateTimeMilli();
        String psAccountid = "Tt";
        String psTaskname = "タスク名";
        String psLockkey = "ロックキー3_1";
        String psExtinfo = "付加情報";

        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", psExtinfo);
        poExtinfoMapList.add(poExtinfoMap);

        StartTaskInBean inBean = new StartTaskInBean();
        inBean.setGyoumukey(psGyoumukey);
        inBean.setFlowid(psFlowid);
        inBean.setAccountid(psAccountid);
        inBean.setTaskname(psTaskname);
        inBean.setLockkey(psLockkey);
        inBean.setExtInfo(poExtinfoMapList);

        StartTaskOutBean outBean = iwfKouteiClient.execStartTask(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("IWF2010", outBean.getSyousaimsgcd());
        assertEquals("トークンIDが取得できませんでした。", outBean.getSyousaimsg());

    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(31)
    public void testInfoExistNG02() throws Exception {
        String psGyoumukey = BizDate.getSysDateTimeMilli();
        String psFlowId = "tt4";
        String psAccountid = "JUnit";
        String psTaskname = "タスク名";
        String psLockkey = BizDate.getSysDateTimeMilli();
        String psExtinfo = "付加情報";

        boolean lockYouhi = IwfCoreConfig.getInstance().isLockYouhi();
        int lockValidTime = IwfCoreConfig.getInstance().getLockValidTime();

        IwfCoreConfig.getInstance().setLockYouhi(true);
        IwfCoreConfig.getInstance().setLockValidTime(1000);

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setGyoumukey(psGyoumukey);
        befProcessCreateInBean.setFlowid(psFlowId);
        befProcessCreateInBean.setAccountid(psAccountid);
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", psExtinfo);
        poExtinfoMapList.add(poExtinfoMap);

        StartTaskInBean inBean = new StartTaskInBean();
        inBean.setGyoumukey(psGyoumukey);
        inBean.setFlowid(psFlowId);
        inBean.setAccountid(psAccountid);
        inBean.setTaskname(psTaskname);
        inBean.setLockkey(psLockkey);
        inBean.setExtInfo(poExtinfoMapList);

        StartTaskOutBean outBean = iwfKouteiClient.execStartTask(inBean);

        LockProcessInBean aftLockProcessInBean = new LockProcessInBean();
        aftLockProcessInBean.setGyoumukey(psGyoumukey);
        aftLockProcessInBean.setFlowid(psFlowId);
        aftLockProcessInBean.setLockkey(psLockkey);
        LockProcessOutBean aftLockProcessOutBean = iwfKouteiClient.execLockProcess(aftLockProcessInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey(psGyoumukey);
        aftProcessCancelInBean.setFlowid(psFlowId);
        aftProcessCancelInBean.setAccountid(psAccountid);
        aftProcessCancelInBean.setLockkey(psLockkey);
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

        IwfCoreConfig.getInstance().setLockYouhi(lockYouhi);

        IwfCoreConfig.getInstance().setLockValidTime(lockValidTime);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("IWF2011", outBean.getSyousaimsgcd());
        assertEquals("ロックキーが無効です。他の作業者がロック中、またはロックが既に解除されています。", outBean.getSyousaimsg());

    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(32)
    public void testInfoExistNG03() throws Exception {
        String psGyoumukey = BizDate.getSysDateTimeMilli();
        String psFlowId = "tt4";
        String psAccountid = "JUnit";
        String psTaskname = "data-input1";
        String psLockkey = BizDate.getSysDateTimeMilli();
        String psLockkeyNoEffort = "テスト無効ロックキー";
        String psExtinfo = "付加情報";

        boolean lockYouhi = IwfCoreConfig.getInstance().isLockYouhi();
        int lockValidTime = IwfCoreConfig.getInstance().getLockValidTime();

        IwfCoreConfig.getInstance().setLockYouhi(true);
        IwfCoreConfig.getInstance().setLockValidTime(1000);

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setGyoumukey(psGyoumukey);
        befProcessCreateInBean.setFlowid(psFlowId);
        befProcessCreateInBean.setAccountid(psAccountid);
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        LockProcessInBean befLockProcessInBean = new LockProcessInBean();
        befLockProcessInBean.setGyoumukey(psGyoumukey);
        befLockProcessInBean.setFlowid(psFlowId);
        befLockProcessInBean.setLockkey(psLockkey);
        LockProcessOutBean befLockProcessOutBean = iwfKouteiClient.execLockProcess(befLockProcessInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befLockProcessOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程ロック開始実行失敗！");
        }

        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", psExtinfo);
        poExtinfoMapList.add(poExtinfoMap);

        StartTaskInBean inBean = new StartTaskInBean();
        inBean.setGyoumukey(psGyoumukey);
        inBean.setFlowid(psFlowId);
        inBean.setAccountid(psAccountid);
        inBean.setTaskname(psTaskname);
        inBean.setLockkey(psLockkeyNoEffort);
        inBean.setExtInfo(poExtinfoMapList);
        StartTaskOutBean outBean = iwfKouteiClient.execStartTask(inBean);

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey(psGyoumukey);
        aftProcessCancelInBean.setFlowid(psFlowId);
        aftProcessCancelInBean.setAccountid(psAccountid);
        aftProcessCancelInBean.setLockkey(psLockkey);
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

        IwfCoreConfig.getInstance().setLockYouhi(lockYouhi);

        IwfCoreConfig.getInstance().setLockValidTime(lockValidTime);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("IWF2011", outBean.getSyousaimsgcd());
        assertEquals("ロックキーが無効です。他の作業者がロック中、またはロックが既に解除されています。", outBean.getSyousaimsg());
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(33)
    public void testInfoExistNG04() throws Exception {
        String psGyoumukey = BizDate.getSysDateTimeMilli();
        String psFlowId = "tt4";
        String psAccountid = "JUnit";
        String psLockkey = BizDate.getSysDateTimeMilli();
        String psTaskname = "data-check1";
        String psExtinfo = "付加情報";

        boolean lockYouhi = IwfCoreConfig.getInstance().isLockYouhi();
        int lockValidTime = IwfCoreConfig.getInstance().getLockValidTime();

        IwfCoreConfig.getInstance().setLockYouhi(true);
        IwfCoreConfig.getInstance().setLockValidTime(1000);

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setGyoumukey(psGyoumukey);
        befProcessCreateInBean.setFlowid(psFlowId);
        befProcessCreateInBean.setAccountid(psAccountid);
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        LockProcessInBean befLockProcessInBean = new LockProcessInBean();
        befLockProcessInBean.setGyoumukey(psGyoumukey);
        befLockProcessInBean.setFlowid(psFlowId);
        befLockProcessInBean.setLockkey(psLockkey);
        LockProcessOutBean befLockProcessOutBean = iwfKouteiClient.execLockProcess(befLockProcessInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befLockProcessOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程ロック開始実行失敗！");
        }
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", psExtinfo);
        poExtinfoMapList.add(poExtinfoMap);
        StartTaskInBean inBean = new StartTaskInBean();
        inBean.setGyoumukey(psGyoumukey);
        inBean.setFlowid(psFlowId);
        inBean.setAccountid(psAccountid+"NG");
        inBean.setTaskname(psTaskname);
        inBean.setLockkey(psLockkey);
        inBean.setExtInfo(poExtinfoMapList);
        StartTaskOutBean outBean = iwfKouteiClient.execStartTask(inBean);

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey(psGyoumukey);
        aftProcessCancelInBean.setFlowid(psFlowId);
        aftProcessCancelInBean.setAccountid(psAccountid);
        aftProcessCancelInBean.setLockkey(psLockkey);
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

        IwfCoreConfig.getInstance().setLockYouhi(lockYouhi);

        IwfCoreConfig.getInstance().setLockValidTime(lockValidTime);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("IWF2014", outBean.getSyousaimsgcd());
        assertEquals("タスクの実行権限がありません。", outBean.getSyousaimsg());
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(34)
    public void testInfoExistNG05() throws Exception {
        String psGyoumukey = BizDate.getSysDateTimeMilli();
        String psFlowId = "tt4";
        String psAccountid = "JUnit";
        String psLockkey = BizDate.getSysDateTimeMilli();
        String psTaskname = "無効タスク名";
        String psExtinfo = "付加情報";

        boolean lockYouhi = IwfCoreConfig.getInstance().isLockYouhi();
        int lockValidTime = IwfCoreConfig.getInstance().getLockValidTime();

        IwfCoreConfig.getInstance().setLockYouhi(true);
        IwfCoreConfig.getInstance().setLockValidTime(1000);

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setGyoumukey(psGyoumukey);
        befProcessCreateInBean.setFlowid(psFlowId);
        befProcessCreateInBean.setAccountid(psAccountid);
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        LockProcessInBean befLockProcessInBean = new LockProcessInBean();
        befLockProcessInBean.setGyoumukey(psGyoumukey);
        befLockProcessInBean.setFlowid(psFlowId);
        befLockProcessInBean.setLockkey(psLockkey);
        LockProcessOutBean befLockProcessOutBean = iwfKouteiClient.execLockProcess(befLockProcessInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befLockProcessOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程ロック開始実行失敗！");
        }
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", psExtinfo);
        poExtinfoMapList.add(poExtinfoMap);
        StartTaskInBean inBean = new StartTaskInBean();
        inBean.setGyoumukey(psGyoumukey);
        inBean.setFlowid(psFlowId);
        inBean.setAccountid(psAccountid);
        inBean.setTaskname(psTaskname);
        inBean.setLockkey(psLockkey);
        inBean.setExtInfo(poExtinfoMapList);

        StartTaskOutBean outBean = iwfKouteiClient.execStartTask(inBean);

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey(psGyoumukey);
        aftProcessCancelInBean.setFlowid(psFlowId);
        aftProcessCancelInBean.setAccountid(psAccountid);
        aftProcessCancelInBean.setLockkey(psLockkey);
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

        IwfCoreConfig.getInstance().setLockYouhi(lockYouhi);

        IwfCoreConfig.getInstance().setLockValidTime(lockValidTime);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("IWF2015", outBean.getSyousaimsgcd());
        assertEquals("指定されたタスク名はフローに定義されていません。", outBean.getSyousaimsg());
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(35)
    public void testInfoExistNG06() throws Exception {
        String psGyoumukey = BizDate.getSysDateTimeMilli();
        String psFlowId = "tt4";
        String psAccountid = "JUnit";
        String psLockkey = BizDate.getSysDateTimeMilli();
        String psTaskname = "data-input1";
        String psExtinfo = "付加情報";

        boolean lockYouhi = IwfCoreConfig.getInstance().isLockYouhi();
        int lockValidTime = IwfCoreConfig.getInstance().getLockValidTime();

        IwfCoreConfig.getInstance().setLockYouhi(true);
        IwfCoreConfig.getInstance().setLockValidTime(1000);

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setGyoumukey(psGyoumukey);
        befProcessCreateInBean.setFlowid(psFlowId);
        befProcessCreateInBean.setAccountid(psAccountid);
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        LockProcessInBean befLockProcessInBean = new LockProcessInBean();
        befLockProcessInBean.setGyoumukey(psGyoumukey);
        befLockProcessInBean.setFlowid(psFlowId);
        befLockProcessInBean.setLockkey(psLockkey);
        LockProcessOutBean befLockProcessOutBean = iwfKouteiClient.execLockProcess(befLockProcessInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befLockProcessOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程ロック開始実行失敗！");
        }

        ProcessCancelInBean befProcessCancelInBean = new ProcessCancelInBean();
        befProcessCancelInBean.setGyoumukey(psGyoumukey);
        befProcessCancelInBean.setFlowid(psFlowId);
        befProcessCancelInBean.setAccountid(psAccountid);
        befProcessCancelInBean.setLockkey(psLockkey);
        ProcessCancelOutBean befProcessCancelOutBean = iwfKouteiClient.execProcessCancel(befProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程取消実行失敗！");
        }
        IwfCoreConfig.getInstance().setLockYouhi(false);

        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", psExtinfo);
        poExtinfoMapList.add(poExtinfoMap);

        StartTaskInBean inBean = new StartTaskInBean();
        inBean.setGyoumukey(psGyoumukey);
        inBean.setFlowid(psFlowId);
        inBean.setAccountid(psAccountid);
        inBean.setTaskname(psTaskname);
        inBean.setLockkey(psLockkey);
        inBean.setExtInfo(poExtinfoMapList);

        StartTaskOutBean outBean = iwfKouteiClient.execStartTask(inBean);

        IwfCoreConfig.getInstance().setLockYouhi(lockYouhi);

        IwfCoreConfig.getInstance().setLockValidTime(lockValidTime);

        assertEquals(C_ResultCdKbn.WARN.toString(), outBean.getKekkastatus());
        assertEquals("IWF2013", outBean.getSyousaimsgcd());
        assertEquals("タスクが存在しません。", outBean.getSyousaimsg());
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(36)
    public void testInfoExistNG07() throws Exception {
        String psFlowId = "infoExistNG07";
        String psGyoumukey = BizDate.getSysDateTimeMilli();
        String psAccountid = "JUnit";
        String psLockkey = BizDate.getSysDateTimeMilli();
        String psTaskname = "data-check1";
        String psExtinfo = "付加情報";
        IwfCoreConfig.getInstance().setLockYouhi(true);
        IwfCoreConfig.getInstance().setLockValidTime(1000);

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setGyoumukey(psGyoumukey);
        befProcessCreateInBean.setFlowid(psFlowId);
        befProcessCreateInBean.setAccountid(psAccountid);
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }
        LockProcessInBean befLockProcessInBean = new LockProcessInBean();
        befLockProcessInBean.setGyoumukey(psGyoumukey);
        befLockProcessInBean.setFlowid(psFlowId);
        befLockProcessInBean.setLockkey(psLockkey);
        LockProcessOutBean befLockProcessOutBean = iwfKouteiClient.execLockProcess(befLockProcessInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befLockProcessOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程ロック開始実行失敗！");
        }
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", psExtinfo);
        poExtinfoMapList.add(poExtinfoMap);

        StartTaskInBean inBean = new StartTaskInBean();
        inBean.setGyoumukey(psGyoumukey);
        inBean.setFlowid(psFlowId);
        inBean.setAccountid(psAccountid);
        inBean.setTaskname("data-input");
        inBean.setLockkey(psLockkey);
        inBean.setExtInfo(poExtinfoMapList);
        StartTaskOutBean outBean = iwfKouteiClient.execStartTask(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("IWF2016", outBean.getSyousaimsgcd());
        assertEquals("指定されたタスクはトークンに存在しません。", outBean.getSyousaimsg());

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey(psGyoumukey);
        aftProcessCancelInBean.setFlowid(psFlowId);
        aftProcessCancelInBean.setAccountid(psAccountid);
        aftProcessCancelInBean.setLockkey(psLockkey);
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(37)
    public void testInfoExistNG08() throws Exception {
        String psGyoumukey = BizDate.getSysDateTimeMilli();
        String psFlowId = "tt4";
        String psAccountid = "JUnit";
        String psLockkey = BizDate.getSysDateTimeMilli();
        String psTaskname = "data-check1";
        String psExtinfo = "付加情報";

        boolean lockYouhi = IwfCoreConfig.getInstance().isLockYouhi();
        int lockValidTime = IwfCoreConfig.getInstance().getLockValidTime();

        IwfCoreConfig.getInstance().setLockYouhi(true);
        IwfCoreConfig.getInstance().setLockValidTime(1000);

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setGyoumukey(psGyoumukey);
        befProcessCreateInBean.setFlowid(psFlowId);
        befProcessCreateInBean.setAccountid(psAccountid);
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        LockProcessInBean befLockProcessInBean = new LockProcessInBean();
        befLockProcessInBean.setGyoumukey(psGyoumukey);
        befLockProcessInBean.setFlowid(psFlowId);
        befLockProcessInBean.setLockkey(psLockkey);
        LockProcessOutBean befLockProcessOutBean = iwfKouteiClient.execLockProcess(befLockProcessInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befLockProcessOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程ロック開始実行失敗！");
        }

        StartTaskInBean befStartTaskInBean = new StartTaskInBean();
        befStartTaskInBean.setGyoumukey(psGyoumukey);
        befStartTaskInBean.setFlowid(psFlowId);
        befStartTaskInBean.setAccountid(psAccountid);
        befStartTaskInBean.setTaskname(psTaskname);
        befStartTaskInBean.setLockkey(psLockkey);

        List<Map<String, String>> pobefStartTaskExtinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> pobefStartTaskExtinfoMap = new HashMap<String, String>();
        pobefStartTaskExtinfoMap.put("extinfo", psExtinfo);
        pobefStartTaskExtinfoMapList.add(pobefStartTaskExtinfoMap);
        befStartTaskInBean.setExtInfo(pobefStartTaskExtinfoMapList);
        StartTaskOutBean befStartTaskOutBean = iwfKouteiClient.execStartTask(befStartTaskInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befStartTaskOutBean.getKekkastatus())) {
            throw new Exception("前処理：タスク開始実行失敗！");
        }

        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", psExtinfo);
        poExtinfoMapList.add(poExtinfoMap);

        StartTaskInBean inBean = new StartTaskInBean();
        inBean.setGyoumukey(psGyoumukey);
        inBean.setFlowid(psFlowId);
        inBean.setAccountid(psAccountid);
        inBean.setTaskname(psTaskname);
        inBean.setLockkey(psLockkey);
        inBean.setExtInfo(poExtinfoMapList);

        StartTaskOutBean outBean = iwfKouteiClient.execStartTask(inBean);

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setFlowid(psFlowId);
        aftProcessCancelInBean.setGyoumukey(psGyoumukey);
        aftProcessCancelInBean.setAccountid(psAccountid);
        aftProcessCancelInBean.setLockkey(psLockkey);
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

        IwfCoreConfig.getInstance().setLockYouhi(lockYouhi);

        IwfCoreConfig.getInstance().setLockValidTime(lockValidTime);

        assertEquals(C_ResultCdKbn.WARN.toString(), outBean.getKekkastatus());
        assertEquals("IWF2012", outBean.getSyousaimsgcd());
        assertEquals("既に担当者が割り当てられています。", outBean.getSyousaimsg());
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(38)
    public void testSyoriLogicOK01() throws Exception {
        String psGyoumukey = BizDate.getSysDateTimeMilli();
        String psFlowId = "kouteitest";
        String psAccountid = "JUnit";
        String psLockkey = BizDate.getSysDateTimeMilli();
        String psTaskname = "torikesi-check1";
        String psExtinfo = "付加情報";

        boolean lockYouhi = IwfCoreConfig.getInstance().isLockYouhi();
        int lockValidTime = IwfCoreConfig.getInstance().getLockValidTime();

        IwfCoreConfig.getInstance().setLockYouhi(true);
        IwfCoreConfig.getInstance().setLockValidTime(1000);

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setGyoumukey(psGyoumukey);
        befProcessCreateInBean.setFlowid(psFlowId);
        befProcessCreateInBean.setAccountid(psAccountid);
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        LockProcessInBean befLockProcessInBean = new LockProcessInBean();
        befLockProcessInBean.setGyoumukey(psGyoumukey);
        befLockProcessInBean.setFlowid(psFlowId);
        befLockProcessInBean.setLockkey(psLockkey);
        LockProcessOutBean befLockProcessOutBean = iwfKouteiClient.execLockProcess(befLockProcessInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befLockProcessOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程ロック開始実行失敗！");
        }
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", psExtinfo);
        poExtinfoMapList.add(poExtinfoMap);
        StartTaskInBean inBean = new StartTaskInBean();
        inBean.setGyoumukey(psGyoumukey);
        inBean.setFlowid(psFlowId);
        inBean.setAccountid(psAccountid);
        inBean.setTaskname(psTaskname);
        inBean.setLockkey(psLockkey);
        inBean.setExtInfo(poExtinfoMapList);
        StartTaskOutBean outBean = iwfKouteiClient.execStartTask(inBean);

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey(psGyoumukey);
        aftProcessCancelInBean.setFlowid(psFlowId);
        aftProcessCancelInBean.setAccountid(psAccountid);
        aftProcessCancelInBean.setLockkey(psLockkey);
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

        IwfCoreConfig.getInstance().setLockYouhi(lockYouhi);

        IwfCoreConfig.getInstance().setLockValidTime(lockValidTime);

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("IWF0000", outBean.getSyousaimsgcd());
        assertEquals("タスク開始正常終了しました。", outBean.getSyousaimsg());
    }

    @SuppressWarnings("deprecation")
    @Test
    public void testSyoriLogicOK02() throws Exception {
        String psGyoumukey = BizDate.getSysDateTimeMilli();
        String psFlowId = "kouteitest";
        String psAccountid = "JUnit";
        String psLockkey = BizDate.getSysDateTimeMilli();
        String psTaskname = "torikesi-check1";
        String psExtinfo = "付加情報";

        boolean lockYouhi = IwfCoreConfig.getInstance().isLockYouhi();
        int lockValidTime = IwfCoreConfig.getInstance().getLockValidTime();

        IwfCoreConfig.getInstance().setLockYouhi(true);
        IwfCoreConfig.getInstance().setLockValidTime(1000);

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setGyoumukey(psGyoumukey);
        befProcessCreateInBean.setFlowid(psFlowId);
        befProcessCreateInBean.setAccountid(psAccountid);
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        LockProcessInBean befLockProcessInBean = new LockProcessInBean();
        befLockProcessInBean.setGyoumukey(psGyoumukey);
        befLockProcessInBean.setFlowid(psFlowId);
        befLockProcessInBean.setLockkey(psLockkey);
        LockProcessOutBean befLockProcessOutBean = iwfKouteiClient.execLockProcess(befLockProcessInBean);

        if (!C_ResultCdKbn.OK.toString().equals(befLockProcessOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程ロック開始実行失敗！");
        }
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", psExtinfo);
        poExtinfoMapList.add(poExtinfoMap);
        StartTaskInBean inBean = new StartTaskInBean();
        inBean.setGyoumukey(psGyoumukey);
        inBean.setFlowid(psFlowId);
        inBean.setAccountid(psAccountid);
        inBean.setTaskname(psTaskname);
        inBean.setLockkey(psLockkey);
        inBean.setExtInfo(poExtinfoMapList);
        StartTaskOutBean outBean = iwfKouteiClient.execStartTask(inBean);

        IwfCoreConfig.getInstance().setLockYouhi(lockYouhi);

        IwfCoreConfig.getInstance().setLockValidTime(lockValidTime);

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("IWF0000", outBean.getSyousaimsgcd());
        assertEquals("タスク開始正常終了しました。", outBean.getSyousaimsg());
        assertTrue("開始日存在チェック",checkStartTime(psFlowId,psGyoumukey));

    }

    private boolean checkStartTime(String psFlowId, String psGyoumukey){

        boolean startTimeFlg = false;

        WT_GyoumuKey gyoumuKey = iwfCoreDomManager.getGyoumuKey(psFlowId, psGyoumukey);

        if (null != gyoumuKey) {
            List<JBPM_TASKINSTANCE> taskIns = iwfCoreDomManager.getTaskInstances();
            if (taskIns.size() > 0) {
                for (JBPM_TASKINSTANCE taskinstance : taskIns){
                    if(gyoumuKey.getTokenId().equals(taskinstance.getToken_().toString()) &&
                        taskinstance.getStart_() != null && !taskinstance.getStart_().isEmpty()){
                        startTimeFlg = true;
                        break;
                    }
                }
            }
        }
        return startTimeFlg;
    }
}
