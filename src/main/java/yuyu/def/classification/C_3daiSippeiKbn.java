
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ３大疾病区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_3daiSippeiKbn</td><td colspan="3">３大疾病区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SANDAISIP}</td><td>&quot;1&quot;</td><td>３大疾病</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SANDAISIPIGAI}</td><td>&quot;2&quot;</td><td>３大疾病以外</td></tr>
 * </table>
 */
public class C_3daiSippeiKbn extends Classification<C_3daiSippeiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_3daiSippeiKbn BLNK = new C_3daiSippeiKbn("0");

    public static final C_3daiSippeiKbn SANDAISIP = new C_3daiSippeiKbn("1");

    public static final C_3daiSippeiKbn SANDAISIPIGAI = new C_3daiSippeiKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SANDAISIP, "SANDAISIP", false);
        addPattern(PATTERN_DEFAULT, SANDAISIPIGAI, "SANDAISIPIGAI", false);


        lock(C_3daiSippeiKbn.class);
    }

    private C_3daiSippeiKbn(String value) {
        super(value);
    }

    public static C_3daiSippeiKbn valueOf(String value) {
        return valueOf(C_3daiSippeiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_3daiSippeiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_3daiSippeiKbn.class, patternId, value);
    }
}
