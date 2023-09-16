
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 支払戻入区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_ShrrnyKbn</td><td colspan="3">支払戻入区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIHARAI}</td><td>&quot;1&quot;</td><td>支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #REINYUU}</td><td>&quot;2&quot;</td><td>戻入</td></tr>
 * </table>
 */
public class C_ShrrnyKbn extends Classification<C_ShrrnyKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_ShrrnyKbn BLNK = new C_ShrrnyKbn("0");

    public static final C_ShrrnyKbn SIHARAI = new C_ShrrnyKbn("1");

    public static final C_ShrrnyKbn REINYUU = new C_ShrrnyKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SIHARAI, "SIHARAI", false);
        addPattern(PATTERN_DEFAULT, REINYUU, "REINYUU", false);


        lock(C_ShrrnyKbn.class);
    }

    private C_ShrrnyKbn(String value) {
        super(value);
    }

    public static C_ShrrnyKbn valueOf(String value) {
        return valueOf(C_ShrrnyKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_ShrrnyKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_ShrrnyKbn.class, patternId, value);
    }
}
