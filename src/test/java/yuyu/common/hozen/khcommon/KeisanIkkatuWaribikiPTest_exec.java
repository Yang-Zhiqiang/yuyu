package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
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
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * KeisanIkkatuWaribikikiPクラスのメソッド {@link KeisanIkkatuWaribikikiP#exec(String,String,BizNumber,int,BizCurrency)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanIkkatuWaribikiPTest_exec {

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_一括割引Ｐ計算";

    private final static String sheetName = "INデータ";

    @Inject
    private KeisanIkkatuWaribikiP keisanIkkatuWaribikiP;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(KeisanIkkatuWaribikiPTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ002", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {


        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllIkkatuTekiyouNo2());
        bizDomManager.delete(bizDomManager.getAllIkkatuKeisuu());
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        C_ErrorKbn kekkakbn = keisanIkkatuWaribikiP.exec(
            "ﾆｱ",
            "1",
            BizNumber.valueOf(0.1),
            1,
            BizCurrency.valueOf(10));

        exBizCalcbleEquals(keisanIkkatuWaribikiP.getP(), BizCurrency.valueOf(0), "保険料");
        exBizCalcbleEquals(keisanIkkatuWaribikiP.getIktwaribikikgk(), BizCurrency.valueOf(0), "一括割引料");
        exClassificationEquals(kekkakbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        C_ErrorKbn kekkakbn = keisanIkkatuWaribikiP.exec(
            "ﾕｲ",
            "1",
            BizNumber.valueOf(0.1),
            1,
            BizCurrency.valueOf(10));

        exBizCalcbleEquals(keisanIkkatuWaribikiP.getP(), BizCurrency.valueOf(0), "保険料");
        exBizCalcbleEquals(keisanIkkatuWaribikiP.getIktwaribikikgk(), BizCurrency.valueOf(0), "一括割引料");
        exClassificationEquals(kekkakbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {
        C_ErrorKbn kekkakbn = keisanIkkatuWaribikiP.exec(
            "ﾕｱ",
            "1",
            BizNumber.valueOf(0.1),
            1,
            BizCurrency.valueOf(10));

        exBizCalcbleEquals(keisanIkkatuWaribikiP.getP(), BizCurrency.valueOf(0), "保険料");
        exBizCalcbleEquals(keisanIkkatuWaribikiP.getIktwaribikikgk(), BizCurrency.valueOf(0), "一括割引料");
        exClassificationEquals(kekkakbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        C_ErrorKbn kekkakbn = keisanIkkatuWaribikiP.exec(
            "ﾕA",
            "2",
            BizNumber.valueOf(0.1),
            5,
            BizCurrency.valueOf(100));

        exBizCalcbleEquals(keisanIkkatuWaribikiP.getP(), BizCurrency.valueOf(464), "保険料");
        exBizCalcbleEquals(keisanIkkatuWaribikiP.getIktwaribikikgk(), BizCurrency.valueOf(36), "一括割引料");
        exClassificationEquals(kekkakbn, C_ErrorKbn.OK, "結果区分");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        C_ErrorKbn kekkakbn = keisanIkkatuWaribikiP.exec(
            "ﾕA",
            "1",
            BizNumber.valueOf(0.1),
            5,
            BizCurrency.valueOf(10.12, BizCurrencyTypes.DOLLAR));

        exBizCalcbleEquals(keisanIkkatuWaribikiP.getP(), BizCurrency.valueOf(49.47, BizCurrencyTypes.DOLLAR), "保険料");
        exBizCalcbleEquals(keisanIkkatuWaribikiP.getIktwaribikikgk(), BizCurrency.valueOf(1.13, BizCurrencyTypes.DOLLAR), "一括割引料");
        exClassificationEquals(kekkakbn, C_ErrorKbn.OK, "結果区分");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        C_ErrorKbn kekkakbn = keisanIkkatuWaribikiP.exec(
            "ﾆｱ",
            "2",
            BizNumber.valueOf(0.6),
            5,
            BizCurrency.valueOf(10.12, BizCurrencyTypes.DOLLAR));

        exBizCalcbleEquals(keisanIkkatuWaribikiP.getP(), BizCurrency.valueOf(49.35, BizCurrencyTypes.DOLLAR), "保険料");
        exBizCalcbleEquals(keisanIkkatuWaribikiP.getIktwaribikikgk(), BizCurrency.valueOf(1.25, BizCurrencyTypes.DOLLAR), "一括割引料");
        exClassificationEquals(kekkakbn, C_ErrorKbn.OK, "結果区分");
    }
}
