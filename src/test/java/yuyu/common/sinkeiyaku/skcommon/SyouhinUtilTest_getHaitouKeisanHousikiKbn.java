package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_HaitouKeisanHousikiKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 配当計算方式区分取得 のメソッド {@link SyouhinUtil#getHaitouKeisanHousikiKbn(String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SyouhinUtilTest_getHaitouKeisanHousikiKbn {

    @Inject
    private SyouhinUtil syouhinUtil;

    @Test
    @TestOrder(10)
    public void testGetHaitouKeisanHousikiKbn_R1() {
        C_HaitouKeisanHousikiKbn haitouKeisanHousikiKbn  = syouhinUtil.getHaitouKeisanHousikiKbn("ﾕｱ");
        exClassificationEquals(haitouKeisanHousikiKbn, C_HaitouKeisanHousikiKbn.RATE, "配当計算方式区分");
    }

    @Test
    @TestOrder(20)
    public void testGetHaitouKeisanHousikiKbn_R2() {
        C_HaitouKeisanHousikiKbn haitouKeisanHousikiKbn  = syouhinUtil.getHaitouKeisanHousikiKbn("ﾕA");
        exClassificationEquals(haitouKeisanHousikiKbn, C_HaitouKeisanHousikiKbn.RATE, "配当計算方式区分");
    }

    @Test
    @TestOrder(30)
    public void testGetHaitouKeisanHousikiKbn_R3() {
        C_HaitouKeisanHousikiKbn haitouKeisanHousikiKbn  = syouhinUtil.getHaitouKeisanHousikiKbn("ﾕﾉ");
        exClassificationEquals(haitouKeisanHousikiKbn, C_HaitouKeisanHousikiKbn.RATE, "配当計算方式区分");
    }

    @Test
    @TestOrder(40)
    public void testGetHaitouKeisanHousikiKbn_R4() {
        C_HaitouKeisanHousikiKbn haitouKeisanHousikiKbn  = syouhinUtil.getHaitouKeisanHousikiKbn("ﾆｱ");
        exClassificationEquals(haitouKeisanHousikiKbn, C_HaitouKeisanHousikiKbn.RATE, "配当計算方式区分");
    }

    @Test
    @TestOrder(50)
    public void testGetHaitouKeisanHousikiKbn_R5() {
        C_HaitouKeisanHousikiKbn haitouKeisanHousikiKbn  = syouhinUtil.getHaitouKeisanHousikiKbn("ﾕF");
        exClassificationEquals(haitouKeisanHousikiKbn, C_HaitouKeisanHousikiKbn.JITUGAKU, "配当計算方式区分");
    }

    @Test
    @TestOrder(60)
    public void testGetHaitouKeisanHousikiKbn_R6() {
        C_HaitouKeisanHousikiKbn haitouKeisanHousikiKbn  = syouhinUtil.getHaitouKeisanHousikiKbn("ﾕｹ");
        exClassificationEquals(haitouKeisanHousikiKbn, C_HaitouKeisanHousikiKbn.JITUGAKU, "配当計算方式区分");
    }

    @Test
    @TestOrder(70)
    public void testGetHaitouKeisanHousikiKbn_R7() {
        C_HaitouKeisanHousikiKbn haitouKeisanHousikiKbn  = syouhinUtil.getHaitouKeisanHousikiKbn("ﾕB");
        exClassificationEquals(haitouKeisanHousikiKbn, C_HaitouKeisanHousikiKbn.JITUGAKU, "配当計算方式区分");
    }

    @Test
    @TestOrder(80)
    public void testGetHaitouKeisanHousikiKbn_R8() {
        C_HaitouKeisanHousikiKbn haitouKeisanHousikiKbn  = syouhinUtil.getHaitouKeisanHousikiKbn("ﾕﾍ");
        exClassificationEquals(haitouKeisanHousikiKbn, C_HaitouKeisanHousikiKbn.JITUGAKU, "配当計算方式区分");
    }

    @Test
    @TestOrder(90)
    public void testGetHaitouKeisanHousikiKbn_R9() {
        C_HaitouKeisanHousikiKbn haitouKeisanHousikiKbn  = syouhinUtil.getHaitouKeisanHousikiKbn("ﾕG");
        exClassificationEquals(haitouKeisanHousikiKbn, C_HaitouKeisanHousikiKbn.JITUGAKU, "配当計算方式区分");
    }

    @Test
    @TestOrder(100)
    public void testGetHaitouKeisanHousikiKbn_R10() {
        C_HaitouKeisanHousikiKbn haitouKeisanHousikiKbn  = syouhinUtil.getHaitouKeisanHousikiKbn("ﾕﾁ");
        exClassificationEquals(haitouKeisanHousikiKbn, C_HaitouKeisanHousikiKbn.JITUGAKU, "配当計算方式区分");
    }

    @Test
    @TestOrder(110)
    public void testGetHaitouKeisanHousikiKbn_R11() {
        C_HaitouKeisanHousikiKbn haitouKeisanHousikiKbn  = syouhinUtil.getHaitouKeisanHousikiKbn("test");
        exClassificationEquals(haitouKeisanHousikiKbn, C_HaitouKeisanHousikiKbn.BLNK, "配当計算方式区分");
    }
}
