
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 保険契約異動情報払方区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KykIdouHaraikataKbn</td><td colspan="3">保険契約異動情報払方区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NEN}</td><td>&quot;1&quot;</td><td>年１回払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HALFY}</td><td>&quot;2&quot;</td><td>年２回払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TUKI}</td><td>&quot;3&quot;</td><td>月払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ITIJI}</td><td>&quot;4&quot;</td><td>一時払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZENNOU}</td><td>&quot;5&quot;</td><td>前納</td></tr>
 * </table>
 */
public class C_KykIdouHaraikataKbn extends Classification<C_KykIdouHaraikataKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KykIdouHaraikataKbn BLNK = new C_KykIdouHaraikataKbn("0");

    public static final C_KykIdouHaraikataKbn NEN = new C_KykIdouHaraikataKbn("1");

    public static final C_KykIdouHaraikataKbn HALFY = new C_KykIdouHaraikataKbn("2");

    public static final C_KykIdouHaraikataKbn TUKI = new C_KykIdouHaraikataKbn("3");

    public static final C_KykIdouHaraikataKbn ITIJI = new C_KykIdouHaraikataKbn("4");

    public static final C_KykIdouHaraikataKbn ZENNOU = new C_KykIdouHaraikataKbn("5");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, NEN, "NEN", false);
        addPattern(PATTERN_DEFAULT, HALFY, "HALFY", false);
        addPattern(PATTERN_DEFAULT, TUKI, "TUKI", false);
        addPattern(PATTERN_DEFAULT, ITIJI, "ITIJI", false);
        addPattern(PATTERN_DEFAULT, ZENNOU, "ZENNOU", false);


        lock(C_KykIdouHaraikataKbn.class);
    }

    private C_KykIdouHaraikataKbn(String value) {
        super(value);
    }

    public static C_KykIdouHaraikataKbn valueOf(String value) {
        return valueOf(C_KykIdouHaraikataKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KykIdouHaraikataKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KykIdouHaraikataKbn.class, patternId, value);
    }
}
