
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 医事統計用前納区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_IjitoukeiZennouKbn</td><td colspan="3">医事統計用前納区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZENKIZENNOU}</td><td>&quot;1&quot;</td><td>全期前納</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ITIBUZENNOU}</td><td>&quot;2&quot;</td><td>一部前納</td></tr>
 * </table>
 */
public class C_IjitoukeiZennouKbn extends Classification<C_IjitoukeiZennouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_IjitoukeiZennouKbn BLNK = new C_IjitoukeiZennouKbn("0");

    public static final C_IjitoukeiZennouKbn ZENKIZENNOU = new C_IjitoukeiZennouKbn("1");

    public static final C_IjitoukeiZennouKbn ITIBUZENNOU = new C_IjitoukeiZennouKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, ZENKIZENNOU, "ZENKIZENNOU", false);
        addPattern(PATTERN_DEFAULT, ITIBUZENNOU, "ITIBUZENNOU", false);


        lock(C_IjitoukeiZennouKbn.class);
    }

    private C_IjitoukeiZennouKbn(String value) {
        super(value);
    }

    public static C_IjitoukeiZennouKbn valueOf(String value) {
        return valueOf(C_IjitoukeiZennouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_IjitoukeiZennouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_IjitoukeiZennouKbn.class, patternId, value);
    }
}
