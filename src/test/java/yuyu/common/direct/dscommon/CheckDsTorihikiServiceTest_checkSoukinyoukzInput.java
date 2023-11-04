package yuyu.common.direct.dscommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_ChkkekkaKbn;
import yuyu.def.classification.C_Kzdou;
import yuyu.def.classification.C_SoukinyoukzinputchkkekkaKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_YokinKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＤＳ取引サービス共通チェッククラスのメソッド {@link CheckDsTorihikiService#checkSoukinyoukzInput(C_Tuukasyu, String, C_YokinKbn, String, String, C_Kzdou, String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckDsTorihikiServiceTest_checkSoukinyoukzInput {

    @Inject
    private CheckDsTorihikiService checkDsTorihikiService;

    @Test
    @TestOrder(1010)
    public void testCheckSoukinyoukzInput_A1() {
        CheckSoukinyoukzinputResultBean checkSoukinyoukzinputResultBean = checkDsTorihikiService.checkSoukinyoukzInput(
            C_Tuukasyu.JPY, null, C_YokinKbn.BLNK, null, null, null, null);

        exClassificationEquals(checkSoukinyoukzinputResultBean.getChkkekkaKbn(), C_ChkkekkaKbn.ERROR, "チェック結果区分");
        exClassificationEquals(checkSoukinyoukzinputResultBean.getSoukinyoukzinputchkkekkaKbn(),
            C_SoukinyoukzinputchkkekkaKbn.YOKINMINYUURYOKU, "送金用口座入力チェック結果区分");
    }

    @Test
    @TestOrder(1020)
    public void testCheckSoukinyoukzInput_A2() {
        CheckSoukinyoukzinputResultBean checkSoukinyoukzinputResultBean = checkDsTorihikiService.checkSoukinyoukzInput(
            C_Tuukasyu.USD, "9900", C_YokinKbn.BLNK, null, null, null, null);

        exClassificationEquals(checkSoukinyoukzinputResultBean.getChkkekkaKbn(), C_ChkkekkaKbn.ERROR, "チェック結果区分");
        exClassificationEquals(checkSoukinyoukzinputResultBean.getSoukinyoukzinputchkkekkaKbn(),
            C_SoukinyoukzinputchkkekkaKbn.YUTYOGINKOUDATOUSEI, "送金用口座入力チェック結果区分");
    }

    @Test
    @TestOrder(1030)
    public void testCheckSoukinyoukzInput_A3() {
        CheckSoukinyoukzinputResultBean checkSoukinyoukzinputResultBean = checkDsTorihikiService.checkSoukinyoukzInput(
            C_Tuukasyu.JPY, "9900", C_YokinKbn.HUTUU, null, null, null, null);

        exClassificationEquals(checkSoukinyoukzinputResultBean.getChkkekkaKbn(), C_ChkkekkaKbn.ERROR, "チェック結果区分");
        exClassificationEquals(checkSoukinyoukzinputResultBean.getSoukinyoukzinputchkkekkaKbn(),
            C_SoukinyoukzinputchkkekkaKbn.BANGOUMINYUURYOKU, "送金用口座入力チェック結果区分");
    }

    @Test
    @TestOrder(1040)
    public void testCheckSoukinyoukzInput_A4() {
        CheckSoukinyoukzinputResultBean checkSoukinyoukzinputResultBean = checkDsTorihikiService.checkSoukinyoukzInput(
            C_Tuukasyu.EUR, "1001", C_YokinKbn.TOUZA, "", null, null, null);

        exClassificationEquals(checkSoukinyoukzinputResultBean.getChkkekkaKbn(), C_ChkkekkaKbn.ERROR, "チェック結果区分");
        exClassificationEquals(checkSoukinyoukzinputResultBean.getSoukinyoukzinputchkkekkaKbn(),
            C_SoukinyoukzinputchkkekkaKbn.BANGOUMINYUURYOKU, "送金用口座入力チェック結果区分");
    }

    @Test
    @TestOrder(1050)
    public void testCheckSoukinyoukzInput_A5() {
        CheckSoukinyoukzinputResultBean checkSoukinyoukzinputResultBean = checkDsTorihikiService.checkSoukinyoukzInput(
            C_Tuukasyu.JPY, "1001", C_YokinKbn.HUTUU, "ｱｱ12345", null, null, null);

        exClassificationEquals(checkSoukinyoukzinputResultBean.getChkkekkaKbn(), C_ChkkekkaKbn.ERROR, "チェック結果区分");
        exClassificationEquals(checkSoukinyoukzinputResultBean.getSoukinyoukzinputchkkekkaKbn(),
            C_SoukinyoukzinputchkkekkaKbn.BANGOUKYOKAMOJI, "送金用口座入力チェック結果区分");
    }

    @Test
    @TestOrder(1060)
    public void testCheckSoukinyoukzInput_A6() {
        CheckSoukinyoukzinputResultBean checkSoukinyoukzinputResultBean = checkDsTorihikiService.checkSoukinyoukzInput(
            C_Tuukasyu.JPY, "1001", C_YokinKbn.HUTUU, "12345678", null, null, null);

        exClassificationEquals(checkSoukinyoukzinputResultBean.getChkkekkaKbn(), C_ChkkekkaKbn.ERROR, "チェック結果区分");
        exClassificationEquals(checkSoukinyoukzinputResultBean.getSoukinyoukzinputchkkekkaKbn(),
            C_SoukinyoukzinputchkkekkaKbn.BANGOUKETASUU, "送金用口座入力チェック結果区分");
    }

    @Test
    @TestOrder(1070)
    public void testCheckSoukinyoukzInput_A7() {
        CheckSoukinyoukzinputResultBean checkSoukinyoukzinputResultBean = checkDsTorihikiService.checkSoukinyoukzInput(
            C_Tuukasyu.JPY, "1001", C_YokinKbn.HUTUU, "1234567", null, null, null);

        exClassificationEquals(checkSoukinyoukzinputResultBean.getChkkekkaKbn(), C_ChkkekkaKbn.ERROR, "チェック結果区分");
        exClassificationEquals(checkSoukinyoukzinputResultBean.getSoukinyoukzinputchkkekkaKbn(),
            C_SoukinyoukzinputchkkekkaKbn.MEIGININMINYUURYOKU, "送金用口座入力チェック結果区分");
    }

    @Test
    @TestOrder(1080)
    public void testCheckSoukinyoukzInput_A8() {
        CheckSoukinyoukzinputResultBean checkSoukinyoukzinputResultBean = checkDsTorihikiService.checkSoukinyoukzInput(
            C_Tuukasyu.JPY, "1001", C_YokinKbn.HUTUU, "1234567", "", null, null);

        exClassificationEquals(checkSoukinyoukzinputResultBean.getChkkekkaKbn(), C_ChkkekkaKbn.ERROR, "チェック結果区分");
        exClassificationEquals(checkSoukinyoukzinputResultBean.getSoukinyoukzinputchkkekkaKbn(),
            C_SoukinyoukzinputchkkekkaKbn.MEIGININMINYUURYOKU, "送金用口座入力チェック結果区分");
    }

    @Test
    @TestOrder(1090)
    public void testCheckSoukinyoukzInput_A9() {
        CheckSoukinyoukzinputResultBean checkSoukinyoukzinputResultBean = checkDsTorihikiService.checkSoukinyoukzInput(
            C_Tuukasyu.JPY, "1001", C_YokinKbn.HUTUU, "1234567", "アアアアアイイイイイエエエエエウウウウウオオオオオカカカカカキ",
            C_Kzdou.DOUITU, "アアアアアイイイイイエエエエエウウウウウオオオオオカカカカカキ");

        exClassificationEquals(checkSoukinyoukzinputResultBean.getChkkekkaKbn(), C_ChkkekkaKbn.ERROR, "チェック結果区分");
        exClassificationEquals(checkSoukinyoukzinputResultBean.getSoukinyoukzinputchkkekkaKbn(),
            C_SoukinyoukzinputchkkekkaKbn.MEIGININKETASUU, "送金用口座入力チェック結果区分");
    }

    @Test
    @TestOrder(1100)
    public void testCheckSoukinyoukzInput_A10() {
        CheckSoukinyoukzinputResultBean checkSoukinyoukzinputResultBean = checkDsTorihikiService.checkSoukinyoukzInput(
            C_Tuukasyu.JPY, "1001", C_YokinKbn.HUTUU, "1234567", "アアアアアイイイイイ％",
            C_Kzdou.DOUITU, "アアアアアイイイイイ％");

        exClassificationEquals(checkSoukinyoukzinputResultBean.getChkkekkaKbn(), C_ChkkekkaKbn.ERROR, "チェック結果区分");
        exClassificationEquals(checkSoukinyoukzinputResultBean.getSoukinyoukzinputchkkekkaKbn(),
            C_SoukinyoukzinputchkkekkaKbn.MEIGININKYOKAMOJI, "送金用口座入力チェック結果区分");
    }

    @Test
    @TestOrder(1110)
    public void testCheckSoukinyoukzInput_A11() {
        CheckSoukinyoukzinputResultBean checkSoukinyoukzinputResultBean = checkDsTorihikiService.checkSoukinyoukzInput(
            C_Tuukasyu.JPY, "1001", C_YokinKbn.HUTUU, "1234567", "アアアアアイイイイイ",
            C_Kzdou.DOUITU, "アアアアアイイイイイ");

        exClassificationEquals(checkSoukinyoukzinputResultBean.getChkkekkaKbn(), C_ChkkekkaKbn.SEIJYOU, "チェック結果区分");
        exClassificationEquals(checkSoukinyoukzinputResultBean.getSoukinyoukzinputchkkekkaKbn(),
            C_SoukinyoukzinputchkkekkaKbn.BLNK, "送金用口座入力チェック結果区分");
    }

    @Test
    @TestOrder(1120)
    public void testCheckSoukinyoukzInput_A12() {
        CheckSoukinyoukzinputResultBean checkSoukinyoukzinputResultBean = checkDsTorihikiService.checkSoukinyoukzInput(
            C_Tuukasyu.JPY, "1001", C_YokinKbn.HUTUU, "1234567", "アアアアアイイイイイエエエエエウウウウウオオオオオカカカカカキ",
            C_Kzdou.SITEI, "ウウウウウエエエエエ");

        exClassificationEquals(checkSoukinyoukzinputResultBean.getChkkekkaKbn(), C_ChkkekkaKbn.ERROR, "チェック結果区分");
        exClassificationEquals(checkSoukinyoukzinputResultBean.getSoukinyoukzinputchkkekkaKbn(),
            C_SoukinyoukzinputchkkekkaKbn.MEIGININKETASUU, "送金用口座入力チェック結果区分");
    }

    @Test
    @TestOrder(1130)
    public void testCheckSoukinyoukzInput_A13() {
        CheckSoukinyoukzinputResultBean checkSoukinyoukzinputResultBean = checkDsTorihikiService.checkSoukinyoukzInput(
            C_Tuukasyu.JPY, "1001", C_YokinKbn.HUTUU, "1234567", "アアアアアイイイイイ％",
            C_Kzdou.SITEI, "ウウウウウエエエエエ");

        exClassificationEquals(checkSoukinyoukzinputResultBean.getChkkekkaKbn(), C_ChkkekkaKbn.ERROR, "チェック結果区分");
        exClassificationEquals(checkSoukinyoukzinputResultBean.getSoukinyoukzinputchkkekkaKbn(),
            C_SoukinyoukzinputchkkekkaKbn.MEIGININKYOKAMOJI, "送金用口座入力チェック結果区分");
    }

    @Test
    @TestOrder(1140)
    public void testCheckSoukinyoukzInput_A14() {
        CheckSoukinyoukzinputResultBean checkSoukinyoukzinputResultBean = checkDsTorihikiService.checkSoukinyoukzInput(
            C_Tuukasyu.JPY, "1001", C_YokinKbn.HUTUU, "1234567", "アアアアアイイイイイ",
            C_Kzdou.SITEI, "ウウウウウエエエエエ");

        exClassificationEquals(checkSoukinyoukzinputResultBean.getChkkekkaKbn(), C_ChkkekkaKbn.SEIJYOU, "チェック結果区分");
        exClassificationEquals(checkSoukinyoukzinputResultBean.getSoukinyoukzinputchkkekkaKbn(),
            C_SoukinyoukzinputchkkekkaKbn.BLNK, "送金用口座入力チェック結果区分");
    }
}