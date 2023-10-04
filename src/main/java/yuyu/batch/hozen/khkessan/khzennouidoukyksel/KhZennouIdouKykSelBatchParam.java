package yuyu.batch.hozen.khkessan.khzennouidoukyksel;

import yuyu.common.biz.bzcommon.BzBatchParam;
import jp.co.slcs.swak.batch.annotation.BatchScoped;
import jp.co.slcs.swak.date.BizDate;

/**
 * 契約保全 決算 前納異動契約データ抽出パラメータ
 */
@BatchScoped
public class KhZennouIdouKykSelBatchParam extends BzBatchParam{
    private static final long serialVersionUID = 1L;

    private BizDate kessanYmd;

    public BizDate getKessanYmd() {
        return kessanYmd;
    }

    public void setKessanYmd(BizDate pKessanYmd) {
        this.kessanYmd = pKessanYmd;
    }
}
