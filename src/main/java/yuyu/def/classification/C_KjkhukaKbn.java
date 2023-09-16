
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 漢字化不可区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KjkhukaKbn</td><td colspan="3">漢字化不可区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KJKHUKA}</td><td>&quot;1&quot;</td><td>漢字化不可</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_MEIGIHNK MEIGIHNK}<br />(名義変更)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KJKHUKA}</td><td>&quot;1&quot;</td><td>※</td></tr>
 *  <tr><td rowspan="1">{@link #PATTERN_NOBLNK NOBLNK}<br />(ブランクなし)</td><td align="center">&nbsp;</td><td>{@link #KJKHUKA}</td><td>&quot;1&quot;</td><td>漢字化不可</td></tr>
 * </table>
 */
public class C_KjkhukaKbn extends Classification<C_KjkhukaKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KjkhukaKbn BLNK = new C_KjkhukaKbn("0");

    public static final C_KjkhukaKbn KJKHUKA = new C_KjkhukaKbn("1");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_MEIGIHNK = "2";

    public static final String PATTERN_NOBLNK = "3";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KJKHUKA, "KJKHUKA", false);


        addPattern(PATTERN_MEIGIHNK, BLNK, "BLNK", true);
        addPattern(PATTERN_MEIGIHNK, KJKHUKA, "KJKHUKA", false);


        addPattern(PATTERN_NOBLNK, KJKHUKA, "KJKHUKA", false);


        lock(C_KjkhukaKbn.class);
    }

    private C_KjkhukaKbn(String value) {
        super(value);
    }

    public static C_KjkhukaKbn valueOf(String value) {
        return valueOf(C_KjkhukaKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KjkhukaKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KjkhukaKbn.class, patternId, value);
    }
}
