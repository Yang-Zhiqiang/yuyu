package yuyu.common.biz.bzcommon;

import jp.co.slcs.swak.util.string.ConvertUtil;

import org.apache.commons.validator.GenericValidator;

import yuyu.def.classification.C_Kojinhjn;

/**
 * 業務共通 共通 カナ名チェック
 */
public class CheckKanaNm {

    private static final String KANA = "アイウエオカキクケコサシスセソタチツテトナニヌネノハヒフヘホマミムメモヤユヨラリルレロワンガギグゲゴザジズゼゾダヂヅデドバビブベボヴパピプペポー";
    private static final String EISU = "１２３４５６７８９０ＡＢＣＤＥＦＧＨＩＪＫＬＭＮＯＰＱＲＳＴＵＶＷＸＹＺ";
    private static final String KIGO = "’　（）＋－，．／：？";

    public CheckKanaNm() {
        super();
    }

    public static boolean isCheckOK(String pKanaNm) {

        try {
            boolean kekka = true;

            kekka = chkZenkaku(pKanaNm);

            return kekka;
        }
        catch(Exception e) {
            return false;
        }
    }

    public static boolean isCheckOK(String pKanaNm, int pKeta) {

        try {
            boolean kekka = true;

            kekka = chkZenkaku(pKanaNm);

            String tmpHankaku = ConvertUtil.toHanAll(pKanaNm, 0, 0);

            if (tmpHankaku.length() > pKeta) {
                return false;
            }

            return kekka;
        }
        catch(Exception e) {
            return false;
        }
    }

    public static boolean isCheckOK(String pMeigininNmKana, C_Kojinhjn pKojinHoujinKbn, int pKeta) {

        try {
            String tmpZenkaku = null;
            String tmpHankaku = null;

            if (pMeigininNmKana == null || pMeigininNmKana.length() ==0) {
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

            if (C_Kojinhjn.KOJIN.eq(pKojinHoujinKbn)) {
                if (tmpZenkaku.length() < 2) {
                    return false;
                }
                if (GenericValidator.matchRegexp(tmpZenkaku, "　")) {
                    if (!GenericValidator.matchRegexp(tmpZenkaku, "^[^　]+　[^　]+$")) {
                        return false;
                    }
                }
            }
            tmpZenkaku = null;

            tmpHankaku = ConvertUtil.toHanAll(pMeigininNmKana, 0, 0);

            if (tmpHankaku.length() > pKeta) {
                return false;
            }
            tmpHankaku = null;

            return true;
        }
        catch(Exception e) {
            return false;
        }
    }

    private static boolean chkZenkaku(String pKanaNm) {

        String tmpZenkaku = null;

        if(pKanaNm == null || pKanaNm.length() ==0) {
            return false;
        }

        tmpZenkaku = ConvertUtil.toZenAll(pKanaNm, 1, 1);
        tmpZenkaku = ConvertUtil.fromZenKataKana(tmpZenkaku, 1);
        tmpZenkaku = ConvertUtil.toZenKataKana(tmpZenkaku);


        if (pKanaNm.length() != tmpZenkaku.length()) {
            return false;
        }

        if (GenericValidator.matchRegexp(tmpZenkaku, "[^" + KANA + EISU + KIGO + "]")) {
            return false;
        }

        return true;
    }
}
