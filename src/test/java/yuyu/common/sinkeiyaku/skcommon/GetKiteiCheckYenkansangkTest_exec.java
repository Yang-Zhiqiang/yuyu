package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 規定チェック用円換算金額取得のメソッド {@link GetKiteiCheckYenkansangk#exec(BizDate, BizCurrency, C_Tuukasyu)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class GetKiteiCheckYenkansangkTest_exec {

    @Inject
    private GetKiteiCheckYenkansangk getKiteiCheckYenkansangk;


    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_規定チェック用円換算金額取得";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(GetKiteiCheckYenkansangkTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllKijyungkHanteiKawaseRate());
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {
        BizDate  kijyunYmd = BizDate.valueOf("20160804");
        BizCurrency gaku = BizCurrency.valueOf(1000, BizCurrencyTypes.YEN);
        C_Tuukasyu tuukaSyu = C_Tuukasyu.JPY;

        BizCurrency enKanzanGaku = getKiteiCheckYenkansangk.exec(kijyunYmd, gaku, tuukaSyu);

        exBizCalcbleEquals(enKanzanGaku, BizCurrency.valueOf(1000), "円換算金額");
        exBizCalcbleEquals(getKiteiCheckYenkansangk.getKijyungkHanteiyouKawaseRate(), BizNumber.valueOf(0), "基準額判定用為替レート");
        exClassificationEquals(getKiteiCheckYenkansangk.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        BizDate  kijyunYmd = BizDate.valueOf("20160804");
        BizCurrency gaku = BizCurrency.valueOf(1050.23, BizCurrencyTypes.DOLLAR);
        C_Tuukasyu tuukaSyu = C_Tuukasyu.USD;

        BizCurrency enKanzanGaku =getKiteiCheckYenkansangk.exec(kijyunYmd, gaku, tuukaSyu);

        exBizCalcbleEquals(enKanzanGaku, BizCurrency.valueOf(0), "円換算金額");
        exBizCalcbleEquals(getKiteiCheckYenkansangk.getKijyungkHanteiyouKawaseRate(), BizNumber.valueOf(0), "基準額判定用為替レート");
        exClassificationEquals(getKiteiCheckYenkansangk.getErrorKbn(), C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {
        BizDate  kijyunYmd = BizDate.valueOf("20170808");
        BizCurrency gaku = BizCurrency.valueOf(1150.59, BizCurrencyTypes.AU_DOLLAR);
        C_Tuukasyu tuukaSyu = C_Tuukasyu.AUD;

        BizCurrency enKanzanGaku = getKiteiCheckYenkansangk.exec(kijyunYmd, gaku, tuukaSyu);

        exBizCalcbleEquals(enKanzanGaku, BizCurrency.valueOf(57529), "円換算金額");
        exBizCalcbleEquals(getKiteiCheckYenkansangk.getKijyungkHanteiyouKawaseRate(), BizNumber.valueOf(50), "基準額判定用為替レート");
        exClassificationEquals(getKiteiCheckYenkansangk.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {
        BizDate  kijyunYmd = BizDate.valueOf("20170808");
        BizCurrency gaku = BizCurrency.valueOf(115.22, BizCurrencyTypes.DOLLAR);
        C_Tuukasyu tuukaSyu = C_Tuukasyu.USD;

        BizCurrency enKanzanGaku = getKiteiCheckYenkansangk.exec(kijyunYmd, gaku, tuukaSyu);

        exBizCalcbleEquals(enKanzanGaku, BizCurrency.valueOf(5761), "円換算金額");
        exBizCalcbleEquals(getKiteiCheckYenkansangk.getKijyungkHanteiyouKawaseRate(), BizNumber.valueOf(50), "基準額判定用為替レート");
        exClassificationEquals(getKiteiCheckYenkansangk.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {
        BizDate  kijyunYmd = BizDate.valueOf("20160804");
        BizCurrency gaku = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        C_Tuukasyu tuukaSyu = C_Tuukasyu.JPY;

        BizCurrency enKanzanGaku = getKiteiCheckYenkansangk.exec(kijyunYmd, gaku, tuukaSyu);

        BizNumber kijyungkHanteiyouKawaseRate = getKiteiCheckYenkansangk.getKijyungkHanteiyouKawaseRate();
        exBizCalcbleEquals(enKanzanGaku, BizCurrency.valueOf(0), "円換算金額");
        exBizCalcbleEquals(kijyungkHanteiyouKawaseRate, BizNumber.ZERO, "基準額判定用為替レート");
        exClassificationEquals(getKiteiCheckYenkansangk.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");

    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {
        BizDate  kijyunYmd = BizDate.valueOf("20170808");
        BizCurrency gaku = BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR);
        C_Tuukasyu tuukaSyu = C_Tuukasyu.AUD;

        BizCurrency enKanzanGaku = getKiteiCheckYenkansangk.exec(kijyunYmd, gaku, tuukaSyu);
        BizNumber kijyungkHanteiyouKawaseRate = getKiteiCheckYenkansangk.getKijyungkHanteiyouKawaseRate();
        exBizCalcbleEquals(enKanzanGaku, BizCurrency.valueOf(0), "円換算金額");
        exBizCalcbleEquals(kijyungkHanteiyouKawaseRate, BizNumber.valueOf(0), "基準額判定用為替レート");
        exClassificationEquals(getKiteiCheckYenkansangk.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {
        BizDate  kijyunYmd = null;
        BizCurrency gaku = BizCurrency.valueOf(1000, BizCurrencyTypes.DOLLAR);
        C_Tuukasyu tuukaSyu = C_Tuukasyu.USD;

        BizCurrency enKanzanGaku = getKiteiCheckYenkansangk.exec(kijyunYmd, gaku, tuukaSyu);

        exBizCalcbleEquals(enKanzanGaku, BizCurrency.valueOf(0), "円換算金額");
        exBizCalcbleEquals(getKiteiCheckYenkansangk.getKijyungkHanteiyouKawaseRate(), BizNumber.valueOf(0), "基準額判定用為替レート");
        exClassificationEquals(getKiteiCheckYenkansangk.getErrorKbn(), C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {
        BizDate  kijyunYmd = BizDate.valueOf("20170808");
        BizCurrency gaku = null;
        C_Tuukasyu tuukaSyu = C_Tuukasyu.JPY;

        BizCurrency enKanzanGaku = getKiteiCheckYenkansangk.exec(kijyunYmd, gaku, tuukaSyu);

        exBizCalcbleEquals(enKanzanGaku, BizCurrency.valueOf(0), "円換算金額");
        exBizCalcbleEquals(getKiteiCheckYenkansangk.getKijyungkHanteiyouKawaseRate(), BizNumber.valueOf(0), "基準額判定用為替レート");
        exClassificationEquals(getKiteiCheckYenkansangk.getErrorKbn(), C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {
        BizDate  kijyunYmd = BizDate.valueOf("20170808");
        BizCurrency gaku = BizCurrency.valueOf(1000, BizCurrencyTypes.DOLLAR);
        C_Tuukasyu tuukaSyu = null;

        BizCurrency enKanzanGaku = getKiteiCheckYenkansangk.exec(kijyunYmd, gaku, tuukaSyu);

        exBizCalcbleEquals(enKanzanGaku, BizCurrency.valueOf(0), "円換算金額");
        exBizCalcbleEquals(getKiteiCheckYenkansangk.getKijyungkHanteiyouKawaseRate(), BizNumber.valueOf(0), "基準額判定用為替レート");
        exClassificationEquals(getKiteiCheckYenkansangk.getErrorKbn(), C_ErrorKbn.ERROR, "エラー区分");
    }
}
