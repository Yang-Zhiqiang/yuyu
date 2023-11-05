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
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Nenkinsyu;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 年金年額計算クラスのメソッド {@link KeisanNkNengk#exec(C_Nenkinsyu, String, C_Tuukasyu, int, int, C_Seibetu , BizCurrency)} テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanNkNengkTest_exec {

    @Inject
    private KeisanNkNengk KeisanNkNengk;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_年金年額計算";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(KeisanNkNengkTest_exec.class, fileName, sheetName);
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
        bizDomManager.delete(bizDomManager.getAllKktNkGnsritu());
        bizDomManager.delete(bizDomManager.getAllHsykkntkSysnNkGnsritu());
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        C_Nenkinsyu nksyu = C_Nenkinsyu.KAKUTEINENKIN ;

        String ryouritusdNo = "AAA";

        C_Tuukasyu  tuukasyu = C_Tuukasyu.JPY;

        int shrkkn = 98;

        int nkShrStartNen = 99;

        C_Seibetu seibetu = C_Seibetu.MALE;

        BizCurrency nkGns =  BizCurrency.valueOf(12345678, BizCurrencyTypes.YEN);

        C_ErrorKbn resultKbn = KeisanNkNengk.exec(nksyu,ryouritusdNo,tuukasyu,shrkkn,nkShrStartNen,seibetu,nkGns);

        exClassificationEquals(resultKbn, C_ErrorKbn.ERROR, "結果区分");

        exBizCalcbleEquals(KeisanNkNengk.getNkNengk(), null, "年金年額");

        exBizCalcbleEquals(KeisanNkNengk.getNkNengkBigk(), null, "年金年額（倍額）");

        exNumericEquals(KeisanNkNengk.getHsykkn(), 0, "保証期間");

    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        C_Nenkinsyu nksyu = C_Nenkinsyu.KAKUTEINENKIN ;

        String ryouritusdNo = "AAA";

        C_Tuukasyu  tuukasyu = C_Tuukasyu.JPY;

        int shrkkn = 99;

        int nkShrStartNen = 99;

        C_Seibetu seibetu = C_Seibetu.MALE;

        BizCurrency nkGns =  BizCurrency.valueOf(12345678, BizCurrencyTypes.YEN);

        C_ErrorKbn resultKbn = KeisanNkNengk.exec(nksyu,ryouritusdNo,tuukasyu,shrkkn,nkShrStartNen,seibetu,nkGns);

        exClassificationEquals(resultKbn, C_ErrorKbn.OK, "結果区分");

        exBizCalcbleEquals(KeisanNkNengk.getNkNengk(), BizCurrency.valueOf(1000217, BizCurrencyTypes.YEN), "年金年額");

        exBizCalcbleEquals(KeisanNkNengk.getNkNengkBigk(), null, "年金年額（倍額）");

        exNumericEquals(KeisanNkNengk.getHsykkn(), 0, "保証期間");

    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        C_Nenkinsyu nksyu = C_Nenkinsyu.KAKUTEINENKIN ;

        String ryouritusdNo = "AAA";

        C_Tuukasyu  tuukasyu = C_Tuukasyu.USD;

        int shrkkn = 99;

        int nkShrStartNen = 99;

        C_Seibetu seibetu = C_Seibetu.MALE;

        BizCurrency nkGns =  BizCurrency.valueOf(12345678, BizCurrencyTypes.DOLLAR);

        C_ErrorKbn resultKbn = KeisanNkNengk.exec(nksyu,ryouritusdNo,tuukasyu,shrkkn,nkShrStartNen,seibetu,nkGns);

        exClassificationEquals(resultKbn, C_ErrorKbn.OK, "結果区分");

        exBizCalcbleEquals(KeisanNkNengk.getNkNengk(), BizCurrency.valueOf(1008304.32, BizCurrencyTypes.DOLLAR), "年金年額");

        exBizCalcbleEquals(KeisanNkNengk.getNkNengkBigk(), null, "年金年額（倍額）");

        exNumericEquals(KeisanNkNengk.getHsykkn(), 0, "保証期間");

    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        C_Nenkinsyu nksyu = C_Nenkinsyu.KAKUTEINENKIN ;

        String ryouritusdNo = "AAA";

        C_Tuukasyu  tuukasyu = C_Tuukasyu.AUD;

        int shrkkn = 99;

        int nkShrStartNen = 99;

        C_Seibetu seibetu = C_Seibetu.MALE;

        BizCurrency nkGns =  BizCurrency.valueOf(12345678, BizCurrencyTypes.AU_DOLLAR);

        C_ErrorKbn resultKbn = KeisanNkNengk.exec(nksyu,ryouritusdNo,tuukasyu,shrkkn,nkShrStartNen,seibetu,nkGns);

        exClassificationEquals(resultKbn, C_ErrorKbn.OK, "結果区分");

        exBizCalcbleEquals(KeisanNkNengk.getNkNengk(), BizCurrency.valueOf(1008304.32, BizCurrencyTypes.AU_DOLLAR), "年金年額");

        exBizCalcbleEquals(KeisanNkNengk.getNkNengkBigk(), null, "年金年額（倍額）");

        exNumericEquals(KeisanNkNengk.getHsykkn(), 0, "保証期間");

    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        C_Nenkinsyu nksyu = C_Nenkinsyu.KAKUTEINENKIN;

        String ryouritusdNo = "BBB";

        C_Tuukasyu  tuukasyu = C_Tuukasyu.USD;

        int shrkkn = 99;

        int nkShrStartNen = 99;

        C_Seibetu seibetu = C_Seibetu.MALE;

        BizCurrency nkGns =  BizCurrency.valueOf(42345678901.23, BizCurrencyTypes.DOLLAR);

        C_ErrorKbn resultKbn = KeisanNkNengk.exec(nksyu,ryouritusdNo,tuukasyu,shrkkn,nkShrStartNen,seibetu,nkGns);

        exClassificationEquals(resultKbn, C_ErrorKbn.OK, "結果区分");

        exBizCalcbleEquals(KeisanNkNengk.getNkNengk(),BizCurrency.valueOf(16938271560.50, BizCurrencyTypes.DOLLAR) , "年金年額");

        exBizCalcbleEquals(KeisanNkNengk.getNkNengkBigk(), null, "年金年額（倍額）");

        exNumericEquals(KeisanNkNengk.getHsykkn(), 0, "保証期間");

    }


    @Test
    @TestOrder(60)
    public void testExec_A6() {

        C_Nenkinsyu nksyu = C_Nenkinsyu.SGKHSYSYSNNENKIN ;

        String ryouritusdNo = "AAA";

        C_Tuukasyu  tuukasyu = C_Tuukasyu.JPY;

        int shrkkn = 99;

        int nkShrStartNen = 98;

        C_Seibetu seibetu = C_Seibetu.MALE;

        BizCurrency nkGns =  BizCurrency.valueOf(12345678, BizCurrencyTypes.YEN);

        C_ErrorKbn resultKbn = KeisanNkNengk.exec(nksyu,ryouritusdNo,tuukasyu,shrkkn,nkShrStartNen,seibetu,nkGns);

        exClassificationEquals(resultKbn, C_ErrorKbn.ERROR, "結果区分");

        exBizCalcbleEquals(KeisanNkNengk.getNkNengk(), null, "年金年額");

        exBizCalcbleEquals(KeisanNkNengk.getNkNengkBigk(), null, "年金年額（倍額）");

        exNumericEquals(KeisanNkNengk.getHsykkn(), 0, "保証期間");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        C_Nenkinsyu nksyu = C_Nenkinsyu.SGKHSYSYSNNENKIN ;

        String ryouritusdNo = "AAA";

        C_Tuukasyu  tuukasyu = C_Tuukasyu.JPY;

        int shrkkn = 99;

        int nkShrStartNen = 99;

        C_Seibetu seibetu = C_Seibetu.MALE;

        BizCurrency nkGns =  BizCurrency.valueOf(12345678, BizCurrencyTypes.YEN);

        C_ErrorKbn resultKbn = KeisanNkNengk.exec(nksyu,ryouritusdNo,tuukasyu,shrkkn,nkShrStartNen,seibetu,nkGns);

        exClassificationEquals(resultKbn, C_ErrorKbn.OK, "結果区分");

        exBizCalcbleEquals(KeisanNkNengk.getNkNengk(), BizCurrency.valueOf(1008305, BizCurrencyTypes.YEN), "年金年額");

        exBizCalcbleEquals(KeisanNkNengk.getNkNengkBigk(), null, "年金年額（倍額）");

        exNumericEquals(KeisanNkNengk.getHsykkn(), 99, "保証期間");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        C_Nenkinsyu nksyu = C_Nenkinsyu.SGKHSYSYSNNENKIN ;

        String ryouritusdNo = "AAA";

        C_Tuukasyu  tuukasyu = C_Tuukasyu.USD;

        int shrkkn = 99;

        int nkShrStartNen = 99;

        C_Seibetu seibetu = C_Seibetu.MALE;

        BizCurrency nkGns =  BizCurrency.valueOf(12345678, BizCurrencyTypes.DOLLAR);

        C_ErrorKbn resultKbn = KeisanNkNengk.exec(nksyu,ryouritusdNo,tuukasyu,shrkkn,nkShrStartNen,seibetu,nkGns);

        exClassificationEquals(resultKbn, C_ErrorKbn.OK, "結果区分");

        exBizCalcbleEquals(KeisanNkNengk.getNkNengk(), BizCurrency.valueOf(1008304.32, BizCurrencyTypes.DOLLAR), "年金年額");

        exBizCalcbleEquals(KeisanNkNengk.getNkNengkBigk(), null, "年金年額（倍額）");

        exNumericEquals(KeisanNkNengk.getHsykkn(), 99, "保証期間");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        C_Nenkinsyu nksyu = C_Nenkinsyu.SGKHSYSYSNNENKIN ;

        String ryouritusdNo = "AAA";

        C_Tuukasyu  tuukasyu = C_Tuukasyu.AUD;

        int shrkkn = 99;

        int nkShrStartNen = 99;

        C_Seibetu seibetu = C_Seibetu.MALE;

        BizCurrency nkGns =  BizCurrency.valueOf(12345678, BizCurrencyTypes.AU_DOLLAR);

        C_ErrorKbn resultKbn = KeisanNkNengk.exec(nksyu,ryouritusdNo,tuukasyu,shrkkn,nkShrStartNen,seibetu,nkGns);

        exClassificationEquals(resultKbn, C_ErrorKbn.OK, "結果区分");

        exBizCalcbleEquals(KeisanNkNengk.getNkNengk(),BizCurrency.valueOf(1008304.32, BizCurrencyTypes.AU_DOLLAR), "年金年額");

        exBizCalcbleEquals(KeisanNkNengk.getNkNengkBigk(), null, "年金年額（倍額）");

        exNumericEquals(KeisanNkNengk.getHsykkn(), 99, "保証期間");

    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        C_Nenkinsyu nksyu = C_Nenkinsyu.BLNK;

        String ryouritusdNo = "AAA";

        C_Tuukasyu  tuukasyu = C_Tuukasyu.JPY;

        int shrkkn = 99;

        int nkShrStartNen = 99;

        C_Seibetu seibetu = C_Seibetu.MALE;

        BizCurrency nkGns =  BizCurrency.valueOf(12345678, BizCurrencyTypes.YEN);

        C_ErrorKbn resultKbn = KeisanNkNengk.exec(nksyu,ryouritusdNo,tuukasyu,shrkkn,nkShrStartNen,seibetu,nkGns);

        exClassificationEquals(resultKbn, C_ErrorKbn.ERROR, "結果区分");

        exBizCalcbleEquals(KeisanNkNengk.getNkNengk(), null, "年金年額");

        exBizCalcbleEquals(KeisanNkNengk.getNkNengkBigk(), null, "年金年額（倍額）");

        exNumericEquals(KeisanNkNengk.getHsykkn(), 0, "保証期間");
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {

        C_Nenkinsyu nksyu = C_Nenkinsyu.KAKUTEIDAI1NENKINBAIGK ;

        String ryouritusdNo = "BBB";

        C_Tuukasyu  tuukasyu = C_Tuukasyu.JPY;

        int shrkkn = 99;

        int nkShrStartNen = 99;

        C_Seibetu seibetu = C_Seibetu.MALE;

        BizCurrency nkGns =  BizCurrency.valueOf(12345678, BizCurrencyTypes.YEN);

        C_ErrorKbn resultKbn = KeisanNkNengk.exec(nksyu,ryouritusdNo,tuukasyu,shrkkn,nkShrStartNen,seibetu,nkGns);

        exClassificationEquals(resultKbn, C_ErrorKbn.ERROR, "結果区分");

        exBizCalcbleEquals(KeisanNkNengk.getNkNengk(), null, "年金年額");

        exBizCalcbleEquals(KeisanNkNengk.getNkNengkBigk(), null, "年金年額（倍額）");

        exNumericEquals(KeisanNkNengk.getHsykkn(), 0, "保証期間");
    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {

        C_Nenkinsyu nksyu = C_Nenkinsyu.KAKUTEIDAI1NENKINBAIGK ;

        String ryouritusdNo = "AAA";

        C_Tuukasyu  tuukasyu = C_Tuukasyu.JPY;

        int shrkkn = 99;

        int nkShrStartNen = 99;

        C_Seibetu seibetu = C_Seibetu.MALE;

        BizCurrency nkGns =  BizCurrency.valueOf(12345678, BizCurrencyTypes.YEN);

        C_ErrorKbn resultKbn = KeisanNkNengk.exec(nksyu,ryouritusdNo,tuukasyu,shrkkn,nkShrStartNen,seibetu,nkGns);

        exClassificationEquals(resultKbn, C_ErrorKbn.OK, "結果区分");

        exBizCalcbleEquals(KeisanNkNengk.getNkNengk(), BizCurrency.valueOf(1008305, BizCurrencyTypes.YEN), "年金年額");

        exBizCalcbleEquals(KeisanNkNengk.getNkNengkBigk(), BizCurrency.valueOf(2016610, BizCurrencyTypes.YEN),
            "年金年額（倍額）");

        exNumericEquals(KeisanNkNengk.getHsykkn(), 0, "保証期間");
    }

    @Test
    @TestOrder(130)
    public void testExec_A13() {

        C_Nenkinsyu nksyu = C_Nenkinsyu.KAKUTEIDAI1NENKINBAIGK ;

        String ryouritusdNo = "AAA";

        C_Tuukasyu  tuukasyu = C_Tuukasyu.USD;

        int shrkkn = 99;

        int nkShrStartNen = 99;

        C_Seibetu seibetu = C_Seibetu.MALE;

        BizCurrency nkGns =  BizCurrency.valueOf(12345678, BizCurrencyTypes.DOLLAR);

        C_ErrorKbn resultKbn = KeisanNkNengk.exec(nksyu,ryouritusdNo,tuukasyu,shrkkn,nkShrStartNen,seibetu,nkGns);

        exClassificationEquals(resultKbn, C_ErrorKbn.OK, "結果区分");

        exBizCalcbleEquals(KeisanNkNengk.getNkNengk(), BizCurrency.valueOf(1008304.32, BizCurrencyTypes.DOLLAR),
            "年金年額");

        exBizCalcbleEquals(KeisanNkNengk.getNkNengkBigk(), BizCurrency.valueOf(2016608.64, BizCurrencyTypes.DOLLAR),
            "年金年額（倍額）");

        exNumericEquals(KeisanNkNengk.getHsykkn(), 0, "保証期間");
    }

    @Test
    @TestOrder(140)
    public void testExec_A14() {

        C_Nenkinsyu nksyu = C_Nenkinsyu.KAKUTEIDAI1NENKINBAIGK ;

        String ryouritusdNo = "AAA";

        C_Tuukasyu  tuukasyu = C_Tuukasyu.AUD;

        int shrkkn = 99;

        int nkShrStartNen = 99;

        C_Seibetu seibetu = C_Seibetu.MALE;

        BizCurrency nkGns =  BizCurrency.valueOf(42345678901.23, BizCurrencyTypes.AU_DOLLAR);

        C_ErrorKbn resultKbn = KeisanNkNengk.exec(nksyu,ryouritusdNo,tuukasyu,shrkkn,nkShrStartNen,seibetu,nkGns);

        exClassificationEquals(resultKbn, C_ErrorKbn.OK, "結果区分");

        exBizCalcbleEquals(KeisanNkNengk.getNkNengk(),BizCurrency.valueOf(16938271560.50, BizCurrencyTypes.AU_DOLLAR),
            "年金年額");

        exBizCalcbleEquals(KeisanNkNengk.getNkNengkBigk(), BizCurrency.valueOf(33876543121.00,
            BizCurrencyTypes.AU_DOLLAR), "年金年額（倍額）");

        exNumericEquals(KeisanNkNengk.getHsykkn(), 0, "保証期間");

    }
}
