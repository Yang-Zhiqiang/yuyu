
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 有無区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_UmuKbn</td><td colspan="3">有無区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ARI}</td><td>&quot;1&quot;</td><td>あり</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_REVERSE REVERSE}<br />(逆パターン)</td><td align="center">○</td><td>{@link #ARI}</td><td>&quot;1&quot;</td><td>あり</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>なし</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_KANJI KANJI}<br />(漢字)</td><td align="center">○</td><td>{@link #ARI}</td><td>&quot;1&quot;</td><td>有</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>無</td></tr>
 * </table>
 */
public class C_UmuKbn extends Classification<C_UmuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_UmuKbn NONE = new C_UmuKbn("0");

    public static final C_UmuKbn ARI = new C_UmuKbn("1");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_REVERSE = "2";

    public static final String PATTERN_KANJI = "3";


    static {

        addPattern(PATTERN_DEFAULT, NONE, "NONE", true);
        addPattern(PATTERN_DEFAULT, ARI, "ARI", false);


        addPattern(PATTERN_REVERSE, ARI, "ARI", true);
        addPattern(PATTERN_REVERSE, NONE, "NONE", false);


        addPattern(PATTERN_KANJI, ARI, "ARI", true);
        addPattern(PATTERN_KANJI, NONE, "NONE", false);


        lock(C_UmuKbn.class);
    }

    private C_UmuKbn(String value) {
        super(value);
    }

    public static C_UmuKbn valueOf(String value) {
        return valueOf(C_UmuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_UmuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_UmuKbn.class, patternId, value);
    }
}
