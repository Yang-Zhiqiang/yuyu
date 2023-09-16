
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 返金方法区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HnknhouKbn</td><td colspan="3">返金方法区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOUKYK_KOUZA}</td><td>&quot;1&quot;</td><td>当契約の口座</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DANTAIHNKN_KOUZA}</td><td>&quot;2&quot;</td><td>団体返金口座</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUZASITEI}</td><td>&quot;3&quot;</td><td>口座指定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KARIUKE}</td><td>&quot;4&quot;</td><td>仮受</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PHURIKZ}</td><td>&quot;5&quot;</td><td>保険料振替口座</td></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_SELECT SELECT}<br />(選択)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PHURIKZ}</td><td>&quot;5&quot;</td><td>保険料振替口座</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUZASITEI}</td><td>&quot;3&quot;</td><td>口座指定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KARIUKE}</td><td>&quot;4&quot;</td><td>仮受</td></tr>
 * </table>
 */
public class C_HnknhouKbn extends Classification<C_HnknhouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HnknhouKbn BLNK = new C_HnknhouKbn("0");

    public static final C_HnknhouKbn TOUKYK_KOUZA = new C_HnknhouKbn("1");

    public static final C_HnknhouKbn DANTAIHNKN_KOUZA = new C_HnknhouKbn("2");

    public static final C_HnknhouKbn KOUZASITEI = new C_HnknhouKbn("3");

    public static final C_HnknhouKbn KARIUKE = new C_HnknhouKbn("4");

    public static final C_HnknhouKbn PHURIKZ = new C_HnknhouKbn("5");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SELECT = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, TOUKYK_KOUZA, "TOUKYK_KOUZA", false);
        addPattern(PATTERN_DEFAULT, DANTAIHNKN_KOUZA, "DANTAIHNKN_KOUZA", false);
        addPattern(PATTERN_DEFAULT, KOUZASITEI, "KOUZASITEI", false);
        addPattern(PATTERN_DEFAULT, KARIUKE, "KARIUKE", false);
        addPattern(PATTERN_DEFAULT, PHURIKZ, "PHURIKZ", false);


        addPattern(PATTERN_SELECT, BLNK, "BLNK", true);
        addPattern(PATTERN_SELECT, PHURIKZ, "PHURIKZ", false);
        addPattern(PATTERN_SELECT, KOUZASITEI, "KOUZASITEI", false);
        addPattern(PATTERN_SELECT, KARIUKE, "KARIUKE", false);


        lock(C_HnknhouKbn.class);
    }

    private C_HnknhouKbn(String value) {
        super(value);
    }

    public static C_HnknhouKbn valueOf(String value) {
        return valueOf(C_HnknhouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HnknhouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HnknhouKbn.class, patternId, value);
    }
}
