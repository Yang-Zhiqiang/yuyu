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
 * 前納精算額計算２クラスのメソッド {@link KeisanZennouSeisanGk2#kansanZennouSeisanGk(BizDate, C_Tuukasyu， BizDate)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanZennouSeisanGk2Test_kansanZennouSeisanGk {

    @Inject
    private KeisanZennouSeisanGk2 keisanZennouSeisanGk2;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_前納精算額計算２";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(KeisanZennouSeisanGk2Test_kansanZennouSeisanGk.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ003", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllKawaseRate());
    }

    @Test
    @TestOrder(10)
    public void testKansanZennouSeisanGk_A1() {

        BizCurrency zennouSeisanGk = BizCurrency.valueOf(1000, BizCurrencyTypes.DOLLAR);
        C_Tuukasyu knsnTuukasyu = C_Tuukasyu.USD;
        BizDate knsnKwsratekjymd = BizDate.valueOf(20200101);

        C_ErrorKbn errorKbn = keisanZennouSeisanGk2.kansanZennouSeisanGk(zennouSeisanGk, knsnTuukasyu, knsnKwsratekjymd);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanZennouSeisanGk2.getKnsnKwsRate(), null,"換算為替レート");
        exBizCalcbleEquals(keisanZennouSeisanGk2.getZennouSeisanGkKnsnTk(), BizCurrency.valueOf(1000, BizCurrencyTypes.DOLLAR), "前納精算額（換算通貨）");
    }

    @Test
    @TestOrder(20)
    public void testKansanZennouSeisanGk_A2() {

        BizCurrency zennouSeisanGk = BizCurrency.valueOf(1000, BizCurrencyTypes.DOLLAR);
        C_Tuukasyu knsnTuukasyu = C_Tuukasyu.JPY;
        BizDate knsnKwsratekjymd = BizDate.valueOf(20170102);

        C_ErrorKbn errorKbn = keisanZennouSeisanGk2.kansanZennouSeisanGk(zennouSeisanGk, knsnTuukasyu, knsnKwsratekjymd);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exBizCalcbleEquals(keisanZennouSeisanGk2.getKnsnKwsRate(), null,"換算為替レート");
        exBizCalcbleEquals(keisanZennouSeisanGk2.getZennouSeisanGkKnsnTk(), null, "前納精算額（換算通貨）");
    }

    @Test
    @TestOrder(30)
    public void testKansanZennouSeisanGk_A3() {

        BizCurrency zennouSeisanGk = BizCurrency.valueOf(1000, BizCurrencyTypes.DOLLAR);
        C_Tuukasyu knsnTuukasyu = C_Tuukasyu.JPY;
        BizDate knsnKwsratekjymd = BizDate.valueOf(20200101);

        C_ErrorKbn errorKbn = keisanZennouSeisanGk2.kansanZennouSeisanGk(zennouSeisanGk, knsnTuukasyu, knsnKwsratekjymd);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanZennouSeisanGk2.getKnsnKwsRate(), BizNumber.valueOf(120.89),"換算為替レート");
        exBizCalcbleEquals(keisanZennouSeisanGk2.getZennouSeisanGkKnsnTk(), BizCurrency.valueOf(120890), "前納精算額（換算通貨）");
    }
}
