package yuyu.batch.ray.mq.mqemgcystopstatusupdate;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import yuyu.def.classification.C_MqEmgcyStopStatusKbn;
import yuyu.infr.batch.BatchParam;

/**
 * {@link MqEmgcyStopStatusUpdateBatch MQ緊急停止状態更新バッチ処理} のパラメータBeanクラスです。
 */
@BatchScoped
public class MqEmgcyStopStatusUpdateBatchParam extends BatchParam {

    private static final long serialVersionUID = -3997840804217405907L;

    private C_MqEmgcyStopStatusKbn mqEmgcyStopStatus;

    public C_MqEmgcyStopStatusKbn getMqEmgcyStopStatus() {
        return mqEmgcyStopStatus;
    }

    public void setMqEmgcyStopStatus(C_MqEmgcyStopStatusKbn mqEmgcyStopStatus) {
        this.mqEmgcyStopStatus = mqEmgcyStopStatus;
    }

}
