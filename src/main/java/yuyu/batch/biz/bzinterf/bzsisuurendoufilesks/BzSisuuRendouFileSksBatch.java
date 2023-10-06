package yuyu.batch.biz.bzinterf.bzsisuurendoufilesks;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.file.FileType;
import jp.co.slcs.swak.file.util.SeparateConvertUtil;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.FilePathUtil;
import yuyu.def.MessageId;
import yuyu.def.biz.file.csv.BzSisuuRendouFileDataRecordLayoutFile;
import yuyu.def.biz.file.csv.BzSisuuRendouFileHeaderRecordLayoutFile;
import yuyu.def.biz.file.csv.BzSisuuRendouFileLayoutFile;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.BM_Sisuu;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.file.FileControlManager;

/**
 * 業務共通 インターフェイス 指数連動ファイル作成
 */
public class BzSisuuRendouFileSksBatch implements Batch {

    private static final String HEADER = "HEADER";

    private static final String FILENM = "BM_Sisuu_rendou.csv";

    private static final char KONMA = ',';

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private BizDomManager bizDomManager;

    @Override
    public BatchParam getParam() {

        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(bzBatchParam.getSyoriYmd())));

        int count = 0;

        List<BzSisuuRendouFileLayoutFile> bzSisuuRendouFileLayoutFileLst = new ArrayList<>();

        List<BM_Sisuu> sisuuLst = bizDomManager.getSisuusBySisuukouhyouymdMax();

        BzSisuuRendouFileLayoutFile bzSisuuRendouFileLayoutFile = SWAKInjector
            .getInstance(BzSisuuRendouFileLayoutFile.class);

        BzSisuuRendouFileHeaderRecordLayoutFile bzSisuuRendouFileHeaderRecordLayoutFile = SWAKInjector
            .getInstance(BzSisuuRendouFileHeaderRecordLayoutFile.class);

        bzSisuuRendouFileHeaderRecordLayoutFile.setIfcRecordsikibetumojiretu(HEADER);

        bzSisuuRendouFileHeaderRecordLayoutFile.setIfcSakuseiymd(BizDate.getSysDate());

        bzSisuuRendouFileHeaderRecordLayoutFile.setIfcDtrecordkensuu(sisuuLst.size());

        String headRecord = SeparateConvertUtil.beanToStringForSeparate(bzSisuuRendouFileHeaderRecordLayoutFile,
            KONMA);

        bzSisuuRendouFileLayoutFile.setIfcSisuurendoudata(headRecord);

        bzSisuuRendouFileLayoutFileLst.add(bzSisuuRendouFileLayoutFile);

        count = count + 1;

        for (BM_Sisuu sisuu : sisuuLst) {

            BzSisuuRendouFileLayoutFile bzSisuuRendouFileLayoutFileTemp = SWAKInjector
                .getInstance(BzSisuuRendouFileLayoutFile.class);

            BzSisuuRendouFileDataRecordLayoutFile bzSisuuRendouFileDataRecordLayoutFile = SWAKInjector
                .getInstance(BzSisuuRendouFileDataRecordLayoutFile.class);

            bzSisuuRendouFileDataRecordLayoutFile.setIfcSisuukbn(sisuu.getSisuukbn());

            bzSisuuRendouFileDataRecordLayoutFile.setIfcSisuukouhyouymd(sisuu.getSisuukouhyouymd());

            bzSisuuRendouFileDataRecordLayoutFile.setIfcSisuu(sisuu.getSisuu());

            bzSisuuRendouFileDataRecordLayoutFile.setIfcSisuucalckijyunymd(sisuu.getSisuucalckijyunymd());

            String dataRecord = SeparateConvertUtil.beanToStringForSeparate(
                bzSisuuRendouFileDataRecordLayoutFile, KONMA);

            bzSisuuRendouFileLayoutFileTemp.setIfcSisuurendoudata(dataRecord);

            bzSisuuRendouFileLayoutFileLst.add(bzSisuuRendouFileLayoutFileTemp);

            count = count + 1;

        }

        FileControlManager fileControlManager = SWAKInjector.getInstance(FileControlManager.class);

        String filePath = FilePathUtil.getBatchOutDataPath();

        try {
            fileControlManager.writeFileData(filePath + "/" + FILENM, bzSisuuRendouFileLayoutFileLst, FileType.CSV);
        } catch (Exception e) {
            throw new BizAppException(e, MessageUtil.getMessage(MessageId.EBF0163, FILENM));
        }

        if (sisuuLst.size() != 0) {
            batchLogger.info(MessageUtil.getMessage(MessageId.IBF1009, String.valueOf(sisuuLst.get(0).getSisuukouhyouymd())));
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(count)));
    }

}
