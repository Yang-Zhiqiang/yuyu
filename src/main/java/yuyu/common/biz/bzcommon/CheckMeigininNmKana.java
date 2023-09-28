package yuyu.common.biz.bzcommon;

import jp.co.slcs.swak.util.string.ConvertUtil;

import org.apache.commons.validator.GenericValidator;

import yuyu.def.classification.C_Kojinhjn;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 業務共通 共通 カナ名義人チェック
 */
public class CheckMeigininNmKana {

    private static final String KANA             = "アイウエオカキクケコサシスセソタチツテトナニヌネノハヒフヘホマミムメモヤユヨラリルレロワンガギグゲゴザジズゼゾダヂヅデドバビブベボヴパピプペポ";
    private static final String EISU             = "１２３４５６７８９０ＡＢＣＤＥＦＧＨＩＪＫＬＭＮＯＰＱＲＳＴＵＶＷＸＹＺ";
    private static final String KIGO             = "’　（）＋－，．／：？";

    private static final String KANA_KOZA        = "ｱｲｳｴｵｶｷｸｹｺｻｼｽｾｿﾀﾁﾂﾃﾄﾅﾆﾇﾈﾉﾊﾋﾌﾍﾎﾏﾐﾑﾒﾓﾔﾕﾖﾗﾘﾙﾚﾛﾜﾝ";
    private static final String EISU_KOZA        = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DAKUTEN_KOZA     = "ﾞﾟ";
    private static final String KIGO_KOZA        = "()\\-\\. ";
    private static final String KIGO_GAIKAKOZA        = "/\\-?:()\\.,'+ ";

    private static final String KANA_KZHURI      = "ｱｲｳｴｵｶｷｸｹｺｻｼｽｾｿﾀﾁﾂﾃﾄﾅﾆﾇﾈﾉﾊﾋﾌﾍﾎﾏﾐﾑﾒﾓﾔﾕﾖﾗﾘﾙﾚﾛﾜﾝ";
    private static final String EISU_KZHURI      = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DAKUTEN_KZHURI   = "ﾞﾟ";
    private static final String KIGO_KZHURI      = " ()\\-\\./｢｣ｰ";

    private static final String KANA_FBSOUKIN    = "ｱｲｳｴｵｶｷｸｹｺｻｼｽｾｿﾀﾁﾂﾃﾄﾅﾆﾇﾈﾉﾊﾋﾌﾍﾎﾏﾐﾑﾒﾓﾔﾕﾖﾗﾘﾙﾚﾛﾜﾝ";
    private static final String EISU_FBSOUKIN    = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DAKUTEN_FBSOUKIN = "ﾞﾟ";
    private static final String KIGO_FBSOUKIN    = " ()\\-,\\./｢\\\\｣ｰ";

    public CheckMeigininNmKana() {
        super();
    }

    public static boolean isCheckOK(String pMeigininNmKana, C_Kojinhjn pKojinHoujinKbn) {

        return CheckMeigininNmKana.isPALCheckOK(pMeigininNmKana, pKojinHoujinKbn);

    }

    public static boolean isCheckOK(String pMeigininNmKana, C_Kojinhjn pKojinHoujinKbn, int pKeta) {

        if(!CheckMeigininNmKana.isPALCheckOK(pMeigininNmKana, pKojinHoujinKbn)){
            return false;
        }

        String tmpHankaku;

        tmpHankaku = ConvertUtil.toHanAll(pMeigininNmKana, 0, 0);
        if (tmpHankaku.length() > pKeta) {
            return false;
        }

        tmpHankaku = null;

        return true;
    }

