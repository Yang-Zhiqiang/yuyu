package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import yuyu.common.hozen.haitou.SetHokenNnd;
import yuyu.common.siharai.sicommon.SiSiharaiKingakuKeisanTest_exec;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_MisyuptsKbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * {@link SetHokenNnd}のモッククラスです。<br />
 */
public class KeisanMsyMkeiPMock extends KeisanMsyMkeiP {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    private BizCurrency misyuP;

    private BizCurrency misyuPGaika;

    private int misyuPJyutouKaisuuY;

    private int misyuPJyutouKaisuuM;

    private BizDateYM misyuPJyutouYM;

    private MisyuuPBean[] misyuuPBeans;

    private BizCurrency mikeikaP;

    private int mikeikaPJyutouKaisuuY;

    private int mikeikaPJyutouKaisuuM;

    private BizDateYM mikeikaPJyutouYM;

    private MiKeikaPBean[] miKeikaPBeans;

    @Override
    public BizCurrency getMisyuP() {

        if (SiSiharaiKingakuKeisanTest_exec.class == caller) {
            return misyuP;
        }

        if (caller == KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class) {
            return misyuP;
        }
        return super.getMisyuP();
    }

    @Override
    public BizCurrency getMisyuPGaika() {
        if (SiSiharaiKingakuKeisanTest_exec.class == caller) {
            return misyuPGaika;
        }
        if (caller == KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class) {
            return misyuPGaika;
        }
        return super.getMisyuPGaika();
    }

    @Override
    public int getMisyuPJyutouKaisuuY() {
        if (SiSiharaiKingakuKeisanTest_exec.class == caller) {
            return misyuPJyutouKaisuuY;
        }
        if (caller == KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class) {
            return misyuPJyutouKaisuuY;
        }
        return super.getMisyuPJyutouKaisuuY();
    }

    @Override
    public int getMisyuPJyutouKaisuuM() {
        if (SiSiharaiKingakuKeisanTest_exec.class == caller) {
            return misyuPJyutouKaisuuM;
        }
        if (caller == KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class) {
            return misyuPJyutouKaisuuM;
        }
        return super.getMisyuPJyutouKaisuuM();
    }

    @Override
    public BizDateYM getMisyuPJyutouYM() {
        if (SiSiharaiKingakuKeisanTest_exec.class == caller) {
            return misyuPJyutouYM;
        }
        if (caller == KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class) {
            return misyuPJyutouYM;
        }
        return super.getMisyuPJyutouYM();
    }

    @Override
    public MisyuuPBean[] getMisyuuPBeans() {
        if (SiSiharaiKingakuKeisanTest_exec.class == caller) {
            return misyuuPBeans;
        }
        if (caller == KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class) {
            return misyuuPBeans;
        }
        return super.getMisyuuPBeans();
    }

    @Override
    public BizCurrency getMikeikaP() {
        if (SiSiharaiKingakuKeisanTest_exec.class == caller) {
            return mikeikaP;
        }
        if (caller == KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class) {
            return mikeikaP;
        }
        return super.getMikeikaP();
    }

    @Override
    public int getMikeikaPJyutouKaisuuY() {
        if (SiSiharaiKingakuKeisanTest_exec.class == caller) {
            return mikeikaPJyutouKaisuuY;
        }
        if (caller == KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class) {
            return mikeikaPJyutouKaisuuY;
        }
        return super.getMikeikaPJyutouKaisuuY();
    }
    @Override
    public int getMikeikaPJyutouKaisuuM() {
        if (SiSiharaiKingakuKeisanTest_exec.class == caller) {
            return mikeikaPJyutouKaisuuM;
        }
        if (caller == KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class) {
            return mikeikaPJyutouKaisuuM;
        }
        return super.getMikeikaPJyutouKaisuuM();
    }

    @Override
    public BizDateYM getMikeikaPJyutouYM() {
        if (SiSiharaiKingakuKeisanTest_exec.class == caller) {
            return mikeikaPJyutouYM;
        }
        if (caller == KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class) {
            return mikeikaPJyutouYM;
        }
        return super.getMikeikaPJyutouYM();
    }

    @Override
    public MiKeikaPBean[] getMiKeikaPBeans() {
        if (SiSiharaiKingakuKeisanTest_exec.class == caller) {
            return miKeikaPBeans;
        }
        if (caller == KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class) {
            return miKeikaPBeans;
        }
        return super.getMiKeikaPBeans();
    }


