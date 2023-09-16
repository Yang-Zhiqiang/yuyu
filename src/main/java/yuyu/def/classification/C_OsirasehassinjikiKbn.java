
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * お知らせ発信時期区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_OsirasehassinjikiKbn</td><td colspan="3">お知らせ発信時期区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #SOKUJI}</td><td>&quot;1&quot;</td><td>即時</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BATCH}</td><td>&quot;2&quot;</td><td>バッチ</td></tr>
 * </table>
 */
public class C_OsirasehassinjikiKbn extends Classification<C_OsirasehassinjikiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_OsirasehassinjikiKbn SOKUJI = new C_OsirasehassinjikiKbn("1");

    public static final C_OsirasehassinjikiKbn BATCH = new C_OsirasehassinjikiKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, SOKUJI, "SOKUJI", true);
        addPattern(PATTERN_DEFAULT, BATCH, "BATCH", false);


        lock(C_OsirasehassinjikiKbn.class);
    }

    private C_OsirasehassinjikiKbn(String value) {
        super(value);
    }

    public static C_OsirasehassinjikiKbn valueOf(String value) {
        return valueOf(C_OsirasehassinjikiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_OsirasehassinjikiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_OsirasehassinjikiKbn.class, patternId, value);
    }
}
