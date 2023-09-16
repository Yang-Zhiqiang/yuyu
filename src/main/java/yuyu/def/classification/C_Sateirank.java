
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 査定ランク クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Sateirank</td><td colspan="3">査定ランク</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANI}</td><td>&quot;1&quot;</td><td>簡易査定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUDO}</td><td>&quot;2&quot;</td><td>高度査定</td></tr>
 * </table>
 */
public class C_Sateirank extends Classification<C_Sateirank> {

    private static final long serialVersionUID = 1L;


    public static final C_Sateirank BLNK = new C_Sateirank("0");

    public static final C_Sateirank KANI = new C_Sateirank("1");

    public static final C_Sateirank KOUDO = new C_Sateirank("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KANI, "KANI", false);
        addPattern(PATTERN_DEFAULT, KOUDO, "KOUDO", false);


        lock(C_Sateirank.class);
    }

    private C_Sateirank(String value) {
        super(value);
    }

    public static C_Sateirank valueOf(String value) {
        return valueOf(C_Sateirank.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Sateirank.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Sateirank.class, patternId, value);
    }
}
