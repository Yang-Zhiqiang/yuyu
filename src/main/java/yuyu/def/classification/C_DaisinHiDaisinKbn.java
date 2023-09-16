
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 代申非代申区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_DaisinHiDaisinKbn</td><td colspan="3">代申非代申区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DAISIN}</td><td>&quot;1&quot;</td><td>代申会社</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HIDAISIN}</td><td>&quot;2&quot;</td><td>非代申会社</td></tr>
 * </table>
 */
public class C_DaisinHiDaisinKbn extends Classification<C_DaisinHiDaisinKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_DaisinHiDaisinKbn BLNK = new C_DaisinHiDaisinKbn("0");

    public static final C_DaisinHiDaisinKbn DAISIN = new C_DaisinHiDaisinKbn("1");

    public static final C_DaisinHiDaisinKbn HIDAISIN = new C_DaisinHiDaisinKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, DAISIN, "DAISIN", false);
        addPattern(PATTERN_DEFAULT, HIDAISIN, "HIDAISIN", false);


        lock(C_DaisinHiDaisinKbn.class);
    }

    private C_DaisinHiDaisinKbn(String value) {
        super(value);
    }

    public static C_DaisinHiDaisinKbn valueOf(String value) {
        return valueOf(C_DaisinHiDaisinKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_DaisinHiDaisinKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_DaisinHiDaisinKbn.class, patternId, value);
    }
}
