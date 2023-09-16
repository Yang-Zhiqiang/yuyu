
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 再保種類 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Saihosyurui</td><td colspan="3">再保種類</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NI}</td><td>&quot;1&quot;</td><td>任意</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TK}</td><td>&quot;2&quot;</td><td>特約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #QS}</td><td>&quot;3&quot;</td><td>Ｑ／Ｓ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SP}</td><td>&quot;4&quot;</td><td>サープラス</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #EL}</td><td>&quot;5&quot;</td><td>Ｅｘｃｅｓｓ　Ｌｏｓｓ</td></tr>
 * </table>
 */
public class C_Saihosyurui extends Classification<C_Saihosyurui> {

    private static final long serialVersionUID = 1L;


    public static final C_Saihosyurui NONE = new C_Saihosyurui("0");

    public static final C_Saihosyurui NI = new C_Saihosyurui("1");

    public static final C_Saihosyurui TK = new C_Saihosyurui("2");

    public static final C_Saihosyurui QS = new C_Saihosyurui("3");

    public static final C_Saihosyurui SP = new C_Saihosyurui("4");

    public static final C_Saihosyurui EL = new C_Saihosyurui("5");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NONE, "NONE", true);
        addPattern(PATTERN_DEFAULT, NI, "NI", false);
        addPattern(PATTERN_DEFAULT, TK, "TK", false);
        addPattern(PATTERN_DEFAULT, QS, "QS", false);
        addPattern(PATTERN_DEFAULT, SP, "SP", false);
        addPattern(PATTERN_DEFAULT, EL, "EL", false);


        lock(C_Saihosyurui.class);
    }

    private C_Saihosyurui(String value) {
        super(value);
    }

    public static C_Saihosyurui valueOf(String value) {
        return valueOf(C_Saihosyurui.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Saihosyurui.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Saihosyurui.class, patternId, value);
    }
}
