
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ロックアウト区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_LockoutKbn</td><td colspan="3">ロックアウト区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #LOCKOUT_NONE}</td><td>&quot;0&quot;</td><td>ロックアウトしない</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #LOCKOUT_ARI}</td><td>&quot;1&quot;</td><td>ロックアウトする</td></tr>
 * </table>
 */
public class C_LockoutKbn extends Classification<C_LockoutKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_LockoutKbn LOCKOUT_NONE = new C_LockoutKbn("0");

    public static final C_LockoutKbn LOCKOUT_ARI = new C_LockoutKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, LOCKOUT_NONE, "LOCKOUT_NONE", true);
        addPattern(PATTERN_DEFAULT, LOCKOUT_ARI, "LOCKOUT_ARI", false);


        lock(C_LockoutKbn.class);
    }

    private C_LockoutKbn(String value) {
        super(value);
    }

    public static C_LockoutKbn valueOf(String value) {
        return valueOf(C_LockoutKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_LockoutKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_LockoutKbn.class, patternId, value);
    }
}
