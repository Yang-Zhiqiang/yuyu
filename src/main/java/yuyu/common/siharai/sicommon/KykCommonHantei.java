package yuyu.common.siharai.sicommon;

import javax.inject.Inject;

import org.slf4j.Logger;

import yuyu.def.classification.C_Hkuktsyu;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.def.db.entity.JT_SiUkt;

/**
 * 保険金給付金支払 保険金給付金支払共通 契約内容共通判定クラス
 */
public class KykCommonHantei {

    @Inject
    private static Logger logger;

    public KykCommonHantei() {
        super();
    }

    public boolean chkKykdrtkykumu(JT_SiKykKihon pSiKykKihon) {

        logger.debug("▽ 契約者代理特約有無判定 開始");

        if (C_UmuKbn.ARI.eq(pSiKykKihon.getKykdrtkykhukaumu())) {

            logger.debug("△ 契約者代理特約有無判定 終了");
            return true;
        }

        logger.debug("△ 契約者代理特約有無判定 終了");
        return false;
    }

    public boolean chkKeiukedou(JT_SiKykKihon pSiKykKihon) {

        logger.debug("▽ 契受同一判定 開始");

        if (pSiKykKihon.getSbuktnin() == 1) {
            for (JT_SiUkt tempSiUkt : pSiKykKihon.getSiUkts()) {
                if (C_Hkuktsyu.SBHKKUKT.eq(tempSiUkt.getHkuktsyu()) && C_UktKbn.KYK.eq(tempSiUkt.getUktkbn())) {

                    logger.debug("△ 契受同一判定 終了");
                    return true;
                }
            }
        }

        logger.debug("△ 契受同一判定 終了");
        return false;
    }

}
