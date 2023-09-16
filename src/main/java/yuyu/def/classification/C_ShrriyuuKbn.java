
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 支払理由区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_ShrriyuuKbn</td><td colspan="3">支払理由区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="8">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NIZYUNYKN}</td><td>&quot;1&quot;</td><td>二重入金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAZYOUNYKN}</td><td>&quot;2&quot;</td><td>過剰入金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HARAIKOMIHUYOU}</td><td>&quot;3&quot;</td><td>払込不要</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HRHNGONYKN}</td><td>&quot;4&quot;</td><td>払込方法変更後入金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OHTHER_MOUSIDE}</td><td>&quot;5&quot;</td><td>その他（申し出返金）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YUYOKKNGONYKN}</td><td>&quot;6&quot;</td><td>猶予期間後入金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OHTHER}</td><td>&quot;9&quot;</td><td>その他</td></tr>
 * </table>
 */
public class C_ShrriyuuKbn extends Classification<C_ShrriyuuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_ShrriyuuKbn BLNK = new C_ShrriyuuKbn("0");

    public static final C_ShrriyuuKbn NIZYUNYKN = new C_ShrriyuuKbn("1");

    public static final C_ShrriyuuKbn KAZYOUNYKN = new C_ShrriyuuKbn("2");

    public static final C_ShrriyuuKbn HARAIKOMIHUYOU = new C_ShrriyuuKbn("3");

    public static final C_ShrriyuuKbn HRHNGONYKN = new C_ShrriyuuKbn("4");

    public static final C_ShrriyuuKbn OHTHER_MOUSIDE = new C_ShrriyuuKbn("5");

    public static final C_ShrriyuuKbn YUYOKKNGONYKN = new C_ShrriyuuKbn("6");

    public static final C_ShrriyuuKbn OHTHER = new C_ShrriyuuKbn("9");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, NIZYUNYKN, "NIZYUNYKN", false);
        addPattern(PATTERN_DEFAULT, KAZYOUNYKN, "KAZYOUNYKN", false);
        addPattern(PATTERN_DEFAULT, HARAIKOMIHUYOU, "HARAIKOMIHUYOU", false);
        addPattern(PATTERN_DEFAULT, HRHNGONYKN, "HRHNGONYKN", false);
        addPattern(PATTERN_DEFAULT, OHTHER_MOUSIDE, "OHTHER_MOUSIDE", false);
        addPattern(PATTERN_DEFAULT, YUYOKKNGONYKN, "YUYOKKNGONYKN", false);
        addPattern(PATTERN_DEFAULT, OHTHER, "OHTHER", false);


        lock(C_ShrriyuuKbn.class);
    }

    private C_ShrriyuuKbn(String value) {
        super(value);
    }

    public static C_ShrriyuuKbn valueOf(String value) {
        return valueOf(C_ShrriyuuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_ShrriyuuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_ShrriyuuKbn.class, patternId, value);
    }
}
