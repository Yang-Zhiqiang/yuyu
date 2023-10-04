package yuyu.batch.ray.mq.mqcontrolsignalreceive;

import javax.inject.Inject;

import jp.co.slcs.swak.batch.annotation.Execute;
import yuyu.infr.batch.Batch;
import yuyu.infrext.mq.MqControlSignalReceive;

/**
 * ＭＱ制御信号受信のバッチクラスです。
 */

public class MqControlSignalReceiveBatch implements Batch {

    @Inject
    private MqControlSignalReceiveBatchParam batchParam;

    @Inject
    private MqControlSignalReceive MqCntrlSgnlRcv;

    @Override
    public MqControlSignalReceiveBatchParam getParam() {
        return batchParam;
    }

    @Execute
    public void execute() {

        MqCntrlSgnlRcv.excCntrlSgnlRcv(batchParam.getMqOnlineStatus());
    }
}

