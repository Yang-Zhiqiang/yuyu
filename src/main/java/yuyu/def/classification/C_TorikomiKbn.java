
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 取込区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TorikomiKbn</td><td colspan="3">取込区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TUUJYOU}</td><td>&quot;1&quot;</td><td>通常取込</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAI}</td><td>&quot;2&quot;</td><td>再取込</td></tr>
 *  <tr><td rowspan="1">{@link #PATTERN_TORIKOMI TORIKOMI}<br />(取込)</td><td align="center">&nbsp;</td><td>{@link #TUUJYOU}</td><td>&quot;1&quot;</td><td>通常取込</td></tr>
 * </table>
 */
public class C_TorikomiKbn extends Classification<C_TorikomiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TorikomiKbn BLNK = new C_TorikomiKbn("0");

    public static final C_TorikomiKbn TUUJYOU = new C_TorikomiKbn("1");

    public static final C_TorikomiKbn SAI = new C_TorikomiKbn("2");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_TORIKOMI = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, TUUJYOU, "TUUJYOU", false);
        addPattern(PATTERN_DEFAULT, SAI, "SAI", false);


        addPattern(PATTERN_TORIKOMI, TUUJYOU, "TUUJYOU", false);


        lock(C_TorikomiKbn.class);
    }

    private C_TorikomiKbn(String value) {
        super(value);
    }

    public static C_TorikomiKbn valueOf(String value) {
        return valueOf(C_TorikomiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TorikomiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TorikomiKbn.class, patternId, value);
    }
}
