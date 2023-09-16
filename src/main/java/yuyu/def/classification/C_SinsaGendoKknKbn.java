
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 審査限度期間区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SinsaGendoKknKbn</td><td colspan="3">審査限度期間区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BD5}</td><td>&quot;5&quot;</td><td>５営業日</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #D45}</td><td>&quot;45&quot;</td><td>４５日</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #D180}</td><td>&quot;180&quot;</td><td>１８０日</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_SELECT SELECT}<br />(選択)</td><td align="center">○</td><td>{@link #BD5}</td><td>&quot;5&quot;</td><td>５営業日</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #D45}</td><td>&quot;45&quot;</td><td>４５日</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #D180}</td><td>&quot;180&quot;</td><td>１８０日</td></tr>
 * </table>
 */
public class C_SinsaGendoKknKbn extends Classification<C_SinsaGendoKknKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SinsaGendoKknKbn BLNK = new C_SinsaGendoKknKbn("0");

    public static final C_SinsaGendoKknKbn BD5 = new C_SinsaGendoKknKbn("5");

    public static final C_SinsaGendoKknKbn D45 = new C_SinsaGendoKknKbn("45");

    public static final C_SinsaGendoKknKbn D180 = new C_SinsaGendoKknKbn("180");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SELECT = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, BD5, "BD5", false);
        addPattern(PATTERN_DEFAULT, D45, "D45", false);
        addPattern(PATTERN_DEFAULT, D180, "D180", false);


        addPattern(PATTERN_SELECT, BD5, "BD5", true);
        addPattern(PATTERN_SELECT, D45, "D45", false);
        addPattern(PATTERN_SELECT, D180, "D180", false);


        lock(C_SinsaGendoKknKbn.class);
    }

    private C_SinsaGendoKknKbn(String value) {
        super(value);
    }

    public static C_SinsaGendoKknKbn valueOf(String value) {
        return valueOf(C_SinsaGendoKknKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SinsaGendoKknKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SinsaGendoKknKbn.class, patternId, value);
    }
}
