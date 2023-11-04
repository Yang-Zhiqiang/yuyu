package yuyu.common.biz.bzcommon;

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
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

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
 * 預り元利金計算クラスのメソッド {@link KeisanAzukariGanrikin#exec(String, BizDate, C_Tuukasyu)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanAzukariGanrikinTest_exec2 {

    @Inject
    private KeisanAzukariGanrikin keisanAzukariGanrikin;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_預り元利金計算";

    private final static String sheetName = "INデータ";

    @Test
    @TestOrder(10)
    public void testExec2_A1() {

        MockObjectManager.initialize();
        C_ErrorKbn errorKbn = keisanAzukariGanrikin.exec(
            "17808102506",
            BizDate.valueOf(20181113),
            C_Tuukasyu.USD);
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanAzukariGanrikin.getAzukariGanrikinKyktuuka(), BizCurrency.valueOf(0,BizCurrencyTypes.DOLLAR), "預り元利金（契約通貨）");
        exBizCalcbleEquals(keisanAzukariGanrikin.getAzukariGanrikinYen(), BizCurrency.valueOf(0), "預り元利金（円貨）");
        exDateEquals(keisanAzukariGanrikin.getTyokuzenAzukariOutouYmd(), null, "直前預り応当日");
        exBizCalcbleEquals(keisanAzukariGanrikin.getTyokuzenAzukarikin(), null, "直前預り金");
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testExec2_A2() {

        MockObjectManager.initialize();
        insertData("データ005");
        C_ErrorKbn errorKbn = keisanAzukariGanrikin.exec(
            "17808100010",
            BizDate.valueOf(20181113),
            C_Tuukasyu.USD);
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exBizCalcbleEquals(keisanAzukariGanrikin.getAzukariGanrikinKyktuuka(), BizCurrency.valueOf(0,BizCurrencyTypes.DOLLAR), "預り元利金（契約通貨）");
        exBizCalcbleEquals(keisanAzukariGanrikin.getAzukariGanrikinYen(), BizCurrency.valueOf(0), "預り元利金（円貨）");
        exDateEquals(keisanAzukariGanrikin.getTyokuzenAzukariOutouYmd(), null, "直前預り応当日");
        exBizCalcbleEquals(keisanAzukariGanrikin.getTyokuzenAzukarikin(), null, "直前預り金");
        deleteData();
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testExec2_A3() {

        MockObjectManager.initialize();
        insertData("データ005");
        C_ErrorKbn errorKbn = keisanAzukariGanrikin.exec(
            "17808100010",
            BizDate.valueOf(20181111),
            C_Tuukasyu.JPY);
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanAzukariGanrikin.getAzukariGanrikinKyktuuka(), BizCurrency.valueOf(0), "預り元利金（契約通貨）");
        exBizCalcbleEquals(keisanAzukariGanrikin.getAzukariGanrikinYen(), BizCurrency.valueOf(200000), "預り元利金（円貨）");
        exDateEquals(keisanAzukariGanrikin.getTyokuzenAzukariOutouYmd(), BizDate.valueOf(20181111), "直前預り応当日");
        exBizCalcbleEquals(keisanAzukariGanrikin.getTyokuzenAzukarikin(), BizCurrency.valueOf(200000), "直前預り金");
        deleteData();
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testExec2_A4() {

        MockObjectManager.initialize();
        insertData("データ005");
        C_ErrorKbn errorKbn = keisanAzukariGanrikin.exec(
            "17808100010",
            BizDate.valueOf(20181111),
            C_Tuukasyu.USD);
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanAzukariGanrikin.getAzukariGanrikinKyktuuka(), BizCurrency.valueOf(0,BizCurrencyTypes.DOLLAR), "預り元利金（契約通貨）");
        exBizCalcbleEquals(keisanAzukariGanrikin.getAzukariGanrikinYen(), BizCurrency.valueOf(200000), "預り元利金（円貨）");
        exDateEquals(keisanAzukariGanrikin.getTyokuzenAzukariOutouYmd(), BizDate.valueOf(20181111), "直前預り応当日");
        exBizCalcbleEquals(keisanAzukariGanrikin.getTyokuzenAzukarikin(), BizCurrency.valueOf(200000), "直前預り金");
        deleteData();
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testExec2_A5() {

        MockObjectManager.initialize();
        insertData("データ006");
        C_ErrorKbn errorKbn = keisanAzukariGanrikin.exec(
            "17808102470",
            BizDate.valueOf(20190228),
            C_Tuukasyu.USD);
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanAzukariGanrikin.getAzukariGanrikinKyktuuka(), BizCurrency.valueOf(43.17,BizCurrencyTypes.DOLLAR), "預り元利金（契約通貨）");
        exBizCalcbleEquals(keisanAzukariGanrikin.getAzukariGanrikinYen(), BizCurrency.valueOf(6478), "預り元利金（円貨）");
        exDateEquals(keisanAzukariGanrikin.getTyokuzenAzukariOutouYmd(), BizDate.valueOf(20190228), "直前預り応当日");
        exBizCalcbleEquals(keisanAzukariGanrikin.getTyokuzenAzukarikin(), BizCurrency.valueOf(4214), "直前預り金");
        deleteData();
    }

    private void insertData(String pDate) {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(KeisanAzukariGanrikinTest_exec2.class, fileName, sheetName);
            testDataMaker.insDataByDataId(pDate, testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    private void deleteData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllAzukariRiritu());
    }
}
