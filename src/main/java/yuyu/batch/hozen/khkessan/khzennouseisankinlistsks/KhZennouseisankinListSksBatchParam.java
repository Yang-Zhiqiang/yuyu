package yuyu.batch.hozen.khkessan.khzennouseisankinlistsks;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.BzBatchParam;

/**
 * 契約保全 決算 前納精算金明細リスト作成バッチパラメータクラス
 */
@BatchScoped
public class KhZennouseisankinListSksBatchParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    private BizDate kessanYmd;

    public BizDate getKessanYmd() {
        return kessanYmd;
    }

    public void setKessanYmd(BizDate pKessanYmd) {
        this.kessanYmd = pKessanYmd;
    }


}