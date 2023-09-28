package yuyu.common.biz.bzcommon;

import javax.inject.Inject;

import org.apache.commons.validator.GenericValidator;
import org.slf4j.Logger;

import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 業務共通 共通 口座番号チェック
 */
public class CheckKouzaNo {

    private static final String SUUJI = "0123456789";

    private static final String EIJI = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static final String KIGOU = "/\\-?:()\\.,'+ ";

    @Inject
    private static Logger logger;

    public CheckKouzaNo() {
        super();
    }

    public boolean isCheckOK(String pKouzaNo, C_Tuukasyu pTuukasyu) {

        logger.debug("▽ 口座番号チェック 開始");

        if (pKouzaNo == null || pKouzaNo.length() == 0) {

            return false;

        }

        String checkMoji = "";

        if (C_Tuukasyu.JPY.eq(pTuukasyu)) {

            checkMoji = SUUJI;

        }
        else {

            checkMoji = SUUJI + EIJI + KIGOU;
        }

        if (GenericValidator.matchRegexp(pKouzaNo, "[^" + checkMoji + "]")) {

            return false;

        }

        logger.debug("△ 口座番号チェック 終了");

        return true;
    }

    public boolean isKyoyouKeta(String pKouzaNo, C_Tuukasyu pTuukasyu) {

        logger.debug("▽ 口座番号チェック 開始");

        if (pKouzaNo == null || pKouzaNo.length() == 0) {

            return true;

        }

        Integer ketasuu = 0;

        if (C_Tuukasyu.JPY.eq(pTuukasyu)) {

            ketasuu = YuyuBizConfig.getInstance().getYenkaKouzaKetasuu();

        }
        else {

            ketasuu = YuyuBizConfig.getInstance().getGaikaKouzaKetasuu();
        }

        if (pKouzaNo.length() > ketasuu) {

            return false;

        }

        logger.debug("△ 口座番号チェック 終了");

        return true;
    }

}
