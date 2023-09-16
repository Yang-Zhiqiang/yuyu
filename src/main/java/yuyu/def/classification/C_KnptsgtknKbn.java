
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 健保対象外（治験）区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KnptsgtknKbn</td><td colspan="3">健保対象外（治験）区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TIKEN}</td><td>&quot;1&quot;</td><td>治験</td></tr>
 * </table>
 */
public class C_KnptsgtknKbn extends Classification<C_KnptsgtknKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KnptsgtknKbn BLNK = new C_KnptsgtknKbn("0");

    public static final C_KnptsgtknKbn TIKEN = new C_KnptsgtknKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, TIKEN, "TIKEN", false);


        lock(C_KnptsgtknKbn.class);
    }

    private C_KnptsgtknKbn(String value) {
        super(value);
    }

    public static C_KnptsgtknKbn valueOf(String value) {
        return valueOf(C_KnptsgtknKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KnptsgtknKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KnptsgtknKbn.class, patternId, value);
    }
}
