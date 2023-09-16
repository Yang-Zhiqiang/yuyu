
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 数理払方区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SuuriHaraikataKbn</td><td colspan="3">数理払方区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="9">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #ITIJI}</td><td>&quot;0&quot;</td><td>一時払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TIZUKI}</td><td>&quot;7&quot;</td><td>地月</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BANKZUKI}</td><td>&quot;8&quot;</td><td>バンク月</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CREDIT}</td><td>&quot;9&quot;</td><td>クレジット月</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HARAIMAN}</td><td>&quot;12&quot;</td><td>払満後</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KURISAGE}</td><td>&quot;13&quot;</td><td>繰下げ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_KAISIGO}</td><td>&quot;14&quot;</td><td>年金開始後</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NEN}</td><td>&quot;21&quot;</td><td>年１回払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HALFY}</td><td>&quot;22&quot;</td><td>年２回払</td></tr>
 * </table>
 */
public class C_SuuriHaraikataKbn extends Classification<C_SuuriHaraikataKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SuuriHaraikataKbn ITIJI = new C_SuuriHaraikataKbn("0");

    public static final C_SuuriHaraikataKbn TIZUKI = new C_SuuriHaraikataKbn("7");

    public static final C_SuuriHaraikataKbn BANKZUKI = new C_SuuriHaraikataKbn("8");

    public static final C_SuuriHaraikataKbn CREDIT = new C_SuuriHaraikataKbn("9");

    public static final C_SuuriHaraikataKbn HARAIMAN = new C_SuuriHaraikataKbn("12");

    public static final C_SuuriHaraikataKbn KURISAGE = new C_SuuriHaraikataKbn("13");

    public static final C_SuuriHaraikataKbn NK_KAISIGO = new C_SuuriHaraikataKbn("14");

    public static final C_SuuriHaraikataKbn NEN = new C_SuuriHaraikataKbn("21");

    public static final C_SuuriHaraikataKbn HALFY = new C_SuuriHaraikataKbn("22");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, ITIJI, "ITIJI", true);
        addPattern(PATTERN_DEFAULT, TIZUKI, "TIZUKI", false);
        addPattern(PATTERN_DEFAULT, BANKZUKI, "BANKZUKI", false);
        addPattern(PATTERN_DEFAULT, CREDIT, "CREDIT", false);
        addPattern(PATTERN_DEFAULT, HARAIMAN, "HARAIMAN", false);
        addPattern(PATTERN_DEFAULT, KURISAGE, "KURISAGE", false);
        addPattern(PATTERN_DEFAULT, NK_KAISIGO, "NK_KAISIGO", false);
        addPattern(PATTERN_DEFAULT, NEN, "NEN", false);
        addPattern(PATTERN_DEFAULT, HALFY, "HALFY", false);


        lock(C_SuuriHaraikataKbn.class);
    }

    private C_SuuriHaraikataKbn(String value) {
        super(value);
    }

    public static C_SuuriHaraikataKbn valueOf(String value) {
        return valueOf(C_SuuriHaraikataKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SuuriHaraikataKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SuuriHaraikataKbn.class, patternId, value);
    }
}
