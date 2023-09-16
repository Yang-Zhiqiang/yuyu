
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 継続区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KzkKbn</td><td colspan="3">継続区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #HUKA}</td><td>&quot;0&quot;</td><td>不可</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KA}</td><td>&quot;1&quot;</td><td>可</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUMON}</td><td>&quot;2&quot;</td><td>不問</td></tr>
 * </table>
 */
public class C_KzkKbn extends Classification<C_KzkKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KzkKbn HUKA = new C_KzkKbn("0");

    public static final C_KzkKbn KA = new C_KzkKbn("1");

    public static final C_KzkKbn HUMON = new C_KzkKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, HUKA, "HUKA", true);
        addPattern(PATTERN_DEFAULT, KA, "KA", false);
        addPattern(PATTERN_DEFAULT, HUMON, "HUMON", false);


        lock(C_KzkKbn.class);
    }

    private C_KzkKbn(String value) {
        super(value);
    }

    public static C_KzkKbn valueOf(String value) {
        return valueOf(C_KzkKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KzkKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KzkKbn.class, patternId, value);
    }
}
