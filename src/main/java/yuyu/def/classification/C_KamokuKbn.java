
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 科目区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KamokuKbn</td><td colspan="3">科目区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SISAN}</td><td>&quot;1&quot;</td><td>資産</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FUSAI}</td><td>&quot;2&quot;</td><td>負債</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYUUEKI}</td><td>&quot;3&quot;</td><td>収益</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HIYOU}</td><td>&quot;4&quot;</td><td>費用</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIHON}</td><td>&quot;5&quot;</td><td>資本</td></tr>
 * </table>
 */
public class C_KamokuKbn extends Classification<C_KamokuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KamokuKbn BLNK = new C_KamokuKbn("0");

    public static final C_KamokuKbn SISAN = new C_KamokuKbn("1");

    public static final C_KamokuKbn FUSAI = new C_KamokuKbn("2");

    public static final C_KamokuKbn SYUUEKI = new C_KamokuKbn("3");

    public static final C_KamokuKbn HIYOU = new C_KamokuKbn("4");

    public static final C_KamokuKbn SIHON = new C_KamokuKbn("5");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SISAN, "SISAN", false);
        addPattern(PATTERN_DEFAULT, FUSAI, "FUSAI", false);
        addPattern(PATTERN_DEFAULT, SYUUEKI, "SYUUEKI", false);
        addPattern(PATTERN_DEFAULT, HIYOU, "HIYOU", false);
        addPattern(PATTERN_DEFAULT, SIHON, "SIHON", false);


        lock(C_KamokuKbn.class);
    }

    private C_KamokuKbn(String value) {
        super(value);
    }

    public static C_KamokuKbn valueOf(String value) {
        return valueOf(C_KamokuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KamokuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KamokuKbn.class, patternId, value);
    }
}
