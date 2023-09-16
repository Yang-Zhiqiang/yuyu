
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 資料種別 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Siryousyubetu</td><td colspan="3">資料種別</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #IRYOU}</td><td>&quot;0&quot;</td><td>医療</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TK}</td><td>&quot;9&quot;</td><td>特約</td></tr>
 * </table>
 */
public class C_Siryousyubetu extends Classification<C_Siryousyubetu> {

    private static final long serialVersionUID = 1L;


    public static final C_Siryousyubetu IRYOU = new C_Siryousyubetu("0");

    public static final C_Siryousyubetu TK = new C_Siryousyubetu("9");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, IRYOU, "IRYOU", true);
        addPattern(PATTERN_DEFAULT, TK, "TK", false);


        lock(C_Siryousyubetu.class);
    }

    private C_Siryousyubetu(String value) {
        super(value);
    }

    public static C_Siryousyubetu valueOf(String value) {
        return valueOf(C_Siryousyubetu.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Siryousyubetu.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Siryousyubetu.class, patternId, value);
    }
}
