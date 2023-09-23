package yuyu.common.siharai.sicommon;

import javax.inject.Inject;

import jp.co.slcs.swak.number.BizCurrency;

import org.slf4j.Logger;

import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.classification.C_ErrorKbn;

/**
 * 保険金給付金支払 保険金給付金支払共通 精算金額計算
 */
public class CalcSeisankgk {

    @Inject
    private static Logger logger;

    private BizCurrency sbymdSeisankGk;

    public BizCurrency getSbymdSeisankGk() {
        return sbymdSeisankGk;
    }

    public C_ErrorKbn exec(String pSyouhnCd, SiHkkingakuSisanParamBean pSiHkkingakuSisanParamBean) {

        logger.debug("▽ 精算金額計算 開始");

        C_ErrorKbn errorKbn = C_ErrorKbn.OK;

        if (pSyouhnCd == null) {

            errorKbn = C_ErrorKbn.ERROR;

            logger.debug("【精算金額計算】の与件が正しく設定されていません。");
            logger.debug("△ 精算金額計算 終了");

            return errorKbn;
        }

        if (pSiHkkingakuSisanParamBean == null) {

            errorKbn = C_ErrorKbn.ERROR;

            logger.debug("【精算金額計算】の与件が正しく設定されていません。");
            logger.debug("△ 精算金額計算 終了");

            return errorKbn;
        }

        errorKbn = execCalcSeisankgk(pSyouhnCd, pSiHkkingakuSisanParamBean);

        logger.debug("△ 精算金額計算 終了");

        return errorKbn;
    }

    private C_ErrorKbn execCalcSeisankgk(String pSyouhnCd, SiHkkingakuSisanParamBean pSiHkkingakuSisanParamBean){

        C_ErrorKbn errorKbn = C_ErrorKbn.OK;

        int syohinHanteiKbn = SyouhinUtil.hantei(pSyouhnCd);

        if (SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR == syohinHanteiKbn
            || SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 == syohinHanteiKbn) {
            if (pSiHkkingakuSisanParamBean.getSbymdTmttKnGk().compareTo(
                pSiHkkingakuSisanParamBean.getSbymdKaiyakuhenreiknGk()) < 0) {
                sbymdSeisankGk = pSiHkkingakuSisanParamBean.getSbymdKaiyakuhenreiknGk();
            } else {
                sbymdSeisankGk = pSiHkkingakuSisanParamBean.getSbymdTmttKnGk();
            }

        } else if (SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR == syohinHanteiKbn
            || SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 == syohinHanteiKbn) {
            if (pSiHkkingakuSisanParamBean.getSbymdTmttKnGk().compareTo(
                pSiHkkingakuSisanParamBean.getSbymdKaiyakuhenreiknGk()) < 0) {
                sbymdSeisankGk = pSiHkkingakuSisanParamBean.getSbymdKaiyakuhenreiknGk();
            } else {
                sbymdSeisankGk = pSiHkkingakuSisanParamBean.getSbymdTmttKnGk();
            }

        } else if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN == syohinHanteiKbn
            || SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN == syohinHanteiKbn) {
            if (pSiHkkingakuSisanParamBean.getPruikei().compareTo(
                pSiHkkingakuSisanParamBean.getSbymdTmttKnGk()) < 0) {
                sbymdSeisankGk = pSiHkkingakuSisanParamBean.getPruikei();
            } else {
                sbymdSeisankGk = pSiHkkingakuSisanParamBean.getSbymdTmttKnGk();
            }
        }

        return errorKbn;
    }

}
