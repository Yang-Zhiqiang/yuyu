
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 売上送信区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_UriagesousinKbn</td><td colspan="3">売上送信区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SOUSINMATI}</td><td>&quot;1&quot;</td><td>送信待ち</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SOUSINZUMI}</td><td>&quot;2&quot;</td><td>送信済み</td></tr>
 * </table>
 */
public class C_UriagesousinKbn extends Classification<C_UriagesousinKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_UriagesousinKbn BLNK = new C_UriagesousinKbn("0");

    public static final C_UriagesousinKbn SOUSINMATI = new C_UriagesousinKbn("1");

    public static final C_UriagesousinKbn SOUSINZUMI = new C_UriagesousinKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SOUSINMATI, "SOUSINMATI", false);
        addPattern(PATTERN_DEFAULT, SOUSINZUMI, "SOUSINZUMI", false);


        lock(C_UriagesousinKbn.class);
    }

    private C_UriagesousinKbn(String value) {
        super(value);
    }

    public static C_UriagesousinKbn valueOf(String value) {
        return valueOf(C_UriagesousinKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_UriagesousinKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_UriagesousinKbn.class, patternId, value);
    }
}
