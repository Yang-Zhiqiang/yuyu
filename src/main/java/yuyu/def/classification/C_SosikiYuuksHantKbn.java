
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 組織有効性判定区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SosikiYuuksHantKbn</td><td colspan="3">組織有効性判定区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #OK}</td><td>&quot;0&quot;</td><td>有効性ＯＫ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NG}</td><td>&quot;1&quot;</td><td>有効性ＮＧ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HANTEIHUKA}</td><td>&quot;2&quot;</td><td>判定不可</td></tr>
 * </table>
 */
public class C_SosikiYuuksHantKbn extends Classification<C_SosikiYuuksHantKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SosikiYuuksHantKbn OK = new C_SosikiYuuksHantKbn("0");

    public static final C_SosikiYuuksHantKbn NG = new C_SosikiYuuksHantKbn("1");

    public static final C_SosikiYuuksHantKbn HANTEIHUKA = new C_SosikiYuuksHantKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, OK, "OK", true);
        addPattern(PATTERN_DEFAULT, NG, "NG", false);
        addPattern(PATTERN_DEFAULT, HANTEIHUKA, "HANTEIHUKA", false);


        lock(C_SosikiYuuksHantKbn.class);
    }

    private C_SosikiYuuksHantKbn(String value) {
        super(value);
    }

    public static C_SosikiYuuksHantKbn valueOf(String value) {
        return valueOf(C_SosikiYuuksHantKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SosikiYuuksHantKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SosikiYuuksHantKbn.class, patternId, value);
    }
}