    @Override
    public void exec(String pSyoNo, BizDate pKeisanYMD, BizDateYM pJkipjytYM, BizCurrency pHrkp,
        C_MisyuptsKbn pMisyuPTsKbn) {

        if (SiSiharaiKingakuKeisanTest_exec.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                misyuP = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                misyuPGaika = BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR);
                misyuPJyutouKaisuuY = 0;
                misyuPJyutouKaisuuM = 0;
                misyuPJyutouYM = null;
                misyuuPBeans = null;
                mikeikaP = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                mikeikaPJyutouKaisuuY = 0;
                mikeikaPJyutouKaisuuM = 0;
                mikeikaPJyutouYM = null;
                miKeikaPBeans = null;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                misyuP = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                misyuPGaika = BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR);
                misyuPJyutouKaisuuY = 0;
                misyuPJyutouKaisuuM = 0;
                misyuPJyutouYM = null;
                misyuuPBeans = null;

                mikeikaP = BizCurrency.valueOf(40010, BizCurrencyTypes.YEN);
                mikeikaPJyutouKaisuuY = 0;
                mikeikaPJyutouKaisuuM = 4;
                mikeikaPJyutouYM = BizDateYM.valueOf(201907);

                MiKeikaPBean[] meisaiMikeikaPBean = new MiKeikaPBean[4];
                MiKeikaPBean meisaiMikeikaPBean0 = new MiKeikaPBean();
                meisaiMikeikaPBean0.setMiKeikaP(BizCurrency.valueOf(10001, BizCurrencyTypes.YEN));
                meisaiMikeikaPBean0.setMkeiPNykDenYmd(BizDate.valueOf(20190701));
                meisaiMikeikaPBean0.setMkeiPHrkKaisuu(C_Hrkkaisuu.TUKI);
                meisaiMikeikaPBean0.setMkeiPJytKaisuuY(0);
                meisaiMikeikaPBean0.setMkeiPJytKaisuuM(1);
                meisaiMikeikaPBean0.setMkeiPJytYm(BizDateYM.valueOf(201907));
                meisaiMikeikaPBean[0] = meisaiMikeikaPBean0;

                MiKeikaPBean meisaiMikeikaPBean1 = new MiKeikaPBean();
                meisaiMikeikaPBean1.setMiKeikaP(BizCurrency.valueOf(10002, BizCurrencyTypes.YEN));
                meisaiMikeikaPBean1.setMkeiPNykDenYmd(BizDate.valueOf(20190801));
                meisaiMikeikaPBean1.setMkeiPHrkKaisuu(C_Hrkkaisuu.TUKI);
                meisaiMikeikaPBean1.setMkeiPJytKaisuuY(0);
                meisaiMikeikaPBean1.setMkeiPJytKaisuuM(1);
                meisaiMikeikaPBean1.setMkeiPJytYm(BizDateYM.valueOf(201908));
                meisaiMikeikaPBean[1] = meisaiMikeikaPBean1;

                MiKeikaPBean meisaiMikeikaPBean2 = new MiKeikaPBean();
                meisaiMikeikaPBean2.setMiKeikaP(BizCurrency.valueOf(10003, BizCurrencyTypes.YEN));
                meisaiMikeikaPBean2.setMkeiPNykDenYmd(BizDate.valueOf(20190901));
                meisaiMikeikaPBean2.setMkeiPHrkKaisuu(C_Hrkkaisuu.TUKI);
                meisaiMikeikaPBean2.setMkeiPJytKaisuuY(0);
                meisaiMikeikaPBean2.setMkeiPJytKaisuuM(1);
                meisaiMikeikaPBean2.setMkeiPJytYm(BizDateYM.valueOf(201909));
                meisaiMikeikaPBean[2] = meisaiMikeikaPBean2;

                MiKeikaPBean meisaiMikeikaPBean3 = new MiKeikaPBean();
                meisaiMikeikaPBean3.setMiKeikaP(BizCurrency.valueOf(10004, BizCurrencyTypes.YEN));
                meisaiMikeikaPBean3.setMkeiPNykDenYmd(BizDate.valueOf(20191001));
                meisaiMikeikaPBean3.setMkeiPHrkKaisuu(C_Hrkkaisuu.TUKI);
                meisaiMikeikaPBean3.setMkeiPJytKaisuuY(0);
                meisaiMikeikaPBean3.setMkeiPJytKaisuuM(1);
                meisaiMikeikaPBean3.setMkeiPJytYm(BizDateYM.valueOf(201910));
                meisaiMikeikaPBean[3] = meisaiMikeikaPBean3;

