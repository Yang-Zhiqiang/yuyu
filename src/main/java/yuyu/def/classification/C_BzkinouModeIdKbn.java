
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 業務共通機能モードＩＤ区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_BzkinouModeIdKbn</td><td colspan="3">業務共通機能モードＩＤ区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #DEFAULT}</td><td>&quot;default&quot;</td><td>デフォルト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #INPUT}</td><td>&quot;input&quot;</td><td>入力</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUKAI}</td><td>&quot;syoukai&quot;</td><td>照会</td></tr>
 * </table>
 */
public class C_BzkinouModeIdKbn extends Classification<C_BzkinouModeIdKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_BzkinouModeIdKbn DEFAULT = new C_BzkinouModeIdKbn("default");

    public static final C_BzkinouModeIdKbn INPUT = new C_BzkinouModeIdKbn("input");

    public static final C_BzkinouModeIdKbn SYOUKAI = new C_BzkinouModeIdKbn("syoukai");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, DEFAULT, "DEFAULT", true);
        addPattern(PATTERN_DEFAULT, INPUT, "INPUT", false);
        addPattern(PATTERN_DEFAULT, SYOUKAI, "SYOUKAI", false);


        lock(C_BzkinouModeIdKbn.class);
    }

    private C_BzkinouModeIdKbn(String value) {
        super(value);
    }

    public static C_BzkinouModeIdKbn valueOf(String value) {
        return valueOf(C_BzkinouModeIdKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_BzkinouModeIdKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_BzkinouModeIdKbn.class, patternId, value);
    }
}
