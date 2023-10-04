package yuyu.batch.hozen.khansyuu.khkesikomisel;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.def.classification.C_Nykkeiro;

/**
 * 契約保全 案内収納 消込データ抽出バッチパラメータ
 */
@BatchScoped
public class KhKesikomiSelBatchParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    private C_Nykkeiro nykkeiro;

    private String heisoukbn;

    public C_Nykkeiro getNykkeiro() {
        return nykkeiro;
    }

    public void setNykkeiro(C_Nykkeiro pNykkeiro) {
        nykkeiro = pNykkeiro;
    }

    public String getHeisoukbn() {
        return heisoukbn;
    }

    public void setHeisoukbn(String pHeisoukbn) {
        heisoukbn = pHeisoukbn;
    }
}

