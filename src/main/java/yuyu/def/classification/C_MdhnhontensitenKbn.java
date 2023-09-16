
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 窓販本店支店区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_MdhnhontensitenKbn</td><td colspan="3">窓販本店支店区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>設定なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HONTEN}</td><td>&quot;1&quot;</td><td>本店</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SITEN}</td><td>&quot;2&quot;</td><td>支店</td></tr>
 * </table>
 */
public class C_MdhnhontensitenKbn extends Classification<C_MdhnhontensitenKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_MdhnhontensitenKbn NONE = new C_MdhnhontensitenKbn("0");

    public static final C_MdhnhontensitenKbn HONTEN = new C_MdhnhontensitenKbn("1");

    public static final C_MdhnhontensitenKbn SITEN = new C_MdhnhontensitenKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NONE, "NONE", true);
        addPattern(PATTERN_DEFAULT, HONTEN, "HONTEN", false);
        addPattern(PATTERN_DEFAULT, SITEN, "SITEN", false);


        lock(C_MdhnhontensitenKbn.class);
    }

    private C_MdhnhontensitenKbn(String value) {
        super(value);
    }

    public static C_MdhnhontensitenKbn valueOf(String value) {
        return valueOf(C_MdhnhontensitenKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_MdhnhontensitenKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_MdhnhontensitenKbn.class, patternId, value);
    }
}
