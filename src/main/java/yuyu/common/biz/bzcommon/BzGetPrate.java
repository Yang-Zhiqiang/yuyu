package yuyu.common.biz.bzcommon;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizNumber;

import org.slf4j.Logger;

import com.google.common.base.Strings;

import yuyu.common.suuri.srcommon.SrHokenSyuruiKigouSedaiConverter;
import yuyu.def.biz.detacher.BM_RatePDetacher;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_RateGetErrorKbn;
import yuyu.def.db.entity.BM_RateP;

/**
 * 業務共通 業務共通 Ｐレート取得クラス
 */
public class BzGetPrate {

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private static Logger logger;

    @Inject
    private SrHokenSyuruiKigouSedaiConverter hokenSyuruiKigouSedaiConverter;

    public BzGetPrate() {
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
        int pHrkkkn) {

        logger.debug("▽ Ｐレート取得 開始");

        BzGetPrateBean bzGetPrateBean = SWAKInjector.getInstance(BzGetPrateBean.class);

        String palSaimankiHyouji = "";

        String palHhknSei = "";

        String palHrkkaisuu = "";

        if (C_HknkknsmnKbn.SAIMANKI.eq(pHknkknsmnkbn)) {

            palSaimankiHyouji = "1";
        }
        else if (C_HknkknsmnKbn.NENMANKI.eq(pHknkknsmnkbn)) {

            palSaimankiHyouji = "0";
        }

        if (C_Hhknsei.MALE.eq(pHhknsei)) {
            palHhknSei = "1";
        }
        else if (C_Hhknsei.FEMALE.eq(pHhknsei)) {

            palHhknSei = "2";
        }

        if (C_Hrkkaisuu.ITIJI.eq(pHrkkaisuu)) {
            palHrkkaisuu = "0";
        }

        BM_RateP bm_RateP = bizDomManager.getRateP(
            pSyouhnCd.substring(0, 2),
            hokenSyuruiKigouSedaiConverter.convert(pRyouritusdNo.substring(0, 1)),
            Strings.padStart(String.valueOf(pYoteiriritu.multiply(10000)), 5, '0').substring(2),
            "9",
            palHrkkaisuu,
            palHhknSei,
            Strings.padStart(String.valueOf(pHhknnen),3,'0'),
            palSaimankiHyouji,
            Strings.padStart(String.valueOf(pHknkkn),2,'0'),
            Strings.padStart(String.valueOf(pHrkkkn),2,'0'));

        if (bm_RateP == null) {

            bzGetPrateBean.setErrorKbn(C_ErrorKbn.ERROR);

            bzGetPrateBean.setRateGetErrorKbn(C_RateGetErrorKbn.TARGETERROR);
        }
        else {
            bm_RateP = BM_RatePDetacher.detachRatePtouched(bm_RateP);

            bzGetPrateBean.setPrate(bm_RateP.getPrate());
            bzGetPrateBean.setPsRate(bm_RateP.getPdatesrate());

            bzGetPrateBean.setErrorKbn(C_ErrorKbn.OK);
        }

        logger.debug("△ Ｐレート取得 終了");

        return bzGetPrateBean;
    }
}