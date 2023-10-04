package yuyu.batch.hozen.khansyuu.khkzhurinyuukintrsks;

import yuyu.common.biz.bzcommon.BzBatchParam;
import jp.co.slcs.swak.batch.annotation.BatchScoped;

/**
 * 契約保全 案内収納 口座振替入金ＴＲ作成パラメータクラス
 */
@BatchScoped
public class KhKzhuriNyuukinTrSksBatchParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    public KhKzhuriNyuukinTrSksBatchParam() {
    }

    private String heisoukbn;

    public String getHeisoukbn() {
        return heisoukbn;
    }

    public void setHeisoukbn(String pHeisoukbn) {
        heisoukbn = pHeisoukbn;
    }
}
