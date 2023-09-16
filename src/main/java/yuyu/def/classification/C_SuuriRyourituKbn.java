
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 数理料率区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SuuriRyourituKbn</td><td colspan="3">数理料率区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #OTHER}</td><td>&quot;0&quot;</td><td>その他（普通料率・一時払料率）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUHURI}</td><td>&quot;3&quot;</td><td>口座振替料率</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CREDIT}</td><td>&quot;5&quot;</td><td>クレジット料率</td></tr>
 * </table>
 */
public class C_SuuriRyourituKbn extends Classification<C_SuuriRyourituKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SuuriRyourituKbn OTHER = new C_SuuriRyourituKbn("0");

    public static final C_SuuriRyourituKbn KOUHURI = new C_SuuriRyourituKbn("3");

    public static final C_SuuriRyourituKbn CREDIT = new C_SuuriRyourituKbn("5");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, OTHER, "OTHER", true);
        addPattern(PATTERN_DEFAULT, KOUHURI, "KOUHURI", false);
        addPattern(PATTERN_DEFAULT, CREDIT, "CREDIT", false);


        lock(C_SuuriRyourituKbn.class);
    }

    private C_SuuriRyourituKbn(String value) {
        super(value);
    }

    public static C_SuuriRyourituKbn valueOf(String value) {
        return valueOf(C_SuuriRyourituKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SuuriRyourituKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SuuriRyourituKbn.class, patternId, value);
    }
}
