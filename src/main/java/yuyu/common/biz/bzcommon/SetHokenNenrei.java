package yuyu.common.biz.bzcommon;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateSpan;

/**
 * 業務共通 共通 保険年齢設定
 */
public class SetHokenNenrei {

    @Inject
    private SetNenrei setNenrei;

    public SetHokenNenrei() {
        super();
    }

    public int exec(BizDate pKijyunYmd, BizDate pBirthday) {

        int nenrei = setNenrei.exec(pKijyunYmd, pBirthday);

        BizDate birthday = pBirthday.addYears(nenrei).getRekijyou();

        BizDateSpan dateSpan = BizDateUtil.calcDifference(pKijyunYmd, birthday);
        int months = dateSpan.getYears() * 12 + dateSpan.getMonths();

        int hkNenrei;

        if (months >= 6) {

            hkNenrei = nenrei + 1;
        }
        else {

            hkNenrei = nenrei;
        }

        return hkNenrei;
    }
}
