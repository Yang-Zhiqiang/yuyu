package yuyu.common.biz.bzcommon;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizNumber;

import org.slf4j.Logger;

import yuyu.def.biz.detacher.BM_RateNenkinPkisoVDetacher;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_NenkinJimuTesuuryouKbn;
import yuyu.def.classification.C_NenkinKbn;
import yuyu.def.classification.C_NenkinKigouSedaiKbn;
import yuyu.def.classification.C_NenkinVRateGetKbn;
import yuyu.def.classification.C_RateGetErrorKbn;
import yuyu.def.db.entity.BM_RateNenkinPkisoV;

/**
 * 業務共通 業務共通 年金開始後Ｐ基礎Ｖレート取得クラス
 */
public class BzGetNenkinPkisoVrate {

    private static final int RATE = 100000;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private static Logger logger;

    public BzGetNenkinPkisoVrate() {
        super();
    }

    public BzGetNenkinPkisoVrateBean exec(
            C_NenkinKbn pNenkinKbn,
            String pNenkinsyu,
            C_NenkinKigouSedaiKbn pNenkinKigouSedaiKbn,
            String pNkshrkkn,
            String pNenkinkaisigoyoteiriritukbn,
            C_NenkinJimuTesuuryouKbn pNenkinJimuTesuuryouKbn,
            C_NenkinVRateGetKbn pNenkinVRateGetKbn,
            int pKeikanensuu) {

        logger.debug("▽ 年金開始後Ｐ基礎Ｖレート取得 開始");

        BzGetNenkinPkisoVrateBean bzGetNenkinPkisoVrateBean = SWAKInjector.getInstance(BzGetNenkinPkisoVrateBean.class);

        String palNenkinSisutemuSyurui = "";

        String palNenkinKigouSedaiCode = "";

        String palNnknKsgjmtesuuryouCode = "";

        C_ErrorKbn errorKbn = chkKeikaNensu(
                pKeikanensuu,
                pNkshrkkn,
                pNenkinVRateGetKbn);

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

            bzGetNenkinPkisoVrateBean.setErrorKbn(C_ErrorKbn.ERROR);

            bzGetNenkinPkisoVrateBean.setRateGetErrorKbn(C_RateGetErrorKbn.INPUTERROR);

            logger.debug("△ 年金開始後Ｐ基礎Ｖレート取得 終了");

            return bzGetNenkinPkisoVrateBean;

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

        BM_RateNenkinPkisoV bM_RateNenkinPkisoV = bizDomManager.getRateNenkinPkisoV(
                palNenkinSisutemuSyurui,
                pNenkinsyu.substring(0, 2),
                palNenkinKigouSedaiCode,
                pNkshrkkn,
                pNenkinkaisigoyoteiriritukbn,
                palNnknKsgjmtesuuryouCode);

        if (bM_RateNenkinPkisoV == null) {

            bzGetNenkinPkisoVrateBean.setErrorKbn(C_ErrorKbn.ERROR);
        }
        else {

            bM_RateNenkinPkisoV = BM_RateNenkinPkisoVDetacher.detachRateNenkinPkisoVtouched(bM_RateNenkinPkisoV);

            HashMap<Integer, BizNumber> nenkinPkisoVrate = new HashMap<>();

            if (C_NenkinVRateGetKbn.ALL.eq(pNenkinVRateGetKbn)) {
                for (int n = 0; n <= 99; n++) {
                    nenkinPkisoVrate.put(n, getData(bM_RateNenkinPkisoV, n).divide(RATE));
                }
            }
            else if (C_NenkinVRateGetKbn.ONEYEAR.eq(pNenkinVRateGetKbn)) {
                nenkinPkisoVrate.put(0, getData(bM_RateNenkinPkisoV, pKeikanensuu).divide(RATE));
            }
            else if (C_NenkinVRateGetKbn.TWOYEARS.eq(pNenkinVRateGetKbn)) {
                nenkinPkisoVrate.put(0, getData(bM_RateNenkinPkisoV, pKeikanensuu).divide(RATE));

                nenkinPkisoVrate.put(1, getData(bM_RateNenkinPkisoV, pKeikanensuu + 1).divide(RATE));

            }

            bzGetNenkinPkisoVrateBean.setNenkinKaisigovRate(nenkinPkisoVrate);
            bzGetNenkinPkisoVrateBean.setErrorKbn(C_ErrorKbn.OK);
        }

        logger.debug("△ 年金開始後Ｐ基礎Ｖレート取得 終了");

        return bzGetNenkinPkisoVrateBean;
    }

    private C_ErrorKbn chkKeikaNensu(
            int pKeikanensuu,
            String pNkshrkkn,
            C_NenkinVRateGetKbn pNenkinVRateGetKbn) {

        C_ErrorKbn errorKbn = null;

        if (pKeikanensuu > Integer.parseInt(pNkshrkkn)) {

            errorKbn = C_ErrorKbn.ERROR;
        }
        else if (C_NenkinVRateGetKbn.TWOYEARS.eq(pNenkinVRateGetKbn) && pKeikanensuu == 99) {

            errorKbn = C_ErrorKbn.ERROR;
        }
        else {

            errorKbn = C_ErrorKbn.OK;
        }

        return errorKbn;
    }

    private BizNumber getData(BM_RateNenkinPkisoV pBM_RateNenkinPkisoV, int pKeikanensuu) {

        BizNumber getData = BizNumber.ZERO;

        try {
            PropertyDescriptor propertyDescriptor = new PropertyDescriptor(
                    "nenkinkaisigopkisovrate".concat(
                            String.format("%02d", pKeikanensuu)),
                            pBM_RateNenkinPkisoV.getClass());

            Method getMethod = propertyDescriptor.getReadMethod();

            if (getMethod.invoke(pBM_RateNenkinPkisoV) != null
                    && !BizUtil.isBlank(getMethod.invoke(pBM_RateNenkinPkisoV).toString())) {
                getData = BizNumber.valueOf(Integer.parseInt(getMethod.invoke(pBM_RateNenkinPkisoV).toString()));
            }

        } catch (Exception e) {
        }

        return getData;
    }
}