
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 被保険者続柄 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Hhktdk</td><td colspan="3">被保険者続柄</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="8">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HGU}</td><td>&quot;2&quot;</td><td>配偶者</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OYA}</td><td>&quot;4&quot;</td><td>親</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KO}</td><td>&quot;3&quot;</td><td>子</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SHB}</td><td>&quot;7&quot;</td><td>祖父母</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAGO}</td><td>&quot;5&quot;</td><td>孫</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYDSM}</td><td>&quot;6&quot;</td><td>兄弟姉妹</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;99&quot;</td><td>その他</td></tr>
 * </table>
 */
public class C_Hhktdk extends Classification<C_Hhktdk> {

    private static final long serialVersionUID = 1L;


    public static final C_Hhktdk BLNK = new C_Hhktdk("0");

    public static final C_Hhktdk HGU = new C_Hhktdk("2");

    public static final C_Hhktdk OYA = new C_Hhktdk("4");

    public static final C_Hhktdk KO = new C_Hhktdk("3");

    public static final C_Hhktdk SHB = new C_Hhktdk("7");

    public static final C_Hhktdk MAGO = new C_Hhktdk("5");

    public static final C_Hhktdk KYDSM = new C_Hhktdk("6");

    public static final C_Hhktdk SONOTA = new C_Hhktdk("99");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, HGU, "HGU", false);
        addPattern(PATTERN_DEFAULT, OYA, "OYA", false);
        addPattern(PATTERN_DEFAULT, KO, "KO", false);
        addPattern(PATTERN_DEFAULT, SHB, "SHB", false);
        addPattern(PATTERN_DEFAULT, MAGO, "MAGO", false);
        addPattern(PATTERN_DEFAULT, KYDSM, "KYDSM", false);
        addPattern(PATTERN_DEFAULT, SONOTA, "SONOTA", false);


        lock(C_Hhktdk.class);
    }

    private C_Hhktdk(String value) {
        super(value);
    }

    public static C_Hhktdk valueOf(String value) {
        return valueOf(C_Hhktdk.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Hhktdk.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Hhktdk.class, patternId, value);
    }
}
