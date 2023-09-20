package yuyu.common.suuri.srcommon;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_SuuriKyoutuuErrorKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_YouhiKbn;

/**
 * 数理 数理共通 数理用合成レート計算
 */
public class SrSuuriGouseiRateKeisan {

    private final BizNumber ZERO = BizNumber.valueOf(0);

    private final String ORIGINALDATE = "00000000";

    @Inject
    private static Logger logger;

    public SrSuuriGouseiRateKeisan() {
        super();
    }

    public SrSuuriGouseiRateKeisanBean exec(BizDate pKwsrateKjYmd,
        C_Tuukasyu pHrktuukasyu, BizNumber pCrossRate) {

        logger.debug("▽ 数理用合成レート計算 開始");

        SrSuuriGouseiRateKeisanBean srSuuriGouseiRateKeisanBean =
            SWAKInjector.getInstance(SrSuuriGouseiRateKeisanBean.class);

        srSuuriGouseiRateKeisanBean.setErrorKbn(C_ErrorKbn.OK);

        srSuuriGouseiRateKeisanBean.setSuuriKyoutuuErrorKbn(C_SuuriKyoutuuErrorKbn.NONE);

        srSuuriGouseiRateKeisanBean.setSuuriGouseiRate(BizNumber.valueOf(0));

        SetErrMessageInfoBean setErrMessageInfoBean = SWAKInjector.getInstance(SetErrMessageInfoBean.class);

        setErrMessageInfoBean.setKwsrateKjYmd(BizDate.valueOf(ORIGINALDATE));

        setErrMessageInfoBean.setKawaserateSyuruiKbn(C_KawaserateSyuruiKbn.BLNK);

        setErrMessageInfoBean.setMotoTuukasyu(C_Tuukasyu.BLNK);

        setErrMessageInfoBean.setKansanTuukasyu(C_Tuukasyu.BLNK);

        setErrMessageInfoBean.setKawasetekiyoKbn(C_KawasetekiyoKbn.BLNK);

        setErrMessageInfoBean.setKawasetsryKbn(C_KawasetsryKbn.BLNK);

        setErrMessageInfoBean.setEigyoubiHoseiKbn(C_EigyoubiHoseiKbn.BLNK);

        setErrMessageInfoBean.setYouhiKbn(C_YouhiKbn.HUYOU);

        srSuuriGouseiRateKeisanBean.setErrMessageInfoBean(setErrMessageInfoBean);

        if (pKwsrateKjYmd == null) {

            srSuuriGouseiRateKeisanBean.setErrorKbn(C_ErrorKbn.ERROR);
        }

        if (pHrktuukasyu == null) {

            srSuuriGouseiRateKeisanBean.setErrorKbn(C_ErrorKbn.ERROR);
        }

        if (pCrossRate == null || ZERO.compareTo(pCrossRate) == 0) {

            srSuuriGouseiRateKeisanBean.setErrorKbn(C_ErrorKbn.ERROR);
        }

        if (C_ErrorKbn.ERROR.eq(srSuuriGouseiRateKeisanBean.getErrorKbn())) {

            srSuuriGouseiRateKeisanBean.setSuuriKyoutuuErrorKbn(C_SuuriKyoutuuErrorKbn.INPUTERROR);

            logger.debug("△ 数理用合成レート計算 終了");

            return srSuuriGouseiRateKeisanBean;
        }

        GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);

        BizNumber hrkTuukaKawaseRate = BizNumber.valueOf(0);

        C_ErrorKbn errorKbn = getKawaseRate.exec(
            pKwsrateKjYmd,
            C_KawaserateSyuruiKbn.PM17JIKAWASERATE,
            pHrktuukasyu,
            C_Tuukasyu.JPY,
            C_KawasetekiyoKbn.TTM,
            C_KawasetsryKbn.JISSEIRATE,
            C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
            C_YouhiKbn.HUYOU);

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

            SetErrMessageInfoBean errMessageInfoBean =
                SWAKInjector.getInstance(SetErrMessageInfoBean.class);

            srSuuriGouseiRateKeisanBean.setErrorKbn(C_ErrorKbn.ERROR);

            errMessageInfoBean.setKwsrateKjYmd(pKwsrateKjYmd);

            errMessageInfoBean.setKawaserateSyuruiKbn(C_KawaserateSyuruiKbn.PM17JIKAWASERATE);

            errMessageInfoBean.setMotoTuukasyu(pHrktuukasyu);

            errMessageInfoBean.setKansanTuukasyu(C_Tuukasyu.JPY);

            errMessageInfoBean.setKawasetekiyoKbn(C_KawasetekiyoKbn.TTM);

            errMessageInfoBean.setKawasetsryKbn(C_KawasetsryKbn.JISSEIRATE);

            errMessageInfoBean.setEigyoubiHoseiKbn(C_EigyoubiHoseiKbn.YOKUEIGYOUBI);

            errMessageInfoBean.setYouhiKbn(C_YouhiKbn.HUYOU);

            srSuuriGouseiRateKeisanBean.setErrMessageInfoBean(errMessageInfoBean);

            srSuuriGouseiRateKeisanBean.setSuuriKyoutuuErrorKbn(C_SuuriKyoutuuErrorKbn.KAWASERATEGETERROR);

            logger.debug("△ 数理用合成レート計算 終了");

            return srSuuriGouseiRateKeisanBean;
        }

        hrkTuukaKawaseRate = getKawaseRate.getKawaserate();

        srSuuriGouseiRateKeisanBean.setSuuriGouseiRate(pCrossRate.multiply(hrkTuukaKawaseRate));

        logger.debug("△ 数理用合成レート計算 終了");

        return srSuuriGouseiRateKeisanBean;

    }
}
