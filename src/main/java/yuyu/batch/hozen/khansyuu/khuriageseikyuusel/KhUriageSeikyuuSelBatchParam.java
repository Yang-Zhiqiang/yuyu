package yuyu.batch.hozen.khansyuu.khuriageseikyuusel;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import yuyu.common.biz.bzcommon.BzBatchParam;

/**
 * 契約保全 案内収納 売上請求データ抽出
 */
@BatchScoped
public class KhUriageSeikyuuSelBatchParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    private String heisoukbn;

    public String getHeisoukbn() {
        return heisoukbn;
    }

    public void setHeisoukbn(String pHeisoukbn) {
        heisoukbn = pHeisoukbn;
    }
}

