package yuyu.batch.hozen.khhubikanri.khhubityouhyou;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.hozen.khcommon.EditPdfHubiMikai;
import yuyu.def.MessageId;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全不備帳票作成のバッチクラスです。
 */
public class KhHubiTyouhyouBatch implements Batch {

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
    public void Execute() {

        BizDate syoriymd = null;

        syoriymd = bzBatchParam.getSyoriYmd();

        EditPdfHubiMikai editPdfHubiMikai = SWAKInjector.getInstance(EditPdfHubiMikai.class);

        int result = editPdfHubiMikai.exec(syoriymd, kinou.getCategoryId(), kinou.getKinouId(),
            bzBatchParam.getIbKakutyoujobcd());

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(result), "不備未解消リスト"));

    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
