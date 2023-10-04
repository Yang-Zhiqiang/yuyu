package yuyu.batch.hozen.khansyuu.khsinkokuyokokutuutisks;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import yuyu.common.biz.bzcommon.BzBatchParam;

/**
 * 契約保全 案内収納 申告予告通知作成のパラメータ
 */
@BatchScoped
public class KhSinkokuYokokuTuutiSksBatchParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    private String heisoukbn;

    public String getHeisoukbn() {
        return heisoukbn;
    }

    public void setHeisoukbn(String pHeisoukbn) {
        this.heisoukbn = pHeisoukbn;
    }
}
