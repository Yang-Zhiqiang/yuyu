package yuyu.common.biz.koutei;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.workflow.IwfKouteiClient;
import yuyu.common.biz.workflow.IwfKouteiClientMockForBiz;
import yuyu.common.biz.workflow.io.koutei.StartTaskInBean;
import yuyu.common.biz.workflow.io.koutei.UnassignTaskInBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 業務共通強制タスク開始クラスのメソッド {@link BzForceTaskStart#exec(String, String, String, String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzForceTaskStartTest_exec {

    @Inject
    private BaseUserInfo baseUserInfo;

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(IwfKouteiClient.class).to(IwfKouteiClientMockForBiz.class);
                bind(BzGetProcessSummary.class).to(BzGetProcessSummaryMockForBiz.class);
                bind(BzForceProcessForward.class).to(BzForceProcessForwardMockForBiz.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        IwfKouteiClientMockForBiz.caller = "Test";
        BzGetProcessSummaryMockForBiz.caller = BzForceTaskStartTest_exec.class;
        BzForceProcessForwardMockForBiz.caller = BzForceTaskStartTest_exec.class;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForBiz.caller = null;
        IwfKouteiClientMockForBiz.caller = null;
        BzForceProcessForwardMockForBiz.caller = null;

        BzGetProcessSummaryMockForBiz.SYORIPTN = null;
        IwfKouteiClientMockForBiz.mode = null;
        BzForceProcessForwardMockForBiz.SYORIPTN = null;
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {
        MockObjectManager.initialize();
        IwfKouteiClientMockForBiz.mode = "dl01-13";
        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN1;
        String pKouteiKanriId = "1001";
        String pJimuTetuzukiCd = "2001";
        String pTaskId = "3001";
        String pKouteiLockKey = "4001";

        BzForceTaskStart bzForceTaskStart = SWAKInjector.getInstance(BzForceTaskStart.class);
        bzForceTaskStart.exec(pKouteiKanriId, pJimuTetuzukiCd, pTaskId, pKouteiLockKey);
        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForBiz.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean.getKouteiKanriId(), "1001", "工程管理ID");
        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), "2001", "事務手続コード");
    }

    @Test(expected = BizAppException.class)
    @TestOrder(20)
    public void testExec_A2() {
        MockObjectManager.initialize();
        IwfKouteiClientMockForBiz.mode = "dl01-09";
        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN2;
        BzForceProcessForwardMockForBiz.SYORIPTN = BzForceProcessForwardMockForBiz.TESTPATTERN1;
        String pKouteiKanriId = "1001";
        String pJimuTetuzukiCd = "2001";
        String pTaskId = "3002";
        String pKouteiLockKey = "4001";
        try {
            BzForceTaskStart bzForceTaskStart = SWAKInjector.getInstance(BzForceTaskStart.class);
            bzForceTaskStart.exec(pKouteiKanriId, pJimuTetuzukiCd, pTaskId, pKouteiLockKey);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "IWFエラーです。機能＝業務共通強制タスク開始、API＝タスク開始、エラーコード＝IWF0005", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {
        MockObjectManager.initialize();
        IwfKouteiClientMockForBiz.mode = "dl01-10";
        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN2;
        String pKouteiKanriId = "1001";
        String pJimuTetuzukiCd = "2001";
        String pTaskId = "3001";
        String pKouteiLockKey = "4001";

        BzForceTaskStart bzForceTaskStart = SWAKInjector.getInstance(BzForceTaskStart.class);
        bzForceTaskStart.exec(pKouteiKanriId, pJimuTetuzukiCd, pTaskId, pKouteiLockKey);
        StartTaskInBean startTaskInBean = (StartTaskInBean) MockObjectManager
            .getArgument(IwfKouteiClientMockForBiz.class, "execStartTask", 0, 0);
        exStringEquals(startTaskInBean.getGyoumukey(), "1001", "業務キー");
        exStringEquals(startTaskInBean.getFlowid(), "2001", "フローID");
        exStringEquals(startTaskInBean.getAccountid(), "JUnit", "アカウントID");
        exStringEquals(startTaskInBean.getTaskname(), "3001", "タスク名");
        exStringEquals(startTaskInBean.getLockkey(), "4001", "ロック");
    }

    @Test(expected = BizAppException.class)
    @TestOrder(40)
    public void testExec_A4() {
        MockObjectManager.initialize();
        IwfKouteiClientMockForBiz.mode = "dl01-09";
        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN2;
        BzForceProcessForwardMockForBiz.SYORIPTN = BzForceProcessForwardMockForBiz.TESTPATTERN1;
        String pKouteiKanriId = "1001";
        String pJimuTetuzukiCd = "2001";
        String pTaskId = "3002";
        String pKouteiLockKey = "4001";
        try {
            BzForceTaskStart bzForceTaskStart = SWAKInjector.getInstance(BzForceTaskStart.class);
            bzForceTaskStart.exec(pKouteiKanriId, pJimuTetuzukiCd, pTaskId, pKouteiLockKey);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "IWFエラーです。機能＝業務共通強制タスク開始、API＝タスク開始、エラーコード＝IWF0005", "エラーメッセージ");
            throw e;
        }
    }

    @Test()
    @TestOrder(50)
    public void testExec_A5() {

        baseUserInfo.getUser().setUserId("JUnit");

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN3;
        String pKouteiKanriId = "1001";
        String pJimuTetuzukiCd = "2001";
        String pTaskId = "3001";
        String pKouteiLockKey = "4001";

        BzForceTaskStart bzForceTaskStart = SWAKInjector.getInstance(BzForceTaskStart.class);
        bzForceTaskStart.exec(pKouteiKanriId, pJimuTetuzukiCd, pTaskId, pKouteiLockKey);
    }

    @Test()
    @TestOrder(60)
    public void testExec_A6() {

        baseUserInfo.getUser().setUserId("JUnit");

        MockObjectManager.initialize();
        IwfKouteiClientMockForBiz.mode = "dl01-10";
        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN4;
        String pKouteiKanriId = "1001";
        String pJimuTetuzukiCd = "2001";
        String pTaskId = "3001";
        String pKouteiLockKey = "4001";

        BzForceTaskStart bzForceTaskStart = SWAKInjector.getInstance(BzForceTaskStart.class);
        bzForceTaskStart.exec(pKouteiKanriId, pJimuTetuzukiCd, pTaskId, pKouteiLockKey);
        UnassignTaskInBean unassignTaskInBean = (UnassignTaskInBean) MockObjectManager
            .getArgument(IwfKouteiClientMockForBiz.class, "execUnsignTask", 0, 0);
        exStringEquals(unassignTaskInBean.getGyoumukey(), "1001", "業務キー");
        exStringEquals(unassignTaskInBean.getFlowid(), "2001", "フローID");
        exStringEquals(unassignTaskInBean.getAccountid(), "123", "アカウントID");
        exStringEquals(unassignTaskInBean.getRirekiaccountid(), "JUnit", "履歴用アカウントID");
        exStringEquals(unassignTaskInBean.getLockkey(), "4001", "ロック");
    }

    @Test(expected = BizAppException.class)
    @TestOrder(70)
    public void testExec_A7() {

        baseUserInfo.getUser().setUserId("JUnit");

        MockObjectManager.initialize();
        IwfKouteiClientMockForBiz.mode = "06-02";
        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN4;
        String pKouteiKanriId = "1001";
        String pJimuTetuzukiCd = "2001";
        String pTaskId = "3001";
        String pKouteiLockKey = "4001";
        try {
            BzForceTaskStart bzForceTaskStart = SWAKInjector.getInstance(BzForceTaskStart.class);
            bzForceTaskStart.exec(pKouteiKanriId, pJimuTetuzukiCd, pTaskId, pKouteiLockKey);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "IWFエラーです。機能＝業務共通強制タスク開始、API＝割当解除、エラーコード＝IWF0006", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizAppException.class)
    @TestOrder(80)
    public void testExec_A8() {
        MockObjectManager.initialize();
        IwfKouteiClientMockForBiz.mode = "dl01-11";
        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN4;
        BzForceProcessForwardMockForBiz.SYORIPTN = BzForceProcessForwardMockForBiz.TESTPATTERN1;
        String pKouteiKanriId = "1001";
        String pJimuTetuzukiCd = "2001";
        String pTaskId = "3002";
        String pKouteiLockKey = "4001";
        try {
            BzForceTaskStart bzForceTaskStart = SWAKInjector.getInstance(BzForceTaskStart.class);
            bzForceTaskStart.exec(pKouteiKanriId, pJimuTetuzukiCd, pTaskId, pKouteiLockKey);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "IWFエラーです。機能＝業務共通強制タスク開始、API＝タスク開始、エラーコード＝IWF0006", "エラーメッセージ");
            throw e;
        }
    }
}
