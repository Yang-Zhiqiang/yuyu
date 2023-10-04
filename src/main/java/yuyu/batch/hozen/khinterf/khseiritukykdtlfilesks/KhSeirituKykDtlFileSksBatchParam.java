package yuyu.batch.hozen.khinterf.khseiritukykdtlfilesks;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.BzBatchParam;

/**
 * 成立契約明細ファイル作成パラメータクラス
 */
@BatchScoped
public class KhSeirituKykDtlFileSksBatchParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    private BizDate kykYmdFrom;

    private BizDate kykYmdTo;

    public BizDate getKykYmdFrom() {
        return kykYmdFrom;
    }

    public void setKykYmdFrom(BizDate kykYmdFrom) {
        this.kykYmdFrom = kykYmdFrom;
    }

    public BizDate getKykYmdTo() {
        return kykYmdTo;
    }

    public void setKykYmdTo(BizDate kykYmdTo) {
        this.kykYmdTo = kykYmdTo;
    }

}