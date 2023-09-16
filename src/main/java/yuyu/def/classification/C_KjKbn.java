
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * K・J区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KjKbn</td><td colspan="3">K・J区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #K}</td><td>&quot;1&quot;</td><td>K</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #J}</td><td>&quot;2&quot;</td><td>J</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #M}</td><td>&quot;3&quot;</td><td>M</td></tr>
 * </table>
 */
public class C_KjKbn extends Classification<C_KjKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KjKbn BLNK = new C_KjKbn("0");

    public static final C_KjKbn K = new C_KjKbn("1");

    public static final C_KjKbn J = new C_KjKbn("2");

    public static final C_KjKbn M = new C_KjKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, K, "K", false);
        addPattern(PATTERN_DEFAULT, J, "J", false);
        addPattern(PATTERN_DEFAULT, M, "M", false);


        lock(C_KjKbn.class);
    }

    private C_KjKbn(String value) {
        super(value);
    }

    public static C_KjKbn valueOf(String value) {
        return valueOf(C_KjKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KjKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KjKbn.class, patternId, value);
    }
}
