package yuyu.common.base.format;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.logger.LoggerFactory;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateConfig;
import jp.co.slcs.swak.date.BizDateFormat;
import jp.co.slcs.swak.date.BizDateFormat.FillStyle;
import jp.co.slcs.swak.date.BizSeireki;
import jp.co.slcs.swak.date.BizWareki;
import jp.co.slcs.swak.date.SeirekiWarekiKbn;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.def.MessageId;

/**
 * 標準書式用日付編集クラス<br/>
 */
public class DefaultDateFormatter {

    private static Logger logger = LoggerFactory.getLogger(DefaultDateFormatter.class);

    private static final String HANKAKU_SPACE = " ";

    private static final String HANKAKU_COLON = ":";

    private static final String WAREKI_KANJI_YMD_FORMAT = "GGyy年MM月dd日";

    private static final String SEIREKI_KANJI_YMD_FORMAT = "yyyy年MM月dd日";

    private static final String WAREKI_KANJI_YM_FORMAT = "GGyy年MM月";

    private static final String SEIREKI_KANJI_YM_FORMAT = "yyyy年MM月";

    private static final String WAREKI_KANJI_Y_FORMAT = "GGyy年";

    private static final String SEIREKI_KANJI_Y_FORMAT = "yyyy年";

    private static final String WAREKI_KANJI_MD_FORMAT = "MM月dd日";

    private static String defaultYMDFormat;

    private static String defaultYMFormat;

    private static String defaultYFormat;

    private static String defaultMDFormat;

    private static String kanjiYMDFormat;

    private static String kanjiYMFormat;

    private static String kanjiYFormat;

    private static String kanjiMDFormat;

    static {

        BizDateConfig bizDateConfig = BizDateConfig.getInstance();
        SeirekiWarekiKbn seirekiWareKiKbn = bizDateConfig.getSeirekiWarekiKbn();

        switch(seirekiWareKiKbn) {

            case WAREKI_SYMBOL:
            case WAREKI_KANJI:
            case WAREKI_INPUT:

                BizWareki bizWareki = bizDateConfig.getWareki();

                defaultYMDFormat = bizWareki.getBizDateDefaultFormat();
                defaultYMFormat = bizWareki.getBizDateDefaultYMFormat();
                defaultYFormat = bizWareki.getBizDateDefaultYFormat();
                kanjiYMDFormat = WAREKI_KANJI_YMD_FORMAT;
                kanjiYMFormat = WAREKI_KANJI_YM_FORMAT;
                kanjiYFormat = WAREKI_KANJI_Y_FORMAT;

                break;

            default:

                BizSeireki bizSeireki = bizDateConfig.getSeireki();

                defaultYMDFormat = bizSeireki.getBizDateDefaultFormat();
                defaultYMFormat = bizSeireki.getBizDateDefaultYMFormat();
                defaultYFormat = bizSeireki.getBizDateDefaultYFormat();
                kanjiYMDFormat = SEIREKI_KANJI_YMD_FORMAT;
                kanjiYMFormat = SEIREKI_KANJI_YM_FORMAT;
                kanjiYFormat = SEIREKI_KANJI_Y_FORMAT;
        }

        defaultMDFormat = bizDateConfig.getBizDateDefaultMDFormat();

        kanjiMDFormat = WAREKI_KANJI_MD_FORMAT;
    }

    public static String formatYMDZeroFill(BizDate pBizDate) {

        logger.debug("▽ 標準書式用日付書式編集＃年月日ゼロ埋め編集（引数型：Bizdate） 開始");

        String defalutYMDDate;

        if (pBizDate == null) {

            defalutYMDDate = "";
        }
        else {

            BizDateFormat format = new BizDateFormat(defaultYMDFormat, FillStyle.Zero);

            defalutYMDDate = format.format(pBizDate);
        }

        logger.debug("△ 標準書式用日付書式編集＃年月日ゼロ埋め編集（引数型：Bizdate） 終了");

        return defalutYMDDate;
    }

    public static String formatYMDZeroFill(String pBizDate) {

        logger.debug("▽ 標準書式用日付書式編集＃年月日ゼロ埋め編集（引数型：String） 開始");

        String defalutYMDDate;

        if (BizUtil.isBlank(pBizDate)) {

            defalutYMDDate = "";
        }
        else if (pBizDate.length() != 8) {
            throw new BizAppException(MessageUtil.getMessage(MessageId.EBA0023, "入力桁数"));
        }
        else {

            BizDate bizDate = BizDate.valueOf(pBizDate);

            BizDateFormat format = new BizDateFormat(defaultYMDFormat, FillStyle.Zero);

            defalutYMDDate = format.format(bizDate);
        }

        logger.debug("△ 標準書式用日付書式編集＃年月日ゼロ埋め編集（引数型：String） 終了");

        return defalutYMDDate;
    }

