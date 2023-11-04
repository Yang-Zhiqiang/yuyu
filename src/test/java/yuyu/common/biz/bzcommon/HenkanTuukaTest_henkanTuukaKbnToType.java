package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.number.configuration.BizNumberConfig;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.number.currencytype.CurrencyType;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Tuukasyu;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 通貨変換処理の通貨変換処理メソッド{@link HenkanTuuka#henkanTuukaKbnToType(C_Tuukasyu)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class HenkanTuukaTest_henkanTuukaKbnToType {

    @Inject
    private HenkanTuuka henkanTuuka;

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

    }

    @Test(expected = BizAppException.class)
    @Transactional
    @TestOrder(10)
    public void testHenkanTuukaKbnToType_A1() {

        try {
            henkanTuuka.henkanTuukaKbnToType(null);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='通貨種類',value='null'","エラーメッセージ");
            throw e;
        }
    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testHenkanTuukaKbnToType_A2() {

        CurrencyType currencyType =henkanTuuka.henkanTuukaKbnToType(C_Tuukasyu.JPY);
        exStringEquals(String.valueOf(currencyType), BizCurrencyTypes.YEN.toString(), "通貨タイプ");

    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testHenkanTuukaKbnToType_A3() {

        CurrencyType currencyType =henkanTuuka.henkanTuukaKbnToType(C_Tuukasyu.USD);
        exStringEquals(String.valueOf(currencyType), BizCurrencyTypes.DOLLAR.toString(), "通貨タイプ");

    }

    @Test
    @Transactional
    @TestOrder(40)
    public void testHenkanTuukaKbnToType_A4() {

        CurrencyType currencyType =henkanTuuka.henkanTuukaKbnToType(C_Tuukasyu.EUR);
        exStringEquals(String.valueOf(currencyType), BizCurrencyTypes.EURO.toString(), "通貨タイプ");

    }

    @Test
    @Transactional
    @TestOrder(50)
    public void testHenkanTuukaKbnToType_A5() {

        CurrencyType currencyType =henkanTuuka.henkanTuukaKbnToType(C_Tuukasyu.AUD);
        exStringEquals(String.valueOf(currencyType), BizCurrencyTypes.AU_DOLLAR.toString(), "通貨タイプ");

    }

    @Test
    @Transactional
    @TestOrder(60)
    public void testHenkanTuukaKbnToType_A6() {

        CurrencyType currencyType =henkanTuuka.henkanTuukaKbnToType(C_Tuukasyu.BLNK);
        exStringEquals(String.valueOf(currencyType), BizNumberConfig.getInstance().getDefaultCurrencyType().toString(), "通貨タイプ");

    }

}