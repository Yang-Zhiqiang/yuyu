
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 支払結果区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_ShrKekkaKbn</td><td colspan="3">支払結果区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="7">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SHR}</td><td>&quot;1&quot;</td><td>支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HSHR}</td><td>&quot;2&quot;</td><td>非該当</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ITIBU_SHR}</td><td>&quot;3&quot;</td><td>一部支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TSSHR}</td><td>&quot;4&quot;</td><td>特殊支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NENKINSHR}</td><td>&quot;5&quot;</td><td>年金支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ITIBU_NENKIN}</td><td>&quot;6&quot;</td><td>一部年金</td></tr>
 * </table>
 */
public class C_ShrKekkaKbn extends Classification<C_ShrKekkaKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_ShrKekkaKbn BLNK = new C_ShrKekkaKbn("0");

    public static final C_ShrKekkaKbn SHR = new C_ShrKekkaKbn("1");

    public static final C_ShrKekkaKbn HSHR = new C_ShrKekkaKbn("2");

    public static final C_ShrKekkaKbn ITIBU_SHR = new C_ShrKekkaKbn("3");

    public static final C_ShrKekkaKbn TSSHR = new C_ShrKekkaKbn("4");

    public static final C_ShrKekkaKbn NENKINSHR = new C_ShrKekkaKbn("5");

    public static final C_ShrKekkaKbn ITIBU_NENKIN = new C_ShrKekkaKbn("6");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SHR, "SHR", false);
        addPattern(PATTERN_DEFAULT, HSHR, "HSHR", false);
        addPattern(PATTERN_DEFAULT, ITIBU_SHR, "ITIBU_SHR", false);
        addPattern(PATTERN_DEFAULT, TSSHR, "TSSHR", false);
        addPattern(PATTERN_DEFAULT, NENKINSHR, "NENKINSHR", false);
        addPattern(PATTERN_DEFAULT, ITIBU_NENKIN, "ITIBU_NENKIN", false);


        lock(C_ShrKekkaKbn.class);
    }

    private C_ShrKekkaKbn(String value) {
        super(value);
    }

    public static C_ShrKekkaKbn valueOf(String value) {
        return valueOf(C_ShrKekkaKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_ShrKekkaKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_ShrKekkaKbn.class, patternId, value);
    }
}
