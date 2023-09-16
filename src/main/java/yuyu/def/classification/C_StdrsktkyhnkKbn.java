
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 指定代理請求特約変更区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_StdrsktkyhnkKbn</td><td colspan="3">指定代理請求特約変更区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUKA}</td><td>&quot;1&quot;</td><td>付加</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HENKOU}</td><td>&quot;2&quot;</td><td>変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIYAKU}</td><td>&quot;3&quot;</td><td>解約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIJYO}</td><td>&quot;4&quot;</td><td>解除</td></tr>
 *  <tr><td rowspan="1">{@link #PATTERN_CTHK CTHK}<br />(中途付加)</td><td align="center">○</td><td>{@link #HUKA}</td><td>&quot;1&quot;</td><td>付加</td></tr>
 * </table>
 */
public class C_StdrsktkyhnkKbn extends Classification<C_StdrsktkyhnkKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_StdrsktkyhnkKbn BLNK = new C_StdrsktkyhnkKbn("0");

    public static final C_StdrsktkyhnkKbn HUKA = new C_StdrsktkyhnkKbn("1");

    public static final C_StdrsktkyhnkKbn HENKOU = new C_StdrsktkyhnkKbn("2");

    public static final C_StdrsktkyhnkKbn KAIYAKU = new C_StdrsktkyhnkKbn("3");

    public static final C_StdrsktkyhnkKbn KAIJYO = new C_StdrsktkyhnkKbn("4");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_CTHK = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, HUKA, "HUKA", false);
        addPattern(PATTERN_DEFAULT, HENKOU, "HENKOU", false);
        addPattern(PATTERN_DEFAULT, KAIYAKU, "KAIYAKU", false);
        addPattern(PATTERN_DEFAULT, KAIJYO, "KAIJYO", false);


        addPattern(PATTERN_CTHK, HUKA, "HUKA", true);


        lock(C_StdrsktkyhnkKbn.class);
    }

    private C_StdrsktkyhnkKbn(String value) {
        super(value);
    }

    public static C_StdrsktkyhnkKbn valueOf(String value) {
        return valueOf(C_StdrsktkyhnkKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_StdrsktkyhnkKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_StdrsktkyhnkKbn.class, patternId, value);
    }
}
