
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 負号区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HugouKbn</td><td colspan="3">負号区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #SEI}</td><td>&quot;0&quot;</td><td>正</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HU}</td><td>&quot;1&quot;</td><td>負</td></tr>
 * </table>
 */
public class C_HugouKbn extends Classification<C_HugouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HugouKbn SEI = new C_HugouKbn("0");

    public static final C_HugouKbn HU = new C_HugouKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, SEI, "SEI", true);
        addPattern(PATTERN_DEFAULT, HU, "HU", false);


        lock(C_HugouKbn.class);
    }

    private C_HugouKbn(String value) {
        super(value);
    }

    public static C_HugouKbn valueOf(String value) {
        return valueOf(C_HugouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HugouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HugouKbn.class, patternId, value);
    }
}
