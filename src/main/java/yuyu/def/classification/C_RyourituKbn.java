
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 料率区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_RyourituKbn</td><td colspan="3">料率区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="7">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OTHER}</td><td>&quot;1&quot;</td><td>その他（普通料率・一時払料率）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DANTAI_A}</td><td>&quot;2&quot;</td><td>団体料率Ａ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DANTAI_B}</td><td>&quot;3&quot;</td><td>団体料率Ｂ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUHURI}</td><td>&quot;4&quot;</td><td>口座振替料率</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYUUDAN}</td><td>&quot;5&quot;</td><td>集団料率</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CREDIT}</td><td>&quot;6&quot;</td><td>クレジット料率</td></tr>
 * </table>
 */
public class C_RyourituKbn extends Classification<C_RyourituKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_RyourituKbn BLNK = new C_RyourituKbn("0");

    public static final C_RyourituKbn OTHER = new C_RyourituKbn("1");

    public static final C_RyourituKbn DANTAI_A = new C_RyourituKbn("2");

    public static final C_RyourituKbn DANTAI_B = new C_RyourituKbn("3");

    public static final C_RyourituKbn KOUHURI = new C_RyourituKbn("4");

    public static final C_RyourituKbn SYUUDAN = new C_RyourituKbn("5");

    public static final C_RyourituKbn CREDIT = new C_RyourituKbn("6");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, OTHER, "OTHER", false);
        addPattern(PATTERN_DEFAULT, DANTAI_A, "DANTAI_A", false);
        addPattern(PATTERN_DEFAULT, DANTAI_B, "DANTAI_B", false);
        addPattern(PATTERN_DEFAULT, KOUHURI, "KOUHURI", false);
        addPattern(PATTERN_DEFAULT, SYUUDAN, "SYUUDAN", false);
        addPattern(PATTERN_DEFAULT, CREDIT, "CREDIT", false);


        lock(C_RyourituKbn.class);
    }

    private C_RyourituKbn(String value) {
        super(value);
    }

    public static C_RyourituKbn valueOf(String value) {
        return valueOf(C_RyourituKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_RyourituKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_RyourituKbn.class, patternId, value);
    }
}
