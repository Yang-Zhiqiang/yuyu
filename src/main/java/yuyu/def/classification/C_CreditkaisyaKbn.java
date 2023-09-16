
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * クレジット会社区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_CreditkaisyaKbn</td><td colspan="3">クレジット会社区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CREDITKAISYA}</td><td>&quot;1&quot;</td><td>クレジットカード会社</td></tr>
 * </table>
 */
public class C_CreditkaisyaKbn extends Classification<C_CreditkaisyaKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_CreditkaisyaKbn BLNK = new C_CreditkaisyaKbn("0");

    public static final C_CreditkaisyaKbn CREDITKAISYA = new C_CreditkaisyaKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, CREDITKAISYA, "CREDITKAISYA", false);


        lock(C_CreditkaisyaKbn.class);
    }

    private C_CreditkaisyaKbn(String value) {
        super(value);
    }

    public static C_CreditkaisyaKbn valueOf(String value) {
        return valueOf(C_CreditkaisyaKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_CreditkaisyaKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_CreditkaisyaKbn.class, patternId, value);
    }
}
