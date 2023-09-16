
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 情報系特約分類区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_InfotkbunruiKbn</td><td colspan="3">情報系特約分類区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="9">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MARUGANHYJ}</td><td>&quot;1&quot;</td><td>マルがん表示</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MARUJYOHYJ}</td><td>&quot;2&quot;</td><td>マル女表示</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MARUSEIHYJ}</td><td>&quot;3&quot;</td><td>マル生表示</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MARUSINHYJ}</td><td>&quot;4&quot;</td><td>マル進表示</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MARUSYUHYJ}</td><td>&quot;5&quot;</td><td>マル手表示</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MARUDANHYJ}</td><td>&quot;6&quot;</td><td>マル断表示</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MARUKOUHYJ}</td><td>&quot;7&quot;</td><td>マル抗表示</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SANDAISIPHYJ}</td><td>&quot;8&quot;</td><td>３大疾病表示</td></tr>
 * </table>
 */
public class C_InfotkbunruiKbn extends Classification<C_InfotkbunruiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_InfotkbunruiKbn NONE = new C_InfotkbunruiKbn("0");

    public static final C_InfotkbunruiKbn MARUGANHYJ = new C_InfotkbunruiKbn("1");

    public static final C_InfotkbunruiKbn MARUJYOHYJ = new C_InfotkbunruiKbn("2");

    public static final C_InfotkbunruiKbn MARUSEIHYJ = new C_InfotkbunruiKbn("3");

    public static final C_InfotkbunruiKbn MARUSINHYJ = new C_InfotkbunruiKbn("4");

    public static final C_InfotkbunruiKbn MARUSYUHYJ = new C_InfotkbunruiKbn("5");

    public static final C_InfotkbunruiKbn MARUDANHYJ = new C_InfotkbunruiKbn("6");

    public static final C_InfotkbunruiKbn MARUKOUHYJ = new C_InfotkbunruiKbn("7");

    public static final C_InfotkbunruiKbn SANDAISIPHYJ = new C_InfotkbunruiKbn("8");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NONE, "NONE", true);
        addPattern(PATTERN_DEFAULT, MARUGANHYJ, "MARUGANHYJ", false);
        addPattern(PATTERN_DEFAULT, MARUJYOHYJ, "MARUJYOHYJ", false);
        addPattern(PATTERN_DEFAULT, MARUSEIHYJ, "MARUSEIHYJ", false);
        addPattern(PATTERN_DEFAULT, MARUSINHYJ, "MARUSINHYJ", false);
        addPattern(PATTERN_DEFAULT, MARUSYUHYJ, "MARUSYUHYJ", false);
        addPattern(PATTERN_DEFAULT, MARUDANHYJ, "MARUDANHYJ", false);
        addPattern(PATTERN_DEFAULT, MARUKOUHYJ, "MARUKOUHYJ", false);
        addPattern(PATTERN_DEFAULT, SANDAISIPHYJ, "SANDAISIPHYJ", false);


        lock(C_InfotkbunruiKbn.class);
    }

    private C_InfotkbunruiKbn(String value) {
        super(value);
    }

    public static C_InfotkbunruiKbn valueOf(String value) {
        return valueOf(C_InfotkbunruiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_InfotkbunruiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_InfotkbunruiKbn.class, patternId, value);
    }
}
