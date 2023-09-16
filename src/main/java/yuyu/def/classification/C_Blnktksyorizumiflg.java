
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ブランク付処理済フラグ クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Blnktksyorizumiflg</td><td colspan="3">ブランク付処理済フラグ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYORIZUMI}</td><td>&quot;1&quot;</td><td>済</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MISYORI}</td><td>&quot;2&quot;</td><td>未</td></tr>
 * </table>
 */
public class C_Blnktksyorizumiflg extends Classification<C_Blnktksyorizumiflg> {

    private static final long serialVersionUID = 1L;


    public static final C_Blnktksyorizumiflg BLNK = new C_Blnktksyorizumiflg("0");

    public static final C_Blnktksyorizumiflg SYORIZUMI = new C_Blnktksyorizumiflg("1");

    public static final C_Blnktksyorizumiflg MISYORI = new C_Blnktksyorizumiflg("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SYORIZUMI, "SYORIZUMI", false);
        addPattern(PATTERN_DEFAULT, MISYORI, "MISYORI", false);


        lock(C_Blnktksyorizumiflg.class);
    }

    private C_Blnktksyorizumiflg(String value) {
        super(value);
    }

    public static C_Blnktksyorizumiflg valueOf(String value) {
        return valueOf(C_Blnktksyorizumiflg.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Blnktksyorizumiflg.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Blnktksyorizumiflg.class, patternId, value);
    }
}
