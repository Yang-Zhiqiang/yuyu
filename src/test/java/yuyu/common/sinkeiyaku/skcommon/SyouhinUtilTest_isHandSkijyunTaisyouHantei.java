package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.dgic.testing.common.virtualmock.MockObjectManager;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 商品属性ユーティリティのメソッド {@link SyouhinUtil#isHandSkijyunTaisyouHantei(String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SyouhinUtilTest_isHandSkijyunTaisyouHantei {

    @Test
    @TestOrder(10)
    public void testIsHandSkijyunTaisyouHantei_I1() {
        String syouhnCd = null;

        boolean hanDeiFlg  = SyouhinUtil.isHandSkijyunTaisyouHantei(syouhnCd);
        exBooleanEquals(hanDeiFlg, false, "判定区分");
    }

    @Test
    @TestOrder(20)
    public void testIsHandSkijyunTaisyouHantei_I2() {
        String syouhnCd = "";

        boolean hanDeiFlg  = SyouhinUtil.isHandSkijyunTaisyouHantei(syouhnCd);
        exBooleanEquals(hanDeiFlg, false, "判定区分");
    }

    @Test
    @TestOrder(30)
    public void testIsHandSkijyunTaisyouHantei_I3() {
        String syouhnCd = "ｱ1";
        boolean hanDeiFlg  = SyouhinUtil.isHandSkijyunTaisyouHantei(syouhnCd);
        exBooleanEquals(hanDeiFlg, true, "判定区分");

    }

    @Test
    @TestOrder(40)
    public void testIsHandSkijyunTaisyouHantei_I4() {
        String syouhnCd = "ｲ1";
        boolean hanDeiFlg  = SyouhinUtil.isHandSkijyunTaisyouHantei(syouhnCd);
        exBooleanEquals(hanDeiFlg, true, "判定区分");

    }

    @Test
    @TestOrder(50)
    public void testIsHandSkijyunTaisyouHantei_I5() {
        String syouhnCd = "ｳ1";
        boolean hanDeiFlg  = SyouhinUtil.isHandSkijyunTaisyouHantei(syouhnCd);
        exBooleanEquals(hanDeiFlg, false, "判定区分");

        MockObjectManager.initialize();

    }
}
