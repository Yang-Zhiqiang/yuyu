
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 減額方法区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_GengkhouKbn</td><td colspan="3">減額方法区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SD}</td><td>&quot;1&quot;</td><td>Ｓ建</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PD}</td><td>&quot;2&quot;</td><td>Ｐ建</td></tr>
 * </table>
 */
public class C_GengkhouKbn extends Classification<C_GengkhouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_GengkhouKbn BLNK = new C_GengkhouKbn("0");

    public static final C_GengkhouKbn SD = new C_GengkhouKbn("1");

    public static final C_GengkhouKbn PD = new C_GengkhouKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SD, "SD", false);
        addPattern(PATTERN_DEFAULT, PD, "PD", false);


        lock(C_GengkhouKbn.class);
    }

    private C_GengkhouKbn(String value) {
        super(value);
    }

    public static C_GengkhouKbn valueOf(String value) {
        return valueOf(C_GengkhouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_GengkhouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_GengkhouKbn.class, patternId, value);
    }
}
