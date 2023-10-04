package yuyu.batch.hozen.khinterf.khuriagesousinfilesks;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import yuyu.common.biz.bzcommon.BzBatchParam;

/**
 * 契約保全 インターフェイス  売上送信Ｆ作成バッチパラメータ
 */
@BatchScoped
public class KhUriageSousinFileSksBatchParam extends BzBatchParam{

    private static final long serialVersionUID = 1L;

    private String heisoukbn;

    public String getHeisoukbn() {
        return heisoukbn;
    }

    public void setHeisoukbn(String pHeisoukbn) {
        this.heisoukbn = pHeisoukbn;
    }
}
