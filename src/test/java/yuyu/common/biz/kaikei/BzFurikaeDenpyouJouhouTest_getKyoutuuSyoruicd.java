package yuyu.common.biz.kaikei;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_KeirisysKbn;
import yuyu.def.classification.C_SeiHukuKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 振替伝票情報クラスのメソッド {@link BzFurikaeDenpyouJouhouTest#getKyoutuuSyoruicd()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzFurikaeDenpyouJouhouTest_getKyoutuuSyoruicd {

    @Inject
    private BzFurikaeDenpyouJouhou bzFurikaeDenpyouJouhou;

    @Test
    @TestOrder(10)
    public void testGetKyoutuuSyoruicd_A1() {
        bzFurikaeDenpyouJouhou.setKeiriSysKbn(C_KeirisysKbn.FUHO);
        C_SeiHukuKbn seiHukuKbn = C_SeiHukuKbn.SEI;

        bzFurikaeDenpyouJouhou.getKyoutuuSyoruicd(seiHukuKbn);

        exClassificationEquals(bzFurikaeDenpyouJouhou.getKyoutuuSyoruicd(seiHukuKbn), C_SyoruiCdKbn.CM_HURIDEN, "共通項目書類コード");
    }

    @Test
    @TestOrder(20)
    public void testGetKyoutuuSyoruicd_A2() {
        bzFurikaeDenpyouJouhou.setKeiriSysKbn(C_KeirisysKbn.FUHO);
        C_SeiHukuKbn seiHukuKbn = C_SeiHukuKbn.HUKU;

        bzFurikaeDenpyouJouhou.getKyoutuuSyoruicd(seiHukuKbn);

        exClassificationEquals(bzFurikaeDenpyouJouhou.getKyoutuuSyoruicd(seiHukuKbn), C_SyoruiCdKbn.CM_HURIDEN_HIKAE, "共通項目書類コード");
    }

    @Test
    @TestOrder(30)
    public void testGetKyoutuuSyoruicd_A3() {
        bzFurikaeDenpyouJouhou.setKeiriSysKbn(C_KeirisysKbn.SINKEIYAKU);
        C_SeiHukuKbn seiHukuKbn = C_SeiHukuKbn.SEI;

        bzFurikaeDenpyouJouhou.getKyoutuuSyoruicd(seiHukuKbn);

        exClassificationEquals(bzFurikaeDenpyouJouhou.getKyoutuuSyoruicd(seiHukuKbn), C_SyoruiCdKbn.CM_SK_HURIDEN, "共通項目書類コード");
    }

    @Test
    @TestOrder(40)
    public void testGetKyoutuuSyoruicd_A4() {
        bzFurikaeDenpyouJouhou.setKeiriSysKbn(C_KeirisysKbn.SINKEIYAKU);
        C_SeiHukuKbn seiHukuKbn = C_SeiHukuKbn.HUKU;

        bzFurikaeDenpyouJouhou.getKyoutuuSyoruicd(seiHukuKbn);

        exClassificationEquals(bzFurikaeDenpyouJouhou.getKyoutuuSyoruicd(seiHukuKbn), C_SyoruiCdKbn.CM_SK_HURIDEN_HIKAE, "共通項目書類コード");
    }

    @Test
    @TestOrder(50)
    public void testGetKyoutuuSyoruicd_A5() {
        bzFurikaeDenpyouJouhou.setKeiriSysKbn(C_KeirisysKbn.KESSANSINKEIYAKU);
        C_SeiHukuKbn seiHukuKbn = C_SeiHukuKbn.SEI;

        bzFurikaeDenpyouJouhou.getKyoutuuSyoruicd(seiHukuKbn);

        exClassificationEquals(bzFurikaeDenpyouJouhou.getKyoutuuSyoruicd(seiHukuKbn), C_SyoruiCdKbn.SR_SK_KESSANHURIDEN, "共通項目書類コード");
    }

    @Test
    @TestOrder(60)
    public void testGetKyoutuuSyoruicd_A6() {
        bzFurikaeDenpyouJouhou.setKeiriSysKbn(C_KeirisysKbn.KESSANSINKEIYAKU);
        C_SeiHukuKbn seiHukuKbn = C_SeiHukuKbn.HUKU;

        bzFurikaeDenpyouJouhou.getKyoutuuSyoruicd(seiHukuKbn);

        exClassificationEquals(bzFurikaeDenpyouJouhou.getKyoutuuSyoruicd(seiHukuKbn), C_SyoruiCdKbn.SR_SK_KESSANHURIDEN_HIKAE, "共通項目書類コード");
    }

    @Test
    @TestOrder(70)
    public void testGetKyoutuuSyoruicd_A7() {
        bzFurikaeDenpyouJouhou.setKeiriSysKbn(C_KeirisysKbn.BLNK);
        C_SeiHukuKbn seiHukuKbn = C_SeiHukuKbn.SEI;

        bzFurikaeDenpyouJouhou.getKyoutuuSyoruicd(seiHukuKbn);

        exClassificationEquals(bzFurikaeDenpyouJouhou.getKyoutuuSyoruicd(seiHukuKbn), C_SyoruiCdKbn.BLNK, "共通項目書類コード");
    }
}
