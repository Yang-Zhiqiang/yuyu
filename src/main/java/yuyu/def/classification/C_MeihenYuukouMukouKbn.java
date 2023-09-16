
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 名義変更有効無効区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_MeihenYuukouMukouKbn</td><td colspan="3">名義変更有効無効区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ENABLE}</td><td>&quot;1&quot;</td><td>有効</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DISABLE}</td><td>&quot;2&quot;</td><td>無効</td></tr>
 * </table>
 */
public class C_MeihenYuukouMukouKbn extends Classification<C_MeihenYuukouMukouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_MeihenYuukouMukouKbn BLNK = new C_MeihenYuukouMukouKbn("0");

    public static final C_MeihenYuukouMukouKbn ENABLE = new C_MeihenYuukouMukouKbn("1");

    public static final C_MeihenYuukouMukouKbn DISABLE = new C_MeihenYuukouMukouKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, ENABLE, "ENABLE", false);
        addPattern(PATTERN_DEFAULT, DISABLE, "DISABLE", false);


        lock(C_MeihenYuukouMukouKbn.class);
    }

    private C_MeihenYuukouMukouKbn(String value) {
        super(value);
    }

    public static C_MeihenYuukouMukouKbn valueOf(String value) {
        return valueOf(C_MeihenYuukouMukouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_MeihenYuukouMukouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_MeihenYuukouMukouKbn.class, patternId, value);
    }
}
