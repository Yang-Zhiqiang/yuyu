
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 請求者区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SeikyuusyaKbn</td><td colspan="3">請求者区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="9">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UKTHONNIN}</td><td>&quot;1&quot;</td><td>受取人本人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #STDR}</td><td>&quot;2&quot;</td><td>指定代理人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UKTDAIHYOU}</td><td>&quot;3&quot;</td><td>受取人代表者</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKHONNIN}</td><td>&quot;4&quot;</td><td>契約者本人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HHKN}</td><td>&quot;5&quot;</td><td>被保険者</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBUKT}</td><td>&quot;6&quot;</td><td>死亡受取人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKDAIRININ}</td><td>&quot;7&quot;</td><td>契約者代理人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;9&quot;</td><td>その他下記請求者</td></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_SIBOU SIBOU}<br />(（死亡）請求受付・査定)</td><td align="center">&nbsp;</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UKTHONNIN}</td><td>&quot;1&quot;</td><td>受取人本人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UKTDAIHYOU}</td><td>&quot;3&quot;</td><td>受取人代表者</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKDAIRININ}</td><td>&quot;7&quot;</td><td>契約者代理人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;9&quot;</td><td>その他下記請求者</td></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_OTHER OTHER}<br />(（死亡）請求受付・査定以外)</td><td align="center">&nbsp;</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UKTHONNIN}</td><td>&quot;1&quot;</td><td>受取人本人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #STDR}</td><td>&quot;2&quot;</td><td>指定代理人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;9&quot;</td><td>その他下記請求者</td></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_PM PM}<br />(Ｐ免)</td><td align="center">&nbsp;</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKHONNIN}</td><td>&quot;4&quot;</td><td>契約者本人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #STDR}</td><td>&quot;2&quot;</td><td>指定代理人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;9&quot;</td><td>その他下記請求者</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_SINDANSYO SINDANSYO}<br />(診断書料支払)</td><td align="center">○</td><td>{@link #HHKN}</td><td>&quot;5&quot;</td><td>被保険者</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBUKT}</td><td>&quot;6&quot;</td><td>死亡受取人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;9&quot;</td><td>その他下記請求者</td></tr>
 * </table>
 */
public class C_SeikyuusyaKbn extends Classification<C_SeikyuusyaKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SeikyuusyaKbn BLNK = new C_SeikyuusyaKbn("0");

    public static final C_SeikyuusyaKbn UKTHONNIN = new C_SeikyuusyaKbn("1");

    public static final C_SeikyuusyaKbn STDR = new C_SeikyuusyaKbn("2");

    public static final C_SeikyuusyaKbn UKTDAIHYOU = new C_SeikyuusyaKbn("3");

    public static final C_SeikyuusyaKbn KYKHONNIN = new C_SeikyuusyaKbn("4");

    public static final C_SeikyuusyaKbn HHKN = new C_SeikyuusyaKbn("5");

    public static final C_SeikyuusyaKbn SBUKT = new C_SeikyuusyaKbn("6");

    public static final C_SeikyuusyaKbn KYKDAIRININ = new C_SeikyuusyaKbn("7");

    public static final C_SeikyuusyaKbn SONOTA = new C_SeikyuusyaKbn("9");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SIBOU = "2";

    public static final String PATTERN_OTHER = "3";

    public static final String PATTERN_PM = "4";

    public static final String PATTERN_SINDANSYO = "5";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, UKTHONNIN, "UKTHONNIN", false);
        addPattern(PATTERN_DEFAULT, STDR, "STDR", false);
        addPattern(PATTERN_DEFAULT, UKTDAIHYOU, "UKTDAIHYOU", false);
        addPattern(PATTERN_DEFAULT, KYKHONNIN, "KYKHONNIN", false);
        addPattern(PATTERN_DEFAULT, HHKN, "HHKN", false);
        addPattern(PATTERN_DEFAULT, SBUKT, "SBUKT", false);
        addPattern(PATTERN_DEFAULT, KYKDAIRININ, "KYKDAIRININ", false);
        addPattern(PATTERN_DEFAULT, SONOTA, "SONOTA", false);


        addPattern(PATTERN_SIBOU, BLNK, "BLNK", false);
        addPattern(PATTERN_SIBOU, UKTHONNIN, "UKTHONNIN", false);
        addPattern(PATTERN_SIBOU, UKTDAIHYOU, "UKTDAIHYOU", false);
        addPattern(PATTERN_SIBOU, KYKDAIRININ, "KYKDAIRININ", false);
        addPattern(PATTERN_SIBOU, SONOTA, "SONOTA", false);


        addPattern(PATTERN_OTHER, BLNK, "BLNK", false);
        addPattern(PATTERN_OTHER, UKTHONNIN, "UKTHONNIN", false);
        addPattern(PATTERN_OTHER, STDR, "STDR", false);
        addPattern(PATTERN_OTHER, SONOTA, "SONOTA", false);


        addPattern(PATTERN_PM, BLNK, "BLNK", false);
        addPattern(PATTERN_PM, KYKHONNIN, "KYKHONNIN", false);
        addPattern(PATTERN_PM, STDR, "STDR", false);
        addPattern(PATTERN_PM, SONOTA, "SONOTA", false);


        addPattern(PATTERN_SINDANSYO, HHKN, "HHKN", true);
        addPattern(PATTERN_SINDANSYO, SBUKT, "SBUKT", false);
        addPattern(PATTERN_SINDANSYO, SONOTA, "SONOTA", false);


        lock(C_SeikyuusyaKbn.class);
    }

    private C_SeikyuusyaKbn(String value) {
        super(value);
    }

    public static C_SeikyuusyaKbn valueOf(String value) {
        return valueOf(C_SeikyuusyaKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SeikyuusyaKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SeikyuusyaKbn.class, patternId, value);
    }
}
