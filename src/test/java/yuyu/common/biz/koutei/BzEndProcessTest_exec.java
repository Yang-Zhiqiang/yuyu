package yuyu.common.biz.koutei;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 業務共通工程サマリ取得クラスのメソッド {@link BzEndProcess#exec(String,String,String,C_YouhiKbn)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzEndProcessTest_exec {

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(BzGetProcessSummary.class).to(BzGetProcessSummaryMockForBiz.class);
                bind(GetSyoriKokouteiInfo.class).to(GetSyoriKokouteiInfoMockForBiz.class);
                bind(BzForceProcessForward.class).to(BzForceProcessForwardMockForBiz.class);
            }
        });
    }

    @BeforeClass
    public static void testInit(){
        BzGetProcessSummaryMockForBiz.caller = BzEndProcessTest_exec.class;
        GetSyoriKokouteiInfoMockForBiz.caller = "Test";
        BzForceProcessForwardMockForBiz.caller = BzEndProcessTest_exec.class;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForBiz.caller = null;
        GetSyoriKokouteiInfoMockForBiz.caller = null;
        BzForceProcessForwardMockForBiz.caller = null;
        BzGetProcessSummaryMockForBiz.SYORIPTN = null;
        GetSyoriKokouteiInfoMockForBiz.mode = null;
        BzForceProcessForwardMockForBiz.SYORIPTN = null;
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN1;
        GetSyoriKokouteiInfoMockForBiz.mode = GetSyoriKokouteiInfoMockForBiz.TESTPATTERN7;
        String pSyuKouteiKanriId = "001";
        String pSyuJimuTetuzukiCd = "002";
        String pKouteiLockKey = "003";
        C_YouhiKbn pSyuKouteiEndYouhiKbn = C_YouhiKbn.YOU;
        BzEndProcess bzEndProcess = SWAKInjector.getInstance(BzEndProcess.class);
        bzEndProcess.exec(pSyuKouteiKanriId, pSyuJimuTetuzukiCd, pKouteiLockKey, pSyuKouteiEndYouhiKbn);
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN2;
        GetSyoriKokouteiInfoMockForBiz.mode = GetSyoriKokouteiInfoMockForBiz.TESTPATTERN8;
        BzForceProcessForwardMockForBiz.SYORIPTN = BzForceProcessForwardMockForBiz.TESTPATTERN1;
        String pSyuKouteiKanriId = "001";
        String pSyuJimuTetuzukiCd = "002";
        String pKouteiLockKey = "003";
        C_YouhiKbn pSyuKouteiEndYouhiKbn = C_YouhiKbn.YOU;
        BzEndProcess bzEndProcess = SWAKInjector.getInstance(BzEndProcess.class);
        bzEndProcess.exec(pSyuKouteiKanriId, pSyuJimuTetuzukiCd, pKouteiLockKey, pSyuKouteiEndYouhiKbn);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(BzGetProcessSummaryMockForBiz.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean.getKouteiKanriId(), "001", "工程管理ID");
        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), "002", "工程事務手続コード");
        C_Kouteikanristatus[] kouteikanristatus = bzGetProcessSummaryInBean.getKouteiKanriStatuss();
        exClassificationEquals(kouteikanristatus[0], C_Kouteikanristatus.SYORITYUU, "工程管理状況（配列）");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {
        MockObjectManager.initialize();
        GetSyoriKokouteiInfoMockForBiz.mode = GetSyoriKokouteiInfoMockForBiz.TESTPATTERN7;
        String pSyuKouteiKanriId = "001";
        String pSyuJimuTetuzukiCd = "002";
        String pKouteiLockKey = "003";
        C_YouhiKbn pSyuKouteiEndYouhiKbn = C_YouhiKbn.HUYOU;
        BzEndProcess bzEndProcess = SWAKInjector.getInstance(BzEndProcess.class);
        bzEndProcess.exec(pSyuKouteiKanriId, pSyuJimuTetuzukiCd, pKouteiLockKey,pSyuKouteiEndYouhiKbn);
    }

    @Test
    @TestOrder(40)
    public void testExec_B1() {
        MockObjectManager.initialize();
        GetSyoriKokouteiInfoMockForBiz.mode = GetSyoriKokouteiInfoMockForBiz.TESTPATTERN7;
        String pSyuKouteiKanriId = "001";
        String pSyuJimuTetuzukiCd = "002";
        String pKouteiLockKey = "003";
        C_YouhiKbn pSyuKouteiEndYouhiKbn = C_YouhiKbn.HUYOU;
        BzEndProcess bzEndProcess = SWAKInjector.getInstance(BzEndProcess.class);
        bzEndProcess.exec(pSyuKouteiKanriId, pSyuJimuTetuzukiCd, pKouteiLockKey,pSyuKouteiEndYouhiKbn);
    }

    @Test
    @TestOrder(50)
    public void testExec_B2() {
        MockObjectManager.initialize();
        GetSyoriKokouteiInfoMockForBiz.mode = GetSyoriKokouteiInfoMockForBiz.TESTPATTERN8;
        BzForceProcessForwardMockForBiz.SYORIPTN = BzForceProcessForwardMockForBiz.TESTPATTERN2;

        String pSyuKouteiKanriId = "001";
        String pSyuJimuTetuzukiCd = "002";
        String pKouteiLockKey = "003";
        C_YouhiKbn pSyuKouteiEndYouhiKbn = C_YouhiKbn.HUYOU;
        BzEndProcess bzEndProcess = SWAKInjector.getInstance(BzEndProcess.class);
        bzEndProcess.exec(pSyuKouteiKanriId, pSyuJimuTetuzukiCd, pKouteiLockKey,pSyuKouteiEndYouhiKbn);

        String syuKouteiKanriId = (String)MockObjectManager.getArgument(BzForceProcessForwardMockForBiz.class, "exec", 0, 0);
        exStringEquals(syuKouteiKanriId, "101", "工程管理ID");
        String syuJimuTetuzukiCd = (String)MockObjectManager.getArgument(BzForceProcessForwardMockForBiz.class, "exec", 0, 1);
        exStringEquals(syuJimuTetuzukiCd, "1002", "事務手続コード");
        String destnodeId = (String)MockObjectManager.getArgument(BzForceProcessForwardMockForBiz.class, "exec", 0, 2);
        exStringEquals(destnodeId, BzIwfUtilConstants.NODEID_ENDNODE_DEFAULT, "遷移先ノードID");
        String kouteiLockKey = (String)MockObjectManager.getArgument(BzForceProcessForwardMockForBiz.class, "exec", 0, 3);
        exStringEquals(kouteiLockKey, "003", "工程ロックキー");
    }

    @Test
    @TestOrder(60)
    public void testExec_B3() {
        MockObjectManager.initialize();
        GetSyoriKokouteiInfoMockForBiz.mode = GetSyoriKokouteiInfoMockForBiz.TESTPATTERN9;
        BzForceProcessForwardMockForBiz.SYORIPTN = BzForceProcessForwardMockForBiz.TESTPATTERN1;
        String pSyuKouteiKanriId = "001";
        String pSyuJimuTetuzukiCd = "002";
        String pKouteiLockKey = "003";
        C_YouhiKbn pSyuKouteiEndYouhiKbn = C_YouhiKbn.HUYOU;
        BzEndProcess bzEndProcess = SWAKInjector.getInstance(BzEndProcess.class);
        bzEndProcess.exec(pSyuKouteiKanriId, pSyuJimuTetuzukiCd, pKouteiLockKey,pSyuKouteiEndYouhiKbn);
    }
}
