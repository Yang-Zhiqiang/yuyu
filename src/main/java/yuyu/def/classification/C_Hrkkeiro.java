
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 払込経路 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Hrkkeiro</td><td colspan="3">払込経路</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUHURI}</td><td>&quot;1&quot;</td><td>口座振替扱い</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DANTAI}</td><td>&quot;2&quot;</td><td>団体</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYUUDAN}</td><td>&quot;3&quot;</td><td>集団</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HURIKAE}</td><td>&quot;4&quot;</td><td>振替</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CREDIT}</td><td>&quot;6&quot;</td><td>クレジットカード扱い</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_SELECT SELECT}<br />(選択用)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUHURI}</td><td>&quot;1&quot;</td><td>口座振替扱い</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CREDIT}</td><td>&quot;6&quot;</td><td>クレジットカード扱い</td></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_TYHYRYKNM TYHYRYKNM}<br />(帳票表示用略称)</td><td align="center">&nbsp;</td><td>{@link #KOUHURI}</td><td>&quot;1&quot;</td><td>口振</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DANTAI}</td><td>&quot;2&quot;</td><td>団体</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYUUDAN}</td><td>&quot;3&quot;</td><td>集団</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CREDIT}</td><td>&quot;6&quot;</td><td>クレ</td></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_SINKEIYAKU SINKEIYAKU}<br />(新契約用)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUHURI}</td><td>&quot;1&quot;</td><td>口座振替</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DANTAI}</td><td>&quot;2&quot;</td><td>団体</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYUUDAN}</td><td>&quot;3&quot;</td><td>集団</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HURIKAE}</td><td>&quot;4&quot;</td><td>振替</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CREDIT}</td><td>&quot;6&quot;</td><td>クレジットカード扱い</td></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_SKMOUSIKOMI SKMOUSIKOMI}<br />(申込書入力用)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUHURI}</td><td>&quot;1&quot;</td><td>口座振替</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CREDIT}</td><td>&quot;6&quot;</td><td>クレジットカード扱い</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HURIKAE}</td><td>&quot;4&quot;</td><td>振替</td></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_DISPKANANASI DISPKANANASI}<br />(表示用（送り仮名なし）)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUHURI}</td><td>&quot;1&quot;</td><td>口座振替</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DANTAI}</td><td>&quot;2&quot;</td><td>団体</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYUUDAN}</td><td>&quot;3&quot;</td><td>集団</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HURIKAE}</td><td>&quot;4&quot;</td><td>振替</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CREDIT}</td><td>&quot;6&quot;</td><td>クレジットカード扱</td></tr>
 * </table>
 */
public class C_Hrkkeiro extends Classification<C_Hrkkeiro> {

    private static final long serialVersionUID = 1L;


    public static final C_Hrkkeiro BLNK = new C_Hrkkeiro("0");

    public static final C_Hrkkeiro KOUHURI = new C_Hrkkeiro("1");

    public static final C_Hrkkeiro DANTAI = new C_Hrkkeiro("2");

    public static final C_Hrkkeiro SYUUDAN = new C_Hrkkeiro("3");

    public static final C_Hrkkeiro HURIKAE = new C_Hrkkeiro("4");

    public static final C_Hrkkeiro CREDIT = new C_Hrkkeiro("6");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SELECT = "2";

    public static final String PATTERN_TYHYRYKNM = "3";

    public static final String PATTERN_SINKEIYAKU = "4";

    public static final String PATTERN_SKMOUSIKOMI = "5";

    public static final String PATTERN_DISPKANANASI = "6";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KOUHURI, "KOUHURI", false);
        addPattern(PATTERN_DEFAULT, DANTAI, "DANTAI", false);
        addPattern(PATTERN_DEFAULT, SYUUDAN, "SYUUDAN", false);
        addPattern(PATTERN_DEFAULT, HURIKAE, "HURIKAE", false);
        addPattern(PATTERN_DEFAULT, CREDIT, "CREDIT", false);


        addPattern(PATTERN_SELECT, BLNK, "BLNK", true);
        addPattern(PATTERN_SELECT, KOUHURI, "KOUHURI", false);
        addPattern(PATTERN_SELECT, CREDIT, "CREDIT", false);


        addPattern(PATTERN_TYHYRYKNM, KOUHURI, "KOUHURI", false);
        addPattern(PATTERN_TYHYRYKNM, DANTAI, "DANTAI", false);
        addPattern(PATTERN_TYHYRYKNM, SYUUDAN, "SYUUDAN", false);
        addPattern(PATTERN_TYHYRYKNM, CREDIT, "CREDIT", false);


        addPattern(PATTERN_SINKEIYAKU, BLNK, "BLNK", true);
        addPattern(PATTERN_SINKEIYAKU, KOUHURI, "KOUHURI", false);
        addPattern(PATTERN_SINKEIYAKU, DANTAI, "DANTAI", false);
        addPattern(PATTERN_SINKEIYAKU, SYUUDAN, "SYUUDAN", false);
        addPattern(PATTERN_SINKEIYAKU, HURIKAE, "HURIKAE", false);
        addPattern(PATTERN_SINKEIYAKU, CREDIT, "CREDIT", false);


        addPattern(PATTERN_SKMOUSIKOMI, BLNK, "BLNK", true);
        addPattern(PATTERN_SKMOUSIKOMI, KOUHURI, "KOUHURI", false);
        addPattern(PATTERN_SKMOUSIKOMI, CREDIT, "CREDIT", false);
        addPattern(PATTERN_SKMOUSIKOMI, HURIKAE, "HURIKAE", false);


        addPattern(PATTERN_DISPKANANASI, BLNK, "BLNK", true);
        addPattern(PATTERN_DISPKANANASI, KOUHURI, "KOUHURI", false);
        addPattern(PATTERN_DISPKANANASI, DANTAI, "DANTAI", false);
        addPattern(PATTERN_DISPKANANASI, SYUUDAN, "SYUUDAN", false);
        addPattern(PATTERN_DISPKANANASI, HURIKAE, "HURIKAE", false);
        addPattern(PATTERN_DISPKANANASI, CREDIT, "CREDIT", false);


        lock(C_Hrkkeiro.class);
    }

    private C_Hrkkeiro(String value) {
        super(value);
    }

    public static C_Hrkkeiro valueOf(String value) {
        return valueOf(C_Hrkkeiro.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Hrkkeiro.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Hrkkeiro.class, patternId, value);
    }
}
