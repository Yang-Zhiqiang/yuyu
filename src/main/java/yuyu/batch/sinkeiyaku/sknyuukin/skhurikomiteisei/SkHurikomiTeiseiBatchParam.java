package yuyu.batch.sinkeiyaku.sknyuukin.skhurikomiteisei;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.def.classification.C_KouzasyuruiKbn;

/**
 * 新契約 入金 振込入金データ訂正パラメータ
 */
@BatchScoped
public class SkHurikomiTeiseiBatchParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    private C_KouzasyuruiKbn kzsyuruikbn;

    public C_KouzasyuruiKbn getKzsyuruikbn() {
        return kzsyuruikbn;
    }

    public void setKzsyuruikbn(C_KouzasyuruiKbn pKzsyuruikbn) {
        kzsyuruikbn = pKzsyuruikbn;
    }
}
