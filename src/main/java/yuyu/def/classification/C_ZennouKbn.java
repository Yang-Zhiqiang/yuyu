
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 前納区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_ZennouKbn</td><td colspan="3">前納区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IPPAN_ZENNOU}</td><td>&quot;1&quot;</td><td>一般前納</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TKBT_ZENNOU}</td><td>&quot;2&quot;</td><td>特別前納</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TKYKP_ZENNOU}</td><td>&quot;3&quot;</td><td>特約Ｐ前納</td></tr>
 * </table>
 */
public class C_ZennouKbn extends Classification<C_ZennouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_ZennouKbn BLNK = new C_ZennouKbn("0");

    public static final C_ZennouKbn IPPAN_ZENNOU = new C_ZennouKbn("1");

    public static final C_ZennouKbn TKBT_ZENNOU = new C_ZennouKbn("2");

    public static final C_ZennouKbn TKYKP_ZENNOU = new C_ZennouKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, IPPAN_ZENNOU, "IPPAN_ZENNOU", false);
        addPattern(PATTERN_DEFAULT, TKBT_ZENNOU, "TKBT_ZENNOU", false);
        addPattern(PATTERN_DEFAULT, TKYKP_ZENNOU, "TKYKP_ZENNOU", false);


        lock(C_ZennouKbn.class);
    }

    private C_ZennouKbn(String value) {
        super(value);
    }

    public static C_ZennouKbn valueOf(String value) {
        return valueOf(C_ZennouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_ZennouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_ZennouKbn.class, patternId, value);
    }
}
