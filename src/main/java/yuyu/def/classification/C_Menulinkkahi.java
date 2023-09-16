
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * メニューリンク可否 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Menulinkkahi</td><td colspan="3">メニューリンク可否</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #HUKA}</td><td>&quot;0&quot;</td><td>不可</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KA}</td><td>&quot;1&quot;</td><td>可</td></tr>
 * </table>
 */
public class C_Menulinkkahi extends Classification<C_Menulinkkahi> {

    private static final long serialVersionUID = 1L;


    public static final C_Menulinkkahi HUKA = new C_Menulinkkahi("0");

    public static final C_Menulinkkahi KA = new C_Menulinkkahi("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, HUKA, "HUKA", true);
        addPattern(PATTERN_DEFAULT, KA, "KA", false);


        lock(C_Menulinkkahi.class);
    }

    private C_Menulinkkahi(String value) {
        super(value);
    }

    public static C_Menulinkkahi valueOf(String value) {
        return valueOf(C_Menulinkkahi.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Menulinkkahi.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Menulinkkahi.class, patternId, value);
    }
}
