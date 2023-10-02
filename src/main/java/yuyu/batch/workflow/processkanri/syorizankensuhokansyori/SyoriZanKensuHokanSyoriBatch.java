package yuyu.batch.workflow.processkanri.syorizankensuhokansyori;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import yuyu.common.workflow.workflowutility.MakeCountOfTaskSummaryResultBean;
import yuyu.common.workflow.workflowutility.WorkFlowResultConstants;
import yuyu.common.workflow.workflowutility.WorkFlowUtility;
import yuyu.def.MessageId;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 処理残件数保管処理のバッチクラスです。
 */
public class SyoriZanKensuHokanSyoriBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BatchParam batchParam;

    @Inject
    private AS_Kinou kinou;

    @Override
    public BatchParam getParam() {
        return batchParam;
    }

    @Execute
    @Transactional
    public void execute() {


        MakeCountOfTaskSummaryResultBean result = WorkFlowUtility.makeCountOfTaskSummary();

        if (result.getSyorikekkaStatus().equals(WorkFlowResultConstants.RESULT_NG)) {
            batchLogger.error(result.getSyousaiMessage());
            throw new BizAppException(MessageId.EBF0129, kinou.getKinouNm());
        }
    }
}
