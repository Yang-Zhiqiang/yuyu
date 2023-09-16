
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ロック区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_LockKbn</td><td colspan="3">ロック区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #LOCK_OK}</td><td>&quot;0&quot;</td><td>ロック成功</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #LOCK_NG}</td><td>&quot;1&quot;</td><td>ロック失敗</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #LOCK_OTHER}</td><td>&quot;2&quot;</td><td>他者ロック中</td></tr>
 * </table>
 */
public class C_LockKbn extends Classification<C_LockKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_LockKbn LOCK_OK = new C_LockKbn("0");

    public static final C_LockKbn LOCK_NG = new C_LockKbn("1");

    public static final C_LockKbn LOCK_OTHER = new C_LockKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, LOCK_OK, "LOCK_OK", true);
        addPattern(PATTERN_DEFAULT, LOCK_NG, "LOCK_NG", false);
        addPattern(PATTERN_DEFAULT, LOCK_OTHER, "LOCK_OTHER", false);


        lock(C_LockKbn.class);
    }

    private C_LockKbn(String value) {
        super(value);
    }

    public static C_LockKbn valueOf(String value) {
        return valueOf(C_LockKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_LockKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_LockKbn.class, patternId, value);
    }
}
