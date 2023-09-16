
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * エラー区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_ErrorKbn</td><td colspan="3">エラー区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #OK}</td><td>&quot;0&quot;</td><td>処理ＯＫ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ERROR}</td><td>&quot;1&quot;</td><td>エラー</td></tr>
 * </table>
 */
public class C_ErrorKbn extends Classification<C_ErrorKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_ErrorKbn OK = new C_ErrorKbn("0");

    public static final C_ErrorKbn ERROR = new C_ErrorKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, OK, "OK", true);
        addPattern(PATTERN_DEFAULT, ERROR, "ERROR", false);


        lock(C_ErrorKbn.class);
    }

    private C_ErrorKbn(String value) {
        super(value);
    }

    public static C_ErrorKbn valueOf(String value) {
        return valueOf(C_ErrorKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_ErrorKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_ErrorKbn.class, patternId, value);
    }
}
