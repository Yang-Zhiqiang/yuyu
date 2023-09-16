
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 募集可否区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_BsKahiKbn</td><td colspan="3">募集可否区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BOSYUUKA}</td><td>&quot;1&quot;</td><td>募集可</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BOSYUUHUKA}</td><td>&quot;2&quot;</td><td>募集不可</td></tr>
 * </table>
 */
public class C_BsKahiKbn extends Classification<C_BsKahiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_BsKahiKbn BLNK = new C_BsKahiKbn("0");

    public static final C_BsKahiKbn BOSYUUKA = new C_BsKahiKbn("1");

    public static final C_BsKahiKbn BOSYUUHUKA = new C_BsKahiKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, BOSYUUKA, "BOSYUUKA", false);
        addPattern(PATTERN_DEFAULT, BOSYUUHUKA, "BOSYUUHUKA", false);


        lock(C_BsKahiKbn.class);
    }

    private C_BsKahiKbn(String value) {
        super(value);
    }

    public static C_BsKahiKbn valueOf(String value) {
        return valueOf(C_BsKahiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_BsKahiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_BsKahiKbn.class, patternId, value);
    }
}
