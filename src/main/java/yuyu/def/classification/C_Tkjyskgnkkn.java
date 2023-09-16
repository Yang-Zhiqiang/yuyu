
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 特条削減期間 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Tkjyskgnkkn</td><td colspan="3">特条削減期間</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #Y1}</td><td>&quot;1&quot;</td><td>１年</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #Y2}</td><td>&quot;2&quot;</td><td>２年</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #Y3}</td><td>&quot;3&quot;</td><td>３年</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #Y4}</td><td>&quot;4&quot;</td><td>４年</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #Y5}</td><td>&quot;5&quot;</td><td>５年</td></tr>
 * </table>
 */
public class C_Tkjyskgnkkn extends Classification<C_Tkjyskgnkkn> {

    private static final long serialVersionUID = 1L;


    public static final C_Tkjyskgnkkn BLNK = new C_Tkjyskgnkkn("0");

    public static final C_Tkjyskgnkkn Y1 = new C_Tkjyskgnkkn("1");

    public static final C_Tkjyskgnkkn Y2 = new C_Tkjyskgnkkn("2");

    public static final C_Tkjyskgnkkn Y3 = new C_Tkjyskgnkkn("3");

    public static final C_Tkjyskgnkkn Y4 = new C_Tkjyskgnkkn("4");

    public static final C_Tkjyskgnkkn Y5 = new C_Tkjyskgnkkn("5");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, Y1, "Y1", false);
        addPattern(PATTERN_DEFAULT, Y2, "Y2", false);
        addPattern(PATTERN_DEFAULT, Y3, "Y3", false);
        addPattern(PATTERN_DEFAULT, Y4, "Y4", false);
        addPattern(PATTERN_DEFAULT, Y5, "Y5", false);


        lock(C_Tkjyskgnkkn.class);
    }

    private C_Tkjyskgnkkn(String value) {
        super(value);
    }

    public static C_Tkjyskgnkkn valueOf(String value) {
        return valueOf(C_Tkjyskgnkkn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Tkjyskgnkkn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Tkjyskgnkkn.class, patternId, value);
    }
}
