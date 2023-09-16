
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＤＳ商品分類区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_DsSyouhnbunruiKbn</td><td colspan="3">ＤＳ商品分類区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="7">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GKDTITIJIBRSYSN}</td><td>&quot;1&quot;</td><td>外貨建一時払終身</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YENDTITIJIBRSYSN}</td><td>&quot;2&quot;</td><td>円建一時払終身</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GKDTITIJIBRNK}</td><td>&quot;3&quot;</td><td>外貨建一時払年金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GKDTHIJYNBRNK}</td><td>&quot;4&quot;</td><td>外貨建平準払年金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YENDTITIJIBRNK}</td><td>&quot;5&quot;</td><td>円建一時払年金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SNTKDTHIJYNBRSYSN}</td><td>&quot;6&quot;</td><td>選択通貨建平準払終身</td></tr>
 * </table>
 */
public class C_DsSyouhnbunruiKbn extends Classification<C_DsSyouhnbunruiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_DsSyouhnbunruiKbn BLNK = new C_DsSyouhnbunruiKbn("0");

    public static final C_DsSyouhnbunruiKbn GKDTITIJIBRSYSN = new C_DsSyouhnbunruiKbn("1");

    public static final C_DsSyouhnbunruiKbn YENDTITIJIBRSYSN = new C_DsSyouhnbunruiKbn("2");

    public static final C_DsSyouhnbunruiKbn GKDTITIJIBRNK = new C_DsSyouhnbunruiKbn("3");

    public static final C_DsSyouhnbunruiKbn GKDTHIJYNBRNK = new C_DsSyouhnbunruiKbn("4");

    public static final C_DsSyouhnbunruiKbn YENDTITIJIBRNK = new C_DsSyouhnbunruiKbn("5");

    public static final C_DsSyouhnbunruiKbn SNTKDTHIJYNBRSYSN = new C_DsSyouhnbunruiKbn("6");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, GKDTITIJIBRSYSN, "GKDTITIJIBRSYSN", false);
        addPattern(PATTERN_DEFAULT, YENDTITIJIBRSYSN, "YENDTITIJIBRSYSN", false);
        addPattern(PATTERN_DEFAULT, GKDTITIJIBRNK, "GKDTITIJIBRNK", false);
        addPattern(PATTERN_DEFAULT, GKDTHIJYNBRNK, "GKDTHIJYNBRNK", false);
        addPattern(PATTERN_DEFAULT, YENDTITIJIBRNK, "YENDTITIJIBRNK", false);
        addPattern(PATTERN_DEFAULT, SNTKDTHIJYNBRSYSN, "SNTKDTHIJYNBRSYSN", false);


        lock(C_DsSyouhnbunruiKbn.class);
    }

    private C_DsSyouhnbunruiKbn(String value) {
        super(value);
    }

    public static C_DsSyouhnbunruiKbn valueOf(String value) {
        return valueOf(C_DsSyouhnbunruiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_DsSyouhnbunruiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_DsSyouhnbunruiKbn.class, patternId, value);
    }
}
