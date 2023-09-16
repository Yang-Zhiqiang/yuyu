
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 年金原資区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_NkGnsKbn</td><td colspan="3">年金原資区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;00&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SHUV}</td><td>&quot;01&quot;</td><td>主契約Ｖ</td></tr>
 * </table>
 */
public class C_NkGnsKbn extends Classification<C_NkGnsKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_NkGnsKbn BLNK = new C_NkGnsKbn("00");

    public static final C_NkGnsKbn SHUV = new C_NkGnsKbn("01");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SHUV, "SHUV", false);


        lock(C_NkGnsKbn.class);
    }

    private C_NkGnsKbn(String value) {
        super(value);
    }

    public static C_NkGnsKbn valueOf(String value) {
        return valueOf(C_NkGnsKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_NkGnsKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_NkGnsKbn.class, patternId, value);
    }
}
