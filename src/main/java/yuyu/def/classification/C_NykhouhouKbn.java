
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 入金方法区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_NykhouhouKbn</td><td colspan="3">入金方法区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HURIKAE}</td><td>&quot;1&quot;</td><td>振替入金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KARIUKE}</td><td>&quot;2&quot;</td><td>仮受金からの入金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KARIUKEKEIJYOU}</td><td>&quot;3&quot;</td><td>仮受金計上</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_SELECT SELECT}<br />(選択用)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KARIUKE}</td><td>&quot;2&quot;</td><td>仮受金からの入金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KARIUKEKEIJYOU}</td><td>&quot;3&quot;</td><td>仮受金計上</td></tr>
 * </table>
 */
public class C_NykhouhouKbn extends Classification<C_NykhouhouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_NykhouhouKbn BLNK = new C_NykhouhouKbn("0");

    public static final C_NykhouhouKbn HURIKAE = new C_NykhouhouKbn("1");

    public static final C_NykhouhouKbn KARIUKE = new C_NykhouhouKbn("2");

    public static final C_NykhouhouKbn KARIUKEKEIJYOU = new C_NykhouhouKbn("3");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SELECT = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, HURIKAE, "HURIKAE", false);
        addPattern(PATTERN_DEFAULT, KARIUKE, "KARIUKE", false);
        addPattern(PATTERN_DEFAULT, KARIUKEKEIJYOU, "KARIUKEKEIJYOU", false);


        addPattern(PATTERN_SELECT, BLNK, "BLNK", true);
        addPattern(PATTERN_SELECT, KARIUKE, "KARIUKE", false);
        addPattern(PATTERN_SELECT, KARIUKEKEIJYOU, "KARIUKEKEIJYOU", false);


        lock(C_NykhouhouKbn.class);
    }

    private C_NykhouhouKbn(String value) {
        super(value);
    }

    public static C_NykhouhouKbn valueOf(String value) {
        return valueOf(C_NykhouhouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_NykhouhouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_NykhouhouKbn.class, patternId, value);
    }
}
