package yuyu.batch.hozen.khinterf.khmonitoringdatapeps;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.google.common.collect.Lists;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khinterf.khmonitoringdatapeps.dba.KhMonitoringDataPepsDao;
import yuyu.batch.hozen.khinterf.khmonitoringdatapeps.dba.KhMonitoringDataPepsInfosBean;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzfiledl.BzFileUploadUtil;
import yuyu.common.hozen.khcommon.EditCommonMonitoringdata;
import yuyu.common.hozen.khcommon.EditCommonMonitoringdataBean;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_KhTtdkTyuui;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.hozen.file.csv.KhMonitoringDataPepsCsvFile;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 インターフェイス 契約保全モニタリングデータ抽出（ＰＥＰｓ）クラス
 */
public class KhMonitoringDataPepsBatch implements Batch {

    private final int FILE_SAVE_MAX_LIST_COUNT = 4000;

    private static final String TYSYTTAISYOUTABLEID = IT_KhTtdkTyuui.TABLE_NAME;

    private static final String RECOVERYFILTERIDKBNID = "Kh001";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private KhMonitoringDataPepsDao khMonitoringDataPepsDao;

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
        String ibKakutyoujobcd = bzBatchParam.getIbKakutyoujobcd();
        long syoriKensuu = 0;
        List<KhMonitoringDataPepsCsvFile> khMonitoringDataPepsCsvFileLst = new ArrayList<>();
        int fileRenban = 0;

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018),
            ibKakutyoujobcd));

        EditCommonMonitoringdata editCommonMonitoringdata = SWAKInjector.getInstance(EditCommonMonitoringdata.class);

        try (ExDBResults<KhMonitoringDataPepsInfosBean> khMonitoringDataPepsInfosBeanLst =
            khMonitoringDataPepsDao.getKhMonitoringDataPepsInfos(ibKakutyoujobcd)) {

            for (KhMonitoringDataPepsInfosBean khMonitoringDataPepsInfosBean : khMonitoringDataPepsInfosBeanLst) {

                String kbnkey = khMonitoringDataPepsInfosBean.getKbnkey();
                String syoNo = khMonitoringDataPepsInfosBean.getSyono();

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(ibKakutyoujobcd);
                bzRecoveryDatasikibetuBean.setIbTableid(TYSYTTAISYOUTABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERYFILTERIDKBNID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(kbnkey);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(syoNo);

                IT_KykKihon kykKihon = khMonitoringDataPepsInfosBean.getIT_KykKihon();

                EditCommonMonitoringdataBean editCommonMonitoringdataBean = editCommonMonitoringdata.exec(kykKihon,null);

                KhMonitoringDataPepsCsvFile khMonitoringDataPepsCsvFile =
                    SWAKInjector.getInstance(KhMonitoringDataPepsCsvFile.class);

                khMonitoringDataPepsCsvFile.setIfcSyono(editCommonMonitoringdataBean.getSyono());
                khMonitoringDataPepsCsvFile.setIfcOkyksmno(editCommonMonitoringdataBean.getOkyksmno());
                khMonitoringDataPepsCsvFile.setIfcKyknmknhan(editCommonMonitoringdataBean.getKyknmkn());
                khMonitoringDataPepsCsvFile.setIfcKyknmkj(editCommonMonitoringdataBean.getKyknmkj());
                khMonitoringDataPepsCsvFile.setIfcKykseiymd(editCommonMonitoringdataBean.getSeiymd().toString());
                khMonitoringDataPepsCsvFile.setIfcCommonkihontikucd(editCommonMonitoringdataBean.getKihontikucd());
                khMonitoringDataPepsCsvFile.setIfcKykymdstr(editCommonMonitoringdataBean.getKykymd().toString());
                khMonitoringDataPepsCsvFile.setIfcLastzugkymd(editCommonMonitoringdataBean.getZougakukeii().toString());
                khMonitoringDataPepsCsvFile.setIfcZuruigk(editCommonMonitoringdataBean.getZougakukingaku().toString());
                khMonitoringDataPepsCsvFile.setIfcLastmeighnksyoriymd(editCommonMonitoringdataBean.
                    getMeighnkkeii().toString());
                khMonitoringDataPepsCsvFile.setIfcHrkkeirokbn(editCommonMonitoringdataBean.getHrkkeirokbn());
                khMonitoringDataPepsCsvFile.setIfcSyuunoukeirokbn(editCommonMonitoringdataBean.getSyuunoukeirokbn());
                khMonitoringDataPepsCsvFile.setIfcKykkzdoukbn(editCommonMonitoringdataBean.getKzkykdoukbn().getValue());
                khMonitoringDataPepsCsvFile.setIfcAtukaisisyacd(editCommonMonitoringdataBean.getAtukaisisyacd());
                khMonitoringDataPepsCsvFile.setIfcAtukaisibucd(editCommonMonitoringdataBean.getAtukaisibucd());
                khMonitoringDataPepsCsvFile.setIfcAtukaikojincd(editCommonMonitoringdataBean.getAtukaikojincd());
                khMonitoringDataPepsCsvFile.setIfcMrkykhyj(editCommonMonitoringdataBean.getMrkykhyj().getValue());
                khMonitoringDataPepsCsvFile.setIfcNaibukykhyj(editCommonMonitoringdataBean.getNaibukykhyj().getValue());
                khMonitoringDataPepsCsvFile.setIfcJikokykhyj(editCommonMonitoringdataBean.getJikokykhyj().getValue());
                khMonitoringDataPepsCsvFile.setIfcHjnkykhyj(editCommonMonitoringdataBean.getHjnkykhyj().getValue());
                khMonitoringDataPepsCsvFile.setIfcSyouhnbunruikbn(editCommonMonitoringdataBean.getSyouhnbunruikbn());
                khMonitoringDataPepsCsvFile.setIfcSyouhnnmkbn(editCommonMonitoringdataBean.getSyouhnnmkbn());
                khMonitoringDataPepsCsvFile.setIfcHouteityotkhknhyj(
                    editCommonMonitoringdataBean.getHouteityotkhknhyj().getValue());
                khMonitoringDataPepsCsvFile.setIfcTyotkhknhyj(editCommonMonitoringdataBean.
                    getTyotkhknhyj().getValue());
                khMonitoringDataPepsCsvFile.setIfcHighcverrorkbn(editCommonMonitoringdataBean.getHighcverrorkbn());
                khMonitoringDataPepsCsvFile.setIfcHighriskflg(editCommonMonitoringdataBean.getHighriskflg().getValue());
                khMonitoringDataPepsCsvFile.setIfcMediumriskflg(C_UmuKbn.NONE.getValue());

                if (C_UmuKbn.ARI.getValue().equals(khMonitoringDataPepsCsvFile.getIfcHouteityotkhknhyj()) ||
                    C_UmuKbn.ARI.getValue().equals(khMonitoringDataPepsCsvFile.getIfcTyotkhknhyj())) {
                    khMonitoringDataPepsCsvFile.setIfcSyouhntokuseigtflg(C_UmuKbn.ARI.getValue());
                }
                else {
                    khMonitoringDataPepsCsvFile.setIfcSyouhntokuseigtflg(C_UmuKbn.NONE.getValue());
                }

                khMonitoringDataPepsCsvFileLst.add(khMonitoringDataPepsCsvFile);

                syoriKensuu++;
            }
        }

        bzRecoveryDatasikibetuBean.initializeBlank();


        BzFileUploadUtil bzFileUploadUtil = SWAKInjector.getInstance(BzFileUploadUtil.class);

        if (khMonitoringDataPepsCsvFileLst.size() == 0) {
            C_ErrorKbn errorKbn = bzFileUploadUtil.exec(
                C_FileSyuruiCdKbn.KH_MONITORINGDATACSVFPEPS,
                khMonitoringDataPepsCsvFileLst,
                true,
                "1");

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                throw new BizAppException(MessageId.EBF0129, "ファイルアップロードユーティリティ");
            }
        }
        else {
            List<List<KhMonitoringDataPepsCsvFile>> khMonitoringDataList = Lists.partition(khMonitoringDataPepsCsvFileLst,
                FILE_SAVE_MAX_LIST_COUNT);

            for (List<KhMonitoringDataPepsCsvFile> list : khMonitoringDataList) {
                fileRenban++;

                C_ErrorKbn errorKbn = bzFileUploadUtil.exec(
                    C_FileSyuruiCdKbn.KH_MONITORINGDATACSVFPEPS,
                    list,
                    true,
                    String.valueOf(fileRenban));

                if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                    throw new BizAppException(MessageId.EBF0129, "ファイルアップロードユーティリティ");
                }
            }
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();

    }
}
