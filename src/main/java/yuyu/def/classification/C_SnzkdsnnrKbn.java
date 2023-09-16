
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 専属代申乗合区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SnzkdsnnrKbn</td><td colspan="3">専属代申乗合区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SENZOKU}</td><td>&quot;1&quot;</td><td>専属</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DAISIN}</td><td>&quot;2&quot;</td><td>代申</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NORIAI}</td><td>&quot;3&quot;</td><td>乗合</td></tr>
 * </table>
 */
public class C_SnzkdsnnrKbn extends Classification<C_SnzkdsnnrKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SnzkdsnnrKbn BLNK = new C_SnzkdsnnrKbn("0");

    public static final C_SnzkdsnnrKbn SENZOKU = new C_SnzkdsnnrKbn("1");

    public static final C_SnzkdsnnrKbn DAISIN = new C_SnzkdsnnrKbn("2");

    public static final C_SnzkdsnnrKbn NORIAI = new C_SnzkdsnnrKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SENZOKU, "SENZOKU", false);
        addPattern(PATTERN_DEFAULT, DAISIN, "DAISIN", false);
        addPattern(PATTERN_DEFAULT, NORIAI, "NORIAI", false);


        lock(C_SnzkdsnnrKbn.class);
    }

    private C_SnzkdsnnrKbn(String value) {
        super(value);
    }

    public static C_SnzkdsnnrKbn valueOf(String value) {
        return valueOf(C_SnzkdsnnrKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SnzkdsnnrKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SnzkdsnnrKbn.class, patternId, value);
    }
}
