package yuyu.batch.direct.dsneugokihantei.dsneugokihanteikekkasakusei;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.direct.dsneugokihantei.dsneugokihanteikekkasakusei.dba.DsNeugokiHanteiKekkaSakuseiDao;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzfiledl.BzFileUploadUtil;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.MW_DsNeugokiHanteiKekkaWk;
import yuyu.def.direct.file.csv.DsNeugokiHanteiKekkaFile;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * ダイレクトサービス 値動き判定 値動き判定結果Ｆ作成
 */
public class DsNeugokiHanteiKekkaSakuseiBatch implements Batch {

    private final String TABLE_ID = "MW_DsNeugokiHanteiKekkaWk";

    private final String RECOVERY_FILTER_ID = "Ds002";

    private final int CSV_MAX_KENSUU = 5000;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private DsNeugokiHanteiKekkaSakuseiDao dsNeugokiHanteiKekkaSakuseiDao;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Override
    public BatchParam getParam() {

        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();
        String kakutyouJobCd = bzBatchParam.getIbKakutyoujobcd();
        long syoriKensuu = 0;
        long csvRenno = 1;
        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IBW0003), String.valueOf(syoriYmd)));

        List<DsNeugokiHanteiKekkaFile> dsNeugokiHanteiKekkaFileLst = new ArrayList<>();
        DsNeugokiHanteiKekkaFile dsNeugokiHanteiKekkaFile;
        BzFileUploadUtil bzFileUploadUtil = SWAKInjector.getInstance(BzFileUploadUtil.class);
        try (ExDBResults<MW_DsNeugokiHanteiKekkaWk> dsNeugokiHanteiKekkaWkLst = dsNeugokiHanteiKekkaSakuseiDao.
            getDsNeugokiHanteiKekkaWkByKakutyoujobcd(kakutyouJobCd);) {

            for (MW_DsNeugokiHanteiKekkaWk dsNeugokiHanteiKekkaWk : dsNeugokiHanteiKekkaWkLst) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyouJobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(TABLE_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERY_FILTER_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(dsNeugokiHanteiKekkaWk.getDsdatasakuseiymd().toString());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(dsNeugokiHanteiKekkaWk.getSyono());

                dsNeugokiHanteiKekkaFile = SWAKInjector.getInstance(DsNeugokiHanteiKekkaFile.class);
                dsNeugokiHanteiKekkaFile.setIfcSyono(dsNeugokiHanteiKekkaWk.getSyono());
                dsNeugokiHanteiKekkaFile.setIfcKyknmkn(dsNeugokiHanteiKekkaWk.getKyknmkn());
                dsNeugokiHanteiKekkaFile.setIfcHanteiymd(dsNeugokiHanteiKekkaWk.getDsdatasakuseiymd().toString());
                dsNeugokiHanteiKekkaFile.setIfcBosyuujiaatukaidrtencd(dsNeugokiHanteiKekkaWk.getBosyuujiaatukaidrtencd());
                dsNeugokiHanteiKekkaFile.setIfcBosyuujibatukaidrtencd(dsNeugokiHanteiKekkaWk.getBosyuujibatukaidrtencd());
                dsNeugokiHanteiKekkaFile.setIfcMailaddresstourokuumukbn(
                    dsNeugokiHanteiKekkaWk.getMailaddresstourokuumukbn().getValue());
                dsNeugokiHanteiKekkaFile.setIfcMailsousinyhkbn(dsNeugokiHanteiKekkaWk.getMailsousinyhkbn().getValue());
                dsNeugokiHanteiKekkaFile.setIfcNeugokiwari(
                    dsNeugokiHanteiKekkaWk.getNeugokiwari().multiply(100).toString());
                dsNeugokiHanteiKekkaFile.setIfcItijibrp(dsNeugokiHanteiKekkaWk.getItijibrp().toString());
                dsNeugokiHanteiKekkaFile.setIfcKyktuukasyu(dsNeugokiHanteiKekkaWk.getKyktuukasyu().getValue());
                dsNeugokiHanteiKekkaFile.setIfcNeugokihanteikjnkngk(
                    dsNeugokiHanteiKekkaWk.getNeugokihanteikjnkngk().toString());
                dsNeugokiHanteiKekkaFile.setIfcKaiyakuhryen(dsNeugokiHanteiKekkaWk.getKaiyakuhryen().toString());
                dsNeugokiHanteiKekkaFileLst.add(dsNeugokiHanteiKekkaFile);

                if (dsNeugokiHanteiKekkaFileLst.size() == CSV_MAX_KENSUU) {
                    C_ErrorKbn errorKbn = bzFileUploadUtil.exec(C_FileSyuruiCdKbn.DS_NEUGOKIHANTEIKEKKAFILE,
                        dsNeugokiHanteiKekkaFileLst,
                        true,
                        String.valueOf(csvRenno));

                    if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                        throw new BizAppException(MessageId.EBF0129, kinou.getKinouNm());
                    }
                    dsNeugokiHanteiKekkaFileLst.removeAll(dsNeugokiHanteiKekkaFileLst);
                    csvRenno = csvRenno + 1;
                }
                syoriKensuu = syoriKensuu + 1;
            }

            if (dsNeugokiHanteiKekkaFileLst.size() > 0 || (dsNeugokiHanteiKekkaFileLst.size() == 0 && csvRenno == 1)) {
                C_ErrorKbn errorKbn = bzFileUploadUtil.exec(C_FileSyuruiCdKbn.DS_NEUGOKIHANTEIKEKKAFILE,
                    dsNeugokiHanteiKekkaFileLst,
                    true,
                    String.valueOf(csvRenno));

                if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                    throw new BizAppException(MessageId.EBF0129, kinou.getKinouNm());
                }
            }

            bzRecoveryDatasikibetuBean.initializeBlank();
        }
        batchLogger.info(MessageUtil.getMessage(MessageId.IAC0020, String.valueOf(syoriKensuu)));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
