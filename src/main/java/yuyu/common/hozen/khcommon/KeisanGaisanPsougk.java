package yuyu.common.hozen.khcommon;

import javax.inject.Inject;

import org.slf4j.Logger;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.def.classification.C_Hrkkaisuu;

/**
 * 契約保全 契約保全共通 概算保険料総額計算
 */
public class KeisanGaisanPsougk {

    @Inject
    private static Logger logger;

    public BizCurrency exec(BizCurrency pHrkp, C_Hrkkaisuu pHrkkaisuu, BizDate pKykYmd, BizDate pHaraimanYmd ) {

        logger.debug("▽ 概算保険料総額計算 開始");

        int phrkkknNen = BizDateUtil.calcDifference(pKykYmd, pHaraimanYmd).getYears();

        BizCurrency gaisanPsougk = pHrkp.multiply(12 / Integer.valueOf(pHrkkaisuu.getValue())).multiply(phrkkknNen);

        logger.debug("△ 概算保険料総額計算 終了");

        return gaisanPsougk;
    }
}
