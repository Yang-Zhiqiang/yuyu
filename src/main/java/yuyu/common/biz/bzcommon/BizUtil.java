package yuyu.common.biz.bzcommon;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Vector;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.classification.Classification;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.util.string.StringUtil;
import yuyu.def.MessageId;

import com.google.common.base.Strings;

/**
 * 業務汎用ユーティリティクラスです。
 */
public class BizUtil {

    private static final String CHAR_SET = "SHIFT_JIS";

    private static final String SYONOKETASUU = "11";

    private static final String MOSNOKETASUU = "9";

    public static final int ZERO_FILL = 0;

    public static final int NON_ZERO_FILL = 1;

    public static final int ZERO_FILL_LAST_ONLY = 2;

    public static final int KETASUU_CHECK_ERROR = 1;
    public static final int DECIMAL_KETASUU_ROUND = 0;

    public static final String KAIGYOU_CR = "\r";
    public static final String KAIGYOU_CRLF = "\r\n";
    public static final String KAIGYOU_LF = "\n";
    public static final String KAIGYOU_ETC = "";

    public static String zero2blank(String psValue) {
        if (Strings.isNullOrEmpty(psValue)) {
            return "";
        }
        else {
            try {
                long lTmp = Long.parseLong(psValue);
                if (lTmp == 0) {
                    return "";
                }
                else {
                    return psValue;
                }
            } catch (Exception eExp) {
                return psValue;
            }
        }
    }

    public static String blank2zero(String psValue) {
        if (psValue == null) {
            throw new BizAppException(MessageId.EHS0008, "不明");
        }
        else if (psValue.length() == 0) {
            return "0";
        }
        else {
            return psValue;
        }
    }

    public static String blank2zero(BizNumber pbdValue) {
        if (pbdValue == null) {
            throw new BizAppException(MessageId.EHS0008, "不明");
        }
        else if (pbdValue.toString().length() == 0) {
            return "0";
        }
        else {
            return pbdValue.toString();
        }
    }

