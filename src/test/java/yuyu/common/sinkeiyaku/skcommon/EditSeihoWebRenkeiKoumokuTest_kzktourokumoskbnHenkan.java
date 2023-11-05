package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_KzktourokuserviceTourokuKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 生保Ｗｅｂ連携項目編集のメソッド{@link EditSeihoWebRenkeiKoumoku#kzktourokumoskbnHenkan()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSeihoWebRenkeiKoumokuTest_kzktourokumoskbnHenkan {

    @Inject
    private EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testKzktourokumoskbnHenkan_A1(){

        String pKzktourokumoskbn = "1";

        C_KzktourokuserviceTourokuKbn kzktourokuserviceTourokuKbn = editSeihoWebRenkeiKoumoku.kzktourokumoskbnHenkan(pKzktourokumoskbn);

        exClassificationEquals(kzktourokuserviceTourokuKbn, C_KzktourokuserviceTourokuKbn.ARI, "ご家族登録サービス登録区分");
    }

    @Test
    @TestOrder(20)
    public void testKzktourokumoskbnHenkan_A2(){

        String pKzktourokumoskbn = "2";

        C_KzktourokuserviceTourokuKbn kzktourokuserviceTourokuKbn = editSeihoWebRenkeiKoumoku.kzktourokumoskbnHenkan(pKzktourokumoskbn);

        exClassificationEquals(kzktourokuserviceTourokuKbn, C_KzktourokuserviceTourokuKbn.NONE, "ご家族登録サービス登録区分");
    }

    @Test
    @TestOrder(30)
    public void testKzktourokumoskbnHenkan_A3(){

        String pKzktourokumoskbn = "3";

        C_KzktourokuserviceTourokuKbn kzktourokuserviceTourokuKbn = editSeihoWebRenkeiKoumoku.kzktourokumoskbnHenkan(pKzktourokumoskbn);

        exClassificationEquals(kzktourokuserviceTourokuKbn, C_KzktourokuserviceTourokuKbn.BLNK, "ご家族登録サービス登録区分");
    }
}
