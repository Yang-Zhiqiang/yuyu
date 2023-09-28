package yuyu.common.base.format;

import jp.co.slcs.swak.core.logger.LoggerFactory;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateFormat;
import jp.co.slcs.swak.date.BizDateFormat.FillStyle;
import jp.co.slcs.swak.util.string.ConvertUtil;

import org.slf4j.Logger;

/**
 * 個別指定書式用日付編集クラス
 */
public class FixedDateFormatter {

    private static Logger logger = LoggerFactory.getLogger(FixedDateFormatter.class);

    private static final String WAREKI_KANJI_YMD_FORMAT = "GGyy年MM月dd日";

    private static final String SEIREKI_KANJI_YMD_FORMAT = "yyyy年MM月dd日";

    private static final String WAREKI_KANJI_YM_FORMAT = "GGyy年MM月";

    private static final String SEIREKI_KANJI_YM_FORMAT = "yyyy年MM月";

    private static final String WAREKI_KANJI_Y_FORMAT = "GGyy年";

    private static final String SEIREKI_KANJI_Y_FORMAT = "yyyy年";

    private static final String KANJI_MD_FORMAT = "MM月dd日";

    private static final String SEIREKI_M_FORMAT = "MM";

    private static final String SEIREKI_KANJI_M_FORMAT = "MM月";

    private static final String SEIREKI_D_FORMAT = "dd";

    private static final String SEIREKI_KANJI_D_FORMAT = "dd日";

    private static final String SEIREKI_YB_FORMAT = "E";

    private static final String SEIREKI_SLASH_YMD_FORMAT = "yyyy/MM/dd";

    public static String formatYoubi(BizDate pBizDate) {

        logger.debug("▽ 個別指定書式用日付編集＃曜日編集（囲い文字指定なし） 開始");

        String formatYB;

        if (pBizDate == null) {

            formatYB = "";
        }
        else {

            BizDateFormat format = new BizDateFormat(SEIREKI_YB_FORMAT);

            formatYB = format.format(pBizDate);
        }

        logger.debug("△ 個別指定書式用日付編集＃曜日編集（囲い文字指定なし） 終了");

        return formatYB;
    }

    public static String formatYoubi(BizDate pBizDate, String pStStartMj, String pStEndMj) {

        logger.debug("▽ 個別指定書式用日付編集＃曜日編集（囲い文字指定あり） 開始");

        String formatYB;

        if (pBizDate == null) {

            formatYB = "";
        }
        else {

            BizDateFormat format = new BizDateFormat(SEIREKI_YB_FORMAT);

            formatYB = format.format(pBizDate);

            formatYB = pStStartMj + formatYB + pStEndMj;
        }

        logger.debug("△ 個別指定書式用日付編集＃曜日編集（囲い文字指定あり） 終了");

        return formatYB;
    }

    public static String formatYMDWarekiKanjiNoneFill(BizDate pBizDate) {

        logger.debug("▽ 個別指定書式用日付編集＃年月日和暦漢字埋め文字無し編集 開始");

        String formatYMD;

        if (pBizDate == null) {

            formatYMD = "";
        }
        else {

            BizDateFormat format = new BizDateFormat(WAREKI_KANJI_YMD_FORMAT, FillStyle.None);

            formatYMD = format.format(pBizDate);
        }

        logger.debug("△ 個別指定書式用日付編集＃年月日和暦漢字埋め文字無し編集 終了");

        return formatYMD;
    }

    public static String formatYMDSeirekiSlashZeroFill(BizDate pBizDate) {

        logger.debug("▽ 個別指定書式用日付編集＃年月日西暦スラッシュゼロ埋め編集 開始");

        String formatYMD;

        if (pBizDate == null) {

            formatYMD = "";
        }
        else {

            BizDateFormat format = new BizDateFormat(SEIREKI_SLASH_YMD_FORMAT, FillStyle.Zero);

            formatYMD = format.format(pBizDate);
        }

        logger.debug("△ 個別指定書式用日付編集＃年月日西暦スラッシュゼロ埋め編集 終了");

        return formatYMD;
    }

