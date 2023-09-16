
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 親子代理店区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_OyakodrtenKbn</td><td colspan="3">親子代理店区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>親子関係なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OYA}</td><td>&quot;1&quot;</td><td>親</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KO}</td><td>&quot;2&quot;</td><td>子</td></tr>
 * </table>
 */
public class C_OyakodrtenKbn extends Classification<C_OyakodrtenKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_OyakodrtenKbn NONE = new C_OyakodrtenKbn("0");

    public static final C_OyakodrtenKbn OYA = new C_OyakodrtenKbn("1");

    public static final C_OyakodrtenKbn KO = new C_OyakodrtenKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NONE, "NONE", true);
        addPattern(PATTERN_DEFAULT, OYA, "OYA", false);
        addPattern(PATTERN_DEFAULT, KO, "KO", false);


        lock(C_OyakodrtenKbn.class);
    }

    private C_OyakodrtenKbn(String value) {
        super(value);
    }

    public static C_OyakodrtenKbn valueOf(String value) {
        return valueOf(C_OyakodrtenKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_OyakodrtenKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_OyakodrtenKbn.class, patternId, value);
    }
}
