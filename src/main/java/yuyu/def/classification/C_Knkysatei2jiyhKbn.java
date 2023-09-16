
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 環境査定（２次）要否区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Knkysatei2jiyhKbn</td><td colspan="3">環境査定（２次）要否区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>未判定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUYOU}</td><td>&quot;1&quot;</td><td>実施不要</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YOU_A}</td><td>&quot;2&quot;</td><td>実施要（ランクＡ）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YOU_B}</td><td>&quot;3&quot;</td><td>実施要（ランクＢ）</td></tr>
 * </table>
 */
public class C_Knkysatei2jiyhKbn extends Classification<C_Knkysatei2jiyhKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_Knkysatei2jiyhKbn NONE = new C_Knkysatei2jiyhKbn("0");

    public static final C_Knkysatei2jiyhKbn HUYOU = new C_Knkysatei2jiyhKbn("1");

    public static final C_Knkysatei2jiyhKbn YOU_A = new C_Knkysatei2jiyhKbn("2");

    public static final C_Knkysatei2jiyhKbn YOU_B = new C_Knkysatei2jiyhKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NONE, "NONE", true);
        addPattern(PATTERN_DEFAULT, HUYOU, "HUYOU", false);
        addPattern(PATTERN_DEFAULT, YOU_A, "YOU_A", false);
        addPattern(PATTERN_DEFAULT, YOU_B, "YOU_B", false);


        lock(C_Knkysatei2jiyhKbn.class);
    }

    private C_Knkysatei2jiyhKbn(String value) {
        super(value);
    }

    public static C_Knkysatei2jiyhKbn valueOf(String value) {
        return valueOf(C_Knkysatei2jiyhKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Knkysatei2jiyhKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Knkysatei2jiyhKbn.class, patternId, value);
    }
}
