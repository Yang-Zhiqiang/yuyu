package yuyu.batch.hozen.khinterf.khmonitoringdatasoukikaiyaku;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateMD;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.util.string.ConvertUtil;
import yuyu.batch.hozen.khinterf.khmonitoringdatasoukikaiyaku.dba.KhMonitoringDataSoukiKaiyakuDao;
import yuyu.batch.hozen.khinterf.khmonitoringdatasoukikaiyaku.dba.KyMonitoringDataSoukiKaiyakuBean;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzfiledl.BzFileUploadUtil;
import yuyu.common.hozen.khcommon.EditCommonMonitoringdata;
import yuyu.common.hozen.khcommon.EditCommonMonitoringdataBean;
import yuyu.def.MessageId;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.IT_KhShrRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.hozen.file.csv.KhMonitoringDataSoukiKaiyakuCsvFile;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.collect.Lists;

/**
 * 契約保全 インターフェイス 契約保全モニタリングデータ抽出（早期解約）クラスです。<br />
 */
public class KhMonitoringDataSoukiKaiyakuBatch implements Batch {

    private static final String TYSYTTAISYOU_TABLE_ID = IT_KykKihon.TABLE_NAME;

    private static final String RECOVERY_FILTER_KBNID = "Kh001";

    private static final int SYORIM_4M = 4;

    private static final int SYORIM_5M = 5;

    private static final int SYORIM_10M = 10;

    private static final int SYORIM_11M = 11;

    private static final BizDateMD TAISYOUKKNMD_3M31D = BizDateMD.valueOf("0331");

    private static final BizDateMD TAISYOUKKNMD_4M1D = BizDateMD.valueOf("0401");

    private static final BizDateMD TAISYOUKKNMD_9M30D = BizDateMD.valueOf("0930");

    private static final BizCurrency YENSHRGKGOUKEI_KIJYUN = BizCurrency.valueOf(50000000, BizCurrencyTypes.YEN);

