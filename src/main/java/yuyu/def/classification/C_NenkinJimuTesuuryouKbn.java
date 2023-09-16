
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 年金事務手数料区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_NenkinJimuTesuuryouKbn</td><td colspan="3">年金事務手数料区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>手数料なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PER1_00}</td><td>&quot;01&quot;</td><td>1.00%</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PER1_25}</td><td>&quot;02&quot;</td><td>1.25%</td></tr>
 * </table>
 */
public class C_NenkinJimuTesuuryouKbn extends Classification<C_NenkinJimuTesuuryouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_NenkinJimuTesuuryouKbn NONE = new C_NenkinJimuTesuuryouKbn("0");

    public static final C_NenkinJimuTesuuryouKbn PER1_00 = new C_NenkinJimuTesuuryouKbn("01");

    public static final C_NenkinJimuTesuuryouKbn PER1_25 = new C_NenkinJimuTesuuryouKbn("02");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NONE, "NONE", true);
        addPattern(PATTERN_DEFAULT, PER1_00, "PER1_00", false);
        addPattern(PATTERN_DEFAULT, PER1_25, "PER1_25", false);


        lock(C_NenkinJimuTesuuryouKbn.class);
    }

    private C_NenkinJimuTesuuryouKbn(String value) {
        super(value);
    }

    public static C_NenkinJimuTesuuryouKbn valueOf(String value) {
        return valueOf(C_NenkinJimuTesuuryouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_NenkinJimuTesuuryouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_NenkinJimuTesuuryouKbn.class, patternId, value);
    }
}
