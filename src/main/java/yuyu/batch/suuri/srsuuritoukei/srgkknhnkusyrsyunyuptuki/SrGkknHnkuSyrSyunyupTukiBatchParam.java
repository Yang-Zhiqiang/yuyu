package yuyu.batch.suuri.srsuuritoukei.srgkknhnkusyrsyunyuptuki;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.hozen.khcommon.SetDenSimebi;
import yuyu.common.suuri.srcommon.SrCommonConstants;

/**
 * 数理 数理統計 月間変更処理収入Ｐ統計情報作成バッチパラメータ<br />
 */
@BatchScoped
public class SrGkknHnkuSyrSyunyupTukiBatchParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    public static final String GKKNHNK_REIGETSU = "RGIXM000";

    public static final String GKKNHNK_KESSANKIJIZEN = "RGIXM001";

    public static final String GKKNHNK_KESSANKIHONBAN = "RGIXM002";

    public static final String GKKNHNK_KESSANKIJIZEN3 = "RGIXM003";

    private static final String SYORIYM_201905 = "201905";

    private static final String TYSYTYMD_20190331 = "20190331";

    public SrGkknHnkuSyrSyunyupTukiBatchParam() {
    }

    private BizDate tysytstsyFromYmd;

    public BizDate getTysytstsyFromYmd() {
        return tysytstsyFromYmd;
    }

    public void setTysytstsyFromYmd(BizDate pTysytstsyFromYmd) {
        tysytstsyFromYmd = pTysytstsyFromYmd;
    }

    private BizDate tysytstsyToYmd;

    public BizDate getTysytstsyToYmd() {
        return tysytstsyToYmd;
    }

    public void setTysytstsyToYmd(BizDate pTysytstsyToYmd) {
        tysytstsyToYmd = pTysytstsyToYmd;
    }

    private int syoriKensuu;

    public int getSyoriKensuu() {
        return syoriKensuu;
    }

    public void setSyoriKensuu(int pSyoriKensuu) {
        syoriKensuu = pSyoriKensuu;
    }

    private int itSyoriKensuu;

    public int getItSyoriKensuu() {
        return itSyoriKensuu;
    }

    public void setItSyoriKensuu(int pItSyoriKensuu) {
        itSyoriKensuu = pItSyoriKensuu;
    }

    private int errorSyoriKensuu;

    public int getErrorSyoriKensuu() {
        return errorSyoriKensuu;
    }

    public void setErrorSyoriKensuu(int pErrorSyoriKensuu) {
        errorSyoriKensuu = pErrorSyoriKensuu;
    }
    
    private BizDate zenkaiDenSimeYmd;

    public BizDate getZenkaiDenSimeYmd() {
        return zenkaiDenSimeYmd;
    }

    public void setZenkaiDenSimeYmd(BizDate pZenkaiDenSimeYmd) {
        zenkaiDenSimeYmd = pZenkaiDenSimeYmd;
    }
    
    void setParam() {

        BizDate syoriYmdHoseigo = null;

        if (getIbKakutyoujobcd().equals(GKKNHNK_KESSANKIJIZEN) &&
            getSyoriYmd().getMonth() ==  SrCommonConstants.MONTH_DECEMBER) {
            syoriYmdHoseigo = getSyoriYmd().addMonths(1);
        }
        else {
            syoriYmdHoseigo = getSyoriYmd();
        }

        SetDenSimebi setDenSimebi = SWAKInjector.getInstance(SetDenSimebi.class);

        setZenkaiDenSimeYmd(setDenSimebi.exec(syoriYmdHoseigo.addMonths(-1)));
        
        setTysytstsyFromYmd(getZenkaiDenSimeYmd());

        if (BizDateUtil.compareYm(getSyoriYmd().getBizDateYM(), BizDateYM.valueOf(
            SYORIYM_201905)) == BizDateUtil.COMPARE_EQUAL) {

            setTysytstsyFromYmd(BizDate.valueOf(TYSYTYMD_20190331));
        }

        setTysytstsyToYmd(setDenSimebi.exec(syoriYmdHoseigo));

    }
}
