
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 愛称名チャネル区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_AisyoumeiChannelKbn</td><td colspan="3">愛称名チャネル区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="8">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;00&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MADOHAN}</td><td>&quot;01&quot;</td><td>窓販</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SMBC}</td><td>&quot;02&quot;</td><td>ＳＭＢＣ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SINKIN}</td><td>&quot;03&quot;</td><td>信金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MIZUHO}</td><td>&quot;04&quot;</td><td>みずほ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SHOP}</td><td>&quot;05&quot;</td><td>ショップ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SMBCNIKKOU}</td><td>&quot;06&quot;</td><td>ＳＭＢＣ日興証券</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YUUSEI}</td><td>&quot;07&quot;</td><td>郵政</td></tr>
 * </table>
 */
public class C_AisyoumeiChannelKbn extends Classification<C_AisyoumeiChannelKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_AisyoumeiChannelKbn BLNK = new C_AisyoumeiChannelKbn("00");

    public static final C_AisyoumeiChannelKbn MADOHAN = new C_AisyoumeiChannelKbn("01");

    public static final C_AisyoumeiChannelKbn SMBC = new C_AisyoumeiChannelKbn("02");

    public static final C_AisyoumeiChannelKbn SINKIN = new C_AisyoumeiChannelKbn("03");

    public static final C_AisyoumeiChannelKbn MIZUHO = new C_AisyoumeiChannelKbn("04");

    public static final C_AisyoumeiChannelKbn SHOP = new C_AisyoumeiChannelKbn("05");

    public static final C_AisyoumeiChannelKbn SMBCNIKKOU = new C_AisyoumeiChannelKbn("06");

    public static final C_AisyoumeiChannelKbn YUUSEI = new C_AisyoumeiChannelKbn("07");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, MADOHAN, "MADOHAN", false);
        addPattern(PATTERN_DEFAULT, SMBC, "SMBC", false);
        addPattern(PATTERN_DEFAULT, SINKIN, "SINKIN", false);
        addPattern(PATTERN_DEFAULT, MIZUHO, "MIZUHO", false);
        addPattern(PATTERN_DEFAULT, SHOP, "SHOP", false);
        addPattern(PATTERN_DEFAULT, SMBCNIKKOU, "SMBCNIKKOU", false);
        addPattern(PATTERN_DEFAULT, YUUSEI, "YUUSEI", false);


        lock(C_AisyoumeiChannelKbn.class);
    }

    private C_AisyoumeiChannelKbn(String value) {
        super(value);
    }

    public static C_AisyoumeiChannelKbn valueOf(String value) {
        return valueOf(C_AisyoumeiChannelKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_AisyoumeiChannelKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_AisyoumeiChannelKbn.class, patternId, value);
    }
}
