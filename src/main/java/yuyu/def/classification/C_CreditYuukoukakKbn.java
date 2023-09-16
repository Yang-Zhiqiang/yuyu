
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * クレジットカード有効確認区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_CreditYuukoukakKbn</td><td colspan="3">クレジットカード有効確認区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OK}</td><td>&quot;1&quot;</td><td>有効確認ＯＫ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NG}</td><td>&quot;2&quot;</td><td>有効確認ＮＧ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUGOUERR}</td><td>&quot;3&quot;</td><td>照合エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CARDKAISYAHANTEIERR}</td><td>&quot;4&quot;</td><td>カード会社判定エラー</td></tr>
 * </table>
 */
public class C_CreditYuukoukakKbn extends Classification<C_CreditYuukoukakKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_CreditYuukoukakKbn BLNK = new C_CreditYuukoukakKbn("0");

    public static final C_CreditYuukoukakKbn OK = new C_CreditYuukoukakKbn("1");

    public static final C_CreditYuukoukakKbn NG = new C_CreditYuukoukakKbn("2");

    public static final C_CreditYuukoukakKbn SYOUGOUERR = new C_CreditYuukoukakKbn("3");

    public static final C_CreditYuukoukakKbn CARDKAISYAHANTEIERR = new C_CreditYuukoukakKbn("4");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, OK, "OK", false);
        addPattern(PATTERN_DEFAULT, NG, "NG", false);
        addPattern(PATTERN_DEFAULT, SYOUGOUERR, "SYOUGOUERR", false);
        addPattern(PATTERN_DEFAULT, CARDKAISYAHANTEIERR, "CARDKAISYAHANTEIERR", false);


        lock(C_CreditYuukoukakKbn.class);
    }

    private C_CreditYuukoukakKbn(String value) {
        super(value);
    }

    public static C_CreditYuukoukakKbn valueOf(String value) {
        return valueOf(C_CreditYuukoukakKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_CreditYuukoukakKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_CreditYuukoukakKbn.class, patternId, value);
    }
}
