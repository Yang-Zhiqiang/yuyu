package yuyu.common.siharai.sicommon;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.def.db.entity.JM_SiSyouhnZokusei;
import yuyu.def.db.entity.JT_SiKykSyouhn;

/**
 * 保険金給付金支払 保険金給付金支払共通 自殺免責期間判定
 */
public class JisatuMensekiKikanHantei {

    @Inject
    private static Logger logger;

    public JisatuMensekiKikanHantei() {
        super();
    }

    public boolean exec(BizDate pHanteiKijyunYmd, BizDate pHksknnkaisiymd, JT_SiKykSyouhn pSiKykSyouhn,
        JM_SiSyouhnZokusei pSiSyouhnZokusei) {

        logger.debug("▽ 自殺免責期間判定 開始");

        boolean hanteiKekkaFlag = false;

        if (pHanteiKijyunYmd == null || pSiKykSyouhn == null || pSiSyouhnZokusei == null) {

            hanteiKekkaFlag = false;
            logger.debug("△ 自殺免責期間判定 終了");
            return hanteiKekkaFlag;
        }

        if (pSiSyouhnZokusei.getJisatumensekinensuu() == 0) {

            hanteiKekkaFlag = false;
            logger.debug("△ 自殺免責期間判定 終了");
            return hanteiKekkaFlag;
        }

        if (pHksknnkaisiymd == null) {
            BizDate dateHikaku = pSiKykSyouhn.getSknnkaisiymd().addYears(pSiSyouhnZokusei.getJisatumensekinensuu());
            if (BizDateUtil.compareYmd(dateHikaku, pHanteiKijyunYmd)
                == BizDateUtil.COMPARE_GREATER) {

                hanteiKekkaFlag = true;
                logger.debug("△ 自殺免責期間判定 終了");
                return hanteiKekkaFlag;
            }
        }
        else {
            if (BizDateUtil.compareYmd(pHksknnkaisiymd, pSiKykSyouhn.getSknnkaisiymd()) == BizDateUtil.COMPARE_GREATER) {

                BizDate dateHikaku = pHksknnkaisiymd
                    .addYears(pSiSyouhnZokusei.getJisatumensekinensuu());
                if (BizDateUtil.compareYmd(dateHikaku, pHanteiKijyunYmd)
                    == BizDateUtil.COMPARE_GREATER) {

                    hanteiKekkaFlag = true;
                    logger.debug("△ 自殺免責期間判定 終了");
                    return hanteiKekkaFlag;
                }
            }
            else {
                BizDate dateHikaku = pSiKykSyouhn.getSknnkaisiymd().addYears(pSiSyouhnZokusei.getJisatumensekinensuu());
                if (BizDateUtil.compareYmd(dateHikaku, pHanteiKijyunYmd)
                    == BizDateUtil.COMPARE_GREATER) {

                    hanteiKekkaFlag = true;
                    logger.debug("△ 自殺免責期間判定 終了");
                    return hanteiKekkaFlag;
                }
            }
        }

        logger.debug("△ 自殺免責期間判定 終了");
        return hanteiKekkaFlag;
    }
}