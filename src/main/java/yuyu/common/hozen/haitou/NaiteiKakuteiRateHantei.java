package yuyu.common.hozen.haitou;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_NaiteiKakuteiKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.hozen.configuration.YuyuHozenConfig;

/**
 * 契約保全 配当 内定確定レート判定
 */
public class NaiteiKakuteiRateHantei extends BaseDCommon {

    private C_NaiteiKakuteiKbn naiteiKakuteiKbn;

    @Inject
    private static Logger logger;

    {
        regErrorInfo("001", "入力値エラー", "必須の入力項目にnullが含まれる");
        regErrorInfo("002", "Ｄレートなし", null);
    }

    public NaiteiKakuteiRateHantei() {
        super();
    }

    public C_ErrorKbn exec(BizDate pSyoriYmd, BizDateY pDratenendo, C_UmuKbn pKessanSiyouUmu) {

        logger.debug("▽ 内定確定レート判定 開始");

        clear();

        naiteiKakuteiKbn = null;

        final boolean collectEntityFlg = getCollectEntityFlg();

        try {
            if (pSyoriYmd == null || pDratenendo == null) {

                setErrorInfo("001");

                logger.debug("△ 内定確定レート判定 終了");

                return C_ErrorKbn.ERROR;
            }

            BizDate drateRendouYmd = BizDate.valueOf(pDratenendo.toString() + YuyuHozenConfig.getInstance().getDrateRendouMd());

            BizDate drateKakuteiYmd = BizDate.valueOf(pDratenendo.toString() + YuyuHozenConfig.getInstance().getDrateKakuteiMd());
            if (!drateKakuteiYmd.isBusinessDay()) {
                drateKakuteiYmd = drateKakuteiYmd.addBusinessDays(-1);
            }

            if (BizDateUtil.compareYmd(pSyoriYmd, drateRendouYmd) == BizDateUtil.COMPARE_LESSER) {

                setErrorInfo("002");

                logger.debug("△ 内定確定レート判定 終了");

                return C_ErrorKbn.ERROR;
            }

            if (C_UmuKbn.ARI.eq(pKessanSiyouUmu)) {
                naiteiKakuteiKbn = C_NaiteiKakuteiKbn.KAKUTEI;
            }
            else {
                if (BizDateUtil.compareYmd(pSyoriYmd, drateKakuteiYmd) == BizDateUtil.COMPARE_LESSER) {

                    naiteiKakuteiKbn = C_NaiteiKakuteiKbn.NAITEI;
                }
                else {
                    naiteiKakuteiKbn = C_NaiteiKakuteiKbn.KAKUTEI;
                }
            }

            logger.debug("△ 内定確定レート判定 終了");

            return C_ErrorKbn.OK;
        }
        finally {
            collectEntity(collectEntityFlg);
        }
    }

    public C_NaiteiKakuteiKbn getNaiteiKakuteiKbn() {

        return naiteiKakuteiKbn;
    }
}
