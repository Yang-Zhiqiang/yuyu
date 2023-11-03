package yuyu.common.hozen.ascommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険料領収通貨取得クラスのメソッド {@link GetasPRsTuuka#editRyousyuuTuukaSyuruiHantei(C_Tuukasyu,C_UmuKbn,C_UmuKbn)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class GetasPRsTuukaTest_editRyousyuuTuukaSyuruiHantei {

    @Inject
    GetasPRsTuuka getasPRsTuuka;

    @Test
    @TestOrder(10)
    public void testEditRyousyuuTuukaSyuruiHantei_A1() {

        C_ErrorKbn kekkaKbn =  getasPRsTuuka.editRyousyuuTuukaSyuruiHantei(null, C_UmuKbn.NONE, C_UmuKbn.NONE);

        exClassificationEquals(kekkaKbn, C_ErrorKbn.ERROR, "結果区分");
        exClassificationEquals(getasPRsTuuka.getRstuukasyu(), C_Tuukasyu.BLNK, "領収通貨種類");
    }

    @Test
    @TestOrder(20)
    public void testEditRyousyuuTuukaSyuruiHantei_A2() {

        C_ErrorKbn kekkaKbn =  getasPRsTuuka.editRyousyuuTuukaSyuruiHantei(C_Tuukasyu.JPY, null, C_UmuKbn.NONE);

        exClassificationEquals(kekkaKbn, C_ErrorKbn.ERROR, "結果区分");
        exClassificationEquals(getasPRsTuuka.getRstuukasyu(), C_Tuukasyu.BLNK, "領収通貨種類");
    }

    @Test
    @TestOrder(30)
    public void testEditRyousyuuTuukaSyuruiHantei_A3() {

        C_ErrorKbn kekkaKbn =  getasPRsTuuka.editRyousyuuTuukaSyuruiHantei(C_Tuukasyu.JPY, C_UmuKbn.NONE, null);

        exClassificationEquals(kekkaKbn, C_ErrorKbn.ERROR, "結果区分");
        exClassificationEquals(getasPRsTuuka.getRstuukasyu(), C_Tuukasyu.BLNK, "領収通貨種類");
    }

    @Test
    @TestOrder(40)
    public void testEditRyousyuuTuukaSyuruiHantei_A4() {

        C_ErrorKbn kekkaKbn =  getasPRsTuuka.editRyousyuuTuukaSyuruiHantei(C_Tuukasyu.JPY, C_UmuKbn.NONE, C_UmuKbn.NONE);

        exClassificationEquals(kekkaKbn, C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(getasPRsTuuka.getRstuukasyu(), C_Tuukasyu.JPY, "領収通貨種類");
    }

    @Test
    @TestOrder(50)
    public void testEditRyousyuuTuukaSyuruiHantei_A5() {

        C_ErrorKbn kekkaKbn =  getasPRsTuuka.editRyousyuuTuukaSyuruiHantei(C_Tuukasyu.USD, C_UmuKbn.ARI, C_UmuKbn.NONE);

        exClassificationEquals(kekkaKbn, C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(getasPRsTuuka.getRstuukasyu(), C_Tuukasyu.JPY, "領収通貨種類");
    }

    @Test
    @TestOrder(60)
    public void testEditRyousyuuTuukaSyuruiHantei_A6() {

        C_ErrorKbn kekkaKbn =  getasPRsTuuka.editRyousyuuTuukaSyuruiHantei(C_Tuukasyu.USD, C_UmuKbn.NONE, C_UmuKbn.ARI);

        exClassificationEquals(kekkaKbn, C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(getasPRsTuuka.getRstuukasyu(), C_Tuukasyu.AUD, "領収通貨種類");
    }

    @Test
    @TestOrder(70)
    public void testEditRyousyuuTuukaSyuruiHantei_A7() {

        C_ErrorKbn kekkaKbn =  getasPRsTuuka.editRyousyuuTuukaSyuruiHantei(C_Tuukasyu.AUD, C_UmuKbn.NONE, C_UmuKbn.ARI);

        exClassificationEquals(kekkaKbn, C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(getasPRsTuuka.getRstuukasyu(), C_Tuukasyu.USD, "領収通貨種類");
    }

    @Test
    @TestOrder(80)
    public void testEditRyousyuuTuukaSyuruiHantei_A8() {

        C_ErrorKbn kekkaKbn =  getasPRsTuuka.editRyousyuuTuukaSyuruiHantei(C_Tuukasyu.EUR, C_UmuKbn.NONE, C_UmuKbn.ARI);

        exClassificationEquals(kekkaKbn, C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(getasPRsTuuka.getRstuukasyu(), C_Tuukasyu.EUR, "領収通貨種類");
    }

    @Test
    @TestOrder(90)
    public void testEditRyousyuuTuukaSyuruiHantei_A9() {

        C_ErrorKbn kekkaKbn =  getasPRsTuuka.editRyousyuuTuukaSyuruiHantei(C_Tuukasyu.USD, C_UmuKbn.NONE, C_UmuKbn.NONE);

        exClassificationEquals(kekkaKbn, C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(getasPRsTuuka.getRstuukasyu(), C_Tuukasyu.USD, "領収通貨種類");
    }
}
