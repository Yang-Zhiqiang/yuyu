
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ２画面モード状態区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_NiGamenModeJyoutaiKbn</td><td colspan="3">２画面モード状態区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NO}</td><td>&quot;1&quot;</td><td>NO</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OFF}</td><td>&quot;2&quot;</td><td>OFF</td></tr>
 * </table>
 */
public class C_NiGamenModeJyoutaiKbn extends Classification<C_NiGamenModeJyoutaiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_NiGamenModeJyoutaiKbn NO = new C_NiGamenModeJyoutaiKbn("1");

    public static final C_NiGamenModeJyoutaiKbn OFF = new C_NiGamenModeJyoutaiKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NO, "NO", true);
        addPattern(PATTERN_DEFAULT, OFF, "OFF", false);


        lock(C_NiGamenModeJyoutaiKbn.class);
    }

    private C_NiGamenModeJyoutaiKbn(String value) {
        super(value);
    }

    public static C_NiGamenModeJyoutaiKbn valueOf(String value) {
        return valueOf(C_NiGamenModeJyoutaiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_NiGamenModeJyoutaiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_NiGamenModeJyoutaiKbn.class, patternId, value);
    }
}
