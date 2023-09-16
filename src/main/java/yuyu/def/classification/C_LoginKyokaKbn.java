
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ログイン許可区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_LoginKyokaKbn</td><td colspan="3">ログイン許可区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #KYOKA}</td><td>&quot;1&quot;</td><td>許可する</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NONE}</td><td>&quot;2&quot;</td><td>許可しない</td></tr>
 * </table>
 */
public class C_LoginKyokaKbn extends Classification<C_LoginKyokaKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_LoginKyokaKbn KYOKA = new C_LoginKyokaKbn("1");

    public static final C_LoginKyokaKbn NONE = new C_LoginKyokaKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, KYOKA, "KYOKA", true);
        addPattern(PATTERN_DEFAULT, NONE, "NONE", false);


        lock(C_LoginKyokaKbn.class);
    }

    private C_LoginKyokaKbn(String value) {
        super(value);
    }

    public static C_LoginKyokaKbn valueOf(String value) {
        return valueOf(C_LoginKyokaKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_LoginKyokaKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_LoginKyokaKbn.class, patternId, value);
    }
}
