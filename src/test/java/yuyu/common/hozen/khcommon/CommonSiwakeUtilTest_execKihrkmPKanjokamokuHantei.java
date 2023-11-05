package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.AbstractModule;

import yuyu.common.hozen.ascommon.KeisanZennouSeisanGk2;
import yuyu.common.hozen.ascommon.KeisanZennouSeisanGk2MockForHozen;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

/**
 * 仕訳共通ユーティリティクラスのメソッド {@link CommonSiwakeUtil#execKihrkmPKanjokamokuHantei(BizDate,BizDate,BizCurrency,
 * BizDate,BizDateYM,BizCurrency,SiwakeHanteiNyknJissekiRirekiBean[])}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class CommonSiwakeUtilTest_execKihrkmPKanjokamokuHantei {

    @Inject
    private CommonSiwakeUtil commonSiwakeUtil;

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(KeisanZennouSeisanGk2.class).to(KeisanZennouSeisanGk2MockForHozen.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        KeisanZennouSeisanGk2MockForHozen.caller = CommonSiwakeUtilTest_execKihrkmPKanjokamokuHantei.class;
    }

    @AfterClass
    public static void testClear() {

        MockObjectManager.initialize();
        KeisanZennouSeisanGk2MockForHozen.caller = null;
    }

    @Test
    @TestOrder(10)
    public void testExecKihrkmPKanjokamokuHantei_A1() {

        BizDate denYmd = BizDate.valueOf(20180101);
        BizDate kykYmd = BizDate.valueOf(20180102);
        BizCurrency zennouNyuukinkgk = BizCurrency.valueOf(10);
        BizDate ryosyuYmd = BizDate.valueOf(20180103);
        BizDateYM jkipjytYm = BizDateYM.valueOf(201702);
        BizCurrency kihrkmp = BizCurrency.valueOf(0);
        SiwakeHanteiNyknJissekiRirekiBean[] siwakeHanteiNyknJissekiRirekiBeans = new SiwakeHanteiNyknJissekiRirekiBean[0];

        commonSiwakeUtil.execKihrkmPKanjokamokuHantei(denYmd, kykYmd, zennouNyuukinkgk, ryosyuYmd, jkipjytYm,
            kihrkmp, siwakeHanteiNyknJissekiRirekiBeans, C_Hrkkaisuu.TUKI, C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);

        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendoSyokaip(), BizCurrency.valueOf(0), "対象金額（初年度初回保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendo2kaimeikoup(), BizCurrency.valueOf(0), "対象金額（初年度２回目以降）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkJinendoikoup(), BizCurrency.valueOf(0), "対象金額（次年度以降保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSonotahenreikin(), BizCurrency.valueOf(0), "対象金額（その他返戻金）");

        exStringEquals(commonSiwakeUtil.getTaisyouGkSyonendoSyokaip().getCurrencyType().toString(), "YEN",
            "対象金額（初年度初回保険料）");
        exStringEquals(commonSiwakeUtil.getTaisyouGkSyonendo2kaimeikoup().getCurrencyType().toString(), "YEN",
            "対象金額（初年度２回目以降）");
        exStringEquals(commonSiwakeUtil.getTaisyouGkJinendoikoup().getCurrencyType().toString(), "YEN",
            "対象金額（次年度以降保険料）");
        exStringEquals(commonSiwakeUtil.getTaisyouGkSonotahenreikin().getCurrencyType().toString(), "YEN",
            "対象金額（その他返戻金）");
    }

    @Test
    @TestOrder(10)
    public void testExecKihrkmPKanjokamokuHantei_A2() {

        MockObjectManager.initialize();
        KeisanZennouSeisanGk2MockForHozen.SYORIPTN = KeisanZennouSeisanGk2MockForHozen.TESTPATTERN1;
        BizDate denYmd = BizDate.valueOf(20180101);
        BizDate kykYmd = BizDate.valueOf(20180102);
        BizCurrency zennouNyuukinkgk = BizCurrency.valueOf(100000);
        BizDate ryosyuYmd = BizDate.valueOf(20180103);
        BizDateYM jkipjytYm = BizDateYM.valueOf(201702);
        BizCurrency kihrkmp = BizCurrency.valueOf(1000);
        SiwakeHanteiNyknJissekiRirekiBean[] siwakeHanteiNyknJissekiRirekiBeans = new SiwakeHanteiNyknJissekiRirekiBean[1];
        SiwakeHanteiNyknJissekiRirekiBean siwakeHanteiNyknJissekiRirekiBean1 = new SiwakeHanteiNyknJissekiRirekiBean();
        siwakeHanteiNyknJissekiRirekiBean1.setRsgaku(BizCurrency.valueOf(30000));
        siwakeHanteiNyknJissekiRirekiBean1.setHrkp(BizCurrency.valueOf(20000));
        siwakeHanteiNyknJissekiRirekiBean1.setJyutoukaisuum(1);
        siwakeHanteiNyknJissekiRirekiBean1.setJyutoustartym(BizDateYM.valueOf(201701));
        siwakeHanteiNyknJissekiRirekiBean1.setJyutouendym(BizDateYM.valueOf(201801));
        siwakeHanteiNyknJissekiRirekiBeans[0] = siwakeHanteiNyknJissekiRirekiBean1;

        commonSiwakeUtil.execKihrkmPKanjokamokuHantei(denYmd, kykYmd, zennouNyuukinkgk, ryosyuYmd, jkipjytYm,
            kihrkmp, siwakeHanteiNyknJissekiRirekiBeans, C_Hrkkaisuu.TUKI, C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);

        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendoSyokaip(), BizCurrency.valueOf(0), "対象金額（初年度初回保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendo2kaimeikoup(), BizCurrency.valueOf(0), "対象金額（初年度２回目以降）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkJinendoikoup(), BizCurrency.valueOf(0), "対象金額（次年度以降保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSonotahenreikin(), BizCurrency.valueOf(130000),
            "対象金額（その他返戻金）");

        exDateEquals((BizDate) MockObjectManager.getArgument(KeisanZennouSeisanGk2MockForHozen.class, "getZennouPSeisanKbn", 0, 0), BizDate.valueOf("20180103"), "領収日");
        exDateEquals((BizDate) MockObjectManager.getArgument(KeisanZennouSeisanGk2MockForHozen.class, "getZennouPSeisanKbn", 0, 1), BizDate.valueOf("20180101"), "伝票日付");

    }

    @Test
    @TestOrder(30)
    public void testExecKihrkmPKanjokamokuHantei_A3() {

        KeisanZennouSeisanGk2MockForHozen.SYORIPTN = KeisanZennouSeisanGk2MockForHozen.TESTPATTERN2;
        BizDate denYmd = BizDate.valueOf(20180101);
        BizDate kykYmd = BizDate.valueOf(20180102);
        BizCurrency zennouNyuukinkgk = BizCurrency.valueOf(10000);
        BizDate ryosyuYmd = BizDate.valueOf(20180103);
        BizDateYM jkipjytYm = BizDateYM.valueOf(201702);
        BizCurrency kihrkmp = BizCurrency.valueOf(2000);
        SiwakeHanteiNyknJissekiRirekiBean[] siwakeHanteiNyknJissekiRirekiBeans = new SiwakeHanteiNyknJissekiRirekiBean[1];
        SiwakeHanteiNyknJissekiRirekiBean siwakeHanteiNyknJissekiRirekiBean1 = new SiwakeHanteiNyknJissekiRirekiBean();
        siwakeHanteiNyknJissekiRirekiBean1.setRsgaku(BizCurrency.valueOf(130000));
        siwakeHanteiNyknJissekiRirekiBean1.setHrkp(BizCurrency.valueOf(20000));
        siwakeHanteiNyknJissekiRirekiBean1.setJyutoukaisuum(1);
        siwakeHanteiNyknJissekiRirekiBean1.setJyutoustartym(BizDateYM.valueOf(201701));
        siwakeHanteiNyknJissekiRirekiBean1.setJyutouendym(BizDateYM.valueOf(201801));
        siwakeHanteiNyknJissekiRirekiBeans[0] = siwakeHanteiNyknJissekiRirekiBean1;

        commonSiwakeUtil.execKihrkmPKanjokamokuHantei(denYmd, kykYmd, zennouNyuukinkgk, ryosyuYmd, jkipjytYm,
            kihrkmp, siwakeHanteiNyknJissekiRirekiBeans, C_Hrkkaisuu.TUKI, C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);

        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendoSyokaip(), BizCurrency.valueOf(20000),
            "対象金額（初年度初回保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendo2kaimeikoup(), BizCurrency.valueOf(110000),
            "対象金額（初年度２回目以降）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkJinendoikoup(), BizCurrency.valueOf(10000),
            "対象金額（次年度以降保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSonotahenreikin(), BizCurrency.valueOf(0), "対象金額（その他返戻金）");

    }

    @Test
    @TestOrder(40)
    public void testExecKihrkmPKanjokamokuHantei_A4() {

        MockObjectManager.initialize();
        BizDate denYmd = BizDate.valueOf(20180501);
        BizDate kykYmd = BizDate.valueOf(20170102);
        BizCurrency zennouNyuukinkgk = BizCurrency.valueOf(10000);
        BizDate ryosyuYmd = null;
        BizDateYM jkipjytYm = BizDateYM.valueOf(201803);
        BizCurrency kihrkmp = BizCurrency.valueOf(2000);
        SiwakeHanteiNyknJissekiRirekiBean[] siwakeHanteiNyknJissekiRirekiBeans = new SiwakeHanteiNyknJissekiRirekiBean[1];
        SiwakeHanteiNyknJissekiRirekiBean siwakeHanteiNyknJissekiRirekiBean1 = new SiwakeHanteiNyknJissekiRirekiBean();
        siwakeHanteiNyknJissekiRirekiBean1.setRsgaku(BizCurrency.valueOf(130000));
        siwakeHanteiNyknJissekiRirekiBean1.setHrkp(BizCurrency.valueOf(20000));
        siwakeHanteiNyknJissekiRirekiBean1.setJyutoukaisuum(1);
        siwakeHanteiNyknJissekiRirekiBean1.setJyutoustartym(BizDateYM.valueOf(201701));
        siwakeHanteiNyknJissekiRirekiBean1.setJyutouendym(BizDateYM.valueOf(201801));
        siwakeHanteiNyknJissekiRirekiBeans[0] = siwakeHanteiNyknJissekiRirekiBean1;

        commonSiwakeUtil.execKihrkmPKanjokamokuHantei(denYmd, kykYmd, zennouNyuukinkgk, ryosyuYmd, jkipjytYm,
            kihrkmp, siwakeHanteiNyknJissekiRirekiBeans, C_Hrkkaisuu.TUKI, C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);

        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendoSyokaip(), BizCurrency.valueOf(0), "対象金額（初年度初回保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendo2kaimeikoup(), BizCurrency.valueOf(0), "対象金額（初年度２回目以降）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkJinendoikoup(), BizCurrency.valueOf(0), "対象金額（次年度以降保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSonotahenreikin(), BizCurrency.valueOf(2000), "対象金額（その他返戻金）");

    }

    @Test
    @TestOrder(50)
    public void testExecKihrkmPKanjokamokuHantei_A5() {

        BizDate denYmd = BizDate.valueOf(20180501);
        BizDate kykYmd = BizDate.valueOf(20170102);
        BizCurrency zennouNyuukinkgk = BizCurrency.valueOf(10000);
        BizDate ryosyuYmd = null;
        BizDateYM jkipjytYm = BizDateYM.valueOf(201804);
        BizCurrency kihrkmp = BizCurrency.valueOf(3000);
        SiwakeHanteiNyknJissekiRirekiBean[] siwakeHanteiNyknJissekiRirekiBeans = new SiwakeHanteiNyknJissekiRirekiBean[1];
        SiwakeHanteiNyknJissekiRirekiBean siwakeHanteiNyknJissekiRirekiBean1 = new SiwakeHanteiNyknJissekiRirekiBean();
        siwakeHanteiNyknJissekiRirekiBean1.setRsgaku(BizCurrency.valueOf(130000));
        siwakeHanteiNyknJissekiRirekiBean1.setHrkp(BizCurrency.valueOf(20000));
        siwakeHanteiNyknJissekiRirekiBean1.setJyutoukaisuum(1);
        siwakeHanteiNyknJissekiRirekiBean1.setJyutoustartym(BizDateYM.valueOf(201701));
        siwakeHanteiNyknJissekiRirekiBean1.setJyutouendym(BizDateYM.valueOf(201801));
        siwakeHanteiNyknJissekiRirekiBeans[0] = siwakeHanteiNyknJissekiRirekiBean1;

        commonSiwakeUtil.execKihrkmPKanjokamokuHantei(denYmd, kykYmd, zennouNyuukinkgk, ryosyuYmd, jkipjytYm,
            kihrkmp, siwakeHanteiNyknJissekiRirekiBeans, C_Hrkkaisuu.TUKI, C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);

        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendoSyokaip(), BizCurrency.valueOf(0), "対象金額（初年度初回保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendo2kaimeikoup(), BizCurrency.valueOf(0), "対象金額（初年度２回目以降）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkJinendoikoup(), BizCurrency.valueOf(0), "対象金額（次年度以降保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSonotahenreikin(), BizCurrency.valueOf(3000), "対象金額（その他返戻金）");

    }

    @Test
    @TestOrder(60)
    public void testExecKihrkmPKanjokamokuHantei_A6() {

        BizDate denYmd = BizDate.valueOf(20180101);
        BizDate kykYmd = BizDate.valueOf(20180502);
        BizCurrency zennouNyuukinkgk = BizCurrency.valueOf(10000);
        BizDate ryosyuYmd = null;
        BizDateYM jkipjytYm = BizDateYM.valueOf(201805);
        BizCurrency kihrkmp = BizCurrency.valueOf(3000);
        SiwakeHanteiNyknJissekiRirekiBean[] siwakeHanteiNyknJissekiRirekiBeans = new SiwakeHanteiNyknJissekiRirekiBean[0];

        commonSiwakeUtil.execKihrkmPKanjokamokuHantei(denYmd, kykYmd, zennouNyuukinkgk, ryosyuYmd, jkipjytYm,
            kihrkmp, siwakeHanteiNyknJissekiRirekiBeans, C_Hrkkaisuu.TUKI, C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);

        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendoSyokaip(), BizCurrency.valueOf(0), "対象金額（初年度初回保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendo2kaimeikoup(), BizCurrency.valueOf(0), "対象金額（初年度２回目以降）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkJinendoikoup(), BizCurrency.valueOf(0), "対象金額（次年度以降保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSonotahenreikin(), BizCurrency.valueOf(0), "対象金額（その他返戻金）");

    }

    @Test
    @TestOrder(70)
    public void testExecKihrkmPKanjokamokuHantei_A7() {

        BizDate denYmd = BizDate.valueOf(20180101);
        BizDate kykYmd = BizDate.valueOf(20180401);
        BizCurrency zennouNyuukinkgk = BizCurrency.valueOf(10000);
        BizDate ryosyuYmd = null;
        BizDateYM jkipjytYm = BizDateYM.valueOf(201805);
        BizCurrency kihrkmp = BizCurrency.valueOf(3000);
        SiwakeHanteiNyknJissekiRirekiBean[] siwakeHanteiNyknJissekiRirekiBeans = new SiwakeHanteiNyknJissekiRirekiBean[1];
        SiwakeHanteiNyknJissekiRirekiBean siwakeHanteiNyknJissekiRirekiBean1 = new SiwakeHanteiNyknJissekiRirekiBean();
        siwakeHanteiNyknJissekiRirekiBean1.setRsgaku(BizCurrency.valueOf(130000));
        siwakeHanteiNyknJissekiRirekiBean1.setHrkp(BizCurrency.valueOf(20000));
        siwakeHanteiNyknJissekiRirekiBean1.setJyutoukaisuum(1);
        siwakeHanteiNyknJissekiRirekiBean1.setJyutoustartym(BizDateYM.valueOf(201905));
        siwakeHanteiNyknJissekiRirekiBean1.setJyutouendym(BizDateYM.valueOf(201801));
        siwakeHanteiNyknJissekiRirekiBeans[0] = siwakeHanteiNyknJissekiRirekiBean1;

        commonSiwakeUtil.execKihrkmPKanjokamokuHantei(denYmd, kykYmd, zennouNyuukinkgk, ryosyuYmd, jkipjytYm,
            kihrkmp, siwakeHanteiNyknJissekiRirekiBeans, C_Hrkkaisuu.TUKI, C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);

        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendoSyokaip(), BizCurrency.valueOf(0), "対象金額（初年度初回保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendo2kaimeikoup(), BizCurrency.valueOf(0), "対象金額（初年度２回目以降）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkJinendoikoup(), BizCurrency.valueOf(130000), "対象金額（次年度以降保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSonotahenreikin(), BizCurrency.valueOf(0), "対象金額（その他返戻金）");

    }

    @Test
    @TestOrder(80)
    public void testExecKihrkmPKanjokamokuHantei_A8() {

        BizDate denYmd = BizDate.valueOf(20180101);
        BizDate kykYmd = BizDate.valueOf(20180501);
        BizCurrency zennouNyuukinkgk = BizCurrency.valueOf(10000);
        BizDate ryosyuYmd = null;
        BizDateYM jkipjytYm = BizDateYM.valueOf(201806);
        BizCurrency kihrkmp = BizCurrency.valueOf(3000);
        SiwakeHanteiNyknJissekiRirekiBean[] siwakeHanteiNyknJissekiRirekiBeans = new SiwakeHanteiNyknJissekiRirekiBean[3];
        SiwakeHanteiNyknJissekiRirekiBean siwakeHanteiNyknJissekiRirekiBean1 = new SiwakeHanteiNyknJissekiRirekiBean();
        siwakeHanteiNyknJissekiRirekiBean1.setRsgaku(BizCurrency.valueOf(50000));
        siwakeHanteiNyknJissekiRirekiBean1.setHrkp(BizCurrency.valueOf(30000));
        siwakeHanteiNyknJissekiRirekiBean1.setJyutoukaisuum(3);
        siwakeHanteiNyknJissekiRirekiBean1.setJyutoustartym(BizDateYM.valueOf(201905));
        siwakeHanteiNyknJissekiRirekiBean1.setJyutouendym(BizDateYM.valueOf(201801));
        siwakeHanteiNyknJissekiRirekiBeans[0] = siwakeHanteiNyknJissekiRirekiBean1;

        SiwakeHanteiNyknJissekiRirekiBean siwakeHanteiNyknJissekiRirekiBean2 = new SiwakeHanteiNyknJissekiRirekiBean();
        siwakeHanteiNyknJissekiRirekiBean2.setRsgaku(BizCurrency.valueOf(60000));
        siwakeHanteiNyknJissekiRirekiBean2.setHrkp(BizCurrency.valueOf(20000));
        siwakeHanteiNyknJissekiRirekiBean2.setJyutoukaisuum(2);
        siwakeHanteiNyknJissekiRirekiBean2.setJyutoustartym(BizDateYM.valueOf(201805));
        siwakeHanteiNyknJissekiRirekiBean2.setJyutouendym(BizDateYM.valueOf(201801));
        siwakeHanteiNyknJissekiRirekiBeans[1] = siwakeHanteiNyknJissekiRirekiBean2;

        SiwakeHanteiNyknJissekiRirekiBean siwakeHanteiNyknJissekiRirekiBean3 = new SiwakeHanteiNyknJissekiRirekiBean();
        siwakeHanteiNyknJissekiRirekiBean3.setRsgaku(BizCurrency.valueOf(70000));
        siwakeHanteiNyknJissekiRirekiBean3.setHrkp(BizCurrency.valueOf(10000));
        siwakeHanteiNyknJissekiRirekiBean3.setJyutoukaisuum(1);
        siwakeHanteiNyknJissekiRirekiBean3.setJyutoustartym(BizDateYM.valueOf(201804));
        siwakeHanteiNyknJissekiRirekiBean3.setJyutouendym(BizDateYM.valueOf(201801));
        siwakeHanteiNyknJissekiRirekiBeans[2] = siwakeHanteiNyknJissekiRirekiBean3;

        commonSiwakeUtil.execKihrkmPKanjokamokuHantei(denYmd, kykYmd, zennouNyuukinkgk, ryosyuYmd, jkipjytYm,
            kihrkmp, siwakeHanteiNyknJissekiRirekiBeans, C_Hrkkaisuu.TUKI, C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);

        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendoSyokaip(), BizCurrency.valueOf(20000), "対象金額（初年度初回保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendo2kaimeikoup(), BizCurrency.valueOf(110000), "対象金額（初年度２回目以降）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkJinendoikoup(), BizCurrency.valueOf(50000), "対象金額（次年度以降保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSonotahenreikin(), BizCurrency.valueOf(0), "対象金額（その他返戻金）");

    }

    @Test
    @TestOrder(90)
    public void testExecKihrkmPKanjokamokuHantei_A9() {

        BizDate denYmd = BizDate.valueOf(20180101);
        BizDate kykYmd = BizDate.valueOf(20180301);
        BizCurrency zennouNyuukinkgk = BizCurrency.valueOf(10000);
        BizDate ryosyuYmd = null;
        BizDateYM jkipjytYm = BizDateYM.valueOf(201902);
        BizCurrency kihrkmp = BizCurrency.valueOf(3000);
        SiwakeHanteiNyknJissekiRirekiBean[] siwakeHanteiNyknJissekiRirekiBeans = new SiwakeHanteiNyknJissekiRirekiBean[0];

        commonSiwakeUtil.execKihrkmPKanjokamokuHantei(denYmd, kykYmd, zennouNyuukinkgk, ryosyuYmd, jkipjytYm,
            kihrkmp, siwakeHanteiNyknJissekiRirekiBeans, C_Hrkkaisuu.TUKI, C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);

        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendoSyokaip(), BizCurrency.valueOf(0), "対象金額（初年度初回保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendo2kaimeikoup(), BizCurrency.valueOf(0), "対象金額（初年度２回目以降）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkJinendoikoup(), BizCurrency.valueOf(0), "対象金額（次年度以降保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSonotahenreikin(), BizCurrency.valueOf(0), "対象金額（その他返戻金）");

    }

    @Test
    @TestOrder(100)
    public void testExecKihrkmPKanjokamokuHantei_A10() {

        BizDate denYmd = BizDate.valueOf(20180501);
        BizDate kykYmd = BizDate.valueOf(20180301);
        BizCurrency zennouNyuukinkgk = BizCurrency.valueOf(10000);
        BizDate ryosyuYmd = null;
        BizDateYM jkipjytYm = BizDateYM.valueOf(201903);
        BizCurrency kihrkmp = BizCurrency.valueOf(3000);
        SiwakeHanteiNyknJissekiRirekiBean[] siwakeHanteiNyknJissekiRirekiBeans = new SiwakeHanteiNyknJissekiRirekiBean[1];
        SiwakeHanteiNyknJissekiRirekiBean siwakeHanteiNyknJissekiRirekiBean1 = new SiwakeHanteiNyknJissekiRirekiBean();
        siwakeHanteiNyknJissekiRirekiBean1.setRsgaku(BizCurrency.valueOf(50000));
        siwakeHanteiNyknJissekiRirekiBean1.setHrkp(BizCurrency.valueOf(30000));
        siwakeHanteiNyknJissekiRirekiBean1.setJyutoukaisuum(3);
        siwakeHanteiNyknJissekiRirekiBean1.setJyutoustartym(BizDateYM.valueOf(201905));
        siwakeHanteiNyknJissekiRirekiBean1.setJyutouendym(BizDateYM.valueOf(201803));
        siwakeHanteiNyknJissekiRirekiBeans[0] = siwakeHanteiNyknJissekiRirekiBean1;

        commonSiwakeUtil.execKihrkmPKanjokamokuHantei(denYmd, kykYmd, zennouNyuukinkgk, ryosyuYmd, jkipjytYm,
            kihrkmp, siwakeHanteiNyknJissekiRirekiBeans, C_Hrkkaisuu.TUKI, C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);

        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendoSyokaip(), BizCurrency.valueOf(0), "対象金額（初年度初回保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendo2kaimeikoup(), BizCurrency.valueOf(0), "対象金額（初年度２回目以降）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkJinendoikoup(), BizCurrency.valueOf(0), "対象金額（次年度以降保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSonotahenreikin(), BizCurrency.valueOf(50000), "対象金額（その他返戻金）");

    }

    @Test
    @TestOrder(110)
    public void testExecKihrkmPKanjokamokuHantei_A11() {

        BizDate denYmd = BizDate.valueOf(20180501);
        BizDate kykYmd = BizDate.valueOf(20180301);
        BizCurrency zennouNyuukinkgk = BizCurrency.valueOf(10000);
        BizDate ryosyuYmd = null;
        BizDateYM jkipjytYm = BizDateYM.valueOf(201902);
        BizCurrency kihrkmp = BizCurrency.valueOf(3000);
        SiwakeHanteiNyknJissekiRirekiBean[] siwakeHanteiNyknJissekiRirekiBeans = new SiwakeHanteiNyknJissekiRirekiBean[3];
        SiwakeHanteiNyknJissekiRirekiBean siwakeHanteiNyknJissekiRirekiBean1 = new SiwakeHanteiNyknJissekiRirekiBean();
        siwakeHanteiNyknJissekiRirekiBean1.setRsgaku(BizCurrency.valueOf(50000));
        siwakeHanteiNyknJissekiRirekiBean1.setHrkp(BizCurrency.valueOf(30000));
        siwakeHanteiNyknJissekiRirekiBean1.setJyutoukaisuum(3);
        siwakeHanteiNyknJissekiRirekiBean1.setJyutoustartym(BizDateYM.valueOf(201712));
        siwakeHanteiNyknJissekiRirekiBean1.setJyutouendym(BizDateYM.valueOf(201804));
        siwakeHanteiNyknJissekiRirekiBeans[0] = siwakeHanteiNyknJissekiRirekiBean1;

        SiwakeHanteiNyknJissekiRirekiBean siwakeHanteiNyknJissekiRirekiBean2 = new SiwakeHanteiNyknJissekiRirekiBean();
        siwakeHanteiNyknJissekiRirekiBean2.setRsgaku(BizCurrency.valueOf(60000));
        siwakeHanteiNyknJissekiRirekiBean2.setHrkp(BizCurrency.valueOf(20000));
        siwakeHanteiNyknJissekiRirekiBean2.setJyutoukaisuum(4);
        siwakeHanteiNyknJissekiRirekiBean2.setJyutoustartym(BizDateYM.valueOf(201803));
        siwakeHanteiNyknJissekiRirekiBean2.setJyutouendym(BizDateYM.valueOf(201804));
        siwakeHanteiNyknJissekiRirekiBeans[1] = siwakeHanteiNyknJissekiRirekiBean2;

        SiwakeHanteiNyknJissekiRirekiBean siwakeHanteiNyknJissekiRirekiBean3 = new SiwakeHanteiNyknJissekiRirekiBean();
        siwakeHanteiNyknJissekiRirekiBean3.setRsgaku(BizCurrency.valueOf(70000));
        siwakeHanteiNyknJissekiRirekiBean3.setHrkp(BizCurrency.valueOf(10000));
        siwakeHanteiNyknJissekiRirekiBean3.setJyutoukaisuum(6);
        siwakeHanteiNyknJissekiRirekiBean3.setJyutoustartym(BizDateYM.valueOf(201804));
        siwakeHanteiNyknJissekiRirekiBean3.setJyutouendym(BizDateYM.valueOf(201805));
        siwakeHanteiNyknJissekiRirekiBeans[2] = siwakeHanteiNyknJissekiRirekiBean3;

        commonSiwakeUtil.execKihrkmPKanjokamokuHantei(denYmd, kykYmd, zennouNyuukinkgk, ryosyuYmd, jkipjytYm,
            kihrkmp, siwakeHanteiNyknJissekiRirekiBeans, C_Hrkkaisuu.TUKI, C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);

        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendoSyokaip(), BizCurrency.valueOf(0), "対象金額（初年度初回保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendo2kaimeikoup(), BizCurrency.valueOf(110000), "対象金額（初年度２回目以降）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkJinendoikoup(), BizCurrency.valueOf(0), "対象金額（次年度以降保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSonotahenreikin(), BizCurrency.valueOf(69998), "対象金額（その他返戻金）");

    }

    @Test
    @TestOrder(120)
    public void testExecKihrkmPKanjokamokuHantei_A12() {

        BizDate denYmd = BizDate.valueOf(20180101);
        BizDate kykYmd = BizDate.valueOf(20180301);
        BizCurrency zennouNyuukinkgk = BizCurrency.valueOf(10000);
        BizDate ryosyuYmd = null;
        BizDateYM jkipjytYm = BizDateYM.valueOf(201904);
        BizCurrency kihrkmp = BizCurrency.valueOf(3000);
        SiwakeHanteiNyknJissekiRirekiBean[] siwakeHanteiNyknJissekiRirekiBeans = new SiwakeHanteiNyknJissekiRirekiBean[0];

        commonSiwakeUtil.execKihrkmPKanjokamokuHantei(denYmd, kykYmd, zennouNyuukinkgk, ryosyuYmd, jkipjytYm,
            kihrkmp, siwakeHanteiNyknJissekiRirekiBeans, C_Hrkkaisuu.TUKI, C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);

        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendoSyokaip(), BizCurrency.valueOf(0), "対象金額（初年度初回保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendo2kaimeikoup(), BizCurrency.valueOf(0), "対象金額（初年度２回目以降）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkJinendoikoup(), BizCurrency.valueOf(0), "対象金額（次年度以降保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSonotahenreikin(), BizCurrency.valueOf(0), "対象金額（その他返戻金）");

    }

    @Test
    @TestOrder(130)
    public void testExecKihrkmPKanjokamokuHantei_A13() {

        BizDate denYmd = BizDate.valueOf(20180501);
        BizDate kykYmd = BizDate.valueOf(20180301);
        BizCurrency zennouNyuukinkgk = BizCurrency.valueOf(10000);
        BizDate ryosyuYmd = null;
        BizDateYM jkipjytYm = BizDateYM.valueOf(201904);
        BizCurrency kihrkmp = BizCurrency.valueOf(3000);
        SiwakeHanteiNyknJissekiRirekiBean[] siwakeHanteiNyknJissekiRirekiBeans = new SiwakeHanteiNyknJissekiRirekiBean[1];
        SiwakeHanteiNyknJissekiRirekiBean siwakeHanteiNyknJissekiRirekiBean1 = new SiwakeHanteiNyknJissekiRirekiBean();
        siwakeHanteiNyknJissekiRirekiBean1.setRsgaku(BizCurrency.valueOf(50000));
        siwakeHanteiNyknJissekiRirekiBean1.setHrkp(BizCurrency.valueOf(30000));
        siwakeHanteiNyknJissekiRirekiBean1.setJyutoukaisuum(2);
        siwakeHanteiNyknJissekiRirekiBean1.setJyutoustartym(BizDateYM.valueOf(201803));
        siwakeHanteiNyknJissekiRirekiBean1.setJyutouendym(BizDateYM.valueOf(201803));
        siwakeHanteiNyknJissekiRirekiBeans[0] = siwakeHanteiNyknJissekiRirekiBean1;

        commonSiwakeUtil.execKihrkmPKanjokamokuHantei(denYmd, kykYmd, zennouNyuukinkgk, ryosyuYmd, jkipjytYm,
            kihrkmp, siwakeHanteiNyknJissekiRirekiBeans, C_Hrkkaisuu.TUKI, C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);

        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendoSyokaip(), BizCurrency.valueOf(0), "対象金額（初年度初回保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendo2kaimeikoup(), BizCurrency.valueOf(0), "対象金額（初年度２回目以降）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkJinendoikoup(), BizCurrency.valueOf(0), "対象金額（次年度以降保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSonotahenreikin(), BizCurrency.valueOf(50000), "対象金額（その他返戻金）");

    }

    @Test
    @TestOrder(140)
    public void testExecKihrkmPKanjokamokuHantei_A14() {

        BizDate denYmd = BizDate.valueOf(20180501);
        BizDate kykYmd = BizDate.valueOf(20180301);
        BizCurrency zennouNyuukinkgk = BizCurrency.valueOf(10000);
        BizDate ryosyuYmd = null;
        BizDateYM jkipjytYm = BizDateYM.valueOf(201904);
        BizCurrency kihrkmp = BizCurrency.valueOf(3000);
        SiwakeHanteiNyknJissekiRirekiBean[] siwakeHanteiNyknJissekiRirekiBeans = new SiwakeHanteiNyknJissekiRirekiBean[6];
        SiwakeHanteiNyknJissekiRirekiBean siwakeHanteiNyknJissekiRirekiBean1 = new SiwakeHanteiNyknJissekiRirekiBean();
        siwakeHanteiNyknJissekiRirekiBean1.setRsgaku(BizCurrency.valueOf(50000));
        siwakeHanteiNyknJissekiRirekiBean1.setHrkp(BizCurrency.valueOf(30000));
        siwakeHanteiNyknJissekiRirekiBean1.setJyutoukaisuum(2);
        siwakeHanteiNyknJissekiRirekiBean1.setJyutoustartym(BizDateYM.valueOf(201803));
        siwakeHanteiNyknJissekiRirekiBean1.setJyutouendym(BizDateYM.valueOf(201804));
        siwakeHanteiNyknJissekiRirekiBeans[0] = siwakeHanteiNyknJissekiRirekiBean1;

        SiwakeHanteiNyknJissekiRirekiBean siwakeHanteiNyknJissekiRirekiBean2 = new SiwakeHanteiNyknJissekiRirekiBean();
        siwakeHanteiNyknJissekiRirekiBean2.setRsgaku(BizCurrency.valueOf(60000));
        siwakeHanteiNyknJissekiRirekiBean2.setHrkp(BizCurrency.valueOf(20000));
        siwakeHanteiNyknJissekiRirekiBean2.setJyutoukaisuum(4);
        siwakeHanteiNyknJissekiRirekiBean2.setJyutoustartym(BizDateYM.valueOf(201805));
        siwakeHanteiNyknJissekiRirekiBean2.setJyutouendym(BizDateYM.valueOf(201804));
        siwakeHanteiNyknJissekiRirekiBeans[1] = siwakeHanteiNyknJissekiRirekiBean2;

        SiwakeHanteiNyknJissekiRirekiBean siwakeHanteiNyknJissekiRirekiBean3 = new SiwakeHanteiNyknJissekiRirekiBean();
        siwakeHanteiNyknJissekiRirekiBean3.setRsgaku(BizCurrency.valueOf(70000));
        siwakeHanteiNyknJissekiRirekiBean3.setHrkp(BizCurrency.valueOf(10000));
        siwakeHanteiNyknJissekiRirekiBean3.setJyutoukaisuum(3);
        siwakeHanteiNyknJissekiRirekiBean3.setJyutoustartym(BizDateYM.valueOf(201804));
        siwakeHanteiNyknJissekiRirekiBean3.setJyutouendym(BizDateYM.valueOf(201805));
        siwakeHanteiNyknJissekiRirekiBeans[2] = siwakeHanteiNyknJissekiRirekiBean3;

        SiwakeHanteiNyknJissekiRirekiBean siwakeHanteiNyknJissekiRirekiBean4 = new SiwakeHanteiNyknJissekiRirekiBean();
        siwakeHanteiNyknJissekiRirekiBean4.setRsgaku(BizCurrency.valueOf(70001));
        siwakeHanteiNyknJissekiRirekiBean4.setHrkp(BizCurrency.valueOf(10001));
        siwakeHanteiNyknJissekiRirekiBean4.setJyutoukaisuum(3);
        siwakeHanteiNyknJissekiRirekiBean4.setJyutoustartym(BizDateYM.valueOf(201902));
        siwakeHanteiNyknJissekiRirekiBean4.setJyutouendym(BizDateYM.valueOf(201805));
        siwakeHanteiNyknJissekiRirekiBeans[3] = siwakeHanteiNyknJissekiRirekiBean4;

        SiwakeHanteiNyknJissekiRirekiBean siwakeHanteiNyknJissekiRirekiBean5 = new SiwakeHanteiNyknJissekiRirekiBean();
        siwakeHanteiNyknJissekiRirekiBean5.setRsgaku(BizCurrency.valueOf(70002));
        siwakeHanteiNyknJissekiRirekiBean5.setHrkp(BizCurrency.valueOf(10002));
        siwakeHanteiNyknJissekiRirekiBean5.setJyutoukaisuum(1);
        siwakeHanteiNyknJissekiRirekiBean5.setJyutoustartym(BizDateYM.valueOf(201903));
        siwakeHanteiNyknJissekiRirekiBean5.setJyutouendym(BizDateYM.valueOf(201805));
        siwakeHanteiNyknJissekiRirekiBeans[4] = siwakeHanteiNyknJissekiRirekiBean5;

        SiwakeHanteiNyknJissekiRirekiBean siwakeHanteiNyknJissekiRirekiBean6 = new SiwakeHanteiNyknJissekiRirekiBean();
        siwakeHanteiNyknJissekiRirekiBean6.setRsgaku(BizCurrency.valueOf(70002));
        siwakeHanteiNyknJissekiRirekiBean6.setHrkp(BizCurrency.valueOf(10002));
        siwakeHanteiNyknJissekiRirekiBean6.setJyutoukaisuum(1);
        siwakeHanteiNyknJissekiRirekiBean6.setJyutoustartym(BizDateYM.valueOf(201904));
        siwakeHanteiNyknJissekiRirekiBean6.setJyutouendym(BizDateYM.valueOf(201805));
        siwakeHanteiNyknJissekiRirekiBeans[5] = siwakeHanteiNyknJissekiRirekiBean6;

        commonSiwakeUtil.execKihrkmPKanjokamokuHantei(denYmd, kykYmd, zennouNyuukinkgk, ryosyuYmd, jkipjytYm,
            kihrkmp, siwakeHanteiNyknJissekiRirekiBeans, C_Hrkkaisuu.TUKI, C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);

        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendoSyokaip(), BizCurrency.valueOf(0), "対象金額（初年度初回保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendo2kaimeikoup(), BizCurrency.valueOf(220001), "対象金額（初年度２回目以降）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkJinendoikoup(), BizCurrency.valueOf(140004), "対象金額（次年度以降保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSonotahenreikin(), BizCurrency.valueOf(30000), "対象金額（その他返戻金）");

    }

    @Test
    @TestOrder(150)
    public void testExecKihrkmPKanjokamokuHantei_A15() {

        BizDate denYmd = BizDate.valueOf(20180101);
        BizDate kykYmd = BizDate.valueOf(20170401);
        BizCurrency zennouNyuukinkgk = BizCurrency.valueOf(10000);
        BizDate ryosyuYmd = null;
        BizDateYM jkipjytYm = BizDateYM.valueOf(201904);
        BizCurrency kihrkmp = BizCurrency.valueOf(3000);
        SiwakeHanteiNyknJissekiRirekiBean[] siwakeHanteiNyknJissekiRirekiBeans = new SiwakeHanteiNyknJissekiRirekiBean[0];

        commonSiwakeUtil.execKihrkmPKanjokamokuHantei(denYmd, kykYmd, zennouNyuukinkgk, ryosyuYmd, jkipjytYm,
            kihrkmp, siwakeHanteiNyknJissekiRirekiBeans, C_Hrkkaisuu.TUKI, C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);

        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendoSyokaip(), BizCurrency.valueOf(0), "対象金額（初年度初回保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendo2kaimeikoup(), BizCurrency.valueOf(0), "対象金額（初年度２回目以降）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkJinendoikoup(), BizCurrency.valueOf(0), "対象金額（次年度以降保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSonotahenreikin(), BizCurrency.valueOf(0), "対象金額（その他返戻金）");

    }

    @Test
    @TestOrder(160)
    public void testExecKihrkmPKanjokamokuHantei_A16() {

        BizDate denYmd = BizDate.valueOf(20180501);
        BizDate kykYmd = BizDate.valueOf(20170301);
        BizCurrency zennouNyuukinkgk = BizCurrency.valueOf(10000);
        BizDate ryosyuYmd = null;
        BizDateYM jkipjytYm = BizDateYM.valueOf(201904);
        BizCurrency kihrkmp = BizCurrency.valueOf(3000);
        SiwakeHanteiNyknJissekiRirekiBean[] siwakeHanteiNyknJissekiRirekiBeans = new SiwakeHanteiNyknJissekiRirekiBean[1];
        SiwakeHanteiNyknJissekiRirekiBean siwakeHanteiNyknJissekiRirekiBean1 = new SiwakeHanteiNyknJissekiRirekiBean();
        siwakeHanteiNyknJissekiRirekiBean1.setRsgaku(BizCurrency.valueOf(50000));
        siwakeHanteiNyknJissekiRirekiBean1.setHrkp(BizCurrency.valueOf(30000));
        siwakeHanteiNyknJissekiRirekiBean1.setJyutoukaisuum(2);
        siwakeHanteiNyknJissekiRirekiBean1.setJyutoustartym(BizDateYM.valueOf(201803));
        siwakeHanteiNyknJissekiRirekiBean1.setJyutouendym(BizDateYM.valueOf(201803));
        siwakeHanteiNyknJissekiRirekiBeans[0] = siwakeHanteiNyknJissekiRirekiBean1;

        commonSiwakeUtil.execKihrkmPKanjokamokuHantei(denYmd, kykYmd, zennouNyuukinkgk, ryosyuYmd, jkipjytYm,
            kihrkmp, siwakeHanteiNyknJissekiRirekiBeans, C_Hrkkaisuu.TUKI, C_TkiktbrisyuruiKbn.TEIKI_12MONTHS);

        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendoSyokaip(), BizCurrency.valueOf(0), "対象金額（初年度初回保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendo2kaimeikoup(), BizCurrency.valueOf(0), "対象金額（初年度２回目以降）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkJinendoikoup(), BizCurrency.valueOf(0), "対象金額（次年度以降保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSonotahenreikin(), BizCurrency.valueOf(50000), "対象金額（その他返戻金）");

    }

    @Test
    @TestOrder(170)
    public void testExecKihrkmPKanjokamokuHantei_A17() {

        BizDate denYmd = BizDate.valueOf(20180501);
        BizDate kykYmd = BizDate.valueOf(20170401);
        BizCurrency zennouNyuukinkgk = BizCurrency.valueOf(10000);
        BizDate ryosyuYmd = null;
        BizDateYM jkipjytYm = BizDateYM.valueOf(201904);
        BizCurrency kihrkmp = BizCurrency.valueOf(3000);
        SiwakeHanteiNyknJissekiRirekiBean[] siwakeHanteiNyknJissekiRirekiBeans = new SiwakeHanteiNyknJissekiRirekiBean[3];
        SiwakeHanteiNyknJissekiRirekiBean siwakeHanteiNyknJissekiRirekiBean1 = new SiwakeHanteiNyknJissekiRirekiBean();
        siwakeHanteiNyknJissekiRirekiBean1.setRsgaku(BizCurrency.valueOf(50000));
        siwakeHanteiNyknJissekiRirekiBean1.setHrkp(BizCurrency.valueOf(30000));
        siwakeHanteiNyknJissekiRirekiBean1.setJyutoukaisuum(1);
        siwakeHanteiNyknJissekiRirekiBean1.setJyutoustartym(BizDateYM.valueOf(201805));
        siwakeHanteiNyknJissekiRirekiBean1.setJyutouendym(BizDateYM.valueOf(201804));
        siwakeHanteiNyknJissekiRirekiBeans[0] = siwakeHanteiNyknJissekiRirekiBean1;

        SiwakeHanteiNyknJissekiRirekiBean siwakeHanteiNyknJissekiRirekiBean2 = new SiwakeHanteiNyknJissekiRirekiBean();
        siwakeHanteiNyknJissekiRirekiBean2.setRsgaku(BizCurrency.valueOf(60000));
        siwakeHanteiNyknJissekiRirekiBean2.setHrkp(BizCurrency.valueOf(20000));
        siwakeHanteiNyknJissekiRirekiBean2.setJyutoukaisuum(1);
        siwakeHanteiNyknJissekiRirekiBean2.setJyutoustartym(BizDateYM.valueOf(201804));
        siwakeHanteiNyknJissekiRirekiBean2.setJyutouendym(BizDateYM.valueOf(201805));
        siwakeHanteiNyknJissekiRirekiBeans[1] = siwakeHanteiNyknJissekiRirekiBean2;

        SiwakeHanteiNyknJissekiRirekiBean siwakeHanteiNyknJissekiRirekiBean3 = new SiwakeHanteiNyknJissekiRirekiBean();
        siwakeHanteiNyknJissekiRirekiBean3.setRsgaku(BizCurrency.valueOf(70000));
        siwakeHanteiNyknJissekiRirekiBean3.setHrkp(BizCurrency.valueOf(10000));
        siwakeHanteiNyknJissekiRirekiBean3.setJyutoukaisuum(4);
        siwakeHanteiNyknJissekiRirekiBean3.setJyutoustartym(BizDateYM.valueOf(201803));
        siwakeHanteiNyknJissekiRirekiBean3.setJyutouendym(BizDateYM.valueOf(201806));
        siwakeHanteiNyknJissekiRirekiBeans[2] = siwakeHanteiNyknJissekiRirekiBean3;

        commonSiwakeUtil.execKihrkmPKanjokamokuHantei(denYmd, kykYmd, zennouNyuukinkgk, ryosyuYmd, jkipjytYm,
            kihrkmp, siwakeHanteiNyknJissekiRirekiBeans, C_Hrkkaisuu.NEN, C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);

        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendoSyokaip(), BizCurrency.valueOf(0), "対象金額（初年度初回保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendo2kaimeikoup(), BizCurrency.valueOf(0), "対象金額（初年度２回目以降）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkJinendoikoup(), BizCurrency.valueOf(110000), "対象金額（次年度以降保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSonotahenreikin(), BizCurrency.valueOf(70000), "対象金額（その他返戻金）");

    }

    @Test
    @TestOrder(180)
    public void testExecKihrkmPKanjokamokuHantei_A18() {

        MockObjectManager.initialize();
        KeisanZennouSeisanGk2MockForHozen.SYORIPTN = KeisanZennouSeisanGk2MockForHozen.TESTPATTERN1;
        BizDate denYmd = BizDate.valueOf(20180101);
        BizDate kykYmd = BizDate.valueOf(20180102);
        BizCurrency zennouNyuukinkgk = BizCurrency.valueOf(100000);
        BizDate ryosyuYmd = BizDate.valueOf(20180103);
        BizDateYM jkipjytYm = BizDateYM.valueOf(201702);
        BizCurrency kihrkmp = BizCurrency.valueOf(1000);
        SiwakeHanteiNyknJissekiRirekiBean[] siwakeHanteiNyknJissekiRirekiBeans = new SiwakeHanteiNyknJissekiRirekiBean[1];
        SiwakeHanteiNyknJissekiRirekiBean siwakeHanteiNyknJissekiRirekiBean1 = new SiwakeHanteiNyknJissekiRirekiBean();
        siwakeHanteiNyknJissekiRirekiBean1.setRsgaku(BizCurrency.valueOf(30000));
        siwakeHanteiNyknJissekiRirekiBean1.setHrkp(BizCurrency.valueOf(20000));
        siwakeHanteiNyknJissekiRirekiBean1.setJyutoukaisuum(1);
        siwakeHanteiNyknJissekiRirekiBean1.setJyutoustartym(BizDateYM.valueOf(201701));
        siwakeHanteiNyknJissekiRirekiBean1.setJyutouendym(BizDateYM.valueOf(201801));
        siwakeHanteiNyknJissekiRirekiBeans[0] = siwakeHanteiNyknJissekiRirekiBean1;

        commonSiwakeUtil.execKihrkmPKanjokamokuHantei(denYmd, kykYmd, zennouNyuukinkgk, ryosyuYmd, jkipjytYm,
            kihrkmp, siwakeHanteiNyknJissekiRirekiBeans, C_Hrkkaisuu.NEN, C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);

        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendoSyokaip(), BizCurrency.valueOf(0), "対象金額（初年度初回保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendo2kaimeikoup(), BizCurrency.valueOf(0), "対象金額（初年度２回目以降）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkJinendoikoup(), BizCurrency.valueOf(0), "対象金額（次年度以降保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSonotahenreikin(), BizCurrency.valueOf(130000),
            "対象金額（その他返戻金）");

    }

    @Test
    @TestOrder(190)
    public void testExecKihrkmPKanjokamokuHantei_A19() {

        MockObjectManager.initialize();
        KeisanZennouSeisanGk2MockForHozen.SYORIPTN = KeisanZennouSeisanGk2MockForHozen.TESTPATTERN2;
        BizDate denYmd = BizDate.valueOf(20180101);
        BizDate kykYmd = BizDate.valueOf(20180102);
        BizCurrency zennouNyuukinkgk = BizCurrency.valueOf(100000);
        BizDate ryosyuYmd = BizDate.valueOf(20180103);
        BizDateYM jkipjytYm = BizDateYM.valueOf(201702);
        BizCurrency kihrkmp = BizCurrency.valueOf(1000);
        SiwakeHanteiNyknJissekiRirekiBean[] siwakeHanteiNyknJissekiRirekiBeans = new SiwakeHanteiNyknJissekiRirekiBean[1];
        SiwakeHanteiNyknJissekiRirekiBean siwakeHanteiNyknJissekiRirekiBean1 = new SiwakeHanteiNyknJissekiRirekiBean();
        siwakeHanteiNyknJissekiRirekiBean1.setRsgaku(BizCurrency.valueOf(30000));
        siwakeHanteiNyknJissekiRirekiBean1.setHrkp(BizCurrency.valueOf(20000));
        siwakeHanteiNyknJissekiRirekiBean1.setJyutoukaisuum(1);
        siwakeHanteiNyknJissekiRirekiBean1.setJyutoustartym(BizDateYM.valueOf(201701));
        siwakeHanteiNyknJissekiRirekiBean1.setJyutouendym(BizDateYM.valueOf(201801));
        siwakeHanteiNyknJissekiRirekiBeans[0] = siwakeHanteiNyknJissekiRirekiBean1;

        commonSiwakeUtil.execKihrkmPKanjokamokuHantei(denYmd, kykYmd, zennouNyuukinkgk, ryosyuYmd, jkipjytYm,
            kihrkmp, siwakeHanteiNyknJissekiRirekiBeans, C_Hrkkaisuu.NEN, C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);

        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendoSyokaip(), BizCurrency.valueOf(30000), "対象金額（初年度初回保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendo2kaimeikoup(), BizCurrency.valueOf(0), "対象金額（初年度２回目以降）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkJinendoikoup(), BizCurrency.valueOf(100000), "対象金額（次年度以降保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSonotahenreikin(), BizCurrency.valueOf(0),
            "対象金額（その他返戻金）");

    }


    @Test
    @TestOrder(200)
    public void testExecKihrkmPKanjokamokuHantei_A20() {

        BizDate denYmd = BizDate.valueOf(20180501);
        BizDate kykYmd = BizDate.valueOf(20170301);
        BizCurrency zennouNyuukinkgk = BizCurrency.valueOf(10000);
        BizDate ryosyuYmd = null;
        BizDateYM jkipjytYm = BizDateYM.valueOf(201904);
        BizCurrency kihrkmp = BizCurrency.valueOf(3000);
        SiwakeHanteiNyknJissekiRirekiBean[] siwakeHanteiNyknJissekiRirekiBeans = new SiwakeHanteiNyknJissekiRirekiBean[1];
        SiwakeHanteiNyknJissekiRirekiBean siwakeHanteiNyknJissekiRirekiBean1 = new SiwakeHanteiNyknJissekiRirekiBean();
        siwakeHanteiNyknJissekiRirekiBean1.setRsgaku(BizCurrency.valueOf(50000));
        siwakeHanteiNyknJissekiRirekiBean1.setHrkp(BizCurrency.valueOf(30000));
        siwakeHanteiNyknJissekiRirekiBean1.setJyutoukaisuum(2);
        siwakeHanteiNyknJissekiRirekiBean1.setJyutoustartym(BizDateYM.valueOf(201803));
        siwakeHanteiNyknJissekiRirekiBean1.setJyutouendym(BizDateYM.valueOf(201805));
        siwakeHanteiNyknJissekiRirekiBeans[0] = siwakeHanteiNyknJissekiRirekiBean1;

        commonSiwakeUtil.execKihrkmPKanjokamokuHantei(denYmd, kykYmd, zennouNyuukinkgk, ryosyuYmd, jkipjytYm,
            kihrkmp, siwakeHanteiNyknJissekiRirekiBeans, C_Hrkkaisuu.TUKI, C_TkiktbrisyuruiKbn.NONE);

        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendoSyokaip(), BizCurrency.valueOf(0), "対象金額（初年度初回保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendo2kaimeikoup(), BizCurrency.valueOf(0), "対象金額（初年度２回目以降）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkJinendoikoup(), BizCurrency.valueOf(0), "対象金額（次年度以降保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSonotahenreikin(), BizCurrency.valueOf(50000), "対象金額（その他返戻金）");

    }

    @Test
    @TestOrder(210)
    public void testExecKihrkmPKanjokamokuHantei_A21() {

        BizDate denYmd = BizDate.valueOf(20180501);
        BizDate kykYmd = BizDate.valueOf(20200401);
        BizCurrency zennouNyuukinkgk = BizCurrency.valueOf(10000);
        BizDate ryosyuYmd = null;
        BizDateYM jkipjytYm = BizDateYM.valueOf(201904);
        BizCurrency kihrkmp = BizCurrency.valueOf(3000);
        SiwakeHanteiNyknJissekiRirekiBean[] siwakeHanteiNyknJissekiRirekiBeans = new SiwakeHanteiNyknJissekiRirekiBean[1];
        SiwakeHanteiNyknJissekiRirekiBean siwakeHanteiNyknJissekiRirekiBean1 = new SiwakeHanteiNyknJissekiRirekiBean();
        siwakeHanteiNyknJissekiRirekiBean1.setRsgaku(BizCurrency.valueOf(50000));
        siwakeHanteiNyknJissekiRirekiBean1.setHrkp(BizCurrency.valueOf(30000));
        siwakeHanteiNyknJissekiRirekiBean1.setJyutoukaisuum(2);
        siwakeHanteiNyknJissekiRirekiBean1.setJyutoustartym(BizDateYM.valueOf(202003));
        siwakeHanteiNyknJissekiRirekiBean1.setJyutouendym(BizDateYM.valueOf(201805));
        siwakeHanteiNyknJissekiRirekiBeans[0] = siwakeHanteiNyknJissekiRirekiBean1;

        commonSiwakeUtil.execKihrkmPKanjokamokuHantei(denYmd, kykYmd, zennouNyuukinkgk, ryosyuYmd, jkipjytYm,
            kihrkmp, siwakeHanteiNyknJissekiRirekiBeans, C_Hrkkaisuu.TUKI, C_TkiktbrisyuruiKbn.NONE);

        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendoSyokaip(), BizCurrency.valueOf(50000), "対象金額（初年度初回保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendo2kaimeikoup(), BizCurrency.valueOf(0), "対象金額（初年度２回目以降）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkJinendoikoup(), BizCurrency.valueOf(0), "対象金額（次年度以降保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSonotahenreikin(), BizCurrency.valueOf(0), "対象金額（その他返戻金）");

    }

    @Test
    @TestOrder(220)
    public void testExecKihrkmPKanjokamokuHantei_A22() {

        BizDate denYmd = BizDate.valueOf(20180501);
        BizDate kykYmd = BizDate.valueOf(20200201);
        BizCurrency zennouNyuukinkgk = BizCurrency.valueOf(10000);
        BizDate ryosyuYmd = null;
        BizDateYM jkipjytYm = BizDateYM.valueOf(201904);
        BizCurrency kihrkmp = BizCurrency.valueOf(3000);
        SiwakeHanteiNyknJissekiRirekiBean[] siwakeHanteiNyknJissekiRirekiBeans = new SiwakeHanteiNyknJissekiRirekiBean[1];
        SiwakeHanteiNyknJissekiRirekiBean siwakeHanteiNyknJissekiRirekiBean1 = new SiwakeHanteiNyknJissekiRirekiBean();
        siwakeHanteiNyknJissekiRirekiBean1.setRsgaku(BizCurrency.valueOf(50000));
        siwakeHanteiNyknJissekiRirekiBean1.setHrkp(BizCurrency.valueOf(30000));
        siwakeHanteiNyknJissekiRirekiBean1.setJyutoukaisuum(2);
        siwakeHanteiNyknJissekiRirekiBean1.setJyutoustartym(BizDateYM.valueOf(202003));
        siwakeHanteiNyknJissekiRirekiBean1.setJyutouendym(BizDateYM.valueOf(201805));
        siwakeHanteiNyknJissekiRirekiBeans[0] = siwakeHanteiNyknJissekiRirekiBean1;

        commonSiwakeUtil.execKihrkmPKanjokamokuHantei(denYmd, kykYmd, zennouNyuukinkgk, ryosyuYmd, jkipjytYm,
            kihrkmp, siwakeHanteiNyknJissekiRirekiBeans, C_Hrkkaisuu.TUKI, C_TkiktbrisyuruiKbn.NONE);

        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendoSyokaip(), BizCurrency.valueOf(0), "対象金額（初年度初回保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendo2kaimeikoup(), BizCurrency.valueOf(50000), "対象金額（初年度２回目以降）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkJinendoikoup(), BizCurrency.valueOf(0), "対象金額（次年度以降保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSonotahenreikin(), BizCurrency.valueOf(0), "対象金額（その他返戻金）");

    }

    @Test
    @TestOrder(230)
    public void testExecKihrkmPKanjokamokuHantei_A23() {

        BizDate denYmd = BizDate.valueOf(20180501);
        BizDate kykYmd = BizDate.valueOf(20200201);
        BizCurrency zennouNyuukinkgk = BizCurrency.valueOf(10000);
        BizDate ryosyuYmd = null;
        BizDateYM jkipjytYm = BizDateYM.valueOf(201904);
        BizCurrency kihrkmp = BizCurrency.valueOf(3000);
        SiwakeHanteiNyknJissekiRirekiBean[] siwakeHanteiNyknJissekiRirekiBeans = new SiwakeHanteiNyknJissekiRirekiBean[1];
        SiwakeHanteiNyknJissekiRirekiBean siwakeHanteiNyknJissekiRirekiBean1 = new SiwakeHanteiNyknJissekiRirekiBean();
        siwakeHanteiNyknJissekiRirekiBean1.setRsgaku(BizCurrency.valueOf(50000));
        siwakeHanteiNyknJissekiRirekiBean1.setHrkp(BizCurrency.valueOf(30000));
        siwakeHanteiNyknJissekiRirekiBean1.setJyutoukaisuum(2);
        siwakeHanteiNyknJissekiRirekiBean1.setJyutoustartym(BizDateYM.valueOf(202003));
        siwakeHanteiNyknJissekiRirekiBean1.setJyutouendym(BizDateYM.valueOf(201805));
        siwakeHanteiNyknJissekiRirekiBeans[0] = siwakeHanteiNyknJissekiRirekiBean1;

        commonSiwakeUtil.execKihrkmPKanjokamokuHantei(denYmd, kykYmd, zennouNyuukinkgk, ryosyuYmd, jkipjytYm,
            kihrkmp, siwakeHanteiNyknJissekiRirekiBeans, C_Hrkkaisuu.HALFY, C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);

        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendoSyokaip(), BizCurrency.valueOf(50000), "対象金額（初年度初回保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendo2kaimeikoup(), BizCurrency.valueOf(0), "対象金額（初年度２回目以降）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkJinendoikoup(), BizCurrency.valueOf(0), "対象金額（次年度以降保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSonotahenreikin(), BizCurrency.valueOf(0), "対象金額（その他返戻金）");

    }

    @Test
    @TestOrder(240)
    public void testExecKihrkmPKanjokamokuHantei_A24() {

        BizDate denYmd = BizDate.valueOf(20180501);
        BizDate kykYmd = BizDate.valueOf(20200201);
        BizCurrency zennouNyuukinkgk = BizCurrency.valueOf(10000);
        BizDate ryosyuYmd = null;
        BizDateYM jkipjytYm = BizDateYM.valueOf(201904);
        BizCurrency kihrkmp = BizCurrency.valueOf(3000);
        SiwakeHanteiNyknJissekiRirekiBean[] siwakeHanteiNyknJissekiRirekiBeans = new SiwakeHanteiNyknJissekiRirekiBean[1];
        SiwakeHanteiNyknJissekiRirekiBean siwakeHanteiNyknJissekiRirekiBean1 = new SiwakeHanteiNyknJissekiRirekiBean();
        siwakeHanteiNyknJissekiRirekiBean1.setRsgaku(BizCurrency.valueOf(50000));
        siwakeHanteiNyknJissekiRirekiBean1.setHrkp(BizCurrency.valueOf(30000));
        siwakeHanteiNyknJissekiRirekiBean1.setJyutoukaisuum(2);
        siwakeHanteiNyknJissekiRirekiBean1.setJyutoustartym(BizDateYM.valueOf(202003));
        siwakeHanteiNyknJissekiRirekiBean1.setJyutouendym(BizDateYM.valueOf(201805));
        siwakeHanteiNyknJissekiRirekiBeans[0] = siwakeHanteiNyknJissekiRirekiBean1;

        commonSiwakeUtil.execKihrkmPKanjokamokuHantei(denYmd, kykYmd, zennouNyuukinkgk, ryosyuYmd, jkipjytYm,
            kihrkmp, siwakeHanteiNyknJissekiRirekiBeans, C_Hrkkaisuu.ITIJI, C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);

        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendoSyokaip(), BizCurrency.valueOf(0), "対象金額（初年度初回保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendo2kaimeikoup(), BizCurrency.valueOf(0), "対象金額（初年度２回目以降）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkJinendoikoup(), BizCurrency.valueOf(0), "対象金額（次年度以降保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSonotahenreikin(), BizCurrency.valueOf(0), "対象金額（その他返戻金）");

    }


    @Test
    @TestOrder(250)
    public void testExecKihrkmPKanjokamokuHantei_A25() {

        MockObjectManager.initialize();
        KeisanZennouSeisanGk2MockForHozen.SYORIPTN = KeisanZennouSeisanGk2MockForHozen.TESTPATTERN2;
        BizDate denYmd = BizDate.valueOf(20180101);
        BizDate kykYmd = BizDate.valueOf(20180102);
        BizCurrency zennouNyuukinkgk = BizCurrency.valueOf(100000);
        BizDate ryosyuYmd = BizDate.valueOf(20180103);
        BizDateYM jkipjytYm = BizDateYM.valueOf(201702);
        BizCurrency kihrkmp = BizCurrency.valueOf(1000);
        SiwakeHanteiNyknJissekiRirekiBean[] siwakeHanteiNyknJissekiRirekiBeans = new SiwakeHanteiNyknJissekiRirekiBean[1];
        SiwakeHanteiNyknJissekiRirekiBean siwakeHanteiNyknJissekiRirekiBean1 = new SiwakeHanteiNyknJissekiRirekiBean();
        siwakeHanteiNyknJissekiRirekiBean1.setRsgaku(BizCurrency.valueOf(30000));
        siwakeHanteiNyknJissekiRirekiBean1.setHrkp(BizCurrency.valueOf(20000));
        siwakeHanteiNyknJissekiRirekiBean1.setJyutoukaisuum(1);
        siwakeHanteiNyknJissekiRirekiBean1.setJyutoustartym(BizDateYM.valueOf(201701));
        siwakeHanteiNyknJissekiRirekiBean1.setJyutouendym(BizDateYM.valueOf(201801));
        siwakeHanteiNyknJissekiRirekiBeans[0] = siwakeHanteiNyknJissekiRirekiBean1;

        commonSiwakeUtil.execKihrkmPKanjokamokuHantei(denYmd, kykYmd, zennouNyuukinkgk, ryosyuYmd, jkipjytYm,
            kihrkmp, siwakeHanteiNyknJissekiRirekiBeans, C_Hrkkaisuu.HALFY, C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);

        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendoSyokaip(), BizCurrency.valueOf(0), "対象金額（初年度初回保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendo2kaimeikoup(), BizCurrency.valueOf(0), "対象金額（初年度２回目以降）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkJinendoikoup(), BizCurrency.valueOf(0), "対象金額（次年度以降保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSonotahenreikin(), BizCurrency.valueOf(0),
            "対象金額（その他返戻金）");

    }

    @Test
    @TestOrder(260)
    public void testExecKihrkmPKanjokamokuHantei_A26() {

        BizDate denYmd = BizDate.valueOf(20180101);
        BizDate kykYmd = BizDate.valueOf(20160301);
        BizCurrency zennouNyuukinkgk = BizCurrency.valueOf(10000);
        BizDate ryosyuYmd = null;
        BizDateYM jkipjytYm = BizDateYM.valueOf(201801);
        BizCurrency kihrkmp = BizCurrency.valueOf(3000);
        SiwakeHanteiNyknJissekiRirekiBean[] siwakeHanteiNyknJissekiRirekiBeans = new SiwakeHanteiNyknJissekiRirekiBean[2];
        SiwakeHanteiNyknJissekiRirekiBean siwakeHanteiNyknJissekiRirekiBean1 = new SiwakeHanteiNyknJissekiRirekiBean();
        siwakeHanteiNyknJissekiRirekiBean1.setRsgaku(BizCurrency.valueOf(50000));
        siwakeHanteiNyknJissekiRirekiBean1.setHrkp(BizCurrency.valueOf(30000));
        siwakeHanteiNyknJissekiRirekiBean1.setJyutoukaisuum(3);
        siwakeHanteiNyknJissekiRirekiBean1.setJyutoustartym(BizDateYM.valueOf(201701));
        siwakeHanteiNyknJissekiRirekiBean1.setJyutouendym(BizDateYM.valueOf(201801));
        siwakeHanteiNyknJissekiRirekiBeans[0] = siwakeHanteiNyknJissekiRirekiBean1;

        SiwakeHanteiNyknJissekiRirekiBean siwakeHanteiNyknJissekiRirekiBean2 = new SiwakeHanteiNyknJissekiRirekiBean();
        siwakeHanteiNyknJissekiRirekiBean2.setRsgaku(BizCurrency.valueOf(60000));
        siwakeHanteiNyknJissekiRirekiBean2.setHrkp(BizCurrency.valueOf(20000));
        siwakeHanteiNyknJissekiRirekiBean2.setJyutoukaisuum(2);
        siwakeHanteiNyknJissekiRirekiBean2.setJyutoustartym(BizDateYM.valueOf(201705));
        siwakeHanteiNyknJissekiRirekiBean2.setJyutouendym(BizDateYM.valueOf(201704));
        siwakeHanteiNyknJissekiRirekiBeans[1] = siwakeHanteiNyknJissekiRirekiBean2;

        commonSiwakeUtil.execKihrkmPKanjokamokuHantei(denYmd, kykYmd, zennouNyuukinkgk, ryosyuYmd, jkipjytYm,
            kihrkmp, siwakeHanteiNyknJissekiRirekiBeans, C_Hrkkaisuu.TUKI, C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);

        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendoSyokaip(), BizCurrency.valueOf(0), "対象金額（初年度初回保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendo2kaimeikoup(), BizCurrency.valueOf(0), "対象金額（初年度２回目以降）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkJinendoikoup(), BizCurrency.valueOf(60000), "対象金額（次年度以降保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSonotahenreikin(), BizCurrency.valueOf(49998), "対象金額（その他返戻金）");

    }

}