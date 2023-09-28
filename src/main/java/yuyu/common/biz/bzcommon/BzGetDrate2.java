package yuyu.common.biz.bzcommon;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.HashMap;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizNumber;

import org.slf4j.Logger;

import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.biz.detacher.BM_RisaHitSyouhnyouRateD2Detacher;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_DRateGetKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HokenSyuruiKigouSedaiKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_NaiteiKakuteiKbn;
import yuyu.def.classification.C_RateGetErrorKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_RisaHitSyouhnyouRateD2;

/**
 * 業務共通 業務共通 Ｄレート取得クラス２
 */
public class BzGetDrate2 {

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private static Logger logger;

    private static final int KEIKANENSUU_MIN = 0;

    private static final int KEIKANENSUU_MAX = 99;

    private static final String DNEND_KIJYUN = "2021";

    private static final String PMEN_NASI = "9";

    public BzGetDrate2() {
        super();
    }

    public BzGetDrateBean exec(
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
        String pDnendo,
        C_NaiteiKakuteiKbn pNaiteikakuteikbn,
        C_DRateGetKbn pDRateGetKbn,
        int pKeikanensuu) {

        logger.debug("▽ Ｄレート取得２ 開始");

        BzGetDrateBean bzGetDrateBean = SWAKInjector.getInstance(BzGetDrateBean.class);
        String hokenSyuruiKigouSedaiKbn = pRyouritusdNo.substring(0, 1);

        int syohinHanteiKbn = SyouhinUtil.hantei(pSyouhnCd.substring(0, 2));

        if ((syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR ||
                syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19) &&
            (hokenSyuruiKigouSedaiKbn.equals(C_HokenSyuruiKigouSedaiKbn.RYOU17.getValue()) ||
                hokenSyuruiKigouSedaiKbn.equals(C_HokenSyuruiKigouSedaiKbn.RYOU18_4.getValue()) ||
                hokenSyuruiKigouSedaiKbn.equals(C_HokenSyuruiKigouSedaiKbn.RYOU18_8.getValue())) &&
            (DNEND_KIJYUN.compareTo(pDnendo) > 0 ||
                (DNEND_KIJYUN.equals(pDnendo) && C_NaiteiKakuteiKbn.NAITEI.eq(pNaiteikakuteikbn)))) {

            BzGetDrate bzGetDrate = SWAKInjector.getInstance(BzGetDrate.class);
            bzGetDrateBean = bzGetDrate.exec(
                pSyouhnCd.substring(0, 2),
                pRyouritusdNo,
                pYoteiriritu,
                pHrkkaisuu,
                pHhknsei,
                pHhknnen,
                pHknkknsmnkbn,
                pHknkkn,
                pHrkkkn,
                pDnendo,
                pNaiteikakuteikbn,
                pDRateGetKbn,
                pKeikanensuu);
        }
        else {

            C_ErrorKbn errorKbn = chkKeikaNensu(
                pHknkknsmnkbn,
                pKeikanensuu,
                pHknkkn,
                pDRateGetKbn);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                bzGetDrateBean.setErrorKbn(C_ErrorKbn.ERROR);

                bzGetDrateBean.setRateGetErrorKbn(C_RateGetErrorKbn.INPUTERROR);

                logger.debug("△ Ｄレート取得２ 終了");

                return bzGetDrateBean;

            }

            BzRateKoumokuHenkanSet bzRateKoumokuHenkanSet = SWAKInjector.getInstance(BzRateKoumokuHenkanSet.class);
            BM_RisaHitSyouhnyouRateD2 bM_RisaHitSyouhnyouRateD2 = new BM_RisaHitSyouhnyouRateD2();

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
                pNaiteikakuteikbn);

