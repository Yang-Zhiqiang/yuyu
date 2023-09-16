
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 最終年金支払表示 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Lastnkshrhyouji</td><td colspan="3">最終年金支払表示</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #MI}</td><td>&quot;0&quot;</td><td>未支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZUMI}</td><td>&quot;1&quot;</td><td>支払済</td></tr>
 * </table>
 */
public class C_Lastnkshrhyouji extends Classification<C_Lastnkshrhyouji> {

    private static final long serialVersionUID = 1L;


    public static final C_Lastnkshrhyouji MI = new C_Lastnkshrhyouji("0");

    public static final C_Lastnkshrhyouji ZUMI = new C_Lastnkshrhyouji("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, MI, "MI", true);
        addPattern(PATTERN_DEFAULT, ZUMI, "ZUMI", false);


        lock(C_Lastnkshrhyouji.class);
    }

    private C_Lastnkshrhyouji(String value) {
        super(value);
    }

    public static C_Lastnkshrhyouji valueOf(String value) {
        return valueOf(C_Lastnkshrhyouji.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Lastnkshrhyouji.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Lastnkshrhyouji.class, patternId, value);
    }
}
