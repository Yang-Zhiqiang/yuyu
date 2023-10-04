package yuyu.batch.hozen.khinterf.khtmttkinyskcsvfilesks;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khinterf.khtmttkinyskcsvfilesks.dba.KhTmttkinYskCsvFileSksDao;
import yuyu.batch.hozen.khinterf.khtmttkinyskcsvfilesks.dba.KhTmttkinYskWkBean;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzfiledl.BzFileUploadUtil;
import yuyu.def.MessageId;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.hozen.file.csv.KhTmttkinYskCsvFile;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.collect.Lists;

/**
 * 契約保全 インターフェース 積立金予測ＣＳＶファイル作成<br />
 */
public class KhTmttkinYskCsvFileSksBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private KhTmttkinYskCsvFileSksDao khTmttkinYskCsvFileSksDao;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(bzBatchParam.getSyoriYmd())));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018),
            bzBatchParam.getIbKakutyoujobcd()));

        int tmttkinyskcsvfkensuu = 0;

        List<KhTmttkinYskWkBean> khTmttkinYskWkBeanLst = new ArrayList<>();

        List<KhTmttkinYskCsvFile> khTmttkinYskCsvFileLst = new ArrayList<>();

        khTmttkinYskWkBeanLst = khTmttkinYskCsvFileSksDao.getKhTmttkinYskWkBeans();

        for (KhTmttkinYskWkBean khTmttkinYskWkBean : khTmttkinYskWkBeanLst) {

            KhTmttkinYskCsvFile khTmttkinYskCsvFile = SWAKInjector.getInstance(KhTmttkinYskCsvFile.class);

            khTmttkinYskCsvFile.setIfcSyouhnbunruittknyskkbn(khTmttkinYskWkBean.getSyouhnbunruitmttkinyskkbn());

            khTmttkinYskCsvFile.setIfcKyktuukasyukbn(khTmttkinYskWkBean.getKyktuukasyu());

            khTmttkinYskCsvFile.setIfcKykymd(khTmttkinYskWkBean.getKykymd());

            khTmttkinYskCsvFile.setIfcKyksjkkktyouseiriritu(khTmttkinYskWkBean.getKyksjkkktyouseiriritu().multiply(100));

            khTmttkinYskCsvFile.setIfcTargettkhkumu(khTmttkinYskWkBean.getTargettkhkumu());

            khTmttkinYskCsvFile.setIfcTargettkmkht(khTmttkinYskWkBean.getTargettkmokuhyouti());

            khTmttkinYskCsvFile.setIfcKyktuukapgk(khTmttkinYskWkBean.getSumKyktuukap());

            khTmttkinYskCsvFile.setIfcKyktuukatmttkngkgk(khTmttkinYskWkBean.getSumKyktuukatmttkngk());

            khTmttkinYskCsvFile.setIfcKyktuukakaiyakuhrgkgk(khTmttkinYskWkBean.getSumKyktuukakaiyakuhrgk());

            khTmttkinYskCsvFileLst.add(khTmttkinYskCsvFile);

            tmttkinyskcsvfkensuu = tmttkinyskcsvfkensuu + 1;
        }

        if (khTmttkinYskCsvFileLst.size() > 0) {

            int renno = 1;

            List<List<KhTmttkinYskCsvFile>> tmttkinYskCsvFileList = Lists.partition(khTmttkinYskCsvFileLst, 10000);

            BzFileUploadUtil bzFileUploadUtil = SWAKInjector.getInstance(BzFileUploadUtil.class);

            for (List<KhTmttkinYskCsvFile> khTmttkinYskCsvFilelst : tmttkinYskCsvFileList) {

                C_ErrorKbn errorKbn = bzFileUploadUtil.exec(C_FileSyuruiCdKbn.KH_TMTTKINYSKCSVF, khTmttkinYskCsvFilelst,
                    true, String.valueOf(renno));

                if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                    throw new BizAppException(MessageId.EBF0129, "ファイルアップロードユーティリティ");
                }

                renno = renno + 1;
            }
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(tmttkinyskcsvfkensuu)));
    }

}
