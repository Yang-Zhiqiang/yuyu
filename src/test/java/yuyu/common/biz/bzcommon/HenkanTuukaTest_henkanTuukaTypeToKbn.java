package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.number.currencytype.CurrencyType;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Tuukasyu;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 通貨変換処理の通貨変換処理メソッド{@link HenkanTuuka#henkanTuukaTypeToKbn(CurrencyType)}テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class HenkanTuukaTest_henkanTuukaTypeToKbn {


    @Inject
    private HenkanTuuka henkanTuuka;

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

    }

    @Test(expected = BizAppException.class)
    @Transactional
    @TestOrder(10)
    public void testHenkanTuukaTypeToKbn_A1() {

        try {
            henkanTuuka.henkanTuukaTypeToKbn(null);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='通貨タイプ',value='null'","エラーメッセージ");
            throw e;
        }
    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testHenkanTuukaTypeToKbn_A2() {

        C_Tuukasyu tuukasyu = henkanTuuka.henkanTuukaTypeToKbn(BizCurrencyTypes.YEN);

        exClassificationEquals(tuukasyu, C_Tuukasyu.JPY, "通貨種類");
    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testHenkanTuukaTypeToKbn_A3() {

        C_Tuukasyu tuukasyu = henkanTuuka.henkanTuukaTypeToKbn(BizCurrencyTypes.DOLLAR);

        exClassificationEquals(tuukasyu, C_Tuukasyu.USD, "通貨種類");
    }

    @Test
    @Transactional
    @TestOrder(40)
    public void testHenkanTuukaTypeToKbn_A4() {

        C_Tuukasyu tuukasyu = henkanTuuka.henkanTuukaTypeToKbn(BizCurrencyTypes.EURO);

        exClassificationEquals(tuukasyu, C_Tuukasyu.EUR, "通貨種類");
    }

    @Test
    @Transactional
    @TestOrder(50)
    public void testHenkanTuukaTypeToKbn_A5() {

        C_Tuukasyu tuukasyu = henkanTuuka.henkanTuukaTypeToKbn(BizCurrencyTypes.AU_DOLLAR);

        exClassificationEquals(tuukasyu, C_Tuukasyu.AUD, "通貨種類");
    }

    @Test
    @Transactional
    @TestOrder(60)
    public void testHenkanTuukaTypeToKbn_A6() {

        C_Tuukasyu tuukasyu = henkanTuuka.henkanTuukaTypeToKbn(BizCurrencyTypes.MANYEN);
        exClassificationEquals(tuukasyu, C_Tuukasyu.JPY, "通貨種類");
    }

}