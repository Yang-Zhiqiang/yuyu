package yuyu.common.biz.report;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_NengetuKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.AM_SyoruiZokusei;

/**
 * 業務共通 帳票出力 帳票表示用の各種データ編集クラス
 */
public class ViewReport {

    private static final String HANKAKU_SPACE = " ";

    private static final String ZENKAKU_SPACE = "　";

    private static final String NEN = "年";

    private static final String KEN = "件";

    private static final String EN = "円";

    private static final String KAI= "回";

    private static final String SAMA = "様";

    private static final String KATAKANA_SAMA = "サマ";

    private static final String ONTYUU = "御中";

    public static String getHozonKknTani(C_SyoruiCdKbn pSyoruiCdKbn) {

        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        AM_SyoruiZokusei syorui = baseDomManager.getSyoruiZokusei(pSyoruiCdKbn);

        return getHozonKknTani(syorui);
    }

    public static String getHozonKknTani(AM_SyoruiZokusei pZokusei) {

        String hozonKkn = String.valueOf(pZokusei.getHozonKikan());

        C_NengetuKbn nengetuKbn = pZokusei.getNengetukbn();

        if ("0".equals(hozonKkn)) {

            hozonKkn = "";
        }
        else if ("99".equals(hozonKkn)) {

            hozonKkn = "永久";
        }
        else {

            if (C_NengetuKbn.NEN.eq(nengetuKbn)) {

                hozonKkn = hozonKkn + " 年";
            }
            else if (C_NengetuKbn.TUKI.eq(nengetuKbn)) {

                hozonKkn = hozonKkn + "ヵ月";
            }
        }
        return hozonKkn;
    }

    public static String editCommaTuuka(BizCurrency pValue, int piDecimalPartType, int piDecimalPartDigit) {

        if (pValue == null) {
            return null;
        }

        String str = BizUtil.comma(pValue.toString(), piDecimalPartType, piDecimalPartDigit);

        String result = editHankakuKuhakuTaniHuyo(str, pValue.getType().getUnitValue());

        return result;
    }

    public static String editCommaTuuka(BizCurrency pValue, int piDecimalPartType) {

        if (pValue == null) {
            return null;
        }

        String strKingaku = pValue.toString();

        CurrencyType ctTuukataipu = pValue.getType();

        String tani = ctTuukataipu.getUnitValue();

        int decimalPartDigit;

        if (EN.equals(tani)) {
            decimalPartDigit = 0;
        }
        else {
            decimalPartDigit = 2;
        }

        String str = BizUtil.comma(strKingaku, piDecimalPartType, decimalPartDigit);

        String result = editHankakuKuhakuTaniHuyo(str, tani);

        return result;
    }

    public static String editCommaKen(String pValue) {

        if (pValue == null) {
            return null;
        }

        String str = editHankakuKuhakuTaniHuyo(BizUtil.comma(pValue), KEN);

        return str;
    }

    public static String editSama(String pValue) {

        if (pValue == null) {
            return null;
        }
        String str = editZenkakuKuhakuTaniHuyo(pValue, SAMA);

        return str;
    }

    public static String editSamaKana(String pValue) {

        if (pValue == null) {
            return null;
        }
        String str = editZenkakuKuhakuTaniHuyo(pValue, KATAKANA_SAMA);

        return str;

    }

    public static String editOntyuu(String pValue) {

        if (pValue == null) {
            return null;
        }
        String str = editZenkakuKuhakuTaniHuyo(pValue, ONTYUU);

        return str;

    }

    public static String editNen(String pValue) {

        if (pValue == null) {
            return null;
        }

        String str = editHankakuKuhakuTaniHuyo(pValue, NEN);

        return str;
    }

    public static String editKen(String pValue) {

        if (pValue == null) {
            return null;
        }

        String str = editHankakuKuhakuTaniHuyo(pValue, KEN);

        return str;
    }

    public static String editEn(String pValue) {

        if (pValue == null) {
            return null;
        }

        String str = editHankakuKuhakuTaniHuyo(pValue, EN);

        return str;
    }

    public static String editKai(String pValue) {

        if (pValue == null) {
            return null;
        }
        String str = editHankakuKuhakuTaniHuyo(pValue, KAI);

        return str;
    }

    public static String editKaigyoSama(String pValue) {

        if (pValue == null) {
            return null;
        }

        String str = BizUtil.editMojiretu(pValue, 16);

        str = editSama(str);

        return str;
    }

    public static String[] editAdrDisp(int pLength, String pAdr1, String pAdr2, String pAdr3) {

        String[] result = new String[3];

        if ((pLength != 0) &&
                ((!BizUtil.isBlank(pAdr1) && pLength < pAdr1.length()) ||
                        (!BizUtil.isBlank(pAdr2) && pLength < pAdr2.length()) ||
                        (!BizUtil.isBlank(pAdr3) && pLength < pAdr3.length()))) {
            StringBuffer sbAdr = new StringBuffer();

            if (!BizUtil.isBlank(pAdr1)) {
                sbAdr.append(pAdr1);
            }
            if (!BizUtil.isBlank(pAdr2)) {
                sbAdr.append(pAdr2);
            }
            if (!BizUtil.isBlank(pAdr3)) {
                sbAdr.append(pAdr3);
            }

            String[] sAdr = BizUtil.splitLineSeparator(sbAdr.toString(), pLength, false);

            result[0] = sAdr[0];
            result[1] = sAdr[1];
            if (sAdr.length > 2) {
                result[2] = sAdr[2];
            }
        }
        else {
            result[0] = pAdr1;
            result[1] = pAdr2;
            result[2] = pAdr3;
        }

        return result;

    }

    public static String editCommaTuukaNoSpace(BizCurrency pValue, int piDecimalPartType, int piDecimalPartDigit) {

        if (pValue == null) {
            return null;
        }

        String str = BizUtil.comma(pValue.toString(), piDecimalPartType, piDecimalPartDigit);

        String result = editTaniHuyo(str, pValue.getType().getUnitValue());

        return result;
    }

    public static String editCommaTuukaNoSpace(BizCurrency pValue, int piDecimalPartType) {

        if (pValue == null) {
            return null;
        }

        String strKingaku = pValue.toString();

        CurrencyType ctTuukataipu = pValue.getType();

        String tani = ctTuukataipu.getUnitValue();

        int decimalPartDigit;

        if (EN.equals(tani)) {
            decimalPartDigit = 0;
        }
        else {
            decimalPartDigit = 2;
        }

        String str = BizUtil.comma(strKingaku, piDecimalPartType, decimalPartDigit);

        String result = editTaniHuyo(str, tani);

        return result;
    }


    private static String editHankakuKuhakuTaniHuyo(String pValue, String pUnit) {

        StringBuffer sbValue = new StringBuffer();

        sbValue.append(pValue);
        sbValue.append(HANKAKU_SPACE);
        sbValue.append(pUnit);

        return sbValue.toString();
    }


    private static String editZenkakuKuhakuTaniHuyo(String pValue, String pUnit) {

        StringBuffer sbValue = new StringBuffer();

        sbValue.append(pValue);
        sbValue.append(ZENKAKU_SPACE);
        sbValue.append(pUnit);

        return sbValue.toString();
    }


    private static String editTaniHuyo(String pValue, String pUnit) {

        StringBuffer sbValue = new StringBuffer();

        sbValue.append(pValue);
        sbValue.append(pUnit);

        return sbValue.toString();
    }

}
