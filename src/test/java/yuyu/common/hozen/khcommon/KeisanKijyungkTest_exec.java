package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_KwsrendouKbn;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_KawaseRate;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約保全 契約保全共通 基準金額計算クラスのメソッド
 *  {@link KeisanKijyungk#exec(BizDate, BizCurrency, BizCurrency, C_Tuukasyu, C_Tkhukaumu)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanKijyungkTest_exec {

    @Inject
    private KeisanKijyungk KeisanKijyungk;

    //    @BeforeClass
    //    public static void testInit() {
    //        IwfImageClientMock.caller = "Test";
    //    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        BM_KawaseRate kawaseRate1 = bizDomManager.getKawaseRate(BizDate.valueOf(20170404),
            C_KwsrendouKbn.KOUJIKAWASERATE1, C_Tuukasyu.USD, C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTM, C_KawasetsryKbn.NYUKINRATE);

        if (kawaseRate1 == null) {
            BM_KawaseRate kawaseRate = new BM_KawaseRate();
            kawaseRate.setKwsratekjymd(BizDate.valueOf(20170404));
            kawaseRate.setKwsrendoukbn(C_KwsrendouKbn.KOUJIKAWASERATE1);
            kawaseRate.setMototuuka(C_Tuukasyu.USD);
            kawaseRate.setKanzantuuka(C_Tuukasyu.JPY);
            kawaseRate.setKawasetekiyokbn(C_KawasetekiyoKbn.TTM);
            kawaseRate.setKawasetsrykbn(C_KawasetsryKbn.NYUKINRATE);
            kawaseRate.setKawaserate(BizNumber.valueOf(1.3333));
            bizDomManager.insert(kawaseRate);
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllKawaseRate());
    }
    @Test
    @TestOrder(10)
    public void testExec_A1() {

        BizDate pPryousyuuymd = BizDate.valueOf(20170406);

        BizCurrency pRsgaku = BizCurrency.valueOf(100, BizCurrencyTypes.YEN);

        BizCurrency pHokenryou = BizCurrency.valueOf(1000, BizCurrencyTypes.DOLLAR);

        C_Tuukasyu kyktuukasyu = C_Tuukasyu.USD;

        C_Tkhukaumu yennykntkhkkbn = C_Tkhukaumu.HUKA;

        C_ErrorKbn result = KeisanKijyungk.exec(pPryousyuuymd,
            pRsgaku, pHokenryou, kyktuukasyu, yennykntkhkkbn);

        exClassificationEquals(result, C_ErrorKbn.OK, "処理結果区分");

        exBizCalcbleEquals(KeisanKijyungk.getKijyungk(), BizCurrency.valueOf(100, BizCurrencyTypes.YEN), "基準金額");

        exBizCalcbleEquals(KeisanKijyungk.getYenkawaserate(), null, "円換算為替レート");

    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        BizDate pPryousyuuymd = BizDate.valueOf(20170404);

        BizCurrency pRsgaku = BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR);

        BizCurrency pHokenryou = BizCurrency.valueOf(1000, BizCurrencyTypes.DOLLAR);

        C_Tuukasyu kyktuukasyu = C_Tuukasyu.USD;

        C_Tkhukaumu yennykntkhkkbn = C_Tkhukaumu.NONE;

        C_ErrorKbn result = KeisanKijyungk.exec(pPryousyuuymd,
            pRsgaku, pHokenryou, kyktuukasyu, yennykntkhkkbn);

        exClassificationEquals(result, C_ErrorKbn.OK, "処理結果区分");

        exBizCalcbleEquals(KeisanKijyungk.getKijyungk(), BizCurrency.valueOf(1334, BizCurrencyTypes.YEN), "基準金額");

        exBizCalcbleEquals(KeisanKijyungk.getYenkawaserate(), BizNumber.valueOf(1.3333), "円換算為替レート");

    }
    @Test
    @TestOrder(30)
    public void testExec_A3() {

        BizDate pPryousyuuymd = BizDate.valueOf(20170406);

        BizCurrency pRsgaku = BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR);

        BizCurrency pHokenryou = BizCurrency.valueOf(1000, BizCurrencyTypes.DOLLAR);

        C_Tuukasyu kyktuukasyu = C_Tuukasyu.USD;

        C_Tkhukaumu yennykntkhkkbn = C_Tkhukaumu.NONE;

        C_ErrorKbn result = KeisanKijyungk.exec(pPryousyuuymd,
            pRsgaku, pHokenryou, kyktuukasyu, yennykntkhkkbn);

        exClassificationEquals(result, C_ErrorKbn.ERROR, "処理結果区分");

        exBizCalcbleEquals(KeisanKijyungk.getKijyungk(), null, "基準金額");

        exBizCalcbleEquals(KeisanKijyungk.getYenkawaserate(), null, "円換算為替レート");

    }
}
