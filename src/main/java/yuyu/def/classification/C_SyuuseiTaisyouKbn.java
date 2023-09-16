
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 修正対象者区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SyuuseiTaisyouKbn</td><td colspan="3">修正対象者区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HHKN}</td><td>&quot;1&quot;</td><td>被保険者</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYK}</td><td>&quot;2&quot;</td><td>契約者</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NKUKT}</td><td>&quot;3&quot;</td><td>年金受取人</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_HOZEN HOZEN}<br />(契約保全)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HHKN}</td><td>&quot;1&quot;</td><td>被保険者</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYK}</td><td>&quot;2&quot;</td><td>契約者</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_NENKIN NENKIN}<br />(年金支払)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HHKN}</td><td>&quot;1&quot;</td><td>被保険者</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NKUKT}</td><td>&quot;3&quot;</td><td>年金受取人</td></tr>
 * </table>
 */
public class C_SyuuseiTaisyouKbn extends Classification<C_SyuuseiTaisyouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SyuuseiTaisyouKbn BLNK = new C_SyuuseiTaisyouKbn("0");

    public static final C_SyuuseiTaisyouKbn HHKN = new C_SyuuseiTaisyouKbn("1");

    public static final C_SyuuseiTaisyouKbn KYK = new C_SyuuseiTaisyouKbn("2");

    public static final C_SyuuseiTaisyouKbn NKUKT = new C_SyuuseiTaisyouKbn("3");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_HOZEN = "2";

    public static final String PATTERN_NENKIN = "3";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, HHKN, "HHKN", false);
        addPattern(PATTERN_DEFAULT, KYK, "KYK", false);
        addPattern(PATTERN_DEFAULT, NKUKT, "NKUKT", false);


        addPattern(PATTERN_HOZEN, BLNK, "BLNK", true);
        addPattern(PATTERN_HOZEN, HHKN, "HHKN", false);
        addPattern(PATTERN_HOZEN, KYK, "KYK", false);


        addPattern(PATTERN_NENKIN, BLNK, "BLNK", true);
        addPattern(PATTERN_NENKIN, HHKN, "HHKN", false);
        addPattern(PATTERN_NENKIN, NKUKT, "NKUKT", false);


        lock(C_SyuuseiTaisyouKbn.class);
    }

    private C_SyuuseiTaisyouKbn(String value) {
        super(value);
    }

    public static C_SyuuseiTaisyouKbn valueOf(String value) {
        return valueOf(C_SyuuseiTaisyouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SyuuseiTaisyouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SyuuseiTaisyouKbn.class, patternId, value);
    }
}
