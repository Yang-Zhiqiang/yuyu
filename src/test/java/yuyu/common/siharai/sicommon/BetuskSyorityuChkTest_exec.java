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
import yuyu.def.classification.C_UmuKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 別請求処理中チェッククラスのメソッド {@link BetuskSyorityuChk#exec(String, String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BetuskSyorityuChkTest_exec {

    @Inject
    private BetuskSyorityuChk betuskSyorityuChk;

    private final static String syoNo1 = "10000000001";
    private final static String syoNo2 = "10000000002";
    private final static String syoNo3 = "10000000003";
    private final static String syoNo4 = "10000000004";
    private final static String syoNo5 = "10000000005";

    private final static String skNo1 = "00000000001";
    private final static String skNo4 = "00000000004";
    private final static String skNo5 = "00000000005";

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

        BzGetProcessSummaryMockForSiharai.caller = BetuskSyorityuChkTest_exec.class;
    }
    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSiharai.caller = null;
        BzGetProcessSummaryMockForSiharai.SYORIPTN = null;
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN1;

        boolean result =  betuskSyorityuChk.exec(syoNo1, skNo1);

        exStringEquals((String) MockObjectManager.getArgument(BzGetProcessSummaryInBean.class, "setSyoNo", 0, 0),syoNo1, "証券番号");
        C_Kouteikanristatus[] kouteikanristatusArr = (C_Kouteikanristatus[]) MockObjectManager
            .getArgument(BzGetProcessSummaryInBean.class, "setKouteiKanriStatuss", 0, 0);
        exClassificationEquals(kouteikanristatusArr[0],C_Kouteikanristatus.SYORITYUU, "（配列）工程管理状況");
        exStringEquals((String) MockObjectManager.getArgument(BzGetProcessSummaryInBean.class, "setSubSystemId", 0, 0),TeisuuSiharai.SUBSYSTEMID_SIHARAI, "サブシステムID");
        exClassificationEquals((C_UmuKbn) MockObjectManager.getArgument(BzGetProcessSummaryInBean.class, "setSyukouteiSiborikomiUmu", 0, 0),C_UmuKbn.ARI, "主工程絞り込み有無");

        exStringEquals(betuskSyorityuChk.getWmJimutetuzukinm(), null, "ワーニングメッセージ事務手続名");
        exStringEquals(betuskSyorityuChk.getWmNodenm(), null, "ワーニングメッセージ現在ノード名");
        exBooleanEquals(result, true, "処理結果");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN2;

        boolean result =  betuskSyorityuChk.exec(syoNo2, null);

        exStringEquals(betuskSyorityuChk.getWmJimutetuzukinm(), null, "ワーニングメッセージ事務手続名");
        exStringEquals(betuskSyorityuChk.getWmNodenm(), null, "ワーニングメッセージ現在ノード名");
        exBooleanEquals(result, true, "処理結果");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN3;

        boolean result =  betuskSyorityuChk.exec(syoNo3, "");

        exStringEquals(betuskSyorityuChk.getWmJimutetuzukinm(), "", "ワーニングメッセージ事務手続名");
        exStringEquals(betuskSyorityuChk.getWmNodenm(), "", "ワーニングメッセージ現在ノード名");
        exBooleanEquals(result, false, "処理結果");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN4;

        boolean result =  betuskSyorityuChk.exec(syoNo4, skNo4);

        exStringEquals(betuskSyorityuChk.getWmJimutetuzukinm(), null, "ワーニングメッセージ事務手続名");
        exStringEquals(betuskSyorityuChk.getWmNodenm(), null, "ワーニングメッセージ現在ノード名");
        exBooleanEquals(result, true, "処理結果");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN5;

        boolean result =  betuskSyorityuChk.exec(syoNo5, skNo5);

        exStringEquals(betuskSyorityuChk.getWmJimutetuzukinm(), "transaction", "ワーニングメッセージ事務手続名");
        exStringEquals(betuskSyorityuChk.getWmNodenm(), "nodeName", "ワーニングメッセージ現在ノード名");
        exBooleanEquals(result, false, "処理結果");
    }
}
