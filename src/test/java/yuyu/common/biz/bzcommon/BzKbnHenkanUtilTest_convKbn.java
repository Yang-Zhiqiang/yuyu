package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SystemRenkeiHenkanHoukouKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_HaitoukinuketorihouKbn;
import yuyu.def.classification.C_StknsetKbn;
import yuyu.def.classification.C_HaitouKbn;
import yuyu.def.classification.C_Kyksei;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_HonninkakuninSyoruiKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Kykkaksyrui;
import yuyu.def.classification.C_FatcakakkekkaKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_TodouhukenKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Sisuukbn;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_Yuukoukakkekka;
import yuyu.def.classification.C_CreditUriageNgJiyuuKbn;
import yuyu.def.classification.C_AuthoriKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * {@link BzKbnHenkanUtil}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzKbnHenkanUtilTest_convKbn {

    @Inject
    private BzKbnHenkanUtil bzKbnHenkanUtil;

    @Test
    @TestOrder(10)
    public void testConvKbn_A1() {

        String before = null;
        Class<?> clazz = C_Tdk.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), null, "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), false, "区分値変換結果");
    }

    @Test
    @TestOrder(20)
    public void testConvKbn_A2() {

        String before = "99";
        Class<?> clazz = null;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "99", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), false, "区分値変換結果");
    }

    @Test
    @TestOrder(30)
    public void testConvKbn_A3() {

        String before = "99";
        Class<?> clazz = C_Tdk.class;
        C_SystemRenkeiHenkanHoukouKbn direction = null;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "99", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), false, "区分値変換結果");
    }

    @Test
    @TestOrder(40)
    public void testConvKbn_A4() {

        String before = "1";
        Class<?> clazz = C_Tdk.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "0", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(50)
    public void testConvKbn_A5() {

        String before = "2";
        Class<?> clazz = C_Tdk.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "1", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(60)
    public void testConvKbn_A6() {

        String before = "4";
        Class<?> clazz = C_Tdk.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "2", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(70)
    public void testConvKbn_A7() {

        String before = "3";
        Class<?> clazz = C_Tdk.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "3", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(80)
    public void testConvKbn_A8() {

        String before = "7";
        Class<?> clazz = C_Tdk.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "4", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(90)
    public void testConvKbn_A9() {

        String before = "5";
        Class<?> clazz = C_Tdk.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "5", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(100)
    public void testConvKbn_A10() {

        String before = "6";
        Class<?> clazz = C_Tdk.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "6", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(110)
    public void testConvKbn_A11() {

        String before = "8";
        Class<?> clazz = C_Tdk.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "7", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(120)
    public void testConvKbn_A12() {

        String before = "9";
        Class<?> clazz = C_Tdk.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "8", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(130)
    public void testConvKbn_A13() {

        String before = "99";
        Class<?> clazz = C_Tdk.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "9", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(140)
    public void testConvKbn_A14() {

        String before = "99999";
        Class<?> clazz = C_Tdk.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "99999", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), false, "区分値変換結果");
    }

    @Test
    @TestOrder(150)
    public void testConvKbn_A15() {

        String before = "0";
        Class<?> clazz = C_Tdk.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "1", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(160)
    public void testConvKbn_A16() {

        String before = "1";
        Class<?> clazz = C_Tdk.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "2", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(170)
    public void testConvKbn_A17() {

        String before = "2";
        Class<?> clazz = C_Tdk.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "4", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(180)
    public void testConvKbn_A18() {

        String before = "3";
        Class<?> clazz = C_Tdk.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "3", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(190)
    public void testConvKbn_A19() {

        String before = "4";
        Class<?> clazz = C_Tdk.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "7", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(200)
    public void testConvKbn_A20() {

        String before = "5";
        Class<?> clazz = C_Tdk.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "5", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(210)
    public void testConvKbn_A21() {

        String before = "6";
        Class<?> clazz = C_Tdk.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "6", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(220)
    public void testConvKbn_A22() {

        String before = "7";
        Class<?> clazz = C_Tdk.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "8", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(230)
    public void testConvKbn_A23() {

        String before = "8";
        Class<?> clazz = C_Tdk.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "9", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(240)
    public void testConvKbn_A24() {

        String before = "9";
        Class<?> clazz = C_Tdk.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "99", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(250)
    public void testConvKbn_A25() {

        String before = "99999";
        Class<?> clazz = C_Tdk.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "99999", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), false, "区分値変換結果");
    }

    @Test
    @TestOrder(260)
    public void testConvKbn_A26() {

        String before = "1";
        Class<?> clazz = C_HknkknsmnKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "1", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(270)
    public void testConvKbn_A27() {

        String before = "2";
        Class<?> clazz = C_HknkknsmnKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "0", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(280)
    public void testConvKbn_A28() {

        String before = "99999";
        Class<?> clazz = C_HknkknsmnKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "99999", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), false, "区分値変換結果");
    }

    @Test
    @TestOrder(290)
    public void testConvKbn_A29() {

        String before = "1";
        Class<?> clazz = C_HknkknsmnKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "1", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(300)
    public void testConvKbn_A30() {

        String before = "0";
        Class<?> clazz = C_HknkknsmnKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "2", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(310)
    public void testConvKbn_A31() {

        String before = "99999";
        Class<?> clazz = C_HknkknsmnKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "99999", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), false, "区分値変換結果");
    }

    @Test
    @TestOrder(320)
    public void testConvKbn_A32() {

        String before = "1";
        Class<?> clazz = C_HrkkknsmnKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "1", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(330)
    public void testConvKbn_A33() {

        String before = "2";
        Class<?> clazz = C_HrkkknsmnKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "0", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(340)
    public void testConvKbn_A34() {

        String before = "99999";
        Class<?> clazz = C_HrkkknsmnKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "99999", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), false, "区分値変換結果");
    }

    @Test
    @TestOrder(350)
    public void testConvKbn_A35() {

        String before = "1";
        Class<?> clazz = C_HrkkknsmnKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "1", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(360)
    public void testConvKbn_A36() {

        String before = "0";
        Class<?> clazz = C_HrkkknsmnKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "2", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(370)
    public void testConvKbn_A37() {

        String before = "99999";
        Class<?> clazz = C_HrkkknsmnKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "99999", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), false, "区分値変換結果");
    }

    @Test
    @TestOrder(380)
    public void testConvKbn_A38() {

        String before = "1";
        Class<?> clazz = C_Hhknsei.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "1", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(390)
    public void testConvKbn_A39() {

        String before = "2";
        Class<?> clazz = C_Hhknsei.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "2", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(400)
    public void testConvKbn_A40() {

        String before = "0";
        Class<?> clazz = C_Hhknsei.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "0", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(410)
    public void testConvKbn_A41() {

        String before = "99999";
        Class<?> clazz = C_Hhknsei.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "99999", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), false, "区分値変換結果");
    }

    @Test
    @TestOrder(420)
    public void testConvKbn_A42() {

        String before = "1";
        Class<?> clazz = C_Hhknsei.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "1", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(430)
    public void testConvKbn_A43() {

        String before = "2";
        Class<?> clazz = C_Hhknsei.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "2", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(440)
    public void testConvKbn_A44() {

        String before = "0";
        Class<?> clazz = C_Hhknsei.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "0", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(450)
    public void testConvKbn_A45() {

        String before = "99999";
        Class<?> clazz = C_Hhknsei.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "99999", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), false, "区分値変換結果");
    }

    @Test
    @TestOrder(460)
    public void testConvKbn_A46() {

        String before = "99";
        Class<?> clazz = C_Hrkkaisuu.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "0", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(470)
    public void testConvKbn_A47() {

        String before = "12";
        Class<?> clazz = C_Hrkkaisuu.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "1", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(480)
    public void testConvKbn_A48() {

        String before = "6";
        Class<?> clazz = C_Hrkkaisuu.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "2", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(490)
    public void testConvKbn_A49() {

        String before = "1";
        Class<?> clazz = C_Hrkkaisuu.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "3", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(500)
    public void testConvKbn_A50() {

        String before = "99999";
        Class<?> clazz = C_Hrkkaisuu.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "99999", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), false, "区分値変換結果");
    }

    @Test
    @TestOrder(510)
    public void testConvKbn_A51() {

        String before = "0";
        Class<?> clazz = C_Hrkkaisuu.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "99", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(520)
    public void testConvKbn_A52() {

        String before = "1";
        Class<?> clazz = C_Hrkkaisuu.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "12", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(530)
    public void testConvKbn_A53() {

        String before = "2";
        Class<?> clazz = C_Hrkkaisuu.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "6", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(540)
    public void testConvKbn_A54() {

        String before = "3";
        Class<?> clazz = C_Hrkkaisuu.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "1", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(550)
    public void testConvKbn_A55() {

        String before = "99999";
        Class<?> clazz = C_Hrkkaisuu.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "99999", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), false, "区分値変換結果");
    }

    @Test
    @TestOrder(560)
    public void testConvKbn_A56() {

        String before = "1";
        Class<?> clazz = C_Sdpd.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "1", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(570)
    public void testConvKbn_A57() {

        String before = "2";
        Class<?> clazz = C_Sdpd.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "2", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(580)
    public void testConvKbn_A58() {

        String before = "99999";
        Class<?> clazz = C_Sdpd.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "99999", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), false, "区分値変換結果");
    }

    @Test
    @TestOrder(590)
    public void testConvKbn_A59() {

        String before = "1";
        Class<?> clazz = C_Sdpd.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "1", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(600)
    public void testConvKbn_A60() {

        String before = "2";
        Class<?> clazz = C_Sdpd.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "2", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(610)
    public void testConvKbn_A61() {

        String before = "99999";
        Class<?> clazz = C_Sdpd.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "99999", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), false, "区分値変換結果");
    }

    @Test
    @TestOrder(620)
    public void testConvKbn_A62() {

        String before = "1";
        Class<?> clazz = C_HaitoukinuketorihouKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "1", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(630)
    public void testConvKbn_A63() {

        String before = "0";
        Class<?> clazz = C_HaitoukinuketorihouKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "0", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(640)
    public void testConvKbn_A64() {

        String before = "99999";
        Class<?> clazz = C_HaitoukinuketorihouKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "99999", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), false, "区分値変換結果");
    }

    @Test
    @TestOrder(650)
    public void testConvKbn_A65() {

        String before = "1";
        Class<?> clazz = C_HaitoukinuketorihouKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "1", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(660)
    public void testConvKbn_A66() {

        String before = "0";
        Class<?> clazz = C_HaitoukinuketorihouKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "0", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(670)
    public void testConvKbn_A67() {

        String before = "99999";
        Class<?> clazz = C_HaitoukinuketorihouKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "99999", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), false, "区分値変換結果");
    }

    @Test
    @TestOrder(680)
    public void testConvKbn_A68() {

        String before = "1";
        Class<?> clazz = C_StknsetKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "1", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(690)
    public void testConvKbn_A69() {

        String before = "99999";
        Class<?> clazz = C_StknsetKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "99999", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), false, "区分値変換結果");
    }

    @Test
    @TestOrder(700)
    public void testConvKbn_A70() {

        String before = "1";
        Class<?> clazz = C_StknsetKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "1", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(710)
    public void testConvKbn_A71() {

        String before = "99999";
        Class<?> clazz = C_StknsetKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "99999", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), false, "区分値変換結果");
    }

    @Test
    @TestOrder(720)
    public void testConvKbn_A72() {

        String before = "3";
        Class<?> clazz = C_HaitouKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "1", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(730)
    public void testConvKbn_A73() {

        String before = "2";
        Class<?> clazz = C_HaitouKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "2", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(740)
    public void testConvKbn_A74() {

        String before = "1";
        Class<?> clazz = C_HaitouKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "3", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(750)
    public void testConvKbn_A75() {

        String before = "99999";
        Class<?> clazz = C_HaitouKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "99999", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), false, "区分値変換結果");
    }

    @Test
    @TestOrder(760)
    public void testConvKbn_A76() {

        String before = "1";
        Class<?> clazz = C_HaitouKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "3", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(770)
    public void testConvKbn_A77() {

        String before = "2";
        Class<?> clazz = C_HaitouKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "2", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(780)
    public void testConvKbn_A78() {

        String before = "3";
        Class<?> clazz = C_HaitouKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "1", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(790)
    public void testConvKbn_A79() {

        String before = "99999";
        Class<?> clazz = C_HaitouKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "99999", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), false, "区分値変換結果");
    }

    @Test
    @TestOrder(800)
    public void testConvKbn_A80() {

        String before = "1";
        Class<?> clazz = C_Kyksei.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "1", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(810)
    public void testConvKbn_A81() {

        String before = "2";
        Class<?> clazz = C_Kyksei.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "2", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(820)
    public void testConvKbn_A82() {

        String before = "3";
        Class<?> clazz = C_Kyksei.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "3", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(830)
    public void testConvKbn_A83() {

        String before = "0";
        Class<?> clazz = C_Kyksei.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "0", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(840)
    public void testConvKbn_A84() {

        String before = "99999";
        Class<?> clazz = C_Kyksei.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "99999", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), false, "区分値変換結果");
    }

    @Test
    @TestOrder(850)
    public void testConvKbn_A85() {

        String before = "1";
        Class<?> clazz = C_Kyksei.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "1", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(860)
    public void testConvKbn_A86() {

        String before = "2";
        Class<?> clazz = C_Kyksei.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "2", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(870)
    public void testConvKbn_A87() {

        String before = "3";
        Class<?> clazz = C_Kyksei.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "3", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(880)
    public void testConvKbn_A88() {

        String before = "0";
        Class<?> clazz = C_Kyksei.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "0", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(890)
    public void testConvKbn_A89() {

        String before = "99999";
        Class<?> clazz = C_Kyksei.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "99999", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), false, "区分値変換結果");
    }

    @Test
    @TestOrder(900)
    public void testConvKbn_A90() {

        String before = "1";
        Class<?> clazz = C_UktKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "2", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(910)
    public void testConvKbn_A91() {

        String before = "2";
        Class<?> clazz = C_UktKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "1", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(920)
    public void testConvKbn_A92() {

        String before = "5";
        Class<?> clazz = C_UktKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "3", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(930)
    public void testConvKbn_A93() {

        String before = "6";
        Class<?> clazz = C_UktKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "5", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(940)
    public void testConvKbn_A94() {

        String before = "0";
        Class<?> clazz = C_UktKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "0", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(950)
    public void testConvKbn_A95() {

        String before = "99999";
        Class<?> clazz = C_UktKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "99999", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), false, "区分値変換結果");
    }

    @Test
    @TestOrder(960)
    public void testConvKbn_A96() {

        String before = "2";
        Class<?> clazz = C_UktKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "1", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(970)
    public void testConvKbn_A97() {

        String before = "1";
        Class<?> clazz = C_UktKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "2", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(980)
    public void testConvKbn_A98() {

        String before = "3";
        Class<?> clazz = C_UktKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "5", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(990)
    public void testConvKbn_A99() {

        String before = "5";
        Class<?> clazz = C_UktKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "6", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1000)
    public void testConvKbn_A100() {

        String before = "0";
        Class<?> clazz = C_UktKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "0", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1010)
    public void testConvKbn_A101() {

        String before = "99999";
        Class<?> clazz = C_UktKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "99999", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), false, "区分値変換結果");
    }

    @Test
    @TestOrder(1020)
    public void testConvKbn_A102() {

        String before = "0";
        Class<?> clazz = C_HonninkakuninSyoruiKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "00", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1030)
    public void testConvKbn_A103() {

        String before = "11";
        Class<?> clazz = C_HonninkakuninSyoruiKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "01", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1040)
    public void testConvKbn_A104() {

        String before = "12";
        Class<?> clazz = C_HonninkakuninSyoruiKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "02", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1050)
    public void testConvKbn_A105() {

        String before = "13";
        Class<?> clazz = C_HonninkakuninSyoruiKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "03", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1060)
    public void testConvKbn_A106() {

        String before = "14";
        Class<?> clazz = C_HonninkakuninSyoruiKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "04", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1070)
    public void testConvKbn_A107() {

        String before = "15";
        Class<?> clazz = C_HonninkakuninSyoruiKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "05", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1080)
    public void testConvKbn_A108() {

        String before = "16";
        Class<?> clazz = C_HonninkakuninSyoruiKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "06", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1090)
    public void testConvKbn_A109() {

        String before = "17";
        Class<?> clazz = C_HonninkakuninSyoruiKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "07", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1100)
    public void testConvKbn_A110() {

        String before = "18";
        Class<?> clazz = C_HonninkakuninSyoruiKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "08", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1110)
    public void testConvKbn_A111() {

        String before = "19";
        Class<?> clazz = C_HonninkakuninSyoruiKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "09", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1120)
    public void testConvKbn_A112() {

        String before = "20";
        Class<?> clazz = C_HonninkakuninSyoruiKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "10", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1130)
    public void testConvKbn_A113() {

        String before = "21";
        Class<?> clazz = C_HonninkakuninSyoruiKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "11", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1140)
    public void testConvKbn_A114() {

        String before = "22";
        Class<?> clazz = C_HonninkakuninSyoruiKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "12", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1150)
    public void testConvKbn_A115() {

        String before = "23";
        Class<?> clazz = C_HonninkakuninSyoruiKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "13", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1160)
    public void testConvKbn_A116() {

        String before = "24";
        Class<?> clazz = C_HonninkakuninSyoruiKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "14", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1170)
    public void testConvKbn_A117() {

        String before = "25";
        Class<?> clazz = C_HonninkakuninSyoruiKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "15", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1180)
    public void testConvKbn_A118() {

        String before = "26";
        Class<?> clazz = C_HonninkakuninSyoruiKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "16", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1190)
    public void testConvKbn_A119() {

        String before = "27";
        Class<?> clazz = C_HonninkakuninSyoruiKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "17", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1200)
    public void testConvKbn_A120() {

        String before = "28";
        Class<?> clazz = C_HonninkakuninSyoruiKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "18", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1210)
    public void testConvKbn_A121() {

        String before = "29";
        Class<?> clazz = C_HonninkakuninSyoruiKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "19", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1220)
    public void testConvKbn_A122() {

        String before = "30";
        Class<?> clazz = C_HonninkakuninSyoruiKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "20", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1230)
    public void testConvKbn_A123() {

        String before = "34";
        Class<?> clazz = C_HonninkakuninSyoruiKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "21", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1240)
    public void testConvKbn_A124() {

        String before = "33";
        Class<?> clazz = C_HonninkakuninSyoruiKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "23", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1250)
    public void testConvKbn_A125() {

        String before = "32";
        Class<?> clazz = C_HonninkakuninSyoruiKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "24", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1260)
    public void testConvKbn_A126() {

        String before = "90";
        Class<?> clazz = C_HonninkakuninSyoruiKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "90", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1270)
    public void testConvKbn_A127() {

        String before = "92";
        Class<?> clazz = C_HonninkakuninSyoruiKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "92", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1280)
    public void testConvKbn_A128() {

        String before = "99999";
        Class<?> clazz = C_HonninkakuninSyoruiKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "99999", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), false, "区分値変換結果");
    }

    @Test
    @TestOrder(1290)
    public void testConvKbn_A129() {

        String before = "00";
        Class<?> clazz = C_HonninkakuninSyoruiKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "0", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1300)
    public void testConvKbn_A130() {

        String before = "01";
        Class<?> clazz = C_HonninkakuninSyoruiKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "11", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1310)
    public void testConvKbn_A131() {

        String before = "02";
        Class<?> clazz = C_HonninkakuninSyoruiKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "12", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1320)
    public void testConvKbn_A132() {

        String before = "03";
        Class<?> clazz = C_HonninkakuninSyoruiKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "13", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1330)
    public void testConvKbn_A133() {

        String before = "04";
        Class<?> clazz = C_HonninkakuninSyoruiKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "14", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1340)
    public void testConvKbn_A134() {

        String before = "05";
        Class<?> clazz = C_HonninkakuninSyoruiKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "15", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1350)
    public void testConvKbn_A135() {

        String before = "06";
        Class<?> clazz = C_HonninkakuninSyoruiKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "16", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1360)
    public void testConvKbn_A136() {

        String before = "07";
        Class<?> clazz = C_HonninkakuninSyoruiKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "17", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1370)
    public void testConvKbn_A137() {

        String before = "08";
        Class<?> clazz = C_HonninkakuninSyoruiKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "18", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1380)
    public void testConvKbn_A138() {

        String before = "09";
        Class<?> clazz = C_HonninkakuninSyoruiKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "19", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1390)
    public void testConvKbn_A139() {

        String before = "10";
        Class<?> clazz = C_HonninkakuninSyoruiKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "20", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1400)
    public void testConvKbn_A140() {

        String before = "11";
        Class<?> clazz = C_HonninkakuninSyoruiKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "21", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1410)
    public void testConvKbn_A141() {

        String before = "12";
        Class<?> clazz = C_HonninkakuninSyoruiKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "22", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1420)
    public void testConvKbn_A142() {

        String before = "13";
        Class<?> clazz = C_HonninkakuninSyoruiKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "23", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1430)
    public void testConvKbn_A143() {

        String before = "14";
        Class<?> clazz = C_HonninkakuninSyoruiKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "24", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1440)
    public void testConvKbn_A144() {

        String before = "15";
        Class<?> clazz = C_HonninkakuninSyoruiKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "25", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1450)
    public void testConvKbn_A145() {

        String before = "16";
        Class<?> clazz = C_HonninkakuninSyoruiKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "26", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1460)
    public void testConvKbn_A146() {

        String before = "17";
        Class<?> clazz = C_HonninkakuninSyoruiKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "27", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1470)
    public void testConvKbn_A147() {

        String before = "18";
        Class<?> clazz = C_HonninkakuninSyoruiKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "28", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1480)
    public void testConvKbn_A148() {

        String before = "19";
        Class<?> clazz = C_HonninkakuninSyoruiKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "29", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1490)
    public void testConvKbn_A149() {

        String before = "20";
        Class<?> clazz = C_HonninkakuninSyoruiKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "30", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1500)
    public void testConvKbn_A150() {

        String before = "21";
        Class<?> clazz = C_HonninkakuninSyoruiKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "34", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1510)
    public void testConvKbn_A151() {

        String before = "23";
        Class<?> clazz = C_HonninkakuninSyoruiKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "33", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1520)
    public void testConvKbn_A152() {

        String before = "24";
        Class<?> clazz = C_HonninkakuninSyoruiKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "32", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1530)
    public void testConvKbn_A153() {

        String before = "90";
        Class<?> clazz = C_HonninkakuninSyoruiKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "90", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1540)
    public void testConvKbn_A154() {

        String before = "92";
        Class<?> clazz = C_HonninkakuninSyoruiKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "92", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1550)
    public void testConvKbn_A155() {

        String before = "99999";
        Class<?> clazz = C_HonninkakuninSyoruiKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "99999", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), false, "区分値変換結果");
    }

    @Test
    @TestOrder(1560)
    public void testConvKbn_A156() {

        String before = "1";
        Class<?> clazz = C_YokinKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "1", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1570)
    public void testConvKbn_A157() {

        String before = "2";
        Class<?> clazz = C_YokinKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "2", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1580)
    public void testConvKbn_A158() {

        String before = "4";
        Class<?> clazz = C_YokinKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "4", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1590)
    public void testConvKbn_A159() {

        String before = "9";
        Class<?> clazz = C_YokinKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "9", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1600)
    public void testConvKbn_A160() {

        String before = "99999";
        Class<?> clazz = C_YokinKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "99999", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), false, "区分値変換結果");
    }

    @Test
    @TestOrder(1610)
    public void testConvKbn_A161() {

        String before = "1";
        Class<?> clazz = C_YokinKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "1", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1620)
    public void testConvKbn_A162() {

        String before = "2";
        Class<?> clazz = C_YokinKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "2", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1630)
    public void testConvKbn_A163() {

        String before = "4";
        Class<?> clazz = C_YokinKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "4", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1640)
    public void testConvKbn_A164() {

        String before = "9";
        Class<?> clazz = C_YokinKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "9", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1650)
    public void testConvKbn_A165() {

        String before = "99999";
        Class<?> clazz = C_YokinKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "99999", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), false, "区分値変換結果");
    }

    @Test
    @TestOrder(1660)
    public void testConvKbn_A166() {

        String before = "1";
        Class<?> clazz = C_Hrkkeiro.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "1", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1670)
    public void testConvKbn_A167() {

        String before = "2";
        Class<?> clazz = C_Hrkkeiro.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "2", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1680)
    public void testConvKbn_A168() {

        String before = "4";
        Class<?> clazz = C_Hrkkeiro.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "4", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1690)
    public void testConvKbn_A169() {

        String before = "0";
        Class<?> clazz = C_Hrkkeiro.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1700)
    public void testConvKbn_A170() {

        String before = "6";
        Class<?> clazz = C_Hrkkeiro.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "6", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1710)
    public void testConvKbn_A171() {

        String before = "99999";
        Class<?> clazz = C_Hrkkeiro.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "99999", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), false, "区分値変換結果");
    }

    @Test
    @TestOrder(1720)
    public void testConvKbn_A172() {

        String before = "1";
        Class<?> clazz = C_Hrkkeiro.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "1", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1730)
    public void testConvKbn_A173() {

        String before = "2";
        Class<?> clazz = C_Hrkkeiro.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "2", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1740)
    public void testConvKbn_A174() {

        String before = "4";
        Class<?> clazz = C_Hrkkeiro.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "4", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1750)
    public void testConvKbn_A175() {

        String before = "";
        Class<?> clazz = C_Hrkkeiro.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "0", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1760)
    public void testConvKbn_A176() {

        String before = "6";
        Class<?> clazz = C_Hrkkeiro.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "6", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1770)
    public void testConvKbn_A177() {

        String before = "99999";
        Class<?> clazz = C_Hrkkeiro.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "99999", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), false, "区分値変換結果");
    }

    @Test
    @TestOrder(1780)
    public void testConvKbn_A178() {

        String before = "0";
        Class<?> clazz = C_Kykkaksyrui.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "00", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1790)
    public void testConvKbn_A179() {

        String before = "1";
        Class<?> clazz = C_Kykkaksyrui.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "01", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1800)
    public void testConvKbn_A180() {

        String before = "2";
        Class<?> clazz = C_Kykkaksyrui.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "12", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1810)
    public void testConvKbn_A181() {

        String before = "3";
        Class<?> clazz = C_Kykkaksyrui.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "21", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1820)
    public void testConvKbn_A182() {

        String before = "99999";
        Class<?> clazz = C_Kykkaksyrui.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "99999", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), false, "区分値変換結果");
    }

    @Test
    @TestOrder(1830)
    public void testConvKbn_A183() {

        String before = "00";
        Class<?> clazz = C_Kykkaksyrui.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "0", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1840)
    public void testConvKbn_A184() {

        String before = "01";
        Class<?> clazz = C_Kykkaksyrui.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "1", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1850)
    public void testConvKbn_A185() {

        String before = "12";
        Class<?> clazz = C_Kykkaksyrui.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "2", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1860)
    public void testConvKbn_A186() {

        String before = "21";
        Class<?> clazz = C_Kykkaksyrui.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "3", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1870)
    public void testConvKbn_A187() {

        String before = "99999";
        Class<?> clazz = C_Kykkaksyrui.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "99999", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), false, "区分値変換結果");
    }

    @Test
    @TestOrder(1880)
    public void testConvKbn_A188() {

        String before = "0";
        Class<?> clazz = C_FatcakakkekkaKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "0", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1890)
    public void testConvKbn_A189() {

        String before = "1";
        Class<?> clazz = C_FatcakakkekkaKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "1", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1900)
    public void testConvKbn_A190() {

        String before = "2";
        Class<?> clazz = C_FatcakakkekkaKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "8", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1910)
    public void testConvKbn_A191() {

        String before = "3";
        Class<?> clazz = C_FatcakakkekkaKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "9", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1920)
    public void testConvKbn_A192() {

        String before = "99999";
        Class<?> clazz = C_FatcakakkekkaKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "99999", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), false, "区分値変換結果");
    }

    @Test
    @TestOrder(1930)
    public void testConvKbn_A193() {

        String before = "0";
        Class<?> clazz = C_FatcakakkekkaKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "0", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1940)
    public void testConvKbn_A194() {

        String before = "1";
        Class<?> clazz = C_FatcakakkekkaKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "1", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1950)
    public void testConvKbn_A195() {

        String before = "8";
        Class<?> clazz = C_FatcakakkekkaKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "2", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1960)
    public void testConvKbn_A196() {

        String before = "9";
        Class<?> clazz = C_FatcakakkekkaKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "3", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1970)
    public void testConvKbn_A197() {

        String before = "99999";
        Class<?> clazz = C_FatcakakkekkaKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "99999", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), false, "区分値変換結果");
    }

    @Test
    @TestOrder(1980)
    public void testConvKbn_A198() {

        String before = "0";
        Class<?> clazz = C_Tuukasyu.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "0", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(1990)
    public void testConvKbn_A199() {

        String before = "JPY";
        Class<?> clazz = C_Tuukasyu.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "1", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2000)
    public void testConvKbn_A200() {

        String before = "USD";
        Class<?> clazz = C_Tuukasyu.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "2", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2010)
    public void testConvKbn_A201() {

        String before = "EUR";
        Class<?> clazz = C_Tuukasyu.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "3", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2020)
    public void testConvKbn_A202() {

        String before = "AUD";
        Class<?> clazz = C_Tuukasyu.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "4", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2030)
    public void testConvKbn_A203() {

        String before = "99999";
        Class<?> clazz = C_Tuukasyu.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "99999", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), false, "区分値変換結果");
    }

    @Test
    @TestOrder(2040)
    public void testConvKbn_A204() {

        String before = "0";
        Class<?> clazz = C_Tuukasyu.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "0", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2050)
    public void testConvKbn_A205() {

        String before = "1";
        Class<?> clazz = C_Tuukasyu.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "JPY", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2060)
    public void testConvKbn_A206() {

        String before = "2";
        Class<?> clazz = C_Tuukasyu.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "USD", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2070)
    public void testConvKbn_A207() {

        String before = "3";
        Class<?> clazz = C_Tuukasyu.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "EUR", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2080)
    public void testConvKbn_A208() {

        String before = "4";
        Class<?> clazz = C_Tuukasyu.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "AUD", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2090)
    public void testConvKbn_A209() {

        String before = "99999";
        Class<?> clazz = C_Tuukasyu.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "99999", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), false, "区分値変換結果");
    }

    @Test
    @TestOrder(2100)
    public void testConvKbn_A210() {

        String before = "0";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "00", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2110)
    public void testConvKbn_A211() {

        String before = "1";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "01", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2120)
    public void testConvKbn_A212() {

        String before = "2";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "02", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2130)
    public void testConvKbn_A213() {

        String before = "3";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "03", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2140)
    public void testConvKbn_A214() {

        String before = "4";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "04", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2150)
    public void testConvKbn_A215() {

        String before = "5";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "05", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2160)
    public void testConvKbn_A216() {

        String before = "6";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "06", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2170)
    public void testConvKbn_A217() {

        String before = "7";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "07", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2180)
    public void testConvKbn_A218() {

        String before = "8";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "08", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2190)
    public void testConvKbn_A219() {

        String before = "9";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "09", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2200)
    public void testConvKbn_A220() {

        String before = "10";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "10", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2210)
    public void testConvKbn_A221() {

        String before = "11";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "11", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2220)
    public void testConvKbn_A222() {

        String before = "12";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "12", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2230)
    public void testConvKbn_A223() {

        String before = "13";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "13", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2240)
    public void testConvKbn_A224() {

        String before = "14";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "14", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2250)
    public void testConvKbn_A225() {

        String before = "15";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "15", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2260)
    public void testConvKbn_A226() {

        String before = "16";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "16", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2270)
    public void testConvKbn_A227() {

        String before = "17";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "17", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2280)
    public void testConvKbn_A228() {

        String before = "18";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "18", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2290)
    public void testConvKbn_A229() {

        String before = "19";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "19", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2300)
    public void testConvKbn_A230() {

        String before = "20";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "20", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2310)
    public void testConvKbn_A231() {

        String before = "21";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "21", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2320)
    public void testConvKbn_A232() {

        String before = "22";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "22", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2330)
    public void testConvKbn_A233() {

        String before = "23";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "23", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2340)
    public void testConvKbn_A234() {

        String before = "24";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "24", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2350)
    public void testConvKbn_A235() {

        String before = "25";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "25", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2360)
    public void testConvKbn_A236() {

        String before = "26";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "26", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2370)
    public void testConvKbn_A237() {

        String before = "27";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "27", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2380)
    public void testConvKbn_A238() {

        String before = "28";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "28", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2390)
    public void testConvKbn_A239() {

        String before = "29";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "29", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2400)
    public void testConvKbn_A240() {

        String before = "30";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "30", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2410)
    public void testConvKbn_A241() {

        String before = "31";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "31", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2420)
    public void testConvKbn_A242() {

        String before = "32";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "32", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2430)
    public void testConvKbn_A243() {

        String before = "33";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "33", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2440)
    public void testConvKbn_A244() {

        String before = "34";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "34", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2450)
    public void testConvKbn_A245() {

        String before = "35";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "35", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2460)
    public void testConvKbn_A246() {

        String before = "36";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "36", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2470)
    public void testConvKbn_A247() {

        String before = "37";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "37", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2480)
    public void testConvKbn_A248() {

        String before = "38";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "38", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2490)
    public void testConvKbn_A249() {

        String before = "39";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "39", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2500)
    public void testConvKbn_A250() {

        String before = "40";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "40", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2510)
    public void testConvKbn_A251() {

        String before = "41";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "41", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2520)
    public void testConvKbn_A252() {

        String before = "42";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "42", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2530)
    public void testConvKbn_A253() {

        String before = "43";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "43", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2540)
    public void testConvKbn_A254() {

        String before = "44";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "44", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2550)
    public void testConvKbn_A255() {

        String before = "45";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "45", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2560)
    public void testConvKbn_A256() {

        String before = "46";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "46", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2570)
    public void testConvKbn_A257() {

        String before = "47";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "47", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2580)
    public void testConvKbn_A258() {

        String before = "99999";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "99999", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), false, "区分値変換結果");
    }

    @Test
    @TestOrder(2590)
    public void testConvKbn_A259() {

        String before = "00";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "0", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2600)
    public void testConvKbn_A260() {

        String before = "01";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "1", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2610)
    public void testConvKbn_A261() {

        String before = "02";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "2", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2620)
    public void testConvKbn_A262() {

        String before = "03";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "3", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2630)
    public void testConvKbn_A263() {

        String before = "04";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "4", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2640)
    public void testConvKbn_A264() {

        String before = "05";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "5", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2650)
    public void testConvKbn_A265() {

        String before = "06";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "6", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2660)
    public void testConvKbn_A266() {

        String before = "07";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "7", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2670)
    public void testConvKbn_A267() {

        String before = "08";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "8", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2680)
    public void testConvKbn_A268() {

        String before = "09";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "9", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2690)
    public void testConvKbn_A269() {

        String before = "10";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "10", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2700)
    public void testConvKbn_A270() {

        String before = "11";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "11", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2710)
    public void testConvKbn_A271() {

        String before = "12";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "12", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2720)
    public void testConvKbn_A272() {

        String before = "13";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "13", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2730)
    public void testConvKbn_A273() {

        String before = "14";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "14", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2740)
    public void testConvKbn_A274() {

        String before = "15";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "15", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2750)
    public void testConvKbn_A275() {

        String before = "16";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "16", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2760)
    public void testConvKbn_A276() {

        String before = "17";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "17", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2770)
    public void testConvKbn_A277() {

        String before = "18";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "18", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2780)
    public void testConvKbn_A278() {

        String before = "19";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "19", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2790)
    public void testConvKbn_A279() {

        String before = "20";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "20", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2800)
    public void testConvKbn_A280() {

        String before = "21";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "21", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2810)
    public void testConvKbn_A281() {

        String before = "22";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "22", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2820)
    public void testConvKbn_A282() {

        String before = "23";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "23", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2830)
    public void testConvKbn_A283() {

        String before = "24";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "24", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2840)
    public void testConvKbn_A284() {

        String before = "25";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "25", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2850)
    public void testConvKbn_A285() {

        String before = "26";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "26", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2860)
    public void testConvKbn_A286() {

        String before = "27";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "27", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2870)
    public void testConvKbn_A287() {

        String before = "28";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "28", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2880)
    public void testConvKbn_A288() {

        String before = "29";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "29", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2890)
    public void testConvKbn_A289() {

        String before = "30";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "30", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2900)
    public void testConvKbn_A290() {

        String before = "31";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "31", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2910)
    public void testConvKbn_A291() {

        String before = "32";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "32", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2920)
    public void testConvKbn_A292() {

        String before = "33";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "33", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2930)
    public void testConvKbn_A293() {

        String before = "34";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "34", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2940)
    public void testConvKbn_A294() {

        String before = "35";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "35", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2950)
    public void testConvKbn_A295() {

        String before = "36";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "36", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2960)
    public void testConvKbn_A296() {

        String before = "37";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "37", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2970)
    public void testConvKbn_A297() {

        String before = "38";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "38", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2980)
    public void testConvKbn_A298() {

        String before = "39";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "39", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(2990)
    public void testConvKbn_A299() {

        String before = "40";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "40", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(3000)
    public void testConvKbn_A300() {

        String before = "41";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "41", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(3010)
    public void testConvKbn_A301() {

        String before = "42";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "42", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(3020)
    public void testConvKbn_A302() {

        String before = "43";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "43", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(3030)
    public void testConvKbn_A303() {

        String before = "44";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "44", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(3040)
    public void testConvKbn_A304() {

        String before = "45";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "45", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(3050)
    public void testConvKbn_A305() {

        String before = "46";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "46", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(3060)
    public void testConvKbn_A306() {

        String before = "47";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "47", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(3070)
    public void testConvKbn_A307() {

        String before = "99999";
        Class<?> clazz = C_TodouhukenKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "99999", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), false, "区分値変換結果");
    }

    @Test
    @TestOrder(3080)
    public void testConvKbn_A308() {

        String before = "9";
        Class<?> clazz = C_Kykjyoutai.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "01", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(3090)
    public void testConvKbn_A309() {

        String before = "1";
        Class<?> clazz = C_Kykjyoutai.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "00", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(3100)
    public void testConvKbn_A310() {

        String before = "6";
        Class<?> clazz = C_Kykjyoutai.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "07", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(3110)
    public void testConvKbn_A311() {

        String before = "7";
        Class<?> clazz = C_Kykjyoutai.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "09", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(3120)
    public void testConvKbn_A312() {

        String before = "99999";
        Class<?> clazz = C_Kykjyoutai.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "99999", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), false, "区分値変換結果");
    }

    @Test
    @TestOrder(3130)
    public void testConvKbn_A313() {

        String before = "01";
        Class<?> clazz = C_Kykjyoutai.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "9", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(3140)
    public void testConvKbn_A314() {

        String before = "00";
        Class<?> clazz = C_Kykjyoutai.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "1", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(3150)
    public void testConvKbn_A315() {

        String before = "07";
        Class<?> clazz = C_Kykjyoutai.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "6", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(3160)
    public void testConvKbn_A316() {

        String before = "09";
        Class<?> clazz = C_Kykjyoutai.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "7", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(3170)
    public void testConvKbn_A317() {

        String before = "99999";
        Class<?> clazz = C_Kykjyoutai.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "99999", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), false, "区分値変換結果");
    }

    @Test
    @TestOrder(3180)
    public void testConvKbn_A318() {

        String before = "1";
        Class<?> clazz = C_Sisuukbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "1", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(3190)
    public void testConvKbn_A319() {

        String before = "2";
        Class<?> clazz = C_Sisuukbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "2", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(3200)
    public void testConvKbn_A320() {

        String before = "99999";
        Class<?> clazz = C_Sisuukbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "99999", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), false, "区分値変換結果");
    }

    @Test
    @TestOrder(3210)
    public void testConvKbn_A321() {

        String before = "1";
        Class<?> clazz = C_Sisuukbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "1", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(3220)
    public void testConvKbn_A322() {

        String before = "2";
        Class<?> clazz = C_Sisuukbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "2", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(3230)
    public void testConvKbn_A323() {

        String before = "99999";
        Class<?> clazz = C_Sisuukbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "99999", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), false, "区分値変換結果");
    }

    @Test
    @TestOrder(3240)
    public void testConvKbn_A324() {

        String before = "1";
        Class<?> clazz = C_NyknaiyouKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "01", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(3250)
    public void testConvKbn_A325() {

        String before = "10";
        Class<?> clazz = C_NyknaiyouKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "21", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(3260)
    public void testConvKbn_A326() {

        String before = "11";
        Class<?> clazz = C_NyknaiyouKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "22", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(3270)
    public void testConvKbn_A327() {

        String before = "99999";
        Class<?> clazz = C_NyknaiyouKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "99999", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), false, "区分値変換結果");
    }

    @Test
    @TestOrder(3280)
    public void testConvKbn_A328() {

        String before = "01";
        Class<?> clazz = C_NyknaiyouKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "1", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(3290)
    public void testConvKbn_A329() {

        String before = "21";
        Class<?> clazz = C_NyknaiyouKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "10", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(3300)
    public void testConvKbn_A330() {

        String before = "22";
        Class<?> clazz = C_NyknaiyouKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "11", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(3310)
    public void testConvKbn_A331() {

        String before = "99999";
        Class<?> clazz = C_NyknaiyouKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "99999", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), false, "区分値変換結果");
    }

    @Test
    @TestOrder(3320)
    public void testConvKbn_A332() {

        String before = "2";
        Class<?> clazz = C_Yuukoukakkekka.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "1", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(3330)
    public void testConvKbn_A333() {

        String before = "3";
        Class<?> clazz = C_Yuukoukakkekka.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "2", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(3340)
    public void testConvKbn_A334() {

        String before = "4";
        Class<?> clazz = C_Yuukoukakkekka.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "3", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(3350)
    public void testConvKbn_A335() {

        String before = "99999";
        Class<?> clazz = C_Yuukoukakkekka.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "99999", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), false, "区分値変換結果");
    }

    @Test
    @TestOrder(3360)
    public void testConvKbn_A336() {

        String before = "1";
        Class<?> clazz = C_Yuukoukakkekka.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "2", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(3370)
    public void testConvKbn_A337() {

        String before = "2";
        Class<?> clazz = C_Yuukoukakkekka.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "3", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(3380)
    public void testConvKbn_A338() {

        String before = "3";
        Class<?> clazz = C_Yuukoukakkekka.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "4", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(3390)
    public void testConvKbn_A339() {

        String before = "99999";
        Class<?> clazz = C_Yuukoukakkekka.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "99999", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), false, "区分値変換結果");
    }

    @Test
    @TestOrder(3400)
    public void testConvKbn_A340() {

        String before = "99";
        Class<?> clazz = C_CreditUriageNgJiyuuKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "0", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(3410)
    public void testConvKbn_A341() {

        String before = "1";
        Class<?> clazz = C_CreditUriageNgJiyuuKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "1", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(3420)
    public void testConvKbn_A342() {

        String before = "2";
        Class<?> clazz = C_CreditUriageNgJiyuuKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "2", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(3430)
    public void testConvKbn_A343() {

        String before = "5";
        Class<?> clazz = C_CreditUriageNgJiyuuKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "5", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(3440)
    public void testConvKbn_A344() {

        String before = "8";
        Class<?> clazz = C_CreditUriageNgJiyuuKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "8", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(3450)
    public void testConvKbn_A345() {

        String before = "9";
        Class<?> clazz = C_CreditUriageNgJiyuuKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "9", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(3460)
    public void testConvKbn_A346() {

        String before = "99999";
        Class<?> clazz = C_CreditUriageNgJiyuuKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "99999", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), false, "区分値変換結果");
    }

    @Test
    @TestOrder(3470)
    public void testConvKbn_A347() {

        String before = "0";
        Class<?> clazz = C_CreditUriageNgJiyuuKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "99", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(3480)
    public void testConvKbn_A348() {

        String before = "1";
        Class<?> clazz = C_CreditUriageNgJiyuuKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "1", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(3490)
    public void testConvKbn_A349() {

        String before = "2";
        Class<?> clazz = C_CreditUriageNgJiyuuKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "2", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(3500)
    public void testConvKbn_A350() {

        String before = "5";
        Class<?> clazz = C_CreditUriageNgJiyuuKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "5", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(3510)
    public void testConvKbn_A351() {

        String before = "8";
        Class<?> clazz = C_CreditUriageNgJiyuuKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "8", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(3520)
    public void testConvKbn_A352() {

        String before = "9";
        Class<?> clazz = C_CreditUriageNgJiyuuKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "9", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(3530)
    public void testConvKbn_A353() {

        String before = "99999";
        Class<?> clazz = C_CreditUriageNgJiyuuKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "99999", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), false, "区分値変換結果");
    }

    @Test
    @TestOrder(3540)
    public void testConvKbn_A354() {

        String before = "3";
        Class<?> clazz = C_AuthoriKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "0", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(3550)
    public void testConvKbn_A355() {

        String before = "1";
        Class<?> clazz = C_AuthoriKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "1", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(3560)
    public void testConvKbn_A356() {

        String before = "2";
        Class<?> clazz = C_AuthoriKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "2", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(3570)
    public void testConvKbn_A357() {

        String before = "99999";
        Class<?> clazz = C_AuthoriKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "99999", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), false, "区分値変換結果");
    }

    @Test
    @TestOrder(3580)
    public void testConvKbn_A358() {

        String before = "0";
        Class<?> clazz = C_AuthoriKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "3", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(3590)
    public void testConvKbn_A359() {

        String before = "1";
        Class<?> clazz = C_AuthoriKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "1", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(3600)
    public void testConvKbn_A360() {

        String before = "2";
        Class<?> clazz = C_AuthoriKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "2", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(3610)
    public void testConvKbn_A361() {

        String before = "99999";
        Class<?> clazz = C_AuthoriKbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "99999", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), false, "区分値変換結果");
    }
}