    public static String formatYMD(BizDate pBizDate) {

        logger.debug("▽ 標準書式用日付書式編集＃年月日編集（引数型：Bizdate） 開始");

        String defalutYMDDate;

        if (pBizDate == null) {

            defalutYMDDate = "";
        }
        else {

            BizDateFormat format = new BizDateFormat(defaultYMDFormat, FillStyle.Blank);

            defalutYMDDate = format.format(pBizDate);
        }

        logger.debug("△ 標準書式用日付書式編集＃年月日編集（引数型：Bizdate） 終了");

        return defalutYMDDate;
    }

    public static String formatYMD(String pBizDate) {

        logger.debug("▽ 標準書式用日付書式編集＃年月日編集（引数型：String） 開始");

        String defalutYMDDate;

        if (BizUtil.isBlank(pBizDate)) {

            defalutYMDDate = "";
        }
        else if (pBizDate.length() != 8) {
            throw new BizAppException(MessageUtil.getMessage(MessageId.EBA0023, "入力桁数"));
        }
        else {

            BizDate bizDate = BizDate.valueOf(pBizDate);

            BizDateFormat format = new BizDateFormat(defaultYMDFormat, FillStyle.Blank);

            defalutYMDDate = format.format(bizDate);
        }

        logger.debug("△ 標準書式用日付書式編集＃年月日編集（引数型：String） 終了");

        return defalutYMDDate;
    }

    public static String formatYMDKanji(BizDate pBizDate) {

        logger.debug("▽ 標準書式用日付書式編集＃年月日漢字編集（引数型：Bizdate） 開始");

        String kanjiYMDDate;

        if (pBizDate == null) {

            kanjiYMDDate = "";
        }
        else {

            BizDateFormat format = new BizDateFormat(kanjiYMDFormat, FillStyle.Blank);

            kanjiYMDDate = format.format(pBizDate);
        }

        logger.debug("△ 標準書式用日付書式編集＃年月日漢字編集（引数型：Bizdate） 終了");

        return kanjiYMDDate;
    }

    public static String formatYMDKanji(String pBizDate) {

        logger.debug("▽ 標準書式用日付書式編集＃年月日漢字編集（引数型：String） 開始");

        String kanjiYMDDate;

        if (BizUtil.isBlank(pBizDate)) {

            kanjiYMDDate = "";
        }
        else if (pBizDate.length() != 8) {
            throw new BizAppException(MessageUtil.getMessage(MessageId.EBA0023, "入力桁数"));
        }
        else {

            BizDate bizDate = BizDate.valueOf(pBizDate);

            BizDateFormat format = new BizDateFormat(kanjiYMDFormat, FillStyle.Blank);

            kanjiYMDDate = format.format(bizDate);
        }

        logger.debug("△ 標準書式用日付書式編集＃年月日漢字編集（引数型：String） 終了");

        return kanjiYMDDate;
    }

    public static String formatYMZeroFill(BizDate pBizDate) {

        logger.debug("▽ 標準書式用日付書式編集＃年月ゼロ埋め編集（引数型：Bizdate） 開始");

        String defaultYMDate;

        if (pBizDate == null) {

            defaultYMDate = "";
        }
        else {

            BizDateFormat format = new BizDateFormat(defaultYMFormat, FillStyle.Zero);

            defaultYMDate = format.format(pBizDate);
        }

        logger.debug("△ 標準書式用日付書式編集＃年月ゼロ埋め編集（引数型：Bizdate） 終了");

        return defaultYMDate;
    }

    public static String formatYMZeroFill(String pBizDate) {

        logger.debug("▽ 標準書式用日付書式編集＃年月ゼロ埋め編集（引数型：String） 開始");

        String defaultYMDate;

        if (BizUtil.isBlank(pBizDate)) {

            defaultYMDate = "";
        }
        else if (pBizDate.length() != 6) {
            throw new BizAppException(MessageUtil.getMessage(MessageId.EBA0023, "入力桁数"));
        }
        else {

            BizDate bizDate = BizDate.valueOf(pBizDate + "01");

            BizDateFormat format = new BizDateFormat(defaultYMFormat, FillStyle.Zero);

            defaultYMDate = format.format(bizDate);
        }

        logger.debug("△ 標準書式用日付書式編集＃年月ゼロ埋め編集（引数型：String） 終了");

        return defaultYMDate;
    }

