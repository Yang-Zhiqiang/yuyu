
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * システム区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SysKbn</td><td colspan="3">システム区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #SKEI}</td><td>&quot;0&quot;</td><td>新契約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ESHIEN}</td><td>&quot;1&quot;</td><td>営業支援</td></tr>
 * </table>
 */
public class C_SysKbn extends Classification<C_SysKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SysKbn SKEI = new C_SysKbn("0");

    public static final C_SysKbn ESHIEN = new C_SysKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, SKEI, "SKEI", true);
        addPattern(PATTERN_DEFAULT, ESHIEN, "ESHIEN", false);


        lock(C_SysKbn.class);
    }

    private C_SysKbn(String value) {
        super(value);
    }

    public static C_SysKbn valueOf(String value) {
        return valueOf(C_SysKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SysKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SysKbn.class, patternId, value);
    }
}
