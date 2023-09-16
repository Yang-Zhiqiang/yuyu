
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 予定利率保証期間区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_YoteirirituHosyoukknKbn</td><td colspan="3">予定利率保証期間区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YEAR10}</td><td>&quot;10&quot;</td><td>１０年</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YEAR15}</td><td>&quot;15&quot;</td><td>１５年</td></tr>
 * </table>
 */
public class C_YoteirirituHosyoukknKbn extends Classification<C_YoteirirituHosyoukknKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_YoteirirituHosyoukknKbn BLNK = new C_YoteirirituHosyoukknKbn("0");

    public static final C_YoteirirituHosyoukknKbn YEAR10 = new C_YoteirirituHosyoukknKbn("10");

    public static final C_YoteirirituHosyoukknKbn YEAR15 = new C_YoteirirituHosyoukknKbn("15");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, YEAR10, "YEAR10", false);
        addPattern(PATTERN_DEFAULT, YEAR15, "YEAR15", false);


        lock(C_YoteirirituHosyoukknKbn.class);
    }

    private C_YoteirirituHosyoukknKbn(String value) {
        super(value);
    }

    public static C_YoteirirituHosyoukknKbn valueOf(String value) {
        return valueOf(C_YoteirirituHosyoukknKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_YoteirirituHosyoukknKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_YoteirirituHosyoukknKbn.class, patternId, value);
    }
}
