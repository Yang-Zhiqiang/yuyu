package yuyu.batch.sinkeiyaku.sknyuukin.skhurikominyuukin;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import yuyu.common.biz.bzcommon.BzBatchParam;

/**
 * 新契約 入金 振込入金処理バッチパラメータ
 */
@BatchScoped
public class SkHurikomiNyuukinBatchParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    private int maxsyoricnt;

    public int getMaxsyoricnt() {

        return maxsyoricnt;
    }

    public void setMaxsyoricnt(int pMaxsyoricnt) {

        this.maxsyoricnt = pMaxsyoricnt;
    }
}
