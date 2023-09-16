
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 曜日区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_YoubiKbn</td><td colspan="3">曜日区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="7">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #SUNDAY}</td><td>&quot;Sunday&quot;</td><td>日曜日</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MONDAY}</td><td>&quot;Monday&quot;</td><td>月曜日</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TUESDAY}</td><td>&quot;Tuesday&quot;</td><td>火曜日</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #WEDNESDAY}</td><td>&quot;Wednesday&quot;</td><td>水曜日</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #THURSDAY}</td><td>&quot;Thursday&quot;</td><td>木曜日</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FRIDAY}</td><td>&quot;Friday&quot;</td><td>金曜日</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SATURDAY}</td><td>&quot;Saturday&quot;</td><td>土曜日</td></tr>
 * </table>
 */
public class C_YoubiKbn extends Classification<C_YoubiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_YoubiKbn SUNDAY = new C_YoubiKbn("Sunday");

    public static final C_YoubiKbn MONDAY = new C_YoubiKbn("Monday");

    public static final C_YoubiKbn TUESDAY = new C_YoubiKbn("Tuesday");

    public static final C_YoubiKbn WEDNESDAY = new C_YoubiKbn("Wednesday");

    public static final C_YoubiKbn THURSDAY = new C_YoubiKbn("Thursday");

    public static final C_YoubiKbn FRIDAY = new C_YoubiKbn("Friday");

    public static final C_YoubiKbn SATURDAY = new C_YoubiKbn("Saturday");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, SUNDAY, "SUNDAY", true);
        addPattern(PATTERN_DEFAULT, MONDAY, "MONDAY", false);
        addPattern(PATTERN_DEFAULT, TUESDAY, "TUESDAY", false);
        addPattern(PATTERN_DEFAULT, WEDNESDAY, "WEDNESDAY", false);
        addPattern(PATTERN_DEFAULT, THURSDAY, "THURSDAY", false);
        addPattern(PATTERN_DEFAULT, FRIDAY, "FRIDAY", false);
        addPattern(PATTERN_DEFAULT, SATURDAY, "SATURDAY", false);


        lock(C_YoubiKbn.class);
    }

    private C_YoubiKbn(String value) {
        super(value);
    }

    public static C_YoubiKbn valueOf(String value) {
        return valueOf(C_YoubiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_YoubiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_YoubiKbn.class, patternId, value);
    }
}
