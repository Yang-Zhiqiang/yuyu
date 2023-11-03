package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_CardBrandKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * クレジットカードブランド設定のメソッド {@link SetCreditCardBrand#exec(String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetCreditCardBrandTest_exec {

    @Inject
    private SetCreditCardBrand setCreditCardBrand;

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        C_CardBrandKbn cardbrandKbn = setCreditCardBrand.exec("301611");

        exClassificationEquals(cardbrandKbn, C_CardBrandKbn.DINERS, "カードブランド区分");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        C_CardBrandKbn cardbrandKbn = setCreditCardBrand.exec("361612");

        exClassificationEquals(cardbrandKbn, C_CardBrandKbn.DINERS, "カードブランド区分");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        C_CardBrandKbn cardbrandKbn = setCreditCardBrand.exec("381613");

        exClassificationEquals(cardbrandKbn, C_CardBrandKbn.DINERS, "カードブランド区分");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        C_CardBrandKbn cardbrandKbn = setCreditCardBrand.exec("391614");

        exClassificationEquals(cardbrandKbn, C_CardBrandKbn.DINERS, "カードブランド区分");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        C_CardBrandKbn cardbrandKbn = setCreditCardBrand.exec("341615");

        exClassificationEquals(cardbrandKbn, C_CardBrandKbn.AMEX, "カードブランド区分");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        C_CardBrandKbn cardbrandKbn = setCreditCardBrand.exec("371616");

        exClassificationEquals(cardbrandKbn, C_CardBrandKbn.AMEX, "カードブランド区分");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        C_CardBrandKbn cardbrandKbn = setCreditCardBrand.exec("351617");

        exClassificationEquals(cardbrandKbn, C_CardBrandKbn.JCB, "カードブランド区分");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        C_CardBrandKbn cardbrandKbn = setCreditCardBrand.exec("311618");

        exClassificationEquals(cardbrandKbn, C_CardBrandKbn.SONOTA, "カードブランド区分");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        C_CardBrandKbn cardbrandKbn = setCreditCardBrand.exec("401619");

        exClassificationEquals(cardbrandKbn, C_CardBrandKbn.VISA, "カードブランド区分");
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        C_CardBrandKbn cardbrandKbn = setCreditCardBrand.exec("50161A");

        exClassificationEquals(cardbrandKbn, C_CardBrandKbn.MASTER, "カードブランド区分");
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {

        C_CardBrandKbn cardbrandKbn = setCreditCardBrand.exec("60161B");

        exClassificationEquals(cardbrandKbn, C_CardBrandKbn.SONOTA, "カードブランド区分");
    }
}
