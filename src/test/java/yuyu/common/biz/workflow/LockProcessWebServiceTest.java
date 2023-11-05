package yuyu.common.biz.workflow;

import static org.junit.Assert.*;

import javax.inject.Inject;

import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.uniquekey.UniqueKeyGenerator;
import jp.co.slcs.swak.util.string.DebugUtil;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;

import yuyu.common.biz.workflow.io.koutei.LockProcessInBean;
import yuyu.common.biz.workflow.io.koutei.LockProcessOutBean;
import yuyu.common.biz.workflow.io.koutei.ProcessCancelInBean;
import yuyu.common.biz.workflow.io.koutei.ProcessCancelOutBean;
import yuyu.common.biz.workflow.io.koutei.ProcessCreateInBean;
import yuyu.common.biz.workflow.io.koutei.ProcessCreateOutBean;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.lockprocess.WSLockProcess;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.lockprocess.WSLockProcessRequest;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.def.workflowcore.configration.IwfCoreConfig;

/**
 * 工程ロック開始Webサービス {@link WSLockProcess#executeBizMain(WSLockProcessRequest)} テスト用クラスです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class LockProcessWebServiceTest {

    @Inject
    private static Logger log;

    @Inject
    private IwfKouteiClient iwfKouteiClient;

    @Inject
    private UniqueKeyGenerator keyGenerator;

    @Test(expected=RuntimeException.class)
    public void testValidationNG01() {
        LockProcessInBean inBean = null;
        iwfKouteiClient.execLockProcess(inBean);
    }

    @Test
    public void testValidationNG02() {
        String psGyoumukey = null;
        String psFlowid = "09";
        String psLockkey = "l1";

        LockProcessInBean inBean = new LockProcessInBean();
        inBean.setGyoumukey(psGyoumukey);
        inBean.setFlowid(psFlowid);
        inBean.setLockkey(psLockkey);

        LockProcessOutBean outBean = iwfKouteiClient.execLockProcess(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("IWF0002", outBean.getSyousaimsgcd());
        assertEquals("必須入力チェックエラー：業務キー", outBean.getSyousaimsg());
        assertNull("業務キー", outBean.getGyoumukey());

        //        boolean result = C_ResultCdKbn.NG.toString().equals(outBean.getKekkastatus())
        //                && "IWF0002".equals(outBean.getSyousaimsgcd())
        //                && "必須入力チェックエラー：業務キー".equals(outBean.getSyousaimsg())
        //                && null == outBean.getGyoumukey();
        //        assertTrue(result);
    }

    @Test
    public void testValidationNG03() {
        try {
            String psGyoumukey = "";
            String psFlowid = "09";
            String psLockkey = "l1";

            LockProcessInBean inBean = new LockProcessInBean();
            inBean.setGyoumukey(psGyoumukey);
            inBean.setFlowid(psFlowid);
            inBean.setLockkey(psLockkey);

            LockProcessOutBean outBean = iwfKouteiClient.execLockProcess(inBean);

            boolean result = C_ResultCdKbn.NG.toString().equals(outBean.getKekkastatus())
                && "IWF0002".equals(outBean.getSyousaimsgcd())
                && "必須入力チェックエラー：業務キー".equals(outBean.getSyousaimsg())
                && null == outBean.getGyoumukey();

            assertTrue(result);
        } catch (Exception e) {
            log.debug(e.getMessage(), e);
            assertTrue(false);
        }
    }

    @Test
    public void testValidationNG04() {
        try {
            String psGyoumukey = "GKID000000000000006";
            String psFlowid = null;
            String psLockkey = "l1";

            LockProcessInBean inBean = new LockProcessInBean();
            inBean.setGyoumukey(psGyoumukey);
            inBean.setFlowid(psFlowid);
            inBean.setLockkey(psLockkey);

            LockProcessOutBean outBean = iwfKouteiClient.execLockProcess(inBean);

            boolean result = C_ResultCdKbn.NG.toString().equals(outBean.getKekkastatus())
                && "IWF0002".equals(outBean.getSyousaimsgcd())
                && "必須入力チェックエラー：フローＩＤ".equals(outBean.getSyousaimsg())
                && null == outBean.getGyoumukey();

            assertTrue(result);
        } catch (Exception e) {
            log.debug(e.getMessage(), e);
            assertTrue(false);
        }
    }

    @Test
    public void testValidationNG05() {
        try {
            String psGyoumukey = "GKID000000000000006";
            String psFlowid = "";
            String psLockkey = "l1";

            LockProcessInBean inBean = new LockProcessInBean();
            inBean.setGyoumukey(psGyoumukey);
            inBean.setFlowid(psFlowid);
            inBean.setLockkey(psLockkey);

            LockProcessOutBean outBean = iwfKouteiClient.execLockProcess(inBean);

            boolean result = C_ResultCdKbn.NG.toString().equals(outBean.getKekkastatus())
                && "IWF0002".equals(outBean.getSyousaimsgcd())
                && "必須入力チェックエラー：フローＩＤ".equals(outBean.getSyousaimsg())
                && null == outBean.getGyoumukey();

            assertTrue(result);
        } catch (Exception e) {
            log.debug(e.getMessage(), e);
            assertTrue(false);
        }
    }

    @Test
    public void testValidationNG06() {
        try {
            String psGyoumukey = "GKID000000000000006";
            String psFlowid = "09";
            String psLockkey = null;

            LockProcessInBean inBean = new LockProcessInBean();
            inBean.setGyoumukey(psGyoumukey);
            inBean.setFlowid(psFlowid);
            inBean.setLockkey(psLockkey);

            LockProcessOutBean outBean = iwfKouteiClient.execLockProcess(inBean);

            boolean result = C_ResultCdKbn.NG.toString().equals(outBean.getKekkastatus())
                && "IWF0002".equals(outBean.getSyousaimsgcd())
                && "必須入力チェックエラー：ロックキー".equals(outBean.getSyousaimsg())
                && null == outBean.getGyoumukey();

            assertTrue(result);
        } catch (Exception e) {
            log.debug(e.getMessage(), e);
            assertTrue(false);
        }
    }

    @Test
    public void testValidationNG07() {
        try {
            String psGyoumukey = "GKID000000000000006";
            String psFlowid = "09";
            String psLockkey = "";

            LockProcessInBean inBean = new LockProcessInBean();
            inBean.setGyoumukey(psGyoumukey);
            inBean.setFlowid(psFlowid);
            inBean.setLockkey(psLockkey);

            LockProcessOutBean outBean = iwfKouteiClient.execLockProcess(inBean);

            boolean result = C_ResultCdKbn.NG.toString().equals(outBean.getKekkastatus())
                && "IWF0002".equals(outBean.getSyousaimsgcd())
                && "必須入力チェックエラー：ロックキー".equals(outBean.getSyousaimsg())
                && null == outBean.getGyoumukey();

            assertTrue(result);
        } catch (Exception e) {
            log.debug(e.getMessage(), e);
            assertTrue(false);
        }
    }

    @Test
    public void testKyoukaiOK01() throws Exception {
        //String psGyoumukey = BizDate.getSysDateTimeMilli() + "一二";
        String psGyoumukey = keyGenerator.generateUniqueKey();

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setFlowid("tt4");
        befProcessCreateInBean.setGyoumukey(psGyoumukey);
        befProcessCreateInBean.setAccountid("JUnit");
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        String psFlowid = "tt4";
        String psLockkey = "l1";

        LockProcessInBean inBean = new LockProcessInBean();
        inBean.setGyoumukey(psGyoumukey);
        inBean.setFlowid(psFlowid);
        inBean.setLockkey(psLockkey);

        LockProcessOutBean outBean = iwfKouteiClient.execLockProcess(inBean);

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setFlowid("tt4");
        aftProcessCancelInBean.setGyoumukey(psGyoumukey);
        aftProcessCancelInBean.setAccountid("JUnit");
        aftProcessCancelInBean.setLockkey("l1");
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

        log.debug("outBean           = {}", outBean                  );
        log.debug("status            = {}", outBean.getKekkastatus() );
        log.debug("gyoumukey         = {}", outBean.getGyoumukey()   );
        log.debug("syousaimsgcd      = {}", outBean.getSyousaimsgcd());
        log.debug("syousaimsg        = {}", outBean.getSyousaimsg()  );
        log.debug("validationErrMsgs = {}", DebugUtil.toString(outBean.getValidationErrMsgs()));
        assertEquals(C_ResultCdKbn.OK.toString(),    outBean.getKekkastatus() );
        assertEquals("IWF0000",                      outBean.getSyousaimsgcd());
        assertEquals("工程ロック正常終了しました。", outBean.getSyousaimsg()  );
        assertEquals(psGyoumukey,                    outBean.getGyoumukey()   );

        //        boolean result = C_ResultCdKbn.OK.toString().equals(outBean.getKekkastatus())
        //            && "IWF0000".equals(outBean.getSyousaimsgcd())
        //            && "工程ロック正常終了しました。".equals(outBean.getSyousaimsg())
        //            && psGyoumukey.equals(outBean.getGyoumukey());
        //
        //        assertTrue(result);
    }

    @Test
    public void testKyoukaiOK02() {
        try {

            String psGyoumukey = BizDate.getSysDateTimeMilli() + "一二三";

            ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
            befProcessCreateInBean.setFlowid("tt4");
            befProcessCreateInBean.setGyoumukey(psGyoumukey);
            befProcessCreateInBean.setAccountid("JUnit");
            ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
            if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
                throw new Exception("前処理：工程作成実行失敗！");
            }

            String psFlowid = "tt4";
            String psLockkey = "l1";

            LockProcessInBean inBean = new LockProcessInBean();
            inBean.setGyoumukey(psGyoumukey);
            inBean.setFlowid(psFlowid);
            inBean.setLockkey(psLockkey);

            LockProcessOutBean outBean = iwfKouteiClient.execLockProcess(inBean);

            boolean result = C_ResultCdKbn.OK.toString().equals(outBean.getKekkastatus())
                && "IWF0000".equals(outBean.getSyousaimsgcd())
                && "工程ロック正常終了しました。".equals(outBean.getSyousaimsg())
                && psGyoumukey.equals(outBean.getGyoumukey());

            ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
            aftProcessCancelInBean.setFlowid("tt4");
            aftProcessCancelInBean.setGyoumukey(psGyoumukey);
            aftProcessCancelInBean.setAccountid("JUnit");
            aftProcessCancelInBean.setLockkey("l1");
            ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
            if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
                throw new Exception("後処理：工程取消実行失敗！");
            }

            assertTrue(result);
        } catch (Exception e) {
            log.debug(e.getMessage(), e);
            assertTrue(false);
        }
    }

    @Test
    public void testKyoukaiNG01() {
        try {
            String psGyoumukey = "業務キー業務キー業務キー業務キー業務キー業務キー業務キー業務キー業務キー業務キー業務キー業務キー業務キ";
            String psFlowid = "09";
            String psLockkey = "l1";

            LockProcessInBean inBean = new LockProcessInBean();
            inBean.setGyoumukey(psGyoumukey);
            inBean.setFlowid(psFlowid);
            inBean.setLockkey(psLockkey);

            LockProcessOutBean outBean = iwfKouteiClient.execLockProcess(inBean);

            boolean result = C_ResultCdKbn.NG.toString().equals(outBean.getKekkastatus())
                && "IWF0008".equals(outBean.getSyousaimsgcd())
                && "業務キーは20文字以内で入力してください。".equals(outBean.getSyousaimsg())
                && null == outBean.getGyoumukey();

            assertTrue(result);
        } catch (Exception e) {
            log.debug(e.getMessage(), e);
            assertTrue(false);
        }
    }

    @Test
    public void testKyoukaiOK03() {
        try {

            String psGyoumukey = BizDate.getSysDateTimeMilli() + "＃1A";

            ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
            befProcessCreateInBean.setFlowid("tt4");
            befProcessCreateInBean.setGyoumukey(psGyoumukey);
            befProcessCreateInBean.setAccountid("JUnit");
            ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
            if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
                throw new Exception("前処理：工程作成実行失敗！");
            }

            String psFlowid = "tt4";
            String psLockkey = "l1";

            LockProcessInBean inBean = new LockProcessInBean();
            inBean.setGyoumukey(psGyoumukey);
            inBean.setFlowid(psFlowid);
            inBean.setLockkey(psLockkey);

            LockProcessOutBean outBean = iwfKouteiClient.execLockProcess(inBean);

            boolean result = C_ResultCdKbn.OK.toString().equals(outBean.getKekkastatus())
                && "IWF0000".equals(outBean.getSyousaimsgcd())
                && "工程ロック正常終了しました。".equals(outBean.getSyousaimsg())
                && psGyoumukey.equals(outBean.getGyoumukey());

            ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
            aftProcessCancelInBean.setFlowid("tt4");
            aftProcessCancelInBean.setGyoumukey(psGyoumukey);
            aftProcessCancelInBean.setAccountid("JUnit");
            aftProcessCancelInBean.setLockkey("l1");
            ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
            if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
                throw new Exception("後処理：工程取消実行失敗！");
            }

            assertTrue(result);
        } catch (Exception e) {
            log.debug(e.getMessage(), e);
            assertTrue(false);
        }
    }

    @Test
    public void testKyoukaiOK04() {
        try {

            String psGyoumukey = BizDate.getSysDateTimeMilli();

            ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
            befProcessCreateInBean.setFlowid("一二三四五六七八九十一二三四五六七八");
            befProcessCreateInBean.setGyoumukey(psGyoumukey);
            befProcessCreateInBean.setAccountid("JUnit");
            ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
            if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
                throw new Exception("前処理：工程作成実行失敗！");
            }

            String psFlowid = "一二三四五六七八九十一二三四五六七八";
            String psLockkey = "l1";

            LockProcessInBean inBean = new LockProcessInBean();
            inBean.setGyoumukey(psGyoumukey);
            inBean.setFlowid(psFlowid);
            inBean.setLockkey(psLockkey);

            LockProcessOutBean outBean = iwfKouteiClient.execLockProcess(inBean);

            boolean result = C_ResultCdKbn.OK.toString().equals(outBean.getKekkastatus())
                && "IWF0000".equals(outBean.getSyousaimsgcd())
                && "工程ロック正常終了しました。".equals(outBean.getSyousaimsg())
                && psGyoumukey.equals(outBean.getGyoumukey());

            ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
            aftProcessCancelInBean.setFlowid("一二三四五六七八九十一二三四五六七八");
            aftProcessCancelInBean.setGyoumukey(psGyoumukey);
            aftProcessCancelInBean.setAccountid("JUnit");
            aftProcessCancelInBean.setLockkey("l1");
            ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
            if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
                throw new Exception("後処理：工程取消実行失敗！");
            }

            assertTrue(result);
        } catch (Exception e) {
            log.debug(e.getMessage(), e);
            assertTrue(false);
        }
    }

    @Test
    public void testKyoukaiOK05() {
        try {

            String psGyoumukey = BizDate.getSysDateTimeMilli();

            ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
            befProcessCreateInBean.setFlowid("一二三四五六七八九十一二三四五六七八九");
            befProcessCreateInBean.setGyoumukey(psGyoumukey);
            befProcessCreateInBean.setAccountid("JUnit");
            ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
            if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
                throw new Exception("前処理：工程作成実行失敗！");
            }

            String psFlowid = "一二三四五六七八九十一二三四五六七八九";
            String psLockkey = "l1";

            LockProcessInBean inBean = new LockProcessInBean();
            inBean.setGyoumukey(psGyoumukey);
            inBean.setFlowid(psFlowid);
            inBean.setLockkey(psLockkey);

            LockProcessOutBean outBean = iwfKouteiClient.execLockProcess(inBean);

            boolean result = C_ResultCdKbn.OK.toString().equals(outBean.getKekkastatus())
                && "IWF0000".equals(outBean.getSyousaimsgcd())
                && "工程ロック正常終了しました。".equals(outBean.getSyousaimsg())
                && psGyoumukey.equals(outBean.getGyoumukey());

            ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
            aftProcessCancelInBean.setFlowid("一二三四五六七八九十一二三四五六七八九");
            aftProcessCancelInBean.setGyoumukey(psGyoumukey);
            aftProcessCancelInBean.setAccountid("JUnit");
            aftProcessCancelInBean.setLockkey("l1");
            ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
            if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
                throw new Exception("後処理：工程取消実行失敗！");
            }

            assertTrue(result);
        } catch (Exception e) {
            log.debug(e.getMessage(), e);
            assertTrue(false);
        }
    }

    @Test
    public void testKyoukaiNG02() {
        try {
            String psGyoumukey = "GYOUMUKEYOK03";
            String psFlowid = "フローＩＤフローＩＤフローＩＤフローＩＤ";
            String psLockkey = "l1";

            LockProcessInBean inBean = new LockProcessInBean();
            inBean.setGyoumukey(psGyoumukey);
            inBean.setFlowid(psFlowid);
            inBean.setLockkey(psLockkey);

            LockProcessOutBean outBean = iwfKouteiClient.execLockProcess(inBean);

            boolean result = C_ResultCdKbn.NG.toString().equals(outBean.getKekkastatus())
                && "IWF0008".equals(outBean.getSyousaimsgcd())
                && "フローＩＤは19文字以内で入力してください。".equals(outBean.getSyousaimsg())
                && null == outBean.getGyoumukey();

            assertTrue(result);
        } catch (Exception e) {
            log.debug(e.getMessage(), e);
            assertTrue(false);
        }
    }

    @Test
    public void testKyoukaiOK06() {
        try {

            String psGyoumukey = BizDate.getSysDateTimeMilli();

            ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
            befProcessCreateInBean.setFlowid("＃1A一");
            befProcessCreateInBean.setGyoumukey(psGyoumukey);
            befProcessCreateInBean.setAccountid("JUnit");
            ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
            if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
                throw new Exception("前処理：工程作成実行失敗！");
            }

            String psFlowid = "＃1A一";
            String psLockkey = "l1";

            LockProcessInBean inBean = new LockProcessInBean();
            inBean.setGyoumukey(psGyoumukey);
            inBean.setFlowid(psFlowid);
            inBean.setLockkey(psLockkey);

            LockProcessOutBean outBean = iwfKouteiClient.execLockProcess(inBean);

            boolean result = C_ResultCdKbn.OK.toString().equals(outBean.getKekkastatus())
                && "IWF0000".equals(outBean.getSyousaimsgcd())
                && "工程ロック正常終了しました。".equals(outBean.getSyousaimsg())
                && psGyoumukey.equals(outBean.getGyoumukey());

            ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
            aftProcessCancelInBean.setFlowid("＃1A一");
            aftProcessCancelInBean.setGyoumukey(psGyoumukey);
            aftProcessCancelInBean.setAccountid("JUnit");
            aftProcessCancelInBean.setLockkey("l1");
            ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
            if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
                throw new Exception("後処理：工程取消実行失敗！");
            }

            assertTrue(result);
        } catch (Exception e) {
            log.debug(e.getMessage(), e);
            assertTrue(false);
        }
    }

    @Test
    public void testKyoukaiOK07() {
        try {

            String psGyoumukey = BizDate.getSysDateTimeMilli();

            ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
            befProcessCreateInBean.setFlowid("tt4");
            befProcessCreateInBean.setGyoumukey(psGyoumukey);
            befProcessCreateInBean.setAccountid("JUnit");
            ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
            if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
                throw new Exception("前処理：工程作成実行失敗！");
            }

            String psFlowid = "tt4";
            String psLockkey = "ロックキーロックキーロックキーロックキーロックキーロックキ";

            LockProcessInBean inBean = new LockProcessInBean();
            inBean.setGyoumukey(psGyoumukey);
            inBean.setFlowid(psFlowid);
            inBean.setLockkey(psLockkey);

            LockProcessOutBean outBean = iwfKouteiClient.execLockProcess(inBean);

            boolean result = C_ResultCdKbn.OK.toString().equals(outBean.getKekkastatus())
                && "IWF0000".equals(outBean.getSyousaimsgcd())
                && "工程ロック正常終了しました。".equals(outBean.getSyousaimsg())
                && psGyoumukey.equals(outBean.getGyoumukey());

            ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
            aftProcessCancelInBean.setFlowid("tt4");
            aftProcessCancelInBean.setGyoumukey(psGyoumukey);
            aftProcessCancelInBean.setAccountid("JUnit");
            aftProcessCancelInBean.setLockkey("ロックキーロックキーロックキーロックキーロックキーロックキ");
            ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
            if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
                throw new Exception("後処理：工程取消実行失敗！");
            }

            assertTrue(result);
        } catch (Exception e) {
            log.debug(e.getMessage(), e);
            assertTrue(false);
        }
    }

    @Test
    public void testKyoukaiOK08() {
        try {

            String psGyoumukey = BizDate.getSysDateTimeMilli();

            ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
            befProcessCreateInBean.setFlowid("tt4");
            befProcessCreateInBean.setGyoumukey(psGyoumukey);
            befProcessCreateInBean.setAccountid("JUnit");
            ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
            if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
                throw new Exception("前処理：工程作成実行失敗！");
            }

            String psFlowid = "tt4";
            String psLockkey = "ロックキーロックキーロックキーロックキーロックキーロックキー";

            LockProcessInBean inBean = new LockProcessInBean();
            inBean.setGyoumukey(psGyoumukey);
            inBean.setFlowid(psFlowid);
            inBean.setLockkey(psLockkey);

            LockProcessOutBean outBean = iwfKouteiClient.execLockProcess(inBean);

            boolean result = C_ResultCdKbn.OK.toString().equals(outBean.getKekkastatus())
                && "IWF0000".equals(outBean.getSyousaimsgcd())
                && "工程ロック正常終了しました。".equals(outBean.getSyousaimsg())
                && psGyoumukey.equals(outBean.getGyoumukey());

            ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
            aftProcessCancelInBean.setFlowid("tt4");
            aftProcessCancelInBean.setGyoumukey(psGyoumukey);
            aftProcessCancelInBean.setAccountid("JUnit");
            aftProcessCancelInBean.setLockkey("ロックキーロックキーロックキーロックキーロックキーロックキー");
            ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
            if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
                throw new Exception("後処理：工程取消実行失敗！");
            }

            assertTrue(result);
        } catch (Exception e) {
            log.debug(e.getMessage(), e);
            assertTrue(false);
        }
    }

    @Test
    public void testKyoukaiNG03() {
        try {
            String psGyoumukey = "GYOUMUKEYOK07";
            String psFlowid = "FLOWIDOK07";
            String psLockkey = "ロックキーロックキーロックキーロックキーロックキーロックキーロ";

            LockProcessInBean inBean = new LockProcessInBean();
            inBean.setGyoumukey(psGyoumukey);
            inBean.setFlowid(psFlowid);
            inBean.setLockkey(psLockkey);

            LockProcessOutBean outBean = iwfKouteiClient.execLockProcess(inBean);

            boolean result = C_ResultCdKbn.NG.toString().equals(outBean.getKekkastatus())
                && "IWF0008".equals(outBean.getSyousaimsgcd())
                && "ロックキーは30文字以内で入力してください。".equals(outBean.getSyousaimsg())
                && null == outBean.getGyoumukey();

            assertTrue(result);
        } catch (Exception e) {
            log.debug(e.getMessage(), e);
            assertTrue(false);
        }
    }

    @Test
    public void testKyoukaiOK09() {
        try {

            String psGyoumukey = BizDate.getSysDateTimeMilli();

            ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
            befProcessCreateInBean.setFlowid("tt4");
            befProcessCreateInBean.setGyoumukey(psGyoumukey);
            befProcessCreateInBean.setAccountid("JUnit");
            ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
            if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
                throw new Exception("前処理：工程作成実行失敗！");
            }

            String psFlowid = "tt4";
            String psLockkey = "ロックキー0001";

            LockProcessInBean inBean = new LockProcessInBean();
            inBean.setGyoumukey(psGyoumukey);
            inBean.setFlowid(psFlowid);
            inBean.setLockkey(psLockkey);

            LockProcessOutBean outBean = iwfKouteiClient.execLockProcess(inBean);

            boolean result = C_ResultCdKbn.OK.toString().equals(outBean.getKekkastatus())
                && "IWF0000".equals(outBean.getSyousaimsgcd())
                && "工程ロック正常終了しました。".equals(outBean.getSyousaimsg())
                && psGyoumukey.equals(outBean.getGyoumukey());

            ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
            aftProcessCancelInBean.setFlowid("tt4");
            aftProcessCancelInBean.setGyoumukey(psGyoumukey);
            aftProcessCancelInBean.setAccountid("JUnit");
            aftProcessCancelInBean.setLockkey("ロックキー0001");
            ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
            if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
                throw new Exception("後処理：工程取消実行失敗！");
            }

            assertTrue(result);
        } catch (Exception e) {
            log.debug(e.getMessage(), e);
            assertTrue(false);
        }
    }

    @Test
    public void testInfoExistNG01() {
        try {

            IwfCoreConfig.getInstance().setLockYouhi(false);

            String psGyoumukey = BizDate.getSysDateTimeMilli() + "E01";

            ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
            befProcessCreateInBean.setFlowid("tt4");
            befProcessCreateInBean.setGyoumukey(psGyoumukey);
            befProcessCreateInBean.setAccountid("JUnit");
            ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
            if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
                throw new Exception("前処理：工程作成実行失敗！");
            }

            String psFlowid = "tt4";
            String psLockkey = "l1";

            LockProcessInBean inBean = new LockProcessInBean();
            inBean.setGyoumukey(psGyoumukey);
            inBean.setFlowid(psFlowid);
            inBean.setLockkey(psLockkey);

            LockProcessOutBean outBean = iwfKouteiClient.execLockProcess(inBean);

            IwfCoreConfig.getInstance().setLockYouhi(true);

            boolean result = C_ResultCdKbn.NG.toString().equals(outBean.getKekkastatus())
                && "IWF2093".equals(outBean.getSyousaimsgcd())
                && "設定ファイルの設定により、ロックは不要です。".equals(outBean.getSyousaimsg())
                && null == outBean.getGyoumukey();

            assertTrue(result);
        } catch (Exception e) {
            log.debug(e.getMessage(), e);
            assertTrue(false);
        }
    }

    @Test
    public void testInfoExistNG02() {
        try {
            String psGyoumukey = BizDate.getSysDateTimeMilli() + "E02";
            String psFlowid = "09";
            String psLockkey = "l1";

            LockProcessInBean inBean = new LockProcessInBean();
            inBean.setGyoumukey(psGyoumukey);
            inBean.setFlowid(psFlowid);
            inBean.setLockkey(psLockkey);

            LockProcessOutBean outBean = iwfKouteiClient.execLockProcess(inBean);

            boolean result = C_ResultCdKbn.NG.toString().equals(outBean.getKekkastatus())
                && "IWF2090".equals(outBean.getSyousaimsgcd())
                && "トークンIDが取得できませんでした。".equals(outBean.getSyousaimsg())
                && null == outBean.getGyoumukey();

            assertTrue(result);
        } catch (Exception e) {
            log.debug(e.getMessage(), e);
            assertTrue(false);
        }
    }

    @Test
    public void testInfoExistNG03() {
        try {

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

            String psFlowid = "tt4";
            String psLockkey = "l1";

            LockProcessInBean inBean = new LockProcessInBean();
            inBean.setGyoumukey(gyoumukey);
            inBean.setFlowid(psFlowid);
            inBean.setLockkey(psLockkey);

            LockProcessOutBean outBean = iwfKouteiClient.execLockProcess(inBean);

            boolean result = C_ResultCdKbn.NG.toString().equals(outBean.getKekkastatus())
                && "IWF2092".equals(outBean.getSyousaimsgcd())
                && "指定されたフローID、業務キーに紐づくトークンは存在しない、または終了しています。".equals(outBean.getSyousaimsg())
                && gyoumukey.equals(outBean.getGyoumukey());

            assertTrue(result);
        } catch (Exception e) {
            log.debug(e.getMessage(), e);
            assertTrue(false);
        }
    }

    @Test
    public void testInfoExistNG04() {
        try {

            String gyoumukey = BizDate.getSysDateTimeMilli() + "E04";

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

            String psFlowid = "tt4";
            String psLockkey = "l1";

            LockProcessInBean inBean = new LockProcessInBean();
            inBean.setGyoumukey(gyoumukey);
            inBean.setFlowid(psFlowid);
            inBean.setLockkey(psLockkey);

            LockProcessOutBean outBean = iwfKouteiClient.execLockProcess(inBean);

            boolean result = C_ResultCdKbn.NG.toString().equals(outBean.getKekkastatus())
                && "IWF2091".equals(outBean.getSyousaimsgcd())
                && "対象のトークンは既にロックされています。".equals(outBean.getSyousaimsg());

            ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
            aftProcessCancelInBean.setFlowid("tt4");
            aftProcessCancelInBean.setGyoumukey(gyoumukey);
            aftProcessCancelInBean.setAccountid("JUnit");
            aftProcessCancelInBean.setLockkey("l1");
            ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
            if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
                throw new Exception("後処理：工程取消実行失敗！");
            }

            assertTrue(result);
        } catch (Exception e) {
            log.debug(e.getMessage(), e);
            assertTrue(false);
        }
    }

    @Test
    public void testSyoriLogicOK01() {
        try {

            String gyoumukey = BizDate.getSysDateTimeMilli();

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

            LockProcessInBean inBean = new LockProcessInBean();
            inBean.setGyoumukey(psGyoumukey);
            inBean.setFlowid(psFlowid);
            inBean.setLockkey(psLockkey);

            LockProcessOutBean outBean = iwfKouteiClient.execLockProcess(inBean);

            boolean result = C_ResultCdKbn.OK.toString().equals(outBean.getKekkastatus())
                && "IWF0000".equals(outBean.getSyousaimsgcd())
                && "工程ロック正常終了しました。".equals(outBean.getSyousaimsg())
                && gyoumukey.equals(outBean.getGyoumukey());

            ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
            aftProcessCancelInBean.setFlowid("tt4");
            aftProcessCancelInBean.setGyoumukey(gyoumukey);
            aftProcessCancelInBean.setAccountid("JUnit");
            aftProcessCancelInBean.setLockkey("l1");
            ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
            if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
                throw new Exception("後処理：工程取消実行失敗！");
            }

            assertTrue(result);
        } catch (Exception e) {
            log.debug(e.getMessage(), e);
            assertTrue(false);
        }
    }
}
