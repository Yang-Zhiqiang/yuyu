
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 振替案内状況区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HrkeAnnaiJkKbn</td><td colspan="3">振替案内状況区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ANNAITYUU}</td><td>&quot;1&quot;</td><td>案内中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TYAKKINARI}</td><td>&quot;2&quot;</td><td>着金あり</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TORIKESI}</td><td>&quot;3&quot;</td><td>取消</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIJO}</td><td>&quot;4&quot;</td><td>解除</td></tr>
 * </table>
 */
public class C_HrkeAnnaiJkKbn extends Classification<C_HrkeAnnaiJkKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HrkeAnnaiJkKbn BLNK = new C_HrkeAnnaiJkKbn("0");

    public static final C_HrkeAnnaiJkKbn ANNAITYUU = new C_HrkeAnnaiJkKbn("1");

    public static final C_HrkeAnnaiJkKbn TYAKKINARI = new C_HrkeAnnaiJkKbn("2");

    public static final C_HrkeAnnaiJkKbn TORIKESI = new C_HrkeAnnaiJkKbn("3");

    public static final C_HrkeAnnaiJkKbn KAIJO = new C_HrkeAnnaiJkKbn("4");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, ANNAITYUU, "ANNAITYUU", false);
        addPattern(PATTERN_DEFAULT, TYAKKINARI, "TYAKKINARI", false);
        addPattern(PATTERN_DEFAULT, TORIKESI, "TORIKESI", false);
        addPattern(PATTERN_DEFAULT, KAIJO, "KAIJO", false);


        lock(C_HrkeAnnaiJkKbn.class);
    }

    private C_HrkeAnnaiJkKbn(String value) {
        super(value);
    }

    public static C_HrkeAnnaiJkKbn valueOf(String value) {
        return valueOf(C_HrkeAnnaiJkKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HrkeAnnaiJkKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HrkeAnnaiJkKbn.class, patternId, value);
    }
}
