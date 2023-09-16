
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 財務会計決算区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_ZaimukaikeiksnKbn</td><td colspan="3">財務会計決算区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="9">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #TUUJYOU}</td><td>&quot;0&quot;</td><td>通常取引</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KSNTRHK}</td><td>&quot;1&quot;</td><td>決算取引</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KSNTYSI}</td><td>&quot;2&quot;</td><td>決算調整</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KSNTRHKTYUUKAN}</td><td>&quot;3&quot;</td><td>中間決算取引</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KSNTYSITYUUKAN}</td><td>&quot;4&quot;</td><td>中間決算調整</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KSNTRHK1Q}</td><td>&quot;5&quot;</td><td>5：１Q決算取引</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KSNTYSI1Q}</td><td>&quot;6&quot;</td><td>6：１Q決算調整</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KSNTRHK3Q}</td><td>&quot;7&quot;</td><td>7：３Q決算取引</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KSNTYSI3Q}</td><td>&quot;8&quot;</td><td>8：３Q決算調整</td></tr>
 * </table>
 */
public class C_ZaimukaikeiksnKbn extends Classification<C_ZaimukaikeiksnKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_ZaimukaikeiksnKbn TUUJYOU = new C_ZaimukaikeiksnKbn("0");

    public static final C_ZaimukaikeiksnKbn KSNTRHK = new C_ZaimukaikeiksnKbn("1");

    public static final C_ZaimukaikeiksnKbn KSNTYSI = new C_ZaimukaikeiksnKbn("2");

    public static final C_ZaimukaikeiksnKbn KSNTRHKTYUUKAN = new C_ZaimukaikeiksnKbn("3");

    public static final C_ZaimukaikeiksnKbn KSNTYSITYUUKAN = new C_ZaimukaikeiksnKbn("4");

    public static final C_ZaimukaikeiksnKbn KSNTRHK1Q = new C_ZaimukaikeiksnKbn("5");

    public static final C_ZaimukaikeiksnKbn KSNTYSI1Q = new C_ZaimukaikeiksnKbn("6");

    public static final C_ZaimukaikeiksnKbn KSNTRHK3Q = new C_ZaimukaikeiksnKbn("7");

    public static final C_ZaimukaikeiksnKbn KSNTYSI3Q = new C_ZaimukaikeiksnKbn("8");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, TUUJYOU, "TUUJYOU", true);
        addPattern(PATTERN_DEFAULT, KSNTRHK, "KSNTRHK", false);
        addPattern(PATTERN_DEFAULT, KSNTYSI, "KSNTYSI", false);
        addPattern(PATTERN_DEFAULT, KSNTRHKTYUUKAN, "KSNTRHKTYUUKAN", false);
        addPattern(PATTERN_DEFAULT, KSNTYSITYUUKAN, "KSNTYSITYUUKAN", false);
        addPattern(PATTERN_DEFAULT, KSNTRHK1Q, "KSNTRHK1Q", false);
        addPattern(PATTERN_DEFAULT, KSNTYSI1Q, "KSNTYSI1Q", false);
        addPattern(PATTERN_DEFAULT, KSNTRHK3Q, "KSNTRHK3Q", false);
        addPattern(PATTERN_DEFAULT, KSNTYSI3Q, "KSNTYSI3Q", false);


        lock(C_ZaimukaikeiksnKbn.class);
    }

    private C_ZaimukaikeiksnKbn(String value) {
        super(value);
    }

    public static C_ZaimukaikeiksnKbn valueOf(String value) {
        return valueOf(C_ZaimukaikeiksnKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_ZaimukaikeiksnKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_ZaimukaikeiksnKbn.class, patternId, value);
    }
}
