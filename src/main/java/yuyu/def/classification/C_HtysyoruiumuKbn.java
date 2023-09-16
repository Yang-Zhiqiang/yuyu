
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 必要書類有無区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HtysyoruiumuKbn</td><td colspan="3">必要書類有無区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MARU}</td><td>&quot;1&quot;</td><td>○</td></tr>
 * </table>
 */
public class C_HtysyoruiumuKbn extends Classification<C_HtysyoruiumuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HtysyoruiumuKbn BLNK = new C_HtysyoruiumuKbn("0");

    public static final C_HtysyoruiumuKbn MARU = new C_HtysyoruiumuKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, MARU, "MARU", false);


        lock(C_HtysyoruiumuKbn.class);
    }

    private C_HtysyoruiumuKbn(String value) {
        super(value);
    }

    public static C_HtysyoruiumuKbn valueOf(String value) {
        return valueOf(C_HtysyoruiumuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HtysyoruiumuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HtysyoruiumuKbn.class, patternId, value);
    }
}
