package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 生保Ｗｅｂ連携項目編集のメソッド{@link EditSeihoWebRenkeiKoumoku#syouhnhantei(C_HknsyuruiNo)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSeihoWebRenkeiKoumokuTest_syouhnhantei {

    @Inject
    private EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testSyouhnhantei_A1() {

        C_HknsyuruiNo pHknsyuruiNo = C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_19_SGARI;

        String syouhinHantei = editSeihoWebRenkeiKoumoku.syouhnhantei(pHknsyuruiNo);

        exStringEquals(syouhinHantei, "1", "商品判定（商品属性マスタ取得用）");
    }

    @Test
    @TestOrder(20)
    public void testSyouhnhantei_A2() {

        C_HknsyuruiNo pHknsyuruiNo = C_HknsyuruiNo.GAIKAINDEXNK;

        String syouhinHantei = editSeihoWebRenkeiKoumoku.syouhnhantei(pHknsyuruiNo);

        exStringEquals(syouhinHantei, "1", "商品判定（商品属性マスタ取得用）");
    }

    @Test
    @TestOrder(30)
    public void testSyouhnhantei_A3() {

        C_HknsyuruiNo pHknsyuruiNo = C_HknsyuruiNo.GAIKAINDEXNK_SISUU;

        String syouhinHantei = editSeihoWebRenkeiKoumoku.syouhnhantei(pHknsyuruiNo);

        exStringEquals(syouhinHantei, "1", "商品判定（商品属性マスタ取得用）");
    }

    @Test
    @TestOrder(40)
    public void testSyouhnhantei_A4() {

        C_HknsyuruiNo pHknsyuruiNo = C_HknsyuruiNo.GAIKAINDEXNK_TEIRITU;

        String syouhinHantei = editSeihoWebRenkeiKoumoku.syouhnhantei(pHknsyuruiNo);

        exStringEquals(syouhinHantei, "1", "商品判定（商品属性マスタ取得用）");
    }

    @Test
    @TestOrder(50)
    public void testSyouhnhantei_A5() {

        C_HknsyuruiNo pHknsyuruiNo = C_HknsyuruiNo.GAIKAINDEXNK_20_SISUU;

        String syouhinHantei = editSeihoWebRenkeiKoumoku.syouhnhantei(pHknsyuruiNo);

        exStringEquals(syouhinHantei, "1", "商品判定（商品属性マスタ取得用）");
    }

    @Test
    @TestOrder(60)
    public void testSyouhnhantei_A6() {

        C_HknsyuruiNo pHknsyuruiNo = C_HknsyuruiNo.GAIKAINDEXNK_20_TEIRITUTEIKI;

        String syouhinHantei = editSeihoWebRenkeiKoumoku.syouhnhantei(pHknsyuruiNo);

        exStringEquals(syouhinHantei, "1", "商品判定（商品属性マスタ取得用）");
    }

    @Test
    @TestOrder(70)
    public void testSyouhnhantei_A7() {

        C_HknsyuruiNo pHknsyuruiNo = C_HknsyuruiNo.GAIKARIRITUHENDOUNK;

        String syouhinHantei = editSeihoWebRenkeiKoumoku.syouhnhantei(pHknsyuruiNo);

        exStringEquals(syouhinHantei, "1", "商品判定（商品属性マスタ取得用）");
    }

    @Test
    @TestOrder(80)
    public void testSyouhnhantei_A8() {

        C_HknsyuruiNo pHknsyuruiNo = C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_YOKUSEI;

        String syouhinHantei = editSeihoWebRenkeiKoumoku.syouhnhantei(pHknsyuruiNo);

        exStringEquals(syouhinHantei, "2", "商品判定（商品属性マスタ取得用）");
    }
}
