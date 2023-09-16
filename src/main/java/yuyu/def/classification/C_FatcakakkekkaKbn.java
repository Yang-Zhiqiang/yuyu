
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * FATCA確認結果区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_FatcakakkekkaKbn</td><td colspan="3">FATCA確認結果区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FATCA_HOUKOKUTAISYOU}</td><td>&quot;1&quot;</td><td>ＦＡＴＣＡ報告対象</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FATCA_TEIKITYOSAYOU}</td><td>&quot;2&quot;</td><td>ＦＡＴＣＡ報告対象外（定期調査必要）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FATCA_TEIKITYOSAHUYOU}</td><td>&quot;3&quot;</td><td>ＦＡＴＣＡ報告対象外（定期調査不要）</td></tr>
 * </table>
 */
public class C_FatcakakkekkaKbn extends Classification<C_FatcakakkekkaKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_FatcakakkekkaKbn BLNK = new C_FatcakakkekkaKbn("0");

    public static final C_FatcakakkekkaKbn FATCA_HOUKOKUTAISYOU = new C_FatcakakkekkaKbn("1");

    public static final C_FatcakakkekkaKbn FATCA_TEIKITYOSAYOU = new C_FatcakakkekkaKbn("2");

    public static final C_FatcakakkekkaKbn FATCA_TEIKITYOSAHUYOU = new C_FatcakakkekkaKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, FATCA_HOUKOKUTAISYOU, "FATCA_HOUKOKUTAISYOU", false);
        addPattern(PATTERN_DEFAULT, FATCA_TEIKITYOSAYOU, "FATCA_TEIKITYOSAYOU", false);
        addPattern(PATTERN_DEFAULT, FATCA_TEIKITYOSAHUYOU, "FATCA_TEIKITYOSAHUYOU", false);


        lock(C_FatcakakkekkaKbn.class);
    }

    private C_FatcakakkekkaKbn(String value) {
        super(value);
    }

    public static C_FatcakakkekkaKbn valueOf(String value) {
        return valueOf(C_FatcakakkekkaKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_FatcakakkekkaKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_FatcakakkekkaKbn.class, patternId, value);
    }
}
