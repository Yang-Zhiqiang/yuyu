
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 申込経路 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Moskeiro</td><td colspan="3">申込経路</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HONNIN_TYOKU_MOS}</td><td>&quot;1&quot;</td><td>本人直接申込</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUKAI}</td><td>&quot;2&quot;</td><td>紹介</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;3&quot;</td><td>その他</td></tr>
 * </table>
 */
public class C_Moskeiro extends Classification<C_Moskeiro> {

    private static final long serialVersionUID = 1L;


    public static final C_Moskeiro BLNK = new C_Moskeiro("0");

    public static final C_Moskeiro HONNIN_TYOKU_MOS = new C_Moskeiro("1");

    public static final C_Moskeiro SYOUKAI = new C_Moskeiro("2");

    public static final C_Moskeiro SONOTA = new C_Moskeiro("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, HONNIN_TYOKU_MOS, "HONNIN_TYOKU_MOS", false);
        addPattern(PATTERN_DEFAULT, SYOUKAI, "SYOUKAI", false);
        addPattern(PATTERN_DEFAULT, SONOTA, "SONOTA", false);


        lock(C_Moskeiro.class);
    }

    private C_Moskeiro(String value) {
        super(value);
    }

    public static C_Moskeiro valueOf(String value) {
        return valueOf(C_Moskeiro.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Moskeiro.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Moskeiro.class, patternId, value);
    }
}
