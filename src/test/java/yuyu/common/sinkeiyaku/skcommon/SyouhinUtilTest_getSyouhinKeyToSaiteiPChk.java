package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 商品属性ユーティリティのメソッド {@link SyouhinUtil#getSyouhinKeyToSaiteiPChk(String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SyouhinUtilTest_getSyouhinKeyToSaiteiPChk {

    @Inject
    private SyouhinUtil syouhinUtil;

    @Test
    @TestOrder(10)
    public void testGetSyouhinKeyToSaiteiPChk_N1() {

        String[] syoHinBetuKey1s  = syouhinUtil.getSyouhinKeyToSaiteiPChk("ﾕﾄ");
        exNumericEquals(syoHinBetuKey1s.length, 2, "商品別キー１配列のサイズ");
        exStringEquals(syoHinBetuKey1s[0], "33101", "商品別キー１配列[0]");
        exStringEquals(syoHinBetuKey1s[1], "33102", "商品別キー１配列[1]");

    }

    @Test
    @TestOrder(20)
    public void testGetSyouhinKeyToSaiteiPChk_N2() {

        String[] syoHinBetuKey1s  = syouhinUtil.getSyouhinKeyToSaiteiPChk("ﾕｱ");
        exNumericEquals(syoHinBetuKey1s.length, 1, "商品別キー１配列のサイズ");
        exStringEquals(syoHinBetuKey1s[0], "", "商品別キー１配列[0]");

    }
}
