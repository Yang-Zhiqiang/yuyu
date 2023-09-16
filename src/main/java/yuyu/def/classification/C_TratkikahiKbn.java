
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 取扱可否区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TratkikahiKbn</td><td colspan="3">取扱可否区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #TRATKIHUKA}</td><td>&quot;0&quot;</td><td>取扱不可</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TRATKIKA}</td><td>&quot;1&quot;</td><td>取扱可</td></tr>
 * </table>
 */
public class C_TratkikahiKbn extends Classification<C_TratkikahiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TratkikahiKbn TRATKIHUKA = new C_TratkikahiKbn("0");

    public static final C_TratkikahiKbn TRATKIKA = new C_TratkikahiKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, TRATKIHUKA, "TRATKIHUKA", true);
        addPattern(PATTERN_DEFAULT, TRATKIKA, "TRATKIKA", false);


        lock(C_TratkikahiKbn.class);
    }

    private C_TratkikahiKbn(String value) {
        super(value);
    }

    public static C_TratkikahiKbn valueOf(String value) {
        return valueOf(C_TratkikahiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TratkikahiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TratkikahiKbn.class, patternId, value);
    }
}
