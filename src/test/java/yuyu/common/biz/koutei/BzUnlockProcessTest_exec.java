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
import yuyu.common.biz.workflow.io.koutei.UnlockProcessInBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 業務共通工程ロック解除クラスのメソッド {@link BzUnlockProcess#exec(String, String, String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzUnlockProcessTest_exec {

    @Before
    public void Before () {
        MockModuleBinder.bind(new AbstractModule() {
            @Override
            protected void configure() {
                bind(IwfKouteiClient.class).to(IwfKouteiClientMockForBiz.class);
                bind(GetSyoriKokouteiInfo.class).to(GetSyoriKokouteiInfoMockForBiz.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        IwfKouteiClientMockForBiz.caller = "Test";
        GetSyoriKokouteiInfoMockForBiz.caller = "Test01";
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        IwfKouteiClientMockForBiz.caller = null;
        GetSyoriKokouteiInfoMockForBiz.caller = null;
        IwfKouteiClientMockForBiz.mode = null;
        GetSyoriKokouteiInfoMockForBiz.mode = null;
    }

    @Test()
    @TestOrder(10)
    public void testExec_A1() {
        IwfKouteiClientMockForBiz.mode = "dl33-01";
        String pKouteiKanriId = "10000000001";
        String pJimuTetuzukiCd = "001";
        String pKouteiLockKey = null;
        BzUnlockProcess bzUnlockProcess = SWAKInjector.getInstance(BzUnlockProcess.class);
        bzUnlockProcess.exec(pKouteiKanriId, pJimuTetuzukiCd, pKouteiLockKey);
    }

    @Test()
    @TestOrder(20)
    public void testExec_A2() {
        IwfKouteiClientMockForBiz.mode = "dl33-01";
        String pKouteiKanriId = "10000000001";
        String pJimuTetuzukiCd = "001";
        String pKouteiLockKey = "";
        BzUnlockProcess bzUnlockProcess = SWAKInjector.getInstance(BzUnlockProcess.class);
        bzUnlockProcess.exec(pKouteiKanriId, pJimuTetuzukiCd, pKouteiLockKey);
    }

    @Test()
    @TestOrder(30)
    public void testExec_A3() {
        IwfKouteiClientMockForBiz.mode = "dl33-01";
        String pKouteiKanriId = "10000000001";
        String pJimuTetuzukiCd = "001";
        String pKouteiLockKey = "110";
        BzUnlockProcess bzUnlockProcess = SWAKInjector.getInstance(BzUnlockProcess.class);
        bzUnlockProcess.exec(pKouteiKanriId, pJimuTetuzukiCd, pKouteiLockKey);
    }

    @Test(expected = BizAppException.class)
    @TestOrder(40)
    public void testExec_A4() {
        IwfKouteiClientMockForBiz.mode = "dl33-01";
        GetSyoriKokouteiInfoMockForBiz.mode = GetSyoriKokouteiInfoMockForBiz.TESTPATTERN1;
        String pKouteiKanriId = "10000000001";
        String pJimuTetuzukiCd = "001";
        String pKouteiLockKey = "110";
        try {
            BzUnlockProcess bzUnlockProcess = SWAKInjector.getInstance(BzUnlockProcess.class);
            bzUnlockProcess.exec(pKouteiKanriId, pJimuTetuzukiCd, pKouteiLockKey);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "同一事務手続内の処理中子工程件数が不正です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test()
    @TestOrder(50)
    public void testExec_A5() {
        IwfKouteiClientMockForBiz.mode = "dl33-01";
        GetSyoriKokouteiInfoMockForBiz.mode = GetSyoriKokouteiInfoMockForBiz.TESTPATTERN2;
        MockObjectManager.initialize();
        String pKouteiKanriId = "10000000001";
        String pJimuTetuzukiCd = "001";
        String pKouteiLockKey = "110";
        BzUnlockProcess bzUnlockProcess = SWAKInjector.getInstance(BzUnlockProcess.class);
        bzUnlockProcess.exec(pKouteiKanriId, pJimuTetuzukiCd, pKouteiLockKey);
        String pKouteiKanriIdInput = (String) MockObjectManager.getArgument(GetSyoriKokouteiInfoMockForBiz.class,
            "exec", 0, 0);
        String pJimuTetuzukiCdInput = (String) MockObjectManager.getArgument(GetSyoriKokouteiInfoMockForBiz.class,
            "exec", 0, 1);
        exStringEquals(pKouteiKanriIdInput, "10000000001", "工程管理ID");
        exStringEquals(pJimuTetuzukiCdInput, "001", "事務手続コード");
        UnlockProcessInBean processUpdateInBean = (UnlockProcessInBean) MockObjectManager.getArgument(
            IwfKouteiClientMockForBiz.class, "execUnlockProcess", 0, 0);
        exStringEquals(processUpdateInBean.getGyoumukey(), "10000000002", "工程管理ID");
        exStringEquals(processUpdateInBean.getFlowid(), "002", "事務手続コード");
        exStringEquals(processUpdateInBean.getLockkey(), "110", "工程ロックキー");
        UnlockProcessInBean processUpdateInBean1 = (UnlockProcessInBean) MockObjectManager.getArgument(
            IwfKouteiClientMockForBiz.class, "execUnlockProcess", 1, 0);
        exStringEquals(processUpdateInBean1.getGyoumukey(), "10000000001", "工程管理ID");
        exStringEquals(processUpdateInBean1.getFlowid(), "001", "事務手続コード");
        exStringEquals(processUpdateInBean1.getLockkey(), "110", "工程ロックキー");
    }

    @Test()
    @TestOrder(60)
    public void testExec_A6() {
        IwfKouteiClientMockForBiz.mode = "dl33-02";
        GetSyoriKokouteiInfoMockForBiz.mode = GetSyoriKokouteiInfoMockForBiz.TESTPATTERN2;
        String pKouteiKanriId = "10000000001";
        String pJimuTetuzukiCd = "001";
        String pKouteiLockKey = "110";
        BzUnlockProcess bzUnlockProcess = SWAKInjector.getInstance(BzUnlockProcess.class);
        bzUnlockProcess.exec(pKouteiKanriId, pJimuTetuzukiCd, pKouteiLockKey);
    }

    @Test()
    @TestOrder(70)
    public void testExec_A7() {
        IwfKouteiClientMockForBiz.mode = "dl33-03";
        GetSyoriKokouteiInfoMockForBiz.mode = GetSyoriKokouteiInfoMockForBiz.TESTPATTERN2;
        String pKouteiKanriId = "10000000001";
        String pJimuTetuzukiCd = "001";
        String pKouteiLockKey = "110";
        BzUnlockProcess bzUnlockProcess = SWAKInjector.getInstance(BzUnlockProcess.class);
        bzUnlockProcess.exec(pKouteiKanriId, pJimuTetuzukiCd, pKouteiLockKey);
    }

    @Test()
    @TestOrder(80)
    public void testExec_A8() {
        IwfKouteiClientMockForBiz.mode = "dl33-04";
        GetSyoriKokouteiInfoMockForBiz.mode = GetSyoriKokouteiInfoMockForBiz.TESTPATTERN2;
        String pKouteiKanriId = "10000000001";
        String pJimuTetuzukiCd = "001";
        String pKouteiLockKey = "110";
        BzUnlockProcess bzUnlockProcess = SWAKInjector.getInstance(BzUnlockProcess.class);
        bzUnlockProcess.exec(pKouteiKanriId, pJimuTetuzukiCd, pKouteiLockKey);
    }

    @Test()
    @TestOrder(90)
    public void testExec_A9() {
        IwfKouteiClientMockForBiz.mode = "dl33-05";
        GetSyoriKokouteiInfoMockForBiz.mode = GetSyoriKokouteiInfoMockForBiz.TESTPATTERN2;
        String pKouteiKanriId = "10000000001";
        String pJimuTetuzukiCd = "001";
        String pKouteiLockKey = "110";
        BzUnlockProcess bzUnlockProcess = SWAKInjector.getInstance(BzUnlockProcess.class);
        bzUnlockProcess.exec(pKouteiKanriId, pJimuTetuzukiCd, pKouteiLockKey);
    }

    @Test(expected = BizAppException.class)
    @TestOrder(100)
    public void testExec_A10() {
        IwfKouteiClientMockForBiz.mode = "dl33-06";
        GetSyoriKokouteiInfoMockForBiz.mode = GetSyoriKokouteiInfoMockForBiz.TESTPATTERN2;
        String pKouteiKanriId = "10000000001";
        String pJimuTetuzukiCd = "001";
        String pKouteiLockKey = "110";
        try {
            BzUnlockProcess bzUnlockProcess = SWAKInjector.getInstance(BzUnlockProcess.class);
            bzUnlockProcess.exec(pKouteiKanriId, pJimuTetuzukiCd, pKouteiLockKey);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(),
                "IWFエラーです。機能＝業務共通工程ロック解除、API＝工程ロック解除、エラーコード＝IWF2105",
                "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {
        IwfKouteiClientMockForBiz.mode = "dl33-07";
        GetSyoriKokouteiInfoMockForBiz.mode = GetSyoriKokouteiInfoMockForBiz.TESTPATTERN3;
        String pKouteiKanriId = "10000000001";
        String pJimuTetuzukiCd = "001";
        String pKouteiLockKey = "110";
        BzUnlockProcess bzUnlockProcess = SWAKInjector.getInstance(BzUnlockProcess.class);
        bzUnlockProcess.exec(pKouteiKanriId, pJimuTetuzukiCd, pKouteiLockKey);
    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {
        IwfKouteiClientMockForBiz.mode = "dl33-08";
        GetSyoriKokouteiInfoMockForBiz.mode = GetSyoriKokouteiInfoMockForBiz.TESTPATTERN3;
        String pKouteiKanriId = "10000000001";
        String pJimuTetuzukiCd = "001";
        String pKouteiLockKey = "110";
        BzUnlockProcess bzUnlockProcess = SWAKInjector.getInstance(BzUnlockProcess.class);
        bzUnlockProcess.exec(pKouteiKanriId, pJimuTetuzukiCd, pKouteiLockKey);
    }

    @Test
    @TestOrder(130)
    public void testExec_A13() {
        IwfKouteiClientMockForBiz.mode = "dl33-09";
        GetSyoriKokouteiInfoMockForBiz.mode = GetSyoriKokouteiInfoMockForBiz.TESTPATTERN3;
        String pKouteiKanriId = "10000000001";
        String pJimuTetuzukiCd = "001";
        String pKouteiLockKey = "110";
        BzUnlockProcess bzUnlockProcess = SWAKInjector.getInstance(BzUnlockProcess.class);
        bzUnlockProcess.exec(pKouteiKanriId, pJimuTetuzukiCd, pKouteiLockKey);
    }

    @Test
    @TestOrder(140)
    public void testExec_A14() {
        IwfKouteiClientMockForBiz.mode = "dl33-10";
        GetSyoriKokouteiInfoMockForBiz.mode = GetSyoriKokouteiInfoMockForBiz.TESTPATTERN3;
        String pKouteiKanriId = "10000000001";
        String pJimuTetuzukiCd = "001";
        String pKouteiLockKey = "110";
        BzUnlockProcess bzUnlockProcess = SWAKInjector.getInstance(BzUnlockProcess.class);
        bzUnlockProcess.exec(pKouteiKanriId, pJimuTetuzukiCd, pKouteiLockKey);
    }

    @Test(expected = BizAppException.class)
    @TestOrder(150)
    public void testExec_A15() {
        IwfKouteiClientMockForBiz.mode = "dl33-11";
        GetSyoriKokouteiInfoMockForBiz.mode = GetSyoriKokouteiInfoMockForBiz.TESTPATTERN3;
        String pKouteiKanriId = "10000000001";
        String pJimuTetuzukiCd = "001";
        String pKouteiLockKey = "110";
        try {
            BzUnlockProcess bzUnlockProcess = SWAKInjector.getInstance(BzUnlockProcess.class);
            bzUnlockProcess.exec(pKouteiKanriId, pJimuTetuzukiCd, pKouteiLockKey);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(),
                "IWFエラーです。機能＝業務共通工程ロック解除、API＝工程ロック解除、エラーコード＝IWF2105",
                "エラーメッセージ");
            throw e;
        }
    }
}
