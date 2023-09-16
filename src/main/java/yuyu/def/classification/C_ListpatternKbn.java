
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * リストパターン区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_ListpatternKbn</td><td colspan="3">リストパターン区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="10">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #LIST}</td><td>&quot;0&quot;</td><td>リスト表示最大行数</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BM}</td><td>&quot;1&quot;</td><td>病名</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NI}</td><td>&quot;2&quot;</td><td>入院</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SJ}</td><td>&quot;3&quot;</td><td>手術</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TI}</td><td>&quot;4&quot;</td><td>通院</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UT}</td><td>&quot;5&quot;</td><td>受付</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SNSN}</td><td>&quot;6&quot;</td><td>先進医療</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SHRDETAIL}</td><td>&quot;7&quot;</td><td>支払明細</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYUTRY}</td><td>&quot;8&quot;</td><td>腫瘍用薬治療</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GANSNDNKH}</td><td>&quot;9&quot;</td><td>がん診断給付</td></tr>
 * </table>
 */
public class C_ListpatternKbn extends Classification<C_ListpatternKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_ListpatternKbn LIST = new C_ListpatternKbn("0");

    public static final C_ListpatternKbn BM = new C_ListpatternKbn("1");

    public static final C_ListpatternKbn NI = new C_ListpatternKbn("2");

    public static final C_ListpatternKbn SJ = new C_ListpatternKbn("3");

    public static final C_ListpatternKbn TI = new C_ListpatternKbn("4");

    public static final C_ListpatternKbn UT = new C_ListpatternKbn("5");

    public static final C_ListpatternKbn SNSN = new C_ListpatternKbn("6");

    public static final C_ListpatternKbn SHRDETAIL = new C_ListpatternKbn("7");

    public static final C_ListpatternKbn SYUTRY = new C_ListpatternKbn("8");

    public static final C_ListpatternKbn GANSNDNKH = new C_ListpatternKbn("9");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, LIST, "LIST", true);
        addPattern(PATTERN_DEFAULT, BM, "BM", false);
        addPattern(PATTERN_DEFAULT, NI, "NI", false);
        addPattern(PATTERN_DEFAULT, SJ, "SJ", false);
        addPattern(PATTERN_DEFAULT, TI, "TI", false);
        addPattern(PATTERN_DEFAULT, UT, "UT", false);
        addPattern(PATTERN_DEFAULT, SNSN, "SNSN", false);
        addPattern(PATTERN_DEFAULT, SHRDETAIL, "SHRDETAIL", false);
        addPattern(PATTERN_DEFAULT, SYUTRY, "SYUTRY", false);
        addPattern(PATTERN_DEFAULT, GANSNDNKH, "GANSNDNKH", false);


        lock(C_ListpatternKbn.class);
    }

    private C_ListpatternKbn(String value) {
        super(value);
    }

    public static C_ListpatternKbn valueOf(String value) {
        return valueOf(C_ListpatternKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_ListpatternKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_ListpatternKbn.class, patternId, value);
    }
}
