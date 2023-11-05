package yuyu.common.hozen.khcommon;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.koutei.BzGetProcessSummaryMock;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_UmuKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * CheckProcessKaishiクラスのメソッド {@link CheckProcessKaishi#exec(String,String)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class CheckProcessKaishiTest_exec {

    @Inject
    private CheckProcessKaishi checkProcessKaishi;

    @Test
    @TestOrder(10)
    public void testExec_A1() {
        BzGetProcessSummaryMock.SYORIPTN = BzGetProcessSummaryMock.TESTPATTERN7;

        C_UmuKbn cUmuKbn = checkProcessKaishi.exec("", "");

        BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = checkProcessKaishi.getBzGetProcessSummaryOutBean();

        if (bzGetProcessSummaryOutBean != null) {
            fail("【業務共通工程サマリ取得出力Bean】[期待値違反] 検証値：NULL以外 期待値：NULL");
        }

        exClassificationEquals(cUmuKbn, C_UmuKbn.NONE, "有無区分");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        BzGetProcessSummaryMock.SYORIPTN = BzGetProcessSummaryMock.TESTPATTERN8;

        C_UmuKbn cUmuKbn = checkProcessKaishi.exec("12806345672", "0001");

        BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = checkProcessKaishi.getBzGetProcessSummaryOutBean();

        exStringEquals(bzGetProcessSummaryOutBean.getJimuTetuzukiCd(), "0001",
            "業務共通工程サマリ取得出力Beanの事務手続コード");
        exDateEquals(bzGetProcessSummaryOutBean.getKouteEndYmd(), null,
            "業務共通工程サマリ取得出力Beanの工程完了年月日");
        exClassificationEquals(bzGetProcessSummaryOutBean.getKouteiKanriStatus(), C_Kouteikanristatus.SYORITYUU,
            "業務共通工程サマリ取得出力Beanの工程管理状況");
        exStringEquals(bzGetProcessSummaryOutBean.getSyoNo(), "12806345672",
            "業務共通工程サマリ取得出力Beanの証券番号");

        exClassificationEquals(cUmuKbn, C_UmuKbn.ARI, "有無区分");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        BzGetProcessSummaryMock.SYORIPTN = BzGetProcessSummaryMock.TESTPATTERN9;

        C_UmuKbn cUmuKbn = checkProcessKaishi.exec("12807345675", "0001");

        BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = checkProcessKaishi.getBzGetProcessSummaryOutBean();

        if (bzGetProcessSummaryOutBean != null) {
            fail("【業務共通工程サマリ取得出力Bean】[期待値違反] 検証値：NULL以外 期待値：NULL");
        }

        exClassificationEquals(cUmuKbn, C_UmuKbn.NONE, "有無区分");
    }

    @BeforeClass
    public static void testInit(){

        BzGetProcessSummaryMock.caller = CheckProcessKaishiTest_exec.class;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMock.caller = null;
        BzGetProcessSummaryMock.SYORIPTN = null;
    }
}