    public static String formatYM(BizDate pBizDate) {

        logger.debug("▽ 標準書式用日付書式編集＃年月編集（引数型：Bizdate） 開始");

        String defaultYMDate;

        if (pBizDate == null) {

            defaultYMDate = "";
        }
        else {

            BizDateFormat format = new BizDateFormat(defaultYMFormat, FillStyle.Blank);

            defaultYMDate = format.format(pBizDate);
        }

        logger.debug("△ 標準書式用日付書式編集＃年月編集（引数型：Bizdate） 終了");

        return defaultYMDate;
    }

    public static String formatYM(String pBizDate) {

        logger.debug("▽ 標準書式用日付書式編集＃年月編集（引数型：String） 開始");

        String defaultYMDate;

        if (BizUtil.isBlank(pBizDate)) {

            defaultYMDate = "";
        }
        else if (pBizDate.length() != 6) {
            throw new BizAppException(MessageUtil.getMessage(MessageId.EBA0023, "入力桁数"));
        }
        else {

            BizDate bizDate = BizDate.valueOf(pBizDate + "01");

            BizDateFormat format = new BizDateFormat(defaultYMFormat, FillStyle.Blank);

            defaultYMDate = format.format(bizDate);
        }

        logger.debug("△ 標準書式用日付書式編集＃年月編集（引数型：String） 終了");

        return defaultYMDate;
    }

    public static String formatYMKanji(BizDate pBizDate) {

        logger.debug("▽ 標準書式用日付書式編集＃年月漢字編集（引数型：Bizdate） 開始");

        String kanjiYMDate;

        if (pBizDate == null) {

            kanjiYMDate = "";
        }
        else {

            BizDateFormat format = new BizDateFormat(kanjiYMFormat, FillStyle.Blank);

            kanjiYMDate = format.format(pBizDate);
        }

        logger.debug("△ 標準書式用日付書式編集＃年月漢字編集（引数型：Bizdate） 終了");

        return kanjiYMDate;
    }

    public static String formatYMKanji(String pBizDate) {

        logger.debug("▽ 標準書式用日付書式編集＃年月漢字編集（引数型：String） 開始");

        String kanjiYMDate;

        if (BizUtil.isBlank(pBizDate)) {

            kanjiYMDate = "";
        }
        else if (pBizDate.length() != 6) {
            throw new BizAppException(MessageUtil.getMessage(MessageId.EBA0023, "入力桁数"));
        }
        else {

            BizDate bizDate = BizDate.valueOf(pBizDate + "01");

            BizDateFormat format = new BizDateFormat(kanjiYMFormat, FillStyle.Blank);

            kanjiYMDate = format.format(bizDate);
        }

        logger.debug("△ 標準書式用日付書式編集＃年月漢字編集（引数型：String） 終了");

        return kanjiYMDate;
    }

    public static String formatYZeroFill(BizDate pBizDate) {

        logger.debug("▽ 標準書式用日付書式編集＃年ゼロ埋め編集（引数型：Bizdate） 開始");

        String defaultYDate;

        if (pBizDate == null) {

            defaultYDate = "";
        }
        else {

            BizDateFormat format = new BizDateFormat(defaultYFormat, FillStyle.Zero);

            defaultYDate = format.format(pBizDate);
        }

        logger.debug("△ 標準書式用日付書式編集＃年ゼロ埋め編集（引数型：Bizdate） 終了");

        return defaultYDate;
    }

    public static String formatYZeroFill(String pBizDate) {

        logger.debug("▽ 標準書式用日付書式編集＃年ゼロ埋め編集（引数型：String） 開始");

        String defaultYDate;

        if (BizUtil.isBlank(pBizDate)) {

            defaultYDate = "";
        }
        else if (pBizDate.length() != 4) {
            throw new BizAppException(MessageUtil.getMessage(MessageId.EBA0023, "入力桁数"));
        }
        else {

            BizDate bizDate = BizDate.valueOf(pBizDate + "0101");

            BizDateFormat format = new BizDateFormat(defaultYFormat, FillStyle.Zero);

            defaultYDate = format.format(bizDate);
        }

        logger.debug("△ 標準書式用日付書式編集＃年ゼロ埋め編集（引数型：String） 終了");

        return defaultYDate;
    }

