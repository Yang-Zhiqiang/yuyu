package yuyu.batch.suuri.srsuuritoukei.srsibouriturendou;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import jp.co.slcs.swak.date.BizDateYM;
import yuyu.common.biz.bzcommon.BzBatchParam;

/**
 * 死亡率用連動情報作成パラメータクラス
 */
@BatchScoped
public class SrSibourituRendouBatchParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    public SrSibourituRendouBatchParam() {
    }

    public static final String RGHGM = "RGHGM000";

    private BizDateYM tysyttaisyouym;

    private int syorikensuu;

    private int errorkensuu;

    public BizDateYM getTysyttaisyouym() {
        return tysyttaisyouym;
    }

    public void setTysyttaisyouym(BizDateYM pTysyttaisyouym) {
        tysyttaisyouym = pTysyttaisyouym;
    }

    public int getSyorikensuu() {
        return syorikensuu;
    }

    public void setSyorikensuu(int pSyorikensuu) {
        syorikensuu = pSyorikensuu;
    }

    public int getErrorkensuu() {
        return errorkensuu;
    }

    public void setErrorkensuu(int pErrorkensuu) {
        errorkensuu = pErrorkensuu;
    }

    public void setParam() {

        setTysyttaisyouym(super.getSyoriYmd().getBizDateYM().addMonths(-5));
    }
}
