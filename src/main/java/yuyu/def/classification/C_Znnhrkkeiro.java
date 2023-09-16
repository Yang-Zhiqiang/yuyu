
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 前納後払込経路 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Znnhrkkeiro</td><td colspan="3">前納後払込経路</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUHURI}</td><td>&quot;1&quot;</td><td>口振</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YUUHURI}</td><td>&quot;5&quot;</td><td>郵振</td></tr>
 * </table>
 */
public class C_Znnhrkkeiro extends Classification<C_Znnhrkkeiro> {

    private static final long serialVersionUID = 1L;


    public static final C_Znnhrkkeiro BLNK = new C_Znnhrkkeiro("0");

    public static final C_Znnhrkkeiro KOUHURI = new C_Znnhrkkeiro("1");

    public static final C_Znnhrkkeiro YUUHURI = new C_Znnhrkkeiro("5");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KOUHURI, "KOUHURI", false);
        addPattern(PATTERN_DEFAULT, YUUHURI, "YUUHURI", false);


        lock(C_Znnhrkkeiro.class);
    }

    private C_Znnhrkkeiro(String value) {
        super(value);
    }

    public static C_Znnhrkkeiro valueOf(String value) {
        return valueOf(C_Znnhrkkeiro.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Znnhrkkeiro.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Znnhrkkeiro.class, patternId, value);
    }
}
