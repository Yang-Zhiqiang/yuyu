
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 事務成立保留区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_JimusrhKbn</td><td colspan="3">事務成立保留区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HORYU}</td><td>&quot;1&quot;</td><td>成立保留中</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_RYAKU RYAKU}<br />(略称)</td><td align="center">&nbsp;</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HORYU}</td><td>&quot;1&quot;</td><td>保留中</td></tr>
 * </table>
 */
public class C_JimusrhKbn extends Classification<C_JimusrhKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_JimusrhKbn NONE = new C_JimusrhKbn("0");

    public static final C_JimusrhKbn HORYU = new C_JimusrhKbn("1");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_RYAKU = "2";


    static {

        addPattern(PATTERN_DEFAULT, NONE, "NONE", true);
        addPattern(PATTERN_DEFAULT, HORYU, "HORYU", false);


        addPattern(PATTERN_RYAKU, NONE, "NONE", false);
        addPattern(PATTERN_RYAKU, HORYU, "HORYU", false);


        lock(C_JimusrhKbn.class);
    }

    private C_JimusrhKbn(String value) {
        super(value);
    }

    public static C_JimusrhKbn valueOf(String value) {
        return valueOf(C_JimusrhKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_JimusrhKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_JimusrhKbn.class, patternId, value);
    }
}
