package yuyu.batch.suuri.srsuuritoukei.srkyhkinshrjyukyurnrk;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import jp.co.slcs.swak.date.BizDateYM;
import yuyu.common.biz.bzcommon.BzBatchParam;
/**
 * （数理）給付金支払状況連絡情報作成バッチパラメータクラス。<br />
 */
@BatchScoped
public class SrKyhkinShrJyukyuRnrkBatchParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    public static final String KAKUTYOUJOBCD_SRKYHKINSHRJYUKYURNRK_HONBANSOUKOU = "RGIWM000";

    public SrKyhkinShrJyukyuRnrkBatchParam() {
    }

    private BizDateYM tysyttaisyouYm;

    public BizDateYM getTysyttaisyouYm() {
        return tysyttaisyouYm;
    }

    public void setTysyttaisyouYm(BizDateYM pTysyttaisyouYm) {
        tysyttaisyouYm = pTysyttaisyouYm;
    }

    private int syoriKensuu;

    public int getSyoriKensuu() {
        return syoriKensuu;
    }

    public void setSyoriKensuu(int pSyoriKensuu) {
        syoriKensuu = pSyoriKensuu;
    }

    private int errorSyoriKensuu;

    public int getErrorSyoriKensuu() {
        return errorSyoriKensuu;
    }

    public void setErrorSyoriKensuu(int pErrorSyoriKensuu) {
        errorSyoriKensuu = pErrorSyoriKensuu;
    }

    public void setParam() {

        tysyttaisyouYm = super.getSyoriYmd().getBizDateYM().addMonths(-1);

    }
}
