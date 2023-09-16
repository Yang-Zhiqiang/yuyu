
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＦＡＴＣＡ対象者区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_FatcatgKbn</td><td colspan="3">ＦＡＴＣＡ対象者区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYK}</td><td>&quot;1&quot;</td><td>契約者</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBUMANKIKT}</td><td>&quot;2&quot;</td><td>死亡／満期受取人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKSZK}</td><td>&quot;3&quot;</td><td>契約者相続人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEIKYUUSYA}</td><td>&quot;4&quot;</td><td>請求者</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;9&quot;</td><td>その他（法定相続人、第三者受取人等）</td></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_SELECT SELECT}<br />(画面表示用)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYK}</td><td>&quot;1&quot;</td><td>契約者</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBUMANKIKT}</td><td>&quot;2&quot;</td><td>死亡／満期受取人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;9&quot;</td><td>その他（法定相続人、第三者受取人等）</td></tr>
 * </table>
 */
public class C_FatcatgKbn extends Classification<C_FatcatgKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_FatcatgKbn BLNK = new C_FatcatgKbn("0");

    public static final C_FatcatgKbn KYK = new C_FatcatgKbn("1");

    public static final C_FatcatgKbn SBUMANKIKT = new C_FatcatgKbn("2");

    public static final C_FatcatgKbn KYKSZK = new C_FatcatgKbn("3");

    public static final C_FatcatgKbn SEIKYUUSYA = new C_FatcatgKbn("4");

    public static final C_FatcatgKbn SONOTA = new C_FatcatgKbn("9");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SELECT = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KYK, "KYK", false);
        addPattern(PATTERN_DEFAULT, SBUMANKIKT, "SBUMANKIKT", false);
        addPattern(PATTERN_DEFAULT, KYKSZK, "KYKSZK", false);
        addPattern(PATTERN_DEFAULT, SEIKYUUSYA, "SEIKYUUSYA", false);
        addPattern(PATTERN_DEFAULT, SONOTA, "SONOTA", false);


        addPattern(PATTERN_SELECT, BLNK, "BLNK", true);
        addPattern(PATTERN_SELECT, KYK, "KYK", false);
        addPattern(PATTERN_SELECT, SBUMANKIKT, "SBUMANKIKT", false);
        addPattern(PATTERN_SELECT, SONOTA, "SONOTA", false);


        lock(C_FatcatgKbn.class);
    }

    private C_FatcatgKbn(String value) {
        super(value);
    }

    public static C_FatcatgKbn valueOf(String value) {
        return valueOf(C_FatcatgKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_FatcatgKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_FatcatgKbn.class, patternId, value);
    }
}
