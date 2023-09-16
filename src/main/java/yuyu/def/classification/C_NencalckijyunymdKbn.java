
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 年齢計算基準日区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_NencalckijyunymdKbn</td><td colspan="3">年齢計算基準日区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #SITEI}</td><td>&quot;0&quot;</td><td>指定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOUJITU}</td><td>&quot;1&quot;</td><td>当日</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YOKU1_OR_YOKUYOKU1}</td><td>&quot;2&quot;</td><td>翌月１日または翌々月１日</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YOKU1}</td><td>&quot;3&quot;</td><td>翌月１日</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YOKUYOKU1}</td><td>&quot;4&quot;</td><td>翌々月１日</td></tr>
 * </table>
 */
public class C_NencalckijyunymdKbn extends Classification<C_NencalckijyunymdKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_NencalckijyunymdKbn SITEI = new C_NencalckijyunymdKbn("0");

    public static final C_NencalckijyunymdKbn TOUJITU = new C_NencalckijyunymdKbn("1");

    public static final C_NencalckijyunymdKbn YOKU1_OR_YOKUYOKU1 = new C_NencalckijyunymdKbn("2");

    public static final C_NencalckijyunymdKbn YOKU1 = new C_NencalckijyunymdKbn("3");

    public static final C_NencalckijyunymdKbn YOKUYOKU1 = new C_NencalckijyunymdKbn("4");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, SITEI, "SITEI", true);
        addPattern(PATTERN_DEFAULT, TOUJITU, "TOUJITU", false);
        addPattern(PATTERN_DEFAULT, YOKU1_OR_YOKUYOKU1, "YOKU1_OR_YOKUYOKU1", false);
        addPattern(PATTERN_DEFAULT, YOKU1, "YOKU1", false);
        addPattern(PATTERN_DEFAULT, YOKUYOKU1, "YOKUYOKU1", false);


        lock(C_NencalckijyunymdKbn.class);
    }

    private C_NencalckijyunymdKbn(String value) {
        super(value);
    }

    public static C_NencalckijyunymdKbn valueOf(String value) {
        return valueOf(C_NencalckijyunymdKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_NencalckijyunymdKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_NencalckijyunymdKbn.class, patternId, value);
    }
}
