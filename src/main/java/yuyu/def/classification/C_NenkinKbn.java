
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 年金区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_NenkinKbn</td><td colspan="3">年金区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YUYU}</td><td>&quot;6&quot;</td><td>ゆうゆう</td></tr>
 * </table>
 */
public class C_NenkinKbn extends Classification<C_NenkinKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_NenkinKbn NONE = new C_NenkinKbn("0");

    public static final C_NenkinKbn YUYU = new C_NenkinKbn("6");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NONE, "NONE", true);
        addPattern(PATTERN_DEFAULT, YUYU, "YUYU", false);


        lock(C_NenkinKbn.class);
    }

    private C_NenkinKbn(String value) {
        super(value);
    }

    public static C_NenkinKbn valueOf(String value) {
        return valueOf(C_NenkinKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_NenkinKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_NenkinKbn.class, patternId, value);
    }
}
