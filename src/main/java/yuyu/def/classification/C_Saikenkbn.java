
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 債権区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Saikenkbn</td><td colspan="3">債権区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAIKEN}</td><td>&quot;1&quot;</td><td>債権</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SASIOSAE}</td><td>&quot;2&quot;</td><td>差押</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HASAN}</td><td>&quot;3&quot;</td><td>破産</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;9&quot;</td><td>その他</td></tr>
 * </table>
 */
public class C_Saikenkbn extends Classification<C_Saikenkbn> {

    private static final long serialVersionUID = 1L;


    public static final C_Saikenkbn BLNK = new C_Saikenkbn("0");

    public static final C_Saikenkbn SAIKEN = new C_Saikenkbn("1");

    public static final C_Saikenkbn SASIOSAE = new C_Saikenkbn("2");

    public static final C_Saikenkbn HASAN = new C_Saikenkbn("3");

    public static final C_Saikenkbn SONOTA = new C_Saikenkbn("9");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SAIKEN, "SAIKEN", false);
        addPattern(PATTERN_DEFAULT, SASIOSAE, "SASIOSAE", false);
        addPattern(PATTERN_DEFAULT, HASAN, "HASAN", false);
        addPattern(PATTERN_DEFAULT, SONOTA, "SONOTA", false);


        lock(C_Saikenkbn.class);
    }

    private C_Saikenkbn(String value) {
        super(value);
    }

    public static C_Saikenkbn valueOf(String value) {
        return valueOf(C_Saikenkbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Saikenkbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Saikenkbn.class, patternId, value);
    }
}
