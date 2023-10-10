package yuyu.batch.biz.bzinterf.bzbatchgkfbsoukinfilesks;

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
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.kaikei.BzGkFbSoukinFileSks;
import yuyu.def.MessageId;
import yuyu.def.biz.file.fixedlength.BzGkFbsoukinFixedlengthRecordLayoutFile;
import yuyu.def.classification.C_Gkgyoumucd;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.file.FileControlManager;

/**
 * 業務共通 インターフェイス バッチ外貨ＦＢ送金ファイル作成
 */
public class BzBatchGkFBSoukinFileSksBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchGkFBSoukinFileSksBatchParam bzBatchParam;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(bzBatchParam.getSyoriYmd())));

        BzGkFbSoukinFileSks bzGkFbSoukinFileSks = SWAKInjector.getInstance(BzGkFbSoukinFileSks.class);



        List<BzGkFbsoukinFixedlengthRecordLayoutFile> bzGkFbsoukinFixedlengthRecordLayoutFileLst =
            bzGkFbSoukinFileSks.creadGaikaFBSoukinFwairu(C_ShrhousiteiKbn.FB_2EIGYOUBI,
                C_Gkgyoumucd.NENKINJIDOU2EIGO, bzBatchParam.getSyoriYmd(), bzBatchParam.getIbKakutyoujobcd());
        int count2eiato = bzGkFbSoukinFileSks.getDateCount();

        String batchFileOut = FilePathUtil.getBatchOutDataPath();

        String filePath = batchFileOut + "/" + bzBatchParam.getFileNm2eiatoTyakkin();

        FileControlManager fileControlManager = SWAKInjector.getInstance(FileControlManager.class);

        try {
            fileControlManager.writeFileData(filePath,
                bzGkFbsoukinFixedlengthRecordLayoutFileLst, FileType.FIXEDLENGTH);
        } catch (Exception e) {
            throw new BizAppException(e, MessageUtil.getMessage(
                MessageId.EBF0163, bzBatchParam.getFileNm2eiatoTyakkin()));
        }

        bzGkFbSoukinFileSks = SWAKInjector.getInstance(BzGkFbSoukinFileSks.class);

        bzGkFbsoukinFixedlengthRecordLayoutFileLst = bzGkFbSoukinFileSks.creadGaikaFBSoukinFwairu(
            C_ShrhousiteiKbn.FB_3EIGYOUBI, C_Gkgyoumucd.NENKINJIDOU3EIDO, bzBatchParam.getSyoriYmd(), bzBatchParam.getIbKakutyoujobcd());
        int count3eiato = bzGkFbSoukinFileSks.getDateCount();

        batchFileOut = FilePathUtil.getBatchOutDataPath();

        filePath = batchFileOut + "/" + bzBatchParam.getFileNm3eiatoTyakkin();

        fileControlManager = SWAKInjector.getInstance(FileControlManager.class);

        try {
            fileControlManager.writeFileData(filePath,
                bzGkFbsoukinFixedlengthRecordLayoutFileLst, FileType.FIXEDLENGTH);
        } catch (Exception e) {
            throw new CommonBizAppException(e, MessageUtil.getMessage(
                MessageId.EBF0163, bzBatchParam.getFileNm3eiatoTyakkin()));
        }

        int count = count2eiato + count3eiato;

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(count)));
    }


    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
