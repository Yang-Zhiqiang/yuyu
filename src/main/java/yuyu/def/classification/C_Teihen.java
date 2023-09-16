
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 定額変額区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Teihen</td><td colspan="3">定額変額区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEI}</td><td>&quot;1&quot;</td><td>定額</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HEN}</td><td>&quot;2&quot;</td><td>変額</td></tr>
 * </table>
 */
public class C_Teihen extends Classification<C_Teihen> {

    private static final long serialVersionUID = 1L;


    public static final C_Teihen BLNK = new C_Teihen("0");

    public static final C_Teihen TEI = new C_Teihen("1");

    public static final C_Teihen HEN = new C_Teihen("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, TEI, "TEI", false);
        addPattern(PATTERN_DEFAULT, HEN, "HEN", false);


        lock(C_Teihen.class);
    }

    private C_Teihen(String value) {
        super(value);
    }

    public static C_Teihen valueOf(String value) {
        return valueOf(C_Teihen.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Teihen.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Teihen.class, patternId, value);
    }
}
