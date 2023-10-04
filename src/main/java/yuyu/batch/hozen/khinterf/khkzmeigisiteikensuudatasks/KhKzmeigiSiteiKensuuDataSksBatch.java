package yuyu.batch.hozen.khinterf.khkzmeigisiteikensuudatasks;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khinterf.khkzmeigisiteikensuudatasks.dba.KhKzmeigiSiteiKensuuDataSksDao;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzfiledl.BzFileUploadUtil;
import yuyu.def.MessageId;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.hozen.file.csv.KhPHrkKzMeigiSiteiKensuuDataCsvFile;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 インターフェイス 契約保全保険料払込口座名義指定件数データ作成クラス
 */
public class KhKzmeigiSiteiKensuuDataSksBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private KhKzmeigiSiteiKensuuDataSksDao khKzmeigiSiteiKensuuDataSksDao;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IBW0003), String.valueOf(bzBatchParam.getSyoriYmd())));


        int syoriKensuu = khKzmeigiSiteiKensuuDataSksDao.getKhKzmeigiSiteiKensuuDataSksInfo().size();

        List<KhPHrkKzMeigiSiteiKensuuDataCsvFile> khPHrkKzMeigiSiteiKensuuDataLst = new ArrayList<>();

        KhPHrkKzMeigiSiteiKensuuDataCsvFile khPHrkKzMeigiSiteiKensuuData =
            SWAKInjector.getInstance(KhPHrkKzMeigiSiteiKensuuDataCsvFile.class);

        khPHrkKzMeigiSiteiKensuuData.setIfcKensuu(String.valueOf(syoriKensuu));

        khPHrkKzMeigiSiteiKensuuDataLst.add(khPHrkKzMeigiSiteiKensuuData);

        BzFileUploadUtil bzFileUploadUtil = SWAKInjector.getInstance(BzFileUploadUtil.class);

        C_ErrorKbn errorKbn = bzFileUploadUtil.exec(
            C_FileSyuruiCdKbn.KH_KZMEIGISITEIKENSUUDATACSVF,
            khPHrkKzMeigiSiteiKensuuDataLst,
            true);

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

            throw new BizAppException(MessageId.EBF0129, "ファイルアップロードユーティリティ");
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));
    }
}
