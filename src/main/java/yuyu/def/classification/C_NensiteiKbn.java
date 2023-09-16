
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 年齢指定区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_NensiteiKbn</td><td colspan="3">年齢指定区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NENREI}</td><td>&quot;0&quot;</td><td>年齢</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEINENGAPPI}</td><td>&quot;1&quot;</td><td>生年月日</td></tr>
 * </table>
 */
public class C_NensiteiKbn extends Classification<C_NensiteiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_NensiteiKbn NENREI = new C_NensiteiKbn("0");

    public static final C_NensiteiKbn SEINENGAPPI = new C_NensiteiKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NENREI, "NENREI", true);
        addPattern(PATTERN_DEFAULT, SEINENGAPPI, "SEINENGAPPI", false);


        lock(C_NensiteiKbn.class);
    }

    private C_NensiteiKbn(String value) {
        super(value);
    }

    public static C_NensiteiKbn valueOf(String value) {
        return valueOf(C_NensiteiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_NensiteiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_NensiteiKbn.class, patternId, value);
    }
}
