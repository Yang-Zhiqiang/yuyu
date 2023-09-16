
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 取扱代理店区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TratkidrtenKbn</td><td colspan="3">取扱代理店区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SINKIN}</td><td>&quot;1&quot;</td><td>信用金庫</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOKAISYA_DRTEN}</td><td>&quot;2&quot;</td><td>子会社もしくは別働体代理店</td></tr>
 * </table>
 */
public class C_TratkidrtenKbn extends Classification<C_TratkidrtenKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TratkidrtenKbn BLNK = new C_TratkidrtenKbn("0");

    public static final C_TratkidrtenKbn SINKIN = new C_TratkidrtenKbn("1");

    public static final C_TratkidrtenKbn KOKAISYA_DRTEN = new C_TratkidrtenKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SINKIN, "SINKIN", false);
        addPattern(PATTERN_DEFAULT, KOKAISYA_DRTEN, "KOKAISYA_DRTEN", false);


        lock(C_TratkidrtenKbn.class);
    }

    private C_TratkidrtenKbn(String value) {
        super(value);
    }

    public static C_TratkidrtenKbn valueOf(String value) {
        return valueOf(C_TratkidrtenKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TratkidrtenKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TratkidrtenKbn.class, patternId, value);
    }
}
