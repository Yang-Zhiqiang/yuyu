
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 手数料明細配列区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TsrymeshrtKbn</td><td colspan="3">手数料明細配列区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #TEMEIHAIRETU1}</td><td>&quot;1&quot;</td><td>手数料明細配列１</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEMEIHAIRETU2}</td><td>&quot;2&quot;</td><td>手数料明細配列２</td></tr>
 * </table>
 */
public class C_TsrymeshrtKbn extends Classification<C_TsrymeshrtKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TsrymeshrtKbn TEMEIHAIRETU1 = new C_TsrymeshrtKbn("1");

    public static final C_TsrymeshrtKbn TEMEIHAIRETU2 = new C_TsrymeshrtKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, TEMEIHAIRETU1, "TEMEIHAIRETU1", true);
        addPattern(PATTERN_DEFAULT, TEMEIHAIRETU2, "TEMEIHAIRETU2", false);


        lock(C_TsrymeshrtKbn.class);
    }

    private C_TsrymeshrtKbn(String value) {
        super(value);
    }

    public static C_TsrymeshrtKbn valueOf(String value) {
        return valueOf(C_TsrymeshrtKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TsrymeshrtKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TsrymeshrtKbn.class, patternId, value);
    }
}
