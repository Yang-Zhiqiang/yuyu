package yuyu.common.biz.bzcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateSpan;
import jp.co.slcs.swak.date.BizDateYM;

/**
 * 日付ユーティリティクラスです。<br />
 */
public class BizDateUtil {

    public static final int COMPARE_LESSER     = -1;
    public static final int COMPARE_EQUAL      = 0;
    public static final int COMPARE_GREATER    = 1;

    public static BizDateSpan calcDifference(BizDate pDate1, BizDate pDate2) {

        if (pDate1.compareTo(pDate2) >= 0) {

            return pDate1.subtract(pDate2);
        }

        return pDate2.subtract(pDate1);
    }

    public static int calcDifferenceDays(BizDate pDate1, BizDate pDate2) {

        if (pDate1.compareTo(pDate2) >= 0) {

            return pDate1.subtractDays(pDate2);
        }

        return pDate2.subtractDays(pDate1);
    }

    public static int calcDifferenceMonths(BizDateYM pDateYm1, BizDateYM pDateYm2) {

        if (pDateYm1.compareTo(pDateYm2) >= 0) {

            return pDateYm1.subtractMonths(pDateYm2);
        }

        return pDateYm2.subtractMonths(pDateYm1);
    }

    public static int compareYmd(BizDate pDate1, BizDate pDate2) {

        if (pDate1 == null && pDate2 == null) {
            return COMPARE_EQUAL;
        }
        else if (pDate1 == null) {
            return COMPARE_LESSER;
        }
        else if (pDate2 == null) {
            return COMPARE_GREATER;
        }
        else {
            if (pDate1.compareTo(pDate2) > 0) {
                return COMPARE_GREATER;
            }
            else if (pDate1.compareTo(pDate2) == 0) {
                return COMPARE_EQUAL;
            }
            else {
                return COMPARE_LESSER;
            }
        }
    }

    public static int compareYm(BizDateYM pDateYM1, BizDateYM pDateYM2) {

        if (pDateYM1 == null && pDateYM2 == null) {
            return COMPARE_EQUAL;
        }
        else if (pDateYM1 == null) {
            return COMPARE_LESSER;
        }
        else if (pDateYM2 == null) {
            return COMPARE_GREATER;
        }
        else {
            if (pDateYM1.compareTo(pDateYM2) > 0) {
                return COMPARE_GREATER;
            }
            else if (pDateYM1.compareTo(pDateYM2) == 0) {
                return COMPARE_EQUAL;
            }
            else {
                return COMPARE_LESSER;
            }
        }
    }

    public static int compareYmdByYm(BizDate pDate1, BizDate pDate2) {

        if (pDate1 == null && pDate2 == null) {
            return COMPARE_EQUAL;
        }
        else if (pDate1 == null) {
            return COMPARE_LESSER;
        }
        else if (pDate2 == null) {
            return COMPARE_GREATER;
        }
        else {
            BizDateYM dateYM1 = pDate1.getBizDateYM();
            BizDateYM dateYM2 = pDate2.getBizDateYM();
            return compareYm(dateYM1, dateYM2);
        }
    }

    public static BizDate ifNotBlankValueOf(String pDate) {
        if (BizUtil.isBlank(pDate)) {

            return null;
        }

        return BizDate.valueOf(pDate);
    }

    public static BizDate getDateAfterPeriod(BizDate pDate, int pYear, int pMonth) {

        BizDateSpan span = new BizDateSpan(pYear, pMonth, 0);

        BizDate wkDateAfterPeriod = pDate.add(span);

        if (!wkDateAfterPeriod.isRekijyou()) {
            wkDateAfterPeriod = wkDateAfterPeriod.getRekijyou().getNextDay();
        }

        return wkDateAfterPeriod;

    }
}
