
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 査定要否区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SateiYouhiKbn</td><td colspan="3">査定要否区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YOU}</td><td>&quot;1&quot;</td><td>査定要</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUYOU}</td><td>&quot;2&quot;</td><td>査定不要</td></tr>
 * </table>
 */
public class C_SateiYouhiKbn extends Classification<C_SateiYouhiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SateiYouhiKbn BLNK = new C_SateiYouhiKbn("0");

    public static final C_SateiYouhiKbn YOU = new C_SateiYouhiKbn("1");

    public static final C_SateiYouhiKbn HUYOU = new C_SateiYouhiKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, YOU, "YOU", false);
        addPattern(PATTERN_DEFAULT, HUYOU, "HUYOU", false);


        lock(C_SateiYouhiKbn.class);
    }

    private C_SateiYouhiKbn(String value) {
        super(value);
    }

    public static C_SateiYouhiKbn valueOf(String value) {
        return valueOf(C_SateiYouhiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SateiYouhiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SateiYouhiKbn.class, patternId, value);
    }
}
