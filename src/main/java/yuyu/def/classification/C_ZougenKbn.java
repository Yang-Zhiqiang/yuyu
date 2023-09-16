
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 増減区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_ZougenKbn</td><td colspan="3">増減区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #ZOU}</td><td>&quot;1&quot;</td><td>増</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GEN}</td><td>&quot;2&quot;</td><td>減</td></tr>
 * </table>
 */
public class C_ZougenKbn extends Classification<C_ZougenKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_ZougenKbn ZOU = new C_ZougenKbn("1");

    public static final C_ZougenKbn GEN = new C_ZougenKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, ZOU, "ZOU", true);
        addPattern(PATTERN_DEFAULT, GEN, "GEN", false);


        lock(C_ZougenKbn.class);
    }

    private C_ZougenKbn(String value) {
        super(value);
    }

    public static C_ZougenKbn valueOf(String value) {
        return valueOf(C_ZougenKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_ZougenKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_ZougenKbn.class, patternId, value);
    }
}
