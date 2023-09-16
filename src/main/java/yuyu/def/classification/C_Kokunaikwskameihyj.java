
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 内国為替制度加盟表示 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Kokunaikwskameihyj</td><td colspan="3">内国為替制度加盟表示</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #MIKAMEI}</td><td>&quot;0&quot;</td><td>未加盟</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAMEI}</td><td>&quot;1&quot;</td><td>加盟</td></tr>
 * </table>
 */
public class C_Kokunaikwskameihyj extends Classification<C_Kokunaikwskameihyj> {

    private static final long serialVersionUID = 1L;


    public static final C_Kokunaikwskameihyj MIKAMEI = new C_Kokunaikwskameihyj("0");

    public static final C_Kokunaikwskameihyj KAMEI = new C_Kokunaikwskameihyj("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, MIKAMEI, "MIKAMEI", true);
        addPattern(PATTERN_DEFAULT, KAMEI, "KAMEI", false);


        lock(C_Kokunaikwskameihyj.class);
    }

    private C_Kokunaikwskameihyj(String value) {
        super(value);
    }

    public static C_Kokunaikwskameihyj valueOf(String value) {
        return valueOf(C_Kokunaikwskameihyj.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Kokunaikwskameihyj.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Kokunaikwskameihyj.class, patternId, value);
    }
}
