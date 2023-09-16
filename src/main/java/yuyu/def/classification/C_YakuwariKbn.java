
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 役割区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_YakuwariKbn</td><td colspan="3">役割区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="7">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYK}</td><td>&quot;1&quot;</td><td>契約者</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HHKN}</td><td>&quot;2&quot;</td><td>被保険者</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBHENKANUKT}</td><td>&quot;3&quot;</td><td>死亡返還金受取人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #STDRNIN}</td><td>&quot;4&quot;</td><td>指定代理請求人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBSUKT}</td><td>&quot;6&quot;</td><td>死亡保険金受取人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTAUKT}</td><td>&quot;5&quot;</td><td>その他受取人</td></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_NOBLNK NOBLNK}<br />(ブランクなし)</td><td align="center">&nbsp;</td><td>{@link #KYK}</td><td>&quot;1&quot;</td><td>契約者</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HHKN}</td><td>&quot;2&quot;</td><td>被保険者</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBHENKANUKT}</td><td>&quot;3&quot;</td><td>死亡返還金受取人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #STDRNIN}</td><td>&quot;4&quot;</td><td>指定代理請求人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBSUKT}</td><td>&quot;6&quot;</td><td>死亡保険金受取人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTAUKT}</td><td>&quot;5&quot;</td><td>その他受取人</td></tr>
 * </table>
 */
public class C_YakuwariKbn extends Classification<C_YakuwariKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_YakuwariKbn BLNK = new C_YakuwariKbn("0");

    public static final C_YakuwariKbn KYK = new C_YakuwariKbn("1");

    public static final C_YakuwariKbn HHKN = new C_YakuwariKbn("2");

    public static final C_YakuwariKbn SBHENKANUKT = new C_YakuwariKbn("3");

    public static final C_YakuwariKbn STDRNIN = new C_YakuwariKbn("4");

    public static final C_YakuwariKbn SBSUKT = new C_YakuwariKbn("6");

    public static final C_YakuwariKbn SONOTAUKT = new C_YakuwariKbn("5");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_NOBLNK = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KYK, "KYK", false);
        addPattern(PATTERN_DEFAULT, HHKN, "HHKN", false);
        addPattern(PATTERN_DEFAULT, SBHENKANUKT, "SBHENKANUKT", false);
        addPattern(PATTERN_DEFAULT, STDRNIN, "STDRNIN", false);
        addPattern(PATTERN_DEFAULT, SBSUKT, "SBSUKT", false);
        addPattern(PATTERN_DEFAULT, SONOTAUKT, "SONOTAUKT", false);


        addPattern(PATTERN_NOBLNK, KYK, "KYK", false);
        addPattern(PATTERN_NOBLNK, HHKN, "HHKN", false);
        addPattern(PATTERN_NOBLNK, SBHENKANUKT, "SBHENKANUKT", false);
        addPattern(PATTERN_NOBLNK, STDRNIN, "STDRNIN", false);
        addPattern(PATTERN_NOBLNK, SBSUKT, "SBSUKT", false);
        addPattern(PATTERN_NOBLNK, SONOTAUKT, "SONOTAUKT", false);


        lock(C_YakuwariKbn.class);
    }

    private C_YakuwariKbn(String value) {
        super(value);
    }

    public static C_YakuwariKbn valueOf(String value) {
        return valueOf(C_YakuwariKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_YakuwariKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_YakuwariKbn.class, patternId, value);
    }
}
