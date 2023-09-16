
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * セット販売区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SethanKbn</td><td colspan="3">セット販売区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #TANPIN}</td><td>&quot;0&quot;</td><td>単品　</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SET}</td><td>&quot;1&quot;</td><td>セット販売</td></tr>
 * </table>
 */
public class C_SethanKbn extends Classification<C_SethanKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SethanKbn TANPIN = new C_SethanKbn("0");

    public static final C_SethanKbn SET = new C_SethanKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, TANPIN, "TANPIN", true);
        addPattern(PATTERN_DEFAULT, SET, "SET", false);


        lock(C_SethanKbn.class);
    }

    private C_SethanKbn(String value) {
        super(value);
    }

    public static C_SethanKbn valueOf(String value) {
        return valueOf(C_SethanKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SethanKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SethanKbn.class, patternId, value);
    }
}
