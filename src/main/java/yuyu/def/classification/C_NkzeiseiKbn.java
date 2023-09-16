
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 年金税制区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_NkzeiseiKbn</td><td colspan="3">年金税制区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUKA}</td><td>&quot;1&quot;</td><td>特約付加</td></tr>
 * </table>
 */
public class C_NkzeiseiKbn extends Classification<C_NkzeiseiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_NkzeiseiKbn NONE = new C_NkzeiseiKbn("0");

    public static final C_NkzeiseiKbn HUKA = new C_NkzeiseiKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NONE, "NONE", true);
        addPattern(PATTERN_DEFAULT, HUKA, "HUKA", false);


        lock(C_NkzeiseiKbn.class);
    }

    private C_NkzeiseiKbn(String value) {
        super(value);
    }

    public static C_NkzeiseiKbn valueOf(String value) {
        return valueOf(C_NkzeiseiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_NkzeiseiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_NkzeiseiKbn.class, patternId, value);
    }
}
