
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 顧客使用区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KoksiyouKbn</td><td colspan="3">顧客使用区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>許可しない</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYOKA}</td><td>&quot;1&quot;</td><td>許可する</td></tr>
 * </table>
 */
public class C_KoksiyouKbn extends Classification<C_KoksiyouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KoksiyouKbn NONE = new C_KoksiyouKbn("0");

    public static final C_KoksiyouKbn KYOKA = new C_KoksiyouKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NONE, "NONE", true);
        addPattern(PATTERN_DEFAULT, KYOKA, "KYOKA", false);


        lock(C_KoksiyouKbn.class);
    }

    private C_KoksiyouKbn(String value) {
        super(value);
    }

    public static C_KoksiyouKbn valueOf(String value) {
        return valueOf(C_KoksiyouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KoksiyouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KoksiyouKbn.class, patternId, value);
    }
}
