package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
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
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FiSiyouKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_UnitFundKbn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 変額積立金計算クラスのメソッド {@link KeisanCV#exec(String, BizDate, C_Tuukasyu)} テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanCVTest_exec {

    @Inject
    private KeisanCV keisanCV;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_変額積立金計算";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(KeisanCVTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();


        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        bizDomManager.delete(bizDomManager.getAllFundIndexKihon());
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        String syoukenNo = "11806111366";

        BizDate calcKijyunYmd = BizDate.valueOf(20160301);

        C_Tuukasyu keiyakuTuukasyu = C_Tuukasyu.JPY;

        C_ErrorKbn resultKbn = keisanCV.exec(syoukenNo, calcKijyunYmd, keiyakuTuukasyu);

        exClassificationEquals(resultKbn, C_ErrorKbn.ERROR, "結果区分");

        exBizCalcbleEquals(keisanCV.getCV(), null, "変額積立金（契約単位）");
        exClassificationEquals(keisanCV.getFiSiyouKbn(), null, "ファンドインデックス使用区分");
        exListEquals(keisanCV.getCVBeanList(), null, "変額積立金BeanList");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        String syoukenNo = "12806111367";

        BizDate calcKijyunYmd = BizDate.valueOf(20160301);

        C_Tuukasyu keiyakuTuukasyu = C_Tuukasyu.JPY;

        C_ErrorKbn resultKbn = keisanCV.exec(syoukenNo, calcKijyunYmd, keiyakuTuukasyu);

        exClassificationEquals(resultKbn, C_ErrorKbn.ERROR, "結果区分");

        exBizCalcbleEquals(keisanCV.getCV(), null, "変額積立金（契約単位）");
        exClassificationEquals(keisanCV.getFiSiyouKbn(), null, "ファンドインデックス使用区分");
        exListEquals(keisanCV.getCVBeanList(), null, "変額積立金BeanList");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        String syoukenNo = "13806111368";

        BizDate calcKijyunYmd = BizDate.valueOf(20160801);

        C_Tuukasyu keiyakuTuukasyu = C_Tuukasyu.USD;

        C_ErrorKbn resultKbn = keisanCV.exec(syoukenNo, calcKijyunYmd, keiyakuTuukasyu);

        exClassificationEquals(resultKbn, C_ErrorKbn.ERROR, "結果区分");

        exBizCalcbleEquals(keisanCV.getCV(), null, "変額積立金（契約単位）");
        exClassificationEquals(keisanCV.getFiSiyouKbn(), null, "ファンドインデックス使用区分");
        exListEquals(keisanCV.getCVBeanList(), null, "変額積立金BeanList");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        String syoukenNo = "14806111369";

        BizDate calcKijyunYmd = BizDate.valueOf(20160301);

        C_Tuukasyu keiyakuTuukasyu = C_Tuukasyu.JPY;

        C_ErrorKbn resultKbn = keisanCV.exec(syoukenNo, calcKijyunYmd, keiyakuTuukasyu);

        exClassificationEquals(resultKbn, C_ErrorKbn.OK, "結果区分");

        exBizCalcbleEquals(keisanCV.getCV(), BizCurrency.valueOf(123456790, BizCurrencyTypes.YEN), "変額積立金（契約単位）");
        exBooleanEquals(keisanCV.getCV().getType() == BizCurrencyTypes.YEN, true, "変額積立金（契約単位）の通貨タイプ");
        exClassificationEquals(keisanCV.getFiSiyouKbn(), C_FiSiyouKbn.TJTMATU, "ファンドインデックス使用区分");

        exClassificationEquals(keisanCV.getCVBeanList().get(0).getUnitFundKbn(), C_UnitFundKbn.EURFUND, "ユニットファンド区分");
        exBizCalcbleEquals(keisanCV.getCVBeanList().get(0).getUnitSuu(), BizNumber.valueOf(123456789.5432), "ユニット数");
        exDateEquals(keisanCV.getCVBeanList().get(0).getUnitKouryokuhasseiYmd(), BizDate.valueOf(20160301), "ユニット効力発生日");
        exBizCalcbleEquals(keisanCV.getCVBeanList().get(0).getFundIndex(), BizNumber.valueOf(1), "ファンドインデックス");
        exDateEquals(keisanCV.getCVBeanList().get(0).getFundHyoukaYmd(), BizDate.valueOf(20160301), "ファンド評価年月日");
        exBizCalcbleEquals(keisanCV.getCVBeanList().get(0).getFundBetuTumitatekin(),
            BizCurrency.valueOf(123456790, BizCurrencyTypes.YEN),
            "ファンド別積立金");
        exBooleanEquals(keisanCV.getCVBeanList().get(0).getFundBetuTumitatekin().getType() == BizCurrencyTypes.YEN,
            true, "ファンド別積立金の通貨タイプ");
        exNumericEquals(keisanCV.getCVBeanList().get(0).getWariAi(), 999, "割合");
        exClassificationEquals(keisanCV.getCVBeanList().get(0).getHistoryFlag(), C_UmuKbn.NONE, "履歴フラグ");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        String syoukenNo = "15806111360";

        BizDate calcKijyunYmd = BizDate.valueOf(20160301);

        C_Tuukasyu keiyakuTuukasyu = C_Tuukasyu.USD;

        C_ErrorKbn resultKbn = keisanCV.exec(syoukenNo, calcKijyunYmd, keiyakuTuukasyu);

        exClassificationEquals(resultKbn, C_ErrorKbn.OK, "結果区分");

        exBizCalcbleEquals(keisanCV.getCV(), BizCurrency.valueOf(1612, BizCurrencyTypes.DOLLAR), "変額積立金（契約単位）");
        exBooleanEquals(keisanCV.getCV().getType() == BizCurrencyTypes.DOLLAR, true, "変額積立金（契約単位）の通貨タイプ");
        exClassificationEquals(keisanCV.getFiSiyouKbn(), C_FiSiyouKbn.TJTSI, "ファンドインデックス使用区分");

        exClassificationEquals(keisanCV.getCVBeanList().get(0).getUnitFundKbn(), C_UnitFundKbn.USDFUND, "ユニットファンド区分");
        exBizCalcbleEquals(keisanCV.getCVBeanList().get(0).getUnitSuu(), BizNumber.valueOf(15), "ユニット数");
        exDateEquals(keisanCV.getCVBeanList().get(0).getUnitKouryokuhasseiYmd(), BizDate.valueOf(20160229), "ユニット効力発生日");
        exBizCalcbleEquals(keisanCV.getCVBeanList().get(0).getFundIndex(), BizNumber.valueOf(5.02),
            "ファンドインデックス");
        exDateEquals(keisanCV.getCVBeanList().get(0).getFundHyoukaYmd(), BizDate.valueOf(20160301), "ファンド評価年月日");
        exBizCalcbleEquals(keisanCV.getCVBeanList().get(0).getFundBetuTumitatekin(),
            BizCurrency.valueOf(76, BizCurrencyTypes.DOLLAR),
            "ファンド別積立金");
        exBooleanEquals(keisanCV.getCVBeanList().get(0).getFundBetuTumitatekin().getType() == BizCurrencyTypes.DOLLAR,
            true, "ファンド別積立金の通貨タイプ");
        exNumericEquals(keisanCV.getCVBeanList().get(0).getWariAi(), 151, "割合");
        exClassificationEquals(keisanCV.getCVBeanList().get(0).getHistoryFlag(), C_UmuKbn.ARI, "履歴フラグ");

        exClassificationEquals(keisanCV.getCVBeanList().get(1).getUnitFundKbn(), C_UnitFundKbn.EURFUND, "ユニットファンド区分");
        exBizCalcbleEquals(keisanCV.getCVBeanList().get(1).getUnitSuu(), BizNumber.valueOf(15), "ユニット数");
        exDateEquals(keisanCV.getCVBeanList().get(1).getUnitKouryokuhasseiYmd(), BizDate.valueOf(20160229), "ユニット効力発生日");
        exBizCalcbleEquals(keisanCV.getCVBeanList().get(1).getFundIndex(), BizNumber.valueOf(1.0),
            "ファンドインデックス");
        exDateEquals(keisanCV.getCVBeanList().get(1).getFundHyoukaYmd(), BizDate.valueOf(20160301), "ファンド評価年月日");
        exBizCalcbleEquals(keisanCV.getCVBeanList().get(1).getFundBetuTumitatekin(),
            BizCurrency.valueOf(15, BizCurrencyTypes.DOLLAR),
            "ファンド別積立金");
        exBooleanEquals(keisanCV.getCVBeanList().get(1).getFundBetuTumitatekin().getType() == BizCurrencyTypes.DOLLAR,
            true, "ファンド別積立金の通貨タイプ");
        exNumericEquals(keisanCV.getCVBeanList().get(1).getWariAi(), 152, "割合");
        exClassificationEquals(keisanCV.getCVBeanList().get(1).getHistoryFlag(), C_UmuKbn.ARI, "履歴フラグ");

        exClassificationEquals(keisanCV.getCVBeanList().get(2).getUnitFundKbn(), C_UnitFundKbn.AUDFUND, "ユニットファンド区分");
        exBizCalcbleEquals(keisanCV.getCVBeanList().get(2).getUnitSuu(), BizNumber.valueOf(15.2016), "ユニット数");
        exDateEquals(keisanCV.getCVBeanList().get(2).getUnitKouryokuhasseiYmd(), BizDate.valueOf(20160229), "ユニット効力発生日");
        exBizCalcbleEquals(keisanCV.getCVBeanList().get(2).getFundIndex(), BizNumber.valueOf(100.0123456789),
            "ファンドインデックス");
        exDateEquals(keisanCV.getCVBeanList().get(2).getFundHyoukaYmd(), BizDate.valueOf(20160301), "ファンド評価年月日");
        exBizCalcbleEquals(keisanCV.getCVBeanList().get(2).getFundBetuTumitatekin(),
            BizCurrency.valueOf(1521, BizCurrencyTypes.DOLLAR),
            "ファンド別積立金");
        exBooleanEquals(keisanCV.getCVBeanList().get(2).getFundBetuTumitatekin().getType() == BizCurrencyTypes.DOLLAR,
            true, "ファンド別積立金の通貨タイプ");
        exNumericEquals(keisanCV.getCVBeanList().get(2).getWariAi(), 121, "割合");
        exClassificationEquals(keisanCV.getCVBeanList().get(2).getHistoryFlag(), C_UmuKbn.NONE, "履歴フラグ");
    }
}
