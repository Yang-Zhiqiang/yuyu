
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 送信状況区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SousinjkKbn</td><td colspan="3">送信状況区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>未送信</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SOUSINZUMI}</td><td>&quot;1&quot;</td><td>送信済み</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NONE}</td><td>&quot;2&quot;</td><td>指定無し</td></tr>
 * </table>
 */
public class C_SousinjkKbn extends Classification<C_SousinjkKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SousinjkKbn BLNK = new C_SousinjkKbn("0");

    public static final C_SousinjkKbn SOUSINZUMI = new C_SousinjkKbn("1");

    public static final C_SousinjkKbn NONE = new C_SousinjkKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SOUSINZUMI, "SOUSINZUMI", false);
        addPattern(PATTERN_DEFAULT, NONE, "NONE", false);


        lock(C_SousinjkKbn.class);
    }

    private C_SousinjkKbn(String value) {
        super(value);
    }

    public static C_SousinjkKbn valueOf(String value) {
        return valueOf(C_SousinjkKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SousinjkKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SousinjkKbn.class, patternId, value);
    }
}
