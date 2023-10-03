package yuyu.batch.suuri.srkessan.srskkessandataretentionperiod;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.BzBatchParam;
/**
 * （数理）新契約決算用データ保存期間管理バッチパラメータクラス。<br />
 */
@BatchScoped
public class SrSkKessanDataRetentionPeriodBatchParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    public SrSkKessanDataRetentionPeriodBatchParam() {
    }

    private BizDate delSyoriYmd;

    public BizDate getDelSyoriYmd() {
        return delSyoriYmd;
    }

    public void setDelSyoriYmd(BizDate pDelSyoriYmd) {
        delSyoriYmd = pDelSyoriYmd;
    }

    public void setParam() {

        delSyoriYmd = super.getSyoriYmd().addDays(-180);
    }
}
