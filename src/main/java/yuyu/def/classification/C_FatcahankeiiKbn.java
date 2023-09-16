
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＦＡＴＣＡ判明経緯区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_FatcahankeiiKbn</td><td colspan="3">ＦＡＴＣＡ判明経緯区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SINKEIYAKU}</td><td>&quot;1&quot;</td><td>新契約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MEIGIHNK}</td><td>&quot;2&quot;</td><td>名義変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIYAKU}</td><td>&quot;3&quot;</td><td>解約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HKSIHARAI}</td><td>&quot;4&quot;</td><td>保険金・給付金支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;5&quot;</td><td>その他</td></tr>
 * </table>
 */
public class C_FatcahankeiiKbn extends Classification<C_FatcahankeiiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_FatcahankeiiKbn BLNK = new C_FatcahankeiiKbn("0");

    public static final C_FatcahankeiiKbn SINKEIYAKU = new C_FatcahankeiiKbn("1");

    public static final C_FatcahankeiiKbn MEIGIHNK = new C_FatcahankeiiKbn("2");

    public static final C_FatcahankeiiKbn KAIYAKU = new C_FatcahankeiiKbn("3");

    public static final C_FatcahankeiiKbn HKSIHARAI = new C_FatcahankeiiKbn("4");

    public static final C_FatcahankeiiKbn SONOTA = new C_FatcahankeiiKbn("5");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SINKEIYAKU, "SINKEIYAKU", false);
        addPattern(PATTERN_DEFAULT, MEIGIHNK, "MEIGIHNK", false);
        addPattern(PATTERN_DEFAULT, KAIYAKU, "KAIYAKU", false);
        addPattern(PATTERN_DEFAULT, HKSIHARAI, "HKSIHARAI", false);
        addPattern(PATTERN_DEFAULT, SONOTA, "SONOTA", false);


        lock(C_FatcahankeiiKbn.class);
    }

    private C_FatcahankeiiKbn(String value) {
        super(value);
    }

    public static C_FatcahankeiiKbn valueOf(String value) {
        return valueOf(C_FatcahankeiiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_FatcahankeiiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_FatcahankeiiKbn.class, patternId, value);
    }
}
