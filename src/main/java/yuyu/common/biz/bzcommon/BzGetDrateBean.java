package yuyu.common.biz.bzcommon;

import java.io.Serializable;
import java.util.HashMap;

import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_RateGetErrorKbn;

/**
 * 業務共通 業務共通 Ｄレート取得結果Ｂｅａｎクラス
 */
public class BzGetDrateBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private C_ErrorKbn errorKbn = null;

    private C_RateGetErrorKbn rateGetErrorKbn = null;

    private HashMap<Integer, BizNumber> drate = null;

    private HashMap<Integer, BizNumber> shisaDrate = null;

    private HashMap<Integer, BizNumber> risaDrate = null;

    private HashMap<Integer, BizNumber> hisaDrate = null;

    private HashMap<Integer, BizNumber> dyouVrate = null;

    private HashMap<Integer, BizNumber> kikenSrate = null;

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

    public HashMap<Integer, BizNumber> getDrate() {
        return drate;
    }

    public void setDrate(HashMap<Integer, BizNumber> pDrate) {
        this.drate = pDrate;
    }

    public HashMap<Integer, BizNumber> getShisaDrate() {
        return shisaDrate;
    }

    public void setShisaDrate(HashMap<Integer, BizNumber> pShisaDrate) {
        this.shisaDrate = pShisaDrate;
    }

    public HashMap<Integer, BizNumber> getRisaDrate() {
        return risaDrate;
    }

    public void setRisaDrate(HashMap<Integer, BizNumber> pRisaDrate) {
        this.risaDrate = pRisaDrate;
    }

    public HashMap<Integer, BizNumber> getHisaDrate() {
        return hisaDrate;
    }

    public void setHisaDrate(HashMap<Integer, BizNumber> pHisaDrate) {
        this.hisaDrate = pHisaDrate;
    }

    public HashMap<Integer, BizNumber> getDyouVrate() {
        return dyouVrate;
    }

    public void setDyouVrate(HashMap<Integer, BizNumber> pDyouVrate) {
        this.dyouVrate = pDyouVrate;
    }

    public HashMap<Integer, BizNumber> getKikenSrate() {
        return kikenSrate;
    }

    public void setKikenSrate(HashMap<Integer, BizNumber> pKikenSrate) {
        this.kikenSrate = pKikenSrate;
    }

}
