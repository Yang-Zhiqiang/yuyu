package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_MisyuptsKbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * 未収Ｐ・未経過Ｐ計算{@link KeisanMsyMkeiP}のモッククラスです。<br />
 */
public class KeisanMsyMkeiPMockForHozen extends KeisanMsyMkeiP {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

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

        if (caller == KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class) {
            return misyuP;
        }
        return super.getMisyuP();
    }

    @Override
    public BizCurrency getMisyuPGaika() {
        if (caller == KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class) {
            return misyuPGaika;
        }
        return super.getMisyuPGaika();
    }

    @Override
    public int getMisyuPJyutouKaisuuY() {
        if (caller == KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class) {
            return misyuPJyutouKaisuuY;
        }
        return super.getMisyuPJyutouKaisuuY();
    }

    @Override
    public int getMisyuPJyutouKaisuuM() {
        if (caller == KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class) {
            return misyuPJyutouKaisuuM;
        }
        return super.getMisyuPJyutouKaisuuM();
    }

    @Override
    public BizDateYM getMisyuPJyutouYM() {
        if (caller == KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class) {
            return misyuPJyutouYM;
        }
        return super.getMisyuPJyutouYM();
    }

    @Override
    public MisyuuPBean[] getMisyuuPBeans() {
        if (caller == KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class) {
            return misyuuPBeans;
        }
        return super.getMisyuuPBeans();
    }

    @Override
    public BizCurrency getMikeikaP() {
        if (caller == KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class) {
            return mikeikaP;
        }
        if (caller == EditHokenKykIdouRirekiTblTest_exec.class ||
            caller == EditHokenKykIdouRirekiTblTest_keisanWV.class ||
            caller == EditHokenKykIdouRirekiTblTest_keisanZnnusisnMikkP.class ||
            caller == EditHokenKykIdouRirekiTblTest_keisanZnnusisnMikkPKykInfo.class ||
            caller == EditHokenKykIdouRirekiTblTest_editSeiritujiHrkp.class ||
            caller == EditHokenKykIdouRirekiTblTest_editIdoujiyuuKbn.class ||
            caller == EditHokenKykIdouRirekiTblTest_editHokenKykIdouHaraikataKbn.class ||
            caller == EditHokenKykIdouRirekiTblTest_getKeikaYm.class) {
            return mikeikaP;
        }

        return super.getMikeikaP();
    }

    @Override
    public int getMikeikaPJyutouKaisuuY() {
        if (caller == KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class) {
            return mikeikaPJyutouKaisuuY;
        }
        return super.getMikeikaPJyutouKaisuuY();
    }
    @Override
    public int getMikeikaPJyutouKaisuuM() {
        if (caller == KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class) {
            return mikeikaPJyutouKaisuuM;
        }
        return super.getMikeikaPJyutouKaisuuM();
    }

    @Override
    public BizDateYM getMikeikaPJyutouYM() {
        if (caller == KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class) {
            return mikeikaPJyutouYM;
        }
        return super.getMikeikaPJyutouYM();
    }

    @Override
    public MiKeikaPBean[] getMiKeikaPBeans() {
        if (caller == KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class) {
            return miKeikaPBeans;
        }
        return super.getMiKeikaPBeans();
    }


    @Override
    public void exec(String pSyoNo, BizDate pKeisanYMD, BizDateYM pJkipjytYM, BizCurrency pHrkp,
        C_MisyuptsKbn pMisyuPTsKbn) {

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
        }
        if (caller == EditHokenKykIdouRirekiTblTest_exec.class ||
            caller == EditHokenKykIdouRirekiTblTest_keisanWV.class ||
            caller == EditHokenKykIdouRirekiTblTest_keisanZnnusisnMikkP.class ||
            caller == EditHokenKykIdouRirekiTblTest_keisanZnnusisnMikkPKykInfo.class ||
            caller == EditHokenKykIdouRirekiTblTest_editSeiritujiHrkp.class ||
            caller == EditHokenKykIdouRirekiTblTest_editIdoujiyuuKbn.class ||
            caller == EditHokenKykIdouRirekiTblTest_editHokenKykIdouHaraikataKbn.class ||
            caller == EditHokenKykIdouRirekiTblTest_getKeikaYm.class) {
            if (TESTPATTERN2.equals(SYORIPTN)) {
                if (pHrkp.compareTo(BizCurrency.valueOf(2234.56, pHrkp.getType())) == 0) {
                    mikeikaP = BizCurrency.valueOf(200.02, BizCurrencyTypes.DOLLAR);
                } if (pHrkp.compareTo(BizCurrency.valueOf(2234.55, pHrkp.getType())) == 0) {
                    mikeikaP = BizCurrency.valueOf(100.02, BizCurrencyTypes.DOLLAR);
                }
                if (pHrkp.compareTo(BizCurrency.valueOf(2234.57, pHrkp.getType())) == 0) {
                    mikeikaP = BizCurrency.valueOf(400.02, BizCurrencyTypes.DOLLAR);
                }

                return;
            }
        }

        super.exec(pSyoNo, pKeisanYMD, pJkipjytYM, pHrkp, pMisyuPTsKbn);
    }

    @Override
    public void execKyknaiyouSitei(String pSyoNo, BizDate pKeisanYMD, BizDateYM pJkipjytYM, BizCurrency pHrkp,
        C_MisyuptsKbn pMisyuPTsKbn, BizCurrency pKihons, int pHhknnen, C_Hhknsei pHhknsei, int pHrkkkn) {

        if (caller == EditHokenKykIdouRirekiTblTest_exec.class ||
            caller == EditHokenKykIdouRirekiTblTest_keisanWV.class ||
            caller == EditHokenKykIdouRirekiTblTest_keisanZnnusisnMikkP.class ||
            caller == EditHokenKykIdouRirekiTblTest_keisanZnnusisnMikkPKykInfo.class ||
            caller == EditHokenKykIdouRirekiTblTest_editSeiritujiHrkp.class ||
            caller == EditHokenKykIdouRirekiTblTest_editIdoujiyuuKbn.class ||
            caller == EditHokenKykIdouRirekiTblTest_editHokenKykIdouHaraikataKbn.class ||
            caller == EditHokenKykIdouRirekiTblTest_getKeikaYm.class) {
            if (TESTPATTERN2.equals(SYORIPTN)) {
                if (pHrkp.compareTo(BizCurrency.valueOf(2234.56, pHrkp.getType())) == 0) {
                    mikeikaP = BizCurrency.valueOf(200.02, BizCurrencyTypes.DOLLAR);
                } if (pHrkp.compareTo(BizCurrency.valueOf(2234.55, pHrkp.getType())) == 0) {
                    mikeikaP = BizCurrency.valueOf(100.02, BizCurrencyTypes.DOLLAR);
                }
                if (pHrkp.compareTo(BizCurrency.valueOf(2234.57, pHrkp.getType())) == 0) {
                    mikeikaP = BizCurrency.valueOf(400.02, BizCurrencyTypes.DOLLAR);
                }

                return;
            }
        }
        super.execKyknaiyouSitei(pSyoNo, pKeisanYMD, pJkipjytYM, pHrkp,
            pMisyuPTsKbn, pKihons, pHhknnen, pHhknsei, pHrkkkn);
    }
}