package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_TumitatekinHaibunWariKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 生保Ｗｅｂ連携項目編集のメソッド {@link EditSeihoWebRenkeiKoumoku#tumitatekinHaibunWariKbnHenkan(Integer)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSeihoWebRenkeiKoumokuTest_tumitatekinHaibunWariKbnHenkan {

    @Inject
    private EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testTumitatekinHaibunWariKbnHenkan_A1() {

        C_TumitatekinHaibunWariKbn tumitatekinHaibunWariKbn =
            editSeihoWebRenkeiKoumoku.tumitatekinHaibunWariKbnHenkan(0, C_UmuKbn.ARI);

        exClassificationEquals(tumitatekinHaibunWariKbn, C_TumitatekinHaibunWariKbn.WARIAI000, "積立金配分割合区分");

    }

    @Test
    @TestOrder(20)
    public void testTumitatekinHaibunWariKbnHenkan_A2() {

        C_TumitatekinHaibunWariKbn tumitatekinHaibunWariKbn =
            editSeihoWebRenkeiKoumoku.tumitatekinHaibunWariKbnHenkan(10, C_UmuKbn.ARI);

        exClassificationEquals(tumitatekinHaibunWariKbn, C_TumitatekinHaibunWariKbn.WARIAI010, "積立金配分割合区分");

    }

    @Test
    @TestOrder(30)
    public void testTumitatekinHaibunWariKbnHenkan_A3() {

        C_TumitatekinHaibunWariKbn tumitatekinHaibunWariKbn =
            editSeihoWebRenkeiKoumoku.tumitatekinHaibunWariKbnHenkan(20, C_UmuKbn.ARI);

        exClassificationEquals(tumitatekinHaibunWariKbn, C_TumitatekinHaibunWariKbn.WARIAI020, "積立金配分割合区分");

    }

    @Test
    @TestOrder(40)
    public void testTumitatekinHaibunWariKbnHenkan_A4() {

        C_TumitatekinHaibunWariKbn tumitatekinHaibunWariKbn =
            editSeihoWebRenkeiKoumoku.tumitatekinHaibunWariKbnHenkan(30, C_UmuKbn.ARI);

        exClassificationEquals(tumitatekinHaibunWariKbn, C_TumitatekinHaibunWariKbn.WARIAI030, "積立金配分割合区分");

    }

    @Test
    @TestOrder(50)
    public void testTumitatekinHaibunWariKbnHenkan_A5() {

        C_TumitatekinHaibunWariKbn tumitatekinHaibunWariKbn =
            editSeihoWebRenkeiKoumoku.tumitatekinHaibunWariKbnHenkan(40, C_UmuKbn.ARI);

        exClassificationEquals(tumitatekinHaibunWariKbn, C_TumitatekinHaibunWariKbn.WARIAI040, "積立金配分割合区分");

    }

    @Test
    @TestOrder(60)
    public void testTumitatekinHaibunWariKbnHenkan_A6() {

        C_TumitatekinHaibunWariKbn tumitatekinHaibunWariKbn =
            editSeihoWebRenkeiKoumoku.tumitatekinHaibunWariKbnHenkan(50, C_UmuKbn.ARI);

        exClassificationEquals(tumitatekinHaibunWariKbn, C_TumitatekinHaibunWariKbn.WARIAI050, "積立金配分割合区分");

    }

    @Test
    @TestOrder(70)
    public void testTumitatekinHaibunWariKbnHenkan_A7() {

        C_TumitatekinHaibunWariKbn tumitatekinHaibunWariKbn =
            editSeihoWebRenkeiKoumoku.tumitatekinHaibunWariKbnHenkan(60, C_UmuKbn.ARI);

        exClassificationEquals(tumitatekinHaibunWariKbn, C_TumitatekinHaibunWariKbn.WARIAI060, "積立金配分割合区分");

    }

    @Test
    @TestOrder(80)
    public void testTumitatekinHaibunWariKbnHenkan_A8() {

        C_TumitatekinHaibunWariKbn tumitatekinHaibunWariKbn =
            editSeihoWebRenkeiKoumoku.tumitatekinHaibunWariKbnHenkan(70, C_UmuKbn.ARI);

        exClassificationEquals(tumitatekinHaibunWariKbn, C_TumitatekinHaibunWariKbn.WARIAI070, "積立金配分割合区分");

    }

    @Test
    @TestOrder(90)
    public void testTumitatekinHaibunWariKbnHenkan_A9() {

        C_TumitatekinHaibunWariKbn tumitatekinHaibunWariKbn =
            editSeihoWebRenkeiKoumoku.tumitatekinHaibunWariKbnHenkan(80, C_UmuKbn.ARI);

        exClassificationEquals(tumitatekinHaibunWariKbn, C_TumitatekinHaibunWariKbn.WARIAI080, "積立金配分割合区分");

    }

    @Test
    @TestOrder(100)
    public void testTumitatekinHaibunWariKbnHenkan_A10() {

        C_TumitatekinHaibunWariKbn tumitatekinHaibunWariKbn =
            editSeihoWebRenkeiKoumoku.tumitatekinHaibunWariKbnHenkan(90, C_UmuKbn.ARI);

        exClassificationEquals(tumitatekinHaibunWariKbn, C_TumitatekinHaibunWariKbn.WARIAI090, "積立金配分割合区分");

    }

    @Test
    @TestOrder(110)
    public void testTumitatekinHaibunWariKbnHenkan_A11() {

        C_TumitatekinHaibunWariKbn tumitatekinHaibunWariKbn =
            editSeihoWebRenkeiKoumoku.tumitatekinHaibunWariKbnHenkan(100, C_UmuKbn.ARI);

        exClassificationEquals(tumitatekinHaibunWariKbn, C_TumitatekinHaibunWariKbn.WARIAI100, "積立金配分割合区分");

    }

    @Test
    @TestOrder(120)
    public void testTumitatekinHaibunWariKbnHenkan_A12() {

        C_TumitatekinHaibunWariKbn tumitatekinHaibunWariKbn =
            editSeihoWebRenkeiKoumoku.tumitatekinHaibunWariKbnHenkan(101, C_UmuKbn.ARI);

        exClassificationEquals(tumitatekinHaibunWariKbn, C_TumitatekinHaibunWariKbn.BLNK, "積立金配分割合区分");

    }

    @Test
    @TestOrder(130)
    public void testTumitatekinHaibunWariKbnHenkan_A13() {

        C_TumitatekinHaibunWariKbn tumitatekinHaibunWariKbn =
            editSeihoWebRenkeiKoumoku.tumitatekinHaibunWariKbnHenkan(0, C_UmuKbn.NONE);

        exClassificationEquals(tumitatekinHaibunWariKbn, C_TumitatekinHaibunWariKbn.BLNK, "積立金配分割合区分");

    }
}
