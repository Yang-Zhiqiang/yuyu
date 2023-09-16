
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 不担保期間 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Htnpkkn</td><td colspan="3">不担保期間</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="7">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ONE}</td><td>&quot;1&quot;</td><td>１年</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOW}</td><td>&quot;2&quot;</td><td>２年</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #THREE}</td><td>&quot;3&quot;</td><td>３年</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FOUR}</td><td>&quot;4&quot;</td><td>４年</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FIVE}</td><td>&quot;5&quot;</td><td>５年</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZENKKN}</td><td>&quot;99&quot;</td><td>全期間</td></tr>
 * </table>
 */
public class C_Htnpkkn extends Classification<C_Htnpkkn> {

    private static final long serialVersionUID = 1L;


    public static final C_Htnpkkn BLNK = new C_Htnpkkn("0");

    public static final C_Htnpkkn ONE = new C_Htnpkkn("1");

    public static final C_Htnpkkn TOW = new C_Htnpkkn("2");

    public static final C_Htnpkkn THREE = new C_Htnpkkn("3");

    public static final C_Htnpkkn FOUR = new C_Htnpkkn("4");

    public static final C_Htnpkkn FIVE = new C_Htnpkkn("5");

    public static final C_Htnpkkn ZENKKN = new C_Htnpkkn("99");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, ONE, "ONE", false);
        addPattern(PATTERN_DEFAULT, TOW, "TOW", false);
        addPattern(PATTERN_DEFAULT, THREE, "THREE", false);
        addPattern(PATTERN_DEFAULT, FOUR, "FOUR", false);
        addPattern(PATTERN_DEFAULT, FIVE, "FIVE", false);
        addPattern(PATTERN_DEFAULT, ZENKKN, "ZENKKN", false);


        lock(C_Htnpkkn.class);
    }

    private C_Htnpkkn(String value) {
        super(value);
    }

    public static C_Htnpkkn valueOf(String value) {
        return valueOf(C_Htnpkkn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Htnpkkn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Htnpkkn.class, patternId, value);
    }
}
