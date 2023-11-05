package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 商品属性ユーティリティのメソッド {@link SyouhinUtil#getSyouhinKeyToSaiteiPJhChk(String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SyouhinUtilTest_getSyouhinKeyToSaiteiPJhChk {

    @Inject
    private SyouhinUtil syouhinUtil;

    @Test
    @TestOrder(10)
    public void testGetSyouhinKeyToSaiteiPJhChk_O1() {

        String[] syoHinBetuKey1s  = syouhinUtil.getSyouhinKeyToSaiteiPJhChk("ﾕﾄ");
        exStringEquals(syoHinBetuKey1s[0], "33102", "商品別キー１配列[0]");
    }

    @Test
    @TestOrder(20)
    public void testGetSyouhinKeyToSaiteiPJhChk_O2() {

        String[] syoHinBetuKey1s  = syouhinUtil.getSyouhinKeyToSaiteiPJhChk("ﾕｱ");
        exStringEquals(syoHinBetuKey1s[0], "", "商品別キー１配列[0]");

    }
}
