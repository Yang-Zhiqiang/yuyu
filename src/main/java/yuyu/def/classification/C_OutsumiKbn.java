
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 出力済区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_OutsumiKbn</td><td colspan="3">出力済区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #MIOUT}</td><td>&quot;0&quot;</td><td>未出力</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OUTSUMI}</td><td>&quot;1&quot;</td><td>出力済</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NONE}</td><td>&quot;9&quot;</td><td>指定なし</td></tr>
 * </table>
 */
public class C_OutsumiKbn extends Classification<C_OutsumiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_OutsumiKbn MIOUT = new C_OutsumiKbn("0");

    public static final C_OutsumiKbn OUTSUMI = new C_OutsumiKbn("1");

    public static final C_OutsumiKbn NONE = new C_OutsumiKbn("9");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, MIOUT, "MIOUT", true);
        addPattern(PATTERN_DEFAULT, OUTSUMI, "OUTSUMI", false);
        addPattern(PATTERN_DEFAULT, NONE, "NONE", false);


        lock(C_OutsumiKbn.class);
    }

    private C_OutsumiKbn(String value) {
        super(value);
    }

    public static C_OutsumiKbn valueOf(String value) {
        return valueOf(C_OutsumiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_OutsumiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_OutsumiKbn.class, patternId, value);
    }
}
