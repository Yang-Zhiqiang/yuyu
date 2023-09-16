
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 取込帳票区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TorikomityhyKbn</td><td colspan="3">取込帳票区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SCANNER}</td><td>&quot;1&quot;</td><td>スキャナ取込帳票</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KIKAI}</td><td>&quot;2&quot;</td><td>機械取込帳票</td></tr>
 * </table>
 */
public class C_TorikomityhyKbn extends Classification<C_TorikomityhyKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TorikomityhyKbn BLNK = new C_TorikomityhyKbn("0");

    public static final C_TorikomityhyKbn SCANNER = new C_TorikomityhyKbn("1");

    public static final C_TorikomityhyKbn KIKAI = new C_TorikomityhyKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SCANNER, "SCANNER", false);
        addPattern(PATTERN_DEFAULT, KIKAI, "KIKAI", false);


        lock(C_TorikomityhyKbn.class);
    }

    private C_TorikomityhyKbn(String value) {
        super(value);
    }

    public static C_TorikomityhyKbn valueOf(String value) {
        return valueOf(C_TorikomityhyKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TorikomityhyKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TorikomityhyKbn.class, patternId, value);
    }
}
