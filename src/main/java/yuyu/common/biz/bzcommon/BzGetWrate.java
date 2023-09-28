package yuyu.common.biz.bzcommon;

import java.util.HashMap;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizNumber;

import org.slf4j.Logger;

import yuyu.def.biz.detacher.BM_RateWDetacher;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_RateGetErrorKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_WRateGetKbn;
import yuyu.def.db.entity.BM_RateW;

/**
 * 業務共通 共通 Ｗレート取得クラス
 */
public class BzGetWrate {

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private static Logger logger;

    private static final int KEIKANENSUU_MIN = 0;

    private static final int KEIKANENSUU_MAX = 99;

    private static final String PMEN_NASI = "9";

    public BzGetWrate() {
        super();
    }

    public BzGetWrateBean exec(
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
        C_WRateGetKbn pWRateGetKbn,
        int pKeikanensuu) {

        logger.debug("▽ Ｗレート取得 開始");

        BzGetWrateBean bzGetWrateBean = SWAKInjector.getInstance(BzGetWrateBean.class);

        C_ErrorKbn errorKbn = chkKeikaNensu(
            pHknkknsmnkbn,
            pKeikanensuu,
            pHknkkn,
            pWRateGetKbn);

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

            bzGetWrateBean.setErrorKbn(C_ErrorKbn.ERROR);

            bzGetWrateBean.setRateGetErrorKbn(C_RateGetErrorKbn.INPUTERROR);

            logger.debug("△ Ｗレート取得 終了");

            return bzGetWrateBean;

        }

        BzRateKoumokuHenkanSet bzRateKoumokuHenkanSet = SWAKInjector.getInstance(BzRateKoumokuHenkanSet.class);
        BM_RateW rateW = new BM_RateW();

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
            null,
            null);

        rateW = bizDomManager.getRateW(
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
            bzRateKoumokuHenkanSetBean.getDai1hknkkn());

        if (rateW == null) {

            bzGetWrateBean.setErrorKbn(C_ErrorKbn.ERROR);

            bzGetWrateBean.setRateGetErrorKbn(C_RateGetErrorKbn.TARGETERROR);
        }
        else {

            rateW = BM_RateWDetacher.detachRateWtouched(rateW);

            HashMap<Integer, BizNumber> wrateAll = getWrateMap(rateW);

            HashMap<Integer, BizNumber> wrate = new HashMap<>();

            if (C_WRateGetKbn.ALL.eq(pWRateGetKbn)) {

                wrate.putAll(wrateAll);
            }
            else if (C_WRateGetKbn.ONEYEAR.eq(pWRateGetKbn)) {

                wrate.put(0, wrateAll.get(pKeikanensuu));
            }
            else if (C_WRateGetKbn.TWOYEARS.eq(pWRateGetKbn)) {

                wrate.put(0, wrateAll.get(pKeikanensuu));

                wrate.put(1, wrateAll.get(pKeikanensuu + 1));
            }

            bzGetWrateBean.setWrate(wrate);

            bzGetWrateBean.setErrorKbn(C_ErrorKbn.OK);
        }

        logger.debug("△ Ｗレート取得 終了");

        return bzGetWrateBean;
    }

    private C_ErrorKbn chkKeikaNensu(
        C_HknkknsmnKbn pHknkknsmnKbn,
        int pKeikanensuu,
        int pHknkkn,
        C_WRateGetKbn pWRateGetKbn) {

        C_ErrorKbn errorKbn = null;

        if (pKeikanensuu < KEIKANENSUU_MIN || pKeikanensuu > KEIKANENSUU_MAX) {

            errorKbn = C_ErrorKbn.ERROR;
        }
        else if (C_HknkknsmnKbn.NENMANKI.eq(pHknkknsmnKbn) && pKeikanensuu > pHknkkn) {

            errorKbn = C_ErrorKbn.ERROR;
        }
        else if (C_WRateGetKbn.TWOYEARS.eq(pWRateGetKbn) && pKeikanensuu == KEIKANENSUU_MAX) {

            errorKbn = C_ErrorKbn.ERROR;
        }
        else {

            errorKbn = C_ErrorKbn.OK;
        }

        return errorKbn;
    }

    private HashMap<Integer, BizNumber> getWrateMap(BM_RateW pBM_RateW) {

        HashMap<Integer, BizNumber> wrate = new HashMap<>();

        int i = 0;
        wrate.put(i++, getWrate(pBM_RateW.getWrate00()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate01()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate02()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate03()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate04()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate05()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate06()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate07()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate08()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate09()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate10()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate11()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate12()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate13()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate14()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate15()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate16()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate17()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate18()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate19()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate20()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate21()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate22()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate23()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate24()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate25()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate26()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate27()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate28()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate29()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate30()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate31()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate32()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate33()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate34()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate35()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate36()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate37()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate38()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate39()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate40()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate41()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate42()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate43()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate44()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate45()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate46()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate47()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate48()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate49()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate50()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate51()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate52()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate53()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate54()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate55()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate56()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate57()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate58()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate59()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate60()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate61()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate62()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate63()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate64()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate65()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate66()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate67()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate68()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate69()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate70()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate71()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate72()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate73()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate74()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate75()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate76()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate77()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate78()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate79()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate80()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate81()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate82()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate83()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate84()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate85()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate86()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate87()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate88()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate89()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate90()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate91()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate92()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate93()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate94()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate95()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate96()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate97()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate98()));
        wrate.put(i++, getWrate(pBM_RateW.getWrate99()));

        return wrate;
    }

    private BizNumber getWrate(BizNumber wrate) {
        return wrate == null ? BizNumber.ZERO : wrate;
    }
}
