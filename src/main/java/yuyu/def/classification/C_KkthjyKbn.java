
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 告知報状区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KkthjyKbn</td><td colspan="3">告知報状区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KKTNRK_ARI}</td><td>&quot;1&quot;</td><td>告知書あり</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HJYNRK_ARI}</td><td>&quot;2&quot;</td><td>報状あり</td></tr>
 * </table>
 */
public class C_KkthjyKbn extends Classification<C_KkthjyKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KkthjyKbn NONE = new C_KkthjyKbn("0");

    public static final C_KkthjyKbn KKTNRK_ARI = new C_KkthjyKbn("1");

    public static final C_KkthjyKbn HJYNRK_ARI = new C_KkthjyKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NONE, "NONE", true);
        addPattern(PATTERN_DEFAULT, KKTNRK_ARI, "KKTNRK_ARI", false);
        addPattern(PATTERN_DEFAULT, HJYNRK_ARI, "HJYNRK_ARI", false);


        lock(C_KkthjyKbn.class);
    }

    private C_KkthjyKbn(String value) {
        super(value);
    }

    public static C_KkthjyKbn valueOf(String value) {
        return valueOf(C_KkthjyKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KkthjyKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KkthjyKbn.class, patternId, value);
    }
}