    public static String formatMZeroFill(BizDate pBizDate) {

        logger.debug("▽ 個別指定書式用日付編集＃月ゼロ埋め編集 開始");

        String formatM;

        if (pBizDate == null) {

            formatM = "";
        }
        else {

            BizDateFormat format = new BizDateFormat(SEIREKI_M_FORMAT, FillStyle.Zero);

            formatM = format.format(pBizDate);
        }

        logger.debug("△ 個別指定書式用日付編集＃月ゼロ埋め編集 終了");

        return formatM;
    }

    public static String formatDZeroFill(BizDate pBizDate) {

        logger.debug("▽ 個別指定書式用日付編集＃日ゼロ埋め編集 開始");

        String formatD;

        if (pBizDate == null) {

            formatD = "";
        }
        else {

            BizDateFormat format = new BizDateFormat(SEIREKI_D_FORMAT, FillStyle.Zero);

            formatD = format.format(pBizDate);
        }

        logger.debug("△ 個別指定書式用日付編集＃日ゼロ埋め編集 終了");

        return formatD;
    }

    public static String formatYMDZenkakuWarekiKanji(BizDate pBizDate) {

        logger.debug("▽ 個別指定書式用日付編集＃年月日全角和暦漢字編集 開始");

        String formatYMDZenkaku;

        if (pBizDate == null) {

            formatYMDZenkaku = "";
        }
        else {

            BizDateFormat format = new BizDateFormat(WAREKI_KANJI_YMD_FORMAT, FillStyle.Blank);

            formatYMDZenkaku = format.format(pBizDate);

            formatYMDZenkaku = ConvertUtil.toZenAll(formatYMDZenkaku, 1, 1);
        }

        logger.debug("△ 個別指定書式用日付編集＃年月日全角和暦漢字編集 終了");

        return formatYMDZenkaku;
    }

    public static String formatYMDZenkakuSeirekiKanji(BizDate pBizDate) {

        logger.debug("▽ 個別指定書式用日付編集＃年月日全角西暦漢字編集 開始");

        String formatYMDZenkaku;

        if (pBizDate == null) {

            formatYMDZenkaku = "";
        }
        else {

            BizDateFormat format = new BizDateFormat(SEIREKI_KANJI_YMD_FORMAT, FillStyle.Blank);

            formatYMDZenkaku = format.format(pBizDate);

            formatYMDZenkaku = ConvertUtil.toZenAll(formatYMDZenkaku, 1, 1);
        }

        logger.debug("△ 個別指定書式用日付編集＃年月日全角西暦漢字編集 終了");

        return formatYMDZenkaku;
    }

    public static String formatYMZenkakuWarekiKanji(BizDate pBizDate) {

        logger.debug("▽ 個別指定書式用日付編集＃年月全角和暦漢字編集 開始");

        String formatYMZenkaku;

        if (pBizDate == null) {

            formatYMZenkaku = "";
        }
        else {

            BizDateFormat format = new BizDateFormat(WAREKI_KANJI_YM_FORMAT, FillStyle.Blank);

            formatYMZenkaku = format.format(pBizDate);

            formatYMZenkaku = ConvertUtil.toZenAll(formatYMZenkaku, 1, 1);
        }

        logger.debug("△ 個別指定書式用日付編集＃年月全角和暦漢字編集 終了");

        return formatYMZenkaku;
    }

