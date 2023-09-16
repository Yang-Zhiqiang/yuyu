
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 新契約事務区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SkeijimuKbn</td><td colspan="3">新契約事務区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="9">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;00&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TIGINSINKIN}</td><td>&quot;01&quot;</td><td>地銀・信金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SMBC}</td><td>&quot;02&quot;</td><td>ＳＭＢＣ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SMTB}</td><td>&quot;03&quot;</td><td>ＳＭＴＢ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MIZUHO}</td><td>&quot;04&quot;</td><td>みずほ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SHOP}</td><td>&quot;05&quot;</td><td>ショップ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YUUTYO}</td><td>&quot;06&quot;</td><td>ゆうちょ銀行</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NIHONYUUBIN}</td><td>&quot;07&quot;</td><td>日本郵便</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANPOSEIMEI}</td><td>&quot;08&quot;</td><td>かんぽ生命</td></tr>
 *  <tr><td rowspan="8">{@link #PATTERN_NOBLNK NOBLNK}<br />(ブランクなし)</td><td align="center">&nbsp;</td><td>{@link #TIGINSINKIN}</td><td>&quot;01&quot;</td><td>地銀・信金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SMBC}</td><td>&quot;02&quot;</td><td>ＳＭＢＣ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SMTB}</td><td>&quot;03&quot;</td><td>ＳＭＴＢ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MIZUHO}</td><td>&quot;04&quot;</td><td>みずほ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SHOP}</td><td>&quot;05&quot;</td><td>ショップ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YUUTYO}</td><td>&quot;06&quot;</td><td>ゆうちょ銀行</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NIHONYUUBIN}</td><td>&quot;07&quot;</td><td>日本郵便</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANPOSEIMEI}</td><td>&quot;08&quot;</td><td>かんぽ生命</td></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_QR QR}<br />(外部印刷ＱＲ作成用)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;00&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TIGINSINKIN}</td><td>&quot;01&quot;</td><td>地銀・信金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SMTB}</td><td>&quot;03&quot;</td><td>ＳＭＴＢ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SHOP}</td><td>&quot;05&quot;</td><td>ショップ</td></tr>
 *  <tr><td rowspan="9">{@link #PATTERN_QRSEAL QRSEAL}<br />(ＱＲシール用紙作成用)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;00&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TIGINSINKIN}</td><td>&quot;01&quot;</td><td>地銀・信金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SMBC}</td><td>&quot;02&quot;</td><td>ＳＭＢＣ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SMTB}</td><td>&quot;03&quot;</td><td>ＳＭＴＢ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MIZUHO}</td><td>&quot;04&quot;</td><td>みずほ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SHOP}</td><td>&quot;05&quot;</td><td>ショップ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YUUTYO}</td><td>&quot;06&quot;</td><td>ゆうちょ銀行</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NIHONYUUBIN}</td><td>&quot;07&quot;</td><td>日本郵便</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANPOSEIMEI}</td><td>&quot;08&quot;</td><td>かんぽ生命</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_QRDATA QRDATA}<br />(外部用ＱＲデータ用)</td><td align="center">&nbsp;</td><td>{@link #TIGINSINKIN}</td><td>&quot;01&quot;</td><td>Tigin</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SMTB}</td><td>&quot;03&quot;</td><td>Smtb</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SHOP}</td><td>&quot;05&quot;</td><td>Shop</td></tr>
 * </table>
 */
public class C_SkeijimuKbn extends Classification<C_SkeijimuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SkeijimuKbn BLNK = new C_SkeijimuKbn("00");

    public static final C_SkeijimuKbn TIGINSINKIN = new C_SkeijimuKbn("01");

    public static final C_SkeijimuKbn SMBC = new C_SkeijimuKbn("02");

    public static final C_SkeijimuKbn SMTB = new C_SkeijimuKbn("03");

    public static final C_SkeijimuKbn MIZUHO = new C_SkeijimuKbn("04");

    public static final C_SkeijimuKbn SHOP = new C_SkeijimuKbn("05");

    public static final C_SkeijimuKbn YUUTYO = new C_SkeijimuKbn("06");

    public static final C_SkeijimuKbn NIHONYUUBIN = new C_SkeijimuKbn("07");

    public static final C_SkeijimuKbn KANPOSEIMEI = new C_SkeijimuKbn("08");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_NOBLNK = "2";

    public static final String PATTERN_QR = "3";

    public static final String PATTERN_QRSEAL = "4";

    public static final String PATTERN_QRDATA = "5";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, TIGINSINKIN, "TIGINSINKIN", false);
        addPattern(PATTERN_DEFAULT, SMBC, "SMBC", false);
        addPattern(PATTERN_DEFAULT, SMTB, "SMTB", false);
        addPattern(PATTERN_DEFAULT, MIZUHO, "MIZUHO", false);
        addPattern(PATTERN_DEFAULT, SHOP, "SHOP", false);
        addPattern(PATTERN_DEFAULT, YUUTYO, "YUUTYO", false);
        addPattern(PATTERN_DEFAULT, NIHONYUUBIN, "NIHONYUUBIN", false);
        addPattern(PATTERN_DEFAULT, KANPOSEIMEI, "KANPOSEIMEI", false);


        addPattern(PATTERN_NOBLNK, TIGINSINKIN, "TIGINSINKIN", false);
        addPattern(PATTERN_NOBLNK, SMBC, "SMBC", false);
        addPattern(PATTERN_NOBLNK, SMTB, "SMTB", false);
        addPattern(PATTERN_NOBLNK, MIZUHO, "MIZUHO", false);
        addPattern(PATTERN_NOBLNK, SHOP, "SHOP", false);
        addPattern(PATTERN_NOBLNK, YUUTYO, "YUUTYO", false);
        addPattern(PATTERN_NOBLNK, NIHONYUUBIN, "NIHONYUUBIN", false);
        addPattern(PATTERN_NOBLNK, KANPOSEIMEI, "KANPOSEIMEI", false);


        addPattern(PATTERN_QR, BLNK, "BLNK", true);
        addPattern(PATTERN_QR, TIGINSINKIN, "TIGINSINKIN", false);
        addPattern(PATTERN_QR, SMTB, "SMTB", false);
        addPattern(PATTERN_QR, SHOP, "SHOP", false);


        addPattern(PATTERN_QRSEAL, BLNK, "BLNK", true);
        addPattern(PATTERN_QRSEAL, TIGINSINKIN, "TIGINSINKIN", false);
        addPattern(PATTERN_QRSEAL, SMBC, "SMBC", false);
        addPattern(PATTERN_QRSEAL, SMTB, "SMTB", false);
        addPattern(PATTERN_QRSEAL, MIZUHO, "MIZUHO", false);
        addPattern(PATTERN_QRSEAL, SHOP, "SHOP", false);
        addPattern(PATTERN_QRSEAL, YUUTYO, "YUUTYO", false);
        addPattern(PATTERN_QRSEAL, NIHONYUUBIN, "NIHONYUUBIN", false);
        addPattern(PATTERN_QRSEAL, KANPOSEIMEI, "KANPOSEIMEI", false);


        addPattern(PATTERN_QRDATA, TIGINSINKIN, "TIGINSINKIN", false);
        addPattern(PATTERN_QRDATA, SMTB, "SMTB", false);
        addPattern(PATTERN_QRDATA, SHOP, "SHOP", false);


        lock(C_SkeijimuKbn.class);
    }

    private C_SkeijimuKbn(String value) {
        super(value);
    }

    public static C_SkeijimuKbn valueOf(String value) {
        return valueOf(C_SkeijimuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SkeijimuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SkeijimuKbn.class, patternId, value);
    }
}
