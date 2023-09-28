package yuyu.common.biz.bzcommon;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizNumber;

import org.slf4j.Logger;

import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.biz.detacher.BM_RateP2Detacher;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HokenSyuruiKigouSedaiKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_RateGetErrorKbn;
import yuyu.def.classification.C_RyourituKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_RateP2;

/**
 * 業務共通 共通 Ｐレート取得２クラス
 */
public class BzGetPrate2 {

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private static Logger logger;

    private static final String PMEN_NASI = "9";

    public BzGetPrate2() {
        super();
    }

    public BzGetPrateBean exec(
        String pSyouhnCd,
        String pRyouritusdNo,
        BizNumber pYoteiriritu,
        C_Hrkkaisuu pHrkkaisuu,
        C_Hhknsei pHhknsei,
        int pHhknnen,
        C_HknkknsmnKbn pHknkknsmnkbn,
        int pHknkkn,
        int pHrkkkn,
        C_Kykjyoutai pKykjyoutai,
        C_Tuukasyu pTuukasyun,
        int pDai1hknkkn,
        C_RyourituKbn pRyourituKbn) {

        logger.debug("▽ Ｐレート取得２ 開始");

        BzGetPrateBean bzGetPrateBean = SWAKInjector.getInstance(BzGetPrateBean.class);
        String hokenSyuruiKigouSedaiKbn = pRyouritusdNo.substring(0, 1);

        int syohinHanteiKbn = SyouhinUtil.hantei(pSyouhnCd.substring(0, 2));

        if ((syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR ||
                syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19) &&
            (hokenSyuruiKigouSedaiKbn.equals(C_HokenSyuruiKigouSedaiKbn.RYOU17.getValue()) ||
                hokenSyuruiKigouSedaiKbn.equals(C_HokenSyuruiKigouSedaiKbn.RYOU18_4.getValue()) ||
                hokenSyuruiKigouSedaiKbn.equals(C_HokenSyuruiKigouSedaiKbn.RYOU18_8.getValue()))) {

            BzGetPrate bzGetPrate = SWAKInjector.getInstance(BzGetPrate.class);
            bzGetPrateBean = bzGetPrate.exec(
                pSyouhnCd,
                pRyouritusdNo,
                pYoteiriritu,
                pHrkkaisuu,
                pHhknsei,
                pHhknnen,
                pHknkknsmnkbn,
                pHknkkn,
                pHrkkkn);
        }
        else {

            BzRateKoumokuHenkanSet bzRateKoumokuHenkanSet = SWAKInjector.getInstance(BzRateKoumokuHenkanSet.class);
            BM_RateP2 rateP2 = new BM_RateP2();

            BzRateKoumokuHenkanSetBean bzRateKoumokuHenkanSetBean = bzRateKoumokuHenkanSet.exec(
                pSyouhnCd,
                pRyouritusdNo,
                pYoteiriritu,
                pHrkkaisuu,
                pHhknsei,
                pHhknnen,
                pHknkknsmnkbn,
                pHknkkn,
                pHrkkkn,
                pKykjyoutai,
                pTuukasyun,
                pDai1hknkkn,
                pRyourituKbn,
                null);

            if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR ||
                syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19) {

                rateP2 = bizDomManager.getRateP2byRatePkey(
                    bzRateKoumokuHenkanSetBean.getHknsyukigou(),
                    bzRateKoumokuHenkanSetBean.getHokensyuruikigousdicode(),
                    bzRateKoumokuHenkanSetBean.getYoteiriritu(),
                    PMEN_NASI,
                    bzRateKoumokuHenkanSetBean.getHrkkaisuu(),
                    bzRateKoumokuHenkanSetBean.getHhknsei(),
                    bzRateKoumokuHenkanSetBean.getKeiyakujihhknnen(),
                    bzRateKoumokuHenkanSetBean.getSaimankikeiyakuhyouji(),
                    bzRateKoumokuHenkanSetBean.getHknkkn(),
                    bzRateKoumokuHenkanSetBean.getPharaikomikikan());

            }
            else {

                rateP2 = bizDomManager.getRateP2(
                    bzRateKoumokuHenkanSetBean.getHknsyukigou(),
                    bzRateKoumokuHenkanSetBean.getHokensyuruikigousdicode(),
                    bzRateKoumokuHenkanSetBean.getYoteiriritu(),
                    PMEN_NASI,
                    bzRateKoumokuHenkanSetBean.getHrkkaisuu(),
                    bzRateKoumokuHenkanSetBean.getHhknsei(),
                    bzRateKoumokuHenkanSetBean.getKeiyakujihhknnen(),
                    bzRateKoumokuHenkanSetBean.getSaimankikeiyakuhyouji(),
                    bzRateKoumokuHenkanSetBean.getHknkkn(),
                    bzRateKoumokuHenkanSetBean.getPharaikomikikan(),
                    bzRateKoumokuHenkanSetBean.getAnnaihuyouriyuukbn(),
                    bzRateKoumokuHenkanSetBean.getTuukasyukbn(),
                    bzRateKoumokuHenkanSetBean.getDai1hknkkn(),
                    bzRateKoumokuHenkanSetBean.getRyouritukbn());
            }

            if (rateP2 == null) {

                bzGetPrateBean.setErrorKbn(C_ErrorKbn.ERROR);
                bzGetPrateBean.setRateGetErrorKbn(C_RateGetErrorKbn.TARGETERROR);
            }
            else {
                rateP2 = BM_RateP2Detacher.detachRateP2touched(rateP2);

                bzGetPrateBean.setPrate(rateP2.getPrate());
                bzGetPrateBean.setPsRate(rateP2.getPdatesrate());
                bzGetPrateBean.setErrorKbn(C_ErrorKbn.OK);
            }
        }

        logger.debug("△ Ｐレート取得２ 終了");

        return bzGetPrateBean;
    }
}
