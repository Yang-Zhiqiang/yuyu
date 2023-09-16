
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 通貨換算区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TuukaksKbn</td><td colspan="3">通貨換算区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #YEN_GAIKA}</td><td>&quot;1&quot;</td><td>円から外貨</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKA_YEN}</td><td>&quot;2&quot;</td><td>外貨から円</td></tr>
 * </table>
 */
public class C_TuukaksKbn extends Classification<C_TuukaksKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TuukaksKbn YEN_GAIKA = new C_TuukaksKbn("1");

    public static final C_TuukaksKbn GAIKA_YEN = new C_TuukaksKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, YEN_GAIKA, "YEN_GAIKA", true);
        addPattern(PATTERN_DEFAULT, GAIKA_YEN, "GAIKA_YEN", false);


        lock(C_TuukaksKbn.class);
    }

    private C_TuukaksKbn(String value) {
        super(value);
    }

    public static C_TuukaksKbn valueOf(String value) {
        return valueOf(C_TuukaksKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TuukaksKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TuukaksKbn.class, patternId, value);
    }
}
