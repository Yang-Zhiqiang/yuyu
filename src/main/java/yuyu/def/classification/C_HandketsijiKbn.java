
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ハンド決定指示区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HandketsijiKbn</td><td colspan="3">ハンド決定指示区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="9">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #HUYOU}</td><td>&quot;0&quot;</td><td>不要</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYOUSEIKET}</td><td>&quot;1&quot;</td><td>強制決定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #LINC_TASYAARI}</td><td>&quot;2&quot;</td><td>ＬＩＮＣ他社加入あり</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKKAK_MONDAI_ARI}</td><td>&quot;3&quot;</td><td>契約確認問題あり</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NIJIKET_YOU}</td><td>&quot;4&quot;</td><td>２次決定要</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KIKENZOU_HENKOU_ARI}</td><td>&quot;5&quot;</td><td>危険増変更あり</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KETKEKKAIRAI}</td><td>&quot;6&quot;</td><td>決定結果入力依頼</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HIWEB_KANKYOUIMUSATEI}</td><td>&quot;7&quot;</td><td>非対面Ｗｅｂ環境・医務査定実施</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HIWEB_TOKUJYOUKETTEI}</td><td>&quot;8&quot;</td><td>非対面Ｗｅｂ特条決定</td></tr>
 * </table>
 */
public class C_HandketsijiKbn extends Classification<C_HandketsijiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HandketsijiKbn HUYOU = new C_HandketsijiKbn("0");

    public static final C_HandketsijiKbn KYOUSEIKET = new C_HandketsijiKbn("1");

    public static final C_HandketsijiKbn LINC_TASYAARI = new C_HandketsijiKbn("2");

    public static final C_HandketsijiKbn KYKKAK_MONDAI_ARI = new C_HandketsijiKbn("3");

    public static final C_HandketsijiKbn NIJIKET_YOU = new C_HandketsijiKbn("4");

    public static final C_HandketsijiKbn KIKENZOU_HENKOU_ARI = new C_HandketsijiKbn("5");

    public static final C_HandketsijiKbn KETKEKKAIRAI = new C_HandketsijiKbn("6");

    public static final C_HandketsijiKbn HIWEB_KANKYOUIMUSATEI = new C_HandketsijiKbn("7");

    public static final C_HandketsijiKbn HIWEB_TOKUJYOUKETTEI = new C_HandketsijiKbn("8");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, HUYOU, "HUYOU", true);
        addPattern(PATTERN_DEFAULT, KYOUSEIKET, "KYOUSEIKET", false);
        addPattern(PATTERN_DEFAULT, LINC_TASYAARI, "LINC_TASYAARI", false);
        addPattern(PATTERN_DEFAULT, KYKKAK_MONDAI_ARI, "KYKKAK_MONDAI_ARI", false);
        addPattern(PATTERN_DEFAULT, NIJIKET_YOU, "NIJIKET_YOU", false);
        addPattern(PATTERN_DEFAULT, KIKENZOU_HENKOU_ARI, "KIKENZOU_HENKOU_ARI", false);
        addPattern(PATTERN_DEFAULT, KETKEKKAIRAI, "KETKEKKAIRAI", false);
        addPattern(PATTERN_DEFAULT, HIWEB_KANKYOUIMUSATEI, "HIWEB_KANKYOUIMUSATEI", false);
        addPattern(PATTERN_DEFAULT, HIWEB_TOKUJYOUKETTEI, "HIWEB_TOKUJYOUKETTEI", false);


        lock(C_HandketsijiKbn.class);
    }

    private C_HandketsijiKbn(String value) {
        super(value);
    }

    public static C_HandketsijiKbn valueOf(String value) {
        return valueOf(C_HandketsijiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HandketsijiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HandketsijiKbn.class, patternId, value);
    }
}
