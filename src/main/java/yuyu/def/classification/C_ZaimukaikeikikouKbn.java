
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 財務会計機構区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_ZaimukaikeikikouKbn</td><td colspan="3">財務会計機構区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HONSYA}</td><td>&quot;1&quot;</td><td>本社</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOKYOHONSYA}</td><td>&quot;2&quot;</td><td>東京本社</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SISYA}</td><td>&quot;3&quot;</td><td>支社</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JIMUSYO}</td><td>&quot;4&quot;</td><td>駐在員事務所</td></tr>
 * </table>
 */
public class C_ZaimukaikeikikouKbn extends Classification<C_ZaimukaikeikikouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_ZaimukaikeikikouKbn BLNK = new C_ZaimukaikeikikouKbn("0");

    public static final C_ZaimukaikeikikouKbn HONSYA = new C_ZaimukaikeikikouKbn("1");

    public static final C_ZaimukaikeikikouKbn TOKYOHONSYA = new C_ZaimukaikeikikouKbn("2");

    public static final C_ZaimukaikeikikouKbn SISYA = new C_ZaimukaikeikikouKbn("3");

    public static final C_ZaimukaikeikikouKbn JIMUSYO = new C_ZaimukaikeikikouKbn("4");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, HONSYA, "HONSYA", false);
        addPattern(PATTERN_DEFAULT, TOKYOHONSYA, "TOKYOHONSYA", false);
        addPattern(PATTERN_DEFAULT, SISYA, "SISYA", false);
        addPattern(PATTERN_DEFAULT, JIMUSYO, "JIMUSYO", false);


        lock(C_ZaimukaikeikikouKbn.class);
    }

    private C_ZaimukaikeikikouKbn(String value) {
        super(value);
    }

    public static C_ZaimukaikeikikouKbn valueOf(String value) {
        return valueOf(C_ZaimukaikeikikouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_ZaimukaikeikikouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_ZaimukaikeikikouKbn.class, patternId, value);
    }
}
