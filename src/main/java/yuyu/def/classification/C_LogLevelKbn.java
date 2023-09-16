
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ログレベル区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_LogLevelKbn</td><td colspan="3">ログレベル区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #INFO}</td><td>&quot;1&quot;</td><td>情報</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #WARN}</td><td>&quot;2&quot;</td><td>警告</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ERROR}</td><td>&quot;3&quot;</td><td>エラー</td></tr>
 * </table>
 */
public class C_LogLevelKbn extends Classification<C_LogLevelKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_LogLevelKbn INFO = new C_LogLevelKbn("1");

    public static final C_LogLevelKbn WARN = new C_LogLevelKbn("2");

    public static final C_LogLevelKbn ERROR = new C_LogLevelKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, INFO, "INFO", true);
        addPattern(PATTERN_DEFAULT, WARN, "WARN", false);
        addPattern(PATTERN_DEFAULT, ERROR, "ERROR", false);


        lock(C_LogLevelKbn.class);
    }

    private C_LogLevelKbn(String value) {
        super(value);
    }

    public static C_LogLevelKbn valueOf(String value) {
        return valueOf(C_LogLevelKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_LogLevelKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_LogLevelKbn.class, patternId, value);
    }
}
