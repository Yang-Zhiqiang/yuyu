
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 年月日区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_NengappiKbn</td><td colspan="3">年月日区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HI}</td><td>&quot;1&quot;</td><td>日</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TUKI}</td><td>&quot;2&quot;</td><td>月</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NEN}</td><td>&quot;3&quot;</td><td>年</td></tr>
 * </table>
 */
public class C_NengappiKbn extends Classification<C_NengappiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_NengappiKbn BLNK = new C_NengappiKbn("0");

    public static final C_NengappiKbn HI = new C_NengappiKbn("1");

    public static final C_NengappiKbn TUKI = new C_NengappiKbn("2");

    public static final C_NengappiKbn NEN = new C_NengappiKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, HI, "HI", false);
        addPattern(PATTERN_DEFAULT, TUKI, "TUKI", false);
        addPattern(PATTERN_DEFAULT, NEN, "NEN", false);


        lock(C_NengappiKbn.class);
    }

    private C_NengappiKbn(String value) {
        super(value);
    }

    public static C_NengappiKbn valueOf(String value) {
        return valueOf(C_NengappiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_NengappiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_NengappiKbn.class, patternId, value);
    }
}
