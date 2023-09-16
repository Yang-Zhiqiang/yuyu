
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 個人法人区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Kojinhjn</td><td colspan="3">個人法人区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #KOJIN}</td><td>&quot;1&quot;</td><td>個人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HJN}</td><td>&quot;2&quot;</td><td>法人</td></tr>
 *  <tr><td rowspan="1">{@link #PATTERN_KOJIN KOJIN}<br />(個人)</td><td align="center">○</td><td>{@link #KOJIN}</td><td>&quot;1&quot;</td><td>個人</td></tr>
 * </table>
 */
public class C_Kojinhjn extends Classification<C_Kojinhjn> {

    private static final long serialVersionUID = 1L;


    public static final C_Kojinhjn KOJIN = new C_Kojinhjn("1");

    public static final C_Kojinhjn HJN = new C_Kojinhjn("2");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_KOJIN = "2";


    static {

        addPattern(PATTERN_DEFAULT, KOJIN, "KOJIN", true);
        addPattern(PATTERN_DEFAULT, HJN, "HJN", false);


        addPattern(PATTERN_KOJIN, KOJIN, "KOJIN", true);


        lock(C_Kojinhjn.class);
    }

    private C_Kojinhjn(String value) {
        super(value);
    }

    public static C_Kojinhjn valueOf(String value) {
        return valueOf(C_Kojinhjn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Kojinhjn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Kojinhjn.class, patternId, value);
    }
}
