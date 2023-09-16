
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 医務査定要否区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_ImusateiyhKbn</td><td colspan="3">医務査定要否区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>未判定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUYOU}</td><td>&quot;1&quot;</td><td>実施不要</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YOU_KANI}</td><td>&quot;2&quot;</td><td>実施要（簡易）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YOU_KOUDO}</td><td>&quot;3&quot;</td><td>実施要（高度）</td></tr>
 * </table>
 */
public class C_ImusateiyhKbn extends Classification<C_ImusateiyhKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_ImusateiyhKbn NONE = new C_ImusateiyhKbn("0");

    public static final C_ImusateiyhKbn HUYOU = new C_ImusateiyhKbn("1");

    public static final C_ImusateiyhKbn YOU_KANI = new C_ImusateiyhKbn("2");

    public static final C_ImusateiyhKbn YOU_KOUDO = new C_ImusateiyhKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NONE, "NONE", true);
        addPattern(PATTERN_DEFAULT, HUYOU, "HUYOU", false);
        addPattern(PATTERN_DEFAULT, YOU_KANI, "YOU_KANI", false);
        addPattern(PATTERN_DEFAULT, YOU_KOUDO, "YOU_KOUDO", false);


        lock(C_ImusateiyhKbn.class);
    }

    private C_ImusateiyhKbn(String value) {
        super(value);
    }

    public static C_ImusateiyhKbn valueOf(String value) {
        return valueOf(C_ImusateiyhKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_ImusateiyhKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_ImusateiyhKbn.class, patternId, value);
    }
}
