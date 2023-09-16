
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 診断書作成枚数区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SindansyoSksMaisuuKbn</td><td colspan="3">診断書作成枚数区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="10">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #ZERO}</td><td>&quot;0&quot;</td><td>０</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ONE}</td><td>&quot;1&quot;</td><td>１</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TWO}</td><td>&quot;2&quot;</td><td>２</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #THREE}</td><td>&quot;3&quot;</td><td>３</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FOUR}</td><td>&quot;4&quot;</td><td>４</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FIVE}</td><td>&quot;5&quot;</td><td>５</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIX}</td><td>&quot;6&quot;</td><td>６</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEVEN}</td><td>&quot;7&quot;</td><td>７</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #EIGHT}</td><td>&quot;8&quot;</td><td>８</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NINE}</td><td>&quot;9&quot;</td><td>９</td></tr>
 *  <tr><td rowspan="9">{@link #PATTERN_KYUUFU KYUUFU}<br />(給付)</td><td align="center">○</td><td>{@link #ONE}</td><td>&quot;1&quot;</td><td>１</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TWO}</td><td>&quot;2&quot;</td><td>２</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #THREE}</td><td>&quot;3&quot;</td><td>３</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FOUR}</td><td>&quot;4&quot;</td><td>４</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FIVE}</td><td>&quot;5&quot;</td><td>５</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIX}</td><td>&quot;6&quot;</td><td>６</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEVEN}</td><td>&quot;7&quot;</td><td>７</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #EIGHT}</td><td>&quot;8&quot;</td><td>８</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NINE}</td><td>&quot;9&quot;</td><td>９</td></tr>
 * </table>
 */
public class C_SindansyoSksMaisuuKbn extends Classification<C_SindansyoSksMaisuuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SindansyoSksMaisuuKbn ZERO = new C_SindansyoSksMaisuuKbn("0");

    public static final C_SindansyoSksMaisuuKbn ONE = new C_SindansyoSksMaisuuKbn("1");

    public static final C_SindansyoSksMaisuuKbn TWO = new C_SindansyoSksMaisuuKbn("2");

    public static final C_SindansyoSksMaisuuKbn THREE = new C_SindansyoSksMaisuuKbn("3");

    public static final C_SindansyoSksMaisuuKbn FOUR = new C_SindansyoSksMaisuuKbn("4");

    public static final C_SindansyoSksMaisuuKbn FIVE = new C_SindansyoSksMaisuuKbn("5");

    public static final C_SindansyoSksMaisuuKbn SIX = new C_SindansyoSksMaisuuKbn("6");

    public static final C_SindansyoSksMaisuuKbn SEVEN = new C_SindansyoSksMaisuuKbn("7");

    public static final C_SindansyoSksMaisuuKbn EIGHT = new C_SindansyoSksMaisuuKbn("8");

    public static final C_SindansyoSksMaisuuKbn NINE = new C_SindansyoSksMaisuuKbn("9");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_KYUUFU = "2";


    static {

        addPattern(PATTERN_DEFAULT, ZERO, "ZERO", true);
        addPattern(PATTERN_DEFAULT, ONE, "ONE", false);
        addPattern(PATTERN_DEFAULT, TWO, "TWO", false);
        addPattern(PATTERN_DEFAULT, THREE, "THREE", false);
        addPattern(PATTERN_DEFAULT, FOUR, "FOUR", false);
        addPattern(PATTERN_DEFAULT, FIVE, "FIVE", false);
        addPattern(PATTERN_DEFAULT, SIX, "SIX", false);
        addPattern(PATTERN_DEFAULT, SEVEN, "SEVEN", false);
        addPattern(PATTERN_DEFAULT, EIGHT, "EIGHT", false);
        addPattern(PATTERN_DEFAULT, NINE, "NINE", false);


        addPattern(PATTERN_KYUUFU, ONE, "ONE", true);
        addPattern(PATTERN_KYUUFU, TWO, "TWO", false);
        addPattern(PATTERN_KYUUFU, THREE, "THREE", false);
        addPattern(PATTERN_KYUUFU, FOUR, "FOUR", false);
        addPattern(PATTERN_KYUUFU, FIVE, "FIVE", false);
        addPattern(PATTERN_KYUUFU, SIX, "SIX", false);
        addPattern(PATTERN_KYUUFU, SEVEN, "SEVEN", false);
        addPattern(PATTERN_KYUUFU, EIGHT, "EIGHT", false);
        addPattern(PATTERN_KYUUFU, NINE, "NINE", false);


        lock(C_SindansyoSksMaisuuKbn.class);
    }

    private C_SindansyoSksMaisuuKbn(String value) {
        super(value);
    }

    public static C_SindansyoSksMaisuuKbn valueOf(String value) {
        return valueOf(C_SindansyoSksMaisuuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SindansyoSksMaisuuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SindansyoSksMaisuuKbn.class, patternId, value);
    }
}
