
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 保険法施行区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HknhouskKbn</td><td colspan="3">保険法施行区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #MAE}</td><td>&quot;0&quot;</td><td>保険法施行前契約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ATO}</td><td>&quot;1&quot;</td><td>保険法施行後契約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;2&quot;</td><td>その他</td></tr>
 * </table>
 */
public class C_HknhouskKbn extends Classification<C_HknhouskKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HknhouskKbn MAE = new C_HknhouskKbn("0");

    public static final C_HknhouskKbn ATO = new C_HknhouskKbn("1");

    public static final C_HknhouskKbn SONOTA = new C_HknhouskKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, MAE, "MAE", true);
        addPattern(PATTERN_DEFAULT, ATO, "ATO", false);
        addPattern(PATTERN_DEFAULT, SONOTA, "SONOTA", false);


        lock(C_HknhouskKbn.class);
    }

    private C_HknhouskKbn(String value) {
        super(value);
    }

    public static C_HknhouskKbn valueOf(String value) {
        return valueOf(C_HknhouskKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HknhouskKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HknhouskKbn.class, patternId, value);
    }
}
