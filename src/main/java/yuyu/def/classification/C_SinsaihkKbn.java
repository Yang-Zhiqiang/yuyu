
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 新規再発行区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SinsaihkKbn</td><td colspan="3">新規再発行区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIN}</td><td>&quot;1&quot;</td><td>新規</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAI}</td><td>&quot;2&quot;</td><td>再発行</td></tr>
 * </table>
 */
public class C_SinsaihkKbn extends Classification<C_SinsaihkKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SinsaihkKbn BLNK = new C_SinsaihkKbn("0");

    public static final C_SinsaihkKbn SIN = new C_SinsaihkKbn("1");

    public static final C_SinsaihkKbn SAI = new C_SinsaihkKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SIN, "SIN", false);
        addPattern(PATTERN_DEFAULT, SAI, "SAI", false);


        lock(C_SinsaihkKbn.class);
    }

    private C_SinsaihkKbn(String value) {
        super(value);
    }

    public static C_SinsaihkKbn valueOf(String value) {
        return valueOf(C_SinsaihkKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SinsaihkKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SinsaihkKbn.class, patternId, value);
    }
}
