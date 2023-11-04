package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約保全 契約保全共通 積増判定時指数連動積立金計算クラスのメソッド
 *  {@link KeisanTmHntiSisuuRendouTmttkn#exec(pSyouhnCd, C_Tuukasyu, BizNumber, BizNumber, BizNumber, BizNumber, BizCurrency, pRendouRitu)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanTmHntiSisuuRendouTmttknTest_exec {

    @Inject
    private KeisanTmHntiSisuuRendouTmttkn keisanTmHntiSisuuRendouTmttkn;

    @AfterClass
    public static void testClear() {

        MockObjectManager.initialize();

    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        String syouhnCd = "ﾕｹ";

        C_Tuukasyu kyktuukasyu = C_Tuukasyu.JPY;

        BizNumber tmmsHanteiYmdSisuu = BizNumber.ZERO;

        BizNumber tykzenTmmsHanteiYmdSisuu = BizNumber.ZERO;

        BizNumber setteiBairitu = BizNumber.ONE;

        BizNumber tmttknZoukarituJygn = BizNumber.ZERO;

        BizCurrency sisuuRendouTmttKngk = BizCurrency.valueOf(1234567, BizCurrencyTypes.YEN);

        BizNumber rendouRitu = BizNumber.ZERO;

        C_ErrorKbn result = keisanTmHntiSisuuRendouTmttkn.exec(syouhnCd, kyktuukasyu, tmmsHanteiYmdSisuu,
            tykzenTmmsHanteiYmdSisuu, setteiBairitu, tmttknZoukarituJygn, sisuuRendouTmttKngk, rendouRitu);

        exClassificationEquals(result, C_ErrorKbn.ERROR, "処理結果区分");

        exBizCalcbleEquals(keisanTmHntiSisuuRendouTmttkn.getSisuuUpRitu(), null, "指数上昇率");

        exBizCalcbleEquals(keisanTmHntiSisuuRendouTmttkn.getTmttknZoukaRitu(), null, "積立金増加率");

    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        String syouhnCd = "ﾕｹ";

        C_Tuukasyu kyktuukasyu = C_Tuukasyu.USD;

        BizNumber tmmsHanteiYmdSisuu = BizNumber.valueOf(20044.41008);

        BizNumber tykzenTmmsHanteiYmdSisuu = BizNumber.valueOf(20030.36987);

        BizNumber setteiBairitu = BizNumber.ONE;

        BizNumber tmttknZoukarituJygn = BizNumber.valueOf(0.0001);

        BizCurrency sisuuRendouTmttKngk = BizCurrency.valueOf(1234567, BizCurrencyTypes.DOLLAR);

        BizNumber rendouRitu = BizNumber.ZERO;

        C_ErrorKbn result = keisanTmHntiSisuuRendouTmttkn.exec(syouhnCd, kyktuukasyu, tmmsHanteiYmdSisuu,
            tykzenTmmsHanteiYmdSisuu, setteiBairitu, tmttknZoukarituJygn, sisuuRendouTmttKngk, rendouRitu);

        exClassificationEquals(result, C_ErrorKbn.OK, "処理結果区分");

        exBizCalcbleEquals(keisanTmHntiSisuuRendouTmttkn.getSisuurendoutmttkngk(), BizCurrency.valueOf(1234690.46, BizCurrencyTypes.DOLLAR), "指数連動積立金額");

        exBizCalcbleEquals(keisanTmHntiSisuuRendouTmttkn.getSisuuUpRitu(), BizNumber.valueOf(0.0007009461), "指数上昇率");

        exBizCalcbleEquals(keisanTmHntiSisuuRendouTmttkn.getTmttknZoukaRitu(), BizNumber.valueOf(0.0001), "積立金増加率");

    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        String syouhnCd = "ﾕｹ";

        C_Tuukasyu kyktuukasyu = C_Tuukasyu.JPY;

        BizNumber tmmsHanteiYmdSisuu = BizNumber.valueOf(20044.41008);

        BizNumber tykzenTmmsHanteiYmdSisuu = BizNumber.valueOf(20044.41008);

        BizNumber setteiBairitu = BizNumber.ONE;

        BizNumber tmttknZoukarituJygn = BizNumber.valueOf(-1);

        BizCurrency sisuuRendouTmttKngk = BizCurrency.valueOf(1234567, BizCurrencyTypes.YEN);

        BizNumber rendouRitu = BizNumber.ZERO;

        C_ErrorKbn result = keisanTmHntiSisuuRendouTmttkn.exec(syouhnCd, kyktuukasyu, tmmsHanteiYmdSisuu,
            tykzenTmmsHanteiYmdSisuu, setteiBairitu, tmttknZoukarituJygn, sisuuRendouTmttKngk, rendouRitu);

        exClassificationEquals(result, C_ErrorKbn.OK, "処理結果区分");

        exBizCalcbleEquals(keisanTmHntiSisuuRendouTmttkn.getSisuurendoutmttkngk(), BizCurrency.valueOf(1234567, BizCurrencyTypes.YEN), "指数連動積立金額");

        exBizCalcbleEquals(keisanTmHntiSisuuRendouTmttkn.getSisuuUpRitu(), BizNumber.valueOf(0), "指数上昇率");

        exBizCalcbleEquals(keisanTmHntiSisuuRendouTmttkn.getTmttknZoukaRitu(), BizNumber.valueOf(0), "積立金増加率");

    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        String syouhnCd = "ﾕｹ";

        C_Tuukasyu kyktuukasyu = C_Tuukasyu.JPY;

        BizNumber tmmsHanteiYmdSisuu = BizNumber.valueOf(20024.96001);

        BizNumber tykzenTmmsHanteiYmdSisuu = BizNumber.valueOf(20030.36987);

        BizNumber setteiBairitu = BizNumber.ONE;

        BizNumber tmttknZoukarituJygn = BizNumber.valueOf(-1);

        BizCurrency sisuuRendouTmttKngk = BizCurrency.valueOf(1234567, BizCurrencyTypes.YEN);

        BizNumber rendouRitu = BizNumber.ZERO;

        C_ErrorKbn result = keisanTmHntiSisuuRendouTmttkn.exec(syouhnCd, kyktuukasyu, tmmsHanteiYmdSisuu,
            tykzenTmmsHanteiYmdSisuu, setteiBairitu, tmttknZoukarituJygn, sisuuRendouTmttKngk, rendouRitu);

        exClassificationEquals(result, C_ErrorKbn.OK, "処理結果区分");

        exBizCalcbleEquals(keisanTmHntiSisuuRendouTmttkn.getSisuurendoutmttkngk(), BizCurrency.valueOf(1234567, BizCurrencyTypes.YEN), "指数連動積立金額");

        exBizCalcbleEquals(keisanTmHntiSisuuRendouTmttkn.getSisuuUpRitu(), BizNumber.valueOf(-0.0002700829), "指数上昇率");

        exBizCalcbleEquals(keisanTmHntiSisuuRendouTmttkn.getTmttknZoukaRitu(), BizNumber.valueOf(0), "積立金増加率");

    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        String syouhnCd = "ﾕｹ";

        C_Tuukasyu kyktuukasyu = C_Tuukasyu.JPY;

        BizNumber tmmsHanteiYmdSisuu = BizNumber.valueOf(20044.41008);

        BizNumber tykzenTmmsHanteiYmdSisuu = BizNumber.valueOf(20030.36987);

        BizNumber setteiBairitu = BizNumber.ONE;

        BizNumber tmttknZoukarituJygn = BizNumber.valueOf(0.0007009461);

        BizCurrency sisuuRendouTmttKngk = BizCurrency.valueOf(1234567, BizCurrencyTypes.YEN);

        BizNumber rendouRitu = BizNumber.ZERO;

        C_ErrorKbn result = keisanTmHntiSisuuRendouTmttkn.exec(syouhnCd, kyktuukasyu, tmmsHanteiYmdSisuu,
            tykzenTmmsHanteiYmdSisuu, setteiBairitu, tmttknZoukarituJygn, sisuuRendouTmttKngk, rendouRitu);

        exClassificationEquals(result, C_ErrorKbn.OK, "処理結果区分");

        exBizCalcbleEquals(keisanTmHntiSisuuRendouTmttkn.getSisuurendoutmttkngk(), BizCurrency.valueOf(1235433, BizCurrencyTypes.YEN), "指数連動積立金額");

        exBizCalcbleEquals(keisanTmHntiSisuuRendouTmttkn.getSisuuUpRitu(), BizNumber.valueOf(0.0007009461), "指数上昇率");

        exBizCalcbleEquals(keisanTmHntiSisuuRendouTmttkn.getTmttknZoukaRitu(), BizNumber.valueOf(0.0007009461), "積立金増加率");

    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        String syouhnCd = "ﾕｹ";

        C_Tuukasyu kyktuukasyu = C_Tuukasyu.JPY;

        BizNumber tmmsHanteiYmdSisuu = BizNumber.valueOf(20044.41008);

        BizNumber tykzenTmmsHanteiYmdSisuu = BizNumber.valueOf(20044.41008);

        BizNumber setteiBairitu = BizNumber.ONE;

        BizNumber tmttknZoukarituJygn = BizNumber.valueOf(0);

        BizCurrency sisuuRendouTmttKngk = BizCurrency.valueOf(1234567, BizCurrencyTypes.YEN);

        BizNumber rendouRitu = BizNumber.ZERO;

        C_ErrorKbn result = keisanTmHntiSisuuRendouTmttkn.exec(syouhnCd, kyktuukasyu, tmmsHanteiYmdSisuu,
            tykzenTmmsHanteiYmdSisuu, setteiBairitu, tmttknZoukarituJygn, sisuuRendouTmttKngk, rendouRitu);

        exClassificationEquals(result, C_ErrorKbn.OK, "処理結果区分");

        exBizCalcbleEquals(keisanTmHntiSisuuRendouTmttkn.getSisuurendoutmttkngk(), BizCurrency.valueOf(1234567, BizCurrencyTypes.YEN), "指数連動積立金額");

        exBizCalcbleEquals(keisanTmHntiSisuuRendouTmttkn.getSisuuUpRitu(), BizNumber.valueOf(0), "指数上昇率");

        exBizCalcbleEquals(keisanTmHntiSisuuRendouTmttkn.getTmttknZoukaRitu(), BizNumber.valueOf(0), "積立金増加率");

    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        String syouhnCd = "ﾕｹ";

        C_Tuukasyu kyktuukasyu = C_Tuukasyu.JPY;

        BizNumber tmmsHanteiYmdSisuu = BizNumber.valueOf(20024.96001);

        BizNumber tykzenTmmsHanteiYmdSisuu = BizNumber.valueOf(20030.36987);

        BizNumber setteiBairitu = BizNumber.ONE;

        BizNumber tmttknZoukarituJygn = BizNumber.valueOf(-0.0002700829);

        BizCurrency sisuuRendouTmttKngk = BizCurrency.valueOf(1234567, BizCurrencyTypes.YEN);

        BizNumber rendouRitu = BizNumber.ZERO;

        C_ErrorKbn result = keisanTmHntiSisuuRendouTmttkn.exec(syouhnCd, kyktuukasyu, tmmsHanteiYmdSisuu,
            tykzenTmmsHanteiYmdSisuu, setteiBairitu, tmttknZoukarituJygn, sisuuRendouTmttKngk, rendouRitu);

        exClassificationEquals(result, C_ErrorKbn.OK, "処理結果区分");

        exBizCalcbleEquals(keisanTmHntiSisuuRendouTmttkn.getSisuurendoutmttkngk(), BizCurrency.valueOf(1234567, BizCurrencyTypes.YEN), "指数連動積立金額");

        exBizCalcbleEquals(keisanTmHntiSisuuRendouTmttkn.getSisuuUpRitu(), BizNumber.valueOf(-0.0002700829), "指数上昇率");

        exBizCalcbleEquals(keisanTmHntiSisuuRendouTmttkn.getTmttknZoukaRitu(), BizNumber.valueOf(0), "積立金増加率");

    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        String syouhnCd = "ﾕｹ";

        C_Tuukasyu kyktuukasyu = C_Tuukasyu.JPY;

        BizNumber tmmsHanteiYmdSisuu = BizNumber.valueOf(20044.41008);

        BizNumber tykzenTmmsHanteiYmdSisuu = BizNumber.valueOf(20030.36987);

        BizNumber setteiBairitu = BizNumber.ONE;

        BizNumber tmttknZoukarituJygn = BizNumber.valueOf(0.1234);

        BizCurrency sisuuRendouTmttKngk = BizCurrency.valueOf(1234567, BizCurrencyTypes.YEN);

        BizNumber rendouRitu = BizNumber.ZERO;

        C_ErrorKbn result = keisanTmHntiSisuuRendouTmttkn.exec(syouhnCd, kyktuukasyu, tmmsHanteiYmdSisuu,
            tykzenTmmsHanteiYmdSisuu, setteiBairitu, tmttknZoukarituJygn, sisuuRendouTmttKngk, rendouRitu);

        exClassificationEquals(result, C_ErrorKbn.OK, "処理結果区分");

        exBizCalcbleEquals(keisanTmHntiSisuuRendouTmttkn.getSisuurendoutmttkngk(), BizCurrency.valueOf(1235433, BizCurrencyTypes.YEN), "指数連動積立金額");

        exBizCalcbleEquals(keisanTmHntiSisuuRendouTmttkn.getSisuuUpRitu(), BizNumber.valueOf(0.0007009461), "指数上昇率");

        exBizCalcbleEquals(keisanTmHntiSisuuRendouTmttkn.getTmttknZoukaRitu(), BizNumber.valueOf(0.0007009461), "積立金増加率");

    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        String syouhnCd = "ﾕｹ";

        C_Tuukasyu kyktuukasyu = C_Tuukasyu.JPY;

        BizNumber tmmsHanteiYmdSisuu = BizNumber.valueOf(20044.41008);

        BizNumber tykzenTmmsHanteiYmdSisuu = BizNumber.valueOf(20044.41008);

        BizNumber setteiBairitu = BizNumber.ONE;

        BizNumber tmttknZoukarituJygn = BizNumber.valueOf(0.1234);

        BizCurrency sisuuRendouTmttKngk = BizCurrency.valueOf(1234567, BizCurrencyTypes.YEN);

        BizNumber rendouRitu = BizNumber.ZERO;

        C_ErrorKbn result = keisanTmHntiSisuuRendouTmttkn.exec(syouhnCd, kyktuukasyu, tmmsHanteiYmdSisuu,
            tykzenTmmsHanteiYmdSisuu, setteiBairitu, tmttknZoukarituJygn, sisuuRendouTmttKngk, rendouRitu);

        exClassificationEquals(result, C_ErrorKbn.OK, "処理結果区分");

        exBizCalcbleEquals(keisanTmHntiSisuuRendouTmttkn.getSisuurendoutmttkngk(), BizCurrency.valueOf(1234567, BizCurrencyTypes.YEN), "指数連動積立金額");

        exBizCalcbleEquals(keisanTmHntiSisuuRendouTmttkn.getSisuuUpRitu(), BizNumber.valueOf(0), "指数上昇率");

        exBizCalcbleEquals(keisanTmHntiSisuuRendouTmttkn.getTmttknZoukaRitu(), BizNumber.valueOf(0), "積立金増加率");

    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        String syouhnCd = "ﾕｹ";

        C_Tuukasyu kyktuukasyu = C_Tuukasyu.JPY;

        BizNumber tmmsHanteiYmdSisuu = BizNumber.valueOf(20024.96001);

        BizNumber tykzenTmmsHanteiYmdSisuu = BizNumber.valueOf(20030.36987);

        BizNumber setteiBairitu = BizNumber.ONE;

        BizNumber tmttknZoukarituJygn = BizNumber.valueOf(0);

        BizCurrency sisuuRendouTmttKngk = BizCurrency.valueOf(1234567, BizCurrencyTypes.YEN);

        BizNumber rendouRitu = BizNumber.ZERO;

        C_ErrorKbn result = keisanTmHntiSisuuRendouTmttkn.exec(syouhnCd, kyktuukasyu, tmmsHanteiYmdSisuu,
            tykzenTmmsHanteiYmdSisuu, setteiBairitu, tmttknZoukarituJygn, sisuuRendouTmttKngk, rendouRitu);

        exClassificationEquals(result, C_ErrorKbn.OK, "処理結果区分");

        exBizCalcbleEquals(keisanTmHntiSisuuRendouTmttkn.getSisuurendoutmttkngk(), BizCurrency.valueOf(1234567, BizCurrencyTypes.YEN), "指数連動積立金額");

        exBizCalcbleEquals(keisanTmHntiSisuuRendouTmttkn.getSisuuUpRitu(), BizNumber.valueOf(-0.0002700829), "指数上昇率");

        exBizCalcbleEquals(keisanTmHntiSisuuRendouTmttkn.getTmttknZoukaRitu(), BizNumber.valueOf(0), "積立金増加率");

    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {

        String syouhnCd = "ﾕﾍ";

        C_Tuukasyu kyktuukasyu = C_Tuukasyu.USD;

        BizNumber tmmsHanteiYmdSisuu = BizNumber.valueOf(20044.41008);

        BizNumber tykzenTmmsHanteiYmdSisuu = BizNumber.valueOf(20030.36987);

        BizNumber setteiBairitu = BizNumber.ZERO;

        BizNumber tmttknZoukarituJygn = BizNumber.valueOf(0.0001);

        BizCurrency sisuuRendouTmttKngk = BizCurrency.valueOf(1234567, BizCurrencyTypes.DOLLAR);

        BizNumber rendouRitu = BizNumber.ONE;

        C_ErrorKbn result = keisanTmHntiSisuuRendouTmttkn.exec(syouhnCd, kyktuukasyu, tmmsHanteiYmdSisuu,
            tykzenTmmsHanteiYmdSisuu, setteiBairitu, tmttknZoukarituJygn, sisuuRendouTmttKngk, rendouRitu);

        exClassificationEquals(result, C_ErrorKbn.OK, "処理結果区分");

        exBizCalcbleEquals(keisanTmHntiSisuuRendouTmttkn.getSisuurendoutmttkngk(), BizCurrency.valueOf(1234690.46, BizCurrencyTypes.DOLLAR), "指数連動積立金額");

        exBizCalcbleEquals(keisanTmHntiSisuuRendouTmttkn.getSisuuUpRitu(), BizNumber.valueOf(0.0007009461), "指数上昇率");

        exBizCalcbleEquals(keisanTmHntiSisuuRendouTmttkn.getTmttknZoukaRitu(), BizNumber.valueOf(0.0001), "積立金増加率");

    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {

        String syouhnCd = "ﾕﾍ";

        C_Tuukasyu kyktuukasyu = C_Tuukasyu.JPY;

        BizNumber tmmsHanteiYmdSisuu = BizNumber.valueOf(20044.41008);

        BizNumber tykzenTmmsHanteiYmdSisuu = BizNumber.valueOf(20044.41008);

        BizNumber setteiBairitu = BizNumber.ZERO;

        BizNumber tmttknZoukarituJygn = BizNumber.valueOf(-1);

        BizCurrency sisuuRendouTmttKngk = BizCurrency.valueOf(1234567, BizCurrencyTypes.YEN);

        BizNumber rendouRitu = BizNumber.ONE;

        C_ErrorKbn result = keisanTmHntiSisuuRendouTmttkn.exec(syouhnCd, kyktuukasyu, tmmsHanteiYmdSisuu,
            tykzenTmmsHanteiYmdSisuu, setteiBairitu, tmttknZoukarituJygn, sisuuRendouTmttKngk, rendouRitu);

        exClassificationEquals(result, C_ErrorKbn.OK, "処理結果区分");

        exBizCalcbleEquals(keisanTmHntiSisuuRendouTmttkn.getSisuurendoutmttkngk(), BizCurrency.valueOf(1234567, BizCurrencyTypes.YEN), "指数連動積立金額");

        exBizCalcbleEquals(keisanTmHntiSisuuRendouTmttkn.getSisuuUpRitu(), BizNumber.valueOf(0), "指数上昇率");

        exBizCalcbleEquals(keisanTmHntiSisuuRendouTmttkn.getTmttknZoukaRitu(), BizNumber.valueOf(0), "積立金増加率");

    }

    @Test
    @TestOrder(130)
    public void testExec_A13() {

        String syouhnCd = "ﾕﾍ";

        C_Tuukasyu kyktuukasyu = C_Tuukasyu.JPY;

        BizNumber tmmsHanteiYmdSisuu = BizNumber.valueOf(20024.96001);

        BizNumber tykzenTmmsHanteiYmdSisuu = BizNumber.valueOf(20030.36987);

        BizNumber setteiBairitu = BizNumber.ZERO;

        BizNumber tmttknZoukarituJygn = BizNumber.valueOf(-1);

        BizCurrency sisuuRendouTmttKngk = BizCurrency.valueOf(1234567, BizCurrencyTypes.YEN);

        BizNumber rendouRitu = BizNumber.ONE;

        C_ErrorKbn result = keisanTmHntiSisuuRendouTmttkn.exec(syouhnCd, kyktuukasyu, tmmsHanteiYmdSisuu,
            tykzenTmmsHanteiYmdSisuu, setteiBairitu, tmttknZoukarituJygn, sisuuRendouTmttKngk, rendouRitu);

        exClassificationEquals(result, C_ErrorKbn.OK, "処理結果区分");

        exBizCalcbleEquals(keisanTmHntiSisuuRendouTmttkn.getSisuurendoutmttkngk(), BizCurrency.valueOf(1234567, BizCurrencyTypes.YEN), "指数連動積立金額");

        exBizCalcbleEquals(keisanTmHntiSisuuRendouTmttkn.getSisuuUpRitu(), BizNumber.valueOf(-0.0002700829), "指数上昇率");

        exBizCalcbleEquals(keisanTmHntiSisuuRendouTmttkn.getTmttknZoukaRitu(), BizNumber.valueOf(0), "積立金増加率");

    }

    @Test
    @TestOrder(140)
    public void testExec_A14() {

        String syouhnCd = "ﾕﾁ";

        C_Tuukasyu kyktuukasyu = C_Tuukasyu.JPY;

        BizNumber tmmsHanteiYmdSisuu = BizNumber.valueOf(20044.41008);

        BizNumber tykzenTmmsHanteiYmdSisuu = BizNumber.valueOf(20030.36987);

        BizNumber setteiBairitu = BizNumber.ZERO;

        BizNumber tmttknZoukarituJygn = BizNumber.valueOf(0.0007009461);

        BizCurrency sisuuRendouTmttKngk = BizCurrency.valueOf(1234567, BizCurrencyTypes.YEN);

        BizNumber rendouRitu = BizNumber.ONE;

        C_ErrorKbn result = keisanTmHntiSisuuRendouTmttkn.exec(syouhnCd, kyktuukasyu, tmmsHanteiYmdSisuu,
            tykzenTmmsHanteiYmdSisuu, setteiBairitu, tmttknZoukarituJygn, sisuuRendouTmttKngk, rendouRitu);

        exClassificationEquals(result, C_ErrorKbn.ERROR, "処理結果区分");

        exBizCalcbleEquals(keisanTmHntiSisuuRendouTmttkn.getSisuurendoutmttkngk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "指数連動積立金額");

        exBizCalcbleEquals(keisanTmHntiSisuuRendouTmttkn.getSisuuUpRitu(), BizNumber.valueOf(0), "指数上昇率");

        exBizCalcbleEquals(keisanTmHntiSisuuRendouTmttkn.getTmttknZoukaRitu(), BizNumber.valueOf(0), "積立金増加率");

    }
}
