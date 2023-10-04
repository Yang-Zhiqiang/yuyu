package yuyu.batch.hozen.khkessan.khbikintyusyutu;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.BzBatchParam;

/**
 * 契約保全備金抽出パラメータクラス
 */
@BatchScoped
public class KhBikinTyusyutuBatchParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    private BizDate kessanYmd;

    public BizDate getKessanYmd() {
        return kessanYmd;
    }

    public void setKessanYmd(BizDate pKessanYmd) {
        this.kessanYmd = pKessanYmd;
    }


}