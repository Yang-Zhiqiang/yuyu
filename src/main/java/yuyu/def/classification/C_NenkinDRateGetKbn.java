
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 年金開始後Ｄレート取得区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_NenkinDRateGetKbn</td><td colspan="3">年金開始後Ｄレート取得区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ONEYEAR}</td><td>&quot;1&quot;</td><td>１年分（経過年数）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TWOYEARS}</td><td>&quot;2&quot;</td><td>２年分（経過年数と経過年数＋１年）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ALL}</td><td>&quot;9&quot;</td><td>すべて</td></tr>
 * </table>
 */
public class C_NenkinDRateGetKbn extends Classification<C_NenkinDRateGetKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_NenkinDRateGetKbn NONE = new C_NenkinDRateGetKbn("0");

    public static final C_NenkinDRateGetKbn ONEYEAR = new C_NenkinDRateGetKbn("1");

    public static final C_NenkinDRateGetKbn TWOYEARS = new C_NenkinDRateGetKbn("2");

    public static final C_NenkinDRateGetKbn ALL = new C_NenkinDRateGetKbn("9");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NONE, "NONE", true);
        addPattern(PATTERN_DEFAULT, ONEYEAR, "ONEYEAR", false);
        addPattern(PATTERN_DEFAULT, TWOYEARS, "TWOYEARS", false);
        addPattern(PATTERN_DEFAULT, ALL, "ALL", false);


        lock(C_NenkinDRateGetKbn.class);
    }

    private C_NenkinDRateGetKbn(String value) {
        super(value);
    }

    public static C_NenkinDRateGetKbn valueOf(String value) {
        return valueOf(C_NenkinDRateGetKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_NenkinDRateGetKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_NenkinDRateGetKbn.class, patternId, value);
    }
}
