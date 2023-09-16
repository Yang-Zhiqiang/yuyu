
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 支払精算区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_ShrssnKbn</td><td colspan="3">支払精算区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #KAKUTEIMAE}</td><td>&quot;0&quot;</td><td>確定前</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIHARAIZUMI}</td><td>&quot;1&quot;</td><td>支払済</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KURINOBETYU}</td><td>&quot;2&quot;</td><td>繰延中</td></tr>
 * </table>
 */
public class C_ShrssnKbn extends Classification<C_ShrssnKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_ShrssnKbn KAKUTEIMAE = new C_ShrssnKbn("0");

    public static final C_ShrssnKbn SIHARAIZUMI = new C_ShrssnKbn("1");

    public static final C_ShrssnKbn KURINOBETYU = new C_ShrssnKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, KAKUTEIMAE, "KAKUTEIMAE", true);
        addPattern(PATTERN_DEFAULT, SIHARAIZUMI, "SIHARAIZUMI", false);
        addPattern(PATTERN_DEFAULT, KURINOBETYU, "KURINOBETYU", false);


        lock(C_ShrssnKbn.class);
    }

    private C_ShrssnKbn(String value) {
        super(value);
    }

    public static C_ShrssnKbn valueOf(String value) {
        return valueOf(C_ShrssnKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_ShrssnKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_ShrssnKbn.class, patternId, value);
    }
}
