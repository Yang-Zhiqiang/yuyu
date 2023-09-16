
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 保険料割引区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_PWaribikiKbn</td><td colspan="3">保険料割引区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;00&quot;</td><td>なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PWARISEIDO}</td><td>&quot;01&quot;</td><td>保険料割引制度</td></tr>
 * </table>
 */
public class C_PWaribikiKbn extends Classification<C_PWaribikiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_PWaribikiKbn NONE = new C_PWaribikiKbn("00");

    public static final C_PWaribikiKbn PWARISEIDO = new C_PWaribikiKbn("01");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NONE, "NONE", true);
        addPattern(PATTERN_DEFAULT, PWARISEIDO, "PWARISEIDO", false);


        lock(C_PWaribikiKbn.class);
    }

    private C_PWaribikiKbn(String value) {
        super(value);
    }

    public static C_PWaribikiKbn valueOf(String value) {
        return valueOf(C_PWaribikiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_PWaribikiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_PWaribikiKbn.class, patternId, value);
    }
}
