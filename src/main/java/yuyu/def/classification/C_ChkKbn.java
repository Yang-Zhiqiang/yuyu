
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * チェック区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_ChkKbn</td><td colspan="3">チェック区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="8">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MASK}</td><td>&quot;1&quot;</td><td>正規表現（x）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #REQUIRED}</td><td>&quot;2&quot;</td><td>必須</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NUM}</td><td>&quot;3&quot;</td><td>数字</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ALPHA_NUM}</td><td>&quot;4&quot;</td><td>英数字</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #LEN}</td><td>&quot;5&quot;</td><td>文字列長（n）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MIN_LEN}</td><td>&quot;6&quot;</td><td>最小文字列長（n）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAX_LEN}</td><td>&quot;7&quot;</td><td>最大文字列長（n）</td></tr>
 * </table>
 */
public class C_ChkKbn extends Classification<C_ChkKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_ChkKbn NONE = new C_ChkKbn("0");

    public static final C_ChkKbn MASK = new C_ChkKbn("1");

    public static final C_ChkKbn REQUIRED = new C_ChkKbn("2");

    public static final C_ChkKbn NUM = new C_ChkKbn("3");

    public static final C_ChkKbn ALPHA_NUM = new C_ChkKbn("4");

    public static final C_ChkKbn LEN = new C_ChkKbn("5");

    public static final C_ChkKbn MIN_LEN = new C_ChkKbn("6");

    public static final C_ChkKbn MAX_LEN = new C_ChkKbn("7");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NONE, "NONE", true);
        addPattern(PATTERN_DEFAULT, MASK, "MASK", false);
        addPattern(PATTERN_DEFAULT, REQUIRED, "REQUIRED", false);
        addPattern(PATTERN_DEFAULT, NUM, "NUM", false);
        addPattern(PATTERN_DEFAULT, ALPHA_NUM, "ALPHA_NUM", false);
        addPattern(PATTERN_DEFAULT, LEN, "LEN", false);
        addPattern(PATTERN_DEFAULT, MIN_LEN, "MIN_LEN", false);
        addPattern(PATTERN_DEFAULT, MAX_LEN, "MAX_LEN", false);


        lock(C_ChkKbn.class);
    }

    private C_ChkKbn(String value) {
        super(value);
    }

    public static C_ChkKbn valueOf(String value) {
        return valueOf(C_ChkKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_ChkKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_ChkKbn.class, patternId, value);
    }
}
