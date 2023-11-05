package yuyu.common.biz.workflow;

import static org.junit.Assert.*;

import javax.inject.Inject;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDate;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.workflow.io.koutei.ForceUnlockProcessInBean;
import yuyu.common.biz.workflow.io.koutei.LockProcessInBean;
import yuyu.common.biz.workflow.io.koutei.LockProcessOutBean;
import yuyu.common.biz.workflow.io.koutei.ProcessCancelInBean;
import yuyu.common.biz.workflow.io.koutei.ProcessCancelOutBean;
import yuyu.common.biz.workflow.io.koutei.ProcessCreateInBean;
import yuyu.common.biz.workflow.io.koutei.ProcessCreateOutBean;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.def.workflowcore.configration.IwfCoreConfig;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.forceunlockprocess.WSForceUnlockProcess;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.forceunlockprocess.WSForceUnlockProcessRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.forceunlockprocess.WSForceUnlockProcessResponse;

/**
 * 強制工程ロック解除Webサービス {@link WSForceUnlockProcess#executeBizMain(WSForceUnlockProcessRequest)} テスト用クラスです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class ForceUnlockProcessWebServiceTest {

    @Inject
    IwfKouteiClient iwfKouteiClient;

    @Test(expected = RuntimeException.class)
    public void testValidationNG01() {

        iwfKouteiClient.execForceUnlockProcess(null);
    }

    @Test
    public void testValidationNG02() {
        ForceUnlockProcessInBean forceUnlockProcessInBean = new ForceUnlockProcessInBean();
        forceUnlockProcessInBean.setGyoumukey(null);
        forceUnlockProcessInBean.setFlowid("09");
        WSForceUnlockProcessResponse wSForceUnlockProcessResponse = iwfKouteiClient.execForceUnlockProcess(forceUnlockProcessInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), wSForceUnlockProcessResponse.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", wSForceUnlockProcessResponse.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "必須入力チェックエラー：業務キー", wSForceUnlockProcessResponse.getSyousaimsg());

    }

    @Test
    public void testValidationNG03() {
        ForceUnlockProcessInBean forceUnlockProcessInBean = new ForceUnlockProcessInBean();
        forceUnlockProcessInBean.setGyoumukey("");
        forceUnlockProcessInBean.setFlowid("09");
        WSForceUnlockProcessResponse wSForceUnlockProcessResponse = iwfKouteiClient.execForceUnlockProcess(forceUnlockProcessInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), wSForceUnlockProcessResponse.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", wSForceUnlockProcessResponse.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "必須入力チェックエラー：業務キー", wSForceUnlockProcessResponse.getSyousaimsg());

    }

    @Test
    public void testValidationNG04() {
        ForceUnlockProcessInBean forceUnlockProcessInBean = new ForceUnlockProcessInBean();
        forceUnlockProcessInBean.setGyoumukey("業務キー1_4");
        forceUnlockProcessInBean.setFlowid(null);
        WSForceUnlockProcessResponse wSForceUnlockProcessResponse = iwfKouteiClient.execForceUnlockProcess(forceUnlockProcessInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), wSForceUnlockProcessResponse.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", wSForceUnlockProcessResponse.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "必須入力チェックエラー：フローＩＤ", wSForceUnlockProcessResponse.getSyousaimsg());

    }

    @Test
    public void testValidationNG05() {
        ForceUnlockProcessInBean forceUnlockProcessInBean = new ForceUnlockProcessInBean();
        forceUnlockProcessInBean.setGyoumukey("業務キー1_5");
        forceUnlockProcessInBean.setFlowid("");
        WSForceUnlockProcessResponse wSForceUnlockProcessResponse = iwfKouteiClient.execForceUnlockProcess(forceUnlockProcessInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), wSForceUnlockProcessResponse.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", wSForceUnlockProcessResponse.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "必須入力チェックエラー：フローＩＤ", wSForceUnlockProcessResponse.getSyousaimsg());

    }

    @Test
    public void testInfoExistNG01() {
        ForceUnlockProcessInBean forceUnlockProcessInBean = new ForceUnlockProcessInBean();
        forceUnlockProcessInBean.setGyoumukey("業務キー2_1");
        forceUnlockProcessInBean.setFlowid("09");
        IwfCoreConfig.getInstance().setLockYouhi(false);
        WSForceUnlockProcessResponse wSForceUnlockProcessResponse = iwfKouteiClient.execForceUnlockProcess(forceUnlockProcessInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), wSForceUnlockProcessResponse.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF2203", wSForceUnlockProcessResponse.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "設定ファイルの設定により、アンロックは不要です。", wSForceUnlockProcessResponse.getSyousaimsg());

    }

    @Test
    public void testInfoExistNG02() {
        String gyoumukey = BizDate.getSysDateTimeMilli();
        IwfCoreConfig.getInstance().setLockYouhi(true);

        ForceUnlockProcessInBean forceUnlockProcessInBean = new ForceUnlockProcessInBean();
        forceUnlockProcessInBean.setGyoumukey(gyoumukey);
        forceUnlockProcessInBean.setFlowid("09");
        WSForceUnlockProcessResponse wSForceUnlockProcessResponse = iwfKouteiClient.execForceUnlockProcess(forceUnlockProcessInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), wSForceUnlockProcessResponse.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF2200", wSForceUnlockProcessResponse.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "トークンIDが取得できませんでした。", wSForceUnlockProcessResponse.getSyousaimsg());

    }

    @Test
    public void testInfoExistNG03() throws Exception {
        String gyoumukey = BizDate.getSysDateTimeMilli();
        String lockKey = BizDate.getSysDateTimeMilli();
        IwfCoreConfig.getInstance().setLockYouhi(true);

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setFlowid("09");
        befProcessCreateInBean.setGyoumukey(gyoumukey);
        befProcessCreateInBean.setAccountid("Tt");
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        LockProcessInBean befLockProcessInBean = new LockProcessInBean();
        befLockProcessInBean.setGyoumukey(gyoumukey);
        befLockProcessInBean.setFlowid("09");
        befLockProcessInBean.setLockkey(lockKey);
        LockProcessOutBean befLockProcessOutBean = iwfKouteiClient.execLockProcess(befLockProcessInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befLockProcessOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程ロック開始実行失敗！");
        }

        ProcessCancelInBean befProcessCancelInBean = new ProcessCancelInBean();
        befProcessCancelInBean.setFlowid("09");
        befProcessCancelInBean.setGyoumukey(gyoumukey);
        befProcessCancelInBean.setAccountid("Tt");
        befProcessCancelInBean.setLockkey(lockKey);
        ProcessCancelOutBean befProcessCancelOutBean = iwfKouteiClient.execProcessCancel(befProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程取消実行失敗！");
        }

        ForceUnlockProcessInBean forceUnlockProcessInBean = new ForceUnlockProcessInBean();
        forceUnlockProcessInBean.setGyoumukey(gyoumukey);
        forceUnlockProcessInBean.setFlowid("09");
        WSForceUnlockProcessResponse wSForceUnlockProcessResponse = iwfKouteiClient.execForceUnlockProcess(forceUnlockProcessInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), wSForceUnlockProcessResponse.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF2202", wSForceUnlockProcessResponse.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "指定されたフローID、業務キーに紐づくトークンは存在しない、または終了しています。", wSForceUnlockProcessResponse.getSyousaimsg());

    }

    @Test
    public void testInfoExistNG04() throws Exception {
        String gyoumukey = BizDate.getSysDateTimeMilli();
        String lockKey = BizDate.getSysDateTimeMilli();
        IwfCoreConfig.getInstance().setLockYouhi(true);

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setFlowid("09");
        befProcessCreateInBean.setGyoumukey(gyoumukey);
        befProcessCreateInBean.setAccountid("Tt");
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        ForceUnlockProcessInBean forceUnlockProcessInBean = new ForceUnlockProcessInBean();
        forceUnlockProcessInBean.setGyoumukey(gyoumukey);
        forceUnlockProcessInBean.setFlowid("09");
        WSForceUnlockProcessResponse wSForceUnlockProcessResponse = iwfKouteiClient.execForceUnlockProcess(forceUnlockProcessInBean);

        LockProcessInBean aftLockProcessInBean = new LockProcessInBean();
        aftLockProcessInBean.setGyoumukey(gyoumukey);
        aftLockProcessInBean.setFlowid("09");
        aftLockProcessInBean.setLockkey(lockKey);
        LockProcessOutBean aftLockProcessOutBean = iwfKouteiClient.execLockProcess(aftLockProcessInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setFlowid("09");
        aftProcessCancelInBean.setGyoumukey(gyoumukey);
        aftProcessCancelInBean.setAccountid("Tt");
        aftProcessCancelInBean.setLockkey(lockKey);
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

        assertEquals("処理結果ステータス:", C_ResultCdKbn.WARN.toString(), wSForceUnlockProcessResponse.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF2201", wSForceUnlockProcessResponse.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "対象のトークンはロックされていません。", wSForceUnlockProcessResponse.getSyousaimsg());

    }

    @Test
    public void testSyoriLogicOK01() throws Exception {
        String gyoumukey = BizDate.getSysDateTimeMilli();
        String lockKey = BizDate.getSysDateTimeMilli();
        IwfCoreConfig.getInstance().setLockYouhi(true);

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setFlowid("09");
        befProcessCreateInBean.setGyoumukey(gyoumukey);
        befProcessCreateInBean.setAccountid("Tt");
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        LockProcessInBean befLockProcessInBean = new LockProcessInBean();
        befLockProcessInBean.setGyoumukey(gyoumukey);
        befLockProcessInBean.setFlowid("09");
        befLockProcessInBean.setLockkey(lockKey);
        LockProcessOutBean befLockProcessOutBean = iwfKouteiClient.execLockProcess(befLockProcessInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befLockProcessOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程ロック開始実行失敗！");
        }

        ForceUnlockProcessInBean forceUnlockProcessInBean = new ForceUnlockProcessInBean();
        forceUnlockProcessInBean.setGyoumukey(gyoumukey);
        forceUnlockProcessInBean.setFlowid("09");
        WSForceUnlockProcessResponse wSForceUnlockProcessResponse = iwfKouteiClient.execForceUnlockProcess(forceUnlockProcessInBean);

        LockProcessInBean aftLockProcessInBean = new LockProcessInBean();
        aftLockProcessInBean.setGyoumukey(gyoumukey);
        aftLockProcessInBean.setFlowid("09");
        aftLockProcessInBean.setLockkey(lockKey);
        LockProcessOutBean aftLockProcessOutBean = iwfKouteiClient.execLockProcess(aftLockProcessInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setFlowid("09");
        aftProcessCancelInBean.setGyoumukey(gyoumukey);
        aftProcessCancelInBean.setAccountid("Tt");
        aftProcessCancelInBean.setLockkey(lockKey);
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), wSForceUnlockProcessResponse.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", wSForceUnlockProcessResponse.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "強制工程アンロック正常終了しました。", wSForceUnlockProcessResponse.getSyousaimsg());

    }

}

