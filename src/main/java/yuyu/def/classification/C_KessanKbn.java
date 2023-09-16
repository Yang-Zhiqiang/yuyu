
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 決算区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KessanKbn</td><td colspan="3">決算区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #TUUJYOU}</td><td>&quot;0&quot;</td><td>通常</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KESSAN}</td><td>&quot;1&quot;</td><td>決算</td></tr>
 * </table>
 */
public class C_KessanKbn extends Classification<C_KessanKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KessanKbn TUUJYOU = new C_KessanKbn("0");

    public static final C_KessanKbn KESSAN = new C_KessanKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, TUUJYOU, "TUUJYOU", true);
        addPattern(PATTERN_DEFAULT, KESSAN, "KESSAN", false);


        lock(C_KessanKbn.class);
    }

    private C_KessanKbn(String value) {
        super(value);
    }

    public static C_KessanKbn valueOf(String value) {
        return valueOf(C_KessanKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KessanKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KessanKbn.class, patternId, value);
    }
}
