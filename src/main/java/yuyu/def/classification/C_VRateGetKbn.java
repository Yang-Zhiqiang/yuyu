
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * Ｖレート取得区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_VRateGetKbn</td><td colspan="3">Ｖレート取得区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ONEYEAR}</td><td>&quot;1&quot;</td><td>１年分（経過年数）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TWOYEARS}</td><td>&quot;2&quot;</td><td>２年分（経過年数と経過年数＋１年）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ALL}</td><td>&quot;9&quot;</td><td>すべて</td></tr>
 * </table>
 */
public class C_VRateGetKbn extends Classification<C_VRateGetKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_VRateGetKbn NONE = new C_VRateGetKbn("0");

    public static final C_VRateGetKbn ONEYEAR = new C_VRateGetKbn("1");

    public static final C_VRateGetKbn TWOYEARS = new C_VRateGetKbn("2");

    public static final C_VRateGetKbn ALL = new C_VRateGetKbn("9");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NONE, "NONE", true);
        addPattern(PATTERN_DEFAULT, ONEYEAR, "ONEYEAR", false);
        addPattern(PATTERN_DEFAULT, TWOYEARS, "TWOYEARS", false);
        addPattern(PATTERN_DEFAULT, ALL, "ALL", false);


        lock(C_VRateGetKbn.class);
    }

    private C_VRateGetKbn(String value) {
        super(value);
    }

    public static C_VRateGetKbn valueOf(String value) {
        return valueOf(C_VRateGetKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_VRateGetKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_VRateGetKbn.class, patternId, value);
    }
}
