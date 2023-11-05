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
 * 初期死亡時円換算支払額最低保証特約取扱判定のメソッド {@link DrtenTkykTratkiHantei#initsbjiYenknsnshrgkSaiteihsytkTratkiHantei(String,C_UmuKbn,
        C_SkeijimuKbn,String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class DrtenTkykTratkiHanteiTest_initsbjiYenknsnshrgkSaiteihsytkTratkiHantei {

    @Inject
    private DrtenTkykTratkiHantei drtenTkykTratkiHantei;

    @Test
    @TestOrder(10)
    public void testInitsbjiYenknsnshrgkSaiteihsytkTratkiHantei_A1() {
        String syouhincd = "ﾕｱ";
        C_UmuKbn syksbyensitihsyutktekiumu = C_UmuKbn.NONE;
        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.SMBC;
        String oyadrtencd = "";
        C_TkykTratkiKbn tkykTratkiKbn = drtenTkykTratkiHantei.initsbjiYenknsnshrgkSaiteihsytkTratkiHantei(syouhincd, syksbyensitihsyutktekiumu,
            skeijimuKbn, oyadrtencd);

        exClassificationEquals(tkykTratkiKbn, C_TkykTratkiKbn.HUKAKANOU, "特約取扱区分");

    }

    @Test
    @TestOrder(20)
    public void testInitsbjiYenknsnshrgkSaiteihsytkTratkiHantei_A2() {
        String syouhincd = "ﾕｱ";
        C_UmuKbn syksbyensitihsyutktekiumu = C_UmuKbn.ARI;
        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.SMBC;
        String oyadrtencd = "";
        C_TkykTratkiKbn tkykTratkiKbn = drtenTkykTratkiHantei.initsbjiYenknsnshrgkSaiteihsytkTratkiHantei(syouhincd, syksbyensitihsyutktekiumu,
            skeijimuKbn, oyadrtencd);

        exClassificationEquals(tkykTratkiKbn, C_TkykTratkiKbn.HUKAKANOU, "特約取扱区分");

    }

    @Test
    @TestOrder(30)
    public void testInitsbjiYenknsnshrgkSaiteihsytkTratkiHantei_A3() {
        String syouhincd = "ﾕﾉ";
        C_UmuKbn syksbyensitihsyutktekiumu = C_UmuKbn.ARI;
        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.SMTB;
        String oyadrtencd = "5100001";
        C_TkykTratkiKbn tkykTratkiKbn = drtenTkykTratkiHantei.initsbjiYenknsnshrgkSaiteihsytkTratkiHantei(syouhincd, syksbyensitihsyutktekiumu,
            skeijimuKbn, oyadrtencd);

        exClassificationEquals(tkykTratkiKbn, C_TkykTratkiKbn.HUKAHISSU, "特約取扱区分");

    }

    @Test
    @TestOrder(40)
    public void testInitsbjiYenknsnshrgkSaiteihsytkTratkiHantei_A4() {
        String syouhincd = "ﾕﾉ";
        C_UmuKbn syksbyensitihsyutktekiumu = C_UmuKbn.ARI;
        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.SMTB;
        String oyadrtencd = "2101079";
        C_TkykTratkiKbn tkykTratkiKbn = drtenTkykTratkiHantei.initsbjiYenknsnshrgkSaiteihsytkTratkiHantei(syouhincd, syksbyensitihsyutktekiumu,
            skeijimuKbn, oyadrtencd);

        exClassificationEquals(tkykTratkiKbn, C_TkykTratkiKbn.HUKAHISSU, "特約取扱区分");

    }

    @Test
    @TestOrder(50)
    public void testInitsbjiYenknsnshrgkSaiteihsytkTratkiHantei_A5() {
        String syouhincd = "ﾕﾉ";
        C_UmuKbn syksbyensitihsyutktekiumu = C_UmuKbn.ARI;
        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.SMTB;
        String oyadrtencd = "5102152";
        C_TkykTratkiKbn tkykTratkiKbn = drtenTkykTratkiHantei.initsbjiYenknsnshrgkSaiteihsytkTratkiHantei(syouhincd, syksbyensitihsyutktekiumu,
            skeijimuKbn, oyadrtencd);

        exClassificationEquals(tkykTratkiKbn, C_TkykTratkiKbn.HUKAHISSU, "特約取扱区分");

    }

    @Test
    @TestOrder(60)
    public void testInitsbjiYenknsnshrgkSaiteihsytkTratkiHantei_A6() {
        String syouhincd = "ﾕﾉ";
        C_UmuKbn syksbyensitihsyutktekiumu = C_UmuKbn.ARI;
        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.SMTB;
        String oyadrtencd = "other";
        C_TkykTratkiKbn tkykTratkiKbn = drtenTkykTratkiHantei.initsbjiYenknsnshrgkSaiteihsytkTratkiHantei(syouhincd, syksbyensitihsyutktekiumu,
            skeijimuKbn, oyadrtencd);

        exClassificationEquals(tkykTratkiKbn, C_TkykTratkiKbn.HUKAKANOU, "特約取扱区分");

    }

    @Test
    @TestOrder(70)
    public void testInitsbjiYenknsnshrgkSaiteihsytkTratkiHantei_A7() {
        String syouhincd = "ﾕｹ";
        C_UmuKbn syksbyensitihsyutktekiumu = C_UmuKbn.ARI;
        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.SMTB;
        String oyadrtencd = "";
        C_TkykTratkiKbn tkykTratkiKbn = drtenTkykTratkiHantei.initsbjiYenknsnshrgkSaiteihsytkTratkiHantei(syouhincd, syksbyensitihsyutktekiumu,
            skeijimuKbn, oyadrtencd);

        exClassificationEquals(tkykTratkiKbn, C_TkykTratkiKbn.TRATKINASI, "特約取扱区分");

    }

    @Test
    @TestOrder(80)
    public void testInitsbjiYenknsnshrgkSaiteihsytkTratkiHantei_A8() {
        String syouhincd = "ﾕﾉ";
        C_UmuKbn syksbyensitihsyutktekiumu = C_UmuKbn.NONE;
        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.SMTB;
        String oyadrtencd = "5100001";
        C_TkykTratkiKbn tkykTratkiKbn = drtenTkykTratkiHantei.initsbjiYenknsnshrgkSaiteihsytkTratkiHantei(syouhincd, syksbyensitihsyutktekiumu,
            skeijimuKbn, oyadrtencd);

        exClassificationEquals(tkykTratkiKbn, C_TkykTratkiKbn.HUKAHISSU, "特約取扱区分");

    }

    @Test
    @TestOrder(90)
    public void testInitsbjiYenknsnshrgkSaiteihsytkTratkiHantei_A9() {
        String syouhincd = "ﾕﾉ";
        C_UmuKbn syksbyensitihsyutktekiumu = C_UmuKbn.NONE;
        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.SMTB;
        String oyadrtencd = "2101079";
        C_TkykTratkiKbn tkykTratkiKbn = drtenTkykTratkiHantei.initsbjiYenknsnshrgkSaiteihsytkTratkiHantei(syouhincd, syksbyensitihsyutktekiumu,
            skeijimuKbn, oyadrtencd);

        exClassificationEquals(tkykTratkiKbn, C_TkykTratkiKbn.HUKAHISSU, "特約取扱区分");

    }

    @Test
    @TestOrder(100)
    public void testInitsbjiYenknsnshrgkSaiteihsytkTratkiHantei_A10() {
        String syouhincd = "ﾕﾉ";
        C_UmuKbn syksbyensitihsyutktekiumu = C_UmuKbn.NONE;
        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.SMTB;
        String oyadrtencd = "5102152";
        C_TkykTratkiKbn tkykTratkiKbn = drtenTkykTratkiHantei.initsbjiYenknsnshrgkSaiteihsytkTratkiHantei(syouhincd, syksbyensitihsyutktekiumu,
            skeijimuKbn, oyadrtencd);

        exClassificationEquals(tkykTratkiKbn, C_TkykTratkiKbn.HUKAHISSU, "特約取扱区分");

    }

    @Test
    @TestOrder(110)
    public void testInitsbjiYenknsnshrgkSaiteihsytkTratkiHantei_A11() {
        String syouhincd = "ﾕﾉ";
        C_UmuKbn syksbyensitihsyutktekiumu = C_UmuKbn.NONE;
        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.SMTB;
        String oyadrtencd = "other";
        C_TkykTratkiKbn tkykTratkiKbn = drtenTkykTratkiHantei.initsbjiYenknsnshrgkSaiteihsytkTratkiHantei(syouhincd, syksbyensitihsyutktekiumu,
            skeijimuKbn, oyadrtencd);

        exClassificationEquals(tkykTratkiKbn, C_TkykTratkiKbn.HUKAKANOU, "特約取扱区分");

    }

    @Test
    @TestOrder(120)
    public void testInitsbjiYenknsnshrgkSaiteihsytkTratkiHantei_A12() {
        String syouhincd = "ﾕｹ";
        C_UmuKbn syksbyensitihsyutktekiumu = C_UmuKbn.NONE;
        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.SMTB;
        String oyadrtencd = "";
        C_TkykTratkiKbn tkykTratkiKbn = drtenTkykTratkiHantei.initsbjiYenknsnshrgkSaiteihsytkTratkiHantei(syouhincd, syksbyensitihsyutktekiumu,
            skeijimuKbn, oyadrtencd);

        exClassificationEquals(tkykTratkiKbn, C_TkykTratkiKbn.TRATKINASI, "特約取扱区分");

    }
}
