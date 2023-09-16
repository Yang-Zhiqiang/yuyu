
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 許可区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KyokaKbn</td><td colspan="3">許可区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">&nbsp;</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>許可しない</td></tr>
 *  <tr><td align="center">○</td><td>{@link #KYOKA}</td><td>&quot;1&quot;</td><td>許可する</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_PASSWORD PASSWORD}<br />(パスワード変更許可)</td><td align="center">&nbsp;</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>変更不可</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYOKA}</td><td>&quot;1&quot;</td><td>変更可</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_LOGIN LOGIN}<br />(ログイン許可)</td><td align="center">&nbsp;</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>ログイン不可</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYOKA}</td><td>&quot;1&quot;</td><td>ログイン可</td></tr>
 * </table>
 */
public class C_KyokaKbn extends Classification<C_KyokaKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KyokaKbn NONE = new C_KyokaKbn("0");

    public static final C_KyokaKbn KYOKA = new C_KyokaKbn("1");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_PASSWORD = "2";

    public static final String PATTERN_LOGIN = "3";


    static {

        addPattern(PATTERN_DEFAULT, NONE, "NONE", false);
        addPattern(PATTERN_DEFAULT, KYOKA, "KYOKA", true);


        addPattern(PATTERN_PASSWORD, NONE, "NONE", false);
        addPattern(PATTERN_PASSWORD, KYOKA, "KYOKA", false);


        addPattern(PATTERN_LOGIN, NONE, "NONE", false);
        addPattern(PATTERN_LOGIN, KYOKA, "KYOKA", false);


        lock(C_KyokaKbn.class);
    }

    private C_KyokaKbn(String value) {
        super(value);
    }

    public static C_KyokaKbn valueOf(String value) {
        return valueOf(C_KyokaKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KyokaKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KyokaKbn.class, patternId, value);
    }
}
