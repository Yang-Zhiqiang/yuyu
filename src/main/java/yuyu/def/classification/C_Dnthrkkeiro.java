
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 団体払込経路 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Dnthrkkeiro</td><td colspan="3">団体払込経路</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUHURI}</td><td>&quot;1&quot;</td><td>口振</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DANTAI}</td><td>&quot;2&quot;</td><td>団体</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYUUDAN}</td><td>&quot;3&quot;</td><td>集団</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YUUHURI}</td><td>&quot;5&quot;</td><td>郵振</td></tr>
 * </table>
 */
public class C_Dnthrkkeiro extends Classification<C_Dnthrkkeiro> {

    private static final long serialVersionUID = 1L;


    public static final C_Dnthrkkeiro BLNK = new C_Dnthrkkeiro("0");

    public static final C_Dnthrkkeiro KOUHURI = new C_Dnthrkkeiro("1");

    public static final C_Dnthrkkeiro DANTAI = new C_Dnthrkkeiro("2");

    public static final C_Dnthrkkeiro SYUUDAN = new C_Dnthrkkeiro("3");

    public static final C_Dnthrkkeiro YUUHURI = new C_Dnthrkkeiro("5");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KOUHURI, "KOUHURI", false);
        addPattern(PATTERN_DEFAULT, DANTAI, "DANTAI", false);
        addPattern(PATTERN_DEFAULT, SYUUDAN, "SYUUDAN", false);
        addPattern(PATTERN_DEFAULT, YUUHURI, "YUUHURI", false);


        lock(C_Dnthrkkeiro.class);
    }

    private C_Dnthrkkeiro(String value) {
        super(value);
    }

    public static C_Dnthrkkeiro valueOf(String value) {
        return valueOf(C_Dnthrkkeiro.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Dnthrkkeiro.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Dnthrkkeiro.class, patternId, value);
    }
}
