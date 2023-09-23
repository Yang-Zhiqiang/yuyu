package yuyu.common.hozen.khcommon;

import java.math.RoundingMode;

import javax.inject.Inject;

import jp.co.slcs.swak.number.BizCurrency;

import org.slf4j.Logger;

/**
 * 契約保全 契約保全共通 ターゲット特約目標額計算
 */
public class KeisanTargetMokuhyougk {

    @Inject
    private static Logger logger;

    public KeisanTargetMokuhyougk() {
        super();
    }

    public BizCurrency exec(
        BizCurrency pTargetkijyungk,
        int pTargettkmokuhyougkwari) {

        logger.debug("▽ ターゲット特約目標額計算 開始");

        BizCurrency mokuhyougk = pTargetkijyungk.multiply(pTargettkmokuhyougkwari).divide(100, 0, RoundingMode.UP);

        logger.debug("△ ターゲット特約目標額計算 終了");

        return mokuhyougk;
    }

}