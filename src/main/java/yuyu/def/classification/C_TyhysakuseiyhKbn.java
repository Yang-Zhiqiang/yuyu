
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 帳票作成要否区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TyhysakuseiyhKbn</td><td colspan="3">帳票作成要否区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YOU}</td><td>&quot;1&quot;</td><td>要</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUYOU}</td><td>&quot;2&quot;</td><td>不要</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_NOBLNK NOBLNK}<br />(ブランクなし)</td><td align="center">○</td><td>{@link #HUYOU}</td><td>&quot;2&quot;</td><td>不要</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YOU}</td><td>&quot;1&quot;</td><td>要</td></tr>
 * </table>
 */
public class C_TyhysakuseiyhKbn extends Classification<C_TyhysakuseiyhKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TyhysakuseiyhKbn BLNK = new C_TyhysakuseiyhKbn("0");

    public static final C_TyhysakuseiyhKbn YOU = new C_TyhysakuseiyhKbn("1");

    public static final C_TyhysakuseiyhKbn HUYOU = new C_TyhysakuseiyhKbn("2");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_NOBLNK = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, YOU, "YOU", false);
        addPattern(PATTERN_DEFAULT, HUYOU, "HUYOU", false);


        addPattern(PATTERN_NOBLNK, HUYOU, "HUYOU", true);
        addPattern(PATTERN_NOBLNK, YOU, "YOU", false);


        lock(C_TyhysakuseiyhKbn.class);
    }

    private C_TyhysakuseiyhKbn(String value) {
        super(value);
    }

    public static C_TyhysakuseiyhKbn valueOf(String value) {
        return valueOf(C_TyhysakuseiyhKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TyhysakuseiyhKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TyhysakuseiyhKbn.class, patternId, value);
    }
}
