
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 銀行登録対象区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_BanktrktaisyouKbn</td><td colspan="3">銀行登録対象区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BANKSITEN}</td><td>&quot;1&quot;</td><td>銀行・支店</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BANK}</td><td>&quot;2&quot;</td><td>銀行のみ</td></tr>
 * </table>
 */
public class C_BanktrktaisyouKbn extends Classification<C_BanktrktaisyouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_BanktrktaisyouKbn BANKSITEN = new C_BanktrktaisyouKbn("1");

    public static final C_BanktrktaisyouKbn BANK = new C_BanktrktaisyouKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BANKSITEN, "BANKSITEN", true);
        addPattern(PATTERN_DEFAULT, BANK, "BANK", false);


        lock(C_BanktrktaisyouKbn.class);
    }

    private C_BanktrktaisyouKbn(String value) {
        super(value);
    }

    public static C_BanktrktaisyouKbn valueOf(String value) {
        return valueOf(C_BanktrktaisyouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_BanktrktaisyouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_BanktrktaisyouKbn.class, patternId, value);
    }
}
