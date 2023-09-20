package yuyu.common.suuri.srcommon;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import jp.co.slcs.swak.date.BizDateYM;
import yuyu.common.biz.bzcommon.BzBatchParam;

/**
 *  新契約成立共通パラメータ
 */
@BatchScoped
public class SrSinkykSeirituCommonParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    public static final String RGHEM000 = "RGHEM000";

    public static final String RGHEM001 = "RGHEM001";

    public static final String RGHEM002 = "RGHEM002";

    public static final String RGHEM003 = "RGHEM003";

    public static final String RGHEM004 = "RGHEM004";

    public static final String RGIYM000 = "RGIYM000";

    private BizDateYM tyuusyututaisyouym;

    private int errorsyorikensuu;

    public BizDateYM getTyuusyututaisyouym() {
        return tyuusyututaisyouym;
    }

    public void setTyuusyututaisyouym(BizDateYM pTyuusyututaisyouym) {
        tyuusyututaisyouym = pTyuusyututaisyouym;
    }

    public int getErrorsyorikensuu() {
        return errorsyorikensuu;
    }

    public void setErrorsyorikensuu(int pErrorsyorikensuu) {
        errorsyorikensuu = pErrorsyorikensuu;
    }

    public SrSinkykSeirituCommonParam() {
        super();
    }

    public void setParam() {

        if(RGHEM001.equals(super.getIbKakutyoujobcd())) {

            tyuusyututaisyouym = super.getSyoriYmd().getBizDateYM();
        }
        else if(RGHEM002.equals(super.getIbKakutyoujobcd()) &&
            super.getSyoriYmd().getMonth() == SrCommonConstants.MONTH_DECEMBER) {

            tyuusyututaisyouym = super.getSyoriYmd().getBizDateYM();
        }
        else {

            tyuusyututaisyouym = super.getSyoriYmd().getBizDateYM().addMonths(-1);
        }
    }

}
