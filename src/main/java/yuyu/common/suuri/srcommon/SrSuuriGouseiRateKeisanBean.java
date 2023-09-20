package yuyu.common.suuri.srcommon;

import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_SuuriKyoutuuErrorKbn;

/**
 * 数理 数理共通 数理用合成レート計算Bean
 */
public class SrSuuriGouseiRateKeisanBean {

    private C_ErrorKbn errorKbn;

    private C_SuuriKyoutuuErrorKbn suuriKyoutuuErrorKbn;

    private BizNumber suuriGouseiRate;

    private SetErrMessageInfoBean errMessageInfoBean;

    public C_ErrorKbn getErrorKbn() {
        return errorKbn;
    }

    public void setErrorKbn(C_ErrorKbn pErrorKbn) {
        errorKbn = pErrorKbn;
    }

    public C_SuuriKyoutuuErrorKbn getSuuriKyoutuuErrorKbn() {
        return suuriKyoutuuErrorKbn;
    }

    public void setSuuriKyoutuuErrorKbn(C_SuuriKyoutuuErrorKbn pSuuriKyoutuuErrorKbn) {
        suuriKyoutuuErrorKbn = pSuuriKyoutuuErrorKbn;
    }

    public BizNumber getSuuriGouseiRate() {
        return suuriGouseiRate;
    }

    public void setSuuriGouseiRate(BizNumber pSuuriGouseiRate) {
        suuriGouseiRate = pSuuriGouseiRate;
    }

    public SetErrMessageInfoBean getErrMessageInfoBean() {
        return errMessageInfoBean;
    }

    public void setErrMessageInfoBean(SetErrMessageInfoBean pErrMessageInfoBean) {
        errMessageInfoBean = pErrMessageInfoBean;
    }

}
