
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 契約者種類 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Kyksyurui</td><td colspan="3">契約者種類</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #ALL}</td><td>&quot;0&quot;</td><td>全て</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOJIN}</td><td>&quot;1&quot;</td><td>個人契約者</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HJN}</td><td>&quot;2&quot;</td><td>法人契約者</td></tr>
 * </table>
 */
public class C_Kyksyurui extends Classification<C_Kyksyurui> {

    private static final long serialVersionUID = 1L;


    public static final C_Kyksyurui ALL = new C_Kyksyurui("0");

    public static final C_Kyksyurui KOJIN = new C_Kyksyurui("1");

    public static final C_Kyksyurui HJN = new C_Kyksyurui("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, ALL, "ALL", true);
        addPattern(PATTERN_DEFAULT, KOJIN, "KOJIN", false);
        addPattern(PATTERN_DEFAULT, HJN, "HJN", false);


        lock(C_Kyksyurui.class);
    }

    private C_Kyksyurui(String value) {
        super(value);
    }

    public static C_Kyksyurui valueOf(String value) {
        return valueOf(C_Kyksyurui.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Kyksyurui.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Kyksyurui.class, patternId, value);
    }
}
