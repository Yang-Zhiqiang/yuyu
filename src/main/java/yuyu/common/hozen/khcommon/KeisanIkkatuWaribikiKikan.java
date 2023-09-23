package yuyu.common.hozen.khcommon;

import javax.inject.Inject;

import org.slf4j.Logger;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import yuyu.common.biz.bzcommon.BizDateUtil;

/**
 * 契約保全 契約保全共通 一括割引期間計算<br />
 * 充当月数のうち、一括割引が適用対象となる期間、適用対象とならない期間を計算する。<br />
 */
public class KeisanIkkatuWaribikiKikan {

    private Integer wrbkTekikknTksu;

    private Integer wrbkTekikkngaiTksu;

    @Inject
    private static Logger logger;

    public KeisanIkkatuWaribikiKikan() {
        super();
    }

    public Integer getWrbkTekikknTksu() {
        return wrbkTekikknTksu;
    }

    public Integer getWrbkTekikkngaiTksu() {
        return wrbkTekikkngaiTksu;
    }

    public void exec(BizDate pRyosyuYmd, BizDateYM pJyuutouYm, Integer pJyuutouTukisuu) {

        logger.debug("▽ 一括割引期間計算 開始");

        BizDateYM jyutouEndYm = pJyuutouYm.addMonths(pJyuutouTukisuu -1);

        if (BizDateUtil.compareYm(pRyosyuYmd.getBizDateYM(), jyutouEndYm) == BizDateUtil.COMPARE_EQUAL ||
            BizDateUtil.compareYm(pRyosyuYmd.getBizDateYM(), jyutouEndYm) == BizDateUtil.COMPARE_GREATER) {

            wrbkTekikkngaiTksu = pJyuutouTukisuu;
        }
        else if (BizDateUtil.compareYm(pJyuutouYm, pRyosyuYmd.getBizDateYM().addMonths(-2)) == BizDateUtil.COMPARE_LESSER) {

            wrbkTekikkngaiTksu = BizDateUtil.calcDifferenceMonths(pRyosyuYmd.getBizDateYM().addMonths(-2), pJyuutouYm);
        }
        else {

            wrbkTekikkngaiTksu = 0;
        }

        if (wrbkTekikkngaiTksu > pJyuutouTukisuu) {

            wrbkTekikkngaiTksu = pJyuutouTukisuu;
        }

        wrbkTekikknTksu = pJyuutouTukisuu - wrbkTekikkngaiTksu;

        logger.debug("△ 一括割引期間計算 終了");
    }
}
