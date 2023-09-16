
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * １ＰＣＬ請求状況区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_1pclskjkKbn</td><td colspan="3">１ＰＣＬ請求状況区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #MISK}</td><td>&quot;0&quot;</td><td>未請求</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FST}</td><td>&quot;1&quot;</td><td>初回</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SECOND}</td><td>&quot;2&quot;</td><td>２回目</td></tr>
 * </table>
 */
public class C_1pclskjkKbn extends Classification<C_1pclskjkKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_1pclskjkKbn MISK = new C_1pclskjkKbn("0");

    public static final C_1pclskjkKbn FST = new C_1pclskjkKbn("1");

    public static final C_1pclskjkKbn SECOND = new C_1pclskjkKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, MISK, "MISK", true);
        addPattern(PATTERN_DEFAULT, FST, "FST", false);
        addPattern(PATTERN_DEFAULT, SECOND, "SECOND", false);


        lock(C_1pclskjkKbn.class);
    }

    private C_1pclskjkKbn(String value) {
        super(value);
    }

    public static C_1pclskjkKbn valueOf(String value) {
        return valueOf(C_1pclskjkKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_1pclskjkKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_1pclskjkKbn.class, patternId, value);
    }
}
