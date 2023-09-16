
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 入出金区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_NsyknKbn</td><td colspan="3">入出金区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NYKN}</td><td>&quot;1&quot;</td><td>入金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYKN}</td><td>&quot;2&quot;</td><td>出金</td></tr>
 * </table>
 */
public class C_NsyknKbn extends Classification<C_NsyknKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_NsyknKbn BLNK = new C_NsyknKbn("0");

    public static final C_NsyknKbn NYKN = new C_NsyknKbn("1");

    public static final C_NsyknKbn SYKN = new C_NsyknKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, NYKN, "NYKN", false);
        addPattern(PATTERN_DEFAULT, SYKN, "SYKN", false);


        lock(C_NsyknKbn.class);
    }

    private C_NsyknKbn(String value) {
        super(value);
    }

    public static C_NsyknKbn valueOf(String value) {
        return valueOf(C_NsyknKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_NsyknKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_NsyknKbn.class, patternId, value);
    }
}
