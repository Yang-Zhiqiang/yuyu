package yuyu.common.biz.interf;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_HnknhkgnKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 伝送用売上金額変換処理クラスのメソッド {@link DensouUriageKgHenkan#exec(C_HnknhkgnKbn, BizCurrency, String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class DensouUriageKgHenkanTest_exec {

    @Inject
    private DensouUriageKgHenkan densouUriageKgHenkan;


    @Test
    @TestOrder(10)
    public void testExec_A1() {
        densouUriageKgHenkan.exec(C_HnknhkgnKbn.HNKN, BizCurrency.valueOf(66), null);
        exStringEquals(densouUriageKgHenkan.getDensoUriageGk(),"6F","伝送用売上金額");
        exBooleanEquals(densouUriageKgHenkan.getErrFlag(), false,"エラーフラグ");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        densouUriageKgHenkan.exec(C_HnknhkgnKbn.HNKN, BizCurrency.valueOf(0), null);
        exStringEquals(densouUriageKgHenkan.getDensoUriageGk(),"{","伝送用売上金額");
        exBooleanEquals(densouUriageKgHenkan.getErrFlag(),false,"エラーフラグ");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        densouUriageKgHenkan.exec(C_HnknhkgnKbn.HNKN, BizCurrency.valueOf(3.3), null);
        exBooleanEquals(densouUriageKgHenkan.getErrFlag(),true,"エラーフラグ");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        densouUriageKgHenkan.exec(C_HnknhkgnKbn.HNKN, BizCurrency.valueOf(-55), null);
        exStringEquals(densouUriageKgHenkan.getDensoUriageGk(), "5N","伝送用売上金額");
        exBooleanEquals(densouUriageKgHenkan.getErrFlag(),false,"エラーフラグ");
    }

    @Test
    @TestOrder(50)
    public void testExec_B1() {

        densouUriageKgHenkan.exec(C_HnknhkgnKbn.HKGN, null, "4C");
        exBizCalcbleEquals(densouUriageKgHenkan.getSignUrageGk(),BizCurrency.valueOf(43),"サイン付売上金額");
        exBooleanEquals(densouUriageKgHenkan.getErrFlag(),false,"エラーフラグ");
    }

    @Test
    @TestOrder(60)
    public void testExec_B2() {

        densouUriageKgHenkan.exec(C_HnknhkgnKbn.HKGN, null, "4K");
        exBizCalcbleEquals(densouUriageKgHenkan.getSignUrageGk(),BizCurrency.valueOf(-42),"サイン付売上金額");
        exBooleanEquals(densouUriageKgHenkan.getErrFlag(),false,"エラーフラグ");
    }

    @Test
    @TestOrder(70)
    public void testExec_B3() {

        densouUriageKgHenkan.exec(C_HnknhkgnKbn.HKGN, null, "4Y");
        exBooleanEquals(densouUriageKgHenkan.getErrFlag(),true,"エラーフラグ");
    }

    @Test
    @TestOrder(80)
    public void testExec_B4() {

        densouUriageKgHenkan.exec(C_HnknhkgnKbn.HNKN, BizCurrency.valueOf(0), null);
        exStringEquals(densouUriageKgHenkan.getDensoUriageGk(),"{","伝送用売上金額");
    }

    @Test
    @TestOrder(90)
    public void testExec_B5() {

        densouUriageKgHenkan.exec(C_HnknhkgnKbn.HNKN, BizCurrency.valueOf(1), null);
        exStringEquals(densouUriageKgHenkan.getDensoUriageGk(),"A","伝送用売上金額");
    }

    @Test
    @TestOrder(100)
    public void testExec_B6() {

        densouUriageKgHenkan.exec(C_HnknhkgnKbn.HNKN, BizCurrency.valueOf(2), null);
        exStringEquals(densouUriageKgHenkan.getDensoUriageGk(),"B","伝送用売上金額");
    }

    @Test
    @TestOrder(110)
    public void testExec_B7() {

        densouUriageKgHenkan.exec(C_HnknhkgnKbn.HNKN, BizCurrency.valueOf(3), null);
        exStringEquals(densouUriageKgHenkan.getDensoUriageGk(),"C","伝送用売上金額");
    }

    @Test
    @TestOrder(120)
    public void testExec_B8() {

        densouUriageKgHenkan.exec(C_HnknhkgnKbn.HNKN, BizCurrency.valueOf(4), null);
        exStringEquals(densouUriageKgHenkan.getDensoUriageGk(),"D","伝送用売上金額");
    }

    @Test
    @TestOrder(130)
    public void testExec_B9() {

        densouUriageKgHenkan.exec(C_HnknhkgnKbn.HNKN, BizCurrency.valueOf(5), null);
        exStringEquals(densouUriageKgHenkan.getDensoUriageGk(),"E","伝送用売上金額");
    }

    @Test
    @TestOrder(140)
    public void testExec_B10() {

        densouUriageKgHenkan.exec(C_HnknhkgnKbn.HNKN, BizCurrency.valueOf(6), null);
        exStringEquals(densouUriageKgHenkan.getDensoUriageGk(),"F","伝送用売上金額");
    }

    @Test
    @TestOrder(150)
    public void testExec_B11() {

        densouUriageKgHenkan.exec(C_HnknhkgnKbn.HNKN, BizCurrency.valueOf(7), null);
        exStringEquals(densouUriageKgHenkan.getDensoUriageGk(),"G","伝送用売上金額");
    }

    @Test
    @TestOrder(160)
    public void testExec_B12() {

        densouUriageKgHenkan.exec(C_HnknhkgnKbn.HNKN, BizCurrency.valueOf(8), null);
        exStringEquals(densouUriageKgHenkan.getDensoUriageGk(),"H","伝送用売上金額");
    }

    @Test
    @TestOrder(170)
    public void testExec_B13() {

        densouUriageKgHenkan.exec(C_HnknhkgnKbn.HNKN, BizCurrency.valueOf(9), null);
        exStringEquals(densouUriageKgHenkan.getDensoUriageGk(),"I","伝送用売上金額");
    }

    @Test
    @TestOrder(180)
    public void testExec_B14() {

        densouUriageKgHenkan.exec(C_HnknhkgnKbn.HNKN, BizCurrency.valueOf(-10), null);
        exStringEquals(densouUriageKgHenkan.getDensoUriageGk(),"1}","伝送用売上金額");
    }

    @Test
    @TestOrder(190)
    public void testExec_B15() {

        densouUriageKgHenkan.exec(C_HnknhkgnKbn.HNKN, BizCurrency.valueOf(-1), null);
        exStringEquals(densouUriageKgHenkan.getDensoUriageGk(),"J","伝送用売上金額");
    }

    @Test
    @TestOrder(200)
    public void testExec_B16() {

        densouUriageKgHenkan.exec(C_HnknhkgnKbn.HNKN, BizCurrency.valueOf(-2), null);
        exStringEquals(densouUriageKgHenkan.getDensoUriageGk(),"K","伝送用売上金額");
    }

    @Test
    @TestOrder(210)
    public void testExec_B17() {

        densouUriageKgHenkan.exec(C_HnknhkgnKbn.HNKN, BizCurrency.valueOf(-3), null);
        exStringEquals(densouUriageKgHenkan.getDensoUriageGk(),"L","伝送用売上金額");
    }

    @Test
    @TestOrder(220)
    public void testExec_B18() {

        densouUriageKgHenkan.exec(C_HnknhkgnKbn.HNKN, BizCurrency.valueOf(-4), null);
        exStringEquals(densouUriageKgHenkan.getDensoUriageGk(),"M","伝送用売上金額");
    }

    @Test
    @TestOrder(230)
    public void testExec_B19() {

        densouUriageKgHenkan.exec(C_HnknhkgnKbn.HNKN, BizCurrency.valueOf(-5), null);
        exStringEquals(densouUriageKgHenkan.getDensoUriageGk(),"N","伝送用売上金額");
    }

    @Test
    @TestOrder(240)
    public void testExec_B20() {

        densouUriageKgHenkan.exec(C_HnknhkgnKbn.HNKN, BizCurrency.valueOf(-6), null);
        exStringEquals(densouUriageKgHenkan.getDensoUriageGk(),"O","伝送用売上金額");
    }

    @Test
    @TestOrder(250)
    public void testExec_B21() {

        densouUriageKgHenkan.exec(C_HnknhkgnKbn.HNKN, BizCurrency.valueOf(-7), null);
        exStringEquals(densouUriageKgHenkan.getDensoUriageGk(),"P","伝送用売上金額");
    }

    @Test
    @TestOrder(260)
    public void testExec_B22() {

        densouUriageKgHenkan.exec(C_HnknhkgnKbn.HNKN, BizCurrency.valueOf(-8), null);
        exStringEquals(densouUriageKgHenkan.getDensoUriageGk(),"Q","伝送用売上金額");
    }

    @Test
    @TestOrder(270)
    public void testExec_B23() {

        densouUriageKgHenkan.exec(C_HnknhkgnKbn.HNKN, BizCurrency.valueOf(-9), null);
        exStringEquals(densouUriageKgHenkan.getDensoUriageGk(),"R","伝送用売上金額");
    }

    @Test
    @TestOrder(280)
    public void testExec_C1() {

        densouUriageKgHenkan.exec(C_HnknhkgnKbn.HNKN, BizCurrency.valueOf(1, BizCurrencyTypes.YEN), null);
        exStringEquals(densouUriageKgHenkan.getDensoUriageGk(),"A","伝送用売上金額");
    }

    @Test
    @TestOrder(290)
    public void testExec_C2() {

        densouUriageKgHenkan.exec(C_HnknhkgnKbn.HNKN, BizCurrency.valueOf(1, BizCurrencyTypes.MANYEN), null);
        exStringEquals(densouUriageKgHenkan.getDensoUriageGk(),"A","伝送用売上金額");
    }

    @Test
    @TestOrder(300)
    public void testExec_C3() {

        densouUriageKgHenkan.exec(C_HnknhkgnKbn.HNKN, BizCurrency.valueOf(1, BizCurrencyTypes.DOLLAR), null);
        exStringEquals(densouUriageKgHenkan.getDensoUriageGk(),"A","伝送用売上金額");
    }

    @Test
    @TestOrder(310)
    public void testExec_C4() {

        densouUriageKgHenkan.exec(C_HnknhkgnKbn.HNKN, BizCurrency.valueOf(1, BizCurrencyTypes.AU_DOLLAR), null);
        exStringEquals(densouUriageKgHenkan.getDensoUriageGk(),"A","伝送用売上金額");
    }

    @Test
    @TestOrder(320)
    public void testExec_C5() {

        densouUriageKgHenkan.exec(C_HnknhkgnKbn.HNKN, BizCurrency.valueOf(1, BizCurrencyTypes.EURO), null);
        exStringEquals(densouUriageKgHenkan.getDensoUriageGk(),"A","伝送用売上金額");
    }

}
