package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.hozen.ascommon.KeisanZennouSeisanGk2;
import yuyu.common.hozen.ascommon.KeisanZennouSeisanGk2MockForHozen;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 仕訳共通ユーティリティクラスのメソッド {@link CommonSiwakeUtil#execPKanjokamokuHantei(BizDate,BizDate,BizCurrency,
 * BizDate,BizDateYM,BizCurrency,BizDateYM,MiKeikaPBean[],String,C_SyoriKbn)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class CommonSiwakeUtilTest_execPKanjokamokuHantei {

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
        KeisanZennouSeisanGk2MockForHozen.caller = CommonSiwakeUtilTest_execPKanjokamokuHantei.class;
    }

    @AfterClass
    public static void testClear() {

        MockObjectManager.initialize();
        KeisanZennouSeisanGk2MockForHozen.caller = null;
    }

    @Test
    @TestOrder(10)
    public void testExecPKanjokamokuHantei_A1() {

        MockObjectManager.initialize();
        KeisanZennouSeisanGk2MockForHozen.SYORIPTN = KeisanZennouSeisanGk2MockForHozen.TESTPATTERN1;
        BizDate denYmd = BizDate.valueOf(20180101);
        BizDate kykYmd = BizDate.valueOf(20180102);
        BizCurrency zennouSeisankin = BizCurrency.valueOf(55555);
        BizDate ryosyuYmd = BizDate.valueOf(20181101);
        BizDateYM jkipjytYm = BizDateYM.valueOf(201802);
        BizCurrency mkkp = BizCurrency.valueOf(11111);
        BizDateYM mikeikapjyutouYm = BizDateYM.valueOf(201803);
        MiKeikaPBean[] miKeikaPBeans = new MiKeikaPBean[0];
        String kinouId = IKhozenCommonConstants.JIMUTETUZUKICD_KAIYAKU;
        C_SyoriKbn syoriKbn = C_SyoriKbn.BLNK;

        commonSiwakeUtil.execPKanjokamokuHantei(denYmd, kykYmd, zennouSeisankin, ryosyuYmd, jkipjytYm, mkkp,
            mikeikapjyutouYm, miKeikaPBeans, kinouId, syoriKbn, C_Hrkkaisuu.TUKI, C_TkiktbrisyuruiKbn.TEIKI_12MONTHS);

        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendo2kaimeikoup(), BizCurrency.valueOf(0),
            "対象金額（初年度２回目以降）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkJinendoikoup(), BizCurrency.valueOf(0),
            "対象金額（次年度以降保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSonotahenreikin(), BizCurrency.valueOf(66666),
            "対象金額（その他返戻金）");

        exDateEquals((BizDate) MockObjectManager.getArgument(KeisanZennouSeisanGk2MockForHozen.class, "getZennouPSeisanKbn", 0, 0), BizDate.valueOf("20181101"), "領収日");
        exDateEquals((BizDate) MockObjectManager.getArgument(KeisanZennouSeisanGk2MockForHozen.class, "getZennouPSeisanKbn", 0, 1), BizDate.valueOf("20180101"), "伝票日付");
    }

    @Test
    @TestOrder(20)
    public void testExecPKanjokamokuHantei_A2() {
        KeisanZennouSeisanGk2MockForHozen.SYORIPTN = KeisanZennouSeisanGk2MockForHozen.TESTPATTERN2;
        BizDate denYmd = BizDate.valueOf(20180101);
        BizDate kykYmd = BizDate.valueOf(20180102);
        BizCurrency zennouSeisankin = BizCurrency.valueOf(55555);
        BizDate ryosyuYmd = BizDate.valueOf(20181101);
        BizDateYM jkipjytYm = BizDateYM.valueOf(201802);
        BizCurrency mkkp = BizCurrency.valueOf(11111);
        BizDateYM mikeikapjyutouYm = BizDateYM.valueOf(201803);
        MiKeikaPBean[] miKeikaPBeans = new MiKeikaPBean[0];
        String kinouId = IKhozenCommonConstants.KINOUID_BATCH_KAIYAKU;
        C_SyoriKbn syoriKbn = C_SyoriKbn.BLNK;

        commonSiwakeUtil.execPKanjokamokuHantei(denYmd, kykYmd, zennouSeisankin, ryosyuYmd, jkipjytYm, mkkp,
            mikeikapjyutouYm, miKeikaPBeans, kinouId, syoriKbn, C_Hrkkaisuu.TUKI, C_TkiktbrisyuruiKbn.TEIKI_12MONTHS);

        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendo2kaimeikoup(), BizCurrency.valueOf(11111),
            "対象金額（初年度２回目以降）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkJinendoikoup(), BizCurrency.valueOf(55555),
            "対象金額（次年度以降保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSonotahenreikin(), BizCurrency.valueOf(0),
            "対象金額（その他返戻金）");
    }

    @Test
    @TestOrder(30)
    public void testExecPKanjokamokuHantei_A3() {
        BizDate denYmd = BizDate.valueOf(20180101);
        BizDate kykYmd = BizDate.valueOf(20180102);
        BizCurrency zennouSeisankin = BizCurrency.valueOf(55555);
        BizDate ryosyuYmd = null;
        BizDateYM jkipjytYm = BizDateYM.valueOf(201802);
        BizCurrency mkkp = BizCurrency.valueOf(0);
        BizDateYM mikeikapjyutouYm = BizDateYM.valueOf(201803);
        MiKeikaPBean[] miKeikaPBeans = new MiKeikaPBean[0];
        String kinouId = IKhozenCommonConstants.KINOUID_GENGAKU;
        C_SyoriKbn syoriKbn = C_SyoriKbn.BLNK;

        commonSiwakeUtil.execPKanjokamokuHantei(denYmd, kykYmd, zennouSeisankin, ryosyuYmd, jkipjytYm, mkkp,
            mikeikapjyutouYm, miKeikaPBeans, kinouId, syoriKbn, C_Hrkkaisuu.TUKI, C_TkiktbrisyuruiKbn.TEIKI_12MONTHS);

        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendo2kaimeikoup(), BizCurrency.valueOf(0),
            "対象金額（初年度２回目以降）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkJinendoikoup(), BizCurrency.valueOf(0),
            "対象金額（次年度以降保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSonotahenreikin(), BizCurrency.valueOf(0),
            "対象金額（その他返戻金）");
    }

    @Test
    @TestOrder(40)
    public void testExecPKanjokamokuHantei_A4() {

        MockObjectManager.initialize();
        BizDate denYmd = BizDate.valueOf(20180501);
        BizDate kykYmd = BizDate.valueOf(20180102);
        BizCurrency zennouSeisankin = BizCurrency.valueOf(55555);
        BizDate ryosyuYmd = null;
        BizDateYM jkipjytYm = BizDateYM.valueOf(201803);
        BizCurrency mkkp = BizCurrency.valueOf(5555);
        BizDateYM mikeikapjyutouYm = BizDateYM.valueOf(201802);
        MiKeikaPBean[] miKeikaPBeans = new MiKeikaPBean[1];
        MiKeikaPBean miKeikaPBean1 = new MiKeikaPBean();
        miKeikaPBean1.setMiKeikaP(BizCurrency.valueOf(0));
        miKeikaPBean1.setMkeiPNykDenYmd(BizDate.valueOf(20170101));
        miKeikaPBean1.setMkeiPHrkKaisuu(C_Hrkkaisuu.BLNK);
        miKeikaPBean1.setMkeiPJytKaisuuY(0);
        miKeikaPBean1.setMkeiPJytKaisuuM(0);
        miKeikaPBean1.setMkeiPJytYm(BizDateYM.valueOf(201807));
        miKeikaPBeans[0] = miKeikaPBean1;
        String kinouId = IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI;
        C_SyoriKbn syoriKbn = C_SyoriKbn.KYKTORIKESI;

        commonSiwakeUtil.execPKanjokamokuHantei(denYmd, kykYmd, zennouSeisankin, ryosyuYmd, jkipjytYm, mkkp,
            mikeikapjyutouYm, miKeikaPBeans, kinouId, syoriKbn, C_Hrkkaisuu.TUKI, C_TkiktbrisyuruiKbn.TEIKI_12MONTHS);

        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendo2kaimeikoup(), BizCurrency.valueOf(0),
            "対象金額（初年度２回目以降）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkJinendoikoup(), BizCurrency.valueOf(0),
            "対象金額（次年度以降保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSonotahenreikin(), BizCurrency.valueOf(5555),
            "対象金額（その他返戻金）");

    }

    @Test
    @TestOrder(50)
    public void testExecPKanjokamokuHantei_A5() {
        BizDate denYmd = BizDate.valueOf(20180501);
        BizDate kykYmd = BizDate.valueOf(20180102);
        BizCurrency zennouSeisankin = BizCurrency.valueOf(55555);
        BizDate ryosyuYmd = null;
        BizDateYM jkipjytYm = BizDateYM.valueOf(201804);
        BizCurrency mkkp = BizCurrency.valueOf(15000);
        BizDateYM mikeikapjyutouYm = BizDateYM.valueOf(201802);
        MiKeikaPBean[] miKeikaPBeans = new MiKeikaPBean[1];
        MiKeikaPBean miKeikaPBean1 = new MiKeikaPBean();
        miKeikaPBean1.setMiKeikaP(BizCurrency.valueOf(0));
        miKeikaPBean1.setMkeiPNykDenYmd(BizDate.valueOf(20170101));
        miKeikaPBean1.setMkeiPHrkKaisuu(C_Hrkkaisuu.BLNK);
        miKeikaPBean1.setMkeiPJytKaisuuY(0);
        miKeikaPBean1.setMkeiPJytKaisuuM(0);
        miKeikaPBean1.setMkeiPJytYm(BizDateYM.valueOf(201807));
        miKeikaPBeans[0] = miKeikaPBean1;
        String kinouId = IKhozenCommonConstants.KINOUID_KAIYAKU;
        C_SyoriKbn syoriKbn = C_SyoriKbn.BLNK;

        commonSiwakeUtil.execPKanjokamokuHantei(denYmd, kykYmd, zennouSeisankin, ryosyuYmd, jkipjytYm, mkkp,
            mikeikapjyutouYm, miKeikaPBeans, kinouId, syoriKbn, C_Hrkkaisuu.TUKI, C_TkiktbrisyuruiKbn.TEIKI_12MONTHS);

        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendo2kaimeikoup(), BizCurrency.valueOf(0),
            "対象金額（初年度２回目以降）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkJinendoikoup(), BizCurrency.valueOf(0),
            "対象金額（次年度以降保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSonotahenreikin(), BizCurrency.valueOf(15000),
            "対象金額（その他返戻金）");
    }

    @Test
    @TestOrder(60)
    public void testExecPKanjokamokuHantei_A6() {
        BizDate denYmd = BizDate.valueOf(20180501);
        BizDate kykYmd = BizDate.valueOf(20180102);
        BizCurrency zennouSeisankin = BizCurrency.valueOf(55555);
        BizDate ryosyuYmd = null;
        BizDateYM jkipjytYm = BizDateYM.valueOf(201805);
        BizCurrency mkkp = BizCurrency.valueOf(15000);
        BizDateYM mikeikapjyutouYm = BizDateYM.valueOf(201805);
        MiKeikaPBean[] miKeikaPBeans = new MiKeikaPBean[1];
        MiKeikaPBean miKeikaPBean1 = new MiKeikaPBean();
        miKeikaPBean1.setMiKeikaP(BizCurrency.valueOf(0));
        miKeikaPBean1.setMkeiPNykDenYmd(BizDate.valueOf(20170101));
        miKeikaPBean1.setMkeiPHrkKaisuu(C_Hrkkaisuu.BLNK);
        miKeikaPBean1.setMkeiPJytKaisuuY(0);
        miKeikaPBean1.setMkeiPJytKaisuuM(0);
        miKeikaPBean1.setMkeiPJytYm(BizDateYM.valueOf(201807));
        miKeikaPBeans[0] = miKeikaPBean1;
        String kinouId = IKhozenCommonConstants.KINOUID_KAIYAKU;
        C_SyoriKbn syoriKbn = C_SyoriKbn.BLNK;

        commonSiwakeUtil.execPKanjokamokuHantei(denYmd, kykYmd, zennouSeisankin, ryosyuYmd, jkipjytYm, mkkp,
            mikeikapjyutouYm, miKeikaPBeans, kinouId, syoriKbn, C_Hrkkaisuu.TUKI, C_TkiktbrisyuruiKbn.TEIKI_12MONTHS);

        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendo2kaimeikoup(), BizCurrency.valueOf(0),
            "対象金額（初年度２回目以降）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkJinendoikoup(), BizCurrency.valueOf(15000),
            "対象金額（次年度以降保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSonotahenreikin(), BizCurrency.valueOf(0),
            "対象金額（その他返戻金）");
    }

    @Test
    @TestOrder(70)
    public void testExecPKanjokamokuHantei_A7() {
        BizDate denYmd = BizDate.valueOf(20180501);
        BizDate kykYmd = BizDate.valueOf(20170602);
        BizCurrency zennouSeisankin = BizCurrency.valueOf(55555);
        BizDate ryosyuYmd = null;
        BizDateYM jkipjytYm = BizDateYM.valueOf(201805);
        BizCurrency mkkp = BizCurrency.valueOf(15000);
        BizDateYM mikeikapjyutouYm = BizDateYM.valueOf(201804);
        MiKeikaPBean[] miKeikaPBeans = new MiKeikaPBean[1];
        MiKeikaPBean miKeikaPBean1 = new MiKeikaPBean();
        miKeikaPBean1.setMiKeikaP(BizCurrency.valueOf(0));
        miKeikaPBean1.setMkeiPNykDenYmd(BizDate.valueOf(20170101));
        miKeikaPBean1.setMkeiPHrkKaisuu(C_Hrkkaisuu.BLNK);
        miKeikaPBean1.setMkeiPJytKaisuuY(0);
        miKeikaPBean1.setMkeiPJytKaisuuM(0);
        miKeikaPBean1.setMkeiPJytYm(BizDateYM.valueOf(201807));
        miKeikaPBeans[0] = miKeikaPBean1;
        String kinouId = IKhozenCommonConstants.KINOUID_KAIYAKU;
        C_SyoriKbn syoriKbn = C_SyoriKbn.BLNK;

        commonSiwakeUtil.execPKanjokamokuHantei(denYmd, kykYmd, zennouSeisankin, ryosyuYmd, jkipjytYm, mkkp,
            mikeikapjyutouYm, miKeikaPBeans, kinouId, syoriKbn, C_Hrkkaisuu.TUKI, C_TkiktbrisyuruiKbn.TEIKI_12MONTHS);

        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendo2kaimeikoup(), BizCurrency.valueOf(0),
            "対象金額（初年度２回目以降）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkJinendoikoup(), BizCurrency.valueOf(15000),
            "対象金額（次年度以降保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSonotahenreikin(), BizCurrency.valueOf(0),
            "対象金額（その他返戻金）");
    }

    @Test
    @TestOrder(80)
    public void testExecPKanjokamokuHantei_A8() {
        BizDate denYmd = BizDate.valueOf(20180501);
        BizDate kykYmd = BizDate.valueOf(20170601);
        BizCurrency zennouSeisankin = BizCurrency.valueOf(55555);
        BizDate ryosyuYmd = null;
        BizDateYM jkipjytYm = BizDateYM.valueOf(201805);
        BizCurrency mkkp = BizCurrency.valueOf(150000);
        BizDateYM mikeikapjyutouYm = BizDateYM.valueOf(201804);
        MiKeikaPBean[] miKeikaPBeans = new MiKeikaPBean[3];
        MiKeikaPBean miKeikaPBean1 = new MiKeikaPBean();
        miKeikaPBean1.setMiKeikaP(BizCurrency.valueOf(10000));
        miKeikaPBean1.setMkeiPNykDenYmd(BizDate.valueOf(20170101));
        miKeikaPBean1.setMkeiPHrkKaisuu(C_Hrkkaisuu.BLNK);
        miKeikaPBean1.setMkeiPJytKaisuuY(0);
        miKeikaPBean1.setMkeiPJytKaisuuM(0);
        miKeikaPBean1.setMkeiPJytYm(BizDateYM.valueOf(201806));
        miKeikaPBeans[0] = miKeikaPBean1;
        MiKeikaPBean miKeikaPBean2 = new MiKeikaPBean();
        miKeikaPBean2.setMiKeikaP(BizCurrency.valueOf(20000));
        miKeikaPBean2.setMkeiPNykDenYmd(BizDate.valueOf(20170101));
        miKeikaPBean2.setMkeiPHrkKaisuu(C_Hrkkaisuu.BLNK);
        miKeikaPBean2.setMkeiPJytKaisuuY(0);
        miKeikaPBean2.setMkeiPJytKaisuuM(0);
        miKeikaPBean2.setMkeiPJytYm(BizDateYM.valueOf(201805));
        miKeikaPBeans[1] = miKeikaPBean2;
        MiKeikaPBean miKeikaPBean3 = new MiKeikaPBean();
        miKeikaPBean3.setMiKeikaP(BizCurrency.valueOf(30000));
        miKeikaPBean3.setMkeiPNykDenYmd(BizDate.valueOf(20170101));
        miKeikaPBean3.setMkeiPHrkKaisuu(C_Hrkkaisuu.BLNK);
        miKeikaPBean3.setMkeiPJytKaisuuY(0);
        miKeikaPBean3.setMkeiPJytKaisuuM(0);
        miKeikaPBean3.setMkeiPJytYm(BizDateYM.valueOf(201805));
        miKeikaPBeans[2] = miKeikaPBean3;

        String kinouId = IKhozenCommonConstants.KINOUID_KAIYAKU;
        C_SyoriKbn syoriKbn = C_SyoriKbn.BLNK;

        commonSiwakeUtil.execPKanjokamokuHantei(denYmd, kykYmd, zennouSeisankin, ryosyuYmd, jkipjytYm, mkkp,
            mikeikapjyutouYm, miKeikaPBeans, kinouId, syoriKbn, C_Hrkkaisuu.TUKI, C_TkiktbrisyuruiKbn.TEIKI_12MONTHS);

        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendo2kaimeikoup(), BizCurrency.valueOf(50000),
            "対象金額（初年度２回目以降）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkJinendoikoup(), BizCurrency.valueOf(100000),
            "対象金額（次年度以降保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSonotahenreikin(), BizCurrency.valueOf(0),
            "対象金額（その他返戻金）");
    }

    @Test
    @TestOrder(90)
    public void testExecPKanjokamokuHantei_A9() {
        BizDate denYmd = BizDate.valueOf(20180501);
        BizDate kykYmd = BizDate.valueOf(20180102);
        BizCurrency zennouSeisankin = BizCurrency.valueOf(55555);
        BizDate ryosyuYmd = null;
        BizDateYM jkipjytYm = BizDateYM.valueOf(201805);
        BizCurrency mkkp = BizCurrency.valueOf(15000);
        BizDateYM mikeikapjyutouYm = BizDateYM.valueOf(201803);
        MiKeikaPBean[] miKeikaPBeans = new MiKeikaPBean[1];
        MiKeikaPBean miKeikaPBean1 = new MiKeikaPBean();
        miKeikaPBean1.setMiKeikaP(BizCurrency.valueOf(0));
        miKeikaPBean1.setMkeiPNykDenYmd(BizDate.valueOf(20170101));
        miKeikaPBean1.setMkeiPHrkKaisuu(C_Hrkkaisuu.BLNK);
        miKeikaPBean1.setMkeiPJytKaisuuY(0);
        miKeikaPBean1.setMkeiPJytKaisuuM(0);
        miKeikaPBean1.setMkeiPJytYm(BizDateYM.valueOf(201807));
        miKeikaPBeans[0] = miKeikaPBean1;
        String kinouId = IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI;
        C_SyoriKbn syoriKbn = C_SyoriKbn.KAIJO;

        commonSiwakeUtil.execPKanjokamokuHantei(denYmd, kykYmd, zennouSeisankin, ryosyuYmd, jkipjytYm, mkkp,
            mikeikapjyutouYm, miKeikaPBeans, kinouId, syoriKbn, C_Hrkkaisuu.TUKI, C_TkiktbrisyuruiKbn.TEIKI_12MONTHS);

        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendo2kaimeikoup(), BizCurrency.valueOf(0),
            "対象金額（初年度２回目以降）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkJinendoikoup(), BizCurrency.valueOf(15000),
            "対象金額（次年度以降保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSonotahenreikin(), BizCurrency.valueOf(0),
            "対象金額（その他返戻金）");
    }

    @Test
    @TestOrder(100)
    public void testExecPKanjokamokuHantei_A10() {
        BizDate denYmd = BizDate.valueOf(20180501);
        BizDate kykYmd = BizDate.valueOf(20170502);
        BizCurrency zennouSeisankin = BizCurrency.valueOf(55555);
        BizDate ryosyuYmd = null;
        BizDateYM jkipjytYm = BizDateYM.valueOf(201806);
        BizCurrency mkkp = BizCurrency.valueOf(15000);
        BizDateYM mikeikapjyutouYm = BizDateYM.valueOf(201803);
        MiKeikaPBean[] miKeikaPBeans = new MiKeikaPBean[1];
        MiKeikaPBean miKeikaPBean1 = new MiKeikaPBean();
        miKeikaPBean1.setMiKeikaP(BizCurrency.valueOf(0));
        miKeikaPBean1.setMkeiPNykDenYmd(BizDate.valueOf(20170101));
        miKeikaPBean1.setMkeiPHrkKaisuu(C_Hrkkaisuu.BLNK);
        miKeikaPBean1.setMkeiPJytKaisuuY(0);
        miKeikaPBean1.setMkeiPJytKaisuuM(0);
        miKeikaPBean1.setMkeiPJytYm(BizDateYM.valueOf(201807));
        miKeikaPBeans[0] = miKeikaPBean1;
        String kinouId = IKhozenCommonConstants.KINOUID_JYUUSYOHENKOU;
        C_SyoriKbn syoriKbn = C_SyoriKbn.KAIJO;

        commonSiwakeUtil.execPKanjokamokuHantei(denYmd, kykYmd, zennouSeisankin, ryosyuYmd, jkipjytYm, mkkp,
            mikeikapjyutouYm, miKeikaPBeans, kinouId, syoriKbn, C_Hrkkaisuu.TUKI, C_TkiktbrisyuruiKbn.TEIKI_12MONTHS);

        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendo2kaimeikoup(), BizCurrency.valueOf(0),
            "対象金額（初年度２回目以降）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkJinendoikoup(), BizCurrency.valueOf(15000),
            "対象金額（次年度以降保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSonotahenreikin(), BizCurrency.valueOf(0),
            "対象金額（その他返戻金）");
    }

    @Test
    @TestOrder(110)
    public void testExecPKanjokamokuHantei_A11() {
        BizDate denYmd = BizDate.valueOf(20180501);
        BizDate kykYmd = BizDate.valueOf(20170602);
        BizCurrency zennouSeisankin = BizCurrency.valueOf(55555);
        BizDate ryosyuYmd = null;
        BizDateYM jkipjytYm = BizDateYM.valueOf(201806);
        BizCurrency mkkp = BizCurrency.valueOf(15000);
        BizDateYM mikeikapjyutouYm = BizDateYM.valueOf(201803);
        MiKeikaPBean[] miKeikaPBeans = new MiKeikaPBean[1];
        MiKeikaPBean miKeikaPBean1 = new MiKeikaPBean();
        miKeikaPBean1.setMiKeikaP(BizCurrency.valueOf(0));
        miKeikaPBean1.setMkeiPNykDenYmd(BizDate.valueOf(20170101));
        miKeikaPBean1.setMkeiPHrkKaisuu(C_Hrkkaisuu.BLNK);
        miKeikaPBean1.setMkeiPJytKaisuuY(0);
        miKeikaPBean1.setMkeiPJytKaisuuM(0);
        miKeikaPBean1.setMkeiPJytYm(BizDateYM.valueOf(201807));
        miKeikaPBeans[0] = miKeikaPBean1;
        String kinouId = IKhozenCommonConstants.KINOUID_JYUUSYOHENKOU;
        C_SyoriKbn syoriKbn = C_SyoriKbn.BLNK;

        commonSiwakeUtil.execPKanjokamokuHantei(denYmd, kykYmd, zennouSeisankin, ryosyuYmd, jkipjytYm, mkkp,
            mikeikapjyutouYm, miKeikaPBeans, kinouId, syoriKbn, C_Hrkkaisuu.TUKI, C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);

        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendo2kaimeikoup(), BizCurrency.valueOf(0),
            "対象金額（初年度２回目以降）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkJinendoikoup(), BizCurrency.valueOf(15000),
            "対象金額（次年度以降保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSonotahenreikin(), BizCurrency.valueOf(0),
            "対象金額（その他返戻金）");
    }

    @Test
    @TestOrder(120)
    public void testExecPKanjokamokuHantei_A12() {
        BizDate denYmd = BizDate.valueOf(20180501);
        BizDate kykYmd = BizDate.valueOf(20170702);
        BizCurrency zennouSeisankin = BizCurrency.valueOf(55555);
        BizDate ryosyuYmd = null;
        BizDateYM jkipjytYm = BizDateYM.valueOf(201806);
        BizCurrency mkkp = BizCurrency.valueOf(15000);
        BizDateYM mikeikapjyutouYm = BizDateYM.valueOf(201803);
        MiKeikaPBean[] miKeikaPBeans = new MiKeikaPBean[1];
        MiKeikaPBean miKeikaPBean1 = new MiKeikaPBean();
        miKeikaPBean1.setMiKeikaP(BizCurrency.valueOf(10000));
        miKeikaPBean1.setMkeiPNykDenYmd(BizDate.valueOf(20170101));
        miKeikaPBean1.setMkeiPHrkKaisuu(C_Hrkkaisuu.BLNK);
        miKeikaPBean1.setMkeiPJytKaisuuY(3);
        miKeikaPBean1.setMkeiPJytKaisuuM(2);
        miKeikaPBean1.setMkeiPJytYm(BizDateYM.valueOf(201801));
        miKeikaPBeans[0] = miKeikaPBean1;

        String kinouId = IKhozenCommonConstants.KINOUID_JYUUSYOHENKOU;
        C_SyoriKbn syoriKbn = C_SyoriKbn.BLNK;

        commonSiwakeUtil.execPKanjokamokuHantei(denYmd, kykYmd, zennouSeisankin, ryosyuYmd, jkipjytYm, mkkp,
            mikeikapjyutouYm, miKeikaPBeans, kinouId, syoriKbn, C_Hrkkaisuu.TUKI, C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);

        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendo2kaimeikoup(), BizCurrency.valueOf(0),
            "対象金額（初年度２回目以降）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkJinendoikoup(), BizCurrency.valueOf(0),
            "対象金額（次年度以降保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSonotahenreikin(), BizCurrency.valueOf(10000),
            "対象金額（その他返戻金）");
    }

    @Test
    @TestOrder(130)
    public void testExecPKanjokamokuHantei_A13() {
        BizDate denYmd = BizDate.valueOf(20180501);
        BizDate kykYmd = BizDate.valueOf(20170702);
        BizCurrency zennouSeisankin = BizCurrency.valueOf(55555);
        BizDate ryosyuYmd = null;
        BizDateYM jkipjytYm = BizDateYM.valueOf(201806);
        BizCurrency mkkp = BizCurrency.valueOf(15000);
        BizDateYM mikeikapjyutouYm = BizDateYM.valueOf(201803);
        MiKeikaPBean[] miKeikaPBeans = new MiKeikaPBean[3];
        MiKeikaPBean miKeikaPBean1 = new MiKeikaPBean();
        miKeikaPBean1.setMiKeikaP(BizCurrency.valueOf(11000));
        miKeikaPBean1.setMkeiPNykDenYmd(BizDate.valueOf(20170101));
        miKeikaPBean1.setMkeiPHrkKaisuu(C_Hrkkaisuu.BLNK);
        miKeikaPBean1.setMkeiPJytKaisuuY(1);
        miKeikaPBean1.setMkeiPJytKaisuuM(3);
        miKeikaPBean1.setMkeiPJytYm(BizDateYM.valueOf(201801));
        miKeikaPBeans[0] = miKeikaPBean1;
        MiKeikaPBean miKeikaPBean2 = new MiKeikaPBean();
        miKeikaPBean2.setMiKeikaP(BizCurrency.valueOf(12000));
        miKeikaPBean2.setMkeiPNykDenYmd(BizDate.valueOf(20170101));
        miKeikaPBean2.setMkeiPHrkKaisuu(C_Hrkkaisuu.BLNK);
        miKeikaPBean2.setMkeiPJytKaisuuY(2);
        miKeikaPBean2.setMkeiPJytKaisuuM(1);
        miKeikaPBean2.setMkeiPJytYm(BizDateYM.valueOf(201803));
        miKeikaPBeans[1] = miKeikaPBean2;
        MiKeikaPBean miKeikaPBean3 = new MiKeikaPBean();
        miKeikaPBean3.setMiKeikaP(BizCurrency.valueOf(13000));
        miKeikaPBean3.setMkeiPNykDenYmd(BizDate.valueOf(20170101));
        miKeikaPBean3.setMkeiPHrkKaisuu(C_Hrkkaisuu.BLNK);
        miKeikaPBean3.setMkeiPJytKaisuuY(3);
        miKeikaPBean3.setMkeiPJytKaisuuM(3);
        miKeikaPBean3.setMkeiPJytYm(BizDateYM.valueOf(201803));
        miKeikaPBeans[2] = miKeikaPBean3;

        String kinouId = IKhozenCommonConstants.KINOUID_JYUUSYOHENKOU;
        C_SyoriKbn syoriKbn = C_SyoriKbn.BLNK;

        commonSiwakeUtil.execPKanjokamokuHantei(denYmd, kykYmd, zennouSeisankin, ryosyuYmd, jkipjytYm, mkkp,
            mikeikapjyutouYm, miKeikaPBeans, kinouId, syoriKbn, C_Hrkkaisuu.TUKI, C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);

        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendo2kaimeikoup(), BizCurrency.valueOf(8667),
            "対象金額（初年度２回目以降）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkJinendoikoup(), BizCurrency.valueOf(0),
            "対象金額（次年度以降保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSonotahenreikin(), BizCurrency.valueOf(27333),
            "対象金額（その他返戻金）");
    }

    @Test
    @TestOrder(140)
    public void testExecPKanjokamokuHantei_A14() {
        BizDate denYmd = BizDate.valueOf(20180501);
        BizDate kykYmd = BizDate.valueOf(20170502);
        BizCurrency zennouSeisankin = BizCurrency.valueOf(55555);
        BizDate ryosyuYmd = null;
        BizDateYM jkipjytYm = BizDateYM.valueOf(201806);
        BizCurrency mkkp = BizCurrency.valueOf(15000);
        BizDateYM mikeikapjyutouYm = BizDateYM.valueOf(201803);
        MiKeikaPBean[] miKeikaPBeans = new MiKeikaPBean[1];
        MiKeikaPBean miKeikaPBean1 = new MiKeikaPBean();
        miKeikaPBean1.setMiKeikaP(BizCurrency.valueOf(0));
        miKeikaPBean1.setMkeiPNykDenYmd(BizDate.valueOf(20170101));
        miKeikaPBean1.setMkeiPHrkKaisuu(C_Hrkkaisuu.BLNK);
        miKeikaPBean1.setMkeiPJytKaisuuY(0);
        miKeikaPBean1.setMkeiPJytKaisuuM(0);
        miKeikaPBean1.setMkeiPJytYm(BizDateYM.valueOf(201807));
        miKeikaPBeans[0] = miKeikaPBean1;
        String kinouId = IKhozenCommonConstants.KINOUID_JYUUSYOHENKOU;
        C_SyoriKbn syoriKbn = C_SyoriKbn.BLNK;

        commonSiwakeUtil.execPKanjokamokuHantei(denYmd, kykYmd, zennouSeisankin, ryosyuYmd, jkipjytYm, mkkp,
            mikeikapjyutouYm, miKeikaPBeans, kinouId, syoriKbn, C_Hrkkaisuu.TUKI, C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);

        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendo2kaimeikoup(), BizCurrency.valueOf(0),
            "対象金額（初年度２回目以降）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkJinendoikoup(), BizCurrency.valueOf(15000),
            "対象金額（次年度以降保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSonotahenreikin(), BizCurrency.valueOf(0),
            "対象金額（その他返戻金）");
    }

    @Test
    @TestOrder(150)
    public void testExecPKanjokamokuHantei_A15() {
        BizDate denYmd = BizDate.valueOf(20180501);
        BizDate kykYmd = BizDate.valueOf(20170502);
        BizCurrency zennouSeisankin = BizCurrency.valueOf(55555);
        BizDate ryosyuYmd = null;
        BizDateYM jkipjytYm = BizDateYM.valueOf(201806);
        BizCurrency mkkp = BizCurrency.valueOf(15000);
        BizDateYM mikeikapjyutouYm = BizDateYM.valueOf(201803);
        MiKeikaPBean[] miKeikaPBeans = new MiKeikaPBean[1];
        MiKeikaPBean miKeikaPBean1 = new MiKeikaPBean();
        miKeikaPBean1.setMiKeikaP(BizCurrency.valueOf(10000));
        miKeikaPBean1.setMkeiPNykDenYmd(BizDate.valueOf(20170101));
        miKeikaPBean1.setMkeiPHrkKaisuu(C_Hrkkaisuu.BLNK);
        miKeikaPBean1.setMkeiPJytKaisuuY(3);
        miKeikaPBean1.setMkeiPJytKaisuuM(2);
        miKeikaPBean1.setMkeiPJytYm(BizDateYM.valueOf(201801));
        miKeikaPBeans[0] = miKeikaPBean1;

        String kinouId = IKhozenCommonConstants.KINOUID_JYUUSYOHENKOU;
        C_SyoriKbn syoriKbn = C_SyoriKbn.BLNK;

        commonSiwakeUtil.execPKanjokamokuHantei(denYmd, kykYmd, zennouSeisankin, ryosyuYmd, jkipjytYm, mkkp,
            mikeikapjyutouYm, miKeikaPBeans, kinouId, syoriKbn, C_Hrkkaisuu.TUKI, C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);

        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendo2kaimeikoup(), BizCurrency.valueOf(0),
            "対象金額（初年度２回目以降）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkJinendoikoup(), BizCurrency.valueOf(0),
            "対象金額（次年度以降保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSonotahenreikin(), BizCurrency.valueOf(10000),
            "対象金額（その他返戻金）");
    }

    @Test
    @TestOrder(160)
    public void testExecPKanjokamokuHantei_A16() {
        BizDate denYmd = BizDate.valueOf(20180501);
        BizDate kykYmd = BizDate.valueOf(20170502);
        BizCurrency zennouSeisankin = BizCurrency.valueOf(55555);
        BizDate ryosyuYmd = null;
        BizDateYM jkipjytYm = BizDateYM.valueOf(201806);
        BizCurrency mkkp = BizCurrency.valueOf(15000);
        BizDateYM mikeikapjyutouYm = BizDateYM.valueOf(201803);
        MiKeikaPBean[] miKeikaPBeans = new MiKeikaPBean[4];
        MiKeikaPBean miKeikaPBean1 = new MiKeikaPBean();
        miKeikaPBean1.setMiKeikaP(BizCurrency.valueOf(11000));
        miKeikaPBean1.setMkeiPNykDenYmd(BizDate.valueOf(20170101));
        miKeikaPBean1.setMkeiPHrkKaisuu(C_Hrkkaisuu.BLNK);
        miKeikaPBean1.setMkeiPJytKaisuuY(1);
        miKeikaPBean1.setMkeiPJytKaisuuM(3);
        miKeikaPBean1.setMkeiPJytYm(BizDateYM.valueOf(201801));
        miKeikaPBeans[0] = miKeikaPBean1;
        MiKeikaPBean miKeikaPBean2 = new MiKeikaPBean();
        miKeikaPBean2.setMiKeikaP(BizCurrency.valueOf(12000));
        miKeikaPBean2.setMkeiPNykDenYmd(BizDate.valueOf(20170101));
        miKeikaPBean2.setMkeiPHrkKaisuu(C_Hrkkaisuu.BLNK);
        miKeikaPBean2.setMkeiPJytKaisuuY(2);
        miKeikaPBean2.setMkeiPJytKaisuuM(1);
        miKeikaPBean2.setMkeiPJytYm(BizDateYM.valueOf(201803));
        miKeikaPBeans[1] = miKeikaPBean2;
        MiKeikaPBean miKeikaPBean3 = new MiKeikaPBean();
        miKeikaPBean3.setMiKeikaP(BizCurrency.valueOf(13000));
        miKeikaPBean3.setMkeiPNykDenYmd(BizDate.valueOf(20170101));
        miKeikaPBean3.setMkeiPHrkKaisuu(C_Hrkkaisuu.BLNK);
        miKeikaPBean3.setMkeiPJytKaisuuY(3);
        miKeikaPBean3.setMkeiPJytKaisuuM(3);
        miKeikaPBean3.setMkeiPJytYm(BizDateYM.valueOf(201803));
        miKeikaPBeans[2] = miKeikaPBean3;
        MiKeikaPBean miKeikaPBean4 = new MiKeikaPBean();
        miKeikaPBean4.setMiKeikaP(BizCurrency.valueOf(13000));
        miKeikaPBean4.setMkeiPNykDenYmd(BizDate.valueOf(20170101));
        miKeikaPBean4.setMkeiPHrkKaisuu(C_Hrkkaisuu.BLNK);
        miKeikaPBean4.setMkeiPJytKaisuuY(3);
        miKeikaPBean4.setMkeiPJytKaisuuM(3);
        miKeikaPBean4.setMkeiPJytYm(BizDateYM.valueOf(201807));
        miKeikaPBeans[3] = miKeikaPBean4;

        String kinouId = IKhozenCommonConstants.KINOUID_JYUUSYOHENKOU;
        C_SyoriKbn syoriKbn = C_SyoriKbn.BLNK;

        commonSiwakeUtil.execPKanjokamokuHantei(denYmd, kykYmd, zennouSeisankin, ryosyuYmd, jkipjytYm, mkkp,
            mikeikapjyutouYm, miKeikaPBeans, kinouId, syoriKbn, C_Hrkkaisuu.TUKI, C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);

        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendo2kaimeikoup(), BizCurrency.valueOf(8667),
            "対象金額（初年度２回目以降）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkJinendoikoup(), BizCurrency.valueOf(13000),
            "対象金額（次年度以降保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSonotahenreikin(), BizCurrency.valueOf(27333),
            "対象金額（その他返戻金）");
    }

    @Test
    @TestOrder(170)
    public void testExecPKanjokamokuHantei_A17() {
        BizDate denYmd = BizDate.valueOf(20180501);
        BizDate kykYmd = BizDate.valueOf(20170402);
        BizCurrency zennouSeisankin = BizCurrency.valueOf(55555);
        BizDate ryosyuYmd = null;
        BizDateYM jkipjytYm = BizDateYM.valueOf(201806);
        BizCurrency mkkp = BizCurrency.valueOf(15000);
        BizDateYM mikeikapjyutouYm = BizDateYM.valueOf(201803);
        MiKeikaPBean[] miKeikaPBeans = new MiKeikaPBean[1];
        MiKeikaPBean miKeikaPBean1 = new MiKeikaPBean();
        miKeikaPBean1.setMiKeikaP(BizCurrency.valueOf(0));
        miKeikaPBean1.setMkeiPNykDenYmd(BizDate.valueOf(20170101));
        miKeikaPBean1.setMkeiPHrkKaisuu(C_Hrkkaisuu.BLNK);
        miKeikaPBean1.setMkeiPJytKaisuuY(0);
        miKeikaPBean1.setMkeiPJytKaisuuM(0);
        miKeikaPBean1.setMkeiPJytYm(BizDateYM.valueOf(201807));
        miKeikaPBeans[0] = miKeikaPBean1;
        String kinouId = IKhozenCommonConstants.KINOUID_JYUUSYOHENKOU;
        C_SyoriKbn syoriKbn = C_SyoriKbn.BLNK;

        commonSiwakeUtil.execPKanjokamokuHantei(denYmd, kykYmd, zennouSeisankin, ryosyuYmd, jkipjytYm, mkkp,
            mikeikapjyutouYm, miKeikaPBeans, kinouId, syoriKbn, C_Hrkkaisuu.TUKI, C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);

        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendo2kaimeikoup(), BizCurrency.valueOf(0),
            "対象金額（初年度２回目以降）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkJinendoikoup(), BizCurrency.valueOf(15000),
            "対象金額（次年度以降保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSonotahenreikin(), BizCurrency.valueOf(0),
            "対象金額（その他返戻金）");
    }

    @Test
    @TestOrder(180)
    public void testExecPKanjokamokuHantei_A18() {
        BizDate denYmd = BizDate.valueOf(20180501);
        BizDate kykYmd = BizDate.valueOf(20170402);
        BizCurrency zennouSeisankin = BizCurrency.valueOf(55555);
        BizDate ryosyuYmd = null;
        BizDateYM jkipjytYm = BizDateYM.valueOf(201806);
        BizCurrency mkkp = BizCurrency.valueOf(15000);
        BizDateYM mikeikapjyutouYm = BizDateYM.valueOf(201803);
        MiKeikaPBean[] miKeikaPBeans = new MiKeikaPBean[1];
        MiKeikaPBean miKeikaPBean1 = new MiKeikaPBean();
        miKeikaPBean1.setMiKeikaP(BizCurrency.valueOf(50000));
        miKeikaPBean1.setMkeiPNykDenYmd(BizDate.valueOf(20170101));
        miKeikaPBean1.setMkeiPHrkKaisuu(C_Hrkkaisuu.BLNK);
        miKeikaPBean1.setMkeiPJytKaisuuY(3);
        miKeikaPBean1.setMkeiPJytKaisuuM(1);
        miKeikaPBean1.setMkeiPJytYm(BizDateYM.valueOf(201802));
        miKeikaPBeans[0] = miKeikaPBean1;
        String kinouId = IKhozenCommonConstants.KINOUID_JYUUSYOHENKOU;
        C_SyoriKbn syoriKbn = C_SyoriKbn.BLNK;

        commonSiwakeUtil.execPKanjokamokuHantei(denYmd, kykYmd, zennouSeisankin, ryosyuYmd, jkipjytYm, mkkp,
            mikeikapjyutouYm, miKeikaPBeans, kinouId, syoriKbn, C_Hrkkaisuu.TUKI, C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);

        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendo2kaimeikoup(), BizCurrency.valueOf(0),
            "対象金額（初年度２回目以降）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkJinendoikoup(), BizCurrency.valueOf(0),
            "対象金額（次年度以降保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSonotahenreikin(), BizCurrency.valueOf(50000),
            "対象金額（その他返戻金）");
    }

    @Test
    @TestOrder(190)
    public void testExecPKanjokamokuHantei_A19() {
        BizDate denYmd = BizDate.valueOf(20180501);
        BizDate kykYmd = BizDate.valueOf(20170302);
        BizCurrency zennouSeisankin = BizCurrency.valueOf(55555);
        BizDate ryosyuYmd = null;
        BizDateYM jkipjytYm = BizDateYM.valueOf(201806);
        BizCurrency mkkp = BizCurrency.valueOf(15000);
        BizDateYM mikeikapjyutouYm = BizDateYM.valueOf(201803);
        MiKeikaPBean[] miKeikaPBeans = new MiKeikaPBean[3];
        MiKeikaPBean miKeikaPBean1 = new MiKeikaPBean();
        miKeikaPBean1.setMiKeikaP(BizCurrency.valueOf(34000));
        miKeikaPBean1.setMkeiPNykDenYmd(BizDate.valueOf(20170101));
        miKeikaPBean1.setMkeiPHrkKaisuu(C_Hrkkaisuu.BLNK);
        miKeikaPBean1.setMkeiPJytKaisuuY(3);
        miKeikaPBean1.setMkeiPJytKaisuuM(3);
        miKeikaPBean1.setMkeiPJytYm(BizDateYM.valueOf(201801));
        miKeikaPBeans[0] = miKeikaPBean1;
        MiKeikaPBean miKeikaPBean2 = new MiKeikaPBean();
        miKeikaPBean2.setMiKeikaP(BizCurrency.valueOf(40000));
        miKeikaPBean2.setMkeiPNykDenYmd(BizDate.valueOf(20170101));
        miKeikaPBean2.setMkeiPHrkKaisuu(C_Hrkkaisuu.BLNK);
        miKeikaPBean2.setMkeiPJytKaisuuY(3);
        miKeikaPBean2.setMkeiPJytKaisuuM(1);
        miKeikaPBean2.setMkeiPJytYm(BizDateYM.valueOf(201803));
        miKeikaPBeans[1] = miKeikaPBean2;
        MiKeikaPBean miKeikaPBean3 = new MiKeikaPBean();
        miKeikaPBean3.setMiKeikaP(BizCurrency.valueOf(50000));
        miKeikaPBean3.setMkeiPNykDenYmd(BizDate.valueOf(20170101));
        miKeikaPBean3.setMkeiPHrkKaisuu(C_Hrkkaisuu.BLNK);
        miKeikaPBean3.setMkeiPJytKaisuuY(3);
        miKeikaPBean3.setMkeiPJytKaisuuM(3);
        miKeikaPBean3.setMkeiPJytYm(BizDateYM.valueOf(201803));
        miKeikaPBeans[2] = miKeikaPBean3;
        String kinouId = IKhozenCommonConstants.KINOUID_JYUUSYOHENKOU;
        C_SyoriKbn syoriKbn = C_SyoriKbn.BLNK;

        commonSiwakeUtil.execPKanjokamokuHantei(denYmd, kykYmd, zennouSeisankin, ryosyuYmd, jkipjytYm, mkkp,
            mikeikapjyutouYm, miKeikaPBeans, kinouId, syoriKbn, C_Hrkkaisuu.NEN, C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);

        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendo2kaimeikoup(), BizCurrency.valueOf(0),
            "対象金額（初年度２回目以降）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkJinendoikoup(), BizCurrency.valueOf(0),
            "対象金額（次年度以降保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSonotahenreikin(), BizCurrency.valueOf(124000),
            "対象金額（その他返戻金）");
    }

    @Test
    @TestOrder(200)
    public void testExecPKanjokamokuHantei_A20() {
        KeisanZennouSeisanGk2MockForHozen.SYORIPTN = KeisanZennouSeisanGk2MockForHozen.TESTPATTERN2;
        BizDate denYmd = BizDate.valueOf(20180101);
        BizDate kykYmd = BizDate.valueOf(20180102);
        BizCurrency zennouSeisankin = BizCurrency.valueOf(55555);
        BizDate ryosyuYmd = null;
        BizDateYM jkipjytYm = BizDateYM.valueOf(201802);
        BizCurrency mkkp = BizCurrency.valueOf(11111);
        BizDateYM mikeikapjyutouYm = BizDateYM.valueOf(201803);
        MiKeikaPBean[] miKeikaPBeans = new MiKeikaPBean[1];
        MiKeikaPBean miKeikaPBean1 = new MiKeikaPBean();
        miKeikaPBean1.setMiKeikaP(BizCurrency.valueOf(34000));
        miKeikaPBean1.setMkeiPNykDenYmd(BizDate.valueOf(20170101));
        miKeikaPBean1.setMkeiPHrkKaisuu(C_Hrkkaisuu.BLNK);
        miKeikaPBean1.setMkeiPJytKaisuuY(3);
        miKeikaPBean1.setMkeiPJytKaisuuM(3);
        miKeikaPBean1.setMkeiPJytYm(BizDateYM.valueOf(201703));
        miKeikaPBeans[0] = miKeikaPBean1;
        String kinouId = IKhozenCommonConstants.KINOUID_KAIYAKU;
        C_SyoriKbn syoriKbn = C_SyoriKbn.BLNK;

        commonSiwakeUtil.execPKanjokamokuHantei(denYmd, kykYmd, zennouSeisankin, ryosyuYmd, jkipjytYm, mkkp,
            mikeikapjyutouYm, miKeikaPBeans, kinouId, syoriKbn, C_Hrkkaisuu.TUKI, C_TkiktbrisyuruiKbn.TEIKI_12MONTHS);

        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendo2kaimeikoup(), BizCurrency.valueOf(0),
            "対象金額（初年度２回目以降）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkJinendoikoup(), BizCurrency.valueOf(0),
            "対象金額（次年度以降保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSonotahenreikin(), BizCurrency.valueOf(11111),
            "対象金額（その他返戻金）");
    }

    @Test
    @TestOrder(210)
    public void testExecPKanjokamokuHantei_A21() {
        KeisanZennouSeisanGk2MockForHozen.SYORIPTN = KeisanZennouSeisanGk2MockForHozen.TESTPATTERN2;
        BizDate denYmd = BizDate.valueOf(20180101);
        BizDate kykYmd = BizDate.valueOf(20180102);
        BizCurrency zennouSeisankin = BizCurrency.valueOf(55555);
        BizDate ryosyuYmd = BizDate.valueOf(20181101);
        BizDateYM jkipjytYm = BizDateYM.valueOf(201802);
        BizCurrency mkkp = BizCurrency.valueOf(11111);
        BizDateYM mikeikapjyutouYm = BizDateYM.valueOf(201803);
        MiKeikaPBean[] miKeikaPBeans = new MiKeikaPBean[1];
        MiKeikaPBean miKeikaPBean1 = new MiKeikaPBean();
        miKeikaPBean1.setMiKeikaP(BizCurrency.valueOf(34000));
        miKeikaPBean1.setMkeiPNykDenYmd(BizDate.valueOf(20170101));
        miKeikaPBean1.setMkeiPHrkKaisuu(C_Hrkkaisuu.BLNK);
        miKeikaPBean1.setMkeiPJytKaisuuY(3);
        miKeikaPBean1.setMkeiPJytKaisuuM(3);
        miKeikaPBean1.setMkeiPJytYm(BizDateYM.valueOf(201703));
        miKeikaPBeans[0] = miKeikaPBean1;
        String kinouId = IKhozenCommonConstants.KINOUID_KAIYAKU;
        C_SyoriKbn syoriKbn = C_SyoriKbn.BLNK;

        commonSiwakeUtil.execPKanjokamokuHantei(denYmd, kykYmd, zennouSeisankin, ryosyuYmd, jkipjytYm, mkkp,
            mikeikapjyutouYm, miKeikaPBeans, kinouId, syoriKbn, C_Hrkkaisuu.NEN, C_TkiktbrisyuruiKbn.TEIKI_12MONTHS);

        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendo2kaimeikoup(), BizCurrency.valueOf(0),
            "対象金額（初年度２回目以降）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkJinendoikoup(), BizCurrency.valueOf(55555),
            "対象金額（次年度以降保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSonotahenreikin(), BizCurrency.valueOf(0),
            "対象金額（その他返戻金）");
    }

    @Test
    @TestOrder(220)
    public void testExecPKanjokamokuHantei_A22() {
        BizDate denYmd = BizDate.valueOf(20180501);
        BizDate kykYmd = BizDate.valueOf(20171002);
        BizCurrency zennouSeisankin = BizCurrency.valueOf(55555);
        BizDate ryosyuYmd = null;
        BizDateYM jkipjytYm = BizDateYM.valueOf(201806);
        BizCurrency mkkp = BizCurrency.valueOf(15000);
        BizDateYM mikeikapjyutouYm = BizDateYM.valueOf(201803);
        MiKeikaPBean[] miKeikaPBeans = new MiKeikaPBean[2];
        MiKeikaPBean miKeikaPBean1 = new MiKeikaPBean();
        miKeikaPBean1.setMiKeikaP(BizCurrency.valueOf(11000));
        miKeikaPBean1.setMkeiPNykDenYmd(BizDate.valueOf(20180401));
        miKeikaPBean1.setMkeiPHrkKaisuu(C_Hrkkaisuu.BLNK);
        miKeikaPBean1.setMkeiPJytKaisuuY(1);
        miKeikaPBean1.setMkeiPJytKaisuuM(3);
        miKeikaPBean1.setMkeiPJytYm(BizDateYM.valueOf(201804));
        miKeikaPBeans[0] = miKeikaPBean1;
        MiKeikaPBean miKeikaPBean2 = new MiKeikaPBean();
        miKeikaPBean2.setMiKeikaP(BizCurrency.valueOf(11000));
        miKeikaPBean2.setMkeiPNykDenYmd(BizDate.valueOf(20180401));
        miKeikaPBean2.setMkeiPHrkKaisuu(C_Hrkkaisuu.BLNK);
        miKeikaPBean2.setMkeiPJytKaisuuY(1);
        miKeikaPBean2.setMkeiPJytKaisuuM(3);
        miKeikaPBean2.setMkeiPJytYm(BizDateYM.valueOf(201810));
        miKeikaPBeans[1] = miKeikaPBean2;

        String kinouId = IKhozenCommonConstants.KINOUID_KAIYAKU;
        C_SyoriKbn syoriKbn = C_SyoriKbn.BLNK;

        commonSiwakeUtil.execPKanjokamokuHantei(denYmd, kykYmd, zennouSeisankin, ryosyuYmd, jkipjytYm, mkkp,
            mikeikapjyutouYm, miKeikaPBeans, kinouId, syoriKbn, C_Hrkkaisuu.HALFY, C_TkiktbrisyuruiKbn.TEIKI_12MONTHS);

        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendo2kaimeikoup(), BizCurrency.valueOf(11000),
            "対象金額（初年度２回目以降）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkJinendoikoup(), BizCurrency.valueOf(11000),
            "対象金額（次年度以降保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSonotahenreikin(), BizCurrency.valueOf(0),
            "対象金額（その他返戻金）");
    }

    @Test
    @TestOrder(230)
    public void testExecPKanjokamokuHantei_A23() {
        BizDate denYmd = BizDate.valueOf(20180501);
        BizDate kykYmd = BizDate.valueOf(20160702);
        BizCurrency zennouSeisankin = BizCurrency.valueOf(55555);
        BizDate ryosyuYmd = null;
        BizDateYM jkipjytYm = BizDateYM.valueOf(201806);
        BizCurrency mkkp = BizCurrency.valueOf(15000);
        BizDateYM mikeikapjyutouYm = BizDateYM.valueOf(201803);
        MiKeikaPBean[] miKeikaPBeans = new MiKeikaPBean[1];
        MiKeikaPBean miKeikaPBean1 = new MiKeikaPBean();
        miKeikaPBean1.setMiKeikaP(BizCurrency.valueOf(11000));
        miKeikaPBean1.setMkeiPNykDenYmd(BizDate.valueOf(20170101));
        miKeikaPBean1.setMkeiPHrkKaisuu(C_Hrkkaisuu.BLNK);
        miKeikaPBean1.setMkeiPJytKaisuuY(1);
        miKeikaPBean1.setMkeiPJytKaisuuM(3);
        miKeikaPBean1.setMkeiPJytYm(BizDateYM.valueOf(201805));
        miKeikaPBeans[0] = miKeikaPBean1;

        String kinouId = IKhozenCommonConstants.KINOUID_KAIYAKU;
        C_SyoriKbn syoriKbn = C_SyoriKbn.BLNK;

        commonSiwakeUtil.execPKanjokamokuHantei(denYmd, kykYmd, zennouSeisankin, ryosyuYmd, jkipjytYm, mkkp,
            mikeikapjyutouYm, miKeikaPBeans, kinouId, syoriKbn, C_Hrkkaisuu.HALFY, C_TkiktbrisyuruiKbn.TEIKI_12MONTHS);

        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendo2kaimeikoup(), BizCurrency.valueOf(0),
            "対象金額（初年度２回目以降）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkJinendoikoup(), BizCurrency.valueOf(11000),
            "対象金額（次年度以降保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSonotahenreikin(), BizCurrency.valueOf(0),
            "対象金額（その他返戻金）");
    }


    @Test
    @TestOrder(240)
    public void testExecPKanjokamokuHantei_A24() {
        BizDate denYmd = BizDate.valueOf(20180501);
        BizDate kykYmd = BizDate.valueOf(20160702);
        BizCurrency zennouSeisankin = BizCurrency.valueOf(55555);
        BizDate ryosyuYmd = null;
        BizDateYM jkipjytYm = BizDateYM.valueOf(201806);
        BizCurrency mkkp = BizCurrency.valueOf(15000);
        BizDateYM mikeikapjyutouYm = BizDateYM.valueOf(201803);
        MiKeikaPBean[] miKeikaPBeans = new MiKeikaPBean[1];
        MiKeikaPBean miKeikaPBean1 = new MiKeikaPBean();
        miKeikaPBean1.setMiKeikaP(BizCurrency.valueOf(11000));
        miKeikaPBean1.setMkeiPNykDenYmd(BizDate.valueOf(20170101));
        miKeikaPBean1.setMkeiPHrkKaisuu(C_Hrkkaisuu.BLNK);
        miKeikaPBean1.setMkeiPJytKaisuuY(1);
        miKeikaPBean1.setMkeiPJytKaisuuM(3);
        miKeikaPBean1.setMkeiPJytYm(BizDateYM.valueOf(201805));
        miKeikaPBeans[0] = miKeikaPBean1;

        String kinouId = IKhozenCommonConstants.KINOUID_KAIYAKU;
        C_SyoriKbn syoriKbn = C_SyoriKbn.BLNK;

        commonSiwakeUtil.execPKanjokamokuHantei(denYmd, kykYmd, zennouSeisankin, ryosyuYmd, jkipjytYm, mkkp,
            mikeikapjyutouYm, miKeikaPBeans, kinouId, syoriKbn, C_Hrkkaisuu.NEN, C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);

        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendo2kaimeikoup(), BizCurrency.valueOf(0),
            "対象金額（初年度２回目以降）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkJinendoikoup(), BizCurrency.valueOf(11000),
            "対象金額（次年度以降保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSonotahenreikin(), BizCurrency.valueOf(0),
            "対象金額（その他返戻金）");
    }


    @Test
    @TestOrder(250)
    public void testExecPKanjokamokuHantei_A25() {
        BizDate denYmd = BizDate.valueOf(20180501);
        BizDate kykYmd = BizDate.valueOf(20160702);
        BizCurrency zennouSeisankin = BizCurrency.valueOf(55555);
        BizDate ryosyuYmd = null;
        BizDateYM jkipjytYm = BizDateYM.valueOf(201806);
        BizCurrency mkkp = BizCurrency.valueOf(15000);
        BizDateYM mikeikapjyutouYm = BizDateYM.valueOf(201803);
        MiKeikaPBean[] miKeikaPBeans = new MiKeikaPBean[1];
        MiKeikaPBean miKeikaPBean1 = new MiKeikaPBean();
        miKeikaPBean1.setMiKeikaP(BizCurrency.valueOf(11000));
        miKeikaPBean1.setMkeiPNykDenYmd(BizDate.valueOf(20170101));
        miKeikaPBean1.setMkeiPHrkKaisuu(C_Hrkkaisuu.BLNK);
        miKeikaPBean1.setMkeiPJytKaisuuY(1);
        miKeikaPBean1.setMkeiPJytKaisuuM(3);
        miKeikaPBean1.setMkeiPJytYm(BizDateYM.valueOf(201804));
        miKeikaPBeans[0] = miKeikaPBean1;

        String kinouId = IKhozenCommonConstants.KINOUID_JYUUSYOHENKOU;
        C_SyoriKbn syoriKbn = C_SyoriKbn.BLNK;

        commonSiwakeUtil.execPKanjokamokuHantei(denYmd, kykYmd, zennouSeisankin, ryosyuYmd, jkipjytYm, mkkp,
            mikeikapjyutouYm, miKeikaPBeans, kinouId, syoriKbn, C_Hrkkaisuu.TUKI, C_TkiktbrisyuruiKbn.NONE);

        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendo2kaimeikoup(), BizCurrency.valueOf(0),
            "対象金額（初年度２回目以降）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkJinendoikoup(), BizCurrency.valueOf(11000),
            "対象金額（次年度以降保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSonotahenreikin(), BizCurrency.valueOf(0),
            "対象金額（その他返戻金）");
    }

    @Test
    @TestOrder(260)
    public void testExecPKanjokamokuHantei_A26() {
        BizDate denYmd = BizDate.valueOf(20180501);
        BizDate kykYmd = BizDate.valueOf(20180702);
        BizCurrency zennouSeisankin = BizCurrency.valueOf(55555);
        BizDate ryosyuYmd = null;
        BizDateYM jkipjytYm = BizDateYM.valueOf(201806);
        BizCurrency mkkp = BizCurrency.valueOf(15000);
        BizDateYM mikeikapjyutouYm = BizDateYM.valueOf(201803);
        MiKeikaPBean[] miKeikaPBeans = new MiKeikaPBean[1];
        MiKeikaPBean miKeikaPBean1 = new MiKeikaPBean();
        miKeikaPBean1.setMiKeikaP(BizCurrency.valueOf(11000));
        miKeikaPBean1.setMkeiPNykDenYmd(BizDate.valueOf(20170101));
        miKeikaPBean1.setMkeiPHrkKaisuu(C_Hrkkaisuu.BLNK);
        miKeikaPBean1.setMkeiPJytKaisuuY(1);
        miKeikaPBean1.setMkeiPJytKaisuuM(3);
        miKeikaPBean1.setMkeiPJytYm(BizDateYM.valueOf(201805));
        miKeikaPBeans[0] = miKeikaPBean1;

        String kinouId = IKhozenCommonConstants.KINOUID_KAIYAKU;
        C_SyoriKbn syoriKbn = C_SyoriKbn.BLNK;

        commonSiwakeUtil.execPKanjokamokuHantei(denYmd, kykYmd, zennouSeisankin, ryosyuYmd, jkipjytYm, mkkp,
            mikeikapjyutouYm, miKeikaPBeans, kinouId, syoriKbn, C_Hrkkaisuu.HALFY, C_TkiktbrisyuruiKbn.TEIKI_12MONTHS);

        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendo2kaimeikoup(), BizCurrency.valueOf(0),
            "対象金額（初年度２回目以降）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkJinendoikoup(), BizCurrency.valueOf(0),
            "対象金額（次年度以降保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSonotahenreikin(), BizCurrency.valueOf(0),
            "対象金額（その他返戻金）");
    }

    @Test
    @TestOrder(270)
    public void testExecPKanjokamokuHantei_A27() {
        BizDate denYmd = BizDate.valueOf(20180501);
        BizDate kykYmd = BizDate.valueOf(20180702);
        BizCurrency zennouSeisankin = BizCurrency.valueOf(55555);
        BizDate ryosyuYmd = null;
        BizDateYM jkipjytYm = BizDateYM.valueOf(201806);
        BizCurrency mkkp = BizCurrency.valueOf(15000);
        BizDateYM mikeikapjyutouYm = BizDateYM.valueOf(201803);
        MiKeikaPBean[] miKeikaPBeans = new MiKeikaPBean[1];
        MiKeikaPBean miKeikaPBean1 = new MiKeikaPBean();
        miKeikaPBean1.setMiKeikaP(BizCurrency.valueOf(11000));
        miKeikaPBean1.setMkeiPNykDenYmd(BizDate.valueOf(20170101));
        miKeikaPBean1.setMkeiPHrkKaisuu(C_Hrkkaisuu.BLNK);
        miKeikaPBean1.setMkeiPJytKaisuuY(1);
        miKeikaPBean1.setMkeiPJytKaisuuM(3);
        miKeikaPBean1.setMkeiPJytYm(BizDateYM.valueOf(201803));
        miKeikaPBeans[0] = miKeikaPBean1;

        String kinouId = IKhozenCommonConstants.KINOUID_KAIYAKU;
        C_SyoriKbn syoriKbn = C_SyoriKbn.BLNK;

        commonSiwakeUtil.execPKanjokamokuHantei(denYmd, kykYmd, zennouSeisankin, ryosyuYmd, jkipjytYm, mkkp,
            mikeikapjyutouYm, miKeikaPBeans, kinouId, syoriKbn, C_Hrkkaisuu.HALFY, C_TkiktbrisyuruiKbn.TEIKI_12MONTHS);

        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendo2kaimeikoup(), BizCurrency.valueOf(0),
            "対象金額（初年度２回目以降）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkJinendoikoup(), BizCurrency.valueOf(0),
            "対象金額（次年度以降保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSonotahenreikin(), BizCurrency.valueOf(15000),
            "対象金額（その他返戻金）");
    }

    @Test
    @TestOrder(280)
    public void testExecPKanjokamokuHantei_A28() {
        BizDate denYmd = BizDate.valueOf(20180501);
        BizDate kykYmd = BizDate.valueOf(20160702);
        BizCurrency zennouSeisankin = BizCurrency.valueOf(55555);
        BizDate ryosyuYmd = null;
        BizDateYM jkipjytYm = BizDateYM.valueOf(201806);
        BizCurrency mkkp = BizCurrency.valueOf(15000);
        BizDateYM mikeikapjyutouYm = BizDateYM.valueOf(201803);
        MiKeikaPBean[] miKeikaPBeans = new MiKeikaPBean[2];
        MiKeikaPBean miKeikaPBean1 = new MiKeikaPBean();
        miKeikaPBean1.setMiKeikaP(BizCurrency.valueOf(11000));
        miKeikaPBean1.setMkeiPNykDenYmd(BizDate.valueOf(20170101));
        miKeikaPBean1.setMkeiPHrkKaisuu(C_Hrkkaisuu.BLNK);
        miKeikaPBean1.setMkeiPJytKaisuuY(1);
        miKeikaPBean1.setMkeiPJytKaisuuM(2);
        miKeikaPBean1.setMkeiPJytYm(BizDateYM.valueOf(201803));
        miKeikaPBeans[0] = miKeikaPBean1;
        MiKeikaPBean miKeikaPBean2 = new MiKeikaPBean();
        miKeikaPBean2.setMiKeikaP(BizCurrency.valueOf(11000));
        miKeikaPBean2.setMkeiPNykDenYmd(BizDate.valueOf(20170101));
        miKeikaPBean2.setMkeiPHrkKaisuu(C_Hrkkaisuu.BLNK);
        miKeikaPBean2.setMkeiPJytKaisuuY(1);
        miKeikaPBean2.setMkeiPJytKaisuuM(3);
        miKeikaPBean2.setMkeiPJytYm(BizDateYM.valueOf(201804));
        miKeikaPBeans[1] = miKeikaPBean2;

        String kinouId = IKhozenCommonConstants.KINOUID_JYUUSYOHENKOU;
        C_SyoriKbn syoriKbn = C_SyoriKbn.BLNK;

        commonSiwakeUtil.execPKanjokamokuHantei(denYmd, kykYmd, zennouSeisankin, ryosyuYmd, jkipjytYm, mkkp,
            mikeikapjyutouYm, miKeikaPBeans, kinouId, syoriKbn, C_Hrkkaisuu.TUKI, C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);

        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendo2kaimeikoup(), BizCurrency.valueOf(0),
            "対象金額（初年度２回目以降）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkJinendoikoup(), BizCurrency.valueOf(16500),
            "対象金額（次年度以降保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSonotahenreikin(), BizCurrency.valueOf(5500),
            "対象金額（その他返戻金）");
    }

    @Test
    @TestOrder(290)
    public void testExecPKanjokamokuHantei_A29() {

        MockObjectManager.initialize();
        KeisanZennouSeisanGk2MockForHozen.SYORIPTN = KeisanZennouSeisanGk2MockForHozen.TESTPATTERN3;
        BizDate denYmd = BizDate.valueOf(20180101);
        BizDate kykYmd = BizDate.valueOf(20180102);
        BizCurrency zennouSeisankin = BizCurrency.valueOf(55555);
        BizDate ryosyuYmd = BizDate.valueOf(20181101);
        BizDateYM jkipjytYm = BizDateYM.valueOf(201802);
        BizCurrency mkkp = BizCurrency.valueOf(11111,BizCurrencyTypes.YEN);
        BizDateYM mikeikapjyutouYm = BizDateYM.valueOf(201803);
        MiKeikaPBean[] miKeikaPBeans = new MiKeikaPBean[0];
        String kinouId = IKhozenCommonConstants.JIMUTETUZUKICD_KAIYAKU;
        C_SyoriKbn syoriKbn = C_SyoriKbn.BLNK;

        commonSiwakeUtil.execPKanjokamokuHantei(denYmd, kykYmd, zennouSeisankin, ryosyuYmd, jkipjytYm, mkkp,
            mikeikapjyutouYm, miKeikaPBeans, kinouId, syoriKbn, C_Hrkkaisuu.TUKI, C_TkiktbrisyuruiKbn.TEIKI_12MONTHS);

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
    @TestOrder(300)
    public void testExecPKanjokamokuHantei_A30() {
        KeisanZennouSeisanGk2MockForHozen.SYORIPTN = KeisanZennouSeisanGk2MockForHozen.TESTPATTERN2;
        BizDate denYmd = BizDate.valueOf(20180101);
        BizDate kykYmd = BizDate.valueOf(20180102);
        BizCurrency zennouSeisankin = BizCurrency.valueOf(55555);
        BizDate ryosyuYmd = BizDate.valueOf(20181101);
        BizDateYM jkipjytYm = BizDateYM.valueOf(201802);
        BizCurrency mkkp = BizCurrency.valueOf(11111);
        BizDateYM mikeikapjyutouYm = BizDateYM.valueOf(201803);
        MiKeikaPBean[] miKeikaPBeans = new MiKeikaPBean[1];
        MiKeikaPBean miKeikaPBean1 = new MiKeikaPBean();
        miKeikaPBean1.setMiKeikaP(BizCurrency.valueOf(34000));
        miKeikaPBean1.setMkeiPNykDenYmd(BizDate.valueOf(20170101));
        miKeikaPBean1.setMkeiPHrkKaisuu(C_Hrkkaisuu.BLNK);
        miKeikaPBean1.setMkeiPJytKaisuuY(3);
        miKeikaPBean1.setMkeiPJytKaisuuM(3);
        miKeikaPBean1.setMkeiPJytYm(BizDateYM.valueOf(201703));
        miKeikaPBeans[0] = miKeikaPBean1;
        String kinouId = IKhozenCommonConstants.KINOUID_KAIYAKU;
        C_SyoriKbn syoriKbn = C_SyoriKbn.BLNK;

        commonSiwakeUtil.execPKanjokamokuHantei(denYmd, kykYmd, zennouSeisankin, ryosyuYmd, jkipjytYm, mkkp,
            mikeikapjyutouYm, miKeikaPBeans, kinouId, syoriKbn, C_Hrkkaisuu.HALFY, C_TkiktbrisyuruiKbn.TEIKI_12MONTHS);

        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendo2kaimeikoup(), BizCurrency.valueOf(0),
            "対象金額（初年度２回目以降）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkJinendoikoup(), BizCurrency.valueOf(0),
            "対象金額（次年度以降保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSonotahenreikin(), BizCurrency.valueOf(0),
            "対象金額（その他返戻金）");
    }

    @Test
    @TestOrder(310)
    public void testExecPKanjokamokuHantei_A31() {
        BizDate denYmd = BizDate.valueOf(20180501);
        BizDate kykYmd = BizDate.valueOf(20160702);
        BizCurrency zennouSeisankin = BizCurrency.valueOf(55555);
        BizDate ryosyuYmd = null;
        BizDateYM jkipjytYm = BizDateYM.valueOf(201806);
        BizCurrency mkkp = BizCurrency.valueOf(15000);
        BizDateYM mikeikapjyutouYm = BizDateYM.valueOf(201803);
        MiKeikaPBean[] miKeikaPBeans = new MiKeikaPBean[2];
        MiKeikaPBean miKeikaPBean1 = new MiKeikaPBean();
        miKeikaPBean1.setMiKeikaP(BizCurrency.valueOf(11000));
        miKeikaPBean1.setMkeiPNykDenYmd(BizDate.valueOf(20170101));
        miKeikaPBean1.setMkeiPHrkKaisuu(C_Hrkkaisuu.BLNK);
        miKeikaPBean1.setMkeiPJytKaisuuY(1);
        miKeikaPBean1.setMkeiPJytKaisuuM(2);
        miKeikaPBean1.setMkeiPJytYm(BizDateYM.valueOf(201803));
        miKeikaPBeans[0] = miKeikaPBean1;
        MiKeikaPBean miKeikaPBean2 = new MiKeikaPBean();
        miKeikaPBean2.setMiKeikaP(BizCurrency.valueOf(11000));
        miKeikaPBean2.setMkeiPNykDenYmd(BizDate.valueOf(20170101));
        miKeikaPBean2.setMkeiPHrkKaisuu(C_Hrkkaisuu.BLNK);
        miKeikaPBean2.setMkeiPJytKaisuuY(1);
        miKeikaPBean2.setMkeiPJytKaisuuM(3);
        miKeikaPBean2.setMkeiPJytYm(BizDateYM.valueOf(201804));
        miKeikaPBeans[1] = miKeikaPBean2;

        String kinouId = IKhozenCommonConstants.KINOUID_JYUUSYOHENKOU;
        C_SyoriKbn syoriKbn = C_SyoriKbn.BLNK;

        commonSiwakeUtil.execPKanjokamokuHantei(denYmd, kykYmd, zennouSeisankin, ryosyuYmd, jkipjytYm, mkkp,
            mikeikapjyutouYm, miKeikaPBeans, kinouId, syoriKbn, C_Hrkkaisuu.ITIJI, C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);

        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSyonendo2kaimeikoup(), BizCurrency.valueOf(0),
            "対象金額（初年度２回目以降）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkJinendoikoup(), BizCurrency.valueOf(0),
            "対象金額（次年度以降保険料）");
        exBizCalcbleEquals(commonSiwakeUtil.getTaisyouGkSonotahenreikin(), BizCurrency.valueOf(0),
            "対象金額（その他返戻金）");
    }

}
