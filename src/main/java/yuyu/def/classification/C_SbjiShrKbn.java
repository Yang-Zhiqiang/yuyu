
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 死亡時支払区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SbjiShrKbn</td><td colspan="3">死亡時支払区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBHOKENKIN}</td><td>&quot;1&quot;</td><td>死亡保険金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBHENKANKIN}</td><td>&quot;2&quot;</td><td>死亡返還金</td></tr>
 * </table>
 */
public class C_SbjiShrKbn extends Classification<C_SbjiShrKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SbjiShrKbn BLNK = new C_SbjiShrKbn("0");

    public static final C_SbjiShrKbn SBHOKENKIN = new C_SbjiShrKbn("1");

    public static final C_SbjiShrKbn SBHENKANKIN = new C_SbjiShrKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SBHOKENKIN, "SBHOKENKIN", false);
        addPattern(PATTERN_DEFAULT, SBHENKANKIN, "SBHENKANKIN", false);


        lock(C_SbjiShrKbn.class);
    }

    private C_SbjiShrKbn(String value) {
        super(value);
    }

    public static C_SbjiShrKbn valueOf(String value) {
        return valueOf(C_SbjiShrKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SbjiShrKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SbjiShrKbn.class, patternId, value);
    }
}
