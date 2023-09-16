
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 決定結果入力要否区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KetkekkayhKbn</td><td colspan="3">決定結果入力要否区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>未判定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JIDOU}</td><td>&quot;1&quot;</td><td>自動決定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YOU}</td><td>&quot;2&quot;</td><td>実施要</td></tr>
 * </table>
 */
public class C_KetkekkayhKbn extends Classification<C_KetkekkayhKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KetkekkayhKbn NONE = new C_KetkekkayhKbn("0");

    public static final C_KetkekkayhKbn JIDOU = new C_KetkekkayhKbn("1");

    public static final C_KetkekkayhKbn YOU = new C_KetkekkayhKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NONE, "NONE", true);
        addPattern(PATTERN_DEFAULT, JIDOU, "JIDOU", false);
        addPattern(PATTERN_DEFAULT, YOU, "YOU", false);


        lock(C_KetkekkayhKbn.class);
    }

    private C_KetkekkayhKbn(String value) {
        super(value);
    }

    public static C_KetkekkayhKbn valueOf(String value) {
        return valueOf(C_KetkekkayhKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KetkekkayhKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KetkekkayhKbn.class, patternId, value);
    }
}
