
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 病名該当区分２ クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_ByoumeiGaitouKbn2</td><td colspan="3">病名該当区分２</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANSENSYOU}</td><td>&quot;1&quot;</td><td>感染症</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAIGAI}</td><td>&quot;2&quot;</td><td>災害</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUSYOU}</td><td>&quot;3&quot;</td><td>不詳</td></tr>
 * </table>
 */
public class C_ByoumeiGaitouKbn2 extends Classification<C_ByoumeiGaitouKbn2> {

    private static final long serialVersionUID = 1L;


    public static final C_ByoumeiGaitouKbn2 BLNK = new C_ByoumeiGaitouKbn2("0");

    public static final C_ByoumeiGaitouKbn2 KANSENSYOU = new C_ByoumeiGaitouKbn2("1");

    public static final C_ByoumeiGaitouKbn2 SAIGAI = new C_ByoumeiGaitouKbn2("2");

    public static final C_ByoumeiGaitouKbn2 HUSYOU = new C_ByoumeiGaitouKbn2("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KANSENSYOU, "KANSENSYOU", false);
        addPattern(PATTERN_DEFAULT, SAIGAI, "SAIGAI", false);
        addPattern(PATTERN_DEFAULT, HUSYOU, "HUSYOU", false);


        lock(C_ByoumeiGaitouKbn2.class);
    }

    private C_ByoumeiGaitouKbn2(String value) {
        super(value);
    }

    public static C_ByoumeiGaitouKbn2 valueOf(String value) {
        return valueOf(C_ByoumeiGaitouKbn2.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_ByoumeiGaitouKbn2.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_ByoumeiGaitouKbn2.class, patternId, value);
    }
}
