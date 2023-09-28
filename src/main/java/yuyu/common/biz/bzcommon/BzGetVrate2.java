package yuyu.common.biz.bzcommon;

import java.util.HashMap;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizNumber;

import org.slf4j.Logger;

import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.biz.detacher.BM_RateV2Detacher;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HokenSyuruiKigouSedaiKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_RateGetErrorKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_VRateGetKbn;
import yuyu.def.db.entity.BM_RateV2;

/**
 * 業務共通 共通 Ｖレート取得２
 */
public class BzGetVrate2 {

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private static Logger logger;

    private static final int KEIKANENSUU_MIN = 0;

    private static final int KEIKANENSUU_MAX = 99;

    private static final String PMEN_NASI = "9";

    public BzGetVrate2() {
        super();
    }

    public BzGetVrateBean exec(
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
        C_VRateGetKbn pVRateGetKbn,
        int pKeikanensuu) {

        logger.debug("▽ Ｖレート取得２ 開始");

        BzGetVrateBean bzGetVrateBean = SWAKInjector.getInstance(BzGetVrateBean.class);
        String hokenSyuruiKigouSedaiKbn = pRyouritusdNo.substring(0, 1);

        int syohinHanteiKbn = SyouhinUtil.hantei(pSyouhnCd.substring(0, 2));

        if ((syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR ||
                syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19) &&
            (hokenSyuruiKigouSedaiKbn.equals(C_HokenSyuruiKigouSedaiKbn.RYOU17.getValue()) ||
                hokenSyuruiKigouSedaiKbn.equals(C_HokenSyuruiKigouSedaiKbn.RYOU18_4.getValue()) ||
                hokenSyuruiKigouSedaiKbn.equals(C_HokenSyuruiKigouSedaiKbn.RYOU18_8.getValue()))) {

            BzGetVrate bzGetVrate = SWAKInjector.getInstance(BzGetVrate.class);
            bzGetVrateBean = bzGetVrate.exec(
                pSyouhnCd,
                pRyouritusdNo,
                pYoteiriritu,
                pHrkkaisuu,
                pHhknsei,
                pHhknnen,
                pHknkknsmnkbn,
                pHknkkn,
                pHrkkkn,
                pVRateGetKbn,
                pKeikanensuu);
        }
        else {

            C_ErrorKbn errorKbn = chkKeikaNensu(
                pHknkknsmnkbn,
                pKeikanensuu,
                pHknkkn,
                pVRateGetKbn);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                bzGetVrateBean.setErrorKbn(C_ErrorKbn.ERROR);

                bzGetVrateBean.setRateGetErrorKbn(C_RateGetErrorKbn.INPUTERROR);

                logger.debug("△ Ｖレート取得２ 終了");

                return bzGetVrateBean;

            }

            BzRateKoumokuHenkanSet bzRateKoumokuHenkanSet = SWAKInjector.getInstance(BzRateKoumokuHenkanSet.class);
            BM_RateV2 rateV2 = new BM_RateV2();

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

            if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR ||
                syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19) {

                rateV2 = bizDomManager.getRateV2byRateVkey(
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

                rateV2 = bizDomManager.getRateV2(
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
            }

            if (rateV2 == null) {

                bzGetVrateBean.setErrorKbn(C_ErrorKbn.ERROR);

                bzGetVrateBean.setRateGetErrorKbn(C_RateGetErrorKbn.TARGETERROR);
            }
            else {

                rateV2 = BM_RateV2Detacher.detachRateV2touched(rateV2);

                HashMap<Integer, BizNumber> vrateAll = getVrateMap(rateV2);

                HashMap<Integer, BizNumber> vrate = new HashMap<>();

                if (C_VRateGetKbn.ALL.eq(pVRateGetKbn)) {
                    vrate.putAll(vrateAll);
                }
                else if (C_VRateGetKbn.ONEYEAR.eq(pVRateGetKbn)) {

                    vrate.put(0, vrateAll.get(pKeikanensuu));
                }
                else if (C_VRateGetKbn.TWOYEARS.eq(pVRateGetKbn)) {

                    vrate.put(0, vrateAll.get(pKeikanensuu));

                    vrate.put(1, vrateAll.get(pKeikanensuu + 1));
                }

                bzGetVrateBean.setVrate(vrate);

                bzGetVrateBean.setErrorKbn(C_ErrorKbn.OK);
            }
        }

        logger.debug("△ Ｖレート取得２ 終了");

        return bzGetVrateBean;
    }

    private C_ErrorKbn chkKeikaNensu(
        C_HknkknsmnKbn pHknkknsmnKbn,
        int pKeikanensuu,
        int pHknkkn,
        C_VRateGetKbn pVRateGetKbn) {

        C_ErrorKbn errorKbn = C_ErrorKbn.OK;

        if (pKeikanensuu < KEIKANENSUU_MIN  || KEIKANENSUU_MAX < pKeikanensuu) {

            errorKbn =  C_ErrorKbn.ERROR;
        }

        if (C_HknkknsmnKbn.NENMANKI.eq(pHknkknsmnKbn) && pKeikanensuu > pHknkkn ) {

            errorKbn =  C_ErrorKbn.ERROR;
        }

        if (C_VRateGetKbn.TWOYEARS.eq(pVRateGetKbn) && pKeikanensuu == KEIKANENSUU_MAX) {

            errorKbn =  C_ErrorKbn.ERROR;
        }

        return errorKbn;
    }

    private HashMap<Integer, BizNumber> getVrateMap(BM_RateV2 pBM_RateV2) {

        HashMap<Integer, BizNumber> vrate = new HashMap<>();

        int i = 0;
        vrate.put(i++, getVrate(pBM_RateV2.getVrate00()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate01()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate02()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate03()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate04()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate05()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate06()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate07()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate08()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate09()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate10()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate11()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate12()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate13()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate14()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate15()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate16()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate17()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate18()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate19()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate20()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate21()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate22()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate23()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate24()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate25()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate26()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate27()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate28()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate29()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate30()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate31()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate32()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate33()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate34()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate35()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate36()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate37()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate38()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate39()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate40()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate41()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate42()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate43()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate44()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate45()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate46()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate47()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate48()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate49()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate50()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate51()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate52()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate53()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate54()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate55()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate56()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate57()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate58()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate59()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate60()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate61()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate62()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate63()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate64()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate65()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate66()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate67()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate68()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate69()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate70()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate71()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate72()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate73()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate74()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate75()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate76()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate77()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate78()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate79()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate80()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate81()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate82()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate83()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate84()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate85()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate86()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate87()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate88()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate89()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate90()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate91()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate92()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate93()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate94()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate95()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate96()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate97()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate98()));
        vrate.put(i++, getVrate(pBM_RateV2.getVrate99()));

        return vrate;
    }

    private BizNumber getVrate(BizNumber vrate) {
        return vrate == null ? BizNumber.ZERO : vrate;
    }
}
