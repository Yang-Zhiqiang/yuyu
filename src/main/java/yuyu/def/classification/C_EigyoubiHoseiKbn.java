
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 営業日補正区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_EigyoubiHoseiKbn</td><td colspan="3">営業日補正区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>補正なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YOKUEIGYOUBI}</td><td>&quot;1&quot;</td><td>翌営業日</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZENEIGYOUBI}</td><td>&quot;2&quot;</td><td>前営業日</td></tr>
 * </table>
 */
public class C_EigyoubiHoseiKbn extends Classification<C_EigyoubiHoseiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_EigyoubiHoseiKbn BLNK = new C_EigyoubiHoseiKbn("0");

    public static final C_EigyoubiHoseiKbn YOKUEIGYOUBI = new C_EigyoubiHoseiKbn("1");

    public static final C_EigyoubiHoseiKbn ZENEIGYOUBI = new C_EigyoubiHoseiKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, YOKUEIGYOUBI, "YOKUEIGYOUBI", false);
        addPattern(PATTERN_DEFAULT, ZENEIGYOUBI, "ZENEIGYOUBI", false);


        lock(C_EigyoubiHoseiKbn.class);
    }

    private C_EigyoubiHoseiKbn(String value) {
        super(value);
    }

    public static C_EigyoubiHoseiKbn valueOf(String value) {
        return valueOf(C_EigyoubiHoseiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_EigyoubiHoseiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_EigyoubiHoseiKbn.class, patternId, value);
    }
}
