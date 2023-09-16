
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * お知らせ既読区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_OsirasekidokuKbn</td><td colspan="3">お知らせ既読区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #MIDOKU}</td><td>&quot;0&quot;</td><td>未読</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KIDOKU}</td><td>&quot;1&quot;</td><td>既読</td></tr>
 * </table>
 */
public class C_OsirasekidokuKbn extends Classification<C_OsirasekidokuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_OsirasekidokuKbn MIDOKU = new C_OsirasekidokuKbn("0");

    public static final C_OsirasekidokuKbn KIDOKU = new C_OsirasekidokuKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, MIDOKU, "MIDOKU", true);
        addPattern(PATTERN_DEFAULT, KIDOKU, "KIDOKU", false);


        lock(C_OsirasekidokuKbn.class);
    }

    private C_OsirasekidokuKbn(String value) {
        super(value);
    }

    public static C_OsirasekidokuKbn valueOf(String value) {
        return valueOf(C_OsirasekidokuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_OsirasekidokuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_OsirasekidokuKbn.class, patternId, value);
    }
}
