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
import yuyu.common.biz.workflow.io.koutei.ForceProcessForwardInBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 業務共通強制工程遷移クラスのメソッド {@link BzForceProcessForward#exec(String, String, String, String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzForceProcessForwardTest_exec {

    @Inject
    private BaseUserInfo baseUserInfo;

    @Before
    public void Before () {
        MockModuleBinder.bind(new AbstractModule() {
            @Override
            protected void configure() {
                bind(BzGetProcessSummary.class).to(BzGetProcessSummaryMockForBiz.class);
                bind(IwfKouteiClient.class).to(IwfKouteiClientMockForBiz.class);
            }
        });
    }

    @BeforeClass
    public static void testInit(){
        BzGetProcessSummaryMockForBiz.caller = BzForceProcessForwardTest_exec.class;
        IwfKouteiClientMockForBiz.caller = "Test";
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForBiz.caller = null;
        IwfKouteiClientMockForBiz.caller = null;
        BzGetProcessSummaryMockForBiz.SYORIPTN = null;
        IwfKouteiClientMockForBiz.mode = null;
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN1;
        IwfKouteiClientMockForBiz.mode = "dl-01";
        String pKouteiKanriId = "101";
        String pJimuTetuzukiCd = "102";
        String pDestnodeId = BzIwfUtilConstants.NODEID_ENDNODE_DEFAULT;
        String pKouteiLockKey = "103";
        BzForceProcessForward BzForceProcessForward = SWAKInjector.getInstance(BzForceProcessForward.class);
        BzForceProcessForward.exec(pKouteiKanriId, pJimuTetuzukiCd, pDestnodeId, pKouteiLockKey);
        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForBiz.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean.getKouteiKanriId(), "101", "工程管理ID");
        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), "102", "事務手続コード");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        baseUserInfo.getUser().setUserId("JUnit");

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN1;
        IwfKouteiClientMockForBiz.mode = "forceprocessforward-01";
        String pKouteiKanriId = "101";
        String pJimuTetuzukiCd = "102";
        String pDestnodeId = "TaskNm01";
        String pKouteiLockKey = "103";
        BzForceProcessForward BzForceProcessForward = SWAKInjector.getInstance(BzForceProcessForward.class);
        BzForceProcessForward.exec(pKouteiKanriId, pJimuTetuzukiCd, pDestnodeId, pKouteiLockKey);
        ForceProcessForwardInBean forceProcessForwardInBean = (ForceProcessForwardInBean) MockObjectManager.getArgument(
            IwfKouteiClientMockForBiz.class, "execForceProcessForward", 0, 0);
        exStringEquals(forceProcessForwardInBean.getGyoumukey(), "101", "業務キー");
        exStringEquals(forceProcessForwardInBean.getFlowid(), "102", "フローID");
        exStringEquals(forceProcessForwardInBean.getAccountid(),  "JUnit", "アカウントID");
        exStringEquals(forceProcessForwardInBean.getSrcnodename(),  BzIwfUtilConstants.NODEID_ENDNODE_DEFAULT, "遷移元ノード名");
        exStringEquals(forceProcessForwardInBean.getDestnodename(),  "TaskNm01", "遷移先ノード名");
        exStringEquals(forceProcessForwardInBean.getLockkey(), "103", "ロックキー");
    }

    @Test(expected = BizAppException.class)
    @TestOrder(30)
    public void testExec_A3() {

        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN1;
        IwfKouteiClientMockForBiz.mode = "forceprocessforward-02";
        String pKouteiKanriId = "101";
        String pJimuTetuzukiCd = "102";
        String pDestnodeId = "TaskNm01";
        String pKouteiLockKey = "103";
        try {
            BzForceProcessForward BzForceProcessForward = SWAKInjector.getInstance(BzForceProcessForward.class);
            BzForceProcessForward.exec(pKouteiKanriId, pJimuTetuzukiCd, pDestnodeId, pKouteiLockKey);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "IWFエラーです。機能＝業務共通強制工程遷移、API＝強制工程遷移、エラーコード＝IWF0002", "エラーメッセージ");
            throw e;
        }
    }
}