            if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR ||
                syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19) {

                bM_RisaHitSyouhnyouRateD2 = bizDomManager.getRisaHitSyouhnyouRateD2byRisaHitSyouhnyouRateDkey(
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
                    pDnendo,
                    bzRateKoumokuHenkanSetBean.getPaldratenaikakucode());

            }
            else {

                bM_RisaHitSyouhnyouRateD2 = bizDomManager.getRisaHitSyouhnyouRateD2(
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
                    pDnendo,
                    bzRateKoumokuHenkanSetBean.getPaldratenaikakucode());
            }

            if (bM_RisaHitSyouhnyouRateD2 == null) {

                bzGetDrateBean.setErrorKbn(C_ErrorKbn.ERROR);
                bzGetDrateBean.setRateGetErrorKbn(C_RateGetErrorKbn.TARGETERROR);
            }
            else {

                bM_RisaHitSyouhnyouRateD2 = BM_RisaHitSyouhnyouRateD2Detacher.detachRisaHitSyouhnyouRateD2touched(bM_RisaHitSyouhnyouRateD2);

                HashMap<Integer, BizNumber> drate = new HashMap<>();

                HashMap<Integer, BizNumber> shisaDrate = new HashMap<>();

                HashMap<Integer, BizNumber> risaDrate = new HashMap<>();

                HashMap<Integer, BizNumber> hisaDrate = new HashMap<>();

                HashMap<Integer, BizNumber> dyouVrate = new HashMap<>();

                HashMap<Integer, BizNumber> kikenSrate = new HashMap<>();

                if (C_DRateGetKbn.ALL.eq(pDRateGetKbn)) {

                    for (int n = 0; n <= 99; n++) {

                        drate.put(n, getDrateFromRisaHitSyouhnyouRateD2(bM_RisaHitSyouhnyouRateD2, n));
                        shisaDrate.put(n, BizNumber.valueOf(0));
                        risaDrate.put(n, getDrateFromRisaHitSyouhnyouRateD2(bM_RisaHitSyouhnyouRateD2, n));
                        hisaDrate.put(n, BizNumber.valueOf(0));
                        dyouVrate.put(n, getDyouVrateFromRisaHitSyouhnyouRateD2(bM_RisaHitSyouhnyouRateD2, n));
                        kikenSrate.put(n, BizNumber.valueOf(0));
                    }
                }
                else if (C_DRateGetKbn.ONEYEAR.eq(pDRateGetKbn)) {

                    drate.put(0, getDrateFromRisaHitSyouhnyouRateD2(bM_RisaHitSyouhnyouRateD2, pKeikanensuu));
                    shisaDrate.put(0, BizNumber.valueOf(0));
                    risaDrate.put(0, getDrateFromRisaHitSyouhnyouRateD2(bM_RisaHitSyouhnyouRateD2, pKeikanensuu));
                    hisaDrate.put(0, BizNumber.valueOf(0));
                    dyouVrate.put(0, getDyouVrateFromRisaHitSyouhnyouRateD2(bM_RisaHitSyouhnyouRateD2, pKeikanensuu));
                    kikenSrate.put(0, BizNumber.valueOf(0));
                }
                else if (C_DRateGetKbn.TWOYEARS.eq(pDRateGetKbn)) {

                    drate.put(0, getDrateFromRisaHitSyouhnyouRateD2(bM_RisaHitSyouhnyouRateD2, pKeikanensuu));
                    drate.put(1, getDrateFromRisaHitSyouhnyouRateD2(bM_RisaHitSyouhnyouRateD2, pKeikanensuu + 1));

                    shisaDrate.put(0, BizNumber.valueOf(0));
                    shisaDrate.put(1, BizNumber.valueOf(0));

                    risaDrate.put(0, getDrateFromRisaHitSyouhnyouRateD2(bM_RisaHitSyouhnyouRateD2, pKeikanensuu));
                    risaDrate.put(1, getDrateFromRisaHitSyouhnyouRateD2(bM_RisaHitSyouhnyouRateD2, pKeikanensuu + 1));

                    hisaDrate.put(0, BizNumber.valueOf(0));
                    hisaDrate.put(1, BizNumber.valueOf(0));

                    dyouVrate.put(0, getDyouVrateFromRisaHitSyouhnyouRateD2(bM_RisaHitSyouhnyouRateD2, pKeikanensuu));
                    dyouVrate.put(1, getDyouVrateFromRisaHitSyouhnyouRateD2(bM_RisaHitSyouhnyouRateD2, pKeikanensuu + 1));

                    kikenSrate.put(0, BizNumber.valueOf(0));
                    kikenSrate.put(1, BizNumber.valueOf(0));
                }

                bzGetDrateBean.setDrate(drate);
                bzGetDrateBean.setShisaDrate(shisaDrate);
                bzGetDrateBean.setRisaDrate(risaDrate);
                bzGetDrateBean.setHisaDrate(hisaDrate);
                bzGetDrateBean.setDyouVrate(dyouVrate);
                bzGetDrateBean.setKikenSrate(kikenSrate);

                bzGetDrateBean.setErrorKbn(C_ErrorKbn.OK);
            }
        }


        logger.debug("△ Ｄレート取得２ 終了");

        return bzGetDrateBean;
    }

    private C_ErrorKbn chkKeikaNensu(
        C_HknkknsmnKbn pHknkknsmnKbn,
        int pKeikanensuu,
        int pHknkkn,
        C_DRateGetKbn pDRateGetKbn) {

        C_ErrorKbn errorKbn = null;

        if (pKeikanensuu < KEIKANENSUU_MIN || pKeikanensuu > KEIKANENSUU_MAX) {

            errorKbn = C_ErrorKbn.ERROR;
        }
        else if (C_HknkknsmnKbn.NENMANKI.eq(pHknkknsmnKbn) && pKeikanensuu > pHknkkn) {

            errorKbn = C_ErrorKbn.ERROR;
        }
        else if (C_DRateGetKbn.TWOYEARS.eq(pDRateGetKbn) && pKeikanensuu == KEIKANENSUU_MAX) {

            errorKbn = C_ErrorKbn.ERROR;
        }
        else {

            errorKbn = C_ErrorKbn.OK;
        }

        return errorKbn;
    }

    private BizNumber getDrateFromRisaHitSyouhnyouRateD2(BM_RisaHitSyouhnyouRateD2 pBM_RisaHitSyouhnyouRateD2, int pKeikanensuu) {

        BizNumber getDrate = BizNumber.ZERO;

        try {
            PropertyDescriptor propertyDescriptor = new PropertyDescriptor(
                "drate".concat(
                    String.format("%02d", pKeikanensuu)),
                    pBM_RisaHitSyouhnyouRateD2.getClass());

            Method getMethod = propertyDescriptor.getReadMethod();

            if (getMethod.invoke(pBM_RisaHitSyouhnyouRateD2) != null && !BizUtil.
                isBlank(getMethod.invoke(pBM_RisaHitSyouhnyouRateD2).toString())) {
                getDrate = BizNumber.valueOf(new BigDecimal(getMethod.invoke(pBM_RisaHitSyouhnyouRateD2).toString()));
            }
        } catch (Exception e) {
        }

        return getDrate;
    }

    private BizNumber getDyouVrateFromRisaHitSyouhnyouRateD2(BM_RisaHitSyouhnyouRateD2 pBM_RisaHitSyouhnyouRateD2, int pKeikanensuu) {

        BizNumber getDyouVrate = BizNumber.ZERO;

        try {
            PropertyDescriptor propertyDescriptor = new PropertyDescriptor(
                "dyouvrate".concat(
                    String.format("%02d", pKeikanensuu)),
                    pBM_RisaHitSyouhnyouRateD2.getClass());

            Method getMethod = propertyDescriptor.getReadMethod();

            if (getMethod.invoke(pBM_RisaHitSyouhnyouRateD2) != null && !BizUtil.
                isBlank(getMethod.invoke(pBM_RisaHitSyouhnyouRateD2).toString())) {
                getDyouVrate = BizNumber.valueOf(new BigDecimal(getMethod.invoke(pBM_RisaHitSyouhnyouRateD2).toString()));
            }
        } catch (Exception e) {
        }

        return getDyouVrate;
    }
}