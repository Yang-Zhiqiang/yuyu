
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 特定関係法人区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TkhjnKbn</td><td colspan="3">特定関係法人区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NASI}</td><td>&quot;1&quot;</td><td>該当なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ARI}</td><td>&quot;2&quot;</td><td>該当懸念あり</td></tr>
 * </table>
 */
public class C_TkhjnKbn extends Classification<C_TkhjnKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TkhjnKbn BLNK = new C_TkhjnKbn("0");

    public static final C_TkhjnKbn NASI = new C_TkhjnKbn("1");

    public static final C_TkhjnKbn ARI = new C_TkhjnKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, NASI, "NASI", false);
        addPattern(PATTERN_DEFAULT, ARI, "ARI", false);


        lock(C_TkhjnKbn.class);
    }

    private C_TkhjnKbn(String value) {
        super(value);
    }

    public static C_TkhjnKbn valueOf(String value) {
        return valueOf(C_TkhjnKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TkhjnKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TkhjnKbn.class, patternId, value);
    }
}
