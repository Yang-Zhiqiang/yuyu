package yuyu.common.sinkeiyaku.moschk;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Tuukasyu;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 不備メッセージ設定クラスのメソッド {@link SetHubiMsg#editHubiMsgKingaku(BizCurrency, BizCurrency, C_Tuukasyu)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetHubiMsgTest_editHubiMsgKingaku {

    @Inject
    private SetHubiMsg setHubiMsg;

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
    }

    @Test
    @TestOrder(10)
    public void testEditHubiMsgKingaku_A1() {

        String hubiMsg = setHubiMsg.editHubiMsgKingaku(BizCurrency.valueOf(20000), BizCurrency.valueOf(10001),
            C_Tuukasyu.JPY);

        exStringEquals(hubiMsg, "2万円", "不備メッセージ（通貨）");
    }

    @Test
    @TestOrder(20)
    public void testEditHubiMsgKingaku_A2() {

        String hubiMsg = setHubiMsg.editHubiMsgKingaku(BizCurrency.valueOf(10050), BizCurrency.valueOf(10000),
            C_Tuukasyu.JPY);

        exStringEquals(hubiMsg, "1万円", "不備メッセージ（通貨）");
    }

    @Test
    @TestOrder(30)
    public void testEditHubiMsgKingaku_A3() {

        String hubiMsg = setHubiMsg.editHubiMsgKingaku(BizCurrency.valueOf(5000), BizCurrency.valueOf(9999),
            C_Tuukasyu.JPY);

        exStringEquals(hubiMsg, "5,000円", "不備メッセージ（通貨）");
    }

    @Test
    @TestOrder(40)
    public void testEditHubiMsgKingaku_A4() {

        String hubiMsg = setHubiMsg.editHubiMsgKingaku(BizCurrency.valueOf(123,BizCurrencyTypes.DOLLAR),
            BizCurrency.valueOf(1.1,BizCurrencyTypes.DOLLAR), C_Tuukasyu.USD);

        exStringEquals(hubiMsg, "123米ドル", "不備メッセージ（通貨）");
    }

    @Test
    @TestOrder(50)
    public void testEditHubiMsgKingaku_A5() {

        String hubiMsg = setHubiMsg.editHubiMsgKingaku(BizCurrency.valueOf(234,BizCurrencyTypes.DOLLAR),
            BizCurrency.valueOf(1,BizCurrencyTypes.DOLLAR), C_Tuukasyu.USD);

        exStringEquals(hubiMsg, "234米ドル", "不備メッセージ（通貨）");
    }

    @Test
    @TestOrder(60)
    public void testEditHubiMsgKingaku_A6() {

        String hubiMsg = setHubiMsg.editHubiMsgKingaku(BizCurrency.valueOf(345,BizCurrencyTypes.DOLLAR),
            BizCurrency.valueOf(0.9,BizCurrencyTypes.DOLLAR), C_Tuukasyu.USD);

        exStringEquals(hubiMsg, "345.0米ドル", "不備メッセージ（通貨）");
    }

    @Test
    @TestOrder(70)
    public void testEditHubiMsgKingaku_A7() {

        String hubiMsg = setHubiMsg.editHubiMsgKingaku(BizCurrency.valueOf(456,BizCurrencyTypes.DOLLAR),
            BizCurrency.valueOf(0.11,BizCurrencyTypes.DOLLAR), C_Tuukasyu.USD);

        exStringEquals(hubiMsg, "456.0米ドル", "不備メッセージ（通貨）");
    }

    @Test
    @TestOrder(80)
    public void testEditHubiMsgKingaku_A8() {

        String hubiMsg = setHubiMsg.editHubiMsgKingaku(BizCurrency.valueOf(567,BizCurrencyTypes.DOLLAR),
            BizCurrency.valueOf(0.1,BizCurrencyTypes.DOLLAR), C_Tuukasyu.USD);

        exStringEquals(hubiMsg, "567.0米ドル", "不備メッセージ（通貨）");
    }

    @Test
    @TestOrder(90)
    public void testEditHubiMsgKingaku_A9() {

        String hubiMsg = setHubiMsg.editHubiMsgKingaku(BizCurrency.valueOf(678,BizCurrencyTypes.DOLLAR),
            BizCurrency.valueOf(0.099,BizCurrencyTypes.DOLLAR), C_Tuukasyu.USD);

        exStringEquals(hubiMsg, "678.00米ドル", "不備メッセージ（通貨）");
    }

}
