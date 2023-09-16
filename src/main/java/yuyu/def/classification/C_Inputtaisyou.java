
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 入力対象区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Inputtaisyou</td><td colspan="3">入力対象区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #INPUT}</td><td>&quot;1&quot;</td><td>入力する</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NONE}</td><td>&quot;2&quot;</td><td>入力しない</td></tr>
 * </table>
 */
public class C_Inputtaisyou extends Classification<C_Inputtaisyou> {

    private static final long serialVersionUID = 1L;


    public static final C_Inputtaisyou BLNK = new C_Inputtaisyou("0");

    public static final C_Inputtaisyou INPUT = new C_Inputtaisyou("1");

    public static final C_Inputtaisyou NONE = new C_Inputtaisyou("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, INPUT, "INPUT", false);
        addPattern(PATTERN_DEFAULT, NONE, "NONE", false);


        lock(C_Inputtaisyou.class);
    }

    private C_Inputtaisyou(String value) {
        super(value);
    }

    public static C_Inputtaisyou valueOf(String value) {
        return valueOf(C_Inputtaisyou.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Inputtaisyou.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Inputtaisyou.class, patternId, value);
    }
}
