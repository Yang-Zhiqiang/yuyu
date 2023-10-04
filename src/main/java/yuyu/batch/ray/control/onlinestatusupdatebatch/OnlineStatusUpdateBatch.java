package yuyu.batch.ray.control.onlinestatusupdatebatch;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.def.MessageId;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.db.dao.AT_SystemControlInfoDao;
import yuyu.def.db.entity.AT_SystemControlInfo;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;

/**
 * オンラインステータス更新バッチ
 */
public class OnlineStatusUpdateBatch implements Batch  {

    @Inject
    private static Logger  log;

    @Inject
    private BaseDomManager baseManager;
    @Inject
    private AT_SystemControlInfoDao dao;
    @Inject
    private OnlineStatusUpdateBatchParam batchParam;

    @Override
    public BatchParam getParam() {
        return batchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        log.debug("オンライン状態更新バッチ　開始");
        checkParam();

        update();

        log.debug("オンライン状態更新バッチ　終了");
    }

    private void checkParam() {
        if (batchParam.getOnlineStatus() == null) {
            throw new BizAppException(MessageId.EAF1009, MessageUtil.getMessage(MessageId.IAW1009));
        }
    }

    @Transactional
    private void update() {
        AT_SystemControlInfo systemControlInfo = dao.getSystemControlInfo(OnlineStatusUpdateBatchConstants.SYSTEM_CTRLINFO_KEY);
        systemControlInfo.setOnlineStatus(batchParam.getOnlineStatus().toString());
        baseManager.update(systemControlInfo);
        return;
    }
}