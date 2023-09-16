
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 再勧奨期間区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SaikansKbn</td><td colspan="3">再勧奨期間区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="7">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ONEMONTH}</td><td>&quot;1&quot;</td><td>１ヶ月後</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TWOMONTHS}</td><td>&quot;2&quot;</td><td>２ヶ月後</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #THREEMONTHS}</td><td>&quot;3&quot;</td><td>３ヶ月後</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FOURMONTHS}</td><td>&quot;4&quot;</td><td>４ヶ月後</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FIVEMONTHS}</td><td>&quot;5&quot;</td><td>５ヶ月後</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIXMONTHS}</td><td>&quot;6&quot;</td><td>６ヶ月後</td></tr>
 * </table>
 */
public class C_SaikansKbn extends Classification<C_SaikansKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SaikansKbn BLNK = new C_SaikansKbn("0");

    public static final C_SaikansKbn ONEMONTH = new C_SaikansKbn("1");

    public static final C_SaikansKbn TWOMONTHS = new C_SaikansKbn("2");

    public static final C_SaikansKbn THREEMONTHS = new C_SaikansKbn("3");

    public static final C_SaikansKbn FOURMONTHS = new C_SaikansKbn("4");

    public static final C_SaikansKbn FIVEMONTHS = new C_SaikansKbn("5");

    public static final C_SaikansKbn SIXMONTHS = new C_SaikansKbn("6");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, ONEMONTH, "ONEMONTH", false);
        addPattern(PATTERN_DEFAULT, TWOMONTHS, "TWOMONTHS", false);
        addPattern(PATTERN_DEFAULT, THREEMONTHS, "THREEMONTHS", false);
        addPattern(PATTERN_DEFAULT, FOURMONTHS, "FOURMONTHS", false);
        addPattern(PATTERN_DEFAULT, FIVEMONTHS, "FIVEMONTHS", false);
        addPattern(PATTERN_DEFAULT, SIXMONTHS, "SIXMONTHS", false);


        lock(C_SaikansKbn.class);
    }

    private C_SaikansKbn(String value) {
        super(value);
    }

    public static C_SaikansKbn valueOf(String value) {
        return valueOf(C_SaikansKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SaikansKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SaikansKbn.class, patternId, value);
    }
}
