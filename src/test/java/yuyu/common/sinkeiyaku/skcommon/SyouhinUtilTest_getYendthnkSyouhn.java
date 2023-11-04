package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 円建変更後商品取得 のメソッド {@link SyouhinUtil#getYendthnkSyouhn(String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SyouhinUtilTest_getYendthnkSyouhn {

    @Inject
    private SyouhinUtil syouhinUtil;

    @Test
    @TestOrder(10)
    public void testGetYendthnkSyouhn_T1() {
        boolean hanntei = syouhinUtil.getYendthnkSyouhn("ﾕA");
        exBooleanEquals(hanntei, true, "判定区分");
    }

    @Test
    @TestOrder(20)
    public void testGetYendthnkSyouhn_T2() {
        boolean hanntei = syouhinUtil.getYendthnkSyouhn("ﾕF");
        exBooleanEquals(hanntei, true, "判定区分");
    }

    @Test
    @TestOrder(30)
    public void testGetYendthnkSyouhn_T3() {
        boolean hanntei = syouhinUtil.getYendthnkSyouhn("ﾕB");
        exBooleanEquals(hanntei, true, "判定区分");
    }

    @Test
    @TestOrder(40)
    public void testGetYendthnkSyouhn_T4() {
        boolean hanntei = syouhinUtil.getYendthnkSyouhn("ﾕG");
        exBooleanEquals(hanntei, true, "判定区分");
    }

    @Test
    @TestOrder(50)
    public void testGetYendthnkSyouhn_T5() {
        boolean hanntei = syouhinUtil.getYendthnkSyouhn("ﾆｱ");
        exBooleanEquals(hanntei, false, "判定区分");
    }
}
