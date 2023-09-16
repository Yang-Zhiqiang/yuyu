
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＳＰ計算可否区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SpKeisanKahiKbn</td><td colspan="3">ＳＰ計算可否区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #MISETTEI}</td><td>&quot;0&quot;</td><td>未設定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SPKEISANKA}</td><td>&quot;1&quot;</td><td>ＳＰ計算可</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SPKEISANHUKA}</td><td>&quot;2&quot;</td><td>ＳＰ計算不可</td></tr>
 * </table>
 */
public class C_SpKeisanKahiKbn extends Classification<C_SpKeisanKahiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SpKeisanKahiKbn MISETTEI = new C_SpKeisanKahiKbn("0");

    public static final C_SpKeisanKahiKbn SPKEISANKA = new C_SpKeisanKahiKbn("1");

    public static final C_SpKeisanKahiKbn SPKEISANHUKA = new C_SpKeisanKahiKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, MISETTEI, "MISETTEI", true);
        addPattern(PATTERN_DEFAULT, SPKEISANKA, "SPKEISANKA", false);
        addPattern(PATTERN_DEFAULT, SPKEISANHUKA, "SPKEISANHUKA", false);


        lock(C_SpKeisanKahiKbn.class);
    }

    private C_SpKeisanKahiKbn(String value) {
        super(value);
    }

    public static C_SpKeisanKahiKbn valueOf(String value) {
        return valueOf(C_SpKeisanKahiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SpKeisanKahiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SpKeisanKahiKbn.class, patternId, value);
    }
}
