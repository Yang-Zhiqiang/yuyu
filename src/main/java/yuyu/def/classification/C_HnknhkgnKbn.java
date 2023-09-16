
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 変換復元区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HnknhkgnKbn</td><td colspan="3">変換復元区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HNKN}</td><td>&quot;1&quot;</td><td>変換</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HKGN}</td><td>&quot;2&quot;</td><td>復元</td></tr>
 * </table>
 */
public class C_HnknhkgnKbn extends Classification<C_HnknhkgnKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HnknhkgnKbn BLNK = new C_HnknhkgnKbn("0");

    public static final C_HnknhkgnKbn HNKN = new C_HnknhkgnKbn("1");

    public static final C_HnknhkgnKbn HKGN = new C_HnknhkgnKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, HNKN, "HNKN", false);
        addPattern(PATTERN_DEFAULT, HKGN, "HKGN", false);


        lock(C_HnknhkgnKbn.class);
    }

    private C_HnknhkgnKbn(String value) {
        super(value);
    }

    public static C_HnknhkgnKbn valueOf(String value) {
        return valueOf(C_HnknhkgnKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HnknhkgnKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HnknhkgnKbn.class, patternId, value);
    }
}
