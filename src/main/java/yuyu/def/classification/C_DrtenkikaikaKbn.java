
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 代理店機械化区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_DrtenkikaikaKbn</td><td colspan="3">代理店機械化区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SUMI}</td><td>&quot;1&quot;</td><td>機械化済</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HAND}</td><td>&quot;2&quot;</td><td>ハンド</td></tr>
 * </table>
 */
public class C_DrtenkikaikaKbn extends Classification<C_DrtenkikaikaKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_DrtenkikaikaKbn BLNK = new C_DrtenkikaikaKbn("0");

    public static final C_DrtenkikaikaKbn SUMI = new C_DrtenkikaikaKbn("1");

    public static final C_DrtenkikaikaKbn HAND = new C_DrtenkikaikaKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SUMI, "SUMI", false);
        addPattern(PATTERN_DEFAULT, HAND, "HAND", false);


        lock(C_DrtenkikaikaKbn.class);
    }

    private C_DrtenkikaikaKbn(String value) {
        super(value);
    }

    public static C_DrtenkikaikaKbn valueOf(String value) {
        return valueOf(C_DrtenkikaikaKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_DrtenkikaikaKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_DrtenkikaikaKbn.class, patternId, value);
    }
}
