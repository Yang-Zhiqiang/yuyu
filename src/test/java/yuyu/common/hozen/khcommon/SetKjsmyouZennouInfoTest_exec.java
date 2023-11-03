package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SetKjsmyouZennouInfoクラスのメソッド {@link SetKjsmyouZennouInfo#exec(BizDate,String,BizCurrency,C_Hrkkaisuu,BizCurrency,C_UmuKbn)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class SetKjsmyouZennouInfoTest_exec {

    private final static BizDate zennoujijyutoustartymd = BizDate.valueOf("20181101");

    private final static String zennoujijytukikan = "1";

    private final static BizCurrency zennoujipnyknkgk = BizCurrency.valueOf(1000);

    private final static BizCurrency hrkp = BizCurrency.valueOf(500);

    private final static BizDate yenkaknsnKijyunymd = BizDate.valueOf(20200814);

    private final static BizNumber yenknsnKawaseRate = BizNumber.valueOf(6.78);

    @Inject
    private SetKjsmyouZennouInfo setKjsmyouZennouInfo;

    @Test(expected = CommonBizAppException.class)
    @TestOrder(10)
    public void testExec_A1() {

        try {
            setKjsmyouZennouInfo.setYenkaknsnKijyunymd(yenkaknsnKijyunymd);
            setKjsmyouZennouInfo.setYenknsnKawaseRate(yenknsnKawaseRate);

            setKjsmyouZennouInfo.exec(zennoujijyutoustartymd, zennoujijytukikan, zennoujipnyknkgk,
                C_Hrkkaisuu.HALFY, hrkp, C_UmuKbn.ARI);

        } catch (Exception e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。控除証明用前納情報設定　与件エラー　払込回数＝年２回払", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        setKjsmyouZennouInfo.setYenkaknsnKijyunymd(yenkaknsnKijyunymd);
        setKjsmyouZennouInfo.setYenknsnKawaseRate(yenknsnKawaseRate);

        C_ErrorKbn kekkakbn = setKjsmyouZennouInfo.exec(zennoujijyutoustartymd, zennoujijytukikan,
            zennoujipnyknkgk, C_Hrkkaisuu.TUKI, hrkp, C_UmuKbn.ARI);

        exDateEquals(setKjsmyouZennouInfo.getKjsmyouzennoukaisiymd(), BizDate.valueOf("20181201"), "控除証明用前納開始年月日");
        exStringEquals(setKjsmyouZennouInfo.getKjsmyouzennoukikanm(), "11", "控除証明用前納期間（月）");
        exBizCalcbleEquals(setKjsmyouZennouInfo.getKjsmyouzennounyuukinkgk(), BizCurrency.valueOf(500), "控除証明用前納入金額");
        exDateEquals(setKjsmyouZennouInfo.getKjsmyouenknsnkijyunymd(), null, "控除証明用円換算レート基準日");
        exBizCalcbleEquals(setKjsmyouZennouInfo.getKjsmyouenknsnrate(), BizNumber.valueOf(0), "控除証明用円換算為替レート");
        exClassificationEquals(kekkakbn, C_ErrorKbn.OK, "結果区分");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        setKjsmyouZennouInfo.setYenkaknsnKijyunymd(yenkaknsnKijyunymd);
        setKjsmyouZennouInfo.setYenknsnKawaseRate(yenknsnKawaseRate);

        C_ErrorKbn kekkakbn = setKjsmyouZennouInfo.exec(zennoujijyutoustartymd, zennoujijytukikan,
            zennoujipnyknkgk, C_Hrkkaisuu.NEN, hrkp, C_UmuKbn.ARI);

        exDateEquals(setKjsmyouZennouInfo.getKjsmyouzennoukaisiymd(), BizDate.valueOf("20191101"), "控除証明用前納開始年月日");
        exStringEquals(setKjsmyouZennouInfo.getKjsmyouzennoukikanm(), "0", "控除証明用前納期間（月）");
        exBizCalcbleEquals(setKjsmyouZennouInfo.getKjsmyouzennounyuukinkgk(), BizCurrency.valueOf(500), "控除証明用前納入金額");
        exDateEquals(setKjsmyouZennouInfo.getKjsmyouenknsnkijyunymd(), null, "控除証明用円換算レート基準日");
        exBizCalcbleEquals(setKjsmyouZennouInfo.getKjsmyouenknsnrate(), BizNumber.valueOf(0), "控除証明用円換算為替レート");
        exClassificationEquals(kekkakbn, C_ErrorKbn.OK, "結果区分");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        setKjsmyouZennouInfo.setYenkaknsnKijyunymd(yenkaknsnKijyunymd);
        setKjsmyouZennouInfo.setYenknsnKawaseRate(yenknsnKawaseRate);

        C_ErrorKbn kekkakbn = setKjsmyouZennouInfo.exec(zennoujijyutoustartymd, zennoujijytukikan,
            zennoujipnyknkgk, C_Hrkkaisuu.HALFY, hrkp, C_UmuKbn.NONE);

        exDateEquals(setKjsmyouZennouInfo.getKjsmyouzennoukaisiymd(), BizDate.valueOf("20181101"), "控除証明用前納開始年月日");
        exStringEquals(setKjsmyouZennouInfo.getKjsmyouzennoukikanm(), "12", "控除証明用前納期間（月）");
        exBizCalcbleEquals(setKjsmyouZennouInfo.getKjsmyouzennounyuukinkgk(), BizCurrency.valueOf(1000), "控除証明用前納入金額");
        exDateEquals(setKjsmyouZennouInfo.getKjsmyouenknsnkijyunymd(), null, "控除証明用円換算レート基準日");
        exBizCalcbleEquals(setKjsmyouZennouInfo.getKjsmyouenknsnrate(), BizNumber.valueOf(0), "控除証明用円換算為替レート");
        exClassificationEquals(kekkakbn, C_ErrorKbn.OK, "結果区分");
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(50)
    public void testExec_A5() {

        try {

            setKjsmyouZennouInfo.exec(zennoujijyutoustartymd, zennoujijytukikan, zennoujipnyknkgk,
                C_Hrkkaisuu.HALFY, BizCurrency.valueOf(1000, BizCurrencyTypes.DOLLAR), C_UmuKbn.ARI);

        } catch (Exception e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。控除証明用前納情報設定　与件エラー　円換算基準日＝null", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        setKjsmyouZennouInfo.setYenkaknsnKijyunymd(yenkaknsnKijyunymd);
        setKjsmyouZennouInfo.setYenknsnKawaseRate(yenknsnKawaseRate);

        C_ErrorKbn kekkakbn = setKjsmyouZennouInfo.exec(zennoujijyutoustartymd, zennoujijytukikan,
            BizCurrency.valueOf(1500, BizCurrencyTypes.DOLLAR), C_Hrkkaisuu.NEN,
            BizCurrency.valueOf(1000, BizCurrencyTypes.DOLLAR), C_UmuKbn.ARI);

        exDateEquals(setKjsmyouZennouInfo.getKjsmyouzennoukaisiymd(), BizDate.valueOf("20191101"), "控除証明用前納開始年月日");
        exStringEquals(setKjsmyouZennouInfo.getKjsmyouzennoukikanm(), "0", "控除証明用前納期間（月）");
        exBizCalcbleEquals(setKjsmyouZennouInfo.getKjsmyouzennounyuukinkgk(), BizCurrency.valueOf(3390), "控除証明用前納入金額");
        exDateEquals(setKjsmyouZennouInfo.getKjsmyouenknsnkijyunymd(), BizDate.valueOf("20200814"), "控除証明用円換算レート基準日");
        exBizCalcbleEquals(setKjsmyouZennouInfo.getKjsmyouenknsnrate(), BizNumber.valueOf(6.78), "控除証明用円換算為替レート");
        exClassificationEquals(kekkakbn, C_ErrorKbn.OK, "結果区分");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        setKjsmyouZennouInfo.setYenkaknsnKijyunymd(yenkaknsnKijyunymd);
        setKjsmyouZennouInfo.setYenknsnKawaseRate(yenknsnKawaseRate);

        C_ErrorKbn kekkakbn = setKjsmyouZennouInfo.exec(zennoujijyutoustartymd, zennoujijytukikan,
            BizCurrency.valueOf(10000, BizCurrencyTypes.YEN), C_Hrkkaisuu.TUKI,
            BizCurrency.valueOf(1000, BizCurrencyTypes.DOLLAR), C_UmuKbn.ARI);

        exDateEquals(setKjsmyouZennouInfo.getKjsmyouzennoukaisiymd(), BizDate.valueOf("20181201"), "控除証明用前納開始年月日");
        exStringEquals(setKjsmyouZennouInfo.getKjsmyouzennoukikanm(), "11", "控除証明用前納期間（月）");
        exBizCalcbleEquals(setKjsmyouZennouInfo.getKjsmyouzennounyuukinkgk(), BizCurrency.valueOf(3220), "控除証明用前納入金額");
        exDateEquals(setKjsmyouZennouInfo.getKjsmyouenknsnkijyunymd(), BizDate.valueOf(20200814), "控除証明用円換算レート基準日");
        exBizCalcbleEquals(setKjsmyouZennouInfo.getKjsmyouenknsnrate(), BizNumber.valueOf(6.78), "控除証明用円換算為替レート");
        exClassificationEquals(kekkakbn, C_ErrorKbn.OK, "結果区分");
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(80)
    public void testExec_A8() {

        try {

            setKjsmyouZennouInfo.setYenkaknsnKijyunymd(yenkaknsnKijyunymd);
            setKjsmyouZennouInfo.setYenknsnKawaseRate(null);

            setKjsmyouZennouInfo.exec(zennoujijyutoustartymd, zennoujijytukikan,
                zennoujipnyknkgk, C_Hrkkaisuu.HALFY,
                BizCurrency.valueOf(1000, BizCurrencyTypes.DOLLAR), C_UmuKbn.ARI);

        } catch (Exception e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。控除証明用前納情報設定　与件エラー　円換算為替レート＝null", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(90)
    public void testExec_A9() {

        try {

            setKjsmyouZennouInfo.setYenkaknsnKijyunymd(yenkaknsnKijyunymd);
            setKjsmyouZennouInfo.setYenknsnKawaseRate(BizNumber.ZERO);

            setKjsmyouZennouInfo.exec(zennoujijyutoustartymd, zennoujijytukikan,
                zennoujipnyknkgk, C_Hrkkaisuu.HALFY,
                BizCurrency.valueOf(1000, BizCurrencyTypes.DOLLAR), C_UmuKbn.ARI);

        } catch (Exception e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。控除証明用前納情報設定　与件エラー　円換算為替レート＝0", "エラーメッセージ");
            throw e;
        }
    }
}
