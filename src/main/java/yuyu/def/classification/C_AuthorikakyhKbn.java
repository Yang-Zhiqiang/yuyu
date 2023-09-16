
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * オーソリ確認要否区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_AuthorikakyhKbn</td><td colspan="3">オーソリ確認要否区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #YOU}</td><td>&quot;0&quot;</td><td>要</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUYOU}</td><td>&quot;1&quot;</td><td>不要</td></tr>
 * </table>
 */
public class C_AuthorikakyhKbn extends Classification<C_AuthorikakyhKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_AuthorikakyhKbn YOU = new C_AuthorikakyhKbn("0");

    public static final C_AuthorikakyhKbn HUYOU = new C_AuthorikakyhKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, YOU, "YOU", true);
        addPattern(PATTERN_DEFAULT, HUYOU, "HUYOU", false);


        lock(C_AuthorikakyhKbn.class);
    }

    private C_AuthorikakyhKbn(String value) {
        super(value);
    }

    public static C_AuthorikakyhKbn valueOf(String value) {
        return valueOf(C_AuthorikakyhKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_AuthorikakyhKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_AuthorikakyhKbn.class, patternId, value);
    }
}
