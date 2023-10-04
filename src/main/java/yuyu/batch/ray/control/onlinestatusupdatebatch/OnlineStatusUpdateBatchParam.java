package yuyu.batch.ray.control.onlinestatusupdatebatch;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import yuyu.def.classification.C_OnlineStatusKbn;
import yuyu.infr.batch.BatchParam;

/**
 * オンライン状態更新バッチのバッチパラメータクラスです。
 */
@BatchScoped
public class OnlineStatusUpdateBatchParam extends BatchParam {

    private static final long serialVersionUID = -1L;

    private C_OnlineStatusKbn onlineStatus = null;

    public C_OnlineStatusKbn getOnlineStatus() {
        return onlineStatus;
    }

    public void setOnlineStatus(C_OnlineStatusKbn onlineStatus) {
        this.onlineStatus = onlineStatus;
    }

}
