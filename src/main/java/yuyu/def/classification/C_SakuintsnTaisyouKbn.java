
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 索引通算対象者区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SakuintsnTaisyouKbn</td><td colspan="3">索引通算対象者区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYK}</td><td>&quot;1&quot;</td><td>契約者</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HHKN}</td><td>&quot;2&quot;</td><td>被保険者</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NKUKT}</td><td>&quot;3&quot;</td><td>年金受取人</td></tr>
 * </table>
 */
public class C_SakuintsnTaisyouKbn extends Classification<C_SakuintsnTaisyouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SakuintsnTaisyouKbn BLNK = new C_SakuintsnTaisyouKbn("0");

    public static final C_SakuintsnTaisyouKbn KYK = new C_SakuintsnTaisyouKbn("1");

    public static final C_SakuintsnTaisyouKbn HHKN = new C_SakuintsnTaisyouKbn("2");

    public static final C_SakuintsnTaisyouKbn NKUKT = new C_SakuintsnTaisyouKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KYK, "KYK", false);
        addPattern(PATTERN_DEFAULT, HHKN, "HHKN", false);
        addPattern(PATTERN_DEFAULT, NKUKT, "NKUKT", false);


        lock(C_SakuintsnTaisyouKbn.class);
    }

    private C_SakuintsnTaisyouKbn(String value) {
        super(value);
    }

    public static C_SakuintsnTaisyouKbn valueOf(String value) {
        return valueOf(C_SakuintsnTaisyouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SakuintsnTaisyouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SakuintsnTaisyouKbn.class, patternId, value);
    }
}
