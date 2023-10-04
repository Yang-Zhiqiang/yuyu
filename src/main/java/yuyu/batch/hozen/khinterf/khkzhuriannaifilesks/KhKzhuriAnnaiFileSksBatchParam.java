package yuyu.batch.hozen.khinterf.khkzhuriannaifilesks;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import yuyu.common.biz.bzcommon.BzBatchParam;

/**
 * 契約保全 案内収納 口座振替案内Ｆ作成パラメータクラス
 */
@BatchScoped
public class KhKzhuriAnnaiFileSksBatchParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    public KhKzhuriAnnaiFileSksBatchParam() {
    }

    private String heisoukbn;

    public String getHeisoukbn() {
        return heisoukbn;
    }

    public void setHeisoukbn(String pHeisoukbn) {
        heisoukbn = pHeisoukbn;
    }

}
