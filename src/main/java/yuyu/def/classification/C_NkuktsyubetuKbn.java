
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 年金受取人種別区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_NkuktsyubetuKbn</td><td colspan="3">年金受取人種別区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SOUZOKU}</td><td>&quot;1&quot;</td><td>法定相続人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KZUKT}</td><td>&quot;2&quot;</td><td>継続年金受取人</td></tr>
 * </table>
 */
public class C_NkuktsyubetuKbn extends Classification<C_NkuktsyubetuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_NkuktsyubetuKbn BLNK = new C_NkuktsyubetuKbn("0");

    public static final C_NkuktsyubetuKbn SOUZOKU = new C_NkuktsyubetuKbn("1");

    public static final C_NkuktsyubetuKbn KZUKT = new C_NkuktsyubetuKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SOUZOKU, "SOUZOKU", false);
        addPattern(PATTERN_DEFAULT, KZUKT, "KZUKT", false);


        lock(C_NkuktsyubetuKbn.class);
    }

    private C_NkuktsyubetuKbn(String value) {
        super(value);
    }

    public static C_NkuktsyubetuKbn valueOf(String value) {
        return valueOf(C_NkuktsyubetuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_NkuktsyubetuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_NkuktsyubetuKbn.class, patternId, value);
    }
}