    public static boolean isBlank(String psValue) {
        if (Strings.isNullOrEmpty(psValue) || StringUtil.lrTrim(psValue).length() == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public static int getSJISLen_From_Unicode(String psValue) throws Exception {
        if (Strings.isNullOrEmpty(psValue)) {
            return 0;
        }
        byte[] btConvs = psValue.getBytes(CHAR_SET);
        return btConvs.length;
    }

    public static long getSJISLen_From_Unicode(char pcValue) throws Exception {
        byte[] btConvs = String.valueOf(pcValue).getBytes(CHAR_SET);
        return btConvs.length;
    }

    public static String getSJISEdit(String psValue, long plByte) {
        long lLen_Tmp = 0;

        if (psValue == null || plByte == 0) {
            return "";
        }
        try {
            lLen_Tmp = getSJISLen_From_Unicode(psValue);
        } catch (Exception eExp) {
            return "";
        }
        if (plByte >= lLen_Tmp) {
            return psValue;
        }
        int iLen_Org = psValue.length();
        int iPos_Org = 0;
        char cPos_Org;
        long lLen_SJIS = 0;
        StringBuffer sbSjis = new StringBuffer();
        while (iPos_Org < iLen_Org) {
            cPos_Org = psValue.charAt(iPos_Org);
            try {
                lLen_Tmp = getSJISLen_From_Unicode(cPos_Org);
            } catch (Exception eExp) {
                lLen_Tmp = 0;
            }
            lLen_SJIS = lLen_SJIS + lLen_Tmp;
            if (lLen_SJIS > plByte) {
                break;
            }
            if (lLen_Tmp > 0) {
                sbSjis.append(cPos_Org);
            }
            iPos_Org++;
        }
        return sbSjis.toString();
    }

    public static String editMask(String psEditWord, int piStart, int piMjsuu, char pcMaskmj) {
        if (Strings.isNullOrEmpty(psEditWord)) {
            return psEditWord;
        }
        if (psEditWord.length() < piStart + piMjsuu) {
            return psEditWord;
        }

        String sFirstmjrt = "";
        String sLastmjrt = "";
        char[] cMaskmjrts = new char[piMjsuu];

        sFirstmjrt = psEditWord.substring(0, piStart);
        sLastmjrt = psEditWord.substring(piStart + piMjsuu);
        for (int iI = 0; iI < piMjsuu; iI++) {
            cMaskmjrts[iI] = pcMaskmj;
        }
        return sFirstmjrt + (new String(cMaskmjrts)) + sLastmjrt;
    }

    public static String editMask(String psEditWord, int piMjsuu, char pcMaskmj) {
        if (Strings.isNullOrEmpty(psEditWord) || piMjsuu <= 0) {
            return psEditWord;
        }

        int iLength = psEditWord.length();

        int iMjsuu = piMjsuu;

        if (iMjsuu > iLength) {
            iMjsuu = iLength;
        }

        char[] cMaskmjrts = new char[iMjsuu];

        for (int iI = 0; iI < iMjsuu; iI++) {
            cMaskmjrts[iI] = pcMaskmj;
        }

        String sFirstmjrt = psEditWord.substring(0, iLength - iMjsuu);

        return sFirstmjrt.concat(new String(cMaskmjrts));
    }

    public static String editMojiretu(String psBikou, int piLength) {

        String sLineSeparator = System.getProperty("line.separator");

        StringBuffer sbValue = new StringBuffer();

        if (Strings.isNullOrEmpty(psBikou)) {
            return "";
        }
        if (piLength == 0) {
            return psBikou;
        }

        String[] sResults = splitLineSeparator(psBikou, piLength, true);
        for (int iI = 0; iI < sResults.length; iI++) {
            sbValue.append(sResults[iI]);
            if (iI < sResults.length - 1) {
                sbValue.append(sLineSeparator);
            }
        }

        return sbValue.toString();
    }

    public static String editYno(String psValue) {
        if (BizUtil.isBlank(psValue) || 3 >= psValue.length()) {
            return psValue;
        }

        StringBuffer sbYno = new StringBuffer();
        sbYno.append(psValue.substring(0, 3));
        sbYno.append("-");
        sbYno.append(psValue.substring(3));

        return sbYno.toString();
    }

    public static String editSyoNoSpace_3_4_4(String psValue) {

        if (BizUtil.isBlank(psValue) || Integer.parseInt(SYONOKETASUU) != psValue.length()) {
            return psValue;
        }

        StringBuffer sbSyono = new StringBuffer();
        sbSyono.append(psValue.substring(0, 3));
        sbSyono.append(" ");
        sbSyono.append(psValue.substring(3, 7));
        sbSyono.append(" ");
        sbSyono.append(psValue.substring(7));

        return sbSyono.toString();
    }

    public static String editSyoNo(String psValue) {

        if (BizUtil.isBlank(psValue) || Integer.parseInt(SYONOKETASUU) != psValue.length()) {
            return psValue;
        }

        StringBuffer sbSyono = new StringBuffer();
        sbSyono.append(psValue.substring(0, 2));
        sbSyono.append(" ");
        sbSyono.append(psValue.substring(2, 5));
        sbSyono.append(" ");
        sbSyono.append(psValue.substring(5, 10));
        sbSyono.append(" ");
        sbSyono.append(psValue.substring(10));

        return sbSyono.toString();
    }

    public static String editMosNo(String psValue) {

        if (BizUtil.isBlank(psValue) || Integer.parseInt(MOSNOKETASUU) != psValue.length()) {
            return psValue;
        }

        StringBuffer sbMosno = new StringBuffer();
        sbMosno.append(psValue.substring(0, 3));
        sbMosno.append(" ");
        sbMosno.append(psValue.substring(3, 6));
        sbMosno.append(" ");
        sbMosno.append(psValue.substring(6));

        return sbMosno.toString();
    }

    public static String comma(String psSrc) {
        double dVal;
        DecimalFormat df;
        StringBuffer sbResult;
        StringBuffer sbPattern;

        sbResult = new StringBuffer();
        sbPattern = new StringBuffer();


        sbPattern.append("#,###");


        dVal = Double.parseDouble(psSrc);

        df = new DecimalFormat(sbPattern.toString());
        sbResult.append(df.format(dVal));

        return sbResult.toString();

    }

    public static String comma(String psSrc, int piDecimalPartType, int piDecimalPartDigit) {
        double dVal;
        DecimalFormat df;
        StringBuffer sbResult;
        StringBuffer sbPattern;
        String sDecPattern = null;

        sbResult = new StringBuffer();
        sbPattern = new StringBuffer();

        if (piDecimalPartDigit >= 40) {
            throw new BizAppException(MessageId.EBA0023, "入力桁数");
        }

        switch (piDecimalPartType) {
            case ZERO_FILL:
                sDecPattern = "0";
                break;

            case ZERO_FILL_LAST_ONLY:
            case NON_ZERO_FILL:
                sDecPattern = "#";
                break;
            default:
                throw new BizAppException(MessageId.EBA0023, "引数");
        }


        sbPattern.append("#,##0");

        if (piDecimalPartDigit > 0) {
            sbPattern.append(".");
            for (int i = 0; i < piDecimalPartDigit; i++) {
                sbPattern.append(sDecPattern);
            }
        }


        dVal = Double.parseDouble(psSrc);

        df = new DecimalFormat(sbPattern.toString());
        sbResult.append(df.format(dVal));

        return sbResult.toString();

    }

    public static String num(String psSrc,
        int piIntegralPartType,
        int piIntegralPartDigit) {

        int i;
        int iLen;
        double dVal;
        DecimalFormat df;
        StringBuffer sbResult;
        StringBuffer sbPattern;
        String sIntPattern = null;
        String sIntPatternLast = null;

        sbResult = new StringBuffer();
        sbPattern = new StringBuffer();

        BigDecimal bdCastValue = null;

        switch (piIntegralPartType) {
            case ZERO_FILL:
                sIntPattern = "0";
                sIntPatternLast = "0";
                break;

            case ZERO_FILL_LAST_ONLY:
                sIntPattern = "#";
                sIntPatternLast = "0";
                break;

            case NON_ZERO_FILL:
                sIntPattern = "#";
                sIntPatternLast = "#";
                break;

            default:
                throw new BizAppException(MessageId.EBA0023, "引数");
        }


        if (piIntegralPartDigit > 0) {
            iLen = piIntegralPartDigit - 1;
            for (i = 0; i < iLen; i++) {
                sbPattern.append(sIntPattern);
            }
            sbPattern.append(sIntPatternLast);
        }

        bdCastValue = new BigDecimal(psSrc);
        bdCastValue = bdCastValue.setScale(0, BigDecimal.ROUND_HALF_UP);
        dVal = Double.parseDouble(bdCastValue.toString());


        df = new DecimalFormat(sbPattern.toString());
        sbResult.append(df.format(dVal));

        return sbResult.toString();
    }

    public static String num(String psSrc,
        int piIntegralPartType,
        int piIntegralPartDigit,
        int piDecimalPartType,
        int piDecimalPartDigit) {

        return num(psSrc,
            piIntegralPartType,
            piIntegralPartDigit,
            piDecimalPartType,
            piDecimalPartDigit,
            KETASUU_CHECK_ERROR);
    }

    public static String num(String psSrc,
        int piIntegralPartType,
        int piIntegralPartDigit,
        int piDecimalPartType,
        int piDecimalPartDigit,
        int piDecimalKetasuuCheck) {

        int i;
        int iLen;
        double dVal;
        DecimalFormat df;
        StringBuffer sbResult;
        StringBuffer sbPattern;
        String sIntPattern = null;
        String sIntPatternLast = null;
        String sDecPattern = null;

        sbResult = new StringBuffer();
        sbPattern = new StringBuffer();

        BigDecimal bdCastValue = null;
        BigDecimal bdAbsValue = null;
        String sCastValue = null;
        int iIntegerLength = 0;
        int iDecimalLength = 0;

        if (piDecimalPartDigit >= 40) {
            throw new BizAppException(MessageId.EBA0023, "入力桁数");
        }

        bdCastValue = new BigDecimal(psSrc);

        iDecimalLength = bdCastValue.scale();

        bdAbsValue = bdCastValue.abs();

        sCastValue = bdAbsValue.toString();

        if (iDecimalLength != 0) {
            iIntegerLength = (sCastValue.length() - iDecimalLength) - 1;
        }
        else {
            iIntegerLength = sCastValue.length();
        }

        if (iIntegerLength > piIntegralPartDigit) {
            if (piDecimalKetasuuCheck == KETASUU_CHECK_ERROR) {
                throw new BizAppException(MessageId.EBA0023, "入力桁数");
            }
        }

        if (iDecimalLength > piDecimalPartDigit) {
            if (piDecimalKetasuuCheck == KETASUU_CHECK_ERROR) {
                throw new BizAppException(MessageId.EBA0023, "入力桁数");
            }
            bdCastValue = bdCastValue.setScale(piDecimalPartDigit, BigDecimal.ROUND_HALF_UP);
            dVal = Double.parseDouble(bdCastValue.toString());
        }
        else {
            dVal = Double.parseDouble(bdCastValue.toString());
        }

        switch (piIntegralPartType) {
            case ZERO_FILL:
                sIntPattern = "0";
                sIntPatternLast = "0";
                break;

            case ZERO_FILL_LAST_ONLY:
                sIntPattern = "#";
                sIntPatternLast = "0";
                break;

            case NON_ZERO_FILL:
                sIntPattern = "#";
                sIntPatternLast = "#";
                break;

            default:
                throw new BizAppException(MessageId.EBA0023, "引数");
        }

        switch (piDecimalPartType) {
            case ZERO_FILL:
                sDecPattern = "0";
                break;

            case ZERO_FILL_LAST_ONLY:
            case NON_ZERO_FILL:
                sDecPattern = "#";
                break;
            default:
                throw new BizAppException(MessageId.EBA0023, "引数");
        }


        if (piIntegralPartDigit > 0) {
            iLen = piIntegralPartDigit - 1;
            for (i = 0; i < iLen; i++) {
                sbPattern.append(sIntPattern);
            }
            sbPattern.append(sIntPatternLast);
        }

        if (piDecimalPartDigit > 0) {
            sbPattern.append(".");
            iLen = piDecimalPartDigit;
            for (i = 0; i < iLen; i++) {
                sbPattern.append(sDecPattern);
            }
        }


        df = new DecimalFormat(sbPattern.toString());
        sbResult.append(df.format(dVal));

        return sbResult.toString();

    }

    public static String[] splitLineSeparator(String psVal, int piLength, boolean bFlg) {
        String sSeparator;

        if (piLength < 1) {
            throw new BizAppException(MessageId.EBA0023, "最大文字数の指定");
        }
        if (psVal.indexOf(KAIGYOU_CRLF) != -1) {
            sSeparator = KAIGYOU_CRLF;
        }
        else if (psVal.indexOf(KAIGYOU_CR) != -1) {
            sSeparator = KAIGYOU_CR;
        }
        else if (psVal.indexOf(KAIGYOU_LF) != -1) {
            sSeparator = KAIGYOU_LF;
        } else {
            sSeparator = KAIGYOU_ETC;
        }

        int iLen_w = sSeparator.length();
        int iLen_a = psVal.length();
        int iIdx = 0;
        int iCtr = 0;
        String st = new String(psVal);
        Vector<String> v = new Vector<String>();

        while (iCtr < iLen_a) {
            iIdx = st.indexOf(sSeparator, iCtr);

            if (iIdx != -1 && iLen_w > 0) {

                if (iCtr < iIdx - piLength) {
                    v.add(st.substring(iCtr, iCtr + piLength));
                    iCtr = iCtr + piLength;
                }
                else if (iCtr == iIdx - piLength) {
                    if (bFlg) {
                        v.add(st.substring(iCtr, iCtr + piLength));
                    }
                    else {
                        v.add(st.substring(iCtr, iCtr + piLength + iLen_w));
                    }
                    iCtr = iCtr + piLength + iLen_w;
                }
                else {
                    if (bFlg) {
                        v.add(st.substring(iCtr, iIdx));
                    }
                    else {
                        v.add(st.substring(iCtr, iIdx + iLen_w));
                    }
                    iCtr = iIdx + iLen_w;
                }
            }
            else if (iCtr > iLen_a - piLength) {
                v.add(st.substring(iCtr, iLen_a));
                break;
            }
            else {
                v.add(st.substring(iCtr, iCtr + piLength));
                iCtr = iCtr + piLength;
            }
        }

        int vec = v.size();
        String[] result = new String[vec];

        for (int i = 0; i < vec; i++) {
            result[i] = v.get(i);
        }

        return result;
    }

    public static String zeroNum(String psSrc,
        int piIntegralPartDigit,
        int piDecimalPartDigit) {

        return num(psSrc,
            ZERO_FILL,
            piIntegralPartDigit,
            ZERO_FILL,
            piDecimalPartDigit,
            KETASUU_CHECK_ERROR);
    }

    public static String editKana(String psSeionTaisyouMojiretu) {

        int iTmp;
        int iWK_Mojisuu;
        int iWK_GattiIndex;
        String sWK_SeionTaisyouMojiretu;
        String sWK_SeionHenkanMojiretu;
        String sWK_TugiMoji;
        String sWK_SeionTaisyouMoji;
        String sWK_Henkan_Mae;
        String sWK_Henkan_Ato;
        String sWK_Sakujyo_Hikaku;
        StringBuffer sbWK_SeionHenkanMojiretu = null;

        if (psSeionTaisyouMojiretu == null) {
            throw new BizAppException("EHS0008", "清音対象文字列");
        }

        if (psSeionTaisyouMojiretu.length() > 30) {
            throw new BizAppException("EHS0009", "清音対象文字列");
        }

        if (StringUtil.lrTrim(psSeionTaisyouMojiretu).length() == 0) {
            throw new BizAppException("EHS0010", "清音対象文字列");
        }

        sWK_SeionTaisyouMojiretu = psSeionTaisyouMojiretu;
        sWK_SeionTaisyouMoji = "";
        sWK_TugiMoji = "";
        sWK_SeionHenkanMojiretu = "";
        sWK_Henkan_Mae = "ヴガギグゲゴザジズゼゾダヂヅデドバビブベボパピプペポァィゥェォャュョッ";
        sWK_Henkan_Ato = "ウカキクケコサシスセソタシステトハヒフヘホハヒフヘホアイウエオヤユヨツ";
        sWK_Sakujyo_Hikaku = "ー・゛゜－．　";
        sbWK_SeionHenkanMojiretu = new StringBuffer("");

        iWK_Mojisuu = sWK_SeionTaisyouMojiretu.length();

        for (iTmp = 0; iTmp < iWK_Mojisuu; iTmp++) {

            sWK_SeionTaisyouMoji = sWK_SeionTaisyouMojiretu.substring(iTmp, iTmp + 1);

            if (iTmp < iWK_Mojisuu - 1) {
                sWK_TugiMoji = sWK_SeionTaisyouMojiretu.substring(iTmp + 1, iTmp + 2);
            }
            else {
                sWK_TugiMoji = "";
            }

            if (sWK_SeionTaisyouMoji.equals("ツ") && sWK_TugiMoji.equals("゛")) {
                sbWK_SeionHenkanMojiretu.append("ス");
            }
            else {
                if (sWK_SeionTaisyouMoji.equals("チ") && sWK_TugiMoji.equals("゛")) {
                    sbWK_SeionHenkanMojiretu.append("シ");
                }
                else {
                    iWK_GattiIndex = sWK_Henkan_Mae.indexOf(sWK_SeionTaisyouMoji);
                    if (iWK_GattiIndex == -1) {
                        if (sWK_Sakujyo_Hikaku.indexOf(sWK_SeionTaisyouMoji) == -1) {
                            sbWK_SeionHenkanMojiretu.append(sWK_SeionTaisyouMoji);
                        }
                    }
                    else {
                        sbWK_SeionHenkanMojiretu.append(sWK_Henkan_Ato.substring(iWK_GattiIndex, iWK_GattiIndex + 1));
                    }
                }
            }
        }

        sWK_SeionHenkanMojiretu = sbWK_SeionHenkanMojiretu.toString();
        return sWK_SeionHenkanMojiretu;
    }

    public static boolean isZero(BizCurrency pValue) {
        if (pValue == null) {
            return false;
        }
        else if (pValue.isOptional()) {
            return false;
        }
        else if (pValue.isZeroOrOptional()) {
            return true;
        }
        else {
            return false;
        }
    }

    public static Integer replaceIfNull(Integer pValue, Integer pReplaceValue) {
        if (pValue == null) {
            return pReplaceValue;
        }
        else {
            return pValue;
        }
    }

    public static BizDateYM replaceIfNull(BizDateYM pValue, BizDateYM pReplaceValue) {
        if (pValue == null) {
            return pReplaceValue;
        }
        else {
            return pValue;
        }
    }

    public static Classification<?> replaceIfNull(Classification<?> pValue, Classification<?> pReplaceValue) {
        if (pValue == null) {
            return pReplaceValue;
        }
        else {
            return pValue;
        }
    }

    public static String replaceIfNullOrBlank(String pValue, String pReplaceValue) {
        if (Strings.isNullOrEmpty(pValue)) {
            return pReplaceValue;
        }
        else {
            return pValue;
        }
    }

    public static BizCurrency replaceIfNullOrOptional(BizCurrency pValue, BizCurrency pReplaceValue) {
        if (pValue == null) {
            return pReplaceValue;
        }
        else if (pValue.isOptional()) {
            return pReplaceValue;
        }
        else {
            return pValue;
        }
    }

    public static String getGeneralMessageId(String pMessageId) {
        if (pMessageId == null) {
            throw new BizAppException(MessageId.EBA0023, MessageUtil.getMessage(MessageId.IBW0001));
        }

        if (pMessageId.startsWith("E")) {
            return MessageId.EBC0001;
        }
        else if (pMessageId.startsWith("W")) {
            return MessageId.WBC0001;
        }
        else if (pMessageId.startsWith("I")) {
            return MessageId.IBC0001;
        }
        else if (pMessageId.startsWith("Q")) {
            return MessageId.QBC0001;
        }
        else if (pMessageId.startsWith("K")) {
            return MessageId.KBC0001;
        }
        else if (pMessageId.startsWith("T")) {
            return MessageId.TBC0001;
        }
        else {
            return pMessageId;
        }
    }
}
