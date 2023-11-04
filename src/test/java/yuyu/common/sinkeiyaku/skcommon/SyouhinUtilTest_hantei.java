package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 商品属性ユーティリティのメソッド {@link SyouhinUtil#hantei(String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SyouhinUtilTest_hantei {

    @Test
    @Transactional
    @TestOrder(10)
    public void testHantei_A1() {
        String syouhnCd = null;
        int syouhnKubun = SyouhinUtil.hantei(syouhnCd);

        exNumericEquals(syouhnKubun, 999, "商品判定区分");

    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testHantei_A2() {
        String syouhnCd = "";
        int syouhnKubun = SyouhinUtil.hantei(syouhnCd);

        exNumericEquals(syouhnKubun, 999, "商品判定区分");

    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testHantei_A3() {
        String syouhnCd = "a1";
        int syouhnKubun = SyouhinUtil.hantei(syouhnCd);

        exNumericEquals(syouhnKubun, 999, "商品判定区分");

    }

    @Test
    @Transactional
    @TestOrder(40)
    public void testHantei_A4() {
        String syouhnCd = "ｱ1";
        int syouhnKubun = SyouhinUtil.hantei(syouhnCd);

        exNumericEquals(syouhnKubun, 101, "商品判定区分");

    }

    @Test
    @Transactional
    @TestOrder(50)
    public void testHantei_A5() {
        String syouhnCd = "ｱ2";
        int syouhnKubun = SyouhinUtil.hantei(syouhnCd);

        exNumericEquals(syouhnKubun, 101, "商品判定区分");

    }

    @Test
    @Transactional
    @TestOrder(60)
    public void testHantei_A6() {
        String syouhnCd = "ｲ1";
        int syouhnKubun = SyouhinUtil.hantei(syouhnCd);

        exNumericEquals(syouhnKubun, 102, "商品判定区分");

    }

    @Test
    @Transactional
    @TestOrder(70)
    public void testHantei_A7() {
        String syouhnCd = "ｲ2";
        int syouhnKubun = SyouhinUtil.hantei(syouhnCd);

        exNumericEquals(syouhnKubun, 102, "商品判定区分");

    }

    @Test
    @Transactional
    @TestOrder(80)
    public void testHantei_A8() {
        String syouhnCd = "ｳ1";
        int syouhnKubun = SyouhinUtil.hantei(syouhnCd);

        exNumericEquals(syouhnKubun, 103, "商品判定区分");

    }

    @Test
    @Transactional
    @TestOrder(90)
    public void testHantei_A9() {
        String syouhnCd = "ｳ2";
        int syouhnKubun = SyouhinUtil.hantei(syouhnCd);

        exNumericEquals(syouhnKubun, 103, "商品判定区分");

        MockObjectManager.initialize();

    }

    @Test
    @Transactional
    @TestOrder(100)
    public void testHantei_A10() {
        String syouhnCd = "ﾕｹ";
        int syouhnKubun = SyouhinUtil.hantei(syouhnCd);

        exNumericEquals(syouhnKubun, 105, "商品判定区分");

        MockObjectManager.initialize();

    }

    @Test
    @Transactional
    @TestOrder(110)
    public void testHantei_A11() {
        String syouhnCd = "ﾕｺ";
        int syouhnKubun = SyouhinUtil.hantei(syouhnCd);

        exNumericEquals(syouhnKubun, 105, "商品判定区分");

        MockObjectManager.initialize();

    }

    @Test
    @Transactional
    @TestOrder(120)
    public void testHantei_A12() {
        String syouhnCd = "ﾕｻ";
        int syouhnKubun = SyouhinUtil.hantei(syouhnCd);

        exNumericEquals(syouhnKubun, 105, "商品判定区分");

        MockObjectManager.initialize();

    }

    @Test
    @Transactional
    @TestOrder(130)
    public void testHantei_A13() {
        String syouhnCd = "ﾕｼ";
        int syouhnKubun = SyouhinUtil.hantei(syouhnCd);

        exNumericEquals(syouhnKubun, 105, "商品判定区分");

        MockObjectManager.initialize();

    }

    @Test
    @Transactional
    @TestOrder(140)
    public void testHantei_A14() {
        String syouhnCd = "ﾕｽ";
        int syouhnKubun = SyouhinUtil.hantei(syouhnCd);

        exNumericEquals(syouhnKubun, 105, "商品判定区分");

        MockObjectManager.initialize();

    }

    @Test
    @Transactional
    @TestOrder(150)
    public void testHantei_A15() {
        String syouhnCd = "ﾕｾ";
        int syouhnKubun = SyouhinUtil.hantei(syouhnCd);

        exNumericEquals(syouhnKubun, 105, "商品判定区分");

        MockObjectManager.initialize();

    }

    @Test
    @Transactional
    @TestOrder(160)
    public void testHantei_A16() {
        String syouhnCd = "ﾕｿ";
        int syouhnKubun = SyouhinUtil.hantei(syouhnCd);

        exNumericEquals(syouhnKubun, 105, "商品判定区分");

        MockObjectManager.initialize();

    }

    @Test
    @Transactional
    @TestOrder(170)
    public void testHantei_A17() {
        String syouhnCd = "ﾕﾀ";
        int syouhnKubun = SyouhinUtil.hantei(syouhnCd);

        exNumericEquals(syouhnKubun, 105, "商品判定区分");

        MockObjectManager.initialize();

    }

    @Test
    @Transactional
    @TestOrder(180)
    public void testHantei_A18() {
        String syouhnCd = "ﾕA";
        int syouhnKubun = SyouhinUtil.hantei(syouhnCd);

        exNumericEquals(syouhnKubun, 104, "商品判定区分");

        MockObjectManager.initialize();

    }

    @Test
    @Transactional
    @TestOrder(190)
    public void testHantei_A19() {
        String syouhnCd = "ﾕB";
        int syouhnKubun = SyouhinUtil.hantei(syouhnCd);

        exNumericEquals(syouhnKubun, 105, "商品判定区分");

        MockObjectManager.initialize();

    }

    @Test
    @Transactional
    @TestOrder(200)
    public void testHantei_A20() {
        String syouhnCd = "ﾕC";
        int syouhnKubun = SyouhinUtil.hantei(syouhnCd);

        exNumericEquals(syouhnKubun, 105, "商品判定区分");

        MockObjectManager.initialize();

    }

    @Test
    @Transactional
    @TestOrder(210)
    public void testHantei_A21() {
        String syouhnCd = "ﾕD";
        int syouhnKubun = SyouhinUtil.hantei(syouhnCd);

        exNumericEquals(syouhnKubun, 105, "商品判定区分");

        MockObjectManager.initialize();

    }

    @Test
    @Transactional
    @TestOrder(220)
    public void testHantei_A22() {
        String syouhnCd = "ﾕE";
        int syouhnKubun = SyouhinUtil.hantei(syouhnCd);

        exNumericEquals(syouhnKubun, 105, "商品判定区分");

        MockObjectManager.initialize();

    }

    @Test
    @Transactional
    @TestOrder(230)
    public void testHantei_A23() {
        String syouhnCd = "ﾕﾁ";
        int syouhnKubun = SyouhinUtil.hantei(syouhnCd);

        exNumericEquals(syouhnKubun, 106, "商品判定区分");

        MockObjectManager.initialize();

    }

    @Test
    @Transactional
    @TestOrder(240)
    public void testHantei_A24() {
        String syouhnCd = "ﾕﾂ";
        int syouhnKubun = SyouhinUtil.hantei(syouhnCd);

        exNumericEquals(syouhnKubun, 106, "商品判定区分");

        MockObjectManager.initialize();

    }

    @Test
    @Transactional
    @TestOrder(250)
    public void testHantei_A25() {
        String syouhnCd = "ﾕﾃ";
        int syouhnKubun = SyouhinUtil.hantei(syouhnCd);

        exNumericEquals(syouhnKubun, 106, "商品判定区分");

        MockObjectManager.initialize();

    }

    @Test
    @Transactional
    @TestOrder(260)
    public void testHantei_A26() {
        String syouhnCd = "ﾕﾄ";
        int syouhnKubun = SyouhinUtil.hantei(syouhnCd);

        exNumericEquals(syouhnKubun, 106, "商品判定区分");

        MockObjectManager.initialize();

    }

    @Test
    @Transactional
    @TestOrder(270)
    public void testHantei_A27() {
        String syouhnCd = "ﾕﾅ";
        int syouhnKubun = SyouhinUtil.hantei(syouhnCd);

        exNumericEquals(syouhnKubun, 106, "商品判定区分");

        MockObjectManager.initialize();

    }

    @Test
    @Transactional
    @TestOrder(280)
    public void testHantei_A28() {
        String syouhnCd = "ﾕﾆ";
        int syouhnKubun = SyouhinUtil.hantei(syouhnCd);

        exNumericEquals(syouhnKubun, 106, "商品判定区分");

        MockObjectManager.initialize();

    }

    @Test
    @Transactional
    @TestOrder(290)
    public void testHantei_A29() {
        String syouhnCd = "ﾕﾇ";
        int syouhnKubun = SyouhinUtil.hantei(syouhnCd);

        exNumericEquals(syouhnKubun, 106, "商品判定区分");

        MockObjectManager.initialize();

    }

    @Test
    @Transactional
    @TestOrder(300)
    public void testHantei_A30() {
        String syouhnCd = "ﾕﾈ";
        int syouhnKubun = SyouhinUtil.hantei(syouhnCd);

        exNumericEquals(syouhnKubun, 106, "商品判定区分");

        MockObjectManager.initialize();

    }

    @Test
    @Transactional
    @TestOrder(310)
    public void testHantei_A31() {
        String syouhnCd = "ﾕﾉ";
        int syouhnKubun = SyouhinUtil.hantei(syouhnCd);

        exNumericEquals(syouhnKubun, 107, "商品判定区分");

        MockObjectManager.initialize();

    }

    @Test
    @Transactional
    @TestOrder(320)
    public void testHantei_A32() {
        String syouhnCd = "ﾕﾊ";
        int syouhnKubun = SyouhinUtil.hantei(syouhnCd);

        exNumericEquals(syouhnKubun, 107, "商品判定区分");

        MockObjectManager.initialize();

    }

    @Test
    @Transactional
    @TestOrder(330)
    public void testHantei_A33() {
        String syouhnCd = "ﾕﾋ";
        int syouhnKubun = SyouhinUtil.hantei(syouhnCd);

        exNumericEquals(syouhnKubun, 107, "商品判定区分");

        MockObjectManager.initialize();

    }

    @Test
    @Transactional
    @TestOrder(340)
    public void testHantei_A34() {
        String syouhnCd = "ﾕﾌ";
        int syouhnKubun = SyouhinUtil.hantei(syouhnCd);

        exNumericEquals(syouhnKubun, 107, "商品判定区分");

        MockObjectManager.initialize();

    }

    @Test
    @Transactional
    @TestOrder(350)
    public void testHantei_A35() {
        String syouhnCd = "ﾕF";
        int syouhnKubun = SyouhinUtil.hantei(syouhnCd);

        exNumericEquals(syouhnKubun, 107, "商品判定区分");

        MockObjectManager.initialize();

    }

    @Test
    @Transactional
    @TestOrder(360)
    public void testHantei_A36() {
        String syouhnCd = "ﾕﾍ";
        int syouhnKubun = SyouhinUtil.hantei(syouhnCd);

        exNumericEquals(syouhnKubun, 108, "商品判定区分");
    }

    @Test
    @Transactional
    @TestOrder(370)
    public void testHantei_A37() {
        String syouhnCd = "ﾕﾎ";
        int syouhnKubun = SyouhinUtil.hantei(syouhnCd);

        exNumericEquals(syouhnKubun, 108, "商品判定区分");
    }

    @Test
    @Transactional
    @TestOrder(380)
    public void testHantei_A38() {
        String syouhnCd = "ﾕﾏ";
        int syouhnKubun = SyouhinUtil.hantei(syouhnCd);

        exNumericEquals(syouhnKubun, 108, "商品判定区分");
    }

    @Test
    @Transactional
    @TestOrder(390)
    public void testHantei_A39() {
        String syouhnCd = "ﾕﾐ";
        int syouhnKubun = SyouhinUtil.hantei(syouhnCd);

        exNumericEquals(syouhnKubun, 108, "商品判定区分");
    }

    @Test
    @Transactional
    @TestOrder(400)
    public void testHantei_A40() {
        String syouhnCd = "ﾕﾑ";
        int syouhnKubun = SyouhinUtil.hantei(syouhnCd);

        exNumericEquals(syouhnKubun, 108, "商品判定区分");
    }

    @Test
    @Transactional
    @TestOrder(410)
    public void testHantei_A41() {
        String syouhnCd = "ﾕﾒ";
        int syouhnKubun = SyouhinUtil.hantei(syouhnCd);

        exNumericEquals(syouhnKubun, 108, "商品判定区分");
    }

    @Test
    @Transactional
    @TestOrder(420)
    public void testHantei_A42() {
        String syouhnCd = "ﾕﾓ";
        int syouhnKubun = SyouhinUtil.hantei(syouhnCd);

        exNumericEquals(syouhnKubun, 108, "商品判定区分");
    }

    @Test
    @Transactional
    @TestOrder(430)
    public void testHantei_A43() {
        String syouhnCd = "ﾕﾔ";
        int syouhnKubun = SyouhinUtil.hantei(syouhnCd);

        exNumericEquals(syouhnKubun, 108, "商品判定区分");
    }

    @Test
    @Transactional
    @TestOrder(440)
    public void testHantei_A44() {
        String syouhnCd = "ﾕﾕ";
        int syouhnKubun = SyouhinUtil.hantei(syouhnCd);

        exNumericEquals(syouhnKubun, 108, "商品判定区分");
    }

    @Test
    @Transactional
    @TestOrder(450)
    public void testHantei_A45() {
        String syouhnCd = "ﾕﾖ";
        int syouhnKubun = SyouhinUtil.hantei(syouhnCd);

        exNumericEquals(syouhnKubun, 108, "商品判定区分");
    }

    @Test
    @Transactional
    @TestOrder(460)
    public void testHantei_A46() {
        String syouhnCd = "ﾕﾗ";
        int syouhnKubun = SyouhinUtil.hantei(syouhnCd);

        exNumericEquals(syouhnKubun, 108, "商品判定区分");
    }

    @Test
    @Transactional
    @TestOrder(470)
    public void testHantei_A47() {
        String syouhnCd = "ﾕﾘ";
        int syouhnKubun = SyouhinUtil.hantei(syouhnCd);

        exNumericEquals(syouhnKubun, 108, "商品判定区分");
    }

    @Test
    @Transactional
    @TestOrder(480)
    public void testHantei_A48() {
        String syouhnCd = "ﾕﾙ";
        int syouhnKubun = SyouhinUtil.hantei(syouhnCd);

        exNumericEquals(syouhnKubun, 108, "商品判定区分");
    }

    @Test
    @Transactional
    @TestOrder(490)
    public void testHantei_A49() {
        String syouhnCd = "ﾕﾚ";
        int syouhnKubun = SyouhinUtil.hantei(syouhnCd);

        exNumericEquals(syouhnKubun, 108, "商品判定区分");
    }

    @Test
    @Transactional
    @TestOrder(500)
    public void testHantei_A50() {
        String syouhnCd = "ﾕﾛ";
        int syouhnKubun = SyouhinUtil.hantei(syouhnCd);

        exNumericEquals(syouhnKubun, 108, "商品判定区分");
    }

    @Test
    @Transactional
    @TestOrder(510)
    public void testHantei_A51() {
        String syouhnCd = "ﾕﾜ";
        int syouhnKubun = SyouhinUtil.hantei(syouhnCd);

        exNumericEquals(syouhnKubun, 108, "商品判定区分");
    }

    @Test
    @Transactional
    @TestOrder(520)
    public void testHantei_A52() {
        String syouhnCd = "ﾕG";
        int syouhnKubun = SyouhinUtil.hantei(syouhnCd);

        exNumericEquals(syouhnKubun, 108, "商品判定区分");
    }

    @Test
    @Transactional
    @TestOrder(530)
    public void testHantei_A53() {
        String syouhnCd = "ﾕH";
        int syouhnKubun = SyouhinUtil.hantei(syouhnCd);

        exNumericEquals(syouhnKubun, 108, "商品判定区分");
    }

    @Test
    @Transactional
    @TestOrder(540)
    public void testHantei_A54() {
        String syouhnCd = "ﾕJ";
        int syouhnKubun = SyouhinUtil.hantei(syouhnCd);

        exNumericEquals(syouhnKubun, 108, "商品判定区分");
    }

    @Test
    @Transactional
    @TestOrder(550)
    public void testHantei_A55() {
        String syouhnCd = "ﾕK";
        int syouhnKubun = SyouhinUtil.hantei(syouhnCd);

        exNumericEquals(syouhnKubun, 108, "商品判定区分");
    }

    @Test
    @Transactional
    @TestOrder(560)
    public void testHantei_A56() {
        String syouhnCd = "ﾆｱ";
        int syouhnKubun = SyouhinUtil.hantei(syouhnCd);

        exNumericEquals(syouhnKubun, 109, "商品判定区分");
    }
}
