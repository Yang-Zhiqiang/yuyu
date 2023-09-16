
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 型区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KataKbn</td><td colspan="3">型区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="9">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HONNIN}</td><td>&quot;1&quot;</td><td>本人型</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HONNIN_TUMA}</td><td>&quot;2&quot;</td><td>本人・妻型</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HONIN_KO}</td><td>&quot;3&quot;</td><td>本人・子型</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HONNIN_SAISI}</td><td>&quot;4&quot;</td><td>本人・妻子型</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GKYUFGK_5}</td><td>&quot;11&quot;</td><td>5/1万 型</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GKYUFGK_10}</td><td>&quot;12&quot;</td><td>10/1万 型</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GKYUFGK_15}</td><td>&quot;13&quot;</td><td>15/1万 型</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GKYUFGK_20}</td><td>&quot;14&quot;</td><td>20/1万 型</td></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_NOBLNK NOBLNK}<br />(ブランクなし)</td><td align="center">&nbsp;</td><td>{@link #HONNIN}</td><td>&quot;1&quot;</td><td>本人型</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HONNIN_TUMA}</td><td>&quot;2&quot;</td><td>本人・妻型</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HONIN_KO}</td><td>&quot;3&quot;</td><td>本人・子型</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HONNIN_SAISI}</td><td>&quot;4&quot;</td><td>本人・妻子型</td></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_SYU SYU}<br />(主契約)</td><td align="center">○</td><td>{@link #HONNIN}</td><td>&quot;1&quot;</td><td>本人型</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HONNIN_TUMA}</td><td>&quot;2&quot;</td><td>本人・妻型</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HONIN_KO}</td><td>&quot;3&quot;</td><td>本人・子型</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HONNIN_SAISI}</td><td>&quot;4&quot;</td><td>本人・妻子型</td></tr>
 *  <tr><td rowspan="1">{@link #PATTERN_SELECT SELECT}<br />(選択)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_GKYUFGK GKYUFGK}<br />(がん入院給付日額の型)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GKYUFGK_5}</td><td>&quot;11&quot;</td><td>5/1万 型</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GKYUFGK_10}</td><td>&quot;12&quot;</td><td>10/1万 型</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GKYUFGK_15}</td><td>&quot;13&quot;</td><td>15/1万 型</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GKYUFGK_20}</td><td>&quot;14&quot;</td><td>20/1万 型</td></tr>
 *  <tr><td rowspan="9">{@link #PATTERN_GAMEN GAMEN}<br />(画面表示用)</td><td align="center">&nbsp;</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HONNIN}</td><td>&quot;1&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HONNIN_TUMA}</td><td>&quot;2&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HONIN_KO}</td><td>&quot;3&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HONNIN_SAISI}</td><td>&quot;4&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GKYUFGK_5}</td><td>&quot;11&quot;</td><td>5/1万 型</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GKYUFGK_10}</td><td>&quot;12&quot;</td><td>10/1万 型</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GKYUFGK_15}</td><td>&quot;13&quot;</td><td>15/1万 型</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GKYUFGK_20}</td><td>&quot;14&quot;</td><td>20/1万 型</td></tr>
 *  <tr><td rowspan="9">{@link #PATTERN_REPORT REPORT}<br />(帳票用)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HONNIN}</td><td>&quot;1&quot;</td><td>本人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HONNIN_TUMA}</td><td>&quot;2&quot;</td><td>本人・妻</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HONIN_KO}</td><td>&quot;3&quot;</td><td>本人・子</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HONNIN_SAISI}</td><td>&quot;4&quot;</td><td>本人・妻子</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GKYUFGK_5}</td><td>&quot;11&quot;</td><td>5/1万</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GKYUFGK_10}</td><td>&quot;12&quot;</td><td>10/1万</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GKYUFGK_15}</td><td>&quot;13&quot;</td><td>15/1万</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GKYUFGK_20}</td><td>&quot;14&quot;</td><td>20/1万</td></tr>
 * </table>
 */
public class C_KataKbn extends Classification<C_KataKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KataKbn BLNK = new C_KataKbn("0");

    public static final C_KataKbn HONNIN = new C_KataKbn("1");

    public static final C_KataKbn HONNIN_TUMA = new C_KataKbn("2");

    public static final C_KataKbn HONIN_KO = new C_KataKbn("3");

    public static final C_KataKbn HONNIN_SAISI = new C_KataKbn("4");

    public static final C_KataKbn GKYUFGK_5 = new C_KataKbn("11");

    public static final C_KataKbn GKYUFGK_10 = new C_KataKbn("12");

    public static final C_KataKbn GKYUFGK_15 = new C_KataKbn("13");

    public static final C_KataKbn GKYUFGK_20 = new C_KataKbn("14");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_NOBLNK = "2";

    public static final String PATTERN_SYU = "3";

    public static final String PATTERN_SELECT = "4";

    public static final String PATTERN_GKYUFGK = "5";

    public static final String PATTERN_GAMEN = "6";

    public static final String PATTERN_REPORT = "7";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, HONNIN, "HONNIN", false);
        addPattern(PATTERN_DEFAULT, HONNIN_TUMA, "HONNIN_TUMA", false);
        addPattern(PATTERN_DEFAULT, HONIN_KO, "HONIN_KO", false);
        addPattern(PATTERN_DEFAULT, HONNIN_SAISI, "HONNIN_SAISI", false);
        addPattern(PATTERN_DEFAULT, GKYUFGK_5, "GKYUFGK_5", false);
        addPattern(PATTERN_DEFAULT, GKYUFGK_10, "GKYUFGK_10", false);
        addPattern(PATTERN_DEFAULT, GKYUFGK_15, "GKYUFGK_15", false);
        addPattern(PATTERN_DEFAULT, GKYUFGK_20, "GKYUFGK_20", false);


        addPattern(PATTERN_NOBLNK, HONNIN, "HONNIN", false);
        addPattern(PATTERN_NOBLNK, HONNIN_TUMA, "HONNIN_TUMA", false);
        addPattern(PATTERN_NOBLNK, HONIN_KO, "HONIN_KO", false);
        addPattern(PATTERN_NOBLNK, HONNIN_SAISI, "HONNIN_SAISI", false);


        addPattern(PATTERN_SYU, HONNIN, "HONNIN", true);
        addPattern(PATTERN_SYU, HONNIN_TUMA, "HONNIN_TUMA", false);
        addPattern(PATTERN_SYU, HONIN_KO, "HONIN_KO", false);
        addPattern(PATTERN_SYU, HONNIN_SAISI, "HONNIN_SAISI", false);


        addPattern(PATTERN_SELECT, BLNK, "BLNK", true);


        addPattern(PATTERN_GKYUFGK, BLNK, "BLNK", true);
        addPattern(PATTERN_GKYUFGK, GKYUFGK_5, "GKYUFGK_5", false);
        addPattern(PATTERN_GKYUFGK, GKYUFGK_10, "GKYUFGK_10", false);
        addPattern(PATTERN_GKYUFGK, GKYUFGK_15, "GKYUFGK_15", false);
        addPattern(PATTERN_GKYUFGK, GKYUFGK_20, "GKYUFGK_20", false);


        addPattern(PATTERN_GAMEN, BLNK, "BLNK", false);
        addPattern(PATTERN_GAMEN, HONNIN, "HONNIN", false);
        addPattern(PATTERN_GAMEN, HONNIN_TUMA, "HONNIN_TUMA", false);
        addPattern(PATTERN_GAMEN, HONIN_KO, "HONIN_KO", false);
        addPattern(PATTERN_GAMEN, HONNIN_SAISI, "HONNIN_SAISI", false);
        addPattern(PATTERN_GAMEN, GKYUFGK_5, "GKYUFGK_5", false);
        addPattern(PATTERN_GAMEN, GKYUFGK_10, "GKYUFGK_10", false);
        addPattern(PATTERN_GAMEN, GKYUFGK_15, "GKYUFGK_15", false);
        addPattern(PATTERN_GAMEN, GKYUFGK_20, "GKYUFGK_20", false);


        addPattern(PATTERN_REPORT, BLNK, "BLNK", true);
        addPattern(PATTERN_REPORT, HONNIN, "HONNIN", false);
        addPattern(PATTERN_REPORT, HONNIN_TUMA, "HONNIN_TUMA", false);
        addPattern(PATTERN_REPORT, HONIN_KO, "HONIN_KO", false);
        addPattern(PATTERN_REPORT, HONNIN_SAISI, "HONNIN_SAISI", false);
        addPattern(PATTERN_REPORT, GKYUFGK_5, "GKYUFGK_5", false);
        addPattern(PATTERN_REPORT, GKYUFGK_10, "GKYUFGK_10", false);
        addPattern(PATTERN_REPORT, GKYUFGK_15, "GKYUFGK_15", false);
        addPattern(PATTERN_REPORT, GKYUFGK_20, "GKYUFGK_20", false);


        lock(C_KataKbn.class);
    }

    private C_KataKbn(String value) {
        super(value);
    }

    public static C_KataKbn valueOf(String value) {
        return valueOf(C_KataKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KataKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KataKbn.class, patternId, value);
    }
}
