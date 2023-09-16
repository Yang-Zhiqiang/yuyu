
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 処理済フラグ クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Syorizumiflg</td><td colspan="3">処理済フラグ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #MISYORI}</td><td>&quot;0&quot;</td><td>未処理</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYORIZUMI}</td><td>&quot;1&quot;</td><td>処理済</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_SIHARAI SIHARAI}<br />(保険金用)</td><td align="center">○</td><td>{@link #MISYORI}</td><td>&quot;0&quot;</td><td>未</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYORIZUMI}</td><td>&quot;1&quot;</td><td>済</td></tr>
 * </table>
 */
public class C_Syorizumiflg extends Classification<C_Syorizumiflg> {

    private static final long serialVersionUID = 1L;


    public static final C_Syorizumiflg MISYORI = new C_Syorizumiflg("0");

    public static final C_Syorizumiflg SYORIZUMI = new C_Syorizumiflg("1");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SIHARAI = "2";


    static {

        addPattern(PATTERN_DEFAULT, MISYORI, "MISYORI", true);
        addPattern(PATTERN_DEFAULT, SYORIZUMI, "SYORIZUMI", false);


        addPattern(PATTERN_SIHARAI, MISYORI, "MISYORI", true);
        addPattern(PATTERN_SIHARAI, SYORIZUMI, "SYORIZUMI", false);


        lock(C_Syorizumiflg.class);
    }

    private C_Syorizumiflg(String value) {
        super(value);
    }

    public static C_Syorizumiflg valueOf(String value) {
        return valueOf(C_Syorizumiflg.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Syorizumiflg.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Syorizumiflg.class, patternId, value);
    }
}
