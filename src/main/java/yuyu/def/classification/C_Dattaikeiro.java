
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 脱退経路 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Dattaikeiro</td><td colspan="3">脱退経路</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #ONLINE}</td><td>&quot;0&quot;</td><td>オンライン</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUHURI}</td><td>&quot;10&quot;</td><td>口座振替</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CREDIT}</td><td>&quot;20&quot;</td><td>クレジット</td></tr>
 * </table>
 */
public class C_Dattaikeiro extends Classification<C_Dattaikeiro> {

    private static final long serialVersionUID = 1L;


    public static final C_Dattaikeiro ONLINE = new C_Dattaikeiro("0");

    public static final C_Dattaikeiro KOUHURI = new C_Dattaikeiro("10");

    public static final C_Dattaikeiro CREDIT = new C_Dattaikeiro("20");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, ONLINE, "ONLINE", true);
        addPattern(PATTERN_DEFAULT, KOUHURI, "KOUHURI", false);
        addPattern(PATTERN_DEFAULT, CREDIT, "CREDIT", false);


        lock(C_Dattaikeiro.class);
    }

    private C_Dattaikeiro(String value) {
        super(value);
    }

    public static C_Dattaikeiro valueOf(String value) {
        return valueOf(C_Dattaikeiro.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Dattaikeiro.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Dattaikeiro.class, patternId, value);
    }
}
