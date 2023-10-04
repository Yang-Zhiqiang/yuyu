package yuyu.batch.hozen.khkessan.khkessanzennousel;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.BzBatchParam;

/**
 * 契約保全 決算 決算用前納データ抽出パラメータ
 */
@BatchScoped
public class KhKessanZennouSelBatchParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    private BizDate kessanYmd;

    public BizDate getKessanYmd() {
        return kessanYmd;
    }

    public void setKessanYmd(BizDate pKessanYmd) {
        kessanYmd = pKessanYmd;
    }
}