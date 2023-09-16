
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 査定・決定処理名区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SateiketsyorinmKbn</td><td colspan="3">査定・決定処理名区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="16">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #MOSTENKEN_1}</td><td>&quot;MT1&quot;</td><td>申込点検（１次）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MOSTENKEN_2}</td><td>&quot;MT2&quot;</td><td>申込点検（２次）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MOSTENKEN_3}</td><td>&quot;MT3&quot;</td><td>申込点検（３次）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MOSTENKEN_HUBI}</td><td>&quot;MTHB&quot;</td><td>申込点検（点検後不備）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KNKSATEI_1}</td><td>&quot;KN1&quot;</td><td>環境査定（１次）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KNKSATEI_2A}</td><td>&quot;KN2A&quot;</td><td>環境査定（２次Ａ）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KNKSATEI_2B}</td><td>&quot;KN2B&quot;</td><td>環境査定（２次Ｂ）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IMUSATEI_KANI_UW}</td><td>&quot;IMKUW&quot;</td><td>医務査定（簡易（ＵＷ））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IMUSATEI_KANI_MD}</td><td>&quot;IMKMD&quot;</td><td>医務査定（簡易（ＭＤ））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #LINCKKA}</td><td>&quot;LINC&quot;</td><td>ＬＩＮＣ結果反映</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RULEHANTEI}</td><td>&quot;RULE&quot;</td><td>ルール判定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUBIKAISYOU}</td><td>&quot;HBKS&quot;</td><td>不備解消</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYOSEIHANDKET}</td><td>&quot;KHK&quot;</td><td>強制ハンド決定入力</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TORIKESI}</td><td>&quot;TRKS&quot;</td><td>申込取消</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MOSINPUT_HENTEI_NYUTEI}</td><td>&quot;MOST&quot;</td><td>申込書入力（変更訂正・入力訂正）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKKAKKEKKA}</td><td>&quot;KYKKK&quot;</td><td>契約確認結果入力</td></tr>
 * </table>
 */
public class C_SateiketsyorinmKbn extends Classification<C_SateiketsyorinmKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SateiketsyorinmKbn MOSTENKEN_1 = new C_SateiketsyorinmKbn("MT1");

    public static final C_SateiketsyorinmKbn MOSTENKEN_2 = new C_SateiketsyorinmKbn("MT2");

    public static final C_SateiketsyorinmKbn MOSTENKEN_3 = new C_SateiketsyorinmKbn("MT3");

    public static final C_SateiketsyorinmKbn MOSTENKEN_HUBI = new C_SateiketsyorinmKbn("MTHB");

    public static final C_SateiketsyorinmKbn KNKSATEI_1 = new C_SateiketsyorinmKbn("KN1");

    public static final C_SateiketsyorinmKbn KNKSATEI_2A = new C_SateiketsyorinmKbn("KN2A");

    public static final C_SateiketsyorinmKbn KNKSATEI_2B = new C_SateiketsyorinmKbn("KN2B");

    public static final C_SateiketsyorinmKbn IMUSATEI_KANI_UW = new C_SateiketsyorinmKbn("IMKUW");

    public static final C_SateiketsyorinmKbn IMUSATEI_KANI_MD = new C_SateiketsyorinmKbn("IMKMD");

    public static final C_SateiketsyorinmKbn LINCKKA = new C_SateiketsyorinmKbn("LINC");

    public static final C_SateiketsyorinmKbn RULEHANTEI = new C_SateiketsyorinmKbn("RULE");

    public static final C_SateiketsyorinmKbn HUBIKAISYOU = new C_SateiketsyorinmKbn("HBKS");

    public static final C_SateiketsyorinmKbn KYOSEIHANDKET = new C_SateiketsyorinmKbn("KHK");

    public static final C_SateiketsyorinmKbn TORIKESI = new C_SateiketsyorinmKbn("TRKS");

    public static final C_SateiketsyorinmKbn MOSINPUT_HENTEI_NYUTEI = new C_SateiketsyorinmKbn("MOST");

    public static final C_SateiketsyorinmKbn KYKKAKKEKKA = new C_SateiketsyorinmKbn("KYKKK");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, MOSTENKEN_1, "MOSTENKEN_1", true);
        addPattern(PATTERN_DEFAULT, MOSTENKEN_2, "MOSTENKEN_2", false);
        addPattern(PATTERN_DEFAULT, MOSTENKEN_3, "MOSTENKEN_3", false);
        addPattern(PATTERN_DEFAULT, MOSTENKEN_HUBI, "MOSTENKEN_HUBI", false);
        addPattern(PATTERN_DEFAULT, KNKSATEI_1, "KNKSATEI_1", false);
        addPattern(PATTERN_DEFAULT, KNKSATEI_2A, "KNKSATEI_2A", false);
        addPattern(PATTERN_DEFAULT, KNKSATEI_2B, "KNKSATEI_2B", false);
        addPattern(PATTERN_DEFAULT, IMUSATEI_KANI_UW, "IMUSATEI_KANI_UW", false);
        addPattern(PATTERN_DEFAULT, IMUSATEI_KANI_MD, "IMUSATEI_KANI_MD", false);
        addPattern(PATTERN_DEFAULT, LINCKKA, "LINCKKA", false);
        addPattern(PATTERN_DEFAULT, RULEHANTEI, "RULEHANTEI", false);
        addPattern(PATTERN_DEFAULT, HUBIKAISYOU, "HUBIKAISYOU", false);
        addPattern(PATTERN_DEFAULT, KYOSEIHANDKET, "KYOSEIHANDKET", false);
        addPattern(PATTERN_DEFAULT, TORIKESI, "TORIKESI", false);
        addPattern(PATTERN_DEFAULT, MOSINPUT_HENTEI_NYUTEI, "MOSINPUT_HENTEI_NYUTEI", false);
        addPattern(PATTERN_DEFAULT, KYKKAKKEKKA, "KYKKAKKEKKA", false);


        lock(C_SateiketsyorinmKbn.class);
    }

    private C_SateiketsyorinmKbn(String value) {
        super(value);
    }

    public static C_SateiketsyorinmKbn valueOf(String value) {
        return valueOf(C_SateiketsyorinmKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SateiketsyorinmKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SateiketsyorinmKbn.class, patternId, value);
    }
}
