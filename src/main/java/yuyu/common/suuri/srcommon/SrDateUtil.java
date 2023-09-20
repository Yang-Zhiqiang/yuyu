package yuyu.common.suuri.srcommon;

import jp.co.slcs.swak.date.BizDate;

/**
 * 数理統計　日付ユーティリティクラスです。<br />
 */
public class SrDateUtil {

    public static boolean isKessanTuki(BizDate kijyunYMD) {

        if (kijyunYMD == null) {
            return false;
        }

        if (!kijyunYMD.isRekijyou()) {
            return false;
        }

        int month = kijyunYMD.getMonth();

        if (month == SrCommonConstants.MONTH_MARCH || month == SrCommonConstants.MONTH_JUNE
            || month == SrCommonConstants.MONTH_SEPTEMBER || month == SrCommonConstants.MONTH_DECEMBER) {
            return true;
        }

        return false;
    }

    public static boolean isKessanTukiYokugetu(BizDate kijyunYMD) {

        if (kijyunYMD == null) {
            return false;
        }

        if (!kijyunYMD.isRekijyou()) {
            return false;
        }

        int month = kijyunYMD.getMonth();

        if (month == SrCommonConstants.MONTH_JANUARY || month == SrCommonConstants.MONTH_APRIL
            || month == SrCommonConstants.MONTH_JULY || month == SrCommonConstants.MONTH_OCTOBER) {
            return true;
        }

        return false;
    }
}
