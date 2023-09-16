
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＡＥＯＩ対象者区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_AeoiTaisyousyaKbn</td><td colspan="3">ＡＥＯＩ対象者区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKSYA}</td><td>&quot;1&quot;</td><td>契約者</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBMANKIUKT}</td><td>&quot;2&quot;</td><td>死亡/満期受取人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;9&quot;</td><td>その他（法定相続人、第三者受取人等）</td></tr>
 * </table>
 */
public class C_AeoiTaisyousyaKbn extends Classification<C_AeoiTaisyousyaKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_AeoiTaisyousyaKbn BLNK = new C_AeoiTaisyousyaKbn("0");

    public static final C_AeoiTaisyousyaKbn KYKSYA = new C_AeoiTaisyousyaKbn("1");

    public static final C_AeoiTaisyousyaKbn SBMANKIUKT = new C_AeoiTaisyousyaKbn("2");

    public static final C_AeoiTaisyousyaKbn SONOTA = new C_AeoiTaisyousyaKbn("9");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KYKSYA, "KYKSYA", false);
        addPattern(PATTERN_DEFAULT, SBMANKIUKT, "SBMANKIUKT", false);
        addPattern(PATTERN_DEFAULT, SONOTA, "SONOTA", false);


        lock(C_AeoiTaisyousyaKbn.class);
    }

    private C_AeoiTaisyousyaKbn(String value) {
        super(value);
    }

    public static C_AeoiTaisyousyaKbn valueOf(String value) {
        return valueOf(C_AeoiTaisyousyaKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_AeoiTaisyousyaKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_AeoiTaisyousyaKbn.class, patternId, value);
    }
}
