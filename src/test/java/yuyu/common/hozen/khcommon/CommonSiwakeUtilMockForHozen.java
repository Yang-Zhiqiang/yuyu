package yuyu.common.hozen.khcommon;

import java.util.List;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import yuyu.common.biz.kaikei.BzSiwakeMeisaiBean;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 仕訳共通ユーティリティ{@link CommonSiwakeUtil}のモッククラスです<br />
 */
public class CommonSiwakeUtilMockForHozen extends CommonSiwakeUtil {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    private BizCurrency taisyouGkSyonendoSyokaip;

    private BizCurrency taisyouGkSyonendo2kaimeikoup;

    private BizCurrency taisyouGkJinendoikoup;

    private BizCurrency taisyouGkSonotahenreikin;

    @Override
    public BizCurrency getTaisyouGkSyonendoSyokaip() {
        return taisyouGkSyonendoSyokaip;
    }

    @Override
    public BizCurrency getTaisyouGkSyonendo2kaimeikoup() {
        return taisyouGkSyonendo2kaimeikoup;
    }

    @Override
    public BizCurrency getTaisyouGkJinendoikoup() {
        return taisyouGkJinendoikoup;
    }

    @Override
    public BizCurrency getTaisyouGkSonotahenreikin() {
        return taisyouGkSonotahenreikin;
    }

    @Override
    public void execPKanjokamokuHantei(BizDate pDenYmd, BizDate pKykYmd, BizCurrency pZennouSeisankin, BizDate pRyosyuYmd,
        BizDateYM pJkipjytYm, BizCurrency pMkkp, BizDateYM pMikeikapjyutouYm, MiKeikaPBean[] pMiKeikaPBeans, String pKinouId,
        C_SyoriKbn pSyoriKbn, C_Hrkkaisuu pHrkkaisuu, C_TkiktbrisyuruiKbn pTikiktbrisyuruikbn) {
        if (caller == EditKaiyakuTblUpdateTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                taisyouGkSyonendoSyokaip = BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR);
                taisyouGkSyonendo2kaimeikoup = BizCurrency.valueOf(150, BizCurrencyTypes.DOLLAR);
                taisyouGkJinendoikoup = BizCurrency.valueOf(200, BizCurrencyTypes.DOLLAR);
                taisyouGkSonotahenreikin = BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                taisyouGkSyonendoSyokaip = BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR);
                taisyouGkSyonendo2kaimeikoup = BizCurrency.valueOf(150, BizCurrencyTypes.AU_DOLLAR);
                taisyouGkJinendoikoup = BizCurrency.valueOf(200, BizCurrencyTypes.AU_DOLLAR);
                taisyouGkSonotahenreikin = BizCurrency.valueOf(100, BizCurrencyTypes.AU_DOLLAR);
            }
            else {
                taisyouGkSyonendoSyokaip = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                taisyouGkSyonendo2kaimeikoup = BizCurrency.valueOf(150, BizCurrencyTypes.YEN);
                taisyouGkJinendoikoup = BizCurrency.valueOf(200, BizCurrencyTypes.YEN);
                taisyouGkSonotahenreikin = BizCurrency.valueOf(100, BizCurrencyTypes.YEN);
            }
            return;
        }
        super.execPKanjokamokuHantei(pDenYmd, pKykYmd, pZennouSeisankin, pRyosyuYmd, pJkipjytYm,
            pMkkp, pMikeikapjyutouYm, pMiKeikaPBeans, pKinouId,pSyoriKbn, pHrkkaisuu, pTikiktbrisyuruikbn);
    }

    @Override
    public List<BzSiwakeMeisaiBean> execTaisyakuTyousei(C_Tuukasyu pTuukasyu, List<BzSiwakeMeisaiBean> pBzSiwakeMeisaiBeanLst) {
        if (caller == EditKaiyakuTblUpdateTest_exec.class) {
            return pBzSiwakeMeisaiBeanLst;
        }
        return super.execTaisyakuTyousei(pTuukasyu, pBzSiwakeMeisaiBeanLst);
    }
}
