package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_TargetTkHukaKanouKbn;
import yuyu.def.classification.C_TkykTratkiKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ターゲット特約取扱判定のメソッド {@link DrtenTkykTratkiHantei#targettkTratkiHantei(C_TargetTkHukaKanouKbn,C_SkeijimuKbn,String
)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class DrtenTkykTratkiHanteiTest_targettkTratkiHantei {

    @Inject
    private DrtenTkykTratkiHantei drtenTkykTratkiHantei;

    @Test
    @TestOrder(10)
    public void testTargettkTratkiHantei_A1() {

        C_TargetTkHukaKanouKbn targetTkHukaKanouKbn = C_TargetTkHukaKanouKbn.NONE;
        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.SMBC;
        String oyadrtencd = "";
        C_TkykTratkiKbn tkykTratkiKbn = drtenTkykTratkiHantei.targettkTratkiHantei(targetTkHukaKanouKbn, skeijimuKbn,
            oyadrtencd);

        exClassificationEquals(tkykTratkiKbn, C_TkykTratkiKbn.BLNK, "特約取扱区分");

    }

    @Test
    @TestOrder(20)
    public void testTargettkTratkiHantei_A2() {

        C_TargetTkHukaKanouKbn targetTkHukaKanouKbn = C_TargetTkHukaKanouKbn.YENNENKIN;
        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.SMBC;
        String oyadrtencd = "";
        C_TkykTratkiKbn tkykTratkiKbn = drtenTkykTratkiHantei.targettkTratkiHantei(targetTkHukaKanouKbn, skeijimuKbn,
            oyadrtencd);

        exClassificationEquals(tkykTratkiKbn, C_TkykTratkiKbn.HUKAHISSU, "特約取扱区分");

    }

    @Test
    @TestOrder(30)
    public void testTargettkTratkiHantei_A3() {

        C_TargetTkHukaKanouKbn targetTkHukaKanouKbn = C_TargetTkHukaKanouKbn.YENSYUUSIN;
        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.SMTB;
        String oyadrtencd = "5100001";
        C_TkykTratkiKbn tkykTratkiKbn = drtenTkykTratkiHantei.targettkTratkiHantei(targetTkHukaKanouKbn, skeijimuKbn,
            oyadrtencd);

        exClassificationEquals(tkykTratkiKbn, C_TkykTratkiKbn.TRATKINASI, "特約取扱区分");

    }

    @Test
    @TestOrder(40)
    public void testTargettkTratkiHantei_A4() {

        C_TargetTkHukaKanouKbn targetTkHukaKanouKbn = C_TargetTkHukaKanouKbn.YENSYUUSIN;
        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.SMTB;
        String oyadrtencd = "2101079";
        C_TkykTratkiKbn tkykTratkiKbn = drtenTkykTratkiHantei.targettkTratkiHantei(targetTkHukaKanouKbn, skeijimuKbn,
            oyadrtencd);

        exClassificationEquals(tkykTratkiKbn, C_TkykTratkiKbn.TRATKINASI, "特約取扱区分");

    }

    @Test
    @TestOrder(50)
    public void testTargettkTratkiHantei_A5() {

        C_TargetTkHukaKanouKbn targetTkHukaKanouKbn = C_TargetTkHukaKanouKbn.YENSYUUSIN;
        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.SMTB;
        String oyadrtencd = "5102152";
        C_TkykTratkiKbn tkykTratkiKbn = drtenTkykTratkiHantei.targettkTratkiHantei(targetTkHukaKanouKbn, skeijimuKbn,
            oyadrtencd);

        exClassificationEquals(tkykTratkiKbn, C_TkykTratkiKbn.TRATKINASI, "特約取扱区分");

    }

    @Test
    @TestOrder(60)
    public void testTargettkTratkiHantei_A6() {

        C_TargetTkHukaKanouKbn targetTkHukaKanouKbn = C_TargetTkHukaKanouKbn.YENSYUUSIN;
        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.SMTB;
        String oyadrtencd = "other";
        C_TkykTratkiKbn tkykTratkiKbn = drtenTkykTratkiHantei.targettkTratkiHantei(targetTkHukaKanouKbn, skeijimuKbn,
            oyadrtencd);

        exClassificationEquals(tkykTratkiKbn, C_TkykTratkiKbn.HUKAHISSU, "特約取扱区分");

    }

}
