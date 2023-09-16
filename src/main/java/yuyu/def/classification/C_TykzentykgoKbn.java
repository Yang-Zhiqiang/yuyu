
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 直前直後区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TykzentykgoKbn</td><td colspan="3">直前直後区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TYKZEN}</td><td>&quot;1&quot;</td><td>直前</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TYKGO}</td><td>&quot;2&quot;</td><td>直後</td></tr>
 * </table>
 */
public class C_TykzentykgoKbn extends Classification<C_TykzentykgoKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TykzentykgoKbn BLNK = new C_TykzentykgoKbn("0");

    public static final C_TykzentykgoKbn TYKZEN = new C_TykzentykgoKbn("1");

    public static final C_TykzentykgoKbn TYKGO = new C_TykzentykgoKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, TYKZEN, "TYKZEN", false);
        addPattern(PATTERN_DEFAULT, TYKGO, "TYKGO", false);


        lock(C_TykzentykgoKbn.class);
    }

    private C_TykzentykgoKbn(String value) {
        super(value);
    }

    public static C_TykzentykgoKbn valueOf(String value) {
        return valueOf(C_TykzentykgoKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TykzentykgoKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TykzentykgoKbn.class, patternId, value);
    }
}
