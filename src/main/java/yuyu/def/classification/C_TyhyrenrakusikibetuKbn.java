
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 帳票連絡先識別区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TyhyrenrakusikibetuKbn</td><td colspan="3">帳票連絡先識別区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;00&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SHOP}</td><td>&quot;01&quot;</td><td>ショップ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MADOHAN_SMBC}</td><td>&quot;02&quot;</td><td>窓販（SMBC）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MADOHAN_TIGINSINKIN}</td><td>&quot;03&quot;</td><td>窓販（地銀・信金）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MADOHAN_MIZUHO}</td><td>&quot;04&quot;</td><td>窓販（みずほ）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YUUSEI}</td><td>&quot;05&quot;</td><td>郵政</td></tr>
 * </table>
 */
public class C_TyhyrenrakusikibetuKbn extends Classification<C_TyhyrenrakusikibetuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TyhyrenrakusikibetuKbn BLNK = new C_TyhyrenrakusikibetuKbn("00");

    public static final C_TyhyrenrakusikibetuKbn SHOP = new C_TyhyrenrakusikibetuKbn("01");

    public static final C_TyhyrenrakusikibetuKbn MADOHAN_SMBC = new C_TyhyrenrakusikibetuKbn("02");

    public static final C_TyhyrenrakusikibetuKbn MADOHAN_TIGINSINKIN = new C_TyhyrenrakusikibetuKbn("03");

    public static final C_TyhyrenrakusikibetuKbn MADOHAN_MIZUHO = new C_TyhyrenrakusikibetuKbn("04");

    public static final C_TyhyrenrakusikibetuKbn YUUSEI = new C_TyhyrenrakusikibetuKbn("05");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SHOP, "SHOP", false);
        addPattern(PATTERN_DEFAULT, MADOHAN_SMBC, "MADOHAN_SMBC", false);
        addPattern(PATTERN_DEFAULT, MADOHAN_TIGINSINKIN, "MADOHAN_TIGINSINKIN", false);
        addPattern(PATTERN_DEFAULT, MADOHAN_MIZUHO, "MADOHAN_MIZUHO", false);
        addPattern(PATTERN_DEFAULT, YUUSEI, "YUUSEI", false);


        lock(C_TyhyrenrakusikibetuKbn.class);
    }

    private C_TyhyrenrakusikibetuKbn(String value) {
        super(value);
    }

    public static C_TyhyrenrakusikibetuKbn valueOf(String value) {
        return valueOf(C_TyhyrenrakusikibetuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TyhyrenrakusikibetuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TyhyrenrakusikibetuKbn.class, patternId, value);
    }
}
