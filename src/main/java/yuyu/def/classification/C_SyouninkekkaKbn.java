
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 承認結果区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SyouninkekkaKbn</td><td colspan="3">承認結果区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SN}</td><td>&quot;1&quot;</td><td>承認</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HSN}</td><td>&quot;2&quot;</td><td>不承認</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HORYUU}</td><td>&quot;9&quot;</td><td>保留</td></tr>
 * </table>
 */
public class C_SyouninkekkaKbn extends Classification<C_SyouninkekkaKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SyouninkekkaKbn BLNK = new C_SyouninkekkaKbn("0");

    public static final C_SyouninkekkaKbn SN = new C_SyouninkekkaKbn("1");

    public static final C_SyouninkekkaKbn HSN = new C_SyouninkekkaKbn("2");

    public static final C_SyouninkekkaKbn HORYUU = new C_SyouninkekkaKbn("9");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SN, "SN", false);
        addPattern(PATTERN_DEFAULT, HSN, "HSN", false);
        addPattern(PATTERN_DEFAULT, HORYUU, "HORYUU", false);


        lock(C_SyouninkekkaKbn.class);
    }

    private C_SyouninkekkaKbn(String value) {
        super(value);
    }

    public static C_SyouninkekkaKbn valueOf(String value) {
        return valueOf(C_SyouninkekkaKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SyouninkekkaKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SyouninkekkaKbn.class, patternId, value);
    }
}
