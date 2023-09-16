
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 組織コード登録解除区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SosikiCdTourokuKaijoKbn</td><td colspan="3">組織コード登録解除区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #TOUROKU}</td><td>&quot;0&quot;</td><td>登録</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIJO}</td><td>&quot;1&quot;</td><td>解除</td></tr>
 * </table>
 */
public class C_SosikiCdTourokuKaijoKbn extends Classification<C_SosikiCdTourokuKaijoKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SosikiCdTourokuKaijoKbn TOUROKU = new C_SosikiCdTourokuKaijoKbn("0");

    public static final C_SosikiCdTourokuKaijoKbn KAIJO = new C_SosikiCdTourokuKaijoKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, TOUROKU, "TOUROKU", true);
        addPattern(PATTERN_DEFAULT, KAIJO, "KAIJO", false);


        lock(C_SosikiCdTourokuKaijoKbn.class);
    }

    private C_SosikiCdTourokuKaijoKbn(String value) {
        super(value);
    }

    public static C_SosikiCdTourokuKaijoKbn valueOf(String value) {
        return valueOf(C_SosikiCdTourokuKaijoKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SosikiCdTourokuKaijoKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SosikiCdTourokuKaijoKbn.class, patternId, value);
    }
}
