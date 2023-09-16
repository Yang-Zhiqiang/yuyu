
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 入力可否区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Inputkahi</td><td colspan="3">入力可否区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #HI}</td><td>&quot;0&quot;</td><td>否</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KA}</td><td>&quot;1&quot;</td><td>可</td></tr>
 * </table>
 */
public class C_Inputkahi extends Classification<C_Inputkahi> {

    private static final long serialVersionUID = 1L;


    public static final C_Inputkahi HI = new C_Inputkahi("0");

    public static final C_Inputkahi KA = new C_Inputkahi("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, HI, "HI", true);
        addPattern(PATTERN_DEFAULT, KA, "KA", false);


        lock(C_Inputkahi.class);
    }

    private C_Inputkahi(String value) {
        super(value);
    }

    public static C_Inputkahi valueOf(String value) {
        return valueOf(C_Inputkahi.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Inputkahi.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Inputkahi.class, patternId, value);
    }
}
