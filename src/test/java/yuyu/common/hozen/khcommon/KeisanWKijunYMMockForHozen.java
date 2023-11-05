package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Kykjyoutai;

/**
 * {@link KeisanWKijunYM}のモッククラスです<br />
 */
public class KeisanWKijunYMMockForHozen  extends KeisanWKijunYM {
    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public BizDateYM exec(BizDate pKeiyakuYMD, BizDate pCalcKijyunYMD, BizDateYM pJikaipjutoYM,
        C_Hrkkaisuu pHrkkaisuu, C_Kykjyoutai pKykjyoutai, String pSyouhncd, BizDate pYendthnkymd) {

        if (caller == WSuiihyouNenkinTest_exec.class) {
            return super.exec(pKeiyakuYMD, pCalcKijyunYMD, pJikaipjutoYM, pHrkkaisuu, pKykjyoutai,pSyouhncd, pYendthnkymd);
        }
        return super.exec(pKeiyakuYMD, pCalcKijyunYMD, pJikaipjutoYM, pHrkkaisuu, pKykjyoutai,pSyouhncd, pYendthnkymd);
    }
}