    public static String formatY(BizDate pBizDate) {

        logger.debug("▽ 標準書式用日付書式編集＃年編集（引数型：Bizdate） 開始");

        String defaultYDate;

        if (pBizDate == null) {

            defaultYDate = "";
        }
        else {

            BizDateFormat format = new BizDateFormat(defaultYFormat, FillStyle.Blank);

            defaultYDate = format.format(pBizDate);
        }

        logger.debug("△ 標準書式用日付書式編集＃年編集（引数型：Bizdate） 終了");

        return defaultYDate;
    }

    public static String formatY(String pBizDate) {

        logger.debug("▽ 標準書式用日付書式編集＃年編集（引数型：String） 開始");

        String defaultYDate;

        if (BizUtil.isBlank(pBizDate)) {

            defaultYDate = "";
        }
        else if (pBizDate.length() != 4) {
            throw new BizAppException(MessageUtil.getMessage(MessageId.EBA0023, "入力桁数"));
        }
        else {

            BizDate bizDate = BizDate.valueOf(pBizDate + "0101");

            BizDateFormat format = new BizDateFormat(defaultYFormat, FillStyle.Blank);

            defaultYDate = format.format(bizDate);
        }

        logger.debug("△ 標準書式用日付書式編集＃年編集（引数型：String） 終了");

        return defaultYDate;
    }

    public static String formatYKanji(BizDate pBizDate) {

        logger.debug("▽ 標準書式用日付書式編集＃年漢字編集（引数型：Bizdate） 開始");

        String kanjiYDate;

        if (pBizDate == null) {

            kanjiYDate = "";
        }
        else {

            BizDateFormat format = new BizDateFormat(kanjiYFormat, FillStyle.Blank);

            kanjiYDate = format.format(pBizDate);
        }

        logger.debug("△ 標準書式用日付書式編集＃年漢字編集（引数型：Bizdate） 終了");

        return kanjiYDate;
    }

    public static String formatYKanji(String pBizDate) {

        logger.debug("▽ 標準書式用日付書式編集＃年漢字編集（引数型：String） 開始");

        String kanjiYDate;

        if (BizUtil.isBlank(pBizDate)) {

            kanjiYDate = "";
        }
        else if (pBizDate.length() != 4) {
            throw new BizAppException(MessageUtil.getMessage(MessageId.EBA0023, "入力桁数"));
        }
        else {

            BizDate bizDate = BizDate.valueOf(pBizDate + "0101");

            BizDateFormat format = new BizDateFormat(kanjiYFormat, FillStyle.Blank);

            kanjiYDate = format.format(bizDate);
        }

        logger.debug("△ 標準書式用日付書式編集＃年漢字編集（引数型：String） 終了");

        return kanjiYDate;
    }

    public static String formatMDZeroFill(BizDate pBizDate) {

        logger.debug("▽ 標準書式用日付書式編集＃月日ゼロ埋め編集（引数型：Bizdate） 開始");

        String defaultMDDate;

        if (pBizDate == null) {

            defaultMDDate = "";
        }
        else {

            BizDateFormat format = new BizDateFormat(defaultMDFormat, FillStyle.Zero);

            defaultMDDate = format.format(pBizDate);
        }

        logger.debug("△ 標準書式用日付書式編集＃月日ゼロ埋め編集（引数型：Bizdate） 終了");

        return defaultMDDate;
    }

    public static String formatMDZeroFill(String pBizDate) {

        logger.debug("▽ 標準書式用日付書式編集＃月日ゼロ埋め編集（引数型：String） 開始");

        String defaultMDDate;

        if (BizUtil.isBlank(pBizDate)) {

            defaultMDDate = "";
        }
        else if (pBizDate.length() != 4) {
            throw new BizAppException(MessageUtil.getMessage(MessageId.EBA0023, "入力桁数"));
        }
        else {

            BizDate bizDate = BizDate.valueOf("2000" + pBizDate);

            BizDateFormat format = new BizDateFormat(defaultMDFormat, FillStyle.Zero);

            defaultMDDate = format.format(bizDate);
        }

        logger.debug("△ 標準書式用日付書式編集＃月日ゼロ埋め編集（引数型：String） 終了");

        return defaultMDDate;
    }

    public static String formatMD(BizDate pBizDate) {

        logger.debug("▽ 標準書式用日付書式編集＃月日編集（引数型：Bizdate） 開始");

        String defaultMDDate;

        if (pBizDate == null) {

            defaultMDDate = "";
        }
        else {

            BizDateFormat format = new BizDateFormat(defaultMDFormat, FillStyle.Blank);

            defaultMDDate = format.format(pBizDate);
        }

        logger.debug("△ 標準書式用日付書式編集＃月日編集（引数型：Bizdate） 終了");

        return defaultMDDate;
    }

