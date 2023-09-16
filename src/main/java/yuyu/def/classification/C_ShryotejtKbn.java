
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 支払予定状態区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_ShryotejtKbn</td><td colspan="3">支払予定状態区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #KARI}</td><td>&quot;0&quot;</td><td>仮</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAKUTEI}</td><td>&quot;1&quot;</td><td>確定</td></tr>
 * </table>
 */
public class C_ShryotejtKbn extends Classification<C_ShryotejtKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_ShryotejtKbn KARI = new C_ShryotejtKbn("0");

    public static final C_ShryotejtKbn KAKUTEI = new C_ShryotejtKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, KARI, "KARI", true);
        addPattern(PATTERN_DEFAULT, KAKUTEI, "KAKUTEI", false);


        lock(C_ShryotejtKbn.class);
    }

    private C_ShryotejtKbn(String value) {
        super(value);
    }

    public static C_ShryotejtKbn valueOf(String value) {
        return valueOf(C_ShryotejtKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_ShryotejtKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_ShryotejtKbn.class, patternId, value);
    }
}
