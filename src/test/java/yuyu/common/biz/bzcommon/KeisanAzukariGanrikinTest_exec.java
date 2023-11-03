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
 * 預り元利金計算クラスのメソッド {@link KeisanAzukariGanrikin#exec(BizDate, BizDate, BizCurrency, C_Tuukasyu)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanAzukariGanrikinTest_exec {

    @Inject
    private KeisanAzukariGanrikin keisanAzukariGanrikin;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_預り元利金計算";

    private final static String sheetName = "INデータ";

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        MockObjectManager.initialize();
        C_ErrorKbn errorKbn = keisanAzukariGanrikin.exec(
            null,
            BizDate.valueOf(20181111),
            BizCurrency.valueOf(200000),
            C_Tuukasyu.JPY);
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        MockObjectManager.initialize();
        C_ErrorKbn errorKbn = keisanAzukariGanrikin.exec(
            BizDate.valueOf(20181111),
            null,
            BizCurrency.valueOf(200000, BizCurrencyTypes.AU_DOLLAR),
            C_Tuukasyu.AUD);
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        MockObjectManager.initialize();
        C_ErrorKbn errorKbn = keisanAzukariGanrikin.exec(
            BizDate.valueOf(20181111),
            BizDate.valueOf(20181111),
            null,
            C_Tuukasyu.JPY);
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        MockObjectManager.initialize();
        C_ErrorKbn errorKbn = keisanAzukariGanrikin.exec(
            BizDate.valueOf(20181111),
            BizDate.valueOf(20181111),
            BizCurrency.optional(),
            C_Tuukasyu.JPY);
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        MockObjectManager.initialize();
        C_ErrorKbn errorKbn = keisanAzukariGanrikin.exec(
            BizDate.valueOf(20181111),
            BizDate.valueOf(20181111),
            BizCurrency.valueOf(200000, BizCurrencyTypes.DOLLAR),
            null);
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        MockObjectManager.initialize();
        C_ErrorKbn errorKbn = keisanAzukariGanrikin.exec(
            BizDate.valueOf(20181111),
            BizDate.valueOf(20181111),
            BizCurrency.valueOf(200000, BizCurrencyTypes.DOLLAR),
            C_Tuukasyu.BLNK);
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        MockObjectManager.initialize();
        C_ErrorKbn errorKbn = keisanAzukariGanrikin.exec(
            BizDate.valueOf(20181111),
            BizDate.valueOf(20181113),
            BizCurrency.valueOf(0),
            C_Tuukasyu.JPY);
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanAzukariGanrikin.getAzukariGanrikinKyktuuka(), null, "預り元利金（契約通貨）");
        exBizCalcbleEquals(keisanAzukariGanrikin.getAzukariGanrikinYen(), BizCurrency.valueOf(0), "預り元利金（円貨）");
        exDateEquals(keisanAzukariGanrikin.getTyokuzenAzukariOutouYmd(), BizDate.valueOf(20181111), "直前預り応当日");
        exBizCalcbleEquals(keisanAzukariGanrikin.getTyokuzenAzukarikin(), BizCurrency.valueOf(0), "直前預り金");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        MockObjectManager.initialize();
        C_ErrorKbn errorKbn = keisanAzukariGanrikin.exec(
            BizDate.valueOf(20181111),
            BizDate.valueOf(20181113),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR),
            C_Tuukasyu.USD);
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanAzukariGanrikin.getAzukariGanrikinKyktuuka(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "預り元利金（契約通貨）");
        exBizCalcbleEquals(keisanAzukariGanrikin.getAzukariGanrikinYen(), null, "預り元利金（円貨）");
        exDateEquals(keisanAzukariGanrikin.getTyokuzenAzukariOutouYmd(), BizDate.valueOf(20181111), "直前預り応当日");
        exBizCalcbleEquals(keisanAzukariGanrikin.getTyokuzenAzukarikin(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "直前預り金");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        MockObjectManager.initialize();
        C_ErrorKbn errorKbn = keisanAzukariGanrikin.exec(
            BizDate.valueOf(20181111),
            BizDate.valueOf(20181110),
            BizCurrency.valueOf(200000),
            C_Tuukasyu.JPY);
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exBizCalcbleEquals(keisanAzukariGanrikin.getAzukariGanrikinKyktuuka(), null, "預り元利金（契約通貨）");
        exBizCalcbleEquals(keisanAzukariGanrikin.getAzukariGanrikinYen(), null, "預り元利金（円貨）");
        exDateEquals(keisanAzukariGanrikin.getTyokuzenAzukariOutouYmd(), null, "直前預り応当日");
        exBizCalcbleEquals(keisanAzukariGanrikin.getTyokuzenAzukarikin(), null, "直前預り金");
    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testExec_A10() {

        MockObjectManager.initialize();
        insertData("データ001");
        C_ErrorKbn errorKbn = keisanAzukariGanrikin.exec(
            BizDate.valueOf(20181111),
            BizDate.valueOf(20181112),
            BizCurrency.valueOf(200000),
            C_Tuukasyu.JPY);
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exBizCalcbleEquals(keisanAzukariGanrikin.getAzukariGanrikinKyktuuka(), null, "預り元利金（契約通貨）");
        exBizCalcbleEquals(keisanAzukariGanrikin.getAzukariGanrikinYen(), null, "預り元利金（円貨）");
        exDateEquals(keisanAzukariGanrikin.getTyokuzenAzukariOutouYmd(), null, "直前預り応当日");
        exBizCalcbleEquals(keisanAzukariGanrikin.getTyokuzenAzukarikin(), null, "直前預り金");
        deleteData();
    }

    @Test
    @TestOrder(110)
    @Transactional
    public void testExec_A11() {

        MockObjectManager.initialize();
        insertData("データ002");
        C_ErrorKbn errorKbn = keisanAzukariGanrikin.exec(
            BizDate.valueOf(20181111),
            BizDate.valueOf(20181113),
            BizCurrency.valueOf(200000),
            C_Tuukasyu.JPY);
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exBizCalcbleEquals(keisanAzukariGanrikin.getAzukariGanrikinKyktuuka(), null, "預り元利金（契約通貨）");
        exBizCalcbleEquals(keisanAzukariGanrikin.getAzukariGanrikinYen(), null, "預り元利金（円貨）");
        exDateEquals(keisanAzukariGanrikin.getTyokuzenAzukariOutouYmd(), null, "直前預り応当日");
        exBizCalcbleEquals(keisanAzukariGanrikin.getTyokuzenAzukarikin(), null, "直前預り金");
        deleteData();
    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {

        MockObjectManager.initialize();
        C_ErrorKbn errorKbn = keisanAzukariGanrikin.exec(
            BizDate.valueOf(20181111),
            BizDate.valueOf(20181111),
            BizCurrency.valueOf(200000),
            C_Tuukasyu.JPY);
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanAzukariGanrikin.getAzukariGanrikinKyktuuka(), null, "預り元利金（契約通貨）");
        exBizCalcbleEquals(keisanAzukariGanrikin.getAzukariGanrikinYen(), BizCurrency.valueOf(200000), "預り元利金（円貨）");
        exDateEquals(keisanAzukariGanrikin.getTyokuzenAzukariOutouYmd(), BizDate.valueOf(20181111), "直前預り応当日");
        exBizCalcbleEquals(keisanAzukariGanrikin.getTyokuzenAzukarikin(), BizCurrency.valueOf(200000), "直前預り金");
    }

    @Test
    @TestOrder(130)
    @Transactional
    public void testExec_A13() {

        MockObjectManager.initialize();
        insertData("データ003");
        C_ErrorKbn errorKbn = keisanAzukariGanrikin.exec(
            BizDate.valueOf(20181111),
            BizDate.valueOf(20181113),
            BizCurrency.valueOf(200000),
            C_Tuukasyu.JPY);
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanAzukariGanrikin.getAzukariGanrikinKyktuuka(), null, "預り元利金（契約通貨）");
        exBizCalcbleEquals(keisanAzukariGanrikin.getAzukariGanrikinYen(), BizCurrency.valueOf(200060), "預り元利金（円貨）");
        exDateEquals(keisanAzukariGanrikin.getTyokuzenAzukariOutouYmd(), BizDate.valueOf(20181111), "直前預り応当日");
        exBizCalcbleEquals(keisanAzukariGanrikin.getTyokuzenAzukarikin(), BizCurrency.valueOf(200000), "直前預り金");
        deleteData();
    }

    @Test
    @TestOrder(140)
    @Transactional
    public void testExec_A14() {

        MockObjectManager.initialize();
        insertData("データ004");
        C_ErrorKbn errorKbn = keisanAzukariGanrikin.exec(
            BizDate.valueOf(20160229),
            BizDate.valueOf(20190228),
            BizCurrency.valueOf(200000,BizCurrencyTypes.DOLLAR),
            C_Tuukasyu.USD);
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanAzukariGanrikin.getAzukariGanrikinKyktuuka(), BizCurrency.valueOf(215795.67,BizCurrencyTypes.DOLLAR), "預り元利金（契約通貨）");
        exBizCalcbleEquals(keisanAzukariGanrikin.getAzukariGanrikinYen(), null, "預り元利金（円貨）");
        exDateEquals(keisanAzukariGanrikin.getTyokuzenAzukariOutouYmd(), BizDate.valueOf(20190228), "直前預り応当日");
        exBizCalcbleEquals(keisanAzukariGanrikin.getTyokuzenAzukarikin(), BizCurrency.valueOf(210540.81,BizCurrencyTypes.DOLLAR), "直前預り金");
        deleteData();
    }

    private void insertData(String pDate) {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(KeisanAzukariGanrikinTest_exec.class, fileName, sheetName);
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
