package yuyu.common.base.format;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * BizDateFormatter クラスです。
 */
public class BizDateFormatter extends Classification<BizDateFormatter> {

    private static final long serialVersionUID = 1L;

    public static final BizDateFormatter seirekiCommaYMDFormat = new BizDateFormatter("yyyy.MM.dd");

    public static final BizDateFormatter seirekiCommaYMFormat = new BizDateFormatter("yyyy.MM");

    public static final BizDateFormatter commaMDFormat = new BizDateFormatter("MM.dd");

    public static final BizDateFormatter seirekiYFormat = new BizDateFormatter("yyyy");

    public static final BizDateFormatter warekiSymbolCommaYMDFormat = new BizDateFormatter("Gyy.MM.dd");

    public static final BizDateFormatter warekiSymbolCommaYMFormat = new BizDateFormatter("Gyy.MM");

    public static final BizDateFormatter warekiSymbolYFormat = new BizDateFormatter("Gyy");

    public static final BizDateFormatter warekiKanjiCommaYMDFormat = new BizDateFormatter("GGyy.MM.dd");

    public static final BizDateFormatter warekiKanjiCommaYMFormat = new BizDateFormatter("GGyy.MM");

    public static final BizDateFormatter warekiKanjiYFormat = new BizDateFormatter("GGyy");

    public static final BizDateFormatter seirekiSlashYMDFormat = new BizDateFormatter("yyyy/MM/dd");

    public static final BizDateFormatter seirekiSlashYMFormat = new BizDateFormatter("yyyy/MM");

    public static final BizDateFormatter slashMDFormat = new BizDateFormatter("MM/dd");

    public static final BizDateFormatter warekiSymbolSlashYMDFormat = new BizDateFormatter("Gyy/MM/dd");

    public static final BizDateFormatter warekiSymbolSlashYMFormat = new BizDateFormatter("Gyy/MM");

    public static final BizDateFormatter warekiKanjiSlashYMDFormat = new BizDateFormatter("GGyy/MM/dd");

    public static final BizDateFormatter warekiKanjiSlashYMFormat = new BizDateFormatter("GGyy/MM");

    public static final BizDateFormatter seirekiKanjiYMDFormat = new BizDateFormatter("yyyy年MM月dd日");

    public static final BizDateFormatter seirekiKanjiYMFormat = new BizDateFormatter("yyyy年MM月");

    public static final BizDateFormatter kanjiMDFormat = new BizDateFormatter("MM月dd日");

    public static final BizDateFormatter seirekiKanjiYFormat = new BizDateFormatter("yyyy年");

    public static final BizDateFormatter warekiSymbolKanjiYMDFormat = new BizDateFormatter("Gyy年MM月dd日");

    public static final BizDateFormatter warekiSymbolKanjiYMFormat = new BizDateFormatter("Gyy年MM月");

    public static final BizDateFormatter warekiSymbolKanjiYFormat = new BizDateFormatter("Gyy年");

    public static final BizDateFormatter warekiKanjiKanjiYMDFormat = new BizDateFormatter("GGyy年MM月dd日");

    public static final BizDateFormatter warekiKanjiKanjiYMFormat = new BizDateFormatter("GGyy年MM月");

    public static final BizDateFormatter warekiKanjiKanjiYFormat = new BizDateFormatter("GGyy年");

    private BizDateFormatter(String pValue) {
        super(pValue);
    }

    public static BizDateFormatter valueOf(String pValue) {
        return valueOf(BizDateFormatter.class, pValue);
    }

}
