
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 内包外付特約区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_NaihousotozuketkKbn</td><td colspan="3">内包外付特約区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NAIHOU}</td><td>&quot;1&quot;</td><td>内包</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SOTOZUKE}</td><td>&quot;2&quot;</td><td>外付</td></tr>
 * </table>
 */
public class C_NaihousotozuketkKbn extends Classification<C_NaihousotozuketkKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_NaihousotozuketkKbn BLNK = new C_NaihousotozuketkKbn("0");

    public static final C_NaihousotozuketkKbn NAIHOU = new C_NaihousotozuketkKbn("1");

    public static final C_NaihousotozuketkKbn SOTOZUKE = new C_NaihousotozuketkKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, NAIHOU, "NAIHOU", false);
        addPattern(PATTERN_DEFAULT, SOTOZUKE, "SOTOZUKE", false);


        lock(C_NaihousotozuketkKbn.class);
    }

    private C_NaihousotozuketkKbn(String value) {
        super(value);
    }

    public static C_NaihousotozuketkKbn valueOf(String value) {
        return valueOf(C_NaihousotozuketkKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_NaihousotozuketkKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_NaihousotozuketkKbn.class, patternId, value);
    }
}
