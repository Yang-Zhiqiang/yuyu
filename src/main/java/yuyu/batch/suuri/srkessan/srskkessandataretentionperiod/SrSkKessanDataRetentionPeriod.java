package yuyu.batch.suuri.srkessan.srskkessandataretentionperiod;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.def.MessageId;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 新契約決算用データ保存期間管理クラス
 */
public class SrSkKessanDataRetentionPeriod implements Batch {

    @Inject
    private SrSkKessanDataRetentionPeriodBatchParam srSkKessanDataRetentionPeriodBatchParam;

    @Inject
    private BatchLogger batchLogger;

    @Override
    public BatchParam getParam() {

        return srSkKessanDataRetentionPeriodBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        srSkKessanDataRetentionPeriodBatchParam.setParam();

        SrSkKessanDataRetentionPeriodDao srSkKessanDataRetentionPeriodDao =
            SWAKInjector.getInstance(SrSkKessanDataRetentionPeriodDao.class);

        srSkKessanDataRetentionPeriodDao.deleteSkOikmTyouseiDenpyou();

        srSkKessanDataRetentionPeriodDao.deleteSkOikmSyukeiPDenpyou();

        srSkKessanDataRetentionPeriodDao.deleteSkKessanSyukeisBySyoriYmd(
            srSkKessanDataRetentionPeriodBatchParam.getDelSyoriYmd());

        batchLogger.info(MessageUtil.getMessage(MessageId.ISA1002));
    }
}
