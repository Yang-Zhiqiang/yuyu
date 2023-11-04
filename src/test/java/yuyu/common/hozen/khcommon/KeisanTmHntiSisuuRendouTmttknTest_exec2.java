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
public class KeisanTmHntiSisuuRendouTmttknTest_exec2 {

    @Inject
    private KeisanTmHntiSisuuRendouTmttkn keisanTmHntiSisuuRendouTmttkn;

    @AfterClass
    public static void testClear() {

        MockObjectManager.initialize();

    }

    @Test
    @TestOrder(10)
    public void testExec2_A1() {

        String syouhnCd = "ﾕｹ";

        C_Tuukasyu kyktuukasyu = C_Tuukasyu.USD;

        BizNumber tmmsHanteiYmdSisuu = BizNumber.valueOf(20044.41008);

        BizNumber tykzenTmmsHanteiYmdSisuu = BizNumber.valueOf(20030.36987);

        BizNumber setteiBairitu = BizNumber.valueOf(1);

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
    @TestOrder(10)
    public void testExec2_A2() {

        String syouhnCd = "ﾕｹ";

        C_Tuukasyu kyktuukasyu = C_Tuukasyu.USD;

        BizNumber tmmsHanteiYmdSisuu = BizNumber.valueOf(98765.43201);

        BizNumber tykzenTmmsHanteiYmdSisuu = BizNumber.valueOf(12345.12345);

        BizNumber setteiBairitu = BizNumber.valueOf(0.87);

        BizNumber tmttknZoukarituJygn = BizNumber.valueOf(7.1234);

        BizCurrency sisuuRendouTmttKngk = BizCurrency.valueOf(1234567890.12, BizCurrencyTypes.DOLLAR);

        BizNumber rendouRitu = BizNumber.ZERO;

        C_ErrorKbn result = keisanTmHntiSisuuRendouTmttkn.exec(syouhnCd, kyktuukasyu, tmmsHanteiYmdSisuu,
            tykzenTmmsHanteiYmdSisuu, setteiBairitu, tmttknZoukarituJygn, sisuuRendouTmttKngk, rendouRitu);

        exClassificationEquals(result, C_ErrorKbn.OK, "処理結果区分");

        exBizCalcbleEquals(keisanTmHntiSisuuRendouTmttkn.getSisuurendoutmttkngk(), BizCurrency.valueOf(8753473022.06, BizCurrencyTypes.DOLLAR), "指数連動積立金額");

        exBizCalcbleEquals(keisanTmHntiSisuuRendouTmttkn.getSisuuUpRitu(), BizNumber.valueOf(7.0003600134), "指数上昇率");

        exBizCalcbleEquals(keisanTmHntiSisuuRendouTmttkn.getTmttknZoukaRitu(), BizNumber.valueOf(6.0903132117), "積立金増加率");

    }

    @Test
    @TestOrder(20)
    public void testExec2_A3() {

        String syouhnCd = "ﾕｹ";

        C_Tuukasyu kyktuukasyu = C_Tuukasyu.JPY;

        BizNumber tmmsHanteiYmdSisuu = BizNumber.valueOf(20044.41008);

        BizNumber tykzenTmmsHanteiYmdSisuu = BizNumber.valueOf(20030.36987);

        BizNumber setteiBairitu = BizNumber.valueOf(1.23);

        BizNumber tmttknZoukarituJygn = BizNumber.valueOf(0.1234);

        BizCurrency sisuuRendouTmttKngk = BizCurrency.valueOf(1234567, BizCurrencyTypes.YEN);

        BizNumber rendouRitu = BizNumber.ZERO;

        C_ErrorKbn result = keisanTmHntiSisuuRendouTmttkn.exec(syouhnCd, kyktuukasyu, tmmsHanteiYmdSisuu,
            tykzenTmmsHanteiYmdSisuu, setteiBairitu, tmttknZoukarituJygn, sisuuRendouTmttKngk, rendouRitu);

        exClassificationEquals(result, C_ErrorKbn.OK, "処理結果区分");

        exBizCalcbleEquals(keisanTmHntiSisuuRendouTmttkn.getSisuurendoutmttkngk(), BizCurrency.valueOf(1235632, BizCurrencyTypes.YEN), "指数連動積立金額");

        exBizCalcbleEquals(keisanTmHntiSisuuRendouTmttkn.getSisuuUpRitu(), BizNumber.valueOf(0.0007009461), "指数上昇率");

        exBizCalcbleEquals(keisanTmHntiSisuuRendouTmttkn.getTmttknZoukaRitu(), BizNumber.valueOf(0.0008621637), "積立金増加率");

    }
    @Test
    @TestOrder(40)
    public void testExec2_A4() {

        String syouhnCd = "ﾕﾍ";

        C_Tuukasyu kyktuukasyu = C_Tuukasyu.USD;

        BizNumber tmmsHanteiYmdSisuu = BizNumber.valueOf(20044.41008);

        BizNumber tykzenTmmsHanteiYmdSisuu = BizNumber.valueOf(20030.36987);

        BizNumber setteiBairitu = BizNumber.ZERO;

        BizNumber tmttknZoukarituJygn = BizNumber.valueOf(0.0001);

        BizCurrency sisuuRendouTmttKngk = BizCurrency.valueOf(1234567, BizCurrencyTypes.DOLLAR);

        BizNumber rendouRitu = BizNumber.valueOf(1);

        C_ErrorKbn result = keisanTmHntiSisuuRendouTmttkn.exec(syouhnCd, kyktuukasyu, tmmsHanteiYmdSisuu,
            tykzenTmmsHanteiYmdSisuu, setteiBairitu, tmttknZoukarituJygn, sisuuRendouTmttKngk, rendouRitu);

        exClassificationEquals(result, C_ErrorKbn.OK, "処理結果区分");

        exBizCalcbleEquals(keisanTmHntiSisuuRendouTmttkn.getSisuurendoutmttkngk(), BizCurrency.valueOf(1234690.46, BizCurrencyTypes.DOLLAR), "指数連動積立金額");

        exBizCalcbleEquals(keisanTmHntiSisuuRendouTmttkn.getSisuuUpRitu(), BizNumber.valueOf(0.0007009461), "指数上昇率");

        exBizCalcbleEquals(keisanTmHntiSisuuRendouTmttkn.getTmttknZoukaRitu(), BizNumber.valueOf(0.0001), "積立金増加率");

    }

    @Test
    @TestOrder(50)
    public void testExec2_A5() {

        String syouhnCd = "ﾕﾍ";

        C_Tuukasyu kyktuukasyu = C_Tuukasyu.USD;

        BizNumber tmmsHanteiYmdSisuu = BizNumber.valueOf(98765.43201);

        BizNumber tykzenTmmsHanteiYmdSisuu = BizNumber.valueOf(12345.12345);

        BizNumber setteiBairitu = BizNumber.ZERO;

        BizNumber tmttknZoukarituJygn = BizNumber.valueOf(7.1234);

        BizCurrency sisuuRendouTmttKngk = BizCurrency.valueOf(1234567890.12, BizCurrencyTypes.DOLLAR);

        BizNumber rendouRitu = BizNumber.valueOf(0.87);

        C_ErrorKbn result = keisanTmHntiSisuuRendouTmttkn.exec(syouhnCd, kyktuukasyu, tmmsHanteiYmdSisuu,
            tykzenTmmsHanteiYmdSisuu, setteiBairitu, tmttknZoukarituJygn, sisuuRendouTmttKngk, rendouRitu);

        exClassificationEquals(result, C_ErrorKbn.OK, "処理結果区分");

        exBizCalcbleEquals(keisanTmHntiSisuuRendouTmttkn.getSisuurendoutmttkngk(), BizCurrency.valueOf(8753473022.06, BizCurrencyTypes.DOLLAR), "指数連動積立金額");

        exBizCalcbleEquals(keisanTmHntiSisuuRendouTmttkn.getSisuuUpRitu(), BizNumber.valueOf(7.0003600134), "指数上昇率");

        exBizCalcbleEquals(keisanTmHntiSisuuRendouTmttkn.getTmttknZoukaRitu(), BizNumber.valueOf(6.0903132117), "積立金増加率");

    }

    @Test
    @TestOrder(60)
    public void testExec2_A6() {

        String syouhnCd = "ﾕﾍ";

        C_Tuukasyu kyktuukasyu = C_Tuukasyu.JPY;

        BizNumber tmmsHanteiYmdSisuu = BizNumber.valueOf(20044.41008);

        BizNumber tykzenTmmsHanteiYmdSisuu = BizNumber.valueOf(20030.36987);

        BizNumber setteiBairitu = BizNumber.ZERO;

        BizNumber tmttknZoukarituJygn = BizNumber.valueOf(0.1234);

        BizCurrency sisuuRendouTmttKngk = BizCurrency.valueOf(1234567, BizCurrencyTypes.YEN);

        BizNumber rendouRitu = BizNumber.valueOf(1.23);

        C_ErrorKbn result = keisanTmHntiSisuuRendouTmttkn.exec(syouhnCd, kyktuukasyu, tmmsHanteiYmdSisuu,
            tykzenTmmsHanteiYmdSisuu, setteiBairitu, tmttknZoukarituJygn, sisuuRendouTmttKngk, rendouRitu);

        exClassificationEquals(result, C_ErrorKbn.OK, "処理結果区分");

        exBizCalcbleEquals(keisanTmHntiSisuuRendouTmttkn.getSisuurendoutmttkngk(), BizCurrency.valueOf(1235632, BizCurrencyTypes.YEN), "指数連動積立金額");

        exBizCalcbleEquals(keisanTmHntiSisuuRendouTmttkn.getSisuuUpRitu(), BizNumber.valueOf(0.0007009461), "指数上昇率");

        exBizCalcbleEquals(keisanTmHntiSisuuRendouTmttkn.getTmttknZoukaRitu(), BizNumber.valueOf(0.0008621637), "積立金増加率");

    }
}
