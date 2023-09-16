
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 反社チェック対象者区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HnsychkTaisyousyaKbn</td><td colspan="3">反社チェック対象者区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="10">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYK}</td><td>&quot;1&quot;</td><td>契約者</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HHKN}</td><td>&quot;2&quot;</td><td>被保険者</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBSUKT}</td><td>&quot;3&quot;</td><td>死亡保険金受取人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBKYFKUKT}</td><td>&quot;4&quot;</td><td>死亡給付金受取人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NKUKT}</td><td>&quot;5&quot;</td><td>年金受取人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKDRN}</td><td>&quot;6&quot;</td><td>契約者代理人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #STDRSK}</td><td>&quot;7&quot;</td><td>被保険者代理人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TRKKZK1}</td><td>&quot;8&quot;</td><td>登録家族（１人目）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TRKKZK2}</td><td>&quot;9&quot;</td><td>登録家族（２人目）</td></tr>
 * </table>
 */
public class C_HnsychkTaisyousyaKbn extends Classification<C_HnsychkTaisyousyaKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HnsychkTaisyousyaKbn BLNK = new C_HnsychkTaisyousyaKbn("0");

    public static final C_HnsychkTaisyousyaKbn KYK = new C_HnsychkTaisyousyaKbn("1");

    public static final C_HnsychkTaisyousyaKbn HHKN = new C_HnsychkTaisyousyaKbn("2");

    public static final C_HnsychkTaisyousyaKbn SBSUKT = new C_HnsychkTaisyousyaKbn("3");

    public static final C_HnsychkTaisyousyaKbn SBKYFKUKT = new C_HnsychkTaisyousyaKbn("4");

    public static final C_HnsychkTaisyousyaKbn NKUKT = new C_HnsychkTaisyousyaKbn("5");

    public static final C_HnsychkTaisyousyaKbn KYKDRN = new C_HnsychkTaisyousyaKbn("6");

    public static final C_HnsychkTaisyousyaKbn STDRSK = new C_HnsychkTaisyousyaKbn("7");

    public static final C_HnsychkTaisyousyaKbn TRKKZK1 = new C_HnsychkTaisyousyaKbn("8");

    public static final C_HnsychkTaisyousyaKbn TRKKZK2 = new C_HnsychkTaisyousyaKbn("9");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KYK, "KYK", false);
        addPattern(PATTERN_DEFAULT, HHKN, "HHKN", false);
        addPattern(PATTERN_DEFAULT, SBSUKT, "SBSUKT", false);
        addPattern(PATTERN_DEFAULT, SBKYFKUKT, "SBKYFKUKT", false);
        addPattern(PATTERN_DEFAULT, NKUKT, "NKUKT", false);
        addPattern(PATTERN_DEFAULT, KYKDRN, "KYKDRN", false);
        addPattern(PATTERN_DEFAULT, STDRSK, "STDRSK", false);
        addPattern(PATTERN_DEFAULT, TRKKZK1, "TRKKZK1", false);
        addPattern(PATTERN_DEFAULT, TRKKZK2, "TRKKZK2", false);


        lock(C_HnsychkTaisyousyaKbn.class);
    }

    private C_HnsychkTaisyousyaKbn(String value) {
        super(value);
    }

    public static C_HnsychkTaisyousyaKbn valueOf(String value) {
        return valueOf(C_HnsychkTaisyousyaKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HnsychkTaisyousyaKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HnsychkTaisyousyaKbn.class, patternId, value);
    }
}
