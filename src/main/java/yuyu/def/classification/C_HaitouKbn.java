
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 配当区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HaitouKbn</td><td colspan="3">配当区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YUUHAI}</td><td>&quot;1&quot;</td><td>有配</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RISAHAI}</td><td>&quot;2&quot;</td><td>利差配</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NONE}</td><td>&quot;3&quot;</td><td>無配当</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_SELECT SELECT}<br />(選択)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NONE}</td><td>&quot;3&quot;</td><td>無配当</td></tr>
 * </table>
 */
public class C_HaitouKbn extends Classification<C_HaitouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HaitouKbn BLNK = new C_HaitouKbn("0");

    public static final C_HaitouKbn YUUHAI = new C_HaitouKbn("1");

    public static final C_HaitouKbn RISAHAI = new C_HaitouKbn("2");

    public static final C_HaitouKbn NONE = new C_HaitouKbn("3");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SELECT = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, YUUHAI, "YUUHAI", false);
        addPattern(PATTERN_DEFAULT, RISAHAI, "RISAHAI", false);
        addPattern(PATTERN_DEFAULT, NONE, "NONE", false);


        addPattern(PATTERN_SELECT, BLNK, "BLNK", true);
        addPattern(PATTERN_SELECT, NONE, "NONE", false);


        lock(C_HaitouKbn.class);
    }

    private C_HaitouKbn(String value) {
        super(value);
    }

    public static C_HaitouKbn valueOf(String value) {
        return valueOf(C_HaitouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HaitouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HaitouKbn.class, patternId, value);
    }
}
