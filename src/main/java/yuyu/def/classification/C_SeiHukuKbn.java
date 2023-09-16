
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 正副区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SeiHukuKbn</td><td colspan="3">正副区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEI}</td><td>&quot;1&quot;</td><td>正</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUKU}</td><td>&quot;2&quot;</td><td>副</td></tr>
 * </table>
 */
public class C_SeiHukuKbn extends Classification<C_SeiHukuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SeiHukuKbn BLNK = new C_SeiHukuKbn("0");

    public static final C_SeiHukuKbn SEI = new C_SeiHukuKbn("1");

    public static final C_SeiHukuKbn HUKU = new C_SeiHukuKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SEI, "SEI", false);
        addPattern(PATTERN_DEFAULT, HUKU, "HUKU", false);


        lock(C_SeiHukuKbn.class);
    }

    private C_SeiHukuKbn(String value) {
        super(value);
    }

    public static C_SeiHukuKbn valueOf(String value) {
        return valueOf(C_SeiHukuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SeiHukuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SeiHukuKbn.class, patternId, value);
    }
}
