
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 発信区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HassinKbn</td><td colspan="3">発信区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #MIHASSIN}</td><td>&quot;0&quot;</td><td>未発信</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HASSINZUMI}</td><td>&quot;1&quot;</td><td>発信済</td></tr>
 * </table>
 */
public class C_HassinKbn extends Classification<C_HassinKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HassinKbn MIHASSIN = new C_HassinKbn("0");

    public static final C_HassinKbn HASSINZUMI = new C_HassinKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, MIHASSIN, "MIHASSIN", true);
        addPattern(PATTERN_DEFAULT, HASSINZUMI, "HASSINZUMI", false);


        lock(C_HassinKbn.class);
    }

    private C_HassinKbn(String value) {
        super(value);
    }

    public static C_HassinKbn valueOf(String value) {
        return valueOf(C_HassinKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HassinKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HassinKbn.class, patternId, value);
    }
}
