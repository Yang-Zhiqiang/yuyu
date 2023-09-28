package yuyu.common.biz.bzcommon;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizNumber;

import org.slf4j.Logger;

import com.google.common.base.Strings;

import yuyu.common.suuri.srcommon.SrHokenSyuruiKigouSedaiConverter;
import yuyu.def.biz.detacher.BM_RateDDetacher;
import yuyu.def.biz.detacher.BM_RisaHitSyouhnyouRateDDetacher;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_DRateGetKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HaitouKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_NaiteiKakuteiKbn;
import yuyu.def.classification.C_RateGetErrorKbn;
import yuyu.def.db.entity.BM_RateD;
import yuyu.def.db.entity.BM_RisaHitSyouhnyouRateD;
import yuyu.def.db.entity.BM_SyouhnZokusei;

/**
 * 業務共通 業務共通 Ｄレート取得クラス
 */
public class BzGetDrate {

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private static Logger logger;

    @Inject
    private SrHokenSyuruiKigouSedaiConverter hokenSyuruiKigouSedaiConverter;

    public BzGetDrate() {
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
        String pDnendo,
        C_NaiteiKakuteiKbn pNaiteikakuteikbn,
        C_DRateGetKbn pDRateGetKbn,
        int pKeikanensuu) {

        logger.debug("▽ Dレート取得 開始");

        BzGetDrateBean bzGetDrateBean = SWAKInjector.getInstance(BzGetDrateBean.class);

        String palSaimankiHyouji = "";

        String palHhknSei = "";

        String palNaiteikakuteikbn = "";

        String palHrkkaisuu = "";

        C_ErrorKbn errorKbn = chkKeikaNensu(
            pHknkknsmnkbn,
            pKeikanensuu,
            pHknkkn,
            pDRateGetKbn);

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

            bzGetDrateBean.setErrorKbn(C_ErrorKbn.ERROR);

            bzGetDrateBean.setRateGetErrorKbn(C_RateGetErrorKbn.INPUTERROR);

            logger.debug("△ Dレート取得 終了");

            return bzGetDrateBean;

        }

        C_HaitouKbn haitoukbn = C_HaitouKbn.BLNK;

        List<BM_SyouhnZokusei> syouhnZokuseiLst =
            bizDomManager.getSyouhnZokuseisBySyouhncd(pSyouhnCd);
        if (syouhnZokuseiLst.size() != 0) {
            haitoukbn = syouhnZokuseiLst.get(0).getHaitoukbn();
        }

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

        if (C_NaiteiKakuteiKbn.KAKUTEI.eq(pNaiteikakuteikbn)) {

            palNaiteikakuteikbn = "0";
        }
        else if (C_NaiteiKakuteiKbn.NAITEI.eq(pNaiteikakuteikbn)) {

            palNaiteikakuteikbn = "1";
        }

        if (C_Hrkkaisuu.ITIJI.eq(pHrkkaisuu)) {
            palHrkkaisuu = "0";
        }

