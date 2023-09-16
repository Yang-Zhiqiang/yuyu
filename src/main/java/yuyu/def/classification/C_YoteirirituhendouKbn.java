
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 予定利率変動区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_YoteirirituhendouKbn</td><td colspan="3">予定利率変動区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TUKI1KAI}</td><td>&quot;1&quot;</td><td>月１回</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TUKI2KAI}</td><td>&quot;2&quot;</td><td>月２回（１日・１６日）</td></tr>
 * </table>
 */
public class C_YoteirirituhendouKbn extends Classification<C_YoteirirituhendouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_YoteirirituhendouKbn NONE = new C_YoteirirituhendouKbn("0");

    public static final C_YoteirirituhendouKbn TUKI1KAI = new C_YoteirirituhendouKbn("1");

    public static final C_YoteirirituhendouKbn TUKI2KAI = new C_YoteirirituhendouKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NONE, "NONE", true);
        addPattern(PATTERN_DEFAULT, TUKI1KAI, "TUKI1KAI", false);
        addPattern(PATTERN_DEFAULT, TUKI2KAI, "TUKI2KAI", false);


        lock(C_YoteirirituhendouKbn.class);
    }

    private C_YoteirirituhendouKbn(String value) {
        super(value);
    }

    public static C_YoteirirituhendouKbn valueOf(String value) {
        return valueOf(C_YoteirirituhendouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_YoteirirituhendouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_YoteirirituhendouKbn.class, patternId, value);
    }
}
