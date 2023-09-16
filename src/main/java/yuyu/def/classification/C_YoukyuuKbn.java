
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 要求区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_YoukyuuKbn</td><td colspan="3">要求区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>要求しない</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YOUKYUU}</td><td>&quot;1&quot;</td><td>要求する</td></tr>
 * </table>
 */
public class C_YoukyuuKbn extends Classification<C_YoukyuuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_YoukyuuKbn NONE = new C_YoukyuuKbn("0");

    public static final C_YoukyuuKbn YOUKYUU = new C_YoukyuuKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NONE, "NONE", true);
        addPattern(PATTERN_DEFAULT, YOUKYUU, "YOUKYUU", false);


        lock(C_YoukyuuKbn.class);
    }

    private C_YoukyuuKbn(String value) {
        super(value);
    }

    public static C_YoukyuuKbn valueOf(String value) {
        return valueOf(C_YoukyuuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_YoukyuuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_YoukyuuKbn.class, patternId, value);
    }
}
