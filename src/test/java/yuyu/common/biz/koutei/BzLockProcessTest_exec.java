package yuyu.common.biz.koutei;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.workflow.IwfKouteiClient;
import yuyu.common.biz.workflow.IwfKouteiClientMockForBiz;
import yuyu.common.biz.workflow.io.koutei.LockProcessInBean;
import yuyu.def.classification.C_KouteiLockKekkaKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 業務共通工程ロック開始クラスのメソッド {@link BzLockProcess#exec(String, String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzLockProcessTest_exec {

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(IwfKouteiClient.class).to(IwfKouteiClientMockForBiz.class);
                bind(GetSyoriKokouteiInfo.class).to(GetSyoriKokouteiInfoMockForBiz.class);
                bind(BzUnlockProcess.class).to(BzUnlockProcessMockForBiz.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        IwfKouteiClientMockForBiz.caller = "Test";
        GetSyoriKokouteiInfoMockForBiz.caller = "BzLockProcessTest_exec";
        BzUnlockProcessMockForBiz.caller = BzLockProcessTest_exec.class;
    }

    @AfterClass
    public static void testClear() {
        IwfKouteiClientMockForBiz.caller = null;
        GetSyoriKokouteiInfoMockForBiz.caller = null;
        BzUnlockProcessMockForBiz.caller = null;
        IwfKouteiClientMockForBiz.mode = null;
        GetSyoriKokouteiInfoMockForBiz.mode = null;
        BzUnlockProcessMockForBiz.SYORIPTN = null;
        MockObjectManager.initialize();
    }
    @Test()
    @TestOrder(10)
    public void testExec_A1() {

        MockObjectManager.initialize();
        IwfKouteiClientMockForBiz.mode = "dl33-01";
        BzLockProcessOutBean bzLockProcessOutBean = new BzLockProcessOutBean();

        String pKouteiKanriId = "10000000001";
        String pJimuTetuzukiCd = "001";
        BzLockProcess bzLockProcess = SWAKInjector.getInstance(BzLockProcess.class);
        bzLockProcessOutBean = bzLockProcess.exec(pKouteiKanriId, pJimuTetuzukiCd);

        exClassificationEquals(bzLockProcessOutBean.getKouteiLockKekkaKbn(), C_KouteiLockKekkaKbn.SUCCESS, "工程ロック結果区分");
        LockProcessInBean processUpdateInBean = (LockProcessInBean)MockObjectManager.getArgument(IwfKouteiClientMockForBiz.class, "execLockProcess", 0, 0);
        exStringEquals(processUpdateInBean.getGyoumukey(), "10000000001", "工程管理ID");
        exStringEquals(processUpdateInBean.getFlowid(), "001", "事務手続コード");
    }

    @Test(expected = BizAppException.class)
    @TestOrder(20)
    public void testExec_A2() {

        MockObjectManager.initialize();
        IwfKouteiClientMockForBiz.mode = "dl33-01";
        GetSyoriKokouteiInfoMockForBiz.mode  = GetSyoriKokouteiInfoMockForBiz.TESTPATTERN1;
        String pKouteiKanriId = "10000000001";
        String pJimuTetuzukiCd = "001";
        try {
            BzLockProcess bzLockProcess = SWAKInjector.getInstance(BzLockProcess.class);
            bzLockProcess.exec(pKouteiKanriId, pJimuTetuzukiCd);
            exStringEquals((String)MockObjectManager.getArgument(BzUnlockProcessMockForBiz.class, "exec", 0, 0), "10000000001", "工程管理ID");
            exStringEquals((String)MockObjectManager.getArgument(BzUnlockProcessMockForBiz.class, "exec", 0, 1), "001", "事務手続コード");
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "同一事務手続内の処理中子工程件数が不正です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test()
    @TestOrder(30)
    public void testExec_A3() {

        MockObjectManager.initialize();
        IwfKouteiClientMockForBiz.mode = "dl33-01";
        GetSyoriKokouteiInfoMockForBiz.mode  = GetSyoriKokouteiInfoMockForBiz.TESTPATTERN2;
        BzLockProcessOutBean bzLockProcessOutBean = new BzLockProcessOutBean();

        String pKouteiKanriId = "10000000001";
        String pJimuTetuzukiCd = "001";
        BzLockProcess bzLockProcess = SWAKInjector.getInstance(BzLockProcess.class);
        bzLockProcessOutBean = bzLockProcess.exec(pKouteiKanriId, pJimuTetuzukiCd);

        exClassificationEquals(bzLockProcessOutBean.getKouteiLockKekkaKbn(), C_KouteiLockKekkaKbn.SUCCESS, "工程ロック結果区分");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        MockObjectManager.initialize();
        IwfKouteiClientMockForBiz.mode = "dl33-02";
        GetSyoriKokouteiInfoMockForBiz.mode  = GetSyoriKokouteiInfoMockForBiz.TESTPATTERN2;
        BzLockProcessOutBean bzLockProcessOutBean = new BzLockProcessOutBean();

        String pKouteiKanriId = "10000000001";
        String pJimuTetuzukiCd = "001";
        BzLockProcess bzLockProcess = SWAKInjector.getInstance(BzLockProcess.class);
        bzLockProcessOutBean = bzLockProcess.exec(pKouteiKanriId, pJimuTetuzukiCd);

        exClassificationEquals(bzLockProcessOutBean.getKouteiLockKekkaKbn(), C_KouteiLockKekkaKbn.SUCCESS, "工程ロック結果区分");

        LockProcessInBean processUpdateInBean2 = (LockProcessInBean)MockObjectManager.getArgument(IwfKouteiClientMockForBiz.class, "execLockProcess", 2, 0);
        exStringEquals(processUpdateInBean2.getGyoumukey(), "10000000002", "工程管理ID");
        exStringEquals(processUpdateInBean2.getFlowid(), "002", "事務手続コード ");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        MockObjectManager.initialize();
        IwfKouteiClientMockForBiz.mode = "dl33-03";
        GetSyoriKokouteiInfoMockForBiz.mode  = GetSyoriKokouteiInfoMockForBiz.TESTPATTERN2;
        BzLockProcessOutBean bzLockProcessOutBean = new BzLockProcessOutBean();

        String pKouteiKanriId = "10000000001";
        String pJimuTetuzukiCd = "001";
        BzLockProcess bzLockProcess = SWAKInjector.getInstance(BzLockProcess.class);
        bzLockProcessOutBean = bzLockProcess.exec(pKouteiKanriId, pJimuTetuzukiCd);

        exClassificationEquals(bzLockProcessOutBean.getKouteiLockKekkaKbn(), C_KouteiLockKekkaKbn.FAILURE_CHILD,
            "工程ロック結果区分");
        exStringEquals((String)MockObjectManager.getArgument(BzUnlockProcessMockForBiz.class, "exec", 0, 0), "10000000001", "工程管理ID");
        exStringEquals((String)MockObjectManager.getArgument(BzUnlockProcessMockForBiz.class, "exec", 0, 1), "001", "事務手続コード");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        MockObjectManager.initialize();
        IwfKouteiClientMockForBiz.mode = "dl33-04";
        GetSyoriKokouteiInfoMockForBiz.mode  = GetSyoriKokouteiInfoMockForBiz.TESTPATTERN2;
        BzLockProcessOutBean bzLockProcessOutBean = new BzLockProcessOutBean();

        String pKouteiKanriId = "10000000001";
        String pJimuTetuzukiCd = "001";
        BzLockProcess bzLockProcess = SWAKInjector.getInstance(BzLockProcess.class);
        bzLockProcessOutBean = bzLockProcess.exec(pKouteiKanriId, pJimuTetuzukiCd);

        exClassificationEquals(bzLockProcessOutBean.getKouteiLockKekkaKbn(), C_KouteiLockKekkaKbn.FAILURE_CHILD,
            "工程ロック結果区分");
        exStringEquals((String)MockObjectManager.getArgument(BzUnlockProcessMockForBiz.class, "exec", 0, 0), "10000000001", "工程管理ID");
        exStringEquals((String)MockObjectManager.getArgument(BzUnlockProcessMockForBiz.class, "exec", 0, 1), "001", "事務手続コード");
    }

    @Test(expected = BizAppException.class)
    @TestOrder(70)
    public void testExec_A7() {

        MockObjectManager.initialize();
        IwfKouteiClientMockForBiz.mode = "dl33-05";
        GetSyoriKokouteiInfoMockForBiz.mode  = GetSyoriKokouteiInfoMockForBiz.TESTPATTERN2;
        String pKouteiKanriId = "10000000001";
        String pJimuTetuzukiCd = "001";
        try {
            BzLockProcess bzLockProcess = SWAKInjector.getInstance(BzLockProcess.class);
            bzLockProcess.exec(pKouteiKanriId, pJimuTetuzukiCd);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "IWFエラーです。機能＝業務共通工程ロック開始、API＝工程ロック開始、エラーコード＝IWF2094", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        MockObjectManager.initialize();
        IwfKouteiClientMockForBiz.mode = "dl33-06";
        GetSyoriKokouteiInfoMockForBiz.mode  = GetSyoriKokouteiInfoMockForBiz.TESTPATTERN3;
        BzLockProcessOutBean bzLockProcessOutBean = new BzLockProcessOutBean();
        String pKouteiKanriId = "10000000001";
        String pJimuTetuzukiCd = "001";
        BzLockProcess bzLockProcess = SWAKInjector.getInstance(BzLockProcess.class);
        bzLockProcessOutBean = bzLockProcess.exec(pKouteiKanriId, pJimuTetuzukiCd);
        exClassificationEquals(bzLockProcessOutBean.getKouteiLockKekkaKbn(), C_KouteiLockKekkaKbn.SUCCESS, "工程ロック結果区分");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        MockObjectManager.initialize();
        IwfKouteiClientMockForBiz.mode = "dl33-07";
        GetSyoriKokouteiInfoMockForBiz.mode  = GetSyoriKokouteiInfoMockForBiz.TESTPATTERN3;
        BzLockProcessOutBean bzLockProcessOutBean = new BzLockProcessOutBean();

        String pKouteiKanriId = "10000000001";
        String pJimuTetuzukiCd = "001";
        BzLockProcess bzLockProcess = SWAKInjector.getInstance(BzLockProcess.class);
        bzLockProcessOutBean = bzLockProcess.exec(pKouteiKanriId, pJimuTetuzukiCd);

        exClassificationEquals(bzLockProcessOutBean.getKouteiLockKekkaKbn(), C_KouteiLockKekkaKbn.FAILURE_SELF, "工程ロック結果区分");
    }
    @Test
    @TestOrder(100)
    public void testExec_A10() {

        MockObjectManager.initialize();
        IwfKouteiClientMockForBiz.mode = "dl33-08";
        GetSyoriKokouteiInfoMockForBiz.mode  = GetSyoriKokouteiInfoMockForBiz.TESTPATTERN3;
        BzLockProcessOutBean bzLockProcessOutBean = new BzLockProcessOutBean();

        String pKouteiKanriId = "10000000001";
        String pJimuTetuzukiCd = "001";
        BzLockProcess bzLockProcess = SWAKInjector.getInstance(BzLockProcess.class);
        bzLockProcessOutBean = bzLockProcess.exec(pKouteiKanriId, pJimuTetuzukiCd);

        exClassificationEquals(bzLockProcessOutBean.getKouteiLockKekkaKbn(), C_KouteiLockKekkaKbn.FAILURE_SELF, "工程ロック結果区分");
    }

    @Test(expected = BizAppException.class)
    @TestOrder(110)
    public void testExec_A11() {

        MockObjectManager.initialize();
        IwfKouteiClientMockForBiz.mode = "dl33-09";
        GetSyoriKokouteiInfoMockForBiz.mode  = GetSyoriKokouteiInfoMockForBiz.TESTPATTERN3;

        String pKouteiKanriId = "10000000001";
        String pJimuTetuzukiCd = "001";
        try {
            BzLockProcess bzLockProcess = SWAKInjector.getInstance(BzLockProcess.class);
            bzLockProcess.exec(pKouteiKanriId, pJimuTetuzukiCd);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "IWFエラーです。機能＝業務共通工程ロック開始、API＝工程ロック開始、エラーコード＝IWF2094", "エラーメッセージ");
            throw e;
        }
    }

    @Test()
    @TestOrder(120)
    public void testExec_B1() {

        MockObjectManager.initialize();
        IwfKouteiClientMockForBiz.mode = "dl33-01";
        BzLockProcessOutBean bzLockProcessOutBean = new BzLockProcessOutBean();

        String pKouteiKanriId = "10000000001";
        String pJimuTetuzukiCd = "001";
        String pKouteiLockKey = "key001";
        BzLockProcess bzLockProcess = SWAKInjector.getInstance(BzLockProcess.class);
        bzLockProcessOutBean = bzLockProcess.exec(pKouteiKanriId, pJimuTetuzukiCd, pKouteiLockKey);

        exClassificationEquals(bzLockProcessOutBean.getKouteiLockKekkaKbn(), C_KouteiLockKekkaKbn.SUCCESS, "工程ロック結果区分");
        LockProcessInBean processUpdateInBean = (LockProcessInBean)MockObjectManager.getArgument(IwfKouteiClientMockForBiz.class, "execLockProcess", 0, 0);
        exStringEquals(processUpdateInBean.getGyoumukey(), "10000000001", "工程管理ID");
        exStringEquals(processUpdateInBean.getFlowid(), "001", "事務手続コード ");
        exStringEquals(processUpdateInBean.getLockkey(), "key001", "工程ロックキー");
    }

    @Test(expected = BizAppException.class)
    @TestOrder(130)
    public void testExec_B2() {

        MockObjectManager.initialize();
        IwfKouteiClientMockForBiz.mode = "dl33-01";
        GetSyoriKokouteiInfoMockForBiz.mode  = GetSyoriKokouteiInfoMockForBiz.TESTPATTERN1;
        String pKouteiKanriId = "10000000001";
        String pJimuTetuzukiCd = "001";

        String pKouteiLockKey = "key001";
        try {
            BzLockProcess bzLockProcess = SWAKInjector.getInstance(BzLockProcess.class);
            bzLockProcess.exec(pKouteiKanriId, pJimuTetuzukiCd, pKouteiLockKey);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "同一事務手続内の処理中子工程件数が不正です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test()
    @TestOrder(140)
    public void testExec_B3() {

        MockObjectManager.initialize();
        IwfKouteiClientMockForBiz.mode = "dl33-01";
        GetSyoriKokouteiInfoMockForBiz.mode  = GetSyoriKokouteiInfoMockForBiz.TESTPATTERN2;
        BzLockProcessOutBean bzLockProcessOutBean = new BzLockProcessOutBean();

        String pKouteiKanriId = "10000000001";
        String pJimuTetuzukiCd = "001";
        String pKouteiLockKey = "key001";
        BzLockProcess bzLockProcess = SWAKInjector.getInstance(BzLockProcess.class);
        bzLockProcessOutBean = bzLockProcess.exec(pKouteiKanriId, pJimuTetuzukiCd, pKouteiLockKey);

        exClassificationEquals(bzLockProcessOutBean.getKouteiLockKekkaKbn(), C_KouteiLockKekkaKbn.SUCCESS, "工程ロック結果区分");
    }

    @Test
    @TestOrder(150)
    public void testExec_B4() {

        MockObjectManager.initialize();
        IwfKouteiClientMockForBiz.mode = "dl33-02";
        GetSyoriKokouteiInfoMockForBiz.mode  = GetSyoriKokouteiInfoMockForBiz.TESTPATTERN2;
        BzLockProcessOutBean bzLockProcessOutBean = new BzLockProcessOutBean();

        String pKouteiKanriId = "10000000001";
        String pJimuTetuzukiCd = "001";
        String pKouteiLockKey = "key001";
        BzLockProcess bzLockProcess = SWAKInjector.getInstance(BzLockProcess.class);
        bzLockProcessOutBean = bzLockProcess.exec(pKouteiKanriId, pJimuTetuzukiCd, pKouteiLockKey);

        exClassificationEquals(bzLockProcessOutBean.getKouteiLockKekkaKbn(), C_KouteiLockKekkaKbn.SUCCESS, "工程ロック結果区分");

        LockProcessInBean processUpdateInBean2 = (LockProcessInBean)MockObjectManager.getArgument(IwfKouteiClientMockForBiz.class, "execLockProcess", 2, 0);
        exStringEquals(processUpdateInBean2.getGyoumukey(), "10000000002", "工程管理ID");
        exStringEquals(processUpdateInBean2.getFlowid(), "002", "事務手続コード ");
        exStringEquals(processUpdateInBean2.getLockkey(), "key001", "工程ロックキー");
    }
    @Test
    @TestOrder(160)
    public void testExec_B5() {

        MockObjectManager.initialize();
        IwfKouteiClientMockForBiz.mode = "dl33-03";
        GetSyoriKokouteiInfoMockForBiz.mode  = GetSyoriKokouteiInfoMockForBiz.TESTPATTERN2;
        BzLockProcessOutBean bzLockProcessOutBean = new BzLockProcessOutBean();

        String pKouteiKanriId = "10000000001";
        String pJimuTetuzukiCd = "001";
        String pKouteiLockKey = "key001";
        BzLockProcess bzLockProcess = SWAKInjector.getInstance(BzLockProcess.class);
        bzLockProcessOutBean = bzLockProcess.exec(pKouteiKanriId, pJimuTetuzukiCd, pKouteiLockKey);

        exClassificationEquals(bzLockProcessOutBean.getKouteiLockKekkaKbn(), C_KouteiLockKekkaKbn.FAILURE_CHILD,
            "工程ロック結果区分");
        exStringEquals((String)MockObjectManager.getArgument(BzUnlockProcessMockForBiz.class, "exec", 0, 0), "10000000001", "工程管理ID");
        exStringEquals((String)MockObjectManager.getArgument(BzUnlockProcessMockForBiz.class, "exec", 0, 1), "001", "事務手続コード");
        exStringEquals((String)MockObjectManager.getArgument(BzUnlockProcessMockForBiz.class, "exec", 0, 2), "key001", "工程ロックキー");
    }

    @Test
    @TestOrder(170)
    public void testExec_B6() {

        MockObjectManager.initialize();
        IwfKouteiClientMockForBiz.mode = "dl33-04";
        GetSyoriKokouteiInfoMockForBiz.mode  = GetSyoriKokouteiInfoMockForBiz.TESTPATTERN2;
        BzLockProcessOutBean bzLockProcessOutBean = new BzLockProcessOutBean();

        String pKouteiKanriId = "10000000001";
        String pJimuTetuzukiCd = "001";
        String pKouteiLockKey = "key001";
        BzLockProcess bzLockProcess = SWAKInjector.getInstance(BzLockProcess.class);
        bzLockProcessOutBean = bzLockProcess.exec(pKouteiKanriId, pJimuTetuzukiCd, pKouteiLockKey);

        exClassificationEquals(bzLockProcessOutBean.getKouteiLockKekkaKbn(), C_KouteiLockKekkaKbn.FAILURE_CHILD,
            "工程ロック結果区分");
        exStringEquals((String)MockObjectManager.getArgument(BzUnlockProcessMockForBiz.class, "exec", 0, 0), "10000000001", "工程管理ID");
        exStringEquals((String)MockObjectManager.getArgument(BzUnlockProcessMockForBiz.class, "exec", 0, 1), "001", "事務手続コード");
        exStringEquals((String)MockObjectManager.getArgument(BzUnlockProcessMockForBiz.class, "exec", 0, 2), "key001", "工程ロックキー");
    }

    @Test(expected = BizAppException.class)
    @TestOrder(180)
    public void testExec_B7() {

        MockObjectManager.initialize();
        IwfKouteiClientMockForBiz.mode = "dl33-05";
        GetSyoriKokouteiInfoMockForBiz.mode  = GetSyoriKokouteiInfoMockForBiz.TESTPATTERN2;
        String pKouteiKanriId = "10000000001";
        String pJimuTetuzukiCd = "001";
        String pKouteiLockKey = "key001";
        try {
            BzLockProcess bzLockProcess = SWAKInjector.getInstance(BzLockProcess.class);
            bzLockProcess.exec(pKouteiKanriId, pJimuTetuzukiCd, pKouteiLockKey);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "IWFエラーです。機能＝業務共通工程ロック開始、API＝工程ロック開始、エラーコード＝IWF2094", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(190)
    public void testExec_B8() {

        MockObjectManager.initialize();
        IwfKouteiClientMockForBiz.mode = "dl33-06";
        GetSyoriKokouteiInfoMockForBiz.mode  = GetSyoriKokouteiInfoMockForBiz.TESTPATTERN3;
        BzLockProcessOutBean bzLockProcessOutBean = new BzLockProcessOutBean();
        String pKouteiKanriId = "10000000001";
        String pJimuTetuzukiCd = "001";

        String pKouteiLockKey = "key001";
        BzLockProcess bzLockProcess = SWAKInjector.getInstance(BzLockProcess.class);
        bzLockProcessOutBean = bzLockProcess.exec(pKouteiKanriId, pJimuTetuzukiCd, pKouteiLockKey);
        exClassificationEquals(bzLockProcessOutBean.getKouteiLockKekkaKbn(), C_KouteiLockKekkaKbn.SUCCESS, "工程ロック結果区分");
    }

    @Test
    @TestOrder(200)
    public void testExec_B9() {

        MockObjectManager.initialize();
        IwfKouteiClientMockForBiz.mode = "dl33-07";
        GetSyoriKokouteiInfoMockForBiz.mode  = GetSyoriKokouteiInfoMockForBiz.TESTPATTERN3;
        BzLockProcessOutBean bzLockProcessOutBean = new BzLockProcessOutBean();

        String pKouteiKanriId = "10000000001";
        String pJimuTetuzukiCd = "001";
        String pKouteiLockKey = "key001";
        BzLockProcess bzLockProcess = SWAKInjector.getInstance(BzLockProcess.class);
        bzLockProcessOutBean = bzLockProcess.exec(pKouteiKanriId, pJimuTetuzukiCd, pKouteiLockKey);

        exClassificationEquals(bzLockProcessOutBean.getKouteiLockKekkaKbn(), C_KouteiLockKekkaKbn.FAILURE_SELF, "工程ロック結果区分");
    }
    @Test
    @TestOrder(210)
    public void testExec_B10() {

        MockObjectManager.initialize();
        IwfKouteiClientMockForBiz.mode = "dl33-08";
        GetSyoriKokouteiInfoMockForBiz.mode  = GetSyoriKokouteiInfoMockForBiz.TESTPATTERN3;
        BzLockProcessOutBean bzLockProcessOutBean = new BzLockProcessOutBean();

        String pKouteiKanriId = "10000000001";
        String pJimuTetuzukiCd = "001";
        String pKouteiLockKey = "key001";
        BzLockProcess bzLockProcess = SWAKInjector.getInstance(BzLockProcess.class);
        bzLockProcessOutBean = bzLockProcess.exec(pKouteiKanriId, pJimuTetuzukiCd, pKouteiLockKey);
        exClassificationEquals(bzLockProcessOutBean.getKouteiLockKekkaKbn(), C_KouteiLockKekkaKbn.FAILURE_SELF, "工程ロック結果区分");
    }

    @Test(expected = BizAppException.class)
    @TestOrder(220)
    public void testExec_B11() {

        MockObjectManager.initialize();
        IwfKouteiClientMockForBiz.mode = "dl33-09";
        GetSyoriKokouteiInfoMockForBiz.mode  = GetSyoriKokouteiInfoMockForBiz.TESTPATTERN3;

        String pKouteiKanriId = "10000000001";
        String pJimuTetuzukiCd = "001";
        String pKouteiLockKey = "key001";
        try {
            BzLockProcess bzLockProcess = SWAKInjector.getInstance(BzLockProcess.class);
            bzLockProcess.exec(pKouteiKanriId, pJimuTetuzukiCd, pKouteiLockKey);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "IWFエラーです。機能＝業務共通工程ロック開始、API＝工程ロック開始、エラーコード＝IWF2094", "エラーメッセージ");
            throw e;
        }
    }
}

