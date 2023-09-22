package yuyu.common.sinkeiyaku.skcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.CHolidayAdjustingMode;

/**
 * 新契約 新契約共通  申込有効期限取得
 */
public class GetMosYuukouKigen {

    public static BizDate exec(BizDate pKijyunYmd) {

        BizDate kijyunYmd = pKijyunYmd;

        kijyunYmd = kijyunYmd.getBizDateYM().addMonths(2).getBizDate(10);

        if (kijyunYmd.isHoliday()) {

            kijyunYmd = kijyunYmd.getBusinessDay(CHolidayAdjustingMode.PREVIOUS);
        }

        return kijyunYmd;
    }
}
