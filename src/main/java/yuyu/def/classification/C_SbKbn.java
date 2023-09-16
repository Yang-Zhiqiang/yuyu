
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 死亡区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SbKbn</td><td colspan="3">死亡区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UKEHI}</td><td>&quot;1&quot;</td><td>受被死亡</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UKENOMI}</td><td>&quot;2&quot;</td><td>受のみ死亡</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HINOMI}</td><td>&quot;3&quot;</td><td>被のみ死亡</td></tr>
 * </table>
 */
public class C_SbKbn extends Classification<C_SbKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SbKbn NONE = new C_SbKbn("0");

    public static final C_SbKbn UKEHI = new C_SbKbn("1");

    public static final C_SbKbn UKENOMI = new C_SbKbn("2");

    public static final C_SbKbn HINOMI = new C_SbKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NONE, "NONE", true);
        addPattern(PATTERN_DEFAULT, UKEHI, "UKEHI", false);
        addPattern(PATTERN_DEFAULT, UKENOMI, "UKENOMI", false);
        addPattern(PATTERN_DEFAULT, HINOMI, "HINOMI", false);


        lock(C_SbKbn.class);
    }

    private C_SbKbn(String value) {
        super(value);
    }

    public static C_SbKbn valueOf(String value) {
        return valueOf(C_SbKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SbKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SbKbn.class, patternId, value);
    }
}
