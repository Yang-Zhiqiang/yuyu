
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 機関担当区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KikantantouKbn</td><td colspan="3">機関担当区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KIKANTANTOU1}</td><td>&quot;1&quot;</td><td>支部(所)長以外で支部(所)を担当</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KIKANTANTOU2}</td><td>&quot;2&quot;</td><td>営業職員で副支社長、営業センター長、等</td></tr>
 * </table>
 */
public class C_KikantantouKbn extends Classification<C_KikantantouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KikantantouKbn BLNK = new C_KikantantouKbn("0");

    public static final C_KikantantouKbn KIKANTANTOU1 = new C_KikantantouKbn("1");

    public static final C_KikantantouKbn KIKANTANTOU2 = new C_KikantantouKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KIKANTANTOU1, "KIKANTANTOU1", false);
        addPattern(PATTERN_DEFAULT, KIKANTANTOU2, "KIKANTANTOU2", false);


        lock(C_KikantantouKbn.class);
    }

    private C_KikantantouKbn(String value) {
        super(value);
    }

    public static C_KikantantouKbn valueOf(String value) {
        return valueOf(C_KikantantouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KikantantouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KikantantouKbn.class, patternId, value);
    }
}
