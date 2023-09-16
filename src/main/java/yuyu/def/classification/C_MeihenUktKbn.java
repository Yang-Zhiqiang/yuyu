
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 名義変更受取人区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_MeihenUktKbn</td><td colspan="3">名義変更受取人区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DOUITU}</td><td>&quot;1&quot;</td><td>名義同一</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SOUI}</td><td>&quot;2&quot;</td><td>名義相違</td></tr>
 * </table>
 */
public class C_MeihenUktKbn extends Classification<C_MeihenUktKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_MeihenUktKbn BLNK = new C_MeihenUktKbn("0");

    public static final C_MeihenUktKbn DOUITU = new C_MeihenUktKbn("1");

    public static final C_MeihenUktKbn SOUI = new C_MeihenUktKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, DOUITU, "DOUITU", false);
        addPattern(PATTERN_DEFAULT, SOUI, "SOUI", false);


        lock(C_MeihenUktKbn.class);
    }

    private C_MeihenUktKbn(String value) {
        super(value);
    }

    public static C_MeihenUktKbn valueOf(String value) {
        return valueOf(C_MeihenUktKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_MeihenUktKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_MeihenUktKbn.class, patternId, value);
    }
}
