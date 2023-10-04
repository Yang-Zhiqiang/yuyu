package yuyu.batch.hozen.khozen.khmkhgktttyendthnk;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import yuyu.common.biz.bzcommon.BzBatchParam;

/**
 * 契約保全 契約保全 円建変更バッチパラメータ
 */
@BatchScoped
public class KhMkhgkTttYendtHnkBatchParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    private String heisoukbn;

    public String getHeisoukbn() {
        return heisoukbn;
    }

    public void setHeisoukbn(String pHeisoukbn) {
        heisoukbn = pHeisoukbn;
    }

}
