package yuyu.common.siharai.sicommon;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;

import yuyu.common.siharai.edittbl.SiSiDetailParamBean;
import yuyu.def.classification.C_HokenkinsyuruiKbn;

/**
 * 保険金給付金支払 保険金給付金支払共通 保険金給付金保障判定クラス
 */
public class SiHosyouHantei {

    @Inject
    private static Logger logger;

    public SiHosyouHantei() {
        super();
    }

    public boolean chkSaigaiHosyou(List<SiSiDetailParamBean> pSiSiDetailParamBeanList) {

        logger.debug("▽ 保険金給付金保障判定 災害保障判定 開始");

        boolean hanteiKekkaFlag = false;
        if (pSiSiDetailParamBeanList == null) {
            logger.debug("△ 保険金給付金保障判定 災害保障判定 終了");
            return hanteiKekkaFlag;
        }

        for (SiSiDetailParamBean siSiDetailParamBean : pSiSiDetailParamBeanList) {
            if (C_HokenkinsyuruiKbn.SAIGAIHOKENKIN.eq(siSiDetailParamBean.getHokenkinsyuruikbn())) {
                hanteiKekkaFlag = true;
                logger.debug("△ 保険金給付金保障判定 災害保障判定 終了");
                return hanteiKekkaFlag;
            }
        }

        logger.debug("△ 保険金給付金保障判定 災害保障判定 終了");
        return hanteiKekkaFlag;
    }

}