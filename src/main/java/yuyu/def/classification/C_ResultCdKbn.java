
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 結果コード区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_ResultCdKbn</td><td colspan="3">結果コード区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #OK}</td><td>&quot;0&quot;</td><td>正常終了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #WARN}</td><td>&quot;1&quot;</td><td>警告終了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NG}</td><td>&quot;9&quot;</td><td>異常終了</td></tr>
 * </table>
 */
public class C_ResultCdKbn extends Classification<C_ResultCdKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_ResultCdKbn OK = new C_ResultCdKbn("0");

    public static final C_ResultCdKbn WARN = new C_ResultCdKbn("1");

    public static final C_ResultCdKbn NG = new C_ResultCdKbn("9");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, OK, "OK", true);
        addPattern(PATTERN_DEFAULT, WARN, "WARN", false);
        addPattern(PATTERN_DEFAULT, NG, "NG", false);


        lock(C_ResultCdKbn.class);
    }

    private C_ResultCdKbn(String value) {
        super(value);
    }

    public static C_ResultCdKbn valueOf(String value) {
        return valueOf(C_ResultCdKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_ResultCdKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_ResultCdKbn.class, patternId, value);
    }
}
