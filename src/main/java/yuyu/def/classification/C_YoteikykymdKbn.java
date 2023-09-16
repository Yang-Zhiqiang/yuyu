
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 予定契約日区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_YoteikykymdKbn</td><td colspan="3">予定契約日区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #SITEI}</td><td>&quot;0&quot;</td><td>指定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YOKU1}</td><td>&quot;1&quot;</td><td>翌月１日設定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YOKUYOKU1}</td><td>&quot;2&quot;</td><td>翌々月１日設定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AUTO}</td><td>&quot;3&quot;</td><td>自動設定</td></tr>
 * </table>
 */
public class C_YoteikykymdKbn extends Classification<C_YoteikykymdKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_YoteikykymdKbn SITEI = new C_YoteikykymdKbn("0");

    public static final C_YoteikykymdKbn YOKU1 = new C_YoteikykymdKbn("1");

    public static final C_YoteikykymdKbn YOKUYOKU1 = new C_YoteikykymdKbn("2");

    public static final C_YoteikykymdKbn AUTO = new C_YoteikykymdKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, SITEI, "SITEI", true);
        addPattern(PATTERN_DEFAULT, YOKU1, "YOKU1", false);
        addPattern(PATTERN_DEFAULT, YOKUYOKU1, "YOKUYOKU1", false);
        addPattern(PATTERN_DEFAULT, AUTO, "AUTO", false);


        lock(C_YoteikykymdKbn.class);
    }

    private C_YoteikykymdKbn(String value) {
        super(value);
    }

    public static C_YoteikykymdKbn valueOf(String value) {
        return valueOf(C_YoteikykymdKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_YoteikykymdKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_YoteikykymdKbn.class, patternId, value);
    }
}
