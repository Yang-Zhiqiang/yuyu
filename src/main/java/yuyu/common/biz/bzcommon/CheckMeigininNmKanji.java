package yuyu.common.biz.bzcommon;

import org.apache.commons.validator.GenericValidator;

import yuyu.def.classification.C_Kojinhjn;

/**
 * 業務共通 共通 漢字名義人チェック
 */
public class CheckMeigininNmKanji {
    private static final int MIN_LENGTH = 2;
    private static final String ONE_BLANK = "^[^　]*　[^　]*$";

    public CheckMeigininNmKanji() {
        super();
    }

    public static boolean isCheckOK(String pMeigininNmKanji, C_Kojinhjn pKojinHoujinKbn) {
        if(pMeigininNmKanji == null || pMeigininNmKanji.length() == 0){
            return true;
        }

        if(!C_Kojinhjn.HJN.eq(pKojinHoujinKbn)){

            if(pMeigininNmKanji.length() < MIN_LENGTH){
                return false;
            }
            if(!GenericValidator.matchRegexp(pMeigininNmKanji, ONE_BLANK)){
                return false;
            }
        }

        return true;
    }
}
