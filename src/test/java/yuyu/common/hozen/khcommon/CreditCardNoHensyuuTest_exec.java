package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_CardBrandKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約保全 契約保全共通 クレジットカード番号表示編集クラスのメソッド {@link CreditCardNoHensyuu#exec()}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class CreditCardNoHensyuuTest_exec {

    @Inject
    private CreditCardNoHensyuu creditCardNoHensyuu;

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        String editCreditCardNo = creditCardNoHensyuu.exec(C_CardBrandKbn.VISA, "1234");

        exStringEquals(editCreditCardNo, "＊＊＊＊　＊＊＊＊　＊＊＊＊　１２３４", "編集後クレジットカード番号");
    }

    @Test
    @TestOrder(10)
    public void testExec_A2() {

        String editCreditCardNo = creditCardNoHensyuu.exec(C_CardBrandKbn.MASTER, "Abcd");

        exStringEquals(editCreditCardNo, "＊＊＊＊　＊＊＊＊　＊＊＊＊　Ａｂｃｄ", "編集後クレジットカード番号");
    }

    @Test
    @TestOrder(10)
    public void testExec_A3() {

        String editCreditCardNo = creditCardNoHensyuu.exec(C_CardBrandKbn.JCB, "a123");

        exStringEquals(editCreditCardNo, "＊＊＊＊　＊＊＊＊　＊＊＊＊　ａ１２３", "編集後クレジットカード番号");
    }

    @Test
    @TestOrder(10)
    public void testExec_A4() {

        String editCreditCardNo = creditCardNoHensyuu.exec(C_CardBrandKbn.AMEX, "!123");

        exStringEquals(editCreditCardNo, "＊＊＊＊　＊＊＊＊＊＊　＊！１２３", "編集後クレジットカード番号");
    }

    @Test
    @TestOrder(10)
    public void testExec_A5() {

        String editCreditCardNo = creditCardNoHensyuu.exec(C_CardBrandKbn.DINERS, "５678");

        exStringEquals(editCreditCardNo, "＊＊＊＊　＊＊＊＊＊＊　５６７８", "編集後クレジットカード番号");
    }

    @Test
    @TestOrder(10)
    public void testExec_A6() {

        String editCreditCardNo = creditCardNoHensyuu.exec(C_CardBrandKbn.SONOTA, "ｱｲｳｴ");

        exStringEquals(editCreditCardNo, "アイウエ", "編集後クレジットカード番号");
    }

}