    private final int FILE_SAVE_MAX_LIST_COUNT = 3000;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private KhMonitoringDataSoukiKaiyakuDao khMonitoringDataSoukiKaiyakuDao;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private BaseDomManager baseDomManager;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        String kakutyoujobCd = bzBatchParam.getIbKakutyoujobcd();

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IBW0003), String.valueOf(syoriYmd)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IBW1018), String.valueOf(kakutyoujobCd)));

        BizDateY syoriY = syoriYmd.getBizDateY();
        int syoriM = syoriYmd.getMonth();

        BizDate taisyoukknFrom = null;

        BizDate taisyoukknTo = null;

        if (syoriM == SYORIM_4M || syoriM == SYORIM_5M){

            taisyoukknFrom = BizDate.valueOf(syoriY.getPreviousYear(), TAISYOUKKNMD_4M1D);

            taisyoukknTo = BizDate.valueOf(syoriY, TAISYOUKKNMD_3M31D);
        }
        else if (syoriM == SYORIM_10M || syoriM == SYORIM_11M) {

            taisyoukknFrom = BizDate.valueOf(syoriY, TAISYOUKKNMD_4M1D);

            taisyoukknTo = BizDate.valueOf(syoriY, TAISYOUKKNMD_9M30D);
        }

        List<KhMonitoringDataSoukiKaiyakuCsvFile> khMonitoringDataSoukiKaiyakuCsvFileLst = Lists.newArrayList();

        int khMonitoringDataSoukiKaiyakuOutkensuu = 0;

        int fileRenno = 0;

        try (

            ExDBResults<KyMonitoringDataSoukiKaiyakuBean> kyMonitoringDataSoukiKaiyakuBeanLst =
            khMonitoringDataSoukiKaiyakuDao.getKhMonitoringDataSoukiKaiyakuBean(kakutyoujobCd, taisyoukknFrom, taisyoukknTo);) {

            for (KyMonitoringDataSoukiKaiyakuBean kyMonitoringDataSoukiKaiyakuBean : kyMonitoringDataSoukiKaiyakuBeanLst) {

                IT_KykKihon kykKihon = kyMonitoringDataSoukiKaiyakuBean.getKykKihon();
                IT_KykSyouhn kykSyouhn = kyMonitoringDataSoukiKaiyakuBean.getKykSyouhn();
                IT_KhShrRireki khShrRireki = kyMonitoringDataSoukiKaiyakuBean.getKhShrRireki();

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyoujobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(TYSYTTAISYOU_TABLE_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERY_FILTER_KBNID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(kykKihon.getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(kykKihon.getSyono());

                BizDate kykymd = kykSyouhn.getKykymd();

                BizDate hanteiYmd = kykymd.getNextYear().getRekijyou();

                if ((BizDateUtil.compareYmd(kykSyouhn.getSyoumetuymd(), hanteiYmd) == BizDateUtil.COMPARE_LESSER ||
                    BizDateUtil.compareYmd(kykSyouhn.getSyoumetuymd(), hanteiYmd) == BizDateUtil.COMPARE_EQUAL) ) {

                    if (khShrRireki.getYenshrgkgoukei().compareTo(YENSHRGKGOUKEI_KIJYUN) > 0) {

                        EditCommonMonitoringdata editCommonMonitoringdata = SWAKInjector.getInstance(EditCommonMonitoringdata.class);

                        EditCommonMonitoringdataBean editCommonMonitoringdataBean =
                            editCommonMonitoringdata.exec(kykKihon, taisyoukknTo.getBizDateYM());

                        String kzmeiginmknHan = "";

                        if (!BizUtil.isBlank(khShrRireki.getKzmeiginmkn())) {

                            kzmeiginmknHan =  ConvertUtil.toHanAll(khShrRireki.getKzmeiginmkn(), 0, 1);
                        }

                        AS_Kinou kinou = baseDomManager.getKinou(khShrRireki.getGyoumuKousinKinou());

                        String syoricd = kinou.getSyoricd();

                        KhMonitoringDataSoukiKaiyakuCsvFile khMonitoringDataSoukiKaiyakuCsvFile = SWAKInjector
                            .getInstance(KhMonitoringDataSoukiKaiyakuCsvFile.class);

                        khMonitoringDataSoukiKaiyakuCsvFile.setIfcSyono(editCommonMonitoringdataBean.getSyono());
                        khMonitoringDataSoukiKaiyakuCsvFile.setIfcOkyksmno(editCommonMonitoringdataBean.getOkyksmno());
                        khMonitoringDataSoukiKaiyakuCsvFile.setIfcKyknmknhan(editCommonMonitoringdataBean.getKyknmkn());
                        khMonitoringDataSoukiKaiyakuCsvFile.setIfcKyknmkj(editCommonMonitoringdataBean.getKyknmkj());
                        khMonitoringDataSoukiKaiyakuCsvFile.setIfcKykseiymd(editCommonMonitoringdataBean.getSeiymd().toString());
                        khMonitoringDataSoukiKaiyakuCsvFile.setIfcCommonkihontikucd(editCommonMonitoringdataBean.getKihontikucd());
                        khMonitoringDataSoukiKaiyakuCsvFile.setIfcKykymdstr(editCommonMonitoringdataBean.getKykymd().toString());
                        khMonitoringDataSoukiKaiyakuCsvFile.setIfcLastzugkymd(editCommonMonitoringdataBean.getZougakukeii().toString());
                        khMonitoringDataSoukiKaiyakuCsvFile.setIfcZuruigk(editCommonMonitoringdataBean.getZougakukingaku().toAdsoluteString());
                        khMonitoringDataSoukiKaiyakuCsvFile.setIfcLastmeighnksyoriymd(editCommonMonitoringdataBean.getMeighnkkeii().toString());
                        khMonitoringDataSoukiKaiyakuCsvFile.setIfcHrkkeirokbn(editCommonMonitoringdataBean.getHrkkeirokbn());
                        khMonitoringDataSoukiKaiyakuCsvFile.setIfcSyuunoukeirokbn(editCommonMonitoringdataBean.getSyuunoukeirokbn());
                        khMonitoringDataSoukiKaiyakuCsvFile.setIfcKykkzdoukbn(editCommonMonitoringdataBean.getKzkykdoukbn().getValue());
                        khMonitoringDataSoukiKaiyakuCsvFile.setIfcAtukaisisyacd(editCommonMonitoringdataBean.getAtukaisisyacd());
                        khMonitoringDataSoukiKaiyakuCsvFile.setIfcAtukaisibucd(editCommonMonitoringdataBean.getAtukaisibucd());
                        khMonitoringDataSoukiKaiyakuCsvFile.setIfcAtukaikojincd(editCommonMonitoringdataBean.getAtukaikojincd());
                        khMonitoringDataSoukiKaiyakuCsvFile.setIfcMrkykhyj(editCommonMonitoringdataBean.getMrkykhyj().getValue());
                        khMonitoringDataSoukiKaiyakuCsvFile.setIfcNaibukykhyj(editCommonMonitoringdataBean.getNaibukykhyj().getValue());
                        khMonitoringDataSoukiKaiyakuCsvFile.setIfcJikokykhyj(editCommonMonitoringdataBean.getJikokykhyj().getValue());
                        khMonitoringDataSoukiKaiyakuCsvFile.setIfcHjnkykhyj(editCommonMonitoringdataBean.getHjnkykhyj().getValue());
                        khMonitoringDataSoukiKaiyakuCsvFile.setIfcSyouhnbunruikbn(editCommonMonitoringdataBean.getSyouhnbunruikbn());
                        khMonitoringDataSoukiKaiyakuCsvFile.setIfcSyouhnnmkbn(editCommonMonitoringdataBean.getSyouhnnmkbn());
                        khMonitoringDataSoukiKaiyakuCsvFile.setIfcHouteityotkhknhyj(editCommonMonitoringdataBean.getHouteityotkhknhyj().getValue());
                        khMonitoringDataSoukiKaiyakuCsvFile.setIfcTyotkhknhyj(editCommonMonitoringdataBean.getTyotkhknhyj().getValue());
                        khMonitoringDataSoukiKaiyakuCsvFile.setIfcHighcverrorkbn(editCommonMonitoringdataBean.getHighcverrorkbn());
                        khMonitoringDataSoukiKaiyakuCsvFile.setIfcKaiykymd(khShrRireki.getShrsyoriymd().toString());
                        khMonitoringDataSoukiKaiyakuCsvFile.setIfcKaiyakuhrkngak(khShrRireki.getYenshrgkgoukei().toAdsoluteString());
                        khMonitoringDataSoukiKaiyakuCsvFile.setIfcCommonsyoricd(syoricd);
                        khMonitoringDataSoukiKaiyakuCsvFile.setIfcShrhousiteikbn(khShrRireki.getShrhousiteikbn().getValue());
                        khMonitoringDataSoukiKaiyakuCsvFile.setIfcBankcd(khShrRireki.getBankcd());
                        khMonitoringDataSoukiKaiyakuCsvFile.setIfcSitencd(khShrRireki.getSitencd());
                        khMonitoringDataSoukiKaiyakuCsvFile.setIfcYokinkbn(khShrRireki.getYokinkbn());
                        khMonitoringDataSoukiKaiyakuCsvFile.setIfcShrsakikz(khShrRireki.getKouzano());
                        khMonitoringDataSoukiKaiyakuCsvFile.setIfcKzmeiginmknhan(kzmeiginmknHan);

                        khMonitoringDataSoukiKaiyakuCsvFileLst.add(khMonitoringDataSoukiKaiyakuCsvFile);

                        khMonitoringDataSoukiKaiyakuOutkensuu = khMonitoringDataSoukiKaiyakuOutkensuu + 1;
                    }
                }
            }
            bzRecoveryDatasikibetuBean.initializeBlank();
        }

        BzFileUploadUtil bzFileUploadUtil = SWAKInjector.getInstance(BzFileUploadUtil.class);

        C_ErrorKbn errorKbn = C_ErrorKbn.OK;

        if (khMonitoringDataSoukiKaiyakuCsvFileLst.size() == 0) {

            errorKbn = bzFileUploadUtil.exec(C_FileSyuruiCdKbn.KH_MONITORINGDATACSVFSOUKIKAIYAKU,
                khMonitoringDataSoukiKaiyakuCsvFileLst, true, "1");

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                throw new BizAppException(MessageUtil.getMessage(MessageId.EBF0129,
                    "ファイルアップロードユーティリティ"));
            }
        }
        else {

            fileRenno = 1;

            List<List<KhMonitoringDataSoukiKaiyakuCsvFile>> bunkatuLst =
                Lists.partition(khMonitoringDataSoukiKaiyakuCsvFileLst, FILE_SAVE_MAX_LIST_COUNT);

            for(List<KhMonitoringDataSoukiKaiyakuCsvFile> list:bunkatuLst) {

                errorKbn = bzFileUploadUtil.exec(C_FileSyuruiCdKbn.KH_MONITORINGDATACSVFSOUKIKAIYAKU,
                    list, true, String.valueOf(fileRenno));

                if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                    throw new BizAppException(MessageUtil.getMessage(MessageId.EBF0129,
                        "ファイルアップロードユーティリティ"));
                }

                fileRenno = fileRenno + 1;
            }
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(khMonitoringDataSoukiKaiyakuOutkensuu)));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);
        bzBatchAbendCommonRecovery.exec();
    }
}
