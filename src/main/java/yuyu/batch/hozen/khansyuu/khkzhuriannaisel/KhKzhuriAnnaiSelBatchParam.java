package yuyu.batch.hozen.khansyuu.khkzhuriannaisel;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import yuyu.common.biz.bzcommon.BzBatchParam;

/**
 * 契約保全 案内収納 口座振替案内データ抽出パラメータクラス
 */
@BatchScoped
public class KhKzhuriAnnaiSelBatchParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    public KhKzhuriAnnaiSelBatchParam() {
    }

    private String heisoukbn;

    public String getHeisoukbn() {
        return heisoukbn;
    }

    public void setHeisoukbn(String pHeisoukbn) {
        heisoukbn = pHeisoukbn;
    }

}
