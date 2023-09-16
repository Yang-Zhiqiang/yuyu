
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 前納後払込回数 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Znnhrkkai</td><td colspan="3">前納後払込回数</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TUKI}</td><td>&quot;1&quot;</td><td>月払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NEN}</td><td>&quot;12&quot;</td><td>年払</td></tr>
 * </table>
 */
public class C_Znnhrkkai extends Classification<C_Znnhrkkai> {

    private static final long serialVersionUID = 1L;


    public static final C_Znnhrkkai BLNK = new C_Znnhrkkai("0");

    public static final C_Znnhrkkai TUKI = new C_Znnhrkkai("1");

    public static final C_Znnhrkkai NEN = new C_Znnhrkkai("12");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, TUKI, "TUKI", false);
        addPattern(PATTERN_DEFAULT, NEN, "NEN", false);


        lock(C_Znnhrkkai.class);
    }

    private C_Znnhrkkai(String value) {
        super(value);
    }

    public static C_Znnhrkkai valueOf(String value) {
        return valueOf(C_Znnhrkkai.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Znnhrkkai.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Znnhrkkai.class, patternId, value);
    }
}
