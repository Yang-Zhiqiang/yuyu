package yuyu.batch.hozen.khansyuu.khkoujyosyoumeisks;

import yuyu.common.biz.bzcommon.BzBatchParam;
import jp.co.slcs.swak.batch.annotation.BatchScoped;

/**
 * 契約保全 案内収納 控除証明書作成のパラメータ
 */
@BatchScoped
public class KhKoujyosyoumeiSksBatchParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    private String heisoukbn;

    public String getHeisoukbn() {
        return heisoukbn;
    }

    public void setHeisoukbn(String pHeisoukbn) {
        this.heisoukbn = pHeisoukbn;
    }
}
