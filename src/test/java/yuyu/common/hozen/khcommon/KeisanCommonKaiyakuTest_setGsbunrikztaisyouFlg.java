package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 解約共通計算のメソッド {@link KeisanCommonKaiyaku#setGsbunrikztaisyouFlg(C_UmuKbn, C_UmuKbn, C_UmuKbn)} テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanCommonKaiyakuTest_setGsbunrikztaisyouFlg {

    @Inject
    private KeisanCommonKaiyaku keisanCommonKaiyaku;

    private C_UmuKbn umuKbn;

    @Test
    @TestOrder(10)
    public void testSetGsbunrikztaisyouFlg_A1                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           () {

        C_UmuKbn pKhShrRireki = C_UmuKbn.ARI;
        C_UmuKbn pYenkaGsBunriTaisyouFlag = C_UmuKbn.NONE;
        C_UmuKbn pGaikaGsBunriTaisyouFlag = C_UmuKbn.ARI;
        C_Tuukasyu pKykTuukasyu = C_Tuukasyu.USD;

        umuKbn = keisanCommonKaiyaku.setGsbunrikztaisyouFlg(pKhShrRireki, pYenkaGsBunriTaisyouFlag, pGaikaGsBunriTaisyouFlag, pKykTuukasyu);

        exClassificationEquals(umuKbn, C_UmuKbn.NONE, "源泉分離課税対象フラグ");

    }

    @Test
    @TestOrder(20)
    public void testSetGsbunrikztaisyouFlg_A2() {

        C_UmuKbn pKhShrRireki = C_UmuKbn.NONE;
        C_UmuKbn pYenkaGsBunriTaisyouFlag = C_UmuKbn.ARI;
        C_UmuKbn pGaikaGsBunriTaisyouFlag = C_UmuKbn.NONE;
        C_Tuukasyu pKykTuukasyu = C_Tuukasyu.USD;

        umuKbn = keisanCommonKaiyaku.setGsbunrikztaisyouFlg(pKhShrRireki, pYenkaGsBunriTaisyouFlag, pGaikaGsBunriTaisyouFlag, pKykTuukasyu);

        exClassificationEquals(umuKbn, C_UmuKbn.NONE, "源泉分離課税対象フラグ");

    }

    @Test
    @TestOrder(30)
    public void testSetGsbunrikztaisyouFlg_A3() {

        C_UmuKbn pKhShrRireki = C_UmuKbn.ARI;
        C_UmuKbn pYenkaGsBunriTaisyouFlag = C_UmuKbn.ARI;
        C_UmuKbn pGaikaGsBunriTaisyouFlag = C_UmuKbn.NONE;
        C_Tuukasyu pKykTuukasyu = C_Tuukasyu.USD;

        umuKbn = keisanCommonKaiyaku.setGsbunrikztaisyouFlg(pKhShrRireki, pYenkaGsBunriTaisyouFlag, pGaikaGsBunriTaisyouFlag, pKykTuukasyu);

        exClassificationEquals(umuKbn, C_UmuKbn.ARI, "源泉分離課税対象フラグ");

    }

    @Test
    @TestOrder(40)
    public void testSetGsbunrikztaisyouFlg_A4() {

        C_UmuKbn pKhShrRireki = C_UmuKbn.NONE;
        C_UmuKbn pYenkaGsBunriTaisyouFlag = C_UmuKbn.NONE;
        C_UmuKbn pGaikaGsBunriTaisyouFlag = C_UmuKbn.ARI;
        C_Tuukasyu pKykTuukasyu = C_Tuukasyu.USD;

        umuKbn = keisanCommonKaiyaku.setGsbunrikztaisyouFlg(pKhShrRireki, pYenkaGsBunriTaisyouFlag, pGaikaGsBunriTaisyouFlag, pKykTuukasyu);

        exClassificationEquals(umuKbn, C_UmuKbn.ARI, "源泉分離課税対象フラグ");

    }

    @Test
    @TestOrder(50)
    public void testSetGsbunrikztaisyouFlg_A5() {

        C_UmuKbn pKhShrRireki = C_UmuKbn.NONE;
        C_UmuKbn pYenkaGsBunriTaisyouFlag = C_UmuKbn.NONE;
        C_UmuKbn pGaikaGsBunriTaisyouFlag = C_UmuKbn.NONE;
        C_Tuukasyu pKykTuukasyu = C_Tuukasyu.USD;

        umuKbn = keisanCommonKaiyaku.setGsbunrikztaisyouFlg(pKhShrRireki, pYenkaGsBunriTaisyouFlag, pGaikaGsBunriTaisyouFlag, pKykTuukasyu);

        exClassificationEquals(umuKbn, C_UmuKbn.NONE, "源泉分離課税対象フラグ");

    }

    @Test
    @TestOrder(60)
    public void testSetGsbunrikztaisyouFlg_A6() {

        C_UmuKbn pKhShrRireki = C_UmuKbn.NONE;
        C_UmuKbn pYenkaGsBunriTaisyouFlag = C_UmuKbn.ARI;
        C_UmuKbn pGaikaGsBunriTaisyouFlag = C_UmuKbn.NONE;
        C_Tuukasyu pKykTuukasyu = C_Tuukasyu.JPY;

        umuKbn = keisanCommonKaiyaku.setGsbunrikztaisyouFlg(pKhShrRireki, pYenkaGsBunriTaisyouFlag, pGaikaGsBunriTaisyouFlag, pKykTuukasyu);

        exClassificationEquals(umuKbn, C_UmuKbn.ARI, "源泉分離課税対象フラグ");

    }

    @Test
    @TestOrder(70)
    public void testSetGsbunrikztaisyouFlg_A7() {

        C_UmuKbn pKhShrRireki = C_UmuKbn.NONE;
        C_UmuKbn pYenkaGsBunriTaisyouFlag = C_UmuKbn.NONE;
        C_UmuKbn pGaikaGsBunriTaisyouFlag = C_UmuKbn.NONE;
        C_Tuukasyu pKykTuukasyu = C_Tuukasyu.JPY;

        umuKbn = keisanCommonKaiyaku.setGsbunrikztaisyouFlg(pKhShrRireki, pYenkaGsBunriTaisyouFlag, pGaikaGsBunriTaisyouFlag, pKykTuukasyu);

        exClassificationEquals(umuKbn, C_UmuKbn.NONE, "源泉分離課税対象フラグ");

    }

}
