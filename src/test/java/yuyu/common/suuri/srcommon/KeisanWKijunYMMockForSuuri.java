package yuyu.common.suuri.srcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import yuyu.common.hozen.khcommon.KeisanWKijunYM;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Kykjyoutai;

/**
 * {@link KeisanWKijunYM}のモッククラスです<br />
 */
public class KeisanWKijunYMMockForSuuri  extends KeisanWKijunYM {
    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public BizDateYM exec(BizDate pKeiyakuYMD, BizDate pCalcKijyunYMD, BizDateYM pJikaipjutoYM,
        C_Hrkkaisuu pHrkkaisuu, C_Kykjyoutai pKykjyoutai, String pSyouhncd, BizDate pYendthnkymd) {

        if (caller == SrSinkykSeirituKoumokuCommonSetTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizDateYM.valueOf("201803");
            }
        }
        return super.exec(pKeiyakuYMD, pCalcKijyunYMD, pJikaipjutoYM, pHrkkaisuu, pKykjyoutai,pSyouhncd, pYendthnkymd);
    }
}
