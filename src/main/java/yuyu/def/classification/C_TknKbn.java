
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 特認区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TknKbn</td><td colspan="3">特認区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>特認なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANOU}</td><td>&quot;1&quot;</td><td>特認可能</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SUMI}</td><td>&quot;2&quot;</td><td>特認済</td></tr>
 * </table>
 */
public class C_TknKbn extends Classification<C_TknKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TknKbn NONE = new C_TknKbn("0");

    public static final C_TknKbn KANOU = new C_TknKbn("1");

    public static final C_TknKbn SUMI = new C_TknKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NONE, "NONE", true);
        addPattern(PATTERN_DEFAULT, KANOU, "KANOU", false);
        addPattern(PATTERN_DEFAULT, SUMI, "SUMI", false);


        lock(C_TknKbn.class);
    }

    private C_TknKbn(String value) {
        super(value);
    }

    public static C_TknKbn valueOf(String value) {
        return valueOf(C_TknKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TknKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TknKbn.class, patternId, value);
    }
}
