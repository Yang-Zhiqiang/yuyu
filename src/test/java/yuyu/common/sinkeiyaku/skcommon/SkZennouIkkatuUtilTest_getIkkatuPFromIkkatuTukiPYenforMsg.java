package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.hozen.khcommon.KeisanIkkatuNyuukinGkBean;
import yuyu.common.hozen.khcommon.KeisanTukiIkkatuNyuukinGk;
import yuyu.common.hozen.khcommon.KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku;
import yuyu.def.classification.C_IkkatubaraiKaisuuKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 新契約前納一括払関連ユーティリティクラスのメソッド {@link SkZennouIkkatuUtil#getIkkatuPFromIkkatuTukiPYenforMsg(
        boolean maxkngkkansflg,String syusyouhncd,Integer syusyouhnsdno,String syuryouritusdno,
        BizCurrency teikiikkatutkbrip,BizCurrency tkbrihrkptani,C_IkkatubaraiKaisuuKbn ikkatubaraikaisuu,
        int ikkatupsiteitaniskru)} テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class SkZennouIkkatuUtilTest_getIkkatuPFromIkkatuTukiPYenforMsg {

    @Inject
    private SkZennouIkkatuUtil skZennouIkkatuUtil;

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {

                bind(KeisanTukiIkkatuNyuukinGk.class).to(KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.class);

            }
        });
    }

    @BeforeClass
    public static void testInit() {

        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.caller = SkZennouIkkatuUtilTest_getIkkatuPFromIkkatuTukiPYenforMsg.class;
    }

    @AfterClass
    public static void testClear() {

        MockObjectManager.initialize();

        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.caller = null;
        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = null;
    }

    @Test
    @TestOrder(10)
    public void testgetIkkatuPFromIkkatuTukiPYenforMsg_A1() {

        boolean maxkngkkansflg = true;

        String syusyouhncd = null;

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        BizCurrency teikiikkatutkbrip = BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);

        BizCurrency tkbrihrkptani = BizCurrency.valueOf(2000000, BizCurrencyTypes.YEN);

        C_IkkatubaraiKaisuuKbn ikkatubaraikaisuu = C_IkkatubaraiKaisuuKbn.IKKATU6;

        int ikkatupsiteitaniskru = 1;

        BizCurrency hrkptani = skZennouIkkatuUtil.getIkkatuPFromIkkatuTukiPYenforMsg( maxkngkkansflg, syusyouhncd, syusyouhnsdno, syuryouritusdno,
            teikiikkatutkbrip, tkbrihrkptani, ikkatubaraikaisuu, ikkatupsiteitaniskru);

        exBizCalcbleEquals(hrkptani, BizCurrency.valueOf(0), "定期一括払Ｐ");
    }

    @Test
    @TestOrder(20)
    public void testgetIkkatuPFromIkkatuTukiPYenforMsg_A2() {

        boolean maxkngkkansflg = true;

        String syusyouhncd = "";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        BizCurrency teikiikkatutkbrip = BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);

        BizCurrency tkbrihrkptani = BizCurrency.valueOf(2000000, BizCurrencyTypes.YEN);

        C_IkkatubaraiKaisuuKbn ikkatubaraikaisuu = C_IkkatubaraiKaisuuKbn.IKKATU6;

        int ikkatupsiteitaniskru = 1;

        BizCurrency hrkptani = skZennouIkkatuUtil.getIkkatuPFromIkkatuTukiPYenforMsg( maxkngkkansflg, syusyouhncd, syusyouhnsdno, syuryouritusdno,
            teikiikkatutkbrip, tkbrihrkptani, ikkatubaraikaisuu, ikkatupsiteitaniskru);

        exBizCalcbleEquals(hrkptani, BizCurrency.valueOf(0), "定期一括払Ｐ");
    }

    @Test
    @TestOrder(30)
    public void testgetIkkatuPFromIkkatuTukiPYenforMsg_A3() {

        boolean maxkngkkansflg = true;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = null;

        String syuryouritusdno = "101";

        BizCurrency teikiikkatutkbrip = BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);

        BizCurrency tkbrihrkptani = BizCurrency.valueOf(2000000, BizCurrencyTypes.YEN);

        C_IkkatubaraiKaisuuKbn ikkatubaraikaisuu = C_IkkatubaraiKaisuuKbn.IKKATU6;

        int ikkatupsiteitaniskru = 1;

        BizCurrency hrkptani = skZennouIkkatuUtil.getIkkatuPFromIkkatuTukiPYenforMsg( maxkngkkansflg, syusyouhncd, syusyouhnsdno, syuryouritusdno,
            teikiikkatutkbrip, tkbrihrkptani, ikkatubaraikaisuu, ikkatupsiteitaniskru);

        exBizCalcbleEquals(hrkptani, BizCurrency.valueOf(0), "定期一括払Ｐ");
    }

    @Test
    @TestOrder(40)
    public void testgetIkkatuPFromIkkatuTukiPYenforMsg_A4() {

        boolean maxkngkkansflg = true;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 0;

        String syuryouritusdno = "101";

        BizCurrency teikiikkatutkbrip = BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);

        BizCurrency tkbrihrkptani = BizCurrency.valueOf(2000000, BizCurrencyTypes.YEN);

        C_IkkatubaraiKaisuuKbn ikkatubaraikaisuu = C_IkkatubaraiKaisuuKbn.IKKATU6;

        int ikkatupsiteitaniskru = 1;

        BizCurrency hrkptani = skZennouIkkatuUtil.getIkkatuPFromIkkatuTukiPYenforMsg( maxkngkkansflg, syusyouhncd, syusyouhnsdno, syuryouritusdno,
            teikiikkatutkbrip, tkbrihrkptani, ikkatubaraikaisuu, ikkatupsiteitaniskru);

        exBizCalcbleEquals(hrkptani, BizCurrency.valueOf(0), "定期一括払Ｐ");
    }

    @Test
    @TestOrder(50)
    public void testgetIkkatuPFromIkkatuTukiPYenforMsg_A5() {

        boolean maxkngkkansflg = true;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = -1;

        String syuryouritusdno = "101";

        BizCurrency teikiikkatutkbrip = BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);

        BizCurrency tkbrihrkptani = BizCurrency.valueOf(2000000, BizCurrencyTypes.YEN);

        C_IkkatubaraiKaisuuKbn ikkatubaraikaisuu = C_IkkatubaraiKaisuuKbn.IKKATU6;

        int ikkatupsiteitaniskru = 1;

        BizCurrency hrkptani = skZennouIkkatuUtil.getIkkatuPFromIkkatuTukiPYenforMsg( maxkngkkansflg, syusyouhncd, syusyouhnsdno, syuryouritusdno,
            teikiikkatutkbrip, tkbrihrkptani, ikkatubaraikaisuu, ikkatupsiteitaniskru);

        exBizCalcbleEquals(hrkptani, BizCurrency.valueOf(0), "定期一括払Ｐ");
    }

    @Test
    @TestOrder(60)
    public void testgetIkkatuPFromIkkatuTukiPYenforMsg_A6() {

        boolean maxkngkkansflg = true;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = null;

        BizCurrency teikiikkatutkbrip = BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);

        BizCurrency tkbrihrkptani = BizCurrency.valueOf(2000000, BizCurrencyTypes.YEN);

        C_IkkatubaraiKaisuuKbn ikkatubaraikaisuu = C_IkkatubaraiKaisuuKbn.IKKATU6;

        int ikkatupsiteitaniskru = 1;

        BizCurrency hrkptani = skZennouIkkatuUtil.getIkkatuPFromIkkatuTukiPYenforMsg( maxkngkkansflg, syusyouhncd, syusyouhnsdno, syuryouritusdno,
            teikiikkatutkbrip, tkbrihrkptani, ikkatubaraikaisuu, ikkatupsiteitaniskru);

        exBizCalcbleEquals(hrkptani, BizCurrency.valueOf(0), "定期一括払Ｐ");
    }

    @Test
    @TestOrder(70)
    public void testgetIkkatuPFromIkkatuTukiPYenforMsg_A7() {

        boolean maxkngkkansflg = true;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "";

        BizCurrency teikiikkatutkbrip = BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);

        BizCurrency tkbrihrkptani = BizCurrency.valueOf(2000000, BizCurrencyTypes.YEN);

        C_IkkatubaraiKaisuuKbn ikkatubaraikaisuu = C_IkkatubaraiKaisuuKbn.IKKATU6;

        int ikkatupsiteitaniskru = 1;

        BizCurrency hrkptani = skZennouIkkatuUtil.getIkkatuPFromIkkatuTukiPYenforMsg( maxkngkkansflg, syusyouhncd, syusyouhnsdno, syuryouritusdno,
            teikiikkatutkbrip, tkbrihrkptani, ikkatubaraikaisuu, ikkatupsiteitaniskru);

        exBizCalcbleEquals(hrkptani, BizCurrency.valueOf(0), "定期一括払Ｐ");
    }

    @Test
    @TestOrder(80)
    public void testgetIkkatuPFromIkkatuTukiPYenforMsg_A8() {

        boolean maxkngkkansflg = true;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        BizCurrency teikiikkatutkbrip = null;

        BizCurrency tkbrihrkptani = BizCurrency.valueOf(2000000, BizCurrencyTypes.YEN);

        C_IkkatubaraiKaisuuKbn ikkatubaraikaisuu = C_IkkatubaraiKaisuuKbn.IKKATU6;

        int ikkatupsiteitaniskru = 1;

        BizCurrency hrkptani = skZennouIkkatuUtil.getIkkatuPFromIkkatuTukiPYenforMsg( maxkngkkansflg, syusyouhncd, syusyouhnsdno, syuryouritusdno,
            teikiikkatutkbrip, tkbrihrkptani, ikkatubaraikaisuu, ikkatupsiteitaniskru);

        exBizCalcbleEquals(hrkptani, BizCurrency.valueOf(0), "定期一括払Ｐ");
    }

    @Test
    @TestOrder(90)
    public void testgetIkkatuPFromIkkatuTukiPYenforMsg_A9() {

        boolean maxkngkkansflg = true;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        BizCurrency teikiikkatutkbrip = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        BizCurrency tkbrihrkptani = BizCurrency.valueOf(2000000, BizCurrencyTypes.YEN);

        C_IkkatubaraiKaisuuKbn ikkatubaraikaisuu = C_IkkatubaraiKaisuuKbn.IKKATU6;

        int ikkatupsiteitaniskru = 1;

        BizCurrency hrkptani = skZennouIkkatuUtil.getIkkatuPFromIkkatuTukiPYenforMsg( maxkngkkansflg, syusyouhncd, syusyouhnsdno, syuryouritusdno,
            teikiikkatutkbrip, tkbrihrkptani, ikkatubaraikaisuu, ikkatupsiteitaniskru);

        exBizCalcbleEquals(hrkptani, BizCurrency.valueOf(0), "定期一括払Ｐ");
    }

    @Test
    @TestOrder(100)
    public void testgetIkkatuPFromIkkatuTukiPYenforMsg_A10() {

        boolean maxkngkkansflg = true;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        BizCurrency teikiikkatutkbrip = BizCurrency.valueOf(-1, BizCurrencyTypes.YEN);

        BizCurrency tkbrihrkptani = BizCurrency.valueOf(2000000, BizCurrencyTypes.YEN);

        C_IkkatubaraiKaisuuKbn ikkatubaraikaisuu = C_IkkatubaraiKaisuuKbn.IKKATU6;

        int ikkatupsiteitaniskru = 1;

        BizCurrency hrkptani = skZennouIkkatuUtil.getIkkatuPFromIkkatuTukiPYenforMsg( maxkngkkansflg, syusyouhncd, syusyouhnsdno, syuryouritusdno,
            teikiikkatutkbrip, tkbrihrkptani, ikkatubaraikaisuu, ikkatupsiteitaniskru);

        exBizCalcbleEquals(hrkptani, BizCurrency.valueOf(0), "定期一括払Ｐ");
    }

    @Test
    @TestOrder(110)
    public void testgetIkkatuPFromIkkatuTukiPYenforMsg_A11() {

        boolean maxkngkkansflg = true;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        BizCurrency teikiikkatutkbrip = BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);

        BizCurrency tkbrihrkptani = null;

        C_IkkatubaraiKaisuuKbn ikkatubaraikaisuu = C_IkkatubaraiKaisuuKbn.IKKATU6;

        int ikkatupsiteitaniskru = 1;

        BizCurrency hrkptani = skZennouIkkatuUtil.getIkkatuPFromIkkatuTukiPYenforMsg( maxkngkkansflg, syusyouhncd, syusyouhnsdno, syuryouritusdno,
            teikiikkatutkbrip, tkbrihrkptani, ikkatubaraikaisuu, ikkatupsiteitaniskru);

        exBizCalcbleEquals(hrkptani, BizCurrency.valueOf(0), "定期一括払Ｐ");
    }

    @Test
    @TestOrder(120)
    public void testgetIkkatuPFromIkkatuTukiPYenforMsg_A12() {

        boolean maxkngkkansflg = true;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        BizCurrency teikiikkatutkbrip = BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);

        BizCurrency tkbrihrkptani = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        C_IkkatubaraiKaisuuKbn ikkatubaraikaisuu = C_IkkatubaraiKaisuuKbn.IKKATU6;

        int ikkatupsiteitaniskru = 1;

        BizCurrency hrkptani = skZennouIkkatuUtil.getIkkatuPFromIkkatuTukiPYenforMsg( maxkngkkansflg, syusyouhncd, syusyouhnsdno, syuryouritusdno,
            teikiikkatutkbrip, tkbrihrkptani, ikkatubaraikaisuu, ikkatupsiteitaniskru);

        exBizCalcbleEquals(hrkptani, BizCurrency.valueOf(0), "定期一括払Ｐ");
    }

    @Test
    @TestOrder(130)
    public void testgetIkkatuPFromIkkatuTukiPYenforMsg_A13() {

        boolean maxkngkkansflg = true;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        BizCurrency teikiikkatutkbrip = BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);

        BizCurrency tkbrihrkptani = BizCurrency.valueOf(-1, BizCurrencyTypes.YEN);

        C_IkkatubaraiKaisuuKbn ikkatubaraikaisuu = C_IkkatubaraiKaisuuKbn.IKKATU6;

        int ikkatupsiteitaniskru = 1;

        BizCurrency hrkptani = skZennouIkkatuUtil.getIkkatuPFromIkkatuTukiPYenforMsg( maxkngkkansflg, syusyouhncd, syusyouhnsdno, syuryouritusdno,
            teikiikkatutkbrip, tkbrihrkptani, ikkatubaraikaisuu, ikkatupsiteitaniskru);

        exBizCalcbleEquals(hrkptani, BizCurrency.valueOf(0), "定期一括払Ｐ");
    }

    @Test
    @TestOrder(140)
    public void testgetIkkatuPFromIkkatuTukiPYenforMsg_A14() {

        boolean maxkngkkansflg = true;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        BizCurrency teikiikkatutkbrip = BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);

        BizCurrency tkbrihrkptani = BizCurrency.valueOf(2000000, BizCurrencyTypes.YEN);

        C_IkkatubaraiKaisuuKbn ikkatubaraikaisuu = null;

        int ikkatupsiteitaniskru = 1;

        BizCurrency hrkptani = skZennouIkkatuUtil.getIkkatuPFromIkkatuTukiPYenforMsg( maxkngkkansflg, syusyouhncd, syusyouhnsdno, syuryouritusdno,
            teikiikkatutkbrip, tkbrihrkptani, ikkatubaraikaisuu, ikkatupsiteitaniskru);

        exBizCalcbleEquals(hrkptani, BizCurrency.valueOf(0), "定期一括払Ｐ");
    }

    @Test
    @TestOrder(150)
    public void testgetIkkatuPFromIkkatuTukiPYenforMsg_A15() {

        boolean maxkngkkansflg = true;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        BizCurrency teikiikkatutkbrip = BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);

        BizCurrency tkbrihrkptani = BizCurrency.valueOf(2000000, BizCurrencyTypes.YEN);

        C_IkkatubaraiKaisuuKbn ikkatubaraikaisuu = C_IkkatubaraiKaisuuKbn.BLNK;

        int ikkatupsiteitaniskru = 1;

        BizCurrency hrkptani = skZennouIkkatuUtil.getIkkatuPFromIkkatuTukiPYenforMsg( maxkngkkansflg, syusyouhncd, syusyouhnsdno, syuryouritusdno,
            teikiikkatutkbrip, tkbrihrkptani, ikkatubaraikaisuu, ikkatupsiteitaniskru);

        exBizCalcbleEquals(hrkptani, BizCurrency.valueOf(0), "定期一括払Ｐ");
    }

    @Test
    @TestOrder(160)
    public void testgetIkkatuPFromIkkatuTukiPYenforMsg_A16() {

        boolean maxkngkkansflg = true;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        BizCurrency teikiikkatutkbrip = BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);

        BizCurrency tkbrihrkptani = BizCurrency.valueOf(2000000, BizCurrencyTypes.YEN);

        C_IkkatubaraiKaisuuKbn ikkatubaraikaisuu = C_IkkatubaraiKaisuuKbn.IKKATU2;

        int ikkatupsiteitaniskru = 1;

        BizCurrency hrkptani = skZennouIkkatuUtil.getIkkatuPFromIkkatuTukiPYenforMsg( maxkngkkansflg, syusyouhncd, syusyouhnsdno, syuryouritusdno,
            teikiikkatutkbrip, tkbrihrkptani, ikkatubaraikaisuu, ikkatupsiteitaniskru);

        exBizCalcbleEquals(hrkptani, BizCurrency.valueOf(0), "定期一括払Ｐ");
    }

    @Test
    @TestOrder(170)
    public void testgetIkkatuPFromIkkatuTukiPYenforMsg_A17() {

        boolean maxkngkkansflg = true;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        BizCurrency teikiikkatutkbrip = BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);

        BizCurrency tkbrihrkptani = BizCurrency.valueOf(2000000, BizCurrencyTypes.YEN);

        C_IkkatubaraiKaisuuKbn ikkatubaraikaisuu = C_IkkatubaraiKaisuuKbn.IKKATU3;

        int ikkatupsiteitaniskru = 1;

        BizCurrency hrkptani = skZennouIkkatuUtil.getIkkatuPFromIkkatuTukiPYenforMsg( maxkngkkansflg, syusyouhncd, syusyouhnsdno, syuryouritusdno,
            teikiikkatutkbrip, tkbrihrkptani, ikkatubaraikaisuu, ikkatupsiteitaniskru);

        exBizCalcbleEquals(hrkptani, BizCurrency.valueOf(0), "定期一括払Ｐ");
    }

    @Test
    @TestOrder(180)
    public void testgetIkkatuPFromIkkatuTukiPYenforMsg_A18() {

        boolean maxkngkkansflg = true;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        BizCurrency teikiikkatutkbrip = BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);

        BizCurrency tkbrihrkptani = BizCurrency.valueOf(2000000, BizCurrencyTypes.YEN);

        C_IkkatubaraiKaisuuKbn ikkatubaraikaisuu = C_IkkatubaraiKaisuuKbn.IKKATU4;

        int ikkatupsiteitaniskru = 1;

        BizCurrency hrkptani = skZennouIkkatuUtil.getIkkatuPFromIkkatuTukiPYenforMsg( maxkngkkansflg, syusyouhncd, syusyouhnsdno, syuryouritusdno,
            teikiikkatutkbrip, tkbrihrkptani, ikkatubaraikaisuu, ikkatupsiteitaniskru);

        exBizCalcbleEquals(hrkptani, BizCurrency.valueOf(0), "定期一括払Ｐ");
    }

    @Test
    @TestOrder(190)
    public void testgetIkkatuPFromIkkatuTukiPYenforMsg_A19() {

        boolean maxkngkkansflg = true;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        BizCurrency teikiikkatutkbrip = BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);

        BizCurrency tkbrihrkptani = BizCurrency.valueOf(2000000, BizCurrencyTypes.YEN);

        C_IkkatubaraiKaisuuKbn ikkatubaraikaisuu = C_IkkatubaraiKaisuuKbn.IKKATU5;

        int ikkatupsiteitaniskru = 1;

        BizCurrency hrkptani = skZennouIkkatuUtil.getIkkatuPFromIkkatuTukiPYenforMsg( maxkngkkansflg, syusyouhncd, syusyouhnsdno, syuryouritusdno,
            teikiikkatutkbrip, tkbrihrkptani, ikkatubaraikaisuu, ikkatupsiteitaniskru);

        exBizCalcbleEquals(hrkptani, BizCurrency.valueOf(0), "定期一括払Ｐ");
    }

    @Test
    @TestOrder(200)
    public void testgetIkkatuPFromIkkatuTukiPYenforMsg_A20() {

        boolean maxkngkkansflg = true;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        BizCurrency teikiikkatutkbrip = BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);

        BizCurrency tkbrihrkptani = BizCurrency.valueOf(2000000, BizCurrencyTypes.YEN);

        C_IkkatubaraiKaisuuKbn ikkatubaraikaisuu = C_IkkatubaraiKaisuuKbn.IKKATU7;

        int ikkatupsiteitaniskru = 1;

        BizCurrency hrkptani = skZennouIkkatuUtil.getIkkatuPFromIkkatuTukiPYenforMsg( maxkngkkansflg, syusyouhncd, syusyouhnsdno, syuryouritusdno,
            teikiikkatutkbrip, tkbrihrkptani, ikkatubaraikaisuu, ikkatupsiteitaniskru);

        exBizCalcbleEquals(hrkptani, BizCurrency.valueOf(0), "定期一括払Ｐ");
    }

    @Test
    @TestOrder(210)
    public void testgetIkkatuPFromIkkatuTukiPYenforMsg_A21() {

        boolean maxkngkkansflg = true;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        BizCurrency teikiikkatutkbrip = BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);

        BizCurrency tkbrihrkptani = BizCurrency.valueOf(2000000, BizCurrencyTypes.YEN);

        C_IkkatubaraiKaisuuKbn ikkatubaraikaisuu = C_IkkatubaraiKaisuuKbn.IKKATU8;

        int ikkatupsiteitaniskru = 1;

        BizCurrency hrkptani = skZennouIkkatuUtil.getIkkatuPFromIkkatuTukiPYenforMsg( maxkngkkansflg, syusyouhncd, syusyouhnsdno, syuryouritusdno,
            teikiikkatutkbrip, tkbrihrkptani, ikkatubaraikaisuu, ikkatupsiteitaniskru);

        exBizCalcbleEquals(hrkptani, BizCurrency.valueOf(0), "定期一括払Ｐ");
    }

    @Test
    @TestOrder(220)
    public void testgetIkkatuPFromIkkatuTukiPYenforMsg_A22() {

        boolean maxkngkkansflg = true;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        BizCurrency teikiikkatutkbrip = BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);

        BizCurrency tkbrihrkptani = BizCurrency.valueOf(2000000, BizCurrencyTypes.YEN);

        C_IkkatubaraiKaisuuKbn ikkatubaraikaisuu = C_IkkatubaraiKaisuuKbn.IKKATU9;

        int ikkatupsiteitaniskru = 1;

        BizCurrency hrkptani = skZennouIkkatuUtil.getIkkatuPFromIkkatuTukiPYenforMsg( maxkngkkansflg, syusyouhncd, syusyouhnsdno, syuryouritusdno,
            teikiikkatutkbrip, tkbrihrkptani, ikkatubaraikaisuu, ikkatupsiteitaniskru);

        exBizCalcbleEquals(hrkptani, BizCurrency.valueOf(0), "定期一括払Ｐ");
    }

    @Test
    @TestOrder(230)
    public void testgetIkkatuPFromIkkatuTukiPYenforMsg_A23() {

        boolean maxkngkkansflg = true;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        BizCurrency teikiikkatutkbrip = BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);

        BizCurrency tkbrihrkptani = BizCurrency.valueOf(2000000, BizCurrencyTypes.YEN);

        C_IkkatubaraiKaisuuKbn ikkatubaraikaisuu = C_IkkatubaraiKaisuuKbn.IKKATU10;

        int ikkatupsiteitaniskru = 1;

        BizCurrency hrkptani = skZennouIkkatuUtil.getIkkatuPFromIkkatuTukiPYenforMsg( maxkngkkansflg, syusyouhncd, syusyouhnsdno, syuryouritusdno,
            teikiikkatutkbrip, tkbrihrkptani, ikkatubaraikaisuu, ikkatupsiteitaniskru);

        exBizCalcbleEquals(hrkptani, BizCurrency.valueOf(0), "定期一括払Ｐ");
    }

    @Test
    @TestOrder(240)
    public void testgetIkkatuPFromIkkatuTukiPYenforMsg_A24() {

        boolean maxkngkkansflg = true;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        BizCurrency teikiikkatutkbrip = BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);

        BizCurrency tkbrihrkptani = BizCurrency.valueOf(2000000, BizCurrencyTypes.YEN);

        C_IkkatubaraiKaisuuKbn ikkatubaraikaisuu = C_IkkatubaraiKaisuuKbn.IKKATU11;

        int ikkatupsiteitaniskru = 1;

        BizCurrency hrkptani = skZennouIkkatuUtil.getIkkatuPFromIkkatuTukiPYenforMsg( maxkngkkansflg, syusyouhncd, syusyouhnsdno, syuryouritusdno,
            teikiikkatutkbrip, tkbrihrkptani, ikkatubaraikaisuu, ikkatupsiteitaniskru);

        exBizCalcbleEquals(hrkptani, BizCurrency.valueOf(0), "定期一括払Ｐ");
    }

    @Test
    @TestOrder(250)
    public void testgetIkkatuPFromIkkatuTukiPYenforMsg_A25() {

        MockObjectManager.initialize();

        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.TESTPATTERN2;

        boolean maxkngkkansflg = true;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        BizCurrency teikiikkatutkbrip = BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);

        BizCurrency tkbrihrkptani = BizCurrency.valueOf(2000000, BizCurrencyTypes.YEN);

        C_IkkatubaraiKaisuuKbn ikkatubaraikaisuu = C_IkkatubaraiKaisuuKbn.IKKATU6;

        int ikkatupsiteitaniskru = 1;

        BizCurrency hrkptani = skZennouIkkatuUtil.getIkkatuPFromIkkatuTukiPYenforMsg( maxkngkkansflg, syusyouhncd, syusyouhnsdno, syuryouritusdno,
            teikiikkatutkbrip, tkbrihrkptani, ikkatubaraikaisuu, ikkatupsiteitaniskru);

        exBizCalcbleEquals(hrkptani, BizCurrency.valueOf(0), "定期一括払Ｐ");
    }

    @Test
    @TestOrder(260)
    public void testgetIkkatuPFromIkkatuTukiPYenforMsg_A26() {

        MockObjectManager.initialize();

        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.TESTPATTERN3;

        boolean maxkngkkansflg = true;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        BizCurrency teikiikkatutkbrip = BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);

        BizCurrency tkbrihrkptani = BizCurrency.valueOf(2000000, BizCurrencyTypes.YEN);

        C_IkkatubaraiKaisuuKbn ikkatubaraikaisuu = C_IkkatubaraiKaisuuKbn.IKKATU12;

        int ikkatupsiteitaniskru = 0;

        BizCurrency hrkptani = skZennouIkkatuUtil.getIkkatuPFromIkkatuTukiPYenforMsg( maxkngkkansflg, syusyouhncd, syusyouhnsdno, syuryouritusdno,
            teikiikkatutkbrip, tkbrihrkptani, ikkatubaraikaisuu, ikkatupsiteitaniskru);

        exBizCalcbleEquals(hrkptani, BizCurrency.valueOf(0), "定期一括払Ｐ");
    }

    @Test
    @TestOrder(270)
    public void testgetIkkatuPFromIkkatuTukiPYenforMsg_A27() {

        MockObjectManager.initialize();

        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.TESTPATTERN4;

        boolean maxkngkkansflg = false;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        BizCurrency teikiikkatutkbrip = BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);

        BizCurrency tkbrihrkptani = BizCurrency.valueOf(2000000, BizCurrencyTypes.YEN);

        C_IkkatubaraiKaisuuKbn ikkatubaraikaisuu = C_IkkatubaraiKaisuuKbn.IKKATU12;

        int ikkatupsiteitaniskru = 1;

        BizCurrency hrkptani = skZennouIkkatuUtil.getIkkatuPFromIkkatuTukiPYenforMsg( maxkngkkansflg, syusyouhncd, syusyouhnsdno, syuryouritusdno,
            teikiikkatutkbrip, tkbrihrkptani, ikkatubaraikaisuu, ikkatupsiteitaniskru);

        exBizCalcbleEquals(hrkptani, BizCurrency.valueOf(0), "定期一括払Ｐ");
    }

    @Test
    @TestOrder(280)
    public void testgetIkkatuPFromIkkatuTukiPYenforMsg_A28() {

        MockObjectManager.initialize();

        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.TESTPATTERN5;

        boolean maxkngkkansflg = true;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        BizCurrency teikiikkatutkbrip = BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);

        BizCurrency tkbrihrkptani = BizCurrency.valueOf(2000000, BizCurrencyTypes.YEN);

        C_IkkatubaraiKaisuuKbn ikkatubaraikaisuu = C_IkkatubaraiKaisuuKbn.IKKATU12;

        int ikkatupsiteitaniskru = 1;

        BizCurrency hrkptani = skZennouIkkatuUtil.getIkkatuPFromIkkatuTukiPYenforMsg( maxkngkkansflg, syusyouhncd, syusyouhnsdno, syuryouritusdno,
            teikiikkatutkbrip, tkbrihrkptani, ikkatubaraikaisuu, ikkatupsiteitaniskru);

        exBizCalcbleEquals(hrkptani, BizCurrency.valueOf(0), "定期一括払Ｐ");
    }

    @Test
    @TestOrder(290)
    public void testgetIkkatuPFromIkkatuTukiPYenforMsg_A29() {

        MockObjectManager.initialize();

        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.TESTPATTERN1;

        boolean maxkngkkansflg = false;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        BizCurrency teikiikkatutkbrip = BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);

        BizCurrency tkbrihrkptani = BizCurrency.valueOf(2000000, BizCurrencyTypes.YEN);

        C_IkkatubaraiKaisuuKbn ikkatubaraikaisuu = C_IkkatubaraiKaisuuKbn.IKKATU12;

        int ikkatupsiteitaniskru = 1;

        BizCurrency hrkptani = skZennouIkkatuUtil.getIkkatuPFromIkkatuTukiPYenforMsg( maxkngkkansflg, syusyouhncd, syusyouhnsdno, syuryouritusdno,
            teikiikkatutkbrip, tkbrihrkptani, ikkatubaraikaisuu, ikkatupsiteitaniskru);

        exBizCalcbleEquals(hrkptani, BizCurrency.valueOf(3333.4), "定期一括払Ｐ");
    }

    @Test
    @TestOrder(300)
    public void testgetIkkatuPFromIkkatuTukiPYenforMsg_A30() {

        MockObjectManager.initialize();

        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.TESTPATTERN1;

        boolean maxkngkkansflg = true;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        BizCurrency teikiikkatutkbrip = BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);

        BizCurrency tkbrihrkptani = BizCurrency.valueOf(2000000, BizCurrencyTypes.YEN);

        C_IkkatubaraiKaisuuKbn ikkatubaraikaisuu = C_IkkatubaraiKaisuuKbn.IKKATU12;

        int ikkatupsiteitaniskru = 1;

        BizCurrency hrkptani = skZennouIkkatuUtil.getIkkatuPFromIkkatuTukiPYenforMsg( maxkngkkansflg, syusyouhncd,
            syusyouhnsdno, syuryouritusdno, teikiikkatutkbrip, tkbrihrkptani, ikkatubaraikaisuu, ikkatupsiteitaniskru);

        KeisanIkkatuNyuukinGkBean keisanIkkatuNyuukinGkBean = (KeisanIkkatuNyuukinGkBean) MockObjectManager
            .getArgument(KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.class, "exec", 0, 0);

        boolean  iktwaribikiFuyouFlg= (boolean)MockObjectManager.getArgument(KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.class, "exec", 0, 1);

        exBizCalcbleEquals(hrkptani, BizCurrency.valueOf(3333.3), "定期一括払Ｐ");

        exClassificationEquals(keisanIkkatuNyuukinGkBean.getTkiktbrisyuruiKbn(), C_TkiktbrisyuruiKbn.TEIKI_12MONTHS, "定期一括払種類区分");

        exNumericEquals(keisanIkkatuNyuukinGkBean.getJyuutoutuKisuu(), 12, "充当月数");

        exClassificationEquals(keisanIkkatuNyuukinGkBean.getRstuukasyu(), C_Tuukasyu.JPY, "領収通貨種類");

        exClassificationEquals(keisanIkkatuNyuukinGkBean.getNyknaiyoukbn(), C_NyknaiyouKbn.BLNK,  "入金内容区分");

        exClassificationEquals(keisanIkkatuNyuukinGkBean.getNykkeiro(), C_Nykkeiro.BLNK,  "入金経路");

        exDateEquals(keisanIkkatuNyuukinGkBean.getSyokaiprsYmd(), null,  "領収年月日");

        exDateYMEquals(keisanIkkatuNyuukinGkBean.getJyutoustartYm(), null,  "充当開始年月");

        exStringEquals(keisanIkkatuNyuukinGkBean.getKeisanIkkatuNyuukinGkSyouhnBeanLst().get(0).getSyouhnCd(), "1001", "商品コード");

        exNumericEquals(keisanIkkatuNyuukinGkBean.getKeisanIkkatuNyuukinGkSyouhnBeanLst().get(0).getSyouhnsdNo(), 1, "商品世代番号");

        exStringEquals(keisanIkkatuNyuukinGkBean.getKeisanIkkatuNyuukinGkSyouhnBeanLst().get(0).getRyouritusdNo(), "101", "料率世代番号");

        exBizCalcbleEquals(keisanIkkatuNyuukinGkBean.getKeisanIkkatuNyuukinGkSyouhnBeanLst().get(0).getHokenryou(), BizCurrency.valueOf(3000000), "保険料");

        exBizCalcbleEquals(keisanIkkatuNyuukinGkBean.getKeisanIkkatuNyuukinGkSyouhnBeanLst().get(0).getYoteiRiritu(), BizNumber.ZERO, "予定利率");

        exBooleanEquals(iktwaribikiFuyouFlg, false, "一括割引不要フラグ");
    }
}
