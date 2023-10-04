package yuyu.batch.ray.mq.mqconnectioncontrol;

import javax.inject.Inject;

import jp.co.slcs.swak.batch.annotation.Execute;
import yuyu.infr.batch.Batch;
import yuyu.infrext.mq.MqConnectionControl;

/**
 * ＭＱコネクション制御のバッチクラスです。
 */
public class MqConnectionControlBatch implements Batch {

    @Inject
    private MqConnectionControlBatchParam batchParam;

    @Inject
    private MqConnectionControl MqConCtrl;


    @Override
    public MqConnectionControlBatchParam getParam() {
        return batchParam;
    }

    @Execute
    public void execute() {

        MqConCtrl.excStartEnd(batchParam.getMqConnectionControlKbn());

    }
}

