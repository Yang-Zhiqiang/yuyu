package yuyu.batch.hozen.khinterf.khsinkokuyokokutuutifsks;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import yuyu.common.biz.bzcommon.BzBatchParam;

/**
 * 契約保全 インターフェイス 申告予告通知Ｆ作成バッチパラメータ
 */
@BatchScoped
public class KhSinkokuYokokuTuutiFSksBatchParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    private String heisoukbn;

    public String getHeisoukbn() {
        return heisoukbn;
    }

    public void setHeisoukbn(String pHeisoukbn) {
        this.heisoukbn = pHeisoukbn;
    }
}
