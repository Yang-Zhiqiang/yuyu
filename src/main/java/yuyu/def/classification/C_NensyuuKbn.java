
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 年収区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_NensyuuKbn</td><td colspan="3">年収区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UNDER300}</td><td>&quot;1&quot;</td><td>３００万円未満</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UNDER500}</td><td>&quot;2&quot;</td><td>３００～５００万円未満</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UNDER700}</td><td>&quot;3&quot;</td><td>５００～７００万円未満</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UNDER1000}</td><td>&quot;4&quot;</td><td>７００～１０００万円未満</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MORETHAN1000}</td><td>&quot;5&quot;</td><td>１０００万円以上</td></tr>
 * </table>
 */
public class C_NensyuuKbn extends Classification<C_NensyuuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_NensyuuKbn BLNK = new C_NensyuuKbn("0");

    public static final C_NensyuuKbn UNDER300 = new C_NensyuuKbn("1");

    public static final C_NensyuuKbn UNDER500 = new C_NensyuuKbn("2");

    public static final C_NensyuuKbn UNDER700 = new C_NensyuuKbn("3");

    public static final C_NensyuuKbn UNDER1000 = new C_NensyuuKbn("4");

    public static final C_NensyuuKbn MORETHAN1000 = new C_NensyuuKbn("5");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, UNDER300, "UNDER300", false);
        addPattern(PATTERN_DEFAULT, UNDER500, "UNDER500", false);
        addPattern(PATTERN_DEFAULT, UNDER700, "UNDER700", false);
        addPattern(PATTERN_DEFAULT, UNDER1000, "UNDER1000", false);
        addPattern(PATTERN_DEFAULT, MORETHAN1000, "MORETHAN1000", false);


        lock(C_NensyuuKbn.class);
    }

    private C_NensyuuKbn(String value) {
        super(value);
    }

    public static C_NensyuuKbn valueOf(String value) {
        return valueOf(C_NensyuuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_NensyuuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_NensyuuKbn.class, patternId, value);
    }
}
