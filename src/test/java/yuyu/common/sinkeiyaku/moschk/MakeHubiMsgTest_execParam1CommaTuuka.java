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
public class MakeHubiMsgTest_execParam1CommaTuuka {

    @Test
    @TestOrder(20)
    public void testExecParam1CommaTuuka_G1() {

        String ret = MakeHubiMsg.execParam1CommaTuuka(MessageId.EHC0154, MessageId.EHC0154, BizCurrency.valueOf(1222,
            BizCurrencyTypes.YEN), "商品名１");
        exStringEquals(ret, "EHC0154 給付日額が最高日額の1,222円をオーバーしています。（商品名１）", "メッセージ文言");
    }

    @Test
    @TestOrder(20)
    public void testExecParam1CommaTuuka_G2() {

        String ret = MakeHubiMsg.execParam1CommaTuuka(MessageId.EHC0154, MessageId.EHC0154, BizCurrency.valueOf(1222,
            BizCurrencyTypes.EURO), "商品名１");
        exStringEquals(ret, "EHC0154 給付日額が最高日額の1,222.00ユーロをオーバーしています。（商品名１）", "メッセージ文言");
    }

}
