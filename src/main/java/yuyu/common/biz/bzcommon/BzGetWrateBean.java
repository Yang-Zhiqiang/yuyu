package yuyu.common.biz.bzcommon;

import java.io.Serializable;
import java.util.HashMap;

import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_RateGetErrorKbn;

/**
 * 業務共通 業務共通 Ｗレート取得結果Ｂｅａｎクラス
 */
public class BzGetWrateBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private C_ErrorKbn errorKbn = null;

    private C_RateGetErrorKbn rateGetErrorKbn = null;

    private HashMap<Integer,BizNumber> wrate = null;

    public C_ErrorKbn getErrorKbn() {
        return errorKbn;
    }

    public void setErrorKbn(C_ErrorKbn pErrorKbn) {
        this.errorKbn = pErrorKbn;
    }

    public C_RateGetErrorKbn getRateGetErrorKbn() {
        return rateGetErrorKbn;
    }

    public void setRateGetErrorKbn(C_RateGetErrorKbn pRateGetErrorKbn) {
        this.rateGetErrorKbn = pRateGetErrorKbn;
    }

    public HashMap<Integer,BizNumber> getWrate() {
        return wrate;
    }

    public void setWrate(HashMap<Integer,BizNumber> pWrate) {
        this.wrate = pWrate;
    }
}
