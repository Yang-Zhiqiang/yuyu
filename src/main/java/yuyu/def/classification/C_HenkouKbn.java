
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 変更区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HenkouKbn</td><td colspan="3">変更区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>変更しない</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HENKOU}</td><td>&quot;1&quot;</td><td>変更する</td></tr>
 * </table>
 */
public class C_HenkouKbn extends Classification<C_HenkouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HenkouKbn NONE = new C_HenkouKbn("0");

    public static final C_HenkouKbn HENKOU = new C_HenkouKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NONE, "NONE", true);
        addPattern(PATTERN_DEFAULT, HENKOU, "HENKOU", false);


        lock(C_HenkouKbn.class);
    }

    private C_HenkouKbn(String value) {
        super(value);
    }

    public static C_HenkouKbn valueOf(String value) {
        return valueOf(C_HenkouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HenkouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HenkouKbn.class, patternId, value);
    }
}
