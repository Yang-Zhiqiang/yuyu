package yuyu.batch.sinkeiyaku.sknyuukin.skhurikomihuriwake;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.def.classification.C_KouzasyuruiKbn;

/**
 * 新契約 入金  振込入金データ振分のバッチパラメータクラス
 */
@BatchScoped
public class SkHurikomiHuriwakeBatchParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    private C_KouzasyuruiKbn kouzaSyuruiKbn;

    public C_KouzasyuruiKbn getKouzaSyuruiKbn() {
        return kouzaSyuruiKbn;
    }

    public void setKouzaSyuruiKbn(C_KouzasyuruiKbn pKouzaSyuruiKbn) {
        this.kouzaSyuruiKbn = pKouzaSyuruiKbn;
    }
}
