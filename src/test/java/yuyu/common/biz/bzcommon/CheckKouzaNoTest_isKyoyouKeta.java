package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 口座番号チェッククラスのメソッド {@link CheckKouzaNo#isKyoyouKeta(String, C_Tuukasyu)}テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckKouzaNoTest_isKyoyouKeta {

    @Inject
    private CheckKouzaNo checkKouzaNo;
    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

    }

    @Test
    @TestOrder(230)
    public void testIsKyoyouKeta_A23() {

        boolean result = checkKouzaNo.isKyoyouKeta(null, C_Tuukasyu.JPY);

        exBooleanEquals(result, true, "チェック結果");
    }

    @Test
    @TestOrder(240)
    public void testIsKyoyouKeta_A24() {

        boolean result = checkKouzaNo.isKyoyouKeta("", C_Tuukasyu.JPY);

        exBooleanEquals(result, true, "チェック結果");
    }

    @Test
    @TestOrder(250)
    public void testIsKyoyouKeta_A25() {
        YuyuBizConfig.getInstance().setYenkaKouzaKetasuu(0);
        boolean result = checkKouzaNo.isKyoyouKeta("1", C_Tuukasyu.JPY);

        exBooleanEquals(result, false, "チェック結果");
    }

    @Test
    @TestOrder(260)
    public void testIsKyoyouKeta_A26() {
        YuyuBizConfig.getInstance().setYenkaKouzaKetasuu(1);
        boolean result = checkKouzaNo.isKyoyouKeta("1", C_Tuukasyu.JPY);

        exBooleanEquals(result, true, "チェック結果");
    }

    @Test
    @TestOrder(270)
    public void testIsKyoyouKeta_A27() {
        YuyuBizConfig.getInstance().setYenkaKouzaKetasuu(1);
        boolean result = checkKouzaNo.isKyoyouKeta("12", C_Tuukasyu.JPY);

        exBooleanEquals(result, false, "チェック結果");
    }

    @Test
    @TestOrder(280)
    public void testIsKyoyouKeta_A28() {
        YuyuBizConfig.getInstance().setYenkaKouzaKetasuu(7);
        boolean result = checkKouzaNo.isKyoyouKeta("123456", C_Tuukasyu.JPY);

        exBooleanEquals(result, true, "チェック結果");
    }

    @Test
    @TestOrder(290)
    public void testIsKyoyouKeta_A29() {
        YuyuBizConfig.getInstance().setYenkaKouzaKetasuu(7);
        boolean result = checkKouzaNo.isKyoyouKeta("1234567", C_Tuukasyu.JPY);

        exBooleanEquals(result, true, "チェック結果");
    }

    @Test
    @TestOrder(300)
    public void testIsKyoyouKeta_A30() {
        YuyuBizConfig.getInstance().setYenkaKouzaKetasuu(7);
        boolean result = checkKouzaNo.isKyoyouKeta("12345678", C_Tuukasyu.JPY);

        exBooleanEquals(result, false, "チェック結果");
    }

    @Test
    @TestOrder(310)
    public void testIsKyoyouKeta_A31() {
        YuyuBizConfig.getInstance().setGaikaKouzaKetasuu(0);
        boolean result = checkKouzaNo.isKyoyouKeta("1", C_Tuukasyu.USD);

        exBooleanEquals(result, false, "チェック結果");
    }

    @Test
    @TestOrder(320)
    public void testIsKyoyouKeta_A32() {
        YuyuBizConfig.getInstance().setGaikaKouzaKetasuu(1);
        boolean result = checkKouzaNo.isKyoyouKeta("1", C_Tuukasyu.USD);

        exBooleanEquals(result, true, "チェック結果");
    }

    @Test
    @TestOrder(330)
    public void testIsKyoyouKeta_A33() {
        YuyuBizConfig.getInstance().setGaikaKouzaKetasuu(1);
        boolean result = checkKouzaNo.isKyoyouKeta("12", C_Tuukasyu.USD);

        exBooleanEquals(result, false, "チェック結果");
    }

    @Test
    @TestOrder(340)
    public void testIsKyoyouKeta_A34() {
        YuyuBizConfig.getInstance().setGaikaKouzaKetasuu(12);
        boolean result = checkKouzaNo.isKyoyouKeta("12345678901", C_Tuukasyu.USD);

        exBooleanEquals(result, true, "チェック結果");
    }

    @Test
    @TestOrder(350)
    public void testIsKyoyouKeta_A35() {
        YuyuBizConfig.getInstance().setGaikaKouzaKetasuu(12);
        boolean result = checkKouzaNo.isKyoyouKeta("123456789012", C_Tuukasyu.USD);

        exBooleanEquals(result, true, "チェック結果");
    }

    @Test
    @TestOrder(360)
    public void testIsKyoyouKeta_A36() {
        YuyuBizConfig.getInstance().setGaikaKouzaKetasuu(12);
        boolean result = checkKouzaNo.isKyoyouKeta("1234567890123", C_Tuukasyu.USD);

        exBooleanEquals(result, false, "チェック結果");
    }

    @Test
    @TestOrder(370)
    public void testIsKyoyouKeta_A37() {
        YuyuBizConfig.getInstance().setGaikaKouzaKetasuu(0);
        boolean result = checkKouzaNo.isKyoyouKeta("1", C_Tuukasyu.EUR);

        exBooleanEquals(result, false, "チェック結果");
    }

    @Test
    @TestOrder(380)
    public void testIsKyoyouKeta_A38() {
        YuyuBizConfig.getInstance().setGaikaKouzaKetasuu(1);
        boolean result = checkKouzaNo.isKyoyouKeta("1", C_Tuukasyu.EUR);

        exBooleanEquals(result, true, "チェック結果");
    }

    @Test
    @TestOrder(390)
    public void testIsKyoyouKeta_A39() {
        YuyuBizConfig.getInstance().setGaikaKouzaKetasuu(1);
        boolean result = checkKouzaNo.isKyoyouKeta("12", C_Tuukasyu.EUR);

        exBooleanEquals(result, false, "チェック結果");
    }

    @Test
    @TestOrder(400)
    public void testIsKyoyouKeta_A40() {
        YuyuBizConfig.getInstance().setGaikaKouzaKetasuu(12);
        boolean result = checkKouzaNo.isKyoyouKeta("12345678901", C_Tuukasyu.EUR);

        exBooleanEquals(result, true, "チェック結果");
    }

    @Test
    @TestOrder(410)
    public void testIsKyoyouKeta_A41() {
        YuyuBizConfig.getInstance().setGaikaKouzaKetasuu(12);
        boolean result = checkKouzaNo.isKyoyouKeta("123456789012", C_Tuukasyu.EUR);

        exBooleanEquals(result, true, "チェック結果");
    }

    @Test
    @TestOrder(420)
    public void testIsKyoyouKeta_A42() {
        YuyuBizConfig.getInstance().setGaikaKouzaKetasuu(12);
        boolean result = checkKouzaNo.isKyoyouKeta("1234567890123", C_Tuukasyu.EUR);

        exBooleanEquals(result, false, "チェック結果");
    }

    @Test
    @TestOrder(430)
    public void testIsKyoyouKeta_A43() {
        YuyuBizConfig.getInstance().setGaikaKouzaKetasuu(0);
        boolean result = checkKouzaNo.isKyoyouKeta("1", C_Tuukasyu.AUD);

        exBooleanEquals(result, false, "チェック結果");
    }

    @Test
    @TestOrder(440)
    public void testIsKyoyouKeta_A44() {
        YuyuBizConfig.getInstance().setGaikaKouzaKetasuu(1);
        boolean result = checkKouzaNo.isKyoyouKeta("1", C_Tuukasyu.AUD);

        exBooleanEquals(result, true, "チェック結果");
    }

    @Test
    @TestOrder(450)
    public void testIsKyoyouKeta_A45() {
        YuyuBizConfig.getInstance().setGaikaKouzaKetasuu(1);
        boolean result = checkKouzaNo.isKyoyouKeta("12", C_Tuukasyu.AUD);

        exBooleanEquals(result, false, "チェック結果");
    }

    @Test
    @TestOrder(460)
    public void testIsKyoyouKeta_A46() {
        YuyuBizConfig.getInstance().setGaikaKouzaKetasuu(12);
        boolean result = checkKouzaNo.isKyoyouKeta("12345678901", C_Tuukasyu.AUD);

        exBooleanEquals(result, true, "チェック結果");
    }

    @Test
    @TestOrder(470)
    public void testIsKyoyouKeta_A47() {
        YuyuBizConfig.getInstance().setGaikaKouzaKetasuu(12);
        boolean result = checkKouzaNo.isKyoyouKeta("123456789012", C_Tuukasyu.AUD);

        exBooleanEquals(result, true, "チェック結果");
    }

    @Test
    @TestOrder(480)
    public void testIsKyoyouKeta_A48() {
        YuyuBizConfig.getInstance().setGaikaKouzaKetasuu(12);
        boolean result = checkKouzaNo.isKyoyouKeta("1234567890123", C_Tuukasyu.AUD);

        exBooleanEquals(result, false, "チェック結果");
    }

    @Test
    @TestOrder(490)
    public void testIsKyoyouKeta_A49() {
        YuyuBizConfig.getInstance().setGaikaKouzaKetasuu(0);
        boolean result = checkKouzaNo.isKyoyouKeta("1", C_Tuukasyu.BLNK);

        exBooleanEquals(result, false, "チェック結果");
    }

    @Test
    @TestOrder(500)
    public void testIsKyoyouKeta_A50() {
        YuyuBizConfig.getInstance().setGaikaKouzaKetasuu(1);
        boolean result = checkKouzaNo.isKyoyouKeta("1", C_Tuukasyu.BLNK);

        exBooleanEquals(result, true, "チェック結果");
    }

    @Test
    @TestOrder(510)
    public void testIsKyoyouKeta_A51() {
        YuyuBizConfig.getInstance().setGaikaKouzaKetasuu(1);
        boolean result = checkKouzaNo.isKyoyouKeta("12", C_Tuukasyu.BLNK);

        exBooleanEquals(result, false, "チェック結果");
    }

    @Test
    @TestOrder(520)
    public void testIsKyoyouKeta_A52() {
        YuyuBizConfig.getInstance().setGaikaKouzaKetasuu(12);
        boolean result = checkKouzaNo.isKyoyouKeta("12345678901", C_Tuukasyu.BLNK);

        exBooleanEquals(result, true, "チェック結果");
    }

    @Test
    @TestOrder(530)
    public void testIsKyoyouKeta_A53() {
        YuyuBizConfig.getInstance().setGaikaKouzaKetasuu(12);
        boolean result = checkKouzaNo.isKyoyouKeta("123456789012", C_Tuukasyu.BLNK);

        exBooleanEquals(result, true, "チェック結果");
    }

    @Test
    @TestOrder(540)
    public void testIsKyoyouKeta_A54() {
        YuyuBizConfig.getInstance().setGaikaKouzaKetasuu(12);
        boolean result = checkKouzaNo.isKyoyouKeta("1234567890123", C_Tuukasyu.BLNK);

        exBooleanEquals(result, false, "チェック結果");
    }


}
