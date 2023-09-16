
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 数理払込方法区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SuuriHrkhouKbn</td><td colspan="3">数理払込方法区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #ITIJI}</td><td>&quot;0&quot;</td><td>一時払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TUKI}</td><td>&quot;70&quot;</td><td>月払</td></tr>
 * </table>
 */
public class C_SuuriHrkhouKbn extends Classification<C_SuuriHrkhouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SuuriHrkhouKbn ITIJI = new C_SuuriHrkhouKbn("0");

    public static final C_SuuriHrkhouKbn TUKI = new C_SuuriHrkhouKbn("70");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, ITIJI, "ITIJI", true);
        addPattern(PATTERN_DEFAULT, TUKI, "TUKI", false);


        lock(C_SuuriHrkhouKbn.class);
    }

    private C_SuuriHrkhouKbn(String value) {
        super(value);
    }

    public static C_SuuriHrkhouKbn valueOf(String value) {
        return valueOf(C_SuuriHrkhouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SuuriHrkhouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SuuriHrkhouKbn.class, patternId, value);
    }
}
