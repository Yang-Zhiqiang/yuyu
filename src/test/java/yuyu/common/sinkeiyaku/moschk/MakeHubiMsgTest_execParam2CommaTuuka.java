package yuyu.common.sinkeiyaku.moschk;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.MessageId;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 不備メッセージ文言作成クラスのメソッドテスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class MakeHubiMsgTest_execParam2CommaTuuka {

    @Test
    @TestOrder(10)
    public void testExecParam2CommaTuuka_D1() {

        String ret = MakeHubiMsg.execParam2CommaTuuka(MessageId.EHC0031, MessageId.EHC0031, "ゆうゆう保険", BizCurrency.valueOf(1111,
            BizCurrencyTypes.YEN));
        exStringEquals(ret, "EHC0031 ゆうゆう保険の保険金額が最低Ｓの1,111円に未達です。", "メッセージ文言");
    }

    @Test
    @TestOrder(20)
    public void testExecParam2CommaTuuka_D2() {

        String ret = MakeHubiMsg.execParam2CommaTuuka(MessageId.EHC0031, MessageId.EHC0031, "ゆうゆう保険", BizCurrency.valueOf(1111,
            BizCurrencyTypes.DOLLAR));
        exStringEquals(ret, "EHC0031 ゆうゆう保険の保険金額が最低Ｓの1,111.00米ドルに未達です。", "メッセージ文言");
    }

}
