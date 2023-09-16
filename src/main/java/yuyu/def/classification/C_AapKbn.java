
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＡＡＰ区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_AapKbn</td><td colspan="3">ＡＡＰ区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SINKEIYAKUAAP}</td><td>&quot;1&quot;</td><td>新契約ＡＡＰ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOYUAAP}</td><td>&quot;2&quot;</td><td>保有ＡＡＰ</td></tr>
 * </table>
 */
public class C_AapKbn extends Classification<C_AapKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_AapKbn BLNK = new C_AapKbn("0");

    public static final C_AapKbn SINKEIYAKUAAP = new C_AapKbn("1");

    public static final C_AapKbn HOYUAAP = new C_AapKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SINKEIYAKUAAP, "SINKEIYAKUAAP", false);
        addPattern(PATTERN_DEFAULT, HOYUAAP, "HOYUAAP", false);


        lock(C_AapKbn.class);
    }

    private C_AapKbn(String value) {
        super(value);
    }

    public static C_AapKbn valueOf(String value) {
        return valueOf(C_AapKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_AapKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_AapKbn.class, patternId, value);
    }
}
