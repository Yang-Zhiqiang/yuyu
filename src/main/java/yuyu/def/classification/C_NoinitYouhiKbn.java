
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 初期値無し要否区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_NoinitYouhiKbn</td><td colspan="3">初期値無し要否区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">&nbsp;</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YOU}</td><td>&quot;1&quot;</td><td>要</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HI}</td><td>&quot;2&quot;</td><td>否</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_NOBLNK NOBLNK}<br />(ブランクなし)</td><td align="center">&nbsp;</td><td>{@link #YOU}</td><td>&quot;1&quot;</td><td>要</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HI}</td><td>&quot;2&quot;</td><td>否</td></tr>
 * </table>
 */
public class C_NoinitYouhiKbn extends Classification<C_NoinitYouhiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_NoinitYouhiKbn BLNK = new C_NoinitYouhiKbn("0");

    public static final C_NoinitYouhiKbn YOU = new C_NoinitYouhiKbn("1");

    public static final C_NoinitYouhiKbn HI = new C_NoinitYouhiKbn("2");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_NOBLNK = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", false);
        addPattern(PATTERN_DEFAULT, YOU, "YOU", false);
        addPattern(PATTERN_DEFAULT, HI, "HI", false);


        addPattern(PATTERN_NOBLNK, YOU, "YOU", false);
        addPattern(PATTERN_NOBLNK, HI, "HI", false);


        lock(C_NoinitYouhiKbn.class);
    }

    private C_NoinitYouhiKbn(String value) {
        super(value);
    }

    public static C_NoinitYouhiKbn valueOf(String value) {
        return valueOf(C_NoinitYouhiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_NoinitYouhiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_NoinitYouhiKbn.class, patternId, value);
    }
}
