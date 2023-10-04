package yuyu.batch.sinkeiyaku.skmousikomi.skpaperlessmousikomi;

import yuyu.common.biz.bzcommon.BzBatchParam;
import jp.co.slcs.swak.batch.annotation.BatchScoped;

/**
 * 新契約 申込入力 ペーパーレス申込書入力バッチパラメータ
 */
@BatchScoped
public class SkPaperlessMousikomiBatchParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    private int maxsyoricnt;

    public int getMaxsyoricnt() {

        return maxsyoricnt;
    }

    public void setMaxsyoricnt(int pMaxsyoricnt) {

        this.maxsyoricnt = pMaxsyoricnt;
    }
}