        if (C_HaitouKbn.RISAHAI.equals(haitoukbn)) {
            BM_RisaHitSyouhnyouRateD bM_RisaHitSyouhnyouRateD = bizDomManager.getRisaHitSyouhnyouRateD(
                pSyouhnCd.substring(0, 2),
                hokenSyuruiKigouSedaiConverter.convert(pRyouritusdNo.substring(0, 1)),
                Strings.padStart(String.valueOf(pYoteiriritu.multiply(10000)), 5, '0').substring(2),
                "9",
                palHrkkaisuu,
                palHhknSei,
                Strings.padStart(String.valueOf(pHhknnen),3,'0'),
                palSaimankiHyouji,
                Strings.padStart(String.valueOf(pHknkkn),2,'0'),
                Strings.padStart(String.valueOf(pHrkkkn),2,'0'),
                pDnendo,
                palNaiteikakuteikbn);

            if (bM_RisaHitSyouhnyouRateD == null) {

                bzGetDrateBean.setErrorKbn(C_ErrorKbn.ERROR);

                bzGetDrateBean.setRateGetErrorKbn(C_RateGetErrorKbn.TARGETERROR);
            }
            else {
                bM_RisaHitSyouhnyouRateD = BM_RisaHitSyouhnyouRateDDetacher.detachRisaHitSyouhnyouRateDtouched(bM_RisaHitSyouhnyouRateD);

                HashMap<Integer, BizNumber> drate = new HashMap<>();

                HashMap<Integer, BizNumber> shisaDrate = new HashMap<>();

                HashMap<Integer, BizNumber> risaDrate = new HashMap<>();

                HashMap<Integer, BizNumber> hisaDrate = new HashMap<>();

                HashMap<Integer, BizNumber> dyouVrate = new HashMap<>();

                HashMap<Integer, BizNumber> kikenSrate = new HashMap<>();

                if (C_DRateGetKbn.ALL.eq(pDRateGetKbn)) {

                    for (int n = 0; n <= 99; n++) {
                        drate.put(n, getDrateFromRisaHitSyouhnyouRateD(bM_RisaHitSyouhnyouRateD, n));
                        shisaDrate.put(n, BizNumber.valueOf(0));
                        risaDrate.put(n, getDrateFromRisaHitSyouhnyouRateD(bM_RisaHitSyouhnyouRateD, n));
                        hisaDrate.put(n, BizNumber.valueOf(0));
                        dyouVrate.put(n, getDyouVrateFromRisaHitSyouhnyouRateD(bM_RisaHitSyouhnyouRateD, n));
                        kikenSrate.put(n, BizNumber.valueOf(0));
                    }
                }
                else if (C_DRateGetKbn.ONEYEAR.eq(pDRateGetKbn)) {
                    drate.put(0, getDrateFromRisaHitSyouhnyouRateD(bM_RisaHitSyouhnyouRateD, pKeikanensuu));
                    shisaDrate.put(0, BizNumber.valueOf(0));
                    risaDrate.put(0, getDrateFromRisaHitSyouhnyouRateD(bM_RisaHitSyouhnyouRateD, pKeikanensuu));
                    hisaDrate.put(0, BizNumber.valueOf(0));
                    dyouVrate.put(0, getDyouVrateFromRisaHitSyouhnyouRateD(bM_RisaHitSyouhnyouRateD, pKeikanensuu));
                    kikenSrate.put(0, BizNumber.valueOf(0));
                }
                else if (C_DRateGetKbn.TWOYEARS.eq(pDRateGetKbn)) {

                    drate.put(0, getDrateFromRisaHitSyouhnyouRateD(bM_RisaHitSyouhnyouRateD, pKeikanensuu));
                    drate.put(1, getDrateFromRisaHitSyouhnyouRateD(bM_RisaHitSyouhnyouRateD, pKeikanensuu + 1));

                    shisaDrate.put(0, BizNumber.valueOf(0));
                    shisaDrate.put(1, BizNumber.valueOf(0));

                    risaDrate.put(0, getDrateFromRisaHitSyouhnyouRateD(bM_RisaHitSyouhnyouRateD, pKeikanensuu));
                    risaDrate.put(1, getDrateFromRisaHitSyouhnyouRateD(bM_RisaHitSyouhnyouRateD, pKeikanensuu + 1));

                    hisaDrate.put(0, BizNumber.valueOf(0));
                    hisaDrate.put(1, BizNumber.valueOf(0));

                    dyouVrate.put(0, getDyouVrateFromRisaHitSyouhnyouRateD(bM_RisaHitSyouhnyouRateD, pKeikanensuu));
                    dyouVrate.put(1, getDyouVrateFromRisaHitSyouhnyouRateD(bM_RisaHitSyouhnyouRateD, pKeikanensuu + 1));

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

        else {
            BM_RateD bM_RateD = bizDomManager.getRateD(
                pSyouhnCd.substring(0, 2),
                hokenSyuruiKigouSedaiConverter.convert(pRyouritusdNo.substring(0, 1)),
                Strings.padStart(String.valueOf(pYoteiriritu.multiply(10000)), 5, '0').substring(2),
                "9",
                palHrkkaisuu,
                palHhknSei,
                Strings.padStart(String.valueOf(pHhknnen),3,'0'),
                palSaimankiHyouji,
                Strings.padStart(String.valueOf(pHknkkn),2,'0'),
                Strings.padStart(String.valueOf(pHrkkkn),2,'0'),
                pDnendo,
                palNaiteikakuteikbn);

            if (bM_RateD == null) {

                bzGetDrateBean.setErrorKbn(C_ErrorKbn.ERROR);

                bzGetDrateBean.setRateGetErrorKbn(C_RateGetErrorKbn.TARGETERROR);
            }
            else {

                bM_RateD = BM_RateDDetacher.detachRateDtouched(bM_RateD);

                HashMap<Integer, BizNumber> drate = new HashMap<>();

                HashMap<Integer, BizNumber> shisaDrate = new HashMap<>();

                HashMap<Integer, BizNumber> risaDrate = new HashMap<>();

                HashMap<Integer, BizNumber> hisaDrate = new HashMap<>();

                HashMap<Integer, BizNumber> dyouVrate = new HashMap<>();

                HashMap<Integer, BizNumber> kikenSrate = new HashMap<>();

                if (C_DRateGetKbn.ALL.eq(pDRateGetKbn)) {

                    for (int n = 0; n <= 99; n++) {
                        drate.put(n, getDrate(bM_RateD, n));
                        shisaDrate.put(n, getSisaDrate(bM_RateD, n));
                        risaDrate.put(n, getRisaDrate(bM_RateD, n));
                        hisaDrate.put(n, getHisaDrate(bM_RateD, n));
                        dyouVrate.put(n, getDyouVrate(bM_RateD, n));
                        kikenSrate.put(n, getKikenSrate(bM_RateD, n));
                    }
                }
                else if (C_DRateGetKbn.ONEYEAR.eq(pDRateGetKbn)) {

                    drate.put(0, getDrate(bM_RateD, pKeikanensuu));
                    shisaDrate.put(0, getSisaDrate(bM_RateD, pKeikanensuu));
                    risaDrate.put(0, getRisaDrate(bM_RateD, pKeikanensuu));
                    hisaDrate.put(0, getHisaDrate(bM_RateD, pKeikanensuu));
                    dyouVrate.put(0, getDyouVrate(bM_RateD, pKeikanensuu));
                    kikenSrate.put(0, getKikenSrate(bM_RateD, pKeikanensuu));
                }
                else if (C_DRateGetKbn.TWOYEARS.eq(pDRateGetKbn)) {

                    drate.put(0, getDrate(bM_RateD, pKeikanensuu));
                    drate.put(1, getDrate(bM_RateD, pKeikanensuu + 1));

                    shisaDrate.put(0, getSisaDrate(bM_RateD, pKeikanensuu));
                    shisaDrate.put(1, getSisaDrate(bM_RateD, pKeikanensuu + 1));

                    risaDrate.put(0, getRisaDrate(bM_RateD, pKeikanensuu));
                    risaDrate.put(1, getRisaDrate(bM_RateD, pKeikanensuu + 1));

                    hisaDrate.put(0, getHisaDrate(bM_RateD, pKeikanensuu));
                    hisaDrate.put(1, getHisaDrate(bM_RateD, pKeikanensuu + 1));

                    dyouVrate.put(0, getDyouVrate(bM_RateD, pKeikanensuu));
                    dyouVrate.put(1, getDyouVrate(bM_RateD, pKeikanensuu + 1));

                    kikenSrate.put(0, getKikenSrate(bM_RateD, pKeikanensuu));
                    kikenSrate.put(1, getKikenSrate(bM_RateD, pKeikanensuu + 1));
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

        logger.debug("△ Dレート取得 終了");

        return bzGetDrateBean;
    }

    private C_ErrorKbn chkKeikaNensu(
        C_HknkknsmnKbn pHknkknsmnKbn,
        int pKeikanensuu,
        int pHknkkn,
        C_DRateGetKbn pDRateGetKbn) {

        C_ErrorKbn errorKbn = null;

        if (C_HknkknsmnKbn.NENMANKI.eq(pHknkknsmnKbn) && pKeikanensuu > pHknkkn) {

            errorKbn = C_ErrorKbn.ERROR;
        }
        else if (C_DRateGetKbn.TWOYEARS.eq(pDRateGetKbn) && pKeikanensuu == 99) {

            errorKbn = C_ErrorKbn.ERROR;
        }
        else {

            errorKbn = C_ErrorKbn.OK;
        }

        return errorKbn;
    }

    private BizNumber getDrate(BM_RateD pBM_RateD, int pKeikanensuu) {

        BizNumber getDrate = BizNumber.ZERO;

        try {
            PropertyDescriptor propertyDescriptor = new PropertyDescriptor(
                "drate".concat(
                    String.format("%02d", pKeikanensuu)),
                    pBM_RateD.getClass());

            Method getMethod = propertyDescriptor.getReadMethod();

            if (getMethod.invoke(pBM_RateD) != null && !BizUtil.isBlank(getMethod.invoke(pBM_RateD).toString())) {
                getDrate = BizNumber.valueOf(new BigDecimal(getMethod.invoke(pBM_RateD).toString()));
            }
        } catch (Exception e) {
        }

        return getDrate;
    }

    private BizNumber getSisaDrate(BM_RateD pBM_RateD, int pKeikanensuu) {

        BizNumber getSisaDrate = BizNumber.ZERO;

        try {
            PropertyDescriptor propertyDescriptor = new PropertyDescriptor(
                "sisadrate".concat(
                    String.format("%02d", pKeikanensuu)),
                    pBM_RateD.getClass());

            Method getMethod = propertyDescriptor.getReadMethod();

            if (getMethod.invoke(pBM_RateD) != null && !BizUtil.isBlank(getMethod.invoke(pBM_RateD).toString())) {
                getSisaDrate = BizNumber.valueOf(new BigDecimal(getMethod.invoke(pBM_RateD).toString()));
            }
        } catch (Exception e) {
        }

        return getSisaDrate;
    }

    private BizNumber getRisaDrate(BM_RateD pBM_RateD, int pKeikanensuu) {

        BizNumber getRisaDrate = BizNumber.ZERO;

        try {
            PropertyDescriptor propertyDescriptor = new PropertyDescriptor(
                "risadrate".concat(
                    String.format("%02d", pKeikanensuu)),
                    pBM_RateD.getClass());

            Method getMethod = propertyDescriptor.getReadMethod();

            if (getMethod.invoke(pBM_RateD) != null && !BizUtil.isBlank(getMethod.invoke(pBM_RateD).toString())) {
                getRisaDrate = BizNumber.valueOf(new BigDecimal(getMethod.invoke(pBM_RateD).toString()));
            }
        } catch (Exception e) {
        }

        return getRisaDrate;
    }

    private BizNumber getHisaDrate(BM_RateD pBM_RateD, int pKeikanensuu) {

        BizNumber getHisaDrate = BizNumber.ZERO;

        try {
            PropertyDescriptor propertyDescriptor = new PropertyDescriptor(
                "hisadrate".concat(
                    String.format("%02d", pKeikanensuu)),
                    pBM_RateD.getClass());

            Method getMethod = propertyDescriptor.getReadMethod();

            if (getMethod.invoke(pBM_RateD) != null && !BizUtil.isBlank(getMethod.invoke(pBM_RateD).toString())) {
                getHisaDrate = BizNumber.valueOf(new BigDecimal(getMethod.invoke(pBM_RateD).toString()));
            }
        } catch (Exception e) {
        }

        return getHisaDrate;
    }

    private BizNumber getDyouVrate(BM_RateD pBM_RateD, int pKeikanensuu) {

        BizNumber getDyouVrate = BizNumber.ZERO;

        try {
            PropertyDescriptor propertyDescriptor = new PropertyDescriptor(
                "dyouvrate".concat(
                    String.format("%02d", pKeikanensuu)),
                    pBM_RateD.getClass());

            Method getMethod = propertyDescriptor.getReadMethod();

            if (getMethod.invoke(pBM_RateD) != null && !BizUtil.isBlank(getMethod.invoke(pBM_RateD).toString())) {
                getDyouVrate = BizNumber.valueOf(new BigDecimal(getMethod.invoke(pBM_RateD).toString()));
            }
        } catch (Exception e) {
        }

        return getDyouVrate;
    }

    private BizNumber getKikenSrate(BM_RateD pBM_RateD, int pKeikanensuu) {

        BizNumber getKikenSrate = BizNumber.ZERO;

        try {
            PropertyDescriptor propertyDescriptor = new PropertyDescriptor(
                "kikensrate".concat(
                    String.format("%02d", pKeikanensuu)),
                    pBM_RateD.getClass());

            Method getMethod = propertyDescriptor.getReadMethod();

            if (getMethod.invoke(pBM_RateD) != null && !BizUtil.isBlank(getMethod.invoke(pBM_RateD).toString())) {
                getKikenSrate = BizNumber.valueOf(new BigDecimal(getMethod.invoke(pBM_RateD).toString()));
            }
        } catch (Exception e) {
        }

        return getKikenSrate;
    }

    private BizNumber getDrateFromRisaHitSyouhnyouRateD(BM_RisaHitSyouhnyouRateD pBM_RisaHitSyouhnyouRateD, int pKeikanensuu) {

        BizNumber getDrate = BizNumber.ZERO;

        try {
            PropertyDescriptor propertyDescriptor = new PropertyDescriptor(
                "drate".concat(
                    String.format("%02d", pKeikanensuu)),
                    pBM_RisaHitSyouhnyouRateD.getClass());

            Method getMethod = propertyDescriptor.getReadMethod();

            if (getMethod.invoke(pBM_RisaHitSyouhnyouRateD) != null && !BizUtil.
                isBlank(getMethod.invoke(pBM_RisaHitSyouhnyouRateD).toString())) {
                getDrate = BizNumber.valueOf(new BigDecimal(getMethod.invoke(pBM_RisaHitSyouhnyouRateD).toString()));
            }
        } catch (Exception e) {
        }

        return getDrate;
    }

    private BizNumber getDyouVrateFromRisaHitSyouhnyouRateD(BM_RisaHitSyouhnyouRateD pBM_RisaHitSyouhnyouRateD, int pKeikanensuu) {

        BizNumber getDyouVrate = BizNumber.ZERO;

        try {
            PropertyDescriptor propertyDescriptor = new PropertyDescriptor(
                "dyouvrate".concat(
                    String.format("%02d", pKeikanensuu)),
                    pBM_RisaHitSyouhnyouRateD.getClass());

            Method getMethod = propertyDescriptor.getReadMethod();

            if (getMethod.invoke(pBM_RisaHitSyouhnyouRateD) != null && !BizUtil.
                isBlank(getMethod.invoke(pBM_RisaHitSyouhnyouRateD).toString())) {
                getDyouVrate = BizNumber.valueOf(new BigDecimal(getMethod.invoke(pBM_RisaHitSyouhnyouRateD).toString()));
            }
        } catch (Exception e) {
        }

        return getDyouVrate;
    }
}