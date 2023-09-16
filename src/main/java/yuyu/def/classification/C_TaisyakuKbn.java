
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 貸借区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TaisyakuKbn</td><td colspan="3">貸借区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KARIKATA}</td><td>&quot;1&quot;</td><td>借方</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KASIKATA}</td><td>&quot;2&quot;</td><td>貸方</td></tr>
 * </table>
 */
public class C_TaisyakuKbn extends Classification<C_TaisyakuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TaisyakuKbn BLNK = new C_TaisyakuKbn("0");

    public static final C_TaisyakuKbn KARIKATA = new C_TaisyakuKbn("1");

    public static final C_TaisyakuKbn KASIKATA = new C_TaisyakuKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KARIKATA, "KARIKATA", false);
        addPattern(PATTERN_DEFAULT, KASIKATA, "KASIKATA", false);


        lock(C_TaisyakuKbn.class);
    }

    private C_TaisyakuKbn(String value) {
        super(value);
    }

    public static C_TaisyakuKbn valueOf(String value) {
        return valueOf(C_TaisyakuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TaisyakuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TaisyakuKbn.class, patternId, value);
    }
}
