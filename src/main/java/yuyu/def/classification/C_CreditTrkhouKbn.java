
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * クレジットカード登録方法区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_CreditTrkhouKbn</td><td colspan="3">クレジットカード登録方法区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOMEN}</td><td>&quot;1&quot;</td><td>生命保険料支払申込書による登録（書面）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #QR}</td><td>&quot;2&quot;</td><td>ＱＲコード方式での登録</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_PRINT_ZEN1 PRINT_ZEN1}<br />(帳票用全角１文字)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOMEN}</td><td>&quot;1&quot;</td><td>Ｗ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #QR}</td><td>&quot;2&quot;</td><td>Ｑ</td></tr>
 * </table>
 */
public class C_CreditTrkhouKbn extends Classification<C_CreditTrkhouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_CreditTrkhouKbn BLNK = new C_CreditTrkhouKbn("0");

    public static final C_CreditTrkhouKbn SYOMEN = new C_CreditTrkhouKbn("1");

    public static final C_CreditTrkhouKbn QR = new C_CreditTrkhouKbn("2");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_PRINT_ZEN1 = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SYOMEN, "SYOMEN", false);
        addPattern(PATTERN_DEFAULT, QR, "QR", false);


        addPattern(PATTERN_PRINT_ZEN1, BLNK, "BLNK", true);
        addPattern(PATTERN_PRINT_ZEN1, SYOMEN, "SYOMEN", false);
        addPattern(PATTERN_PRINT_ZEN1, QR, "QR", false);


        lock(C_CreditTrkhouKbn.class);
    }

    private C_CreditTrkhouKbn(String value) {
        super(value);
    }

    public static C_CreditTrkhouKbn valueOf(String value) {
        return valueOf(C_CreditTrkhouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_CreditTrkhouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_CreditTrkhouKbn.class, patternId, value);
    }
}
