package yuyu.common.hozen.ascommon;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.hozen.khcommon.JtKaisukeisan;
import yuyu.def.classification.C_Hrkkaisuu;

/**
 * 契約保全 案内収納共通 払込期月未到来Ｐ判定
 */
public class CheckHrkkigetuMitouraiP {

    @Inject
    private static Logger logger;

    public CheckHrkkigetuMitouraiP() {
        super();
    }

    public boolean exists(BizDate pKijyunymd, BizDateYM pJyutoustartym, C_Hrkkaisuu pHrkkaisuu, Integer pJyutoukaisuuy,
        Integer pJyutoukaisuum) {

        logger.debug("▽ 払込期月未到来Ｐ判定 開始");

        JtKaisukeisan jtKaisukeisan = SWAKInjector.getInstance(JtKaisukeisan.class);

        jtKaisukeisan.exec(pJyutoukaisuuy, pJyutoukaisuum, pHrkkaisuu);

        int jyutouKaisuu = jtKaisukeisan.getJyutoukaisuu();

        BizDateYM jyuutouym = pJyutoustartym;
        BizDateYM kijyunym = pKijyunymd.getBizDateYM();

        for (int i = 0; i < jyutouKaisuu; i++) {
            if (BizDateUtil.compareYm(kijyunym, jyuutouym) == BizDateUtil.COMPARE_LESSER) {

                logger.debug("△ 払込期月未到来Ｐ判定 終了");
                return true;
            }

            jyuutouym = jyuutouym.addMonths(Integer.valueOf(pHrkkaisuu.getValue()));
        }

        logger.debug("△ 払込期月未到来Ｐ判定 終了");

        return false;
    }
}
