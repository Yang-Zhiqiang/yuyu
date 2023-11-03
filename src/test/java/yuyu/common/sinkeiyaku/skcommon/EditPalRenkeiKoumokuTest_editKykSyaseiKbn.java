package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_Kyksei;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＰＡＬ連携項目編集クラスのメソッド
 * {@link EditPalRenkeiKoumoku#editKykSyaseiKbn(C_KykKbn, C_Hhknsei, C_Kyksei)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditPalRenkeiKoumokuTest_editKykSyaseiKbn {

    @Inject
    private EditPalRenkeiKoumoku editPalRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testEditKykSyaseiKbn_A1() {

        String kykSyaseiKbn = editPalRenkeiKoumoku.editKykSyaseiKbn(C_KykKbn.KEIHI_BETU, C_Hhknsei.BLNK, C_Kyksei.MALE);

        exStringEquals(kykSyaseiKbn, "1", "契約者性別区分");
    }

    @Test
    @TestOrder(20)
    public void testEditKykSyaseiKbn_A2() {

        String kykSyaseiKbn = editPalRenkeiKoumoku.editKykSyaseiKbn(C_KykKbn.KEIHI_BETU, C_Hhknsei.BLNK, C_Kyksei.FEMALE);

        exStringEquals(kykSyaseiKbn, "2", "契約者性別区分");
    }

    @Test
    @TestOrder(30)
    public void testEditKykSyaseiKbn_A3() {

        String kykSyaseiKbn = editPalRenkeiKoumoku.editKykSyaseiKbn(C_KykKbn.KEIHI_BETU, C_Hhknsei.BLNK, C_Kyksei.BLNK);

        exStringEquals(kykSyaseiKbn, "0", "契約者性別区分");
    }

    @Test
    @TestOrder(40)
    public void testEditKykSyaseiKbn_A4() {

        String kykSyaseiKbn = editPalRenkeiKoumoku.editKykSyaseiKbn(C_KykKbn.BLNK, C_Hhknsei.MALE, C_Kyksei.BLNK);

        exStringEquals(kykSyaseiKbn, "1", "契約者性別区分");
    }

    @Test
    @TestOrder(50)
    public void testEditKykSyaseiKbn_A5() {

        String kykSyaseiKbn = editPalRenkeiKoumoku.editKykSyaseiKbn(C_KykKbn.BLNK, C_Hhknsei.FEMALE, C_Kyksei.BLNK);

        exStringEquals(kykSyaseiKbn, "2", "契約者性別区分");
    }

    @Test
    @TestOrder(60)
    public void testEditKykSyaseiKbn_A6() {

        String kykSyaseiKbn = editPalRenkeiKoumoku.editKykSyaseiKbn(C_KykKbn.BLNK, C_Hhknsei.BLNK, C_Kyksei.BLNK);

        exStringEquals(kykSyaseiKbn, "0", "契約者性別区分");
    }

    @Test
    @TestOrder(70)
    public void testEditKykSyaseiKbn_A7() {

        String kykSyaseiKbn = editPalRenkeiKoumoku.editKykSyaseiKbn(C_KykKbn.KEIHI_BETU, C_Hhknsei.BLNK, C_Kyksei.HJNKYK);

        exStringEquals(kykSyaseiKbn, "0", "契約者性別区分");
    }

    @Test
    @TestOrder(80)
    public void testEditKykSyaseiKbn_A8() {

        String kykSyaseiKbn = editPalRenkeiKoumoku.editKykSyaseiKbn(C_KykKbn.KEIHI_DOUITU, C_Hhknsei.MALE, C_Kyksei.BLNK);

        exStringEquals(kykSyaseiKbn, "1", "契約者性別区分");
        MockObjectManager.initialize();
    }
}