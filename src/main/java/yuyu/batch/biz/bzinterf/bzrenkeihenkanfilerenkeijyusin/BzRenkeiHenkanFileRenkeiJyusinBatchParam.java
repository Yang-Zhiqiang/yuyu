package yuyu.batch.biz.bzinterf.bzrenkeihenkanfilerenkeijyusin;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import yuyu.common.biz.bzcommon.BzBatchParam;

/**
 * 業務共通 インターフェース 連携項目変換処理（ファイル連携方式受信）パラメータクラス
 */
@BatchScoped
public class BzRenkeiHenkanFileRenkeiJyusinBatchParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    private String interfaceId;

    public String getInterfaceId() {
        return interfaceId;
    }

    public void setInterfaceId(String interfaceId) {
        this.interfaceId = interfaceId;
    }

}
