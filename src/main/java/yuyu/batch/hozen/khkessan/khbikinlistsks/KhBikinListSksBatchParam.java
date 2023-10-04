package yuyu.batch.hozen.khkessan.khbikinlistsks;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.BzBatchParam;

/**
 * 契約保全 決算 契約保全備金リスト作成（減額）パラメータ
 */
@BatchScoped
public class KhBikinListSksBatchParam extends BzBatchParam {


    private static final long serialVersionUID = 1L;

    private BizDate kessanYmd;

    public BizDate getKessanYmd() {
        return kessanYmd;
    }

    public void setKessanYmd(BizDate pKessanYmd) {
        kessanYmd = pKessanYmd;
    }

}
