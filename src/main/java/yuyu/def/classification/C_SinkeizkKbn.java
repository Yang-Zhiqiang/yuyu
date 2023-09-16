
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 新規継続区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SinkeizkKbn</td><td colspan="3">新規継続区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SHINKI}</td><td>&quot;1&quot;</td><td>新規</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KEIZOKU}</td><td>&quot;2&quot;</td><td>継続</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HENKOU}</td><td>&quot;3&quot;</td><td>変更</td></tr>
 * </table>
 */
public class C_SinkeizkKbn extends Classification<C_SinkeizkKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SinkeizkKbn BLNK = new C_SinkeizkKbn("0");

    public static final C_SinkeizkKbn SHINKI = new C_SinkeizkKbn("1");

    public static final C_SinkeizkKbn KEIZOKU = new C_SinkeizkKbn("2");

    public static final C_SinkeizkKbn HENKOU = new C_SinkeizkKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SHINKI, "SHINKI", false);
        addPattern(PATTERN_DEFAULT, KEIZOKU, "KEIZOKU", false);
        addPattern(PATTERN_DEFAULT, HENKOU, "HENKOU", false);


        lock(C_SinkeizkKbn.class);
    }

    private C_SinkeizkKbn(String value) {
        super(value);
    }

    public static C_SinkeizkKbn valueOf(String value) {
        return valueOf(C_SinkeizkKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SinkeizkKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SinkeizkKbn.class, patternId, value);
    }
}
