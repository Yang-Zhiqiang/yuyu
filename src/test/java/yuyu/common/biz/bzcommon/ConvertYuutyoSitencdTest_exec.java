package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ゆうちょ銀行支店コード変換クラスのメソッド {@link ConvertYuutyoSitencd#exec(String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class ConvertYuutyoSitencdTest_exec {

    @Inject
    private ConvertYuutyoSitencd convertYuutyoSitencd;

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        String sitencd = "123456";

        String hrkmSitencd = convertYuutyoSitencd.exec(sitencd);

        exStringEquals(hrkmSitencd, "123456", "振込用支店コード");

    }
    @Test
    @TestOrder(20)
    public void testExec_A2() {

        String sitencd = "246";

        String hrkmSitencd = convertYuutyoSitencd.exec(sitencd);

        exStringEquals(hrkmSitencd, "248", "振込用支店コード");

    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        String sitencd = "000";

        String hrkmSitencd = convertYuutyoSitencd.exec(sitencd);

        exStringEquals(hrkmSitencd, "008", "振込用支店コード");

    }

}