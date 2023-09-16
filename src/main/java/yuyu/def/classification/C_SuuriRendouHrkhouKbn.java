
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 数理連動用払込方法区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SuuriRendouHrkhouKbn</td><td colspan="3">数理連動用払込方法区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #ITIJI}</td><td>&quot;0&quot;</td><td>一時払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HURIKAE_YOHURI}</td><td>&quot;75&quot;</td><td>振替・預振</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CREDIT}</td><td>&quot;76&quot;</td><td>クレジット払</td></tr>
 * </table>
 */
public class C_SuuriRendouHrkhouKbn extends Classification<C_SuuriRendouHrkhouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SuuriRendouHrkhouKbn ITIJI = new C_SuuriRendouHrkhouKbn("0");

    public static final C_SuuriRendouHrkhouKbn HURIKAE_YOHURI = new C_SuuriRendouHrkhouKbn("75");

    public static final C_SuuriRendouHrkhouKbn CREDIT = new C_SuuriRendouHrkhouKbn("76");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, ITIJI, "ITIJI", true);
        addPattern(PATTERN_DEFAULT, HURIKAE_YOHURI, "HURIKAE_YOHURI", false);
        addPattern(PATTERN_DEFAULT, CREDIT, "CREDIT", false);


        lock(C_SuuriRendouHrkhouKbn.class);
    }

    private C_SuuriRendouHrkhouKbn(String value) {
        super(value);
    }

    public static C_SuuriRendouHrkhouKbn valueOf(String value) {
        return valueOf(C_SuuriRendouHrkhouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SuuriRendouHrkhouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SuuriRendouHrkhouKbn.class, patternId, value);
    }
}
