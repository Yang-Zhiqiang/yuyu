package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_TkykTratkiKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 外貨入金特約取扱判定のメソッド {@link DrtenTkykTratkiHantei#gaikanykntkTratkiHantei(C_UmuKbn,C_SkeijimuKbn,String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class DrtenTkykTratkiHanteiTest_gaikanykntkTratkiHantei {

    @Inject
    private DrtenTkykTratkiHantei drtenTkykTratkiHantei;

    @Test
    @TestOrder(10)
    public void testGaikanykntkTratkiHantei_A1() {
        String syouhincd = "ﾕｱ";
        C_UmuKbn gaikanyuukintktekiumu = C_UmuKbn.NONE;
        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.SMBC;
        String oyadrtencd = "";
        C_TkykTratkiKbn tkykTratkiKbn = drtenTkykTratkiHantei.gaikanykntkTratkiHantei(syouhincd, gaikanyuukintktekiumu,
            skeijimuKbn, oyadrtencd);

        exClassificationEquals(tkykTratkiKbn, C_TkykTratkiKbn.TRATKINASI, "特約取扱区分");

    }

    @Test
    @TestOrder(20)
    public void testGaikanykntkTratkiHantei_A2() {
        String syouhincd = "ﾕｲ";
        C_UmuKbn gaikanyuukintktekiumu = C_UmuKbn.ARI;
        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.SMTB;
        String oyadrtencd = "5100001";
        C_TkykTratkiKbn tkykTratkiKbn = drtenTkykTratkiHantei.gaikanykntkTratkiHantei(syouhincd, gaikanyuukintktekiumu,
            skeijimuKbn, oyadrtencd);

        exClassificationEquals(tkykTratkiKbn, C_TkykTratkiKbn.TRATKINASI, "特約取扱区分");

    }

    @Test
    @TestOrder(30)
    public void testGaikanykntkTratkiHantei_A3() {
        String syouhincd = "ﾕｳ";
        C_UmuKbn gaikanyuukintktekiumu = C_UmuKbn.ARI;
        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.SMTB;
        String oyadrtencd = "2101079";
        C_TkykTratkiKbn tkykTratkiKbn = drtenTkykTratkiHantei.gaikanykntkTratkiHantei(syouhincd, gaikanyuukintktekiumu,
            skeijimuKbn, oyadrtencd);

        exClassificationEquals(tkykTratkiKbn, C_TkykTratkiKbn.HUKAKANOU, "特約取扱区分");

    }

    @Test
    @TestOrder(40)
    public void testGaikanykntkTratkiHantei_A4() {
        String syouhincd = "ﾕｴ";
        C_UmuKbn gaikanyuukintktekiumu = C_UmuKbn.ARI;
        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.SMTB;
        String oyadrtencd = "5102152";
        C_TkykTratkiKbn tkykTratkiKbn = drtenTkykTratkiHantei.gaikanykntkTratkiHantei(syouhincd, gaikanyuukintktekiumu,
            skeijimuKbn, oyadrtencd);

        exClassificationEquals(tkykTratkiKbn, C_TkykTratkiKbn.TRATKINASI, "特約取扱区分");

    }

    @Test
    @TestOrder(50)
    public void testGaikanykntkTratkiHantei_A5() {
        String syouhincd = "ﾕｵ";
        C_UmuKbn gaikanyuukintktekiumu = C_UmuKbn.ARI;
        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.SMTB;
        String oyadrtencd = "other";
        C_TkykTratkiKbn tkykTratkiKbn = drtenTkykTratkiHantei.gaikanykntkTratkiHantei(syouhincd, gaikanyuukintktekiumu,
            skeijimuKbn, oyadrtencd);

        exClassificationEquals(tkykTratkiKbn, C_TkykTratkiKbn.HUKAKANOU, "特約取扱区分");

    }

    @Test
    @TestOrder(60)
    public void testGaikanykntkTratkiHantei_A6() {
        String syouhincd = "ﾕｹ";
        C_UmuKbn gaikanyuukintktekiumu = C_UmuKbn.NONE;
        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.SMBC;
        String oyadrtencd = "";
        C_TkykTratkiKbn tkykTratkiKbn = drtenTkykTratkiHantei.gaikanykntkTratkiHantei(syouhincd, gaikanyuukintktekiumu,
            skeijimuKbn, oyadrtencd);

        exClassificationEquals(tkykTratkiKbn, C_TkykTratkiKbn.TRATKINASI, "特約取扱区分");

    }

    @Test
    @TestOrder(70)
    public void testGaikanykntkTratkiHantei_A7() {
        String syouhincd = "ﾕｺ";
        C_UmuKbn gaikanyuukintktekiumu = C_UmuKbn.ARI;
        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.SMTB;
        String oyadrtencd = "5100001";
        C_TkykTratkiKbn tkykTratkiKbn = drtenTkykTratkiHantei.gaikanykntkTratkiHantei(syouhincd, gaikanyuukintktekiumu,
            skeijimuKbn, oyadrtencd);

        exClassificationEquals(tkykTratkiKbn, C_TkykTratkiKbn.TRATKINASI, "特約取扱区分");

    }

    @Test
    @TestOrder(80)
    public void testGaikanykntkTratkiHantei_A8() {
        String syouhincd = "ﾕｻ";
        C_UmuKbn gaikanyuukintktekiumu = C_UmuKbn.ARI;
        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.SMTB;
        String oyadrtencd = "2101079";
        C_TkykTratkiKbn tkykTratkiKbn = drtenTkykTratkiHantei.gaikanykntkTratkiHantei(syouhincd, gaikanyuukintktekiumu,
            skeijimuKbn, oyadrtencd);

        exClassificationEquals(tkykTratkiKbn, C_TkykTratkiKbn.TRATKINASI, "特約取扱区分");

    }

    @Test
    @TestOrder(90)
    public void testGaikanykntkTratkiHantei_A9() {
        String syouhincd = "ﾕｼ";
        C_UmuKbn gaikanyuukintktekiumu = C_UmuKbn.ARI;
        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.SMTB;
        String oyadrtencd = "5102152";
        C_TkykTratkiKbn tkykTratkiKbn = drtenTkykTratkiHantei.gaikanykntkTratkiHantei(syouhincd, gaikanyuukintktekiumu,
            skeijimuKbn, oyadrtencd);

        exClassificationEquals(tkykTratkiKbn, C_TkykTratkiKbn.TRATKINASI, "特約取扱区分");

    }

    @Test
    @TestOrder(100)
    public void testGaikanykntkTratkiHantei_A10() {
        String syouhincd = "ﾕｽ";
        C_UmuKbn gaikanyuukintktekiumu = C_UmuKbn.ARI;
        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.SMTB;
        String oyadrtencd = "other";
        C_TkykTratkiKbn tkykTratkiKbn = drtenTkykTratkiHantei.gaikanykntkTratkiHantei(syouhincd, gaikanyuukintktekiumu,
            skeijimuKbn, oyadrtencd);

        exClassificationEquals(tkykTratkiKbn, C_TkykTratkiKbn.HUKAKANOU, "特約取扱区分");

    }

    @Test
    @TestOrder(110)
    public void testGaikanykntkTratkiHantei_A11() {
        String syouhincd = "ﾕﾊ";
        C_UmuKbn gaikanyuukintktekiumu = C_UmuKbn.ARI;
        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.SMTB;
        String oyadrtencd = "5100001";
        C_TkykTratkiKbn tkykTratkiKbn = drtenTkykTratkiHantei.gaikanykntkTratkiHantei(syouhincd, gaikanyuukintktekiumu,
            skeijimuKbn, oyadrtencd);

        exClassificationEquals(tkykTratkiKbn, C_TkykTratkiKbn.TRATKINASI, "特約取扱区分");

    }

    @Test
    @TestOrder(120)
    public void testGaikanykntkTratkiHantei_A12() {
        String syouhincd = "ｲ1";
        C_UmuKbn gaikanyuukintktekiumu = C_UmuKbn.ARI;
        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.SMTB;
        String oyadrtencd = "5100001";
        C_TkykTratkiKbn tkykTratkiKbn = drtenTkykTratkiHantei.gaikanykntkTratkiHantei(syouhincd, gaikanyuukintktekiumu,
            skeijimuKbn, oyadrtencd);

        exClassificationEquals(tkykTratkiKbn, C_TkykTratkiKbn.TRATKINASI, "特約取扱区分");

    }

    @Test
    @TestOrder(130)
    public void testGaikanykntkTratkiHantei_A13() {
        String syouhincd = "ﾕﾉ";
        C_UmuKbn gaikanyuukintktekiumu = C_UmuKbn.ARI;
        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.SMTB;
        String oyadrtencd = "2101079";
        C_TkykTratkiKbn tkykTratkiKbn = drtenTkykTratkiHantei.gaikanykntkTratkiHantei(syouhincd, gaikanyuukintktekiumu,
            skeijimuKbn, oyadrtencd);

        exClassificationEquals(tkykTratkiKbn, C_TkykTratkiKbn.TRATKINASI, "特約取扱区分");

    }

    @Test
    @TestOrder(140)
    public void testGaikanykntkTratkiHantei_A14() {
        String syouhincd = "ﾕﾋ";
        C_UmuKbn gaikanyuukintktekiumu = C_UmuKbn.ARI;
        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.SMTB;
        String oyadrtencd = "5102152";
        C_TkykTratkiKbn tkykTratkiKbn = drtenTkykTratkiHantei.gaikanykntkTratkiHantei(syouhincd, gaikanyuukintktekiumu,
            skeijimuKbn, oyadrtencd);

        exClassificationEquals(tkykTratkiKbn, C_TkykTratkiKbn.TRATKINASI, "特約取扱区分");

    }

    @Test
    @TestOrder(150)
    public void testGaikanykntkTratkiHantei_A15() {
        String syouhincd = "ﾕﾌ";
        C_UmuKbn gaikanyuukintktekiumu = C_UmuKbn.ARI;
        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.SMTB;
        String oyadrtencd = "other";
        C_TkykTratkiKbn tkykTratkiKbn = drtenTkykTratkiHantei.gaikanykntkTratkiHantei(syouhincd, gaikanyuukintktekiumu,
            skeijimuKbn, oyadrtencd);

        exClassificationEquals(tkykTratkiKbn, C_TkykTratkiKbn.HUKAKANOU, "特約取扱区分");

    }

    @Test
    @TestOrder(160)
    public void testGaikanykntkTratkiHantei_A16() {
        String syouhincd = "ｲ2";
        C_UmuKbn gaikanyuukintktekiumu = C_UmuKbn.ARI;
        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.SMTB;
        String oyadrtencd = "2101079";
        C_TkykTratkiKbn tkykTratkiKbn = drtenTkykTratkiHantei.gaikanykntkTratkiHantei(syouhincd, gaikanyuukintktekiumu,
            skeijimuKbn, oyadrtencd);

        exClassificationEquals(tkykTratkiKbn, C_TkykTratkiKbn.TRATKINASI, "特約取扱区分");

    }

    @Test
    @TestOrder(170)
    public void testGaikanykntkTratkiHantei_A17() {
        String syouhincd = "ｳ1";
        C_UmuKbn gaikanyuukintktekiumu = C_UmuKbn.ARI;
        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.SMTB;
        String oyadrtencd = "5102152";
        C_TkykTratkiKbn tkykTratkiKbn = drtenTkykTratkiHantei.gaikanykntkTratkiHantei(syouhincd, gaikanyuukintktekiumu,
            skeijimuKbn, oyadrtencd);

        exClassificationEquals(tkykTratkiKbn, C_TkykTratkiKbn.TRATKINASI, "特約取扱区分");

    }

    @Test
    @TestOrder(180)
    public void testGaikanykntkTratkiHantei_A18() {
        String syouhincd = "ｳ2";
        C_UmuKbn gaikanyuukintktekiumu = C_UmuKbn.ARI;
        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.SMTB;
        String oyadrtencd = "other";
        C_TkykTratkiKbn tkykTratkiKbn = drtenTkykTratkiHantei.gaikanykntkTratkiHantei(syouhincd, gaikanyuukintktekiumu,
            skeijimuKbn, oyadrtencd);

        exClassificationEquals(tkykTratkiKbn, C_TkykTratkiKbn.HUKAKANOU, "特約取扱区分");

    }
}
