
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * クレ払消込区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_CreditcardHrKskmKbn</td><td colspan="3">クレ払消込区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="9">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JCB_IPPAN}</td><td>&quot;01&quot;</td><td>ＪＣＢ・一般</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AMEX_IPPAN}</td><td>&quot;02&quot;</td><td>ＡＭＥＸ・一般</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SMCC_IPPAN}</td><td>&quot;03&quot;</td><td>ＳＭＣＣ・一般</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SMCC_NENKIN}</td><td>&quot;04&quot;</td><td>ＳＭＣＣ・年金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JCB_NENKIN}</td><td>&quot;05&quot;</td><td>ＪＣＢ・年金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AMEX_NENKIN}</td><td>&quot;06&quot;</td><td>ＡＭＥＸ・年金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RAY_TEIREI_URIAGE}</td><td>&quot;09&quot;</td><td>ＲＡＹ(定例売上)</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RAY_RINJI_URIAGE}</td><td>&quot;10&quot;</td><td>ＲＡＹ(臨時売上)</td></tr>
 * </table>
 */
public class C_CreditcardHrKskmKbn extends Classification<C_CreditcardHrKskmKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_CreditcardHrKskmKbn BLNK = new C_CreditcardHrKskmKbn("0");

    public static final C_CreditcardHrKskmKbn JCB_IPPAN = new C_CreditcardHrKskmKbn("01");

    public static final C_CreditcardHrKskmKbn AMEX_IPPAN = new C_CreditcardHrKskmKbn("02");

    public static final C_CreditcardHrKskmKbn SMCC_IPPAN = new C_CreditcardHrKskmKbn("03");

    public static final C_CreditcardHrKskmKbn SMCC_NENKIN = new C_CreditcardHrKskmKbn("04");

    public static final C_CreditcardHrKskmKbn JCB_NENKIN = new C_CreditcardHrKskmKbn("05");

    public static final C_CreditcardHrKskmKbn AMEX_NENKIN = new C_CreditcardHrKskmKbn("06");

    public static final C_CreditcardHrKskmKbn RAY_TEIREI_URIAGE = new C_CreditcardHrKskmKbn("09");

    public static final C_CreditcardHrKskmKbn RAY_RINJI_URIAGE = new C_CreditcardHrKskmKbn("10");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, JCB_IPPAN, "JCB_IPPAN", false);
        addPattern(PATTERN_DEFAULT, AMEX_IPPAN, "AMEX_IPPAN", false);
        addPattern(PATTERN_DEFAULT, SMCC_IPPAN, "SMCC_IPPAN", false);
        addPattern(PATTERN_DEFAULT, SMCC_NENKIN, "SMCC_NENKIN", false);
        addPattern(PATTERN_DEFAULT, JCB_NENKIN, "JCB_NENKIN", false);
        addPattern(PATTERN_DEFAULT, AMEX_NENKIN, "AMEX_NENKIN", false);
        addPattern(PATTERN_DEFAULT, RAY_TEIREI_URIAGE, "RAY_TEIREI_URIAGE", false);
        addPattern(PATTERN_DEFAULT, RAY_RINJI_URIAGE, "RAY_RINJI_URIAGE", false);


        lock(C_CreditcardHrKskmKbn.class);
    }

    private C_CreditcardHrKskmKbn(String value) {
        super(value);
    }

    public static C_CreditcardHrKskmKbn valueOf(String value) {
        return valueOf(C_CreditcardHrKskmKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_CreditcardHrKskmKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_CreditcardHrKskmKbn.class, patternId, value);
    }
}
