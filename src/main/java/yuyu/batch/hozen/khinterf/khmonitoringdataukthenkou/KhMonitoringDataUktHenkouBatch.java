package yuyu.batch.hozen.khinterf.khmonitoringdataukthenkou;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
import jp.co.slcs.swak.util.string.ConvertUtil;
import jp.co.slcs.swak.util.string.IDataConvert;
import yuyu.batch.hozen.khinterf.khmonitoringdataukthenkou.dba.KhMonitoringDataUktHenkouDao;
import yuyu.batch.hozen.khinterf.khmonitoringdataukthenkou.dba.MonitoringDataUktHenkouInfoBean;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzfiledl.BzFileUploadUtil;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.hozen.khcommon.EditCommonMonitoringdata;
import yuyu.common.hozen.khcommon.EditCommonMonitoringdataBean;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykUkt;
import yuyu.def.hozen.file.csv.KhMonitoringDataUkthenkouCsvFile;
import yuyu.def.hozen.file.csv.KhUkthenkouKensuuDataCsvFile;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.collect.Lists;

/**
 * 契約保全 インターフェイス 契約保全モニタリングデータ抽出（受取人変更）クラス
 */
public class KhMonitoringDataUktHenkouBatch implements Batch {

    private static final String TYSYTTAISYOUTABLEID = IT_KykKihon.TABLE_NAME;

    private static final String RECOVERYFILTERIDKBNID = "Kh001";

