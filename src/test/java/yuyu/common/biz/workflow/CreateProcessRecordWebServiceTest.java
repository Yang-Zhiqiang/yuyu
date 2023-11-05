package yuyu.common.biz.workflow;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.workflowcore.configration.IwfCoreConfig;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.workflow.io.koutei.CreateProcessRecordInBean;
import yuyu.common.biz.workflow.io.koutei.CreateProcessRecordOutBean;
import yuyu.common.biz.workflow.io.koutei.GetLastRecordByKinouInBean;
import yuyu.common.biz.workflow.io.koutei.GetLastRecordByKinouOutBean;
import yuyu.common.biz.workflow.io.koutei.ProcessCancelInBean;
import yuyu.common.biz.workflow.io.koutei.ProcessCancelOutBean;
import yuyu.common.biz.workflow.io.koutei.ProcessCreateInBean;
import yuyu.common.biz.workflow.io.koutei.ProcessCreateOutBean;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.createprocessrecord.WSCreateProcessRecord;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.createprocessrecord.WSCreateProcessRecordRequest;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.def.classification.C_RirekiKbn;
import yuyu.testinfr.TestOrder;

/**
 * 工程履歴作成Webサービス<br />
 * {@link WSCreateProcessRecord#executeBizMain(WSCreateProcessRecordRequest)}<br />
 * テスト用クラスです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class CreateProcessRecordWebServiceTest {

    @Inject
    IwfKouteiClient iwfKouteiClient;

    @Test(expected = RuntimeException.class)
    @TestOrder(1)
    public void testValidationNG01() {
        iwfKouteiClient.execCcreateProcessRecord(null);
    }

    @Test
    @TestOrder(2)
    public void testValidationNG02() {

        CreateProcessRecordInBean createProcessRecordInBean = new CreateProcessRecordInBean();
        createProcessRecordInBean.setGyoumukey(null);
        createProcessRecordInBean.setFlowid("09");
        createProcessRecordInBean.setAccountid("Tt");
        createProcessRecordInBean.setRirekimsg("履歴メッセージ");
        createProcessRecordInBean.setTaskname("タスク名");

        List<Map<String, String>> extinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> extinfoMap = new HashMap<String, String>();
        extinfoMap.put("extinfo", "付加情報");
        extinfoMapList.add(extinfoMap);
        createProcessRecordInBean.setExtInfo(extinfoMapList);
        CreateProcessRecordOutBean createProcessRecordOutBean = iwfKouteiClient
            .execCcreateProcessRecord(createProcessRecordInBean);

        assertEquals(C_ResultCdKbn.NG.toString(), createProcessRecordOutBean.getKekkastatus());
        assertEquals("IWF0002", createProcessRecordOutBean.getSyousaimsgcd());
        assertEquals("必須入力チェックエラー：業務キー", createProcessRecordOutBean.getSyousaimsg());

    }

    @Test
    @TestOrder(3)
    public void testValidationNG03() {

        CreateProcessRecordInBean createProcessRecordInBean = new CreateProcessRecordInBean();
        createProcessRecordInBean.setGyoumukey("");
        createProcessRecordInBean.setFlowid("09");
        createProcessRecordInBean.setAccountid("Tt");
        createProcessRecordInBean.setRirekimsg("履歴メッセージ");
        createProcessRecordInBean.setTaskname("タスク名");

        List<Map<String, String>> extinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> extinfoMap = new HashMap<String, String>();
        extinfoMap.put("extinfo", "付加情報");
        extinfoMapList.add(extinfoMap);
        createProcessRecordInBean.setExtInfo(extinfoMapList);
        CreateProcessRecordOutBean createProcessRecordOutBean = iwfKouteiClient
            .execCcreateProcessRecord(createProcessRecordInBean);

        assertEquals(C_ResultCdKbn.NG.toString(), createProcessRecordOutBean.getKekkastatus());
        assertEquals("IWF0002", createProcessRecordOutBean.getSyousaimsgcd());
        assertEquals("必須入力チェックエラー：業務キー", createProcessRecordOutBean.getSyousaimsg());

    }

    @Test
    @TestOrder(4)
    public void testValidationNG04() {
        CreateProcessRecordInBean createProcessRecordInBean = new CreateProcessRecordInBean();
        createProcessRecordInBean.setGyoumukey("GKID000000000000006");
        createProcessRecordInBean.setFlowid(null);
        createProcessRecordInBean.setAccountid("Tt");
        createProcessRecordInBean.setRirekimsg("履歴メッセージ");
        createProcessRecordInBean.setTaskname("タスク名");

        List<Map<String, String>> extinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> extinfoMap = new HashMap<String, String>();
        extinfoMap.put("extinfo", "付加情報");
        extinfoMapList.add(extinfoMap);
        createProcessRecordInBean.setExtInfo(extinfoMapList);
        CreateProcessRecordOutBean createProcessRecordOutBean = iwfKouteiClient
            .execCcreateProcessRecord(createProcessRecordInBean);

        assertEquals(C_ResultCdKbn.NG.toString(), createProcessRecordOutBean.getKekkastatus());
        assertEquals("IWF0002", createProcessRecordOutBean.getSyousaimsgcd());
        assertEquals("必須入力チェックエラー：フローＩＤ", createProcessRecordOutBean.getSyousaimsg());

    }

    @Test
    @TestOrder(5)
    public void testValidationNG05() {

        CreateProcessRecordInBean createProcessRecordInBean = new CreateProcessRecordInBean();
        createProcessRecordInBean.setGyoumukey("GKID000000000000006");
        createProcessRecordInBean.setFlowid("");
        createProcessRecordInBean.setAccountid("Tt");
        createProcessRecordInBean.setRirekimsg("履歴メッセージ");
        createProcessRecordInBean.setTaskname("タスク名");

        List<Map<String, String>> extinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> extinfoMap = new HashMap<String, String>();
        extinfoMap.put("extinfo", "付加情報");
        extinfoMapList.add(extinfoMap);
        createProcessRecordInBean.setExtInfo(extinfoMapList);
        CreateProcessRecordOutBean createProcessRecordOutBean = iwfKouteiClient
            .execCcreateProcessRecord(createProcessRecordInBean);

        assertEquals(C_ResultCdKbn.NG.toString(), createProcessRecordOutBean.getKekkastatus());
        assertEquals("IWF0002", createProcessRecordOutBean.getSyousaimsgcd());
        assertEquals("必須入力チェックエラー：フローＩＤ", createProcessRecordOutBean.getSyousaimsg());

    }

    @Test
    @TestOrder(6)
    public void testValidationNG06() {

        CreateProcessRecordInBean createProcessRecordInBean = new CreateProcessRecordInBean();
        createProcessRecordInBean.setGyoumukey("GKID000000000000006");
        createProcessRecordInBean.setFlowid("09");
        createProcessRecordInBean.setAccountid(null);
        createProcessRecordInBean.setRirekimsg("履歴メッセージ");
        createProcessRecordInBean.setTaskname("タスク名");

        List<Map<String, String>> extinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> extinfoMap = new HashMap<String, String>();
        extinfoMap.put("extinfo", "付加情報");
        extinfoMapList.add(extinfoMap);
        createProcessRecordInBean.setExtInfo(extinfoMapList);
        CreateProcessRecordOutBean createProcessRecordOutBean = iwfKouteiClient
            .execCcreateProcessRecord(createProcessRecordInBean);

        assertEquals(C_ResultCdKbn.NG.toString(),createProcessRecordOutBean.getKekkastatus());
        assertEquals("IWF0002", createProcessRecordOutBean.getSyousaimsgcd());
        assertEquals("必須入力チェックエラー：アカウントＩＤ", createProcessRecordOutBean.getSyousaimsg());

    }

    @Test
    @TestOrder(7)
    public void testValidationNG07() {

        CreateProcessRecordInBean createProcessRecordInBean = new CreateProcessRecordInBean();
        createProcessRecordInBean.setGyoumukey("GKID000000000000006");
        createProcessRecordInBean.setFlowid("09");
        createProcessRecordInBean.setAccountid("");
        createProcessRecordInBean.setRirekimsg("履歴メッセージ");
        createProcessRecordInBean.setTaskname("タスク名");

        List<Map<String, String>> extinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> extinfoMap = new HashMap<String, String>();
        extinfoMap.put("extinfo", "付加情報");
        extinfoMapList.add(extinfoMap);
        createProcessRecordInBean.setExtInfo(extinfoMapList);
        CreateProcessRecordOutBean createProcessRecordOutBean = iwfKouteiClient
            .execCcreateProcessRecord(createProcessRecordInBean);

        assertEquals(C_ResultCdKbn.NG.toString(), createProcessRecordOutBean.getKekkastatus());
        assertEquals("IWF0002", createProcessRecordOutBean.getSyousaimsgcd());
        assertEquals("必須入力チェックエラー：アカウントＩＤ", createProcessRecordOutBean.getSyousaimsg());

    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(8)
    public void testValidationOK01() throws Exception {
        String gyoumukey = BizDate.getSysDateTimeMilli();
        String psFlowid = "tt4";
        String psAccountid = "JUnit";
        String psTaskname = "data-input1";
        String lockKey = BizDate.getSysDateTimeMilli();
        String psExtinfo = "付加情報";
        String rirekimsg = null;
        IwfCoreConfig.getInstance().setLockYouhi(false);
        IwfCoreConfig.getInstance().setLockValidTime(1000);

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setGyoumukey(gyoumukey);
        befProcessCreateInBean.setFlowid(psFlowid);
        befProcessCreateInBean.setAccountid(psAccountid);
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient
            .execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(
            befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        CreateProcessRecordInBean createProcessRecordInBean = new CreateProcessRecordInBean();
        createProcessRecordInBean.setGyoumukey(gyoumukey);
        createProcessRecordInBean.setFlowid(psFlowid);
        createProcessRecordInBean.setAccountid(psAccountid);
        createProcessRecordInBean.setRirekimsg(rirekimsg);
        createProcessRecordInBean.setTaskname(psTaskname);

        List<Map<String, String>> extinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> extinfoMap = new HashMap<String, String>();
        extinfoMap.put("extinfo", psExtinfo);
        extinfoMapList.add(extinfoMap);
        createProcessRecordInBean.setExtInfo(extinfoMapList);
        CreateProcessRecordOutBean createProcessRecordOutBean = iwfKouteiClient
            .execCcreateProcessRecord(createProcessRecordInBean);

        assertEquals(C_ResultCdKbn.OK.toString() , createProcessRecordOutBean.getKekkastatus());
        assertEquals("IWF0000", createProcessRecordOutBean.getSyousaimsgcd());
        assertEquals("工程履歴作成正常終了しました。" , createProcessRecordOutBean.getSyousaimsg());

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey(gyoumukey);
        aftProcessCancelInBean.setFlowid(psFlowid);
        aftProcessCancelInBean.setAccountid(psAccountid);
        aftProcessCancelInBean.setLockkey(lockKey);
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient
            .execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(
            aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(9)
    public void testValidationOK02() throws Exception {
        String gyoumukey = BizDate.getSysDateTimeMilli();
        String psFlowid = "tt4";
        String psAccountid = "JUnit";
        String psTaskname = "data-input1";
        String lockKey = BizDate.getSysDateTimeMilli();
        String psExtinfo = "付加情報";
        String rirekimsg = "";
        IwfCoreConfig.getInstance().setLockYouhi(false);
        IwfCoreConfig.getInstance().setLockValidTime(1000);

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setGyoumukey(gyoumukey);
        befProcessCreateInBean.setFlowid(psFlowid);
        befProcessCreateInBean.setAccountid(psAccountid);
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient
            .execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(
            befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        CreateProcessRecordInBean createProcessRecordInBean = new CreateProcessRecordInBean();
        createProcessRecordInBean.setGyoumukey(gyoumukey);
        createProcessRecordInBean.setFlowid(psFlowid);
        createProcessRecordInBean.setAccountid(psAccountid);
        createProcessRecordInBean.setRirekimsg(rirekimsg);
        createProcessRecordInBean.setTaskname(psTaskname);

        List<Map<String, String>> extinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> extinfoMap = new HashMap<String, String>();
        extinfoMap.put("extinfo", psExtinfo);
        extinfoMapList.add(extinfoMap);
        createProcessRecordInBean.setExtInfo(extinfoMapList);
        CreateProcessRecordOutBean createProcessRecordOutBean = iwfKouteiClient
            .execCcreateProcessRecord(createProcessRecordInBean);

        assertEquals(C_ResultCdKbn.OK.toString() , createProcessRecordOutBean.getKekkastatus());
        assertEquals("IWF0000", createProcessRecordOutBean.getSyousaimsgcd());
        assertEquals("工程履歴作成正常終了しました。" , createProcessRecordOutBean.getSyousaimsg());

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey(gyoumukey);
        aftProcessCancelInBean.setFlowid(psFlowid);
        aftProcessCancelInBean.setAccountid(psAccountid);
        aftProcessCancelInBean.setLockkey(lockKey);

        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient
            .execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(
            aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(10)
    public void testValidationOK03() throws Exception {
        String gyoumukey = BizDate.getSysDateTimeMilli();
        String psFlowid = "tt4";
        String psAccountid = "JUnit";
        String psTaskname = null;
        String lockKey = BizDate.getSysDateTimeMilli();
        String psExtinfo = "付加情報";
        String rirekimsg = "履歴メッセージ";
        IwfCoreConfig.getInstance().setLockYouhi(false);
        IwfCoreConfig.getInstance().setLockValidTime(1000);

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setGyoumukey(gyoumukey);
        befProcessCreateInBean.setFlowid(psFlowid);
        befProcessCreateInBean.setAccountid(psAccountid);
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient
            .execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(
            befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        CreateProcessRecordInBean createProcessRecordInBean = new CreateProcessRecordInBean();
        createProcessRecordInBean.setGyoumukey(gyoumukey);
        createProcessRecordInBean.setFlowid(psFlowid);
        createProcessRecordInBean.setAccountid(psAccountid);
        createProcessRecordInBean.setRirekimsg(rirekimsg);
        createProcessRecordInBean.setTaskname(psTaskname);
        List<Map<String, String>> extinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> extinfoMap = new HashMap<String, String>();
        extinfoMap.put("extinfo", psExtinfo);
        extinfoMapList.add(extinfoMap);
        createProcessRecordInBean.setExtInfo(extinfoMapList);
        CreateProcessRecordOutBean createProcessRecordOutBean = iwfKouteiClient
            .execCcreateProcessRecord(createProcessRecordInBean);

        assertEquals(C_ResultCdKbn.OK.toString(),createProcessRecordOutBean.getKekkastatus());
        assertEquals("IWF0000", createProcessRecordOutBean.getSyousaimsgcd());
        assertEquals("工程履歴作成正常終了しました。", createProcessRecordOutBean.getSyousaimsg());

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey(gyoumukey);
        aftProcessCancelInBean.setFlowid(psFlowid);
        aftProcessCancelInBean.setAccountid(psAccountid);
        aftProcessCancelInBean.setLockkey(lockKey);
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient
            .execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(
            aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(11)
    public void testValidationOK04() throws Exception {
        String gyoumukey = BizDate.getSysDateTimeMilli();
        String psFlowid = "tt4";
        String psAccountid = "JUnit";
        String psTaskname = "";
        String lockKey = BizDate.getSysDateTimeMilli();
        String psExtinfo = "付加情報";
        String rirekimsg = "履歴メッセージ";
        IwfCoreConfig.getInstance().setLockYouhi(false);
        IwfCoreConfig.getInstance().setLockValidTime(1000);

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setGyoumukey(gyoumukey);
        befProcessCreateInBean.setFlowid(psFlowid);
        befProcessCreateInBean.setAccountid(psAccountid);
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient
            .execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(
            befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        CreateProcessRecordInBean createProcessRecordInBean = new CreateProcessRecordInBean();
        createProcessRecordInBean.setGyoumukey(gyoumukey);
        createProcessRecordInBean.setFlowid(psFlowid);
        createProcessRecordInBean.setAccountid(psAccountid);
        createProcessRecordInBean.setRirekimsg(rirekimsg);
        createProcessRecordInBean.setTaskname(psTaskname);
        List<Map<String, String>> extinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> extinfoMap = new HashMap<String, String>();
        extinfoMap.put("extinfo", psExtinfo);
        extinfoMapList.add(extinfoMap);
        createProcessRecordInBean.setExtInfo(extinfoMapList);
        CreateProcessRecordOutBean createProcessRecordOutBean = iwfKouteiClient
            .execCcreateProcessRecord(createProcessRecordInBean);

        assertEquals(C_ResultCdKbn.OK.toString(),createProcessRecordOutBean.getKekkastatus());
        assertEquals("IWF0000", createProcessRecordOutBean.getSyousaimsgcd());
        assertEquals("工程履歴作成正常終了しました。" , createProcessRecordOutBean.getSyousaimsg());

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey(gyoumukey);
        aftProcessCancelInBean.setFlowid(psFlowid);
        aftProcessCancelInBean.setAccountid(psAccountid);
        aftProcessCancelInBean.setLockkey(lockKey);
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient
            .execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(
            aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(12)
    public void testValidationOK05() throws Exception {
        String gyoumukey = BizDate.getSysDateTimeMilli();
        String psFlowid = "tt4";
        String psAccountid = "JUnit";
        String psTaskname = "タスク名";
        String lockKey = BizDate.getSysDateTimeMilli();
        String rirekimsg = "履歴メッセージ";
        IwfCoreConfig.getInstance().setLockYouhi(false);
        IwfCoreConfig.getInstance().setLockValidTime(1000);

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setGyoumukey(gyoumukey);
        befProcessCreateInBean.setFlowid(psFlowid);
        befProcessCreateInBean.setAccountid(psAccountid);

        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient
            .execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(
            befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        CreateProcessRecordInBean createProcessRecordInBean = new CreateProcessRecordInBean();
        createProcessRecordInBean.setGyoumukey(gyoumukey);
        createProcessRecordInBean.setFlowid(psFlowid);
        createProcessRecordInBean.setAccountid(psAccountid);
        createProcessRecordInBean.setRirekimsg(rirekimsg);
        createProcessRecordInBean.setTaskname(psTaskname);
        createProcessRecordInBean.setExtInfo(null);
        CreateProcessRecordOutBean createProcessRecordOutBean = iwfKouteiClient
            .execCcreateProcessRecord(createProcessRecordInBean);

        assertEquals(C_ResultCdKbn.OK.toString(),createProcessRecordOutBean.getKekkastatus());
        assertEquals("IWF0000", createProcessRecordOutBean.getSyousaimsgcd());
        assertEquals("工程履歴作成正常終了しました。", createProcessRecordOutBean.getSyousaimsg());

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setFlowid(psFlowid);
        aftProcessCancelInBean.setGyoumukey(gyoumukey);
        aftProcessCancelInBean.setAccountid(psAccountid);
        aftProcessCancelInBean.setLockkey(lockKey);
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient
            .execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(
            aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(13)
    public void testValidationOK06() throws Exception {
        String gyoumukey = BizDate.getSysDateTimeMilli();
        String psFlowid = "tt4";
        String psAccountid = "JUnit";
        String psTaskname = "タスク名";
        String lockKey = BizDate.getSysDateTimeMilli();
        String psExtinfo = "";
        String rirekimsg = "履歴メッセージ";
        IwfCoreConfig.getInstance().setLockYouhi(false);
        IwfCoreConfig.getInstance().setLockValidTime(1000);

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setGyoumukey(gyoumukey);
        befProcessCreateInBean.setFlowid(psFlowid);
        befProcessCreateInBean.setAccountid(psAccountid);
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient
            .execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(
            befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        CreateProcessRecordInBean createProcessRecordInBean = new CreateProcessRecordInBean();
        createProcessRecordInBean.setGyoumukey(gyoumukey);
        createProcessRecordInBean.setFlowid(psFlowid);
        createProcessRecordInBean.setAccountid(psAccountid);
        createProcessRecordInBean.setTaskname(psTaskname);
        createProcessRecordInBean.setRirekimsg(rirekimsg);
        List<Map<String, String>> extinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> extinfoMap = new HashMap<String, String>();
        extinfoMap.put("extinfo", psExtinfo);
        extinfoMapList.add(extinfoMap);
        createProcessRecordInBean.setExtInfo(extinfoMapList);
        CreateProcessRecordOutBean createProcessRecordOutBean = iwfKouteiClient
            .execCcreateProcessRecord(createProcessRecordInBean);

        assertEquals(C_ResultCdKbn.OK.toString(),createProcessRecordOutBean.getKekkastatus());
        assertEquals("IWF0000", createProcessRecordOutBean.getSyousaimsgcd());
        assertEquals("工程履歴作成正常終了しました。", createProcessRecordOutBean.getSyousaimsg());

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey(gyoumukey);
        aftProcessCancelInBean.setFlowid(psFlowid);
        aftProcessCancelInBean.setAccountid(psAccountid);
        aftProcessCancelInBean.setLockkey(lockKey);

        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient
            .execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(
            aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(14)
    public void testKyoukaiOK01() throws Exception {
        String gyoumukey = bj2qj(BizDate.getSysDateTimeMilli()+"12");
        String psFlowid = "tt4";
        String psAccountid = "JUnit";
        String psTaskname = "タスク名";
        String lockKey = BizDate.getSysDateTimeMilli();
        String psExtinfo = "付加情報";
        String rirekimsg = "履歴メッセージ";
        IwfCoreConfig.getInstance().setLockYouhi(false);
        IwfCoreConfig.getInstance().setLockValidTime(1000);

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setFlowid(psFlowid);
        befProcessCreateInBean
        .setGyoumukey(gyoumukey);
        befProcessCreateInBean.setAccountid(psAccountid);
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient
            .execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(
            befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        CreateProcessRecordInBean createProcessRecordInBean = new CreateProcessRecordInBean();
        createProcessRecordInBean
        .setGyoumukey(gyoumukey);
        createProcessRecordInBean.setFlowid(psFlowid);
        createProcessRecordInBean.setAccountid(psAccountid);
        createProcessRecordInBean.setRirekimsg(rirekimsg);
        createProcessRecordInBean.setTaskname(psTaskname);
        List<Map<String, String>> extinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> extinfoMap = new HashMap<String, String>();
        extinfoMap.put("extinfo", psExtinfo);
        extinfoMapList.add(extinfoMap);
        createProcessRecordInBean.setExtInfo(extinfoMapList);
        CreateProcessRecordOutBean createProcessRecordOutBean = iwfKouteiClient
            .execCcreateProcessRecord(createProcessRecordInBean);

        assertEquals(C_ResultCdKbn.OK.toString(),createProcessRecordOutBean.getKekkastatus());
        assertEquals("IWF0000", createProcessRecordOutBean.getSyousaimsgcd());
        assertEquals("工程履歴作成正常終了しました。", createProcessRecordOutBean.getSyousaimsg());

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setFlowid(psFlowid);
        aftProcessCancelInBean
        .setGyoumukey(gyoumukey);
        aftProcessCancelInBean.setAccountid(psAccountid);
        aftProcessCancelInBean.setLockkey(lockKey);
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient
            .execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(
            aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(15)
    public void testKyoukaiOK02() throws Exception {
        String gyoumukey = bj2qj(BizDate.getSysDateTimeMilli()+"123");
        String psFlowid = "tt4";
        String psAccountid = "JUnit";
        String psTaskname = "タスク名";
        String lockKey = BizDate.getSysDateTimeMilli();
        String psExtinfo = "付加情報";
        String rirekimsg = "履歴メッセージ";
        IwfCoreConfig.getInstance().setLockYouhi(false);
        IwfCoreConfig.getInstance().setLockValidTime(1000);

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setGyoumukey(gyoumukey);
        befProcessCreateInBean.setFlowid(psFlowid);
        befProcessCreateInBean.setAccountid(psAccountid);
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient
            .execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(
            befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        CreateProcessRecordInBean createProcessRecordInBean = new CreateProcessRecordInBean();
        createProcessRecordInBean.setGyoumukey(gyoumukey);
        createProcessRecordInBean.setFlowid(psFlowid);
        createProcessRecordInBean.setAccountid(psAccountid);
        createProcessRecordInBean.setRirekimsg(rirekimsg);
        createProcessRecordInBean.setTaskname(psTaskname);

        List<Map<String, String>> extinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> extinfoMap = new HashMap<String, String>();
        extinfoMap.put("extinfo", psExtinfo);
        extinfoMapList.add(extinfoMap);
        createProcessRecordInBean.setExtInfo(extinfoMapList);
        CreateProcessRecordOutBean createProcessRecordOutBean = iwfKouteiClient
            .execCcreateProcessRecord(createProcessRecordInBean);

        assertEquals(C_ResultCdKbn.OK.toString(),  createProcessRecordOutBean.getKekkastatus());
        assertEquals("IWF0000", createProcessRecordOutBean.getSyousaimsgcd());
        assertEquals("工程履歴作成正常終了しました。",  createProcessRecordOutBean.getSyousaimsg());

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey(gyoumukey);
        aftProcessCancelInBean.setFlowid(psFlowid);
        aftProcessCancelInBean.setAccountid(psAccountid);
        aftProcessCancelInBean.setLockkey(lockKey);

        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient
            .execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(
            aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }
    }

    @Test
    @TestOrder(16)
    public void testKyoukaiNG01() {

        CreateProcessRecordInBean createProcessRecordInBean = new CreateProcessRecordInBean();
        createProcessRecordInBean
        .setGyoumukey("業務キー業務キー業務キー業務キー業務キーキ");
        createProcessRecordInBean.setFlowid("09");
        createProcessRecordInBean.setAccountid("Tt");
        createProcessRecordInBean.setRirekimsg("履歴メッセージ");
        createProcessRecordInBean.setTaskname("タスク名");

        List<Map<String, String>> extinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> extinfoMap = new HashMap<String, String>();
        extinfoMap.put("extinfo", "付加情報");
        extinfoMapList.add(extinfoMap);
        createProcessRecordInBean.setExtInfo(extinfoMapList);
        CreateProcessRecordOutBean createProcessRecordOutBean = iwfKouteiClient
            .execCcreateProcessRecord(createProcessRecordInBean);

        assertEquals(C_ResultCdKbn.NG.toString(), createProcessRecordOutBean.getKekkastatus());
        assertEquals("IWF0008", createProcessRecordOutBean.getSyousaimsgcd());
        assertEquals("業務キーは20文字以内で入力してください。", createProcessRecordOutBean.getSyousaimsg());

    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(17)
    public void testKyoukaiOK03() throws Exception {
        String gyoumukey = BizDate.getSysDateTimeMilli()+"業務キ";
        String psFlowid = "tt4";
        String psAccountid = "JUnit";
        String psTaskname = "data-input1";
        String lockKey = BizDate.getSysDateTimeMilli();
        String psExtinfo = "付加情報";
        String rirekimsg = "履歴メッセージ";

        IwfCoreConfig.getInstance().setLockYouhi(false);
        IwfCoreConfig.getInstance().setLockValidTime(1000);

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setFlowid(psFlowid);
        befProcessCreateInBean.setGyoumukey(gyoumukey);
        befProcessCreateInBean.setAccountid(psAccountid);
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient
            .execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        CreateProcessRecordInBean createProcessRecordInBean = new CreateProcessRecordInBean();
        createProcessRecordInBean.setGyoumukey(gyoumukey);
        createProcessRecordInBean.setFlowid(psFlowid);
        createProcessRecordInBean.setAccountid(psAccountid);
        createProcessRecordInBean.setRirekimsg(rirekimsg);
        createProcessRecordInBean.setTaskname(psTaskname);
        List<Map<String, String>> extinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> extinfoMap = new HashMap<String, String>();
        extinfoMap.put("extinfo", psExtinfo);
        extinfoMapList.add(extinfoMap);
        createProcessRecordInBean.setExtInfo(extinfoMapList);
        CreateProcessRecordOutBean createProcessRecordOutBean = iwfKouteiClient
            .execCcreateProcessRecord(createProcessRecordInBean);

        assertEquals(C_ResultCdKbn.OK.toString(),
            createProcessRecordOutBean.getKekkastatus());
        assertEquals("IWF0000", createProcessRecordOutBean.getSyousaimsgcd());
        assertEquals("工程履歴作成正常終了しました。",
            createProcessRecordOutBean.getSyousaimsg());

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey(gyoumukey);
        aftProcessCancelInBean.setFlowid(psFlowid);
        aftProcessCancelInBean.setAccountid(psAccountid);
        aftProcessCancelInBean.setLockkey(lockKey);
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient
            .execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(
            aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }
    }

    @Test
    @TestOrder(18)
    public void testKyoukaiOK04() throws Exception {
        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setFlowid("フローＩＤフローＩＤフローＩＤフロー");
        befProcessCreateInBean.setGyoumukey("GKID000000000000006");
        befProcessCreateInBean.setAccountid("Tt");
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient
            .execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(
            befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        CreateProcessRecordInBean createProcessRecordInBean = new CreateProcessRecordInBean();
        createProcessRecordInBean.setGyoumukey("GKID000000000000006");
        createProcessRecordInBean.setFlowid("フローＩＤフローＩＤフローＩＤフロー");
        createProcessRecordInBean.setAccountid("Tt");
        createProcessRecordInBean.setRirekimsg("履歴メッセージ");
        createProcessRecordInBean.setTaskname("タスク名");
        List<Map<String, String>> extinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> extinfoMap = new HashMap<String, String>();
        extinfoMap.put("extinfo", "付加情報");
        extinfoMapList.add(extinfoMap);
        createProcessRecordInBean.setExtInfo(extinfoMapList);
        CreateProcessRecordOutBean createProcessRecordOutBean = iwfKouteiClient
            .execCcreateProcessRecord(createProcessRecordInBean);

        assertEquals(C_ResultCdKbn.OK.toString(),
            createProcessRecordOutBean.getKekkastatus());
        assertEquals("IWF0000", createProcessRecordOutBean.getSyousaimsgcd());
        assertEquals("工程履歴作成正常終了しました。",
            createProcessRecordOutBean.getSyousaimsg());

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setFlowid("フローＩＤフローＩＤフローＩＤフロー");
        aftProcessCancelInBean.setGyoumukey("GKID000000000000006");
        aftProcessCancelInBean.setAccountid("Tt");
        aftProcessCancelInBean.setLockkey("l1");
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient
            .execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(
            aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }
    }

    @Test
    @TestOrder(19)
    public void testKyoukaiOK05() throws Exception {
        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setFlowid("フローＩＤフローＩＤフローＩＤフローＩ");
        befProcessCreateInBean.setGyoumukey("GKID000000000000006");
        befProcessCreateInBean.setAccountid("Tt");
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient
            .execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(
            befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        CreateProcessRecordInBean createProcessRecordInBean = new CreateProcessRecordInBean();
        createProcessRecordInBean.setGyoumukey("GKID000000000000006");
        createProcessRecordInBean.setFlowid("フローＩＤフローＩＤフローＩＤフローＩ");
        createProcessRecordInBean.setAccountid("Tt");
        createProcessRecordInBean.setRirekimsg("履歴メッセージ");
        createProcessRecordInBean.setTaskname("タスク名");
        List<Map<String, String>> extinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> extinfoMap = new HashMap<String, String>();
        extinfoMap.put("extinfo", "付加情報");
        extinfoMapList.add(extinfoMap);
        createProcessRecordInBean.setExtInfo(extinfoMapList);
        CreateProcessRecordOutBean createProcessRecordOutBean = iwfKouteiClient
            .execCcreateProcessRecord(createProcessRecordInBean);

        assertEquals(C_ResultCdKbn.OK.toString(),createProcessRecordOutBean.getKekkastatus());
        assertEquals("IWF0000", createProcessRecordOutBean.getSyousaimsgcd());
        assertEquals("工程履歴作成正常終了しました。", createProcessRecordOutBean.getSyousaimsg());

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setFlowid("フローＩＤフローＩＤフローＩＤフローＩ");
        aftProcessCancelInBean.setGyoumukey("GKID000000000000006");
        aftProcessCancelInBean.setAccountid("Tt");
        aftProcessCancelInBean.setLockkey("l1");
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient
            .execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(
            aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }
    }

    @Test
    @TestOrder(20)
    public void testKyoukaiNG02() {
        CreateProcessRecordInBean createProcessRecordInBean = new CreateProcessRecordInBean();
        createProcessRecordInBean.setGyoumukey("GKID000000000000006");
        createProcessRecordInBean.setFlowid("フローＩＤフローＩＤフローＩＤフローＩＤ");
        createProcessRecordInBean.setAccountid("Tt");
        createProcessRecordInBean.setRirekimsg("履歴メッセージ");
        createProcessRecordInBean.setTaskname("タスク名");
        List<Map<String, String>> extinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> extinfoMap = new HashMap<String, String>();
        extinfoMap.put("extinfo", "付加情報");
        extinfoMapList.add(extinfoMap);
        createProcessRecordInBean.setExtInfo(extinfoMapList);
        CreateProcessRecordOutBean createProcessRecordOutBean = iwfKouteiClient
            .execCcreateProcessRecord(createProcessRecordInBean);

        assertEquals(C_ResultCdKbn.NG.toString(),createProcessRecordOutBean.getKekkastatus());
        assertEquals("IWF0008",createProcessRecordOutBean.getSyousaimsgcd());
        assertEquals("フローＩＤは19文字以内で入力してください。",createProcessRecordOutBean.getSyousaimsg());
    }

    @Test
    @TestOrder(21)
    public void testKyoukaiOK06() throws Exception {
        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setFlowid("フローＩＤ0001");
        befProcessCreateInBean.setGyoumukey("GKID000000000000006");
        befProcessCreateInBean.setAccountid("Tt");
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient
            .execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(
            befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        CreateProcessRecordInBean createProcessRecordInBean = new CreateProcessRecordInBean();
        createProcessRecordInBean.setGyoumukey("GKID000000000000006");
        createProcessRecordInBean.setFlowid("フローＩＤ0001");
        createProcessRecordInBean.setAccountid("Tt");
        createProcessRecordInBean.setRirekimsg("履歴メッセージ");
        createProcessRecordInBean.setTaskname("タスク名");
        List<Map<String, String>> extinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> extinfoMap = new HashMap<String, String>();
        extinfoMap.put("extinfo", "付加情報");
        extinfoMapList.add(extinfoMap);
        createProcessRecordInBean.setExtInfo(extinfoMapList);
        CreateProcessRecordOutBean createProcessRecordOutBean = iwfKouteiClient
            .execCcreateProcessRecord(createProcessRecordInBean);

        assertEquals(C_ResultCdKbn.OK.toString(), createProcessRecordOutBean.getKekkastatus());
        assertEquals("IWF0000", createProcessRecordOutBean.getSyousaimsgcd());
        assertEquals("工程履歴作成正常終了しました。", createProcessRecordOutBean.getSyousaimsg());

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setFlowid("フローＩＤ0001");
        aftProcessCancelInBean.setGyoumukey("GKID000000000000006");
        aftProcessCancelInBean.setAccountid("Tt");
        aftProcessCancelInBean.setLockkey("l1");
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient
            .execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(
            aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(22)
    public void testKyoukaiOK07() throws Exception {
        String psGyoumukey = BizDate.getSysDateTimeMilli();
        String psFlowid = "tt4";
        String psAccountid = "JUnit";
        String psLockkey = BizDate.getSysDateTimeMilli();
        String psTaskname = "data-input1";
        String psExtinfo = "付加情報";
        String rirekimsg = "履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッ";
        IwfCoreConfig.getInstance().setLockYouhi(false);
        IwfCoreConfig.getInstance().setLockValidTime(1000);

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setGyoumukey(psGyoumukey);
        befProcessCreateInBean.setFlowid(psFlowid);
        befProcessCreateInBean.setAccountid(psAccountid);
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient
            .execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(
            befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        CreateProcessRecordInBean createProcessRecordInBean = new CreateProcessRecordInBean();
        createProcessRecordInBean.setGyoumukey(psGyoumukey);
        createProcessRecordInBean.setFlowid(psFlowid);
        createProcessRecordInBean.setAccountid(psAccountid);
        createProcessRecordInBean
        .setRirekimsg(rirekimsg);
        createProcessRecordInBean.setTaskname(psTaskname);
        List<Map<String, String>> extinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> extinfoMap = new HashMap<String, String>();
        extinfoMap.put("extinfo", psExtinfo);
        extinfoMapList.add(extinfoMap);
        createProcessRecordInBean.setExtInfo(extinfoMapList);
        CreateProcessRecordOutBean createProcessRecordOutBean = iwfKouteiClient
            .execCcreateProcessRecord(createProcessRecordInBean);

        assertEquals(C_ResultCdKbn.OK.toString(), createProcessRecordOutBean.getKekkastatus());
        assertEquals("IWF0000", createProcessRecordOutBean.getSyousaimsgcd());
        assertEquals("工程履歴作成正常終了しました。", createProcessRecordOutBean.getSyousaimsg());

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey(psGyoumukey);
        aftProcessCancelInBean.setFlowid(psFlowid);
        aftProcessCancelInBean.setAccountid(psAccountid);
        aftProcessCancelInBean.setLockkey(psLockkey);
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient
            .execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(
            aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(23)
    public void testKyoukaiOK08() throws Exception {

        String psGyoumukey = BizDate.getSysDateTimeMilli();
        String psFlowid = "tt4";
        String psAccountid = "JUnit";
        String psLockkey = BizDate.getSysDateTimeMilli();
        String psTaskname = "data-input1";
        String psExtinfo = "付加情報";
        String rirekimsg = "履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセ";
        IwfCoreConfig.getInstance().setLockYouhi(false);
        IwfCoreConfig.getInstance().setLockValidTime(1000);

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setGyoumukey(psGyoumukey);
        befProcessCreateInBean.setFlowid(psFlowid);
        befProcessCreateInBean.setAccountid(psAccountid);
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient
            .execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(
            befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        CreateProcessRecordInBean createProcessRecordInBean = new CreateProcessRecordInBean();
        createProcessRecordInBean.setGyoumukey(psGyoumukey);
        createProcessRecordInBean.setFlowid(psFlowid);
        createProcessRecordInBean.setAccountid(psAccountid);
        createProcessRecordInBean
        .setRirekimsg(rirekimsg);
        createProcessRecordInBean.setTaskname(psTaskname);
        List<Map<String, String>> extinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> extinfoMap = new HashMap<String, String>();
        extinfoMap.put("extinfo", psExtinfo);
        extinfoMapList.add(extinfoMap);
        createProcessRecordInBean.setExtInfo(extinfoMapList);
        CreateProcessRecordOutBean createProcessRecordOutBean = iwfKouteiClient
            .execCcreateProcessRecord(createProcessRecordInBean);

        assertEquals(C_ResultCdKbn.OK.toString(), createProcessRecordOutBean.getKekkastatus());
        assertEquals("IWF0000", createProcessRecordOutBean.getSyousaimsgcd());
        assertEquals("工程履歴作成正常終了しました。", createProcessRecordOutBean.getSyousaimsg());

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey(psGyoumukey);
        aftProcessCancelInBean.setFlowid(psFlowid);
        aftProcessCancelInBean.setAccountid(psAccountid);
        aftProcessCancelInBean.setLockkey(psLockkey);
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient
            .execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(
            aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(24)
    public void testKyoukaiNG03() {

        String psGyoumukey = BizDate.getSysDateTimeMilli();
        String psFlowid = "tt4";
        String psAccountid = "JUnit";
        String psTaskname = "data-input1";
        String psExtinfo = "付加情報";
        String rirekimsg = "履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセージ履歴メッセー";
        IwfCoreConfig.getInstance().setLockYouhi(false);
        IwfCoreConfig.getInstance().setLockValidTime(1000);

        CreateProcessRecordInBean createProcessRecordInBean = new CreateProcessRecordInBean();
        createProcessRecordInBean.setGyoumukey(psGyoumukey);
        createProcessRecordInBean.setFlowid(psFlowid);
        createProcessRecordInBean.setAccountid(psAccountid);
        createProcessRecordInBean.setRirekimsg(rirekimsg);
        createProcessRecordInBean.setTaskname(psTaskname);

        List<Map<String, String>> extinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> extinfoMap = new HashMap<String, String>();
        extinfoMap.put("extinfo", psExtinfo);
        extinfoMapList.add(extinfoMap);
        createProcessRecordInBean.setExtInfo(extinfoMapList);
        CreateProcessRecordOutBean createProcessRecordOutBean = iwfKouteiClient
            .execCcreateProcessRecord(createProcessRecordInBean);

        assertEquals(C_ResultCdKbn.NG.toString(),createProcessRecordOutBean.getKekkastatus());
        assertEquals("IWF0008", createProcessRecordOutBean.getSyousaimsgcd());
        assertEquals("履歴メッセージは2000文字以内で入力してください。", createProcessRecordOutBean.getSyousaimsg());

    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(25)
    public void testKyoukaiOK09() throws Exception {

        String psGyoumukey = BizDate.getSysDateTimeMilli();
        String psFlowid = "tt4";
        String psAccountid = "JUnit";
        String psTaskname = "data-input1";
        String psLockkey = BizDate.getSysDateTimeMilli();
        String psExtinfo = "付加情報";
        String rirekimsg = "履歴メッセージ0001";
        IwfCoreConfig.getInstance().setLockYouhi(false);
        IwfCoreConfig.getInstance().setLockValidTime(1000);


        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setGyoumukey(psGyoumukey);
        befProcessCreateInBean.setFlowid(psFlowid);
        befProcessCreateInBean.setAccountid(psAccountid);
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient
            .execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(
            befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        CreateProcessRecordInBean createProcessRecordInBean = new CreateProcessRecordInBean();
        createProcessRecordInBean.setGyoumukey(psGyoumukey);
        createProcessRecordInBean.setFlowid(psFlowid);
        createProcessRecordInBean.setAccountid(psAccountid);
        createProcessRecordInBean.setRirekimsg(rirekimsg);
        createProcessRecordInBean.setTaskname(psTaskname);
        List<Map<String, String>> extinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> extinfoMap = new HashMap<String, String>();
        extinfoMap.put("extinfo", psExtinfo);
        extinfoMapList.add(extinfoMap);
        createProcessRecordInBean.setExtInfo(extinfoMapList);
        CreateProcessRecordOutBean createProcessRecordOutBean = iwfKouteiClient
            .execCcreateProcessRecord(createProcessRecordInBean);

        assertEquals(C_ResultCdKbn.OK.toString(), createProcessRecordOutBean.getKekkastatus());
        assertEquals("IWF0000", createProcessRecordOutBean.getSyousaimsgcd());
        assertEquals("工程履歴作成正常終了しました。",  createProcessRecordOutBean.getSyousaimsg());

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey(psGyoumukey);
        aftProcessCancelInBean.setFlowid(psFlowid);
        aftProcessCancelInBean.setAccountid(psAccountid);
        aftProcessCancelInBean.setLockkey(psLockkey);
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient
            .execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(
            aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(26)
    public void testKyoukaiOK10() throws Exception {

        String psGyoumukey = BizDate.getSysDateTimeMilli();
        String psFlowid = "tt4";
        String psAccountid = "JUnit";
        String psTaskname = "１２３４５６７８９０１２３４５６７８９０１２３４";
        String psLockkey = BizDate.getSysDateTimeMilli();
        String psExtinfo = "付加情報";
        String rirekimsg = "履歴メッセージ0001";
        IwfCoreConfig.getInstance().setLockYouhi(false);
        IwfCoreConfig.getInstance().setLockValidTime(1000);


        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setGyoumukey(psGyoumukey);
        befProcessCreateInBean.setFlowid(psFlowid);
        befProcessCreateInBean.setAccountid(psAccountid);
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient
            .execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(
            befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        CreateProcessRecordInBean createProcessRecordInBean = new CreateProcessRecordInBean();
        createProcessRecordInBean.setGyoumukey(psGyoumukey);
        createProcessRecordInBean.setFlowid(psFlowid);
        createProcessRecordInBean.setAccountid(psAccountid);
        createProcessRecordInBean.setRirekimsg(rirekimsg);
        createProcessRecordInBean.setTaskname(psTaskname);
        List<Map<String, String>> extinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> extinfoMap = new HashMap<String, String>();
        extinfoMap.put("extinfo", psExtinfo);
        extinfoMapList.add(extinfoMap);
        createProcessRecordInBean.setExtInfo(extinfoMapList);
        CreateProcessRecordOutBean createProcessRecordOutBean = iwfKouteiClient
            .execCcreateProcessRecord(createProcessRecordInBean);

        assertEquals(C_ResultCdKbn.OK.toString(), createProcessRecordOutBean.getKekkastatus());
        assertEquals("IWF0000", createProcessRecordOutBean.getSyousaimsgcd());
        assertEquals("工程履歴作成正常終了しました。", createProcessRecordOutBean.getSyousaimsg());

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();

        aftProcessCancelInBean.setGyoumukey(psGyoumukey);
        aftProcessCancelInBean.setFlowid(psFlowid);
        aftProcessCancelInBean.setAccountid(psAccountid);
        aftProcessCancelInBean.setLockkey(psLockkey);
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient
            .execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(
            aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(27)
    public void testKyoukaiOK11() throws Exception {
        String psGyoumukey = BizDate.getSysDateTimeMilli();
        String psFlowid = "tt4";
        String psAccountid = "JUnit";
        String psTaskname = "１２３４５６７８９０１２３４５６７８９０１２３４５";
        String psLockkey = BizDate.getSysDateTimeMilli();
        String psExtinfo = "付加情報";
        String rirekimsg = "履歴メッセージ0001";
        IwfCoreConfig.getInstance().setLockYouhi(false);
        IwfCoreConfig.getInstance().setLockValidTime(1000);

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setGyoumukey(psGyoumukey);
        befProcessCreateInBean.setFlowid(psFlowid);
        befProcessCreateInBean.setAccountid(psAccountid);
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient
            .execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(
            befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        CreateProcessRecordInBean createProcessRecordInBean = new CreateProcessRecordInBean();
        createProcessRecordInBean.setGyoumukey(psGyoumukey);
        createProcessRecordInBean.setFlowid(psFlowid);
        createProcessRecordInBean.setAccountid(psAccountid);
        createProcessRecordInBean.setRirekimsg(rirekimsg);
        createProcessRecordInBean.setTaskname(psTaskname);

        List<Map<String, String>> extinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> extinfoMap = new HashMap<String, String>();
        extinfoMap.put("extinfo", psExtinfo);
        extinfoMapList.add(extinfoMap);
        createProcessRecordInBean.setExtInfo(extinfoMapList);
        CreateProcessRecordOutBean createProcessRecordOutBean = iwfKouteiClient
            .execCcreateProcessRecord(createProcessRecordInBean);

        assertEquals(C_ResultCdKbn.OK.toString() , createProcessRecordOutBean.getKekkastatus());
        assertEquals("IWF0000" , createProcessRecordOutBean.getSyousaimsgcd());
        assertEquals("工程履歴作成正常終了しました。" , createProcessRecordOutBean.getSyousaimsg());

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey(psGyoumukey);
        aftProcessCancelInBean.setFlowid(psFlowid);
        aftProcessCancelInBean.setAccountid(psAccountid);
        aftProcessCancelInBean.setLockkey(psLockkey);
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(
            aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(28)
    public void testKyoukaiNG04() {
        String psGyoumukey = BizDate.getSysDateTimeMilli();
        String psFlowid = "tt4";
        String psAccountid = "JUnit";
        String psTaskname =  "１２３４５６７８９０１２３４５６７８９０１２３４５６";
        String psExtinfo = "付加情報";
        String rirekimsg = "履歴メッセージ";
        IwfCoreConfig.getInstance().setLockYouhi(false);
        IwfCoreConfig.getInstance().setLockValidTime(1000);

        CreateProcessRecordInBean createProcessRecordInBean = new CreateProcessRecordInBean();
        createProcessRecordInBean.setGyoumukey(psGyoumukey);
        createProcessRecordInBean.setFlowid(psFlowid);
        createProcessRecordInBean.setAccountid(psAccountid);
        createProcessRecordInBean.setRirekimsg(rirekimsg);
        createProcessRecordInBean
        .setTaskname(psTaskname);
        List<Map<String, String>> extinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> extinfoMap = new HashMap<String, String>();
        extinfoMap.put("extinfo", psExtinfo);
        extinfoMapList.add(extinfoMap);
        createProcessRecordInBean.setExtInfo(extinfoMapList);
        CreateProcessRecordOutBean createProcessRecordOutBean = iwfKouteiClient
            .execCcreateProcessRecord(createProcessRecordInBean);

        assertEquals(C_ResultCdKbn.NG.toString() , createProcessRecordOutBean.getKekkastatus());
        assertEquals("IWF0008", createProcessRecordOutBean.getSyousaimsgcd());
        assertEquals("タスク名は25文字以内で入力してください。", createProcessRecordOutBean.getSyousaimsg());

    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(29)
    public void testKyoukaiOK12() throws Exception {
        String psGyoumukey = BizDate.getSysDateTimeMilli();
        String psFlowid = "tt4";
        String psAccountid = "JUnit";
        String psTaskname = "タスク名0001";
        String psLockkey = BizDate.getSysDateTimeMilli();
        String psExtinfo = "付加情報";
        String rirekimsg = "履歴メッセージ";
        IwfCoreConfig.getInstance().setLockYouhi(false);
        IwfCoreConfig.getInstance().setLockValidTime(1000);

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setGyoumukey(psGyoumukey);
        befProcessCreateInBean.setFlowid(psFlowid);
        befProcessCreateInBean.setAccountid(psAccountid);
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient
            .execProcessCreate(befProcessCreateInBean);

        if (!C_ResultCdKbn.OK.toString().equals(
            befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        CreateProcessRecordInBean createProcessRecordInBean = new CreateProcessRecordInBean();
        createProcessRecordInBean.setGyoumukey(psGyoumukey);
        createProcessRecordInBean.setFlowid(psFlowid);
        createProcessRecordInBean.setAccountid(psAccountid);
        createProcessRecordInBean.setRirekimsg(rirekimsg);
        createProcessRecordInBean.setTaskname(psTaskname);

        List<Map<String, String>> extinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> extinfoMap = new HashMap<String, String>();
        extinfoMap.put("extinfo", psExtinfo);
        extinfoMapList.add(extinfoMap);
        createProcessRecordInBean.setExtInfo(extinfoMapList);
        CreateProcessRecordOutBean createProcessRecordOutBean = iwfKouteiClient
            .execCcreateProcessRecord(createProcessRecordInBean);


        assertEquals(C_ResultCdKbn.OK.toString(),createProcessRecordOutBean.getKekkastatus());
        assertEquals("IWF0000", createProcessRecordOutBean.getSyousaimsgcd());
        assertEquals("工程履歴作成正常終了しました。" , createProcessRecordOutBean.getSyousaimsg());

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey(psGyoumukey);
        aftProcessCancelInBean.setFlowid(psFlowid);
        aftProcessCancelInBean.setAccountid(psAccountid);
        aftProcessCancelInBean.setLockkey(psLockkey);
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient
            .execProcessCancel(aftProcessCancelInBean);

        if (!C_ResultCdKbn.OK.toString().equals(
            aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }
    }

    @Test
    @TestOrder(30)
    public void testInfoExistNG01() {
        CreateProcessRecordInBean createProcessRecordInBean = new CreateProcessRecordInBean();
        createProcessRecordInBean.setGyoumukey("GYOUMUKEYERR01");
        createProcessRecordInBean.setFlowid("09");
        createProcessRecordInBean.setAccountid("Tt");
        createProcessRecordInBean.setRirekimsg("履歴メッセージ");
        createProcessRecordInBean.setTaskname("タスク名");
        List<Map<String, String>> extinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> extinfoMap = new HashMap<String, String>();
        extinfoMap.put("extinfo", "付加情報");
        extinfoMapList.add(extinfoMap);
        createProcessRecordInBean.setExtInfo(extinfoMapList);
        CreateProcessRecordOutBean createProcessRecordOutBean = iwfKouteiClient
            .execCcreateProcessRecord(createProcessRecordInBean);


        assertEquals(C_ResultCdKbn.NG.toString(), createProcessRecordOutBean.getKekkastatus());
        assertEquals("IWF2222", createProcessRecordOutBean.getSyousaimsgcd());
        assertEquals("業務キーが取得できませんでした。", createProcessRecordOutBean.getSyousaimsg());

    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(31)
    public void testInfoExistNG02() throws Exception {
        String gyoumukey = BizDate.getSysDateTimeMilli();
        String psFlowid = "testInfoExistNG03";
        String psAccountid = "JUnit";
        String psTaskname = "タスク名";
        String lockKey = BizDate.getSysDateTimeMilli();
        String psExtinfo = "付加情報";
        String rirekimsg = "履歴メッセージ";
        IwfCoreConfig.getInstance().setLockYouhi(false);
        IwfCoreConfig.getInstance().setLockValidTime(1000);

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setGyoumukey(gyoumukey);
        befProcessCreateInBean.setFlowid(psFlowid);
        befProcessCreateInBean.setAccountid(psAccountid);
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient
            .execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(
            befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        CreateProcessRecordInBean createProcessRecordInBean = new CreateProcessRecordInBean();
        createProcessRecordInBean.setGyoumukey(gyoumukey);
        createProcessRecordInBean.setFlowid(psFlowid+"NG");
        createProcessRecordInBean.setAccountid(psAccountid);
        createProcessRecordInBean.setRirekimsg(rirekimsg);
        createProcessRecordInBean.setTaskname(psTaskname);
        List<Map<String, String>> extinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> extinfoMap = new HashMap<String, String>();
        extinfoMap.put("extinfo", psExtinfo);
        extinfoMapList.add(extinfoMap);
        createProcessRecordInBean.setExtInfo(extinfoMapList);
        IwfCoreConfig.getInstance().setLockYouhi(false);
        CreateProcessRecordOutBean createProcessRecordOutBean = iwfKouteiClient
            .execCcreateProcessRecord(createProcessRecordInBean);

        assertEquals(C_ResultCdKbn.NG.toString(), createProcessRecordOutBean.getKekkastatus());
        assertEquals("IWF2221", createProcessRecordOutBean.getSyousaimsgcd());
        assertEquals("プロセス定義が取得できませんでした。", createProcessRecordOutBean.getSyousaimsg());

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey(gyoumukey);
        aftProcessCancelInBean.setFlowid(psFlowid);
        aftProcessCancelInBean.setAccountid(psAccountid);
        aftProcessCancelInBean.setLockkey(lockKey);
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient
            .execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(
            aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(32)
    public void testInfoExistNG03() throws Exception {
        String gyoumukey = BizDate.getSysDateTimeMilli();
        String psFlowid = "tt4";
        String psAccountid = "JUnit";
        String psTaskname = "タスク名";
        String lockKey = BizDate.getSysDateTimeMilli();
        String psExtinfo = "付加情報";
        String rirekimsg = "履歴メッセージ";
        IwfCoreConfig.getInstance().setLockYouhi(false);
        IwfCoreConfig.getInstance().setLockValidTime(1000);

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setGyoumukey(gyoumukey);
        befProcessCreateInBean.setFlowid(psFlowid);
        befProcessCreateInBean.setAccountid(psAccountid);
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient
            .execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(
            befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        CreateProcessRecordInBean createProcessRecordInBean = new CreateProcessRecordInBean();
        createProcessRecordInBean.setGyoumukey(gyoumukey);
        createProcessRecordInBean.setFlowid("09");
        createProcessRecordInBean.setAccountid(psAccountid);
        createProcessRecordInBean.setRirekimsg(rirekimsg);
        createProcessRecordInBean.setTaskname(psTaskname);
        List<Map<String, String>> extinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> extinfoMap = new HashMap<String, String>();
        extinfoMap.put("extinfo",psExtinfo);
        extinfoMapList.add(extinfoMap);
        createProcessRecordInBean.setExtInfo(extinfoMapList);
        IwfCoreConfig.getInstance().setLockYouhi(false);
        CreateProcessRecordOutBean createProcessRecordOutBean = iwfKouteiClient
            .execCcreateProcessRecord(createProcessRecordInBean);


        assertEquals(C_ResultCdKbn.NG.toString(), createProcessRecordOutBean.getKekkastatus());
        assertEquals("IWF2223", createProcessRecordOutBean.getSyousaimsgcd());
        assertEquals("トークンIDが取得できませんでした。", createProcessRecordOutBean.getSyousaimsg());

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey(gyoumukey);
        aftProcessCancelInBean.setFlowid(psFlowid);
        aftProcessCancelInBean.setAccountid(psAccountid);
        aftProcessCancelInBean.setLockkey(lockKey);
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient
            .execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(
            aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(33)
    public void testSyoriLogicOK01() throws Exception {
        String gyoumukey = BizDate.getSysDateTimeMilli();
        String psFlowid = "tt4";
        String psAccountid = "JUnit";
        String psTaskname = "data-input1";
        String lockKey = BizDate.getSysDateTimeMilli();
        String psExtinfo = "付加情報";
        String rirekimsg = "履歴メッセージ";
        IwfCoreConfig.getInstance().setLockYouhi(false);
        IwfCoreConfig.getInstance().setLockValidTime(1000);

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setGyoumukey(gyoumukey);
        befProcessCreateInBean.setFlowid(psFlowid);
        befProcessCreateInBean.setAccountid(psAccountid);
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient
            .execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(
            befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        CreateProcessRecordInBean createProcessRecordInBean = new CreateProcessRecordInBean();
        createProcessRecordInBean.setGyoumukey(gyoumukey);
        createProcessRecordInBean.setFlowid(psFlowid);
        createProcessRecordInBean.setAccountid(psAccountid);
        createProcessRecordInBean.setRirekimsg(rirekimsg);
        createProcessRecordInBean.setTaskname(psTaskname);

        List<Map<String, String>> extinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> extinfoMap = new HashMap<String, String>();
        extinfoMap.put("extinfo", psExtinfo);
        extinfoMapList.add(extinfoMap);
        createProcessRecordInBean.setExtInfo(extinfoMapList);
        CreateProcessRecordOutBean createProcessRecordOutBean = iwfKouteiClient
            .execCcreateProcessRecord(createProcessRecordInBean);

        assertEquals(C_ResultCdKbn.OK.toString() , createProcessRecordOutBean.getKekkastatus());
        assertEquals("IWF0000", createProcessRecordOutBean.getSyousaimsgcd());
        assertEquals("工程履歴作成正常終了しました。" , createProcessRecordOutBean.getSyousaimsg());

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey(gyoumukey);
        aftProcessCancelInBean.setFlowid(psFlowid);
        aftProcessCancelInBean.setAccountid(psAccountid);
        aftProcessCancelInBean.setLockkey(lockKey);
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient
            .execProcessCancel(aftProcessCancelInBean);

        if (!C_ResultCdKbn.OK.toString().equals(
            aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(34)
    public void testSyoriLogicOK02() throws Exception {
        String gyoumukey = BizDate.getSysDateTimeMilli();
        String psFlowid = "tt4";
        String psAccountid = "JUnit";
        String psTaskname = "data-input1";
        String lockKey = BizDate.getSysDateTimeMilli();
        String psExtinfo = "付加情報";
        String rirekimsg = "履歴メッセージ";
        IwfCoreConfig.getInstance().setLockYouhi(false);
        IwfCoreConfig.getInstance().setLockValidTime(1000);

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setGyoumukey(gyoumukey);
        befProcessCreateInBean.setFlowid(psFlowid);
        befProcessCreateInBean.setAccountid(psAccountid);
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient
            .execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(
            befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        CreateProcessRecordInBean createProcessRecordInBean = new CreateProcessRecordInBean();
        createProcessRecordInBean.setGyoumukey(gyoumukey);
        createProcessRecordInBean.setFlowid(psFlowid);
        createProcessRecordInBean.setAccountid(psAccountid);
        createProcessRecordInBean.setRirekimsg(rirekimsg);
        createProcessRecordInBean.setTaskname(psTaskname);

        List<Map<String, String>> extinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> extinfoMap = new HashMap<String, String>();
        extinfoMap.put("extinfo", psExtinfo);
        extinfoMapList.add(extinfoMap);
        createProcessRecordInBean.setExtInfo(extinfoMapList);
        CreateProcessRecordOutBean createProcessRecordOutBean = iwfKouteiClient
            .execCcreateProcessRecord(createProcessRecordInBean);


        assertEquals(C_ResultCdKbn.OK.toString( ), createProcessRecordOutBean.getKekkastatus());
        assertEquals("IWF0000", createProcessRecordOutBean.getSyousaimsgcd());
        assertEquals("工程履歴作成正常終了しました。", createProcessRecordOutBean.getSyousaimsg());

        GetLastRecordByKinouInBean aftGetLastRecordByKinouInBean = new GetLastRecordByKinouInBean();
        aftGetLastRecordByKinouInBean.setGyoumukey(gyoumukey);
        aftGetLastRecordByKinouInBean.setFlowid(psFlowid);
        aftGetLastRecordByKinouInBean.setRirekikbn(C_RirekiKbn.GYOUMU .toString());
        GetLastRecordByKinouOutBean aftGetLastRecordByKinouOutBean = iwfKouteiClient
            .execGetLastRecordByKinou(aftGetLastRecordByKinouInBean);
        if (!C_ResultCdKbn.OK.toString().equals(
            aftGetLastRecordByKinouOutBean.getKekkastatus())) {
            throw new Exception("後処理：前回処理結果取得（機能指定）実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey(gyoumukey);
        aftProcessCancelInBean.setFlowid(psFlowid);
        aftProcessCancelInBean.setAccountid(psAccountid);
        aftProcessCancelInBean.setLockkey(lockKey);
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient
            .execProcessCancel(aftProcessCancelInBean);

        if (!C_ResultCdKbn.OK.toString().equals(
            aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }
        createProcessRecordInBean = new CreateProcessRecordInBean();
        createProcessRecordInBean.setGyoumukey(gyoumukey);
        createProcessRecordInBean.setFlowid(psFlowid);
        createProcessRecordInBean.setAccountid(psAccountid);
        createProcessRecordInBean.setRirekimsg(rirekimsg);
        createProcessRecordInBean.setTaskname(psTaskname);

        extinfoMapList = new ArrayList<Map<String, String>>();
        extinfoMap = new HashMap<String, String>();
        extinfoMap.put("extinfo", psExtinfo);
        extinfoMapList.add(extinfoMap);
        createProcessRecordInBean.setExtInfo(extinfoMapList);
        createProcessRecordOutBean = iwfKouteiClient
            .execCcreateProcessRecord(createProcessRecordInBean);


        assertEquals(C_ResultCdKbn.OK.toString( ), createProcessRecordOutBean.getKekkastatus());
        assertEquals("IWF0000", createProcessRecordOutBean.getSyousaimsgcd());
        assertEquals("工程履歴作成正常終了しました。", createProcessRecordOutBean.getSyousaimsg());
    }
    private static String bj2qj(String src) {
        char DBC_SPACE = ' ';
        char SBC_SPACE = 12288;
        char DBC_CHAR_START = 33;
        char DBC_CHAR_END = 126;
        int CONVERT_STEP = 65248;
        if (src == null) {
            return src;
        }
        StringBuilder buf = new StringBuilder(src.length());
        char[] ca = src.toCharArray();
        for (int i = 0; i < ca.length; i++) {
            if (ca[i] == DBC_SPACE) {
                buf.append(SBC_SPACE);
            } else if ((ca[i] >= DBC_CHAR_START) && (ca[i] <= DBC_CHAR_END)) {
                buf.append((char) (ca[i] + CONVERT_STEP));
            } else {
                buf.append(ca[i]);
            }
        }
        return buf.toString();
    }
}
