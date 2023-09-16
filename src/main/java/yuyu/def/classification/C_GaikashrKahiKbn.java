
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 外貨支払可否区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_GaikashrKahiKbn</td><td colspan="3">外貨支払可否区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #HUKA}</td><td>&quot;0&quot;</td><td>不可</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KA}</td><td>&quot;1&quot;</td><td>可</td></tr>
 * </table>
 */
public class C_GaikashrKahiKbn extends Classification<C_GaikashrKahiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_GaikashrKahiKbn HUKA = new C_GaikashrKahiKbn("0");

    public static final C_GaikashrKahiKbn KA = new C_GaikashrKahiKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, HUKA, "HUKA", true);
        addPattern(PATTERN_DEFAULT, KA, "KA", false);


        lock(C_GaikashrKahiKbn.class);
    }

    private C_GaikashrKahiKbn(String value) {
        super(value);
    }

    public static C_GaikashrKahiKbn valueOf(String value) {
        return valueOf(C_GaikashrKahiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_GaikashrKahiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_GaikashrKahiKbn.class, patternId, value);
    }
}
