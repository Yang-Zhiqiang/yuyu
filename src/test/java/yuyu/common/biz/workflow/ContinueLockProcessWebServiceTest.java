package yuyu.common.biz.workflow;

import static org.junit.Assert.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDate;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.workflow.io.koutei.ContinueLockProcessInBean;
import yuyu.common.biz.workflow.io.koutei.ContinueLockProcessOutBean;
import yuyu.common.biz.workflow.io.koutei.ForceUnlockProcessInBean;
import yuyu.common.biz.workflow.io.koutei.LockProcessInBean;
import yuyu.common.biz.workflow.io.koutei.LockProcessOutBean;
import yuyu.common.biz.workflow.io.koutei.ProcessCancelInBean;
import yuyu.common.biz.workflow.io.koutei.ProcessCancelOutBean;
import yuyu.common.biz.workflow.io.koutei.ProcessCreateInBean;
import yuyu.common.biz.workflow.io.koutei.ProcessCreateOutBean;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.continuelockprocess.WSContinueLockProcess;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.continuelockprocess.WSContinueLockProcessRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.forceunlockprocess.WSForceUnlockProcessResponse;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.def.workflowcore.configration.IwfCoreConfig;
import yuyu.testinfr.TestOrder;

/**
 * 工程ロック継続Webサービス {@link WSContinueLockProcess#executeBizMain(WSContinueLockProcessRequest)} テスト用クラスです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class ContinueLockProcessWebServiceTest {

    @Inject
    IwfKouteiClient iwfKouteiClient;

    @Test(expected = RuntimeException.class)
    @TestOrder(1)
    public void testValidationNG01() {
        ContinueLockProcessInBean inBean = null;

        iwfKouteiClient.execContinueLockProcess(inBean);
    }

    @Test
    @TestOrder(2)
    public void testValidationNG02() {

        String psGyoumukey = null;
        String psFlowid = "09";
        String psLockkey = "l1";

        ContinueLockProcessInBean inBean = new ContinueLockProcessInBean();
        inBean.setGyoumukey(psGyoumukey);
        inBean.setFlowid(psFlowid);
        inBean.setLockkey(psLockkey);

        ContinueLockProcessOutBean outBean = iwfKouteiClient.execContinueLockProcess(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("IWF0002", outBean.getSyousaimsgcd());
        assertEquals("必須入力チェックエラー：業務キー", outBean.getSyousaimsg());
    }

    @Test
    @TestOrder(3)
    public void testValidationNG03() {

        String psGyoumukey = "";
        String psFlowid = "09";
        String psLockkey = "l1";

        ContinueLockProcessInBean inBean = new ContinueLockProcessInBean();
        inBean.setGyoumukey(psGyoumukey);
        inBean.setFlowid(psFlowid);
        inBean.setLockkey(psLockkey);

        ContinueLockProcessOutBean outBean = iwfKouteiClient.execContinueLockProcess(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("IWF0002", outBean.getSyousaimsgcd());
        assertEquals("必須入力チェックエラー：業務キー", outBean.getSyousaimsg());
    }

    @Test
    @TestOrder(4)
    public void testValidationNG04() {

        String psGyoumukey = "GKID000000000000006";
        String psFlowid = null;
        String psLockkey = "l1";

        ContinueLockProcessInBean inBean = new ContinueLockProcessInBean();
        inBean.setGyoumukey(psGyoumukey);
        inBean.setFlowid(psFlowid);
        inBean.setLockkey(psLockkey);

        ContinueLockProcessOutBean outBean = iwfKouteiClient.execContinueLockProcess(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("IWF0002", outBean.getSyousaimsgcd());
        assertEquals("必須入力チェックエラー：フローＩＤ", outBean.getSyousaimsg());
    }

    @Test
    @TestOrder(5)
    public void testValidationNG05() {

        String psGyoumukey = "GKID000000000000006";
        String psFlowid = "";
        String psLockkey = "l1";

        ContinueLockProcessInBean inBean = new ContinueLockProcessInBean();
        inBean.setGyoumukey(psGyoumukey);
        inBean.setFlowid(psFlowid);
        inBean.setLockkey(psLockkey);

        ContinueLockProcessOutBean outBean = iwfKouteiClient.execContinueLockProcess(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("IWF0002", outBean.getSyousaimsgcd());
        assertEquals("必須入力チェックエラー：フローＩＤ", outBean.getSyousaimsg());
    }

    @Test
    @TestOrder(6)
    public void testValidationNG06() {

        String psGyoumukey = "GKID000000000000006";
        String psFlowid = "09";
        String psLockkey = null;

        ContinueLockProcessInBean inBean = new ContinueLockProcessInBean();
        inBean.setGyoumukey(psGyoumukey);
        inBean.setFlowid(psFlowid);
        inBean.setLockkey(psLockkey);

        ContinueLockProcessOutBean outBean = iwfKouteiClient.execContinueLockProcess(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("IWF0002", outBean.getSyousaimsgcd());
        assertEquals("必須入力チェックエラー：ロックキー", outBean.getSyousaimsg());
    }

    @Test
    @TestOrder(7)
    public void testValidationNG07() {

        String psGyoumukey = "GKID000000000000006";
        String psFlowid = "09";
        String psLockkey = "";

        ContinueLockProcessInBean inBean = new ContinueLockProcessInBean();
        inBean.setGyoumukey(psGyoumukey);
        inBean.setFlowid(psFlowid);
        inBean.setLockkey(psLockkey);

        ContinueLockProcessOutBean outBean = iwfKouteiClient.execContinueLockProcess(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("IWF0002", outBean.getSyousaimsgcd());
        assertEquals("必須入力チェックエラー：ロックキー", outBean.getSyousaimsg());
    }

    @Test
    @TestOrder(8)
    public void testKyoukaiOK01() throws Exception {
        String gyoumukey = BizDate.getSysDateTimeMilli();

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setFlowid("tt4");
        befProcessCreateInBean.setGyoumukey(gyoumukey);
        befProcessCreateInBean.setAccountid("JUnit");
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        LockProcessInBean befLockProcessInBean = new LockProcessInBean();
        befLockProcessInBean.setGyoumukey(gyoumukey);
        befLockProcessInBean.setFlowid("tt4");
        befLockProcessInBean.setLockkey("ロックキーロックキーロックキーロックキーロックキーロックキ");
        LockProcessOutBean befLockProcessOutBean = iwfKouteiClient.execLockProcess(befLockProcessInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befLockProcessOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程ロック開始実行失敗！");
        }

        String psFlowid = "tt4";
        String psLockkey = "ロックキーロックキーロックキーロックキーロックキーロックキ";

        ContinueLockProcessInBean inBean = new ContinueLockProcessInBean();
        inBean.setGyoumukey(gyoumukey);
        inBean.setFlowid(psFlowid);
        inBean.setLockkey(psLockkey);

        ContinueLockProcessOutBean outBean = iwfKouteiClient.execContinueLockProcess(inBean);

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setFlowid("tt4");
        aftProcessCancelInBean.setGyoumukey(gyoumukey);
        aftProcessCancelInBean.setAccountid("JUnit");
        aftProcessCancelInBean.setLockkey("ロックキーロックキーロックキーロックキーロックキーロックキ");
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("IWF0000", outBean.getSyousaimsgcd());
        assertEquals("工程ロック正常終了しました。", outBean.getSyousaimsg());

    }

    @Test
    @TestOrder(9)
    public void testKyoukaiOK02() throws Exception {
        String gyoumukey = BizDate.getSysDateTimeMilli();

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setFlowid("tt4");
        befProcessCreateInBean.setGyoumukey(gyoumukey);
        befProcessCreateInBean.setAccountid("JUnit");
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        LockProcessInBean befLockProcessInBean = new LockProcessInBean();
        befLockProcessInBean.setGyoumukey(gyoumukey);
        befLockProcessInBean.setFlowid("tt4");
        befLockProcessInBean.setLockkey("ロックキーロックキーロックキーロックキーロックキーロックキー");
        LockProcessOutBean befLockProcessOutBean = iwfKouteiClient.execLockProcess(befLockProcessInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befLockProcessOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程ロック開始実行失敗！");
        }

        String psGyoumukey = gyoumukey;
        String psFlowid = "tt4";
        String psLockkey = "ロックキーロックキーロックキーロックキーロックキーロックキー";

        ContinueLockProcessInBean inBean = new ContinueLockProcessInBean();
        inBean.setGyoumukey(psGyoumukey);
        inBean.setFlowid(psFlowid);
        inBean.setLockkey(psLockkey);

        ContinueLockProcessOutBean outBean = iwfKouteiClient.execContinueLockProcess(inBean);

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setFlowid("tt4");
        aftProcessCancelInBean.setGyoumukey(gyoumukey);
        aftProcessCancelInBean.setAccountid("JUnit");
        aftProcessCancelInBean.setLockkey("ロックキーロックキーロックキーロックキーロックキーロックキー");
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("IWF0000", outBean.getSyousaimsgcd());
        assertEquals("工程ロック正常終了しました。", outBean.getSyousaimsg());

    }

    @Test
    @TestOrder(10)
    public void testKyoukaiNG01() {

        String psGyoumukey = "GYOUMUKEYOK07";
        String psFlowid = "FLOWIDOK07";
        String psLockkey = "ロックキーロックキーロックキーロックキーロックキーロックキーロ";

        ContinueLockProcessInBean inBean = new ContinueLockProcessInBean();
        inBean.setGyoumukey(psGyoumukey);
        inBean.setFlowid(psFlowid);
        inBean.setLockkey(psLockkey);

        ContinueLockProcessOutBean outBean = iwfKouteiClient.execContinueLockProcess(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("IWF0008", outBean.getSyousaimsgcd());
        assertEquals("ロックキーは30文字以内で入力してください。", outBean.getSyousaimsg());

    }

    @Test
    @TestOrder(11)
    public void testKyoukaiOK03() throws Exception {

        String gyoumukey = BizDate.getSysDateTimeMilli();

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setFlowid("tt4");
        befProcessCreateInBean.setGyoumukey(gyoumukey);
        befProcessCreateInBean.setAccountid("JUnit");
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        LockProcessInBean befLockProcessInBean = new LockProcessInBean();
        befLockProcessInBean.setGyoumukey(gyoumukey);
        befLockProcessInBean.setFlowid("tt4");
        befLockProcessInBean.setLockkey("ロックキー0001");
        LockProcessOutBean befLockProcessOutBean = iwfKouteiClient.execLockProcess(befLockProcessInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befLockProcessOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程ロック開始実行失敗！");
        }

        String psGyoumukey = gyoumukey;
        String psFlowid = "tt4";
        String psLockkey = "ロックキー0001";

        ContinueLockProcessInBean inBean = new ContinueLockProcessInBean();
        inBean.setGyoumukey(psGyoumukey);
        inBean.setFlowid(psFlowid);
        inBean.setLockkey(psLockkey);

        ContinueLockProcessOutBean outBean = iwfKouteiClient.execContinueLockProcess(inBean);

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setFlowid("tt4");
        aftProcessCancelInBean.setGyoumukey(gyoumukey);
        aftProcessCancelInBean.setAccountid("JUnit");
        aftProcessCancelInBean.setLockkey("ロックキー0001");
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("IWF0000", outBean.getSyousaimsgcd());
        assertEquals("工程ロック正常終了しました。", outBean.getSyousaimsg());
    }

    @Test
    @TestOrder(12)
    public void testInfoExistNG01() throws Exception {

        IwfCoreConfig.getInstance().setLockYouhi(false);

        String pGyoumukey = BizDate.getSysDateTimeMilli();

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setFlowid("tt4");
        befProcessCreateInBean.setGyoumukey(pGyoumukey);
        befProcessCreateInBean.setAccountid("JUnit");
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        String psLockkey = "l1";

        ContinueLockProcessInBean inBean = new ContinueLockProcessInBean();
        inBean.setGyoumukey(pGyoumukey);
        inBean.setFlowid("tt4");
        inBean.setLockkey(psLockkey);

        ContinueLockProcessOutBean outBean = iwfKouteiClient.execContinueLockProcess(inBean);

        IwfCoreConfig.getInstance().setLockYouhi(true);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("IWF2093", outBean.getSyousaimsgcd());
        assertEquals("設定ファイルの設定により、ロックは不要です。", outBean.getSyousaimsg());
    }

    @Test
    @TestOrder(13)
    public void testInfoExistNG02() {

        String psGyoumukey = "業務キーErr02";
        String psFlowid = "09";
        String psLockkey = "l1";

        ContinueLockProcessInBean inBean = new ContinueLockProcessInBean();
        inBean.setGyoumukey(psGyoumukey);
        inBean.setFlowid(psFlowid);
        inBean.setLockkey(psLockkey);

        ContinueLockProcessOutBean outBean = iwfKouteiClient.execContinueLockProcess(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("IWF2090", outBean.getSyousaimsgcd());
        assertEquals("トークンIDが取得できませんでした。", outBean.getSyousaimsg());
    }

    @Test
    @TestOrder(14)
    public void testInfoExistNG03() throws Exception {

        String gyoumukey = BizDate.getSysDateTimeMilli() + "E03";

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setFlowid("tt4");
        befProcessCreateInBean.setGyoumukey(gyoumukey);
        befProcessCreateInBean.setAccountid("JUnit");
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        LockProcessInBean befLockProcessInBean = new LockProcessInBean();
        befLockProcessInBean.setGyoumukey(gyoumukey);
        befLockProcessInBean.setFlowid("tt4");
        befLockProcessInBean.setLockkey("l1");
        LockProcessOutBean befLockProcessOutBean = iwfKouteiClient.execLockProcess(befLockProcessInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befLockProcessOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程ロック開始実行失敗！");
        }

        ProcessCancelInBean befProcessCancelInBean = new ProcessCancelInBean();
        befProcessCancelInBean.setFlowid("tt4");
        befProcessCancelInBean.setGyoumukey(gyoumukey);
        befProcessCancelInBean.setAccountid("JUnit");
        befProcessCancelInBean.setLockkey("l1");
        ProcessCancelOutBean befProcessCancelOutBean = iwfKouteiClient.execProcessCancel(befProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程取消実行失敗！");
        }

        String psGyoumukey = gyoumukey;
        String psFlowid = "tt4";
        String psLockkey = "l1";

        ContinueLockProcessInBean inBean = new ContinueLockProcessInBean();
        inBean.setGyoumukey(psGyoumukey);
        inBean.setFlowid(psFlowid);
        inBean.setLockkey(psLockkey);

        ContinueLockProcessOutBean outBean = iwfKouteiClient.execContinueLockProcess(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("IWF2092", outBean.getSyousaimsgcd());
        assertEquals("指定されたフローID、業務キーに紐づくトークンは存在しない、または終了しています。", outBean.getSyousaimsg());

    }

    @Test
    @TestOrder(15)
    public void testInfoExistNG04() throws Exception {

        String gyoumukey = BizDate.getSysDateTimeMilli() + "E04";

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setFlowid("tt4");
        befProcessCreateInBean.setGyoumukey(gyoumukey);
        befProcessCreateInBean.setAccountid("JUnit");
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        String psGyoumukey = gyoumukey;
        String psFlowid = "tt4";
        String psLockkey = "l1";

        ContinueLockProcessInBean inBean = new ContinueLockProcessInBean();
        inBean.setGyoumukey(psGyoumukey);
        inBean.setFlowid(psFlowid);
        inBean.setLockkey(psLockkey);

        ContinueLockProcessOutBean outBean = iwfKouteiClient.execContinueLockProcess(inBean);

        LockProcessInBean aftLockProcessInBean = new LockProcessInBean();
        aftLockProcessInBean.setGyoumukey(gyoumukey);
        aftLockProcessInBean.setFlowid("tt4");
        aftLockProcessInBean.setLockkey("l1");
        LockProcessOutBean aftLockProcessOutBean = iwfKouteiClient.execLockProcess(aftLockProcessInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setFlowid("tt4");
        aftProcessCancelInBean.setGyoumukey(gyoumukey);
        aftProcessCancelInBean.setAccountid("JUnit");
        aftProcessCancelInBean.setLockkey("l1");
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("IWF4031", outBean.getSyousaimsgcd());
        assertEquals("ロックキーが未設定、またはロックが既に解除されています。", outBean.getSyousaimsg());
    }

    @Test
    @TestOrder(16)
    public void testInfoExistNG05() throws Exception {

        String gyoumukey = BizDate.getSysDateTimeMilli() + "E05";

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setFlowid("tt4");
        befProcessCreateInBean.setGyoumukey(gyoumukey);
        befProcessCreateInBean.setAccountid("JUnit");
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        LockProcessInBean befLockProcessInBean = new LockProcessInBean();
        befLockProcessInBean.setGyoumukey(gyoumukey);
        befLockProcessInBean.setFlowid("tt4");
        befLockProcessInBean.setLockkey("l1");
        LockProcessOutBean befLockProcessOutBean = iwfKouteiClient.execLockProcess(befLockProcessInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befLockProcessOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程ロック開始実行失敗！");
        }

        String psGyoumukey = gyoumukey;
        String psFlowid = "tt4";
        String psLockkey = "l2";

        ContinueLockProcessInBean inBean = new ContinueLockProcessInBean();
        inBean.setGyoumukey(psGyoumukey);
        inBean.setFlowid(psFlowid);
        inBean.setLockkey(psLockkey);

        ContinueLockProcessOutBean outBean = iwfKouteiClient.execContinueLockProcess(inBean);

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setFlowid("tt4");
        aftProcessCancelInBean.setGyoumukey(gyoumukey);
        aftProcessCancelInBean.setAccountid("JUnit");
        aftProcessCancelInBean.setLockkey("l1");
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("IWF4031", outBean.getSyousaimsgcd());
        assertEquals("ロックキーが未設定、またはロックが既に解除されています。", outBean.getSyousaimsg());
    }

    @Test
    @TestOrder(16)
    @Transactional
    public void testInfoExistNG06() throws Exception {

        String psGyoumukey = BizDate.getSysDateTimeMilli();
        String psFlowid = "tt4";
        String psAccountid = "JUnit";
        String psLockkey = "myLockkeyNG06";

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setFlowid(psFlowid);
        befProcessCreateInBean.setGyoumukey(psGyoumukey);
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

        ForceUnlockProcessInBean forceUnlockProcessInBean = new ForceUnlockProcessInBean();
        forceUnlockProcessInBean.setGyoumukey(psGyoumukey);
        forceUnlockProcessInBean.setFlowid(psFlowid);
        WSForceUnlockProcessResponse wSForceUnlockProcessResponse = iwfKouteiClient.execForceUnlockProcess(forceUnlockProcessInBean);
        if (!C_ResultCdKbn.OK.toString().equals(wSForceUnlockProcessResponse.getKekkastatus())) {
            throw new Exception("前処理：強制ロック失敗！");
        }

        ContinueLockProcessInBean inBean = new ContinueLockProcessInBean();
        inBean.setGyoumukey(psGyoumukey);
        inBean.setFlowid(psFlowid);
        inBean.setLockkey(psLockkey);

        ContinueLockProcessOutBean outBean = iwfKouteiClient.execContinueLockProcess(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("IWF4031", outBean.getSyousaimsgcd());
        assertEquals("ロックキーが未設定、またはロックが既に解除されています。", outBean.getSyousaimsg());
    }

    @Test
    @TestOrder(17)
    public void testSyoriLogicOK01() throws Exception {

        String gyoumukey = BizDate.getSysDateTimeMilli();

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setFlowid("tt4");
        befProcessCreateInBean.setGyoumukey(gyoumukey);
        befProcessCreateInBean.setAccountid("JUnit");
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        LockProcessInBean befLockProcessInBean = new LockProcessInBean();
        befLockProcessInBean.setGyoumukey(gyoumukey);
        befLockProcessInBean.setFlowid("tt4");
        befLockProcessInBean.setLockkey("l1");
        LockProcessOutBean befLockProcessOutBean = iwfKouteiClient.execLockProcess(befLockProcessInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befLockProcessOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程ロック開始実行失敗！");
        }

        String psGyoumukey = gyoumukey;
        String psFlowid = "tt4";
        String psLockkey = "l1";

        ContinueLockProcessInBean inBean = new ContinueLockProcessInBean();
        inBean.setGyoumukey(psGyoumukey);
        inBean.setFlowid(psFlowid);
        inBean.setLockkey(psLockkey);

        ContinueLockProcessOutBean outBean = iwfKouteiClient.execContinueLockProcess(inBean);

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setFlowid("tt4");
        aftProcessCancelInBean.setGyoumukey(gyoumukey);
        aftProcessCancelInBean.setAccountid("JUnit");
        aftProcessCancelInBean.setLockkey("l1");
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("IWF0000", outBean.getSyousaimsgcd());
        assertEquals("工程ロック正常終了しました。", outBean.getSyousaimsg());

    }
}
