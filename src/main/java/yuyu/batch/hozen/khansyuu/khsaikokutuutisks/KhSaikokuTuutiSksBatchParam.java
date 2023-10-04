package yuyu.batch.hozen.khansyuu.khsaikokutuutisks;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import yuyu.common.biz.bzcommon.BzBatchParam;

/**
 * 契約保全 案内収納 催告通知作成バッチパラメータ
 */
@BatchScoped
public class KhSaikokuTuutiSksBatchParam extends BzBatchParam{

    private static final long serialVersionUID = 1L;

    private String syoriKbn;

    public String getSyoriKbn() {
        return syoriKbn;
    }

    public void setSyoriKbn(String pSyoriKbn) {
        this.syoriKbn = pSyoriKbn;
    }
}
