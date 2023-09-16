
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 処理経由区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Syorikeiyu</td><td colspan="3">処理経由区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #INPUT}</td><td>&quot;1&quot;</td><td>入力選択画面経由</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ITIRAN}</td><td>&quot;2&quot;</td><td>一覧選択画面経由</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KEYINPUT}</td><td>&quot;3&quot;</td><td>キー入力画面経由</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SRCH}</td><td>&quot;4&quot;</td><td>検索結果画面経由</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #INPUTCONTENTS}</td><td>&quot;5&quot;</td><td>内容入力画面経由</td></tr>
 * </table>
 */
public class C_Syorikeiyu extends Classification<C_Syorikeiyu> {

    private static final long serialVersionUID = 1L;


    public static final C_Syorikeiyu BLNK = new C_Syorikeiyu("0");

    public static final C_Syorikeiyu INPUT = new C_Syorikeiyu("1");

    public static final C_Syorikeiyu ITIRAN = new C_Syorikeiyu("2");

    public static final C_Syorikeiyu KEYINPUT = new C_Syorikeiyu("3");

    public static final C_Syorikeiyu SRCH = new C_Syorikeiyu("4");

    public static final C_Syorikeiyu INPUTCONTENTS = new C_Syorikeiyu("5");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, INPUT, "INPUT", false);
        addPattern(PATTERN_DEFAULT, ITIRAN, "ITIRAN", false);
        addPattern(PATTERN_DEFAULT, KEYINPUT, "KEYINPUT", false);
        addPattern(PATTERN_DEFAULT, SRCH, "SRCH", false);
        addPattern(PATTERN_DEFAULT, INPUTCONTENTS, "INPUTCONTENTS", false);


        lock(C_Syorikeiyu.class);
    }

    private C_Syorikeiyu(String value) {
        super(value);
    }

    public static C_Syorikeiyu valueOf(String value) {
        return valueOf(C_Syorikeiyu.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Syorikeiyu.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Syorikeiyu.class, patternId, value);
    }
}
