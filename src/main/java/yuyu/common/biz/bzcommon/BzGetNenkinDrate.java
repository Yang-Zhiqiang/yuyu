package yuyu.common.biz.bzcommon;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizNumber;

import org.slf4j.Logger;

import yuyu.def.biz.detacher.BM_RateNenkinDDetacher;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_NaiteiKakuteiKbn;
import yuyu.def.classification.C_NenkinDRateGetKbn;
import yuyu.def.classification.C_NenkinJimuTesuuryouKbn;
import yuyu.def.classification.C_NenkinKbn;
import yuyu.def.classification.C_NenkinKigouSedaiKbn;
import yuyu.def.classification.C_RateGetErrorKbn;
import yuyu.def.db.entity.BM_RateNenkinD;

/**
 * 業務共通 業務共通 年金開始後Ｄレート取得クラス
 */
public class BzGetNenkinDrate {

    private static final int RATE = 100000;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private static Logger logger;

    public BzGetNenkinDrate() {
        super();
    }

    public BzGetNenkinDrateBean exec(
            C_NenkinKbn pNenkinKbn,
            String pNenkinsyu,
            C_NenkinKigouSedaiKbn pNenkinKigouSedaiKbn,
            String pNkshrkkn,
            String pNenkinkaisigoyoteiriritukbn,
            C_NenkinJimuTesuuryouKbn pNenkinJimuTesuuryouKbn,
            String pDnendo,
            C_NaiteiKakuteiKbn pNaiteikakuteikbn,
            C_NenkinDRateGetKbn pNenkinDRateGetKbn,
            int pKeikanensuu) {

        logger.debug("▽ 年金開始後Ｄレート取得 開始");

        BzGetNenkinDrateBean bzGetNenkinDrateBean = SWAKInjector.getInstance(BzGetNenkinDrateBean.class);

        String palNenkinSisutemuSyurui = "";

        String palNenkinKigouSedaiCode = "";

        String palNnknKsgjmtesuuryouCode = "";

        String palDrateNaiteikakuteikbn = "";

        C_ErrorKbn errorKbn = chkKeikaNensu(
                pKeikanensuu,
                pNkshrkkn,
                pNenkinDRateGetKbn);

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

            bzGetNenkinDrateBean.setErrorKbn(C_ErrorKbn.ERROR);

            bzGetNenkinDrateBean.setRateGetErrorKbn(C_RateGetErrorKbn.INPUTERROR);

            logger.debug("△ 年金開始後Ｄレート取得 終了");

            return bzGetNenkinDrateBean;

        }

        if (C_NenkinKbn.YUYU.eq(pNenkinKbn)) {

            palNenkinSisutemuSyurui = "6";
        }

        if (C_NenkinKigouSedaiKbn.KAI10S.eq(pNenkinKigouSedaiKbn)) {

            palNenkinKigouSedaiCode = "F";
        }

        if (C_NenkinJimuTesuuryouKbn.PER1_00.eq(pNenkinJimuTesuuryouKbn)) {

            palNnknKsgjmtesuuryouCode = "01";

        }
        else if (C_NenkinJimuTesuuryouKbn.PER1_25.eq(pNenkinJimuTesuuryouKbn)) {

            palNnknKsgjmtesuuryouCode = "02";
        }

        if (C_NaiteiKakuteiKbn.KAKUTEI.eq(pNaiteikakuteikbn)) {

            palDrateNaiteikakuteikbn = "0";
        }
        else if (C_NaiteiKakuteiKbn.NAITEI.eq(pNaiteikakuteikbn)) {

            palDrateNaiteikakuteikbn = "1";
        }

        BM_RateNenkinD bM_RateNenkinD = bizDomManager.getRateNenkinD(
                palNenkinSisutemuSyurui,
                pNenkinsyu.substring(0, 2),
                palNenkinKigouSedaiCode,
                pNkshrkkn,
                pNenkinkaisigoyoteiriritukbn,
                palNnknKsgjmtesuuryouCode,
                pDnendo,
                palDrateNaiteikakuteikbn);

        if (bM_RateNenkinD == null) {

            bzGetNenkinDrateBean.setErrorKbn(C_ErrorKbn.ERROR);
        }
        else {

            bM_RateNenkinD = BM_RateNenkinDDetacher.detachRateNenkinDtouched(bM_RateNenkinD);

            HashMap<Integer, BizNumber> nenkinDrate = new HashMap<>();

            if (C_NenkinDRateGetKbn.ALL.eq(pNenkinDRateGetKbn)) {
                for (int n = 0; n <= 99; n++) {
                    nenkinDrate.put(n, getData(bM_RateNenkinD, n).divide(RATE));
                }
            }
            else if (C_NenkinDRateGetKbn.ONEYEAR.eq(pNenkinDRateGetKbn)) {

                nenkinDrate.put(0, getData(bM_RateNenkinD, pKeikanensuu).divide(RATE));
            }
            else if (C_NenkinDRateGetKbn.TWOYEARS.eq(pNenkinDRateGetKbn)) {
                nenkinDrate.put(0, getData(bM_RateNenkinD, pKeikanensuu).divide(RATE));

                nenkinDrate.put(1, getData(bM_RateNenkinD, pKeikanensuu + 1).divide(RATE));
            }
            bzGetNenkinDrateBean.setNenkinKaisigodRate(nenkinDrate);
            bzGetNenkinDrateBean.setErrorKbn(C_ErrorKbn.OK);
        }

        logger.debug("△ 年金開始後Ｄレート取得 終了");

        return bzGetNenkinDrateBean;
    }

    private C_ErrorKbn chkKeikaNensu(
            int pKeikanensuu,
            String pNkshrkkn,
            C_NenkinDRateGetKbn pNenkinDRateGetKbn) {

        C_ErrorKbn errorKbn = null;

        if (pKeikanensuu > Integer.parseInt(pNkshrkkn)) {

            errorKbn = C_ErrorKbn.ERROR;
        }
        else if (C_NenkinDRateGetKbn.TWOYEARS.eq(pNenkinDRateGetKbn) && pKeikanensuu == 99) {

            errorKbn = C_ErrorKbn.ERROR;
        }
        else {

            errorKbn = C_ErrorKbn.OK;
        }

        return errorKbn;
    }

    private BizNumber getData(BM_RateNenkinD pBM_RateNenkinD, int pKeikanensuu) {

        BizNumber getData = BizNumber.ZERO;

        try {
            PropertyDescriptor propertyDescriptor = new PropertyDescriptor(
                    "nenkinkaisigodrate".concat(
                            String.format("%02d", pKeikanensuu)),
                            pBM_RateNenkinD.getClass());

            Method getMethod = propertyDescriptor.getReadMethod();

            if (getMethod.invoke(pBM_RateNenkinD) != null
                    && !BizUtil.isBlank(getMethod.invoke(pBM_RateNenkinD).toString())) {
                getData = BizNumber.valueOf(Integer.parseInt(getMethod.invoke(pBM_RateNenkinD).toString()));
            }

        } catch (Exception e) {
        }

        return getData;
    }
}