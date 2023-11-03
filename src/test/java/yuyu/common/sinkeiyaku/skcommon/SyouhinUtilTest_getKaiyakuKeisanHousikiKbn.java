package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_KaiyakuKeisanHousikiKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 解約計算方式区分取得 のメソッド {@link SyouhinUtil#getKaiyakuKeisanHousikiKbn(String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SyouhinUtilTest_getKaiyakuKeisanHousikiKbn {

    @Inject
    private SyouhinUtil syouhinUtil;

    @Test
    @TestOrder(10)
    public void testGetKaiyakuKeisanHousikiKbn_S1() {
        C_KaiyakuKeisanHousikiKbn kaiyakuKeisanHousikiKbn  = syouhinUtil.getKaiyakuKeisanHousikiKbn("ﾆｱ");
        exClassificationEquals(kaiyakuKeisanHousikiKbn, C_KaiyakuKeisanHousikiKbn.RATE, "解約計算方式区分");
    }

    @Test
    @TestOrder(20)
    public void testGetKaiyakuKeisanHousikiKbn_S2() {
        C_KaiyakuKeisanHousikiKbn kaiyakuKeisanHousikiKbn  = syouhinUtil.getKaiyakuKeisanHousikiKbn("ﾕA");
        exClassificationEquals(kaiyakuKeisanHousikiKbn, C_KaiyakuKeisanHousikiKbn.BLNK, "解約計算方式区分");
    }
}
