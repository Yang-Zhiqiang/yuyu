
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 外貨本口座移動ルート区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_GkhnkzidourtKbn</td><td colspan="3">外貨本口座移動ルート区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GKKZDIRECT}</td><td>&quot;1&quot;</td><td>外貨本口座直通</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YENKZKEIYUGKKZ}</td><td>&quot;2&quot;</td><td>円本口座経由外貨本口座</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NONE}</td><td>&quot;9&quot;</td><td>対象外</td></tr>
 * </table>
 */
public class C_GkhnkzidourtKbn extends Classification<C_GkhnkzidourtKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_GkhnkzidourtKbn BLNK = new C_GkhnkzidourtKbn("0");

    public static final C_GkhnkzidourtKbn GKKZDIRECT = new C_GkhnkzidourtKbn("1");

    public static final C_GkhnkzidourtKbn YENKZKEIYUGKKZ = new C_GkhnkzidourtKbn("2");

    public static final C_GkhnkzidourtKbn NONE = new C_GkhnkzidourtKbn("9");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, GKKZDIRECT, "GKKZDIRECT", false);
        addPattern(PATTERN_DEFAULT, YENKZKEIYUGKKZ, "YENKZKEIYUGKKZ", false);
        addPattern(PATTERN_DEFAULT, NONE, "NONE", false);


        lock(C_GkhnkzidourtKbn.class);
    }

    private C_GkhnkzidourtKbn(String value) {
        super(value);
    }

    public static C_GkhnkzidourtKbn valueOf(String value) {
        return valueOf(C_GkhnkzidourtKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_GkhnkzidourtKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_GkhnkzidourtKbn.class, patternId, value);
    }
}
