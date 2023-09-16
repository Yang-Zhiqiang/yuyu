
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 保険料免除特約継続要否区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_PmnjtkkzkyouhiKbn</td><td colspan="3">保険料免除特約継続要否区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MUKOU}</td><td>&quot;1&quot;</td><td>無効</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KEIZOKU}</td><td>&quot;2&quot;</td><td>継続</td></tr>
 * </table>
 */
public class C_PmnjtkkzkyouhiKbn extends Classification<C_PmnjtkkzkyouhiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_PmnjtkkzkyouhiKbn BLNK = new C_PmnjtkkzkyouhiKbn("0");

    public static final C_PmnjtkkzkyouhiKbn MUKOU = new C_PmnjtkkzkyouhiKbn("1");

    public static final C_PmnjtkkzkyouhiKbn KEIZOKU = new C_PmnjtkkzkyouhiKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, MUKOU, "MUKOU", false);
        addPattern(PATTERN_DEFAULT, KEIZOKU, "KEIZOKU", false);


        lock(C_PmnjtkkzkyouhiKbn.class);
    }

    private C_PmnjtkkzkyouhiKbn(String value) {
        super(value);
    }

    public static C_PmnjtkkzkyouhiKbn valueOf(String value) {
        return valueOf(C_PmnjtkkzkyouhiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_PmnjtkkzkyouhiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_PmnjtkkzkyouhiKbn.class, patternId, value);
    }
}
