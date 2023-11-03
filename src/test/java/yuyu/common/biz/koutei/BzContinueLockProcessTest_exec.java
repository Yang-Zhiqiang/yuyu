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
import yuyu.common.biz.workflow.io.koutei.ContinueLockProcessInBean;
import yuyu.def.classification.C_KouteiLockKekkaKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 業務共通工程ロック継続のメソッド {@link BzContinueLockProcess#exec(String, String, String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzContinueLockProcessTest_exec {

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
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
        GetSyoriKokouteiInfoMockForBiz.caller = "Test";
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        IwfKouteiClientMockForBiz.caller = null;
        GetSyoriKokouteiInfoMockForBiz.caller = null;
        IwfKouteiClientMockForBiz.mode = null;
        GetSyoriKokouteiInfoMockForBiz.mode = null;
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {
        MockObjectManager.initialize();
        IwfKouteiClientMockForBiz.mode = "dl11-01";
        C_KouteiLockKekkaKbn kouteiLockKekkaKbn = null;

        String pKouteiKanriId = "10000000001";
        String pJimuTetuzukiCd = "001";
        String pKouteiLockKey = null;
        BzContinueLockProcess bzContinueLockProcess = SWAKInjector.getInstance(BzContinueLockProcess.class);
        kouteiLockKekkaKbn = bzContinueLockProcess.exec(pKouteiKanriId, pJimuTetuzukiCd, pKouteiLockKey);

        exClassificationEquals(kouteiLockKekkaKbn, C_KouteiLockKekkaKbn.SUCCESS, "工程ロック結果区分");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {
        MockObjectManager.initialize();
        IwfKouteiClientMockForBiz.mode = "dl11-01";
        C_KouteiLockKekkaKbn kouteiLockKekkaKbn = null;
        String pKouteiKanriId = "10000000001";
        String pJimuTetuzukiCd = "001";
        String pKouteiLockKey = "";
        BzContinueLockProcess bzContinueLockProcess = SWAKInjector.getInstance(BzContinueLockProcess.class);
        kouteiLockKekkaKbn = bzContinueLockProcess.exec(pKouteiKanriId, pJimuTetuzukiCd, pKouteiLockKey);

        exClassificationEquals(kouteiLockKekkaKbn, C_KouteiLockKekkaKbn.SUCCESS, "工程ロック結果区分");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {
        MockObjectManager.initialize();
        IwfKouteiClientMockForBiz.mode = "dl11-01";
        GetSyoriKokouteiInfoMockForBiz.mode = GetSyoriKokouteiInfoMockForBiz.TESTPATTERN6;
        C_KouteiLockKekkaKbn kouteiLockKekkaKbn = null;
        String pKouteiKanriId = "10000000001";
        String pJimuTetuzukiCd = "001";
        String pKouteiLockKey = "110";
        BzContinueLockProcess bzContinueLockProcess = SWAKInjector.getInstance(BzContinueLockProcess.class);
        kouteiLockKekkaKbn = bzContinueLockProcess.exec(pKouteiKanriId, pJimuTetuzukiCd, pKouteiLockKey);

        exClassificationEquals(kouteiLockKekkaKbn, C_KouteiLockKekkaKbn.SUCCESS, "工程ロック結果区分");
    }

    @Test(expected = BizAppException.class)
    @TestOrder(40)
    public void testExec_A4() {
        MockObjectManager.initialize();
        IwfKouteiClientMockForBiz.mode = "dl11-01";
        GetSyoriKokouteiInfoMockForBiz.mode = GetSyoriKokouteiInfoMockForBiz.TESTPATTERN1;

        String pKouteiKanriId = "10000000001";
        String pJimuTetuzukiCd = "001";
        String pKouteiLockKey = "110";

        try {
            BzContinueLockProcess bzContinueLockProcess = SWAKInjector.getInstance(BzContinueLockProcess.class);
            bzContinueLockProcess.exec(pKouteiKanriId, pJimuTetuzukiCd, pKouteiLockKey);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "同一事務手続内の処理中子工程件数が不正です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {
        IwfKouteiClientMockForBiz.mode = "dl11-01";
        GetSyoriKokouteiInfoMockForBiz.mode = GetSyoriKokouteiInfoMockForBiz.TESTPATTERN2;
        MockObjectManager.initialize();
        C_KouteiLockKekkaKbn kouteiLockKekkaKbn = null;

        String pKouteiKanriId = "10000000001";
        String pJimuTetuzukiCd = "001";
        String pKouteiLockKey = "110";
        BzContinueLockProcess bzContinueLockProcess = SWAKInjector.getInstance(BzContinueLockProcess.class);
        kouteiLockKekkaKbn = bzContinueLockProcess.exec(pKouteiKanriId, pJimuTetuzukiCd, pKouteiLockKey);

        exClassificationEquals(kouteiLockKekkaKbn, C_KouteiLockKekkaKbn.SUCCESS, "工程ロック結果区分");

        ContinueLockProcessInBean continueLockProcessInBean1= (ContinueLockProcessInBean)MockObjectManager.getArgument(IwfKouteiClientMockForBiz.class, "execContinueLockProcess", 0, 0);
        ContinueLockProcessInBean continueLockProcessInBean2= (ContinueLockProcessInBean)MockObjectManager.getArgument(IwfKouteiClientMockForBiz.class, "execContinueLockProcess", 1, 0);
        exStringEquals(continueLockProcessInBean1.getGyoumukey(), "10000000001", "業務キー");
        exStringEquals(continueLockProcessInBean1.getFlowid(), "001", "フローID");
        exStringEquals(continueLockProcessInBean1.getLockkey(), "110", "ロックキー");
        exStringEquals(continueLockProcessInBean2.getGyoumukey(), "hijklmn1", "業務キー");
        exStringEquals(continueLockProcessInBean2.getFlowid(), "hzn1", "フローID");
        exStringEquals(continueLockProcessInBean2.getLockkey(), "110", "ロックキー");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {
        MockObjectManager.initialize();
        IwfKouteiClientMockForBiz.mode = "dl11-02";
        GetSyoriKokouteiInfoMockForBiz.mode = GetSyoriKokouteiInfoMockForBiz.TESTPATTERN2;
        C_KouteiLockKekkaKbn kouteiLockKekkaKbn = null;

        String pKouteiKanriId = "10000000001";
        String pJimuTetuzukiCd = "001";
        String pKouteiLockKey = "110";
        BzContinueLockProcess bzContinueLockProcess = SWAKInjector.getInstance(BzContinueLockProcess.class);
        kouteiLockKekkaKbn = bzContinueLockProcess.exec(pKouteiKanriId, pJimuTetuzukiCd, pKouteiLockKey);

        exClassificationEquals(kouteiLockKekkaKbn, C_KouteiLockKekkaKbn.SUCCESS, "工程ロック結果区分");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {
        MockObjectManager.initialize();
        IwfKouteiClientMockForBiz.mode = "dl11-04";
        GetSyoriKokouteiInfoMockForBiz.mode = GetSyoriKokouteiInfoMockForBiz.TESTPATTERN2;
        C_KouteiLockKekkaKbn kouteiLockKekkaKbn = null;

        String pKouteiKanriId = "10000000001";
        String pJimuTetuzukiCd = "001";
        String pKouteiLockKey = "110";
        BzContinueLockProcess bzContinueLockProcess = SWAKInjector.getInstance(BzContinueLockProcess.class);
        kouteiLockKekkaKbn = bzContinueLockProcess.exec(pKouteiKanriId, pJimuTetuzukiCd, pKouteiLockKey);

        exClassificationEquals(kouteiLockKekkaKbn, C_KouteiLockKekkaKbn.FAILURE_CHILD, "工程ロック結果区分");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {
        MockObjectManager.initialize();
        IwfKouteiClientMockForBiz.mode = "dl11-05";
        GetSyoriKokouteiInfoMockForBiz.mode = GetSyoriKokouteiInfoMockForBiz.TESTPATTERN2;
        C_KouteiLockKekkaKbn kouteiLockKekkaKbn = null;

        String pKouteiKanriId = "10000000001";
        String pJimuTetuzukiCd = "001";
        String pKouteiLockKey = "110";
        BzContinueLockProcess bzContinueLockProcess = SWAKInjector.getInstance(BzContinueLockProcess.class);
        kouteiLockKekkaKbn = bzContinueLockProcess.exec(pKouteiKanriId, pJimuTetuzukiCd, pKouteiLockKey);

        exClassificationEquals(kouteiLockKekkaKbn, C_KouteiLockKekkaKbn.FAILURE_CHILD, "工程ロック結果区分");
    }

    @Test(expected = BizAppException.class)
    @TestOrder(100)
    public void testExec_A10() {
        MockObjectManager.initialize();
        IwfKouteiClientMockForBiz.mode = "dl11-06";
        GetSyoriKokouteiInfoMockForBiz.mode = GetSyoriKokouteiInfoMockForBiz.TESTPATTERN2;

        String pKouteiKanriId = "10000000001";
        String pJimuTetuzukiCd = "001";
        String pKouteiLockKey = "110";
        try {
            BzContinueLockProcess bzContinueLockProcess = SWAKInjector.getInstance(BzContinueLockProcess.class);
            bzContinueLockProcess.exec(pKouteiKanriId, pJimuTetuzukiCd, pKouteiLockKey);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "IWFエラーです。機能＝業務共通工程ロック継続、API＝工程ロック継続、エラーコード＝IWF2094", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {
        MockObjectManager.initialize();
        IwfKouteiClientMockForBiz.mode = "dl11-07";
        GetSyoriKokouteiInfoMockForBiz.mode = GetSyoriKokouteiInfoMockForBiz.TESTPATTERN3;
        C_KouteiLockKekkaKbn kouteiLockKekkaKbn = null;
        String pKouteiKanriId = "10000000001";
        String pJimuTetuzukiCd = "001";
        String pKouteiLockKey = "110";
        BzContinueLockProcess bzContinueLockProcess = SWAKInjector.getInstance(BzContinueLockProcess.class);
        kouteiLockKekkaKbn = bzContinueLockProcess.exec(pKouteiKanriId, pJimuTetuzukiCd, pKouteiLockKey);

        exClassificationEquals(kouteiLockKekkaKbn, C_KouteiLockKekkaKbn.SUCCESS, "工程ロック結果区分");
    }

    @Test
    @TestOrder(130)
    public void testExec_A13() {
        MockObjectManager.initialize();
        IwfKouteiClientMockForBiz.mode = "dl11-09";
        GetSyoriKokouteiInfoMockForBiz.mode = GetSyoriKokouteiInfoMockForBiz.TESTPATTERN4;
        C_KouteiLockKekkaKbn kouteiLockKekkaKbn = null;
        String pKouteiKanriId = "10000000001";
        String pJimuTetuzukiCd = "001";
        String pKouteiLockKey = "110";
        BzContinueLockProcess bzContinueLockProcess = SWAKInjector.getInstance(BzContinueLockProcess.class);
        kouteiLockKekkaKbn = bzContinueLockProcess.exec(pKouteiKanriId, pJimuTetuzukiCd, pKouteiLockKey);

        exClassificationEquals(kouteiLockKekkaKbn, C_KouteiLockKekkaKbn.FAILURE_SELF, "工程ロック結果区分");
    }

    @Test
    @TestOrder(140)
    public void testExec_A14() {
        MockObjectManager.initialize();
        IwfKouteiClientMockForBiz.mode = "dl11-10";
        GetSyoriKokouteiInfoMockForBiz.mode = GetSyoriKokouteiInfoMockForBiz.TESTPATTERN4;
        C_KouteiLockKekkaKbn kouteiLockKekkaKbn = null;
        String pKouteiKanriId = "10000000001";
        String pJimuTetuzukiCd = "001";
        String pKouteiLockKey = "110";
        BzContinueLockProcess bzContinueLockProcess = SWAKInjector.getInstance(BzContinueLockProcess.class);
        kouteiLockKekkaKbn = bzContinueLockProcess.exec(pKouteiKanriId, pJimuTetuzukiCd, pKouteiLockKey);

        exClassificationEquals(kouteiLockKekkaKbn, C_KouteiLockKekkaKbn.FAILURE_SELF, "工程ロック結果区分");
    }

    @Test(expected = BizAppException.class)
    @TestOrder(150)
    public void testExec_A15() {
        MockObjectManager.initialize();
        IwfKouteiClientMockForBiz.mode = "dl11-11";
        GetSyoriKokouteiInfoMockForBiz.mode = GetSyoriKokouteiInfoMockForBiz.TESTPATTERN4;

        String pKouteiKanriId = "10000000001";
        String pJimuTetuzukiCd = "001";
        String pKouteiLockKey = "110";
        try {
            BzContinueLockProcess bzContinueLockProcess = SWAKInjector.getInstance(BzContinueLockProcess.class);
            bzContinueLockProcess.exec(pKouteiKanriId, pJimuTetuzukiCd, pKouteiLockKey);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "IWFエラーです。機能＝業務共通工程ロック継続、API＝工程ロック継続、エラーコード＝IWF2094", "エラーメッセージ");
            throw e;
        }
    }
}
