package yuyu.app.base.system.holidaytouroku;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_HolidayPtn;
import yuyu.def.classification.C_LegalHolidayKbn;
import yuyu.def.classification.C_SysSiyouKbn;

public class SeleniumHolidayTourokuConstants {

    public static final String NEWHOLIDAYPATTERNNM                      = "休日パターン名１２３４５";
    public static final String NEWHOLIDAYCD                             = "holiday12345";
    public static final C_LegalHolidayKbn NEWHOLIDAYLEGALHOLIDAYKBN     = C_LegalHolidayKbn.LEGAL_HOLIDAY;

    public static final String ALREADYHOLIDAYGROUPCD                    = "Selenium";
    public static final String ALREADYHOLIDAYGROUPNM                    = "セレニウムテスト名";
    public static final String ALREADYHOLIDAYGROUPBIKOU                 = "セレニウムテスト備考";
    public static final C_SysSiyouKbn ALREADYHOLIDAYGROUPSYSSIYOUKBN    = C_SysSiyouKbn.TUUJYOU;

    public static final C_LegalHolidayKbn ALREADYHOLIDAYLEGALHOLIDAYKBN = C_LegalHolidayKbn.NONE;
    public static final BizDate ALREADYTEKIYOUYMDFROM                   = BizDate.valueOf("19910529");
    public static final BizDate ALREADYTEKIYOUYMDTO                     = BizDate.valueOf("19910530");
    public static final C_HolidayPtn ALREADYHOLIDAYPATTERN              = C_HolidayPtn.EVERY_WEEK;
    public static final String ALREADYHOLIDAYPATTERNPARAMNM             = "Sunday";
    public static final String ALREADYHOLIDAYPATTERNNM                  = "セレニウムテストパターン名";
    public static final String ALREADYHOLIDAYPATTERNBIKOU               = "セレニウムテスト備考";

    public static final String FUNCTIONNAME                             = "functionName";
    public static final String HOLIDAYGROUPCD                           = "keyInfo[0].holidayGroupCd";
    public static final String HENKOULINK                               = "holidayPatternInfo[0].henkouLink";
    public static final String SAKUJYOLINK                              = "holidayPatternInfo[0].sakujyoLink";
}