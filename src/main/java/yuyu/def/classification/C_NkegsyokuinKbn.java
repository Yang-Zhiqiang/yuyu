
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 内勤営業職員区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_NkegsyokuinKbn</td><td colspan="3">内勤営業職員区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NAIKINSYOKUIN}</td><td>&quot;1&quot;</td><td>内勤職員</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #EIGYOUSYOKUIN}</td><td>&quot;2&quot;</td><td>営業職員</td></tr>
 * </table>
 */
public class C_NkegsyokuinKbn extends Classification<C_NkegsyokuinKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_NkegsyokuinKbn BLNK = new C_NkegsyokuinKbn("0");

    public static final C_NkegsyokuinKbn NAIKINSYOKUIN = new C_NkegsyokuinKbn("1");

    public static final C_NkegsyokuinKbn EIGYOUSYOKUIN = new C_NkegsyokuinKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, NAIKINSYOKUIN, "NAIKINSYOKUIN", false);
        addPattern(PATTERN_DEFAULT, EIGYOUSYOKUIN, "EIGYOUSYOKUIN", false);


        lock(C_NkegsyokuinKbn.class);
    }

    private C_NkegsyokuinKbn(String value) {
        super(value);
    }

    public static C_NkegsyokuinKbn valueOf(String value) {
        return valueOf(C_NkegsyokuinKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_NkegsyokuinKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_NkegsyokuinKbn.class, patternId, value);
    }
}
