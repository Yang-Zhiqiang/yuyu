package yuyu.batch.ray.mq.mqemgcystopstatusupdate;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.def.MessageId;
import yuyu.def.classification.C_MqEmgcyStopStatusKbn;
import yuyu.def.db.dao.AT_SystemControlInfoDao;
import yuyu.def.db.entity.AT_SystemControlInfo;
import yuyu.infr.batch.Batch;

/**
 * ＭＱ緊急停止状態更新のバッチクラスです。
 */
public class MqEmgcyStopStatusUpdateBatch implements Batch {

    @Inject
    private static Logger  log;

    @Inject
    private MqEmgcyStopStatusUpdateBatchParam batchParam;

    @Inject
    private AT_SystemControlInfoDao sysConDao;


    @Override
    public MqEmgcyStopStatusUpdateBatchParam getParam() {
        return batchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        log.debug("ＭＱ緊急停止状態更新バッチ　開始");

        if(batchParam.getMqEmgcyStopStatus() == null){
            throw new BizAppException(MessageUtil.getMessage(MessageId.EAF1009,MessageUtil.getMessage(MessageId.IAW1008)));

        }

        log.debug("batchParam.getMqEmgcyStopStatus() = " + batchParam.getMqEmgcyStopStatus());

        AT_SystemControlInfo ctrlInfo = sysConDao.getSystemControlInfo(MqEmgcyStopStatusUpdateBatchConstants.ctrlInfoKey);


        if(batchParam.getMqEmgcyStopStatus().eq(C_MqEmgcyStopStatusKbn.MQEMGCYSTOP_END)) {
            ctrlInfo.setMqEmgcyStopStatus(C_MqEmgcyStopStatusKbn.MQEMGCYSTOP_END);
        }

        if(batchParam.getMqEmgcyStopStatus().eq(C_MqEmgcyStopStatusKbn.MQEMGCYSTOP_START)) {
            ctrlInfo.setMqEmgcyStopStatus(C_MqEmgcyStopStatusKbn.MQEMGCYSTOP_START);
        }

        sysConDao.update(ctrlInfo);

        log.debug("ＭＱ緊急停止状態更新バッチ　終了");
    }
}

