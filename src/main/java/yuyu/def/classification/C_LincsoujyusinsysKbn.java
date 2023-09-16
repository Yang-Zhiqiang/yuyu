
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＬＩＮＣ送受信用システム区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_LincsoujyusinsysKbn</td><td colspan="3">ＬＩＮＣ送受信用システム区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #SKEI}</td><td>&quot;0&quot;</td><td>新契約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOZEN}</td><td>&quot;1&quot;</td><td>契約保全</td></tr>
 * </table>
 */
public class C_LincsoujyusinsysKbn extends Classification<C_LincsoujyusinsysKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_LincsoujyusinsysKbn SKEI = new C_LincsoujyusinsysKbn("0");

    public static final C_LincsoujyusinsysKbn HOZEN = new C_LincsoujyusinsysKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, SKEI, "SKEI", true);
        addPattern(PATTERN_DEFAULT, HOZEN, "HOZEN", false);


        lock(C_LincsoujyusinsysKbn.class);
    }

    private C_LincsoujyusinsysKbn(String value) {
        super(value);
    }

    public static C_LincsoujyusinsysKbn valueOf(String value) {
        return valueOf(C_LincsoujyusinsysKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_LincsoujyusinsysKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_LincsoujyusinsysKbn.class, patternId, value);
    }
}
