package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import yuyu.common.bosyuu.hbkeiyakusyoukai.HbKeiyakuSyoukaiTest_exec;
import yuyu.common.hozen.setuibean.SetHosyouTest_exec;
import yuyu.common.siharai.sicommon.CalcHkShrKngkTest_exec;
import yuyu.common.siharai.sicommon.GetSibouymdWTest_exec;
import yuyu.common.suuri.srcommon.SrSinkykSeirituKoumokuCommonSetTest_exec;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Kykjyoutai;

/**
 * {@link KeisanWKijunYM}のモッククラスです<br />
 */
public class KeisanWKijunYMMock  extends KeisanWKijunYM {
    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public BizDateYM exec(BizDate pKeiyakuYMD, BizDate pCalcKijyunYMD, BizDateYM pJikaipjutoYM,
        C_Hrkkaisuu pHrkkaisuu, C_Kykjyoutai pKykjyoutai, String pSyouhncd, BizDate pYendthnkymd) {

        if (caller == CalcHkShrKngkTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return BizDateYM.valueOf("202002");
        }
        else if (caller == CalcHkShrKngkTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            return BizDateYM.valueOf("203002");
        }
        else if (caller == CalcHkShrKngkTest_exec.class && TESTPATTERN3.equals(SYORIPTN)) {
            return BizDateYM.valueOf("204002");
        }
        else if (caller == HbKeiyakuSyoukaiTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return BizDateYM.valueOf("201708");
        }
        else if (caller == SrSinkykSeirituKoumokuCommonSetTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return BizDateYM.valueOf("201803");
        }
        else if (caller == KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class && TESTPATTERN1.equals(SYORIPTN)) {
            return BizDateYM.valueOf("202002");
        }
        else if (caller == KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class && TESTPATTERN2.equals(SYORIPTN)) {
            return BizDateYM.valueOf("203002");
        }
        else if (caller == KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class && TESTPATTERN3.equals(SYORIPTN)) {
            return BizDateYM.valueOf("204002");
        }
        else if (caller == KeisanWItijiTest_exec.class && TESTPATTERN1.equals(SYORIPTN)){
            return BizDateYM.valueOf("201805");
        }
        else if (caller == WSuiihyouTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizDateYM.valueOf("201901");
            }
            else {
                return BizDateYM.valueOf("201901");
            }
        }
        else if (caller == GetSibouymdWTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return BizDateYM.valueOf("202003");
        }
        else if (caller == SetHosyouTest_exec.class && TESTPATTERN1.equals(SYORIPTN)){
            return BizDateYM.valueOf("201906");
        }
        else {
            return super.exec(pKeiyakuYMD, pCalcKijyunYMD, pJikaipjutoYM, pHrkkaisuu, pKykjyoutai,pSyouhncd, pYendthnkymd);
        }
    }
}
