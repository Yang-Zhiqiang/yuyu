package yuyu.common.biz.bzcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateConfig;
import jp.co.slcs.swak.date.BizDateFormat;
import jp.co.slcs.swak.date.BizDateFormat.FillStyle;
import jp.co.slcs.swak.date.BizDateMD;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.date.SeirekiWarekiKbn;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.MessageId;

/**
 * 日付フォーマットユーティリティクラスです。<br />
 */
public class DateFormatUtil{

    private static final String  DAY_KANJI_KAKKORYAKUSYOU_SUNDAY    =  "日";
    private static final String  DAY_KANJI_KAKKORYAKUSYOU_MONDAY    =  "月";
    private static final String  DAY_KANJI_KAKKORYAKUSYOU_TUESDAY   =  "火";
    private static final String  DAY_KANJI_KAKKORYAKUSYOU_WEDNESDAY =  "水";
    private static final String  DAY_KANJI_KAKKORYAKUSYOU_THURSDAY  =  "木";
    private static final String  DAY_KANJI_KAKKORYAKUSYOU_FRIDAY    =  "金";
    private static final String  DAY_KANJI_KAKKORYAKUSYOU_SATURDAY  =  "土";
    private static final String  KAKKO_START  =  "（";
    private static final String  KAKKO_END  =  "）";
    private static final String  HANKAKU_SPACE = " ";
    private static final String  COLON = ":";

    public static String dateKANJI(BizDate psSource){
        SeirekiWarekiKbn kbn = BizDateConfig.getInstance().getSeirekiWarekiKbn();
        switch (kbn) {
            case WAREKI_SYMBOL:
            case WAREKI_KANJI:
            case WAREKI_INPUT:
                return new BizDateFormat("GGyy年MM月dd日", FillStyle.Blank).format(psSource);
            case SEIREKI:
            default:
                return new BizDateFormat("yyyy年MM月dd日", FillStyle.Blank).format(psSource);
        }
    }

