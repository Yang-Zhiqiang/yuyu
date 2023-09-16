
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 個人保険団体保険区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KjndnthknKbn</td><td colspan="3">個人保険団体保険区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KJNHKN}</td><td>&quot;1&quot;</td><td>個人保険</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DNTHKN}</td><td>&quot;2&quot;</td><td>団体保険</td></tr>
 * </table>
 */
public class C_KjndnthknKbn extends Classification<C_KjndnthknKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KjndnthknKbn BLNK = new C_KjndnthknKbn("0");

    public static final C_KjndnthknKbn KJNHKN = new C_KjndnthknKbn("1");

    public static final C_KjndnthknKbn DNTHKN = new C_KjndnthknKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KJNHKN, "KJNHKN", false);
        addPattern(PATTERN_DEFAULT, DNTHKN, "DNTHKN", false);


        lock(C_KjndnthknKbn.class);
    }

    private C_KjndnthknKbn(String value) {
        super(value);
    }

    public static C_KjndnthknKbn valueOf(String value) {
        return valueOf(C_KjndnthknKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KjndnthknKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KjndnthknKbn.class, patternId, value);
    }
}
