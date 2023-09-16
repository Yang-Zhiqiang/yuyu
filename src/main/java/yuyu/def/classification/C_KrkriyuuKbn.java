
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 仮受理由区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KrkriyuuKbn</td><td colspan="3">仮受理由区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="32">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUMETUGONYKN}</td><td>&quot;1&quot;</td><td>消滅後入金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HRMNGONYKN}</td><td>&quot;2&quot;</td><td>払満後入金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YUYOKKNGONYKN}</td><td>&quot;3&quot;</td><td>猶予期間後入金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PMENGONYKN}</td><td>&quot;4&quot;</td><td>Ｐ免後入金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZENNOUTYUUNYKN}</td><td>&quot;5&quot;</td><td>前納中入金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYUUSOKUTYUUNYKN}</td><td>&quot;6&quot;</td><td>休息中入金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUSOKUNYKN}</td><td>&quot;11&quot;</td><td>不足入金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAZYOUNYKN}</td><td>&quot;12&quot;</td><td>過剰入金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NYKNNAIYOUSOUI}</td><td>&quot;21&quot;</td><td>入金内容相違</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZYUTOUTUKISOUI}</td><td>&quot;22&quot;</td><td>充当月相違</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RYSYBIMISS}</td><td>&quot;23&quot;</td><td>領収日ミス</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HRKKAISUUSOUI}</td><td>&quot;24&quot;</td><td>払込回数相違</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HRKHOUHOUSOUI}</td><td>&quot;25&quot;</td><td>払込方法相違</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OTHERKR_ARI}</td><td>&quot;26&quot;</td><td>他に仮受あり</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZYUTOUSUUSOUI}</td><td>&quot;27&quot;</td><td>充当回数相違</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HENKOUMATI}</td><td>&quot;31&quot;</td><td>変更処理待ち</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HRHN_SYORIHTY}</td><td>&quot;32&quot;</td><td>払変処理必要</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUMETUGONYKN_1P}</td><td>&quot;41&quot;</td><td>消滅後入金（初回Ｐ）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PMENGONYKN_1P}</td><td>&quot;42&quot;</td><td>Ｐ免後入金（初回Ｐ）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YUYOKKNGONYKN_1P}</td><td>&quot;43&quot;</td><td>猶予期間後入金（初回Ｐ）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JYUTOUTUKISOUI_1P}</td><td>&quot;44&quot;</td><td>充当月相違（初回Ｐ）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HRKKAISUUSOUI_1P}</td><td>&quot;45&quot;</td><td>払込回数相違（初回Ｐ）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JYUTOUSUUSOUI_1P}</td><td>&quot;46&quot;</td><td>充当回数相違（初回Ｐ）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUSOKUNYKN_1P}</td><td>&quot;47&quot;</td><td>不足入金（初回Ｐ）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAZYOUNYKN_1P}</td><td>&quot;48&quot;</td><td>過剰入金（初回Ｐ）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OHTHER_1P}</td><td>&quot;49&quot;</td><td>その他（初回Ｐ）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PTORIKESI}</td><td>&quot;50&quot;</td><td>Ｐ取消による仮受</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HENKINHITUYOU}</td><td>&quot;61&quot;</td><td>返金必要</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HONSYASYOUKAIHTY}</td><td>&quot;80&quot;</td><td>本社照会必要</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KIGETUMAENYN}</td><td>&quot;81&quot;</td><td>期月前入金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OHTHER}</td><td>&quot;90&quot;</td><td>その他</td></tr>
 * </table>
 */
