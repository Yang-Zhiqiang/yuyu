
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 入金区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_NykKbn</td><td colspan="3">入金区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOKAI}</td><td>&quot;1&quot;</td><td>初回</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYO2KAI}</td><td>&quot;2&quot;</td><td>初２回</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JINENDO}</td><td>&quot;3&quot;</td><td>次年度</td></tr>
 * </table>
 */
public class C_NykKbn extends Classification<C_NykKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_NykKbn BLNK = new C_NykKbn("0");

    public static final C_NykKbn SYOKAI = new C_NykKbn("1");

    public static final C_NykKbn SYO2KAI = new C_NykKbn("2");

    public static final C_NykKbn JINENDO = new C_NykKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SYOKAI, "SYOKAI", false);
        addPattern(PATTERN_DEFAULT, SYO2KAI, "SYO2KAI", false);
        addPattern(PATTERN_DEFAULT, JINENDO, "JINENDO", false);


        lock(C_NykKbn.class);
    }

    private C_NykKbn(String value) {
        super(value);
    }

    public static C_NykKbn valueOf(String value) {
        return valueOf(C_NykKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_NykKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_NykKbn.class, patternId, value);
    }
}
