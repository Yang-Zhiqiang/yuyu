
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * パスワード状態区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_PasswordJtKbn</td><td colspan="3">パスワード状態区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLANK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KARI}</td><td>&quot;1&quot;</td><td>仮</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HON}</td><td>&quot;2&quot;</td><td>本</td></tr>
 * </table>
 */
public class C_PasswordJtKbn extends Classification<C_PasswordJtKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_PasswordJtKbn BLANK = new C_PasswordJtKbn("0");

    public static final C_PasswordJtKbn KARI = new C_PasswordJtKbn("1");

    public static final C_PasswordJtKbn HON = new C_PasswordJtKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLANK, "BLANK", true);
        addPattern(PATTERN_DEFAULT, KARI, "KARI", false);
        addPattern(PATTERN_DEFAULT, HON, "HON", false);


        lock(C_PasswordJtKbn.class);
    }

    private C_PasswordJtKbn(String value) {
        super(value);
    }

    public static C_PasswordJtKbn valueOf(String value) {
        return valueOf(C_PasswordJtKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_PasswordJtKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_PasswordJtKbn.class, patternId, value);
    }
}