public class C_KrkriyuuKbn extends Classification<C_KrkriyuuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KrkriyuuKbn BLNK = new C_KrkriyuuKbn("0");

    public static final C_KrkriyuuKbn SYOUMETUGONYKN = new C_KrkriyuuKbn("1");

    public static final C_KrkriyuuKbn HRMNGONYKN = new C_KrkriyuuKbn("2");

    public static final C_KrkriyuuKbn YUYOKKNGONYKN = new C_KrkriyuuKbn("3");

    public static final C_KrkriyuuKbn PMENGONYKN = new C_KrkriyuuKbn("4");

    public static final C_KrkriyuuKbn ZENNOUTYUUNYKN = new C_KrkriyuuKbn("5");

    public static final C_KrkriyuuKbn KYUUSOKUTYUUNYKN = new C_KrkriyuuKbn("6");

    public static final C_KrkriyuuKbn HUSOKUNYKN = new C_KrkriyuuKbn("11");

    public static final C_KrkriyuuKbn KAZYOUNYKN = new C_KrkriyuuKbn("12");

    public static final C_KrkriyuuKbn NYKNNAIYOUSOUI = new C_KrkriyuuKbn("21");

    public static final C_KrkriyuuKbn ZYUTOUTUKISOUI = new C_KrkriyuuKbn("22");

    public static final C_KrkriyuuKbn RYSYBIMISS = new C_KrkriyuuKbn("23");

    public static final C_KrkriyuuKbn HRKKAISUUSOUI = new C_KrkriyuuKbn("24");

    public static final C_KrkriyuuKbn HRKHOUHOUSOUI = new C_KrkriyuuKbn("25");

    public static final C_KrkriyuuKbn OTHERKR_ARI = new C_KrkriyuuKbn("26");

    public static final C_KrkriyuuKbn ZYUTOUSUUSOUI = new C_KrkriyuuKbn("27");

    public static final C_KrkriyuuKbn HENKOUMATI = new C_KrkriyuuKbn("31");

    public static final C_KrkriyuuKbn HRHN_SYORIHTY = new C_KrkriyuuKbn("32");

    public static final C_KrkriyuuKbn SYOUMETUGONYKN_1P = new C_KrkriyuuKbn("41");

    public static final C_KrkriyuuKbn PMENGONYKN_1P = new C_KrkriyuuKbn("42");

    public static final C_KrkriyuuKbn YUYOKKNGONYKN_1P = new C_KrkriyuuKbn("43");

    public static final C_KrkriyuuKbn JYUTOUTUKISOUI_1P = new C_KrkriyuuKbn("44");

    public static final C_KrkriyuuKbn HRKKAISUUSOUI_1P = new C_KrkriyuuKbn("45");

    public static final C_KrkriyuuKbn JYUTOUSUUSOUI_1P = new C_KrkriyuuKbn("46");

    public static final C_KrkriyuuKbn HUSOKUNYKN_1P = new C_KrkriyuuKbn("47");

    public static final C_KrkriyuuKbn KAZYOUNYKN_1P = new C_KrkriyuuKbn("48");

    public static final C_KrkriyuuKbn OHTHER_1P = new C_KrkriyuuKbn("49");

    public static final C_KrkriyuuKbn PTORIKESI = new C_KrkriyuuKbn("50");

    public static final C_KrkriyuuKbn HENKINHITUYOU = new C_KrkriyuuKbn("61");

    public static final C_KrkriyuuKbn HONSYASYOUKAIHTY = new C_KrkriyuuKbn("80");

    public static final C_KrkriyuuKbn KIGETUMAENYN = new C_KrkriyuuKbn("81");

    public static final C_KrkriyuuKbn OHTHER = new C_KrkriyuuKbn("90");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SYOUMETUGONYKN, "SYOUMETUGONYKN", false);
        addPattern(PATTERN_DEFAULT, HRMNGONYKN, "HRMNGONYKN", false);
        addPattern(PATTERN_DEFAULT, YUYOKKNGONYKN, "YUYOKKNGONYKN", false);
        addPattern(PATTERN_DEFAULT, PMENGONYKN, "PMENGONYKN", false);
        addPattern(PATTERN_DEFAULT, ZENNOUTYUUNYKN, "ZENNOUTYUUNYKN", false);
        addPattern(PATTERN_DEFAULT, KYUUSOKUTYUUNYKN, "KYUUSOKUTYUUNYKN", false);
        addPattern(PATTERN_DEFAULT, HUSOKUNYKN, "HUSOKUNYKN", false);
        addPattern(PATTERN_DEFAULT, KAZYOUNYKN, "KAZYOUNYKN", false);
        addPattern(PATTERN_DEFAULT, NYKNNAIYOUSOUI, "NYKNNAIYOUSOUI", false);
        addPattern(PATTERN_DEFAULT, ZYUTOUTUKISOUI, "ZYUTOUTUKISOUI", false);
        addPattern(PATTERN_DEFAULT, RYSYBIMISS, "RYSYBIMISS", false);
        addPattern(PATTERN_DEFAULT, HRKKAISUUSOUI, "HRKKAISUUSOUI", false);
        addPattern(PATTERN_DEFAULT, HRKHOUHOUSOUI, "HRKHOUHOUSOUI", false);
        addPattern(PATTERN_DEFAULT, OTHERKR_ARI, "OTHERKR_ARI", false);
        addPattern(PATTERN_DEFAULT, ZYUTOUSUUSOUI, "ZYUTOUSUUSOUI", false);
        addPattern(PATTERN_DEFAULT, HENKOUMATI, "HENKOUMATI", false);
        addPattern(PATTERN_DEFAULT, HRHN_SYORIHTY, "HRHN_SYORIHTY", false);
        addPattern(PATTERN_DEFAULT, SYOUMETUGONYKN_1P, "SYOUMETUGONYKN_1P", false);
        addPattern(PATTERN_DEFAULT, PMENGONYKN_1P, "PMENGONYKN_1P", false);
        addPattern(PATTERN_DEFAULT, YUYOKKNGONYKN_1P, "YUYOKKNGONYKN_1P", false);
        addPattern(PATTERN_DEFAULT, JYUTOUTUKISOUI_1P, "JYUTOUTUKISOUI_1P", false);
        addPattern(PATTERN_DEFAULT, HRKKAISUUSOUI_1P, "HRKKAISUUSOUI_1P", false);
        addPattern(PATTERN_DEFAULT, JYUTOUSUUSOUI_1P, "JYUTOUSUUSOUI_1P", false);
        addPattern(PATTERN_DEFAULT, HUSOKUNYKN_1P, "HUSOKUNYKN_1P", false);
        addPattern(PATTERN_DEFAULT, KAZYOUNYKN_1P, "KAZYOUNYKN_1P", false);
        addPattern(PATTERN_DEFAULT, OHTHER_1P, "OHTHER_1P", false);
        addPattern(PATTERN_DEFAULT, PTORIKESI, "PTORIKESI", false);
        addPattern(PATTERN_DEFAULT, HENKINHITUYOU, "HENKINHITUYOU", false);
        addPattern(PATTERN_DEFAULT, HONSYASYOUKAIHTY, "HONSYASYOUKAIHTY", false);
        addPattern(PATTERN_DEFAULT, KIGETUMAENYN, "KIGETUMAENYN", false);
        addPattern(PATTERN_DEFAULT, OHTHER, "OHTHER", false);


        lock(C_KrkriyuuKbn.class);
    }

    private C_KrkriyuuKbn(String value) {
        super(value);
    }

    public static C_KrkriyuuKbn valueOf(String value) {
        return valueOf(C_KrkriyuuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KrkriyuuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KrkriyuuKbn.class, patternId, value);
    }
}
