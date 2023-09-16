
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 遅延利息端数処理 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Tienrskhasuusyori</td><td colspan="3">遅延利息端数処理</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ROUNDUP}</td><td>&quot;1&quot;</td><td>切り上げ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ROUNDDOWN}</td><td>&quot;2&quot;</td><td>切り捨て</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ROUND}</td><td>&quot;3&quot;</td><td>四捨五入</td></tr>
 * </table>
 */
public class C_Tienrskhasuusyori extends Classification<C_Tienrskhasuusyori> {

    private static final long serialVersionUID = 1L;


    public static final C_Tienrskhasuusyori BLNK = new C_Tienrskhasuusyori("0");

    public static final C_Tienrskhasuusyori ROUNDUP = new C_Tienrskhasuusyori("1");

    public static final C_Tienrskhasuusyori ROUNDDOWN = new C_Tienrskhasuusyori("2");

    public static final C_Tienrskhasuusyori ROUND = new C_Tienrskhasuusyori("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, ROUNDUP, "ROUNDUP", false);
        addPattern(PATTERN_DEFAULT, ROUNDDOWN, "ROUNDDOWN", false);
        addPattern(PATTERN_DEFAULT, ROUND, "ROUND", false);


        lock(C_Tienrskhasuusyori.class);
    }

    private C_Tienrskhasuusyori(String value) {
        super(value);
    }

    public static C_Tienrskhasuusyori valueOf(String value) {
        return valueOf(C_Tienrskhasuusyori.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Tienrskhasuusyori.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Tienrskhasuusyori.class, patternId, value);
    }
}
