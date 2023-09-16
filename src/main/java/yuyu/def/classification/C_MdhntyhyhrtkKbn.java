
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 窓販帳票配列区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_MdhntyhyhrtkKbn</td><td colspan="3">窓販帳票配列区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MADHAIRETU1}</td><td>&quot;1&quot;</td><td>窓販帳票配列１</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MADHAIRETU2}</td><td>&quot;2&quot;</td><td>窓販帳票配列２</td></tr>
 * </table>
 */
public class C_MdhntyhyhrtkKbn extends Classification<C_MdhntyhyhrtkKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_MdhntyhyhrtkKbn BLNK = new C_MdhntyhyhrtkKbn("0");

    public static final C_MdhntyhyhrtkKbn MADHAIRETU1 = new C_MdhntyhyhrtkKbn("1");

    public static final C_MdhntyhyhrtkKbn MADHAIRETU2 = new C_MdhntyhyhrtkKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, MADHAIRETU1, "MADHAIRETU1", false);
        addPattern(PATTERN_DEFAULT, MADHAIRETU2, "MADHAIRETU2", false);


        lock(C_MdhntyhyhrtkKbn.class);
    }

    private C_MdhntyhyhrtkKbn(String value) {
        super(value);
    }

    public static C_MdhntyhyhrtkKbn valueOf(String value) {
        return valueOf(C_MdhntyhyhrtkKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_MdhntyhyhrtkKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_MdhntyhyhrtkKbn.class, patternId, value);
    }
}
