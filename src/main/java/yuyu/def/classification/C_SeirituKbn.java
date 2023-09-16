
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 成立区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SeirituKbn</td><td colspan="3">成立区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;99&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>未成立</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEIRITU}</td><td>&quot;1&quot;</td><td>成立</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ITIPMATI}</td><td>&quot;2&quot;</td><td>１Ｐ待ち成立</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUSEIRITU}</td><td>&quot;3&quot;</td><td>不成立</td></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_SELECT SELECT}<br />(選択)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;99&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>未成立</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEIRITU}</td><td>&quot;1&quot;</td><td>成立</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUSEIRITU}</td><td>&quot;3&quot;</td><td>不成立</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_SKSTYJKSYOUKAI SKSTYJKSYOUKAI}<br />(進捗状況照会用)</td><td align="center">&nbsp;</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>未成立</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEIRITU}</td><td>&quot;1&quot;</td><td>成立</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUSEIRITU}</td><td>&quot;3&quot;</td><td>不成立</td></tr>
 * </table>
 */
public class C_SeirituKbn extends Classification<C_SeirituKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SeirituKbn BLNK = new C_SeirituKbn("99");

    public static final C_SeirituKbn NONE = new C_SeirituKbn("0");

    public static final C_SeirituKbn SEIRITU = new C_SeirituKbn("1");

    public static final C_SeirituKbn ITIPMATI = new C_SeirituKbn("2");

    public static final C_SeirituKbn HUSEIRITU = new C_SeirituKbn("3");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SELECT = "2";

    public static final String PATTERN_SKSTYJKSYOUKAI = "3";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, NONE, "NONE", false);
        addPattern(PATTERN_DEFAULT, SEIRITU, "SEIRITU", false);
        addPattern(PATTERN_DEFAULT, ITIPMATI, "ITIPMATI", false);
        addPattern(PATTERN_DEFAULT, HUSEIRITU, "HUSEIRITU", false);


        addPattern(PATTERN_SELECT, BLNK, "BLNK", true);
        addPattern(PATTERN_SELECT, NONE, "NONE", false);
        addPattern(PATTERN_SELECT, SEIRITU, "SEIRITU", false);
        addPattern(PATTERN_SELECT, HUSEIRITU, "HUSEIRITU", false);


        addPattern(PATTERN_SKSTYJKSYOUKAI, NONE, "NONE", false);
        addPattern(PATTERN_SKSTYJKSYOUKAI, SEIRITU, "SEIRITU", false);
        addPattern(PATTERN_SKSTYJKSYOUKAI, HUSEIRITU, "HUSEIRITU", false);


        lock(C_SeirituKbn.class);
    }

    private C_SeirituKbn(String value) {
        super(value);
    }

    public static C_SeirituKbn valueOf(String value) {
        return valueOf(C_SeirituKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SeirituKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SeirituKbn.class, patternId, value);
    }
}
