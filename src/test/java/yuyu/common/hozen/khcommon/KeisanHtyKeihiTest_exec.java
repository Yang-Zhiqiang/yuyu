package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.AbstractModule;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

/**
 * 必要経費計算クラスのメソッド {@link KeisanHtyKeihi#exec(String,C_Tuukasyu)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanHtyKeihiTest_exec {

    private final static String syoNo1 = "12806345672";

    private final static String syoNo2 = "12806345683";

    private final static String syoNo3 = "12806345694";

    private final static String syoNo4 = "12806345708";

    private final static String syoNo5 = "12806345719";

    @Inject
    private KeisanHtyKeihi keisanHtyKeihi;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_必要経費計算";

    private final static String sheetName = "テストデータ";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(KeisanKihrkP.class).to(KeisanKihrkPMock.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {

        KeisanKihrkPMock.caller = KeisanHtyKeihiTest_exec.class;
    }

    @AfterClass
    public static void testClear() {

        KeisanKihrkPMock.caller = null;
        KeisanKihrkPMock.SYORIPTN = null;
        MockObjectManager.initialize();
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(KeisanHtyKeihiTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        MockObjectManager.initialize();
        KeisanKihrkPMock.SYORIPTN = KeisanKihrkPMock.TESTPATTERN1;

        C_ErrorKbn errorKbn = keisanHtyKeihi.exec(syoNo1, C_Tuukasyu.JPY);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanHtyKeihi.getHtyKeihi(), BizCurrency.valueOf(0), "必要経費（契約通貨）");
        exBooleanEquals(keisanHtyKeihi.getHtyKeihi().getType() == BizCurrencyTypes.YEN, true, "通貨タイプ");
        exBizCalcbleEquals(keisanHtyKeihi.getYenHtyKeihi(), BizCurrency.valueOf(0), "必要経費（円貨）");
        exBooleanEquals(keisanHtyKeihi.getYenHtyKeihi().getType() == BizCurrencyTypes.YEN, true, "通貨タイプ");
        exBizCalcbleEquals(keisanHtyKeihi.getYenGenKykSyaHtyKeihi(), BizCurrency.valueOf(0), "現契約者必要経費（円貨）");
        exBooleanEquals(keisanHtyKeihi.getYenGenKykSyaHtyKeihi().getType() == BizCurrencyTypes.YEN, true, "通貨タイプ");
        exNumericEquals(keisanHtyKeihi.getKykSyaHenkouKaisuu(), 3, "契約者変更回数");

        exStringEquals((String) MockObjectManager.getArgument(KeisanKihrkPMock.class, "exec", 0, 0), "12806345672", "証券番号");
        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanKihrkPMock.class, "exec", 0, 1), C_Tuukasyu.JPY, "通貨種類");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        KeisanKihrkPMock.SYORIPTN = KeisanKihrkPMock.TESTPATTERN2;

        C_ErrorKbn errorKbn = keisanHtyKeihi.exec(syoNo2, C_Tuukasyu.JPY);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanHtyKeihi.getHtyKeihi(), BizCurrency.valueOf(0), "必要経費（契約通貨）");
        exBooleanEquals(keisanHtyKeihi.getHtyKeihi().getType() == BizCurrencyTypes.YEN, true, "通貨タイプ");
        exBizCalcbleEquals(keisanHtyKeihi.getYenHtyKeihi(), BizCurrency.valueOf(500), "必要経費（円貨）");
        exBooleanEquals(keisanHtyKeihi.getYenHtyKeihi().getType() == BizCurrencyTypes.YEN, true, "通貨タイプ");
        exBizCalcbleEquals(keisanHtyKeihi.getYenGenKykSyaHtyKeihi(), BizCurrency.valueOf(640), "現契約者必要経費（円貨）");
        exBooleanEquals(keisanHtyKeihi.getYenGenKykSyaHtyKeihi().getType() == BizCurrencyTypes.YEN, true, "通貨タイプ");
        exNumericEquals(keisanHtyKeihi.getKykSyaHenkouKaisuu(), 1, "契約者変更回数");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        KeisanKihrkPMock.SYORIPTN = KeisanKihrkPMock.TESTPATTERN3;

        C_ErrorKbn errorKbn = keisanHtyKeihi.exec(syoNo3, C_Tuukasyu.JPY);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanHtyKeihi.getHtyKeihi(), BizCurrency.valueOf(0), "必要経費（契約通貨）");
        exBooleanEquals(keisanHtyKeihi.getHtyKeihi().getType() == BizCurrencyTypes.YEN, true, "通貨タイプ");
        exBizCalcbleEquals(keisanHtyKeihi.getYenHtyKeihi(), BizCurrency.valueOf(0), "必要経費（円貨）");
        exBooleanEquals(keisanHtyKeihi.getYenHtyKeihi().getType() == BizCurrencyTypes.YEN, true, "通貨タイプ");
        exBizCalcbleEquals(keisanHtyKeihi.getYenGenKykSyaHtyKeihi(), BizCurrency.valueOf(0), "現契約者必要経費（円貨）");
        exBooleanEquals(keisanHtyKeihi.getYenGenKykSyaHtyKeihi().getType() == BizCurrencyTypes.YEN, true, "通貨タイプ");
        exNumericEquals(keisanHtyKeihi.getKykSyaHenkouKaisuu(), 1, "契約者変更回数");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        KeisanKihrkPMock.SYORIPTN = KeisanKihrkPMock.TESTPATTERN4;

        C_ErrorKbn errorKbn = keisanHtyKeihi.exec(syoNo4, C_Tuukasyu.JPY);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanHtyKeihi.getHtyKeihi(), BizCurrency.valueOf(0), "必要経費（契約通貨）");
        exBooleanEquals(keisanHtyKeihi.getHtyKeihi().getType() == BizCurrencyTypes.YEN, true, "通貨タイプ");
        exBizCalcbleEquals(keisanHtyKeihi.getYenHtyKeihi(), BizCurrency.valueOf(456), "必要経費（円貨）");
        exBooleanEquals(keisanHtyKeihi.getYenHtyKeihi().getType() == BizCurrencyTypes.YEN, true, "通貨タイプ");
        exBizCalcbleEquals(keisanHtyKeihi.getYenGenKykSyaHtyKeihi(), BizCurrency.valueOf(456), "現契約者必要経費（円貨）");
        exBooleanEquals(keisanHtyKeihi.getYenGenKykSyaHtyKeihi().getType() == BizCurrencyTypes.YEN, true, "通貨タイプ");
        exNumericEquals(keisanHtyKeihi.getKykSyaHenkouKaisuu(), 0, "契約者変更回数");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        KeisanKihrkPMock.SYORIPTN = KeisanKihrkPMock.TESTPATTERN5;

        C_ErrorKbn errorKbn = keisanHtyKeihi.exec(syoNo5, C_Tuukasyu.EUR);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanHtyKeihi.getHtyKeihi(), BizCurrency.valueOf(0, BizCurrencyTypes.EURO), "必要経費（契約通貨）");
        exBooleanEquals(keisanHtyKeihi.getHtyKeihi().getType() == BizCurrencyTypes.EURO, true, "通貨タイプ");
        exBizCalcbleEquals(keisanHtyKeihi.getYenHtyKeihi(), BizCurrency.valueOf(456), "必要経費（円貨）");
        exBooleanEquals(keisanHtyKeihi.getYenHtyKeihi().getType() == BizCurrencyTypes.YEN, true, "通貨タイプ");
        exBizCalcbleEquals(keisanHtyKeihi.getYenGenKykSyaHtyKeihi(), BizCurrency.valueOf(456), "現契約者必要経費（円貨）");
        exBooleanEquals(keisanHtyKeihi.getYenGenKykSyaHtyKeihi().getType() == BizCurrencyTypes.YEN, true, "通貨タイプ");
        exNumericEquals(keisanHtyKeihi.getKykSyaHenkouKaisuu(), 0, "契約者変更回数");
    }
}