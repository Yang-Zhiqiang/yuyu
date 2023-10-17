package yuyu.batch.biz.bzinterf.bzrenkeihenkankyouyuudisc;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import yuyu.common.biz.bzcommon.BzBatchParam;

/**
 * 業務共通 インターフェイス 連携項目変換処理（共有ディスク方式）クラス
 */
@BatchScoped
public class BzRenkeiHenkanKyouyuuDiscBatchParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    private String interfaceId;

    public String getInterfaceId() {
        return interfaceId;
    }

    public void setInterfaceId(String interfaceId) {
        this.interfaceId = interfaceId;
    }

}
