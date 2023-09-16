
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 入金支払区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_NykshrKbn</td><td colspan="3">入金支払区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NYUUKIN}</td><td>&quot;1&quot;</td><td>入金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIHARAI}</td><td>&quot;2&quot;</td><td>支払</td></tr>
 * </table>
 */
public class C_NykshrKbn extends Classification<C_NykshrKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_NykshrKbn BLNK = new C_NykshrKbn("0");

    public static final C_NykshrKbn NYUUKIN = new C_NykshrKbn("1");

    public static final C_NykshrKbn SIHARAI = new C_NykshrKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, NYUUKIN, "NYUUKIN", false);
        addPattern(PATTERN_DEFAULT, SIHARAI, "SIHARAI", false);


        lock(C_NykshrKbn.class);
    }

    private C_NykshrKbn(String value) {
        super(value);
    }

    public static C_NykshrKbn valueOf(String value) {
        return valueOf(C_NykshrKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_NykshrKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_NykshrKbn.class, patternId, value);
    }
}
