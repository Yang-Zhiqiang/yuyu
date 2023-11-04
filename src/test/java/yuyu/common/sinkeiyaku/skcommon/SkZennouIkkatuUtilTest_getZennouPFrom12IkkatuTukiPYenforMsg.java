package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.hozen.ascommon.KeisanZennouNyuukinGk2;
import yuyu.common.hozen.khcommon.KeisanIkkatuNyuukinGkBean;
import yuyu.common.hozen.khcommon.KeisanTukiIkkatuNyuukinGk;
import yuyu.common.hozen.khcommon.KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku;
import yuyu.common.hozen.ascommon.KeisanZennouNyuukinGk2MockForSinkeiyaku;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 新契約前納一括払関連ユーティリティクラスのメソッド {@link SkZennouIkkatuUtil#getZennouPFrom12IkkatuTukiPYenforMsg(
        boolean pMaxkngkkansflg,String pSyusyouhncd,Integer pSyusyouhnsdno,String pSyuryouritusdno,BizDate pKijyunymd,
        BizCurrency pKijyunteikiikkatu12tkbrip,BizCurrency pTkbrihrkptani,Integer pZnnkaisyonendo,
        int pZennoupsiteitaniskru)} テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class SkZennouIkkatuUtilTest_getZennouPFrom12IkkatuTukiPYenforMsg {

    @Inject
    private SkZennouIkkatuUtil skZennouIkkatuUtil;

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {

                bind(KeisanTukiIkkatuNyuukinGk.class).to(KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.class);
                bind(KeisanZennouNyuukinGk2.class).to(KeisanZennouNyuukinGk2MockForSinkeiyaku.class);

            }
        });
    }

    @BeforeClass
    public static void testInit() {

        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.caller = SkZennouIkkatuUtilTest_getZennouPFrom12IkkatuTukiPYenforMsg.class;

        KeisanZennouNyuukinGk2MockForSinkeiyaku.caller = SkZennouIkkatuUtilTest_getZennouPFrom12IkkatuTukiPYenforMsg.class;
    }

    @AfterClass
    public static void testClear() {

        MockObjectManager.initialize();

        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.caller = null;
        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = null;

        KeisanZennouNyuukinGk2MockForSinkeiyaku.caller = null;
        KeisanZennouNyuukinGk2MockForSinkeiyaku.SYORIPTN = null;
    }

    @Test
    @TestOrder(10)
    public void testgetZennouPFrom12IkkatuTukiPYenforMsg_A1() {

        boolean maxkngkkansflg = true;

        String syusyouhncd = null;

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        BizDate kijyunymd = BizDate.valueOf("20180201");

        BizCurrency tkbrihrkptani = BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);

        BizCurrency kijyunteikiikkatu12tkbrip = BizCurrency.valueOf(2000000, BizCurrencyTypes.YEN);

        Integer znnkaisyonendo = 99;

        int ikkatupsiteitaniskru = 1;

        BizCurrency zennoupsyonendo = skZennouIkkatuUtil.getZennouPFrom12IkkatuTukiPYenforMsg( maxkngkkansflg, syusyouhncd,
            syusyouhnsdno, syuryouritusdno, kijyunymd, tkbrihrkptani, kijyunteikiikkatu12tkbrip,
            znnkaisyonendo, ikkatupsiteitaniskru);

        exBizCalcbleEquals(zennoupsyonendo, BizCurrency.valueOf(0), "前納Ｐ（初年度含）");
    }

    @Test
    @TestOrder(20)
    public void testgetZennouPFrom12IkkatuTukiPYenforMsg_A2() {

        boolean maxkngkkansflg = true;

        String syusyouhncd = "";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        BizDate kijyunymd = BizDate.valueOf("20180201");

        BizCurrency tkbrihrkptani = BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);

        BizCurrency kijyunteikiikkatu12tkbrip = BizCurrency.valueOf(2000000, BizCurrencyTypes.YEN);

        Integer znnkaisyonendo = 99;

        int ikkatupsiteitaniskru = 1;

        BizCurrency zennoupsyonendo = skZennouIkkatuUtil.getZennouPFrom12IkkatuTukiPYenforMsg( maxkngkkansflg, syusyouhncd,
            syusyouhnsdno, syuryouritusdno, kijyunymd, tkbrihrkptani, kijyunteikiikkatu12tkbrip,
            znnkaisyonendo, ikkatupsiteitaniskru);

        exBizCalcbleEquals(zennoupsyonendo, BizCurrency.valueOf(0), "前納Ｐ（初年度含）");
    }

    @Test
    @TestOrder(30)
    public void testgetZennouPFrom12IkkatuTukiPYenforMsg_A3() {

        boolean maxkngkkansflg = true;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = null;

        String syuryouritusdno = "101";

        BizDate kijyunymd = BizDate.valueOf("20180201");

        BizCurrency tkbrihrkptani = BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);

        BizCurrency kijyunteikiikkatu12tkbrip = BizCurrency.valueOf(2000000, BizCurrencyTypes.YEN);

        Integer znnkaisyonendo = 99;

        int ikkatupsiteitaniskru = 1;

        BizCurrency zennoupsyonendo = skZennouIkkatuUtil.getZennouPFrom12IkkatuTukiPYenforMsg( maxkngkkansflg, syusyouhncd,
            syusyouhnsdno, syuryouritusdno, kijyunymd, tkbrihrkptani, kijyunteikiikkatu12tkbrip,
            znnkaisyonendo, ikkatupsiteitaniskru);

        exBizCalcbleEquals(zennoupsyonendo, BizCurrency.valueOf(0), "前納Ｐ（初年度含）");
    }

    @Test
    @TestOrder(40)
    public void testgetZennouPFrom12IkkatuTukiPYenforMsg_A4() {

        boolean maxkngkkansflg = true;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 0;

        String syuryouritusdno = "101";

        BizDate kijyunymd = BizDate.valueOf("20180201");

        BizCurrency tkbrihrkptani = BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);

        BizCurrency kijyunteikiikkatu12tkbrip = BizCurrency.valueOf(2000000, BizCurrencyTypes.YEN);

        Integer znnkaisyonendo = 99;

        int ikkatupsiteitaniskru = 1;

        BizCurrency zennoupsyonendo = skZennouIkkatuUtil.getZennouPFrom12IkkatuTukiPYenforMsg( maxkngkkansflg, syusyouhncd,
            syusyouhnsdno, syuryouritusdno, kijyunymd, tkbrihrkptani, kijyunteikiikkatu12tkbrip,
            znnkaisyonendo, ikkatupsiteitaniskru);

        exBizCalcbleEquals(zennoupsyonendo, BizCurrency.valueOf(0), "前納Ｐ（初年度含）");
    }

    @Test
    @TestOrder(50)
    public void testgetZennouPFrom12IkkatuTukiPYenforMsg_A5() {

        boolean maxkngkkansflg = true;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = -1;

        String syuryouritusdno = "101";

        BizDate kijyunymd = BizDate.valueOf("20180201");

        BizCurrency tkbrihrkptani = BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);

        BizCurrency kijyunteikiikkatu12tkbrip = BizCurrency.valueOf(2000000, BizCurrencyTypes.YEN);

        Integer znnkaisyonendo = 99;

        int ikkatupsiteitaniskru = 1;

        BizCurrency zennoupsyonendo = skZennouIkkatuUtil.getZennouPFrom12IkkatuTukiPYenforMsg( maxkngkkansflg, syusyouhncd,
            syusyouhnsdno, syuryouritusdno, kijyunymd, tkbrihrkptani, kijyunteikiikkatu12tkbrip,
            znnkaisyonendo, ikkatupsiteitaniskru);

        exBizCalcbleEquals(zennoupsyonendo, BizCurrency.valueOf(0), "前納Ｐ（初年度含）");
    }

    @Test
    @TestOrder(60)
    public void testgetZennouPFrom12IkkatuTukiPYenforMsg_A6() {

        boolean maxkngkkansflg = true;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = null;

        BizDate kijyunymd = BizDate.valueOf("20180201");

        BizCurrency tkbrihrkptani = BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);

        BizCurrency kijyunteikiikkatu12tkbrip = BizCurrency.valueOf(2000000, BizCurrencyTypes.YEN);

        Integer znnkaisyonendo = 99;

        int ikkatupsiteitaniskru = 1;

        BizCurrency zennoupsyonendo = skZennouIkkatuUtil.getZennouPFrom12IkkatuTukiPYenforMsg( maxkngkkansflg, syusyouhncd,
            syusyouhnsdno, syuryouritusdno, kijyunymd, tkbrihrkptani, kijyunteikiikkatu12tkbrip,
            znnkaisyonendo, ikkatupsiteitaniskru);

        exBizCalcbleEquals(zennoupsyonendo, BizCurrency.valueOf(0), "前納Ｐ（初年度含）");
    }

    @Test
    @TestOrder(70)
    public void testgetZennouPFrom12IkkatuTukiPYenforMsg_A7() {

        boolean maxkngkkansflg = true;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "";

        BizDate kijyunymd = BizDate.valueOf("20180201");

        BizCurrency tkbrihrkptani = BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);

        BizCurrency kijyunteikiikkatu12tkbrip = BizCurrency.valueOf(2000000, BizCurrencyTypes.YEN);

        Integer znnkaisyonendo = 99;

        int ikkatupsiteitaniskru = 1;

        BizCurrency zennoupsyonendo = skZennouIkkatuUtil.getZennouPFrom12IkkatuTukiPYenforMsg( maxkngkkansflg, syusyouhncd,
            syusyouhnsdno, syuryouritusdno, kijyunymd, tkbrihrkptani, kijyunteikiikkatu12tkbrip,
            znnkaisyonendo, ikkatupsiteitaniskru);

        exBizCalcbleEquals(zennoupsyonendo, BizCurrency.valueOf(0), "前納Ｐ（初年度含）");
    }

    @Test
    @TestOrder(80)
    public void testgetZennouPFrom12IkkatuTukiPYenforMsg_A8() {

        boolean maxkngkkansflg = true;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        BizDate kijyunymd = null;

        BizCurrency tkbrihrkptani = BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);

        BizCurrency kijyunteikiikkatu12tkbrip = BizCurrency.valueOf(2000000, BizCurrencyTypes.YEN);

        Integer znnkaisyonendo = 99;

        int ikkatupsiteitaniskru = 1;

        BizCurrency zennoupsyonendo = skZennouIkkatuUtil.getZennouPFrom12IkkatuTukiPYenforMsg( maxkngkkansflg, syusyouhncd,
            syusyouhnsdno, syuryouritusdno, kijyunymd, tkbrihrkptani, kijyunteikiikkatu12tkbrip,
            znnkaisyonendo, ikkatupsiteitaniskru);

        exBizCalcbleEquals(zennoupsyonendo, BizCurrency.valueOf(0), "前納Ｐ（初年度含）");
    }

    @Test
    @TestOrder(90)
    public void testgetZennouPFrom12IkkatuTukiPYenforMsg_A9() {

        boolean maxkngkkansflg = true;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        BizDate kijyunymd = BizDate.valueOf("20180230");

        BizCurrency tkbrihrkptani = BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);

        BizCurrency kijyunteikiikkatu12tkbrip = BizCurrency.valueOf(2000000, BizCurrencyTypes.YEN);

        Integer znnkaisyonendo = 99;

        int ikkatupsiteitaniskru = 1;

        BizCurrency zennoupsyonendo = skZennouIkkatuUtil.getZennouPFrom12IkkatuTukiPYenforMsg( maxkngkkansflg, syusyouhncd,
            syusyouhnsdno, syuryouritusdno, kijyunymd, tkbrihrkptani, kijyunteikiikkatu12tkbrip,
            znnkaisyonendo, ikkatupsiteitaniskru);

        exBizCalcbleEquals(zennoupsyonendo, BizCurrency.valueOf(0), "前納Ｐ（初年度含）");
    }

    @Test
    @TestOrder(100)
    public void testgetZennouPFrom12IkkatuTukiPYenforMsg_A10() {

        boolean maxkngkkansflg = true;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        BizDate kijyunymd = BizDate.valueOf("20180201");

        BizCurrency tkbrihrkptani = null;
        BizCurrency kijyunteikiikkatu12tkbrip = BizCurrency.valueOf(2000000, BizCurrencyTypes.YEN);

        Integer znnkaisyonendo = 99;

        int ikkatupsiteitaniskru = 1;

        BizCurrency zennoupsyonendo = skZennouIkkatuUtil.getZennouPFrom12IkkatuTukiPYenforMsg( maxkngkkansflg, syusyouhncd,
            syusyouhnsdno, syuryouritusdno, kijyunymd, tkbrihrkptani, kijyunteikiikkatu12tkbrip,
            znnkaisyonendo, ikkatupsiteitaniskru);

        exBizCalcbleEquals(zennoupsyonendo, BizCurrency.valueOf(0), "前納Ｐ（初年度含）");
    }

    @Test
    @TestOrder(110)
    public void testgetZennouPFrom12IkkatuTukiPYenforMsg_A11() {

        boolean maxkngkkansflg = true;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        BizDate kijyunymd = BizDate.valueOf("20180201");

        BizCurrency tkbrihrkptani = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        BizCurrency kijyunteikiikkatu12tkbrip = BizCurrency.valueOf(2000000, BizCurrencyTypes.YEN);

        Integer znnkaisyonendo = 99;

        int ikkatupsiteitaniskru = 1;

        BizCurrency zennoupsyonendo = skZennouIkkatuUtil.getZennouPFrom12IkkatuTukiPYenforMsg( maxkngkkansflg, syusyouhncd,
            syusyouhnsdno, syuryouritusdno, kijyunymd, tkbrihrkptani, kijyunteikiikkatu12tkbrip,
            znnkaisyonendo, ikkatupsiteitaniskru);

        exBizCalcbleEquals(zennoupsyonendo, BizCurrency.valueOf(0), "前納Ｐ（初年度含）");
    }

    @Test
    @TestOrder(120)
    public void testgetZennouPFrom12IkkatuTukiPYenforMsg_A12() {

        boolean maxkngkkansflg = true;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        BizDate kijyunymd = BizDate.valueOf("20180201");

        BizCurrency tkbrihrkptani = BizCurrency.valueOf(-1, BizCurrencyTypes.YEN);

        BizCurrency kijyunteikiikkatu12tkbrip = BizCurrency.valueOf(2000000, BizCurrencyTypes.YEN);

        Integer znnkaisyonendo = 99;

        int ikkatupsiteitaniskru = 1;

        BizCurrency zennoupsyonendo = skZennouIkkatuUtil.getZennouPFrom12IkkatuTukiPYenforMsg( maxkngkkansflg, syusyouhncd,
            syusyouhnsdno, syuryouritusdno, kijyunymd, tkbrihrkptani, kijyunteikiikkatu12tkbrip,
            znnkaisyonendo, ikkatupsiteitaniskru);

        exBizCalcbleEquals(zennoupsyonendo, BizCurrency.valueOf(0), "前納Ｐ（初年度含）");
    }

    @Test
    @TestOrder(130)
    public void testgetZennouPFrom12IkkatuTukiPYenforMsg_A13() {

        boolean maxkngkkansflg = true;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        BizDate kijyunymd = BizDate.valueOf("20180201");

        BizCurrency tkbrihrkptani = BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);

        BizCurrency kijyunteikiikkatu12tkbrip = null;

        Integer znnkaisyonendo = 99;

        int ikkatupsiteitaniskru = 1;

        BizCurrency zennoupsyonendo = skZennouIkkatuUtil.getZennouPFrom12IkkatuTukiPYenforMsg( maxkngkkansflg, syusyouhncd,
            syusyouhnsdno, syuryouritusdno, kijyunymd, tkbrihrkptani, kijyunteikiikkatu12tkbrip,
            znnkaisyonendo, ikkatupsiteitaniskru);

        exBizCalcbleEquals(zennoupsyonendo, BizCurrency.valueOf(0), "前納Ｐ（初年度含）");
    }

    @Test
    @TestOrder(140)
    public void testgetZennouPFrom12IkkatuTukiPYenforMsg_A14() {

        boolean maxkngkkansflg = true;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        BizDate kijyunymd = BizDate.valueOf("20180201");

        BizCurrency tkbrihrkptani = BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);

        BizCurrency kijyunteikiikkatu12tkbrip = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        Integer znnkaisyonendo = 99;

        int ikkatupsiteitaniskru = 1;

        BizCurrency zennoupsyonendo = skZennouIkkatuUtil.getZennouPFrom12IkkatuTukiPYenforMsg( maxkngkkansflg, syusyouhncd,
            syusyouhnsdno, syuryouritusdno, kijyunymd, tkbrihrkptani, kijyunteikiikkatu12tkbrip,
            znnkaisyonendo, ikkatupsiteitaniskru);

        exBizCalcbleEquals(zennoupsyonendo, BizCurrency.valueOf(0), "前納Ｐ（初年度含）");
    }

    @Test
    @TestOrder(150)
    public void testgetZennouPFrom12IkkatuTukiPYenforMsg_A15() {

        boolean maxkngkkansflg = true;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        BizDate kijyunymd = BizDate.valueOf("20180201");

        BizCurrency tkbrihrkptani = BizCurrency.valueOf(-1, BizCurrencyTypes.YEN);

        BizCurrency kijyunteikiikkatu12tkbrip = BizCurrency.valueOf(2000000, BizCurrencyTypes.YEN);

        Integer znnkaisyonendo = 99;

        int ikkatupsiteitaniskru = 1;

        BizCurrency zennoupsyonendo = skZennouIkkatuUtil.getZennouPFrom12IkkatuTukiPYenforMsg( maxkngkkansflg, syusyouhncd,
            syusyouhnsdno, syuryouritusdno, kijyunymd, tkbrihrkptani, kijyunteikiikkatu12tkbrip,
            znnkaisyonendo, ikkatupsiteitaniskru);

        exBizCalcbleEquals(zennoupsyonendo, BizCurrency.valueOf(0), "前納Ｐ（初年度含）");
    }

    @Test
    @TestOrder(10)
    public void testgetZennouPFrom12IkkatuTukiPYenforMsg_A16() {

        boolean maxkngkkansflg = true;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        BizDate kijyunymd = BizDate.valueOf("20180201");

        BizCurrency tkbrihrkptani = BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);

        BizCurrency kijyunteikiikkatu12tkbrip = BizCurrency.valueOf(2000000, BizCurrencyTypes.YEN);

        Integer znnkaisyonendo = null;

        int ikkatupsiteitaniskru = 1;

        BizCurrency zennoupsyonendo = skZennouIkkatuUtil.getZennouPFrom12IkkatuTukiPYenforMsg( maxkngkkansflg, syusyouhncd,
            syusyouhnsdno, syuryouritusdno, kijyunymd, tkbrihrkptani, kijyunteikiikkatu12tkbrip,
            znnkaisyonendo, ikkatupsiteitaniskru);

        exBizCalcbleEquals(zennoupsyonendo, BizCurrency.valueOf(0), "前納Ｐ（初年度含）");
    }

    @Test
    @TestOrder(170)
    public void testgetZennouPFrom12IkkatuTukiPYenforMsg_A17() {

        boolean maxkngkkansflg = true;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        BizDate kijyunymd = BizDate.valueOf("20180201");

        BizCurrency tkbrihrkptani = BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);

        BizCurrency kijyunteikiikkatu12tkbrip = BizCurrency.valueOf(2000000, BizCurrencyTypes.YEN);

        Integer znnkaisyonendo = 0;

        int ikkatupsiteitaniskru = 1;

        BizCurrency zennoupsyonendo = skZennouIkkatuUtil.getZennouPFrom12IkkatuTukiPYenforMsg( maxkngkkansflg, syusyouhncd,
            syusyouhnsdno, syuryouritusdno, kijyunymd, tkbrihrkptani, kijyunteikiikkatu12tkbrip,
            znnkaisyonendo, ikkatupsiteitaniskru);

        exBizCalcbleEquals(zennoupsyonendo, BizCurrency.valueOf(0), "前納Ｐ（初年度含）");
    }

    @Test
    @TestOrder(180)
    public void testgetZennouPFrom12IkkatuTukiPYenforMsg_A18() {

        boolean maxkngkkansflg = true;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        BizDate kijyunymd = BizDate.valueOf("20180201");

        BizCurrency tkbrihrkptani = BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);

        BizCurrency kijyunteikiikkatu12tkbrip = BizCurrency.valueOf(2000000, BizCurrencyTypes.YEN);

        Integer znnkaisyonendo = 1;

        int ikkatupsiteitaniskru = 1;

        BizCurrency zennoupsyonendo = skZennouIkkatuUtil.getZennouPFrom12IkkatuTukiPYenforMsg( maxkngkkansflg, syusyouhncd,
            syusyouhnsdno, syuryouritusdno, kijyunymd, tkbrihrkptani, kijyunteikiikkatu12tkbrip,
            znnkaisyonendo, ikkatupsiteitaniskru);

        exBizCalcbleEquals(zennoupsyonendo, BizCurrency.valueOf(0), "前納Ｐ（初年度含）");
    }

    @Test
    @TestOrder(190)
    public void testgetZennouPFrom12IkkatuTukiPYenforMsg_A19() {

        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.TESTPATTERN2;

        boolean maxkngkkansflg = true;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        BizDate kijyunymd = BizDate.valueOf("20180201");

        BizCurrency tkbrihrkptani = BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);

        BizCurrency kijyunteikiikkatu12tkbrip = BizCurrency.valueOf(2000000, BizCurrencyTypes.YEN);

        Integer znnkaisyonendo = 99;

        int ikkatupsiteitaniskru = 1;

        BizCurrency zennoupsyonendo = skZennouIkkatuUtil.getZennouPFrom12IkkatuTukiPYenforMsg( maxkngkkansflg, syusyouhncd,
            syusyouhnsdno, syuryouritusdno, kijyunymd, tkbrihrkptani, kijyunteikiikkatu12tkbrip,
            znnkaisyonendo, ikkatupsiteitaniskru);

        exBizCalcbleEquals(zennoupsyonendo, BizCurrency.valueOf(0), "前納Ｐ（初年度含）");
    }

    @Test
    @TestOrder(200)
    public void testgetZennouPFrom12IkkatuTukiPYenforMsg_A20() {

        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.TESTPATTERN3;

        boolean maxkngkkansflg = true;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        BizDate kijyunymd = BizDate.valueOf("20180201");

        BizCurrency tkbrihrkptani = BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);

        BizCurrency kijyunteikiikkatu12tkbrip = BizCurrency.valueOf(2000000, BizCurrencyTypes.YEN);

        Integer znnkaisyonendo = 99;

        int ikkatupsiteitaniskru = 0;

        BizCurrency zennoupsyonendo = skZennouIkkatuUtil.getZennouPFrom12IkkatuTukiPYenforMsg( maxkngkkansflg, syusyouhncd,
            syusyouhnsdno, syuryouritusdno, kijyunymd, tkbrihrkptani, kijyunteikiikkatu12tkbrip,
            znnkaisyonendo, ikkatupsiteitaniskru);

        exBizCalcbleEquals(zennoupsyonendo, BizCurrency.valueOf(0), "前納Ｐ（初年度含）");
    }

    @Test
    @TestOrder(210)
    public void testgetZennouPFrom12IkkatuTukiPYenforMsg_A21() {

        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.TESTPATTERN4;

        boolean maxkngkkansflg = true;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        BizDate kijyunymd = BizDate.valueOf("20180201");

        BizCurrency tkbrihrkptani = BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);

        BizCurrency kijyunteikiikkatu12tkbrip = BizCurrency.valueOf(2000000, BizCurrencyTypes.YEN);

        Integer znnkaisyonendo = 99;

        int ikkatupsiteitaniskru = 1;

        BizCurrency zennoupsyonendo = skZennouIkkatuUtil.getZennouPFrom12IkkatuTukiPYenforMsg( maxkngkkansflg, syusyouhncd,
            syusyouhnsdno, syuryouritusdno, kijyunymd, tkbrihrkptani, kijyunteikiikkatu12tkbrip,
            znnkaisyonendo, ikkatupsiteitaniskru);

        exBizCalcbleEquals(zennoupsyonendo, BizCurrency.valueOf(0), "前納Ｐ（初年度含）");
    }

    @Test
    @TestOrder(220)
    public void testgetZennouPFrom12IkkatuTukiPYenforMsg_A22() {

        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.TESTPATTERN5;

        boolean maxkngkkansflg = true;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        BizDate kijyunymd = BizDate.valueOf("20180201");

        BizCurrency tkbrihrkptani = BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);

        BizCurrency kijyunteikiikkatu12tkbrip = BizCurrency.valueOf(2000000, BizCurrencyTypes.YEN);

        Integer znnkaisyonendo = 99;

        int ikkatupsiteitaniskru = 1;

        BizCurrency zennoupsyonendo = skZennouIkkatuUtil.getZennouPFrom12IkkatuTukiPYenforMsg( maxkngkkansflg, syusyouhncd,
            syusyouhnsdno, syuryouritusdno, kijyunymd, tkbrihrkptani, kijyunteikiikkatu12tkbrip,
            znnkaisyonendo, ikkatupsiteitaniskru);

        exBizCalcbleEquals(zennoupsyonendo, BizCurrency.valueOf(0), "前納Ｐ（初年度含）");
    }

    @Test
    @TestOrder(230)
    public void testgetZennouPFrom12IkkatuTukiPYenforMsg_A23() {

        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.TESTPATTERN1;

        KeisanZennouNyuukinGk2MockForSinkeiyaku.SYORIPTN = KeisanZennouNyuukinGk2MockForSinkeiyaku.TESTPATTERN2;

        boolean maxkngkkansflg = true;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        BizDate kijyunymd = BizDate.valueOf("20180201");

        BizCurrency tkbrihrkptani = BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);

        BizCurrency kijyunteikiikkatu12tkbrip = BizCurrency.valueOf(2000000, BizCurrencyTypes.YEN);

        Integer znnkaisyonendo = 99;

        int ikkatupsiteitaniskru = 1;

        BizCurrency zennoupsyonendo = skZennouIkkatuUtil.getZennouPFrom12IkkatuTukiPYenforMsg( maxkngkkansflg, syusyouhncd,
            syusyouhnsdno, syuryouritusdno, kijyunymd, tkbrihrkptani, kijyunteikiikkatu12tkbrip,
            znnkaisyonendo, ikkatupsiteitaniskru);

        exBizCalcbleEquals(zennoupsyonendo, BizCurrency.valueOf(0), "前納Ｐ（初年度含）");
    }

    @Test
    @TestOrder(240)
    public void testgetZennouPFrom12IkkatuTukiPYenforMsg_A24() {

        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.TESTPATTERN1;

        KeisanZennouNyuukinGk2MockForSinkeiyaku.SYORIPTN = KeisanZennouNyuukinGk2MockForSinkeiyaku.TESTPATTERN3;

        boolean maxkngkkansflg = true;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        BizDate kijyunymd = BizDate.valueOf("20180201");

        BizCurrency tkbrihrkptani = BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);

        BizCurrency kijyunteikiikkatu12tkbrip = BizCurrency.valueOf(2000000, BizCurrencyTypes.YEN);

        Integer znnkaisyonendo = 99;

        int ikkatupsiteitaniskru = 1;

        BizCurrency zennoupsyonendo = skZennouIkkatuUtil.getZennouPFrom12IkkatuTukiPYenforMsg( maxkngkkansflg, syusyouhncd,
            syusyouhnsdno, syuryouritusdno, kijyunymd, tkbrihrkptani, kijyunteikiikkatu12tkbrip,
            znnkaisyonendo, ikkatupsiteitaniskru);

        exBizCalcbleEquals(zennoupsyonendo, BizCurrency.valueOf(0), "前納Ｐ（初年度含）");
    }

    @Test
    @TestOrder(250)
    public void testgetZennouPFrom12IkkatuTukiPYenforMsg_A25() {

        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.TESTPATTERN1;

        KeisanZennouNyuukinGk2MockForSinkeiyaku.SYORIPTN = KeisanZennouNyuukinGk2MockForSinkeiyaku.TESTPATTERN4;

        boolean maxkngkkansflg = true;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        BizDate kijyunymd = BizDate.valueOf("20180201");

        BizCurrency tkbrihrkptani = BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);

        BizCurrency kijyunteikiikkatu12tkbrip = BizCurrency.valueOf(2000000, BizCurrencyTypes.YEN);

        Integer znnkaisyonendo = 99;

        int ikkatupsiteitaniskru = 1;

        BizCurrency zennoupsyonendo = skZennouIkkatuUtil.getZennouPFrom12IkkatuTukiPYenforMsg( maxkngkkansflg, syusyouhncd,
            syusyouhnsdno, syuryouritusdno, kijyunymd, tkbrihrkptani, kijyunteikiikkatu12tkbrip,
            znnkaisyonendo, ikkatupsiteitaniskru);

        exBizCalcbleEquals(zennoupsyonendo, BizCurrency.valueOf(0), "前納Ｐ（初年度含）");
    }

    @Test
    @TestOrder(260)
    public void testgetZennouPFrom12IkkatuTukiPYenforMsg_A26() {

        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.TESTPATTERN1;

        KeisanZennouNyuukinGk2MockForSinkeiyaku.SYORIPTN = KeisanZennouNyuukinGk2MockForSinkeiyaku.TESTPATTERN5;

        boolean maxkngkkansflg = true;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        BizDate kijyunymd = BizDate.valueOf("20180201");

        BizCurrency tkbrihrkptani = BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);

        BizCurrency kijyunteikiikkatu12tkbrip = BizCurrency.valueOf(2000000, BizCurrencyTypes.YEN);

        Integer znnkaisyonendo = 99;

        int ikkatupsiteitaniskru = 1;

        BizCurrency zennoupsyonendo = skZennouIkkatuUtil.getZennouPFrom12IkkatuTukiPYenforMsg( maxkngkkansflg, syusyouhncd,
            syusyouhnsdno, syuryouritusdno, kijyunymd, tkbrihrkptani, kijyunteikiikkatu12tkbrip,
            znnkaisyonendo, ikkatupsiteitaniskru);

        exBizCalcbleEquals(zennoupsyonendo, BizCurrency.valueOf(0), "前納Ｐ（初年度含）");
    }

    @Test
    @TestOrder(270)
    public void testgetZennouPFrom12IkkatuTukiPYenforMsg_A27() {

        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.TESTPATTERN1;

        KeisanZennouNyuukinGk2MockForSinkeiyaku.SYORIPTN = KeisanZennouNyuukinGk2MockForSinkeiyaku.TESTPATTERN1;

        boolean maxkngkkansflg = true;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        BizDate kijyunymd = BizDate.valueOf("20180201");

        BizCurrency tkbrihrkptani = BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);

        BizCurrency kijyunteikiikkatu12tkbrip = BizCurrency.valueOf(2000000, BizCurrencyTypes.YEN);

        Integer znnkaisyonendo = 99;

        int ikkatupsiteitaniskru = 1;

        BizCurrency zennoupsyonendo = skZennouIkkatuUtil.getZennouPFrom12IkkatuTukiPYenforMsg( maxkngkkansflg, syusyouhncd,
            syusyouhnsdno, syuryouritusdno, kijyunymd, tkbrihrkptani, kijyunteikiikkatu12tkbrip,
            znnkaisyonendo, ikkatupsiteitaniskru);

        exBizCalcbleEquals(zennoupsyonendo, BizCurrency.valueOf(4444.4), "前納Ｐ（初年度含）");
    }

    @Test
    @TestOrder(280)
    public void testgetZennouPFrom12IkkatuTukiPYenforMsg_A28() {

        MockObjectManager.initialize();

        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.TESTPATTERN1;

        KeisanZennouNyuukinGk2MockForSinkeiyaku.SYORIPTN = KeisanZennouNyuukinGk2MockForSinkeiyaku.TESTPATTERN1;

        boolean maxkngkkansflg = false;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        BizDate kijyunymd = BizDate.valueOf("20180201");

        BizCurrency tkbrihrkptani = BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);

        BizCurrency kijyunteikiikkatu12tkbrip = BizCurrency.valueOf(2000000, BizCurrencyTypes.YEN);

        Integer znnkaisyonendo = 99;

        int ikkatupsiteitaniskru = 1;

        BizCurrency zennoupsyonendo = skZennouIkkatuUtil.getZennouPFrom12IkkatuTukiPYenforMsg( maxkngkkansflg, syusyouhncd,
            syusyouhnsdno, syuryouritusdno, kijyunymd, tkbrihrkptani, kijyunteikiikkatu12tkbrip,
            znnkaisyonendo, ikkatupsiteitaniskru);

        exBizCalcbleEquals(zennoupsyonendo, BizCurrency.valueOf(4444.5), "前納Ｐ（初年度含）");

        exDateEquals((BizDate) MockObjectManager.getArgument(KeisanZennouNyuukinGk2MockForSinkeiyaku.class,
            "execKeisanSinkeiyakuDoujiZennouNyuukinGk", 0, 0), BizDate.valueOf("20180201"), "基準日");

        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanZennouNyuukinGk2MockForSinkeiyaku.class,
            "execKeisanSinkeiyakuDoujiZennouNyuukinGk", 0, 1), BizCurrency.valueOf(3333.35), "前納時払込保険料");

        exNumericEquals((Integer) MockObjectManager.getArgument(KeisanZennouNyuukinGk2MockForSinkeiyaku.class,
            "execKeisanSinkeiyakuDoujiZennouNyuukinGk", 0, 2), 98, "前納期間");

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanZennouNyuukinGk2MockForSinkeiyaku.class,
            "execKeisanSinkeiyakuDoujiZennouNyuukinGk", 0, 3), C_Tuukasyu.BLNK, "領収通貨種類");

        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanZennouNyuukinGk2MockForSinkeiyaku.class,
            "execKeisanSinkeiyakuDoujiZennouNyuukinGk", 0, 4), null, "領収為替レート");

        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanZennouNyuukinGk2MockForSinkeiyaku.class,
            "execKeisanSinkeiyakuDoujiZennouNyuukinGk", 0, 5), null, "円換算適用為替レート");

        KeisanIkkatuNyuukinGkBean keisanIkkatuNyuukinGkBean = (KeisanIkkatuNyuukinGkBean) MockObjectManager
            .getArgument(KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.class, "exec", 0, 0);

        boolean  iktwaribikiFuyouFlg= (boolean)MockObjectManager.getArgument(KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.class, "exec", 0, 1);


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

        exBizCalcbleEquals(keisanIkkatuNyuukinGkBean.getKeisanIkkatuNyuukinGkSyouhnBeanLst().get(0).getHokenryou(), BizCurrency.valueOf(1000000), "保険料");

        exBizCalcbleEquals(keisanIkkatuNyuukinGkBean.getKeisanIkkatuNyuukinGkSyouhnBeanLst().get(0).getYoteiRiritu(), BizNumber.ZERO, "予定利率");

        exBooleanEquals(iktwaribikiFuyouFlg, false, "一括割引不要フラグ");
    }
}
