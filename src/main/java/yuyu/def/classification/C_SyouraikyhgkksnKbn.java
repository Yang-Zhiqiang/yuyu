
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 将来給付額計算区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SyouraikyhgkksnKbn</td><td colspan="3">将来給付額計算区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #WAHANKENSUU2}</td><td>&quot;1&quot;</td><td>和半件数2</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #WAHAN3RDSECS2}</td><td>&quot;2&quot;</td><td>和半第三分野S2</td></tr>
 * </table>
 */
public class C_SyouraikyhgkksnKbn extends Classification<C_SyouraikyhgkksnKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SyouraikyhgkksnKbn BLNK = new C_SyouraikyhgkksnKbn("0");

    public static final C_SyouraikyhgkksnKbn WAHANKENSUU2 = new C_SyouraikyhgkksnKbn("1");

    public static final C_SyouraikyhgkksnKbn WAHAN3RDSECS2 = new C_SyouraikyhgkksnKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, WAHANKENSUU2, "WAHANKENSUU2", false);
        addPattern(PATTERN_DEFAULT, WAHAN3RDSECS2, "WAHAN3RDSECS2", false);


        lock(C_SyouraikyhgkksnKbn.class);
    }

    private C_SyouraikyhgkksnKbn(String value) {
        super(value);
    }

    public static C_SyouraikyhgkksnKbn valueOf(String value) {
        return valueOf(C_SyouraikyhgkksnKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SyouraikyhgkksnKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SyouraikyhgkksnKbn.class, patternId, value);
    }
}
