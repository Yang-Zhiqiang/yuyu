
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 入力形式区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Inputtype</td><td colspan="3">入力形式区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #TEXT}</td><td>&quot;0&quot;</td><td>テキスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YMD}</td><td>&quot;1&quot;</td><td>年月日</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UMUCHK}</td><td>&quot;2&quot;</td><td>有無チェック</td></tr>
 * </table>
 */
public class C_Inputtype extends Classification<C_Inputtype> {

    private static final long serialVersionUID = 1L;


    public static final C_Inputtype TEXT = new C_Inputtype("0");

    public static final C_Inputtype YMD = new C_Inputtype("1");

    public static final C_Inputtype UMUCHK = new C_Inputtype("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, TEXT, "TEXT", true);
        addPattern(PATTERN_DEFAULT, YMD, "YMD", false);
        addPattern(PATTERN_DEFAULT, UMUCHK, "UMUCHK", false);


        lock(C_Inputtype.class);
    }

    private C_Inputtype(String value) {
        super(value);
    }

    public static C_Inputtype valueOf(String value) {
        return valueOf(C_Inputtype.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Inputtype.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Inputtype.class, patternId, value);
    }
}
