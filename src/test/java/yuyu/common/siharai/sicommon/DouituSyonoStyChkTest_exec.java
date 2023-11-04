package yuyu.common.siharai.sicommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryMockForSiharai;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 同一証券番号進捗チェックのメソッド{@link DouituSyonoStyChk#exec(String,String,C_Kouteikanristatus[],String[])} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class DouituSyonoStyChkTest_exec {
    @Inject
    private DouituSyonoStyChk douituSyonoStyChk;

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(BzGetProcessSummary.class).to(BzGetProcessSummaryMockForSiharai.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        BzGetProcessSummaryMockForSiharai.caller = DouituSyonoStyChkTest_exec.class;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSiharai.caller =null;
        BzGetProcessSummaryMockForSiharai.SYORIPTN=null;
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN1;
        String syoNo = "80000000026";
        String jimuTetuzukiCd = "001";
        C_Kouteikanristatus[] kouteiKanriStatus = new C_Kouteikanristatus[] { C_Kouteikanristatus.BLNK };
        boolean result = douituSyonoStyChk.exec(syoNo, jimuTetuzukiCd, kouteiKanriStatus);
        exBooleanEquals(result, true, "処理結果");
        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummary.class, "exec", 0, 0);
        String jimuTetuzukiCdParam = bzGetProcessSummaryInBean.getJimuTetuzukiCd();
        String syoNoParam = bzGetProcessSummaryInBean.getSyoNo();
        C_Kouteikanristatus[] KouteikanristatusParam = bzGetProcessSummaryInBean.getKouteiKanriStatuss();
        exStringEquals(jimuTetuzukiCdParam, "001", "事務手続コード");
        exStringEquals(syoNoParam, "80000000026", "証券番号");
        exClassificationEquals(KouteikanristatusParam[0], C_Kouteikanristatus.BLNK, "工程管理状況");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN2;
        String syoNo = "80000000026";
        String jimuTetuzukiCd = "001";
        C_Kouteikanristatus[] kouteiKanriStatus = new C_Kouteikanristatus[] { C_Kouteikanristatus.SYORITYUU };
        boolean result = douituSyonoStyChk.exec(syoNo, jimuTetuzukiCd, kouteiKanriStatus);
        exBooleanEquals(result, false, "処理結果");
        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummary.class, "exec", 0, 0);
        String jimuTetuzukiCdParam = bzGetProcessSummaryInBean.getJimuTetuzukiCd();
        String syoNoParam = bzGetProcessSummaryInBean.getSyoNo();
        C_Kouteikanristatus[] KouteikanristatusParam = bzGetProcessSummaryInBean.getKouteiKanriStatuss();
        exStringEquals(jimuTetuzukiCdParam, "001", "事務手続コード");
        exStringEquals(syoNoParam, "80000000026", "証券番号");
        exNumericEquals(KouteikanristatusParam.length, 1, "工程管理状況のサイズ");
        exClassificationEquals(KouteikanristatusParam[0], C_Kouteikanristatus.SYORITYUU, "工程管理状況");
    }
}
