package yuyu.batch.workflow.processkanri.syorikensuhokansyorikakojisseki;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.workflow.workflowutility.MakeCountOfKakoJissekiTaskSummaryResultBean;
import yuyu.common.workflow.workflowutility.WorkFlowResultConstants;
import yuyu.common.workflow.workflowutility.WorkFlowUtility;
import yuyu.def.MessageId;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * ワークフロー プロセス管理 処理件数保管処理（過去実績サマリ分）
 */
public class SyoriKensuHokanSyoriKakoJissekiBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private AS_Kinou kinou;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();

        batchLogger.info(MessageUtil.getMessage(
                MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003), String.valueOf(syoriYmd)));

        MakeCountOfKakoJissekiTaskSummaryResultBean resultBean = WorkFlowUtility.makeCountOfKakoJissekiTaskSummary(syoriYmd);

        if(WorkFlowResultConstants.RESULT_NG.equals(resultBean.getSyorikekkaStatus())){
            batchLogger.error("エラーコード内容：" + resultBean.getSyousaiMessageCd());
            batchLogger.error("エラーメッセージ内容：" + resultBean.getSyousaiMessage());
            batchLogger.error("エラー発生処理名内容：" + resultBean.getErrHasseiSyoriNm());
            throw new BizAppException(MessageId.EBF0129, kinou.getKinouNm());
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002,
                String.valueOf(resultBean.getKensuuOfSyoriKensuuHokanJimu()),
                "処理件数保管（事務手続別）テーブル"));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002,
                String.valueOf(resultBean.getKensuuOfSyoriKensuuHokanTask()),
                "処理件数保管（タスク別）テーブル"));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002,
                String.valueOf(resultBean.getKensuuOfJimutetuzukiRireki()),
                "事務手続マスタ履歴保存テーブル"));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002,
                String.valueOf(resultBean.getKensuuOfJimutetuzukiTaskRireki()),
                "事務手続タスクマスタ履歴保存テーブル"));

    }
}
