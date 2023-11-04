package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 払変処理区分設定のメソッド {@link SetHrhnSyoriKbn#exec(C_UmuKbn pHrkkaisuuhn, C_UmuKbn pTikiktbrisyuruihn,
 * C_Hrkkeiro pBfrHrkkeiro,C_Hrkkeiro pHenHrkkeiro)}テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetHrhnSyoriKbnTest_exec {

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        SetHrhnSyoriKbn setHrhnSyoriKbn = SWAKInjector.getInstance(SetHrhnSyoriKbn.class);

        C_UmuKbn pHrkkaisuuhn = C_UmuKbn.ARI;

        C_UmuKbn pTikiktbrisyuruihn = C_UmuKbn.NONE;

        C_Hrkkeiro pBfrHrkkeiro = C_Hrkkeiro.BLNK;

        C_Hrkkeiro pHenHrkkeiro = C_Hrkkeiro.BLNK;

        C_SyoriKbn csyoriKbn = setHrhnSyoriKbn.exec(pHrkkaisuuhn, pTikiktbrisyuruihn, pBfrHrkkeiro, pHenHrkkeiro);

        exClassificationEquals(csyoriKbn, C_SyoriKbn.KAISUUHENKOU, "<処理区分>回数変更");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        SetHrhnSyoriKbn setHrhnSyoriKbn = SWAKInjector.getInstance(SetHrhnSyoriKbn.class);

        C_UmuKbn pHrkkaisuuhn = C_UmuKbn.ARI;

        C_UmuKbn pTikiktbrisyuruihn = C_UmuKbn.NONE;

        C_Hrkkeiro pBfrHrkkeiro = C_Hrkkeiro.KOUHURI;

        C_Hrkkeiro pHenHrkkeiro = C_Hrkkeiro.KOUHURI;

        C_SyoriKbn csyoriKbn = setHrhnSyoriKbn.exec(pHrkkaisuuhn, pTikiktbrisyuruihn, pBfrHrkkeiro, pHenHrkkeiro);

        exClassificationEquals(csyoriKbn, C_SyoriKbn.KAISUUHENKOU_KOUZAHENKOU, "<処理区分>回数変更・口座変更");

    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        SetHrhnSyoriKbn setHrhnSyoriKbn = SWAKInjector.getInstance(SetHrhnSyoriKbn.class);

        C_UmuKbn pHrkkaisuuhn = C_UmuKbn.ARI;

        C_UmuKbn pTikiktbrisyuruihn = C_UmuKbn.NONE;

        C_Hrkkeiro pBfrHrkkeiro = C_Hrkkeiro.CREDIT;

        C_Hrkkeiro pHenHrkkeiro = C_Hrkkeiro.KOUHURI;

        C_SyoriKbn csyoriKbn = setHrhnSyoriKbn.exec(pHrkkaisuuhn, pTikiktbrisyuruihn, pBfrHrkkeiro, pHenHrkkeiro);

        exClassificationEquals(csyoriKbn, C_SyoriKbn.KAISUUHENKOU_YOHURIHENNYUU, "<処理区分>回数変更・預振編入");

    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        SetHrhnSyoriKbn setHrhnSyoriKbn = SWAKInjector.getInstance(SetHrhnSyoriKbn.class);

        C_UmuKbn pHrkkaisuuhn = C_UmuKbn.ARI;

        C_UmuKbn pTikiktbrisyuruihn = C_UmuKbn.NONE;

        C_Hrkkeiro pBfrHrkkeiro = C_Hrkkeiro.SYUUDAN;

        C_Hrkkeiro pHenHrkkeiro = C_Hrkkeiro.KOUHURI;

        C_SyoriKbn csyoriKbn = setHrhnSyoriKbn.exec(pHrkkaisuuhn, pTikiktbrisyuruihn, pBfrHrkkeiro, pHenHrkkeiro);

        exClassificationEquals(csyoriKbn, C_SyoriKbn.BLNK, "<処理区分>ブランク");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        SetHrhnSyoriKbn setHrhnSyoriKbn = SWAKInjector.getInstance(SetHrhnSyoriKbn.class);

        C_UmuKbn pHrkkaisuuhn = C_UmuKbn.ARI;

        C_UmuKbn pTikiktbrisyuruihn = C_UmuKbn.NONE;

        C_Hrkkeiro pBfrHrkkeiro = C_Hrkkeiro.KOUHURI;

        C_Hrkkeiro pHenHrkkeiro = C_Hrkkeiro.CREDIT;

        C_SyoriKbn csyoriKbn = setHrhnSyoriKbn.exec(pHrkkaisuuhn, pTikiktbrisyuruihn, pBfrHrkkeiro, pHenHrkkeiro);

        exClassificationEquals(csyoriKbn, C_SyoriKbn.KAISUUHENKOU_CRECAHENNYUU, "<処理区分>回数変更・クレカ編入");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        SetHrhnSyoriKbn setHrhnSyoriKbn = SWAKInjector.getInstance(SetHrhnSyoriKbn.class);

        C_UmuKbn pHrkkaisuuhn = C_UmuKbn.ARI;

        C_UmuKbn pTikiktbrisyuruihn = C_UmuKbn.NONE;

        C_Hrkkeiro pBfrHrkkeiro = C_Hrkkeiro.SYUUDAN;

        C_Hrkkeiro pHenHrkkeiro = C_Hrkkeiro.CREDIT;

        C_SyoriKbn csyoriKbn = setHrhnSyoriKbn.exec(pHrkkaisuuhn, pTikiktbrisyuruihn, pBfrHrkkeiro, pHenHrkkeiro);

        exClassificationEquals(csyoriKbn, C_SyoriKbn.BLNK, "<処理区分>ブランク");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        SetHrhnSyoriKbn setHrhnSyoriKbn = SWAKInjector.getInstance(SetHrhnSyoriKbn.class);

        C_UmuKbn pHrkkaisuuhn = C_UmuKbn.ARI;

        C_UmuKbn pTikiktbrisyuruihn = C_UmuKbn.NONE;

        C_Hrkkeiro pBfrHrkkeiro = C_Hrkkeiro.HURIKAE;

        C_Hrkkeiro pHenHrkkeiro = C_Hrkkeiro.SYUUDAN;

        C_SyoriKbn csyoriKbn = setHrhnSyoriKbn.exec(pHrkkaisuuhn, pTikiktbrisyuruihn, pBfrHrkkeiro, pHenHrkkeiro);

        exClassificationEquals(csyoriKbn, C_SyoriKbn.BLNK, "0<処理区分>ブランク");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        SetHrhnSyoriKbn setHrhnSyoriKbn = SWAKInjector.getInstance(SetHrhnSyoriKbn.class);

        C_UmuKbn pHrkkaisuuhn = C_UmuKbn.NONE;

        C_UmuKbn pTikiktbrisyuruihn = C_UmuKbn.ARI;

        C_Hrkkeiro pBfrHrkkeiro = C_Hrkkeiro.SYUUDAN;

        C_Hrkkeiro pHenHrkkeiro = C_Hrkkeiro.BLNK;

        C_SyoriKbn csyoriKbn = setHrhnSyoriKbn.exec(pHrkkaisuuhn, pTikiktbrisyuruihn, pBfrHrkkeiro, pHenHrkkeiro);

        exClassificationEquals(csyoriKbn, C_SyoriKbn.KAISUUHENKOU, "<処理区分>回座変更");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        SetHrhnSyoriKbn setHrhnSyoriKbn = SWAKInjector.getInstance(SetHrhnSyoriKbn.class);

        C_UmuKbn pHrkkaisuuhn = C_UmuKbn.NONE;

        C_UmuKbn pTikiktbrisyuruihn = C_UmuKbn.ARI;

        C_Hrkkeiro pBfrHrkkeiro = C_Hrkkeiro.KOUHURI;

        C_Hrkkeiro pHenHrkkeiro = C_Hrkkeiro.KOUHURI;

        C_SyoriKbn csyoriKbn = setHrhnSyoriKbn.exec(pHrkkaisuuhn, pTikiktbrisyuruihn, pBfrHrkkeiro, pHenHrkkeiro);

        exClassificationEquals(csyoriKbn, C_SyoriKbn.KAISUUHENKOU_KOUZAHENKOU, "<処理区分>回数変更・口座変更");
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        SetHrhnSyoriKbn setHrhnSyoriKbn = SWAKInjector.getInstance(SetHrhnSyoriKbn.class);

        C_UmuKbn pHrkkaisuuhn = C_UmuKbn.NONE;

        C_UmuKbn pTikiktbrisyuruihn = C_UmuKbn.ARI;

        C_Hrkkeiro pBfrHrkkeiro = C_Hrkkeiro.CREDIT;

        C_Hrkkeiro pHenHrkkeiro = C_Hrkkeiro.KOUHURI;

        C_SyoriKbn csyoriKbn = setHrhnSyoriKbn.exec(pHrkkaisuuhn, pTikiktbrisyuruihn, pBfrHrkkeiro, pHenHrkkeiro);

        exClassificationEquals(csyoriKbn, C_SyoriKbn.KAISUUHENKOU_YOHURIHENNYUU, "<処理区分>回数変更・預振編入");
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {

        SetHrhnSyoriKbn setHrhnSyoriKbn = SWAKInjector.getInstance(SetHrhnSyoriKbn.class);

        C_UmuKbn pHrkkaisuuhn = C_UmuKbn.NONE;

        C_UmuKbn pTikiktbrisyuruihn = C_UmuKbn.ARI;

        C_Hrkkeiro pBfrHrkkeiro = C_Hrkkeiro.SYUUDAN;

        C_Hrkkeiro pHenHrkkeiro = C_Hrkkeiro.KOUHURI;

        C_SyoriKbn csyoriKbn = setHrhnSyoriKbn.exec(pHrkkaisuuhn, pTikiktbrisyuruihn, pBfrHrkkeiro, pHenHrkkeiro);

        exClassificationEquals(csyoriKbn, C_SyoriKbn.BLNK, "<処理区分>ブランク");
    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {

        SetHrhnSyoriKbn setHrhnSyoriKbn = SWAKInjector.getInstance(SetHrhnSyoriKbn.class);

        C_UmuKbn pHrkkaisuuhn = C_UmuKbn.NONE;

        C_UmuKbn pTikiktbrisyuruihn = C_UmuKbn.ARI;

        C_Hrkkeiro pBfrHrkkeiro = C_Hrkkeiro.KOUHURI;

        C_Hrkkeiro pHenHrkkeiro = C_Hrkkeiro.CREDIT;

        C_SyoriKbn csyoriKbn = setHrhnSyoriKbn.exec(pHrkkaisuuhn, pTikiktbrisyuruihn, pBfrHrkkeiro, pHenHrkkeiro);

        exClassificationEquals(csyoriKbn, C_SyoriKbn.KAISUUHENKOU_CRECAHENNYUU, "<処理区分>回数変更・クレカ編入");
    }

    @Test
    @TestOrder(130)
    public void testExec_A13() {

        SetHrhnSyoriKbn setHrhnSyoriKbn = SWAKInjector.getInstance(SetHrhnSyoriKbn.class);

        C_UmuKbn pHrkkaisuuhn = C_UmuKbn.NONE;

        C_UmuKbn pTikiktbrisyuruihn = C_UmuKbn.ARI;

        C_Hrkkeiro pBfrHrkkeiro = C_Hrkkeiro.SYUUDAN;

        C_Hrkkeiro pHenHrkkeiro = C_Hrkkeiro.CREDIT;

        C_SyoriKbn csyoriKbn = setHrhnSyoriKbn.exec(pHrkkaisuuhn, pTikiktbrisyuruihn, pBfrHrkkeiro, pHenHrkkeiro);

        exClassificationEquals(csyoriKbn, C_SyoriKbn.BLNK, "<処理区分>ブランク");
    }

    @Test
    @TestOrder(140)
    public void testExec_A14() {

        SetHrhnSyoriKbn setHrhnSyoriKbn = SWAKInjector.getInstance(SetHrhnSyoriKbn.class);

        C_UmuKbn pHrkkaisuuhn = C_UmuKbn.NONE;

        C_UmuKbn pTikiktbrisyuruihn = C_UmuKbn.ARI;

        C_Hrkkeiro pBfrHrkkeiro = C_Hrkkeiro.DANTAI;

        C_Hrkkeiro pHenHrkkeiro = C_Hrkkeiro.SYUUDAN;

        C_SyoriKbn csyoriKbn = setHrhnSyoriKbn.exec(pHrkkaisuuhn, pTikiktbrisyuruihn, pBfrHrkkeiro, pHenHrkkeiro);

        exClassificationEquals(csyoriKbn, C_SyoriKbn.BLNK, "<処理区分>ブランク");
    }

    @Test
    @TestOrder(150)
    public void testExec_A15() {

        SetHrhnSyoriKbn setHrhnSyoriKbn = SWAKInjector.getInstance(SetHrhnSyoriKbn.class);

        C_UmuKbn pHrkkaisuuhn = C_UmuKbn.NONE;

        C_UmuKbn pTikiktbrisyuruihn = C_UmuKbn.NONE;

        C_Hrkkeiro pBfrHrkkeiro = C_Hrkkeiro.SYUUDAN;

        C_Hrkkeiro pHenHrkkeiro = C_Hrkkeiro.BLNK;

        C_SyoriKbn csyoriKbn = setHrhnSyoriKbn.exec(pHrkkaisuuhn, pTikiktbrisyuruihn, pBfrHrkkeiro, pHenHrkkeiro);

        exClassificationEquals(csyoriKbn, C_SyoriKbn.HRIHENNONE,"<処理区分>払方変更無し");
    }


    @Test
    @TestOrder(160)
    public void testExec_A16() {

        SetHrhnSyoriKbn setHrhnSyoriKbn = SWAKInjector.getInstance(SetHrhnSyoriKbn.class);

        C_UmuKbn pHrkkaisuuhn = C_UmuKbn.NONE;

        C_UmuKbn pTikiktbrisyuruihn = C_UmuKbn.NONE;

        C_Hrkkeiro pBfrHrkkeiro = C_Hrkkeiro.KOUHURI;

        C_Hrkkeiro pHenHrkkeiro = C_Hrkkeiro.KOUHURI;

        C_SyoriKbn csyoriKbn = setHrhnSyoriKbn.exec(pHrkkaisuuhn, pTikiktbrisyuruihn, pBfrHrkkeiro, pHenHrkkeiro);

        exClassificationEquals(csyoriKbn, C_SyoriKbn.KOUZAHENKOU, "<処理区分>口座変更");
    }

    @Test
    @TestOrder(170)
    public void testExec_A17() {

        SetHrhnSyoriKbn setHrhnSyoriKbn = SWAKInjector.getInstance(SetHrhnSyoriKbn.class);

        C_UmuKbn pHrkkaisuuhn = C_UmuKbn.NONE;

        C_UmuKbn pTikiktbrisyuruihn = C_UmuKbn.NONE;

        C_Hrkkeiro pBfrHrkkeiro = C_Hrkkeiro.CREDIT;

        C_Hrkkeiro pHenHrkkeiro = C_Hrkkeiro.KOUHURI;

        C_SyoriKbn csyoriKbn = setHrhnSyoriKbn.exec(pHrkkaisuuhn, pTikiktbrisyuruihn, pBfrHrkkeiro, pHenHrkkeiro);

        exClassificationEquals(csyoriKbn, C_SyoriKbn.YOHURIHENNYUU, "<処理区分>預振編入");
    }

    @Test
    @TestOrder(180)
    public void testExec_A18() {

        SetHrhnSyoriKbn setHrhnSyoriKbn = SWAKInjector.getInstance(SetHrhnSyoriKbn.class);

        C_UmuKbn pHrkkaisuuhn = C_UmuKbn.NONE;

        C_UmuKbn pTikiktbrisyuruihn = C_UmuKbn.NONE;

        C_Hrkkeiro pBfrHrkkeiro = C_Hrkkeiro.SYUUDAN;

        C_Hrkkeiro pHenHrkkeiro = C_Hrkkeiro.KOUHURI;

        C_SyoriKbn csyoriKbn = setHrhnSyoriKbn.exec(pHrkkaisuuhn, pTikiktbrisyuruihn, pBfrHrkkeiro, pHenHrkkeiro);

        exClassificationEquals(csyoriKbn, C_SyoriKbn.BLNK, "<処理区分>ブランク");
    }

    @Test
    @TestOrder(190)
    public void testExec_A19() {

        SetHrhnSyoriKbn setHrhnSyoriKbn = SWAKInjector.getInstance(SetHrhnSyoriKbn.class);

        C_UmuKbn pHrkkaisuuhn = C_UmuKbn.NONE;

        C_UmuKbn pTikiktbrisyuruihn = C_UmuKbn.NONE;

        C_Hrkkeiro pBfrHrkkeiro = C_Hrkkeiro.KOUHURI;

        C_Hrkkeiro pHenHrkkeiro = C_Hrkkeiro.CREDIT;

        C_SyoriKbn csyoriKbn = setHrhnSyoriKbn.exec(pHrkkaisuuhn, pTikiktbrisyuruihn, pBfrHrkkeiro, pHenHrkkeiro);

        exClassificationEquals(csyoriKbn, C_SyoriKbn.CRECAHENNYUU, "<処理区分>クレカ編入");
    }

    @Test
    @TestOrder(200)
    public void testExec_A20() {

        SetHrhnSyoriKbn setHrhnSyoriKbn = SWAKInjector.getInstance(SetHrhnSyoriKbn.class);

        C_UmuKbn pHrkkaisuuhn = C_UmuKbn.NONE;

        C_UmuKbn pTikiktbrisyuruihn = C_UmuKbn.NONE;

        C_Hrkkeiro pBfrHrkkeiro = C_Hrkkeiro.CREDIT;

        C_Hrkkeiro pHenHrkkeiro = C_Hrkkeiro.CREDIT;

        C_SyoriKbn csyoriKbn = setHrhnSyoriKbn.exec(pHrkkaisuuhn, pTikiktbrisyuruihn, pBfrHrkkeiro, pHenHrkkeiro);

        exClassificationEquals(csyoriKbn, C_SyoriKbn.CRECAHENKOU, "<処理区分>クレカ変更");
    }

    @Test
    @TestOrder(210)
    public void testExec_A21() {

        SetHrhnSyoriKbn setHrhnSyoriKbn = SWAKInjector.getInstance(SetHrhnSyoriKbn.class);

        C_UmuKbn pHrkkaisuuhn = C_UmuKbn.NONE;

        C_UmuKbn pTikiktbrisyuruihn = C_UmuKbn.NONE;

        C_Hrkkeiro pBfrHrkkeiro = C_Hrkkeiro.SYUUDAN;

        C_Hrkkeiro pHenHrkkeiro = C_Hrkkeiro.CREDIT;

        C_SyoriKbn csyoriKbn = setHrhnSyoriKbn.exec(pHrkkaisuuhn, pTikiktbrisyuruihn, pBfrHrkkeiro, pHenHrkkeiro);

        exClassificationEquals(csyoriKbn, C_SyoriKbn.BLNK, "<処理区分>ブランク");
    }

    @Test
    @TestOrder(220)
    public void testExec_A22() {

        SetHrhnSyoriKbn setHrhnSyoriKbn = SWAKInjector.getInstance(SetHrhnSyoriKbn.class);

        C_UmuKbn pHrkkaisuuhn = C_UmuKbn.NONE;

        C_UmuKbn pTikiktbrisyuruihn = C_UmuKbn.NONE;

        C_Hrkkeiro pBfrHrkkeiro = C_Hrkkeiro.SYUUDAN;

        C_Hrkkeiro pHenHrkkeiro = C_Hrkkeiro.SYUUDAN;

        C_SyoriKbn csyoriKbn = setHrhnSyoriKbn.exec(pHrkkaisuuhn, pTikiktbrisyuruihn, pBfrHrkkeiro, pHenHrkkeiro);

        exClassificationEquals(csyoriKbn, C_SyoriKbn.BLNK, "0<処理区分>ブランク");
    }
}

