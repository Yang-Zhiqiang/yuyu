package yuyu.batch.biz.bzunyo.bztestkykfilesks;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzunyo.BzTestDataExportFileUtil;
import yuyu.common.biz.bzunyo.BzTestDataExportFileUtilBean;
import yuyu.def.MessageId;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 業務共通 運用 テスト用契約ファイル作成
 */
public class BzTestKykFileSksBatch implements Batch {

    private static String TESTKYKFILE = "TestKykFile";

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

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));

        String zipFileName = TESTKYKFILE + "_" + String.valueOf(syoriYmd);

        BzTestDataExportFileUtil bzTestDataExportFileUtil = SWAKInjector.getInstance(BzTestDataExportFileUtil.class);

        BzTestDataExportFileUtilBean bzTestDataExportFileUtilBean = bzTestDataExportFileUtil.fileDownload(zipFileName);

        boolean result = bzTestDataExportFileUtilBean.getResult();

        if (!result) {
            throw new BizAppException(MessageUtil.getMessage(MessageId.EBF0129, kinou.getKinouNm()));
        }
        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002,
            String.valueOf(bzTestDataExportFileUtilBean.getCount()), "テスト用契約データ抽出テーブル"));
    }
}
