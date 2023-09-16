
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 営業日区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_EigyoubiKbn</td><td colspan="3">営業日区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #EIGYOUBI}</td><td>&quot;1&quot;</td><td>営業日</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HIEIGYOUBI}</td><td>&quot;2&quot;</td><td>非営業日</td></tr>
 * </table>
 */
public class C_EigyoubiKbn extends Classification<C_EigyoubiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_EigyoubiKbn EIGYOUBI = new C_EigyoubiKbn("1");

    public static final C_EigyoubiKbn HIEIGYOUBI = new C_EigyoubiKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, EIGYOUBI, "EIGYOUBI", true);
        addPattern(PATTERN_DEFAULT, HIEIGYOUBI, "HIEIGYOUBI", false);


        lock(C_EigyoubiKbn.class);
    }

    private C_EigyoubiKbn(String value) {
        super(value);
    }

    public static C_EigyoubiKbn valueOf(String value) {
        return valueOf(C_EigyoubiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_EigyoubiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_EigyoubiKbn.class, patternId, value);
    }
}