    public static String formatMD(String pBizDate) {

        logger.debug("▽ 標準書式用日付書式編集＃月日編集（引数型：String） 開始");

        String defaultMDDate;

        if (BizUtil.isBlank(pBizDate)) {

            defaultMDDate = "";
        }
        else if (pBizDate.length() != 4) {
            throw new BizAppException(MessageUtil.getMessage(MessageId.EBA0023, "入力桁数"));
        }
        else {

            BizDate bizDate = BizDate.valueOf("2000" + pBizDate);

            BizDateFormat format = new BizDateFormat(defaultMDFormat, FillStyle.Blank);

            defaultMDDate = format.format(bizDate);
        }

        logger.debug("△ 標準書式用日付書式編集＃月日編集（引数型：String） 終了");

        return defaultMDDate;
    }

    public static String formatMDKanji(BizDate pBizDate) {

        logger.debug("▽ 標準書式用日付書式編集＃月日漢字編集（引数型：Bizdate） 開始");

        String kanjiMDDate;

        if (pBizDate == null) {

            kanjiMDDate = "";
        }
        else {

            BizDateFormat format = new BizDateFormat(kanjiMDFormat, FillStyle.Blank);

            kanjiMDDate = format.format(pBizDate);
        }

        logger.debug("△ 標準書式用日付書式編集＃月日漢字編集（引数型：Bizdate） 終了");

        return kanjiMDDate;
    }

    public static String formatMDKanji(String pBizDate) {

        logger.debug("▽ 標準書式用日付書式編集＃月日漢字編集（引数型：String） 開始");

        String kanjiMDDate;

        if (BizUtil.isBlank(pBizDate)) {

            kanjiMDDate = "";
        }
        else if (pBizDate.length() != 4) {
            throw new BizAppException(MessageUtil.getMessage(MessageId.EBA0023, "入力桁数"));
        }
        else {

            BizDate bizDate = BizDate.valueOf("2000" + pBizDate);

            BizDateFormat format = new BizDateFormat(kanjiMDFormat, FillStyle.Blank);

            kanjiMDDate = format.format(bizDate);
        }

        logger.debug("△ 標準書式用日付書式編集＃月日漢字編集（引数型：String） 終了");

        return kanjiMDDate;
    }

    public static String formatYMDHMSZeroFill(String pBizDate) {

        logger.debug("▽ 標準書式用日付書式編集＃年月日時分秒ゼロ埋め編集（引数型：String） 開始");

        String defaultYMDHMSDate;

        if (BizUtil.isBlank(pBizDate)) {

            defaultYMDHMSDate = "";
        }
        else if (pBizDate.length() < 14) {
            throw new BizAppException(MessageUtil.getMessage(MessageId.EBA0023, "入力桁数"));
        }
        else {

            defaultYMDHMSDate = DefaultDateFormatter.formatYMDZeroFill(pBizDate.substring(0, 8)) + HANKAKU_SPACE +
                pBizDate.substring(8, 10) + HANKAKU_COLON + pBizDate.substring(10, 12) + HANKAKU_COLON +
                pBizDate.substring(12, 14);
        }

        logger.debug("△ 標準書式用日付書式編集＃年月日時分秒ゼロ埋め編集（引数型：String） 終了");

        return defaultYMDHMSDate;
    }

    public static String formatYMDHMZeroFill(String pBizDate) {

        logger.debug("▽ 標準書式用日付書式編集＃年月日時分ゼロ埋め編集（引数型：String） 開始");

        String defaultYMDHMDate;

        if (BizUtil.isBlank(pBizDate)) {

            defaultYMDHMDate = "";
        }
        else if (pBizDate.length() < 12) {
            throw new BizAppException(MessageUtil.getMessage(MessageId.EBA0023, "入力桁数"));
        }
        else {

            defaultYMDHMDate = DefaultDateFormatter.formatYMDZeroFill(pBizDate.substring(0, 8))
                + HANKAKU_SPACE + pBizDate.substring(8, 10) + HANKAKU_COLON + pBizDate.substring(10, 12);
        }

        logger.debug("△ 標準書式用日付書式編集＃年月日時分ゼロ埋め編集（引数型：String）終了");

        return defaultYMDHMDate;
    }
}
