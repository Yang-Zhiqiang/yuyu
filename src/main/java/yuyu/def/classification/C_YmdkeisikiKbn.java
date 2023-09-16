
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 年月日形式区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_YmdkeisikiKbn</td><td colspan="3">年月日形式区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YYYYMMDD}</td><td>&quot;1&quot;</td><td>年月日</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YYYYMM}</td><td>&quot;2&quot;</td><td>年月</td></tr>
 * </table>
 */
public class C_YmdkeisikiKbn extends Classification<C_YmdkeisikiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_YmdkeisikiKbn BLNK = new C_YmdkeisikiKbn("0");

    public static final C_YmdkeisikiKbn YYYYMMDD = new C_YmdkeisikiKbn("1");

    public static final C_YmdkeisikiKbn YYYYMM = new C_YmdkeisikiKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, YYYYMMDD, "YYYYMMDD", false);
        addPattern(PATTERN_DEFAULT, YYYYMM, "YYYYMM", false);


        lock(C_YmdkeisikiKbn.class);
    }

    private C_YmdkeisikiKbn(String value) {
        super(value);
    }

    public static C_YmdkeisikiKbn valueOf(String value) {
        return valueOf(C_YmdkeisikiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_YmdkeisikiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_YmdkeisikiKbn.class, patternId, value);
    }
}
