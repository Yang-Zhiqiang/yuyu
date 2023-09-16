
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 登録家族区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TrkKzkKbn</td><td colspan="3">登録家族区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TRKKZK1}</td><td>&quot;1&quot;</td><td>登録家族（１人目）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TRKKZK2}</td><td>&quot;2&quot;</td><td>登録家族（２人目）</td></tr>
 * </table>
 */
public class C_TrkKzkKbn extends Classification<C_TrkKzkKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TrkKzkKbn BLNK = new C_TrkKzkKbn("0");

    public static final C_TrkKzkKbn TRKKZK1 = new C_TrkKzkKbn("1");

    public static final C_TrkKzkKbn TRKKZK2 = new C_TrkKzkKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, TRKKZK1, "TRKKZK1", false);
        addPattern(PATTERN_DEFAULT, TRKKZK2, "TRKKZK2", false);


        lock(C_TrkKzkKbn.class);
    }

    private C_TrkKzkKbn(String value) {
        super(value);
    }

    public static C_TrkKzkKbn valueOf(String value) {
        return valueOf(C_TrkKzkKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TrkKzkKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TrkKzkKbn.class, patternId, value);
    }
}
