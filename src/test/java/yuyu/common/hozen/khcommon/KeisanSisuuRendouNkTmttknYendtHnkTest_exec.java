package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_ErrorKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約保全 契約保全共通 円建変更後積立金計算クラス
 *  {@link KeisanSisuuRendouNkTmttknYendtHnk#exec(BizDate, BizDateYM, BizDate, BizDateYM, BizDate,
        Integer, BizCurrency, BizNumber)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanSisuuRendouNkTmttknYendtHnkTest_exec {

    @Inject
    private KeisanSisuuRendouNkTmttknYendtHnk keisanSisuuRendouNkTmttknYendtHnk;

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        BizDate pCalckijyunYmd = BizDate.valueOf(20180506);
        BizDateYM pCalcKijyunYm = BizDateYM.valueOf(201805);
        BizDate pYendthnkYmd = BizDate.valueOf(20180507);
        BizDateYM pYendthnkYm= BizDateYM.valueOf(201801);
        BizDate pKykYmd = BizDate.valueOf(20180607);
        Integer pHknkkn = 1;
        BizCurrency pKihons = BizCurrency.valueOf(10000);
        BizNumber pTumitateRiritu = BizNumber.valueOf(0.12345);

        C_ErrorKbn kekkaKb = keisanSisuuRendouNkTmttknYendtHnk.exec(pCalckijyunYmd,
            pCalcKijyunYm,
            pYendthnkYmd,
            pYendthnkYm,
            pKykYmd,
            pHknkkn,
            pKihons,
            pTumitateRiritu);

        exClassificationEquals(kekkaKb, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        BizDate pCalckijyunYmd = BizDate.valueOf(20170227);
        BizDateYM pCalcKijyunYm = BizDateYM.valueOf(201805);
        BizDate pYendthnkYmd = BizDate.valueOf(20170227);
        BizDateYM pYendthnkYm= BizDateYM.valueOf(201701);
        BizDate pKykYmd = BizDate.valueOf(20160229);
        Integer pHknkkn = 1;
        BizCurrency pKihons = BizCurrency.valueOf(10000);
        BizNumber pTumitateRiritu = BizNumber.valueOf(0.12345);
        C_ErrorKbn kekkaKb = keisanSisuuRendouNkTmttknYendtHnk.exec(pCalckijyunYmd,
            pCalcKijyunYm,
            pYendthnkYmd,
            pYendthnkYm,
            pKykYmd,
            pHknkkn,
            pKihons,
            pTumitateRiritu);

        exClassificationEquals(kekkaKb, C_ErrorKbn.OK, "結果区分");
        exNumericEquals(keisanSisuuRendouNkTmttknYendtHnk.getKeikanensu(), 0, "経過年数");
        exNumericEquals(keisanSisuuRendouNkTmttknYendtHnk.getKeikatukisu(), 1, "経過年月");
        exBizCalcbleEquals(keisanSisuuRendouNkTmttknYendtHnk.getTumitategk(), BizCurrency.valueOf(10098), "積立金額");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        BizDate pCalckijyunYmd = BizDate.valueOf(20180506);
        BizDateYM pCalcKijyunYm = BizDateYM.valueOf(201805);
        BizDate pYendthnkYmd = BizDate.valueOf(20180505);
        BizDateYM pYendthnkYm= BizDateYM.valueOf(201606);
        BizDate pKykYmd = BizDate.valueOf(20160506);
        Integer pHknkkn = 2;
        BizCurrency pKihons = BizCurrency.valueOf(10000);
        BizNumber pTumitateRiritu = BizNumber.valueOf(0.12345);
        C_ErrorKbn kekkaKb = keisanSisuuRendouNkTmttknYendtHnk.exec(pCalckijyunYmd,
            pCalcKijyunYm,
            pYendthnkYmd,
            pYendthnkYm,
            pKykYmd,
            pHknkkn,
            pKihons,
            pTumitateRiritu);

        exClassificationEquals(kekkaKb, C_ErrorKbn.OK, "結果区分");
        exNumericEquals(keisanSisuuRendouNkTmttknYendtHnk.getKeikanensu(), 1, "経過年数");
        exNumericEquals(keisanSisuuRendouNkTmttknYendtHnk.getKeikatukisu(), 11, "経過年月");
        exBizCalcbleEquals(keisanSisuuRendouNkTmttknYendtHnk.getTumitategk(),
            BizCurrency.valueOf(12501), "積立金額");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        BizDate pCalckijyunYmd = BizDate.valueOf(20180506);
        BizDateYM pCalcKijyunYm = BizDateYM.valueOf(202104);
        BizDate pYendthnkYmd = BizDate.valueOf(20180407);
        BizDateYM pYendthnkYm= BizDateYM.valueOf(201806);
        BizDate pKykYmd = BizDate.valueOf(20170606);
        Integer pHknkkn = 2;
        BizCurrency pKihons = BizCurrency.valueOf(10000);
        BizNumber pTumitateRiritu = BizNumber.valueOf(0.12345);
        C_ErrorKbn kekkaKb = keisanSisuuRendouNkTmttknYendtHnk.exec(pCalckijyunYmd,
            pCalcKijyunYm,
            pYendthnkYmd,
            pYendthnkYm,
            pKykYmd,
            pHknkkn,
            pKihons,
            pTumitateRiritu);

        exClassificationEquals(kekkaKb, C_ErrorKbn.OK, "結果区分");
        exNumericEquals(keisanSisuuRendouNkTmttknYendtHnk.getKeikanensu(), 3, "経過年数");
        exNumericEquals(keisanSisuuRendouNkTmttknYendtHnk.getKeikatukisu(), 0, "経過年月");
        exBizCalcbleEquals(keisanSisuuRendouNkTmttknYendtHnk.getTumitategk(), BizCurrency.valueOf(14181), "積立金額");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        BizDate pCalckijyunYmd = BizDate.valueOf(20170227);
        BizDateYM pCalcKijyunYm = BizDateYM.valueOf(201805);
        BizDate pYendthnkYmd = BizDate.valueOf(20170227);
        BizDateYM pYendthnkYm= BizDateYM.valueOf(201701);
        BizDate pKykYmd = BizDate.valueOf(20160226);
        Integer pHknkkn = 1;
        BizCurrency pKihons = BizCurrency.valueOf(10000);
        BizNumber pTumitateRiritu = BizNumber.valueOf(0.12345);
        C_ErrorKbn kekkaKb = keisanSisuuRendouNkTmttknYendtHnk.exec(pCalckijyunYmd,
            pCalcKijyunYm,
            pYendthnkYmd,
            pYendthnkYm,
            pKykYmd,
            pHknkkn,
            pKihons,
            pTumitateRiritu);

        exClassificationEquals(kekkaKb, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        BizDate pCalckijyunYmd = BizDate.valueOf(20180506);
        BizDateYM pCalcKijyunYm = BizDateYM.valueOf(202104);
        BizDate pYendthnkYmd = BizDate.valueOf(20180407);
        BizDateYM pYendthnkYm= BizDateYM.valueOf(201806);
        BizDate pKykYmd = BizDate.valueOf(20170606);
        Integer pHknkkn = 99;
        BizCurrency pKihons = BizCurrency.valueOf(10000);
        BizNumber pTumitateRiritu = BizNumber.valueOf(0.12345);
        C_ErrorKbn kekkaKb = keisanSisuuRendouNkTmttknYendtHnk.exec(pCalckijyunYmd,
            pCalcKijyunYm,
            pYendthnkYmd,
            pYendthnkYm,
            pKykYmd,
            pHknkkn,
            pKihons,
            pTumitateRiritu);

        exClassificationEquals(kekkaKb, C_ErrorKbn.OK, "結果区分");
        exNumericEquals(keisanSisuuRendouNkTmttknYendtHnk.getKeikanensu(), 3, "経過年数");
        exNumericEquals(keisanSisuuRendouNkTmttknYendtHnk.getKeikatukisu(), 0, "経過年月");
        exBizCalcbleEquals(keisanSisuuRendouNkTmttknYendtHnk.getTumitategk(), BizCurrency.valueOf(14181), "積立金額");
    }
}