    public static boolean isCheckOK(String pMeigininNmKana) {

        String tmpZenkaku;

        if (pMeigininNmKana == null || pMeigininNmKana.length() == 0) {
            return false;
        }

        tmpZenkaku = ConvertUtil.toZenAll(pMeigininNmKana, 1, 1);
        tmpZenkaku = ConvertUtil.fromZenKataKana(tmpZenkaku, 1);
        tmpZenkaku = ConvertUtil.toZenKataKana(tmpZenkaku);

        if (pMeigininNmKana.length() != tmpZenkaku.length()) {
            return false;
        }

        if (GenericValidator.matchRegexp(tmpZenkaku, "[^" + KANA + EISU + KIGO + "]")) {
            return false;
        }

        return true;
    }

    public static boolean isCheckOK_Koza(String pMeigininNmKana, C_Kojinhjn pKojinHoujinKbn) {

        String tmpHankaku;

        if (pMeigininNmKana == null || pMeigininNmKana.length() == 0) {
            return false;
        }

        tmpHankaku = ConvertUtil.toHanAll(pMeigininNmKana, 0, 0);

        if (GenericValidator.matchRegexp(tmpHankaku, "[^" + KANA_KOZA + EISU_KOZA + DAKUTEN_KOZA + KIGO_KOZA + "]")) {
            return false;
        }

        if (C_Kojinhjn.KOJIN.eq(pKojinHoujinKbn)) {
            if (tmpHankaku.length() < 2) {
                return false;
            }

            if (GenericValidator.matchRegexp(tmpHankaku, " ")) {
                if (!GenericValidator.matchRegexp(tmpHankaku, "^[^ ]+ [^ ]+$")) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean isCheckOK_Koza(String pMeigininNmKana, C_Kojinhjn pKojinHoujinKbn, int pKeta) {

        String tmpHankaku;

        if (pMeigininNmKana == null || pMeigininNmKana.length() == 0) {
            return false;
        }

        tmpHankaku = ConvertUtil.toHanAll(pMeigininNmKana, 0, 0);

        if (GenericValidator.matchRegexp(tmpHankaku, "[^" + KANA_KOZA + EISU_KOZA + DAKUTEN_KOZA + KIGO_KOZA + "]")) {
            return false;
        }

        if (C_Kojinhjn.KOJIN.eq(pKojinHoujinKbn)) {
            if (tmpHankaku.length() < 2) {
                return false;
            }

            if (GenericValidator.matchRegexp(tmpHankaku, " ")) {
                if (!GenericValidator.matchRegexp(tmpHankaku, "^[^ ]+ [^ ]+$")) {
                    return false;
                }
            }
        }

        if (tmpHankaku.length() > pKeta) {
            return false;
        }

        tmpHankaku = null;

        return true;
    }

    public static boolean isCheckOK_Kzhuri(String pMeigininNmKana, C_Kojinhjn pKojinHoujinKbn) {

        String tmpHankaku;

        if (pMeigininNmKana == null || pMeigininNmKana.length() == 0) {
            return false;
        }

        tmpHankaku = ConvertUtil.toHanAll(pMeigininNmKana, 0, 1);

        boolean bKekka = checkKyokaMoji(tmpHankaku, pKojinHoujinKbn);
        if (!bKekka) {
            return false;
        }

        return true;
    }

    public static boolean isCheckOK_Kzhuri(String pMeigininNmKana, C_Kojinhjn pKojinHoujinKbn, int pKeta) {

        String tmpHankaku;

        if (pMeigininNmKana == null || pMeigininNmKana.length() == 0) {
            return false;
        }

        tmpHankaku = ConvertUtil.toHanAll(pMeigininNmKana, 0, 1);

        boolean bKekka = checkKyokaMoji(tmpHankaku, pKojinHoujinKbn);
        if (!bKekka) {
            return false;
        }

        if (tmpHankaku.length() > pKeta) {
            return false;
        }

        tmpHankaku = null;

        return true;
    }

    public static boolean isCheckOK_FBSoukin(String pMeigininNmKana) {
        String tmpHankaku;

        if (pMeigininNmKana == null || pMeigininNmKana.length() == 0) {
            return false;
        }

        tmpHankaku = ConvertUtil.toHanAll(pMeigininNmKana, 0, 1);

        if (GenericValidator.matchRegexp(tmpHankaku, "[^" + KANA_FBSOUKIN + EISU_FBSOUKIN + DAKUTEN_FBSOUKIN + KIGO_FBSOUKIN + "]")) {
            return false;
        }

        return true;
    }

    public static boolean isCheckOK_FBSoukin(String pMeigininNmKana, int pKeta) {
        String tmpHankaku;

        if (pMeigininNmKana == null || pMeigininNmKana.length() == 0) {
            return false;
        }

        tmpHankaku = ConvertUtil.toHanAll(pMeigininNmKana, 0, 1);

        if (GenericValidator.matchRegexp(tmpHankaku, "[^" + KANA_FBSOUKIN + EISU_FBSOUKIN + DAKUTEN_FBSOUKIN + KIGO_FBSOUKIN + "]")) {
            return false;
        }

        if (tmpHankaku.length() > pKeta) {
            return false;
        }

        tmpHankaku = null;

        return true;
    }

    public static boolean isCheckOK_Tuuka(String pKzMeigininNm, C_Tuukasyu pTuukasyu) {
        String tmp;

        if (pKzMeigininNm == null || pKzMeigininNm.length() == 0) {
            return false;
        }

        tmp = ConvertUtil.toHanAll(pKzMeigininNm, 0, 0);

        String checkMoji = "";

        if (C_Tuukasyu.JPY.eq(pTuukasyu)) {

            checkMoji = KANA_KOZA + EISU_KOZA + DAKUTEN_KOZA + KIGO_KOZA;

        }
        else {

            checkMoji = EISU_KOZA + KIGO_GAIKAKOZA;
        }

        if (GenericValidator.matchRegexp(tmp, "[^" + checkMoji + "]")) {

            return false;

        }
        return true;
    }

    private static boolean checkKyokaMoji(String pMeigininNmKana, C_Kojinhjn pKojinHoujinKbn) {

        if (GenericValidator.matchRegexp(pMeigininNmKana, "[^" + KANA_KZHURI + EISU_KZHURI + DAKUTEN_KZHURI + KIGO_KZHURI + "]")) {
            return false;
        }

        if (C_Kojinhjn.KOJIN.eq(pKojinHoujinKbn)) {
            if (pMeigininNmKana.length() < 2) {
                return false;
            }

            if (GenericValidator.matchRegexp(pMeigininNmKana, "  ")) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPALCheckOK(String pMeigininNmKana, C_Kojinhjn pKojinHoujinKbn) {

        if (pMeigininNmKana == null || pMeigininNmKana.length() == 0) {
            return true;
        }

        String sMeigininNmKana = pMeigininNmKana;

        sMeigininNmKana = ConvertUtil.toZenAll(sMeigininNmKana, 1, 1);
        sMeigininNmKana = ConvertUtil.fromZenKataKana(sMeigininNmKana, 0);
        sMeigininNmKana = ConvertUtil.toZenKataKana(sMeigininNmKana);

        if (pMeigininNmKana.length() != sMeigininNmKana.length()) {
            return false;
        }

        if(GenericValidator.matchRegexp(sMeigininNmKana, "．")){
            sMeigininNmKana = sMeigininNmKana.replaceAll("．", "　");
        }

        if (!C_Kojinhjn.HJN.eq(pKojinHoujinKbn)) {
            if (GenericValidator.matchRegexp(sMeigininNmKana, "[^" + KANA + "－" + "　" + "]")) {
                return false;
            }

            if (GenericValidator.matchRegexp(sMeigininNmKana, "^－")) {
                return false;
            }

            if(sMeigininNmKana.length() < 2){
                return false;
            }

            if (!GenericValidator.matchRegexp(sMeigininNmKana, "^[^　]*　[^　]*$")) {
                return false;
            }

            if (GenericValidator.matchRegexp(sMeigininNmKana, "ンン|ン－|－－|　ン|　－")) {
                return false;
            }

        }

        return true;

    }

}
