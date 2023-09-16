
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＰＡＬ料率区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_PalRyourituKbn</td><td colspan="3">ＰＡＬ料率区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="7">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OTHER}</td><td>&quot;1&quot;</td><td>その他（普通料率・一時払料率）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DANTAI_A}</td><td>&quot;2&quot;</td><td>団体料率Ａ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DANTAI_B}</td><td>&quot;3&quot;</td><td>団体料率Ｂ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUHURI}</td><td>&quot;4&quot;</td><td>口座振替料率</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYUUDAN}</td><td>&quot;5&quot;</td><td>集団料率</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CREDIT}</td><td>&quot;6&quot;</td><td>クレジット料率</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_SELECT SELECT}<br />(選択)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OTHER}</td><td>&quot;1&quot;</td><td>０：その他（普通料率・一時払料率）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUHURI}</td><td>&quot;4&quot;</td><td>３：口座振替料率</td></tr>
 * </table>
 */
public class C_PalRyourituKbn extends Classification<C_PalRyourituKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_PalRyourituKbn BLNK = new C_PalRyourituKbn("0");

    public static final C_PalRyourituKbn OTHER = new C_PalRyourituKbn("1");

    public static final C_PalRyourituKbn DANTAI_A = new C_PalRyourituKbn("2");

    public static final C_PalRyourituKbn DANTAI_B = new C_PalRyourituKbn("3");

    public static final C_PalRyourituKbn KOUHURI = new C_PalRyourituKbn("4");

    public static final C_PalRyourituKbn SYUUDAN = new C_PalRyourituKbn("5");

    public static final C_PalRyourituKbn CREDIT = new C_PalRyourituKbn("6");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SELECT = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, OTHER, "OTHER", false);
        addPattern(PATTERN_DEFAULT, DANTAI_A, "DANTAI_A", false);
        addPattern(PATTERN_DEFAULT, DANTAI_B, "DANTAI_B", false);
        addPattern(PATTERN_DEFAULT, KOUHURI, "KOUHURI", false);
        addPattern(PATTERN_DEFAULT, SYUUDAN, "SYUUDAN", false);
        addPattern(PATTERN_DEFAULT, CREDIT, "CREDIT", false);


        addPattern(PATTERN_SELECT, BLNK, "BLNK", true);
        addPattern(PATTERN_SELECT, OTHER, "OTHER", false);
        addPattern(PATTERN_SELECT, KOUHURI, "KOUHURI", false);


        lock(C_PalRyourituKbn.class);
    }

    private C_PalRyourituKbn(String value) {
        super(value);
    }

    public static C_PalRyourituKbn valueOf(String value) {
        return valueOf(C_PalRyourituKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_PalRyourituKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_PalRyourituKbn.class, patternId, value);
    }
}
