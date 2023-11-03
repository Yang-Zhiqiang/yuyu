package yuyu.common.biz.bzcommon;

import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import yuyu.app.bosyuu.hbsekmos.hbseihowebnenkinkaiyakuhrsuii.HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm;
import yuyu.common.sinkeiyaku.moschk.CheckSaiteiPTest_getSaiteiP;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 通貨変換処理のモッククラスです。<br />
 */
public class HenkanTuukaMockForSinkeiyaku extends HenkanTuuka {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    @Override
    public CurrencyType henkanTuukaKbnToType(C_Tuukasyu pTuukasyu) {

        if (caller == CheckSaiteiPTest_getSaiteiP.class){
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrencyTypes.YEN;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrencyTypes.DOLLAR;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizCurrencyTypes.AU_DOLLAR;
            }
        }
        if (caller == HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrencyTypes.YEN;
            }
        }
        return super.henkanTuukaKbnToType(pTuukasyu);
    }

    @Override
    public C_Tuukasyu henkanTuukaTypeToKbn(CurrencyType pCurrencyType) {

        return super.henkanTuukaTypeToKbn(pCurrencyType);
    }
}