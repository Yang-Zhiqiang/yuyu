
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 高度障害Ｓ支払状態区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KdssSiharaiJyoutaiKbn</td><td colspan="3">高度障害Ｓ支払状態区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">&nbsp;</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIHARAI}</td><td>&quot;1&quot;</td><td>支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MENSEKI}</td><td>&quot;2&quot;</td><td>免責</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HIGAITOU}</td><td>&quot;4&quot;</td><td>非該当</td></tr>
 * </table>
 */
public class C_KdssSiharaiJyoutaiKbn extends Classification<C_KdssSiharaiJyoutaiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KdssSiharaiJyoutaiKbn BLNK = new C_KdssSiharaiJyoutaiKbn("0");

    public static final C_KdssSiharaiJyoutaiKbn SIHARAI = new C_KdssSiharaiJyoutaiKbn("1");

    public static final C_KdssSiharaiJyoutaiKbn MENSEKI = new C_KdssSiharaiJyoutaiKbn("2");

    public static final C_KdssSiharaiJyoutaiKbn HIGAITOU = new C_KdssSiharaiJyoutaiKbn("4");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", false);
        addPattern(PATTERN_DEFAULT, SIHARAI, "SIHARAI", false);
        addPattern(PATTERN_DEFAULT, MENSEKI, "MENSEKI", false);
        addPattern(PATTERN_DEFAULT, HIGAITOU, "HIGAITOU", false);


        lock(C_KdssSiharaiJyoutaiKbn.class);
    }

    private C_KdssSiharaiJyoutaiKbn(String value) {
        super(value);
    }

    public static C_KdssSiharaiJyoutaiKbn valueOf(String value) {
        return valueOf(C_KdssSiharaiJyoutaiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KdssSiharaiJyoutaiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KdssSiharaiJyoutaiKbn.class, patternId, value);
    }
}
