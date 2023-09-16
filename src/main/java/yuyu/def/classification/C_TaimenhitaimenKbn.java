
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 対面非対面区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TaimenhitaimenKbn</td><td colspan="3">対面非対面区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TAIMEN}</td><td>&quot;1&quot;</td><td>対面</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HITAIMEN}</td><td>&quot;2&quot;</td><td>非対面</td></tr>
 * </table>
 */
public class C_TaimenhitaimenKbn extends Classification<C_TaimenhitaimenKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TaimenhitaimenKbn BLNK = new C_TaimenhitaimenKbn("0");

    public static final C_TaimenhitaimenKbn TAIMEN = new C_TaimenhitaimenKbn("1");

    public static final C_TaimenhitaimenKbn HITAIMEN = new C_TaimenhitaimenKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, TAIMEN, "TAIMEN", false);
        addPattern(PATTERN_DEFAULT, HITAIMEN, "HITAIMEN", false);


        lock(C_TaimenhitaimenKbn.class);
    }

    private C_TaimenhitaimenKbn(String value) {
        super(value);
    }

    public static C_TaimenhitaimenKbn valueOf(String value) {
        return valueOf(C_TaimenhitaimenKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TaimenhitaimenKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TaimenhitaimenKbn.class, patternId, value);
    }
}
