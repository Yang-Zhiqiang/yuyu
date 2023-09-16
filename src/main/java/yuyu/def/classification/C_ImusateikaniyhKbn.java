
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 医務査定（簡易）要否区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_ImusateikaniyhKbn</td><td colspan="3">医務査定（簡易）要否区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>未判定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUYOU}</td><td>&quot;1&quot;</td><td>実施不要</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YOU_KANI_UW}</td><td>&quot;2&quot;</td><td>実施要（簡易（ＵＷ））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YOU_KANI_MD}</td><td>&quot;3&quot;</td><td>実施要（簡易（ＭＤ））</td></tr>
 * </table>
 */
public class C_ImusateikaniyhKbn extends Classification<C_ImusateikaniyhKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_ImusateikaniyhKbn NONE = new C_ImusateikaniyhKbn("0");

    public static final C_ImusateikaniyhKbn HUYOU = new C_ImusateikaniyhKbn("1");

    public static final C_ImusateikaniyhKbn YOU_KANI_UW = new C_ImusateikaniyhKbn("2");

    public static final C_ImusateikaniyhKbn YOU_KANI_MD = new C_ImusateikaniyhKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NONE, "NONE", true);
        addPattern(PATTERN_DEFAULT, HUYOU, "HUYOU", false);
        addPattern(PATTERN_DEFAULT, YOU_KANI_UW, "YOU_KANI_UW", false);
        addPattern(PATTERN_DEFAULT, YOU_KANI_MD, "YOU_KANI_MD", false);


        lock(C_ImusateikaniyhKbn.class);
    }

    private C_ImusateikaniyhKbn(String value) {
        super(value);
    }

    public static C_ImusateikaniyhKbn valueOf(String value) {
        return valueOf(C_ImusateikaniyhKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_ImusateikaniyhKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_ImusateikaniyhKbn.class, patternId, value);
    }
}
