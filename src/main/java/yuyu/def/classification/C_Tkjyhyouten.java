
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 特条標点 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Tkjyhyouten</td><td colspan="3">特条標点</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="10">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HYOUTEN100}</td><td>&quot;100&quot;</td><td>１００</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HYOUTEN125}</td><td>&quot;125&quot;</td><td>１２５</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HYOUTEN150}</td><td>&quot;150&quot;</td><td>１５０</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HYOUTEN175}</td><td>&quot;175&quot;</td><td>１７５</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HYOUTEN200}</td><td>&quot;200&quot;</td><td>２００</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HYOUTEN225}</td><td>&quot;225&quot;</td><td>２２５</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HYOUTEN250}</td><td>&quot;250&quot;</td><td>２５０</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HYOUTEN275}</td><td>&quot;275&quot;</td><td>２７５</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HYOUTEN300}</td><td>&quot;300&quot;</td><td>３００</td></tr>
 * </table>
 */
public class C_Tkjyhyouten extends Classification<C_Tkjyhyouten> {

    private static final long serialVersionUID = 1L;


    public static final C_Tkjyhyouten BLNK = new C_Tkjyhyouten("0");

    public static final C_Tkjyhyouten HYOUTEN100 = new C_Tkjyhyouten("100");

    public static final C_Tkjyhyouten HYOUTEN125 = new C_Tkjyhyouten("125");

    public static final C_Tkjyhyouten HYOUTEN150 = new C_Tkjyhyouten("150");

    public static final C_Tkjyhyouten HYOUTEN175 = new C_Tkjyhyouten("175");

    public static final C_Tkjyhyouten HYOUTEN200 = new C_Tkjyhyouten("200");

    public static final C_Tkjyhyouten HYOUTEN225 = new C_Tkjyhyouten("225");

    public static final C_Tkjyhyouten HYOUTEN250 = new C_Tkjyhyouten("250");

    public static final C_Tkjyhyouten HYOUTEN275 = new C_Tkjyhyouten("275");

    public static final C_Tkjyhyouten HYOUTEN300 = new C_Tkjyhyouten("300");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, HYOUTEN100, "HYOUTEN100", false);
        addPattern(PATTERN_DEFAULT, HYOUTEN125, "HYOUTEN125", false);
        addPattern(PATTERN_DEFAULT, HYOUTEN150, "HYOUTEN150", false);
        addPattern(PATTERN_DEFAULT, HYOUTEN175, "HYOUTEN175", false);
        addPattern(PATTERN_DEFAULT, HYOUTEN200, "HYOUTEN200", false);
        addPattern(PATTERN_DEFAULT, HYOUTEN225, "HYOUTEN225", false);
        addPattern(PATTERN_DEFAULT, HYOUTEN250, "HYOUTEN250", false);
        addPattern(PATTERN_DEFAULT, HYOUTEN275, "HYOUTEN275", false);
        addPattern(PATTERN_DEFAULT, HYOUTEN300, "HYOUTEN300", false);


        lock(C_Tkjyhyouten.class);
    }

    private C_Tkjyhyouten(String value) {
        super(value);
    }

    public static C_Tkjyhyouten valueOf(String value) {
        return valueOf(C_Tkjyhyouten.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Tkjyhyouten.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Tkjyhyouten.class, patternId, value);
    }
}
