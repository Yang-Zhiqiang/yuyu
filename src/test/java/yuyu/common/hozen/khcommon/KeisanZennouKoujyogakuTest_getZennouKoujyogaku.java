package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 前納控除証明額計算クラスのメソッド {@link KeisanZennouKoujyogaku#getZennouKoujyogaku(BizCurrency,String,BizDate,
 * BizCurrency,C_Hrkkaisuu,BizDateYM,int,int)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanZennouKoujyogakuTest_getZennouKoujyogaku {

    @Inject
    private KeisanZennouKoujyogaku keisanZennouKoujyogaku;

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(JtKaisukeisan.class).to(JtKaisukeisanMockForKhansyuu.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        JtKaisukeisanMockForKhansyuu.caller = KeisanZennouKoujyogakuTest_getZennouKoujyogaku.class;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        JtKaisukeisanMockForKhansyuu.caller = null;
    }

    @Test
    @TestOrder(10)
    public void testGetZennouKoujyogaku_A1() {

        BizCurrency kjsmyouZennounyuuKinkGk = BizCurrency.valueOf(150000);
        String kjsmyouzennouKikanm = "5";
        BizDate kjsmyouzennoukaisiYmd = BizDate.valueOf(20181001);
        BizCurrency hrkp = BizCurrency.valueOf(200000);
        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.TUKI;
        BizDateYM syoumeistartYm = BizDateYM.valueOf(201808);
        int syomeiKaisuuY = 0;
        int syomeiKaisuuM = 0;

        BizCurrency zennouKoujyogaku = keisanZennouKoujyogaku.getZennouKoujyogaku(kjsmyouZennounyuuKinkGk,
            kjsmyouzennouKikanm, kjsmyouzennoukaisiYmd, hrkp, hrkkaisuu, syoumeistartYm, syomeiKaisuuY,
            syomeiKaisuuM);

        exBizCalcbleEquals(zennouKoujyogaku, BizCurrency.valueOf(0), "前納控除証明総額");

    }

    @Test
    @TestOrder(20)
    public void testGetZennouKoujyogaku_A2() {
        JtKaisukeisanMockForKhansyuu.SYORIPTN = JtKaisukeisanMockForKhansyuu.TESTPATTERN1;
        BizCurrency kjsmyouZennounyuuKinkGk = BizCurrency.valueOf(150000.8);
        String kjsmyouzennouKikanm = "5";
        BizDate kjsmyouzennoukaisiYmd = BizDate.valueOf(20181101);
        BizCurrency hrkp = BizCurrency.valueOf(200000);
        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.HALFY;
        BizDateYM syoumeistartYm = BizDateYM.valueOf(201810);
        int syomeiKaisuuY = 0;
        int syomeiKaisuuM = 5;

        BizCurrency zennouKoujyogaku = keisanZennouKoujyogaku.getZennouKoujyogaku(kjsmyouZennounyuuKinkGk,
            kjsmyouzennouKikanm, kjsmyouzennoukaisiYmd, hrkp, hrkkaisuu, syoumeistartYm, syomeiKaisuuY,
            syomeiKaisuuM);

        exBizCalcbleEquals(zennouKoujyogaku, BizCurrency.valueOf(237500), "前納控除証明総額");

    }

    @Test
    @TestOrder(30)
    public void testGetZennouKoujyogaku_A3() {
        JtKaisukeisanMockForKhansyuu.SYORIPTN = JtKaisukeisanMockForKhansyuu.TESTPATTERN2;
        BizCurrency kjsmyouZennounyuuKinkGk = BizCurrency.valueOf(150000);
        String kjsmyouzennouKikanm = "5";
        BizDate kjsmyouzennoukaisiYmd = BizDate.valueOf(20180931);
        BizCurrency hrkp = BizCurrency.valueOf(200000);
        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.HALFY;
        BizDateYM syoumeistartYm = BizDateYM.valueOf(201810);
        int syomeiKaisuuY = 5;
        int syomeiKaisuuM = 0;

        BizCurrency zennouKoujyogaku = keisanZennouKoujyogaku.getZennouKoujyogaku(kjsmyouZennounyuuKinkGk,
            kjsmyouzennouKikanm, kjsmyouzennoukaisiYmd, hrkp, hrkkaisuu, syoumeistartYm, syomeiKaisuuY,
            syomeiKaisuuM);

        exBizCalcbleEquals(zennouKoujyogaku, BizCurrency.valueOf(90000), "前納控除証明総額");
    }

    @Test
    @TestOrder(40)
    public void testGetZennouKoujyogaku_A4() {

        MockObjectManager.initialize();
        JtKaisukeisanMockForKhansyuu.SYORIPTN = JtKaisukeisanMockForKhansyuu.TESTPATTERN3;
        BizCurrency kjsmyouZennounyuuKinkGk = BizCurrency.valueOf(150000);
        String kjsmyouzennouKikanm = "5";
        BizDate kjsmyouzennoukaisiYmd = BizDate.valueOf(20181001);
        BizCurrency hrkp = BizCurrency.valueOf(200000);
        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.HALFY;
        BizDateYM syoumeistartYm = BizDateYM.valueOf(201810);
        int syomeiKaisuuY = 5;
        int syomeiKaisuuM = 10;

        BizCurrency zennouKoujyogaku = keisanZennouKoujyogaku.getZennouKoujyogaku(kjsmyouZennounyuuKinkGk,
            kjsmyouzennouKikanm, kjsmyouzennoukaisiYmd, hrkp, hrkkaisuu, syoumeistartYm, syomeiKaisuuY,
            syomeiKaisuuM);

        exBizCalcbleEquals(zennouKoujyogaku, BizCurrency.valueOf(165000), "前納控除証明総額");

        exNumericEquals((Integer) MockObjectManager.getArgument(JtKaisukeisanMockForKhansyuu.class, "exec", 0, 0),
            Integer.valueOf(5), "証明回数（年）");
        exNumericEquals((Integer) MockObjectManager.getArgument(JtKaisukeisanMockForKhansyuu.class, "exec", 0, 1),
            Integer.valueOf(10), "証明回数（月）");
        exClassificationEquals((C_Hrkkaisuu) MockObjectManager.getArgument(JtKaisukeisanMockForKhansyuu.class, "exec", 0, 2),
            C_Hrkkaisuu.HALFY, "払込回数");

    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(50)
    public void testGetZennouKoujyogaku_A5() {

        try {
            JtKaisukeisanMockForKhansyuu.SYORIPTN = JtKaisukeisanMockForKhansyuu.TESTPATTERN1;
            BizCurrency kjsmyouZennounyuuKinkGk = BizCurrency.valueOf(150000.8);
            String kjsmyouzennouKikanm = "5";
            BizDate kjsmyouzennoukaisiYmd = BizDate.valueOf(20181101);
            BizCurrency hrkp = BizCurrency.valueOf(200000, BizCurrencyTypes.DOLLAR);
            C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.HALFY;
            BizDateYM syoumeistartYm = BizDateYM.valueOf(201810);
            int syomeiKaisuuY = 0;
            int syomeiKaisuuM = 5;
            keisanZennouKoujyogaku.setKjsmyouYenKawaserate(null);

            keisanZennouKoujyogaku.getZennouKoujyogaku(kjsmyouZennounyuuKinkGk,
                kjsmyouzennouKikanm, kjsmyouzennoukaisiYmd, hrkp, hrkkaisuu, syoumeistartYm, syomeiKaisuuY,
                syomeiKaisuuM);

        }catch (Exception e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。控除証明用前納情報設定　与件エラー　控除証明用円換算為替レート＝null", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(60)
    public void testGetZennouKoujyogaku_A6() {
        JtKaisukeisanMockForKhansyuu.SYORIPTN = JtKaisukeisanMockForKhansyuu.TESTPATTERN1;
        BizCurrency kjsmyouZennounyuuKinkGk = BizCurrency.valueOf(150000.8);
        String kjsmyouzennouKikanm = "5";
        BizDate kjsmyouzennoukaisiYmd = BizDate.valueOf(20181101);
        BizCurrency hrkp = BizCurrency.valueOf(200000, BizCurrencyTypes.DOLLAR);
        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.HALFY;
        BizDateYM syoumeistartYm = BizDateYM.valueOf(201810);
        int syomeiKaisuuY = 0;
        int syomeiKaisuuM = 5;
        keisanZennouKoujyogaku.setKjsmyouYenKawaserate(BizNumber.valueOf(12));

        BizCurrency zennouKoujyogaku = keisanZennouKoujyogaku.getZennouKoujyogaku(kjsmyouZennounyuuKinkGk,
            kjsmyouzennouKikanm, kjsmyouzennoukaisiYmd, hrkp, hrkkaisuu, syoumeistartYm, syomeiKaisuuY,
            syomeiKaisuuM);

        exBizCalcbleEquals(zennouKoujyogaku, BizCurrency.valueOf(2437500), "前納控除証明総額");

    }
}
