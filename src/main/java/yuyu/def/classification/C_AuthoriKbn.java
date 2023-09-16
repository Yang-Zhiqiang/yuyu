
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * オーソリ区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_AuthoriKbn</td><td colspan="3">オーソリ区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AUTHORINASI}</td><td>&quot;1&quot;</td><td>オーソリなし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AUTHORIJISSI}</td><td>&quot;2&quot;</td><td>オーソリ実施</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MOSNAINISITAGAU}</td><td>&quot;3&quot;</td><td>申込内容に従う</td></tr>
 * </table>
 */
public class C_AuthoriKbn extends Classification<C_AuthoriKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_AuthoriKbn BLNK = new C_AuthoriKbn("0");

    public static final C_AuthoriKbn AUTHORINASI = new C_AuthoriKbn("1");

    public static final C_AuthoriKbn AUTHORIJISSI = new C_AuthoriKbn("2");

    public static final C_AuthoriKbn MOSNAINISITAGAU = new C_AuthoriKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, AUTHORINASI, "AUTHORINASI", false);
        addPattern(PATTERN_DEFAULT, AUTHORIJISSI, "AUTHORIJISSI", false);
        addPattern(PATTERN_DEFAULT, MOSNAINISITAGAU, "MOSNAINISITAGAU", false);


        lock(C_AuthoriKbn.class);
    }

    private C_AuthoriKbn(String value) {
        super(value);
    }

    public static C_AuthoriKbn valueOf(String value) {
        return valueOf(C_AuthoriKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_AuthoriKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_AuthoriKbn.class, patternId, value);
    }
}
