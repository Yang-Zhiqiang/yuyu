package yuyu.batch.ray.mq.mqconnectioncontrol;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import yuyu.def.classification.C_MqConnectionControlKbn;
import yuyu.infr.batch.BatchParam;

/**
 * {@link MqConnectionControlBatch MQコネクション制御バッチ} のパラメータBeanクラスです。
 */
@BatchScoped
public class MqConnectionControlBatchParam extends BatchParam {

    private static final long serialVersionUID = -3997840804217405907L;

    private C_MqConnectionControlKbn MqConnCntrl;

    public  C_MqConnectionControlKbn getMqConnectionControlKbn() {
        return MqConnCntrl;
    }

    public void setMqConnectionControlKbn(C_MqConnectionControlKbn MqConnCntrl) {
        this.MqConnCntrl = MqConnCntrl;
    }
}