    public static String formatYMZenkakuSeirekiKanji(BizDate pBizDate) {

        logger.debug("▽ 個別指定書式用日付編集＃年月全角西暦漢字編集 開始");

        String formatYMZenkaku;

        if (pBizDate == null) {

            formatYMZenkaku = "";
        }
        else {

            BizDateFormat format = new BizDateFormat(SEIREKI_KANJI_YM_FORMAT, FillStyle.Blank);

            formatYMZenkaku = format.format(pBizDate);

            formatYMZenkaku = ConvertUtil.toZenAll(formatYMZenkaku, 1, 1);
        }

        logger.debug("△ 個別指定書式用日付編集＃年月全角西暦漢字編集 終了");

        return formatYMZenkaku;
    }

    public static String formatYZenkakuWarekiKanji(BizDate pBizDate) {

        logger.debug("▽ 個別指定書式用日付編集＃年全角和暦漢字編集 開始");

        String formatYZenkaku;

        if (pBizDate == null) {

            formatYZenkaku = "";
        }
        else {

            BizDateFormat format = new BizDateFormat(WAREKI_KANJI_Y_FORMAT, FillStyle.Blank);

            formatYZenkaku = format.format(pBizDate);

            formatYZenkaku = ConvertUtil.toZenAll(formatYZenkaku, 1, 1);
        }

        logger.debug("△ 個別指定書式用日付編集＃年全角和暦漢字編集 終了");

        return formatYZenkaku;
    }

    public static String formatYZenkakuSeirekiKanji(BizDate pBizDate) {

        logger.debug("▽ 個別指定書式用日付編集＃年全角西暦漢字編集 開始");

        String formatYZenkaku;

        if (pBizDate == null) {

            formatYZenkaku = "";
        }
        else {

            BizDateFormat format = new BizDateFormat(SEIREKI_KANJI_Y_FORMAT, FillStyle.Blank);

            formatYZenkaku = format.format(pBizDate);

            formatYZenkaku = ConvertUtil.toZenAll(formatYZenkaku, 1, 1);
        }

        logger.debug("△ 個別指定書式用日付編集＃年全角西暦漢字編集 終了");

        return formatYZenkaku;
    }

    public static String formatMDZenkakuKanji(BizDate pBizDate) {

        logger.debug("▽ 個別指定書式用日付編集＃月日全角漢字編集 開始");

        String formatMDZenkaku;

        if (pBizDate == null) {

            formatMDZenkaku = "";
        }
        else {

            BizDateFormat format = new BizDateFormat(KANJI_MD_FORMAT, FillStyle.Blank);

            formatMDZenkaku = format.format(pBizDate);

            formatMDZenkaku = ConvertUtil.toZenAll(formatMDZenkaku, 1, 1);
        }

        logger.debug("△ 個別指定書式用日付編集＃月日全角漢字編集 終了");

        return formatMDZenkaku;
    }

    public static String formatMZenkakuKanji(BizDate pBizDate) {

        logger.debug("▽ 個別指定書式用日付編集＃月全角漢字編集 開始");

        String formatMZenkaku;

        if (pBizDate == null) {

            formatMZenkaku = "";
        }
        else {

            BizDateFormat format = new BizDateFormat(SEIREKI_KANJI_M_FORMAT, FillStyle.Blank);

            formatMZenkaku = format.format(pBizDate);

            formatMZenkaku = ConvertUtil.toZenAll(formatMZenkaku, 1, 1);
        }

        logger.debug("△ 個別指定書式用日付編集＃月全角漢字編集 終了");

        return formatMZenkaku;
    }

    public static String formatDZenkakuKanji(BizDate pBizDate) {

        logger.debug("▽ 個別指定書式用日付編集＃日全角漢字編集 開始");

        String formatDZenkaku;

        if (pBizDate == null) {

            formatDZenkaku = "";
        }
        else {

            BizDateFormat format = new BizDateFormat(SEIREKI_KANJI_D_FORMAT, FillStyle.Blank);

            formatDZenkaku = format.format(pBizDate);

            formatDZenkaku = ConvertUtil.toZenAll(formatDZenkaku, 1, 1);
        }

        logger.debug("△ 個別指定書式用日付編集＃日全角漢字編集 終了");

        return formatDZenkaku;
    }
}
