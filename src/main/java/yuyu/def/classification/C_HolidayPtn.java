
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 休日パターン クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HolidayPtn</td><td colspan="3">休日パターン</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="9">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #EVERY_WEEK}</td><td>&quot;EveryWeek&quot;</td><td>曜日</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OTHER_HOLIDAYGROUP}</td><td>&quot;OtherHolidayGroup&quot;</td><td>休日グループ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SPECIFIC_DAY}</td><td>&quot;SpecificDay&quot;</td><td>年月日</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SPECIFIC_DAYEVERYYEAR}</td><td>&quot;SpecificDayEveryYear&quot;</td><td>月日</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SPECIFIC_DAYOFWEEK}</td><td>&quot;SpecificDayOfWeek&quot;</td><td>月指定曜日</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #EQUINOX}</td><td>&quot;Equinox&quot;</td><td>秋分春分</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NATIONAL_HOLIDAY}</td><td>&quot;NationalHoliday&quot;</td><td>国民の休日</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SUBSTITUTE_HOLIDAY1}</td><td>&quot;SubstituteHoliday1&quot;</td><td>旧振替休日</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SUBSTITUTE_HOLIDAY2}</td><td>&quot;SubstituteHoliday2&quot;</td><td>新振替休日</td></tr>
 * </table>
 */
public class C_HolidayPtn extends Classification<C_HolidayPtn> {

    private static final long serialVersionUID = 1L;


    public static final C_HolidayPtn EVERY_WEEK = new C_HolidayPtn("EveryWeek");

    public static final C_HolidayPtn OTHER_HOLIDAYGROUP = new C_HolidayPtn("OtherHolidayGroup");

    public static final C_HolidayPtn SPECIFIC_DAY = new C_HolidayPtn("SpecificDay");

    public static final C_HolidayPtn SPECIFIC_DAYEVERYYEAR = new C_HolidayPtn("SpecificDayEveryYear");

    public static final C_HolidayPtn SPECIFIC_DAYOFWEEK = new C_HolidayPtn("SpecificDayOfWeek");

    public static final C_HolidayPtn EQUINOX = new C_HolidayPtn("Equinox");

    public static final C_HolidayPtn NATIONAL_HOLIDAY = new C_HolidayPtn("NationalHoliday");

    public static final C_HolidayPtn SUBSTITUTE_HOLIDAY1 = new C_HolidayPtn("SubstituteHoliday1");

    public static final C_HolidayPtn SUBSTITUTE_HOLIDAY2 = new C_HolidayPtn("SubstituteHoliday2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, EVERY_WEEK, "EVERY_WEEK", true);
        addPattern(PATTERN_DEFAULT, OTHER_HOLIDAYGROUP, "OTHER_HOLIDAYGROUP", false);
        addPattern(PATTERN_DEFAULT, SPECIFIC_DAY, "SPECIFIC_DAY", false);
        addPattern(PATTERN_DEFAULT, SPECIFIC_DAYEVERYYEAR, "SPECIFIC_DAYEVERYYEAR", false);
        addPattern(PATTERN_DEFAULT, SPECIFIC_DAYOFWEEK, "SPECIFIC_DAYOFWEEK", false);
        addPattern(PATTERN_DEFAULT, EQUINOX, "EQUINOX", false);
        addPattern(PATTERN_DEFAULT, NATIONAL_HOLIDAY, "NATIONAL_HOLIDAY", false);
        addPattern(PATTERN_DEFAULT, SUBSTITUTE_HOLIDAY1, "SUBSTITUTE_HOLIDAY1", false);
        addPattern(PATTERN_DEFAULT, SUBSTITUTE_HOLIDAY2, "SUBSTITUTE_HOLIDAY2", false);


        lock(C_HolidayPtn.class);
    }

    private C_HolidayPtn(String value) {
        super(value);
    }

    public static C_HolidayPtn valueOf(String value) {
        return valueOf(C_HolidayPtn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HolidayPtn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HolidayPtn.class, patternId, value);
    }
}
