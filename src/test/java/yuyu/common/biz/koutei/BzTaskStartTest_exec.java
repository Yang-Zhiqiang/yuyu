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
import yuyu.def.classification.C_TskStartKekkaKbn;
import yuyu.def.db.entity.AM_User;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 業務共通タスク開始クラスのメソッド {@link BzTaskStart#exec(String, String, String, String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzTaskStartTest_exec {

    @Inject
    private BaseUserInfo baseUserInfo;

    @Before
    public void Before () {
        MockModuleBinder.bind(new AbstractModule() {
            @Override
            protected void configure() {
                bind(IwfKouteiClient.class).to(IwfKouteiClientMockForBiz.class);
                bind(BzGetProcessSummary.class).to(BzGetProcessSummaryMockForBiz.class);
            }
        });
    }

    @BeforeClass
    public static void testInit(){
        IwfKouteiClientMockForBiz.caller = "Test01";
        BzGetProcessSummaryMockForBiz.caller = BzTaskStartTest_exec.class;
    }

    @AfterClass
    public static void testClear() {

        MockObjectManager.initialize();

        IwfKouteiClientMockForBiz.caller = null;
        BzGetProcessSummaryMockForBiz.caller = null;

        IwfKouteiClientMockForBiz.mode = null;
        BzGetProcessSummaryMockForBiz.SYORIPTN = null;
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN1;
        String pKouteiKanriId = "";
        String pJimuTetuzukiCd = "";
        String pTaskId = "";
        String pKouteiLockKey = "";
        BzTaskStart bzTaskStart = SWAKInjector.getInstance(BzTaskStart.class);
        C_TskStartKekkaKbn tskStartKekkaKbn = bzTaskStart.exec(pKouteiKanriId, pJimuTetuzukiCd, pTaskId, pKouteiLockKey);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean1 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForBiz.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean1.getKouteiKanriId(), "", "工程管理ID");
        exStringEquals(bzGetProcessSummaryInBean1.getJimuTetuzukiCd(), "", "事務手続コード");
        exStringEquals(bzGetProcessSummaryInBean1.getTaskIds()[0], "","(配列)タスクID");
        exClassificationEquals(tskStartKekkaKbn, C_TskStartKekkaKbn.HUKA_STARTTSKNONE, "タスク開始結果区分");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {
        AM_User aMUser = new AM_User();
        aMUser.setUserId("JUnit");
        changeCurrentUser(baseUserInfo, aMUser);
        MockObjectManager.initialize();

        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN2;
        IwfKouteiClientMockForBiz.mode = "dl01-08";
        String pKouteiKanriId = "1001";
        String pJimuTetuzukiCd = "2001";
        String pTaskId = "3001";
        String pKouteiLockKey = "4001";

        BzTaskStart bzTaskStart = SWAKInjector.getInstance(BzTaskStart.class);
        C_TskStartKekkaKbn tskStartKekkaKbn = bzTaskStart
            .exec(pKouteiKanriId, pJimuTetuzukiCd, pTaskId, pKouteiLockKey);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean1 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForBiz.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean1.getKouteiKanriId(), "1001", "工程管理ID");
        exStringEquals(bzGetProcessSummaryInBean1.getJimuTetuzukiCd(), "2001", "事務手続コード");
        exStringEquals(bzGetProcessSummaryInBean1.getTaskIds()[0], "3001", "(配列)タスクID");

        StartTaskInBean startTaskInBean1 = (StartTaskInBean) MockObjectManager
            .getArgument(IwfKouteiClientMockForBiz.class, "execStartTask", 0, 0);
        exStringEquals(startTaskInBean1.getGyoumukey(), "1001", "業務キー");
        exStringEquals(startTaskInBean1.getFlowid(), "2001", "フローID");
        exStringEquals(startTaskInBean1.getAccountid(), "JUnit", "アカウントID");
        exStringEquals(startTaskInBean1.getTaskname(), "3001", "タスク名");
        exStringEquals(startTaskInBean1.getLockkey(), "4001", "ロックキー");
        exClassificationEquals(tskStartKekkaKbn, C_TskStartKekkaKbn.SEIJYOU, "タスク開始結果区分");
    }

    @Test(expected = BizAppException.class)
    @TestOrder(30)
    public void testExec_A3() {
        AM_User aMUser = new AM_User();
        aMUser.setUserId("JUnit");
        changeCurrentUser(baseUserInfo, aMUser);

        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN2;
        IwfKouteiClientMockForBiz.mode = "dl01-09";
        String pKouteiKanriId = "1001";
        String pJimuTetuzukiCd = "2001";
        String pTaskId = "3001";
        String pKouteiLockKey = "4001";

        try {

            BzTaskStart bzTaskStart = SWAKInjector.getInstance(BzTaskStart.class);
            bzTaskStart.exec(pKouteiKanriId, pJimuTetuzukiCd, pTaskId, pKouteiLockKey);

        } catch (BizAppException e) {
            exStringEquals(e.getMessage(),
                "IWFエラーです。機能＝業務共通工程タスク開始、API＝タスク開始、エラーコード＝IWF0005", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {
        AM_User aMUser = new AM_User();
        aMUser.setUserId("JUnit");
        changeCurrentUser(baseUserInfo, aMUser);
        MockObjectManager.initialize();

        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN3;
        IwfKouteiClientMockForBiz.mode = "dl01-10";
        String pKouteiKanriId = "1001";
        String pJimuTetuzukiCd = "2001";
        String pTaskId = "3001";
        String pKouteiLockKey = "4001";

        BzTaskStart bzTaskStart = SWAKInjector.getInstance(BzTaskStart.class);
        C_TskStartKekkaKbn tskStartKekkaKbn = bzTaskStart
            .exec(pKouteiKanriId, pJimuTetuzukiCd, pTaskId, pKouteiLockKey);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean1 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForBiz.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean1.getKouteiKanriId(), "1001", "工程管理ID");
        exStringEquals(bzGetProcessSummaryInBean1.getJimuTetuzukiCd(), "2001", "事務手続コード");
        exStringEquals(bzGetProcessSummaryInBean1.getTaskIds()[0], "3001", "(配列)タスクID");

        StartTaskInBean startTaskInBean1 = (StartTaskInBean) MockObjectManager
            .getArgument(IwfKouteiClientMockForBiz.class, "execStartTask", 0, 0);
        exStringEquals(startTaskInBean1.getGyoumukey(), "1001", "業務キー");
        exStringEquals(startTaskInBean1.getFlowid(), "2001", "フローID");
        exStringEquals(startTaskInBean1.getAccountid(), "JUnit", "アカウントID");
        exStringEquals(startTaskInBean1.getTaskname(), "3001", "タスク名");
        exStringEquals(startTaskInBean1.getLockkey(), "4001", "ロックキー");
        exClassificationEquals(tskStartKekkaKbn, C_TskStartKekkaKbn.SEIJYOU, "タスク開始結果区分");
    }

    @Test(expected = BizAppException.class)
    @TestOrder(50)
    public void testExec_A5() {
        AM_User aMUser = new AM_User();
        aMUser.setUserId("JUnit");
        changeCurrentUser(baseUserInfo, aMUser);

        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN3;
        IwfKouteiClientMockForBiz.mode = "dl01-11";
        String pKouteiKanriId = "1001";
        String pJimuTetuzukiCd = "2001";
        String pTaskId = "3001";
        String pKouteiLockKey = "4001";

        try {

            BzTaskStart bzTaskStart = SWAKInjector.getInstance(BzTaskStart.class);
            bzTaskStart.exec(pKouteiKanriId, pJimuTetuzukiCd, pTaskId, pKouteiLockKey);

        } catch (BizAppException e) {
            exStringEquals(e.getMessage(),
                "IWFエラーです。機能＝業務共通工程タスク開始、API＝タスク開始、エラーコード＝IWF0006", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {
        AM_User aMUser = new AM_User();
        aMUser.setUserId("JUnit");
        changeCurrentUser(baseUserInfo, aMUser);
        MockObjectManager.initialize();

        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN4;
        IwfKouteiClientMockForBiz.mode = "dl01-07";
        String pKouteiKanriId = "1001";
        String pJimuTetuzukiCd = "2001";
        String pTaskId = "3001";
        String pKouteiLockKey = "4001";

        BzTaskStart bzTaskStart = SWAKInjector.getInstance(BzTaskStart.class);
        C_TskStartKekkaKbn tskStartKekkaKbn = bzTaskStart
            .exec(pKouteiKanriId, pJimuTetuzukiCd, pTaskId, pKouteiLockKey);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean1 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForBiz.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean1.getKouteiKanriId(), "1001", "工程管理ID");
        exStringEquals(bzGetProcessSummaryInBean1.getJimuTetuzukiCd(), "2001", "事務手続コード");
        exStringEquals(bzGetProcessSummaryInBean1.getTaskIds()[0], "3001", "(配列)タスクID");
        exClassificationEquals(tskStartKekkaKbn, C_TskStartKekkaKbn.SEIJYOU, "タスク開始結果区分");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {
        AM_User aMUser = new AM_User();
        aMUser.setUserId("JUnit");
        changeCurrentUser(baseUserInfo, aMUser);
        MockObjectManager.initialize();

        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN5;
        IwfKouteiClientMockForBiz.mode = "dl01-12";
        String pKouteiKanriId = "1001";
        String pJimuTetuzukiCd = "2001";
        String pTaskId = "3001";
        String pKouteiLockKey = "4001";

        BzTaskStart bzTaskStart = SWAKInjector.getInstance(BzTaskStart.class);
        C_TskStartKekkaKbn tskStartKekkaKbn = bzTaskStart
            .exec(pKouteiKanriId, pJimuTetuzukiCd, pTaskId, pKouteiLockKey);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean1 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForBiz.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean1.getKouteiKanriId(), "1001", "工程管理ID");
        exStringEquals(bzGetProcessSummaryInBean1.getJimuTetuzukiCd(), "2001", "事務手続コード");
        exStringEquals(bzGetProcessSummaryInBean1.getTaskIds()[0], "3001", "(配列)タスクID");
        exClassificationEquals(tskStartKekkaKbn, C_TskStartKekkaKbn.HUKA_TATANTOUWARIATEZUMI, "タスク開始結果区分");
    }
}
