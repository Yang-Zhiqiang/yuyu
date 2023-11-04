package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 商品属性ユーティリティのメソッド {@link SyouhinUtil#hantei(String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SyouhinUtilTest_henkouKubetuHantei {

    @Test
    @Transactional
    @TestOrder(10)
    public void testHenkouKubetuHantei_P1() {
        String syouhnCd = null;

        int syouhnKubun = SyouhinUtil.henkouKubetuHantei(syouhnCd);

        exNumericEquals(syouhnKubun, 9999, "商品判定区分");

    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testHenkouKubetuHantei_P2() {
        String syouhnCd = "";

        int syouhnKubun = SyouhinUtil.henkouKubetuHantei(syouhnCd);

        exNumericEquals(syouhnKubun, 9999, "商品判定区分");

    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testHenkouKubetuHantei_P3() {
        String syouhnCd = "ﾕｱ";

        int syouhnKubun = SyouhinUtil.henkouKubetuHantei(syouhnCd);

        exNumericEquals(syouhnKubun, 1041, "商品判定区分");

    }

    @Test
    @Transactional
    @TestOrder(40)
    public void testHenkouKubetuHantei_P4() {
        String syouhnCd = "ﾕｲ";

        int syouhnKubun = SyouhinUtil.henkouKubetuHantei(syouhnCd);

        exNumericEquals(syouhnKubun, 1041, "商品判定区分");

    }

    @Test
    @Transactional
    @TestOrder(50)
    public void testHenkouKubetuHantei_P5() {
        String syouhnCd = "ﾕｳ";

        int syouhnKubun = SyouhinUtil.henkouKubetuHantei(syouhnCd);

        exNumericEquals(syouhnKubun, 1041, "商品判定区分");

    }

    @Test
    @Transactional
    @TestOrder(60)
    public void testHenkouKubetuHantei_P6() {
        String syouhnCd = "ﾕｴ";

        int syouhnKubun = SyouhinUtil.henkouKubetuHantei(syouhnCd);

        exNumericEquals(syouhnKubun, 1041, "商品判定区分");

    }

    @Test
    @Transactional
    @TestOrder(70)
    public void testHenkouKubetuHantei_P7() {
        String syouhnCd = "ﾕｵ";

        int syouhnKubun = SyouhinUtil.henkouKubetuHantei(syouhnCd);

        exNumericEquals(syouhnKubun, 1041, "商品判定区分");

    }

    @Test
    @Transactional
    @TestOrder(80)
    public void testHenkouKubetuHantei_P8() {
        String syouhnCd = "ﾕｶ";

        int syouhnKubun = SyouhinUtil.henkouKubetuHantei(syouhnCd);

        exNumericEquals(syouhnKubun, 1041, "商品判定区分");

    }

    @Test
    @Transactional
    @TestOrder(90)
    public void testHenkouKubetuHantei_P9() {
        String syouhnCd = "ﾕｷ";

        int syouhnKubun = SyouhinUtil.henkouKubetuHantei(syouhnCd);

        exNumericEquals(syouhnKubun, 1041, "商品判定区分");

    }

    @Test
    @Transactional
    @TestOrder(100)
    public void testHenkouKubetuHantei_P10() {
        String syouhnCd = "ﾕｸ";

        int syouhnKubun = SyouhinUtil.henkouKubetuHantei(syouhnCd);

        exNumericEquals(syouhnKubun, 1041, "商品判定区分");

    }

    @Test
    @Transactional
    @TestOrder(110)
    public void testHenkouKubetuHantei_P11() {
        String syouhnCd = "ﾕA";

        int syouhnKubun = SyouhinUtil.henkouKubetuHantei(syouhnCd);

        exNumericEquals(syouhnKubun, 1042, "商品判定区分");

    }

    @Test
    @Transactional
    @TestOrder(120)
    public void testHenkouKubetuHantei_P12() {
        String syouhnCd = "ﾕｹ";

        int syouhnKubun = SyouhinUtil.henkouKubetuHantei(syouhnCd);

        exNumericEquals(syouhnKubun, 1051, "商品判定区分");

    }

    @Test
    @Transactional
    @TestOrder(130)
    public void testHenkouKubetuHantei_P13() {
        String syouhnCd = "ﾕｺ";

        int syouhnKubun = SyouhinUtil.henkouKubetuHantei(syouhnCd);

        exNumericEquals(syouhnKubun, 1051, "商品判定区分");

    }

    @Test
    @Transactional
    @TestOrder(140)
    public void testHenkouKubetuHantei_P14() {
        String syouhnCd = "ﾕｻ";

        int syouhnKubun = SyouhinUtil.henkouKubetuHantei(syouhnCd);

        exNumericEquals(syouhnKubun, 1051, "商品判定区分");

    }

    @Test
    @Transactional
    @TestOrder(150)
    public void testHenkouKubetuHantei_P15() {
        String syouhnCd = "ﾕｼ";

        int syouhnKubun = SyouhinUtil.henkouKubetuHantei(syouhnCd);

        exNumericEquals(syouhnKubun, 1051, "商品判定区分");

    }

    @Test
    @Transactional
    @TestOrder(160)
    public void testHenkouKubetuHantei_P16() {
        String syouhnCd = "ﾕｽ";

        int syouhnKubun = SyouhinUtil.henkouKubetuHantei(syouhnCd);

        exNumericEquals(syouhnKubun, 1051, "商品判定区分");

    }

    @Test
    @Transactional
    @TestOrder(170)
    public void testHenkouKubetuHantei_P17() {
        String syouhnCd = "ﾕｾ";

        int syouhnKubun = SyouhinUtil.henkouKubetuHantei(syouhnCd);

        exNumericEquals(syouhnKubun, 1051, "商品判定区分");

    }

    @Test
    @Transactional
    @TestOrder(180)
    public void testHenkouKubetuHantei_P18() {
        String syouhnCd = "ﾕｿ";

        int syouhnKubun = SyouhinUtil.henkouKubetuHantei(syouhnCd);

        exNumericEquals(syouhnKubun, 1051, "商品判定区分");

    }

    @Test
    @Transactional
    @TestOrder(190)
    public void testHenkouKubetuHantei_P19() {
        String syouhnCd = "ﾕﾀ";

        int syouhnKubun = SyouhinUtil.henkouKubetuHantei(syouhnCd);

        exNumericEquals(syouhnKubun, 1051, "商品判定区分");

    }

    @Test
    @Transactional
    @TestOrder(200)
    public void testHenkouKubetuHantei_P20() {
        String syouhnCd = "ﾕB";

        int syouhnKubun = SyouhinUtil.henkouKubetuHantei(syouhnCd);

        exNumericEquals(syouhnKubun, 1052, "商品判定区分");

    }

    @Test
    @Transactional
    @TestOrder(210)
    public void testHenkouKubetuHantei_P21() {
        String syouhnCd = "ﾕC";

        int syouhnKubun = SyouhinUtil.henkouKubetuHantei(syouhnCd);

        exNumericEquals(syouhnKubun, 1052, "商品判定区分");

    }

    @Test
    @Transactional
    @TestOrder(220)
    public void testHenkouKubetuHantei_P22() {
        String syouhnCd = "ﾕD";

        int syouhnKubun = SyouhinUtil.henkouKubetuHantei(syouhnCd);

        exNumericEquals(syouhnKubun, 1052, "商品判定区分");

    }

    @Test
    @Transactional
    @TestOrder(230)
    public void testHenkouKubetuHantei_P23() {
        String syouhnCd = "ﾕE";

        int syouhnKubun = SyouhinUtil.henkouKubetuHantei(syouhnCd);

        exNumericEquals(syouhnKubun, 1052, "商品判定区分");

    }

    @Test
    @Transactional
    @TestOrder(240)
    public void testHenkouKubetuHantei_P24() {
        String syouhnCd = "ﾕﾁ";

        int syouhnKubun = SyouhinUtil.henkouKubetuHantei(syouhnCd);

        exNumericEquals(syouhnKubun, 1060, "商品判定区分");

    }

    @Test
    @Transactional
    @TestOrder(250)
    public void testHenkouKubetuHantei_P25() {
        String syouhnCd = "ﾕﾂ";

        int syouhnKubun = SyouhinUtil.henkouKubetuHantei(syouhnCd);

        exNumericEquals(syouhnKubun, 1060, "商品判定区分");

    }

    @Test
    @Transactional
    @TestOrder(260)
    public void testHenkouKubetuHantei_P26() {
        String syouhnCd = "ﾕﾃ";

        int syouhnKubun = SyouhinUtil.henkouKubetuHantei(syouhnCd);

        exNumericEquals(syouhnKubun, 1060, "商品判定区分");

    }

    @Test
    @Transactional
    @TestOrder(270)
    public void testHenkouKubetuHantei_P27() {
        String syouhnCd = "ﾕﾄ";

        int syouhnKubun = SyouhinUtil.henkouKubetuHantei(syouhnCd);

        exNumericEquals(syouhnKubun, 1060, "商品判定区分");

    }

    @Test
    @Transactional
    @TestOrder(280)
    public void testHenkouKubetuHantei_P28() {
        String syouhnCd = "ﾕﾅ";

        int syouhnKubun = SyouhinUtil.henkouKubetuHantei(syouhnCd);

        exNumericEquals(syouhnKubun, 1060, "商品判定区分");

    }

    @Test
    @Transactional
    @TestOrder(290)
    public void testHenkouKubetuHantei_P29() {
        String syouhnCd = "ﾕﾆ";

        int syouhnKubun = SyouhinUtil.henkouKubetuHantei(syouhnCd);

        exNumericEquals(syouhnKubun, 1060, "商品判定区分");

    }

    @Test
    @Transactional
    @TestOrder(300)
    public void testHenkouKubetuHantei_P30() {
        String syouhnCd = "ﾕﾇ";

        int syouhnKubun = SyouhinUtil.henkouKubetuHantei(syouhnCd);

        exNumericEquals(syouhnKubun, 1060, "商品判定区分");

    }

    @Test
    @Transactional
    @TestOrder(310)
    public void testHenkouKubetuHantei_P31() {
        String syouhnCd = "ﾕﾈ";

        int syouhnKubun = SyouhinUtil.henkouKubetuHantei(syouhnCd);

        exNumericEquals(syouhnKubun, 1060, "商品判定区分");

    }

    @Test
    @Transactional
    @TestOrder(320)
    public void testHenkouKubetuHantei_P32() {
        String syouhnCd = "test";

        int syouhnKubun = SyouhinUtil.henkouKubetuHantei(syouhnCd);

        exNumericEquals(syouhnKubun, 9999, "商品判定区分");

    }

    @Test
    @Transactional
    @TestOrder(330)
    public void testHenkouKubetuHantei_P33() {
        String syouhnCd = "ﾕF";

        int syouhnKubun = SyouhinUtil.henkouKubetuHantei(syouhnCd);

        exNumericEquals(syouhnKubun, 1072, "商品判定区分");

    }

    @Test
    @Transactional
    @TestOrder(340)
    public void testHenkouKubetuHantei_P34() {
        String syouhnCd = "ﾕﾉ";

        int syouhnKubun = SyouhinUtil.henkouKubetuHantei(syouhnCd);

        exNumericEquals(syouhnKubun, 1071, "商品判定区分");

    }

    @Test
    @Transactional
    @TestOrder(350)
    public void testHenkouKubetuHantei_P35() {
        String syouhnCd = "ﾕﾊ";

        int syouhnKubun = SyouhinUtil.henkouKubetuHantei(syouhnCd);

        exNumericEquals(syouhnKubun, 1071, "商品判定区分");

    }

    @Test
    @Transactional
    @TestOrder(360)
    public void testHenkouKubetuHantei_P36() {
        String syouhnCd = "ﾕﾋ";

        int syouhnKubun = SyouhinUtil.henkouKubetuHantei(syouhnCd);

        exNumericEquals(syouhnKubun, 1071, "商品判定区分");

    }

    @Test
    @Transactional
    @TestOrder(370)
    public void testHenkouKubetuHantei_P37() {
        String syouhnCd = "ﾕﾌ";

        int syouhnKubun = SyouhinUtil.henkouKubetuHantei(syouhnCd);

        exNumericEquals(syouhnKubun, 1071, "商品判定区分");

    }

    @Test
    @Transactional
    @TestOrder(380)
    public void testHenkouKubetuHantei_P38() {
        String syouhnCd = "ﾕﾍ";

        int syouhnKubun = SyouhinUtil.henkouKubetuHantei(syouhnCd);

        exNumericEquals(syouhnKubun, 1081, "商品判定区分");

    }

    @Test
    @Transactional
    @TestOrder(390)
    public void testHenkouKubetuHantei_P39() {
        String syouhnCd = "ﾕﾎ";

        int syouhnKubun = SyouhinUtil.henkouKubetuHantei(syouhnCd);

        exNumericEquals(syouhnKubun, 1081, "商品判定区分");

    }

    @Test
    @Transactional
    @TestOrder(400)
    public void testHenkouKubetuHantei_P40() {
        String syouhnCd = "ﾕﾏ";

        int syouhnKubun = SyouhinUtil.henkouKubetuHantei(syouhnCd);

        exNumericEquals(syouhnKubun, 1081, "商品判定区分");

    }

    @Test
    @Transactional
    @TestOrder(410)
    public void testHenkouKubetuHantei_P41() {
        String syouhnCd = "ﾕﾐ";

        int syouhnKubun = SyouhinUtil.henkouKubetuHantei(syouhnCd);

        exNumericEquals(syouhnKubun, 1081, "商品判定区分");

    }

    @Test
    @Transactional
    @TestOrder(420)
    public void testHenkouKubetuHantei_P42() {
        String syouhnCd = "ﾕﾑ";

        int syouhnKubun = SyouhinUtil.henkouKubetuHantei(syouhnCd);

        exNumericEquals(syouhnKubun, 1081, "商品判定区分");

    }

    @Test
    @Transactional
    @TestOrder(430)
    public void testHenkouKubetuHantei_P43() {
        String syouhnCd = "ﾕﾒ";

        int syouhnKubun = SyouhinUtil.henkouKubetuHantei(syouhnCd);

        exNumericEquals(syouhnKubun, 1081, "商品判定区分");

    }

    @Test
    @Transactional
    @TestOrder(440)
    public void testHenkouKubetuHantei_P44() {
        String syouhnCd = "ﾕﾓ";

        int syouhnKubun = SyouhinUtil.henkouKubetuHantei(syouhnCd);

        exNumericEquals(syouhnKubun, 1081, "商品判定区分");

    }

    @Test
    @Transactional
    @TestOrder(450)
    public void testHenkouKubetuHantei_P45() {
        String syouhnCd = "ﾕﾔ";

        int syouhnKubun = SyouhinUtil.henkouKubetuHantei(syouhnCd);

        exNumericEquals(syouhnKubun, 1081, "商品判定区分");

    }

    @Test
    @Transactional
    @TestOrder(460)
    public void testHenkouKubetuHantei_P46() {
        String syouhnCd = "ﾕﾕ";

        int syouhnKubun = SyouhinUtil.henkouKubetuHantei(syouhnCd);

        exNumericEquals(syouhnKubun, 1081, "商品判定区分");

    }

    @Test
    @Transactional
    @TestOrder(470)
    public void testHenkouKubetuHantei_P47() {
        String syouhnCd = "ﾕﾖ";

        int syouhnKubun = SyouhinUtil.henkouKubetuHantei(syouhnCd);

        exNumericEquals(syouhnKubun, 1081, "商品判定区分");

    }

    @Test
    @Transactional
    @TestOrder(480)
    public void testHenkouKubetuHantei_P48() {
        String syouhnCd = "ﾕﾗ";

        int syouhnKubun = SyouhinUtil.henkouKubetuHantei(syouhnCd);

        exNumericEquals(syouhnKubun, 1081, "商品判定区分");

    }

    @Test
    @Transactional
    @TestOrder(490)
    public void testHenkouKubetuHantei_P49() {
        String syouhnCd = "ﾕﾘ";

        int syouhnKubun = SyouhinUtil.henkouKubetuHantei(syouhnCd);

        exNumericEquals(syouhnKubun, 1081, "商品判定区分");

    }

    @Test
    @Transactional
    @TestOrder(500)
    public void testHenkouKubetuHantei_P50() {
        String syouhnCd = "ﾕﾙ";

        int syouhnKubun = SyouhinUtil.henkouKubetuHantei(syouhnCd);

        exNumericEquals(syouhnKubun, 1081, "商品判定区分");

    }

    @Test
    @Transactional
    @TestOrder(510)
    public void testHenkouKubetuHantei_P51() {
        String syouhnCd = "ﾕﾚ";

        int syouhnKubun = SyouhinUtil.henkouKubetuHantei(syouhnCd);

        exNumericEquals(syouhnKubun, 1081, "商品判定区分");

    }

    @Test
    @Transactional
    @TestOrder(520)
    public void testHenkouKubetuHantei_P52() {
        String syouhnCd = "ﾕﾛ";

        int syouhnKubun = SyouhinUtil.henkouKubetuHantei(syouhnCd);

        exNumericEquals(syouhnKubun, 1081, "商品判定区分");

    }

    @Test
    @Transactional
    @TestOrder(530)
    public void testHenkouKubetuHantei_P53() {
        String syouhnCd = "ﾕﾜ";

        int syouhnKubun = SyouhinUtil.henkouKubetuHantei(syouhnCd);

        exNumericEquals(syouhnKubun, 1081, "商品判定区分");

    }

    @Test
    @Transactional
    @TestOrder(540)
    public void testHenkouKubetuHantei_P54() {
        String syouhnCd = "ﾕG";

        int syouhnKubun = SyouhinUtil.henkouKubetuHantei(syouhnCd);

        exNumericEquals(syouhnKubun, 1082, "商品判定区分");

    }

    @Test
    @Transactional
    @TestOrder(550)
    public void testHenkouKubetuHantei_P55() {
        String syouhnCd = "ﾕH";

        int syouhnKubun = SyouhinUtil.henkouKubetuHantei(syouhnCd);

        exNumericEquals(syouhnKubun, 1082, "商品判定区分");

    }

    @Test
    @Transactional
    @TestOrder(560)
    public void testHenkouKubetuHantei_P56() {
        String syouhnCd = "ﾕJ";

        int syouhnKubun = SyouhinUtil.henkouKubetuHantei(syouhnCd);

        exNumericEquals(syouhnKubun, 1082, "商品判定区分");

    }

    @Test
    @Transactional
    @TestOrder(570)
    public void testHenkouKubetuHantei_P57() {
        String syouhnCd = "ﾕK";

        int syouhnKubun = SyouhinUtil.henkouKubetuHantei(syouhnCd);

        exNumericEquals(syouhnKubun, 1082, "商品判定区分");

    }

    @Test
    @Transactional
    @TestOrder(580)
    public void testHenkouKubetuHantei_P58() {
        String syouhnCd = "ﾆｱ";

        int syouhnKubun = SyouhinUtil.henkouKubetuHantei(syouhnCd);

        exNumericEquals(syouhnKubun, 1090, "商品判定区分");

    }
}
