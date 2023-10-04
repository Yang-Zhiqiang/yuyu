package yuyu.batch.hozen.khinterf.khtyouhyoukoujyosyoumei;

import yuyu.common.biz.bzcommon.BzBatchParam;
import jp.co.slcs.swak.batch.annotation.BatchScoped;

/**
 * 契約保全 インターフェイス 控除証明書Ｆ作成のパラメータ
 */
@BatchScoped
public class KhTyouhyouKoujyoSyoumeiBatchParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    private String heisoukbn;

    public String getHeisoukbn() {
        return heisoukbn;
    }

    public void setHeisoukbn(String pHeisoukbn) {
        this.heisoukbn = pHeisoukbn;
    }
}
