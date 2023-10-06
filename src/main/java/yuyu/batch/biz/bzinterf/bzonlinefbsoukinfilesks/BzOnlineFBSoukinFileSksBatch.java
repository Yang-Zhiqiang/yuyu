package yuyu.batch.biz.bzinterf.bzonlinefbsoukinfilesks;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.file.FileType;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.FilePathUtil;
import yuyu.common.biz.kaikei.BzFbSoukinFileSks;
import yuyu.def.MessageId;
import yuyu.def.biz.file.fixedlength.BzFbsoukinFixedlengthRecordLayoutFile;
import yuyu.def.classification.C_FbSoukinBatchKbn;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.file.FileControlManager;

/**
 * 業務共通 インターフェイス オンラインＦＢ送金ファイル作成
 */
public class BzOnlineFBSoukinFileSksBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzOnlineFBSoukinFileSksBatchParam bzBatchParam;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(bzBatchParam.getSyoriYmd())));

        BzFbSoukinFileSks bzFbSoukinFileSks = SWAKInjector.getInstance(BzFbSoukinFileSks.class);

        List<BzFbsoukinFixedlengthRecordLayoutFile> bzFbsoukinFixedlengthRecordLayoutFileLst =
            bzFbSoukinFileSks.creadFBsoukinfwairu(bzBatchParam.getSyoriYmd(), bzBatchParam.getIbKakutyoujobcd(),
                C_FbSoukinBatchKbn.NONE, C_ShrhousiteiKbn.FB_YOKUJITU);

        String batchFileOut = FilePathUtil.getBatchOutDataPath();

        String filePath = batchFileOut + "/" + bzBatchParam.getFileNmYokueiTyakkin();

        FileControlManager fileControlManager = SWAKInjector.getInstance(FileControlManager.class);

        try {
            fileControlManager.writeFileData(filePath, bzFbsoukinFixedlengthRecordLayoutFileLst, FileType.FIXEDLENGTH);
        } catch (Exception e) {
            throw new BizAppException(e, MessageUtil.getMessage(
                MessageId.EBF0163, bzBatchParam.getFileNmYokueiTyakkin()));
        }

        int countYokuei = bzFbSoukinFileSks.getDateCount();

        bzFbSoukinFileSks = SWAKInjector.getInstance(BzFbSoukinFileSks.class);

        bzFbsoukinFixedlengthRecordLayoutFileLst =
            bzFbSoukinFileSks.creadFBsoukinfwairu(bzBatchParam.getSyoriYmd(), bzBatchParam.getIbKakutyoujobcd(),
                C_FbSoukinBatchKbn.NONE, C_ShrhousiteiKbn.FB_2EIGYOUBI);

        filePath = batchFileOut + "/" + bzBatchParam.getFileNm2eiatoTyakkin();

        try {
            fileControlManager.writeFileData(filePath, bzFbsoukinFixedlengthRecordLayoutFileLst, FileType.FIXEDLENGTH);
        } catch (Exception e) {
            throw new BizAppException(e, MessageUtil.getMessage(
                MessageId.EBF0163, bzBatchParam.getFileNm2eiatoTyakkin()));
        }

        int counTeiato = bzFbSoukinFileSks.getDateCount();

        int count = countYokuei + counTeiato;

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(count)));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }

}
