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
 * 円入金特約取扱判定のメソッド {@link DrtenTkykTratkiHantei#yennykntkTratkiHantei(String,C_UmuKbn,C_SkeijimuKbn,String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class DrtenTkykTratkiHanteiTest_yennykntkTratkiHantei {

    @Inject
    private DrtenTkykTratkiHantei drtenTkykTratkiHantei;

    @Test
    @TestOrder(10)
    public void testYennykntkTratkiHantei_A1() {

        String syouhncd = "ﾕﾁ";
        C_UmuKbn pyennykntktekiumu = C_UmuKbn.NONE;
        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.SMBC;
        String oyadrtencd = "";

        C_TkykTratkiKbn tkykTratkiKbn = drtenTkykTratkiHantei.yennykntkTratkiHantei(syouhncd, pyennykntktekiumu,
            skeijimuKbn, oyadrtencd);

        exClassificationEquals(tkykTratkiKbn, C_TkykTratkiKbn.TRATKINASI, "特約取扱区分");
    }

    @Test
    @TestOrder(20)
    public void testYennykntkTratkiHantei_A2() {

        String syouhncd = "ﾕﾁ";
        C_UmuKbn pyennykntktekiumu = C_UmuKbn.ARI;
        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.SMBC;
        String oyadrtencd = "";

        C_TkykTratkiKbn tkykTratkiKbn = drtenTkykTratkiHantei.yennykntkTratkiHantei(syouhncd, pyennykntktekiumu,
            skeijimuKbn, oyadrtencd);

        exClassificationEquals(tkykTratkiKbn, C_TkykTratkiKbn.HUKAHISSU, "特約取扱区分");
    }

    @Test
    @TestOrder(30)
    public void testYennykntkTratkiHantei_A3() {

        String syouhncd = "ﾕｹ";
        C_UmuKbn pyennykntktekiumu = C_UmuKbn.ARI;
        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.SMTB;
        String oyadrtencd = "5100001";

        C_TkykTratkiKbn tkykTratkiKbn = drtenTkykTratkiHantei.yennykntkTratkiHantei(syouhncd, pyennykntktekiumu,
            skeijimuKbn, oyadrtencd);

        exClassificationEquals(tkykTratkiKbn, C_TkykTratkiKbn.HUKAKANOU, "特約取扱区分");
    }

    @Test
    @TestOrder(40)
    public void testYennykntkTratkiHantei_A4() {

        String syouhncd = "ﾕｺ";
        C_UmuKbn pyennykntktekiumu = C_UmuKbn.ARI;
        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.SMTB;
        String oyadrtencd = "5102152";

        C_TkykTratkiKbn tkykTratkiKbn = drtenTkykTratkiHantei.yennykntkTratkiHantei(syouhncd, pyennykntktekiumu,
            skeijimuKbn, oyadrtencd);

        exClassificationEquals(tkykTratkiKbn, C_TkykTratkiKbn.HUKAKANOU, "特約取扱区分");
    }

    @Test
    @TestOrder(50)
    public void testYennykntkTratkiHantei_A5() {

        String syouhncd = "ﾕｻ";
        C_UmuKbn pyennykntktekiumu = C_UmuKbn.ARI;
        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.SMTB;
        String oyadrtencd = "2101079";

        C_TkykTratkiKbn tkykTratkiKbn = drtenTkykTratkiHantei.yennykntkTratkiHantei(syouhncd, pyennykntktekiumu,
            skeijimuKbn, oyadrtencd);

        exClassificationEquals(tkykTratkiKbn, C_TkykTratkiKbn.HUKAKANOU, "特約取扱区分");
    }

    @Test
    @TestOrder(60)
    public void testYennykntkTratkiHantei_A6() {

        String syouhncd = "ﾕｼ";
        C_UmuKbn pyennykntktekiumu = C_UmuKbn.ARI;
        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.SMTB;
        String oyadrtencd = "5100001";

        C_TkykTratkiKbn tkykTratkiKbn = drtenTkykTratkiHantei.yennykntkTratkiHantei(syouhncd, pyennykntktekiumu,
            skeijimuKbn, oyadrtencd);

        exClassificationEquals(tkykTratkiKbn, C_TkykTratkiKbn.HUKAKANOU, "特約取扱区分");
    }

    @Test
    @TestOrder(70)
    public void testYennykntkTratkiHantei_A7() {

        String syouhncd = "ﾕｽ";
        C_UmuKbn pyennykntktekiumu = C_UmuKbn.ARI;
        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.SMBC;
        String oyadrtencd = "5102152";

        C_TkykTratkiKbn tkykTratkiKbn = drtenTkykTratkiHantei.yennykntkTratkiHantei(syouhncd, pyennykntktekiumu,
            skeijimuKbn, oyadrtencd);

        exClassificationEquals(tkykTratkiKbn, C_TkykTratkiKbn.HUKAKANOU, "特約取扱区分");
    }
    @Test
    @TestOrder(80)
    public void testYennykntkTratkiHantei_A8() {

        String syouhncd = "ﾕｱ";
        C_UmuKbn pyennykntktekiumu = C_UmuKbn.ARI;
        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.SMBC;
        String oyadrtencd = "5100001";

        C_TkykTratkiKbn tkykTratkiKbn = drtenTkykTratkiHantei.yennykntkTratkiHantei(syouhncd, pyennykntktekiumu,
            skeijimuKbn, oyadrtencd);

        exClassificationEquals(tkykTratkiKbn, C_TkykTratkiKbn.TRATKINASI, "特約取扱区分");
    }

    @Test
    @TestOrder(90)
    public void testYennykntkTratkiHantei_A9() {

        String syouhncd = "ﾕｲ";
        C_UmuKbn pyennykntktekiumu = C_UmuKbn.ARI;
        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.SMBC;
        String oyadrtencd = "5102152";

        C_TkykTratkiKbn tkykTratkiKbn = drtenTkykTratkiHantei.yennykntkTratkiHantei(syouhncd, pyennykntktekiumu,
            skeijimuKbn, oyadrtencd);

        exClassificationEquals(tkykTratkiKbn, C_TkykTratkiKbn.TRATKINASI, "特約取扱区分");
    }

    @Test
    @TestOrder(100)
    public void testYennykntkTratkiHantei_A10() {

        String syouhncd = "ﾕｳ";
        C_UmuKbn pyennykntktekiumu = C_UmuKbn.ARI;
        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.SMBC;
        String oyadrtencd = "2101079";

        C_TkykTratkiKbn tkykTratkiKbn = drtenTkykTratkiHantei.yennykntkTratkiHantei(syouhncd, pyennykntktekiumu,
            skeijimuKbn, oyadrtencd);

        exClassificationEquals(tkykTratkiKbn, C_TkykTratkiKbn.HUKAKANOU, "特約取扱区分");
    }

    @Test
    @TestOrder(110)
    public void testYennykntkTratkiHantei_A11() {

        String syouhncd = "ﾕﾉ";
        C_UmuKbn pyennykntktekiumu = C_UmuKbn.ARI;
        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.SMBC;
        String oyadrtencd = "5100001";

        C_TkykTratkiKbn tkykTratkiKbn = drtenTkykTratkiHantei.yennykntkTratkiHantei(syouhncd, pyennykntktekiumu,
            skeijimuKbn, oyadrtencd);

        exClassificationEquals(tkykTratkiKbn, C_TkykTratkiKbn.HUKAKANOU, "特約取扱区分");
    }
}
