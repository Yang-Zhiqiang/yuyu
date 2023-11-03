package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.hozen.ascommon.KeisanZennouNyuukinGk2;
import yuyu.common.hozen.ascommon.KeisanZennouNyuukinGk2MockForSinkeiyaku;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 新契約前納一括払関連ユーティリティクラスのメソッド {@link SkZennouIkkatuUtil#getZennouPFromNenbaraiPforMsg(
        boolean pMaxkngkkansflg,String pSyusyouhncd,Integer pSyusyouhnsdno,String pSyuryouritusdno,BizDate pKijyunymd,
        BizCurrency pKijyunymdnjyuutoup,,BizCurrency pHrkptani,Integer pZnnkaisyonendo,
        int pZennoupsiteitaniskru)} テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class SkZennouIkkatuUtilTest_getZennouPFromNenbaraiPforMsg {

    @Inject
    private SkZennouIkkatuUtil skZennouIkkatuUtil;

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {

                bind(KeisanZennouNyuukinGk2.class).to(KeisanZennouNyuukinGk2MockForSinkeiyaku.class);

            }
        });
    }

    @BeforeClass
    public static void testInit() {

        KeisanZennouNyuukinGk2MockForSinkeiyaku.caller = SkZennouIkkatuUtilTest_getZennouPFromNenbaraiPforMsg.class;
    }

    @AfterClass
    public static void testClear() {

        MockObjectManager.initialize();

        KeisanZennouNyuukinGk2MockForSinkeiyaku.caller = null;
        KeisanZennouNyuukinGk2MockForSinkeiyaku.SYORIPTN = null;
    }

    @Test
    @TestOrder(10)
    public void testggetZennouPFromNenbaraiPforMsg_A1() {

        boolean maxkngkkansflg = true;

        String syusyouhncd = null;

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        BizDate kijyunymd = BizDate.valueOf("20180201");

        BizCurrency kijyunymdnjyuutoup = BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);

        BizCurrency hrkptani = BizCurrency.valueOf(2000000, BizCurrencyTypes.YEN);

        Integer znnkaisyonendo = 99;

        int ikkatupsiteitaniskru = 1;

        BizCurrency zennoupsyonendo = skZennouIkkatuUtil.getZennouPFromNenbaraiPforMsg( maxkngkkansflg, syusyouhncd,
            syusyouhnsdno, syuryouritusdno, kijyunymd, hrkptani, kijyunymdnjyuutoup,
            znnkaisyonendo, ikkatupsiteitaniskru);

        exBizCalcbleEquals(zennoupsyonendo, BizCurrency.valueOf(0), "前納Ｐ（初年度含）");
    }

    @Test
    @TestOrder(20)
    public void testggetZennouPFromNenbaraiPforMsg_A2() {

        boolean maxkngkkansflg = true;

        String syusyouhncd = "";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        BizDate kijyunymd = BizDate.valueOf("20180201");

        BizCurrency kijyunymdnjyuutoup = BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);

        BizCurrency hrkptani = BizCurrency.valueOf(2000000, BizCurrencyTypes.YEN);

        Integer znnkaisyonendo = 99;

        int ikkatupsiteitaniskru = 1;

        BizCurrency zennoupsyonendo = skZennouIkkatuUtil.getZennouPFromNenbaraiPforMsg( maxkngkkansflg, syusyouhncd,
            syusyouhnsdno, syuryouritusdno, kijyunymd, hrkptani, kijyunymdnjyuutoup,
            znnkaisyonendo, ikkatupsiteitaniskru);

        exBizCalcbleEquals(zennoupsyonendo, BizCurrency.valueOf(0), "前納Ｐ（初年度含）");
    }

    @Test
    @TestOrder(30)
    public void testggetZennouPFromNenbaraiPforMsg_A3() {

        boolean maxkngkkansflg = true;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = null;

        String syuryouritusdno = "101";

        BizDate kijyunymd = BizDate.valueOf("20180201");

        BizCurrency kijyunymdnjyuutoup = BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);

        BizCurrency hrkptani = BizCurrency.valueOf(2000000, BizCurrencyTypes.YEN);

        Integer znnkaisyonendo = 99;

        int ikkatupsiteitaniskru = 1;

        BizCurrency zennoupsyonendo = skZennouIkkatuUtil.getZennouPFromNenbaraiPforMsg( maxkngkkansflg, syusyouhncd,
            syusyouhnsdno, syuryouritusdno, kijyunymd, hrkptani, kijyunymdnjyuutoup,
            znnkaisyonendo, ikkatupsiteitaniskru);

        exBizCalcbleEquals(zennoupsyonendo, BizCurrency.valueOf(0), "前納Ｐ（初年度含）");
    }

    @Test
    @TestOrder(40)
    public void testggetZennouPFromNenbaraiPforMsg_A4() {

        boolean maxkngkkansflg = true;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 0;

        String syuryouritusdno = "101";

        BizDate kijyunymd = BizDate.valueOf("20180201");

        BizCurrency kijyunymdnjyuutoup = BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);

        BizCurrency hrkptani = BizCurrency.valueOf(2000000, BizCurrencyTypes.YEN);

        Integer znnkaisyonendo = 99;

        int ikkatupsiteitaniskru = 1;

        BizCurrency zennoupsyonendo = skZennouIkkatuUtil.getZennouPFromNenbaraiPforMsg( maxkngkkansflg, syusyouhncd,
            syusyouhnsdno, syuryouritusdno, kijyunymd, hrkptani, kijyunymdnjyuutoup,
            znnkaisyonendo, ikkatupsiteitaniskru);

        exBizCalcbleEquals(zennoupsyonendo, BizCurrency.valueOf(0), "前納Ｐ（初年度含）");
    }

    @Test
    @TestOrder(50)
    public void testggetZennouPFromNenbaraiPforMsg_A5() {

        boolean maxkngkkansflg = true;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = -1;

        String syuryouritusdno = "101";

        BizDate kijyunymd = BizDate.valueOf("20180201");

        BizCurrency kijyunymdnjyuutoup = BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);

        BizCurrency hrkptani = BizCurrency.valueOf(2000000, BizCurrencyTypes.YEN);

        Integer znnkaisyonendo = 99;

        int ikkatupsiteitaniskru = 1;

        BizCurrency zennoupsyonendo = skZennouIkkatuUtil.getZennouPFromNenbaraiPforMsg( maxkngkkansflg, syusyouhncd,
            syusyouhnsdno, syuryouritusdno, kijyunymd, hrkptani, kijyunymdnjyuutoup,
            znnkaisyonendo, ikkatupsiteitaniskru);

        exBizCalcbleEquals(zennoupsyonendo, BizCurrency.valueOf(0), "前納Ｐ（初年度含）");
    }

    @Test
    @TestOrder(60)
    public void testggetZennouPFromNenbaraiPforMsg_A6() {

        boolean maxkngkkansflg = true;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = null;

        BizDate kijyunymd = BizDate.valueOf("20180201");

        BizCurrency kijyunymdnjyuutoup = BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);

        BizCurrency hrkptani = BizCurrency.valueOf(2000000, BizCurrencyTypes.YEN);

        Integer znnkaisyonendo = 99;

        int ikkatupsiteitaniskru = 1;

        BizCurrency zennoupsyonendo = skZennouIkkatuUtil.getZennouPFromNenbaraiPforMsg( maxkngkkansflg, syusyouhncd,
            syusyouhnsdno, syuryouritusdno, kijyunymd, hrkptani, kijyunymdnjyuutoup,
            znnkaisyonendo, ikkatupsiteitaniskru);

        exBizCalcbleEquals(zennoupsyonendo, BizCurrency.valueOf(0), "前納Ｐ（初年度含）");
    }

    @Test
    @TestOrder(70)
    public void testggetZennouPFromNenbaraiPforMsg_A7() {

        boolean maxkngkkansflg = true;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "";

        BizDate kijyunymd = BizDate.valueOf("20180201");

        BizCurrency kijyunymdnjyuutoup = BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);

        BizCurrency hrkptani = BizCurrency.valueOf(2000000, BizCurrencyTypes.YEN);

        Integer znnkaisyonendo = 99;

        int ikkatupsiteitaniskru = 1;

        BizCurrency zennoupsyonendo = skZennouIkkatuUtil.getZennouPFromNenbaraiPforMsg( maxkngkkansflg, syusyouhncd,
            syusyouhnsdno, syuryouritusdno, kijyunymd, hrkptani, kijyunymdnjyuutoup,
            znnkaisyonendo, ikkatupsiteitaniskru);

        exBizCalcbleEquals(zennoupsyonendo, BizCurrency.valueOf(0), "前納Ｐ（初年度含）");
    }

    @Test
    @TestOrder(80)
    public void testggetZennouPFromNenbaraiPforMsg_A8() {

        boolean maxkngkkansflg = true;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        BizDate kijyunymd = null;

        BizCurrency kijyunymdnjyuutoup = BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);

        BizCurrency hrkptani = BizCurrency.valueOf(2000000, BizCurrencyTypes.YEN);

        Integer znnkaisyonendo = 99;

        int ikkatupsiteitaniskru = 1;

        BizCurrency zennoupsyonendo = skZennouIkkatuUtil.getZennouPFromNenbaraiPforMsg( maxkngkkansflg, syusyouhncd,
            syusyouhnsdno, syuryouritusdno, kijyunymd, hrkptani, kijyunymdnjyuutoup,
            znnkaisyonendo, ikkatupsiteitaniskru);

        exBizCalcbleEquals(zennoupsyonendo, BizCurrency.valueOf(0), "前納Ｐ（初年度含）");
    }

    @Test
    @TestOrder(90)
    public void testggetZennouPFromNenbaraiPforMsg_A9() {

        boolean maxkngkkansflg = true;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        BizDate kijyunymd = BizDate.valueOf("20180230");

        BizCurrency kijyunymdnjyuutoup = BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);

        BizCurrency hrkptani = BizCurrency.valueOf(2000000, BizCurrencyTypes.YEN);

        Integer znnkaisyonendo = 99;

        int ikkatupsiteitaniskru = 1;

        BizCurrency zennoupsyonendo = skZennouIkkatuUtil.getZennouPFromNenbaraiPforMsg( maxkngkkansflg, syusyouhncd,
            syusyouhnsdno, syuryouritusdno, kijyunymd, hrkptani, kijyunymdnjyuutoup,
            znnkaisyonendo, ikkatupsiteitaniskru);

        exBizCalcbleEquals(zennoupsyonendo, BizCurrency.valueOf(0), "前納Ｐ（初年度含）");
    }

    @Test
    @TestOrder(100)
    public void testggetZennouPFromNenbaraiPforMsg_A10() {

        boolean maxkngkkansflg = true;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        BizDate kijyunymd = BizDate.valueOf("20180201");

        BizCurrency kijyunymdnjyuutoup = null;

        BizCurrency hrkptani = BizCurrency.valueOf(2000000, BizCurrencyTypes.YEN);

        Integer znnkaisyonendo = 99;

        int ikkatupsiteitaniskru = 1;

        BizCurrency zennoupsyonendo = skZennouIkkatuUtil.getZennouPFromNenbaraiPforMsg( maxkngkkansflg, syusyouhncd,
            syusyouhnsdno, syuryouritusdno, kijyunymd, hrkptani, kijyunymdnjyuutoup,
            znnkaisyonendo, ikkatupsiteitaniskru);

        exBizCalcbleEquals(zennoupsyonendo, BizCurrency.valueOf(0), "前納Ｐ（初年度含）");
    }

    @Test
    @TestOrder(110)
    public void testggetZennouPFromNenbaraiPforMsg_A11() {

        boolean maxkngkkansflg = true;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        BizDate kijyunymd = BizDate.valueOf("20180201");

        BizCurrency kijyunymdnjyuutoup = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        BizCurrency hrkptani = BizCurrency.valueOf(2000000, BizCurrencyTypes.YEN);

        Integer znnkaisyonendo = 99;

        int ikkatupsiteitaniskru = 1;

        BizCurrency zennoupsyonendo = skZennouIkkatuUtil.getZennouPFromNenbaraiPforMsg( maxkngkkansflg, syusyouhncd,
            syusyouhnsdno, syuryouritusdno, kijyunymd, hrkptani, kijyunymdnjyuutoup,
            znnkaisyonendo, ikkatupsiteitaniskru);

        exBizCalcbleEquals(zennoupsyonendo, BizCurrency.valueOf(0), "前納Ｐ（初年度含）");
    }

    @Test
    @TestOrder(120)
    public void testggetZennouPFromNenbaraiPforMsg_A12() {

        boolean maxkngkkansflg = true;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        BizDate kijyunymd = BizDate.valueOf("20180201");

        BizCurrency kijyunymdnjyuutoup = BizCurrency.valueOf(-1, BizCurrencyTypes.YEN);

        BizCurrency hrkptani = BizCurrency.valueOf(2000000, BizCurrencyTypes.YEN);

        Integer znnkaisyonendo = 99;

        int ikkatupsiteitaniskru = 1;

        BizCurrency zennoupsyonendo = skZennouIkkatuUtil.getZennouPFromNenbaraiPforMsg( maxkngkkansflg, syusyouhncd,
            syusyouhnsdno, syuryouritusdno, kijyunymd, hrkptani, kijyunymdnjyuutoup,
            znnkaisyonendo, ikkatupsiteitaniskru);

        exBizCalcbleEquals(zennoupsyonendo, BizCurrency.valueOf(0), "前納Ｐ（初年度含）");
    }

    @Test
    @TestOrder(130)
    public void testggetZennouPFromNenbaraiPforMsg_A13() {

        boolean maxkngkkansflg = true;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        BizDate kijyunymd = BizDate.valueOf("20180201");

        BizCurrency kijyunymdnjyuutoup = BizCurrency.optional();

        BizCurrency hrkptani = BizCurrency.valueOf(2000000, BizCurrencyTypes.YEN);

        Integer znnkaisyonendo = 99;

        int ikkatupsiteitaniskru = 1;

        BizCurrency zennoupsyonendo = skZennouIkkatuUtil.getZennouPFromNenbaraiPforMsg( maxkngkkansflg, syusyouhncd,
            syusyouhnsdno, syuryouritusdno, kijyunymd, hrkptani, kijyunymdnjyuutoup,
            znnkaisyonendo, ikkatupsiteitaniskru);

        exBizCalcbleEquals(zennoupsyonendo, BizCurrency.valueOf(0), "前納Ｐ（初年度含）");
    }

    @Test
    @TestOrder(140)
    public void testggetZennouPFromNenbaraiPforMsg_A14() {

        boolean maxkngkkansflg = true;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        BizDate kijyunymd = BizDate.valueOf("20180201");

        BizCurrency kijyunymdnjyuutoup = BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);

        BizCurrency hrkptani = null;

        Integer znnkaisyonendo = 99;

        int ikkatupsiteitaniskru = 1;

        BizCurrency zennoupsyonendo = skZennouIkkatuUtil.getZennouPFromNenbaraiPforMsg( maxkngkkansflg, syusyouhncd,
            syusyouhnsdno, syuryouritusdno, kijyunymd, hrkptani, kijyunymdnjyuutoup,
            znnkaisyonendo, ikkatupsiteitaniskru);

        exBizCalcbleEquals(zennoupsyonendo, BizCurrency.valueOf(0), "前納Ｐ（初年度含）");
    }

    @Test
    @TestOrder(150)
    public void testggetZennouPFromNenbaraiPforMsg_A15() {

        boolean maxkngkkansflg = true;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        BizDate kijyunymd = BizDate.valueOf("20180201");

        BizCurrency kijyunymdnjyuutoup = BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);

        BizCurrency hrkptani = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        Integer znnkaisyonendo = 99;

        int ikkatupsiteitaniskru = 1;

        BizCurrency zennoupsyonendo = skZennouIkkatuUtil.getZennouPFromNenbaraiPforMsg( maxkngkkansflg, syusyouhncd,
            syusyouhnsdno, syuryouritusdno, kijyunymd, hrkptani, kijyunymdnjyuutoup,
            znnkaisyonendo, ikkatupsiteitaniskru);

        exBizCalcbleEquals(zennoupsyonendo, BizCurrency.valueOf(0), "前納Ｐ（初年度含）");
    }

    @Test
    @TestOrder(160)
    public void testggetZennouPFromNenbaraiPforMsg_A16() {

        boolean maxkngkkansflg = true;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        BizDate kijyunymd = BizDate.valueOf("20180201");

        BizCurrency kijyunymdnjyuutoup = BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);

        BizCurrency hrkptani = BizCurrency.valueOf(-1, BizCurrencyTypes.YEN);

        Integer znnkaisyonendo = 99;

        int ikkatupsiteitaniskru = 1;

        BizCurrency zennoupsyonendo = skZennouIkkatuUtil.getZennouPFromNenbaraiPforMsg( maxkngkkansflg, syusyouhncd,
            syusyouhnsdno, syuryouritusdno, kijyunymd, hrkptani, kijyunymdnjyuutoup,
            znnkaisyonendo, ikkatupsiteitaniskru);

        exBizCalcbleEquals(zennoupsyonendo, BizCurrency.valueOf(0), "前納Ｐ（初年度含）");
    }

    @Test
    @TestOrder(170)
    public void testggetZennouPFromNenbaraiPforMsg_A17() {

        boolean maxkngkkansflg = true;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        BizDate kijyunymd = BizDate.valueOf("20180201");

        BizCurrency kijyunymdnjyuutoup = BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);

        BizCurrency hrkptani = BizCurrency.optional();

        Integer znnkaisyonendo = 99;

        int ikkatupsiteitaniskru = 1;

        BizCurrency zennoupsyonendo = skZennouIkkatuUtil.getZennouPFromNenbaraiPforMsg( maxkngkkansflg, syusyouhncd,
            syusyouhnsdno, syuryouritusdno, kijyunymd, hrkptani, kijyunymdnjyuutoup,
            znnkaisyonendo, ikkatupsiteitaniskru);

        exBizCalcbleEquals(zennoupsyonendo, BizCurrency.valueOf(0), "前納Ｐ（初年度含）");
    }

    @Test
    @TestOrder(180)
    public void testggetZennouPFromNenbaraiPforMsg_A18() {

        boolean maxkngkkansflg = true;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        BizDate kijyunymd = BizDate.valueOf("20180201");

        BizCurrency kijyunymdnjyuutoup = BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);

        BizCurrency hrkptani = BizCurrency.valueOf(2000000, BizCurrencyTypes.YEN);

        Integer znnkaisyonendo = null;

        int ikkatupsiteitaniskru = 1;

        BizCurrency zennoupsyonendo = skZennouIkkatuUtil.getZennouPFromNenbaraiPforMsg( maxkngkkansflg, syusyouhncd,
            syusyouhnsdno, syuryouritusdno, kijyunymd, hrkptani, kijyunymdnjyuutoup,
            znnkaisyonendo, ikkatupsiteitaniskru);

        exBizCalcbleEquals(zennoupsyonendo, BizCurrency.valueOf(0), "前納Ｐ（初年度含）");
    }

    @Test
    @TestOrder(190)
    public void testggetZennouPFromNenbaraiPforMsg_A19() {

        boolean maxkngkkansflg = true;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        BizDate kijyunymd = BizDate.valueOf("20180201");

        BizCurrency kijyunymdnjyuutoup = BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);

        BizCurrency hrkptani = BizCurrency.valueOf(2000000, BizCurrencyTypes.YEN);

        Integer znnkaisyonendo = 0;

        int ikkatupsiteitaniskru = 1;

        BizCurrency zennoupsyonendo = skZennouIkkatuUtil.getZennouPFromNenbaraiPforMsg( maxkngkkansflg, syusyouhncd,
            syusyouhnsdno, syuryouritusdno, kijyunymd, hrkptani, kijyunymdnjyuutoup,
            znnkaisyonendo, ikkatupsiteitaniskru);

        exBizCalcbleEquals(zennoupsyonendo, BizCurrency.valueOf(0), "前納Ｐ（初年度含）");
    }

    @Test
    @TestOrder(200)
    public void testggetZennouPFromNenbaraiPforMsg_A20() {

        boolean maxkngkkansflg = true;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        BizDate kijyunymd = BizDate.valueOf("20180201");

        BizCurrency kijyunymdnjyuutoup = BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);

        BizCurrency hrkptani = BizCurrency.valueOf(2000000, BizCurrencyTypes.YEN);

        Integer znnkaisyonendo = 1;

        int ikkatupsiteitaniskru = 1;

        BizCurrency zennoupsyonendo = skZennouIkkatuUtil.getZennouPFromNenbaraiPforMsg( maxkngkkansflg, syusyouhncd,
            syusyouhnsdno, syuryouritusdno, kijyunymd, hrkptani, kijyunymdnjyuutoup,
            znnkaisyonendo, ikkatupsiteitaniskru);

        exBizCalcbleEquals(zennoupsyonendo, BizCurrency.valueOf(0), "前納Ｐ（初年度含）");
    }

    @Test
    @TestOrder(210)
    public void testggetZennouPFromNenbaraiPforMsg_A21() {

        KeisanZennouNyuukinGk2MockForSinkeiyaku.SYORIPTN = KeisanZennouNyuukinGk2MockForSinkeiyaku.TESTPATTERN2;

        boolean maxkngkkansflg = true;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        BizDate kijyunymd = BizDate.valueOf("20180201");

        BizCurrency kijyunymdnjyuutoup = BizCurrency.valueOf(1000000, BizCurrencyTypes.DOLLAR);

        BizCurrency hrkptani = BizCurrency.valueOf(2000000, BizCurrencyTypes.DOLLAR);

        Integer znnkaisyonendo = 99;

        int ikkatupsiteitaniskru = 1;

        BizCurrency zennoupsyonendo = skZennouIkkatuUtil.getZennouPFromNenbaraiPforMsg( maxkngkkansflg, syusyouhncd,
            syusyouhnsdno, syuryouritusdno, kijyunymd, hrkptani, kijyunymdnjyuutoup,
            znnkaisyonendo, ikkatupsiteitaniskru);

        exBizCalcbleEquals(zennoupsyonendo, BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "前納Ｐ（初年度含）");
    }

    @Test
    @TestOrder(220)
    public void testggetZennouPFromNenbaraiPforMsg_A22() {

        KeisanZennouNyuukinGk2MockForSinkeiyaku.SYORIPTN = KeisanZennouNyuukinGk2MockForSinkeiyaku.TESTPATTERN3;

        boolean maxkngkkansflg = true;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        BizDate kijyunymd = BizDate.valueOf("20180201");

        BizCurrency kijyunymdnjyuutoup = BizCurrency.valueOf(1000000, BizCurrencyTypes.DOLLAR);

        BizCurrency hrkptani = BizCurrency.valueOf(2000000, BizCurrencyTypes.DOLLAR);

        Integer znnkaisyonendo = 99;

        int ikkatupsiteitaniskru = 2;

        BizCurrency zennoupsyonendo = skZennouIkkatuUtil.getZennouPFromNenbaraiPforMsg( maxkngkkansflg, syusyouhncd,
            syusyouhnsdno, syuryouritusdno, kijyunymd, hrkptani, kijyunymdnjyuutoup,
            znnkaisyonendo, ikkatupsiteitaniskru);

        exBizCalcbleEquals(zennoupsyonendo, BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "前納Ｐ（初年度含）");
    }

    @Test
    @TestOrder(230)
    public void testggetZennouPFromNenbaraiPforMsg_A23() {

        KeisanZennouNyuukinGk2MockForSinkeiyaku.SYORIPTN = KeisanZennouNyuukinGk2MockForSinkeiyaku.TESTPATTERN4;

        boolean maxkngkkansflg = true;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        BizDate kijyunymd = BizDate.valueOf("20180201");

        BizCurrency kijyunymdnjyuutoup = BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);

        BizCurrency hrkptani = BizCurrency.valueOf(2000000, BizCurrencyTypes.YEN);

        Integer znnkaisyonendo = 99;

        int ikkatupsiteitaniskru = 1;

        BizCurrency zennoupsyonendo = skZennouIkkatuUtil.getZennouPFromNenbaraiPforMsg( maxkngkkansflg, syusyouhncd,
            syusyouhnsdno, syuryouritusdno, kijyunymd, hrkptani, kijyunymdnjyuutoup,
            znnkaisyonendo, ikkatupsiteitaniskru);

        exBizCalcbleEquals(zennoupsyonendo, BizCurrency.valueOf(0), "前納Ｐ（初年度含）");
    }

    @Test
    @TestOrder(240)
    public void testggetZennouPFromNenbaraiPforMsg_A24() {

        KeisanZennouNyuukinGk2MockForSinkeiyaku.SYORIPTN = KeisanZennouNyuukinGk2MockForSinkeiyaku.TESTPATTERN5;

        boolean maxkngkkansflg = true;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        BizDate kijyunymd = BizDate.valueOf("20180201");

        BizCurrency kijyunymdnjyuutoup = BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);

        BizCurrency hrkptani = BizCurrency.valueOf(2000000, BizCurrencyTypes.YEN);

        Integer znnkaisyonendo = 99;

        int ikkatupsiteitaniskru = 1;

        BizCurrency zennoupsyonendo = skZennouIkkatuUtil.getZennouPFromNenbaraiPforMsg( maxkngkkansflg, syusyouhncd,
            syusyouhnsdno, syuryouritusdno, kijyunymd, hrkptani, kijyunymdnjyuutoup,
            znnkaisyonendo, ikkatupsiteitaniskru);

        exBizCalcbleEquals(zennoupsyonendo, BizCurrency.valueOf(0), "前納Ｐ（初年度含）");
    }

    @Test
    @TestOrder(250)
    public void testggetZennouPFromNenbaraiPforMsg_A25() {

        KeisanZennouNyuukinGk2MockForSinkeiyaku.SYORIPTN = KeisanZennouNyuukinGk2MockForSinkeiyaku.TESTPATTERN1;

        boolean maxkngkkansflg = true;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        BizDate kijyunymd = BizDate.valueOf("20180201");

        BizCurrency kijyunymdnjyuutoup = BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);

        BizCurrency hrkptani = BizCurrency.valueOf(2000000, BizCurrencyTypes.YEN);

        Integer znnkaisyonendo = 99;

        int ikkatupsiteitaniskru = 0;

        BizCurrency zennoupsyonendo = skZennouIkkatuUtil.getZennouPFromNenbaraiPforMsg( maxkngkkansflg, syusyouhncd,
            syusyouhnsdno, syuryouritusdno, kijyunymd, hrkptani, kijyunymdnjyuutoup,
            znnkaisyonendo, ikkatupsiteitaniskru);

        exBizCalcbleEquals(zennoupsyonendo, BizCurrency.valueOf(4444), "前納Ｐ（初年度含）");
    }

    @Test
    @TestOrder(260)
    public void testggetZennouPFromNenbaraiPforMsg_A26() {

        KeisanZennouNyuukinGk2MockForSinkeiyaku.SYORIPTN = KeisanZennouNyuukinGk2MockForSinkeiyaku.TESTPATTERN1;

        boolean maxkngkkansflg = false;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        BizDate kijyunymd = BizDate.valueOf("20180201");

        BizCurrency kijyunymdnjyuutoup = BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);

        BizCurrency hrkptani = BizCurrency.valueOf(2000000, BizCurrencyTypes.YEN);

        Integer znnkaisyonendo = 99;

        int ikkatupsiteitaniskru = 1;

        BizCurrency zennoupsyonendo = skZennouIkkatuUtil.getZennouPFromNenbaraiPforMsg( maxkngkkansflg, syusyouhncd,
            syusyouhnsdno, syuryouritusdno, kijyunymd, hrkptani, kijyunymdnjyuutoup,
            znnkaisyonendo, ikkatupsiteitaniskru);

        exBizCalcbleEquals(zennoupsyonendo, BizCurrency.valueOf(4444.5), "前納Ｐ（初年度含）");
    }
}
