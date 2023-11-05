package yuyu.common.siharai.sicommon;

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
import jp.co.slcs.swak.number.currencytype.CurrencyType;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.bzcommon.SetNenreiMock;
import yuyu.common.hozen.khcommon.SetOutoubiMock;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_JydkgmbHkKsnKbn;
import yuyu.def.classification.C_TykzentykgoKbn;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 重度介護前払保険金額計算のメソッド{@link CalcJdkghkKngk#exec()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CalcJdkghkKngkTest_exec {

    @Inject
    private CalcJdkghkKngk calcJdkghkKngk;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_重度介護前払保険金額計算";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(CalcJdkghkKngkTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);
        siharaiDomManager.delete(siharaiDomManager.getAllJyudkaigomebrtkWrbkkkn());
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(
            C_JydkgmbHkKsnKbn.NENREISITEI,
            null,
            BizCurrency.valueOf(2000),
            BizNumber.valueOf(0.5),
            BizDate.valueOf("20161010"),
            BizDate.valueOf("20161010"),
            BizDate.valueOf("20010101"),
            30,
            C_Hhknsei.MALE);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngk.getCalcJdkghkKngkBean().getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(0), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngk.getCalcJdkghkKngkBean().getJdkghkKnGk(), BizCurrency.valueOf(0), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngk.getCalcJdkghkKngkBean().getWaribikiKikan(), BizNumber.valueOf(0), "割引期間");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(
            C_JydkgmbHkKsnKbn.NENREISITEI,
            BizCurrency.valueOf(1000),
            BizCurrency.valueOf(2000),
            null,
            BizDate.valueOf("20161010"),
            BizDate.valueOf("20161010"),
            BizDate.valueOf("20010101"),
            30,
            C_Hhknsei.MALE);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngk.getCalcJdkghkKngkBean().getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(0), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngk.getCalcJdkghkKngkBean().getJdkghkKnGk(), BizCurrency.valueOf(0), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngk.getCalcJdkghkKngkBean().getWaribikiKikan(), BizNumber.valueOf(0), "割引期間");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(
            C_JydkgmbHkKsnKbn.KIJUNBISITEI,
            BizCurrency.valueOf(1000),
            BizCurrency.valueOf(2000),
            BizNumber.valueOf(0.5),
            null,
            BizDate.valueOf("20160101"),
            BizDate.valueOf("20010101"),
            30,
            C_Hhknsei.MALE);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngk.getCalcJdkghkKngkBean().getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(0), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngk.getCalcJdkghkKngkBean().getJdkghkKnGk(), BizCurrency.valueOf(0), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngk.getCalcJdkghkKngkBean().getWaribikiKikan(), BizNumber.valueOf(0), "割引期間");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(
            C_JydkgmbHkKsnKbn.KIJUNBISITEI,
            BizCurrency.valueOf(1000),
            BizCurrency.valueOf(2000),
            BizNumber.valueOf(0.5),
            BizDate.valueOf("20161010"),
            null,
            BizDate.valueOf("20010101"),
            30,
            C_Hhknsei.MALE);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngk.getCalcJdkghkKngkBean().getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(0), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngk.getCalcJdkghkKngkBean().getJdkghkKnGk(), BizCurrency.valueOf(0), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngk.getCalcJdkghkKngkBean().getWaribikiKikan(), BizNumber.valueOf(0), "割引期間");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(
            C_JydkgmbHkKsnKbn.KIJUNBISITEI,
            BizCurrency.valueOf(1000),
            BizCurrency.valueOf(2000),
            BizNumber.valueOf(0.5),
            BizDate.valueOf("20161010"),
            BizDate.valueOf("20161010"),
            null,
            30,
            C_Hhknsei.MALE);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngk.getCalcJdkghkKngkBean().getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(0), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngk.getCalcJdkghkKngkBean().getJdkghkKnGk(), BizCurrency.valueOf(0), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngk.getCalcJdkghkKngkBean().getWaribikiKikan(), BizNumber.valueOf(0), "割引期間");
    }

    @Test
    @TestOrder(55)
    public void testExec_A16() {

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(
            C_JydkgmbHkKsnKbn.KIJUNBISITEI,
            BizCurrency.valueOf(1000),
            BizCurrency.valueOf(2000),
            BizNumber.valueOf(0.5),
            BizDate.valueOf("20161010"),
            BizDate.valueOf("20161009"),
            BizDate.valueOf("19601010"),
            null,
            C_Hhknsei.MALE);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngk.getCalcJdkghkKngkBean().getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(0), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngk.getCalcJdkghkKngkBean().getJdkghkKnGk(), BizCurrency.valueOf(0), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngk.getCalcJdkghkKngkBean().getWaribikiKikan(), BizNumber.valueOf(0), "割引期間");
    }


    @Test
    @TestOrder(60)
    public void testExec_A6() {

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(
            C_JydkgmbHkKsnKbn.NENREISITEI,
            BizCurrency.valueOf(1000),
            BizCurrency.valueOf(2000),
            BizNumber.valueOf(0.5),
            BizDate.valueOf("20161010"),
            BizDate.valueOf("20161010"),
            BizDate.valueOf("20010101"),
            null,
            C_Hhknsei.MALE);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngk.getCalcJdkghkKngkBean().getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(0), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngk.getCalcJdkghkKngkBean().getJdkghkKnGk(), BizCurrency.valueOf(0), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngk.getCalcJdkghkKngkBean().getWaribikiKikan(), BizNumber.valueOf(0), "割引期間");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(
            C_JydkgmbHkKsnKbn.NENREISITEI,
            BizCurrency.valueOf(1000),
            BizCurrency.valueOf(2000),
            BizNumber.valueOf(0.5),
            BizDate.valueOf("20161010"),
            BizDate.valueOf("20161010"),
            BizDate.valueOf("20010101"),
            77,
            C_Hhknsei.BLNK);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngk.getCalcJdkghkKngkBean().getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(0), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngk.getCalcJdkghkKngkBean().getJdkghkKnGk(), BizCurrency.valueOf(0), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngk.getCalcJdkghkKngkBean().getWaribikiKikan(), BizNumber.valueOf(0), "割引期間");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(
            C_JydkgmbHkKsnKbn.KIJUNBISITEI,
            BizCurrency.valueOf(1000),
            BizCurrency.valueOf(2000),
            BizNumber.valueOf(0.5),
            BizDate.valueOf("20171010"),
            BizDate.valueOf("20231010"),
            BizDate.valueOf("19601010"),
            null,
            C_Hhknsei.FEMALE);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngk.getCalcJdkghkKngkBean().getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(0), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngk.getCalcJdkghkKngkBean().getJdkghkKnGk(), BizCurrency.valueOf(0), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngk.getCalcJdkghkKngkBean().getWaribikiKikan(), BizNumber.valueOf(0), "割引期間");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMock.class, "exec", 0, 0), BizDate.valueOf("20171010"), "基準日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMock.class, "exec", 0, 1), BizDate.valueOf("19601010"), "生年月日");

        exClassificationEquals((C_TykzentykgoKbn)MockObjectManager.getArgument(SetOutoubiMock.class, "exec", 0, 0), C_TykzentykgoKbn.TYKGO, "直前直後区分");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetOutoubiMock.class, "exec", 0, 1), BizDate.valueOf("20171010"), "基準日");
        exClassificationEquals((C_Hrkkaisuu)MockObjectManager.getArgument(SetOutoubiMock.class, "exec", 0, 2), C_Hrkkaisuu.NEN, "払込回数");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetOutoubiMock.class, "exec", 0, 3), BizDate.valueOf("20171010"), "判定日");

        exClassificationEquals((C_TykzentykgoKbn)MockObjectManager.getArgument(SetOutoubiMock.class, "exec", 1, 0), C_TykzentykgoKbn.TYKGO, "直前直後区分");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetOutoubiMock.class, "exec", 1, 1), BizDate.valueOf("20171010"), "基準日");
        exClassificationEquals((C_Hrkkaisuu)MockObjectManager.getArgument(SetOutoubiMock.class, "exec", 1, 2), C_Hrkkaisuu.NEN, "払込回数");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetOutoubiMock.class, "exec", 1, 3), BizDate.valueOf("20181010"), "判定日");

    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(
            C_JydkgmbHkKsnKbn.NENREISITEI,
            BizCurrency.valueOf(10000000),
            BizCurrency.valueOf(1111111),
            BizNumber.valueOf(0.5),
            null,
            null,
            null,
            77,
            C_Hhknsei.MALE);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngk.getCalcJdkghkKngkBean().getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(1487206), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngk.getCalcJdkghkKngkBean().getJdkghkKnGk(), BizCurrency.valueOf(1487206), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngk.getCalcJdkghkKngkBean().getWaribikiKikan(), BizNumber.valueOf(4.7), "割引期間");
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(
            C_JydkgmbHkKsnKbn.KIJUNBISITEI,
            BizCurrency.valueOf(10000000),
            BizCurrency.valueOf(3333333),
            BizNumber.valueOf(0.5),
            BizDate.valueOf(20171010),
            BizDate.valueOf(20171010),
            BizDate.valueOf(19400101),
            null,
            C_Hhknsei.MALE);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngk.getCalcJdkghkKngkBean().getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(1487206), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngk.getCalcJdkghkKngkBean().getJdkghkKnGk(), BizCurrency.valueOf(3333333), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngk.getCalcJdkghkKngkBean().getWaribikiKikan(), BizNumber.valueOf(4.7), "割引期間");
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(
            C_JydkgmbHkKsnKbn.KIJUNBISITEI,
            BizCurrency.valueOf(10000000),
            BizCurrency.valueOf(5000000),
            BizNumber.valueOf(3),
            BizDate.valueOf(20190707),
            BizDate.valueOf(20370707),
            BizDate.valueOf(19290901),
            null,
            C_Hhknsei.FEMALE);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngk.getCalcJdkghkKngkBean().getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(5000000), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngk.getCalcJdkghkKngkBean().getJdkghkKnGk(), BizCurrency.valueOf(5000000), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngk.getCalcJdkghkKngkBean().getWaribikiKikan(), BizNumber.valueOf(0.5), "割引期間");
    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(
            C_JydkgmbHkKsnKbn.KIJUNBISITEI,
            BizCurrency.valueOf(10000000),
            BizCurrency.valueOf(3333333),
            BizNumber.valueOf(0.2),
            BizDate.valueOf(20200101),
            BizDate.valueOf(20401231),
            BizDate.valueOf(19750707),
            null,
            C_Hhknsei.MALE);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngk.getCalcJdkghkKngkBean().getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(2412050), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngk.getCalcJdkghkKngkBean().getJdkghkKnGk(), BizCurrency.valueOf(3333333), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngk.getCalcJdkghkKngkBean().getWaribikiKikan(), BizNumber.valueOf(7.8), "割引期間");
    }

    @Test
    @TestOrder(130)
    public void testExec_A13() {

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(
            C_JydkgmbHkKsnKbn.KIJUNBISITEI,
            BizCurrency.valueOf(100000.11, BizCurrencyTypes.DOLLAR),
            BizCurrency.valueOf(33333.33, BizCurrencyTypes.DOLLAR),
            BizNumber.valueOf(0.1),
            BizDate.valueOf(20211202),
            BizDate.valueOf(20400402),
            BizDate.valueOf(19750101),
            null,
            C_Hhknsei.FEMALE);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngk.getCalcJdkghkKngkBean().getJdkghkKnGkCompareBefore(),
            BizCurrency.valueOf(24869.51, BizCurrencyTypes.DOLLAR), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngk.getCalcJdkghkKngkBean().getJdkghkKnGk(),
            BizCurrency.valueOf(33333.33, BizCurrencyTypes.DOLLAR), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngk.getCalcJdkghkKngkBean().getWaribikiKikan(), BizNumber.valueOf(14.6), "割引期間");
    }

    @Test
    @TestOrder(140)
    public void testExec_A14() {

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(
            C_JydkgmbHkKsnKbn.KIJUNBISITEI,
            BizCurrency.valueOf(100000.22, BizCurrencyTypes.AU_DOLLAR),
            BizCurrency.valueOf(22222.22, BizCurrencyTypes.AU_DOLLAR),
            BizNumber.valueOf(0.1),
            BizDate.valueOf(20200229),
            BizDate.valueOf(20400303),
            BizDate.valueOf(19400229),
            null,
            C_Hhknsei.MALE);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngk.getCalcJdkghkKngkBean().getJdkghkKnGkCompareBefore(),
            BizCurrency.valueOf(90909.29, BizCurrencyTypes.AU_DOLLAR), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngk.getCalcJdkghkKngkBean().getJdkghkKnGk(),
            BizCurrency.valueOf(90909.29, BizCurrencyTypes.AU_DOLLAR), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngk.getCalcJdkghkKngkBean().getWaribikiKikan(), BizNumber.valueOf(1), "割引期間");
    }

    @Test
    @TestOrder(150)
    public void testExec_A15() {

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(
            C_JydkgmbHkKsnKbn.KIJUNBISITEI,
            BizCurrency.valueOf(100000.33, BizCurrencyTypes.EURO),
            BizCurrency.valueOf(11111.11, BizCurrencyTypes.EURO),
            BizNumber.valueOf(0.2468),
            BizDate.valueOf(20200229),
            BizDate.valueOf(20400101),
            BizDate.valueOf(19400229),
            null,
            C_Hhknsei.FEMALE);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngk.getCalcJdkghkKngkBean().getJdkghkKnGkCompareBefore(),
            BizCurrency.valueOf(70262.98, BizCurrencyTypes.EURO), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngk.getCalcJdkghkKngkBean().getJdkghkKnGk(),
            BizCurrency.valueOf(70262.98, BizCurrencyTypes.EURO), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngk.getCalcJdkghkKngkBean().getWaribikiKikan(), BizNumber.valueOf(1.6), "割引期間");
    }
    @Test
    @TestOrder(2001)
    public void testExec_B1() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20200228");
        BizDate calckijyunymd = BizDate.valueOf("20400228");
        BizDate hhknseiymd = BizDate.valueOf("19600228");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(917855.42, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(917855.42, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(6.9), "割引期間");
    }
    @Test
    @TestOrder(2002)
    public void testExec_B2() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20200228");
        BizDate calckijyunymd = BizDate.valueOf("20400229");
        BizDate hhknseiymd = BizDate.valueOf("19600228");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(917855.42, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(917855.42, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(6.9), "割引期間");
    }
    @Test
    @TestOrder(2003)
    public void testExec_B3() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20200228");
        BizDate calckijyunymd = BizDate.valueOf("20400301");
        BizDate hhknseiymd = BizDate.valueOf("19600228");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(917855.42, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(917855.42, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(6.9), "割引期間");
    }
    @Test
    @TestOrder(2004)
    public void testExec_B4() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20200228");
        BizDate calckijyunymd = BizDate.valueOf("20500228");
        BizDate hhknseiymd = BizDate.valueOf("19600228");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(958642.96, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(958642.96, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(3.4), "割引期間");
    }
    @Test
    @TestOrder(2005)
    public void testExec_B5() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20200228");
        BizDate calckijyunymd = BizDate.valueOf("20500301");
        BizDate hhknseiymd = BizDate.valueOf("19600228");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(958642.96, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(958642.96, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(3.4), "割引期間");
    }
    @Test
    @TestOrder(2006)
    public void testExec_B6() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20200229");
        BizDate calckijyunymd = BizDate.valueOf("20400228");
        BizDate hhknseiymd = BizDate.valueOf("19600228");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(913305.90, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(913305.90, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(7.3), "割引期間");
    }
    @Test
    @TestOrder(2007)
    public void testExec_B7() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20200229");
        BizDate calckijyunymd = BizDate.valueOf("20400229");
        BizDate hhknseiymd = BizDate.valueOf("19600228");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(917855.42, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(917855.42, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(6.9), "割引期間");
    }
    @Test
    @TestOrder(2008)
    public void testExec_B8() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20200229");
        BizDate calckijyunymd = BizDate.valueOf("20400301");
        BizDate hhknseiymd = BizDate.valueOf("19600228");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(917855.42, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(917855.42, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(6.9), "割引期間");
    }
    @Test
    @TestOrder(2009)
    public void testExec_B9() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20200229");
        BizDate calckijyunymd = BizDate.valueOf("20500228");
        BizDate hhknseiymd = BizDate.valueOf("19600228");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(958642.96, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(958642.96, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(3.4), "割引期間");
    }
    @Test
    @TestOrder(2010)
    public void testExec_B10() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20200229");
        BizDate calckijyunymd = BizDate.valueOf("20500301");
        BizDate hhknseiymd = BizDate.valueOf("19600228");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(958642.96, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(958642.96, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(3.4), "割引期間");
    }
    @Test
    @TestOrder(2011)
    public void testExec_B11() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20200301");
        BizDate calckijyunymd = BizDate.valueOf("20400228");
        BizDate hhknseiymd = BizDate.valueOf("19600228");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(913305.90, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(913305.90, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(7.3), "割引期間");
    }
    @Test
    @TestOrder(2012)
    public void testExec_B12() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20200301");
        BizDate calckijyunymd = BizDate.valueOf("20400229");
        BizDate hhknseiymd = BizDate.valueOf("19600228");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(913305.90, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(913305.90, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(7.3), "割引期間");
    }
    @Test
    @TestOrder(2013)
    public void testExec_B13() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20200301");
        BizDate calckijyunymd = BizDate.valueOf("20400301");
        BizDate hhknseiymd = BizDate.valueOf("19600228");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(917855.42, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(917855.42, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(6.9), "割引期間");
    }
    @Test
    @TestOrder(2014)
    public void testExec_B14() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20200301");
        BizDate calckijyunymd = BizDate.valueOf("20500228");
        BizDate hhknseiymd = BizDate.valueOf("19600228");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(955076.98, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(955076.98, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(3.7), "割引期間");
    }
    @Test
    @TestOrder(2015)
    public void testExec_B15() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20200301");
        BizDate calckijyunymd = BizDate.valueOf("20500301");
        BizDate hhknseiymd = BizDate.valueOf("19600228");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(958642.96, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(958642.96, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(3.4), "割引期間");
    }
    @Test
    @TestOrder(2016)
    public void testExec_B16() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20300228");
        BizDate calckijyunymd = BizDate.valueOf("20400228");
        BizDate hhknseiymd = BizDate.valueOf("19600228");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(917855.42, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(917855.42, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(6.9), "割引期間");
    }
    @Test
    @TestOrder(2017)
    public void testExec_B17() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20300228");
        BizDate calckijyunymd = BizDate.valueOf("20400229");
        BizDate hhknseiymd = BizDate.valueOf("19600228");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(917855.42, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(917855.42, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(6.9), "割引期間");
    }
    @Test
    @TestOrder(2018)
    public void testExec_B18() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20300228");
        BizDate calckijyunymd = BizDate.valueOf("20400301");
        BizDate hhknseiymd = BizDate.valueOf("19600228");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(917855.42, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(917855.42, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(6.9), "割引期間");
    }
    @Test
    @TestOrder(2019)
    public void testExec_B19() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20300228");
        BizDate calckijyunymd = BizDate.valueOf("20500228");
        BizDate hhknseiymd = BizDate.valueOf("19600228");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(958642.96, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(958642.96, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(3.4), "割引期間");
    }
    @Test
    @TestOrder(2020)
    public void testExec_B20() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20300228");
        BizDate calckijyunymd = BizDate.valueOf("20500301");
        BizDate hhknseiymd = BizDate.valueOf("19600228");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(958642.96, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(958642.96, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(3.4), "割引期間");
    }
    @Test
    @TestOrder(2021)
    public void testExec_B21() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20300301");
        BizDate calckijyunymd = BizDate.valueOf("20400228");
        BizDate hhknseiymd = BizDate.valueOf("19600228");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(913305.90, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(913305.90, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(7.3), "割引期間");
    }
    @Test
    @TestOrder(2022)
    public void testExec_B22() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20300301");
        BizDate calckijyunymd = BizDate.valueOf("20400229");
        BizDate hhknseiymd = BizDate.valueOf("19600228");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(913305.90, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(913305.90, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(7.3), "割引期間");
    }
    @Test
    @TestOrder(2023)
    public void testExec_B23() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20300301");
        BizDate calckijyunymd = BizDate.valueOf("20400301");
        BizDate hhknseiymd = BizDate.valueOf("19600228");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(917855.42, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(917855.42, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(6.9), "割引期間");
    }
    @Test
    @TestOrder(2024)
    public void testExec_B24() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20300301");
        BizDate calckijyunymd = BizDate.valueOf("20500228");
        BizDate hhknseiymd = BizDate.valueOf("19600228");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(955076.98, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(955076.98, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(3.7), "割引期間");
    }
    @Test
    @TestOrder(2025)
    public void testExec_B25() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20300301");
        BizDate calckijyunymd = BizDate.valueOf("20500301");
        BizDate hhknseiymd = BizDate.valueOf("19600228");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(958642.96, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(958642.96, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(3.4), "割引期間");
    }
    @Test
    @TestOrder(2026)
    public void testExec_B26() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20200228");
        BizDate calckijyunymd = BizDate.valueOf("20400228");
        BizDate hhknseiymd = BizDate.valueOf("19600229");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(913305.90, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(913305.90, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(7.3), "割引期間");
    }
    @Test
    @TestOrder(2027)
    public void testExec_B27() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20200228");
        BizDate calckijyunymd = BizDate.valueOf("20400229");
        BizDate hhknseiymd = BizDate.valueOf("19600229");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(913305.90, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(913305.90, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(7.3), "割引期間");
    }
    @Test
    @TestOrder(2028)
    public void testExec_B28() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20200228");
        BizDate calckijyunymd = BizDate.valueOf("20400301");
        BizDate hhknseiymd = BizDate.valueOf("19600229");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(913305.90, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(913305.90, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(7.3), "割引期間");
    }
    @Test
    @TestOrder(2029)
    public void testExec_B29() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20200228");
        BizDate calckijyunymd = BizDate.valueOf("20500228");
        BizDate hhknseiymd = BizDate.valueOf("19600229");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(955076.98, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(955076.98, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(3.7), "割引期間");
    }
    @Test
    @TestOrder(2030)
    public void testExec_B30() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20200228");
        BizDate calckijyunymd = BizDate.valueOf("20500301");
        BizDate hhknseiymd = BizDate.valueOf("19600229");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(955076.98, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(955076.98, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(3.7), "割引期間");
    }
    @Test
    @TestOrder(2031)
    public void testExec_B31() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20200229");
        BizDate calckijyunymd = BizDate.valueOf("20400228");
        BizDate hhknseiymd = BizDate.valueOf("19600229");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(913305.90, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(913305.90, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(7.3), "割引期間");
    }
    @Test
    @TestOrder(2032)
    public void testExec_B32() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20200229");
        BizDate calckijyunymd = BizDate.valueOf("20400229");
        BizDate hhknseiymd = BizDate.valueOf("19600229");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(917855.42, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(917855.42, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(6.9), "割引期間");
    }
    @Test
    @TestOrder(2033)
    public void testExec_B33() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20200229");
        BizDate calckijyunymd = BizDate.valueOf("20400301");
        BizDate hhknseiymd = BizDate.valueOf("19600229");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(917855.42, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(917855.42, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(6.9), "割引期間");
    }
    @Test
    @TestOrder(2034)
    public void testExec_B34() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20200229");
        BizDate calckijyunymd = BizDate.valueOf("20500228");
        BizDate hhknseiymd = BizDate.valueOf("19600229");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(958642.96, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(958642.96, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(3.4), "割引期間");
    }
    @Test
    @TestOrder(2035)
    public void testExec_B35() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20200229");
        BizDate calckijyunymd = BizDate.valueOf("20500301");
        BizDate hhknseiymd = BizDate.valueOf("19600229");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(958642.96, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(958642.96, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(3.4), "割引期間");
    }
    @Test
    @TestOrder(2036)
    public void testExec_B36() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20200301");
        BizDate calckijyunymd = BizDate.valueOf("20400228");
        BizDate hhknseiymd = BizDate.valueOf("19600229");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(913305.90, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(913305.90, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(7.3), "割引期間");
    }
    @Test
    @TestOrder(2037)
    public void testExec_B37() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20200301");
        BizDate calckijyunymd = BizDate.valueOf("20400229");
        BizDate hhknseiymd = BizDate.valueOf("19600229");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(913305.90, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(913305.90, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(7.3), "割引期間");
    }
    @Test
    @TestOrder(2038)
    public void testExec_B38() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20200301");
        BizDate calckijyunymd = BizDate.valueOf("20400301");
        BizDate hhknseiymd = BizDate.valueOf("19600229");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(917855.42, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(917855.42, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(6.9), "割引期間");
    }
    @Test
    @TestOrder(2039)
    public void testExec_B39() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20200301");
        BizDate calckijyunymd = BizDate.valueOf("20500228");
        BizDate hhknseiymd = BizDate.valueOf("19600229");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(955076.98, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(955076.98, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(3.7), "割引期間");
    }
    @Test
    @TestOrder(2040)
    public void testExec_B40() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20200301");
        BizDate calckijyunymd = BizDate.valueOf("20500301");
        BizDate hhknseiymd = BizDate.valueOf("19600229");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(958642.96, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(958642.96, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(3.4), "割引期間");
    }
    @Test
    @TestOrder(2041)
    public void testExec_B41() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20300228");
        BizDate calckijyunymd = BizDate.valueOf("20400228");
        BizDate hhknseiymd = BizDate.valueOf("19600229");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(913305.90, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(913305.90, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(7.3), "割引期間");
    }
    @Test
    @TestOrder(2042)
    public void testExec_B42() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20300228");
        BizDate calckijyunymd = BizDate.valueOf("20400229");
        BizDate hhknseiymd = BizDate.valueOf("19600229");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(913305.90, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(913305.90, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(7.3), "割引期間");
    }
    @Test
    @TestOrder(2043)
    public void testExec_B43() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20300228");
        BizDate calckijyunymd = BizDate.valueOf("20400301");
        BizDate hhknseiymd = BizDate.valueOf("19600229");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(913305.90, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(913305.90, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(7.3), "割引期間");
    }
    @Test
    @TestOrder(2044)
    public void testExec_B44() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20300228");
        BizDate calckijyunymd = BizDate.valueOf("20500228");
        BizDate hhknseiymd = BizDate.valueOf("19600229");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(955076.98, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(955076.98, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(3.7), "割引期間");
    }
    @Test
    @TestOrder(2045)
    public void testExec_B45() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20300228");
        BizDate calckijyunymd = BizDate.valueOf("20500301");
        BizDate hhknseiymd = BizDate.valueOf("19600229");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(955076.98, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(955076.98, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(3.7), "割引期間");
    }
    @Test
    @TestOrder(2046)
    public void testExec_B46() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20300301");
        BizDate calckijyunymd = BizDate.valueOf("20400228");
        BizDate hhknseiymd = BizDate.valueOf("19600229");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(913305.90, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(913305.90, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(7.3), "割引期間");
    }
    @Test
    @TestOrder(2047)
    public void testExec_B47() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20300301");
        BizDate calckijyunymd = BizDate.valueOf("20400229");
        BizDate hhknseiymd = BizDate.valueOf("19600229");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(913305.90, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(913305.90, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(7.3), "割引期間");
    }
    @Test
    @TestOrder(2048)
    public void testExec_B48() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20300301");
        BizDate calckijyunymd = BizDate.valueOf("20400301");
        BizDate hhknseiymd = BizDate.valueOf("19600229");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(917855.42, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(917855.42, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(6.9), "割引期間");
    }
    @Test
    @TestOrder(2049)
    public void testExec_B49() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20300301");
        BizDate calckijyunymd = BizDate.valueOf("20500228");
        BizDate hhknseiymd = BizDate.valueOf("19600229");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(955076.98, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(955076.98, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(3.7), "割引期間");
    }
    @Test
    @TestOrder(2050)
    public void testExec_B50() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20300301");
        BizDate calckijyunymd = BizDate.valueOf("20500301");
        BizDate hhknseiymd = BizDate.valueOf("19600229");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(958642.96, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(958642.96, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(3.4), "割引期間");
    }
    @Test
    @TestOrder(2051)
    public void testExec_B51() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20200228");
        BizDate calckijyunymd = BizDate.valueOf("20400228");
        BizDate hhknseiymd = BizDate.valueOf("19600301");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(913305.90, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(913305.90, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(7.3), "割引期間");
    }
    @Test
    @TestOrder(2052)
    public void testExec_B52() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20200228");
        BizDate calckijyunymd = BizDate.valueOf("20400229");
        BizDate hhknseiymd = BizDate.valueOf("19600301");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(913305.90, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(913305.90, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(7.3), "割引期間");
    }
    @Test
    @TestOrder(2053)
    public void testExec_B53() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20200228");
        BizDate calckijyunymd = BizDate.valueOf("20400301");
        BizDate hhknseiymd = BizDate.valueOf("19600301");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(913305.90, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(913305.90, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(7.3), "割引期間");
    }
    @Test
    @TestOrder(2054)
    public void testExec_B54() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20200228");
        BizDate calckijyunymd = BizDate.valueOf("20500228");
        BizDate hhknseiymd = BizDate.valueOf("19600301");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(955076.98, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(955076.98, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(3.7), "割引期間");
    }
    @Test
    @TestOrder(2055)
    public void testExec_B55() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20200228");
        BizDate calckijyunymd = BizDate.valueOf("20500301");
        BizDate hhknseiymd = BizDate.valueOf("19600301");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(955076.98, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(955076.98, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(3.7), "割引期間");
    }
    @Test
    @TestOrder(2056)
    public void testExec_B56() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20200229");
        BizDate calckijyunymd = BizDate.valueOf("20400228");
        BizDate hhknseiymd = BizDate.valueOf("19600301");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(908778.93, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(908778.93, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(7.7), "割引期間");
    }
    @Test
    @TestOrder(2057)
    public void testExec_B57() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20200229");
        BizDate calckijyunymd = BizDate.valueOf("20400229");
        BizDate hhknseiymd = BizDate.valueOf("19600301");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(913305.90, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(913305.90, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(7.3), "割引期間");
    }
    @Test
    @TestOrder(2058)
    public void testExec_B58() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20200229");
        BizDate calckijyunymd = BizDate.valueOf("20400301");
        BizDate hhknseiymd = BizDate.valueOf("19600301");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(913305.90, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(913305.90, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(7.3), "割引期間");
    }
    @Test
    @TestOrder(2059)
    public void testExec_B59() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20200229");
        BizDate calckijyunymd = BizDate.valueOf("20500228");
        BizDate hhknseiymd = BizDate.valueOf("19600301");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(955076.98, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(955076.98, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(3.7), "割引期間");
    }
    @Test
    @TestOrder(2060)
    public void testExec_B60() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20200229");
        BizDate calckijyunymd = BizDate.valueOf("20500301");
        BizDate hhknseiymd = BizDate.valueOf("19600301");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(955076.98, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(955076.98, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(3.7), "割引期間");
    }
    @Test
    @TestOrder(2061)
    public void testExec_B61() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20200301");
        BizDate calckijyunymd = BizDate.valueOf("20400228");
        BizDate hhknseiymd = BizDate.valueOf("19600301");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(913305.90, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(913305.90, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(7.3), "割引期間");
    }
    @Test
    @TestOrder(2062)
    public void testExec_B62() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20200301");
        BizDate calckijyunymd = BizDate.valueOf("20400229");
        BizDate hhknseiymd = BizDate.valueOf("19600301");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(913305.90, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(913305.90, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(7.3), "割引期間");
    }
    @Test
    @TestOrder(2063)
    public void testExec_B63() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20200301");
        BizDate calckijyunymd = BizDate.valueOf("20400301");
        BizDate hhknseiymd = BizDate.valueOf("19600301");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(917855.42, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(917855.42, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(6.9), "割引期間");
    }
    @Test
    @TestOrder(2064)
    public void testExec_B64() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20200301");
        BizDate calckijyunymd = BizDate.valueOf("20500228");
        BizDate hhknseiymd = BizDate.valueOf("19600301");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(955076.98, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(955076.98, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(3.7), "割引期間");
    }
    @Test
    @TestOrder(2065)
    public void testExec_B65() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20200301");
        BizDate calckijyunymd = BizDate.valueOf("20500301");
        BizDate hhknseiymd = BizDate.valueOf("19600301");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(958642.96, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(958642.96, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(3.4), "割引期間");
    }
    @Test
    @TestOrder(2066)
    public void testExec_B66() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20300228");
        BizDate calckijyunymd = BizDate.valueOf("20400228");
        BizDate hhknseiymd = BizDate.valueOf("19600301");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(913305.90, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(913305.90, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(7.3), "割引期間");
    }
    @Test
    @TestOrder(2067)
    public void testExec_B67() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20300228");
        BizDate calckijyunymd = BizDate.valueOf("20400229");
        BizDate hhknseiymd = BizDate.valueOf("19600301");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(913305.90, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(913305.90, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(7.3), "割引期間");
    }
    @Test
    @TestOrder(2068)
    public void testExec_B68() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20300228");
        BizDate calckijyunymd = BizDate.valueOf("20400301");
        BizDate hhknseiymd = BizDate.valueOf("19600301");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(913305.90, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(913305.90, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(7.3), "割引期間");
    }
    @Test
    @TestOrder(2069)
    public void testExec_B69() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20300228");
        BizDate calckijyunymd = BizDate.valueOf("20500228");
        BizDate hhknseiymd = BizDate.valueOf("19600301");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(955076.98, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(955076.98, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(3.7), "割引期間");
    }
    @Test
    @TestOrder(2070)
    public void testExec_B70() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20300228");
        BizDate calckijyunymd = BizDate.valueOf("20500301");
        BizDate hhknseiymd = BizDate.valueOf("19600301");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(955076.98, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(955076.98, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(3.7), "割引期間");
    }
    @Test
    @TestOrder(2071)
    public void testExec_B71() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20300301");
        BizDate calckijyunymd = BizDate.valueOf("20400228");
        BizDate hhknseiymd = BizDate.valueOf("19600301");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(913305.90, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(913305.90, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(7.3), "割引期間");
    }
    @Test
    @TestOrder(2072)
    public void testExec_B72() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20300301");
        BizDate calckijyunymd = BizDate.valueOf("20400229");
        BizDate hhknseiymd = BizDate.valueOf("19600301");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(913305.90, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(913305.90, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(7.3), "割引期間");
    }
    @Test
    @TestOrder(2073)
    public void testExec_B73() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20300301");
        BizDate calckijyunymd = BizDate.valueOf("20400301");
        BizDate hhknseiymd = BizDate.valueOf("19600301");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(917855.42, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(917855.42, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(6.9), "割引期間");
    }
    @Test
    @TestOrder(2074)
    public void testExec_B74() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20300301");
        BizDate calckijyunymd = BizDate.valueOf("20500228");
        BizDate hhknseiymd = BizDate.valueOf("19600301");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(955076.98, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(955076.98, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(3.7), "割引期間");
    }
    @Test
    @TestOrder(2075)
    public void testExec_B75() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20300301");
        BizDate calckijyunymd = BizDate.valueOf("20500301");
        BizDate hhknseiymd = BizDate.valueOf("19600301");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(958642.96, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(958642.96, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(3.4), "割引期間");
    }
    @Test
    @TestOrder(2076)
    public void testExec_B76() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20200228");
        BizDate calckijyunymd = BizDate.valueOf("20400228");
        BizDate hhknseiymd = BizDate.valueOf("19500228");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(958642.96, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(958642.96, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(3.4), "割引期間");
    }
    @Test
    @TestOrder(2077)
    public void testExec_B77() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20200228");
        BizDate calckijyunymd = BizDate.valueOf("20400229");
        BizDate hhknseiymd = BizDate.valueOf("19500228");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(958642.96, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(958642.96, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(3.4), "割引期間");
    }
    @Test
    @TestOrder(2078)
    public void testExec_B78() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20200228");
        BizDate calckijyunymd = BizDate.valueOf("20400301");
        BizDate hhknseiymd = BizDate.valueOf("19500228");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(958642.96, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(958642.96, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(3.4), "割引期間");
    }
    @Test
    @TestOrder(2079)
    public void testExec_B79() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20200228");
        BizDate calckijyunymd = BizDate.valueOf("20500228");
        BizDate hhknseiymd = BizDate.valueOf("19500228");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(982758.83, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(982758.83, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(1.4), "割引期間");
    }
    @Test
    @TestOrder(2080)
    public void testExec_B80() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20200228");
        BizDate calckijyunymd = BizDate.valueOf("20500301");
        BizDate hhknseiymd = BizDate.valueOf("19500228");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(982758.83, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(982758.83, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(1.4), "割引期間");
    }
    @Test
    @TestOrder(2081)
    public void testExec_B81() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20200229");
        BizDate calckijyunymd = BizDate.valueOf("20400228");
        BizDate hhknseiymd = BizDate.valueOf("19500228");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(955076.98, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(955076.98, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(3.7), "割引期間");
    }
    @Test
    @TestOrder(2082)
    public void testExec_B82() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20200229");
        BizDate calckijyunymd = BizDate.valueOf("20400229");
        BizDate hhknseiymd = BizDate.valueOf("19500228");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(958642.96, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(958642.96, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(3.4), "割引期間");
    }
    @Test
    @TestOrder(2083)
    public void testExec_B83() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20200229");
        BizDate calckijyunymd = BizDate.valueOf("20400301");
        BizDate hhknseiymd = BizDate.valueOf("19500228");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(958642.96, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(958642.96, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(3.4), "割引期間");
    }
    @Test
    @TestOrder(2084)
    public void testExec_B84() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20200229");
        BizDate calckijyunymd = BizDate.valueOf("20500228");
        BizDate hhknseiymd = BizDate.valueOf("19500228");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(982758.83, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(982758.83, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(1.4), "割引期間");
    }
    @Test
    @TestOrder(2085)
    public void testExec_B85() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20200229");
        BizDate calckijyunymd = BizDate.valueOf("20500301");
        BizDate hhknseiymd = BizDate.valueOf("19500228");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(982758.83, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(982758.83, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(1.4), "割引期間");
    }
    @Test
    @TestOrder(2086)
    public void testExec_B86() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20200301");
        BizDate calckijyunymd = BizDate.valueOf("20400228");
        BizDate hhknseiymd = BizDate.valueOf("19500228");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(955076.98, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(955076.98, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(3.7), "割引期間");
    }
    @Test
    @TestOrder(2087)
    public void testExec_B87() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20200301");
        BizDate calckijyunymd = BizDate.valueOf("20400229");
        BizDate hhknseiymd = BizDate.valueOf("19500228");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(955076.98, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(955076.98, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(3.7), "割引期間");
    }
    @Test
    @TestOrder(2088)
    public void testExec_B88() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20200301");
        BizDate calckijyunymd = BizDate.valueOf("20400301");
        BizDate hhknseiymd = BizDate.valueOf("19500228");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(958642.96, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(958642.96, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(3.4), "割引期間");
    }
    @Test
    @TestOrder(2089)
    public void testExec_B89() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20200301");
        BizDate calckijyunymd = BizDate.valueOf("20500228");
        BizDate hhknseiymd = BizDate.valueOf("19500228");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(980320.19, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(980320.19, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(1.6), "割引期間");
    }
    @Test
    @TestOrder(2090)
    public void testExec_B90() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20200301");
        BizDate calckijyunymd = BizDate.valueOf("20500301");
        BizDate hhknseiymd = BizDate.valueOf("19500228");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(982758.83, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(982758.83, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(1.4), "割引期間");
    }
    @Test
    @TestOrder(2091)
    public void testExec_B91() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20300228");
        BizDate calckijyunymd = BizDate.valueOf("20400228");
        BizDate hhknseiymd = BizDate.valueOf("19500228");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(958642.96, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(958642.96, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(3.4), "割引期間");
    }
    @Test
    @TestOrder(2092)
    public void testExec_B92() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20300228");
        BizDate calckijyunymd = BizDate.valueOf("20400229");
        BizDate hhknseiymd = BizDate.valueOf("19500228");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(958642.96, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(958642.96, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(3.4), "割引期間");
    }
    @Test
    @TestOrder(2093)
    public void testExec_B93() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20300228");
        BizDate calckijyunymd = BizDate.valueOf("20400301");
        BizDate hhknseiymd = BizDate.valueOf("19500228");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(958642.96, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(958642.96, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(3.4), "割引期間");
    }
    @Test
    @TestOrder(2094)
    public void testExec_B94() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20300228");
        BizDate calckijyunymd = BizDate.valueOf("20500228");
        BizDate hhknseiymd = BizDate.valueOf("19500228");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(982758.83, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(982758.83, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(1.4), "割引期間");
    }
    @Test
    @TestOrder(2095)
    public void testExec_B95() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20300228");
        BizDate calckijyunymd = BizDate.valueOf("20500301");
        BizDate hhknseiymd = BizDate.valueOf("19500228");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(982758.83, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(982758.83, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(1.4), "割引期間");
    }
    @Test
    @TestOrder(2096)
    public void testExec_B96() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20300301");
        BizDate calckijyunymd = BizDate.valueOf("20400228");
        BizDate hhknseiymd = BizDate.valueOf("19500228");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(955076.98, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(955076.98, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(3.7), "割引期間");
    }
    @Test
    @TestOrder(2097)
    public void testExec_B97() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20300301");
        BizDate calckijyunymd = BizDate.valueOf("20400229");
        BizDate hhknseiymd = BizDate.valueOf("19500228");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(955076.98, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(955076.98, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(3.7), "割引期間");
    }
    @Test
    @TestOrder(2098)
    public void testExec_B98() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20300301");
        BizDate calckijyunymd = BizDate.valueOf("20400301");
        BizDate hhknseiymd = BizDate.valueOf("19500228");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(958642.96, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(958642.96, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(3.4), "割引期間");
    }
    @Test
    @TestOrder(2099)
    public void testExec_B99() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20300301");
        BizDate calckijyunymd = BizDate.valueOf("20500228");
        BizDate hhknseiymd = BizDate.valueOf("19500228");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(980320.19, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(980320.19, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(1.6), "割引期間");
    }
    @Test
    @TestOrder(2100)
    public void testExec_B100() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20300301");
        BizDate calckijyunymd = BizDate.valueOf("20500301");
        BizDate hhknseiymd = BizDate.valueOf("19500228");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(982758.83, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(982758.83, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(1.4), "割引期間");
    }
    @Test
    @TestOrder(2101)
    public void testExec_B101() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20200228");
        BizDate calckijyunymd = BizDate.valueOf("20400228");
        BizDate hhknseiymd = BizDate.valueOf("19500301");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(955076.98, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(955076.98, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(3.7), "割引期間");
    }
    @Test
    @TestOrder(2102)
    public void testExec_B102() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20200228");
        BizDate calckijyunymd = BizDate.valueOf("20400229");
        BizDate hhknseiymd = BizDate.valueOf("19500301");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(955076.98, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(955076.98, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(3.7), "割引期間");
    }
    @Test
    @TestOrder(2103)
    public void testExec_B103() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20200228");
        BizDate calckijyunymd = BizDate.valueOf("20400301");
        BizDate hhknseiymd = BizDate.valueOf("19500301");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(955076.98, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(955076.98, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(3.7), "割引期間");
    }
    @Test
    @TestOrder(2104)
    public void testExec_B104() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20200228");
        BizDate calckijyunymd = BizDate.valueOf("20500228");
        BizDate hhknseiymd = BizDate.valueOf("19500301");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(980320.19, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(980320.19, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(1.6), "割引期間");
    }
    @Test
    @TestOrder(2105)
    public void testExec_B105() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20200228");
        BizDate calckijyunymd = BizDate.valueOf("20500301");
        BizDate hhknseiymd = BizDate.valueOf("19500301");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(980320.19, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(980320.19, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(1.6), "割引期間");
    }
    @Test
    @TestOrder(2106)
    public void testExec_B106() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20200229");
        BizDate calckijyunymd = BizDate.valueOf("20400228");
        BizDate hhknseiymd = BizDate.valueOf("19500301");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(951524.27, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(951524.27, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(4.0), "割引期間");
    }
    @Test
    @TestOrder(2107)
    public void testExec_B107() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20200229");
        BizDate calckijyunymd = BizDate.valueOf("20400229");
        BizDate hhknseiymd = BizDate.valueOf("19500301");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(955076.98, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(955076.98, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(3.7), "割引期間");
    }
    @Test
    @TestOrder(2108)
    public void testExec_B108() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20200229");
        BizDate calckijyunymd = BizDate.valueOf("20400301");
        BizDate hhknseiymd = BizDate.valueOf("19500301");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(955076.98, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(955076.98, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(3.7), "割引期間");
    }
    @Test
    @TestOrder(2109)
    public void testExec_B109() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20200229");
        BizDate calckijyunymd = BizDate.valueOf("20500228");
        BizDate hhknseiymd = BizDate.valueOf("19500301");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(980320.19, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(980320.19, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(1.6), "割引期間");
    }
    @Test
    @TestOrder(2110)
    public void testExec_B110() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20200229");
        BizDate calckijyunymd = BizDate.valueOf("20500301");
        BizDate hhknseiymd = BizDate.valueOf("19500301");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(980320.19, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(980320.19, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(1.6), "割引期間");
    }
    @Test
    @TestOrder(2111)
    public void testExec_B111() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20200301");
        BizDate calckijyunymd = BizDate.valueOf("20400228");
        BizDate hhknseiymd = BizDate.valueOf("19500301");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(955076.98, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(955076.98, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(3.7), "割引期間");
    }
    @Test
    @TestOrder(2112)
    public void testExec_B112() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20200301");
        BizDate calckijyunymd = BizDate.valueOf("20400229");
        BizDate hhknseiymd = BizDate.valueOf("19500301");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(955076.98, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(955076.98, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(3.7), "割引期間");
    }
    @Test
    @TestOrder(2113)
    public void testExec_B113() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20200301");
        BizDate calckijyunymd = BizDate.valueOf("20400301");
        BizDate hhknseiymd = BizDate.valueOf("19500301");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(958642.96, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(958642.96, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(3.4), "割引期間");
    }
    @Test
    @TestOrder(2114)
    public void testExec_B114() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20200301");
        BizDate calckijyunymd = BizDate.valueOf("20500228");
        BizDate hhknseiymd = BizDate.valueOf("19500301");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(980320.19, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(980320.19, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(1.6), "割引期間");
    }
    @Test
    @TestOrder(2115)
    public void testExec_B115() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20200301");
        BizDate calckijyunymd = BizDate.valueOf("20500301");
        BizDate hhknseiymd = BizDate.valueOf("19500301");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(982758.83, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(982758.83, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(1.4), "割引期間");
    }
    @Test
    @TestOrder(2116)
    public void testExec_B116() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20300228");
        BizDate calckijyunymd = BizDate.valueOf("20400228");
        BizDate hhknseiymd = BizDate.valueOf("19500301");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(955076.98, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(955076.98, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(3.7), "割引期間");
    }
    @Test
    @TestOrder(2117)
    public void testExec_B117() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20300228");
        BizDate calckijyunymd = BizDate.valueOf("20400229");
        BizDate hhknseiymd = BizDate.valueOf("19500301");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(955076.98, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(955076.98, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(3.7), "割引期間");
    }
    @Test
    @TestOrder(2118)
    public void testExec_B118() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20300228");
        BizDate calckijyunymd = BizDate.valueOf("20400301");
        BizDate hhknseiymd = BizDate.valueOf("19500301");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(955076.98, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(955076.98, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(3.7), "割引期間");
    }
    @Test
    @TestOrder(2119)
    public void testExec_B119() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20300228");
        BizDate calckijyunymd = BizDate.valueOf("20500228");
        BizDate hhknseiymd = BizDate.valueOf("19500301");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(980320.19, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(980320.19, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(1.6), "割引期間");
    }
    @Test
    @TestOrder(2120)
    public void testExec_B120() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20300228");
        BizDate calckijyunymd = BizDate.valueOf("20500301");
        BizDate hhknseiymd = BizDate.valueOf("19500301");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(980320.19, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(980320.19, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(1.6), "割引期間");
    }
    @Test
    @TestOrder(2121)
    public void testExec_B121() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20300301");
        BizDate calckijyunymd = BizDate.valueOf("20400228");
        BizDate hhknseiymd = BizDate.valueOf("19500301");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(955076.98, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(955076.98, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(3.7), "割引期間");
    }
    @Test
    @TestOrder(2122)
    public void testExec_B122() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20300301");
        BizDate calckijyunymd = BizDate.valueOf("20400229");
        BizDate hhknseiymd = BizDate.valueOf("19500301");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(955076.98, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(955076.98, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(3.7), "割引期間");
    }
    @Test
    @TestOrder(2123)
    public void testExec_B123() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20300301");
        BizDate calckijyunymd = BizDate.valueOf("20400301");
        BizDate hhknseiymd = BizDate.valueOf("19500301");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(958642.96, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(958642.96, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(3.4), "割引期間");
    }
    @Test
    @TestOrder(2124)
    public void testExec_B124() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20300301");
        BizDate calckijyunymd = BizDate.valueOf("20500228");
        BizDate hhknseiymd = BizDate.valueOf("19500301");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(980320.19, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(980320.19, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(1.6), "割引期間");
    }
    @Test
    @TestOrder(2125)
    public void testExec_B125() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20300301");
        BizDate calckijyunymd = BizDate.valueOf("20500301");
        BizDate hhknseiymd = BizDate.valueOf("19500301");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(982758.83, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(982758.83, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(1.4), "割引期間");
    }
    @Test
    @TestOrder(2126)
    public void testExec_B126() {
        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;

        C_JydkgmbHkKsnKbn jydkgmbHkKsnKbn = C_JydkgmbHkKsnKbn.KIJUNBISITEI;
        BizCurrency tkkijyunHokenkngk = BizCurrency.valueOf(Double.valueOf("1000000.00"), currencyType);
        BizCurrency kaiyakuhr = BizCurrency.valueOf(Double.valueOf("100000.00"), currencyType);
        BizNumber yoteiriritu = BizNumber.valueOf(0.0125);
        BizDate kykymd = BizDate.valueOf("20400101");
        BizDate calckijyunymd = BizDate.valueOf("20400101");
        BizDate hhknseiymd = BizDate.valueOf("19701231");
        Integer nen = null;
        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        C_ErrorKbn errorKbn = calcJdkghkKngk.exec(jydkgmbHkKsnKbn, tkkijyunHokenkngk, kaiyakuhr, yoteiriritu, kykymd, calckijyunymd, hhknseiymd, nen, hhknsei);
        CalcJdkghkKngkBean calcJdkghkKngkBean = calcJdkghkKngk.getCalcJdkghkKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGkCompareBefore(), BizCurrency.valueOf(860439.04, currencyType), "重度介護前払保険金額（比較前）");
        exBizCalcbleEquals(calcJdkghkKngkBean.getJdkghkKnGk(), BizCurrency.valueOf(860439.04, currencyType), "重度介護前払保険金額");
        exBizCalcbleEquals(calcJdkghkKngkBean.getWaribikiKikan(), BizNumber.valueOf(12.1), "割引期間");
    }

}
