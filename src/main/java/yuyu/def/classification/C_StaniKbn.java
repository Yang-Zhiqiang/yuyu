
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * Ｓ単位区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_StaniKbn</td><td colspan="3">Ｓ単位区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #EN}</td><td>&quot;0&quot;</td><td>円</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEN}</td><td>&quot;1&quot;</td><td>千円</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAN}</td><td>&quot;2&quot;</td><td>万円</td></tr>
 * </table>
 */
public class C_StaniKbn extends Classification<C_StaniKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_StaniKbn EN = new C_StaniKbn("0");

    public static final C_StaniKbn SEN = new C_StaniKbn("1");

    public static final C_StaniKbn MAN = new C_StaniKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, EN, "EN", true);
        addPattern(PATTERN_DEFAULT, SEN, "SEN", false);
        addPattern(PATTERN_DEFAULT, MAN, "MAN", false);


        lock(C_StaniKbn.class);
    }

    private C_StaniKbn(String value) {
        super(value);
    }

    public static C_StaniKbn valueOf(String value) {
        return valueOf(C_StaniKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_StaniKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_StaniKbn.class, patternId, value);
    }
}
