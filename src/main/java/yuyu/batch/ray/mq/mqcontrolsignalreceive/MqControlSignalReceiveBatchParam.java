package yuyu.batch.ray.mq.mqcontrolsignalreceive;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import yuyu.def.classification.C_MqOnlineStatusKbn;
import yuyu.infr.batch.BatchParam;

/**
 * {@link MqControlSignalReceiveBatch MQ制御信号受信バッチ} のパラメータBeanクラスです。
 */
@BatchScoped
public class MqControlSignalReceiveBatchParam extends BatchParam {

    private static final long serialVersionUID = 476235052829802315L;

    private C_MqOnlineStatusKbn mqOnlineStatus;

    public  C_MqOnlineStatusKbn getMqOnlineStatus() {
        return mqOnlineStatus;
    }

    public void setMqOnlineStatus(C_MqOnlineStatusKbn mqOnlineStatus) {
        this.mqOnlineStatus = mqOnlineStatus;
    }

}
