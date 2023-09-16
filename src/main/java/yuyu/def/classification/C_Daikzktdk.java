
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 代表家族続柄 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Daikzktdk</td><td colspan="3">代表家族続柄</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="9">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HGU}</td><td>&quot;1&quot;</td><td>配偶者</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KO}</td><td>&quot;2&quot;</td><td>子</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OYA}</td><td>&quot;3&quot;</td><td>親</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAGO}</td><td>&quot;4&quot;</td><td>孫</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SHB}</td><td>&quot;5&quot;</td><td>祖父母</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYDSM}</td><td>&quot;6&quot;</td><td>兄弟姉妹</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HONNIN}</td><td>&quot;9&quot;</td><td>本人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;99&quot;</td><td>その他</td></tr>
 * </table>
 */
public class C_Daikzktdk extends Classification<C_Daikzktdk> {

    private static final long serialVersionUID = 1L;


    public static final C_Daikzktdk BLNK = new C_Daikzktdk("0");

    public static final C_Daikzktdk HGU = new C_Daikzktdk("1");

    public static final C_Daikzktdk KO = new C_Daikzktdk("2");

    public static final C_Daikzktdk OYA = new C_Daikzktdk("3");

    public static final C_Daikzktdk MAGO = new C_Daikzktdk("4");

    public static final C_Daikzktdk SHB = new C_Daikzktdk("5");

    public static final C_Daikzktdk KYDSM = new C_Daikzktdk("6");

    public static final C_Daikzktdk HONNIN = new C_Daikzktdk("9");

    public static final C_Daikzktdk SONOTA = new C_Daikzktdk("99");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, HGU, "HGU", false);
        addPattern(PATTERN_DEFAULT, KO, "KO", false);
        addPattern(PATTERN_DEFAULT, OYA, "OYA", false);
        addPattern(PATTERN_DEFAULT, MAGO, "MAGO", false);
        addPattern(PATTERN_DEFAULT, SHB, "SHB", false);
        addPattern(PATTERN_DEFAULT, KYDSM, "KYDSM", false);
        addPattern(PATTERN_DEFAULT, HONNIN, "HONNIN", false);
        addPattern(PATTERN_DEFAULT, SONOTA, "SONOTA", false);


        lock(C_Daikzktdk.class);
    }

    private C_Daikzktdk(String value) {
        super(value);
    }

    public static C_Daikzktdk valueOf(String value) {
        return valueOf(C_Daikzktdk.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Daikzktdk.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Daikzktdk.class, patternId, value);
    }
}
