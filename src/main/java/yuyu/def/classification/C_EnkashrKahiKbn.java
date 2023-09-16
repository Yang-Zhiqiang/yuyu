
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 円貨支払可否区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_EnkashrKahiKbn</td><td colspan="3">円貨支払可否区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #HUKA}</td><td>&quot;0&quot;</td><td>不可</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KA}</td><td>&quot;1&quot;</td><td>可</td></tr>
 * </table>
 */
public class C_EnkashrKahiKbn extends Classification<C_EnkashrKahiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_EnkashrKahiKbn HUKA = new C_EnkashrKahiKbn("0");

    public static final C_EnkashrKahiKbn KA = new C_EnkashrKahiKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, HUKA, "HUKA", true);
        addPattern(PATTERN_DEFAULT, KA, "KA", false);


        lock(C_EnkashrKahiKbn.class);
    }

    private C_EnkashrKahiKbn(String value) {
        super(value);
    }

    public static C_EnkashrKahiKbn valueOf(String value) {
        return valueOf(C_EnkashrKahiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_EnkashrKahiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_EnkashrKahiKbn.class, patternId, value);
    }
}
