package yuyu.batch.biz.bzkaikei.bzkawaseratehanei;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.def.classification.C_KwsrendouKbn;

/**
 * 業務共通 経理・会計 為替レートマスタ反映パラメータ
 */
@BatchScoped
public class BzKawaseRateHaneiBatchParam extends BzBatchParam  {

    private static final long serialVersionUID = 1L;

    private C_KwsrendouKbn kwsrendouKbn;

    public C_KwsrendouKbn getKwsrendouKbn() {
        return kwsrendouKbn;
    }

    public void setKwsrendouKbn(C_KwsrendouKbn pKwsrendouKbn) {
        this.kwsrendouKbn = pKwsrendouKbn;
    }
}
