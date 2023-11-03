package yuyu.common.hozen.ascommon;

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
 * 前納入金額計算クラスのメソッド {@link KeisanZennouNyuukinGk2#execKeisanSinkeiyakuDoujiZennouNyuukinGk(BizDate,BizCurrency,
 * Integer, C_Tuukasyu, BizNumber, BizNumber)}テスト用クラスです <br />
 */
@RunWith(OrderedRunner.class)
public class KeisanZennouNyuukinGk2Test_execKeisanSinkeiyakuDoujiZennouNyuukinGk {

    @Inject
    private KeisanZennouNyuukinGk2 keisanZennouNyuukinGk2;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_前納入金額計算２";
    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(
                KeisanZennouNyuukinGk2Test_execKeisanSinkeiyakuDoujiZennouNyuukinGk.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllZennouKeikaRiritu());
        bizDomManager.delete(bizDomManager.getAllZennouGenkaRitu());
    }

    @Test
    @TestOrder(10)
    public void testExecKeisanSinkeiyakuDoujiZennouNyuukinGk_A1() {

        BizDate kijyunymd = BizDate.valueOf("29991230");

        BizCurrency zennouHrkp = BizCurrency.valueOf(100);

        Integer zennouKikan = 1;

        C_Tuukasyu rsTuukasyu = null;

        BizNumber ryosyukwsRate = null;

        BizNumber yenkansanTkykwsRate = null;

        C_ErrorKbn errorKbn = keisanZennouNyuukinGk2.execKeisanSinkeiyakuDoujiZennouNyuukinGk(
            kijyunymd, zennouHrkp, zennouKikan, rsTuukasyu, ryosyukwsRate, yenkansanTkykwsRate);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");

        BizCurrency zennouNyuukin = keisanZennouNyuukinGk2.getZennouNyuukinGk();
        BizCurrency zennouGenka = keisanZennouNyuukinGk2.getZennouGenka();
        BizCurrency zennouNyuukinGkRsTk = keisanZennouNyuukinGk2.getZennouNyuukinGkRsTk();
        BizCurrency zennouGenkaRsTk = keisanZennouNyuukinGk2.getZennouGenkaRsTk();
        BizCurrency zennouNyuukinGkEnka = keisanZennouNyuukinGk2.getZennouNyuukinGkEnka();
        BizCurrency zennouGenkaEnka = keisanZennouNyuukinGk2.getZennouGenkaEnka();

        exBizCalcbleEquals(zennouNyuukin, null, "前納入金額");
        exBizCalcbleEquals(zennouGenka, null, "前納現価");
        exBizCalcbleEquals(zennouNyuukinGkRsTk, null, "前納入金額（領収通貨）");
        exBizCalcbleEquals(zennouGenkaRsTk, null, "前納現価（領収通貨）");
        exBizCalcbleEquals(zennouNyuukinGkEnka, null, "前納入金額（円貨）");
        exBizCalcbleEquals(zennouGenkaEnka, null, "前納現価（円貨）");
    }

    @Test
    @TestOrder(20)
    public void testExecKeisanSinkeiyakuDoujiZennouNyuukinGk_A2() {

        BizDate kijyunymd = BizDate.valueOf("20181010");

        BizCurrency zennouHrkp = BizCurrency.valueOf(100);

        Integer zennouKikan = 1;

        C_Tuukasyu rsTuukasyu = C_Tuukasyu.USD;

        BizNumber ryosyukwsRate = null;

        BizNumber yenkansanTkykwsRate = null;

        C_ErrorKbn errorKbn = keisanZennouNyuukinGk2.execKeisanSinkeiyakuDoujiZennouNyuukinGk(
            kijyunymd, zennouHrkp, zennouKikan, rsTuukasyu, ryosyukwsRate, yenkansanTkykwsRate);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");

        BizCurrency zennouNyuukin = keisanZennouNyuukinGk2.getZennouNyuukinGk();
        BizCurrency zennouGenka = keisanZennouNyuukinGk2.getZennouGenka();
        BizCurrency zennouNyuukinGkRsTk = keisanZennouNyuukinGk2.getZennouNyuukinGkRsTk();
        BizCurrency zennouGenkaRsTk = keisanZennouNyuukinGk2.getZennouGenkaRsTk();
        BizCurrency zennouNyuukinGkEnka = keisanZennouNyuukinGk2.getZennouNyuukinGkEnka();
        BizCurrency zennouGenkaEnka = keisanZennouNyuukinGk2.getZennouGenkaEnka();

        exBizCalcbleEquals(zennouNyuukin, BizCurrency.valueOf(1778), "前納入金額");
        exBizCalcbleEquals(zennouGenka, BizCurrency.valueOf(1778), "前納現価");
        exBizCalcbleEquals(zennouNyuukinGkRsTk, null, "前納入金額（領収通貨）");
        exBizCalcbleEquals(zennouGenkaRsTk, null, "前納現価（領収通貨）");
        exBizCalcbleEquals(zennouNyuukinGkEnka, null, "前納入金額（円貨）");
        exBizCalcbleEquals(zennouGenkaEnka, null, "前納現価（円貨）");
    }

    @Test
    @TestOrder(30)
    public void testExecKeisanSinkeiyakuDoujiZennouNyuukinGk_A3() {

        BizDate kijyunymd = BizDate.valueOf("20181010");

        BizCurrency zennouHrkp = BizCurrency.valueOf(100);

        Integer zennouKikan = 1;

        C_Tuukasyu rsTuukasyu = C_Tuukasyu.BLNK;

        BizNumber ryosyukwsRate = null;

        BizNumber yenkansanTkykwsRate = BizNumber.valueOf(10);

        C_ErrorKbn errorKbn = keisanZennouNyuukinGk2.execKeisanSinkeiyakuDoujiZennouNyuukinGk(
            kijyunymd, zennouHrkp, zennouKikan, rsTuukasyu, ryosyukwsRate, yenkansanTkykwsRate);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

        BizCurrency zennouNyuukin = keisanZennouNyuukinGk2.getZennouNyuukinGk();
        BizCurrency zennouGenka = keisanZennouNyuukinGk2.getZennouGenka();
        BizCurrency zennouNyuukinGkRsTk = keisanZennouNyuukinGk2.getZennouNyuukinGkRsTk();
        BizCurrency zennouGenkaRsTk = keisanZennouNyuukinGk2.getZennouGenkaRsTk();
        BizCurrency zennouNyuukinGkEnka = keisanZennouNyuukinGk2.getZennouNyuukinGkEnka();
        BizCurrency zennouGenkaEnka = keisanZennouNyuukinGk2.getZennouGenkaEnka();

        exBizCalcbleEquals(zennouNyuukin, BizCurrency.valueOf(1878), "前納入金額");
        exBizCalcbleEquals(zennouGenka, BizCurrency.valueOf(1778), "前納現価");
        exBizCalcbleEquals(zennouNyuukinGkRsTk, BizCurrency.valueOf(1878), "前納入金額（領収通貨）");
        exBizCalcbleEquals(zennouGenkaRsTk, BizCurrency.valueOf(1778), "前納現価（領収通貨）");
        exBizCalcbleEquals(zennouNyuukinGkEnka, BizCurrency.valueOf(1878), "前納入金額（円貨）");
        exBizCalcbleEquals(zennouGenkaEnka, BizCurrency.valueOf(1778), "前納現価（円貨）");
    }

    @Test
    @TestOrder(40)
    public void testExecKeisanSinkeiyakuDoujiZennouNyuukinGk_A4() {

        BizDate kijyunymd = BizDate.valueOf("20181225");

        BizCurrency zennouHrkp = BizCurrency.valueOf(100, BizCurrencyTypes.EURO);

        Integer zennouKikan = 1;

        C_Tuukasyu rsTuukasyu = null;

        BizNumber ryosyukwsRate = null;

        BizNumber yenkansanTkykwsRate = null;

        C_ErrorKbn errorKbn = keisanZennouNyuukinGk2.execKeisanSinkeiyakuDoujiZennouNyuukinGk(
            kijyunymd, zennouHrkp, zennouKikan, rsTuukasyu, ryosyukwsRate, yenkansanTkykwsRate);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

        BizCurrency zennouNyuukin = keisanZennouNyuukinGk2.getZennouNyuukinGk();
        BizCurrency zennouGenka = keisanZennouNyuukinGk2.getZennouGenka();
        BizCurrency zennouNyuukinGkRsTk = keisanZennouNyuukinGk2.getZennouNyuukinGkRsTk();
        BizCurrency zennouGenkaRsTk = keisanZennouNyuukinGk2.getZennouGenkaRsTk();
        BizCurrency zennouNyuukinGkEnka = keisanZennouNyuukinGk2.getZennouNyuukinGkEnka();
        BizCurrency zennouGenkaEnka = keisanZennouNyuukinGk2.getZennouGenkaEnka();

        exBizCalcbleEquals(zennouNyuukin, BizCurrency.valueOf(1989.9, BizCurrencyTypes.EURO), "前納入金額");
        exBizCalcbleEquals(zennouGenka, BizCurrency.valueOf(1889.9, BizCurrencyTypes.EURO), "前納現価");
        exBizCalcbleEquals(zennouNyuukinGkRsTk, BizCurrency.valueOf(1989.9, BizCurrencyTypes.EURO), "前納入金額（領収通貨）");
        exBizCalcbleEquals(zennouGenkaRsTk, BizCurrency.valueOf(1889.9, BizCurrencyTypes.EURO), "前納現価（領収通貨）");
        exBizCalcbleEquals(zennouNyuukinGkEnka, null, "前納入金額（円貨）");
        exBizCalcbleEquals(zennouGenkaEnka, null, "前納現価（円貨）");
    }

    @Test
    @TestOrder(50)
    public void testExecKeisanSinkeiyakuDoujiZennouNyuukinGk_A5() {

        BizDate kijyunymd = BizDate.valueOf("20181225");

        BizCurrency zennouHrkp = BizCurrency.valueOf(100, BizCurrencyTypes.EURO);

        Integer zennouKikan = 1;

        C_Tuukasyu rsTuukasyu = C_Tuukasyu.EUR;

        BizNumber ryosyukwsRate = BizNumber.valueOf(10);

        BizNumber yenkansanTkykwsRate = BizNumber.valueOf(10);

        C_ErrorKbn errorKbn = keisanZennouNyuukinGk2.execKeisanSinkeiyakuDoujiZennouNyuukinGk(
            kijyunymd, zennouHrkp, zennouKikan, rsTuukasyu, ryosyukwsRate, yenkansanTkykwsRate);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

        BizCurrency zennouNyuukin = keisanZennouNyuukinGk2.getZennouNyuukinGk();
        BizCurrency zennouGenka = keisanZennouNyuukinGk2.getZennouGenka();
        BizCurrency zennouNyuukinGkRsTk = keisanZennouNyuukinGk2.getZennouNyuukinGkRsTk();
        BizCurrency zennouGenkaRsTk = keisanZennouNyuukinGk2.getZennouGenkaRsTk();
        BizCurrency zennouNyuukinGkEnka = keisanZennouNyuukinGk2.getZennouNyuukinGkEnka();
        BizCurrency zennouGenkaEnka = keisanZennouNyuukinGk2.getZennouGenkaEnka();

        exBizCalcbleEquals(zennouNyuukin, BizCurrency.valueOf(1989.9, BizCurrencyTypes.EURO), "前納入金額");
        exBizCalcbleEquals(zennouGenka, BizCurrency.valueOf(1889.9, BizCurrencyTypes.EURO), "前納現価");
        exBizCalcbleEquals(zennouNyuukinGkRsTk, BizCurrency.valueOf(1989.9, BizCurrencyTypes.EURO), "前納入金額（領収通貨）");
        exBizCalcbleEquals(zennouGenkaRsTk, BizCurrency.valueOf(1889.9, BizCurrencyTypes.EURO), "前納現価（領収通貨）");
        exBizCalcbleEquals(zennouNyuukinGkEnka,  BizCurrency.valueOf(19899), "前納入金額（円貨）");
        exBizCalcbleEquals(zennouGenkaEnka, BizCurrency.valueOf(18899), "前納現価（円貨）");
    }

    @Test
    @TestOrder(60)
    public void testExecKeisanSinkeiyakuDoujiZennouNyuukinGk_A6() {

        BizDate kijyunymd = BizDate.valueOf("20181225");

        BizCurrency zennouHrkp = BizCurrency.valueOf(100, BizCurrencyTypes.EURO);

        Integer zennouKikan = 1;

        C_Tuukasyu rsTuukasyu = C_Tuukasyu.USD;

        BizNumber ryosyukwsRate = BizNumber.valueOf(10);

        BizNumber yenkansanTkykwsRate = null;

        C_ErrorKbn errorKbn = keisanZennouNyuukinGk2.execKeisanSinkeiyakuDoujiZennouNyuukinGk(
            kijyunymd, zennouHrkp, zennouKikan, rsTuukasyu, ryosyukwsRate, yenkansanTkykwsRate);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

        BizCurrency zennouNyuukin = keisanZennouNyuukinGk2.getZennouNyuukinGk();
        BizCurrency zennouGenka = keisanZennouNyuukinGk2.getZennouGenka();
        BizCurrency zennouNyuukinGkRsTk = keisanZennouNyuukinGk2.getZennouNyuukinGkRsTk();
        BizCurrency zennouGenkaRsTk = keisanZennouNyuukinGk2.getZennouGenkaRsTk();
        BizCurrency zennouNyuukinGkEnka = keisanZennouNyuukinGk2.getZennouNyuukinGkEnka();
        BizCurrency zennouGenkaEnka = keisanZennouNyuukinGk2.getZennouGenkaEnka();

        exBizCalcbleEquals(zennouNyuukin, BizCurrency.valueOf(1989.9, BizCurrencyTypes.EURO), "前納入金額");
        exBizCalcbleEquals(zennouGenka, BizCurrency.valueOf(1889.9, BizCurrencyTypes.EURO), "前納現価");
        exBizCalcbleEquals(zennouNyuukinGkRsTk, BizCurrency.valueOf(19899, BizCurrencyTypes.DOLLAR), "前納入金額（領収通貨）");
        exBizCalcbleEquals(zennouGenkaRsTk, BizCurrency.valueOf(18899, BizCurrencyTypes.DOLLAR), "前納現価（領収通貨）");
        exBizCalcbleEquals(zennouNyuukinGkEnka, null, "前納入金額（円貨）");
        exBizCalcbleEquals(zennouGenkaEnka, null, "前納現価（円貨）");
    }
}
