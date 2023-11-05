package yuyu.common.biz.bzcommon;

import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import yuyu.app.bosyuu.hbsekmos.hbseihowebnenkinkaiyakuhrsuii.HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm;
import yuyu.common.hozen.khcommon.EditKykNaiyouOsirase3Test_editInfo;
import yuyu.common.hozen.khcommon.EditSeihowebIdouRirekiTblTest_exec;
import yuyu.common.hozen.khcommon.GetKhTuusanyouKngkTest_getAlltsnkngk;
import yuyu.common.hozen.khcommon.GetKhTuusanyouKngkTest_getTsnyouTuukasyu;
import yuyu.common.hozen.khcommon.GetKhTuusanyouKngkTest_getTsnyouItijip;
import yuyu.common.hozen.khcommon.GetKhTuusanyouKngkTest_getTsnyouNkgns;
import yuyu.common.hozen.khcommon.GetKhTuusanyouKngkTest_getTsnyouSibous;
import yuyu.common.hozen.khcommon.KeisanCommonKaiyakuTest_keisanKaiyakuseisankin;
import yuyu.common.sinkeiyaku.moschk.CheckSPTest_exec;
import yuyu.common.sinkeiyaku.moschk.CheckSaiteiPTest_getSaiteiP;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 通貨変換処理のモッククラスです。<br />
 */
public class HenkanTuukaMock extends HenkanTuuka {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    @Override
    public CurrencyType henkanTuukaKbnToType(C_Tuukasyu pTuukasyu) {
        if (caller == HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN1.equals(SYORIPTN)) {
            return BizCurrencyTypes.YEN;
        }

        if ( caller == CheckSaiteiPTest_getSaiteiP.class && TESTPATTERN1.equals(SYORIPTN)) {
            return BizCurrencyTypes.YEN;
        }
        else if ( caller == CheckSaiteiPTest_getSaiteiP.class && TESTPATTERN2.equals(SYORIPTN)) {
            return BizCurrencyTypes.DOLLAR;
        }
        else if ( caller == CheckSaiteiPTest_getSaiteiP.class && TESTPATTERN3.equals(SYORIPTN)) {
            return BizCurrencyTypes.AU_DOLLAR;
        }
        else if (caller == GetKhTuusanyouKngkTest_getAlltsnkngk.class && TESTPATTERN1.equals(SYORIPTN)) {
            return BizCurrencyTypes.YEN;
        }
        else if (caller == GetKhTuusanyouKngkTest_getTsnyouTuukasyu.class && TESTPATTERN1.equals(SYORIPTN)) {
            return BizCurrencyTypes.YEN;
        }
        else if (caller == GetKhTuusanyouKngkTest_getTsnyouSibous.class && TESTPATTERN1.equals(SYORIPTN)) {
            return BizCurrencyTypes.YEN;
        }
        else if (caller == GetKhTuusanyouKngkTest_getTsnyouItijip.class && TESTPATTERN1.equals(SYORIPTN)) {
            return BizCurrencyTypes.YEN;
        }
        else if (caller == GetKhTuusanyouKngkTest_getTsnyouNkgns.class && TESTPATTERN1.equals(SYORIPTN)) {
            return BizCurrencyTypes.YEN;
        }

        if (caller == KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class && TESTPATTERN1.equals(SYORIPTN)) {
            return BizCurrencyTypes.YEN;
        }

        if (caller == EditKykNaiyouOsirase3Test_editInfo.class && TESTPATTERN1.equals(SYORIPTN)) {
            return BizCurrencyTypes.YEN;
        }

        return super.henkanTuukaKbnToType(pTuukasyu);
    }

    @Override
    public C_Tuukasyu henkanTuukaTypeToKbn(CurrencyType pCurrencyType) {

        C_Tuukasyu tuukaSyu = null;

        if (caller == CheckSPTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {

            tuukaSyu = C_Tuukasyu.USD;

            return tuukaSyu;
        }

        if (caller == EditSeihowebIdouRirekiTblTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                tuukaSyu = C_Tuukasyu.USD;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                tuukaSyu = C_Tuukasyu.JPY;
            }
            return tuukaSyu;
        }
        return super.henkanTuukaTypeToKbn(pCurrencyType);
    }
}