package yuyu.batch.sinkeiyaku.sksonota.skkouteisyuuryou;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import yuyu.common.biz.bzcommon.BzBatchParam;

/**
 * 新契約 その他 新契約工程終了処理バッチパラメータ
 */
@BatchScoped
public class SkKouteiSyuuryouBatchParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    private int maxsyoricnt;

    public int getMaxsyoricnt() {

        return maxsyoricnt;
    }

    public void setMaxsyoricnt(int pMaxsyoricnt) {

        this.maxsyoricnt = pMaxsyoricnt;
    }
}

