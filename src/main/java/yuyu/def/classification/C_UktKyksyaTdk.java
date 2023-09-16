
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 受取人契約者続柄 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_UktKyksyaTdk</td><td colspan="3">受取人契約者続柄</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKIGAI}</td><td>&quot;1&quot;</td><td>契約者以外</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKHNN}</td><td>&quot;2&quot;</td><td>契約者本人</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_SELECT SELECT}<br />(表示用)</td><td align="center">○</td><td>{@link #KYKIGAI}</td><td>&quot;1&quot;</td><td>契約者以外</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKHNN}</td><td>&quot;2&quot;</td><td>契約者本人</td></tr>
 * </table>
 */
public class C_UktKyksyaTdk extends Classification<C_UktKyksyaTdk> {

    private static final long serialVersionUID = 1L;


    public static final C_UktKyksyaTdk BLNK = new C_UktKyksyaTdk("0");

    public static final C_UktKyksyaTdk KYKIGAI = new C_UktKyksyaTdk("1");

    public static final C_UktKyksyaTdk KYKHNN = new C_UktKyksyaTdk("2");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SELECT = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KYKIGAI, "KYKIGAI", false);
        addPattern(PATTERN_DEFAULT, KYKHNN, "KYKHNN", false);


        addPattern(PATTERN_SELECT, KYKIGAI, "KYKIGAI", true);
        addPattern(PATTERN_SELECT, KYKHNN, "KYKHNN", false);


        lock(C_UktKyksyaTdk.class);
    }

    private C_UktKyksyaTdk(String value) {
        super(value);
    }

    public static C_UktKyksyaTdk valueOf(String value) {
        return valueOf(C_UktKyksyaTdk.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_UktKyksyaTdk.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_UktKyksyaTdk.class, patternId, value);
    }
}