                miKeikaPBeans = meisaiMikeikaPBean;

            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {

                misyuP = BizCurrency.valueOf(80010, BizCurrencyTypes.YEN);
                misyuPGaika = BizCurrency.valueOf(656.5, BizCurrencyTypes.DOLLAR);
                misyuPJyutouKaisuuY = 0;
                misyuPJyutouKaisuuM = 4;
                misyuPJyutouYM = BizDateYM.valueOf(201907);

                MisyuuPBean[] meisaiMisyuuPBean = new MisyuuPBean[4];
                MisyuuPBean meisaiMisyuuPBean0 = new MisyuuPBean();
                meisaiMisyuuPBean0.setMisyuuP(BizCurrency.valueOf(20001, BizCurrencyTypes.YEN));
                meisaiMisyuuPBean0.setMisyuuPGaika(BizCurrency.valueOf(164.11, BizCurrencyTypes.DOLLAR));
                meisaiMisyuuPBean0.setMsyPIkkatuNkUmu(C_UmuKbn.ARI);
                meisaiMisyuuPBean0.setMsyPHrkKaisuu(C_Hrkkaisuu.TUKI);
                meisaiMisyuuPBean0.setMsyPJytKaisuuY(0);
                meisaiMisyuuPBean0.setMsyPJytKaisuuM(1);
                meisaiMisyuuPBean0.setMsyPJytYm(BizDateYM.valueOf(201907));
                meisaiMisyuuPBean[0] = meisaiMisyuuPBean0;

                MisyuuPBean meisaiMisyuuPBean1 = new MisyuuPBean();
                meisaiMisyuuPBean1.setMisyuuP(BizCurrency.valueOf(20002, BizCurrencyTypes.YEN));
                meisaiMisyuuPBean1.setMisyuuPGaika(BizCurrency.valueOf(164.12, BizCurrencyTypes.DOLLAR));
                meisaiMisyuuPBean1.setMsyPIkkatuNkUmu(C_UmuKbn.ARI);
                meisaiMisyuuPBean1.setMsyPHrkKaisuu(C_Hrkkaisuu.TUKI);
                meisaiMisyuuPBean1.setMsyPJytKaisuuY(0);
                meisaiMisyuuPBean1.setMsyPJytKaisuuM(1);
                meisaiMisyuuPBean1.setMsyPJytYm(BizDateYM.valueOf(201908));
                meisaiMisyuuPBean[1] = meisaiMisyuuPBean1;

                MisyuuPBean meisaiMisyuuPBean2 = new MisyuuPBean();
                meisaiMisyuuPBean2.setMisyuuP(BizCurrency.valueOf(20003, BizCurrencyTypes.YEN));
                meisaiMisyuuPBean2.setMisyuuPGaika(BizCurrency.valueOf(164.13, BizCurrencyTypes.DOLLAR));
                meisaiMisyuuPBean2.setMsyPIkkatuNkUmu(C_UmuKbn.ARI);
                meisaiMisyuuPBean2.setMsyPHrkKaisuu(C_Hrkkaisuu.TUKI);
                meisaiMisyuuPBean2.setMsyPJytKaisuuY(0);
                meisaiMisyuuPBean2.setMsyPJytKaisuuM(1);
                meisaiMisyuuPBean2.setMsyPJytYm(BizDateYM.valueOf(201909));
                meisaiMisyuuPBean[2] = meisaiMisyuuPBean2;

                MisyuuPBean meisaiMisyuuPBean3 = new MisyuuPBean();
                meisaiMisyuuPBean3.setMisyuuP(BizCurrency.valueOf(20004, BizCurrencyTypes.YEN));
                meisaiMisyuuPBean3.setMisyuuPGaika(BizCurrency.valueOf(164.14, BizCurrencyTypes.DOLLAR));
                meisaiMisyuuPBean3.setMsyPIkkatuNkUmu(C_UmuKbn.ARI);
                meisaiMisyuuPBean3.setMsyPHrkKaisuu(C_Hrkkaisuu.TUKI);
                meisaiMisyuuPBean3.setMsyPJytKaisuuY(0);
                meisaiMisyuuPBean3.setMsyPJytKaisuuM(1);
                meisaiMisyuuPBean3.setMsyPJytYm(BizDateYM.valueOf(201910));
                meisaiMisyuuPBean[3] = meisaiMisyuuPBean3;

                misyuuPBeans = meisaiMisyuuPBean;

                mikeikaP = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                mikeikaPJyutouKaisuuY = 0;
                mikeikaPJyutouKaisuuM = 0;
                mikeikaPJyutouYM = null;
                miKeikaPBeans = null;
            }
        }

        if (caller == KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                misyuP = BizCurrency.valueOf(10001);
                mikeikaP = BizCurrency.valueOf(10002);
                misyuuPBeans = new MisyuuPBean[1];
                MisyuuPBean misyuuPBean = new MisyuuPBean();
                misyuuPBean.setMisyuuP(BizCurrency.valueOf(2001, BizCurrencyTypes.YEN));
                misyuuPBean.setMisyuuPGaika(BizCurrency.valueOf(3001, BizCurrencyTypes.DOLLAR));
                misyuuPBean.setMsyPIkkatuNkUmu(C_UmuKbn.ARI);
                misyuuPBean.setMsyPHrkKaisuu(C_Hrkkaisuu.HALFY);
                misyuuPBean.setMsyPJytKaisuuY(2);
                misyuuPBean.setMsyPJytKaisuuM(10);
                misyuuPBean.setMsyPJytYm(BizDateYM.valueOf(201811));
                misyuuPBeans[0] = misyuuPBean;

                miKeikaPBeans = new MiKeikaPBean[1];
                MiKeikaPBean miKeikaPBean = new MiKeikaPBean();
                miKeikaPBean.setMiKeikaP(BizCurrency.valueOf(3041, BizCurrencyTypes.DOLLAR));
                miKeikaPBean.setMkeiPNykDenYmd(BizDate.valueOf(20180102));
                miKeikaPBean.setMkeiPHrkKaisuu(C_Hrkkaisuu.HALFY);
                miKeikaPBean.setMkeiPJytKaisuuY(2);
                miKeikaPBean.setMkeiPJytKaisuuM(9);
                miKeikaPBean.setMkeiPJytYm(BizDateYM.valueOf(201809));
                miKeikaPBeans[0] = miKeikaPBean;

                misyuPJyutouKaisuuY = 3;
                misyuPJyutouKaisuuM = 12;
                misyuPJyutouYM = BizDateYM.valueOf(201811);
                mikeikaPJyutouKaisuuY = 1;
                mikeikaPJyutouKaisuuM = 9;
                mikeikaPJyutouYM = BizDateYM.valueOf(201812);

                return;
            }

            if (TESTPATTERN2.equals(SYORIPTN)) {
                misyuP = BizCurrency.valueOf(10001);
                mikeikaP = BizCurrency.valueOf(10002);
                misyuuPBeans = new MisyuuPBean[1];
                MisyuuPBean misyuuPBean = new MisyuuPBean();
                misyuuPBean.setMisyuuP(BizCurrency.valueOf(2001, BizCurrencyTypes.YEN));
                misyuuPBean.setMisyuuPGaika(BizCurrency.valueOf(3001, BizCurrencyTypes.DOLLAR));
                misyuuPBean.setMsyPIkkatuNkUmu(C_UmuKbn.ARI);
                misyuuPBean.setMsyPHrkKaisuu(C_Hrkkaisuu.HALFY);
                misyuuPBean.setMsyPJytKaisuuY(2);
                misyuuPBean.setMsyPJytKaisuuM(10);
                misyuuPBean.setMsyPJytYm(BizDateYM.valueOf(201811));
                misyuuPBeans[0] = misyuuPBean;

                miKeikaPBeans = new MiKeikaPBean[1];
                MiKeikaPBean miKeikaPBean = new MiKeikaPBean();
                miKeikaPBean.setMiKeikaP(BizCurrency.valueOf(3041, BizCurrencyTypes.DOLLAR));
                miKeikaPBean.setMkeiPNykDenYmd(BizDate.valueOf(20180102));
                miKeikaPBean.setMkeiPHrkKaisuu(C_Hrkkaisuu.HALFY);
                miKeikaPBean.setMkeiPJytKaisuuY(2);
                miKeikaPBean.setMkeiPJytKaisuuM(9);
                miKeikaPBean.setMkeiPJytYm(BizDateYM.valueOf(201809));
                miKeikaPBeans[0] = miKeikaPBean;

                misyuPJyutouKaisuuY = 3;
                misyuPJyutouKaisuuM = 12;
                misyuPJyutouYM = BizDateYM.valueOf(201811);
                mikeikaPJyutouKaisuuY = 1;
                mikeikaPJyutouKaisuuM = 9;
                mikeikaPJyutouYM = BizDateYM.valueOf(201812);

                return;
            }

            super.exec(pSyoNo, pKeisanYMD, pJkipjytYM, pHrkp, pMisyuPTsKbn);
        }
    }
}