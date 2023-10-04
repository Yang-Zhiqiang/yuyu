package yuyu.batch.hozen.khansyuu.khyuukouseikekkahanei;

import yuyu.common.biz.bzcommon.BzBatchParam;
import jp.co.slcs.swak.batch.annotation.BatchScoped;

/**
 * 契約保全 案内収納 有効性確認結果反映のパラメータ
 */
@BatchScoped
public class KhYuukouseiKekkaHaneiBatchParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    private String heisoukbn;

    public String getHeisoukbn() {
        return heisoukbn;
    }

    public void setHeisoukbn(String pHeisoukbn) {
        this.heisoukbn = pHeisoukbn;
    }
}
