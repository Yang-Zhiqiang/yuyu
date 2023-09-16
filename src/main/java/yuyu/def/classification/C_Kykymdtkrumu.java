
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 契約日特例有無 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Kykymdtkrumu</td><td colspan="3">契約日特例有無</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>無し</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ARI}</td><td>&quot;1&quot;</td><td>有り</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_SELECT SELECT}<br />(選択)</td><td align="center">&nbsp;</td><td>{@link #ARI}</td><td>&quot;1&quot;</td><td>適用する</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>適用しない</td></tr>
 * </table>
 */
public class C_Kykymdtkrumu extends Classification<C_Kykymdtkrumu> {

    private static final long serialVersionUID = 1L;


    public static final C_Kykymdtkrumu NONE = new C_Kykymdtkrumu("0");

    public static final C_Kykymdtkrumu ARI = new C_Kykymdtkrumu("1");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SELECT = "2";


    static {

        addPattern(PATTERN_DEFAULT, NONE, "NONE", true);
        addPattern(PATTERN_DEFAULT, ARI, "ARI", false);


        addPattern(PATTERN_SELECT, ARI, "ARI", false);
        addPattern(PATTERN_SELECT, NONE, "NONE", false);


        lock(C_Kykymdtkrumu.class);
    }

    private C_Kykymdtkrumu(String value) {
        super(value);
    }

    public static C_Kykymdtkrumu valueOf(String value) {
        return valueOf(C_Kykymdtkrumu.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Kykymdtkrumu.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Kykymdtkrumu.class, patternId, value);
    }
}