    private final int FILE_SAVE_MAX_LIST_COUNT = 2000;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private KhMonitoringDataUktHenkouDao khMonitoringDataUktHenkouDao;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();
        String ibKakutyoujobcd = bzBatchParam.getIbKakutyoujobcd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018),
            ibKakutyoujobcd));

        BizDate taisyoukknfrom = null;
        BizDate taisyoukknto = null;

        if (syoriYmd.getMonth() == 4 || syoriYmd.getMonth() == 5) {
            taisyoukknfrom = BizDate.valueOf(syoriYmd.getYear() - 1, 4, 1);
            taisyoukknto = BizDate.valueOf(syoriYmd.getYear(), 3, 31);
        }
        else if (syoriYmd.getMonth() == 10 || syoriYmd.getMonth() == 11){
            taisyoukknfrom = BizDate.valueOf(syoriYmd.getYear(), 4, 1);
            taisyoukknto = BizDate.valueOf(syoriYmd.getYear(), 9, 30);
        }

        long hozenMonitoringDataCsvfKensuu = 0;

        int fileRenban = 0;

        List<KhMonitoringDataUkthenkouCsvFile> khMonitoringDataUkthenkouCsvFileLst = new ArrayList<>();
        EditCommonMonitoringdata editCommonMonitoringdata = SWAKInjector.getInstance(EditCommonMonitoringdata.class);

        try (ExDBResults<MonitoringDataUktHenkouInfoBean> monitoringDataUktHenkouInfoLst =
            khMonitoringDataUktHenkouDao.getMonitoringDataUktHenkouInfos(ibKakutyoujobcd, taisyoukknfrom, taisyoukknto);){

            for (MonitoringDataUktHenkouInfoBean monitoringDataUktHenkouInfosBean : monitoringDataUktHenkouInfoLst) {

                IT_KykKihon kykKihon = monitoringDataUktHenkouInfosBean.getKykKihon();

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(ibKakutyoujobcd);
                bzRecoveryDatasikibetuBean.setIbTableid(TYSYTTAISYOUTABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERYFILTERIDKBNID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(kykKihon.getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(kykKihon.getSyono());

                List<IT_KykUkt> nkUktLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.NKUKT);

                List<IT_KykUkt> sbUktLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

                EditCommonMonitoringdataBean editCommonMonitoringdataBean =
                    editCommonMonitoringdata.exec(kykKihon, taisyoukknto.getBizDateYM());

                KhMonitoringDataUkthenkouCsvFile khMonitoringDataUkthenkouCsvFile =
                    SWAKInjector.getInstance(KhMonitoringDataUkthenkouCsvFile.class);

                khMonitoringDataUkthenkouCsvFile.setIfcSyono(editCommonMonitoringdataBean.getSyono());
                khMonitoringDataUkthenkouCsvFile.setIfcOkyksmno(editCommonMonitoringdataBean.getOkyksmno());
                khMonitoringDataUkthenkouCsvFile.setIfcKyknmknhan(editCommonMonitoringdataBean.getKyknmkn());
                khMonitoringDataUkthenkouCsvFile.setIfcKyknmkj(editCommonMonitoringdataBean.getKyknmkj());
                khMonitoringDataUkthenkouCsvFile.setIfcKykseiymd(editCommonMonitoringdataBean.getSeiymd().toString());
                khMonitoringDataUkthenkouCsvFile.setIfcCommonkihontikucd(editCommonMonitoringdataBean.getKihontikucd());
                khMonitoringDataUkthenkouCsvFile.setIfcKykymdstr(editCommonMonitoringdataBean.getKykymd().toString());
                khMonitoringDataUkthenkouCsvFile.setIfcLastzugkymd(editCommonMonitoringdataBean.getZougakukeii().toString());
                khMonitoringDataUkthenkouCsvFile.setIfcZuruigk(editCommonMonitoringdataBean.getZougakukingaku().toAdsoluteString());
                khMonitoringDataUkthenkouCsvFile.setIfcLastmeighnksyoriymd(editCommonMonitoringdataBean.getMeighnkkeii().toString());
                khMonitoringDataUkthenkouCsvFile.setIfcHrkkeirokbn(editCommonMonitoringdataBean.getHrkkeirokbn());
                khMonitoringDataUkthenkouCsvFile.setIfcSyuunoukeirokbn(editCommonMonitoringdataBean.getSyuunoukeirokbn());
                khMonitoringDataUkthenkouCsvFile.setIfcKykkzdoukbn(editCommonMonitoringdataBean.getKzkykdoukbn().getValue());
                khMonitoringDataUkthenkouCsvFile.setIfcAtukaisisyacd(editCommonMonitoringdataBean.getAtukaisisyacd());
                khMonitoringDataUkthenkouCsvFile.setIfcAtukaisibucd(editCommonMonitoringdataBean.getAtukaisibucd());
                khMonitoringDataUkthenkouCsvFile.setIfcAtukaikojincd(editCommonMonitoringdataBean.getAtukaikojincd());
                khMonitoringDataUkthenkouCsvFile.setIfcMrkykhyj(editCommonMonitoringdataBean.getMrkykhyj().toString());
                khMonitoringDataUkthenkouCsvFile.setIfcNaibukykhyj(editCommonMonitoringdataBean.getNaibukykhyj().toString());
                khMonitoringDataUkthenkouCsvFile.setIfcJikokykhyj(editCommonMonitoringdataBean.getJikokykhyj().toString());
                khMonitoringDataUkthenkouCsvFile.setIfcHjnkykhyj(editCommonMonitoringdataBean.getHjnkykhyj().toString());
                khMonitoringDataUkthenkouCsvFile.setIfcSyouhnbunruikbn(editCommonMonitoringdataBean.getSyouhnbunruikbn());
                khMonitoringDataUkthenkouCsvFile.setIfcSyouhnnmkbn(editCommonMonitoringdataBean.getSyouhnnmkbn());
                khMonitoringDataUkthenkouCsvFile.setIfcHouteityotkhknhyj(editCommonMonitoringdataBean.getHouteityotkhknhyj().toString());
                khMonitoringDataUkthenkouCsvFile.setIfcTyotkhknhyj(editCommonMonitoringdataBean.getTyotkhknhyj().toString());
                khMonitoringDataUkthenkouCsvFile.setIfcHighcverrorkbn(editCommonMonitoringdataBean.getHighcverrorkbn());
                khMonitoringDataUkthenkouCsvFile.setIfcBfnkuktnin("0");
                khMonitoringDataUkthenkouCsvFile.setIfcBfnkuktnmknhan("");
                khMonitoringDataUkthenkouCsvFile.setIfcBfnkuktnmkj("");
                khMonitoringDataUkthenkouCsvFile.setIfcNewnkuktnin(String.valueOf(nkUktLst.size()));
                if (nkUktLst.size() > 0) {
                    if (C_UktKbn.KYK.eq(nkUktLst.get(0).getUktkbn())) {
                        khMonitoringDataUkthenkouCsvFile.setIfcNewnkuktnmknhan(ConvertUtil.convZenHan(
                            IDataConvert.iCONVERT_Z2H_ALL,
                            kykKihon.getKykSya().getKyknmkn()));
                        khMonitoringDataUkthenkouCsvFile.setIfcNewnkuktnmkj(kykKihon.getKykSya().getKyknmkj());
                    }
                    else if (C_UktKbn.HHKN.eq(nkUktLst.get(0).getUktkbn())) {
                        khMonitoringDataUkthenkouCsvFile.setIfcNewnkuktnmknhan(ConvertUtil.convZenHan(
                            IDataConvert.iCONVERT_Z2H_ALL,
                            kykKihon.getHhknSya().getHhknnmkn()));
                        khMonitoringDataUkthenkouCsvFile.setIfcNewnkuktnmkj(kykKihon.getHhknSya().getHhknnmkj());
                    }
                    else {
                        khMonitoringDataUkthenkouCsvFile.setIfcNewnkuktnmknhan("");
                        khMonitoringDataUkthenkouCsvFile.setIfcNewnkuktnmkj("");
                    }
                }
                else {
                    khMonitoringDataUkthenkouCsvFile.setIfcNewnkuktnmknhan("");
                    khMonitoringDataUkthenkouCsvFile.setIfcNewnkuktnmkj("");
                }

                khMonitoringDataUkthenkouCsvFile.setIfcBfsbuktnin("0");

                for (int index = 0; index < 4; index++) {
                    try {
                        methodNmEditAndExec(
                            KhMonitoringDataUkthenkouCsvFile.class,
                            khMonitoringDataUkthenkouCsvFile,
                            "setIfcBfsbuktnmkn",
                            index + 1, "", "han");
                        methodNmEditAndExec(
                            KhMonitoringDataUkthenkouCsvFile.class,
                            khMonitoringDataUkthenkouCsvFile,
                            "setIfcBfsbuktnmkj",
                            index + 1, "", "");

                    } catch (IllegalAccessException
                        | NoSuchMethodException
                        | InvocationTargetException e) {
                        throw new CommonBizAppException();
                    }
                }

                khMonitoringDataUkthenkouCsvFile.setIfcNewsbuktnin(String.valueOf(kykKihon.getSbuktnin()));

                String[] newsbuktnmknHans = {"", "", "", ""};
                String[] newsbuktnmkjs = {"", "", "", ""};

                for (int index = 0; index < sbUktLst.size(); index++) {

                    if (C_UktKbn.KYK.eq(sbUktLst.get(index).getUktkbn())) {
                        newsbuktnmknHans[index] = ConvertUtil.convZenHan(
                            IDataConvert.iCONVERT_Z2H_ALL, kykKihon.getKykSya().getKyknmkn());
                        newsbuktnmkjs[index] = kykKihon.getKykSya().getKyknmkj();
                    }
                    else if (C_UktKbn.HHKN.eq(sbUktLst.get(index).getUktkbn())) {
                        newsbuktnmknHans[index] = ConvertUtil.convZenHan(
                            IDataConvert.iCONVERT_Z2H_ALL, kykKihon.getHhknSya().getHhknnmkn());
                        newsbuktnmkjs[index] = kykKihon.getHhknSya().getHhknnmkj();
                    }
                    else if (C_UktKbn.TOKUTEIMEIGI.eq(sbUktLst.get(index).getUktkbn())) {
                        newsbuktnmknHans[index] = ConvertUtil.convZenHan(
                            IDataConvert.iCONVERT_Z2H_ALL, sbUktLst.get(index).getUktnmkn());
                        newsbuktnmkjs[index] = sbUktLst.get(index).getUktnmkj();
                    }
                    else if (C_UktKbn.SOUZOKUNIN.eq(sbUktLst.get(index).getUktkbn())) {
                        newsbuktnmknHans[index] = "";
                        newsbuktnmkjs[index] = C_UktKbn.SOUZOKUNIN.getContent();
                    }
                    else {
                        newsbuktnmknHans[index] = "";
                        newsbuktnmkjs[index] = "";
                    }
                }

                for (int index = 0; index < 4; index++) {
                    try {
                        methodNmEditAndExec(
                            KhMonitoringDataUkthenkouCsvFile.class,
                            khMonitoringDataUkthenkouCsvFile,
                            "setIfcNewsbuktnmkn",
                            index + 1, newsbuktnmknHans[index], "han");

                        methodNmEditAndExec(
                            KhMonitoringDataUkthenkouCsvFile.class,
                            khMonitoringDataUkthenkouCsvFile,
                            "setIfcNewsbuktnmkj",
                            index + 1, newsbuktnmkjs[index], "");

                    } catch (IllegalAccessException
                        | NoSuchMethodException
                        | InvocationTargetException e) {
                        throw new CommonBizAppException();
                    }
                }

                khMonitoringDataUkthenkouCsvFile.setIfcUkthenymd(monitoringDataUktHenkouInfosBean.getSyoriYmd().toString());

                khMonitoringDataUkthenkouCsvFileLst.add(khMonitoringDataUkthenkouCsvFile);

                hozenMonitoringDataCsvfKensuu++;
            }
        }

        bzRecoveryDatasikibetuBean.initializeBlank();

        BzFileUploadUtil bzFileUploadUtil = SWAKInjector.getInstance(BzFileUploadUtil.class);

        if (khMonitoringDataUkthenkouCsvFileLst.size() == 0) {
            C_ErrorKbn errorKbn = bzFileUploadUtil.exec(C_FileSyuruiCdKbn.KH_MONITORINGDATACSVFUKTHENKOU,
                khMonitoringDataUkthenkouCsvFileLst,
                true,
                "1");

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                throw new BizAppException(MessageId.EBF0129, "ファイルアップロードユーティリティ");
            }
        }
        else {
            List<List<KhMonitoringDataUkthenkouCsvFile>> bunkatuList =
                Lists.partition(khMonitoringDataUkthenkouCsvFileLst, FILE_SAVE_MAX_LIST_COUNT);

            for(List<KhMonitoringDataUkthenkouCsvFile> list : bunkatuList) {

                fileRenban = fileRenban + 1;

                C_ErrorKbn errorKbn = bzFileUploadUtil.exec(C_FileSyuruiCdKbn.KH_MONITORINGDATACSVFUKTHENKOU, list,
                    true, String.valueOf(fileRenban));
                if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                    throw new BizAppException(MessageId.EBF0129, "ファイルアップロードユーティリティ");
                }
            }
        }

        List<KhUkthenkouKensuuDataCsvFile> khUkthenkouKensuuDataCsvFileLst = new ArrayList<>();

        KhUkthenkouKensuuDataCsvFile  KhUkthenkouKensuuDataCsvFile  =
            SWAKInjector.getInstance(KhUkthenkouKensuuDataCsvFile.class);
        KhUkthenkouKensuuDataCsvFile.setIfcKensuu(String.valueOf(hozenMonitoringDataCsvfKensuu));

        khUkthenkouKensuuDataCsvFileLst.add(KhUkthenkouKensuuDataCsvFile);
        C_ErrorKbn errorKbn = bzFileUploadUtil.exec(C_FileSyuruiCdKbn.KH_UKTHENKOUKENSUUDATACSVF,
            khUkthenkouKensuuDataCsvFileLst,
            true);

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {
            throw new BizAppException(MessageId.EBF0129, "ファイルアップロードユーティリティ");
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001,String.valueOf(hozenMonitoringDataCsvfKensuu)));
    }

    private void methodNmEditAndExec (
        Class<KhMonitoringDataUkthenkouCsvFile> pClass,
        KhMonitoringDataUkthenkouCsvFile pGaikaKokyakuTuutiTy,
        String pMethodNm,
        int pMethodNo,
        Object pValue,
        String pMethodEndNm) throws
        IllegalAccessException,
        NoSuchMethodException,
        InvocationTargetException {

        Method setMethod =
            pClass.getMethod(pMethodNm +
                String.valueOf(pMethodNo) + pMethodEndNm, pValue.getClass());
        setMethod.invoke(pGaikaKokyakuTuutiTy, pValue);
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }

}
