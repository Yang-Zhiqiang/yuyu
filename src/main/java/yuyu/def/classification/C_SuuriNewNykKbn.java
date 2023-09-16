
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 数理新入金区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SuuriNewNykKbn</td><td colspan="3">数理新入金区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLANK}</td><td>&quot;00&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IPPAN_NYUUKIN}</td><td>&quot;10&quot;</td><td>一般入金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZENNOU_NYUUKIN}</td><td>&quot;40&quot;</td><td>前納入金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ITIJI}</td><td>&quot;50&quot;</td><td>一時払</td></tr>
 * </table>
 */
public class C_SuuriNewNykKbn extends Classification<C_SuuriNewNykKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SuuriNewNykKbn BLANK = new C_SuuriNewNykKbn("00");

    public static final C_SuuriNewNykKbn IPPAN_NYUUKIN = new C_SuuriNewNykKbn("10");

    public static final C_SuuriNewNykKbn ZENNOU_NYUUKIN = new C_SuuriNewNykKbn("40");

    public static final C_SuuriNewNykKbn ITIJI = new C_SuuriNewNykKbn("50");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLANK, "BLANK", true);
        addPattern(PATTERN_DEFAULT, IPPAN_NYUUKIN, "IPPAN_NYUUKIN", false);
        addPattern(PATTERN_DEFAULT, ZENNOU_NYUUKIN, "ZENNOU_NYUUKIN", false);
        addPattern(PATTERN_DEFAULT, ITIJI, "ITIJI", false);


        lock(C_SuuriNewNykKbn.class);
    }

    private C_SuuriNewNykKbn(String value) {
        super(value);
    }

    public static C_SuuriNewNykKbn valueOf(String value) {
        return valueOf(C_SuuriNewNykKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SuuriNewNykKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SuuriNewNykKbn.class, patternId, value);
    }
}