    public static String dateKANJI(String psSource){
        if (psSource.length() != 8){
            throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBA0023, "入力桁数"));
        }
        SeirekiWarekiKbn kbn = BizDateConfig.getInstance().getSeirekiWarekiKbn();
        switch (kbn) {
            case WAREKI_SYMBOL:
            case WAREKI_KANJI:
            case WAREKI_INPUT:
                return new BizDateFormat("GGyy年MM月dd日", FillStyle.Blank).format(BizDate.valueOf(psSource));
            case SEIREKI:
            default:
                return new BizDateFormat("yyyy年MM月dd日", FillStyle.Blank).format(BizDate.valueOf(psSource));
        }
    }

    public static String dateKANJINoEx(BizDate psSource){
        String sRetStr = null;

        try{
            sRetStr = dateKANJI( psSource );

            return sRetStr;
        }
        catch(Exception eExp){
            if (psSource == null){
                return null;
            }
            return psSource.toString();
        }
    }

    public static String dateKANJINoEx(String psSource){
        String sRetStr = null;

        try{
            sRetStr = dateKANJI( psSource );

            return sRetStr;
        }
        catch(Exception eExp){
            return psSource;
        }
    }

    public static String dateKANJISeireki(BizDate psSource){
        try{
            return new BizDateFormat("yyyy年MM月dd日",FillStyle.Zero).format(psSource);
        }
        catch(Exception eExp){
            if (psSource == null){
                return null;
            }
            return psSource.toString();
        }
    }

    public static String dateKANJISeirekiNoZero(BizDate psSource) {
        try{
            return new BizDateFormat("yyyy年MM月dd日",FillStyle.Blank).format(psSource);
        }
        catch(Exception eExp){
            if (psSource == null){
                return null;
            }
            return psSource.toString();
        }
    }

    public static String dateKANJISeireki(String psSource){
        if (psSource.length() != 8){
            throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBA0023, "入力桁数"));
        }
        try{
            return new BizDateFormat("yyyy年MM月dd日",FillStyle.Zero).format(BizDate.valueOf(psSource));
        }
        catch(Exception eExp){
            return psSource;
        }
    }

    public static String dateKANJISeirekiNoZero(String psSource) {
        if (psSource.length() != 8){
            throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBA0023, "入力桁数"));
        }
        try{
            return new BizDateFormat("yyyy年MM月dd日",FillStyle.Blank).format(BizDate.valueOf(psSource));
        }
        catch(Exception eExp){
            return psSource;
        }
    }


    public static String dateKANJIWareki(BizDate psSource){
        return new BizDateFormat("GGyy年MM月dd日",FillStyle.Blank).format(psSource);
    }

    public static String dateKANJIWareki(String psSource){
        if (psSource.length() != 8){
            throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBA0023, "入力桁数"));
        }
        return new BizDateFormat("GGyy年MM月dd日",FillStyle.Blank).format(BizDate.valueOf(psSource));
    }

    public static String dateKANJIWarekiNoEx(BizDate psSource){
        String sRetStr = null;

        try{
            sRetStr = dateKANJIWareki( psSource );

            return sRetStr;
        }
        catch(Exception eExp){
            if (psSource == null){
                return null;
            }
            return psSource.toString();
        }
    }

    public static String dateKANJIWarekiNoEx(String psSource){
        String sRetStr = null;

        try{
            sRetStr = dateKANJIWareki( psSource );

            return sRetStr;
        }
        catch(Exception eExp){
            return psSource;
        }
    }
    public static String dateYmKANJI(BizDateYM psSource){
        SeirekiWarekiKbn kbn = BizDateConfig.getInstance().getSeirekiWarekiKbn();
        switch (kbn) {
            case WAREKI_SYMBOL:
            case WAREKI_KANJI:
            case WAREKI_INPUT:
                return new BizDateFormat("GGyy年MM月", FillStyle.Blank).format(psSource);
            case SEIREKI:
            default:
                return new BizDateFormat("yyyy年MM月", FillStyle.Blank).format(psSource);
        }

    }

    public static String dateYmKANJI(String psSource){
        if (psSource.length() != 6){
            throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBA0023, "入力桁数"));
        }
        BizDate source = BizDate.valueOf(psSource + "01");
        SeirekiWarekiKbn kbn = BizDateConfig.getInstance().getSeirekiWarekiKbn();
        switch (kbn) {
            case WAREKI_SYMBOL:
            case WAREKI_KANJI:
            case WAREKI_INPUT:
                return new BizDateFormat("GGyy年MM月", FillStyle.Blank).format(source);
            case SEIREKI:
            default:
                return new BizDateFormat("yyyy年MM月", FillStyle.Blank).format(source);
        }
    }

    public static String dateYmKANJINoEx(BizDateYM psSource){
        String sRetStr = null;

        try{
            sRetStr = dateYmKANJI( psSource );

            return sRetStr;
        }
        catch(Exception eExp){
            if (psSource == null){
                return null;
            }
            return psSource.toString();
        }
    }

    public static String dateYmKANJINoEx(String psSource){
        String sRetStr = null;

        try{
            sRetStr = dateYmKANJI( psSource );

            return sRetStr;
        }
        catch(Exception eExp){
            return psSource;
        }
    }

    public static String dateYmKANJIWareki(BizDateYM psSource){
        return new BizDateFormat("GGyy年MM月",FillStyle.Blank).format(psSource);
    }

    public static String dateYmKANJIWareki(String psSource){
        if (psSource.length() != 6){
            throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBA0023, "入力桁数"));
        }
        BizDate source = BizDate.valueOf(psSource + "01");
        return new BizDateFormat("GGyy年MM月",FillStyle.Blank).format(source);
    }

    public static String dateYmKANJIWarekiNoEx(BizDateYM psSource){
        String sRetStr = null;

        try{
            sRetStr = dateYmKANJIWareki( psSource );

            return sRetStr;
        }
        catch(Exception eExp){
            if (psSource == null){
                return null;
            }
            return psSource.toString();
        }
    }

    public static String dateYmKANJIWarekiNoEx(String psSource){
        String sRetStr = null;

        try{
            sRetStr = dateYmKANJIWareki( psSource );

            return sRetStr;
        }
        catch(Exception eExp){
            return psSource;
        }
    }

    public static String dateYKANJIWareki(BizDateY psSource){
        return new BizDateFormat("GGyy年",FillStyle.Blank).format(psSource);
    }

    public static String dateYKANJISeireki(BizDateY psSource){
        return new BizDateFormat("yyyy年",FillStyle.Blank).format(psSource);
    }

    public static String dateYKANJIWareki(String psSource){
        if (psSource.length() != 4){
            throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBA0023, "入力桁数"));
        }
        BizDate source = BizDate.valueOf(psSource + "0101");
        return new BizDateFormat("GGyy年",FillStyle.Blank).format(source);
    }

    public static String dateYKANJISeireki(String psSource){
        if (psSource.length() != 4){
            throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBA0023, "入力桁数"));
        }
        BizDate source = BizDate.valueOf(psSource + "0101");
        return new BizDateFormat("yyyy年",FillStyle.Blank).format(source);
    }

    public static String dateYKANJIWarekiNendo(BizDate psSource){

        try{

            int wkSourceYear = 0;

            if (psSource.getMonth() == 1 || psSource.getMonth() == 2 || psSource.getMonth() == 3) {
                wkSourceYear = psSource.getYear() -1;
            } else {
                wkSourceYear = psSource.getYear();
            }

            return new BizDateFormat("GGyy年度",FillStyle.Blank).format(BizDate.valueOf(wkSourceYear, 4, 1));

        }
        catch(Exception eExp){

            if (psSource == null){
                return null;
            }

            return psSource.toString();

        }

    }

    public static String dateYKANJISeirekiNendo(BizDate psSource){

        try{
            int wkSourceYear = 0;
            if (psSource.getMonth() == 1 || psSource.getMonth() == 2 || psSource.getMonth() == 3) {
                wkSourceYear = psSource.getYear() -1;
            } else {
                wkSourceYear = psSource.getYear();
            }
            return new BizDateFormat("yyyy年度",FillStyle.Blank).format(BizDate.valueOf(wkSourceYear, 4, 1));

        }
        catch(Exception eExp){

            if (psSource == null){
                return null;
            }

            return psSource.toString();

        }

    }

    public static String dateDOT(BizDate psSource){
        SeirekiWarekiKbn kbn = BizDateConfig.getInstance().getSeirekiWarekiKbn();
        switch (kbn) {
            case WAREKI_SYMBOL:
            case WAREKI_KANJI:
            case WAREKI_INPUT:
                return new BizDateFormat("Gyy.MM.dd", FillStyle.Blank).format(psSource);
            case SEIREKI:
            default:
                return new BizDateFormat("yyyy.MM.dd", FillStyle.Blank).format(psSource);
        }
    }

    public static String dateDOT(String psSource){
        if (psSource.length() != 8){
            throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBA0023, "入力桁数"));
        }
        SeirekiWarekiKbn kbn = BizDateConfig.getInstance().getSeirekiWarekiKbn();
        switch (kbn) {
            case WAREKI_SYMBOL:
            case WAREKI_KANJI:
            case WAREKI_INPUT:
                return new BizDateFormat("Gyy.MM.dd", FillStyle.Blank).format(BizDate.valueOf(psSource));
            case SEIREKI:
            default:
                return new BizDateFormat("yyyy.MM.dd", FillStyle.Blank).format(BizDate.valueOf(psSource));
        }
    }


    public static String dateDOTNoEx(BizDate psSource){
        try{
            String sRetStr = dateDOT( psSource );

            return sRetStr;
        }
        catch(Exception eExp){
            if (psSource == null){
                return null;
            }
            return psSource.toString();
        }
    }

    public static String dateDOTNoEx(String psSource){
        try{
            String sRetStr = dateDOT( psSource );

            return sRetStr;
        }
        catch(Exception eExp){
            return psSource;
        }
    }

    public static String dateDOTSeireki(BizDate psSource)  {
        return new BizDateFormat("yyyy.MM.dd",FillStyle.Zero).format(psSource);
    }

    public static String dateDOTSeireki(String psSource)  {
        if (psSource.length() != 8){
            throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBA0023, "入力桁数"));
        }
        return new BizDateFormat("yyyy.MM.dd",FillStyle.Zero).format(BizDate.valueOf(psSource));
    }

    public static String dateDOTWareki(BizDate psSource)  {
        return new BizDateFormat("Gyy.MM.dd",FillStyle.Blank).format(psSource);
    }

    public static String dateDOTWareki(String psSource)  {
        if (psSource.length() != 8){
            throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBA0023, "入力桁数"));
        }
        return new BizDateFormat("Gyy.MM.dd",FillStyle.Blank).format(BizDate.valueOf(psSource));
    }

    public static String dateDOTWarekiNoEx(BizDate psSource){
        String sRetStr = null;

        try{
            sRetStr = dateDOTWareki( psSource );

            return sRetStr;
        }
        catch(Exception eExp){
            if (psSource == null){
                return null;
            }
            return psSource.toString();
        }
    }

    public static String dateDOTWarekiNoEx(String psSource){
        String sRetStr = null;

        try{
            sRetStr = dateDOTWareki( psSource );

            return sRetStr;
        }
        catch(Exception eExp){
            return psSource;
        }
    }

    public static String dateMDDOT(BizDateMD psSource){
        return new BizDateFormat("MM.dd",FillStyle.Zero).format(psSource);
    }

    public static String dateMDDOT(String psSource){
        if (psSource.length() != 4){
            throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBA0023, "入力桁数"));
        }
        BizDate source = BizDate.valueOf("2000" + psSource);
        return new BizDateFormat("MM.dd",FillStyle.Zero).format(source);
    }

    public static String getYoubiRyakusyouKanjiKakko(BizDate pgdDate){
        String        sYoubi          = null;

        switch(pgdDate.getDayOfWeek()){
            case Sunday:
                sYoubi = _editKakko(DAY_KANJI_KAKKORYAKUSYOU_SUNDAY);
                break;
            case Monday:
                sYoubi = _editKakko(DAY_KANJI_KAKKORYAKUSYOU_MONDAY);
                break;
            case Tuesday:
                sYoubi = _editKakko(DAY_KANJI_KAKKORYAKUSYOU_TUESDAY);
                break;
            case Wednesday:
                sYoubi = _editKakko(DAY_KANJI_KAKKORYAKUSYOU_WEDNESDAY);
                break;
            case Thursday:
                sYoubi = _editKakko(DAY_KANJI_KAKKORYAKUSYOU_THURSDAY);
                break;
            case Friday:
                sYoubi = _editKakko(DAY_KANJI_KAKKORYAKUSYOU_FRIDAY);
                break;
            case Saturday:
                sYoubi = _editKakko(DAY_KANJI_KAKKORYAKUSYOU_SATURDAY);
                break;
            default:
                break;
        }

        return sYoubi;
    }

    public static String viewYMD(BizDate psYyyyMmDd){
        SeirekiWarekiKbn kbn = BizDateConfig.getInstance().getSeirekiWarekiKbn();
        switch (kbn) {
            case WAREKI_SYMBOL:
            case WAREKI_KANJI:
            case WAREKI_INPUT:
                return new BizDateFormat("Gyy.MM.dd", FillStyle.Zero).format(psYyyyMmDd);
            case SEIREKI:
            default:
                return new BizDateFormat("yyyy.MM.dd", FillStyle.Zero).format(psYyyyMmDd);
        }
    }

    public static String viewYMD(String psYyyyMmDd){
        if (psYyyyMmDd.length() != 8){
            throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBA0023, "入力桁数"));
        }
        SeirekiWarekiKbn kbn = BizDateConfig.getInstance().getSeirekiWarekiKbn();
        switch (kbn) {
            case WAREKI_SYMBOL:
            case WAREKI_KANJI:
            case WAREKI_INPUT:
                return new BizDateFormat("Gyy.MM.dd", FillStyle.Zero).format(BizDate.valueOf(psYyyyMmDd));
            case SEIREKI:
            default:
                return new BizDateFormat("yyyy.MM.dd", FillStyle.Zero).format(BizDate.valueOf(psYyyyMmDd));
        }
    }


    public static String viewYM(BizDateYM pYyyyMm){

        if(pYyyyMm == null){

            return null;
        }

        SeirekiWarekiKbn kbn = BizDateConfig.getInstance().getSeirekiWarekiKbn();
        switch (kbn) {
            case SEIREKI:
                return new BizDateFormat("yyyy.MM", FillStyle.Zero).format(pYyyyMm);
            case WAREKI_SYMBOL:
            case WAREKI_KANJI:
            case WAREKI_INPUT:
            default:
                return new BizDateFormat("Gyy.MM", FillStyle.Zero).format(pYyyyMm);
        }
    }

    public static String viewYM(String pYyyyMm){

        if (pYyyyMm == null || pYyyyMm.length() != 6){

            return "";
        }

        SeirekiWarekiKbn kbn = BizDateConfig.getInstance().getSeirekiWarekiKbn();
        switch (kbn) {
            case SEIREKI:
                return new BizDateFormat("yyyy.MM", FillStyle.Zero).format(BizDateYM.valueOf(pYyyyMm));
            case WAREKI_SYMBOL:
            case WAREKI_KANJI:
            case WAREKI_INPUT:
            default:
                return new BizDateFormat("Gyy.MM", FillStyle.Zero).format(BizDateYM.valueOf(pYyyyMm));
        }
    }


    public static String dateYmdhm(String psProperty) {

        StringBuffer sbTag = new StringBuffer("");
        String sYmd = null;

        if (psProperty != null && psProperty.length() >= 12) {

            sYmd = psProperty.substring(0, 8);

            sbTag.append(viewYMD(sYmd));
            sbTag.append(HANKAKU_SPACE);
            sbTag.append(psProperty.substring(8, 10));
            sbTag.append(COLON);
            sbTag.append(psProperty.substring(10, 12));
        }

        return sbTag.toString();
    }

    public static String smd(BizDate psProperty){

        if(psProperty == null){

            return "";
        }

        return new BizDateFormat("yyyy.MM.dd", FillStyle.Zero).format(psProperty);
    }

    private static String _editKakko(String psTarget) {
        StringBuffer sbKakko = new StringBuffer();

        sbKakko.append(KAKKO_START);
        sbKakko.append(psTarget);
        sbKakko.append(KAKKO_END);

        return sbKakko.toString();
    }
}
