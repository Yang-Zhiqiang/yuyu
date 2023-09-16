
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 期間歳満期区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KknsmnKbn</td><td colspan="3">期間歳満期区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAI}</td><td>&quot;1&quot;</td><td>歳</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NEN}</td><td>&quot;2&quot;</td><td>年</td></tr>
 * </table>
 */
public class C_KknsmnKbn extends Classification<C_KknsmnKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KknsmnKbn BLNK = new C_KknsmnKbn("0");

    public static final C_KknsmnKbn SAI = new C_KknsmnKbn("1");

    public static final C_KknsmnKbn NEN = new C_KknsmnKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SAI, "SAI", false);
        addPattern(PATTERN_DEFAULT, NEN, "NEN", false);


        lock(C_KknsmnKbn.class);
    }

    private C_KknsmnKbn(String value) {
        super(value);
    }

    public static C_KknsmnKbn valueOf(String value) {
        return valueOf(C_KknsmnKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KknsmnKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KknsmnKbn.class, patternId, value);
    }
}
