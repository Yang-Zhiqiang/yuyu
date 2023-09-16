
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * クレジットカードキー種類区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_CreditCardKeySyuruiKbn</td><td colspan="3">クレジットカードキー種類区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAKUSEINO}</td><td>&quot;1&quot;</td><td>作成番号</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MOSNO}</td><td>&quot;2&quot;</td><td>申込番号</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYONO}</td><td>&quot;3&quot;</td><td>証券番号</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #VITKAIINNO}</td><td>&quot;4&quot;</td><td>Ｖｉｔ会員番号</td></tr>
 * </table>
 */
public class C_CreditCardKeySyuruiKbn extends Classification<C_CreditCardKeySyuruiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_CreditCardKeySyuruiKbn BLNK = new C_CreditCardKeySyuruiKbn("0");

    public static final C_CreditCardKeySyuruiKbn SAKUSEINO = new C_CreditCardKeySyuruiKbn("1");

    public static final C_CreditCardKeySyuruiKbn MOSNO = new C_CreditCardKeySyuruiKbn("2");

    public static final C_CreditCardKeySyuruiKbn SYONO = new C_CreditCardKeySyuruiKbn("3");

    public static final C_CreditCardKeySyuruiKbn VITKAIINNO = new C_CreditCardKeySyuruiKbn("4");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SAKUSEINO, "SAKUSEINO", false);
        addPattern(PATTERN_DEFAULT, MOSNO, "MOSNO", false);
        addPattern(PATTERN_DEFAULT, SYONO, "SYONO", false);
        addPattern(PATTERN_DEFAULT, VITKAIINNO, "VITKAIINNO", false);


        lock(C_CreditCardKeySyuruiKbn.class);
    }

    private C_CreditCardKeySyuruiKbn(String value) {
        super(value);
    }

    public static C_CreditCardKeySyuruiKbn valueOf(String value) {
        return valueOf(C_CreditCardKeySyuruiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_CreditCardKeySyuruiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_CreditCardKeySyuruiKbn.class, patternId, value);
    }
}
