package yuyu.common.base.format;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateConfig;
import jp.co.slcs.swak.date.BizDateFormat;
import jp.co.slcs.swak.date.SeirekiWarekiKbn;

/**
 * BizDateを各処理のフォーマットに従って系変換処理を行うクラスです。
 */
public class BizDateFormatUtil {

    private static final BizDateFormat FORMAT_SEIREKI = new BizDateFormat(BizDateConfig.getInstance().getSeireki().getBizDateDefaultFormat());

    private static final BizDateFormat FORMAT_WAREKI = new BizDateFormat(BizDateConfig.getInstance().getWareki().getBizDateDefaultFormat());

    public static String toFormatedYmd(BizDate pBizDate) {

        SeirekiWarekiKbn kbn = BizDateConfig.getInstance().getSeirekiWarekiKbn();


        switch (kbn) {
            case SEIREKI:
                return FORMAT_SEIREKI.format(pBizDate);

            case WAREKI_KANJI:
            case WAREKI_INPUT:
            case WAREKI_SYMBOL:
                return FORMAT_WAREKI.format(pBizDate);
            default:
                throw new RuntimeException("西暦和暦区分が不正です。 設定値 = " + kbn);
        }

    }

    public static String toFormatedYmd(BizDate pBizDate, BizDateFormatter pBizDateFormatter) {

        return new BizDateFormat(pBizDateFormatter.toString()).format(pBizDate);

    }

    public static String toFormatedCommaYmd(BizDate pBizDate) {

        SeirekiWarekiKbn kbn = BizDateConfig.getInstance().getSeirekiWarekiKbn();

        switch (kbn) {
            case SEIREKI:
                return BizDateFormatUtil.toFormatedYmd(pBizDate, BizDateFormatter.seirekiCommaYMDFormat);

            case WAREKI_KANJI:
                return BizDateFormatUtil.toFormatedYmd(pBizDate, BizDateFormatter.warekiKanjiCommaYMDFormat);

            case WAREKI_INPUT:
                return BizDateFormatUtil.toFormatedYmd(pBizDate, BizDateFormatter.warekiSymbolCommaYMDFormat);

            case WAREKI_SYMBOL:
                return BizDateFormatUtil.toFormatedYmd(pBizDate, BizDateFormatter.warekiSymbolCommaYMDFormat);

            default:
                throw new RuntimeException("西暦和暦区分が不正です。 設定値 = " + kbn);
        }

    }

}
